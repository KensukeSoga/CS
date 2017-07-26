package jp.co.isid.kkh.customer.mac.model.report;

import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * データ更新(請求書)用リスト
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/18)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class UpdateReportMacReqDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public UpdateReportMacReqDataVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new UpdateReportMacReqDataVO();
    }

    public void SetData(String culumname, Object val){
        set(culumname, val);
    }

    /**
     * タイムスタンプを設定します。
     * @param val Date タイムスタンプ
     */
    public void setTimStmp(Date val) {
        set(TBTHB2KMEI.TIMSTMP, val);
    }

    /**
     * タイムスタンプを返します。
     * @return Date タイムスタンプ
     */
    public Date getTimStmp() {
        return (Date) get(TBTHB2KMEI.TIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setUpdApl(String val) {
        set(TBTHB2KMEI.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getUpdApl() {
        return (String) get(TBTHB2KMEI.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHB2KMEI.UPDTNT, val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHB2KMEI.UPDTNT);
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHB2KMEI.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHB2KMEI.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHB2KMEI.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB2KMEI.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB2KMEI.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB2KMEI.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB2KMEI.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB2KMEI.TKSTNTSEQNO);
    }

    /**
     * 年月を設定します。
     * @param val String 年月
     */
    public void setYymm(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * 年月を返します。
     * @return String 年月
     */
    public String getYymm() {
        return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
     * 受注Noを設定します。
     * @param val String 受注No
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * 受注Noを返します。
     * @return String 受注No
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * 受注明細Noを設定します。
     * @param val String 受注明細No
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 受注明細Noを返します。
     * @return String 受注明細No
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 売上明細Noを設定します。
     * @param val String 売上明細No
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 売上明細Noを返します。
     * @return String 売上明細No
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 連番を設定します。
     * @param val String 連番
     */
    public void setRenbn(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * 連番を返します。
     * @return String 連番
     */
    public String getRenbn() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * 営業日を設定します。
     *
     * @param val String 営業日
     */
    public void setDate1(String val) {
        set(TBTHB2KMEI.DATE2, val);
    }

    /**
     * 営業日を返します。
     *
     * @return String 営業日
     */
    public String getDate1() {
        return (String) get(TBTHB2KMEI.DATE2);
    }

}
