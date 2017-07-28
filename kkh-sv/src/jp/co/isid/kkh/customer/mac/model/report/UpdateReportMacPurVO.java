package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurDataVO;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * データ更新(購入伝票)積立用リスト
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/17 IP Shimizu)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class UpdateReportMacPurVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public UpdateReportMacPurVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new UpdateReportMacPurDataVO();
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
     * 伝票番号を設定します。
     *
     * @param val String 伝票番号
     */
    public void setSonota1(String val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * 伝票番号を返します。
     *
     * @return String 伝票番号
     */
    public String getSonota1() {
        return (String) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * 店舗区分を設定します。
     *
     * @param val String 店舗区分
     */
    public void setKbn1(String val) {
        set(TBTHB2KMEI.KBN1, val);
    }

    /**
     * 店舗区分を返します。
     *
     * @return String 店舗区分
     */
    public String getKbn1() {
        return (String) get(TBTHB2KMEI.KBN1);
    }

}
