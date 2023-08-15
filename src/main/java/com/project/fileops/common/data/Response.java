package com.project.fileops.common.data;

/**
 * created on: 08 12 2023
 * 10:25 am
 */

public class Response {
    private int statusCode;
    private String payload;

    public Response(int statusCode, String payload) {
        this.statusCode = statusCode;
        this.payload = payload;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
