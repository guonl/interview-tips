package com.guonl.annotation.blog;

/**
 * Created by guonl
 * Description: 异常类
 */
public class NumException extends Exception{

    private String name;

    public NumException(String message) {
        this.name = message;
    }

    public NumException(Throwable cause, String name) {
        super(name, cause);
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
