package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �V�[�N�G���XNo�ő�lVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class MaxSeqNoVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public MaxSeqNoVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new MaxSeqNoVO();
    }

    /**
     * �V�[�N�G���XNo��ݒ肵�܂��B
     * @param val String �V�[�N�G���XNo
     */
    public void setSeqNo(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * �V�[�N�G���XNo��Ԃ��܂��B
     * @return String �V�[�N�G���XNo
     */
    public String getSeqNo() {
        return (String) get(TBTHB2KMEI.CODE3);
    }
}