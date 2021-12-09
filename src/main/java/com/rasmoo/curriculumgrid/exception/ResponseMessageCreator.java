package com.rasmoo.curriculumgrid.exception;

import com.rasmoo.curriculumgrid.dto.ErrorResponseDTO;
import com.rasmoo.curriculumgrid.dto.ErrorResponseDTO.ErrorResponseDTOBuilder;
import com.rasmoo.curriculumgrid.dto.ValidationErrorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ResponseMessageCreator{
    private final MessageSource messageSource;

    public ResponseEntity<Object> error(final String codeMessage, final HttpStatus httpStatus) {
        final String message = messageSource.getMessage(codeMessage, null, LocaleContextHolder.getLocale());
        final List<ErrorResponseDTO> errors = List.of(buildErrorResponse(codeMessage, message, httpStatus));
        return ResponseEntity.status(httpStatus).body(errors);
    }

    public ErrorResponseDTO getErrors(final BindingResult bindingResult) {
        final List<ValidationErrorDTO> errors = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(f -> errors.add(new ValidationErrorDTO(f.getField(), f.getDefaultMessage())));
        return ErrorResponseDTO.builder().validationErrors(errors).build();
    }

    private ErrorResponseDTO buildErrorResponse(final String codeMessage, final String message, final HttpStatus httpStatus) {
        ErrorResponseDTOBuilder error = ErrorResponseDTO.builder();
        error.code(codeMessage);
        error.message(message);
        error.statusCode(httpStatus.value());
        error.timestamp(LocalDateTime.now());
        return error.build();
    }
}