package jp.co.isid.kkh.customer.mac.model.master;

import java.math.BigDecimal;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * マスタデータVO（INSERT用）
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/27 IP Shimizu)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class MasterMacDataInsertVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public MasterMacDataInsertVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new MasterMacDataInsertVO();
    }

    public void SetData(String culumname, Object val){

        set(culumname, val);
    }

    /**
     * 登録タイムスタンプを設定します。
     *
     * @param val String 登録タイムスタンプ
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHBAMST.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     *
     * @return String 登録タイムスタンプ
     */
    public Date getTrkTimStmp() {
        return (Date) get(TBTHBAMST.TRKTIMSTMP);
    }

    /**
     * 登録プログラムを設定します。
     *
     * @param val String 登録プログラム
     */
    public void setTrkPl(String val) {
        set(TBTHBAMST.TRKPL, val);
    }

    /**
     * 登録プログラムを返します。
     *
     * @return String 登録プログラム
     */
    public String getTrkPl() {
        return (String) get(TBTHBAMST.TRKPL);
    }

    /**
     * 登録担当者を設定します。
     *
     * @param val String 登録担当者
     */
    public void setTrkTnt(String val) {
        set(TBTHBAMST.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     *
     * @return String 登録担当者
     */
    public String getTrkTnt() {
        return (String) get(TBTHBAMST.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     *
     * @param val String 更新タイムスタンプ
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHBAMST.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     *
     * @return String 更新タイムスタンプ
     */
    public Date getUpdTimStmp() {
        return (Date) get(TBTHBAMST.UPDTIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     *
     * @param val String 更新プログラム
     */
    public void setUpdaPl(String val) {
        set(TBTHBAMST.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     *
     * @return String 更新プログラム
     */
    public String getUpdaPl() {
        return (String) get(TBTHBAMST.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     *
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHBAMST.UPDTNT, val);
    }

    /**
     * 更新担当者を返します。
     *
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHBAMST.UPDTNT);
    }

    /**
     * 営業所（取）コードを設定します。
     *
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHBAMST.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     *
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHBAMST.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     *
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHBAMST.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     *
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHBAMST.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     *
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHBAMST.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     *
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHBAMST.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     *
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHBAMST.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     *
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHBAMST.TKSTNTSEQNO);
    }

    /**
     * 種別を設定します。
     *
     * @param val String 種別
     */
    public void setSybt(String val) {
        set(TBTHBAMST.SYBT, val);
    }

    /**
     * 種別を返します。
     *
     * @return String 種別
     */
    public String getSybt() {
        return (String) get(TBTHBAMST.SYBT);
    }

    /**
     * フィールド1を設定します。
     *
     * @param val String フィールド1
     */
    public void setField1(String val) {
        set(TBTHBAMST.FIELD1, val);
    }

    /**
     * フィールド1を返します。
     *
     * @return String フィールド1
     */
    public String getField1() {
        return (String) get(TBTHBAMST.FIELD1);
    }

    /**
     * フィールド2を設定します。
     *
     * @param val String フィールド2
     */
    public void setField2(String val) {
        set(TBTHBAMST.FIELD2, val);
    }

    /**
     * フィールド2を返します。
     *
     * @return String フィールド2
     */
    public String getField2() {
        return (String) get(TBTHBAMST.FIELD2);
    }

    /**
     * フィールド3を設定します。
     *
     * @param val String フィールド3
     */
    public void setField3(String val) {
        set(TBTHBAMST.FIELD3, val);
    }

    /**
     * フィールド3を返します。
     *
     * @return String フィールド3
     */
    public String getField3() {
        return (String) get(TBTHBAMST.FIELD3);
    }

    /**
     * フィールド4を設定します。
     *
     * @param val String フィールド4
     */
    public void setField4(String val) {
        set(TBTHBAMST.FIELD4, val);
    }

    /**
     * フィールド4を返します。
     *
     * @return String フィールド4
     */
    public String getField4() {
        return (String) get(TBTHBAMST.FIELD4);
    }

    /**
     * フィールド5を設定します。
     *
     * @param val String フィールド5
     */
    public void setField5(String val) {
        set(TBTHBAMST.FIELD5, val);
    }

    /**
     * フィールド5を返します。
     *
     * @return String フィールド5
     */
    public String getField5() {
        return (String) get(TBTHBAMST.FIELD5);
    }

    /**
     * フィールド6を設定します。
     *
     * @param val String フィールド6
     */
    public void setField6(String val) {
        set(TBTHBAMST.FIELD6, val);
    }

    /**
     * フィールド6を返します。
     *
     * @return String フィールド6
     */
    public String getField6() {
        return (String) get(TBTHBAMST.FIELD6);
    }

    /**
     * フィールド7を設定します。
     *
     * @param val String フィールド7
     */
    public void setField7(String val) {
        set(TBTHBAMST.FIELD7, val);
    }

    /**
     * フィールド7を返します。
     *
     * @return String フィールド7
     */
    public String getField7() {
        return (String) get(TBTHBAMST.FIELD7);
    }

    /**
     * フィールド8を設定します。
     *
     * @param val String フィールド8
     */
    public void setField8(String val) {
        set(TBTHBAMST.FIELD8, val);
    }

    /**
     * フィールド8を返します。
     *
     * @return String フィールド8
     */
    public String getField8() {
        return (String) get(TBTHBAMST.FIELD8);
    }

    /**
     * フィールド9を設定します。
     *
     * @param val String フィールド9
     */
    public void setField9(String val) {
        set(TBTHBAMST.FIELD9, val);
    }

    /**
     * フィールド9を返します。
     *
     * @return String フィールド9
     */
    public String getField9() {
        return (String) get(TBTHBAMST.FIELD9);
    }

    /**
     * フィールド10を設定します。
     *
     * @param val String フィールド10
     */
    public void setField10(String val) {
        set(TBTHBAMST.FIELD10, val);
    }

    /**
     * フィールド10を返します。
     *
     * @return String フィールド10
     */
    public String getField10() {
        return (String) get(TBTHBAMST.FIELD10);
    }

    /**
     * フィールド11を設定します。
     *
     * @param val String フィールド11
     */
    public void setField11(String val) {
        set(TBTHBAMST.FIELD11, val);
    }

    /**
     * フィールド11を返します。
     *
     * @return String フィールド11
     */
    public String getField11() {
        return (String) get(TBTHBAMST.FIELD11);
    }

    /**
     * フィールド12を設定します。
     *
     * @param val String フィールド12
     */
    public void setField12(String val) {
        set(TBTHBAMST.FIELD12, val);
    }

    /**
     * フィールド12を返します。
     *
     * @return String フィールド12
     */
    public String getField12() {
        return (String) get(TBTHBAMST.FIELD12);
    }

    /**
     * フィールド13を設定します。
     *
     * @param val String フィールド13
     */
    public void setField13(String val) {
        set(TBTHBAMST.FIELD13, val);
    }

    /**
     * フィールド13を返します。
     *
     * @return String フィールド13
     */
    public String getField13() {
        return (String) get(TBTHBAMST.FIELD13);
    }

    /**
     * フィールド14を設定します。
     *
     * @param val String フィールド14
     */
    public void setField14(String val) {
        set(TBTHBAMST.FIELD14, val);
    }

    /**
     * フィールド14を返します。
     *
     * @return String フィールド14
     */
    public String getField14() {
        return (String) get(TBTHBAMST.FIELD14);
    }

    /**
     * フィールド15を設定します。
     *
     * @param val String フィールド15
     */
    public void setField15(String val) {
        set(TBTHBAMST.FIELD15, val);
    }

    /**
     * フィールド15を返します。
     *
     * @return String フィールド15
     */
    public String getField15() {
        return (String) get(TBTHBAMST.FIELD15);
    }

    /**
     * フィールド16を設定します。
     *
     * @param val String フィールド16
     */
    public void setField16(String val) {
        set(TBTHBAMST.FIELD16, val);
    }

    /**
     * フィールド16を返します。
     *
     * @return String フィールド16
     */
    public String getField16() {
        return (String) get(TBTHBAMST.FIELD16);
    }

    /**
     * フィールド17を設定します。
     *
     * @param val String フィールド17
     */
    public void setField17(String val) {
        set(TBTHBAMST.FIELD17, val);
    }

    /**
     * フィールド17を返します。
     *
     * @return String フィールド17
     */
    public String getField17() {
        return (String) get(TBTHBAMST.FIELD17);
    }

    /**
     * フィールド18を設定します。
     *
     * @param val String フィールド18
     */
    public void setField18(String val) {
        set(TBTHBAMST.FIELD18, val);
    }

    /**
     * フィールド18を返します。
     *
     * @return String フィールド18
     */
    public String getField18() {
        return (String) get(TBTHBAMST.FIELD18);
    }

    /**
     * フィールド19を設定します。
     *
     * @param val String フィールド19
     */
    public void setField19(String val) {
        set(TBTHBAMST.FIELD19, val);
    }

    /**
     * フィールド19を返します。
     *
     * @return String フィールド19
     */
    public String getField19() {
        return (String) get(TBTHBAMST.FIELD19);
    }

    /**
     * フィールド20を設定します。
     *
     * @param val String フィールド20
     */
    public void setField20(String val) {
        set(TBTHBAMST.FIELD20, val);
    }

    /**
     * フィールド20を返します。
     *
     * @return String フィールド20
     */
    public String getField20() {
        return (String) get(TBTHBAMST.FIELD20);
    }

    /**
     * 数値1を設定します。
     *
     * @param val BigDecimal 数値1
     */
    public void setIntValue1(BigDecimal val) {
        set(TBTHBAMST.INTVALUE1, val);
    }

    /**
     * 数値1を返します。
     *
     * @return BigDecimal 数値1
     */
    public BigDecimal getIntValue1() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE1);
    }

    /**
     * 数値2を設定します。
     *
     * @param val BigDecimal 数値2
     */
    public void setIntValue2(BigDecimal val) {
        set(TBTHBAMST.INTVALUE2, val);
    }

    /**
     * 数値2を返します。
     *
     * @return BigDecimal 数値2
     */
    public BigDecimal getIntValue2() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE2);
    }

    /**
     * 数値3を設定します。
     *
     * @param val BigDecimal 数値3
     */
    public void setIntValue3(BigDecimal val) {
        set(TBTHBAMST.INTVALUE3, val);
    }

    /**
     * 数値3を返します。
     *
     * @return BigDecimal 数値3
     */
    public BigDecimal getIntValue3() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE3);
    }

    /**
     * 数値4を設定します。
     *
     * @param val BigDecimal 数値4
     */
    public void setIntValue4(BigDecimal val) {
        set(TBTHBAMST.INTVALUE4, val);
    }

    /**
     * 数値4を返します。
     *
     * @return BigDecimal 数値4
     */
    public BigDecimal getIntValue4() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE4);
    }

    /**
     * 数値5を設定します。
     *
     * @param val BigDecimal 数値5
     */
    public void setIntValue5(BigDecimal val) {
        set(TBTHBAMST.INTVALUE5, val);
    }

    /**
     * 数値5を返します。
     *
     * @return BigDecimal 数値5
     */
    public BigDecimal getIntValue5() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE5);
    }

    /**
     * 数値6を設定します。
     *
     * @param val BigDecimal 数値6
     */
    public void setIntValue6(BigDecimal val) {
        set(TBTHBAMST.INTVALUE6, val);
    }

    /**
     * 数値6を返します。
     *
     * @return BigDecimal 数値6
     */
    public BigDecimal getIntValue6() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE6);
    }

    /**
     * 数値7を設定します。
     *
     * @param val BigDecimal 数値7
     */
    public void setIntValue7(BigDecimal val) {
        set(TBTHBAMST.INTVALUE7, val);
    }

    /**
     * 数値7を返します。
     *
     * @return BigDecimal 数値7
     */
    public BigDecimal getIntValue7() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE7);
    }

    /**
     * 数値8を設定します。
     *
     * @param val BigDecimal 数値8
     */
    public void setIntValue8(BigDecimal val) {
        set(TBTHBAMST.INTVALUE8, val);
    }

    /**
     * 数値8を返します。
     *
     * @return BigDecimal 数値8
     */
    public BigDecimal getIntValue8() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE8);
    }

    /**
     * 数値9を設定します。
     *
     * @param val BigDecimal 数値9
     */
    public void setIntValue9(BigDecimal val) {
        set(TBTHBAMST.INTVALUE9, val);
    }

    /**
     * 数値9を返します。
     *
     * @return BigDecimal 数値9
     */
    public BigDecimal getIntValue9() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE9);
    }

    /**
     * 数値10を設定します。
     *
     * @param val BigDecimal 数値10
     */
    public void setIntValue10(BigDecimal val) {
        set(TBTHBAMST.INTVALUE10, val);
    }

    /**
     * 数値10を返します。
     *
     * @return BigDecimal 数値10
     */
    public BigDecimal getIntValue10() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE10);
    }

}
