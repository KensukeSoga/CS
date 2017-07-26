package jp.co.isid.kkh.customer.lion.model.detail;

import java.io.Serializable;

/**
 * <P>
 * ���C�I��TVSpot�f�[�^�擾����
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/05 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FindLionTVSpotCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId;

    /** �c�Ə��i��j�R�[�h(�K�{) */
    private String _egCd;

    /** ���Ӑ��ƃR�[�h(�K�{) */
    private String _tksKgyCd;

    /** ���Ӑ敔��R�[�h(�K�{) */
    private String _bmncd;

    /** ���Ӑ�S���R�[�h(�K�{) */
    private String _tntcd;

    /** �W���u�ԍ� */
    private String _jobNo;

    /** �N�� */
    private String _ym;

    /**
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * @param esqId
     *            �Z�b�g���� esqId
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * @return egCd
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * @param egCd
     *            �Z�b�g���� egCd
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * @return tksKgyCd
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * @param tksKgyCd
     *            �Z�b�g���� tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * @return egCd
     */
    public String getBmncd() {
        return _bmncd;
    }

    /**
     * @param egCd
     *            �Z�b�g���� egCd
     */
    public void setBmncd(String bmncd) {
        this._bmncd = bmncd;
    }

    /**
     * @return egCd
     */
    public String getTntcd() {
        return _tntcd;
    }

    /**
     * @param egCd
     *            �Z�b�g���� egCd
     */
    public void setTntcd(String tntcd) {
        this._tntcd = tntcd;
    }

    /**
     * @return jobNo
     */
    public String getJobNo() {
        return _jobNo;
    }

    /**
     * @param ym
     *            �Z�b�g���� jobNo
     */
    public void setJobNo(String jobNo) {
        this._jobNo = jobNo;
    }

    /**
     * @return _ym
     */
    public String getYM() {
        return _ym;
    }

    /**
     * @param ym
     *            �Z�b�g���� ym
     */
    public void setYM(String ym) {
        this._ym = ym;
    }

}
