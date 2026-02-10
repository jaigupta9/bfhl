package com.chitkara.bfhl.dto;

public class ApiResponse<T> {
    public boolean is_success;
    public String official_email;
    public T data;

    public ApiResponse(boolean is_success, String official_email, T data) {
        this.is_success = is_success;
        this.official_email = official_email;
        this.data = data;
    }
}
