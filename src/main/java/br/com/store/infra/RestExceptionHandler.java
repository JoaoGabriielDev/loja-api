package br.com.store.infra;

import br.com.store.exceptions.ProdutoNotFoundException;
import br.com.store.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> userNotFoundException(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não foi encontrado!");
    }

    @ExceptionHandler(ProdutoNotFoundException.class)
    private ResponseEntity<String> produtoNotFoundException(ProdutoNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não foi encontrado!");
    }

}
