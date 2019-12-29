package architure;

/**
 * @author 穆繁强
 * @date 2019/12/29
 */
public abstract class FenWineCompanyCheck {

    public abstract void check(Integer number, Integer price, Integer tasks);
    private FenWineCompanyCheckImpl impl;

    public FenWineCompanyCheck(FenWineCompanyCheckImpl impl) {
        this.impl = impl;
    }

    /**
     * 计算日均营收额
     * 日均营收额=产品数量*实际售价
     *
     * @param number
     * @param price
     * @return
     */
    public Integer firstStep(Integer number, Integer price) {
        return impl.firstStep(number, price);
    }

    /**
     * 计算核算营收
     * 核算营收=日均任务额-日均营收额
     *
     * @param firstStep
     * @param tasks
     * @return
     */
    public Integer secondStep(Integer firstStep, Integer tasks) {
        return impl.secondStep(firstStep, tasks);
    }

    /**
     * 用于显示输出
     *
     * @param res
     */
    public void show(Integer res) {
        impl.show(res);
    }

}
