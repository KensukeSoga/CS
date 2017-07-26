package jp.co.isid.kkh.customer.acom.model.input;

import java.math.BigDecimal;

/**
 * <P>
 * 発注データマスタ検索条件。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikCommonCondition {

    /** 年度 */
    private String _year;

    /** 種別 */
    private String _syubetsu;

    /** 得意先企業コード */
    private String _tkskgycd;

    /** 得意先部門SEQNO */
    private String _tksbmnseqno;

    /** 得意先担当SEQNO */
    private String _tkstntseqno;

	/** 更新区分 */
	private String _KouKbn;

	/** 履歴管理番号 */
	private String _RireNo;

	/** レコード種別 */
	private String _RecCd;

	/** 依頼年月 */
	private String _Iryymm;

	/** 発注番号 */
	private String _Irban;

	/** 行番号 */
	private String _Irrowban;

	/** メディアコード */
	private String _MediaCd;

	/** メディア名 */
	private String _MediaName;

	/** サイズコード */
	private String _SizeCd;

	/** サイズ */
	private String _SizeName;

	/** 掲載日1 */
	private String _Keisai1;

	/** 掲載日2 */
	private String _Keisai2;

	/** 掲載日3 */
	private String _Keisai3;

	/** 掲載日4 */
	private String _Keisai4;

	/** 掲載日5 */
	private String _Keisai5;

	/** 形態区分コード */
	private String _KeitaiCd;

	/** 形態区分名 */
	private String _KeitaiName;

	/** 依頼月1 */
	private String _Irmonth1;

	/** 放送料1 */
	private BigDecimal _Hosoryo1;

	/** 依頼月2 */
	private String _Irmonth2;

	/** 放送料2 */
	private BigDecimal _Hosoryo2;

	/** 依頼月3 */
	private String _Irmonth3;

	/** 放送料3 */
	private BigDecimal _Hosoryo3;

	/** 依頼月4 */
	private String _Irmonth4;

	/** 放送料4 */
	private BigDecimal _Hosoryo4;

	/** 依頼月5 */
	private String _Irmonth5;

	/** 放送料5 */
	private BigDecimal _Hosoryo5;

	/** 依頼月6 */
	private String _Irmonth6;

	/** 放送料6 */
	private BigDecimal _Hosoryo6;

	/** 交通掲載コード */
	private String _KotukeiCd;

	/** 交通掲載名 */
	private String _KotukeiName;

	/** 掲載日 */
	private String _Keisai;

	/** 掲載料 */
	private BigDecimal _Keisairyo;

	/** 掲載単価 */
	private String _KeisaiTanka;

	/** 掲載回数 */
	private String _KeisaiCnt;

	/** 商品区分 */
	private String _SyohiKbn;

	/** 細目区分 */
	private String _SaiKbn;

	/** 摘要コード */
	private String _TekiCd;

	/** 売上予定年月 */
	private String _Uriyymm;

	/** 担当者名 */
	private String _TanName;

	/** 担当者勤務部署名 */
	private String _TankinName;

	/** 按分種別 */
	private String _Ansyube;

	/** 備考1 */
	private String _Bikou1;

	/** 備考2 */
	private String _Bikou2;

	/** 色刷コード */
	private String _ColorCd;

	/** デザイン変更回数 */
	private String _DesignCnt;

	/** 印刷代 */
	private BigDecimal _Printryo;

	/** 差替作業料 */
	private BigDecimal _Sashikaeryo;

	/** デザイン料 */
	private BigDecimal _Designryo;

	/** 版下代 */
	private BigDecimal _Hanshitaryo;

	/** 製版代 */
	private BigDecimal _Seihanryo;

	/** 登録年月日 */
	private String _TouDate;

	/** 変更年月日 */
	private String _HenDate;

	/** 取消年月日     */
	private String _TorDate;


    /**
    * 新規インスタンスを構築します。
    */
    public HikCommonCondition() {
    }

    /**
     * 年度を取得します。
     * @return 年度
     */
    public String getYear() {
        return _year;
    }

    /**
     * 年度を設定します。
     * @param year 年度
     */
    public void setYear(String year) {
        _year = year;
    }

    /**
     * 種別を取得します。
     * @return String 種別
     */
    public String getSyubetsu() {
        return _syubetsu;
    }

    /**
     * 種別を設定します。
     * @param syubetsu String 種別
     */
    public void setSyubetsu(String syubetsu) {
        _syubetsu = syubetsu;
    }

    /**
     * 得意先企業コードを取得します。
     * @return String 得意先企業コード
     */
    public String getTkskgycd() {
        return _tkskgycd;
    }

    /**
     * 得意先企業コードを設定します。
     * @param syubetsu String 得意先企業コード
     */
    public void setTkskgycd(String tkskgycd) {
    	_tkskgycd = tkskgycd;
    }


    /**
     * 得意先部門SEQNOを取得します。
     * @return String 得意先部門SEQNO
     */
    public String getTksbmnseqno() {
        return _tksbmnseqno;
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param syubetsu String 得意先担当SEQNO
     */
    public void setTksbmnseqno(String tksbmnseqno) {
    	_tksbmnseqno = tksbmnseqno;
    }

    /**
     * 得意先担当SEQNOを取得します。
     * @return String 得意先担当SEQNO
     */
    public String getTkstntseqno() {
        return _tkstntseqno;
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param syubetsu String 得意先担当SEQNO
     */
    public void setTkstntseqno(String tkstntseqno) {
    	_tkstntseqno = tkstntseqno;
    }

	/**
	 * 更新区分を取得する
	 @return 更新区分
	 */
	public String getKouKbn() {
	    return _KouKbn;
	}

	/**
	 * 更新区分を設定する
	 @param KouKbn 更新区分
	 */
	public void setKouKbn(String KouKbn) {
	    this._KouKbn = KouKbn;
	}

	/**
	 * 履歴管理番号を取得する
	 @return 履歴管理番号
	 */
	public String getRireNo() {
	    return _RireNo;
	}

	/**
	 * 履歴管理番号を設定する
	 @param RireNo 履歴管理番号
	 */
	public void setRireNo(String RireNo) {
	    this._RireNo = RireNo;
	}

	/**
	 * レコード種別を取得する
	 @return RecCd レコード種別
	 */
	public String getRecCd() {
	    return _RecCd;
	}

	/**
	 * レコード種別を設定する
	 @param RecCd レコード種別
	 */
	public void setRecCd(String RecCd) {
	    this._RecCd = RecCd;
	}

	/**
	 * 依頼年月を取得する
	 @return 依頼年月
	 */
	public String getIryymm() {
	    return _Iryymm;
	}

	/**
	 * 依頼年月を設定する
	 @param Iryymm 依頼年月
	 */
	public void setIryymm(String Iryymm) {
	    this._Iryymm = Iryymm;
	}

	/**
	 * 発注番号を取得する
	 @return 発注番号
	 */
	public String getIrban() {
	    return _Irban;
	}

	/**
	 * 発注番号を設定する
	 @param Irban 発注番号
	 */
	public void setIrban(String Irban) {
	    this._Irban = Irban;
	}

	/**
	 * 行番号を取得する
	 @return 行番号
	 */
	public String getIrrowban() {
	    return _Irrowban;
	}

	/**
	 * 行番号を設定する
	 @param Irrowban 行番号
	 */
	public void setIrrowban(String Irrowban) {
	    this._Irrowban = Irrowban;
	}

	/**
	 * メディアコードを取得する
	 @return メディアコード
	 */
	public String getMediaCd() {
	    return _MediaCd;
	}

	/**
	 * メディアコードを設定する
	 @param MediaCd メディアコード
	 */
	public void setMediaCd(String MediaCd) {
	    this._MediaCd = MediaCd;
	}

	/**
	 * メディア名を取得する
	 @return メディア名
	 */
	public String getMediaName() {
	    return _MediaName;
	}

	/**
	 * メディア名を設定する
	 @param MediaName メディア名
	 */
	public void setMediaName(String MediaName) {
	    this._MediaName = MediaName;
	}

	/**
	 * サイズコードを取得する
	 @return サイズコード
	 */
	public String getSizeCd() {
	    return _SizeCd;
	}

	/**
	 * サイズコードを設定する
	 @param SizeCd サイズコード
	 */
	public void setSizeCd(String SizeCd) {
	    this._SizeCd = SizeCd;
	}

	/**
	 * サイズを取得する
	 @return サイズ
	 */
	public String getSizeName() {
	    return _SizeName;
	}

	/**
	 * サイズを設定する
	 @param SizeName サイズ
	 */
	public void setSizeName(String SizeName) {
	    this._SizeName = SizeName;
	}

	/**
	 * 掲載日1を取得する
	 @return 掲載日1
	 */
	public String getKeisai1() {
	    return _Keisai1;
	}

	/**
	 * 掲載日1を設定する
	 @param Keisai1 掲載日1
	 */
	public void setKeisai1(String Keisai1) {
	    this._Keisai1 = Keisai1;
	}

	/**
	 * 掲載日2を取得する
	 @return 掲載日2
	 */
	public String getKeisai2() {
	    return _Keisai2;
	}

	/**
	 * 掲載日2を設定する
	 @param Keisai2 掲載日2
	 */
	public void setKeisai2(String Keisai2) {
	    this._Keisai2 = Keisai2;
	}

	/**
	 * 掲載日3を取得する
	 @return 掲載日3
	 */
	public String getKeisai3() {
	    return _Keisai3;
	}

	/**
	 * 掲載日3を設定する
	 @param Keisai3 掲載日3
	 */
	public void setKeisai3(String Keisai3) {
	    this._Keisai3 = Keisai3;
	}

	/**
	 * 掲載日4を取得する
	 @return 掲載日4
	 */
	public String getKeisai4() {
	    return _Keisai4;
	}

	/**
	 * 掲載日4を設定する
	 @param Keisai4 掲載日4
	 */
	public void setKeisai4(String Keisai4) {
	    this._Keisai4 = Keisai4;
	}

	/**
	 * 掲載日5を取得する
	 @return 掲載日5
	 */
	public String getKeisai5() {
	    return _Keisai5;
	}

	/**
	 * 掲載日5を設定する
	 @param Keisai5 掲載日5
	 */
	public void setKeisai5(String Keisai5) {
	    this._Keisai5 = Keisai5;
	}

	/**
	 * 形態区分コードを取得する
	 @return 形態区分コード
	 */
	public String getKeitaiCd() {
	    return _KeitaiCd;
	}

	/**
	 * 形態区分コードを設定する
	 @param KeitaiCd 形態区分コード
	 */
	public void setKeitaiCd(String KeitaiCd) {
	    this._KeitaiCd = KeitaiCd;
	}

	/**
	 * 形態区分名を取得する
	 @return 形態区分名
	 */
	public String getKeitaiName() {
	    return _KeitaiName;
	}

	/**
	 * 形態区分名を設定する
	 @param KeitaiName 形態区分名
	 */
	public void setKeitaiName(String KeitaiName) {
	    this._KeitaiName = KeitaiName;
	}

	/**
	 * 依頼月1を取得する
	 @return 依頼月1
	 */
	public String getIrmonth1() {
	    return _Irmonth1;
	}

	/**
	 * 依頼月1を設定する
	 @param Irmonth1 依頼月1
	 */
	public void setIrmonth1(String Irmonth1) {
	    this._Irmonth1 = Irmonth1;
	}

	/**
	 * 放送料1を取得する
	 @return 放送料1
	 */
	public BigDecimal getHosoryo1() {
	    return _Hosoryo1;
	}

	/**
	 * 放送料1を設定する
	 @param Hosoryo1 放送料1
	 */
	public void setHosoryo1(BigDecimal Hosoryo1) {
	    this._Hosoryo1 = Hosoryo1;
	}

	/**
	 * 依頼月2を取得する
	 @return 依頼月2
	 */
	public String getIrmonth2() {
	    return _Irmonth2;
	}

	/**
	 * 依頼月2を設定する
	 @param Irmonth2 依頼月2
	 */
	public void setIrmonth2(String Irmonth2) {
	    this._Irmonth2 = Irmonth2;
	}

	/**
	 * 放送料2を取得する
	 @return 放送料2
	 */
	public BigDecimal getHosoryo2() {
	    return _Hosoryo2;
	}

	/**
	 * 放送料2を設定する
	 @param Hosoryo2 放送料2
	 */
	public void setHosoryo2(BigDecimal Hosoryo2) {
	    this._Hosoryo2 = Hosoryo2;
	}

	/**
	 * 依頼月3を取得する
	 @return 依頼月3
	 */
	public String getIrmonth3() {
	    return _Irmonth3;
	}

	/**
	 * 依頼月3を設定する
	 @param Irmonth3 依頼月3
	 */
	public void setIrmonth3(String Irmonth3) {
	    this._Irmonth3 = Irmonth3;
	}

	/**
	 * 放送料3を取得する
	 @return 放送料3
	 */
	public BigDecimal getHosoryo3() {
	    return _Hosoryo3;
	}

	/**
	 * 放送料3を設定する
	 @param Hosoryo3 放送料3
	 */
	public void setHosoryo3(BigDecimal Hosoryo3) {
	    this._Hosoryo3 = Hosoryo3;
	}

	/**
	 * 依頼月4を取得する
	 @return 依頼月4
	 */
	public String getIrmonth4() {
	    return _Irmonth4;
	}

	/**
	 * 依頼月4を設定する
	 @param Irmonth4 依頼月4
	 */
	public void setIrmonth4(String Irmonth4) {
	    this._Irmonth4 = Irmonth4;
	}

	/**
	 * 放送料4を取得する
	 @return 放送料4
	 */
	public BigDecimal getHosoryo4() {
	    return _Hosoryo4;
	}

	/**
	 * 放送料4を設定する
	 @param Hosoryo4 放送料4
	 */
	public void setHosoryo4(BigDecimal Hosoryo4) {
	    this._Hosoryo4 = Hosoryo4;
	}

	/**
	 * 依頼月5を取得する
	 @return 依頼月5
	 */
	public String getIrmonth5() {
	    return _Irmonth5;
	}

	/**
	 * 依頼月5を設定する
	 @param Irmonth5 依頼月5
	 */
	public void setIrmonth5(String Irmonth5) {
	    this._Irmonth5 = Irmonth5;
	}

	/**
	 * 放送料5を取得する
	 @return 放送料5
	 */
	public BigDecimal getHosoryo5() {
	    return _Hosoryo5;
	}

	/**
	 * 放送料5を設定する
	 @param Hosoryo5 放送料5
	 */
	public void setHosoryo5(BigDecimal Hosoryo5) {
	    this._Hosoryo5 = Hosoryo5;
	}

	/**
	 * 依頼月6を取得する
	 @return 依頼月6
	 */
	public String getIrmonth6() {
	    return _Irmonth6;
	}

	/**
	 * 依頼月6を設定する
	 @param Irmonth6 依頼月6
	 */
	public void setIrmonth6(String Irmonth6) {
	    this._Irmonth6 = Irmonth6;
	}

	/**
	 * 放送料6を取得する
	 @return 放送料6
	 */
	public BigDecimal getHosoryo6() {
	    return _Hosoryo6;
	}

	/**
	 * 放送料6を設定する
	 @param Hosoryo6 放送料6
	 */
	public void setHosoryo6(BigDecimal Hosoryo6) {
	    this._Hosoryo6 = Hosoryo6;
	}

	/**
	 * 交通掲載コードを取得する
	 @return 交通掲載コード
	 */
	public String getKotukeiCd() {
	    return _KotukeiCd;
	}

	/**
	 * 交通掲載コードを設定する
	 @param KotukeiCd 交通掲載コード
	 */
	public void setKotukeiCd(String KotukeiCd) {
	    this._KotukeiCd = KotukeiCd;
	}

	/**
	 * 交通掲載名を取得する
	 @return 交通掲載名
	 */
	public String getKotukeiName() {
	    return _KotukeiName;
	}

	/**
	 * 交通掲載名を設定する
	 @param KotukeiName 交通掲載名
	 */
	public void setKotukeiName(String KotukeiName) {
	    this._KotukeiName = KotukeiName;
	}

	/**
	 * 掲載日を取得する
	 @return 掲載日
	 */
	public String getKeisai() {
	    return _Keisai;
	}

	/**
	 * 掲載日を設定する
	 @param Keisai 掲載日
	 */
	public void setKeisai(String Keisai) {
	    this._Keisai = Keisai;
	}

	/**
	 * 掲載料を取得する
	 @return 掲載料
	 */
	public BigDecimal getKeisairyo() {
	    return _Keisairyo;
	}

	/**
	 * 掲載料を設定する
	 @param Keisairyo 掲載料
	 */
	public void setKeisairyo(BigDecimal Keisairyo) {
	    this._Keisairyo = Keisairyo;
	}

	/**
	 * 掲載単価を取得する
	 @return 掲載単価
	 */
	public String getKeisaiTanka() {
	    return _KeisaiTanka;
	}

	/**
	 * 掲載単価を設定する
	 @param KeisaiTanka 掲載単価
	 */
	public void setKeisaiTanka(String KeisaiTanka) {
	    this._KeisaiTanka = KeisaiTanka;
	}

	/**
	 * 掲載回数を取得する
	 @return 掲載回数
	 */
	public String getKeisaiCnt() {
	    return _KeisaiCnt;
	}

	/**
	 * 掲載回数を設定する
	 @param KeisaiCnt 掲載回数
	 */
	public void setKeisaiCnt(String KeisaiCnt) {
	    this._KeisaiCnt = KeisaiCnt;
	}

	/**
	 * 商品区分を取得する
	 @return 商品区分
	 */
	public String getSyohiKbn() {
	    return _SyohiKbn;
	}

	/**
	 * 商品区分を設定する
	 @param SyohiKbn 商品区分
	 */
	public void setSyohiKbn(String SyohiKbn) {
	    this._SyohiKbn = SyohiKbn;
	}

	/**
	 * 細目区分を取得する
	 @return 細目区分
	 */
	public String getSaiKbn() {
	    return _SaiKbn;
	}

	/**
	 * 細目区分を設定する
	 @param SaiKbn 細目区分
	 */
	public void setSaiKbn(String SaiKbn) {
	    this._SaiKbn = SaiKbn;
	}

	/**
	 * 摘要コードを取得する
	 @return 摘要コード
	 */
	public String getTekiCd() {
	    return _TekiCd;
	}

	/**
	 * 摘要コードを設定する
	 @param TekiCd 摘要コード
	 */
	public void setTekiCd(String TekiCd) {
	    this._TekiCd = TekiCd;
	}

	/**
	 * 売上予定年月を取得する
	 @return 売上予定年月
	 */
	public String getUriyymm() {
	    return _Uriyymm;
	}

	/**
	 * 売上予定年月を設定する
	 @param Uriyymm 売上予定年月
	 */
	public void setUriyymm(String Uriyymm) {
	    this._Uriyymm = Uriyymm;
	}

	/**
	 * 担当者名を取得する
	 @return 担当者名
	 */
	public String getTanName() {
	    return _TanName;
	}

	/**
	 * 担当者名を設定する
	 @param TanName 担当者名
	 */
	public void setTanName(String TanName) {
	    this._TanName = TanName;
	}

	/**
	 * 担当者勤務部署名を取得する
	 @return 担当者勤務部署名
	 */
	public String getTankinName() {
	    return _TankinName;
	}

	/**
	 * 担当者勤務部署名を設定する
	 @param TankinName 担当者勤務部署名
	 */
	public void setTankinName(String TankinName) {
	    this._TankinName = TankinName;
	}

	/**
	 * 按分種別を取得する
	 @return 按分種別
	 */
	public String getAnsyube() {
	    return _Ansyube;
	}

	/**
	 * 按分種別を設定する
	 @param Ansyube 按分種別
	 */
	public void setAnsyube(String Ansyube) {
	    this._Ansyube = Ansyube;
	}

	/**
	 * 備考1を取得する
	 @return 備考1
	 */
	public String getBikou1() {
	    return _Bikou1;
	}

	/**
	 * 備考1を設定する
	 @param Bikou1 備考1
	 */
	public void setBikou1(String Bikou1) {
	    this._Bikou1 = Bikou1;
	}

	/**
	 * 備考2を取得する
	 @return 備考2
	 */
	public String getBikou2() {
	    return _Bikou2;
	}

	/**
	 * 備考2を設定する
	 @param Bikou2 備考2
	 */
	public void setBikou2(String Bikou2) {
	    this._Bikou2 = Bikou2;
	}

	/**
	 * 色刷コードを取得する
	 @return 色刷コード
	 */
	public String getColorCd() {
	    return _ColorCd;
	}

	/**
	 * 色刷コードを設定する
	 @param ColorCd 色刷コード
	 */
	public void setColorCd(String ColorCd) {
	    this._ColorCd = ColorCd;
	}

	/**
	 * デザイン変更回数を取得する
	 @return デザイン変更回数
	 */
	public String getDesignCnt() {
	    return _DesignCnt;
	}

	/**
	 * デザイン変更回数を設定する
	 @param DesignCnt デザイン変更回数
	 */
	public void setDesignCnt(String DesignCnt) {
	    this._DesignCnt = DesignCnt;
	}

	/**
	 * 印刷代を取得する
	 @return 印刷代
	 */
	public BigDecimal getPrintryo() {
	    return _Printryo;
	}

	/**
	 * 印刷代を設定する
	 @param Printryo 印刷代
	 */
	public void setPrintryo(BigDecimal Printryo) {
	    this._Printryo = Printryo;
	}

	/**
	 * 差替作業料を取得する
	 @return 差替作業料
	 */
	public BigDecimal getSashikaeryo() {
	    return _Sashikaeryo;
	}

	/**
	 * 差替作業料を設定する
	 @param Sashikaeryo 差替作業料
	 */
	public void setSashikaeryo(BigDecimal Sashikaeryo) {
	    this._Sashikaeryo = Sashikaeryo;
	}

	/**
	 * デザイン料を取得する
	 @return デザイン料
	 */
	public BigDecimal getDesignryo() {
	    return _Designryo;
	}

	/**
	 * デザイン料を設定する
	 @param Designryo デザイン料
	 */
	public void setDesignryo(BigDecimal Designryo) {
	    this._Designryo = Designryo;
	}

	/**
	 * 版下代を取得する
	 @return 版下代
	 */
	public BigDecimal getHanshitaryo() {
	    return _Hanshitaryo;
	}

	/**
	 * 版下代を設定する
	 @param Hanshitaryo 版下代
	 */
	public void setHanshitaryo(BigDecimal Hanshitaryo) {
	    this._Hanshitaryo = Hanshitaryo;
	}

	/**
	 * 製版代を取得する
	 @return 製版代
	 */
	public BigDecimal getSeihanryo() {
	    return _Seihanryo;
	}

	/**
	 * 製版代を設定する
	 @param Seihanryo 製版代
	 */
	public void setSeihanryo(BigDecimal Seihanryo) {
	    this._Seihanryo = Seihanryo;
	}

	/**
	 * 登録年月日を取得する
	 @return 登録年月日
	 */
	public String getTouDate() {
	    return _TouDate;
	}

	/**
	 * 登録年月日を設定する
	 @param TouDate 登録年月日
	 */
	public void setTouDate(String TouDate) {
	    this._TouDate = TouDate;
	}

	/**
	 * 変更年月日を取得する
	 @return 変更年月日
	 */
	public String getHenDate() {
	    return _HenDate;
	}

	/**
	 * 変更年月日を設定する
	 @param HenDate 変更年月日
	 */
	public void setHenDate(String HenDate) {
	    this._HenDate = HenDate;
	}

	/**
	 * 取消年月日    を取得する
	 @return 取消年月日
	 */
	public String getTorDate() {
	    return _TorDate;
	}

	/**
	 * 取消年月日    を設定する
	 @param TorDate 取消年月日
	 */
	public void setTorDate(String TorDate) {
	    this._TorDate = TorDate;
	}
}
