package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 穆繁强
 * @date 2019/12/29
 */
public class DataManager {
    public String doWork(User user) throws SQLException {

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
        String msg = "";
        if (res != 0) {
            msg = " insert user success";
        } else {
            msg = " insert user failed";
        }

        return msg;
    }
}
