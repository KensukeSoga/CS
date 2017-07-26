package jp.co.isid.kkh.model.detail;

import java.util.List;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 一括登録処理用VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/24 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class BulkDataRegisterVO extends AbstractModel {

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

    /** ダウンロードテーブルリスト */
    private List<Thb1DownVO> _thb1DownList = null;

    /** ダウンロードテーブルリスト統合子 一括登録対応 */
    private List<Thb1DownVO> _TouIkkatsuThb1Down = null;

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
     * アプリIDを取得する
     * @return アプリID
     */
    public String getAplId() {
        return _aplId;
    }

    /**
     * アプリIDを設定する
     * @param aplId アプリID
     */
    public void setAplId(String aplId) {
        this._aplId = aplId;
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
     * ダウンロードテーブルリストを取得する
     * @return ダウンロードテーブルリスト
     */
    public List<Thb1DownVO> getThb1DownList() {
        return _thb1DownList;
    }

    /**
     * ダウンロードテーブルリストを設定する
     * @param thb1DownList ダウンロードテーブルリスト
     */
    public void setThb1DownList(List<Thb1DownVO> thb1DownList) {
        this._thb1DownList = thb1DownList;
    }

    /**
     * ダウンロードテーブルリストを取得する
     * @return ダウンロードテーブルリスト
     */
    public List<Thb1DownVO> getTouIkkatsuThb1Down() {
        return _TouIkkatsuThb1Down;
    }

    /**
     * ダウンロードテーブルリストを設定する
     * @param thb1DownList ダウンロードテーブルリスト
     */
    public void setTouIkkatsuThb1Down(List<Thb1DownVO> TouIkkatsuThb1Down) {
        this._TouIkkatsuThb1Down = TouIkkatsuThb1Down;
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
