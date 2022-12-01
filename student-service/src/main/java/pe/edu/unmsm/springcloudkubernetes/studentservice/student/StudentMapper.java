package pe.edu.unmsm.springcloudkubernetes.studentservice.student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toStudentDto(Student student);

    List<StudentDto> toStudentDtoList(List<Student> students);

    @Mapping(target = "id", ignore = true)
    Student toStudentEntity(StudentDto student);

    List<Student> toStudentEntityList(List<StudentDto> studentDtoList);
}
