package jp.co.isid.kkh.model.detail;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHB8DOWNR;
import jp.co.isid.nj.model.AbstractModel;

@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class Thb8DownRVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public Thb8DownRVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new Thb8DownRVO();
    }

    /**
     * �^�C���X�^���v��ݒ肵�܂��B
     * @param val Date �^�C���X�^���v
     */
    public void setHb8TimStmp(Date val) {
        set(TBTHB8DOWNR.TIMSTMP, val);
    }

    /**
     * �^�C���X�^���v��Ԃ��܂��B
     * @return Date �^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getHb8TimStmp() {
        return (Date) get(TBTHB8DOWNR.TIMSTMP);
    }

//    /**
//     * �^�C���X�^���v��ݒ肵�܂��B
//     * @param val Date �^�C���X�^���v
//     */
//    public void setHb8TimStmp(String val) {
//        set(TBTHB8DOWNR.TIMSTMP, val);
//    }
//
//    /**
//     * �^�C���X�^���v��Ԃ��܂��B
//     * @return Date �^�C���X�^���v
//     */
//    public String getHb8TimStmp() {
//        return (String) get(TBTHB8DOWNR.TIMSTMP);
//    }

     /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setHb8UpdApl(String val) {
        set(TBTHB8DOWNR.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getHb8UpdApl() {
        return (String) get(TBTHB8DOWNR.UPDAPL);
    }

     /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setHb8UpdTnt(String val) {
        set(TBTHB8DOWNR.UPDTNT, val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getHb8UpdTnt() {
        return (String) get(TBTHB8DOWNR.UPDTNT);
    }

     /**
     * �c�Ə��i���j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i���j�R�[�h
     */
    public void setHb8AtuEgCd(String val) {
        set(TBTHB8DOWNR.ATUEGCD, val);
    }

    /**
     * �c�Ə��i���j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i���j�R�[�h
     */
    public String getHb8AtuEgCd() {
        return (String) get(TBTHB8DOWNR.ATUEGCD);
    }

     /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setHb8EgCd(String val) {
        set(TBTHB8DOWNR.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getHb8EgCd() {
        return (String) get(TBTHB8DOWNR.EGCD);
    }

     /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setHb8TksKgyCd(String val) {
        set(TBTHB8DOWNR.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getHb8TksKgyCd() {
        return (String) get(TBTHB8DOWNR.TKSKGYCD);
    }

     /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setHb8TksBmnSeqNo(String val) {
        set(TBTHB8DOWNR.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getHb8TksBmnSeqNo() {
        return (String) get(TBTHB8DOWNR.TKSBMNSEQNO);
    }

     /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setHb8TksTntSeqNo(String val) {
        set(TBTHB8DOWNR.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getHb8TksTntSeqNo() {
        return (String) get(TBTHB8DOWNR.TKSTNTSEQNO);
    }

     /**
     * ��No��ݒ肵�܂��B
     * @param val String ��No
     */
    public void setHb8JyutNo(String val) {
        set(TBTHB8DOWNR.JYUTNO, val);
    }

    /**
     * ��No��Ԃ��܂��B
     * @return String ��No
     */
    public String getHb8JyutNo() {
        return (String) get(TBTHB8DOWNR.JYUTNO);
    }

     /**
     * �󒍖���No��ݒ肵�܂��B
     * @param val String �󒍖���No
     */
    public void setHb8JyMeiNo(String val) {
        set(TBTHB8DOWNR.JYMEINO, val);
    }

    /**
     * �󒍖���No��Ԃ��܂��B
     * @return String �󒍖���No
     */
    public String getHb8JyMeiNo() {
        return (String) get(TBTHB8DOWNR.JYMEINO);
    }

     /**
     * ���㖾��No��ݒ肵�܂��B
     * @param val String ���㖾��No
     */
    public void setHb8UrMeiNo(String val) {
        set(TBTHB8DOWNR.URMEINO, val);
    }

    /**
     * ���㖾��No��Ԃ��܂��B
     * @return String ���㖾��No
     */
    public String getHb8UrMeiNo() {
        return (String) get(TBTHB8DOWNR.URMEINO);
    }

     /**
     * �������[No��ݒ肵�܂��B
     * @param val String �������[No
     */
    public void setHb8GpyNo(String val) {
        set(TBTHB8DOWNR.GPYNO, val);
    }

    /**
     * �������[No��Ԃ��܂��B
     * @return String �������[No
     */
    public String getHb8GpyNo() {
        return (String) get(TBTHB8DOWNR.GPYNO);
    }

     /**
     * �y�[�WNo��ݒ肵�܂��B
     * @param val String �y�[�WNo
     */
    public void setHb8GpyoPag(String val) {
        set(TBTHB8DOWNR.GPYOPAG, val);
    }

    /**
     * �y�[�WNo��Ԃ��܂��B
     * @return String �y�[�WNo
     */
    public String getHb8GpyoPag() {
        return (String) get(TBTHB8DOWNR.GPYOPAG);
    }

     /**
     * ����No��ݒ肵�܂��B
     * @param val String ����No
     */
    public void setHb8SeiNo(String val) {
        set(TBTHB8DOWNR.SEINO, val);
    }

    /**
     * ����No��Ԃ��܂��B
     * @return String ����No
     */
    public String getHb8SeiNo() {
        return (String) get(TBTHB8DOWNR.SEINO);
    }

     /**
     * ��ڃR�[�h��ݒ肵�܂��B
     * @param val String ��ڃR�[�h
     */
    public void setHb8HimkCd(String val) {
        set(TBTHB8DOWNR.HIMKCD, val);
    }

    /**
     * ��ڃR�[�h��Ԃ��܂��B
     * @return String ��ڃR�[�h
     */
    public String getHb8HimkCd() {
        return (String) get(TBTHB8DOWNR.HIMKCD);
    }

     /**
     * �����t���O��ݒ肵�܂��B
     * @param val String �����t���O
     */
    public void setHb8TouFlg(String val) {
        set(TBTHB8DOWNR.TOUFLG, val);
    }

    /**
     * �����t���O��Ԃ��܂��B
     * @return String �����t���O
     */
    public String getHb8TouFlg() {
        return (String) get(TBTHB8DOWNR.TOUFLG);
    }

     /**
     * �N����ݒ肵�܂��B
     * @param val String �N��
     */
    public void setHb8Yymm(String val) {
        set(TBTHB8DOWNR.YYMM, val);
    }

    /**
     * �N����Ԃ��܂��B
     * @return String �N��
     */
    public String getHb8Yymm() {
        return (String) get(TBTHB8DOWNR.YYMM);
    }

     /**
     * �Ɩ��敪��ݒ肵�܂��B
     * @param val String �Ɩ��敪
     */
    public void setHb8GyomKbn(String val) {
        set(TBTHB8DOWNR.GYOMKBN, val);
    }

    /**
     * �Ɩ��敪��Ԃ��܂��B
     * @return String �Ɩ��敪
     */
    public String getHb8GyomKbn() {
        return (String) get(TBTHB8DOWNR.GYOMKBN);
    }

     /**
     * �}�X�����敪��ݒ肵�܂��B
     * @param val String �}�X�����敪
     */
    public void setHb8MsKbn(String val) {
        set(TBTHB8DOWNR.MSKBN, val);
    }

    /**
     * �}�X�����敪��Ԃ��܂��B
     * @return String �}�X�����敪
     */
    public String getHb8MsKbn() {
        return (String) get(TBTHB8DOWNR.MSKBN);
    }

     /**
     * �^�C���X�|�b�g�敪��ݒ肵�܂��B
     * @param val String �^�C���X�|�b�g�敪
     */
    public void setHb8TmspKbn(String val) {
        set(TBTHB8DOWNR.TMSPKBN, val);
    }

    /**
     * �^�C���X�|�b�g�敪��Ԃ��܂��B
     * @return String �^�C���X�|�b�g�敪
     */
    public String getHb8TmspKbn() {
        return (String) get(TBTHB8DOWNR.TMSPKBN);
    }

     /**
     * ���ۋ敪��ݒ肵�܂��B
     * @param val String ���ۋ敪
     */
    public void setHb8KokKbn(String val) {
        set(TBTHB8DOWNR.KOKKBN, val);
    }

    /**
     * ���ۋ敪��Ԃ��܂��B
     * @return String ���ۋ敪
     */
    public String getHb8KokKbn() {
        return (String) get(TBTHB8DOWNR.KOKKBN);
    }

     /**
     * �����敪��ݒ肵�܂��B
     * @param val String �����敪
     */
    public void setHb8SeiKbn(String val) {
        set(TBTHB8DOWNR.SEIKBN, val);
    }

    /**
     * �����敪��Ԃ��܂��B
     * @return String �����敪
     */
    public String getHb8SeiKbn() {
        return (String) get(TBTHB8DOWNR.SEIKBN);
    }

     /**
     * ���iNO��ݒ肵�܂��B
     * @param val String ���iNO
     */
    public void setHb8SyoNo(String val) {
        set(TBTHB8DOWNR.SYONO, val);
    }

    /**
     * ���iNO��Ԃ��܂��B
     * @return String ���iNO
     */
    public String getHb8SyoNo() {
        return (String) get(TBTHB8DOWNR.SYONO);
    }

     /**
     * ����(����)��ݒ肵�܂��B
     * @param val String ����(����)
     */
    public void setHb8KKNameKJ(String val) {
        set(TBTHB8DOWNR.KKNAMEKJ, val);
    }

    /**
     * ����(����)��Ԃ��܂��B
     * @return String ����(����)
     */
    public String getHb8KKNameKJ() {
        return (String) get(TBTHB8DOWNR.KKNAMEKJ);
    }

     /**
     * �c�Ɖ�ʃ^�C�v��ݒ肵�܂��B
     * @param val String �c�Ɖ�ʃ^�C�v
     */
    public void setHb8EgGamenType(String val) {
        set(TBTHB8DOWNR.EGGAMENTYPE, val);
    }

    /**
     * �c�Ɖ�ʃ^�C�v��Ԃ��܂��B
     * @return String �c�Ɖ�ʃ^�C�v
     */
    public String getHb8EgGamenType() {
        return (String) get(TBTHB8DOWNR.EGGAMENTYPE);
    }

     /**
     * ���E���ŋ敪��ݒ肵�܂��B
     * @param val String ���E���ŋ敪
     */
    public void setHb8KkakShanKbn(String val) {
        set(TBTHB8DOWNR.KKAKSHANKBN, val);
    }

    /**
     * ���E���ŋ敪��Ԃ��܂��B
     * @return String ���E���ŋ敪
     */
    public String getHb8KkakShanKbn() {
        return (String) get(TBTHB8DOWNR.KKAKSHANKBN);
    }

     /**
     * �旿����ݒ肵�܂��B
     * @param val BigDecimal �旿��
     */
    public void setHb8ToriGak(BigDecimal val) {
        set(TBTHB8DOWNR.TORIGAK, val);
    }

    /**
     * �旿����Ԃ��܂��B
     * @return BigDecimal �旿��
     */
    @XmlElement(required = true)
    public BigDecimal getHb8ToriGak() {
        return (BigDecimal) get(TBTHB8DOWNR.TORIGAK);
    }

     /**
     * �����P����ݒ肵�܂��B
     * @param val BigDecimal �����P��
     */
    public void setHb8SeiTnka(BigDecimal val) {
        set(TBTHB8DOWNR.SEITNKA, val);
    }

    /**
     * �����P����Ԃ��܂��B
     * @return BigDecimal �����P��
     */
    @XmlElement(required = true)
    public BigDecimal getHb8SeiTnka() {
        return (BigDecimal) get(TBTHB8DOWNR.SEITNKA);
    }

     /**
     * �������z��ݒ肵�܂��B
     * @param val BigDecimal �������z
     */
    public void setHb8SeiGak(BigDecimal val) {
        set(TBTHB8DOWNR.SEIGAK, val);
    }

    /**
     * �������z��Ԃ��܂��B
     * @return BigDecimal �������z
     */
    @XmlElement(required = true)
    public BigDecimal getHb8SeiGak() {
        return (BigDecimal) get(TBTHB8DOWNR.SEIGAK);
    }

     /**
     * �l������ݒ肵�܂��B
     * @param val BigDecimal �l����
     */
    public void setHb8NeviRitu(BigDecimal val) {
        set(TBTHB8DOWNR.NEBIRITU, val);
    }

    /**
     * �l������Ԃ��܂��B
     * @return BigDecimal �l����
     */
    @XmlElement(required = true)
    public BigDecimal getHb8NeviRitu() {
        return (BigDecimal) get(TBTHB8DOWNR.NEBIRITU);
    }

     /**
     * �l���z��ݒ肵�܂��B
     * @param val BigDecimal �l���z
     */
    public void setHb8NeviGak(BigDecimal val) {
        set(TBTHB8DOWNR.NEBIGAK, val);
    }

    /**
     * �l���z��Ԃ��܂��B
     * @return BigDecimal �l���z
     */
    @XmlElement(required = true)
    public BigDecimal getHb8NeviGak() {
        return (BigDecimal) get(TBTHB8DOWNR.NEBIGAK);
    }

     /**
     * ����ŋ敪��ݒ肵�܂��B
     * @param val String ����ŋ敪
     */
    public void setHb8SzeiKbn(String val) {
        set(TBTHB8DOWNR.SZEIKBN, val);
    }

    /**
     * ����ŋ敪��Ԃ��܂��B
     * @return String ����ŋ敪
     */
    public String getHb8SzeiKbn() {
        return (String) get(TBTHB8DOWNR.SZEIKBN);
    }

     /**
     * ����ŗ���ݒ肵�܂��B
     * @param val BigDecimal ����ŗ�
     */
    public void setHb8SzeiRitu(BigDecimal val) {
        set(TBTHB8DOWNR.SZEIRITU, val);
    }

    /**
     * ����ŗ���Ԃ��܂��B
     * @return BigDecimal ����ŗ�
     */
    @XmlElement(required = true)
    public BigDecimal getHb8SzeiRitu() {
        return (BigDecimal) get(TBTHB8DOWNR.SZEIRITU);
    }

     /**
     * ����Ŋz��ݒ肵�܂��B
     * @param val BigDecimal ����Ŋz
     */
    public void setHb8SzeiGak(BigDecimal val) {
        set(TBTHB8DOWNR.SZEIGAK, val);
    }

    /**
     * ����Ŋz��Ԃ��܂��B
     * @return BigDecimal ����Ŋz
     */
    @XmlElement(required = true)
    public BigDecimal getHb8SzeiGak() {
        return (BigDecimal) get(TBTHB8DOWNR.SZEIGAK);
    }

     /**
     * ��ږ�(����)��ݒ肵�܂��B
     * @param val String ��ږ�(����)
     */
    public void setHb8HimkNmKJ(String val) {
        set(TBTHB8DOWNR.HIMKNMKJ, val);
    }

    /**
     * ��ږ�(����)��Ԃ��܂��B
     * @return String ��ږ�(����)
     */
    public String getHb8HimkNmKJ() {
        return (String) get(TBTHB8DOWNR.HIMKNMKJ);
    }

     /**
     * ��ږ�(�J�i)��ݒ肵�܂��B
     * @param val String ��ږ�(�J�i)
     */
    public void setHb8HimkNmKN(String val) {
        set(TBTHB8DOWNR.HIMKNMKN, val);
    }

    /**
     * ��ږ�(�J�i)��Ԃ��܂��B
     * @return String ��ږ�(�J�i)
     */
    public String getHb8HimkNmKN() {
        return (String) get(TBTHB8DOWNR.HIMKNMKN);
    }

     /**
     * �������No��ݒ肵�܂��B
     * @param val String �������No
     */
    public void setHb8TJyutNo(String val) {
        set(TBTHB8DOWNR.TJYUTNO, val);
    }

    /**
     * �������No��Ԃ��܂��B
     * @return String �������No
     */
    public String getHb8TJyutNo() {
        return (String) get(TBTHB8DOWNR.TJYUTNO);
    }

     /**
     * ������󒍖���No��ݒ肵�܂��B
     * @param val String ������󒍖���No
     */
    public void setHb8TJyMeiNo(String val) {
        set(TBTHB8DOWNR.TJYMEINO, val);
    }

    /**
     * ������󒍖���No��Ԃ��܂��B
     * @return String ������󒍖���No
     */
    public String getHb8TJyMeiNo() {
        return (String) get(TBTHB8DOWNR.TJYMEINO);
    }

     /**
     * �����攄�㖾��No��ݒ肵�܂��B
     * @param val String �����攄�㖾��No
     */
    public void setHb8TUrMeiNo(String val) {
        set(TBTHB8DOWNR.TURMEINO, val);
    }

    /**
     * �����攄�㖾��No��Ԃ��܂��B
     * @return String �����攄�㖾��No
     */
    public String getHb8TUrMeiNo() {
        return (String) get(TBTHB8DOWNR.TURMEINO);
    }

     /**
     * �������t���O��ݒ肵�܂��B
     * @param val String �������t���O
     */
    public void setHb8MSeiFlg(String val) {
        set(TBTHB8DOWNR.MSEIFLG, val);
    }

    /**
     * �������t���O��Ԃ��܂��B
     * @return String �������t���O
     */
    public String getHb8MSeiFlg() {
        return (String) get(TBTHB8DOWNR.MSEIFLG);
    }

     /**
     * �ύX�O�N����ݒ肵�܂��B
     * @param val String �ύX�O�N��
     */
    public void setHb8YymmOld(String val) {
        set(TBTHB8DOWNR.YYMMOLD, val);
    }

    /**
     * �ύX�O�N����Ԃ��܂��B
     * @return String �ύX�O�N��
     */
    public String getHb8YymmOld() {
        return (String) get(TBTHB8DOWNR.YYMMOLD);
    }

     /**
     * �t�B�[���h1��ݒ肵�܂��B
     * @param val String �t�B�[���h1
     */
    public void setHb8Field1(String val) {
        set(TBTHB8DOWNR.FIELD1, val);
    }

    /**
     * �t�B�[���h1��Ԃ��܂��B
     * @return String �t�B�[���h1
     */
    public String getHb8Field1() {
        return (String) get(TBTHB8DOWNR.FIELD1);
    }

     /**
     * �t�B�[���h�Q��ݒ肵�܂��B
     * @param val String �t�B�[���h�Q
     */
    public void setHb8Field2(String val) {
        set(TBTHB8DOWNR.FIELD2, val);
    }

    /**
     * �t�B�[���h�Q��Ԃ��܂��B
     * @return String �t�B�[���h�Q
     */
    public String getHb8Field2() {
        return (String) get(TBTHB8DOWNR.FIELD2);
    }

     /**
     * �t�B�[���h�R��ݒ肵�܂��B
     * @param val String �t�B�[���h�R
     */
    public void setHb8Field3(String val) {
        set(TBTHB8DOWNR.FIELD3, val);
    }

    /**
     * �t�B�[���h�R��Ԃ��܂��B
     * @return String �t�B�[���h�R
     */
    public String getHb8Field3() {
        return (String) get(TBTHB8DOWNR.FIELD3);
    }

     /**
     * �t�B�[���h�S��ݒ肵�܂��B
     * @param val String �t�B�[���h�S
     */
    public void setHb8Field4(String val) {
        set(TBTHB8DOWNR.FIELD4, val);
    }

    /**
     * �t�B�[���h�S��Ԃ��܂��B
     * @return String �t�B�[���h�S
     */
    public String getHb8Field4() {
        return (String) get(TBTHB8DOWNR.FIELD4);
    }

     /**
     * �t�B�[���h�T��ݒ肵�܂��B
     * @param val String �t�B�[���h�T
     */
    public void setHb8Field5(String val) {
        set(TBTHB8DOWNR.FIELD5, val);
    }

    /**
     * �t�B�[���h�T��Ԃ��܂��B
     * @return String �t�B�[���h�T
     */
    public String getHb8Field5() {
        return (String) get(TBTHB8DOWNR.FIELD5);
    }

     /**
     * �t�B�[���h�U��ݒ肵�܂��B
     * @param val String �t�B�[���h�U
     */
    public void setHb8Field6(String val) {
        set(TBTHB8DOWNR.FIELD6, val);
    }

    /**
     * �t�B�[���h�U��Ԃ��܂��B
     * @return String �t�B�[���h�U
     */
    public String getHb8Field6() {
        return (String) get(TBTHB8DOWNR.FIELD6);
    }

     /**
     * �t�B�[���h�V��ݒ肵�܂��B
     * @param val String �t�B�[���h�V
     */
    public void setHb8Field7(String val) {
        set(TBTHB8DOWNR.FIELD7, val);
    }

    /**
     * �t�B�[���h�V��Ԃ��܂��B
     * @return String �t�B�[���h�V
     */
    public String getHb8Field7() {
        return (String) get(TBTHB8DOWNR.FIELD7);
    }

     /**
     * �t�B�[���h�W��ݒ肵�܂��B
     * @param val String �t�B�[���h�W
     */
    public void setHb8Field8(String val) {
        set(TBTHB8DOWNR.FIELD8, val);
    }

    /**
     * �t�B�[���h�W��Ԃ��܂��B
     * @return String �t�B�[���h�W
     */
    public String getHb8Field8() {
        return (String) get(TBTHB8DOWNR.FIELD8);
    }

     /**
     * �t�B�[���h�X��ݒ肵�܂��B
     * @param val String �t�B�[���h�X
     */
    public void setHb8Field9(String val) {
        set(TBTHB8DOWNR.FIELD9, val);
    }

    /**
     * �t�B�[���h�X��Ԃ��܂��B
     * @return String �t�B�[���h�X
     */
    public String getHb8Field9() {
        return (String) get(TBTHB8DOWNR.FIELD9);
    }

     /**
     * �t�B�[���h�P�O��ݒ肵�܂��B
     * @param val String �t�B�[���h�P�O
     */
    public void setHb8Field10(String val) {
        set(TBTHB8DOWNR.FIELD10, val);
    }

    /**
     * �t�B�[���h�P�O��Ԃ��܂��B
     * @return String �t�B�[���h�P�O
     */
    public String getHb8Field10() {
        return (String) get(TBTHB8DOWNR.FIELD10);
    }

     /**
     * �t�B�[���h�P�P��ݒ肵�܂��B
     * @param val String �t�B�[���h�P�P
     */
    public void setHb8Field11(String val) {
        set(TBTHB8DOWNR.FIELD11, val);
    }

    /**
     * �t�B�[���h�P�P��Ԃ��܂��B
     * @return String �t�B�[���h�P�P
     */
    public String getHb8Field11() {
        return (String) get(TBTHB8DOWNR.FIELD11);
    }

     /**
     * �t�B�[���h�P�Q��ݒ肵�܂��B
     * @param val String �t�B�[���h�P�Q
     */
    public void setHb8Field12(String val) {
        set(TBTHB8DOWNR.FIELD12, val);
    }

    /**
     * �t�B�[���h�P�Q��Ԃ��܂��B
     * @return String �t�B�[���h�P�Q
     */
    public String getHb8Field12() {
        return (String) get(TBTHB8DOWNR.FIELD12);
    }

    /**
    * �_�E�����[�h�t�@�C���^�C���X�^���v��ݒ肵�܂��B
    * @param val String �_�E�����[�h�t�@�C���^�C���X�^���v
    */
    public void setHb8FileTimStmp(String val) {
        set(TBTHB8DOWNR.FILETIMSTMP, val);
    }

    /**
    * �_�E�����[�h�t�@�C���^�C���X�^���v��Ԃ��܂��B
    * @return String �_�E�����[�h�t�@�C���^�C���X�^���v
    */
    public String getHb8FileTimStmp() {
        return (String) get(TBTHB8DOWNR.FILETIMSTMP);
    }

    /**
    * ���דo�^������ݒ肵�܂��B
    * @param val String ���דo�^����
    */
    public void setHb8MeiTimStmp(String val) {
        set(TBTHB8DOWNR.MEITIMSTMP, val);
    }

    /**
     * ���דo�^������Ԃ��܂��B
     * @return String ���דo�^����
     */
    public String getHb8MeiTimStmp() {
        return (String) get(TBTHB8DOWNR.MEITIMSTMP);
    }

}
