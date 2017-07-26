package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.nj.model.AbstractModel;

public class ReportLionVO extends AbstractModel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

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

    /** CM秒数合計 */
    public static final String BYOSU_GOKEI = "BYOSU_GOKEI";

    /** ブランドコード */
    public static final String BRAND_CD = "BRAND_CD";

    /** ブランド名 */
    public static final String BRAND_MEI = "BRAND_MEI";

    /** 局コード */
    public static final String KYOKU_CD = "KYOKU_CD";

    /** 局名 */
    public static final String KYOKU_MEI = "KYOKU_MEI";

    /** 番組コード */
    public static final String BANGUMI_CD = "BANGUMI_CD";

    /** 番組名 */
    public static final String BANGUMI_MEI = "BANGUMI_MEI";

    /** テレビ局コード */
    public static final String TV_KYOKU_CD = "TV_KYOKU_CD";

    /** テレビ局名 */
    public static final String TV_KYOKU_MEI = "TV_KYOKU_MEI";

    /** テレビ番組コード */
    public static final String TV_BANGUMI_CD = "TV_BANGUMI_CD";

    /** テレビ番組名 */
    public static final String TV_BANGUMI_MEI = "TV_BANGUMI_MEI";

    /** ラジオ局コード */
    public static final String RD_KYOKU_CD = "RD_KYOKU_CD";

    /** ラジオ局名 */
    public static final String RD_KYOKU_MEI = "RD_KYOKU_MEI";

    /** ラジオ番組コード */
    public static final String RD_BANGUMI_CD = "RD_BANGUMI_CD";

    /** ラジオ番組名 */
    public static final String RD_BANGUMI_MEI = "RD_BANGUMI_MEI";

    /** 消費税率 */
    public static final String SHOHIZEI_RITU = "SHOHIZEI_RITU";

    /** 消費税額 */
    public static final String SHOHIZEI_GAK = "SHOHIZEI_GAK";

    /**新聞コード*/
    public static final String SHINBUN_CD = "SHINBUN_CD";

    /**新聞名*/
    public static final String SHINBUN_MEI = "SHINBUN_MEI";

    /**雑誌コード*/
    public static final String ZASHI_CD = "ZASHI_CD";

    /**雑誌名*/
    public static final String ZASHI_NAME = "ZASHI_NAME";

    /**スペース*/
    public static final String SPACE = "SPACE";

    /**県名*/
    public static final String KEN_NAME = "KEN_NAME";

    /**県コード*/
    public static final String KEN_CD = "KEN_CD";

    /**路線名*/
    public static final String ROSEN_NAME = "ROSEN_NAME";

    /**期間*/
    public static final String KIKAN = "KIKAN";

    /**件名*/
    public static final String KEN_MEI = "KEN_MEI";

    /**局誌コード*/
    public static final String KYOKUSHI_CD = "KYOKUSHI_CD";

    /**局誌名*/
    public static final String KYOKUSHI_NAME = "KYOKUSHI_NAME";

    /**ジャンルコード*/
    public static final String JANLE_CD = "JANLE_CD";

    /**ジャンル名*/
    public static final String JANLE_NAME = "JANLE_NAME";

    /**プログラムコード*/
    public static final String PROGRAM_CD = "PROGRAM_CD";

    /**表示*/
    public static final String HYOJI = "HYOJI";

    /**本数*/
    public static final String HONSU = "HONSU";

    /**プログラム名*/
    public static final String PROGRAM_NAME = "PROGRAM_NAME";

    /**媒体コード*/
    public static final String BAITAI_CD = "BAITAI_CD";

    /**媒体名*/
    public static final String BAITAI_NAME = "BAITAI_NAME";

    /**
     * 新規インスタンスを構築します。
     */
    public ReportLionVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportLionVO();
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
	/**
	* 金額2を設定します。
	* @param val BigDecimal 金額2
	*/
	public void setKngk2(BigDecimal val) {
	  set(TBTHB2KMEI.KNGK2, val);
	}
	/**
	* 金額2を返します。
	* @return BigDecimal 金額2
	*/
	public BigDecimal getKngk2() {
	  return (BigDecimal) get(TBTHB2KMEI.KNGK2);
	}

	/**
	* 金額3を設定します。
	* @param val BigDecimal 金額2
	*/
	public void setKngk3(BigDecimal val) {
	  set(TBTHB2KMEI.KNGK3, val);
	}
	/**
	* 金額3を返します。
	* @return BigDecimal 金額2
	*/
	public BigDecimal getKngk3() {
	  return (BigDecimal) get(TBTHB2KMEI.KNGK3);
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
	 * 値引額を設定する
	 * @param val NEBIGAK
	 */
	public void setNebigak(BigDecimal val) {
	    set(TBTHB2KMEI.NEBIGAK, val);
	}
	/**
	 * 値引額を取得する
	 * @return NEBIGAK
	 */
	public BigDecimal getNebigak() {
	    return (BigDecimal) get(TBTHB2KMEI.NEBIGAK);
	}

	/**
     * 消費税率を設定する
     * @param val SHOHIZEI_RITU
     */
    public void setShohizeiRitu(BigDecimal val) {
        set(SHOHIZEI_RITU, val);
    }
    /**
     * 消費税率を取得する
     * @return SHOHIZEI_RITU
     */
    public BigDecimal getShohizeiRitu() {
        return (BigDecimal) get(SHOHIZEI_RITU);
    }

    /**
	 * 消費税額を設定する
	 * @param val SHOHIZEI_GAK
	 */
	public void setShohizeiGak(BigDecimal val) {
	    set(SHOHIZEI_GAK, val);
	}
	/**
	 * 消費税額を取得する
	 * @return SHOHIZEI_GAK
	 */
	public BigDecimal getShohizeiGak() {
	    return (BigDecimal) get(SHOHIZEI_GAK);
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

	/**
	 * CM秒数合計を設定する
	 * @param val BYOSU_GOKEI
	 */
	public void setByosuGokei(BigDecimal val) {
	    set(BYOSU_GOKEI, val);
	}
	/**
	 * CM秒数合計を取得する
	 * @return BYOSU_GOKEI
	 */
	public BigDecimal getByosuGokei() {
	    return (BigDecimal) get(BYOSU_GOKEI);
	}

	/**
	 * ブランドコードを設定する
	 * @param val BRAND_CD
	 */
	public void setBrandCd(String val) {
	    set(BRAND_CD, val);
	}
	/**
	 * ブランドコードを取得する
	 * @return BRAND_CD
	 */
	public String getBrandCd() {
	    return (String) get(BRAND_CD);
	}

	/**
	 * ブランド名を設定する
	 * @param val BRAND_MEI
	 */
	public void setBrandMei(String val) {
	    set(BRAND_MEI, val);
	}
	/**
	 * ブランド名を取得する
	 * @return BRAND_MEI
	 */
	public String getBrandMei() {
	    return (String) get(BRAND_MEI);
	}

	/**
	 * 局コードを設定する
	 * @param val KYOKU_CD
	 */
	public void setKyokuCd(String val) {
	    set(KYOKU_CD, val);
	}
	/**
	 * 局コードを取得する
	 * @return KYOKU_CD
	 */
	public String getKyokuCd() {
	    return (String) get(KYOKU_CD);
	}

	/**
	 * 局名を設定する
	 * @param val KYOKU_MEI
	 */
	public void setKyokuMei(String val) {
	    set(KYOKU_MEI, val);
	}
	/**
	 * 局名を取得する
	 * @return KYOKU_MEI
	 */
	public String getKyokuMei() {
	    return (String) get(KYOKU_MEI);
	}

	/**
	 * 番組コードを設定する
	 * @param val BANGUMI_CD
	 */
	public void setBangumiCd(String val) {
	    set(BANGUMI_CD, val);
	}
	/**
	 * 番組コードを取得する
	 * @return BANGUMI_CD
	 */
	public String getBangumiCd() {
	    return (String) get(BANGUMI_CD);
	}

	/**
	 * 番組名を設定する
	 * @param val BANGUMI_MEI
	 */
	public void setBangumiMei(String val) {
	    set(BANGUMI_MEI, val);
	}
	/**
	 * 番組名を取得する
	 * @return BANGUMI_MEI
	 */
	public String getBangumiMei() {
	    return (String) get(BANGUMI_MEI);
	}

	/**
	 * テレビ番組コードを設定する
	 * @param val TV_BANGUMI_CD
	 */
	public void setTvBangumiCd(String val) {
	    set(TV_BANGUMI_CD, val);
	}
	/**
	 * テレビ番組コードを取得する
	 * @return TV_BANGUMI_CD
	 */
	public String getTvBangumiCd() {
	    return (String) get(TV_BANGUMI_CD);
	}

	/**
	 * テレビ番組名を設定する
	 * @param val TV_BANGUMI_MEI
	 */
	public void setTvBangumiMei(String val) {
	    set(TV_BANGUMI_MEI, val);
	}
	/**
	 * テレビ番組名を取得する
	 * @return TV_BANGUMI_MEI
	 */
	public String getTvBangumiMei() {
	    return (String) get(TV_BANGUMI_MEI);
	}

	/**
	 * テレビ局コードを設定する
	 * @param val TV_BANGUMI_CD
	 */
	public void setTvKyokuCd(String val) {
	    set(TV_KYOKU_CD, val);
	}
	/**
	 * テレビ局コードを取得する
	 * @return TV_KYOKU_CD
	 */
	public String getTvKyokuCd() {
	    return (String) get(TV_KYOKU_CD);
	}

	/**
	 * テレビ局名を設定する
	 * @param val TV_KYOKU_MEI
	 */
	public void setTvKyokuMei(String val) {
	    set(TV_KYOKU_MEI, val);
	}
	/**
	 * テレビ局名を取得する
	 * @return TV_KYOKU_MEI
	 */
	public String getTvKyokuMei() {
	    return (String) get(TV_KYOKU_MEI);
	}

	/**
	 * ラジオ局コードを設定する
	 * @param val RD_BANGUMI_CD
	 */
	public void setRdKyokuCd(String val) {
	    set(RD_KYOKU_CD, val);
	}
	/**
	 * ラジオ局コードを取得する
	 * @return RD_KYOKU_CD
	 */
	public String getRdKyokuCd() {
	    return (String) get(RD_KYOKU_CD);
	}

	/**
	 * ラジオ局名を設定する
	 * @param val RD_KYOKU_MEI
	 */
	public void setRdKyokuMei(String val) {
	    set(RD_KYOKU_MEI, val);
	}
	/**
	 * ラジオ局名を取得する
	 * @return RD_KYOKU_MEI
	 */
	public String getRdKyokuMei() {
	    return (String) get(RD_KYOKU_MEI);
	}

	/**
	 * ラジオ番組コードを設定する
	 * @param val RD_BANGUMI_CD
	 */
	public void setRdBangumiCd(String val) {
	    set(RD_BANGUMI_CD, val);
	}
	/**
	 * ラジオ番組コードを取得する
	 * @return RD_BANGUMI_CD
	 */
	public String getRdBangumiCd() {
	    return (String) get(RD_BANGUMI_CD);
	}

	/**
	 * ラジオ番組名を設定する
	 * @param val RD_BANGUMI_MEI
	 */
	public void setRdBangumiMei(String val) {
	    set(RD_BANGUMI_MEI, val);
	}
	/**
	 * ラジオ番組名を取得する
	 * @return RD_BANGUMI_MEI
	 */
	public String getRdBangumiMei() {
	    return (String) get(RD_BANGUMI_MEI);
	}
	/**
	 * 新聞コードを設定する
	 * @param val ShinBunCd
	 */
	public void setShinCd(String val) {
	    set(SHINBUN_CD, val);
	}
	/**
	 * 新聞コードを取得する
	 * @return ShinBunCd
	 */
	public String getShinCd() {
	    return (String) get(SHINBUN_CD);
	}

	/**
	 * 新聞名を設定する
	 * @param val SHINBUN_MEI
	 */
	public void setShinMei(String val) {
	    set(SHINBUN_MEI, val);
	}
	/**
	 * 新聞名を取得する
	 * @return SHINBUN_MEI
	 */
	public String getShinMei() {
	    return (String) get(SHINBUN_MEI);
	}

	/**
	 * 雑誌コードを設定する
	 * @param val ZASHI_CD
	 */
	public void setZashiCd(String val) {
	    set(ZASHI_CD, val);
	}
	/**
	 * 雑誌コードを取得する
	 * @return ZASHI_CD
	 */
	public String getZashiCd() {
	    return (String) get(ZASHI_CD);
	}

	/**
	 * 雑誌名を設定する
	 * @param val ZASHI_NAME
	 */
	public void setZashiName(String val) {
	    set(ZASHI_NAME, val);
	}
	/**
	 * 雑誌名を取得する
	 * @return ZASHI_NAME
	 */
	public String getZashiName() {
	    return (String) get(ZASHI_NAME);
	}

//	public static String getSpace() {
//		return SPACE;
//	}
	/**
	 * スペースを設定する
	 * @param val SPACE
	 */
	public void setSpace(String val) {
	    set(SPACE, val);
	}
	/**
	 * スペースを取得する
	 * @return SPACE
	 */
	public String getSpace() {
	    return (String) get(SPACE);
	}

	/**
	 * 県名を設定する
	 * @param val KEN_NAME
	 */
	public void setKenName(String val) {
	    set(KEN_NAME, val);
	}
	/**
	 * 県名を取得する
	 * @return KEN_NAME
	 */
	public String getKenName() {
	    return (String) get(KEN_NAME);
	}

	/**
	 * 県コードを設定する
	 * @param val KEN_CD
	 */
	public void setKenCd(String val) {
	    set(KEN_CD, val);
	}
	/**
	 * 県コードを取得する
	 * @return KEN_CD
	 */
	public String getKenCd() {
	    return (String) get(KEN_CD);
	}

	/**
	 * 路線名を設定する
	 * @param val ROSEN_NAME
	 */
	public void setRosenName(String val) {
	    set(ROSEN_NAME, val);
	}
	/**
	 * 路線名を取得する
	 * @return ROSEN_NAME
	 */
	public String getRosenName() {
	    return (String) get(ROSEN_NAME);
	}

	/**
	 * 期間を設定する
	 * @param val KIKAN
	 */
	public void setKikan(String val) {
	    set(KIKAN, val);
	}
	/**
	 * 期間を取得する
	 * @return KIKAN
	 */
	public String getKikan() {
	    return (String) get(KIKAN);
	}

	/**
	 * 件名を設定する
	 * @param val KEN_MEI
	 */
	public void setKenMei(String val) {
	    set(KEN_MEI, val);
	}
	/**
	 * 件名を取得する
	 * @return KEN_MEI
	 */
	public String getKenMei() {
	    return (String) get(KEN_MEI);
	}

	/**
	 * 局誌コードを設定する
	 * @param val KYOKUSHI_CD
	 */
	public void setKyokushiCd(String val) {
	    set(KYOKUSHI_CD, val);
	}
	/**
	 * 局誌コードを取得する
	 * @return KYOKUSHI_CD
	 */
	public String getKyokushiCd() {
	    return (String) get(KYOKUSHI_CD);
	}

	/**
	 * 局誌名を設定する
	 * @param val KYOKUSHI_NAME
	 */
	public void setKyokushiName(String val) {
	    set(KYOKUSHI_NAME, val);
	}
	/**
	 * 局誌名を取得する
	 * @return KYOKUSHI_NAME
	 */
	public String getKyokushiName() {
	    return (String) get(KYOKUSHI_NAME);
	}

	/**
	 * ジャンルコードを設定する
	 * @param val JANLE_CD
	 */
	public void setJanleCd(String val) {
	    set(JANLE_CD, val);
	}
	/**
	 * ジャンルコードを取得する
	 * @return JANLE_CD
	 */
	public String getJanleCd() {
	    return (String) get(JANLE_CD);
	}

	/**
	 * ジャンル名を設定する
	 * @param val JANLE_NAME
	 */
	public void setJanleName(String val) {
	    set(JANLE_NAME, val);
	}
	/**
	 * ジャンル名を取得する
	 * @return JANLE_NAME
	 */
	public String getJanleName() {
	    return (String) get(JANLE_NAME);
	}

	/**
	 *プログラムコードを設定する
	 * @param val PROGRAM_CD
	 */
	public void setProgramCd(String val) {
	    set(PROGRAM_CD, val);
	}
	/**
	 *プログラムコードを取得する
	 * @return PROGRAM_CD
	 */
	public String getProgramCd() {
	    return (String) get(PROGRAM_CD);
	}

	/**
	 * 表示を設定する
	 * @param val HYOJI
	 */
	public void setHyoji(BigDecimal val) {
	    set(HYOJI, val);
	}
	/**
	 * 表示を取得する
	 * @return HYOJI
	 */
	public BigDecimal getHyoji() {
	    return (BigDecimal) get(HYOJI);
	}

	/**
	 *本数を設定する
	 * @param val HONSU
	 */
	public void setHonsu(String val) {
	    set(HONSU, val);
	}
	/**
	 *本数を取得する
	 * @return HONSU
	 */
	public String getHonsu() {
	    return (String) get(HONSU);
	}

	/**
	 *プログラム名を設定する
	 * @param val PROGRAM_NAME
	 */
	public void setProgramName(String val) {
	    set(PROGRAM_NAME, val);
	}
	/**
	 *プログラム名を取得する
	 * @return PROGRAM_NAME
	 */
	public String getProgramName() {
	    return (String) get(PROGRAM_NAME);
	}

	/**
	 *媒体コードを設定する
	 * @param val BAITAI_CD
	 */
	public void setBaitaiCd(String val) {
	    set(BAITAI_CD, val);
	}
	/**
	 *媒体コードを取得する
	 * @return BAITAI_CD
	 */
	public String getBaitaiCd() {
	    return (String) get(BAITAI_CD);
	}

	/**
	 *媒体名を設定する
	 * @param val BAITAI_NAME
	 */
	public void setBaitaiName(String val) {
	    set(BAITAI_NAME, val);
	}
	/**
	 *媒体名を取得する
	 * @return BAITAI_NAME
	 */
	public String getBaitaiName() {
	    return (String) get(BAITAI_NAME);
	}
}
