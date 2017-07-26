package jp.co.isid.kkh.model.detail;

import jp.co.isid.kkh.integ.tbl.VWTHB_ADMURIAGEM;
import jp.co.isid.nj.model.AbstractModel;

public class ThbAdmUriagemVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ThbAdmUriagemVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ThbAdmUriagemVO();
    }

    /**
     * RESULTKEY��Ԃ��܂��B
     * @return RESULTKEY
     */
    public String getResultKey() {
        return (String) get("RESULTKEY");
    }

    /**
     * RESULTKEY��ݒ肵�܂��B
     * @param val RESULTKEY
     */
    public void setResultKey(String val) {
        set("RESULTKEY", val);
    }

    /**
     * ������Ԃ��擾����
     * @return �������
     */
    public String getSeikJtai() {
        return (String) get(VWTHB_ADMURIAGEM.SEIKJTAI);
    }

    /**
     * ������Ԃ�ݒ肷��
     * @param val �������
     */
    public void setSeikJtai(String val) {
        set(VWTHB_ADMURIAGEM.SEIKJTAI, val);
    }

    /**
     * ������ƃX�e�[�^�X���擾����
     * @return ������ƃX�e�[�^�X
     */
    public String getSeiSagSts() {
        return (String) get(VWTHB_ADMURIAGEM.SEISAGSTS);
    }

    /**
     * ������ƃX�e�[�^�X��ݒ肷��
     * @param val ������ƃX�e�[�^�X
     */
    public void setSeiSagSts(String val) {
        set(VWTHB_ADMURIAGEM.SEISAGSTS, val);
    }

    /**
     * ���~�敪���擾����
     * @return ���~�敪
     */
    public String getStpKbn() {
        return (String) get(VWTHB_ADMURIAGEM.STPKBN);
    }

    /**
     * ���~�敪��ݒ肷��
     * @param val ���~�敪
     */
    public void setStpKbn(String val) {
        set(VWTHB_ADMURIAGEM.STPKBN, val);
    }

}
