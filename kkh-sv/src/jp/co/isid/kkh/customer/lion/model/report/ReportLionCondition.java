package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 *
 * <P>
 * ���C�I���v���[�t���X�g���[��������
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * �E��r���[�Ή�(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author
 *
 */
public class ReportLionCondition extends AbstractServiceCondition{

    private static final long serialVersionUID = 1L;

    /** �}�̖� */
    private String _baitai = null;

    /* 2014/07/31 ��r���[�Ή� HLC fujimoto ADD start */
    /** �v���[�t���X�g�o�͓��� */
    private String _prtOutProofListTimStmp = null;
    /* 2014/07/31 ��r���[�Ή� HLC fujimoto ADD end */

    /**
     * �}�̖����擾����
     * @return �}�̖�
     */
    public String getbaitai() {
        return _baitai;
    }

    /**
     * �}�̖���ݒ肷��
     * @param val String �}�̖�
     */
    public void setbaitai(String val) {
        _baitai = val;
    }

    /* 2014/07/31 ��r���[�Ή� HLC fujimoto ADD start */
    /**
     * �v���[�t���X�g�o�͓������擾����
     * @return �v���[�t���X�g�o�͓���
     */
    public String getPrtOutProofListTimStmp() {
        return _prtOutProofListTimStmp;
    }

    /**
     * �v���[�t���X�g�o�͓�����ݒ肷��
     * @param val String �v���[�t���X�g�o�͓���
     */
    public void setPrtOutProofListTimStmp(String val) {
        _prtOutProofListTimStmp = val;
    }
    /* 2014/07/31 ��r���[�Ή� HLC fujimoto ADD end */

}
