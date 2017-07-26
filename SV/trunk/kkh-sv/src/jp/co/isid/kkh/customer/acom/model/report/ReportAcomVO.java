package jp.co.isid.kkh.customer.acom.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.nj.model.AbstractModel;

public class ReportAcomVO extends AbstractModel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    /** アコムレポートテーブル */
    //public static String TBNAME = "ACOMREP";



    /** 場所  */
    public static final String BASHO = "BASHO";

    /** サイズ */
    public static final String SAIZU = "SAIZU";

    /** 記雑 */
    public static final String KIZATSU = "KIZATSU";

    /** 朝夕 */
    public static final String CHOYU = "CHOYU";

    /** メディア */
    public static final String MEDIA = "MEDIA";

    /** メディア(略) */
    public static final String MEDIARYA = "MEDIARYA";

    /** 色刷 */
    public static final String IROZURI = "IROZURI";

	/**
     * 新規インスタンスを構築します。
     */
    public ReportAcomVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportAcomVO();
    }

	/**
	 * 受注NOを設定します。
	 * @param val String 受注NO
	 */
	 public void setJyutNo(String val) {
	     set(TBTHB2KMEI.JYUTNO, val);
	 }

	 /**
	 * 受注NOを返します。
	 * @return String 受注NO
	 */
	 public String getJyutNo() {
	     return (String) get(TBTHB2KMEI.JYUTNO);
	 }

	/**
	* 受注明細NOを設定します。
	* @param val String 受注明細NO
	*/
	public void setJyMeiNo(String val) {
	  set(TBTHB2KMEI.JYMEINO, val);
	}

	/**
	* 受注明細NOを返します。
	* @return String 受注明細NO
	*/
	public String getJyMeiNo() {
	  return (String) get(TBTHB2KMEI.JYMEINO);
	}

	/**
	* 売上明細NOを設定します。
	* @param val String 売上明細NO
	*/
	public void setUrMeiNo(String val) {
	  set(TBTHB2KMEI.URMEINO, val);
	}

	/**
	* 売上明細NOを返します。
	* @return String 売上明細NO
	*/
	public String getUrMeiNo() {
	  return (String) get(TBTHB2KMEI.URMEINO);
	}

