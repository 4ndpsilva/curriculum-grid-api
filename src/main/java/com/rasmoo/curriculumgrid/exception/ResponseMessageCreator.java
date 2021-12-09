package com.rasmoo.curriculumgrid.exception;

import com.rasmoo.curriculumgrid.dto.ErrorResponseDTO;
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

    public ResponseEntity<List<ErrorResponseDTO>> error(final String codeMessage, final HttpStatus httpStatus) {
        final List<ErrorResponseDTO> errors = List.of(buildErrorResponse(codeMessage, httpStatus));
        return ResponseEntity.status(httpStatus).body(errors);
    }

    public List<ErrorResponseDTO> getErrors(final BindingResult bindingResult) {
        final ErrorResponseDTO error = buildErrorResponse("API-003", HttpStatus.BAD_REQUEST);

        final List<ValidationErrorDTO> errors = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(f -> errors.add(new ValidationErrorDTO(f.getField(), f.getDefaultMessage())));
        error.setValidationErrors(errors);
        return List.of(error);
    }

    private ErrorResponseDTO buildErrorResponse(final String codeMessage, final HttpStatus httpStatus) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setCode(codeMessage);
        error.setMessage(messageSource.getMessage(codeMessage, null, LocaleContextHolder.getLocale()));
        error.setStatusCode(httpStatus.value());
        error.setTimestamp(LocalDateTime.now());
        return error;
    }
}