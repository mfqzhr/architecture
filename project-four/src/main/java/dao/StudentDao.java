package dao;

import bean.Student;

/**
 * @author 穆繁强
 * @date 2019/12/27
 */
public class StudentDao {

    public static Student getStudent() {
        return new Student(1, "mfq", "male");
    }
}
