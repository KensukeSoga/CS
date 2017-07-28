package jp.co.isid.kkh.customer.ash.model.detail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.model.detail.Thb1DownVO;

public class DetailDataAshMergeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ESQ-ID */
    private String _esqId = "";

    /** ダウンロードテーブル(統合先データ) */
    private Thb1DownVO _tougouSaki = null;

    /** ダウンロードテーブル(統合元データ) */
    private List<Thb1DownVO> _tougouMotoList = null;

    /** 最大更新日付(排他チェック用) **/
    private Date _maxUpdDate;

    /** 媒体コード **/
    private String _baitaiCd;

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
     * ダウンロードテーブル(統合先データ)を取得する
     * @return ダウンロードテーブル
     */
    public Thb1DownVO getTougouSaki() {
        return _tougouSaki;
    }

    /**
     * ダウンロードテーブル(統合先データ)を設定する
     * @param thb1Down ダウンロードテーブル
     */
    public void setTougouSaki(Thb1DownVO tougouSaki) {
        this._tougouSaki = tougouSaki;
    }

    /**
     * ダウンロードテーブル(統合元データ)を取得する
     * @return ダウンロードテーブル
     */
    public List<Thb1DownVO> getTougouMotoList() {
        return _tougouMotoList;
    }

    /**
     * ダウンロードテーブル(統合元データ)を設定する
     * @param thb1Down ダウンロードテーブル
     */
    public void setTougouMotoList(List<Thb1DownVO> tougouMotoList) {
        this._tougouMotoList = tougouMotoList;
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
     * 媒体コードを取得する
     * @return 媒体コード
     */
    public String getBaitaiCd() {
        return _baitaiCd;
    }

    /**
     * 媒体コードを設定する
     * @param maxUpdDate 媒体コード
     */
    public void setBaitaiCd(String baitaiCd) {
        this._baitaiCd = baitaiCd;
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
