<%@ page import="java.util.concurrent.TimeUnit" %>
<%@ page import="bean.BaseFood" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ac‘
  Date: 2019/12/26
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>buyer</title>
</head>
<body>
<%

    String food = (String) request.getAttribute("food");
    if (!"".equals(food) && food != null) {
        final String URL = "jdbc:mysql://localhost:3306/warehouse?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        final String USER = "root";
        final String PASSWORD = "123456";

        Connection conn = null;
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, number FROM base_food where name = '" + food + "'");

        BaseFood baseFood = null;
        while (rs.next()) {
            baseFood = new BaseFood();
            baseFood.setId(rs.getInt("id"));
            baseFood.setName(rs.getString("name"));
            baseFood.setNumber(rs.getInt("number"));
        }
        if (baseFood.getNumber() == 0) {
            System.out.println("采购员: 你好厨师没有原材料了");
            request.setAttribute("baseFood", null);
            request.getRequestDispatcher("/cook.jsp").forward(request, response);
            return;
        }
        stmt.executeUpdate("update base_food set number = number - 1 where id = " + baseFood.getId());
        stmt.close();
        System.out.println("采购员: 厨师这是" + baseFood.getName() + "的原材料");
        request.setAttribute("baseFood", baseFood.getName());
        request.setAttribute("food", "");
        request.getRequestDispatcher("/cook.jsp").forward(request, response);
        return;
    }


%>
</body>
</html>
