package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBTCM02JUN;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 公開範囲情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class Tcm01KkhVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public Tcm01KkhVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new Tcm01KkhVO();
    }

    /**
     * ZSBCH0317を取得する
     * @return ZSBCH0317
     */
    public String getZsbch0317() {
        return (String) get(TBTCM02JUN.ZSBCH0317);
    }

    /**
     * ZSBCH0317を設定する
     * @param val ZSBCH0317
     */
    public void setZsbch0317(String val) {
        set(TBTCM02JUN.ZSBCH0317, val);
    }

}
