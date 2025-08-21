package local.mso.app_rest.exception;

import java.util.Date;

public record ExceptionResponse(Date timeStamps, String message, String details) {
}
