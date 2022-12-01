package pe.edu.unmsm.springcloudkubernetes.courseservice.exception;

public class EntityNotFoundException extends DomainException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}