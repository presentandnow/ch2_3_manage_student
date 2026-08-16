package org.fastcampus.student_management.application.course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.CourseList;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseRepository;

public class CourseService {
  private final CourseRepository courseRepository;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, StudentService studentService) {
    this.courseRepository = courseRepository;
    this.studentService = studentService;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentService.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(), courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
    courseRepository.save(course);
  }

  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    // TODO: 1. 과제 구현 부분
    List<Course> courseDayOfWeekList = courseRepository.getCourseDayOfWeek(dayOfWeek);

    return courseDayOfWeekList.stream()
                              .map(CourseInfoDto::new)
                              .toList(); // Collectors(Collector.toList)
    //return new ArrayList<>();
  }

  public void changeFee(String studentName, int fee) {
    // TODO: 4. 과제 구현 부분
    List<Course> studentCourseList = courseRepository.getCourseListByStudent(studentName);

//    studentCourseList.forEach(course -> course.changeFee(fee));

//    for(Course course : studentCourseList) {
//      if(course.isSameDay(DayOfWeek.SATURDAY) || course.isSameDay(DayOfWeek.SUNDAY)) {
//        course.changeFee((int)(fee * 1.5));
//      }
//      course.changeFee(fee);
//    }

    CourseList courseList = new CourseList(studentCourseList);
    courseList.changeAllCourseFee(fee);
  }
}
