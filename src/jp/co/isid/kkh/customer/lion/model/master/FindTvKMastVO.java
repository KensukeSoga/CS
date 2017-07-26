package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * TV局VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/20 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindTvKMastVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindTvKMastVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindTvMastVO();
    }

     /**
      * 登録タイムスタンプを設定します。
      * @param val String 登録タイム
      */
     public void setTrktimstmp(Date val) {
         set(TBTHB11WLTVK.TRKTIMSTMP, val);
     }

     /**
      * 登録タイムスタンプを返します。
      * @return String 登録タイム
      */
     public Date getTrktimstmp() {
         return (Date) get(TBTHB11WLTVK.TRKTIMSTMP);
     }

    /**
     * 登録アプリＩＤを設定します。
     * @param val String 登録アプリＩＤ
     */
    public void setTrkpl(String val) {
        set(TBTHB11WLTVK.TRKPL, val);
    }

    /**
     * 登録アプリＩＤを返します。
     * @return String 登録アプリＩＤ
     */
    public String getTrkpl() {
        return (String) get(TBTHB11WLTVK.TRKPL);
    }

    /**
     * 登録担当を設定します。
     * @param val String 登録担当
     */
    public void setTrktnt(String val) {
        set(TBTHB11WLTVK.TRKTNT, val);
    }

    /**
     * 登録担当を返します。
     * @return String 登録担当
     */
    public String getTrktnt() {
        return (String) get(TBTHB11WLTVK.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新担当
     */
    public void setUpdtimstmp(Date val) {
        set(TBTHB11WLTVK.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新担当
     */
    public Date getUpdtimstmp() {
        return (Date) get(TBTHB11WLTVK.UPDTIMSTMP);
    }

    /**
     * 更新アプリを設定します。
     * @param val String 更新アプリ
     */
    public void setUpdakpl(String val) {
        set(TBTHB11WLTVK.UPDAPL, val);
    }

    /**
     * 更新アプリを返します。
     * @return String 更新アプリ
     */
    public String getUpdakpl() {
        return (String) get(TBTHB11WLTVK.UPDAPL);
    }

    /**
     * 更新担当を設定します。
     * @param val String 更新担当
     */
    public void setUpdtnt(String val) {
        set(TBTHB11WLTVK.UPDTNT, val);
    }

    /**
     * 更新担当を返します。
     * @return String 更新担当
     */
    public String getUpdtnt() {
        return (String) get(TBTHB11WLTVK.UPDTNT);
    }

    /**
     * 営業ｃｄを設定します。
     * @param val String 営業ｃｄ
     */
    public void setEgcd(String val) {
        set(TBTHB11WLTVK.EGCD, val);
    }

    /**
     * 営業ｃｄを返します。
     * @return String 営業ｃｄ
     */
    public String getEgcd() {
        return (String) get(TBTHB11WLTVK.EGCD);
    }

    /**
     * 得意先を設定します。
     * @param val String 得意先
     */
    public void setTkskgycd(String val) {
        set(TBTHB11WLTVK.TKSKGYCD, val);
    }

    /**
     * 得意先を返します。
     * @return String 得意先
     */
    public String getTkskgycd() {
        return (String) get(TBTHB11WLTVK.TKSKGYCD);
    }

    /**
     * 部門を設定します。
     * @param val String 部門
     */
    public void setTksbmnseqno(String val) {
        set(TBTHB11WLTVK.TKSBMNSEQNO, val);
    }

    /**
     * 部門を返します。
     * @return String 部門
     */
    public String getTksbmnseqno() {
        return (String) get(TBTHB11WLTVK.TKSBMNSEQNO);
    }

    /**
     * 担当を設定します。
     * @param val String 担当
     */
    public void setTkstntseqno(String val) {
        set(TBTHB11WLTVK.TKSTNTSEQNO, val);
    }

    /**
     * 担当を返します。
     * @return String 担当
     */
    public String getTkstntseqno() {
        return (String) get(TBTHB11WLTVK.TKSTNTSEQNO);
    }

    /**
     * 放送局コードを設定します。
     * @param val String KYOKUCD
     */
    public void setKyokuCd(String val) {
        set(TBTHB11WLTVK.KYOKUCD, val);
    }

    /**
     * 放送局コードを返します。
     * @return String KYOKUCD
     */
    public String getKyokuCd() {
        return (String) get(TBTHB11WLTVK.KYOKUCD);
    }

    /**
     * 放送局名を設定します。
     * @param val String KYOKUNAME
     */
    public void setKyokuName(String val) {
        set(TBTHB11WLTVK.KYOKUNAME, val);
    }

    /**
     * 放送局名を返します。
     * @return String KYOKUNAME
     */
    public String getKyokuName() {
        return (String) get(TBTHB11WLTVK.KYOKUNAME);
    }

    /**
     * 記号（放送局コード）を設定します。
     * @param val String KIGOU
     */
    public void setKigou(String val) {
        set(TBTHB11WLTVK.KIGOU, val);
    }

    /**
     * 記号（放送局コード）を返します。
     * @return String KIGOU
     */
    public String getKigou() {
        return (String) get(TBTHB11WLTVK.KIGOU);
    }

    /**
     * 系列を設定します。
     * @param val String KEIRETSU
     */
    public void setKeiretsu(String val) {
        set(TBTHB11WLTVK.KEIRETSU, val);
    }

    /**
     * 系列を返します。
     * @return String KEIRETSU
     */
    public String getKeiretsu() {
        return (String) get(TBTHB11WLTVK.KEIRETSU);
    }

    /**
     * 地区を設定します。
     * @param val String TIKU
     */
    public void setTiku(String val) {
        set(TBTHB11WLTVK.TIKU, val);
    }

    /**
     * 地区を返します。
     * @return String TIKU
     */
    public String getTiku() {
        return (String) get(TBTHB11WLTVK.TIKU);
    }

    /**
     * 地区表示順を設定します。
     * @param val String THYOJIJYUN
     */
    public void setTHyojiJyun(String val) {
        set(TBTHB11WLTVK.THYOJIJYUN, val);
    }

    /**
     * 地区表示順を返します。
     * @return String THYOJIJYUN
     */
    public String getTHyojiJyun() {
        return (String) get(TBTHB11WLTVK.THYOJIJYUN);
    }

    /**
     * 表示順を設定します。
     * @param val String HYOJIJYUN
     */
    public void setHyojijyun(String val) {
        set(TBTHB11WLTVK.HYOJIJYUN, val);
    }

    /**
     * 表示順を返します。
     * @return String HYOJIJYUN
     */
    public String getHyojijyun() {
        return (String) get(TBTHB11WLTVK.HYOJIJYUN);
    }

}
