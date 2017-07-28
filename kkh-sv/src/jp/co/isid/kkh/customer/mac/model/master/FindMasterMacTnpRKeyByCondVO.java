package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.kkh.integ.tbl.TBTHB17RMTNP;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * マクドナルド店舗マスタ履歴テーブルキー項目VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 *
 * @author
 */
public class FindMasterMacTnpRKeyByCondVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindMasterMacTnpRKeyByCondVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindMasterMacTnpRKeyByCondVO();
    }

    /**
     * 更新実施キーを設定します。
     *
     * @param val String 更新実施キー
     */
    public void setUpdRrkTimstmp(String val) {
        set(TBTHB17RMTNP.UPDRRKTIMSTMP, val);
    }

    /**
     * 更新実施キーを返します。
     *
     * @return String 更新実施キー
     */
    public String getUpdRrkTimstmp() {
        return (String) get(TBTHB17RMTNP.UPDRRKTIMSTMP);
    }

    /**
     * 取り込み更新フラグを設定します。
     *
     * @param val String 取り込み更新フラグ
     */
    public void setTorikomiFlg(String val) {
        set(TBTHB17RMTNP.TORIKOMIFLG, val);
    }

    /**
     * 取り込み更新フラグを返します。
     *
     * @return String 取り込み更新フラグ
     */
    public String getTorikomiFlg() {
        return (String) get(TBTHB17RMTNP.TORIKOMIFLG);
    }

}
