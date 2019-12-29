package architure;

/**
 * @author 穆繁强
 * @date 2019/12/29
 */
public class FenWineCheck extends FenWineCompanyCheck {


    public FenWineCheck(FenWineCompanyCheckImpl impl) {
        super(impl);
    }

    @Override
    public void check(Integer number, Integer price, Integer tasks) {
        System.out.print("汾酒->");
        Integer firstStep = firstStep(number, price);
        Integer res = secondStep(firstStep, tasks);
        show(res);
    }
}
