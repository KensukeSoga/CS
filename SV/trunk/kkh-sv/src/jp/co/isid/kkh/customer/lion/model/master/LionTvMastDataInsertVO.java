package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * マスタデータVO（INSERT用）
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LionTvMastDataInsertVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public LionTvMastDataInsertVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new LionTvMastDataInsertVO();
    }

    public void SetData(String culumname, Object val){
        set(culumname, val);
    }

    /**
     * 登録タイムスタンプを設定します。
     * @param val String 登録タイムスタンプ
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB9WLTVB.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return String 登録タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB9WLTVB.TRKTIMSTMP);
    }

    /**
     * 登録プログラムを設定します。
     * @param val String 登録プログラム
     */
    public void setTrkPl(String val) {
        set(TBTHB9WLTVB.TRKPL, val);
    }

    /**
     * 登録プログラムを返します。
     * @return String 登録プログラム
     */
    public String getTrkPl() {
        return (String) get(TBTHB9WLTVB.TRKPL);
    }

    /**
     * 登録担当者を設定します。
     * @param val String 登録担当者
     */
    public void setTrkTnt(String val) {
        set(TBTHB9WLTVB.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     * @return String 登録担当者
     */
    public String getTrkTnt() {
        return (String) get(TBTHB9WLTVB.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新タイムスタンプ
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB9WLTVB.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB9WLTVB.UPDTIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setUpdaPl(String val) {
        set(TBTHB9WLTVB.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getUpdaPl() {
        return (String) get(TBTHB9WLTVB.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHB9WLTVB.UPDTNT   , val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHB9WLTVB.UPDTNT   );
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHB9WLTVB.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHB9WLTVB.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHB9WLTVB.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB9WLTVB.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB9WLTVB.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB9WLTVB.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB9WLTVB.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB9WLTVB.TKSTNTSEQNO);
    }

    /**
     * BANCDを設定します。
     * @param val String BANCD
     */
    public void setBanCd(String val) {
        set(TBTHB9WLTVB.BANCD, val);
    }

    /**
     * BANCDを返します。
     * @return String BANCD
     */
    public String getBanCd() {
        return (String) get(TBTHB9WLTVB.BANCD);
    }

    /**
     * BANNMを設定します。
     * @param val String BANNM
     */
    public void setBanName(String val) {
        set(TBTHB9WLTVB.BANNAME, val);
    }

    /**
     * BANNMを返します。
     * @return String BANNM
     */
    public String getBanName() {
        return (String) get(TBTHB9WLTVB.BANNAME);
    }

    /**
     * HKYOKUCDを設定します。
     * @param val String HKYOKUCD
     */
    public void setHkyokuCd(String val) {
        set(TBTHB9WLTVB.HKYOKUCD, val);
    }

    /**
     * HKYOKUCDを返します。
     * @return String HKYOKUCD
     */
    public String getHkyokuCd() {
        return (String) get(TBTHB9WLTVB.HKYOKUCD);
    }

    /**
     * SEISAKUHIを設定します。
     * @param val String SEISAKUHI
     */
    public void setSeisakuhi(String val) {
        set(TBTHB9WLTVB.SEISAKUHI, val);
    }

    /**
     * SEISAKUHIを返します。
     * @return String SEISAKUHI
     */
    public String getSeisakuhi() {
        return (String) get(TBTHB9WLTVB.SEISAKUHI);
    }


    /**
     * HYOJIJYUNを設定します。
     * @param val String HYOJIJYUN
     */
    public void setHyojijyun(String val) {
        set(TBTHB9WLTVB.HYOJIJYUN, val);
    }

    /**
     * HYOJIJYUNを返します。
     * @return String HYOJIJYUN
     */
    public String getHyojijyun() {
        return (String) get(TBTHB9WLTVB.HYOJIJYUN);
    }

    /**
     * TANKAを設定します。
     * @param val String Tanka
     */
    public void setTanka(String val) {
        set(TBTHB9WLTVB.TANKA, val);
    }

    /**
     * TANKAを返します。
     * @return String Tanka
     */
    public String getTanka() {
        return (String) get(TBTHB9WLTVB.TANKA);
    }

    /**
     * TYPE2を設定します。
     * @param val String TYPE2
     */
    public void setType2(String val) {
        set(TBTHB9WLTVB.TYPE2, val);
    }

    /**
     * TYPE2を返します。
     * @return String TYPE2
     */
    public String getType2() {
        return (String) get(TBTHB9WLTVB.TYPE2);
    }

}