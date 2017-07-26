package jp.co.isid.kkh.model.detail;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB8DOWNR;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.tbl.VWTHB_ADMURIAGEM;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �󒍈ꗗVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/14 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class JyutyuDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** �_�~�[�v���p�e�B */
    private String _dummy = null;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public JyutyuDataVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new JyutyuDataVO();
    }

    /**
     * ROWNUM��ݒ肵�܂��B
     * @param val Date �^�C���X�^���v
     */
    public void setRowNum(int val) {
        set("ROWNUM", val);
    }

    /**
     * ROWNUM��Ԃ��܂��B
     * @return int ROWNUM
     */
    public int getRowNum() {
        return (Integer) get("ROWNUM");
    }
    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     * @param val Date �^�C���X�^���v
     */
    public void setHb1TrkTimStmp(Date val) {
        set(TBTHB1DOWN.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     * @return Date �^�C���X�^���v
     */
    public Date getHb1TrkTimStmp() {
        return (Date) get(TBTHB1DOWN.TRKTIMSTMP);
    }

     /**
     * �o�^�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setHb1TrkApl(String val) {
        set(TBTHB1DOWN.TRKAPL, val);
    }

    /**
     * �o�^�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getHb1TrkApl() {
        return (String) get(TBTHB1DOWN.TRKAPL);
    }

     /**
     * �o�^�S���҂�ݒ肵�܂��B
     * @param val String �o�^�S����
     */
    public void setHb1TrkTnt(String val) {
        set(TBTHB1DOWN.TRKTNT, val);
    }

    /**
     * �o�^�S���҂�Ԃ��܂��B
     * @return String �o�^�S����
     */
    public String getHb1TrkTnt() {
        return (String) get(TBTHB1DOWN.TRKTNT);
    }

   /**
    * �^�C���X�^���v��ݒ肵�܂��B
    * @param val Date �^�C���X�^���v
    */
   public void setHb1TimStmp(Date val) {
       set(TBTHB1DOWN.TIMSTMP, val);
   }

   /**
    * �^�C���X�^���v��Ԃ��܂��B
    * @return Date �^�C���X�^���v
    */
   public Date getHb1TimStmp() {
       return (Date) get(TBTHB1DOWN.TIMSTMP);
   }

    /**
    * �X�V�v���O������ݒ肵�܂��B
    * @param val String �X�V�v���O����
    */
   public void setHb1UpdApl(String val) {
       set(TBTHB1DOWN.UPDAPL, val);
   }

   /**
    * �X�V�v���O������Ԃ��܂��B
    * @return String �X�V�v���O����
    */
   public String getHb1UpdApl() {
       return (String) get(TBTHB1DOWN.UPDAPL);
   }

    /**
    * �X�V�S���҂�ݒ肵�܂��B
    * @param val String �X�V�S����
    */
   public void setHb1UpdTnt(String val) {
       set(TBTHB1DOWN.UPDTNT, val);
   }

   /**
    * �X�V�S���҂�Ԃ��܂��B
    * @return String �X�V�S����
    */
   public String getHb1UpdTnt() {
       return (String) get(TBTHB1DOWN.UPDTNT);
   }

    /**
    * �c�Ə��i���j�R�[�h��ݒ肵�܂��B
    * @param val String �c�Ə��i���j�R�[�h
    */
   public void setHb1AtuEgCd(String val) {
       set(TBTHB1DOWN.ATUEGCD, val);
   }

   /**
    * �c�Ə��i���j�R�[�h��Ԃ��܂��B
    * @return String �c�Ə��i���j�R�[�h
    */
   public String getHb1AtuEgCd() {
       return (String) get(TBTHB1DOWN.ATUEGCD);
   }

    /**
    * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
    * @param val String �c�Ə��i��j�R�[�h
    */
   public void setHb1EgCd(String val) {
       set(TBTHB1DOWN.EGCD, val);
   }

   /**
    * �c�Ə��i��j�R�[�h��Ԃ��܂��B
    * @return String �c�Ə��i��j�R�[�h
    */
   public String getHb1EgCd() {
       return (String) get(TBTHB1DOWN.EGCD);
   }

    /**
    * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
    * @param val String ���Ӑ��ƃR�[�h
    */
   public void setHb1TksKgyCd(String val) {
       set(TBTHB1DOWN.TKSKGYCD, val);
   }

   /**
    * ���Ӑ��ƃR�[�h��Ԃ��܂��B
    * @return String ���Ӑ��ƃR�[�h
    */
   public String getHb1TksKgyCd() {
       return (String) get(TBTHB1DOWN.TKSKGYCD);
   }

    /**
    * ���Ӑ敔��SEQNO��ݒ肵�܂��B
    * @param val String ���Ӑ敔��SEQNO
    */
   public void setHb1TksBmnSeqNo(String val) {
       set(TBTHB1DOWN.TKSBMNSEQNO, val);
   }

   /**
    * ���Ӑ敔��SEQNO��Ԃ��܂��B
    * @return String ���Ӑ敔��SEQNO
    */
   public String getHb1TksBmnSeqNo() {
       return (String) get(TBTHB1DOWN.TKSBMNSEQNO);
   }

    /**
    * ���Ӑ�S��SEQNO��ݒ肵�܂��B
    * @param val String ���Ӑ�S��SEQNO
    */
   public void setHb1TksTntSeqNo(String val) {
       set(TBTHB1DOWN.TKSTNTSEQNO, val);
   }

   /**
    * ���Ӑ�S��SEQNO��Ԃ��܂��B
    * @return String ���Ӑ�S��SEQNO
    */
   public String getHb1TksTntSeqNo() {
       return (String) get(TBTHB1DOWN.TKSTNTSEQNO);
   }

    /**
    * ��No��ݒ肵�܂��B
    * @param val String ��No
    */
   public void setHb1JyutNo(String val) {
       set(TBTHB1DOWN.JYUTNO, val);
   }

   /**
    * ��No��Ԃ��܂��B
    * @return String ��No
    */
   public String getHb1JyutNo() {
       return (String) get(TBTHB1DOWN.JYUTNO);
   }

    /**
    * �󒍖���No��ݒ肵�܂��B
    * @param val String �󒍖���No
    */
   public void setHb1JyMeiNo(String val) {
       set(TBTHB1DOWN.JYMEINO, val);
   }

   /**
    * �󒍖���No��Ԃ��܂��B
    * @return String �󒍖���No
    */
   public String getHb1JyMeiNo() {
       return (String) get(TBTHB1DOWN.JYMEINO);
   }

    /**
    * ���㖾��No��ݒ肵�܂��B
    * @param val String ���㖾��No
    */
   public void setHb1UrMeiNo(String val) {
       set(TBTHB1DOWN.URMEINO, val);
   }

   /**
    * ���㖾��No��Ԃ��܂��B
    * @return String ���㖾��No
    */
   public String getHb1UrMeiNo() {
       return (String) get(TBTHB1DOWN.URMEINO);
   }

    /**
    * �������[No��ݒ肵�܂��B
    * @param val String �������[No
    */
   public void setHb1GpyNo(String val) {
       set(TBTHB1DOWN.GPYNO, val);
   }

   /**
    * �������[No��Ԃ��܂��B
    * @return String �������[No
    */
   public String getHb1GpyNo() {
       return (String) get(TBTHB1DOWN.GPYNO);
   }

    /**
    * �y�[�WNo��ݒ肵�܂��B
    * @param val String �y�[�WNo
    */
   public void setHb1GpyoPag(String val) {
       set(TBTHB1DOWN.GPYOPAG, val);
   }

   /**
    * �y�[�WNo��Ԃ��܂��B
    * @return String �y�[�WNo
    */
   public String getHb1GpyoPag() {
       return (String) get(TBTHB1DOWN.GPYOPAG);
   }

    /**
    * ����No��ݒ肵�܂��B
    * @param val String ����No
    */
   public void setHb1SeiNo(String val) {
       set(TBTHB1DOWN.SEINO, val);
   }

   /**
    * ����No��Ԃ��܂��B
    * @return String ����No
    */
   public String getHb1SeiNo() {
       return (String) get(TBTHB1DOWN.SEINO);
   }

    /**
    * ��ڃR�[�h��ݒ肵�܂��B
    * @param val String ��ڃR�[�h
    */
   public void setHb1HimkCd(String val) {
       set(TBTHB1DOWN.HIMKCD, val);
   }

   /**
    * ��ڃR�[�h��Ԃ��܂��B
    * @return String ��ڃR�[�h
    */
   public String getHb1HimkCd() {
       return (String) get(TBTHB1DOWN.HIMKCD);
   }

    /**
    * �����t���O��ݒ肵�܂��B
    * @param val String �����t���O
    */
   public void setHb1TouFlg(String val) {
       set(TBTHB1DOWN.TOUFLG, val);
   }

   /**
    * �����t���O��Ԃ��܂��B
    * @return String �����t���O
    */
   public String getHb1TouFlg() {
       return (String) get(TBTHB1DOWN.TOUFLG);
   }

    /**
    * �N����ݒ肵�܂��B
    * @param val String �N��
    */
   public void setHb1Yymm(String val) {
       set(TBTHB1DOWN.YYMM, val);
   }

   /**
    * �N����Ԃ��܂��B
    * @return String �N��
    */
   public String getHb1Yymm() {
       return (String) get(TBTHB1DOWN.YYMM);
   }

    /**
    * �Ɩ��敪��ݒ肵�܂��B
    * @param val String �Ɩ��敪
    */
   public void setHb1GyomKbn(String val) {
       set(TBTHB1DOWN.GYOMKBN, val);
   }

   /**
    * �Ɩ��敪��Ԃ��܂��B
    * @return String �Ɩ��敪
    */
   public String getHb1GyomKbn() {
       return (String) get(TBTHB1DOWN.GYOMKBN);
   }

    /**
    * �}�X�����敪��ݒ肵�܂��B
    * @param val String �}�X�����敪
    */
   public void setHb1MsKbn(String val) {
       set(TBTHB1DOWN.MSKBN, val);
   }

   /**
    * �}�X�����敪��Ԃ��܂��B
    * @return String �}�X�����敪
    */
   public String getHb1MsKbn() {
       return (String) get(TBTHB1DOWN.MSKBN);
   }

    /**
    * �^�C���X�|�b�g�敪��ݒ肵�܂��B
    * @param val String �^�C���X�|�b�g�敪
    */
   public void setHb1TmspKbn(String val) {
       set(TBTHB1DOWN.TMSPKBN, val);
   }

   /**
    * �^�C���X�|�b�g�敪��Ԃ��܂��B
    * @return String �^�C���X�|�b�g�敪
    */
   public String getHb1TmspKbn() {
       return (String) get(TBTHB1DOWN.TMSPKBN);
   }

    /**
    * ���ۋ敪��ݒ肵�܂��B
    * @param val String ���ۋ敪
    */
   public void setHb1KokKbn(String val) {
       set(TBTHB1DOWN.KOKKBN, val);
   }

   /**
    * ���ۋ敪��Ԃ��܂��B
    * @return String ���ۋ敪
    */
   public String getHb1KokKbn() {
       return (String) get(TBTHB1DOWN.KOKKBN);
   }

    /**
    * �����敪��ݒ肵�܂��B
    * @param val String �����敪
    */
   public void setHb1SeiKbn(String val) {
       set(TBTHB1DOWN.SEIKBN, val);
   }

   /**
    * �����敪��Ԃ��܂��B
    * @return String �����敪
    */
   public String getHb1SeiKbn() {
       return (String) get(TBTHB1DOWN.SEIKBN);
   }

    /**
    * ���iNO��ݒ肵�܂��B
    * @param val String ���iNO
    */
   public void setHb1SyoNo(String val) {
       set(TBTHB1DOWN.SYONO, val);
   }

   /**
    * ���iNO��Ԃ��܂��B
    * @return String ���iNO
    */
   public String getHb1SyoNo() {
       return (String) get(TBTHB1DOWN.SYONO);
   }

    /**
    * ����(����)��ݒ肵�܂��B
    * @param val String ����(����)
    */
   public void setHb1KKNameKJ(String val) {
       set(TBTHB1DOWN.KKNAMEKJ, val);
   }

   /**
    * ����(����)��Ԃ��܂��B
    * @return String ����(����)
    */
   public String getHb1KKNameKJ() {
       return (String) get(TBTHB1DOWN.KKNAMEKJ);
   }

    /**
    * �c�Ɖ�ʃ^�C�v��ݒ肵�܂��B
    * @param val String �c�Ɖ�ʃ^�C�v
    */
   public void setHb1EgGamenType(String val) {
       set(TBTHB1DOWN.EGGAMENTYPE, val);
   }

   /**
    * �c�Ɖ�ʃ^�C�v��Ԃ��܂��B
    * @return String �c�Ɖ�ʃ^�C�v
    */
   public String getHb1EgGamenType() {
       return (String) get(TBTHB1DOWN.EGGAMENTYPE);
   }

    /**
    * ���E���ŋ敪��ݒ肵�܂��B
    * @param val String ���E���ŋ敪
    */
   public void setHb1KkakShanKbn(String val) {
       set(TBTHB1DOWN.KKAKSHANKBN, val);
   }

   /**
    * ���E���ŋ敪��Ԃ��܂��B
    * @return String ���E���ŋ敪
    */
   public String getHb1KkakShanKbn() {
       return (String) get(TBTHB1DOWN.KKAKSHANKBN);
   }

    /**
    * �旿����ݒ肵�܂��B
    * @param val BigDecimal �旿��
    */
   public void setHb1ToriGak(BigDecimal val) {
       set(TBTHB1DOWN.TORIGAK, val);
   }

   /**
    * �旿����Ԃ��܂��B
    * @return BigDecimal �旿��
    */
   public BigDecimal getHb1ToriGak() {
       return (BigDecimal) get(TBTHB1DOWN.TORIGAK);
   }

    /**
    * �����P����ݒ肵�܂��B
    * @param val BigDecimal �����P��
    */
   public void setHb1SeiTnka(BigDecimal val) {
       set(TBTHB1DOWN.SEITNKA, val);
   }

   /**
    * �����P����Ԃ��܂��B
    * @return BigDecimal �����P��
    */
   public BigDecimal getHb1SeiTnka() {
       return (BigDecimal) get(TBTHB1DOWN.SEITNKA);
   }

    /**
    * �������z��ݒ肵�܂��B
    * @param val BigDecimal �������z
    */
   public void setHb1SeiGak(BigDecimal val) {
       set(TBTHB1DOWN.SEIGAK, val);
   }

   /**
    * �������z��Ԃ��܂��B
    * @return BigDecimal �������z
    */
   public BigDecimal getHb1SeiGak() {
       return (BigDecimal) get(TBTHB1DOWN.SEIGAK);
   }

    /**
    * �l������ݒ肵�܂��B
    * @param val BigDecimal �l����
    */
   public void setHb1NeviRitu(BigDecimal val) {
       set(TBTHB1DOWN.NEBIRITU, val);
   }

   /**
    * �l������Ԃ��܂��B
    * @return BigDecimal �l����
    */
   public BigDecimal getHb1NeviRitu() {
       return (BigDecimal) get(TBTHB1DOWN.NEBIRITU);
   }

    /**
    * �l���z��ݒ肵�܂��B
    * @param val BigDecimal �l���z
    */
   public void setHb1NeviGak(BigDecimal val) {
       set(TBTHB1DOWN.NEBIGAK, val);
   }

   /**
    * �l���z��Ԃ��܂��B
    * @return BigDecimal �l���z
    */
   public BigDecimal getHb1NeviGak() {
       return (BigDecimal) get(TBTHB1DOWN.NEBIGAK);
   }

    /**
    * ����ŋ敪��ݒ肵�܂��B
    * @param val String ����ŋ敪
    */
   public void setHb1SzeiKbn(String val) {
       set(TBTHB1DOWN.SZEIKBN, val);
   }

   /**
    * ����ŋ敪��Ԃ��܂��B
    * @return String ����ŋ敪
    */
   public String getHb1SzeiKbn() {
       return (String) get(TBTHB1DOWN.SZEIKBN);
   }

    /**
    * ����ŗ���ݒ肵�܂��B
    * @param val BigDecimal ����ŗ�
    */
   public void setHb1SzeiRitu(BigDecimal val) {
       set(TBTHB1DOWN.SZEIRITU, val);
   }

   /**
    * ����ŗ���Ԃ��܂��B
    * @return BigDecimal ����ŗ�
    */
   public BigDecimal getHb1SzeiRitu() {
       return (BigDecimal) get(TBTHB1DOWN.SZEIRITU);
   }

    /**
    * ����Ŋz��ݒ肵�܂��B
    * @param val BigDecimal ����Ŋz
    */
   public void setHb1SzeiGak(BigDecimal val) {
       set(TBTHB1DOWN.SZEIGAK, val);
   }

   /**
    * ����Ŋz��Ԃ��܂��B
    * @return BigDecimal ����Ŋz
    */
   public BigDecimal getHb1SzeiGak() {
       return (BigDecimal) get(TBTHB1DOWN.SZEIGAK);
   }

    /**
    * ��ږ�(����)��ݒ肵�܂��B
    * @param val String ��ږ�(����)
    */
   public void setHb1HimkNmKJ(String val) {
       set(TBTHB1DOWN.HIMKNMKJ, val);
   }

   /**
    * ��ږ�(����)��Ԃ��܂��B
    * @return String ��ږ�(����)
    */
   public String getHb1HimkNmKJ() {
       return (String) get(TBTHB1DOWN.HIMKNMKJ);
   }

    /**
    * ��ږ�(�J�i)��ݒ肵�܂��B
    * @param val String ��ږ�(�J�i)
    */
   public void setHb1HimkNmKN(String val) {
       set(TBTHB1DOWN.HIMKNMKN, val);
   }

   /**
    * ��ږ�(�J�i)��Ԃ��܂��B
    * @return String ��ږ�(�J�i)
    */
   public String getHb1HimkNmKN() {
       return (String) get(TBTHB1DOWN.HIMKNMKN);
   }

    /**
    * �������No��ݒ肵�܂��B
    * @param val String �������No
    */
   public void setHb1TJyutNo(String val) {
       set(TBTHB1DOWN.TJYUTNO, val);
   }

   /**
    * �������No��Ԃ��܂��B
    * @return String �������No
    */
   public String getHb1TJyutNo() {
       return (String) get(TBTHB1DOWN.TJYUTNO);
   }

    /**
    * ������󒍖���No��ݒ肵�܂��B
    * @param val String ������󒍖���No
    */
   public void setHb1TJyMeiNo(String val) {
       set(TBTHB1DOWN.TJYMEINO, val);
   }

   /**
    * ������󒍖���No��Ԃ��܂��B
    * @return String ������󒍖���No
    */
   public String getHb1TJyMeiNo() {
       return (String) get(TBTHB1DOWN.TJYMEINO);
   }

    /**
    * �����攄�㖾��No��ݒ肵�܂��B
    * @param val String �����攄�㖾��No
    */
   public void setHb1TUrMeiNo(String val) {
       set(TBTHB1DOWN.TURMEINO, val);
   }

   /**
    * �����攄�㖾��No��Ԃ��܂��B
    * @return String �����攄�㖾��No
    */
   public String getHb1TUrMeiNo() {
       return (String) get(TBTHB1DOWN.TURMEINO);
   }

    /**
    * �������t���O��ݒ肵�܂��B
    * @param val String �������t���O
    */
   public void setHb1MSeiFlg(String val) {
       set(TBTHB1DOWN.MSEIFLG, val);
   }

   /**
    * �������t���O��Ԃ��܂��B
    * @return String �������t���O
    */
   public String getHb1MSeiFlg() {
       return (String) get(TBTHB1DOWN.MSEIFLG);
   }

    /**
    * �ύX�O�N����ݒ肵�܂��B
    * @param val String �ύX�O�N��
    */
   public void setHb1YymmOld(String val) {
       set(TBTHB1DOWN.YYMMOLD, val);
   }

   /**
    * �ύX�O�N����Ԃ��܂��B
    * @return String �ύX�O�N��
    */
   public String getHb1YymmOld() {
       return (String) get(TBTHB1DOWN.YYMMOLD);
   }

    /**
    * �t�B�[���h1��ݒ肵�܂��B
    * @param val String �t�B�[���h1
    */
   public void setHb1Field1(String val) {
       set(TBTHB1DOWN.FIELD1, val);
   }

   /**
    * �t�B�[���h1��Ԃ��܂��B
    * @return String �t�B�[���h1
    */
   public String getHb1Field1() {
       return (String) get(TBTHB1DOWN.FIELD1);
   }

    /**
    * �t�B�[���h�Q��ݒ肵�܂��B
    * @param val String �t�B�[���h�Q
    */
   public void setHb1Field2(String val) {
       set(TBTHB1DOWN.FIELD2, val);
   }

   /**
    * �t�B�[���h�Q��Ԃ��܂��B
    * @return String �t�B�[���h�Q
    */
   public String getHb1Field2() {
       return (String) get(TBTHB1DOWN.FIELD2);
   }

    /**
    * �t�B�[���h�R��ݒ肵�܂��B
    * @param val String �t�B�[���h�R
    */
   public void setHb1Field3(String val) {
       set(TBTHB1DOWN.FIELD3, val);
   }

   /**
    * �t�B�[���h�R��Ԃ��܂��B
    * @return String �t�B�[���h�R
    */
   public String getHb1Field3() {
       return (String) get(TBTHB1DOWN.FIELD3);
   }

    /**
    * �t�B�[���h�S��ݒ肵�܂��B
    * @param val String �t�B�[���h�S
    */
   public void setHb1Field4(String val) {
       set(TBTHB1DOWN.FIELD4, val);
   }

   /**
    * �t�B�[���h�S��Ԃ��܂��B
    * @return String �t�B�[���h�S
    */
   public String getHb1Field4() {
       return (String) get(TBTHB1DOWN.FIELD4);
   }

    /**
    * �t�B�[���h�T��ݒ肵�܂��B
    * @param val String �t�B�[���h�T
    */
   public void setHb1Field5(String val) {
       set(TBTHB1DOWN.FIELD5, val);
   }

   /**
    * �t�B�[���h�T��Ԃ��܂��B
    * @return String �t�B�[���h�T
    */
   public String getHb1Field5() {
       return (String) get(TBTHB1DOWN.FIELD5);
   }

    /**
    * �t�B�[���h�U��ݒ肵�܂��B
    * @param val String �t�B�[���h�U
    */
   public void setHb1Field6(String val) {
       set(TBTHB1DOWN.FIELD6, val);
   }

   /**
    * �t�B�[���h�U��Ԃ��܂��B
    * @return String �t�B�[���h�U
    */
   public String getHb1Field6() {
       return (String) get(TBTHB1DOWN.FIELD6);
   }

    /**
    * �t�B�[���h�V��ݒ肵�܂��B
    * @param val String �t�B�[���h�V
    */
   public void setHb1Field7(String val) {
       set(TBTHB1DOWN.FIELD7, val);
   }

   /**
    * �t�B�[���h�V��Ԃ��܂��B
    * @return String �t�B�[���h�V
    */
   public String getHb1Field7() {
       return (String) get(TBTHB1DOWN.FIELD7);
   }

    /**
    * �t�B�[���h�W��ݒ肵�܂��B
    * @param val String �t�B�[���h�W
    */
   public void setHb1Field8(String val) {
       set(TBTHB1DOWN.FIELD8, val);
   }

   /**
    * �t�B�[���h�W��Ԃ��܂��B
    * @return String �t�B�[���h�W
    */
   public String getHb1Field8() {
       return (String) get(TBTHB1DOWN.FIELD8);
   }

    /**
    * �t�B�[���h�X��ݒ肵�܂��B
    * @param val String �t�B�[���h�X
    */
   public void setHb1Field9(String val) {
       set(TBTHB1DOWN.FIELD9, val);
   }

   /**
    * �t�B�[���h�X��Ԃ��܂��B
    * @return String �t�B�[���h�X
    */
   public String getHb1Field9() {
       return (String) get(TBTHB1DOWN.FIELD9);
   }

    /**
    * �t�B�[���h�P�O��ݒ肵�܂��B
    * @param val String �t�B�[���h�P�O
    */
   public void setHb1Field10(String val) {
       set(TBTHB1DOWN.FIELD10, val);
   }

   /**
    * �t�B�[���h�P�O��Ԃ��܂��B
    * @return String �t�B�[���h�P�O
    */
   public String getHb1Field10() {
       return (String) get(TBTHB1DOWN.FIELD10);
   }

    /**
    * �t�B�[���h�P�P��ݒ肵�܂��B
    * @param val String �t�B�[���h�P�P
    */
   public void setHb1Field11(String val) {
       set(TBTHB1DOWN.FIELD11, val);
   }

   /**
    * �t�B�[���h�P�P��Ԃ��܂��B
    * @return String �t�B�[���h�P�P
    */
   public String getHb1Field11() {
       return (String) get(TBTHB1DOWN.FIELD11);
   }

    /**
    * �t�B�[���h�P�Q��ݒ肵�܂��B
    * @param val String �t�B�[���h�P�Q
    */
   public void setHb1Field12(String val) {
       set(TBTHB1DOWN.FIELD12, val);
   }

   /**
    * �t�B�[���h�P�Q��Ԃ��܂��B
    * @return String �t�B�[���h�P�Q
    */
   public String getHb1Field12() {
       return (String) get(TBTHB1DOWN.FIELD12);
   }

    /**
    * hb2JyutNo��ݒ肵�܂��B
    * @param val String hb2JyutNo
    */
   public void setHb2JyutNo(String val) {
       set(TBTHB2KMEI.JYUTNO, val);
   }

   /**
    * hb2JyutNo��Ԃ��܂��B
    * @return String hb2JyutNo
    */
   public String getHb2JyutNo() {
       return (String) get(TBTHB2KMEI.JYUTNO);
   }

    /**
    * hb2SeiGak��ݒ肵�܂��B
    * @param val BigDecimal hb2SeiGak
    */
   public void setHb2SeiGak(BigDecimal val) {
       set(TBTHB2KMEI.SEIGAK, val);
   }

   /**
    * hb2SeiGak��Ԃ��܂��B
    * @return BigDecimal hb2SeiGak
    */
   public BigDecimal getHb2SeiGak() {
       return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
   }

    /**
    * gyomBan��ݒ肵�܂��B
    * @param val String gyomBan
    */
   public void setGyomBan(String val) {
       set("GYOMBAN", val);
   }

   /**
    * gyomBan��Ԃ��܂��B
    * @return String gyomBan
    */
   public String getGyomBan() {
       return (String) get("GYOMBAN");
   }

   /**
    * detailCnt��ݒ肵�܂��B
    * @param val BigDecimal detailCnt
    */
   public void setDetailCnt(BigDecimal val) {
       set("DETAILCNT", val);
   }

   /**
    * detailCnt��Ԃ��܂��B
    * @return Decimal detailCnt
    */
   @XmlElement(required = true)
   public BigDecimal getDetailCnt() {
       return (BigDecimal) get("DETAILCNT");
   }

   /**
    * �_�E�����[�h�t�@�C���^�C���X�^���v��ݒ肵�܂��B
    * @param val String �_�E�����[�h�t�@�C���^�C���X�^���v
    */
    public void setHb1FileTimStmp(String val) {
        set(TBTHB1DOWN.FILETIMSTMP, val);
    }

    /**
    * �_�E�����[�h�t�@�C���^�C���X�^���v��Ԃ��܂��B
    * @return String �_�E�����[�h�t�@�C���^�C���X�^���v
    */
    public String getHb1FileTimStmp() {
        return (String) get(TBTHB1DOWN.FILETIMSTMP);
    }

   /**
    * ���דo�^����(����)��ݒ肵�܂��B
    * @param val String RMeiTimStmp
    */
   public void setRMeiTimStmp(String val) {
       set(TBTHB8DOWNR.MEITIMSTMP, val);
   }

   /**
    * ���דo�^����(����)��Ԃ��܂��B
    * @return String RMeiTimStmp
    */
   public String getRMeiTimStmp() {
       return (String) get(TBTHB8DOWNR.MEITIMSTMP);
   }

   /**
    * �󒍍폜�t���O���擾����
    * @return �󒍍폜�t���O
    */
   public String getJyutDelFlg() {
       return (String) get(TBTHB1DOWN.JYUTDELFLG);
   }

   /**
    * �󒍍폜�t���O��ݒ肷��
    * @param val �󒍍폜�t���O
    */
   public void setJyutDelFlg(String val) {
       set(TBTHB1DOWN.JYUTDELFLG, val);
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

   /**
    * �o�^�S���Җ���Ԃ��܂�
    * @return String �o�^�S���Җ�
    */
   public String getHb1TrkTntNm() {
       return (String) get(TBTHB1DOWN.TRKTNTNM);
   }

   /**
    * �o�^�S���Җ��ݒ肵�܂�
    * @param val �o�^�S����
    */
   public void setHb1TrkTntNm(String val) {
       set(TBTHB1DOWN.TRKTNTNM, val);
   }

   /**
    * ���׍X�V�^�C���X�^���v��Ԃ��܂�
    * @return String �o�^�S���Җ�
    */
   @XmlElement(required = true)
   public Date getHb1KsnTimStmp() {
       return (Date) get(TBTHB1DOWN.KSNTIMSTMP);
   }

   /**
    * ���׍X�V�^�C���X�^���v��ݒ肵�܂�
    * @param val �o�^�S����
    */
   public void setHb1KsnTimStmp(Date val) {
       set(TBTHB1DOWN.KSNTIMSTMP, val);
   }

   /**
    * ���׍X�V�҂�Ԃ��܂�
    * @return String ���׍X�V��
    */
   public String getHb1KsnTnt() {
       return (String) get(TBTHB1DOWN.KSNTNT);
   }

   /**
    * ���׍X�V�҂�ݒ肵�܂�
    * @param val ���׍X�V��
    */
   public void setHb1KsnTnt(String val) {
       set(TBTHB1DOWN.KSNTNT, val);
   }

   /**
    * ���׍X�V�Җ���Ԃ��܂�
    * @return String ���׍X�V�Җ�
    */
   public String getHb1KsnTntNm() {
       return (String) get(TBTHB1DOWN.KSNTNTNM);
   }

   /**
    * ���׍X�V�Җ���ݒ肵�܂�
    * @param val ���׍X�V�Җ�
    */
   public void setHb1KsnTntNm(String val) {
       set(TBTHB1DOWN.KSNTNTNM, val);
   }

   /**
    * �X�y�[�X�Q��Ԃ��܂�
    * @return String ���׍X�V�Җ�
    */
   public String getSpace2() {
       return (String) get(TBTHBAMST.FIELD2);
   }

   /**
    * �X�y�[�X�Q��ݒ肵�܂�
    * @param val ���׍X�V�Җ�
    */
   public void setSpace2(String val) {
       set(TBTHBAMST.FIELD2, val);
   }

   //2013/03/06 jse okazaki �����Ή��@Start
   /**
    * ��������X�e�[�^�X��Ԃ��܂�
    * @return String ��������X�e�[�^�X
    */
   public String getSeikyu() {
       return (String) get("SEIKYU");
   }

   /**
    * ��������X�e�[�^�X��ݒ肵�܂�
    * @param val ��������X�e�[�^�X
    */
   public void setSeikyu(String val) {
       set("SEIKYU", val);
   }
   //2013/03/06 jse okazaki �����Ή��@End

   /**
    * �_�~�[�v���p�e�B���擾����
    * @return �_�~�[�v���p�e�B
    */
   public String getDummy() {
       return _dummy;
   }

   /**
    * �_�~�[�v���p�e�B��ݒ肷��
    * @param dummy �_�~�[�v���p�e�B
    */
   public void setDummy(String dummy) {
       this._dummy = dummy;
   }

}
