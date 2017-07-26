package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * キー局の番組コードのCondition
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC 張(Jang)
 */
public class FindKeyKyokuBangumiCdCondition extends AbstractServiceCondition {
    private static final long serialVersionUID = 1L;

    /** 種別コード (媒体コード) */
    private String _sybt = null;

    /** 種別コード (媒体コード)を取得 */
    public String getSybt() {
        return this._sybt;
    }

    /** 種別コード (媒体コード)を設定 */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

}
