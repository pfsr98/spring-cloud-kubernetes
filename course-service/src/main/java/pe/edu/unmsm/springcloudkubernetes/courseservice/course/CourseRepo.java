package pe.edu.unmsm.springcloudkubernetes.courseservice.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
    boolean existsByName(String name);
}
