package com.CodeDecode_CRUD.demo.Exception;

import org.springframework.stereotype.Component;

@Component
public class NoSuchElements_Exception extends RuntimeException
{
    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public NoSuchElements_Exception(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public NoSuchElements_Exception() {}
}
