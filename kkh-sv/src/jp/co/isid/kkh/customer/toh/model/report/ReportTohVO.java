package jp.co.isid.kkh.customer.toh.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票（TOH)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/04 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportTohVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportTohVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportTohVO();
    }

     /**
      * 受注NOを設定します。
      * @param val String 受注NO
      */
     public void setJyutNo(String val) {
         set(TBTHB2KMEI.JYUTNO, val);
     }

     /**
      * 受注NOを返します。
      * @return String 受注NO
      */
     public String getJyutNo() {
         return (String) get(TBTHB2KMEI.JYUTNO);
     }

    /**
     * 受注明細NOを設定します。
     * @param val String 受注明細NO
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 受注明細NOを返します。
     * @return String 受注明細NO
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 売上明細NOを設定します。
     * @param val String 売上明細NO
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 売上明細NOを返します。
     * @return String 売上明細NO
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 掲載日を設定します。
     * @param val String 掲載日
     */
    public void setDate1(String val) {
        set(TBTHB2KMEI.DATE1, val);
    }

    /**
     * 掲載日を返します。
     * @return String 掲載日
     */
    public String getDate1() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * CODE1を設定します。
     * @param val String CODE1
     */
    public void setCode1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * CODE1を返します。
     * @return String CODE1
     */
    public String getCode1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * 件名を設定します。
     * @param val String 件名
     */
    public void setName8(String val) {
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * 件名を返します。
     * @return String 件名
     */
    public String getName8() {
        return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
     * 媒体名を設定します。
     * @param val String 媒体名
     */
    public void setName2(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * 媒体名を返します。
     * @return String 媒体名
     */
    public String getName2() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * 料金を設定します。
     * @param val String 料金
     */
    public void setSeiGak(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * 料金を返します。
     * @return String 料金
     */
    public BigDecimal getSeiGak() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    // 消費税対応 2013/10/09 add HLC H.Watabe start
    /**
     * 消費税率を設定します。
     * @param val String 消費税率
     */
    public void setRitu1(BigDecimal val) {
        set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * 消費税率を返します。
     * @return String 消費税率
     */
    public BigDecimal getRitu1() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }
    // 消費税対応 2013/10/09 add HLC H.Watabe end

    /**
     * 区分1を設定します。
     * @param val String 区分1
     */
    public void setKbn1(String val) {
        set(TBTHB2KMEI.KBN1, val);
    }

    /**
     * 区分1を返します。
     * @return String 区分1
     */
    public String getKbn1() {
        return (String) get(TBTHB2KMEI.KBN1);
    }

    /**
     * 区分2を設定します。
     * @param val String 区分2
     */
    public void setKbn2(String val) {
        set(TBTHB2KMEI.KBN2, val);
    }

    /**
     * 区分2を返します。
     * @return String 区分2
     */
    public String getKbn2() {
        return (String) get(TBTHB2KMEI.KBN2);
    }

    /**
     * 金額1を設定します。
     * @param val BigDecimal 金額1
     */
    public void setKngk1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * 金額1を返します。
     * @return BigDecimal 金額1
     */
    public BigDecimal getKngk1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

//    /**
//     * 登録タイムスタンプを設定します。
//     * @param val String 登録タイムスタンプ
//     */
//    public void setTrkTimStmp(Date val) {
//        set(TBTHB6LOG.TRKTIMSTMP, val);
//    }
//
//    /**
//     * 登録タイムスタンプを返します。
//     * @return String 登録タイムスタンプ
//     */
//    public Date getTrkTimStmp() {
//        return (Date) get(TBTHB6LOG.TRKTIMSTMP);
//    }
//
//    /**
//     * 登録プログラムを設定します。
//     * @param val String 登録プログラム
//     */
//    public void setTrkPl(String val) {
//        set(TBTHB6LOG.TRKPL, val);
//    }
//
//    /**
//     * 登録プログラムを返します。
//     * @return String 登録プログラム
//     */
//    public String getTrkPl() {
//        return (String) get(TBTHB6LOG.TRKPL);
//    }
//
//    /**
//     * 登録担当者を設定します。
//     * @param val String 登録担当者
//     */
//    public void setTrkTnt(String val) {
//        set(TBTHB6LOG.TRKTNT, val);
//    }
//
//    /**
//     * 登録担当者を返します。
//     * @return String 登録担当者
//     */
//    public String getTrkTnt() {
//        return (String) get(TBTHB6LOG.TRKTNT);
//    }
//
//    /**
//     * 更新タイムスタンプを設定します。
//     * @param val String 更新タイムスタンプ
//     */
//    public void setUpdTimStmp(Date val) {
//        set(TBTHB6LOG.UPDTIMSTMP, val);
//    }
//
//    /**
//     * 更新タイムスタンプを返します。
//     * @return String 更新タイムスタンプ
//     */
//    public Date getUpdTimStmp() {
//        return (Date) get(TBTHB6LOG.UPDTIMSTMP);
//    }
//
//    /**
//     * 更新プログラムを設定します。
//     * @param val String 更新プログラム
//     */
//    public void setUpdPl(String val) {
//        set(TBTHB6LOG.UPDAPL, val);
//    }
//
//    /**
//     * 更新プログラムを返します。
//     * @return String 更新プログラム
//     */
//    public String getUpdPl() {
//        return (String) get(TBTHB6LOG.UPDAPL);
//    }
//
//    /**
//     * 更新担当者を設定します。
//     * @param val String 更新担当者
//     */
//    public void setUpdTnt(String val) {
//        set(TBTHB6LOG.UPDTNT, val);
//    }
//
//    /**
//     * 更新担当者を返します。
//     * @return String 更新担当者
//     */
//    public String getUpdTnt() {
//        return (String) get(TBTHB6LOG.UPDTNT);
//    }
//
//    /**
//     * 営業所（取）コードを設定します。
//     * @param val String 営業所（取）コード
//     */
//    public void setEgCd(String val) {
//        set(TBTHB6LOG.EGCD, val);
//    }
//
//    /**
//     * 営業所（取）コードを返します。
//     * @return String 営業所（取）コード
//     */
//    public String getEgCd() {
//        return (String) get(TBTHB6LOG.EGCD);
//    }
//
//    /**
//     * 得意先企業コードを設定します。
//     * @param val String 得意先企業コード
//     */
//    public void setTksKgyCd(String val) {
//        set(TBTHB6LOG.TKSKGYCD, val);
//    }
//
//    /**
//     * 得意先企業コードを返します。
//     * @return String 得意先企業コード
//     */
//    public String getTksKgyCd() {
//        return (String) get(TBTHB6LOG.TKSKGYCD);
//    }
//
//    /**
//     * 得意先部門SEQNOを設定します。
//     * @param val String 得意先部門SEQNO
//     */
//    public void setTksBmnSeqNo(String val) {
//        set(TBTHB6LOG.TKSBMNSEQNO, val);
//    }
//
//    /**
//     * 得意先部門SEQNOを返します。
//     * @return String 得意先部門SEQNO
//     */
//    public String getTksBmnSeqNo() {
//        return (String) get(TBTHB6LOG.TKSBMNSEQNO);
//    }
//
//    /**
//     * 得意先担当SEQNOを設定します。
//     * @param val String 得意先担当SEQNO
//     */
//    public void setTksTntSeqNo(String val) {
//        set(TBTHB6LOG.TKSTNTSEQNO, val);
//    }
//
//    /**
//     * 得意先担当SEQNOを返します。
//     * @return String 得意先担当SEQNO
//     */
//    public String getTksTntSeqNo() {
//        return (String) get(TBTHB6LOG.TKSTNTSEQNO);
//    }
//
//    /**
//     * 種別を設定します。
//     * @param val String 種別
//     */
//    public void setSybt(String val) {
//        set(TBTHB6LOG.SYBT, val);
//    }
//
//    /**
//     * 種別を返します。
//     * @return String 種別
//     */
//    public String getSybt() {
//        return (String) get(TBTHB6LOG.SYBT);
//    }
//
//    /**
//     * 区分を設定します。
//     * @param val String 区分
//     */
//    public void setKbn(String val) {
//        set(TBTHB6LOG.KBN, val);
//    }
//
//    /**
//     * 区分を返します。
//     * @return String 区分
//     */
//    public String getKbn() {
//        return (String) get(TBTHB6LOG.KBN);
//    }
//
//    /**
//     * 内容を設定します。
//     * @param val String 内容
//     */
//    public void setDesc(String val) {
//        set(TBTHB6LOG.DESC, val);
//    }
//
//    /**
//     * 内容を返します。
//     * @return String 内容
//     */
//    public String getDesc() {
//        return (String) get(TBTHB6LOG.DESC);
//    }
//
//    /**
//     * 更新日時を設定します。
//     * @param val String 更新日時
//     */
//    public void setUpdDate(String val) {
//        set(TBTHB6LOG.UPDDATE, val);
//    }
//
//    /**
//     * 更新日時を返します。
//     * @return String 更新日時
//     */
//    public String getUpdDate() {
//        return (String) get(TBTHB6LOG.UPDDATE);
//    }
//
//    /**
//     * 送受信種類を設定します。
//     * @param val String 送受信種類
//     */
//    public void setReceptionKind(String val) {
//        set(TBTHB6LOG.RECEPTIONKIND, val);
//    }
//
//    /**
//     * 送受信種類を返します。
//     * @return String 送受信種類
//     */
//    public String getReceptionKind() {
//        return (String) get(TBTHB6LOG.RECEPTIONKIND);
//    }
//
//    /**
//     * ステータスを設定します。
//     * @param val String ステータス
//     */
//    public void setStatus(String val) {
//        set(TBTHB6LOG.STATUS, val);
//    }
//
//    /**
//     * ステータスを返します。
//     * @return String ステータス
//     */
//    public String getStatus() {
//        return (String) get(TBTHB6LOG.STATUS);
//    }

//    /**
//     * 新規インスタンスを構築します。
//     */
//    public ReportTohVO() {
//    }
//
//    /**
//     * 新規インスタンスを構築します。
//     *
//     * @return 新規インスタンス
//     */
//    public Object newInstance() {
//        return new ReportTohVO();
//    }
//
//    /**
//     * 受注NOを設定します。
//     * @param val String 受注NO
//     */
//    public void setHb2JyutNo(String val) {
//        set(TBTHB2KMEI.JYUTNO, val);
//    }
//
//    /**
//     * 受注NOを返します。
//     * @return String 受注NO
//     */
//    public String getHb2JyutNo() {
//        return (String) get(TBTHB2KMEI.JYUTNO);
//    }
//
//    /**
//     * 受注明細NOを設定します。
//     * @param val String 受注明細NO
//     */
//    public void setHb2JyMeiNo(String val) {
//        set(TBTHB2KMEI.JYMEINO, val);
//    }
//
//    /**
//     * 受注明細NOを返します。
//     * @return String 受注明細NO
//     */
//    public String getHb2JyMeiNo() {
//        return (String) get(TBTHB2KMEI.JYMEINO);
//    }
//
//    /**
//     * 売上明細NOを設定します。
//     * @param val String 売上明細NO
//     */
//    public void setHb2UrMeiNo(String val) {
//        set(TBTHB2KMEI.URMEINO, val);
//    }
//
//    /**
//     * 売上明細NOを返します。
//     * @return String 売上明細NO
//     */
//    public String getHb2UrMeiNo() {
//        return (String) get(TBTHB2KMEI.URMEINO);
//    }
//
//    /**
//     * 掲載日を設定します。
//     * @param val String 掲載日
//     */
//    public void setHb2Date1(String val) {
//        set(TBTHB2KMEI.DATE1, val);
//    }
//
//    /**
//     * 掲載日を返します。
//     * @return String 掲載日
//     */
//    public String getHb2Date1() {
//        return (String) get(TBTHB2KMEI.DATE1);
//    }
//
//    /**
//     * CODE1を設定します。
//     * @param val String CODE1
//     */
//    public void setHb2Code1(String val) {
//        set(TBTHB2KMEI.CODE1, val);
//    }
//
//    /**
//     * CODE1を返します。
//     * @return String CODE1
//     */
//    public String getHb2Code1() {
//        return (String) get(TBTHB2KMEI.CODE1);
//    }
//
//    /**
//     * 件名を設定します。
//     * @param val String 件名
//     */
//    public void setHb2Name8(String val) {
//        set(TBTHB2KMEI.NAME8, val);
//    }
//
//    /**
//     * 件名を返します。
//     * @return String 件名
//     */
//    public String getHb2Name8() {
//        return (String) get(TBTHB2KMEI.NAME8);
//    }
//
//    /**
//     * 媒体名を設定します。
//     * @param val String 媒体名
//     */
//    public void setHb2Name2(String val) {
//        set(TBTHB2KMEI.NAME2, val);
//    }
//
//    /**
//     * 媒体名を返します。
//     * @return String 媒体名
//     */
//    public String getHb2Name2() {
//        return (String) get(TBTHB2KMEI.NAME2);
//    }
//
//    /**
//     * 料金を設定します。
//     * @param val String 料金
//     */
//    public void setHb2SeiGak(BigDecimal val) {
//        set(TBTHB2KMEI.SEIGAK, val);
//    }
//
//    /**
//     * 料金を返します。
//     * @return String 料金
//     */
//    public BigDecimal getHb2SeiGak() {
//        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
//    }
//
//    /**
//     * 区分1を設定します。
//     * @param val String 区分1
//     */
//    public void setHb2Kbn1(String val) {
//        set(TBTHB2KMEI.KBN1, val);
//    }
//
//    /**
//     * 区分1を返します。
//     * @return String 区分1
//     */
//    public String getHb2Kbn1() {
//        return (String) get(TBTHB2KMEI.KBN1);
//    }
//
//    /**
//     * 区分2を設定します。
//     * @param val String 区分2
//     */
//    public void setHb2Kbn2(String val) {
//        set(TBTHB2KMEI.KBN2, val);
//    }
//
//    /**
//     * 区分2を返します。
//     * @return String 区分2
//     */
//    public String getHb2Kbn2() {
//        return (String) get(TBTHB2KMEI.KBN2);
//    }
//
//    /**
//     * 金額1を設定します。
//     * @param val BigDecimal 金額1
//     */
//    public void setHb2Kngk1(BigDecimal val) {
//        set(TBTHB2KMEI.KNGK1, val);
//    }
//
//    /**
//     * 金額1を返します。
//     * @return BigDecimal 金額1
//     */
//    @XmlElement(required = true)
//    public BigDecimal getHb2Kngk1() {
//        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
//    }

}