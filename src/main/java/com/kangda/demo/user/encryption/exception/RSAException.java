package com.kangda.demo.user.encryption.exception;


import com.kangda.demo.user.encryption.entity.enums.ErrorResultEnum;

public class RSAException extends RuntimeException {

    private String code;

    public RSAException(String code, String message) {
        super(message);
        this.code = code;
    }

    public RSAException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public RSAException(String message) {
        super(message);
        this.code = ErrorResultEnum.INTERNAL_SERVER_ERROR.getErrorCode();
    }

    public RSAException(String message, Exception e) {
        super(message + e.getMessage());
        this.code = ErrorResultEnum.INTERNAL_SERVER_ERROR.getErrorCode();
    }

    public String getCode() {
        return this.code;
    }
}
