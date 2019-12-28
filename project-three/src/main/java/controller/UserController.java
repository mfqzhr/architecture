package controller;

import bean.User;
import dao.UserDao;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 穆繁强
 * @date 2019/12/27
 */

@WebServlet("/userController")
public class UserController extends HttpServlet {

    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userDao = new UserDao();
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setGender(request.getParameter("gender"));
        user.setEmail(request.getParameter("email"));
        int res = 0;
        try {
            res = userDao.insertUser(user);
        } catch (SQLException e) {
            e.getMessage();
        }

        if (res != 0) {
            userDao.writeLogToLocal("insert user success");
            request.getSession().setAttribute("sendToView", "success");
        } else {
            userDao.writeLogToLocal("insert user fail");
            request.getSession().setAttribute("sendToView", "fail");
        }
        response.sendRedirect(request.getContextPath() + "/view.jsp");
    }
}
