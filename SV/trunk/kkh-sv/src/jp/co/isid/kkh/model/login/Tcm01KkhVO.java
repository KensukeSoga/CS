package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBTCM02JUN;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���J�͈͏��VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class Tcm01KkhVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public Tcm01KkhVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new Tcm01KkhVO();
    }

    /**
     * ZSBCH0317���擾����
     * @return ZSBCH0317
     */
    public String getZsbch0317() {
        return (String) get(TBTCM02JUN.ZSBCH0317);
    }

    /**
     * ZSBCH0317��ݒ肷��
     * @param val ZSBCH0317
     */
    public void setZsbch0317(String val) {
        set(TBTCM02JUN.ZSBCH0317, val);
    }

}
