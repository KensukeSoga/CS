package jp.co.isid.kkh.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <P>
 * Web�T�[�r�X�̏���������ێ����钊�ۃN���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/22 )<BR>
 * </P>
 * @author
 */
@XmlRootElement(namespace = "http://model.kkh.isid.co.jp/")
@XmlType(namespace = "http://model.kkh.isid.co.jp/")
public abstract class AbstractServiceCondition implements Serializable{


    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** ���O�C���S����ESQID */
    private String _esqId;
    /** �c�Ə��i��j�R�[�h */
    private String _egCd;
    /** ���Ӑ��ƃR�[�h */
    private String _tksKgyCd;
    /** ���Ӑ敔��SEQNO */
    private String _tksBmnSeqNo;
    /** ���Ӑ�S��SEQNO */
    private String _tksTntSeqNo;
	/** �N�� */
	private String _ym;

    /**
     * ���O�C���S����ESQID��Ԃ��܂��B
     *
     * @return esqId
     */
    public String getEsqId() {
        return _esqId;
    }
    /**
     * ���O�C���S����ESQID��ݒ肵�܂��B
     *
     * @param esqId
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     *
     * @return egCd
     */
    public String getEgCd() {
        return _egCd;
    }
    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     *
     * @param egCd
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     *
     * @return tksKgyCd
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }
    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     *
     * @param tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     *
     * @return tksBmnSeqNo
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }
    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     *
     * @param tksBmnSeqNo
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     *
     * @return tksTntSeqNo
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }
    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     *
     * * @param tksTntSeqNo
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

	/**
	 * �N����Ԃ��܂��B
	 *
	 * @return ym
	 */
	public String getYm() {
		return _ym;
	}
	/**
	 * �N����ݒ肵�܂��B
	 *
	 * @param ym
	 */
	public void setYm(String ym) {
		this._ym = ym;
	}

}
