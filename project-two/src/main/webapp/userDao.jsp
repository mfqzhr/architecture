<%@ page import="bean.User" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.nio.channels.FileChannel" %>
<%@ page import="java.nio.ByteBuffer" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.io.*" %><%--
  Created by IntelliJ IDEA.
  User: ac‘
  Date: 2019/12/27
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>


<%!

    public int insertUser(User user) throws SQLException, IOException {
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
        String sql = "insert into user (name, gender, email) values ( '" + user.getName() + "' , '" + user.getGender() + "' , '"
                + user.getEmail() + "' )";
        System.out.println(sql);
        int res = stmt.executeUpdate(sql);
        if (res != 0) {
            writeLogToLocal("insert user success");
        } else {
            writeLogToLocal("insert user failed");
        }

        return res;

    }

    public void writeLogToLocal(String log) throws IOException {
        String path = "d:/log";
        String fileName = path + "/logout.txt";
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logFmt = "\r\n" + localDateTime + " " + log;
        File file = new File(path);

        if (!file.exists()) {
            file.mkdirs();
        }
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(raf.length());
        raf.write(logFmt.getBytes());
        raf.close();


    }


%>

<%
    User user = (User) request.getAttribute("user");
    int res = insertUser(user);
    if (res != 0) {
        request.setAttribute("msg", "success");

    } else {
        request.setAttribute("msg", "fail");

    }
    request.getRequestDispatcher("/userController.jsp").forward(request, response);
%>

</body>
</html>
