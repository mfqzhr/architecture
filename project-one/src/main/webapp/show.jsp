<%@ page import="bean.Buyer" %>
<%@ page import="bean.Waiter" %><%--
  Created by IntelliJ IDEA.
  User: ac‘
  Date: 2019/12/26
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%=new Waiter().doWork(request.getParameter("food"))%>
</body>
</html>
