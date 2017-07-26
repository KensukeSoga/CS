package jp.co.isid.kkh.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �}�X�^�f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/04 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
@XmlRootElement(namespace = "http://master.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.kkh.isid.co.jp/")
public class MasterDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public MasterDataVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new MasterDataVO();
    }

    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �o�^�^�C���X�^���v
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHBAMST.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     * @return String �o�^�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHBAMST.TRKTIMSTMP);
    }

    /**
     * �o�^�v���O������ݒ肵�܂��B
     * @param val String �o�^�v���O����
     */
    public void setTrkPl(String val) {
        set(TBTHBAMST.TRKPL, val);
    }

    /**
     * �o�^�v���O������Ԃ��܂��B
     * @return String �o�^�v���O����
     */
    public String getTrkPl() {
        return (String) get(TBTHBAMST.TRKPL);
    }

    /**
     * �o�^�S���҂�ݒ肵�܂��B
     * @param val String �o�^�S����
     */
    public void setTrkTnt(String val) {
        set(TBTHBAMST.TRKTNT, val);
    }

    /**
     * �o�^�S���҂�Ԃ��܂��B
     * @return String �o�^�S����
     */
    public String getTrkTnt() {
        return (String) get(TBTHBAMST.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�^�C���X�^���v
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHBAMST.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHBAMST.UPDTIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setUpdaPl(String val) {
        set(TBTHBAMST.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getUpdaPl() {
        return (String) get(TBTHBAMST.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setUpdTnt(String val) {
        set(TBTHBAMST.UPDTNT   , val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getUpdTnt() {
        return (String) get(TBTHBAMST.UPDTNT   );
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String val) {
        set(TBTHBAMST.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return (String) get(TBTHBAMST.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHBAMST.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHBAMST.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHBAMST.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHBAMST.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHBAMST.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHBAMST.TKSTNTSEQNO);
    }

    /**
     * ��ʂ�ݒ肵�܂��B
     * @param val String ���
     */
    public void setSybt(String val) {
        set(TBTHBAMST.SYBT, val);
    }

    /**
     * ��ʂ�Ԃ��܂��B
     * @return String ���
     */
    public String getSybt() {
        return (String) get(TBTHBAMST.SYBT);
    }

    /**
    * �t�B�[���h1��ݒ肵�܂��B
    * @param val String �t�B�[���h1
    */
   public void setColumn1(String val) {
       set("Column1", val);
   }

   /**
    * �t�B�[���h1��Ԃ��܂��B
    * @return String �t�B�[���h1
    */
   public String getColumn1() {
       return (String) get("Column1");
   }

    /**
    * �t�B�[���h2��ݒ肵�܂��B
    * @param val String �t�B�[���h2
    */
   public void setColumn2(String val) {
       set("Column2", val);
   }

   /**
    * �t�B�[���h2��Ԃ��܂��B
    * @return String �t�B�[���h2
    */
   public String getColumn2() {
       return (String) get("Column2");
   }

    /**
    * �t�B�[���h3��ݒ肵�܂��B
    * @param val String �t�B�[���h3
    */
   public void setColumn3(String val) {
       set("Column3", val);
   }

   /**
    * �t�B�[���h3��Ԃ��܂��B
    * @return String �t�B�[���h3
    */
   public String getColumn3() {
       return (String) get("Column3");
   }

    /**
    * �t�B�[���h4��ݒ肵�܂��B
    * @param val String �t�B�[���h4
    */
   public void setColumn4(String val) {
       set("Column4", val);
   }

   /**
    * �t�B�[���h4��Ԃ��܂��B
    * @return String �t�B�[���h4
    */
   public String getColumn4() {
       return (String) get("Column4");
   }

    /**
    * �t�B�[���h5��ݒ肵�܂��B
    * @param val String �t�B�[���h5
    */
   public void setColumn5(String val) {
       set("Column5", val);
   }

   /**
    * �t�B�[���h5��Ԃ��܂��B
    * @return String �t�B�[���h5
    */
   public String getColumn5() {
       return (String) get("Column5");
   }

    /**
    * �t�B�[���h6��ݒ肵�܂��B
    * @param val String �t�B�[���h6
    */
   public void setColumn6(String val) {
       set("Column6", val);
   }

   /**
    * �t�B�[���h6��Ԃ��܂��B
    * @return String �t�B�[���h6
    */
   public String getColumn6() {
       return (String) get("Column6");
   }

    /**
    * �t�B�[���h7��ݒ肵�܂��B
    * @param val String �t�B�[���h7
    */
   public void setColumn7(String val) {
       set("Column7", val);
   }

   /**
    * �t�B�[���h7��Ԃ��܂��B
    * @return String �t�B�[���h7
    */
   public String getColumn7() {
       return (String) get("Column7");
   }

    /**
    * �t�B�[���h8��ݒ肵�܂��B
    * @param val String �t�B�[���h8
    */
   public void setColumn8(String val) {
       set("Column8", val);
   }

   /**
    * �t�B�[���h8��Ԃ��܂��B
    * @return String �t�B�[���h8
    */
   public String getColumn8() {
       return (String) get("Column8");
   }

    /**
    * �t�B�[���h9��ݒ肵�܂��B
    * @param val String �t�B�[���h9
    */
   public void setColumn9(String val) {
       set("Column9", val);
   }

   /**
    * �t�B�[���h9��Ԃ��܂��B
    * @return String �t�B�[���h9
    */
   public String getColumn9() {
       return (String) get("Column9");
   }

    /**
    * �t�B�[���h10��ݒ肵�܂��B
    * @param val String �t�B�[���h10
    */
   public void setColumn10(String val) {
       set("Column10", val);
   }

   /**
    * �t�B�[���h10��Ԃ��܂��B
    * @return String �t�B�[���h10
    */
   public String getColumn10() {
       return (String) get("Column10");
   }

    /**
    * �t�B�[���h11��ݒ肵�܂��B
    * @param val String �t�B�[���h11
    */
   public void setColumn11(String val) {
       set("Column11", val);
   }

   /**
    * �t�B�[���h11��Ԃ��܂��B
    * @return String �t�B�[���h11
    */
   public String getColumn11() {
       return (String) get("Column11");
   }

    /**
    * �t�B�[���h12��ݒ肵�܂��B
    * @param val String �t�B�[���h12
    */
   public void setColumn12(String val) {
       set("Column12", val);
   }

   /**
    * �t�B�[���h12��Ԃ��܂��B
    * @return String �t�B�[���h12
    */
   public String getColumn12() {
       return (String) get("Column12");
   }

    /**
    * �t�B�[���h13��ݒ肵�܂��B
    * @param val String �t�B�[���h13
    */
   public void setColumn13(String val) {
       set("Column13", val);
   }

   /**
    * �t�B�[���h13��Ԃ��܂��B
    * @return String �t�B�[���h13
    */
   public String getColumn13() {
       return (String) get("Column13");
   }

    /**
    * �t�B�[���h14��ݒ肵�܂��B
    * @param val String �t�B�[���h14
    */
   public void setColumn14(String val) {
       set("Column14", val);
   }

   /**
    * �t�B�[���h14��Ԃ��܂��B
    * @return String �t�B�[���h14
    */
   public String getColumn14() {
       return (String) get("Column14");
   }

    /**
    * �t�B�[���h15��ݒ肵�܂��B
    * @param val String �t�B�[���h15
    */
   public void setColumn15(String val) {
       set("Column15", val);
   }

   /**
    * �t�B�[���h15��Ԃ��܂��B
    * @return String �t�B�[���h15
    */
   public String getColumn15() {
       return (String) get("Column15");
   }

    /**
    * �t�B�[���h16��ݒ肵�܂��B
    * @param val String �t�B�[���h16
    */
   public void setColumn16(String val) {
       set("Column16", val);
   }

   /**
    * �t�B�[���h16��Ԃ��܂��B
    * @return String �t�B�[���h16
    */
   public String getColumn16() {
       return (String) get("Column16");
   }

    /**
    * �t�B�[���h17��ݒ肵�܂��B
    * @param val String �t�B�[���h17
    */
   public void setColumn17(String val) {
       set("Column17", val);
   }

   /**
    * �t�B�[���h17��Ԃ��܂��B
    * @return String �t�B�[���h17
    */
   public String getColumn17() {
       return (String) get("Column17");
   }

    /**
    * �t�B�[���h18��ݒ肵�܂��B
    * @param val String �t�B�[���h18
    */
   public void setColumn18(String val) {
       set("Column18", val);
   }

   /**
    * �t�B�[���h18��Ԃ��܂��B
    * @return String �t�B�[���h18
    */
   public String getColumn18() {
       return (String) get("Column18");
   }

    /**
    * �t�B�[���h19��ݒ肵�܂��B
    * @param val String �t�B�[���h19
    */
   public void setColumn19(String val) {
       set("Column19", val);
   }

   /**
    * �t�B�[���h19��Ԃ��܂��B
    * @return String �t�B�[���h19
    */
   public String getColumn19() {
       return (String) get("Column19");
   }

    /**
    * �t�B�[���h20��ݒ肵�܂��B
    * @param val String �t�B�[���h20
    */
   public void setColumn20(String val) {
       set("Column20", val);
   }

   /**
    * �t�B�[���h20��Ԃ��܂��B
    * @return String �t�B�[���h20
    */
   public String getColumn20() {
       return (String) get("Column20");
   }

    /**
    * �t�B�[���h21��ݒ肵�܂��B
    * @param val String �t�B�[���h21
    */
   public void setColumn21(String val) {
       set("Column21", val);
   }

   /**
    * �t�B�[���h21��Ԃ��܂��B
    * @return String �t�B�[���h21
    */
   public String getColumn21() {
       return (String) get("Column21");
   }

    /**
    * �t�B�[���h22��ݒ肵�܂��B
    * @param val String �t�B�[���h22
    */
   public void setColumn22(String val) {
       set("Column22", val);
   }

   /**
    * �t�B�[���h22��Ԃ��܂��B
    * @return String �t�B�[���h22
    */
   public String getColumn22() {
       return (String) get("Column22");
   }

    /**
    * �t�B�[���h23��ݒ肵�܂��B
    * @param val String �t�B�[���h23
    */
   public void setColumn23(String val) {
       set("Column23", val);
   }

   /**
    * �t�B�[���h23��Ԃ��܂��B
    * @return String �t�B�[���h23
    */
   public String getColumn23() {
       return (String) get("Column23");
   }

    /**
    * �t�B�[���h24��ݒ肵�܂��B
    * @param val String �t�B�[���h24
    */
   public void setColumn24(String val) {
       set("Column24", val);
   }

   /**
    * �t�B�[���h24��Ԃ��܂��B
    * @return String �t�B�[���h24
    */
   public String getColumn24() {
       return (String) get("Column24");
   }

    /**
    * �t�B�[���h25��ݒ肵�܂��B
    * @param val String �t�B�[���h25
    */
   public void setColumn25(String val) {
       set("Column25", val);
   }

   /**
    * �t�B�[���h25��Ԃ��܂��B
    * @return String �t�B�[���h25
    */
   public String getColumn25() {
       return (String) get("Column25");
   }

    /**
    * �t�B�[���h26��ݒ肵�܂��B
    * @param val String �t�B�[���h26
    */
   public void setColumn26(String val) {
       set("Column26", val);
   }

   /**
    * �t�B�[���h26��Ԃ��܂��B
    * @return String �t�B�[���h26
    */
   public String getColumn26() {
       return (String) get("Column26");
   }

    /**
    * �t�B�[���h27��ݒ肵�܂��B
    * @param val String �t�B�[���h27
    */
   public void setColumn27(String val) {
       set("Column27", val);
   }

   /**
    * �t�B�[���h27��Ԃ��܂��B
    * @return String �t�B�[���h27
    */
   public String getColumn27() {
       return (String) get("Column27");
   }

    /**
    * �t�B�[���h28��ݒ肵�܂��B
    * @param val String �t�B�[���h28
    */
   public void setColumn28(String val) {
       set("Column28", val);
   }

   /**
    * �t�B�[���h28��Ԃ��܂��B
    * @return String �t�B�[���h28
    */
   public String getColumn28() {
       return (String) get("Column28");
   }

    /**
    * �t�B�[���h29��ݒ肵�܂��B
    * @param val String �t�B�[���h29
    */
   public void setColumn29(String val) {
       set("Column29", val);
   }

   /**
    * �t�B�[���h29��Ԃ��܂��B
    * @return String �t�B�[���h29
    */
   public String getColumn29() {
       return (String) get("Column29");
   }

    /**
    * �t�B�[���h30��ݒ肵�܂��B
    * @param val String �t�B�[���h30
    */
   public void setColumn30(String val) {
       set("Column30", val);
   }

   /**
    * �t�B�[���h30��Ԃ��܂��B
    * @return String �t�B�[���h30
    */
   public String getColumn30() {
       return (String) get("Column30");
   }

}
