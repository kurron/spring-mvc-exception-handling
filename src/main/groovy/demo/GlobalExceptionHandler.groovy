package demo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( Throwable )
    ResponseEntity<String> handleErrors( Throwable t ) {
        new ResponseEntity<String>( t.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR )
    }
}
