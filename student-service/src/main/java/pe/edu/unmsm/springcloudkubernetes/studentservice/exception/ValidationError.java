package pe.edu.unmsm.springcloudkubernetes.studentservice.exception;

public record ValidationError(String field, String message) {
}
