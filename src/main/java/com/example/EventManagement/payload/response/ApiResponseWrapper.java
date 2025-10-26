package com.example.EventManagement.payload.response;
public class ApiResponseWrapper<M> {
    private String status;
    private String message;
    private M data;

    public ApiResponseWrapper(String status, String message, M data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;   // ✅ return type is String
    }

    public String getMessage() {
        return message;
    }

    public M getData() {
        return data;
    }
}



