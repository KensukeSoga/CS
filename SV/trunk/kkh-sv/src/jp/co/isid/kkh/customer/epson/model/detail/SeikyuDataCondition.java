package jp.co.isid.kkh.customer.epson.model.detail;

import java.io.Serializable;

/**
*
* <P>
* ��������f�[�^����(Epson)SeikyuCondition
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2012/04/23 JSE.Yuguchi)<BR>
* </P>
* @author
*/

public class SeikyuDataCondition implements Serializable {

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
    /** �N��*/
    private String _yymm;

    /**
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * @param esqId �Z�b�g���� esqId
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
     * @param egCd �Z�b�g���� egCd
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
     * @param tksKgyCd �Z�b�g���� tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * @return bmncd
     */
    public String getBmncd() {
        return _bmncd;
    }

    /**
     * @param bmncd �Z�b�g���� bmncd
     */
    public void setBmncd(String bmncd) {
        this._bmncd = bmncd;
    }

    /**
     * @return tntcd
     */
    public String getTntcd() {
        return _tntcd;
    }

    /**
     * @param tntcd �Z�b�g���� tntcd
     */
    public void setTntcd(String tntcd) {
        this._tntcd = tntcd;
    }

    /**
     * @return Yymm
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * @param Yymm �Z�b�g���� Yymm
     */
    public void setYymm(String yymm) {
        this._yymm = yymm;
    }

}
