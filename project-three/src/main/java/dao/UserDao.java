package dao;

import bean.User;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 穆繁强
 * @date 2019/12/27
 */
public class UserDao {

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

}
