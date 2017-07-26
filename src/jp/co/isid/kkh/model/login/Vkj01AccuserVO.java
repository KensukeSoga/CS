package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.VWACCUSER;
import jp.co.isid.nj.model.AbstractModel;

public class Vkj01AccuserVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public Vkj01AccuserVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new Vkj01AccuserVO();
    }

    /**
     * OGNZUNTCDを取得する
     * @return OGNZUNTCD
     */
    public String getOgnzuntCd() {
        return (String) get(VWACCUSER.OGNZUNTCD);
    }

    /**
     * OGNZUNTCDを設定する
     * @param val OGNZUNTCD
     */
    public void setOgnzuntCd(String val) {
        set(VWACCUSER.OGNZUNTCD, val);
    }

}
