package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class DetailListLionCondition extends AbstractServiceCondition{

    private static final long serialVersionUID = 1L;

    /** 開始年月 */
    private String _ymfrom;

    /** 終了年月 */
    private String _ymto;

    /** 媒体区分 */
    private String _baitaikbn;

    /**
     * @return 開始年月を返します
     */
    public String getymto() {
        return _ymto;
    }

    /**
     * @param  開始年月をセットします
     */
    public void setymto(String ymto) {
        this._ymto = ymto;
    }

    /**
     * @return 終了年月を返します
     */
    public String getymfrom() {
        return _ymfrom;
    }

    /**
     * @param  終了年月をセットします
     */
    public void setymfrom(String ymfrom) {
        this._ymfrom = ymfrom;
    }

    /**
     * @return 媒体区分を返します
     */
    public String getbaitaikbn() {
        return _baitaikbn;
    }

    /**
     * @param  媒体区分をセットします
     */
    public void setbaitaikbn(String baitaikbn) {
        this._baitaikbn = baitaikbn;
    }

}
