package pe.edu.unmsm.springcloudkubernetes.courseservice.course;

import java.util.List;

public interface CourseService {
    List<CourseDto> getCourses();

    CourseDto getCourseById(Long id);

    CourseDto registerCourse(CourseDto courseDto);

    CourseDto updateCourseById(Long id, CourseDto courseDto);

    void deleteCourseById(Long id);
}
