package architure;

/**
 * 超市
 * @author 穆繁强
 * @date 2019/12/29
 */
public class Supermarket extends FenWineCompanyCheckImpl {

    @Override
    public Integer firstStep(Integer number, Integer price) {
        return number * price;
    }

    @Override
    public Integer secondStep(Integer firstStep, Integer tasks) {
        return tasks - firstStep;
    }

    @Override
    public void show(Integer res) {
        System.out.println("超市核算营收: " + res);
    }
}
