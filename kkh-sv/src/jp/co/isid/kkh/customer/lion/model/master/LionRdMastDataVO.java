package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB10WLRDB;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ラジオ番組マスタデータVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/15 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class LionRdMastDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public LionRdMastDataVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new LionRdMastDataVO();
    }

    /**
     * 登録タイムスタンプを設定します。
     * @param val String 登録タイムスタンプ
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB10WLRDB.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return String 登録タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB10WLRDB.TRKTIMSTMP);
    }

    /**
     * 登録プログラムを設定します。
     * @param val String 登録プログラム
     */
    public void setTrkPl(String val) {
        set(TBTHB10WLRDB.TRKPL, val);
    }

    /**
     * 登録プログラムを返します。
     * @return String 登録プログラム
     */
    public String getTrkPl() {
        return (String) get(TBTHB10WLRDB.TRKPL);
    }

    /**
     * 登録担当者を設定します。
     * @param val String 登録担当者
     */
    public void setTrkTnt(String val) {
        set(TBTHB10WLRDB.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     * @return String 登録担当者
     */
    public String getTrkTnt() {
        return (String) get(TBTHB10WLRDB.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新タイムスタンプ
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB10WLRDB.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB10WLRDB.UPDTIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setUpdaPl(String val) {
        set(TBTHB10WLRDB.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getUpdaPl() {
        return (String) get(TBTHB10WLRDB.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHB10WLRDB.UPDTNT   , val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHB10WLRDB.UPDTNT   );
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHB10WLRDB.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHB10WLRDB.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHB10WLRDB.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB10WLRDB.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB10WLRDB.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB10WLRDB.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB10WLRDB.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB10WLRDB.TKSTNTSEQNO);
    }

    /**
     * BANCDを設定します。
     * @param val String BANCD
     */
    public void setBanCd(String val) {
        set(TBTHB10WLRDB.BANCD, val);
    }

    /**
     * BANCDを返します。
     * @return String BANCD
     */
    public String getBanCd() {
        return (String) get(TBTHB10WLRDB.BANCD);
    }

    /**
     * BANNMを設定します。
     * @param val String BANNM
     */
    public void setBanName(String val) {
        set(TBTHB10WLRDB.BANNAME, val);
    }

    /**
     * BANNMを返します。
     * @return String BANNM
     */
    public String getBanName() {
        return (String) get(TBTHB10WLRDB.BANNAME);
    }

    /**
     * HKYOKUCDを設定します。
     * @param val String HKYOKUCD
     */
    public void setHkyokuCd(String val) {
        set(TBTHB10WLRDB.HKYOKUCD, val);
    }

    /**
     * HKYOKUCDを返します。
     * @return String HKYOKUCD
     */
    public String getHkyokuCd() {
        return (String) get(TBTHB10WLRDB.HKYOKUCD);
    }

    /**
     * SEISAKUHIを設定します。
     * @param val String SEISAKUHI
     */
    public void setSeisakuhi(String val) {
        set(TBTHB10WLRDB.SEISAKUHI, val);
    }

    /**
     * SEISAKUHIを返します。
     * @return String SEISAKUHI
     */
    public String getSeisakuhi() {
        return (String) get(TBTHB10WLRDB.SEISAKUHI);
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
     * @param val String Tanka
     */
    public void setTanka(String val) {
        set(TBTHB10WLRDB.TANKA, val);
    }

    /**
     * TANKAを返します。
     * @return String Tanka
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