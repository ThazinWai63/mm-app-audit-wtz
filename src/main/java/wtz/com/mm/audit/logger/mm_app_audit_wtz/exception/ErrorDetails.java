package wtz.com.mm.audit.logger.mm_app_audit_wtz.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
	
	//timestamp
	//errormessage
	//error details
	
	private LocalDateTime timepstamp;
	private String message;
	private String details;
	public ErrorDetails(LocalDateTime timepstamp, String message, String details) {
		super();
		this.timepstamp = timepstamp;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getTimepstamp() {
		return timepstamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}

}
