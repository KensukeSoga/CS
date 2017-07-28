package jp.co.isid.kkh.customer.acom.model.input;

import jp.co.isid.kkh.model.AbstractServiceCondition;

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
public class HikSearchCondition extends AbstractServiceCondition{

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 年度 */
    private String _year;

    /** 種別 */
    private String _syubetsu;

    /** 依頼行番号 */
    private String _irrowban;

    /**
    * 新規インスタンスを構築します。
    */
    public HikSearchCondition() {
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
     * 依頼行番号を取得します。
     * @return String 依頼行番号
     */
    public String getIrrowban() {
        return _irrowban;
    }

    /**
     * 依頼行番号を設定します。
     * @param syubetsu String 依頼行番号
     */
    public void setIrrowban(String irrowban) {
    	_irrowban = irrowban;
    }
}