//	/**
//	* 掲載日を設定します。
//	* @param val String 掲載日
//	*/
//	public void setDate1(String val) {
//	  set(TBTHB2KMEI.DATE1, val);
//	}
//
//	/**
//	* 掲載日を返します。
//	* @return String 掲載日
//	*/
//	public String getDate1() {
//	  return (String) get(TBTHB2KMEI.DATE1);
//	}
//
//	/**
//	* CODE1を設定します。
//	* @param val String CODE1
//	*/
//	public void setCode1(String val) {
//	  set(TBTHB2KMEI.CODE1, val);
//	}
//
//	/**
//	* CODE1を返します。
//	* @return String CODE1
//	*/
//	public String getCode1() {
//	  return (String) get(TBTHB2KMEI.CODE1);
//	}

	/**
	* CODE2を設定します。
	* @param val String CODE2
	*/
	public void setCode2(String val) {
	  set(TBTHB2KMEI.CODE2, val);
	}

	/**
	* CODE2を返します。
	* @return String CODE2
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

//	/**
//	* NAME1を設定します。
//	* @param val String NAME1
//	*/
//	public void setName1(String val) {
//	  set(TBTHB2KMEI.NAME1, val);
//	}
//
//	/**
//	* NAME1を返します。
//	* @return String NAME1
//	*/
//	public String getName1() {
//	  return (String) get(TBTHB2KMEI.NAME1);
//	}
//
//	/**
//	* NAME2を設定します。
//	* @param val String NAME2
//	*/
//	public void setName2(String val) {
//	  set(TBTHB2KMEI.NAME2, val);
//	}
//
//	/**
//	* NAME2を返します。
//	* @return String NAME2
//	*/
//	public String getName2() {
//	  return (String) get(TBTHB2KMEI.NAME2);
//	}

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
	* NAME11を設定します。
	* @param val String NAME11
	*/
	public void setName11(String val) {
	  set(TBTHB2KMEI.NAME11, val);
	}
	/**
	* NAME11を返します。
	* @return String NAME11
	*/
	public String getName11() {
	  return (String) get(TBTHB2KMEI.NAME11);
	}

	/**
	* NAME12を設定します。
	* @param val String NAME12
	*/
	public void setName12(String val) {
	  set(TBTHB2KMEI.NAME12, val);
	}
	/**
	* NAME12を返します。
	* @return String NAME12
	*/
	public String getName12() {
	  return (String) get(TBTHB2KMEI.NAME12);
	}

	/**
	* Name13を設定します。
	* @param val String NAME13
	*/
	public void setName13(String val) {
	  set(TBTHB2KMEI.NAME13, val);
	}
	/**
	* NAME13を返します。
	* @return String NAME13
	*/
	public String getName13() {
	  return (String) get(TBTHB2KMEI.NAME13);
	}

	/**
	* NAME14を設定します。
	* @param val String NAME14
	*/
	public void setName14(String val) {
	  set(TBTHB2KMEI.NAME14, val);
	}
	/**
	* NAME14を返します。
	* @return String NAME14
	*/
	public String getName14() {
	  return (String) get(TBTHB2KMEI.NAME14);
	}

	/**
	* NAME15を設定します。
	* @param val String NAME15
	*/
	public void setName15(String val) {
	  set(TBTHB2KMEI.NAME15, val);
	}
	/**
	* NAME15を返します。
	* @return String NAME15
	*/
	public String getName15() {
	  return (String) get(TBTHB2KMEI.NAME15);
	}

	/**
	* NAME15を設定します。
	* @param val String NAME16
	*/
	public void setName16(String val) {
	  set(TBTHB2KMEI.NAME16, val);
	}
	/**
	* NAME16を返します。
	* @return String NAME16
	*/
	public String getName16() {
	  return (String) get(TBTHB2KMEI.NAME16);
	}

	/**
	* NAME17を設定します。
	* @param val String NAME17
	*/
	public void setName17(String val) {
	  set(TBTHB2KMEI.NAME17, val);
	}
	/**
	* NAME17を返します。
	* @return String NAME17
	*/
	public String getName17() {
	  return (String) get(TBTHB2KMEI.NAME17);
	}

	/**
	* 区分2を設定します。
	* @param val String 区分2
	*/
	public void setKbn2(String val) {
	  set(TBTHB2KMEI.KBN2, val);
	}

	/**
	* 区分2を返します。
	* @return String 区分2
	*/
	public String getKbn2() {
	  return (String) get(TBTHB2KMEI.KBN2);
	}

