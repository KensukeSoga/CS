package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.VWTITLECLASSMEMBER;
import jp.co.isid.nj.model.AbstractModel;

public class Vkj02TitleClassGroupInfoVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public Vkj02TitleClassGroupInfoVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new Vkj02TitleClassGroupInfoVO();
    }

    /**
     * GROUPCDを取得する
     * @return GROUPCD
     */
    public String getGroupCd() {
        return (String) get(VWTITLECLASSMEMBER.GROUPCD);
    }

    /**
     * GROUPCDを設定する
     * @param val GROUPCD
     */
    public void setGroupCd(String val) {
        set(VWTITLECLASSMEMBER.GROUPCD, val);
    }

}
