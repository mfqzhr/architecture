package com.architecture.projectsix.dao;

import com.architecture.projectsix.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 穆繁强
 * @date 2019/12/28
 */
@Repository
public class UserDao {
    public static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("张三", "男", "18834165775", "142402199810265114"));
        userList.add(new User("李四", "女", "18834165772", "142402199810265117"));
        userList.add(new User("王五", "男", "18834165771", "142402199810265118"));
        userList.add(new User("赵六", "女", "18834165777", "142402199810265112"));

    }

    public List<User> findByAll() {

        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User findByPhoneAndCard(String phone, String card) {
        return userList.stream().filter(user -> user.getPhone().equals(phone)|| user.getCard().equals(card)).findFirst().orElse(null);
    }
}
