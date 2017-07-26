package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBTHBCKHT;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 開放得意先管理情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class ThbcKhtVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ThbcKhtVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ThbcKhtVO();
    }

    /**
     * 画面表示フラグを取得する
     * @return 画面表示フラグ
     */
    public String getDisFlg() {
        return (String) get(TBTHBCKHT.DISFLG);
    }

    /**
     * 画面表示フラグを設定する
     * @param val 画面表示フラグ
     */
    public void setDisFlg(String val) {
        set(TBTHBCKHT.DISFLG, val);
    }

}
