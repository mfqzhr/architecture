package com.architecture.projectfive.view;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 穆繁强
 * @date 2019/12/28
 */

public class StudentView {

    public String printStudentDetails(Integer id, String name, String gender) {
       ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.addObject("name", name);
        modelAndView.addObject("gender", gender);
        return "out";
    }

}
