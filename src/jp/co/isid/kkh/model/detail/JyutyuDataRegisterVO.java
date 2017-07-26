package jp.co.isid.kkh.model.detail;

import java.io.Serializable;
import java.util.List;

public class JyutyuDataRegisterVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ESQ-ID */
    private String _esqId = "";

    /** ダウンロードテーブル */
    private List<Thb1DownVO> _thb1DownList = null;

    /** ダミープロパティ */
    private String _dummy = null;

    /**
     * ESQ-IDを取得する
     * @return ESQ-ID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ESQ-IDを設定する
     * @param esqId ESQ-ID
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * ダウンロードテーブルを取得する
     * @return ダウンロードテーブル
     */
    public List<Thb1DownVO> getThb1DownList() {
        return _thb1DownList;
    }

    /**
     * ダウンロードテーブルを設定する
     * @param thb1Down ダウンロードテーブル
     */
    public void setThb1DownList(List<Thb1DownVO> thb1DownList) {
        this._thb1DownList = thb1DownList;
    }

    /**
     * ダミープロパティを取得する
     * @return ダミープロパティ
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * ダミープロパティを設定する
     * @param dummy ダミープロパティ
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}
