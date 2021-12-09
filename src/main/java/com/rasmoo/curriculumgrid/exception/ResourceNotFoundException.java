package com.rasmoo.curriculumgrid.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends BusinessException{
    public ResourceNotFoundException(String codeMessage, Object...args) {
        super(codeMessage, args);
    }
}