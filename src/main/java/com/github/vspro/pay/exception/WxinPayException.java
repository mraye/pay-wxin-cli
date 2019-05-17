package com.github.vspro.pay.exception;

public class WxinPayException extends Exception {


    private String code;

    private String message;

    public WxinPayException(String message) {
        super(message);
        this.message = message;
    }

    public WxinPayException(Throwable cause) {
        super(cause);
    }

    public WxinPayException(String code, String message){
        super(code + ": "+ message);
        this.code = code;
        this.message = message;
    }

    public WxinPayException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
