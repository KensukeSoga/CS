package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.VWACCUSER;
import jp.co.isid.nj.model.AbstractModel;

public class Vkj01AccuserVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public Vkj01AccuserVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new Vkj01AccuserVO();
    }

    /**
     * OGNZUNTCD���擾����
     * @return OGNZUNTCD
     */
    public String getOgnzuntCd() {
        return (String) get(VWACCUSER.OGNZUNTCD);
    }

    /**
     * OGNZUNTCD��ݒ肷��
     * @param val OGNZUNTCD
     */
    public void setOgnzuntCd(String val) {
        set(VWACCUSER.OGNZUNTCD, val);
    }

}
