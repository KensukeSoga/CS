package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU00SIK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �g�D�}�X�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class RcmnMeu00SikVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public RcmnMeu00SikVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new RcmnMeu00SikVO();
    }

    /**
     * EGSYOCD���擾����
     * @return EGSYOCD
     */
    public String getEgsyoCd() {
        return (String) get(TBRCMN_MEU00SIK.EGSYOCD);
    }

    /**
     * EGSYOCD��ݒ肷��
     * @param val EGSYOCD
     */
    public void setEgsyoCd(String val) {
        set(TBRCMN_MEU00SIK.EGSYOCD, val);
    }

    /**
     * JSIKCD���擾����
     * @return JSIKCD
     */
    public String getJSikCd() {
        return (String) get(TBRCMN_MEU00SIK.JSIKCD);
    }

    /**
     * JSIKCD��ݒ肷��
     * @param val JSIKCD
     */
    public void setJSikCd(String val) {
        set(TBRCMN_MEU00SIK.JSIKCD, val);
    }

    /**
     * KAISOCD���擾����
     * @return KAISOCD
     */
    public String getKaisoCd() {
        return (String) get(TBRCMN_MEU00SIK.KAISOCD);
    }

    /**
     * KAISOCD��ݒ肷��
     * @param val KAISOCD
     */
    public void setKaisoCd(String val) {
        set(TBRCMN_MEU00SIK.KAISOCD, val);
    }

}
