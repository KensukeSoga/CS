package jp.co.isid.kkh.customer.epson.model.detail;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
import jp.co.isid.nj.model.AbstractModel;

@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class Thb14skdownVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public Thb14skdownVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new Thb14skdownVO();
    }

    /**
     * �^�C���X�^���v��ݒ肵�܂��B
     * @param val Date �^�C���X�^���v
     */
    public void setHb14TimStmp(Date val) {
        set(TBTHB14SKDOWN.TIMSTMP, val);
    }

    /**
     * �^�C���X�^���v��Ԃ��܂��B
     * @return Date �^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getHb14TimStmp() {
        return (Date) get(TBTHB14SKDOWN.TIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setHb14UpdApl(String val) {
        set(TBTHB14SKDOWN.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getHb14UpdApl() {
        return (String) get(TBTHB14SKDOWN.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setHb14UpdTnt(String val) {
        set(TBTHB14SKDOWN.UPDTNT, val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getHb14UpdTnt() {
        return (String) get(TBTHB14SKDOWN.UPDTNT);
    }

    /**
     * �����w�b�_�ŏI�X�V������ݒ肵�܂��B
     * @param val String �����w�b�_�ŏI�X�V����
     */
    public void setHb14Seihupdtimstmp(String val) {
        set(TBTHB14SKDOWN.SEIHUPDTIMSTMP, val);
    }

    /**
     * �����w�b�_�ŏI�X�V������Ԃ��܂��B
     * @return String �����w�b�_�ŏI�X�V����
     */
    public String getHb14Seihupdtimstmp() {
        return (String) get(TBTHB14SKDOWN.SEIHUPDTIMSTMP);
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setHb14EgCd(String val) {
        set(TBTHB14SKDOWN.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getHb14EgCd() {
        return (String) get(TBTHB14SKDOWN.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setHb14TksKgyCd(String val) {
        set(TBTHB14SKDOWN.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getHb14TksKgyCd() {
        return (String) get(TBTHB14SKDOWN.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setHb14TksBmnSeqNo(String val) {
        set(TBTHB14SKDOWN.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getHb14TksBmnSeqNo() {
        return (String) get(TBTHB14SKDOWN.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setHb14TksTntSeqNo(String val) {
        set(TBTHB14SKDOWN.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getHb14TksTntSeqNo() {
        return (String) get(TBTHB14SKDOWN.TKSTNTSEQNO);
    }

    /**
     * ����NO��ݒ肵�܂��B
     * @param val String ����NO
     */
    public void setHb14Seino(String val) {
        set(TBTHB14SKDOWN.SEINO, val);
    }

    /**
     * ����NO��Ԃ��܂��B
     * @return String ����NO
     */
    public String getHb14Seino() {
        return (String) get(TBTHB14SKDOWN.SEINO);
    }

    /**
     * �����X�e�[�^�X��ݒ肵�܂��B
     * @param val String �����X�e�[�^�X
     */
    public void setHb14Seistatus(String val) {
        set(TBTHB14SKDOWN.SEISTATUS, val);
    }

    /**
     * �����X�e�[�^�X��Ԃ��܂��B
     * @return String �����X�e�[�^�X
     */
    public String getHb14Seistatus() {
        return (String) get(TBTHB14SKDOWN.SEISTATUS);
    }

    /**
     * �����f�[�^��ʂ�ݒ肵�܂��B
     * @param val String �����f�[�^���
     */
    public void setHb14Seisybt(String val) {
        set(TBTHB14SKDOWN.SEISYBT, val);
    }

    /**
     * �����f�[�^��ʂ�Ԃ��܂��B
     * @return String �����f�[�^���
     */
    public String getHb14Seisybt() {
        return (String) get(TBTHB14SKDOWN.SEISYBT);
    }

    /**
     * �������ʉ݃R�[�h��ݒ肵�܂��B
     * @param val String �������ʉ݃R�[�h
     */
    public void setHb14Seitsukacd(String val) {
        set(TBTHB14SKDOWN.SEITSUKACD, val);
    }

    /**
     * �������ʉ݃R�[�h��Ԃ��܂��B
     * @return String �������ʉ݃R�[�h
     */
    public String getHb14Seitsukacd() {
        return (String) get(TBTHB14SKDOWN.SEITSUKACD);
    }

    /**
     * �����z���v��ݒ肵�܂��B
     * @param val BigDecimal �����z���v
     */
    public void setHb14Seigakgk(BigDecimal val) {
        set(TBTHB14SKDOWN.SEIGAKGK, val);
    }

    /**
     * �����z���v��Ԃ��܂��B
     * @return BigDecimal �����z���v
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Seigakgk() {
        return (BigDecimal) get(TBTHB14SKDOWN.SEIGAKGK);
    }

    /**
     * �������旿�����v��ݒ肵�܂��B
     * @param val BigDecimal �������旿�����v
     */
    public void setHb14Torigakgk(BigDecimal val) {
        set(TBTHB14SKDOWN.TORIGAKGK, val);
    }

    /**
     * �������旿�����v��Ԃ��܂��B
     * @return BigDecimal �������旿�����v
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Torigakgk() {
        return (BigDecimal) get(TBTHB14SKDOWN.TORIGAKGK);
    }

    /**
     * �������l���z���v��ݒ肵�܂��B
     * @param val BigDecimal �������l���z���v
     */
    public void setHb14Nebigakgk(BigDecimal val) {
        set(TBTHB14SKDOWN.NEBIGAKGK, val);
    }

    /**
     * �������l���z���v��Ԃ��܂��B
     * @return BigDecimal �������l���z���v
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Nebigakgk() {
        return (BigDecimal) get(TBTHB14SKDOWN.NEBIGAKGK);
    }

    /**
     * ����������Ŋz���v��ݒ肵�܂��B
     * @param val BigDecimal ����������Ŋz���v
     */
    public void setHb14Szeigakgk(BigDecimal val) {
        set(TBTHB14SKDOWN.SZEIGAKGK, val);
    }

    /**
     * ����������Ŋz���v��Ԃ��܂��B
     * @return BigDecimal ����������Ŋz���v
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Szeigakgk() {
        return (BigDecimal) get(TBTHB14SKDOWN.SZEIGAKGK);
    }

    /**
     * �O��U�֊z��ݒ肵�܂��B
     * @param val BigDecimal �O��U�֊z
     */
    public void setHb14Maefurigak(BigDecimal val) {
        set(TBTHB14SKDOWN.MAEFURIGAK, val);
    }

    /**
     * �O��U�֊z��Ԃ��܂��B
     * @return BigDecimal �O��U�֊z
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Maefurigak() {
        return (BigDecimal) get(TBTHB14SKDOWN.MAEFURIGAK);
    }

    /**
     * �O��U�֏���ł�ݒ肵�܂��B
     * @param val BigDecimal �O��U�֏����
     */
    public void setHb14Maefuriszeigak(BigDecimal val) {
        set(TBTHB14SKDOWN.MAEFURISZEIGAK, val);
    }

    /**
     * �O��U�֏���ł�Ԃ��܂��B
     * @return BigDecimal �O��U�֏����
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Maefuriszeigak() {
        return (BigDecimal) get(TBTHB14SKDOWN.MAEFURISZEIGAK);
    }

    /**
     * ����X�e�[�^�X��ݒ肵�܂��B
     * @param val String ����X�e�[�^�X
     */
    public void setHb14Kaistatus(String val) {
        set(TBTHB14SKDOWN.KAISTATUS, val);
    }

    /**
     * ����X�e�[�^�X��Ԃ��܂��B
     * @return String ����X�e�[�^�X
     */
    public String getHb14Kaistatus() {
        return (String) get(TBTHB14SKDOWN.KAISTATUS);
    }

    /**
     * �ŏI�����N������ݒ肵�܂��B
     * @param val String �ŏI�����N����
     */
    public void setHb14Keshidate(String val) {
        set(TBTHB14SKDOWN.KESHIDATE, val);
    }

    /**
     * �ŏI�����N������Ԃ��܂��B
     * @return String �ŏI�����N����
     */
    public String getHb14Keshidate() {
        return (String) get(TBTHB14SKDOWN.KESHIDATE);
    }

    /**
     * ����z��ݒ肵�܂��B
     * @param val BigDecimal ����z
     */
    public void setHb14Kaigak(BigDecimal val) {
        set(TBTHB14SKDOWN.KAIGAK, val);
    }

    /**
     * ����z��Ԃ��܂��B
     * @return BigDecimal ����z
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Kaigak() {
        return (BigDecimal) get(TBTHB14SKDOWN.KAIGAK);
    }

    /**
     * ����c�Ə��R�[�h��ݒ肵�܂��B
     * @param val String ����c�Ə��R�[�h
     */
    public void setHb14Kaiegcd(String val) {
        set(TBTHB14SKDOWN.KAIEGCD, val);
    }

    /**
     * ����c�Ə��R�[�h��Ԃ��܂��B
     * @return String ����c�Ə��R�[�h
     */
    public String getHb14Kaiegcd() {
        return (String) get(TBTHB14SKDOWN.KAIEGCD);
    }

    /**
     * ��������̔��s����ݒ肵�܂��B
     * @param val String ��������̔��s��
     */
    public void setHb14Seihakdate(String val) {
        set(TBTHB14SKDOWN.SEIHAKDATE, val);
    }

    /**
     * ��������̔��s����Ԃ��܂��B
     * @return String ��������̔��s��
     */
    public String getHb14Seihakdate() {
        return (String) get(TBTHB14SKDOWN.SEIHAKDATE);
    }

    /**
     * �������o�͔N������ݒ肵�܂��B
     * @param val String �������o�͔N����
     */
    public void setHb14Seisyudate(String val) {
        set(TBTHB14SKDOWN.SEISYUDATE, val);
    }

    /**
     * �������o�͔N������Ԃ��܂��B
     * @return String �������o�͔N����
     */
    public String getHb14Seisyudate() {
        return (String) get(TBTHB14SKDOWN.SEISYUDATE);
    }

    /**
     * �������ďo�͔N������ݒ肵�܂��B
     * @param val String �������ďo�͔N����
     */
    public void setHb14Seisaisyudate(String val) {
        set(TBTHB14SKDOWN.SEISAISYUDATE, val);
    }

    /**
     * �������ďo�͔N������Ԃ��܂��B
     * @return String �������ďo�͔N����
     */
    public String getHb14Seisaisyudate() {
        return (String) get(TBTHB14SKDOWN.SEISAISYUDATE);
    }

    /**
     * �Ĕ��s�񐔂�ݒ肵�܂��B
     * @param val BigDecimal �Ĕ��s��
     */
    public void setHb14Saihakcnt(BigDecimal val) {
        set(TBTHB14SKDOWN.SAIHAKCNT, val);
    }

    /**
     * �Ĕ��s�񐔂�Ԃ��܂��B
     * @return BigDecimal �Ĕ��s��
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Saihakcnt() {
        return (BigDecimal) get(TBTHB14SKDOWN.SAIHAKCNT);
    }

    /**
     * ����������N������ݒ肵�܂��B
     * @param val String ����������N����
     */
    public void setHb14Seitoridate(String val) {
        set(TBTHB14SKDOWN.SEITORIDATE, val);
    }

    /**
     * ����������N������Ԃ��܂��B
     * @return String ����������N����
     */
    public String getHb14Seitoridate() {
        return (String) get(TBTHB14SKDOWN.SEITORIDATE);
    }

    /**
     * �����N����ݒ肵�܂��B
     * @param val String �����N��
     */
    public void setHb14Seiyymm(String val) {
        set(TBTHB14SKDOWN.SEIYYMM, val);
    }

    /**
     * �����N����Ԃ��܂��B
     * @return String �����N��
     */
    public String getHb14Seiyymm() {
        return (String) get(TBTHB14SKDOWN.SEIYYMM);
    }

    /**
     * �������ƃR�[�h��ݒ肵�܂��B
     * @param val String �������ƃR�[�h
     */
    public void setHb14Nyukgycd(String val) {
        set(TBTHB14SKDOWN.NYUKGYCD, val);
    }

    /**
     * �������ƃR�[�h��Ԃ��܂��B
     * @return String �������ƃR�[�h
     */
    public String getHb14Nyukgycd() {
        return (String) get(TBTHB14SKDOWN.NYUKGYCD);
    }

    /**
     * �������ƃR�[�h��ݒ肵�܂��B
     * @param val String �������ƃR�[�h
     */
    public void setHb14Seikgycd(String val) {
        set(TBTHB14SKDOWN.SEIKGYCD, val);
    }

    /**
     * �������ƃR�[�h��Ԃ��܂��B
     * @return String �������ƃR�[�h
     */
    public String getHb14Seikgycd() {
        return (String) get(TBTHB14SKDOWN.SEIKGYCD);
    }

    /**
     * �����敔��SEQNO���擾����
     * @return �����敔��SEQNO
     */
    public String getHb14Seibmnseqno() {
        return (String) get(TBTHB14SKDOWN.SEIBMNSEQNO);
    }

    /**
     * �����敔��SEQNO��ݒ肷��
     * @param val �����敔��SEQNO
     */
    public void setHb14Seibmnseqno(String val) {
        set(TBTHB14SKDOWN.SEIBMNSEQNO, val);
    }

    /**
     * ������S��SEQNO���擾����
     * @return ������S��SEQNO
     */
    public String getHb14Seitntseqno() {
        return (String) get(TBTHB14SKDOWN.SEITNTSEQNO);
    }

    /**
     * ������S��SEQNO��ݒ肷��
     * @param val ������S��SEQNO
     */
    public void setHb14Seitntseqno(String val) {
        set(TBTHB14SKDOWN.SEITNTSEQNO, val);
    }

    /**
     * �����於�́i��j���擾����
     * @return �����於�́i��j
     */
    public String getHb14Seinameup() {
        return (String) get(TBTHB14SKDOWN.SEINAMEUP);
    }

    /**
     * �����於�́i��j��ݒ肷��
     * @param val �����於�́i��j
     */
    public void setHb14Seinameup(String val) {
        set(TBTHB14SKDOWN.SEINAMEUP, val);
    }

    /**
     * �����於�́i���j���擾����
     * @return �����於�́i���j
     */
    public String getHb14Seinamedown() {
        return (String) get(TBTHB14SKDOWN.SEINAMEDOWN);
    }

    /**
     * �����於�́i���j��ݒ肷��
     * @param val �����於�́i���j
     */
    public void setHb14Seinamedown(String val) {
        set(TBTHB14SKDOWN.SEINAMEDOWN, val);
    }

    /**
     * �����敔�喼�̂��擾����
     * @return �����敔�喼��
     */
    public String getHb14Seibmnname() {
        return (String) get(TBTHB14SKDOWN.SEIBMNNAME);
    }

    /**
     * �����敔�喼�̂�ݒ肷��
     * @param val �����敔�喼��
     */
    public void setHb14Seibmnname(String val) {
        set(TBTHB14SKDOWN.SEIBMNNAME, val);
    }

    /**
     * �c�Ƌǖ����擾����
     * @return �c�Ƌǖ�
     */
    public String getHb14Egkyoname() {
        return (String) get(TBTHB14SKDOWN.EGKYONAME);
    }

    /**
     * �c�Ƌǖ���ݒ肷��
     * @param val �c�Ƌǖ�
     */
    public void setHb14Egkyoname(String val) {
        set(TBTHB14SKDOWN.EGKYONAME, val);
    }

    /**
     * �c�ƒS���҃R�[�h���擾����
     * @return �c�ƒS���҃R�[�h
     */
    public String getHb14Egtntcd() {
        return (String) get(TBTHB14SKDOWN.EGTNTCD);
    }

    /**
     * �c�ƒS���҃R�[�h��ݒ肷��
     * @param val �c�ƒS���҃R�[�h
     */
    public void setHb14Egtntcd(String val) {
        set(TBTHB14SKDOWN.EGTNTCD, val);
    }

    /**
     * �c�ƒS���Җ����擾����
     * @return �c�ƒS���Җ�
     */
    public String getHb14Egtntname() {
        return (String) get(TBTHB14SKDOWN.EGTNTNAME);
    }

    /**
     * �c�ƒS���Җ���ݒ肷��
     * @param val �c�ƒS���Җ�
     */
    public void setHb14Egtntname(String val) {
        set(TBTHB14SKDOWN.EGTNTNAME, val);
    }

    /**
     * �����S���҃R�[�h���擾����
     * @return �����S���҃R�[�h
     */
    public String getHb14Seitntcd() {
        return (String) get(TBTHB14SKDOWN.SEITNTCD);
    }

    /**
     * �����S���҃R�[�h��ݒ肷��
     * @param val �����S���҃R�[�h
     */
    public void setHb14Seitntcd(String val) {
        set(TBTHB14SKDOWN.SEITNTCD, val);
    }

    /**
     * �����S���Җ����擾����
     * @return �����S���Җ�
     */
    public String getHb14Seitntname() {
        return (String) get(TBTHB14SKDOWN.SEITNTNAME);
    }

    /**
     * �����S���Җ���ݒ肷��
     * @param val �����S���Җ�
     */
    public void setHb14Seitntname(String val) {
        set(TBTHB14SKDOWN.SEITNTNAME, val);
    }

    /**
     * ����w�萿��NO���擾����
     * @return ����w�萿��NO
     */
    public String getHb14Senseino() {
        return (String) get(TBTHB14SKDOWN.SENSEINO);
    }

    /**
     * ����w�萿��NO��ݒ肷��
     * @param val ����w�萿��NO
     */
    public void setHb14Senseino(String val) {
        set(TBTHB14SKDOWN.SENSEINO, val);
    }

    /**
     * �����w�b�_�}�̖����擾����
     * @return �����w�b�_�}�̖�
     */
    public String getHb14Seibainame() {
        return (String) get(TBTHB14SKDOWN.SEIBAINAME);
    }

    /**
     * �����w�b�_�}�̖���ݒ肷��
     * @param val �����w�b�_�}�̖�
     */
    public void setHb14Seibainame(String val) {
        set(TBTHB14SKDOWN.SEIBAINAME, val);
    }

    /**
     * ���������\����N�������擾����
     * @return ���������\����N����
     */
    public String getHb14Seihyodate() {
        return (String) get(TBTHB14SKDOWN.SEIHYODATE);
    }

    /**
     * ���������\����N������ݒ肷��
     * @param val ���������\����N����
     */
    public void setHb14Seihyodate(String val) {
        set(TBTHB14SKDOWN.SEIHYODATE, val);
    }

    /**
     * �L�������i�����j�i��j���擾����
     * @return �L�������i�����j�i��j
     */
    public String getHb14Kounameup() {
        return (String) get(TBTHB14SKDOWN.KOUNAMEUP);
    }

    /**
     * �L�������i�����j�i��j��ݒ肷��
     * @param val �L�������i�����j�i��j
     */
    public void setHb14Kounameup(String val) {
        set(TBTHB14SKDOWN.KOUNAMEUP, val);
    }

    /**
     * �L�������i�����j�i���j���擾����
     * @return �L�������i�����j�i���j
     */
    public String getHb14Kounamedown() {
        return (String) get(TBTHB14SKDOWN.KOUNAMEDOWN);
    }

    /**
     * �L�������i�����j�i���j��ݒ肷��
     * @param val �L�������i�����j�i���j
     */
    public void setHb14Kounamedown(String val) {
        set(TBTHB14SKDOWN.KOUNAMEDOWN, val);
    }

    /**
     * �U�փX�e�[�^�X���擾����
     * @return �U�փX�e�[�^�X
     */
    public String getHb14Furistatus() {
        return (String) get(TBTHB14SKDOWN.FURISTATUS);
    }

    /**
     * �U�փX�e�[�^�X��ݒ肷��
     * @param val �U�փX�e�[�^�X
     */
    public void setHb14Furistatus(String val) {
        set(TBTHB14SKDOWN.FURISTATUS, val);
    }

    /**
     * ��������SEQ���擾����
     * @return ��������SEQ
     */
    public String getHb14Seimeino() {
        return (String) get(TBTHB14SKDOWN.SEIMEINO);
    }

    /**
     * ��������SEQ��ݒ肷��
     * @param val ��������SEQ
     */
    public void setHb14Seimeino(String val) {
        set(TBTHB14SKDOWN.SEIMEINO, val);
    }

    /**
     * �c�Ə��R�[�h�i���j���擾����
     * @return �c�Ə��R�[�h�i���j
     */
    public String getHb14Atuegcd() {
        return (String) get(TBTHB14SKDOWN.ATUEGCD);
    }

    /**
     * �c�Ə��R�[�h�i���j��ݒ肷��
     * @param val �c�Ə��R�[�h�i���j
     */
    public void setHb14Atuegcd(String val) {
        set(TBTHB14SKDOWN.ATUEGCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h�i���j���擾����
     * @return ���Ӑ��ƃR�[�h�i���j
     */
    public String getHb14Atutkskgycd() {
        return (String) get(TBTHB14SKDOWN.ATUTKSKGYCD);
    }

    /**
     * ���Ӑ��ƃR�[�h�i���j��ݒ肷��
     * @param val ���Ӑ��ƃR�[�h�i���j
     */
    public void setHb14Atutkskgycd(String val) {
        set(TBTHB14SKDOWN.ATUTKSKGYCD, val);
    }

    /**
     * ���Ӑ敔��SEQNO�i���j���擾����
     * @return ���Ӑ敔��SEQNO�i���j
     */
    public String getHb14Atutksbmnseqno() {
        return (String) get(TBTHB14SKDOWN.ATUTKSBMNSEQNO);
    }

    /**
     * ���Ӑ敔��SEQNO�i���j��ݒ肷��
     * @param val ���Ӑ敔��SEQNO�i���j
     */
    public void setHb14Atutksbmnseqno(String val) {
        set(TBTHB14SKDOWN.ATUTKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO�i���j���擾����
     * @return ���Ӑ�S��SEQNO�i���j
     */
    public String getHb14Atutkstntseqno() {
        return (String) get(TBTHB14SKDOWN.ATUTKSTNTSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO�i���j��ݒ肷��
     * @param val ���Ӑ�S��SEQNO�i���j
     */
    public void setHb14Atutkstntseqno(String val) {
        set(TBTHB14SKDOWN.ATUTKSTNTSEQNO, val);
    }

    /**
     * ��NO���擾����
     * @return ��NO
     */
    public String getHb14Jyutno() {
        return (String) get(TBTHB14SKDOWN.JYUTNO);
    }

    /**
     * ��NO��ݒ肷��
     * @param val ��NO
     */
    public void setHb14Jyutno(String val) {
        set(TBTHB14SKDOWN.JYUTNO, val);
    }

    /**
     * �󒍖���NO���擾����
     * @return �󒍖���NO
     */
    public String getHb14Jymeino() {
        return (String) get(TBTHB14SKDOWN.JYMEINO);
    }

    /**
     * �󒍖���NO��ݒ肷��
     * @param val �󒍖���NO
     */
    public void setHb14Jymeino(String val) {
        set(TBTHB14SKDOWN.JYMEINO, val);
    }

    /**
     * ���㖾��NO���擾����
     * @return ���㖾��NO
     */
    public String getHb14Urmeino() {
        return (String) get(TBTHB14SKDOWN.URMEINO);
    }

    /**
     * ���㖾��NO��ݒ肷��
     * @param val ���㖾��NO
     */
    public void setHb14Urmeino(String val) {
        set(TBTHB14SKDOWN.URMEINO, val);
    }

    /**
     * �������[NO���擾����
     * @return �������[NO
     */
    public String getHb14Gpyno() {
        return (String) get(TBTHB14SKDOWN.GPYNO);
    }

    /**
     * �������[NO��ݒ肷��
     * @param val �������[NO
     */
    public void setHb14Gpyno(String val) {
        set(TBTHB14SKDOWN.GPYNO, val);
    }

    /**
     * �󒍒ʉ݃R�[�h���擾����
     * @return �󒍒ʉ݃R�[�h
     */
    public String getHb14Jytsukacd() {
        return (String) get(TBTHB14SKDOWN.JYTSUKACD);
    }

    /**
     * �󒍒ʉ݃R�[�h��ݒ肷��
     * @param val �󒍒ʉ݃R�[�h
     */
    public void setHb14Jytsukacd(String val) {
        set(TBTHB14SKDOWN.JYTSUKACD, val);
    }

    /**
     * ���������Z���[�g���擾����
     * @return ���������Z���[�g
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Seikanrate() {
        return (BigDecimal) get(TBTHB14SKDOWN.SEIKANRATE);
    }

    /**
     * ���������Z���[�g��ݒ肷��
     * @param val ���������Z���[�g
     */
    public void setHb14Seikanrate(BigDecimal val) {
        set(TBTHB14SKDOWN.SEIKANRATE, val);
    }

    /**
     * ���[�g�^�C�v���擾����
     * @return ���[�g�^�C�v
     */
    public String getHb14Ratetype() {
        return (String) get(TBTHB14SKDOWN.RATETYPE);
    }

    /**
     * ���[�g�^�C�v��ݒ肷��
     * @param val ���[�g�^�C�v
     */
    public void setHb14Ratetype(String val) {
        set(TBTHB14SKDOWN.RATETYPE, val);
    }

    /**
     * ���������Z�N�������擾����
     * @return ���������Z�N����
     */
    public String getHb14Seikandate() {
        return (String) get(TBTHB14SKDOWN.SEIKANDATE);
    }

    /**
     * ���������Z�N������ݒ肷��
     * @param val ���������Z�N����
     */
    public void setHb14Seikandate(String val) {
        set(TBTHB14SKDOWN.SEIKANDATE, val);
    }

    /**
     * �����旿���i�󒍒ʉ݁j���擾����
     * @return �����旿���i�󒍒ʉ݁j
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Torigakjy() {
        return (BigDecimal) get(TBTHB14SKDOWN.TORIGAKJY);
    }

    /**
     * �����旿���i�󒍒ʉ݁j��ݒ肷��
     * @param val �����旿���i�󒍒ʉ݁j
     */
    public void setHb14Torigakjy(BigDecimal val) {
        set(TBTHB14SKDOWN.TORIGAKJY, val);
    }

    /**
     * �����旿���i�~�݁j���擾����
     * @return �����旿���i�~�݁j
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Torigaken() {
        return (BigDecimal) get(TBTHB14SKDOWN.TORIGAKEN);
    }

    /**
     * �����旿���i�~�݁j��ݒ肷��
     * @param val �����旿���i�~�݁j
     */
    public void setHb14Torigaken(BigDecimal val) {
        set(TBTHB14SKDOWN.TORIGAKEN, val);
    }

    /**
     * �����l���z�i�󒍒ʉ݁j���擾����
     * @return �����l���z�i�󒍒ʉ݁j
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Nebigakjy() {
        return (BigDecimal) get(TBTHB14SKDOWN.NEBIGAKJY);
    }

    /**
     * �����l���z�i�󒍒ʉ݁j��ݒ肷��
     * @param val �����l���z�i�󒍒ʉ݁j
     */
    public void setHb14Nebigakjy(BigDecimal val) {
        set(TBTHB14SKDOWN.NEBIGAKJY, val);
    }

    /**
     * �����l���z�i�~�݁j���擾����
     * @return �����l���z�i�~�݁j
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Nebigaken() {
        return (BigDecimal) get(TBTHB14SKDOWN.NEBIGAKEN);
    }

    /**
     * �����l���z�i�~�݁j��ݒ肷��
     * @param val �����l���z�i�~�݁j
     */
    public void setHb14Nebigaken(BigDecimal val) {
        set(TBTHB14SKDOWN.NEBIGAKEN, val);
    }

    /**
     * ��������Ŋz�i�~�݁j���擾����
     * @return ��������Ŋz�i�~�݁j
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Szeigaken() {
        return (BigDecimal) get(TBTHB14SKDOWN.SZEIGAKEN);
    }

    /**
     * ��������Ŋz�i�~�݁j��ݒ肷��
     * @param val ��������Ŋz�i�~�݁j
     */
    public void setHb14Szeigaken(BigDecimal val) {
        set(TBTHB14SKDOWN.SZEIGAKEN, val);
    }

    /**
     * �U�֔N�������擾����
     * @return �U�֔N����
     */
    public String getHb14Furidate() {
        return (String) get(TBTHB14SKDOWN.FURIDATE);
    }

    /**
     * �U�֔N������ݒ肷��
     * @param val �U�֔N����
     */
    public void setHb14Furidate(String val) {
        set(TBTHB14SKDOWN.FURIDATE, val);
    }

    /**
     * �U�֎���N�������擾����
     * @return �U�֎���N����
     */
    public String getHb14Furitoridate() {
        return (String) get(TBTHB14SKDOWN.FURITORIDATE);
    }

    /**
     * �U�֎���N������ݒ肷��
     * @param val �U�֎���N����
     */
    public void setHb14Furitoridate(String val) {
        set(TBTHB14SKDOWN.FURITORIDATE, val);
    }

    /**
     * ����ŋ敪���擾����
     * @return ����ŋ敪
     */
    public String getHb14Szeikbn() {
        return (String) get(TBTHB14SKDOWN.SZEIKBN);
    }

    /**
     * ����ŋ敪��ݒ肷��
     * @param val ����ŋ敪
     */
    public void setHb14Szeikbn(String val) {
        set(TBTHB14SKDOWN.SZEIKBN, val);
    }

    /**
     * �v��\��N�������擾����
     * @return �v��\��N����
     */
    public String getHb14Keiyodate() {
        return (String) get(TBTHB14SKDOWN.KEIYODATE);
    }

    /**
     * �v��\��N������ݒ肷��
     * @param val �v��\��N����
     */
    public void setHb14Keiyodate(String val) {
        set(TBTHB14SKDOWN.KEIYODATE, val);
    }

    /**
     * �v��N�������擾����
     * @return �v��N����
     */
    public String getHb14Keidate() {
        return (String) get(TBTHB14SKDOWN.KEIDATE);
    }

    /**
     * �v��N������ݒ肷��
     * @param val �v��N����
     */
    public void setHb14Keidate(String val) {
        set(TBTHB14SKDOWN.KEIDATE, val);
    }

    /**
     * �_�E�����[�h�t�@�C���^�C���X�^���v���擾����
     * @return �_�E�����[�h�t�@�C���^�C���X�^���v
     */
    public String getHb14Filetimstmp() {
        return (String) get(TBTHB14SKDOWN.FILETIMSTMP);
    }

    /**
     * �_�E�����[�h�t�@�C���^�C���X�^���v��ݒ肷��
     * @param val �_�E�����[�h�t�@�C���^�C���X�^���v
     */
    public void setHb14Filetimstmp(String val) {
        set(TBTHB14SKDOWN.FILETIMSTMP, val);
    }

    /**
     * �L����ה��f�������擾����
     * @return �L����ה��f����
     */
    public String getHb14Kkhmeitimstmp() {
        return (String) get(TBTHB14SKDOWN.KKHMEITIMSTMP);
    }

    /**
     * �L����ה��f������ݒ肷��
     * @param val �L����ה��f����
     */
    public void setHb14Kkhmeitimstmp(String val) {
        set(TBTHB14SKDOWN.KKHMEITIMSTMP, val);
    }

}
