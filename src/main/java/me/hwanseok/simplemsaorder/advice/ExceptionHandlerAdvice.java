package me.hwanseok.simplemsaorder.advice;

import me.hwanseok.simplemsaorder.exception.OrderGroupNotFoundException;
import me.hwanseok.simplemsaorder.model.dto.common.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(OrderGroupNotFoundException.class)
    public ResponseEntity<ErrorDto> notFoundException(OrderGroupNotFoundException e){
        return ResponseEntity.badRequest().body(ErrorDto.builder()
                .msg("OrderGroup Not Found")
                .build());
    }
}