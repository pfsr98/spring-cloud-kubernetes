package pe.edu.unmsm.springcloudkubernetes.studentservice.exception;

public class DuplicateEntityException extends DomainException {
    public DuplicateEntityException(String message) {
        super(message);
    }
}