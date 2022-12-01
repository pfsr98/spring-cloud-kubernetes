package pe.edu.unmsm.springcloudkubernetes.studentservice.exception;

public class EntityNotFoundException extends DomainException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}