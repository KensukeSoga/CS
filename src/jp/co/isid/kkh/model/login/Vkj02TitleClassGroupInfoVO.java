package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.VWTITLECLASSMEMBER;
import jp.co.isid.nj.model.AbstractModel;

public class Vkj02TitleClassGroupInfoVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public Vkj02TitleClassGroupInfoVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new Vkj02TitleClassGroupInfoVO();
    }

    /**
     * GROUPCD���擾����
     * @return GROUPCD
     */
    public String getGroupCd() {
        return (String) get(VWTITLECLASSMEMBER.GROUPCD);
    }

    /**
     * GROUPCD��ݒ肷��
     * @param val GROUPCD
     */
    public void setGroupCd(String val) {
        set(VWTITLECLASSMEMBER.GROUPCD, val);
    }

}
