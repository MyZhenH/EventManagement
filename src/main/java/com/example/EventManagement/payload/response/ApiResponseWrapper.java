package com.example.EventManagement.payload.response;

import java.io.Serializable;

/**
 * Generic wrapper class for API responses.
 *
 * <p>This class standardizes the response format for all API endpoints to ensure the frontend
 * can consistently expect the same structure.</p>
 *
 * <p>The response contains:</p>
 * <ul>
 *   <li><b>status</b> - Indicates whether the request was a SUCCESS or ERROR.</li>
 *   <li><b>message</b> - A descriptive message explaining the result or error.</li>
 *   <li><b>data</b> - The payload returned by the API; can be any type <code>M</code>, or <code>null</code> for errors.</li>
 * </ul>
 *
 * <p>Using a consistent response wrapper simplifies client-side handling and enables easier error management,
 * logging, and future enhancements such as adding metadata or pagination info.</p>
 *
 * <p><b>Note:</b> This class implements <code>Serializable</code> to support potential use cases
 * such as caching or distributed sessions.</p>
 *
 * @param <M> the type of the data payload returned by this response wrapper
 */
public class ApiResponseWrapper<M> implements Serializable {
    private final String status;
    private final String message;
    private final M data;

    public ApiResponseWrapper(String status, String message, M data) {
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

    public static <M> ApiResponseWrapper<M> success(M data, String message) {
        return new ApiResponseWrapper<>("success", message, data);
    }

    public static <M> ApiResponseWrapper<M> error(String message) {
        return new ApiResponseWrapper<>("error", message, null);
    }
}
