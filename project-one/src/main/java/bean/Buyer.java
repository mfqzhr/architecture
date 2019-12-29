package bean;

import java.sql.*;

/**
 * @author 穆繁强
 * @date 2019/12/29
 */
public class Buyer {
    final String URL = "jdbc:mysql://localhost:3306/warehouse?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    final String USER = "root";
    final String PASSWORD = "123456";

    public String doWork(String food) throws SQLException {

        System.out.println("采购员: 厨师我马上去准备" + food + "的原材料");
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
        int number = 0, id = 0;

        while (rs.next()) {
            number = rs.getInt("number");
            id = rs.getInt("id");
        }
        if (number == 0) {
            System.out.println("采购员: 你好厨师没有原材料了");
            return "原材料不足,请换个菜吧";
        }
        stmt.executeUpdate("update base_food set number = number - 1 where id = " + id);
        stmt.close();
        System.out.println("采购员: 厨师这是" + food + "的原材料");

        return food;
    }
}
