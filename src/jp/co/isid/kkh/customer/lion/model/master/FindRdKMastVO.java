package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ラジオ局VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/20 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindRdKMastVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindRdKMastVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindRdMastVO();
    }

    /**
     * 登録タイムスタンプを設定します。
     * @param val String 登録タイムスタンプ
     */
    public void setTrktimstmp(Date val) {
        set(TBTHB12WLRDK.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return String 登録タイムスタンプ
     */
    public Date getTrktimstmp() {
        return (Date) get(TBTHB12WLRDK.TRKTIMSTMP);
    }

    /**
     * 登録アプリＩＤを設定します。
     * @param val String 登録アプリＩＤ
     */
    public void setTrkpl(String val) {
        set(TBTHB12WLRDK.TRKPL, val);
    }

    /**
     * 登録アプリＩＤを返します。
     * @return String 登録アプリＩＤ
     */
    public String getTrkpl() {
        return (String) get(TBTHB12WLRDK.TRKPL);
    }

    /**
     * 登録担当を設定します。
     * @param val String 登録担当
     */
    public void setTrktnt(String val) {
        set(TBTHB12WLRDK.TRKTNT, val);
    }

    /**
     * 登録担当を返します。
     * @return String 登録担当
     */
    public String getTrktnt() {
        return (String) get(TBTHB12WLRDK.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新タイムスタンプ
     */
    public void setUpdtimstmp(Date val) {
        set(TBTHB12WLRDK.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新タイムスタンプ
     */
    public Date getUpdtimstmp() {
        return (Date) get(TBTHB12WLRDK.UPDTIMSTMP);
    }

    /**
     * 更新アプリを設定します。
     * @param val String 更新アプリ
     */
    public void setUpdakpl(String val) {
        set(TBTHB12WLRDK.UPDAPL, val);
    }

    /**
     * 更新アプリを返します。
     * @return String 更新アプリ
     */
    public String getUpdakpl() {
        return (String) get(TBTHB12WLRDK.UPDAPL);
    }

    /**
     * 更新担当を設定します。
     * @param val String 更新担当
     */
    public void setUpdtnt(String val) {
        set(TBTHB12WLRDK.UPDTNT, val);
    }

    /**
     * 更新担当を返します。
     * @return String 更新担当
     */
    public String getUpdtnt() {
        return (String) get(TBTHB12WLRDK.UPDTNT);
    }

    /**
     * 営業所コードを設定します。
     * @param val String 営業所コード
     */
    public void setEgcd(String val) {
        set(TBTHB12WLRDK.EGCD, val);
    }

    /**
     * 営業所コードを返します。
     * @return String 営業所コード
     */
    public String getEgcd() {
        return (String) get(TBTHB12WLRDK.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTkskgycd(String val) {
        set(TBTHB12WLRDK.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTkskgycd() {
        return (String) get(TBTHB12WLRDK.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksbmnseqno(String val) {
        set(TBTHB12WLRDK.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksbmnseqno() {
        return (String) get(TBTHB12WLRDK.TKSBMNSEQNO);
    }

    /**
    * 得意先担当SEQNOを設定します。
    * @param val String 得意先担当SEQNO
    */
    public void setTkstntseqno(String val) {
        set(TBTHB12WLRDK.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTkstntseqno() {
        return (String) get(TBTHB12WLRDK.TKSTNTSEQNO);
    }

    /**
     * 放送局コードを設定します。
     * @param val String 放送局コード
     */
    public void setKyokuCd(String val) {
        set(TBTHB12WLRDK.KYOKUCD, val);
    }

    /**
     * 放送局コードを返します。
     * @return String 放送局コード
     */
    public String getKyokuCd() {
        return (String) get(TBTHB12WLRDK.KYOKUCD);
    }

    /**
     * 放送局名を設定します。
     * @param val String 放送局名
     */
    public void setKyokuName(String val) {
        set(TBTHB12WLRDK.KYOKUNAME, val);
    }

    /**
     * 放送局名を返します。
     * @return String 放送局名
     */
    public String getKyokuName() {
        return (String) get(TBTHB12WLRDK.KYOKUNAME);
    }

    /**
     * 記号（放送局コード）を設定します。
     * @param val String 記号（放送局コード）
     */
    public void setKigou(String val) {
        set(TBTHB12WLRDK.KIGOU, val);
    }

    /**
     * 記号（放送局コード）を返します。
     * @return String 記号（放送局コード）
     */
    public String getKigou() {
        return (String) get(TBTHB12WLRDK.KIGOU);
    }

    /**
     * 系列を設定します。
     * @param val String 系列
     */
    public void setKeiretsu(String val) {
        set(TBTHB12WLRDK.KEIRETSU, val);
    }

    /**
     * 系列を返します。
     * @return String 系列
     */
    public String getKeiretsu() {
        return (String) get(TBTHB12WLRDK.KEIRETSU);
    }
    /**
     * 表示順を設定します。
     * @param val String 表示順
     */
    public void setHyojijyun(String val) {
        set(TBTHB12WLRDK.HYOJIJYUN, val);
    }

    /**
     * 表示順を返します。
     * @return String 表示順
     */
    public String getHyojijyun() {
        return (String) get(TBTHB12WLRDK.HYOJIJYUN);
    }

}