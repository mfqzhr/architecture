package com.architecture.projectfive.controller;

import com.architecture.projectfive.bean.Student;
import com.architecture.projectfive.dao.StudentDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 穆繁强
 * @date 2019/12/27
 */
@Controller
public class StudentController {
    private Student student;

    @GetMapping("/")
    public ModelAndView index() {
        student = StudentDao.getStudent();
        ModelAndView modelAndView = new ModelAndView("out");
        modelAndView.addObject("id", student.getId());
        modelAndView.addObject("name", student.getName());
        modelAndView.addObject("gender", student.getGender());
        return modelAndView;
    }
}
