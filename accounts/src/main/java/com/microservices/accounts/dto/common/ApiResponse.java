package com.microservices.accounts.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.micrometer.common.lang.Nullable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> extends JsonObject {
    private boolean success;
    private @Nullable T data;
    private ErrorDetail error;
    private int statusCode;

    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = true;
        response.data = data;
        response.statusCode = 200;

        return response;
    }

    public static ApiResponse<Void> badRequest(ErrorDetail error) {
        ApiResponse<Void> response = new ApiResponse<>();
        response.error = error;
        response.success = false;
        response.statusCode = 400;

        return response;
    }
}