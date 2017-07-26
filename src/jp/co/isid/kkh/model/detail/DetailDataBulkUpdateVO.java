package jp.co.isid.kkh.model.detail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class DetailDataBulkUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ESQ-ID */
    private String _esqId = "";

    /** 広告費明細データVOリスト */
    private List<DetailDataVO> _detailDataVOList = null;

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
    public List<DetailDataVO> getDetailDataVOList() {
        return _detailDataVOList;
    }

    /**
     * ダウンロードテーブルを設定する
     * @param thb1Down ダウンロードテーブル
     */
    public void setDetailDataVOList(List<DetailDataVO> detailDataVOList) {
        this._detailDataVOList = detailDataVOList;
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
