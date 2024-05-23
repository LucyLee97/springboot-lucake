package com.example.lucake.commen;

import com.example.lucake.commen.exception.ApiStatusCodeEnum;

public class ApiResponseHandler {
    private ApiResponseHandler() {
    }

    public static <R> ApiResponse<R> success(R rsContent) {
        ApiResponse<R> apiResponse = new ApiResponse<>(ApiStatusCodeEnum.SUCCESS);
        apiResponse.setRsContent(rsContent);
        return apiResponse;
    }
}
