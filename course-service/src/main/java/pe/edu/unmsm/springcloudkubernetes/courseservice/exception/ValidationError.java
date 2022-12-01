package pe.edu.unmsm.springcloudkubernetes.courseservice.exception;

public record ValidationError(String field, String message) {
}
