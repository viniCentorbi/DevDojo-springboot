package academy.devdojo.cursodevdojo.handler;

import academy.devdojo.cursodevdojo.exception.BadRequestException;
import academy.devdojo.cursodevdojo.exception.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre){

        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .title("Bad Request Exception, Check the Documentation")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .details(bre.getMessage())
                        .developerMessage(bre.getClass().getName())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST);


    }
}
