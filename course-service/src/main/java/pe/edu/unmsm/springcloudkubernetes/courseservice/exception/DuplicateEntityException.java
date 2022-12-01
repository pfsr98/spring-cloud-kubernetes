package pe.edu.unmsm.springcloudkubernetes.courseservice.exception;

public class DuplicateEntityException extends DomainException {
    public DuplicateEntityException(String message) {
        super(message);
    }
}