package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ログイン得意先情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class LoginCustomerInfoVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public LoginCustomerInfoVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new LoginCustomerInfoVO();
    }

    /** 得意先企業コード */
    private String _tksKgyCd = null;

    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo = null;

    /** 得意先担当SEQNO */
    private String _tksTntSeqNo = null;

    /** 得意先コード（表示） */
    private String _dispTksCd = null;

    /** 得意先名（表示） */
    private String _dispTksName = null;

    /** 担当組織名（表示） */
    private String _dispTntSikName = null;

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
     * 得意先コード（表示）を取得する
     * @return 得意先コード（表示）
     */
    public String getDispTksCd() {
        return _dispTksCd;
    }

    /**
     * 得意先コード（表示）を設定する
     * @param dispTksCd 得意先コード（表示）
     */
    public void setDispTksCd(String dispTksCd) {
        this._dispTksCd = dispTksCd;
    }

    /**
     * 得意先名（表示）を取得する
     * @return 得意先名（表示）
     */
    public String getDispTksName() {
        return _dispTksName;
    }

    /**
     * 得意先名（表示）を設定する
     * @param dispTksName 得意先名（表示）
     */
    public void setDispTksName(String dispTksName) {
        this._dispTksName = dispTksName;
    }

    /**
     * 担当組織名（表示）を取得する
     * @return 担当組織名（表示）
     */
    public String getDispTntSikName() {
        return _dispTntSikName;
    }

    /**
     * 担当組織名（表示）を設定する
     * @param dispTntSikName 担当組織名（表示）
     */
    public void setDispTntSikName(String dispTntSikName) {
        this._dispTntSikName = dispTntSikName;
    }

}
