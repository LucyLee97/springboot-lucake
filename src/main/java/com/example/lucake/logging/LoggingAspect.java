package com.example.lucake.logging;

import com.example.lucake.commen.exception.ApiStatusCodeEnum;
import com.example.lucake.commen.exception.LucakeException;
import com.example.lucake.entity.AccessLog;
import com.example.lucake.repository.AccessLogRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AccessLogRepo accessLogRepo;

    @Pointcut("execution(* com.example.lucake.controller..*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object logInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        addLog("RQ", objectMapper.writeValueAsString(joinPoint.getArgs()), null, attributes);

        Object resultObject;
        try {
            resultObject = joinPoint.proceed();
        } catch (LucakeException e) {
            addLog("RS", e.getMessage(), e.getStatusCodeEnum().getCode(), attributes);
            throw e;
        } catch (Exception e) {
            addLog("RS", StringUtils.substring(e.toString(), 0, 500), ApiStatusCodeEnum.UNKNOWN_ERROR.getCode(), attributes);
            throw e;
        }

        addLog("RS", objectMapper.writeValueAsString(resultObject), ApiStatusCodeEnum.SUCCESS.getCode(), attributes);
        return resultObject;
    }

    private void addLog(String direction, String detail, String statusCode, ServletRequestAttributes attributes) {
        HttpServletRequest request = attributes.getRequest();
        AccessLog accessLog = new AccessLog();
        accessLog.setStatusCode(statusCode);
        accessLog.setDetail(detail);
        accessLog.setDirection(direction);
        accessLog.setCustomerId("");
        accessLog.setRequestUri(request.getRequestURI());
        accessLog.setClientIp(request.getRemoteAddr());
        accessLogRepo.save(accessLog);
    }
}
