package jp.co.isid.kkh.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class MasterCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** マスタ種別(任意：検索対象のマスタを指定) */
    private String _sybt;
    /** マスタキー(任意：マスタ項目設定の検索にのみ使用) */
    private String _masterKey;
    /** フィルタキー */
    private String  _filterKey;
    /** フィルターバリュー */
    private String _filterValue;
    /** アイテムフィルターバリュー */
    private String _Itemfiltervalue;

    /**
     * マスタ種別を取得する
     * @return String マスタ種別
     */
    public String getSybt() {
        return _sybt;
    }

    /**
     * マスタ種別を設定する
     * @param sybt String マスタ種別
     */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

    /**
     * マスタキーを取得する
     * @return String マスタキー
     */
    public String getMasterKey() {
        return _masterKey;
    }

    /**
     * マスタキーを設定する
     * @param masterKey String マスタキー
     */
    public void setMasterKey(String masterKey) {
        this._masterKey = masterKey;
    }

    /**
     * フィルタキーを取得する
     * @return String フィルタキー
     */
    public String getFilterKey() {
        return _filterKey;
    }

    /**
     * フィルタキーを設定する
     * @param filterKey String フィルタキー
     */
    public void setFilterKey(String filterKey) {
        this._filterKey = filterKey;
    }

    /**
     * フィルターバリューを取得する
     * @return String フィルターバリュー
     */
    public String getFilterValue() {
        return _filterValue;
    }

    /**
     * フィルターバリューを設定する
     * @param filterValue String フィルターバリュー
     */
    public void setFilterValue(String filterValue) {
        _filterValue = filterValue;
    }

    /**
     * アイテムフィルターバリューを設定する
     * @param val String アイテムフィルターバリュー
     */
    public void set_Itemfiltervalue(String val) {
        _Itemfiltervalue = val;
    }

    /**
     * アイテムフィルターバリューを取得する
     * @return String アイテムフィルターバリュー
     */
    public String get_Itemfiltervalue() {
        return _Itemfiltervalue;
    }

}
