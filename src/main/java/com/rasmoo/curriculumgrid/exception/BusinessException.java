package com.rasmoo.curriculumgrid.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private String codeMessage;
    private Object args;

    public BusinessException(final String codeMessage){
        super(codeMessage);
        this.codeMessage = codeMessage;
    }

    public BusinessException(final String codeMessage, final Object...args){
        this(codeMessage);
        this.args = args;
    }
}