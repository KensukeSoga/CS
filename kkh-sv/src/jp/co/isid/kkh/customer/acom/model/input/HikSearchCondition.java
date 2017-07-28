package jp.co.isid.kkh.customer.acom.model.input;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * �����f�[�^�}�X�^���������B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikSearchCondition extends AbstractServiceCondition{

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** �N�x */
    private String _year;

    /** ��� */
    private String _syubetsu;

    /** �˗��s�ԍ� */
    private String _irrowban;

    /**
    * �V�K�C���X�^���X���\�z���܂��B
    */
    public HikSearchCondition() {
    }

    /**
     * �N�x���擾���܂��B
     * @return �N�x
     */
    public String getYear() {
        return _year;
    }

    /**
     * �N�x��ݒ肵�܂��B
     * @param year �N�x
     */
    public void setYear(String year) {
        _year = year;
    }

    /**
     * ��ʂ��擾���܂��B
     * @return String ���
     */
    public String getSyubetsu() {
        return _syubetsu;
    }

    /**
     * ��ʂ�ݒ肵�܂��B
     * @param syubetsu String ���
     */
    public void setSyubetsu(String syubetsu) {
        _syubetsu = syubetsu;
    }

    /**
     * �˗��s�ԍ����擾���܂��B
     * @return String �˗��s�ԍ�
     */
    public String getIrrowban() {
        return _irrowban;
    }

    /**
     * �˗��s�ԍ���ݒ肵�܂��B
     * @param syubetsu String �˗��s�ԍ�
     */
    public void setIrrowban(String irrowban) {
    	_irrowban = irrowban;
    }
}
