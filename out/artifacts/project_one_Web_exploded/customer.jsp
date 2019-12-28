<%--
  Created by IntelliJ IDEA.
  User: ac‘
  Date: 2019/12/26
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>customer</title>
</head>
<body>
<h2>顾客您好请输入您想要吃的菜</h2>
<form action="waiter.jsp">
    <input id="food" name="food" type="text">
    <button type="submit">递给服务员</button>
</form>
<%=request.getSession().getAttribute("foodByCooking") == null ? "" : (request.getSession().getAttribute("foodByCooking"))%>
<%
    request.getSession().setAttribute("foodByCooking", null);
%>
</body>
</html>
