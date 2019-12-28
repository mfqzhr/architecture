<%--
  Created by IntelliJ IDEA.
  User: ac‘
  Date: 2019/12/26
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>waiter</title>
    <%
        String food = request.getParameter("food");
        String foodByCooking = (String) request.getAttribute("foodByCooking");
        if (foodByCooking != null && !"".equals(foodByCooking)) {
            request.getSession().setAttribute("foodByCooking", foodByCooking);
            System.out.println("服务员: " + food + "来了");
            response.sendRedirect(request.getContextPath() + "/customer.jsp");

        } else if (foodByCooking == null || "".equals(foodByCooking)) {

            System.out.println("服务员: 厨师你好顾客要吃" + food);
            request.setAttribute("food", food);
            request.getRequestDispatcher("/cook.jsp").forward(request, response);
            return;
        } else {
            System.out.println("厨师: 没有原材料了,不能做这道菜");
        }
    %>
    </br>

</head>
<body>

</body>
</html>
