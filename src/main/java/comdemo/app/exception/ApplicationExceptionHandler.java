package comdemo.app.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<ExceptionResponseEntity> handleExceptionInternal(WebRequest request, Exception e) {
		ExceptionResponseEntity responseEntity = new ExceptionResponseEntity();
		responseEntity.setErrorCode("A501");
		responseEntity.setErrorMessage(e.getMessage());
		responseEntity.setErrorCateory("500");
		return new ResponseEntity(responseEntity, HttpStatus.BAD_REQUEST);
	}
	
	

}
