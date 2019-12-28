<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: ac‘
  Date: 2019/12/27
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        request.getSession().setAttribute("sendToView", msg);
        response.sendRedirect(pageContext.getServletContext().getContextPath() + "/view.jsp");
    } else {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setGender(request.getParameter("gender"));
        user.setEmail(request.getParameter("email"));
        request.setAttribute("user", user);
        request.getRequestDispatcher("/userDao.jsp").forward(request, response);
    }
%>
</body>
</html>
