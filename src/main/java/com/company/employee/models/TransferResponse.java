package com.company.employee.models;

public class TransferResponse {
    private String message;
    private int responseCode;

    public TransferResponse(String message, int responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public TransferResponse() {
    }

    public String getMessage() {
        return message;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
