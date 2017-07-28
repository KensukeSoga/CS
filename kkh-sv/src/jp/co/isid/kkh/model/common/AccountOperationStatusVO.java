package jp.co.isid.kkh.model.common;

import jp.co.isid.kkh.integ.tbl.TBTKJ99KNR;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 業務会計稼働状況VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/09 JSE H.Abe)<BR>
 * </P>
 * @author
 */
public class AccountOperationStatusVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public AccountOperationStatusVO() {
    }

    /**
     * 新規インスタンスを構築します。
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new AccountOperationStatusVO();
    }

    /**
     * 管理フラグを取得する
     * @return 管理フラグ
     */
    public String getKanriFlg() {
        return (String) get(TBTKJ99KNR.KANRIFLG);
    }

    /**
     * 管理フラグを設定する
     * @param val 管理フラグ
     */
    public void setKanriFlg(String val) {
        set(TBTKJ99KNR.KANRIFLG, val);
    }

}
