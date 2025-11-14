package com.example.EventManagement.payload.response;


/**
 * Generic wrapper class for API responses.
 *
 * <p>It contains:</p>
 * <ul>
 *   <li><b>status</b> - Shows the request was SUCCESS or ERROR.</li>
 *   <li><b>message</b> - A  message explaining the result.</li>
 *   <li><b>data</b> - The  payload returned by the API (can be any type M).</li>
 * </ul>
 *
 * <p>This class helps standardize API responses for frontend that can always
 * expect the same structure.</p>
 *
 **/
public class ApiResponseWrapperEvent<M> {
    private String status;
    private String message;
    private M data;

    public ApiResponseWrapperEvent(String status, String message, M data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public M getData() {
        return data;
    }
}


