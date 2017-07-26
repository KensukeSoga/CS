package jp.co.isid.kkh.model.common;

import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHBBSYS;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * マスタデータVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 IP H.SHimizu)<BR>
 * </P>
 * @author
 */
public class CommonVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public CommonVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new CommonVO();
    }

    /**
     * 登録タイムスタンプを設定します。
     * @param val String 登録タイムスタンプ
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHBBSYS.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return String 登録タイムスタンプ
     */
    public Date getTrkTimStmp() {
        return (Date) get(TBTHBBSYS.TRKTIMSTMP);
    }

    /**
     * 登録プログラムを設定します。
     * @param val String 登録プログラム
     */
    public void setTrkPl(String val) {
        set(TBTHBBSYS.TRKPL, val);
    }

    /**
     * 登録プログラムを返します。
     * @return String 登録プログラム
     */
    public String getTrkPl() {
        return (String) get(TBTHBBSYS.TRKPL);
    }

    /**
     * 登録担当者を設定します。
     * @param val String 登録担当者
     */
    public void setTrkTnt(String val) {
        set(TBTHBBSYS.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     * @return String 登録担当者
     */
    public String getTrkTnt() {
        return (String) get(TBTHBBSYS.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新タイムスタンプ
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHBBSYS.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新タイムスタンプ
     */
    public Date getUpdTimStmp() {
        return (Date) get(TBTHBBSYS.UPDTIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setUpdaPl(String val) {
        set(TBTHBBSYS.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getUpdaPl() {
        return (String) get(TBTHBBSYS.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHBBSYS.UPDTNT   , val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHBBSYS.UPDTNT   );
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHBBSYS.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHBBSYS.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHBBSYS.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHBBSYS.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHBBSYS.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHBBSYS.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHBBSYS.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHBBSYS.TKSTNTSEQNO);
    }

    /**
     * 種別を設定します。
     * @param val String 種別
     */
    public void setSybt(String val) {
        set(TBTHBBSYS.SYBT, val);
    }

    /**
     * 種別を返します。
     * @return String 種別
     */
    public String getSybt() {
        return (String) get(TBTHBBSYS.SYBT);
    }

    /**
     * フィールド1を設定します。
     * @param val String フィールド1
     */
    public void setField1(String val) {
        set(TBTHBBSYS.FIELD1, val);
    }

    /**
     * フィールド1を返します。
     * @return String フィールド1
     */
    public String getField1() {
        return (String) get(TBTHBBSYS.FIELD1);
    }

    /**
     * フィールド2を設定します。
     * @param val String フィールド2
     */
    public void setField2(String val) {
        set(TBTHBBSYS.FIELD2, val);
    }

    /**
     * フィールド2を返します。
     * @return String フィールド2
     */
    public String getField2() {
        return (String) get(TBTHBBSYS.FIELD2);
    }

    /**
     * フィールド3を設定します。
     * @param val String フィールド3
     */
    public void setField3(String val) {
        set(TBTHBBSYS.FIELD3, val);
    }

    /**
     * フィールド3を返します。
     * @return String フィールド3
     */
    public String getField3() {
        return (String) get(TBTHBBSYS.FIELD3);
    }

    /**
     * フィールド4を設定します。
     * @param val String フィールド4
     */
    public void setField4(String val) {
        set(TBTHBBSYS.FIELD4, val);
    }

    /**
     * フィールド4を返します。
     * @return String フィールド4
     */
    public String getField4() {
        return (String) get(TBTHBBSYS.FIELD4);
    }

    /**
     * フィールド5を設定します。
     * @param val String フィールド5
     */
    public void setField5(String val) {
        set(TBTHBBSYS.FIELD5, val);
    }

    /**
     * フィールド5を返します。
     * @return String フィールド5
     */
    public String getField5() {
        return (String) get(TBTHBBSYS.FIELD5);
    }

    /**
     * フィールド6を設定します。
     * @param val String フィールド6
     */
    public void setField6(String val) {
        set(TBTHBBSYS.FIELD6, val);
    }

    /**
     * フィールド6を返します。
     * @return String フィールド6
     */
    public String getField6() {
        return (String) get(TBTHBBSYS.FIELD6);
    }

    /**
     * フィールド7を設定します。
     * @param val String フィールド7
     */
    public void setField7(String val) {
        set(TBTHBBSYS.FIELD7, val);
    }

    /**
     * フィールド7を返します。
     * @return String フィールド7
     */
    public String getField7() {
        return (String) get(TBTHBBSYS.FIELD7);
    }

    /**
     * フィールド8を設定します。
     * @param val String フィールド8
     */
    public void setField8(String val) {
        set(TBTHBBSYS.FIELD8, val);
    }

    /**
     * フィールド8を返します。
     * @return String フィールド8
     */
    public String getField8() {
        return (String) get(TBTHBBSYS.FIELD8);
    }

    /**
     * フィールド9を設定します。
     * @param val String フィールド9
     */
    public void setField9(String val) {
        set(TBTHBBSYS.FIELD9, val);
    }

    /**
     * フィールド9を返します。
     * @return String フィールド9
     */
    public String getField9() {
        return (String) get(TBTHBBSYS.FIELD9);
    }

    /**
     * フィールド10を設定します。
     * @param val String フィールド10
     */
    public void setField10(String val) {
        set(TBTHBBSYS.FIELD10, val);
    }

    /**
     * フィールド10を返します。
     * @return String フィールド10
     */
    public String getField10() {
        return (String) get(TBTHBBSYS.FIELD10);
    }

}
