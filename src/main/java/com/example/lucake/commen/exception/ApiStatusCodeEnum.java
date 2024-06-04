package com.example.lucake.commen.exception;

public enum ApiStatusCodeEnum {

    SUCCESS("000000", "成功"),
    RESULT_NOT_FOUND("000001", "查無資料"),
    USER_AUTH_FAIL("000002", "身份驗證失敗"),
    INPUT_ERROR("999998", "輸入錯誤"),
    UNKNOWN_ERROR("999999", "Server 錯誤"),
    ;

    private final String code;
    private final String desc;

    ApiStatusCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getCode() {
        return this.code;
    }
}
