package git.utp.primerproyecto.primerproyecto.web.exceptions;

import git.utp.primerproyecto.primerproyecto.web.exceptions.types.BadRequestException;
import git.utp.primerproyecto.primerproyecto.web.exceptions.types.NotFoundException;
import git.utp.primerproyecto.primerproyecto.web.exceptions.types.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

   /** declaro un metodo final que recibe la informacion del error y la convierte en un objeto
    // que nos devolvera a nosotros directamente */
   @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionResponse> handlerBadRequestException(BadRequestException exception,
                                                                              WebRequest webRequest) {
       ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
               webRequest.getDescription(true), HttpStatus.BAD_REQUEST.getReasonPhrase());
       return new  ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

   }

   @ExceptionHandler(NotFoundException.class)
   public final ResponseEntity<ExceptionResponse> handlerNotFoundException
           (BadRequestException exception,
            WebRequest webRequest) {
      ExceptionResponse exceptionResponse =
              new ExceptionResponse(new Date(), exception.getMessage(),
              webRequest.getDescription(true), HttpStatus.NOT_FOUND.getReasonPhrase());
      return new  ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

   }

   @ExceptionHandler(ValidationException.class)
   public final ResponseEntity<ExceptionResponse> ValidationException
           (BadRequestException exception,
            WebRequest webRequest) {
      ExceptionResponse exceptionResponse =
              new ExceptionResponse(new Date(), exception.getMessage(),
                      webRequest.getDescription(true), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
      return new  ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

   }
}
