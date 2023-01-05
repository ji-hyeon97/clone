package eatda.clone.exception;

import eatda.clone.dto.ExceptionDTO;
import eatda.clone.dto.ResponseDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseDTO<ExceptionDTO> eatDaException(EatDaException e){
        return new ResponseDTO<>(e.getHttpStatus().value(), new ExceptionDTO(e.getMessage()));
    }
}
