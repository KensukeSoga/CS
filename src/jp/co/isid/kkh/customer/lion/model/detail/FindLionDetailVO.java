package jp.co.isid.kkh.customer.lion.model.detail;

import java.math.BigDecimal;
import java.util.Date;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * TV番組VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/20 JSE A.Naito)<BR>
 * </P>
 * @author
 */
public class FindLionDetailVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindLionDetailVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindLionDetailVO();
    }

    /** VAL1 */
    public static final String VAL1 = "VAL1";

    /** VAL2 */
    public static final String VAL2 = "VAL2";

    /** VAL3 */
    public static final String VAL3 = "VAL3";

    /**
    * 受注NOを設定します。
    * @param val String 受注NO
    */
    public void setJyutno(String val) {
      set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
    * 受注NOを返します。
    * @return String 受注NO
    */
    public String getJyutno() {
      return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
    * 受注明細NOを設定します。
    * @param val String 受注明細NO
    */
    public void setJymeino(String val) {
      set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
    * 受注明細NOを返します。
    * @return String 受注明細NO
    */
    public String getJymeino() {
      return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
    * 売上明細NOを設定します。
    * @param val String 売上明細NO
    */
    public void setUrmeino(String val) {
      set(TBTHB2KMEI.URMEINO, val);
    }

    /**
    * 売上明細NOを返します。
    * @return String 売上明細NO
    */
    public String getUrmeino() {
      return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
    * 年月を設定します。
    * @param val String 売上明細NO
    */
    public void setYymm(String val) {
      set(TBTHB2KMEI.YYMM, val);
    }

    /**
    * 年月を返します。
    * @return String 年月
    */
    public String getYymm() {
      return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
    * HIMKCDを設定します。
    * @param val String HIMKCD
    */
    public void setHimkcd(String val) {
      set(TBTHB2KMEI.HIMKCD, val);
    }

    /**
    * HIMKCDを返します。
    * @return String HIMKCD
    */
    public String getHimkcd() {
      return (String) get(TBTHB2KMEI.HIMKCD);
    }

    /**
    * HNNERTを設定します。
    * @param val BigDecimal HNNERT
    */
    public void setHnnert(BigDecimal val) {
      set(TBTHB2KMEI.HNNERT, val);
    }
    /**
    * HNNERTを返します。
    * @return BigDecimal HNNERT
    */
    public BigDecimal getHnnert() {
      return (BigDecimal) get(TBTHB2KMEI.HNNERT);
    }

    /**
    * NEBIGAKを設定します。
    * @param val BigDecimal NEBIGAK
    */
    public void setNebigak(BigDecimal val) {
      set(TBTHB2KMEI.NEBIGAK, val);
    }
    /**
    * NEBIGAKを返します。
    * @return BigDecimal NEBIGAK
    */
    public BigDecimal getNebigak() {
      return (BigDecimal) get(TBTHB2KMEI.NEBIGAK);
    }

    /**
    * CODE1を設定します。
    * @param val String CODE1
    */
    public void setCode1(String val) {
      set(TBTHB2KMEI.CODE1, val);
    }

    /**
    * CODE1を返します。
    * @return String CODE1
    */
    public String getCode1() {
      return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
    * CODE2を設定します。
    * @param val String CODE2
    */
    public void setCode2(String val) {
      set(TBTHB2KMEI.CODE2, val);
    }

    /**
    * CODE2を返します。
    * @return String CODE3
    */
    public String getCode2() {
      return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
    * CODE3を設定します。
    * @param val String CODE3
    */
    public void setCode3(String val) {
      set(TBTHB2KMEI.CODE3, val);
    }

    /**
    * CODE3を返します。
    * @return String CODE3
    */
    public String getCode3() {
      return (String) get(TBTHB2KMEI.CODE3);
    }

    /**
    * CODE4を設定します。
    * @param val String CODE4
    */
    public void setCode4(String val) {
      set(TBTHB2KMEI.CODE4, val);
    }

    /**
    * CODE4を返します。
    * @return String CODE4
    */
    public String getCode4() {
      return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
    * CODE5を設定します。
    * @param val String CODE5
    */
    public void setCode5(String val) {
      set(TBTHB2KMEI.CODE5, val);
    }

    /**
    * CODE5を返します。
    * @return String CODE5
    */
    public String getCode5() {
      return (String) get(TBTHB2KMEI.CODE5);
    }

    /**
    * CODE6を設定します。
    * @param val String CODE6
    */
    public void setCode6(String val) {
      set(TBTHB2KMEI.CODE6, val);
    }

    /**
    * CODE6を返します。
    * @return String CODE6
    */
    public String getCode6() {
      return (String) get(TBTHB2KMEI.CODE6);
    }

    /**
    * NAME1を設定します。
    * @param val String NAME1
    */
    public void setName1(String val) {
      set(TBTHB2KMEI.NAME1, val);
    }

    /**
    * NAME1を返します。
    * @return String NAME1
    */
    public String getName1() {
      return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
    * NAME2を設定します。
    * @param val String NAME2
    */
    public void setName2(String val) {
      set(TBTHB2KMEI.NAME2, val);
    }

    /**
    * NAME2を返します。
    * @return String NAME2
    */
    public String getName2() {
      return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
    * NAME3を設定します。
    * @param val String NAME3
    */
    public void setName3(String val) {
      set(TBTHB2KMEI.NAME3, val);
    }

    /**
    * NAME3を返します。
    * @return String NAME3
    */
    public String getName3() {
      return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
    * NAME4を設定します。
    * @param val String NAME4
    */
    public void setName4(String val) {
      set(TBTHB2KMEI.NAME4, val);
    }

    /**
    * NAME4を返します。
    * @return String NAME4
    */
    public String getName4() {
      return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
    * NAME5を設定します。
    * @param val String NAME5
    */
    public void setName5(String val) {
      set(TBTHB2KMEI.NAME5, val);
    }

    /**
    * NAME5を返します。
    * @return String NAME5
    */
    public String getName5() {
      return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
    * NAME6を設定します。
    * @param val String NAME6
    */
    public void setName6(String val) {
      set(TBTHB2KMEI.NAME6, val);
    }

    /**
    * NAME6を返します。
    * @return String NAME6
    */
    public String getName6() {
      return (String) get(TBTHB2KMEI.NAME6);
    }

    /**
    * NAME7を設定します。
    * @param val String NAME7
    */
    public void setName7(String val) {
      set(TBTHB2KMEI.NAME7, val);
    }

    /**
    * NAME7を返します。
    * @return String NAME7
    */
    public String getName7() {
      return (String) get(TBTHB2KMEI.NAME7);
    }

    /**
    * NAME8を設定します。
    * @param val String NAME8
    */
    public void setName8(String val) {
      set(TBTHB2KMEI.NAME8, val);
    }

    /**
    * NAME8を返します。
    * @return String NAME8
    */
    public String getName8() {
      return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
    * NAME10を設定します。
    * @param val String NAME10
    */
    public void setName10(String val) {
      set(TBTHB2KMEI.NAME10, val);
    }

    /**
    * NAME10を返します。
    * @return String NAME10
    */
    public String getName10() {
      return (String) get(TBTHB2KMEI.NAME10);
    }

    /**
    * KNGK1を設定します。
    * @param val BigDecimal KNGK1
    */
    public void setKngk1(BigDecimal val) {
      set(TBTHB2KMEI.KNGK1, val);
    }

    /**
    * KNGK1を返します。
    * @return BigDecimal KNGK1
    */
    public BigDecimal getKngk1() {
      return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
    * KNGK2を設定します。
    * @param val BigDecimal KNGK2
    */
    public void setKngk2(BigDecimal val) {
      set(TBTHB2KMEI.KNGK2, val);
    }

    /**
    * KNGK2を返します。
    * @return BigDecimal KNGK2
    */
    public BigDecimal getKngk2() {
      return (BigDecimal) get(TBTHB2KMEI.KNGK2);
    }

    /**
    * KNGK3を設定します。
    * @param val BigDecimal KNGK3
    */
    public void setKngk3(BigDecimal val) {
      set(TBTHB2KMEI.KNGK3, val);
    }

    /**
    * KNGK3を返します。
    * @return BigDecimal KNGK3
    */
    public BigDecimal getKngk3() {
      return (BigDecimal) get(TBTHB2KMEI.KNGK3);
    }

    /**
    * RITU1を設定します。
    * @param val BigDecimal RITU1
    */
    public void setRitu1(BigDecimal val) {
      set(TBTHB2KMEI.RITU1, val);
    }
    /**
    * RITU1を返します。
    * @return BigDecimal RITU1
    */
    public BigDecimal getRitu1() {
      return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }

    /**
    * SEIGAKを設定します。
    * @param val BigDecimal SEIGAK
    */
    public void setSeigak(BigDecimal val) {
      set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
    * SEIGAKを返します。
    * @return BigDecimal SEIGAK
    */
    public BigDecimal getSeigak() {
      return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
    * SONOTA1を設定します。
    * @param val String SONOTA1
    */
    public void setSonota1(String val) {
      set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
    * SONOTA1を返します。
    * @return String SONOTA1
    */
    public String getSonota1() {
      return (String) get(TBTHB2KMEI.SONOTA1);
    }

    /**
    * SONOTA2を設定します。
    * @param val String SONOTA2
    */
    public void setSonota2(String val) {
      set(TBTHB2KMEI.SONOTA2, val);
    }

    /**
    * SONOTA2を返します。
    * @return String SONOTA2
    */
    public String getSonota2() {
      return (String) get(TBTHB2KMEI.SONOTA2);
    }

    /**
    * SONOTA3を設定します。
    * @param val String SONOTA3
    */
    public void setSonota3(String val) {
      set(TBTHB2KMEI.SONOTA3, val);
    }

    /**
    * SONOTA3を返します。
    * @return String SONOTA3
    */
    public String getSonota3() {
      return (String) get(TBTHB2KMEI.SONOTA3);
    }

    /**
    * SONOTA5を設定します。
    * @param val String SONOTA5
    */
    public void setSonota5(String val) {
      set(TBTHB2KMEI.SONOTA5, val);
    }

    /**
    * SONOTA5を返します。
    * @return String SONOTA5
    */
    public String getSonota5() {
      return (String) get(TBTHB2KMEI.SONOTA5);
    }

    /**
    * SONOTA6を設定します。
    * @param val String SONOTA6
    */
    public void setSonota6(String val) {
      set(TBTHB2KMEI.SONOTA6, val);
    }

    /**
    * SONOTA6を返します。
    * @return String SONOTA6
    */
    public String getSonota6() {
      return (String) get(TBTHB2KMEI.SONOTA6);
    }

    /**
    * SONOTA7を設定します。
    * @param val String SONOTA7
    */
    public void setSonota7(String val) {
      set(TBTHB2KMEI.SONOTA7, val);
    }

    /**
    * SONOTA7を返します。
    * @return String SONOTA7
    */
    public String getSonota7() {
      return (String) get(TBTHB2KMEI.SONOTA7);
    }

    /**
    * SONOTA8を設定します。
    * @param val String SONOTA8
    */
    public void setSonota8(String val) {
      set(TBTHB2KMEI.SONOTA8, val);
    }

    /**
    * SONOTA8を返します。
    * @return String SONOTA8
    */
    public String getSonota8() {
      return (String) get(TBTHB2KMEI.SONOTA8);
    }

    /**
    * SONOTA9を設定します。
    * @param val String SONOTA9
    */
    public void setSonota9(String val) {
      set(TBTHB2KMEI.SONOTA9, val);
    }

    /**
    * SONOTA9を返します。
    * @return String SONOTA9
    */
    public String getSonota9() {
      return (String) get(TBTHB2KMEI.SONOTA9);
    }

    //動的マスタ////////////////////////////////
    /**
     * VAL1を設定する
     * @param val VAL1
     */
    public void setVal1(String val) {
        set(VAL1, val);
    }

    /**
     * VAL1を取得する
     * @return VAL1
     */
    public String getVal1() {
        return (String) get(VAL1);
    }

    /**
     * VAL2を設定する
     * @param val VAL2
     */
    public void setVal2(String val) {
        set(VAL2, val);
    }

    /**
     * VAL2を取得する
     * @return VAL2
     */
    public String getVal2() {
        return (String) get(VAL2);
    }

    /**
     * VAL3を設定する
     * @param val VAL3
     */
    public void setVal3(String val) {
        set(VAL3, val);
    }

    /**
     * VAL3を取得する
     * @return VAL3
     */
    public String getVal3() {
        return (String) get(VAL3);
    }

    //動的マスタ////////////////////////////////

     /**
     * タイムスタンプを設定します。
     * @param val String タイムスタンプ
     */
     public void setTimstmp(Date val) {
         set(TBTHB2KMEI.TIMSTMP, val);
     }

     /**
     * タイムスタンプを返します。
     * @return String タイムスタンプ
     */
     public Date getTimstmp() {
         return (Date) get(TBTHB2KMEI.TIMSTMP);
     }

}