package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBTHBDSPUS;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 特別ユーザーマスタVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class ThbdSpUsVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ThbdSpUsVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ThbdSpUsVO();
    }

    /**
     * 営業所コードを取得する
     * @return 営業所コード
     */
    public String getEgsCd() {
        return (String) get(TBTHBDSPUS.EGSCD);
    }

    /**
     * 営業所コードを設定する
     * @param val 営業所コード
     */
    public void setEgsCd(String val) {
        set(TBTHBDSPUS.EGSCD, val);
    }

    /**
     * 得意先企業コードを取得する
     * @return 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHBDSPUS.TKSKGYCD);
    }

    /**
     * 得意先企業コードを設定する
     * @param val 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHBDSPUS.TKSKGYCD, val);
    }

    /**
     * 得意先部門SEQNOを取得する
     * @return 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHBDSPUS.TKSBMNSEQNO);
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param val 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHBDSPUS.TKSBMNSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを取得する
     * @return 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHBDSPUS.TKSTNTSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param val 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHBDSPUS.TKSTNTSEQNO, val);
    }

    /**
     * 組織コードを取得する
     * @return 組織コード
     */
    public String getSikCd() {
        return (String) get(TBTHBDSPUS.SIKCD);
    }

    /**
     * 組織コードを設定する
     * @param val 組織コード
     */
    public void setSikCd(String val) {
        set(TBTHBDSPUS.SIKCD, val);
    }

    /**
     * ユーザーIDを取得する
     * @return ユーザーID
     */
    public String getUserId() {
        return (String) get(TBTHBDSPUS.USERID);
    }

    /**
     * ユーザーIDを設定する
     * @param val ユーザーID
     */
    public void setUserId(String val) {
        set(TBTHBDSPUS.USERID, val);
    }

    /**
     * 営業所名を取得する
     * @return 営業所名
     */
    public String getEgsNm() {
        return (String) get(TBTHBDSPUS.EGSNM);
    }

    /**
     * 営業所名を設定する
     * @param val 営業所名
     */
    public void setEgsNm(String val) {
        set(TBTHBDSPUS.EGSNM, val);
    }

    /**
     * 得意先企業名を取得する
     * @return 得意先企業名
     */
    public String getTksKgyNm() {
        return (String) get(TBTHBDSPUS.TKSKGYNM);
    }

    /**
     * 得意先企業名を設定する
     * @param val 得意先企業名
     */
    public void setTksKgyNm(String val) {
        set(TBTHBDSPUS.TKSKGYNM, val);
    }

    /**
     * 得意先部門名を取得する
     * @return 得意先部門名
     */
    public String getTksBmnNm() {
        return (String) get(TBTHBDSPUS.TKSBMNNM);
    }

    /**
     * 得意先部門名を設定する
     * @param val 得意先部門名
     */
    public void setTksBmnNm(String val) {
        set(TBTHBDSPUS.TKSBMNNM, val);
    }

    /**
     * 得意先担当部署名を取得する
     * @return 得意先担当部署名
     */
    public String getTksTntNm() {
        return (String) get(TBTHBDSPUS.TKSTNTNM);
    }

    /**
     * 得意先担当部署名を設定する
     * @param val 得意先担当部署名
     */
    public void setTksTntNm(String val) {
        set(TBTHBDSPUS.TKSTNTNM, val);
    }

    /**
     * パスワードを取得する
     * @return パスワード
     */
    public String getPassword() {
        return (String) get(TBTHBDSPUS.PASSWORD);
    }

    /**
     * パスワードを設定する
     * @param val パスワード
     */
    public void setPassword(String val) {
        set(TBTHBDSPUS.PASSWORD, val);
    }

    /**
     * ユーザー名（漢字）を取得する
     * @return ユーザー名（漢字）
     */
    public String getUserNmKj() {
        return (String) get(TBTHBDSPUS.USERNMKJ);
    }

    /**
     * ユーザー名（漢字）を設定する
     * @param val ユーザー名（漢字）
     */
    public void setUserNmKj(String val) {
        set(TBTHBDSPUS.USERNMKJ, val);
    }

    /**
     * ユーザー名（ｶﾅ）を取得する
     * @return ユーザー名（ｶﾅ）
     */
    public String getUserNmKn() {
        return (String) get(TBTHBDSPUS.USERNMKN);
    }

    /**
     * ユーザー名（ｶﾅ）を設定する
     * @param val ユーザー名（ｶﾅ）
     */
    public void setUserNmKn(String val) {
        set(TBTHBDSPUS.USERNMKN, val);
    }

}
