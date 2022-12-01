package pe.edu.unmsm.springcloudkubernetes.courseservice.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
