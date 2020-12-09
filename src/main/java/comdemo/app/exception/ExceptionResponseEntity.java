package comdemo.app.exception;

import lombok.Data;

@Data
public class ExceptionResponseEntity {
	private String errorMessage;
	private String errorCode;
	private String fieldName;
	private String errorCateory;
}
