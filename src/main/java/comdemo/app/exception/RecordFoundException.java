package comdemo.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class RecordFoundException extends Exception {

	private static final long serialVersionUID = 5058139850100402449L;

	public RecordFoundException(String message) {
		super(message);
	}
}
