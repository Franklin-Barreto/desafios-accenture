package br.com.thundercoders.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.thundercoders.exceptions.DashBoardNotFoundException;

@RestControllerAdvice
public class ErrorHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handlerGenerico(Exception ex) {
	    ex.printStackTrace();
	    System.out.println("Teste"+ex.getStackTrace());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorre um erro no servidor");
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(DashBoardNotFoundException.class)
	public ResponseEntity<Object>handlerDashBoardException(DashBoardNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
}
