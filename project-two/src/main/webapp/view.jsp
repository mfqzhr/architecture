<%--
  Created by IntelliJ IDEA.
  User: ac‘
  Date: 2019/12/27
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="userController.jsp">
    <table border="1">
        <tr>
            <td>name</td>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <td>gender</td>
            <td><input type="text" id="gender" name="gender"></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="email" id="email" name="email"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">添加用户</button>
            </td>
        </tr>
    </table>
</form>
<%=request.getSession().getAttribute("sendToView") == null ? "":request.getSession().getAttribute("sendToView")%>
<%
    request.getSession().setAttribute("sendToView", null);
%>
</body>
</html>
