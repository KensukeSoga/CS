package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU07SIKKRSPRD;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 経理組織展開情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class RcmnMeu07SikkrsprdVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public RcmnMeu07SikkrsprdVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new RcmnMeu07SikkrsprdVO();
    }

    /**
     * 組織コード（局）を取得する
     * @return 組織コード（局）
     */
    public String getSikCdKyk() {
        return (String) get(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK);
    }

    /**
     * 組織コード（局）を設定する
     * @param val 組織コード（局）
     */
    public void setSikCdKyk(String val) {
        set(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK, val);
    }

}
