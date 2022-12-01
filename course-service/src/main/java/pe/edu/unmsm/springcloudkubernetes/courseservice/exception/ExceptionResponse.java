package pe.edu.unmsm.springcloudkubernetes.courseservice.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

import static pe.edu.unmsm.springcloudkubernetes.courseservice.util.Constants.DATE_TIME_FORMAT;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExceptionResponse(@JsonFormat(pattern = DATE_TIME_FORMAT) LocalDateTime timestamp,
                                String path,
                                String error,
                                String message,
                                List<ValidationError> validationErrors) {
    public ExceptionResponse(LocalDateTime timestamp, String path, String error, String message) {
        this(timestamp, path, error, message, null);
    }

    public ExceptionResponse(LocalDateTime timestamp, String path, String error, List<ValidationError> validationErrors) {
        this(timestamp, path, error, null, validationErrors);
    }
}
