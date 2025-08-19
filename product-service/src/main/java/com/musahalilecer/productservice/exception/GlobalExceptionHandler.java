package com.musahalilecer.productservice.exception;

import com.musahalilecer.productservice.dto.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(HttpServletRequest req, Exception ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleBadRequestException(HttpServletRequest req, Exception ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneric(Exception ex, HttpServletRequest req) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), req.getRequestURI());
    }

    private ResponseEntity<ApiErrorResponse> buildErrorResponse(HttpStatus status, String message, String path) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setTimestamp(LocalDate.now());
        apiErrorResponse.setStatus(status.value());
        apiErrorResponse.setError(status.getReasonPhrase());
        apiErrorResponse.setMessage(message);
        apiErrorResponse.setPath(path);

        return new ResponseEntity<>(apiErrorResponse, status);
    }
}
