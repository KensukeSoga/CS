package jp.co.isid.kkh.customer.lion.model.report;

import java.io.Serializable;

/**
 * <P>
 * ���C�I��FD�o�̓f�[�^�擾����
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FDLionCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId;

    /** �c�Ə��i��j�R�[�h(�K�{) */
    private String _egCd;

    /** ���Ӑ��ƃR�[�h(�K�{) */
    private String _tksKgyCd;

    /** ���Ӑ敔��SEQNO(�K�{) */
    private String _bmncd;

    /** ���Ӑ�S��SEQNO(�K�{) */
    private String _tntcd;

    /** �N�� */
    private String _ym;

    /** �敪 */
    private String _kbn;

    /**
     * ���O�C���S����ESQID���擾����
     * @return ���O�C���S����ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ���O�C���S����ESQID��ݒ肷��
     * @param val String ���O�C���S����ESQID
     */
    public void setEsqId(String val) {
        _esqId = val;
    }

    /**
     * �c�Ə��R�[�h���擾����
     * @return �c�Ə��R�[�h
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * �c�Ə��R�[�h���擾����
     * @param val String �c�Ə��R�[�h
     */
    public void setEgCd(String val) {
        _egCd = val;
    }

    /**
     * ���Ӑ��ƃR�[�h���擾����
     * @return ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷�遏
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        _tksKgyCd = val;
    }

    /**
     * ���Ӑ敔��SEQNO���擾����
     * @return ���Ӑ敔��R�[�h
     */
    public String getBmncd() {
        return _bmncd;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setBmncd(String val) {
        _bmncd = val;
    }

    /**
     * ���Ӑ�S��SEQNO���擾����
     * @return ���Ӑ�S��SEQNO
     */
    public String getTntcd() {
        return _tntcd;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTntcd(String val) {
        _tntcd = val;
    }

    /**
     * �N�����擾����
     * @return �N��
     */
    public String getYM() {
        return _ym;
    }

    /**
     * �N����ݒ肷��
     * @param val String �N��
     */
    public void setYM(String val) {
        _ym = val;
    }

    /**
     * �敪���擾����
     * @return �敪
     */
    public String getKbn() {
        return _kbn;
    }

    /**
     * �敪��ݒ肷��
     * @param val String �敪
     */
    public void setKbn(String val) {
        _kbn = val;
    }

}
