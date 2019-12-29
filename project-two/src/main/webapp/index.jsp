<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
</body>
<form action="view.jsp">
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
</html>
