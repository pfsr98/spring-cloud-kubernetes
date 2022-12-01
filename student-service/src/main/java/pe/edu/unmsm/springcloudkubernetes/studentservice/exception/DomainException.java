package pe.edu.unmsm.springcloudkubernetes.studentservice.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
