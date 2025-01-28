package com.clinicadigital.sys_clinica.utils;

import java.time.LocalDateTime;

public class ErrorResponseCustom {
    private String message;
    private String errorCode;
    private LocalDateTime timeStamp;
    public ErrorResponseCustom(String message,String errorCode) {
        this.message = message;
        this.errorCode=errorCode;
        this.timeStamp=LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
