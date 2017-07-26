package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
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
public class LionTvKMastDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public LionTvKMastDataVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new LionTvKMastDataVO();
    }

    /**
     * 登録タイムスタンプを設定します。
     * @param val String 登録タイムスタンプ
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB11WLTVK.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return String 登録タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB11WLTVK.TRKTIMSTMP);
    }

    /**
     * 登録プログラムを設定します。
     * @param val String 登録プログラム
     */
    public void setTrkPl(String val) {
        set(TBTHB11WLTVK.TRKPL, val);
    }

    /**
     * 登録プログラムを返します。
     * @return String 登録プログラム
     */
    public String getTrkPl() {
        return (String) get(TBTHB11WLTVK.TRKPL);
    }

    /**
     * 登録担当者を設定します。
     * @param val String 登録担当者
     */
    public void setTrkTnt(String val) {
        set(TBTHB11WLTVK.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     * @return String 登録担当者
     */
    public String getTrkTnt() {
        return (String) get(TBTHB11WLTVK.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新タイムスタンプ
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB11WLTVK.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB11WLTVK.UPDTIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setUpdaPl(String val) {
        set(TBTHB11WLTVK.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getUpdaPl() {
        return (String) get(TBTHB11WLTVK.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHB11WLTVK.UPDTNT   , val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHB11WLTVK.UPDTNT   );
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHB11WLTVK.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHB11WLTVK.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHB11WLTVK.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB11WLTVK.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB11WLTVK.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB11WLTVK.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB11WLTVK.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
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