package com.rasmoo.curriculumgrid.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public class ErrorResponseDTO {
    private final String code;
    private final String message;
    private final Integer statusCode;
    private final List<ValidationErrorDTO> validationErrors;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private final LocalDateTime timestamp;
}