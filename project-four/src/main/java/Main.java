import bean.Student;
import controller.StudentController;
import dao.StudentDao;
import view.StudentView;

/**
 * @author 穆繁强
 * @date 2019/12/28
 */
public class Main {
    public static void main(String[] args) {
        //从数据库获取学生记录
        Student model = StudentDao.getStudent();
        //创建一个学生视图,把学生信息输出到控制台
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(model, studentView);
        studentController.updateView();
        studentController.setStudentName("Li Liang");
        studentController.updateView();


    }
}
