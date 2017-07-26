package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU07SIKKRSPRD;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �o���g�D�W�J���VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class RcmnMeu07SikkrsprdVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public RcmnMeu07SikkrsprdVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new RcmnMeu07SikkrsprdVO();
    }

    /**
     * �g�D�R�[�h�i�ǁj���擾����
     * @return �g�D�R�[�h�i�ǁj
     */
    public String getSikCdKyk() {
        return (String) get(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK);
    }

    /**
     * �g�D�R�[�h�i�ǁj��ݒ肷��
     * @param val �g�D�R�[�h�i�ǁj
     */
    public void setSikCdKyk(String val) {
        set(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK, val);
    }

}
