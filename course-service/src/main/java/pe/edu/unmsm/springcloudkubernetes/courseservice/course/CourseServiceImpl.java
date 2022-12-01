package pe.edu.unmsm.springcloudkubernetes.courseservice.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.springcloudkubernetes.courseservice.exception.DuplicateEntityException;
import pe.edu.unmsm.springcloudkubernetes.courseservice.exception.EntityNotFoundException;

import java.text.MessageFormat;
import java.util.List;

import static pe.edu.unmsm.springcloudkubernetes.courseservice.util.Constants.COURSE_NOT_FOUND;
import static pe.edu.unmsm.springcloudkubernetes.courseservice.util.Constants.DUPLICATE_COURSE;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseDto> getCourses() {
        List<Course> coursesFound = courseRepo.findAll();
        return courseMapper.toCourseDtoList(coursesFound);
    }

    @Override
    public CourseDto getCourseById(Long id) {
        Course courseFound = findCourseById(id);
        return courseMapper.toCourseDto(courseFound);
    }

    @Override
    public CourseDto registerCourse(CourseDto courseDto) {
        if (courseRepo.existsByName(courseDto.name())) {
            throw new DuplicateEntityException(MessageFormat.format(DUPLICATE_COURSE, "name", courseDto.name()));
        }
        Course course = courseMapper.toCourseEntity(courseDto);
        Course registeredCourse = courseRepo.save(course);
        return courseMapper.toCourseDto(registeredCourse);
    }

    @Override
    public CourseDto updateCourseById(Long id, CourseDto courseDto) {
        Course courseFound = findCourseById(id);
        Course course = courseFound.toBuilder()
                .name(courseDto.name())
                .userIds(courseDto.userIds())
                .build();
        Course updatedCourse = courseRepo.save(course);
        return courseMapper.toCourseDto(updatedCourse);
    }

    @Override
    public void deleteCourseById(Long id) {
        findCourseById(id);
        courseRepo.deleteById(id);
    }

    private Course findCourseById(Long id) {
        return courseRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format(COURSE_NOT_FOUND, "id", id)));
    }
}
