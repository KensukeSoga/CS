package jp.co.isid.kkh.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * マスタデータVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/04 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
@XmlRootElement(namespace = "http://master.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.kkh.isid.co.jp/")
public class MasterDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public MasterDataVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new MasterDataVO();
    }

    /**
     * 登録タイムスタンプを設定します。
     * @param val String 登録タイムスタンプ
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHBAMST.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return String 登録タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHBAMST.TRKTIMSTMP);
    }

    /**
     * 登録プログラムを設定します。
     * @param val String 登録プログラム
     */
    public void setTrkPl(String val) {
        set(TBTHBAMST.TRKPL, val);
    }

    /**
     * 登録プログラムを返します。
     * @return String 登録プログラム
     */
    public String getTrkPl() {
        return (String) get(TBTHBAMST.TRKPL);
    }

    /**
     * 登録担当者を設定します。
     * @param val String 登録担当者
     */
    public void setTrkTnt(String val) {
        set(TBTHBAMST.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     * @return String 登録担当者
     */
    public String getTrkTnt() {
        return (String) get(TBTHBAMST.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新タイムスタンプ
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHBAMST.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHBAMST.UPDTIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setUpdaPl(String val) {
        set(TBTHBAMST.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getUpdaPl() {
        return (String) get(TBTHBAMST.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHBAMST.UPDTNT   , val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHBAMST.UPDTNT   );
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHBAMST.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHBAMST.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHBAMST.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHBAMST.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHBAMST.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHBAMST.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHBAMST.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHBAMST.TKSTNTSEQNO);
    }

    /**
     * 種別を設定します。
     * @param val String 種別
     */
    public void setSybt(String val) {
        set(TBTHBAMST.SYBT, val);
    }

    /**
     * 種別を返します。
     * @return String 種別
     */
    public String getSybt() {
        return (String) get(TBTHBAMST.SYBT);
    }

    /**
    * フィールド1を設定します。
    * @param val String フィールド1
    */
   public void setColumn1(String val) {
       set("Column1", val);
   }

   /**
    * フィールド1を返します。
    * @return String フィールド1
    */
   public String getColumn1() {
       return (String) get("Column1");
   }

    /**
    * フィールド2を設定します。
    * @param val String フィールド2
    */
   public void setColumn2(String val) {
       set("Column2", val);
   }

   /**
    * フィールド2を返します。
    * @return String フィールド2
    */
   public String getColumn2() {
       return (String) get("Column2");
   }

    /**
    * フィールド3を設定します。
    * @param val String フィールド3
    */
   public void setColumn3(String val) {
       set("Column3", val);
   }

   /**
    * フィールド3を返します。
    * @return String フィールド3
    */
   public String getColumn3() {
       return (String) get("Column3");
   }

    /**
    * フィールド4を設定します。
    * @param val String フィールド4
    */
   public void setColumn4(String val) {
       set("Column4", val);
   }

   /**
    * フィールド4を返します。
    * @return String フィールド4
    */
   public String getColumn4() {
       return (String) get("Column4");
   }

    /**
    * フィールド5を設定します。
    * @param val String フィールド5
    */
   public void setColumn5(String val) {
       set("Column5", val);
   }

   /**
    * フィールド5を返します。
    * @return String フィールド5
    */
   public String getColumn5() {
       return (String) get("Column5");
   }

    /**
    * フィールド6を設定します。
    * @param val String フィールド6
    */
   public void setColumn6(String val) {
       set("Column6", val);
   }

   /**
    * フィールド6を返します。
    * @return String フィールド6
    */
   public String getColumn6() {
       return (String) get("Column6");
   }

    /**
    * フィールド7を設定します。
    * @param val String フィールド7
    */
   public void setColumn7(String val) {
       set("Column7", val);
   }

   /**
    * フィールド7を返します。
    * @return String フィールド7
    */
   public String getColumn7() {
       return (String) get("Column7");
   }

    /**
    * フィールド8を設定します。
    * @param val String フィールド8
    */
   public void setColumn8(String val) {
       set("Column8", val);
   }

   /**
    * フィールド8を返します。
    * @return String フィールド8
    */
   public String getColumn8() {
       return (String) get("Column8");
   }

    /**
    * フィールド9を設定します。
    * @param val String フィールド9
    */
   public void setColumn9(String val) {
       set("Column9", val);
   }

   /**
    * フィールド9を返します。
    * @return String フィールド9
    */
   public String getColumn9() {
       return (String) get("Column9");
   }

    /**
    * フィールド10を設定します。
    * @param val String フィールド10
    */
   public void setColumn10(String val) {
       set("Column10", val);
   }

   /**
    * フィールド10を返します。
    * @return String フィールド10
    */
   public String getColumn10() {
       return (String) get("Column10");
   }

    /**
    * フィールド11を設定します。
    * @param val String フィールド11
    */
   public void setColumn11(String val) {
       set("Column11", val);
   }

   /**
    * フィールド11を返します。
    * @return String フィールド11
    */
   public String getColumn11() {
       return (String) get("Column11");
   }

    /**
    * フィールド12を設定します。
    * @param val String フィールド12
    */
   public void setColumn12(String val) {
       set("Column12", val);
   }

   /**
    * フィールド12を返します。
    * @return String フィールド12
    */
   public String getColumn12() {
       return (String) get("Column12");
   }

    /**
    * フィールド13を設定します。
    * @param val String フィールド13
    */
   public void setColumn13(String val) {
       set("Column13", val);
   }

   /**
    * フィールド13を返します。
    * @return String フィールド13
    */
   public String getColumn13() {
       return (String) get("Column13");
   }

    /**
    * フィールド14を設定します。
    * @param val String フィールド14
    */
   public void setColumn14(String val) {
       set("Column14", val);
   }

   /**
    * フィールド14を返します。
    * @return String フィールド14
    */
   public String getColumn14() {
       return (String) get("Column14");
   }

    /**
    * フィールド15を設定します。
    * @param val String フィールド15
    */
   public void setColumn15(String val) {
       set("Column15", val);
   }

   /**
    * フィールド15を返します。
    * @return String フィールド15
    */
   public String getColumn15() {
       return (String) get("Column15");
   }

    /**
    * フィールド16を設定します。
    * @param val String フィールド16
    */
   public void setColumn16(String val) {
       set("Column16", val);
   }

   /**
    * フィールド16を返します。
    * @return String フィールド16
    */
   public String getColumn16() {
       return (String) get("Column16");
   }

    /**
    * フィールド17を設定します。
    * @param val String フィールド17
    */
   public void setColumn17(String val) {
       set("Column17", val);
   }

   /**
    * フィールド17を返します。
    * @return String フィールド17
    */
   public String getColumn17() {
       return (String) get("Column17");
   }

    /**
    * フィールド18を設定します。
    * @param val String フィールド18
    */
   public void setColumn18(String val) {
       set("Column18", val);
   }

   /**
    * フィールド18を返します。
    * @return String フィールド18
    */
   public String getColumn18() {
       return (String) get("Column18");
   }

    /**
    * フィールド19を設定します。
    * @param val String フィールド19
    */
   public void setColumn19(String val) {
       set("Column19", val);
   }

   /**
    * フィールド19を返します。
    * @return String フィールド19
    */
   public String getColumn19() {
       return (String) get("Column19");
   }

    /**
    * フィールド20を設定します。
    * @param val String フィールド20
    */
   public void setColumn20(String val) {
       set("Column20", val);
   }

   /**
    * フィールド20を返します。
    * @return String フィールド20
    */
   public String getColumn20() {
       return (String) get("Column20");
   }

    /**
    * フィールド21を設定します。
    * @param val String フィールド21
    */
   public void setColumn21(String val) {
       set("Column21", val);
   }

   /**
    * フィールド21を返します。
    * @return String フィールド21
    */
   public String getColumn21() {
       return (String) get("Column21");
   }

    /**
    * フィールド22を設定します。
    * @param val String フィールド22
    */
   public void setColumn22(String val) {
       set("Column22", val);
   }

   /**
    * フィールド22を返します。
    * @return String フィールド22
    */
   public String getColumn22() {
       return (String) get("Column22");
   }

    /**
    * フィールド23を設定します。
    * @param val String フィールド23
    */
   public void setColumn23(String val) {
       set("Column23", val);
   }

   /**
    * フィールド23を返します。
    * @return String フィールド23
    */
   public String getColumn23() {
       return (String) get("Column23");
   }

    /**
    * フィールド24を設定します。
    * @param val String フィールド24
    */
   public void setColumn24(String val) {
       set("Column24", val);
   }

   /**
    * フィールド24を返します。
    * @return String フィールド24
    */
   public String getColumn24() {
       return (String) get("Column24");
   }

    /**
    * フィールド25を設定します。
    * @param val String フィールド25
    */
   public void setColumn25(String val) {
       set("Column25", val);
   }

   /**
    * フィールド25を返します。
    * @return String フィールド25
    */
   public String getColumn25() {
       return (String) get("Column25");
   }

    /**
    * フィールド26を設定します。
    * @param val String フィールド26
    */
   public void setColumn26(String val) {
       set("Column26", val);
   }

   /**
    * フィールド26を返します。
    * @return String フィールド26
    */
   public String getColumn26() {
       return (String) get("Column26");
   }

    /**
    * フィールド27を設定します。
    * @param val String フィールド27
    */
   public void setColumn27(String val) {
       set("Column27", val);
   }

   /**
    * フィールド27を返します。
    * @return String フィールド27
    */
   public String getColumn27() {
       return (String) get("Column27");
   }

    /**
    * フィールド28を設定します。
    * @param val String フィールド28
    */
   public void setColumn28(String val) {
       set("Column28", val);
   }

   /**
    * フィールド28を返します。
    * @return String フィールド28
    */
   public String getColumn28() {
       return (String) get("Column28");
   }

    /**
    * フィールド29を設定します。
    * @param val String フィールド29
    */
   public void setColumn29(String val) {
       set("Column29", val);
   }

   /**
    * フィールド29を返します。
    * @return String フィールド29
    */
   public String getColumn29() {
       return (String) get("Column29");
   }

    /**
    * フィールド30を設定します。
    * @param val String フィールド30
    */
   public void setColumn30(String val) {
       set("Column30", val);
   }

   /**
    * フィールド30を返します。
    * @return String フィールド30
    */
   public String getColumn30() {
       return (String) get("Column30");
   }

}
