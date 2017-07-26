package jp.co.isid.kkh.customer.skyp.model.detail;


import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
 * <P>
 * 並び順更新情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/22 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOrderVO extends Thb2KmeiVO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public UpdateOrderVO() {
        super();
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new UpdateOrderVO();
    }

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
    /** 年月 */
    private String _yymm = null;
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
     * 年月を返します。
     *
     * @return yymm
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * 年月を設定します。
     *
     * @param yymm
     */
    public void setYymm(String yymm) {
        this._yymm = yymm;
    }

    /**
     * 並び順を設定します。
     *
     * @param val
     *            String[] 並び順
     */
    public void setOrder(String[] val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * 並び順を返します。
     *
     * @return String[] 並び順
     */
    public String[] getOrder() {
        return (String[]) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * 媒体名称を設定します。
     *
     * @param val
     *            String[] 媒体名称
     */
    public void setBaitaiNm(String[] val) {
        set(TBTHB2KMEI.NAME7, val);
    }

    /**
     * 媒体名称を返します。
     *
     * @return String[] 媒体名称
     */
    public String[] getBaitaiNm() {
        return (String[]) get(TBTHB2KMEI.NAME7);
    }

    /**
     * 媒体区分を設定します。
     *
     * @param val
     *            String[] 媒体区分
     */
    public void setBaitaiKbn(String[] val) {
        set(TBTHB2KMEI.NAME13, val);
    }

    /**
     * 媒体区分を返します。
     *
     * @return String[] 媒体区分
     */
    public String[] getBaitaiKbn() {
        return (String[]) get(TBTHB2KMEI.NAME13);
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
