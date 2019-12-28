package controller;

import bean.Student;
import view.StudentView;

/**
 * @author 穆繁强
 * @date 2019/12/27
 */
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public Integer getStudentId() {
        return model.getId();
    }

    public String getStudentName() {
        return model.getName();
    }

    public String getStudentGender() {
        return model.getGender();
    }

    public void setStudentId(Integer id) {
        model.setId(id);
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentGender(String gender) {
        model.setGender(gender);
    }

    public void updateView() {
        view.printStudentDetails(model.getId(), model.getName(), model.getGender());
    }
}
