package bean;

/**
 * @author 穆繁强
 * @date 2019/12/29
 */
public class Waiter {

    Cook cook;

    public String doWork(String food) {
        System.out.println("服务员: 你好厨师: 顾客要吃" + food);
        cook = new Cook();
        String res = cook.doWork(food);
        System.out.println("服务员: 您好顾客, 这是您要的" + food);
        return res;
    }
}
