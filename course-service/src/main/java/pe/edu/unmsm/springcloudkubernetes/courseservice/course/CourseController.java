package pe.edu.unmsm.springcloudkubernetes.courseservice.course;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDto> registerCourse(@Valid @RequestBody CourseDto course) {
        CourseDto registerCourse = courseService.registerCourse(course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(registerCourse.id())
                .toUri();
        return ResponseEntity.created(uri).body(registerCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourseById(@PathVariable Long id, @Valid @RequestBody CourseDto course) {
        return ResponseEntity.ok(courseService.updateCourseById(id, course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }
}
