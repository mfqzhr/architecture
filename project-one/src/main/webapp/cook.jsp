<%@ page import="javax.swing.plaf.synth.SynthOptionPaneUI" %>
<%@ page import="bean.BaseFood" %>
<%@ page import="java.util.concurrent.TimeUnit" %><%--
  Created by IntelliJ IDEA.
  User: ac‘
  Date: 2019/12/26
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cook</title>
</head>
<body>
    <%

        String food = (String) request.getAttribute("food");
        String baseFood = (String) request.getAttribute("baseFood");
        if (food != null && !"".equals(food)) {
            System.out.println("厨师: 采购员同志,去给我准备" + food + "的原料");

            request.getRequestDispatcher("/buyer.jsp").forward(request, response);
            return;
        } else {
            System.out.println("厨师: 你好 服务员," + baseFood + "做好了");
            request.setAttribute("foodByCooking", baseFood);
            request.setAttribute("food", "");
            request.getRequestDispatcher("/waiter.jsp").forward(request, response);
        }
    %>
</body>
</html>
