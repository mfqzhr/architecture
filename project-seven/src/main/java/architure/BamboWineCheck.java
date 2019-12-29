package architure;

/**
 * 竹叶青
 *
 * @author 穆繁强
 * @date 2019/12/29
 */
public class BamboWineCheck extends FenWineCompanyCheck {

    public BamboWineCheck(FenWineCompanyCheckImpl impl) {
        super(impl);
    }

    @Override
    public void check(Integer number, Integer price, Integer tasks) {
        System.out.print("竹叶青->");
        Integer firstStep = firstStep(number, price);
        Integer res = secondStep(firstStep, tasks);
        show(res);
    }


}
