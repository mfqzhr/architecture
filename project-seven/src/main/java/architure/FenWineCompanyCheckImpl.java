package architure;

/**
 * @author 穆繁强
 * @date 2019/12/29
 */
public abstract class FenWineCompanyCheckImpl {
    /**
     * 计算日均营收额
     *
     * @param number
     * @param price
     * @return
     */
    public abstract Integer firstStep(Integer number, Integer price);

    /**
     * 核算营收
     *
     * @param firstStep
     * @param tasks
     * @return
     */
    public abstract Integer secondStep(Integer firstStep, Integer tasks);

    /**
     * 显示结果
     *
     * @param res
     */
    public abstract void show(Integer res);
}
