package bean;

import java.sql.SQLException;

/**
 * @author 穆繁强
 * @date 2019/12/29
 */
public class Cook {

    Buyer buyer = new Buyer();

    public String doWork(String food) {

        System.out.println("厨师: 采购员同志,去给我准备" + food + "的原料");
        String res = "";
        try {
            res = buyer.doWork(food);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("厨师: 服务员你好," + food + "做好了");
        return res;
    }
}
