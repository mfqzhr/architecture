package architure;

/**
 * @author 穆繁强
 * @date 2019/12/29
 */
public class Main {
    public static void main(String[] args) {
        /**
         * 汾酒->超市
         */
        FenWineCheck fcSM = new FenWineCheck(new Supermarket());
        fcSM.check(30, 100, 20000);
        /**
         * 汾酒->自营店
         */
        FenWineCheck fcOS = new FenWineCheck(new OwnStore());
        fcOS.check(20, 50, 13000);
        /**
         * 竹叶青->超市
         */
        BamboWineCheck bwcSm = new BamboWineCheck(new Supermarket());
        bwcSm.check(12, 123, 13532);
        /**
         * 竹叶青->自营店
         */
        BamboWineCheck bwcOs = new BamboWineCheck(new OwnStore());
        bwcOs.check(15, 122, 12352);
    }
}
