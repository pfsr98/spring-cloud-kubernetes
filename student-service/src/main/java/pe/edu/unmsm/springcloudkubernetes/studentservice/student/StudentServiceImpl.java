package pe.edu.unmsm.springcloudkubernetes.studentservice.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.springcloudkubernetes.studentservice.exception.DuplicateEntityException;
import pe.edu.unmsm.springcloudkubernetes.studentservice.exception.EntityNotFoundException;

import java.text.MessageFormat;
import java.util.List;

import static pe.edu.unmsm.springcloudkubernetes.studentservice.util.Constants.DUPLICATE_STUDENT;
import static pe.edu.unmsm.springcloudkubernetes.studentservice.util.Constants.STUDENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> getStudents(List<Long> ids) {
        List<Student> studentsFound = (!ids.isEmpty()) ? studentRepo.findAllById(ids) : studentRepo.findAll();
        return studentMapper.toStudentDtoList(studentsFound);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student studentFound = findStudentById(id);
        return studentMapper.toStudentDto(studentFound);
    }

    @Override
    public StudentDto getStudentByEmail(String email) {
        Student studentFound = studentRepo.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format(STUDENT_NOT_FOUND, "email", email)));
        return studentMapper.toStudentDto(studentFound);
    }

    @Override
    public StudentDto registerStudent(StudentDto studentDto) {
        if (studentRepo.existsByEmail(studentDto.email())) {
            throw new DuplicateEntityException(MessageFormat.format(DUPLICATE_STUDENT, "email", studentDto.email()));
        }
        Student student = studentMapper.toStudentEntity(studentDto);
        Student registeredStudent = studentRepo.save(student);
        return studentMapper.toStudentDto(registeredStudent);
    }

    @Override
    public StudentDto updateStudentById(Long id, StudentDto studentDto) {
        Student studentFound = findStudentById(id);
        Student student = studentFound.toBuilder()
                .name(studentDto.name())
                .email(studentDto.email())
                .password(studentDto.password())
                .build();
        Student updatedStudent = studentRepo.save(student);
        return studentMapper.toStudentDto(updatedStudent);
    }

    @Override
    public void deleteStudentById(Long id) {
        findStudentById(id);
        studentRepo.deleteById(id);
    }

    private Student findStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format(STUDENT_NOT_FOUND, "id", id)));
    }
}
