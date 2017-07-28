package jp.co.isid.kkh.model.log;

import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB6LOG;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 汎用ログデータVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 IP H.SHimizu)<BR>
 * </P>
 * @author
 */
public class LogVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public LogVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new LogVO();
    }

    /**
     * 登録タイムスタンプを設定します。
     * @param val String 登録タイムスタンプ
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB6LOG.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return String 登録タイムスタンプ
     */
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB6LOG.TRKTIMSTMP);
    }

    /**
     * 登録プログラムを設定します。
     * @param val String 登録プログラム
     */
    public void setTrkPl(String val) {
        set(TBTHB6LOG.TRKPL, val);
    }

    /**
     * 登録プログラムを返します。
     * @return String 登録プログラム
     */
    public String getTrkPl() {
        return (String) get(TBTHB6LOG.TRKPL);
    }

    /**
     * 登録担当者を設定します。
     * @param val String 登録担当者
     */
    public void setTrkTnt(String val) {
        set(TBTHB6LOG.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     * @return String 登録担当者
     */
    public String getTrkTnt() {
        return (String) get(TBTHB6LOG.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新タイムスタンプ
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB6LOG.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新タイムスタンプ
     */
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB6LOG.UPDTIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setUpdPl(String val) {
        set(TBTHB6LOG.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getUpdPl() {
        return (String) get(TBTHB6LOG.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHB6LOG.UPDTNT, val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHB6LOG.UPDTNT);
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHB6LOG.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHB6LOG.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHB6LOG.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB6LOG.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB6LOG.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB6LOG.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB6LOG.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB6LOG.TKSTNTSEQNO);
    }

    /**
     * 種別を設定します。
     * @param val String 種別
     */
    public void setSybt(String val) {
        set(TBTHB6LOG.SYBT, val);
    }

    /**
     * 機能IDを返します。
     * @return String 種別
     */
    public String getSybt() {
        return (String) get(TBTHB6LOG.SYBT);
    }

    /**
     * 機能IDを設定します。
     * @param val String 機能ID
     */
    public void setKinoId(String val) {
        set(TBTHB6LOG.KINOID, val);
    }

    /**
     * 機能IDを返します。
     * @return String 機能ID
     */
    public String getKinoId() {
        return (String) get(TBTHB6LOG.KINOID);
    }

    /**
     * 区分を設定します。
     * @param val String 区分
     */
    public void setKbn(String val) {
        set(TBTHB6LOG.KBN, val);
    }

    /**
     * 区分を返します。
     * @return String 区分
     */
    public String getKbn() {
        return (String) get(TBTHB6LOG.KBN);
    }

    /**
     * 内容を設定します。
     * @param val String 内容
     */
    public void setDesc(String val) {
        set(TBTHB6LOG.DESC, val);
    }

    /**
     * 内容を返します。
     * @return String 内容
     */
    public String getDesc() {
        return (String) get(TBTHB6LOG.DESC);
    }

    /**
     * エラー内容を設定します。
     * @param val String エラー内容
     */
    public void setErrDesc(String val) {
        set(TBTHB6LOG.ERRDESC, val);
    }

    /**
     * エラー内容を返します。
     * @return String エラー内容
     */
    public String getErrDesc() {
        return (String) get(TBTHB6LOG.ERRDESC);
    }

    /**
     * 更新日時を設定します。
     * @param val String 更新日時
     */
    public void setUpdDate(String val) {
        set(TBTHB6LOG.UPDDATE, val);
    }

    /**
     * 更新日時を返します。
     * @return String 更新日時
     */
    public String getUpdDate() {
        return (String) get(TBTHB6LOG.UPDDATE);
    }

    /**
     * 担当者名を設定します。
     * @param val String 担当者名
     */
    public void setTanName(String val) {
        set(TBTHB6LOG.TANNAME, val);
    }

    /**
     * 担当者名を返します。
     * @return String 担当者名
     */
    public String getTanName() {
        return (String) get(TBTHB6LOG.TANNAME);
    }

    /**
     * 送受信種類を設定します。
     * @param val String 送受信種類
     */
    public void setReceptionKind(String val) {
        set(TBTHB6LOG.RECEPTIONKIND, val);
    }

    /**
     * 送受信種類を返します。
     * @return String 送受信種類
     */
    public String getReceptionKind() {
        return (String) get(TBTHB6LOG.RECEPTIONKIND);
    }

    /**
     * ステータスを設定します。
     * @param val String ステータス
     */
    public void setStatus(String val) {
        set(TBTHB6LOG.STATUS, val);
    }

    /**
     * ステータスを返します。
     * @return String ステータス
     */
    public String getStatus() {
        return (String) get(TBTHB6LOG.STATUS);
    }

}
