package pe.edu.unmsm.springcloudkubernetes.studentservice.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);

    @Query("select s from Student s where s.email = ?1")
    Optional<Student> findByEmailQuery(String email);

    boolean existsByEmail(String email);
}
