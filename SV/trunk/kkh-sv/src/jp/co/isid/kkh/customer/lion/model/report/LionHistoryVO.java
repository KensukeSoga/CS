package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���C�I�������f�[�^��������VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class LionHistoryVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** �����^�C���X�^���v */
    public static final String RRKTIMSTMP = "RRKTIMSTMP";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public LionHistoryVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new LionHistoryVO();
    }

    /**
     * �����^�C���X�^���v���擾����
     * @return �����^�C���X�^���v
     */
    public String getRrkTimStmp() {
        return (String) get(RRKTIMSTMP);
    }

    /**
     * �����^�C���X�^���v��ݒ肷��
     * @param val String �����^�C���X�^���v
     */
    public void setRrkTimStmp(String val) {
        set(RRKTIMSTMP, val);
    }

}