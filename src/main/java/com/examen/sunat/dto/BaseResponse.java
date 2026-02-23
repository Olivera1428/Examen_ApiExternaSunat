package com.examen.sunat.dto;

public class BaseResponse<T> {

    private int status;
    private String message;
    private T data;

    public BaseResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}