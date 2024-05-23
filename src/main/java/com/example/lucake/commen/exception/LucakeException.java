package com.example.lucake.commen.exception;

public class LucakeException extends RuntimeException{

    private ApiStatusCodeEnum statusCodeEnum;

    private Object detail;

    public LucakeException(ApiStatusCodeEnum statusCodeEnum) {
        super(String.format("(%s)%s", statusCodeEnum.getCode(), statusCodeEnum.getDesc()));
        this.statusCodeEnum = statusCodeEnum;
    }

    public LucakeException(ApiStatusCodeEnum statusCodeEnum, Object detail) {
        this.statusCodeEnum = statusCodeEnum;
        this.detail = detail;
    }

    public LucakeException(String message, ApiStatusCodeEnum statusCodeEnum, Object detail) {
        super(message);
        this.statusCodeEnum = statusCodeEnum;
        this.detail = detail;
    }

    public LucakeException(String message, Throwable cause, ApiStatusCodeEnum statusCodeEnum, Object detail) {
        super(message, cause);
        this.statusCodeEnum = statusCodeEnum;
        this.detail = detail;
    }

    public LucakeException(Throwable cause, ApiStatusCodeEnum statusCodeEnum, Object detail) {
        super(cause);
        this.statusCodeEnum = statusCodeEnum;
        this.detail = detail;
    }

    public ApiStatusCodeEnum getStatusCodeEnum() {
        return statusCodeEnum;
    }

    public Object getDetail() {
        return detail;
    }
}
