package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
 * <P>
 * 広告費明細データVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/14 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class DetailDataAshVO extends Thb2KmeiVO {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public DetailDataAshVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new DetailDataAshVO();
    }

    /** 局マスタ フィールド１ */
    private String _kyokuField1 = null;

    /** 局マスタ フィールド２ */
    private String _kyokuField2 = null;

    /** 局マスタ フィールド３ */
    private String _kyokuField3 = null;

    /** 局マスタ フィールド４ */
    private String _kyokuField4 = null;

    /** 商品マスタ フィールド１ */
    private String _shouhinField1 = null;

    /** 商品マスタ フィールド２ */
    private String _shouhinField2 = null;

    /**
     * 局マスタ フィールド１を取得する
     * @return 局マスタ フィールド１
     */
    public String getKyokuField1() {
        return _kyokuField1;
    }

    /**
     * 局マスタ フィールド１を設定する
     * @param kyokuField1 局マスタ フィールド１
     */
    public void setKyokuField1(String kyokuField1) {
        this._kyokuField1 = kyokuField1;
    }

    /**
     * 局マスタ フィールド２を取得する
     * @return 局マスタ フィールド２
     */
    public String getKyokuField2() {
        return _kyokuField2;
    }

    /**
     * 局マスタ フィールド２を設定する
     * @param kyokuField2 局マスタ フィールド２
     */
    public void setKyokuField2(String kyokuField2) {
        this._kyokuField2 = kyokuField2;
    }

    /**
     * 局マスタ フィールド３を取得する
     * @return 局マスタ フィールド３
     */
    public String getKyokuField3() {
        return _kyokuField3;
    }

    /**
     * 局マスタ フィールド３を設定する
     * @param kyokuField3 局マスタ フィールド３
     */
    public void setKyokuField3(String kyokuField3) {
        this._kyokuField3 = kyokuField3;
    }

    /**
     * 局マスタ フィールド４を取得する
     * @return 局マスタ フィールド４
     */
    public String getKyokuField4() {
        return _kyokuField4;
    }

    /**
     * 局マスタ フィールド４を設定する
     * @param kyokuField4 局マスタ フィールド４
     */
    public void setKyokuField4(String kyokuField4) {
        this._kyokuField4 = kyokuField4;
    }

    /**
     * 商品マスタ フィールド１を取得する
     * @return 商品マスタ フィールド１
     */
    public String getShouhinField1() {
        return _shouhinField1;
    }

    /**
     * 商品マスタ フィールド１を設定する
     * @param shouhinField1 商品マスタ フィールド１
     */
    public void setShouhinField1(String shouhinField1) {
        this._shouhinField1 = shouhinField1;
    }

    /**
     * 商品マスタ フィールド２を取得する
     * @return 商品マスタ フィールド２
     */
    public String getShouhinField2() {
        return _shouhinField2;
    }

    /**
     * 商品マスタ フィールド２を設定する
     * @param shouhinField2 商品マスタ フィールド２
     */
    public void setShouhinField2(String shouhinField2) {
        this._shouhinField2 = shouhinField2;
    }

}
