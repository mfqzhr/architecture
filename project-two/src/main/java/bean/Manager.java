package bean;

import util.LogUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 穆繁强
 * @date 2019/12/29
 */
public class Manager {
    DataManager dataManager;

    public String doWork(User user) throws SQLException {
        dataManager = new DataManager();
        System.out.println("业务逻辑层: 数据库管理员请添加一个用户");
        String res = dataManager.doWork(user);
        System.out.println("业务逻辑层: 正在记录日志");
        try {
            LogUtil.writeLogToLocal("d:/log/project2", "添加: " + user.getName() + res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
