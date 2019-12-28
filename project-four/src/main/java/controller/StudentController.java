package controller;

import bean.Student;
import view.StudentView;

/**
 * @author 穆繁强
 * @date 2019/12/27
 */
public class StudentController {
    private Student student;
    private StudentView studentView;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentView getStudentView() {
        return studentView;
    }

    public void setStudentView(StudentView studentView) {
        this.studentView = studentView;
    }

    public void updateView() {

    }
}
