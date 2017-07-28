package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * マスタデータVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/04 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class LionRdKMastDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public LionRdKMastDataVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new LionRdKMastDataVO();
    }

    /**
     * 登録タイムスタンプを設定します。
     * @param val String 登録タイムスタンプ
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB12WLRDK.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return String 登録タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB12WLRDK.TRKTIMSTMP);
    }

    /**
     * 登録プログラムを設定します。
     * @param val String 登録プログラム
     */
    public void setTrkPl(String val) {
        set(TBTHB12WLRDK.TRKPL, val);
    }

    /**
     * 登録プログラムを返します。
     * @return String 登録プログラム
     */
    public String getTrkPl() {
        return (String) get(TBTHB12WLRDK.TRKPL);
    }

    /**
     * 登録担当者を設定します。
     * @param val String 登録担当者
     */
    public void setTrkTnt(String val) {
        set(TBTHB12WLRDK.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     * @return String 登録担当者
     */
    public String getTrkTnt() {
        return (String) get(TBTHB12WLRDK.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新タイムスタンプ
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB12WLRDK.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB12WLRDK.UPDTIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setUpdaPl(String val) {
        set(TBTHB12WLRDK.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getUpdaPl() {
        return (String) get(TBTHB12WLRDK.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHB12WLRDK.UPDTNT   , val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHB12WLRDK.UPDTNT   );
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHB12WLRDK.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHB12WLRDK.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHB12WLRDK.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB12WLRDK.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB12WLRDK.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB12WLRDK.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB12WLRDK.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB12WLRDK.TKSTNTSEQNO);
    }

    /**
     * 放送局コードを設定します。
     * @param val String KYOKUCD
     */
    public void setKyokuCd(String val) {
        set(TBTHB12WLRDK.KYOKUCD, val);
    }

    /**
     * 放送局コードを返します。
     * @return String KYOKUCD
     */
    public String getKyokuCd() {
        return (String) get(TBTHB12WLRDK.KYOKUCD);
    }

    /**
     * 放送局名を設定します。
     * @param val String KYOKUNAME
     */
    public void setKyokuName(String val) {
        set(TBTHB12WLRDK.KYOKUNAME, val);
    }

    /**
     * 放送局名を返します。
     * @return String KYOKUNAME
     */
    public String getKyokuName() {
        return (String) get(TBTHB12WLRDK.KYOKUNAME);
    }

    /**
     * 記号（放送局コード）を設定します。
     * @param val String KIGOU
     */
    public void setKigou(String val) {
        set(TBTHB12WLRDK.KIGOU, val);
    }

    /**
     * 記号（放送局コード）を返します。
     * @return String KIGOU
     */
    public String getKigou() {
        return (String) get(TBTHB12WLRDK.KIGOU);
    }

    /**
     * 系列を設定します。
     * @param val String KEIRETSU
     */
    public void setKeiretsu(String val) {
        set(TBTHB12WLRDK.KEIRETSU, val);
    }

    /**
     * 系列を返します。
     * @return String KEIRETSU
     */
    public String getKeiretsu() {
        return (String) get(TBTHB12WLRDK.KEIRETSU);
    }

    /**
     * 表示順を設定します。
     * @param val String HYOJIJYUN
     */
    public void setHyojijyun(String val) {
        set(TBTHB12WLRDK.HYOJIJYUN, val);
    }

    /**
     * 表示順を返します。
     * @return String HYOJIJYUN
     */
    public String getHyojijyun() {
        return (String) get(TBTHB12WLRDK.HYOJIJYUN);
    }

}