package com.architecture.projectsix.controller;

import com.architecture.projectsix.bean.User;
import com.architecture.projectsix.constant.Constant;
import com.architecture.projectsix.dao.UserDao;
import com.architecture.projectsix.util.LogUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;


/**
 * @author 穆繁强
 * @date 2019/12/28
 */

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<User> list = userDao.findByAll();
        model.addAttribute("list", list);
        return "list";
    }

    @PostMapping("/addUser")
    public String addUser(User user) {
        userDao.addUser(user);
        try {
            LogUtil.writeLogToLocal(Constant.Log_Path, "添加用户: " + user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/list";
    }
}
