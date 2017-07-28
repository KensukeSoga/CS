package jp.co.isid.kkh.customer.lion.model.master;

import java.math.BigDecimal;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB10WLRDB;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ラジオ番組VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/17 JSE A.Naito)<BR>
 * </P>
 * @author  JSE A.Naito
 */
public class FindRdMastVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindRdMastVO() {
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
      * @param val String 登録タイム
      */
     public void setTrktimstmp(Date val) {
         set(TBTHB10WLRDB.TRKTIMSTMP, val);
     }

     /**
      * 登録タイムスタンプを返します。
      * @return String 登録タイム
      */
     public Date getTrktimstmp() {
         return (Date) get(TBTHB10WLRDB.TRKTIMSTMP);
     }

    /**
     * 登録アプリＩＤを設定します。
     * @param val String 登録アプリＩＤ
     */
    public void setTrkpl(String val) {
        set(TBTHB10WLRDB.TRKPL, val);
    }

    /**
     * 登録アプリＩＤを返します。
     * @return String 登録アプリＩＤ
     */
    public String getTrkpl() {
        return (String) get(TBTHB10WLRDB.TRKPL);
    }

    /**
     * 登録担当を設定します。
     * @param val String 登録担当
     */
    public void setTrktnt(String val) {
        set(TBTHB10WLRDB.TRKTNT, val);
    }

    /**
     * 登録担当を返します。
     * @return String 登録担当
     */
    public String getTrktnt() {
        return (String) get(TBTHB10WLRDB.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新担当
     */
    public void setUpdtimstmp(Date val) {
        set(TBTHB10WLRDB.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新担当
     */
    public Date getUpdtimstmp() {
        return (Date) get(TBTHB10WLRDB.UPDTIMSTMP);
    }

    /**
     * 更新アプリを設定します。
     * @param val String 更新アプリ
     */
    public void setUpdakpl(String val) {
        set(TBTHB10WLRDB.UPDAPL, val);
    }

    /**
     * 更新アプリを返します。
     * @return String 更新アプリ
     */
    public String getUpdakpl() {
        return (String) get(TBTHB10WLRDB.UPDAPL);
    }

    /**
     * 更新担当を設定します。
     * @param val String 更新担当
     */
    public void setUpdtnt(String val) {
        set(TBTHB10WLRDB.UPDTNT, val);
    }

    /**
     * 更新担当を返します。
     * @return String 更新担当
     */
    public String getUpdtnt() {
        return (String) get(TBTHB10WLRDB.UPDTNT);
    }

    /**
     * 営業ｃｄを設定します。
     * @param val String 営業ｃｄ
     */
    public void setEgcd(String val) {
        set(TBTHB10WLRDB.EGCD, val);
    }

    /**
     * 営業ｃｄを返します。
     * @return String 営業ｃｄ
     */
    public String getEgcd() {
        return (String) get(TBTHB10WLRDB.EGCD);
    }

    /**
     * 得意先を設定します。
     * @param val String 得意先
     */
    public void setTkskgycd(String val) {
        set(TBTHB10WLRDB.TKSKGYCD, val);
    }

    /**
     * 得意先を返します。
     * @return String 得意先
     */
    public String getTkskgycd() {
        return (String) get(TBTHB10WLRDB.TKSKGYCD);
    }

    /**
     * 部門を設定します。
     * @param val String 部門
     */
    public void setTksbmnseqno(String val) {
        set(TBTHB10WLRDB.TKSBMNSEQNO, val);
    }

    /**
     * 部門を返します。
     * @return String 部門
     */
    public String getTksbmnseqno() {
        return (String) get(TBTHB10WLRDB.TKSBMNSEQNO);
    }

    /**
     * 担当を設定します。
     * @param val String 担当
     */
    public void setTkstntseqno(String val) {
        set(TBTHB10WLRDB.TKSTNTSEQNO, val);
    }

    /**
     * 担当を返します。
     * @return String 担当
     */
    public String getTkstntseqno() {
        return (String) get(TBTHB10WLRDB.TKSTNTSEQNO);
    }

    /**
     * BANCDを設定します。
     * @param val String BANCD
     */
    public void setBancd(String val) {
        set(TBTHB10WLRDB.BANCD, val);
    }

    /**
     * BANCDを返します。
     * @return String BANCD
     */
    public String getBancd() {
        return (String) get(TBTHB10WLRDB.BANCD);
    }

    /**
     * BANNAMEを設定します。
     * @param val String BANNAME
     */
    public void setBanname(String val) {
        set(TBTHB10WLRDB.BANNAME, val);
    }

    /**
     * BANNAMEを返します。
     * @return String BANNAME
     */
    public String getBanname() {
        return (String) get(TBTHB10WLRDB.BANNAME);
    }
    /**
     * HKYOKUCDを設定します。
     * @param val String HKYOKUCD
     */
    public void setHkyokucd(String val) {
        set(TBTHB10WLRDB.HKYOKUCD, val);
    }

    /**
     * HKYOKUCDを返します。
     * @return String HKYOKUCD
     */
    public String getHkyokucd() {
        return (String) get(TBTHB10WLRDB.HKYOKUCD);
    }

    /**
     * 金額を設定します。
     * @param val BigDecimal 金額
     */
    public void setSeisakuhi(BigDecimal val) {
        set(TBTHB10WLRDB.SEISAKUHI, val);
    }

    /**
     * 金額を返します。
     * @return BigDecimal 金額
     */
    public BigDecimal getSeisakuhi() {
      return (BigDecimal) get(TBTHB10WLRDB.SEISAKUHI);
    }

    /**
     * HYOJIJYUNを設定します。
     * @param val String HYOJIJYUN
     */
    public void setHyojijyun(String val) {
        set(TBTHB10WLRDB.HYOJIJYUN, val);
    }

    /**
     * HYOJIJYUNを返します。
     * @return String HYOJIJYUN
     */
    public String getHyojijyun() {
        return (String) get(TBTHB10WLRDB.HYOJIJYUN);
    }

    /**
     * TANKAを設定します。
     * @param val String TANKA
     */
    public void setTanka(String val) {
        set(TBTHB10WLRDB.TANKA, val);
    }

    /**
     * TANKAを返します。
     * @return String TANKA
     */
    public String getTanka() {
        return (String) get(TBTHB10WLRDB.TANKA);
    }

    /**
     * TYPE2を設定します。
     * @param val String TYPE2
     */
    public void setType2(String val) {
        set(TBTHB10WLRDB.TYPE2, val);
    }

    /**
     * TYPE2を返します。
     * @return String TYPE2
     */
    public String getType2() {
        return (String) get(TBTHB10WLRDB.TYPE2);
    }

}
