package com.rasmoo.curriculumgrid.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorResponseDTO {
    private String code;
    private String message;
    private Integer statusCode;
    private List<ErrorDetailsDTO> errorDetails;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
}