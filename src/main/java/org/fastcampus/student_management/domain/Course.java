package org.fastcampus.student_management.domain;

public class Course {
  private final Student student;
  private final String courseName;
  //private int fee; // TODO :: 4. 과제 구현 부분 추가 - final 제거
  private CourseFee fee; // 추가
  private final DayOfWeek dayOfWeek;
  private final Long courseTime;

  public Course(Student student, String courseName, int fee, DayOfWeek dayOfWeek, Long courseTime) {
    if (student == null) {
      throw new IllegalArgumentException("학생은 필수 입력값입니다.");
    }

    this.student = student;
    this.courseName = courseName;
    this.fee = new CourseFee(fee); // 추가
    this.dayOfWeek = dayOfWeek;
    this.courseTime = courseTime;
  }

  public String getCourseName() {
    return courseName;
  }

  public boolean isSameDay(DayOfWeek dayOfWeek) {
    return this.dayOfWeek.equals(dayOfWeek);
  }

  public boolean isActivateUser() {
    return student.isActivate();
  }

  public String getStudentName() {
    return student.getName();
  }

  public int getFee() {
    return this.fee.getFee();
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public Long getCourseTime() {
    return courseTime;
  }

  // TODO: 4. 과제 구현 부분 추가
  public void changeFee(int fee) {
//    this.fee = fee;
    this.fee.changeFee(fee);
  }


}
