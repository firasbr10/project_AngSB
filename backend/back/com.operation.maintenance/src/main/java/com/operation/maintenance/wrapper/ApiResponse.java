package com.operation.maintenance.wrapper;



public class ApiResponse<T> {

    private T data;
    private String message;
    private int status;

    // Constructeur pour une réponse avec des données
    public ApiResponse(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    // Constructeur pour une réponse d'erreur
    public static <T> ApiResponse<T> error(String message, int status) {
        return new ApiResponse<>(null, message, status);
    }

    // Getter et Setter
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

