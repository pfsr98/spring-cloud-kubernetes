package pe.edu.unmsm.springcloudkubernetes.studentservice.student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * A DTO for the {@link Student} entity
 */
public record StudentDto(Long id, @NotBlank String name, @Email @NotBlank String email,
                         @NotBlank String password) {
}