//
//	/**
//	* 金額1を設定します。
//	* @param val BigDecimal 金額1
//	*/
//	public void setKngk1(BigDecimal val) {
//	  set(TBTHB2KMEI.KNGK1, val);
//	}
//
//	/**
//	* 金額1を返します。
//	* @return BigDecimal 金額1
//	*/
//	public BigDecimal getKngk1() {
//	  return (BigDecimal) get(TBTHB2KMEI.KNGK1);
//	}
//
//	/**
//	* 金額2を設定します。
//	* @param val BigDecimal 金額2
//	*/
//	public void setKngk2(BigDecimal val) {
//	  set(TBTHB2KMEI.KNGK2, val);
//	}
//
//	/**
//	* 金額2を返します。
//	* @return BigDecimal 金額2
//	*/
//	public BigDecimal getKngk2() {
//	  return (BigDecimal) get(TBTHB2KMEI.KNGK2);
//	}


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
	* RENBNを設定します。
	* @param val String RENBN
	*/
	public void setRenbn(String val) {
	  set(TBTHB2KMEI.RENBN, val);
	}

	/**
	* RENBNを返します。
	* @return String RENBN
	*/
	public String getRenbn() {
	  return (String) get(TBTHB2KMEI.RENBN);
	}


	/**
	* YYMMを設定します。
	* @param val String YYMM
	*/
	public void setYymm(String val) {
	  set(TBTHB1DOWN.YYMM, val);
	}
	/**
	* YYMMを返します。
	* @return String YYMM
	*/
	public String getYymm() {
	  return (String) get(TBTHB1DOWN.YYMM);
	}

	/**
	* FIELD1を設定します。
	* @param val String FIELD1
	*/
	public void setField1(String val) {
	  set(TBTHB1DOWN.FIELD1, val);
	}
	/**
	* FIELD1を返します。
	* @return String FIELD1
	*/
	public String getField1() {
	  return (String) get(TBTHB1DOWN.FIELD1);
	}

	/**
	* FIELD2を設定します。
	* @param val String FIELD2
	*/
	public void setField2(String val) {
	  set(TBTHB1DOWN.FIELD2, val);
	}

	/**
	* FIELD2を返します。
	* @return String FIELD2
	*/
	public String getField2() {
	  return (String) get(TBTHB1DOWN.FIELD2);
	}

	/**
	* FIELD3を設定します。
	* @param val String FIELD3
	*/
	public void setField3(String val) {
	  set(TBTHB1DOWN.FIELD3, val);
	}

	/**
	* FIELD3を返します。
	* @return String FIELD3
	*/
	public String getField3() {
	  return (String) get(TBTHB1DOWN.FIELD3);
	}

	/**
	 * FIELD4を取得する
	 * @return FIELD4
	 */
	public String getField4() {
	    return (String) get(TBTHB1DOWN.FIELD4);
	}

	/**
	 * FIELD4を設定する
	 * @param val FIELD4
	 */
	public void setField4(String val) {
	    set(TBTHB1DOWN.FIELD4, val);
	}

	/**
	 * FIELD5を取得する
	 * @return FIELD5
	 */
	public String getField5() {
	    return (String) get(TBTHB1DOWN.FIELD5);
	}

	/**
	 * FIELD5を設定する
	 * @param val FIELD5
	 */
	public void setField5(String val) {
	    set(TBTHB1DOWN.FIELD5, val);
	}

	/**
	 * FIELD6を取得する
	 * @return FIELD6
	 */
	public String getField6() {
	    return (String) get(TBTHB1DOWN.FIELD6);
	}
	/**
	 * FIELD6を設定する
	 * @param val FIELD6
	 */
	public void setField6(String val) {
	    set(TBTHB1DOWN.FIELD6, val);
	}

	/**
	 * FIELD7を取得する
	 * @return FIELD7
	 */
	public String getField7() {
	    return (String) get(TBTHB1DOWN.FIELD7);
	}
	/**
	 * FIELD7を設定する
	 * @param val FIELD7
	 */
	public void setField7(String val) {
	    set(TBTHB1DOWN.FIELD7, val);
	}

	/**
	* FIELD8を設定します。
	* @param val String FIELD8
	*/
	public void setField8(String val) {
	  set(TBTHB1DOWN.FIELD8, val);
	}

	/**
	* FIELD8を返します。
	* @return String FIELD8
	*/
	public String getField8() {
	  return (String) get(TBTHB1DOWN.FIELD8);
	}

	/**
	* FIELD9を設定します。
	* @param val String FIELD9
	*/
	public void setField9(String val) {
	  set(TBTHB1DOWN.FIELD9, val);
	}

	/**
	* FIELD9を返します。
	* @return String FIELD9
	*/
	public String getField9() {
	  return (String) get(TBTHB1DOWN.FIELD9);
	}

	/**
	* FIELD11を設定します。
	* @param val String FIELD11
	*/
	public void setField11(String val) {
	  set(TBTHB1DOWN.FIELD11, val);
	}

	/**
	* FIELD11を返します。
	* @return String FIELD11
	*/
	public String getField11() {
	  return (String) get(TBTHB1DOWN.FIELD11);
	}

	/**
	 * SONOTA7を設定する
	 * @param val SONOTA7
	 */
	public void setSonota7(String val) {
	    set(TBTHB2KMEI.SONOTA7, val);
	}

	/**
	 * SONOTA7を返す
	 * @return String SONOTA7
	 */
	public String getSonota7() {
	    return (String) get(TBTHB2KMEI.SONOTA7);
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

	/**
	 * タイムスポット区分を設定する
	 * @param val TMSPKBN
	 */
	public void setTmspkbn(String val) {
	    set(TBTHB1DOWN.TMSPKBN, val);
	}
	/**
	 * タイムスポット区分を取得する
	 * @return TMSPKBN
	 */
	public String getTmspkbn() {
	    return (String) get(TBTHB1DOWN.TMSPKBN);
	}

	/**
	 * GYOMKBNを設定する
	 * @param val GYOMKBN
	 */
	public void setGyomkbn(String val) {
	    set(TBTHB1DOWN.GYOMKBN, val);
	}

	/**
	 * GYOMKBNを取得する
	 * @return GYOMKBN
	 */
	public String getGyomkbn() {
	    return (String) get(TBTHB1DOWN.GYOMKBN);
	}

	/**
	 * 業務区分名称を設定する
	 * @param val GYOMKBNMEI
	 */
	public void setGyomKbnMei(String val) {
	    set(TBRCMN_MEU29CC.MEU29_NAIYJ, val);
	}
	/**
	 * 業務区分名称を取得する
	 * @return GYOMKBNMEI
	 */
	public String getGyomKbnMei() {
	    return (String) get(TBRCMN_MEU29CC.MEU29_NAIYJ);
	}

	/**
	* KKNAMEKJを設定します。
	* @param val String KKNAMEKJ
	*/
	public void setKkNameKj(String val) {
	  set(TBTHB1DOWN.KKNAMEKJ, val);
	}

	/**
	* KKNAMEKJを返します。
	* @return String KKNAMEKJ
	*/
	public String getKkNameKj() {
	  return (String) get(TBTHB1DOWN.KKNAMEKJ);
	}

	/**
	 * HIMKNMKJを設定する
	 * @param val HIMKNMKJ
	 */
	public void setHimknmkj(String val) {
	    set(TBTHB1DOWN.HIMKNMKJ, val);
	}

	/**
	 * HIMKNMKJを取得する
	 * @return HIMKNMKJ
	 */
	public String getHimknmkj() {
	    return (String) get(TBTHB1DOWN.HIMKNMKJ);
	}

	/**
	* 請求金額を設定します。
	* @param val String 請求金額
	*/
	public void setSeiGak(BigDecimal val) {
	  set(TBTHB2KMEI.SEIGAK, val);
	}

	/**
	* 請求金額を返します。
	* @return String 請求金額
	*/
	public BigDecimal getSeiGak() {
	  return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
	}

	/**
	 * NEBIGAKを設定する
	 * @param val NEBIGAK
	 */
	public void setNebigak(BigDecimal val) {
	    set(TBTHB2KMEI.NEBIGAK, val);
	}

	/**
	 * NEBIGAKを取得する
	 * @return NEBIGAK
	 */
	public BigDecimal getNebigak() {
	    return (BigDecimal) get(TBTHB2KMEI.NEBIGAK);
	}

	/**
	 * 場所を設定する
	 * @param val BASHO
	 */
	public void setBasho(String val) {
	    set(BASHO, val);
	}

	/**
	 * 場所を取得する
	 * @return BASHO
	 */
	public String getBasho() {
	    return (String) get(BASHO);
	}

	/**
	 * サイズを設定する
	 * @param val SIZE_
	 */
	public void setSaizu(String val) {
	    set(SAIZU, val);
	}

	/**
	 * サイズを取得する
	 * @return SAIZU
	 */
	public String getSaizu() {
	    return (String) get(SAIZU);
	}

	/**
	 * 記雑を設定する
	 * @param val KIZATSU
	 */
	public void setKizatsu(String val) {
	    set(KIZATSU, val);
	}

	/**
	 * 記雑を取得する
	 * @return KIZATSU
	 */
	public String getKizatsu() {
	    return (String) get(KIZATSU);
	}

	/**
	 * 朝夕を設定する
	 * @param val CHOYU
	 */
	public void setChoyu(String val) {
	    set(CHOYU, val);
	}
	/**
	 * 朝夕を取得する
	 * @return CHOYU
	 */
	public String getChoyu() {
	    return (String) get(CHOYU);
	}

	/**
	 * メディアを設定する
	 * @param val MEDIA
	 */
	public void setMedia(String val) {
	    set(MEDIA, val);
	}
	/**
	 * メディアを取得する
	 * @return MEDIA
	 */
	public String getMedia() {
	    return (String) get(MEDIA);
	}

	/**
	 * メディア(略)を設定する
	 * @param val MEDIARYA
	 */
	public void setMediaRya(String val) {
	    set(MEDIARYA, val);
	}
	/**
	 * メディア(略)を取得する
	 * @return MEDIARYA
	 */
	public String getMediaRya() {
	    return (String) get(MEDIARYA);
	}

	/**
	 * 色刷を設定する
	 * @param val IROZURI
	 */
	public void setIrozuri(String val) {
	    set(IROZURI, val);
	}
	/**
	 * 色刷を取得する
	 * @return IROZURI
	 */
	public String getIrozuri() {
	    return (String) get(IROZURI);
	}
}
