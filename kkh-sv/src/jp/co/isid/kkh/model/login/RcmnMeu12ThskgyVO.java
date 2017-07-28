package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU12THSKGY;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU13THSKGYBMON;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �������VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class RcmnMeu12ThskgyVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public RcmnMeu12ThskgyVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new RcmnMeu12ThskgyVO();
    }

    /**
     * THSKGYDISPKJ���擾����
     * @return THSKGYDISPKJ
     */
    public String getThskgyDispKj() {
        return (String) get(TBRCMN_MEU12THSKGY.THSKGYDISPKJ);
    }

    /**
     * THSKGYDISPKJ��ݒ肷��
     * @param val THSKGYDISPKJ
     */
    public void setThskgyDispKj(String val) {
        set(TBRCMN_MEU12THSKGY.THSKGYDISPKJ, val);
    }

    /**
     * SUBMEI���擾����
     * @return SUBMEI
     */
    public String getSubMei() {
        return (String) get(TBRCMN_MEU13THSKGYBMON.SUBMEI);
    }

    /**
     * SUBMEI��ݒ肷��
     * @param val SUBMEI
     */
    public void setSubMei(String val) {
        set(TBRCMN_MEU13THSKGYBMON.SUBMEI, val);
    }

}
