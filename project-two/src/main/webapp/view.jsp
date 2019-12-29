<%@ page import="bean.Operation" %>
<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: ac‘
  Date: 2019/12/27
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%
    User user = new User();
    user.setName(request.getParameter("name"));
    user.setEmail(request.getParameter("email"));
    user.setGender(request.getParameter("gender"));
    Operation operation = new Operation();
%>
<%=operation.doWork(user)%>

</body>
</html>
