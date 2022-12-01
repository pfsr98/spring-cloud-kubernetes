package pe.edu.unmsm.springcloudkubernetes.courseservice.course;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@Builder(toBuilder = true)
public class Course {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @Column(name = "user_ids", nullable = false)
    @CollectionTable(name = "course_users", joinColumns = @JoinColumn(name = "course_id"))
    private Set<Long> userIds = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return id != null && Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
