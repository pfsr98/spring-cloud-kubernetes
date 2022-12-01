package pe.edu.unmsm.springcloudkubernetes.courseservice.course;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public record CourseDto(Long id, @NotBlank String name, Set<Long> userIds) {
}
