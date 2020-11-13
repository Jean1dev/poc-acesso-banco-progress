package com.logistica.integracoes.exceptions;

import java.util.Date;

public class DetailErrorException extends RuntimeException {
    private Date timestamp;
    private String message;
    private String details;

    public DetailErrorException(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
