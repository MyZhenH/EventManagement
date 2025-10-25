package com.example.EventManagement.payload.response;
public class ApiResponseWrapper<M> {
    private String message;
    private M data;

    public ApiResponseWrapper(String message, M data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public M getData() {
        return data;
    }
}

