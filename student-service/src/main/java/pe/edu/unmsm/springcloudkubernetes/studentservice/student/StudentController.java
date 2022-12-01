package pe.edu.unmsm.springcloudkubernetes.studentservice.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents(@RequestParam(required = false, defaultValue = "") List<Long> ids) {
        return ResponseEntity.ok(studentService.getStudents(ids));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> registerStudent(@Valid @RequestBody StudentDto student) {
        StudentDto registerStudent = studentService.registerStudent(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(registerStudent.id())
                .toUri();
        return ResponseEntity.created(uri).body(registerStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable Long id, @Valid @RequestBody StudentDto student) {
        return ResponseEntity.ok(studentService.updateStudentById(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
