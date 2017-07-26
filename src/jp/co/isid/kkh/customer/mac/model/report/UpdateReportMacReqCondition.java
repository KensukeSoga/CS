package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * データ更新Condition(請求書)
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/18 IP Shimizu)<BR>
 * </P>
 * @author
 */
public class UpdateReportMacReqCondition extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId = null;

    /** アプリID */
    private String _aplId = null;

    /** 営業所（取）コード */
    private String _egCd = null;

    /** 得意先企業コード */
    private String _tksKgyCd = null;

    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo = null;

    /** 得意先担当SEQNO */
    private String _tksTntSeqNo = null;

    /** 伝票番号 */
//    private String _denNum = null;

    /** 営業日 */
    private String _hostDate = null;

    /** 更新日時最大値*/
//    private Date _maxUpDate = null;

    /** データVOリスト */
    private List<UpdateReportMacReqVO> _reportData = null;

    /** ダミープロパティ */
    private String _dummy = null;


    /**
     * ログイン担当者ESQIDを取得する
     @return ログイン担当者ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ログイン担当者ESQIDを設定する
     @param esqId ログイン担当者ESQID
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * アプリIDを取得する
     @return アプリID
     */
    public String getAplId() {
        return _aplId;
    }

    /**
     * アプリIDを設定する
     @param aplId アプリID
     */
    public void setAplId(String aplId) {
        this._aplId = aplId;
    }

    /**
     * 営業所（取）コードを取得する
     @return 営業所（取）コード
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * 営業所（取）コードを設定する
     @param egCd 営業所（取）コード
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * 得意先企業コードを取得する
     @return 得意先企業コード
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * 得意先企業コードを設定する
     @param tksKgyCd 得意先企業コード
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * 得意先部門SEQNOを取得する
     @return 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * 得意先部門SEQNOを設定する
     @param tksBmnSeqNo 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * 得意先担当SEQNOを取得する
     @return 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * 得意先担当SEQNOを設定する
     @param tksTntSeqNo 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * 汎用マスタデータVOリストを取得する
     @return 汎用マスタデータVOリスト
     */
    public List<UpdateReportMacReqVO> getReportData() {
        return _reportData;
    }

    /**
     * データVOリストを設定する
     @param reportData データVOリスト
     */
    public void setReportData(List<UpdateReportMacReqVO> reportData) {
        this._reportData = reportData;
    }

    /**
     * ホスト営業日を取得する
     @return ホスト営業日
     */
    public String getHostDate() {
        return _hostDate;
    }

    /**
     * ホスト営業日を設定する
     @param ホスト営業日
     */
    public void setHostDate(String hostDate) {
        this._hostDate = hostDate;
    }

    /**
     * ダミープロパティを取得する
     @return ダミープロパティ
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * ダミープロパティを設定する
     @param dummy ダミープロパティ
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}
