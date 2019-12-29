package bean;

import java.sql.SQLException;

/**
 * @author 穆繁强
 * @date 2019/12/29
 */
public class Operation {
    Manager manager;

    public String doWork(User user) throws SQLException {
        manager = new Manager();
        System.out.println("表示层: 请添加一个用户");
        String res = manager.doWork(user);
        return res;
    }
}
