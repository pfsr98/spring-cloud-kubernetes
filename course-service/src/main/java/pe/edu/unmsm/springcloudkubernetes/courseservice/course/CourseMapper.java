package pe.edu.unmsm.springcloudkubernetes.courseservice.course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toCourseDto(Course course);

    List<CourseDto> toCourseDtoList(List<Course> courses);

    @Mapping(target = "id", ignore = true)
    Course toCourseEntity(CourseDto course);

    List<Course> toCourseEntityList(List<CourseDto> courseDtoList);
}
