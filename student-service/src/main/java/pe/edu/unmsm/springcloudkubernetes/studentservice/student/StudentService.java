package pe.edu.unmsm.springcloudkubernetes.studentservice.student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents(List<Long> ids);

    StudentDto getStudentById(Long id);

    StudentDto getStudentByEmail(String email);

    StudentDto registerStudent(StudentDto student);

    StudentDto updateStudentById(Long id, StudentDto studentDto);

    void deleteStudentById(Long id);
}
