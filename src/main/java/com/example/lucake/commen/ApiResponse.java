package com.example.lucake.commen;

import com.example.lucake.commen.exception.ApiStatusCodeEnum;

public class ApiResponse<R> {

    private String statusCode;

    private String errorMsg;

    private R rsContent;

    public ApiResponse() {
    }

    public ApiResponse(String statusCode, String errorMsg) {
        this.statusCode = statusCode;
        this.errorMsg = errorMsg;
    }

    public ApiResponse(String statusCode, String errorMsg, R rsContent) {
        this.statusCode = statusCode;
        this.errorMsg = errorMsg;
        this.rsContent = rsContent;
    }

    public ApiResponse(ApiStatusCodeEnum statusCodeEnum) {
        this.statusCode = statusCodeEnum.getCode();
    }

    public ApiResponse(ApiStatusCodeEnum statusCodeEnum, String errorMsg) {
        this.statusCode = statusCodeEnum.getCode();
        this.errorMsg = errorMsg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getRsContent() {
        return rsContent;
    }

    public void setRsContent(R rsContent) {
        this.rsContent = rsContent;
    }
}
