package wtz.com.mm.audit.logger.mm_app_audit_wtz.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundExcepton extends RuntimeException {
	
	public UserNotFoundExcepton(String message) {
		super(message);
	}

}
