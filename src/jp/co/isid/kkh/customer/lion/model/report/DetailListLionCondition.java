package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class DetailListLionCondition extends AbstractServiceCondition{

    private static final long serialVersionUID = 1L;

    /** �J�n�N�� */
    private String _ymfrom;

    /** �I���N�� */
    private String _ymto;

    /** �}�̋敪 */
    private String _baitaikbn;

    /**
     * @return �J�n�N����Ԃ��܂�
     */
    public String getymto() {
        return _ymto;
    }

    /**
     * @param  �J�n�N�����Z�b�g���܂�
     */
    public void setymto(String ymto) {
        this._ymto = ymto;
    }

    /**
     * @return �I���N����Ԃ��܂�
     */
    public String getymfrom() {
        return _ymfrom;
    }

    /**
     * @param  �I���N�����Z�b�g���܂�
     */
    public void setymfrom(String ymfrom) {
        this._ymfrom = ymfrom;
    }

    /**
     * @return �}�̋敪��Ԃ��܂�
     */
    public String getbaitaikbn() {
        return _baitaikbn;
    }

    /**
     * @param  �}�̋敪���Z�b�g���܂�
     */
    public void setbaitaikbn(String baitaikbn) {
        this._baitaikbn = baitaikbn;
    }

}
