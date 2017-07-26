package jp.co.isid.kkh.customer.epson.model.detail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.model.detail.Thb1DownVO;

public class DetailDataEpsonBulkUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId = null;

    /** 営業所（取）コード */
    private String _egCd = null;

    /** 得意先企業コード */
    private String _tksKgyCd = null;

    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo = null;

    /** 得意先担当SEQNO */
    private String _tksTntSeqNo = null;

    /** 年月 */
    private String _yymm = null;

    /** 入力フラグ */
    private String _inputFlg = null;

    /** 広告費明細データVOリスト */
    private List<DetailDataEpsonVO> _detailDataEpsonVOList = null;

    /** 受注登録者更新者更新 */
    private List<Thb1DownVO> _TouIkkatsuThb1Down = null;

    /** 最大更新日付(排他チェック用) **/
    private Date _maxUpdDate;

    /** ダミープロパティ */
    private String _dummy = null;

    /**
     * ログイン担当者ESQIDを取得する
     * @return ログイン担当者ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ログイン担当者ESQIDを設定する
     * @param esqId ログイン担当者ESQID
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * 営業所（取）コードを取得する
     * @return 営業所（取）コード
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * 営業所（取）コードを設定する
     * @param egCd 営業所（取）コード
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * 得意先企業コードを取得する
     * @return 得意先企業コード
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * 得意先企業コードを設定する
     * @param tksKgyCd 得意先企業コード
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * 得意先部門SEQNOを取得する
     * @return 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param tksBmnSeqNo 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * 得意先担当SEQNOを取得する
     * @return 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param tksTntSeqNo 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * 年月を取得する
     * @return 年月
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * 年月を設定する
     * @param yymm 年月
     */
    public void setYymm(String yymm) {
        this._yymm = yymm;
    }

    /**
     * 入力フラグを取得する
     * @return 入力フラグ
     */
    public String getInputFlg() {
        return _inputFlg;
    }

    /**
     * 入力フラグを設定する
     * @param  入力フラグ
     */
    public void setInputFlg(String inputFlg) {
        this._inputFlg = inputFlg;
    }

    /**
     * ダウンロードテーブルを取得する
     * @return ダウンロードテーブル
     */
    public List<DetailDataEpsonVO> getDetailDataEpsonVOList() {
        return _detailDataEpsonVOList;
    }

    /**
     * ダウンロードテーブルを設定する
     * @param thb1Down ダウンロードテーブル
     */
    public void setDetailDataEpsonVOList(List<DetailDataEpsonVO> detailDataVOList) {
        this._detailDataEpsonVOList = detailDataVOList;
    }

    /**
     * 登録者更新者の更新
     * @return ダウンロードテーブル
     */
    public List<Thb1DownVO> getTouIkkatsuThb1Down() {
        return _TouIkkatsuThb1Down;
    }

    /**
     * 登録者更新者の更新
     * @param thb1Down ダウンロードテーブル
     */
    public void setTouIkkatsuThb1Down(List<Thb1DownVO> TouIkkatsuThb1Down) {
        this._TouIkkatsuThb1Down = TouIkkatsuThb1Down;
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
