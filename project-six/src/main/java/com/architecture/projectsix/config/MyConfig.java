package com.architecture.projectsix.config;

import com.architecture.projectsix.constant.Constant;
import com.architecture.projectsix.dao.UserDao;
import com.architecture.projectsix.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * @author 穆繁强
 * @date 2019/12/28
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Autowired
    private UserDao userDao;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String msg = "";
                String name = request.getParameter("name");
                String sex = request.getParameter("sex");
                String phone = request.getParameter("phone");
                String card = request.getParameter("card");
                String cardPattern =
                        "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
                if (!phone.matches("^1(3|4|5|6|7|8|9)\\d{9}$")) {
                    msg = "手机号不正确";
                } else if (!Pattern.matches(cardPattern, card)) {
                    msg = "身份证不正确";
                } else if (!Pattern.matches("^([\\u4e00-\\u9fa5]{1,20}|[a-zA-Z\\.\\s]{1,20})$", name)) {
                    msg = "姓名不合法";
                } else if (userDao.findByPhoneAndCard(phone, card) != null) {
                    msg = "身份证或者手机号不合法";
                } else {
                    request.getSession().setAttribute("msg", "");
                    return true;
                }
                request.getSession().setAttribute("msg", msg);
                LogUtil.writeLogToLocal(Constant.Log_Path, "由于" + msg + " 添加用户失败");
                response.sendRedirect("/");
                return false;
            }
        }).addPathPatterns("/addUser");
    }
}
