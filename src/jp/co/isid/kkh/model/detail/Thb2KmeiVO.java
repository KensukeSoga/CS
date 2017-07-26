package jp.co.isid.kkh.model.detail;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class Thb2KmeiVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public Thb2KmeiVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new Thb2KmeiVO();
    }

    /**
     * タイムスタンプを設定します。
     * @param val Date タイムスタンプ
     */
    public void setHb2TimStmp(Date val) {
        set(TBTHB2KMEI.TIMSTMP, val);
    }

    /**
     * タイムスタンプを返します。
     * @return Date タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getHb2TimStmp() {
        return (Date) get(TBTHB2KMEI.TIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setHb2UpdApl(String val) {
        set(TBTHB2KMEI.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getHb2UpdApl() {
        return (String) get(TBTHB2KMEI.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setHb2UpdTnt(String val) {
        set(TBTHB2KMEI.UPDTNT, val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getHb2UpdTnt() {
        return (String) get(TBTHB2KMEI.UPDTNT);
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setHb2EgCd(String val) {
        set(TBTHB2KMEI.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getHb2EgCd() {
        return (String) get(TBTHB2KMEI.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setHb2TksKgyCd(String val) {
        set(TBTHB2KMEI.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getHb2TksKgyCd() {
        return (String) get(TBTHB2KMEI.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setHb2TksBmnSeqNo(String val) {
        set(TBTHB2KMEI.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getHb2TksBmnSeqNo() {
        return (String) get(TBTHB2KMEI.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setHb2TksTntSeqNo(String val) {
        set(TBTHB2KMEI.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getHb2TksTntSeqNo() {
        return (String) get(TBTHB2KMEI.TKSTNTSEQNO);
    }

    /**
     * 年月を設定します。
     * @param val String 年月
     */
    public void setHb2Yymm(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * 年月を返します。
     * @return String 年月
     */
    public String getHb2Yymm() {
        return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
     * 受注Noを設定します。
     * @param val String 受注No
     */
    public void setHb2JyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * 受注Noを返します。
     * @return String 受注No
     */
    public String getHb2JyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * 受注明細Noを設定します。
     * @param val String 受注明細No
     */
    public void setHb2JyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 受注明細Noを返します。
     * @return String 受注明細No
     */
    public String getHb2JyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 売上明細Noを設定します。
     * @param val String 売上明細No
     */
    public void setHb2UrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 売上明細Noを返します。
     * @return String 売上明細No
     */
    public String getHb2UrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 費目コードを設定します。
     * @param val String 費目コード
     */
    public void setHb2HimkCd(String val) {
        set(TBTHB2KMEI.HIMKCD, val);
    }

    /**
     * 費目コードを返します。
     * @return String 費目コード
     */
    public String getHb2HimkCd() {
        return (String) get(TBTHB2KMEI.HIMKCD);
    }

    /**
     * 連番を設定します。
     * @param val String 連番
     */
    public void setHb2Renbn(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * 連番を返します。
     * @return String 連番
     */
    public String getHb2Renbn() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * 年月日Fromを設定します。
     * @param val String 年月日From
     */
    public void setHb2DateFrom(String val) {
        set(TBTHB2KMEI.DATEFROM, val);
    }

    /**
     * 年月日Fromを返します。
     * @return String 年月日From
     */
    public String getHb2DateFrom() {
        return (String) get(TBTHB2KMEI.DATEFROM);
    }

    /**
     * 年月日Toを設定します。
     * @param val String 年月日To
     */
    public void setHb2DateTo(String val) {
        set(TBTHB2KMEI.DATETO, val);
    }

    /**
     * 年月日Toを返します。
     * @return String 年月日To
     */
    public String getHb2DateTo() {
        return (String) get(TBTHB2KMEI.DATETO);
    }

    /**
     * 請求金額を設定します。
     * @param val BigDecimal 請求金額
     */
    public void setHb2SeiGak(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * 請求金額を返します。
     * @return BigDecimal 請求金額
     */
    @XmlElement(required = true)
    public BigDecimal getHb2SeiGak() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * 変更値引率を設定します。
     * @param val BigDecimal 変更値引率
     */
    public void setHb2Hnnert(BigDecimal val) {
        set(TBTHB2KMEI.HNNERT, val);
    }

    /**
     * 変更値引率を返します。
     * @return BigDecimal 変更値引率
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Hnnert() {
        return (BigDecimal) get(TBTHB2KMEI.HNNERT);
    }

    /**
     * 値引率変更前金額を設定します。
     * @param val BigDecimal 値引率変更前金額
     */
    public void setHb2HnmaeGak(BigDecimal val) {
        set(TBTHB2KMEI.HNMAEGAK, val);
    }

    /**
     * 値引率変更前金額を返します。
     * @return BigDecimal 値引率変更前金額
     */
    @XmlElement(required = true)
    public BigDecimal getHb2HnmaeGak() {
        return (BigDecimal) get(TBTHB2KMEI.HNMAEGAK);
    }

    /**
     * 値引額を設定します。
     * @param val BigDecimal 値引額
     */
    public void setHb2NebiGak(BigDecimal val) {
        set(TBTHB2KMEI.NEBIGAK, val);
    }

    /**
     * 値引額を返します。
     * @return BigDecimal 値引額
     */
    @XmlElement(required = true)
    public BigDecimal getHb2NebiGak() {
        return (BigDecimal) get(TBTHB2KMEI.NEBIGAK);
    }

    /**
     * 日付1を設定します。
     * @param val String 日付1
     */
    public void setHb2Date1(String val) {
        set(TBTHB2KMEI.DATE1, val);
    }

    /**
     * 日付1を返します。
     * @return String 日付1
     */
    public String getHb2Date1() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * 日付2を設定します。
     * @param val String 日付2
     */
    public void setHb2Date2(String val) {
        set(TBTHB2KMEI.DATE2, val);
    }

    /**
     * 日付2を返します。
     * @return String 日付2
     */
    public String getHb2Date2() {
        return (String) get(TBTHB2KMEI.DATE2);
    }

    /**
     * 日付3を設定します。
     * @param val String 日付3
     */
    public void setHb2Date3(String val) {
        set(TBTHB2KMEI.DATE3, val);
    }

    /**
     * 日付3を返します。
     * @return String 日付3
     */
    public String getHb2Date3() {
        return (String) get(TBTHB2KMEI.DATE3);
    }

    /**
     * 日付4を設定します。
     * @param val String 日付4
     */
    public void setHb2Date4(String val) {
        set(TBTHB2KMEI.DATE4, val);
    }

    /**
     * 日付4を返します。
     * @return String 日付4
     */
    public String getHb2Date4() {
        return (String) get(TBTHB2KMEI.DATE4);
    }

    /**
     * 日付5を設定します。
     * @param val String 日付5
     */
    public void setHb2Date5(String val) {
        set(TBTHB2KMEI.DATE5, val);
    }

    /**
     * 日付5を返します。
     * @return String 日付5
     */
    public String getHb2Date5() {
        return (String) get(TBTHB2KMEI.DATE5);
    }

    /**
     * 日付6を設定します。
     * @param val String 日付6
     */
    public void setHb2Date6(String val) {
        set(TBTHB2KMEI.DATE6, val);
    }

    /**
     * 日付6を返します。
     * @return String 日付6
     */
    public String getHb2Date6() {
        return (String) get(TBTHB2KMEI.DATE6);
    }

    /**
     * 区分1を設定します。
     * @param val String 区分1
     */
    public void setHb2Kbn1(String val) {
        set(TBTHB2KMEI.KBN1, val);
    }

    /**
     * 区分1を返します。
     * @return String 区分1
     */
    public String getHb2Kbn1() {
        return (String) get(TBTHB2KMEI.KBN1);
    }

    /**
     * 区分2を設定します。
     * @param val String 区分2
     */
    public void setHb2Kbn2(String val) {
        set(TBTHB2KMEI.KBN2, val);
    }

    /**
     * 区分2を返します。
     * @return String 区分2
     */
    public String getHb2Kbn2() {
        return (String) get(TBTHB2KMEI.KBN2);
    }

    /**
     * 区分3を設定します。
     * @param val String 区分3
     */
    public void setHb2Kbn3(String val) {
        set(TBTHB2KMEI.KBN3, val);
    }

    /**
     * 区分3を返します。
     * @return String 区分3
     */
    public String getHb2Kbn3() {
        return (String) get(TBTHB2KMEI.KBN3);
    }

    /**
     * コード1を設定します。
     * @param val String コード1
     */
    public void setHb2Code1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * コード1を返します。
     * @return String コード1
     */
    public String getHb2Code1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * コード2を設定します。
     * @param val String コード2
     */
    public void setHb2Code2(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * コード2を返します。
     * @return String コード2
     */
    public String getHb2Code2() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * コード3を設定します。
     * @param val String コード3
     */
    public void setHb2Code3(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * コード3を返します。
     * @return String コード3
     */
    public String getHb2Code3() {
        return (String) get(TBTHB2KMEI.CODE3);
    }

    /**
     * コード4を設定します。
     * @param val String コード4
     */
    public void setHb2Code4(String val) {
        set(TBTHB2KMEI.CODE4, val);
    }

    /**
     * コード4を返します。
     * @return String コード4
     */
    public String getHb2Code4() {
        return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
     * コード5を設定します。
     * @param val String コード5
     */
    public void setHb2Code5(String val) {
        set(TBTHB2KMEI.CODE5, val);
    }

    /**
     * コード5を返します。
     * @return String コード5
     */
    public String getHb2Code5() {
        return (String) get(TBTHB2KMEI.CODE5);
    }

    /**
     * コード6を設定します。
     * @param val String コード6
     */
    public void setHb2Code6(String val) {
        set(TBTHB2KMEI.CODE6, val);
    }

    /**
     * コード6を返します。
     * @return String コード6
     */
    public String getHb2Code6() {
        return (String) get(TBTHB2KMEI.CODE6);
    }

    /**
     * 名称1(漢字)を設定します。
     * @param val String 名称1(漢字)
     */
    public void setHb2Name1(String val) {
        set(TBTHB2KMEI.NAME1, val);
    }

    /**
     * 名称1(漢字)を返します。
     * @return String 名称1(漢字)
     */
    public String getHb2Name1() {
        return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
     * 名称2(漢字)を設定します。
     * @param val String 名称2(漢字)
     */
    public void setHb2Name2(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * 名称2(漢字)を返します。
     * @return String 名称2(漢字)
     */
    public String getHb2Name2() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * 名称3(漢字)を設定します。
     * @param val String 名称3(漢字)
     */
    public void setHb2Name3(String val) {
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * 名称3(漢字)を返します。
     * @return String 名称3(漢字)
     */
    public String getHb2Name3() {
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * 名称4(漢字)を設定します。
     * @param val String 名称4(漢字)
     */
    public void setHb2Name4(String val) {
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * 名称4(漢字)を返します。
     * @return String 名称4(漢字)
     */
    public String getHb2Name4() {
        return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
     * 名称5(漢字)を設定します。
     * @param val String 名称5(漢字)
     */
    public void setHb2Name5(String val) {
        set(TBTHB2KMEI.NAME5, val);
    }

    /**
     * 名称5(漢字)を返します。
     * @return String 名称5(漢字)
     */
    public String getHb2Name5() {
        return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
     * 名称6(漢字)を設定します。
     * @param val String 名称6(漢字)
     */
    public void setHb2Name6(String val) {
        set(TBTHB2KMEI.NAME6, val);
    }

    /**
     * 名称6(漢字)を返します。
     * @return String 名称6(漢字)
     */
    public String getHb2Name6() {
        return (String) get(TBTHB2KMEI.NAME6);
    }

    /**
     * 名称7(漢字)を設定します。
     * @param val String 名称7(漢字)
     */
    public void setHb2Name7(String val) {
        set(TBTHB2KMEI.NAME7, val);
    }

    /**
     * 名称7(漢字)を返します。
     * @return String 名称7(漢字)
     */
    public String getHb2Name7() {
        return (String) get(TBTHB2KMEI.NAME7);
    }

    /**
     * 名称8(漢字)を設定します。
     * @param val String 名称8(漢字)
     */
    public void setHb2Name8(String val) {
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * 名称8(漢字)を返します。
     * @return String 名称8(漢字)
     */
    public String getHb2Name8() {
        return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
     * 名称9(漢字)を設定します。
     * @param val String 名称9(漢字)
     */
    public void setHb2Name9(String val) {
        set(TBTHB2KMEI.NAME9, val);
    }

    /**
     * 名称9(漢字)を返します。
     * @return String 名称9(漢字)
     */
    public String getHb2Name9() {
        return (String) get(TBTHB2KMEI.NAME9);
    }

    /**
     * 名称10(漢字)を設定します。
     * @param val String 名称10(漢字)
     */
    public void setHb2Name10(String val) {
        set(TBTHB2KMEI.NAME10, val);
    }

    /**
     * 名称10(漢字)を返します。
     * @return String 名称10(漢字)
     */
    public String getHb2Name10() {
        return (String) get(TBTHB2KMEI.NAME10);
    }

    /**
     * 名称11(漢字)を設定します。
     * @param val String 名称11(漢字)
     */
    public void setHb2Name11(String val) {
        set(TBTHB2KMEI.NAME11, val);
    }

    /**
     * 名称11(漢字)を返します。
     * @return String 名称11(漢字)
     */
    public String getHb2Name11() {
        return (String) get(TBTHB2KMEI.NAME11);
    }

    /**
     * 名称12(漢字)を設定します。
     * @param val String 名称12(漢字)
     */
    public void setHb2Name12(String val) {
        set(TBTHB2KMEI.NAME12, val);
    }

    /**
     * 名称12(漢字)を返します。
     * @return String 名称12(漢字)
     */
    public String getHb2Name12() {
        return (String) get(TBTHB2KMEI.NAME12);
    }

    /**
     * 名称13(漢字)を設定します。
     * @param val String 名称13(漢字)
     */
    public void setHb2Name13(String val) {
        set(TBTHB2KMEI.NAME13, val);
    }

    /**
     * 名称13(漢字)を返します。
     * @return String 名称13(漢字)
     */
    public String getHb2Name13() {
        return (String) get(TBTHB2KMEI.NAME13);
    }

    /**
     * 名称14(漢字)を設定します。
     * @param val String 名称14(漢字)
     */
    public void setHb2Name14(String val) {
        set(TBTHB2KMEI.NAME14, val);
    }

    /**
     * 名称14(漢字)を返します。
     * @return String 名称14(漢字)
     */
    public String getHb2Name14() {
        return (String) get(TBTHB2KMEI.NAME14);
    }

    /**
     * 名称15(漢字)を設定します。
     * @param val String 名称15(漢字)
     */
    public void setHb2Name15(String val) {
        set(TBTHB2KMEI.NAME15, val);
    }

    /**
     * 名称15(漢字)を返します。
     * @return String 名称15(漢字)
     */
    public String getHb2Name15() {
        return (String) get(TBTHB2KMEI.NAME15);
    }

    /**
     * 名称16(漢字)を設定します。
     * @param val String 名称16(漢字)
     */
    public void setHb2Name16(String val) {
        set(TBTHB2KMEI.NAME16, val);
    }

    /**
     * 名称16(漢字)を返します。
     * @return String 名称16(漢字)
     */
    public String getHb2Name16() {
        return (String) get(TBTHB2KMEI.NAME16);
    }

    /**
     * 名称17(漢字)を設定します。
     * @param val String 名称17(漢字)
     */
    public void setHb2Name17(String val) {
        set(TBTHB2KMEI.NAME17, val);
    }

    /**
     * 名称17(漢字)を返します。
     * @return String 名称17(漢字)
     */
    public String getHb2Name17() {
        return (String) get(TBTHB2KMEI.NAME17);
    }

    /**
     * 名称18(漢字)を設定します。
     * @param val String 名称18(漢字)
     */
    public void setHb2Name18(String val) {
        set(TBTHB2KMEI.NAME18, val);
    }

    /**
     * 名称18(漢字)を返します。
     * @return String 名称18(漢字)
     */
    public String getHb2Name18() {
        return (String) get(TBTHB2KMEI.NAME18);
    }

    /**
     * 名称19(漢字)を設定します。
     * @param val String 名称19(漢字)
     */
    public void setHb2Name19(String val) {
        set(TBTHB2KMEI.NAME19, val);
    }

    /**
     * 名称19(漢字)を返します。
     * @return String 名称19(漢字)
     */
    public String getHb2Name19() {
        return (String) get(TBTHB2KMEI.NAME19);
    }

    /**
     * 名称20(漢字)を設定します。
     * @param val String 名称20(漢字)
     */
    public void setHb2Name20(String val) {
        set(TBTHB2KMEI.NAME20, val);
    }

    /**
     * 名称20(漢字)を返します。
     * @return String 名称20(漢字)
     */
    public String getHb2Name20() {
        return (String) get(TBTHB2KMEI.NAME20);
    }

    /**
     * 名称21(漢字)を設定します。
     * @param val String 名称21(漢字)
     */
    public void setHb2Name21(String val) {
        set(TBTHB2KMEI.NAME21, val);
    }

    /**
     * 名称21(漢字)を返します。
     * @return String 名称21(漢字)
     */
    public String getHb2Name21() {
        return (String) get(TBTHB2KMEI.NAME21);
    }

    /**
     * 名称22(漢字)を設定します。
     * @param val String 名称22(漢字)
     */
    public void setHb2Name22(String val) {
        set(TBTHB2KMEI.NAME22, val);
    }

    /**
     * 名称22(漢字)を返します。
     * @return String 名称22(漢字)
     */
    public String getHb2Name22() {
        return (String) get(TBTHB2KMEI.NAME22);
    }

    /**
     * 名称23(漢字)を設定します。
     * @param val String 名称23(漢字)
     */
    public void setHb2Name23(String val) {
        set(TBTHB2KMEI.NAME23, val);
    }

    /**
     * 名称23(漢字)を返します。
     * @return String 名称23(漢字)
     */
    public String getHb2Name23() {
        return (String) get(TBTHB2KMEI.NAME23);
    }

    /**
     * 名称24(漢字)を設定します。
     * @param val String 名称24(漢字)
     */
    public void setHb2Name24(String val) {
        set(TBTHB2KMEI.NAME24, val);
    }

    /**
     * 名称24(漢字)を返します。
     * @return String 名称24(漢字)
     */
    public String getHb2Name24() {
        return (String) get(TBTHB2KMEI.NAME24);
    }

    /**
     * 名称25(漢字)を設定します。
     * @param val String 名称25(漢字)
     */
    public void setHb2Name25(String val) {
        set(TBTHB2KMEI.NAME25, val);
    }

    /**
     * 名称25(漢字)を返します。
     * @return String 名称25(漢字)
     */
    public String getHb2Name25() {
        return (String) get(TBTHB2KMEI.NAME25);
    }

    /**
     * 名称26(漢字)を設定します。
     * @param val String 名称26(漢字)
     */
    public void setHb2Name26(String val) {
        set(TBTHB2KMEI.NAME26, val);
    }

    /**
     * 名称26(漢字)を返します。
     * @return String 名称26(漢字)
     */
    public String getHb2Name26() {
        return (String) get(TBTHB2KMEI.NAME26);
    }

    /**
     * 名称27(漢字)を設定します。
     * @param val String 名称27(漢字)
     */
    public void setHb2Name27(String val) {
        set(TBTHB2KMEI.NAME27, val);
    }

    /**
     * 名称27(漢字)を返します。
     * @return String 名称27(漢字)
     */
    public String getHb2Name27() {
        return (String) get(TBTHB2KMEI.NAME27);
    }

    /**
     * 名称28(漢字)を設定します。
     * @param val String 名称28(漢字)
     */
    public void setHb2Name28(String val) {
        set(TBTHB2KMEI.NAME28, val);
    }

    /**
     * 名称28(漢字)を返します。
     * @return String 名称28(漢字)
     */
    public String getHb2Name28() {
        return (String) get(TBTHB2KMEI.NAME28);
    }

    /**
     * 名称29(漢字)を設定します。
     * @param val String 名称29(漢字)
     */
    public void setHb2Name29(String val) {
        set(TBTHB2KMEI.NAME29, val);
    }

    /**
     * 名称29(漢字)を返します。
     * @return String 名称29(漢字)
     */
    public String getHb2Name29() {
        return (String) get(TBTHB2KMEI.NAME29);
    }

    /**
     * 名称30(漢字)を設定します。
     * @param val String 名称30(漢字)
     */
    public void setHb2Name30(String val) {
        set(TBTHB2KMEI.NAME30, val);
    }

    /**
     * 名称30(漢字)を返します。
     * @return String 名称30(漢字)
     */
    public String getHb2Name30() {
        return (String) get(TBTHB2KMEI.NAME30);
    }

    /**
     * 金額1を設定します。
     * @param val BigDecimal 金額1
     */
    public void setHb2Kngk1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * 金額1を返します。
     * @return BigDecimal 金額1
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Kngk1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * 金額2を設定します。
     * @param val BigDecimal 金額2
     */
    public void setHb2Kngk2(BigDecimal val) {
        set(TBTHB2KMEI.KNGK2, val);
    }

    /**
     * 金額2を返します。
     * @return BigDecimal 金額2
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Kngk2() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK2);
    }

    /**
     * 金額3を設定します。
     * @param val BigDecimal 金額3
     */
    public void setHb2Kngk3(BigDecimal val) {
        set(TBTHB2KMEI.KNGK3, val);
    }

    /**
     * 金額3を返します。
     * @return BigDecimal 金額3
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Kngk3() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK3);
    }

    /**
     * 比率1を設定します。
     * @param val BigDecimal 比率1
     */
    public void setHb2Ritu1(BigDecimal val) {
        set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * 比率1を返します。
     * @return BigDecimal 比率1
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Ritu1() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }

    /**
     * 比率2を設定します。
     * @param val BigDecimal 比率2
     */
    public void setHb2Ritu2(BigDecimal val) {
        set(TBTHB2KMEI.RITU2, val);
    }

    /**
     * 比率2を返します。
     * @return BigDecimal 比率2
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Ritu2() {
        return (BigDecimal) get(TBTHB2KMEI.RITU2);
    }

    /**
     * その他1を設定します。
     * @param val String その他1
     */
    public void setHb2Sonota1(String val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * その他1を返します。
     * @return String その他1
     */
    public String getHb2Sonota1() {
        return (String) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * その他2を設定します。
     * @param val String その他2
     */
    public void setHb2Sonota2(String val) {
        set(TBTHB2KMEI.SONOTA2, val);
    }

    /**
     * その他2を返します。
     * @return String その他2
     */
    public String getHb2Sonota2() {
        return (String) get(TBTHB2KMEI.SONOTA2);
    }

    /**
     * その他3を設定します。
     * @param val String その他3
     */
    public void setHb2Sonota3(String val) {
        set(TBTHB2KMEI.SONOTA3, val);
    }

    /**
     * その他3を返します。
     * @return String その他3
     */
    public String getHb2Sonota3() {
        return (String) get(TBTHB2KMEI.SONOTA3);
    }

    /**
     * その他4を設定します。
     * @param val String その他4
     */
    public void setHb2Sonota4(String val) {
        set(TBTHB2KMEI.SONOTA4, val);
    }

    /**
     * その他4を返します。
     * @return String その他4
     */
    public String getHb2Sonota4() {
        return (String) get(TBTHB2KMEI.SONOTA4);
    }

    /**
     * その他5を設定します。
     * @param val String その他5
     */
    public void setHb2Sonota5(String val) {
        set(TBTHB2KMEI.SONOTA5, val);
    }

    /**
     * その他5を返します。
     * @return String その他5
     */
    public String getHb2Sonota5() {
        return (String) get(TBTHB2KMEI.SONOTA5);
    }

    /**
     * その他6を設定します。
     * @param val String その他6
     */
    public void setHb2Sonota6(String val) {
        set(TBTHB2KMEI.SONOTA6, val);
    }

    /**
     * その他6を返します。
     * @return String その他6
     */
    public String getHb2Sonota6() {
        return (String) get(TBTHB2KMEI.SONOTA6);
    }

    /**
     * その他7を設定します。
     * @param val String その他7
     */
    public void setHb2Sonota7(String val) {
        set(TBTHB2KMEI.SONOTA7, val);
    }

    /**
     * その他7を返します。
     * @return String その他7
     */
    public String getHb2Sonota7() {
        return (String) get(TBTHB2KMEI.SONOTA7);
    }

    /**
     * その他8を設定します。
     * @param val String その他8
     */
    public void setHb2Sonota8(String val) {
        set(TBTHB2KMEI.SONOTA8, val);
    }

    /**
     * その他8を返します。
     * @return String その他8
     */
    public String getHb2Sonota8() {
        return (String) get(TBTHB2KMEI.SONOTA8);
    }

    /**
     * その他9を設定します。
     * @param val String その他9
     */
    public void setHb2Sonota9(String val) {
        set(TBTHB2KMEI.SONOTA9, val);
    }

    /**
     * その他9を返します。
     * @return String その他9
     */
    public String getHb2Sonota9() {
        return (String) get(TBTHB2KMEI.SONOTA9);
    }

    /**
     * その他10を設定します。
     * @param val String その他10
     */
    public void setHb2Sonota10(String val) {
        set(TBTHB2KMEI.SONOTA10, val);
    }

    /**
     * その他10を返します。
     * @return String その他10
     */
    public String getHb2Sonota10() {
        return (String) get(TBTHB2KMEI.SONOTA10);
    }

    /**
     * 分割フラグを設定します。
     * @param val String 分割フラグ
     */
    public void setHb2BunFlg(String val) {
        set(TBTHB2KMEI.BUNFLG, val);
    }

    /**
     * 分割フラグを返します。
     * @return String 分割フラグ
     */
    public String getHb2BunFlg() {
        return (String) get(TBTHB2KMEI.BUNFLG);
    }

    /**
     * 件名変更フラグを設定します。
     * @param val String 件名変更フラグ
     */
    public void setHb2MeihnFlg(String val) {
        set(TBTHB2KMEI.MEIHNFLG, val);
    }

    /**
     * 件名変更フラグを返します。
     * @return String 件名変更フラグ
     */
    public String getHb2MeihnFlg() {
        return (String) get(TBTHB2KMEI.MEIHNFLG);
    }

    /**
     * 値引率変更フラグを設定します。
     * @param val String 値引率変更フラグ
     */
    public void setHb2NebhnFlg(String val) {
        set(TBTHB2KMEI.NEBHNFLG, val);
    }

    /**
     * 値引率変更フラグを返します。
     * @return String 値引率変更フラグ
     */
    public String getHb2NebhnFlg() {
        return (String) get(TBTHB2KMEI.NEBHNFLG);
    }

}
