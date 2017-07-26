package jp.co.isid.kkh.customer.epson.model.detail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

public class DetailUpdateDataEpsonVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ESQ-ID */
    private String _esqId = "";

    /** ダウンロードテーブル */
    private Thb1DownVO _thb1Down = null;

    /** 広告費明細テーブルリスト */
    private List<Thb2KmeiVO> _thb2Kmei = null;

    /** 最大更新日付(排他チェック用) **/
    private Date _maxUpdDate;

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
    public Thb1DownVO getThb1Down() {
        return _thb1Down;
    }

    /**
     * ダウンロードテーブルを設定する
     * @param thb1Down ダウンロードテーブル
     */
    public void setThb1Down(Thb1DownVO thb1Down) {
        this._thb1Down = thb1Down;
    }

    /**
     * 広告費明細テーブルリストを取得する
     * @return 広告費明細テーブルリスト
     */
    public List<Thb2KmeiVO> getThb2Kmei() {
        return _thb2Kmei;
    }

    /**
     * 広告費明細テーブルリストを設定する
     * @param thb2Kmei 広告費明細テーブルリスト
     */
    public void setThb2Kmei(List<Thb2KmeiVO> thb2Kmei) {
        this._thb2Kmei = thb2Kmei;
    }

    /**
     * 最大更新日付を取得する
     * @return ダミープロパティ
     */
    @XmlElement(required = true)
    public Date getMaxUpdDate() {
        return _maxUpdDate;
    }

    /**
     * 最大更新日付を設定する
     * @param maxUpdDate ダミープロパティ
     */
    public void setMaxUpdDate(Date maxUpdDate) {
        this._maxUpdDate = maxUpdDate;
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
