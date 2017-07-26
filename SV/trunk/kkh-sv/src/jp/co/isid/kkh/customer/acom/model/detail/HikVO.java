package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.Date;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 発注データVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/10 form H.Izawa)<BR>
 * </P>
 * @author form H.Izawa
 */

public class HikVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public HikVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new HikVO();
    }

    /**
     * 登録タイムスタンプを設定します。
     * @param val String 登録タイムスタンプ
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB5HIK.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return String 登録タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB5HIK.TRKTIMSTMP);
    }

    /**
     * 登録プログラムを設定します。
     * @param val String 登録プログラム
     */
    public void setTrkPl(String val) {
        set(TBTHB5HIK.TRKPL, val);
    }

    /**
     * 登録プログラムを返します。
     * @return String 登録プログラム
     */
    public String getTrkPl() {
        return (String) get(TBTHB5HIK.TRKPL);
    }

    /**
     * 登録担当者を設定します。
     * @param val String 登録担当者
     */
    public void setTrkTnt(String val) {
        set(TBTHB5HIK.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     * @return String 登録担当者
     */
    public String getTrkTnt() {
        return (String) get(TBTHB5HIK.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新タイムスタンプ
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB5HIK.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB5HIK.UPDTIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setUpdaPl(String val) {
        set(TBTHB5HIK.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getUpdaPl() {
        return (String) get(TBTHB5HIK.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHB5HIK.UPDTN, val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHB5HIK.UPDTN);
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHB5HIK.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHB5HIK.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHB5HIK.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB5HIK.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB5HIK.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB5HIK.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB5HIK.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB5HIK.TKSTNTSEQNO);
    }

    /**
     * 種別を設定します。
     * @param val String 種別
     */
    public void setSybt(String val) {
        set(TBTHB5HIK.SYBT, val);
    }

    /**
     * 種別を返します。
     * @return String 種別
     */
    public String getSybt() {
        return (String) get(TBTHB5HIK.SYBT);
    }

    /**
     * レコード種別を設定します。
     * @param val String レコード種別
     */
    public void setRecCd(String val) {
        set(TBTHB5HIK.RECCD, val);
    }

    /**
     * レコード種別を返します。
     * @return String レコード種別
     */
    public String getRecCd() {
        return (String) get(TBTHB5HIK.RECCD);
    }

    /**
     * 依頼番号を設定します。
     * @param val String 依頼番号
     */
    public void setIrban(String val) {
        set(TBTHB5HIK.IRBAN, val);
    }

    /**
     * 依頼番号を返します。
     * @return String 依頼番号
     */
    public String getIrban() {
        return (String) get(TBTHB5HIK.IRBAN);
    }

    /**
     * 依頼行番号を設定します。
     * @param val String 依頼行番号
     */
    public void setIrrowban(String val) {
        set(TBTHB5HIK.IRROWBAN, val);
    }

    /**
     * 依頼行番号を返します。
     * @return String 依頼行番号
     */
    public String getIrrowban() {
        return (String) get(TBTHB5HIK.IRROWBAN);
    }

    /**
     * 履歴管理番号を設定します。
     * @param val String 履歴管理番号
     */
    public void setRireNo(String val) {
        set(TBTHB5HIK.RIRENO, val);
    }

    /**
     * 履歴管理番号を返します。
     * @return String 履歴管理番号
     */
    public String getRireNo() {
        return (String) get(TBTHB5HIK.RIRENO);
    }

    /**
     * 依頼年月を設定します。
     * @param val String 依頼年月
     */
    public void setIryymm(String val) {
        set(TBTHB5HIK.IRYYMM, val);
    }

    /**
     * 依頼年月を返します。
     * @return String 依頼年月
     */
    public String getIryymm() {
        return (String) get(TBTHB5HIK.IRYYMM);
    }

    /**
     * 依頼区分を設定します。
     * @param val String 依頼区分
     */
    public void setIrKbn(String val) {
        set(TBTHB5HIK.IRKBN, val);
    }

    /**
     * 依頼区分を返します。
     * @return String 依頼区分
     */
    public String getIrKbn() {
        return (String) get(TBTHB5HIK.IRKBN);
    }

    /**
     * 得意先コードを設定します。
     * @param val String 得意先コード
     */
    public void setTokuiCd(String val) {
        set(TBTHB5HIK.TOKUICD, val);
    }

    /**
     * 得意先コードを返します。
     * @return String 得意先コード
     */
    public String getTokuiCd() {
        return (String) get(TBTHB5HIK.TOKUICD);
    }

    /**
     * 営業部コードを設定します。
     * @param val String 営業部コード
     */
    public void setEiCode(String val) {
        set(TBTHB5HIK.EICODE, val);
    }

    /**
     * 営業部コードを返します。
     * @return String 営業部コード
     */
    public String getEiCode() {
        return (String) get(TBTHB5HIK.EICODE);
    }

    /**
     * 営業部名を設定します。
     * @param val String 営業部名
     */
    public void setEiName(String val) {
        set(TBTHB5HIK.EINAME, val);
    }

    /**
     * 営業部名を返します。
     * @return String 営業部名
     */
    public String getEiName() {
        return (String) get(TBTHB5HIK.EINAME);
    }

    /**
     * 店番を設定します。
     * @param val String 店番
     */
    public void setTenCd(String val) {
        set(TBTHB5HIK.TENCD, val);
    }

    /**
     * 店番を返します。
     * @return String 店番
     */
    public String getTenCd() {
        return (String) get(TBTHB5HIK.TENCD);
    }

    /**
     * 店名を設定します。
     * @param val String 店名
     */
    public void setTenName(String val) {
        set(TBTHB5HIK.TENNAME, val);
    }

    /**
     * 店名を返します。
     * @return String 店名
     */
    public String getTenName() {
        return (String) get(TBTHB5HIK.TENNAME);
    }

    /**
     * 予算区分を設定します。
     * @param val String 予算区分
     */
    public void setYosaKbn(String val) {
        set(TBTHB5HIK.YOSAKBN, val);
    }

    /**
     * 予算区分を返します。
     * @return String 予算区分
     */
    public String getYosaKbn() {
        return (String) get(TBTHB5HIK.YOSAKBN);
    }

    /**
     * 依頼内容を設定します。
     * @param val String 依頼内容
     */
    public void setIrnai(String val) {
        set(TBTHB5HIK.IRNAI, val);
    }

    /**
     * 依頼内容を返します。
     * @return String 依頼内容
     */
    public String getIrnai() {
        return (String) get(TBTHB5HIK.IRNAI);
    }

    /**
     * メディアコードを設定します。
     * @param val String メディアコード
     */
    public void setMediaCd(String val) {
        set(TBTHB5HIK.MEDIACD, val);
    }

    /**
     * メディアコードを返します。
     * @return String メディアコード
     */
    public String getMediaCd() {
        return (String) get(TBTHB5HIK.MEDIACD);
    }

    /**
     * メディア名を設定します。
     * @param val String メディア名
     */
    public void setMediaName(String val) {
        set(TBTHB5HIK.MEDIANAME, val);
    }

    /**
     * メディア名を返します。
     * @return String メディア名
     */
    public String getMediaName() {
        return (String) get(TBTHB5HIK.MEDIANAME);
    }

    /**
     * サイズコードを設定します。
     * @param val String サイズコード
     */
    public void setSizeCd(String val) {
        set(TBTHB5HIK.SIZECD, val);
    }

    /**
     * サイズコードを返します。
     * @return String サイズコード
     */
    public String getSizeCd() {
        return (String) get(TBTHB5HIK.SIZECD);
    }
    /**
     * サイズを設定します。
     * @param val String サイズ
     */
    public void setSizeName(String val) {
        set(TBTHB5HIK.SIZENAME, val);
    }

    /**
     * サイズを返します。
     * @return String サイズ
     */
    public String getSizeName() {
        return (String) get(TBTHB5HIK.SIZENAME);
    }

    /**
     * 掲載日1を設定します。
     * @param val String 掲載日1
     */
    public void setKeisai1(String val) {
        set(TBTHB5HIK.KEISAI1, val);
    }

    /**
     * 掲載日1を返します。
     * @return String 掲載日1
     */
    public String getKeisai1() {
        return (String) get(TBTHB5HIK.KEISAI1);
    }

    /**
     * 掲載日2を設定します。
     * @param val String 掲載日2
     */
    public void setKeisai2(String val) {
        set(TBTHB5HIK.KEISAI2, val);
    }

    /**
     * 掲載日2を返します。
     * @return String 掲載日2
     */
    public String getKeisai2() {
        return (String) get(TBTHB5HIK.KEISAI2);
    }

    /**
     * 掲載日3を設定します。
     * @param val String 掲載日3
     */
    public void setKeisai3(String val) {
        set(TBTHB5HIK.KEISAI3, val);
    }

    /**
     * 掲載日3を返します。
     * @return String 掲載日3
     */
    public String getKeisai3() {
        return (String) get(TBTHB5HIK.KEISAI3);
    }

    /**
     * 掲載日4を設定します。
     * @param val String 掲載日4
     */
    public void setKeisai4(String val) {
        set(TBTHB5HIK.KEISAI4, val);
    }

    /**
     * 掲載日4を返します。
     * @return String 掲載日4
     */
    public String getKeisai4() {
        return (String) get(TBTHB5HIK.KEISAI4);
    }

    /**
     * 掲載日5を設定します。
     * @param val String 掲載日5
     */
    public void setKeisai5(String val) {
        set(TBTHB5HIK.KEISAI5, val);
    }

    /**
     * 掲載日5を返します。
     * @return String 掲載日5
     */
    public String getKeisai5() {
        return (String) get(TBTHB5HIK.KEISAI5);
    }

    /**
     * 形態区分コードを設定します。
     * @param val String 形態区分コード
     */
    public void setKeitaiCd(String val) {
        set(TBTHB5HIK.KEITAICD, val);
    }

    /**
     * 形態区分コードを返します。
     * @return String 形態区分コード
     */
    public String getKeitaiCd() {
        return (String) get(TBTHB5HIK.KEITAICD);
    }

    /**
     * 形態区分名を設定します。
     * @param val String 形態区分名
     */
    public void setKeitaiName(String val) {
        set(TBTHB5HIK.KEITAINAME, val);
    }

    /**
     * 形態区分名を返します。
     * @return String 形態区分名
     */
    public String getKeitaiName() {
        return (String) get(TBTHB5HIK.KEITAINAME);
    }

    /**
     * 依頼月1を設定します。
     * @param val String 依頼月1
     */
    public void setIrmonth1(String val) {
        set(TBTHB5HIK.IRMONTH1, val);
    }

    /**
     * 依頼月1を返します。
     * @return String 依頼月1
     */
    public String getIrmonth1() {
        return (String) get(TBTHB5HIK.IRMONTH1);
    }

    /**
     * 放送料1を設定します。
     * @param val BigDecimal 放送料1
     */
    public void setHosoryo1(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO1, val);
    }

    /**
     * 放送料1を返します。
     * @return BigDecimal 放送料1
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo1() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO1);
    }

    /**
     * 依頼月2を設定します。
     * @param val String 依頼月2
     */
    public void setIrmonth2(String val) {
        set(TBTHB5HIK.IRMONTH2, val);
    }

    /**
     * 依頼月2を返します。
     * @return String 依頼月2
     */
    public String getIrmonth2() {
        return (String) get(TBTHB5HIK.IRMONTH2);
    }

    /**
     * 放送料2を設定します。
     * @param val BigDecimal 放送料2
     */
    public void setHosoryo2(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO2, val);
    }

    /**
     * 放送料2を返します。
     * @return BigDecimal 放送料2
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo2() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO2);
    }

    /**
     * 依頼月3を設定します。
     * @param val String 依頼月3
     */
    public void setIrmonth3(String val) {
        set(TBTHB5HIK.IRMONTH3, val);
    }

    /**
     * 依頼月3を返します。
     * @return String 依頼月3
     */
    public String getIrmonth3() {
        return (String) get(TBTHB5HIK.IRMONTH3);
    }

    /**
     * 放送料3を設定します。
     * @param val BigDecimal 放送料3
     */
    public void setHosoryo3(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO3, val);
    }

    /**
     * 放送料3を返します。
     * @return BigDecimal 放送料3
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo3() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO3);
    }

    /**
     * 依頼月4を設定します。
     * @param val String 依頼月4
     */
    public void setIrmonth4(String val) {
        set(TBTHB5HIK.IRMONTH4, val);
    }

    /**
     * 依頼月4を返します。
     * @return String 依頼月4
     */
    public String getIrmonth4() {
        return (String) get(TBTHB5HIK.IRMONTH4);
    }

    /**
     * 放送料4を設定します。
     * @param val BigDecimal 放送料4
     */
    public void setHosoryo4(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO4, val);
    }

    /**
     * 放送料4を返します。
     * @return BigDecimal 放送料4
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo4() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO4);
    }

    /**
     * 依頼月5を設定します。
     * @param val String 依頼月5
     */
    public void setIrmonth5(String val) {
        set(TBTHB5HIK.IRMONTH5, val);
    }

    /**
     * 依頼月5を返します。
     * @return String 依頼月5
     */
    public String getIrmonth5() {
        return (String) get(TBTHB5HIK.IRMONTH5);
    }

    /**
     * 放送料5を設定します。
     * @param val BigDecimal 放送料5
     */
    public void setHosoryo5(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO5, val);
    }

    /**
     * 放送料5を返します。
     * @return BigDecimal 放送料5
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo5() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO5);
    }

    /**
     * 依頼月6を設定します。
     * @param val String 依頼月6
     */
    public void setIrmonth6(String val) {
        set(TBTHB5HIK.IRMONTH6, val);
    }

    /**
     * 依頼月6を返します。
     * @return String 依頼月6
     */
    public String getIrmonth6() {
        return (String) get(TBTHB5HIK.IRMONTH6);
    }

    /**
     * 放送料6を設定します。
     * @param val BigDecimal 放送料6
     */
    public void setHosoryo6(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO6, val);
    }

    /**
     * 放送料6を返します。
     * @return BigDecimal 放送料6
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo6() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO6);
    }

    /**
     * 交通掲載コードを設定します。
     * @param val String 交通掲載コード
     */
    public void setKotukeiCd(String val) {
        set(TBTHB5HIK.KOTUKEICD, val);
    }

    /**
     * 交通掲載コードを返します。
     * @return String 交通掲載コード
     */
    public String getKotukeiCd() {
        return (String) get(TBTHB5HIK.KOTUKEICD);
    }

    /**
     * 交通掲載名を設定します。
     * @param val String 交通掲載名
     */
    public void setKotukeiName(String val) {
        set(TBTHB5HIK.KOTUKEINAME, val);
    }

    /**
     * 交通掲載名を返します。
     * @return String 交通掲載名
     */
    public String getKotukeiName() {
        return (String) get(TBTHB5HIK.KOTUKEINAME);
    }

    /**
     * 掲載日を設定します。
     * @param val String 掲載日
     */
    public void setKeisai(String val) {
        set(TBTHB5HIK.KEISAI, val);
    }

    /**
     * 掲載日を返します。
     * @return String 掲載日
     */
    public String getKeisai() {
        return (String) get(TBTHB5HIK.KEISAI);
    }

    /**
     * 掲載料を設定します。
     * @param val BigDecimal 掲載料
     */
    public void setKeisairyo(BigDecimal val) {
        set(TBTHB5HIK.KEISAIRYO, val);
    }

    /**
     * 掲載料を返します。
     * @return BigDecimal 掲載料
     */
    @XmlElement(required = true)
    public BigDecimal getKeisairyo() {
        return (BigDecimal) get(TBTHB5HIK.KEISAIRYO);
    }

    /**
     * 掲載単価を設定します。
     * @param val String 掲載単価
     */
    public void setKeisaiTanka(String val) {
        set(TBTHB5HIK.KEISAITANKA, val);
    }

    /**
     * 掲載単価を返します。
     * @return String 掲載単価
     */
    @XmlElement(required = true)
    public String getKeisaiTanka() {
        return (String) get(TBTHB5HIK.KEISAITANKA);
    }

    /**
     * 掲載回数を設定します。
     * @param val String 掲載回数
     */
    public void setKeisaiCnt(String val) {
        set(TBTHB5HIK.KEISAICNT, val);
    }

    /**
     * 掲載回数を返します。
     * @return String 掲載回数
     */
    public String getKeisaiCnt() {
        return (String) get(TBTHB5HIK.KEISAICNT);
    }

    /**
     * 商品区分を設定します。
     * @param val String 商品区分
     */
    public void setSyohiKbn(String val) {
        set(TBTHB5HIK.SYOHIKBN, val);
    }

    /**
     * 商品区分を返します。
     * @return String 商品区分
     */
    public String getSyohiKbn() {
        return (String) get(TBTHB5HIK.SYOHIKBN);
    }

    /**
     * 商品名を設定します。
     * @param val String スペース名
     */
    public void setSyohiName(String val) {
        set(TBTHB5HIK.SYOHINAME, val);
    }

    /**
     * 商品名を返します。
     * @return String スペース名
     */
    public String getSyohiName() {
        return (String) get(TBTHB5HIK.SYOHINAME);
    }

    /**
     * 細目区分を設定します。
     * @param val String 細目区分
     */
    public void setSaiKbn(String val) {
        set(TBTHB5HIK.SAIKBN, val);
    }

    /**
     * 細目区分を返します。
     * @return String 細目区分
     */
    public String getSaiKbn() {
        return (String) get(TBTHB5HIK.SAIKBN);
    }

    /**
     * 摘要コードを設定します。
     * @param val String 摘要コード
     */
    public void setTekiCd(String val) {
        set(TBTHB5HIK.TEKICD, val);
    }

    /**
     * 摘要コードを返します。
     * @return String 摘要コード
     */
    public String getTekiCd() {
        return (String) get(TBTHB5HIK.TEKICD);
    }

    /**
     * 売上予定年月を設定します。
     * @param val String 売上予定年月
     */
    public void setUriyymm(String val) {
        set(TBTHB5HIK.URIYYMM, val);
    }

    /**
     * 売上予定年月を返します。
     * @return String 売上予定年月
     */
    public String getUriyymm() {
        return (String) get(TBTHB5HIK.URIYYMM);
    }

    /**
     * 担当者名を設定します。
     * @param val String 担当者名
     */
    public void setTanName(String val) {
        set(TBTHB5HIK.TANNAME, val);
    }

    /**
     * 担当者名を返します。
     * @return String 担当者名
     */
    public String getTanName() {
        return (String) get(TBTHB5HIK.TANNAME);
    }

    /**
     * 担当者勤務部署名を設定します。
     * @param val String 担当者勤務部署名
     */
    public void setTankinName(String val) {
        set(TBTHB5HIK.TANKINNAME, val);
    }

    /**
     * 担当者勤務部署名を返します。
     * @return String 担当者勤務部署名
     */
    public String getTankinName() {
        return (String) get(TBTHB5HIK.TANKINNAME);
    }

    /**
     * 按分種別を設定します。
     * @param val String 按分種別
     */
    public void setAnsyube(String val) {
        set(TBTHB5HIK.ANSYUBE, val);
    }

    /**
     * 按分種別を返します。
     * @return String 按分種別
     */
    public String getAnsyube() {
        return (String) get(TBTHB5HIK.ANSYUBE);
    }

    /**
     * 更新区分を設定します。
     * @param val String 更新区分
     */
    public void setKouKbn(String val) {
        set(TBTHB5HIK.KOUKBN, val);
    }

    /**
     * 更新区分を返します。
     * @return String 更新区分
     */
    public String getKouKbn() {
        return (String) get(TBTHB5HIK.KOUKBN);
    }

    /**
     * 備考1を設定します。
     * @param val String 備考1
     */
    public void setBikou1(String val) {
        set(TBTHB5HIK.BIKOU1, val);
    }

    /**
     * 備考1を返します。
     * @return String 備考1
     */
    public String getBikou1() {
        return (String) get(TBTHB5HIK.BIKOU1);
    }

    /**
     * 備考2を設定します。
     * @param val String 備考2
     */
    public void setBikou2(String val) {
        set(TBTHB5HIK.BIKOU2, val);
    }

    /**
     * 備考2を返します。
     * @return String 備考2
     */
    public String getBikou2() {
        return (String) get(TBTHB5HIK.BIKOU2);
    }

    /**
     * 色刷コードを設定します。
     * @param val String 色刷コード
     */
    public void setColorCd(String val) {
        set(TBTHB5HIK.COLORCD , val);
    }

    /**
     * 色刷コードを返します。
     * @return String 色刷コード
     */
    public String getColorCd() {
        return (String) get(TBTHB5HIK.COLORCD );
    }

    /**
     * スペースコードを設定します。
     * @param val String スペースコード
     */
    public void setSpaceCd(String val) {
        set(TBTHB5HIK.SPACECD , val);
    }

    /**
     * スペースコードを返します。
     * @return String スペースコード
     */
    public String getSpaceCd() {
        return (String) get(TBTHB5HIK.SPACECD );
    }

    /**
     * 種別１コードを設定します。
     * @param val String 種別１コード
     */
    public void setSybt1Cd(String val) {
        set(TBTHB5HIK.SYBT1CD , val);
    }

    /**
     * 種別１コードを返します。
     * @return String 種別１コード
     */
    public String getSybt1Cd() {
        return (String) get(TBTHB5HIK.SYBT1CD);
    }

    /**
     * 種別２コードを設定します。
     * @param val String 種別２コード
     */
    public void setSybt2Cd(String val) {
        set(TBTHB5HIK.SYBT2CD , val);
    }

    /**
     * 種別２コードを返します。
     * @return String 種別２コード
     */
    public String getSybt2Cd() {
        return (String) get(TBTHB5HIK.SYBT2CD);
    }

    /**
     * デザイン変更回数を設定します。
     * @param val String デザイン変更回数
     */
    public void setDesignCnt(String val) {
        set(TBTHB5HIK.DESIGNCNT , val);
    }

    /**
     * デザイン変更回数を返します。
     * @return String デザイン変更回数
     */
    public String getDesignCnt() {
        return (String) get(TBTHB5HIK.DESIGNCNT);
    }

    /**
     * 掲載場所コードを設定します。
     * @param val String 掲載場所コード
     */
    public void setPlaceCd(String val) {
        set(TBTHB5HIK.PLACECD , val);
    }

    /**
     * 掲載場所コードを返します。
     * @return String 掲載場所コード
     */
    public String getPlaceCd() {
        return (String) get(TBTHB5HIK.PLACECD);
    }

    /**
     * 印刷代を設定します。
     * @param val BigDecimal 印刷代
     */
    public void setPrintryo(BigDecimal val) {
        set(TBTHB5HIK.PRINTRYO, val);
    }

    /**
     * 印刷代を返します。
     * @return BigDecimal 印刷代
     */
    @XmlElement(required = true)
    public BigDecimal getPrintryo() {
        return (BigDecimal) get(TBTHB5HIK.PRINTRYO);
    }

    /**
     * 差替作業料を設定します。
     * @param val BigDecimal 差替作業料
     */
    public void setSashikaeryo(BigDecimal val) {
        set(TBTHB5HIK.SASHIKAERYO, val);
    }

    /**
     * 差替作業料を返します。
     * @return BigDecimal 差替作業料
     */
    @XmlElement(required = true)
    public BigDecimal getSashikaeryo() {
        return (BigDecimal) get(TBTHB5HIK.SASHIKAERYO);
    }

    /**
     * デザイン料を設定します。
     * @param val BigDecimal デザイン料
     */
    public void setDesignryo(BigDecimal val) {
        set(TBTHB5HIK.DESIGNRYO, val);
    }

    /**
     * デザイン料を返します。
     * @return BigDecimal デザイン料
     */
    @XmlElement(required = true)
    public BigDecimal getDesignryo() {
        return (BigDecimal) get(TBTHB5HIK.DESIGNRYO);
    }

    /**
     * 版下代を設定します。
     * @param val BigDecimal 版下代
     */
    public void setHanshitaryo(BigDecimal val) {
        set(TBTHB5HIK.HANSHITARYO, val);
    }

    /**
     * 版下代を返します。
     * @return BigDecimal 版下代
     */
    @XmlElement(required = true)
    public BigDecimal getHanshitaryo() {
        return (BigDecimal) get(TBTHB5HIK.HANSHITARYO);
    }

    /**
     * 製版代を設定します。
     * @param val BigDecimal 製版代
     */
    public void setSeihanryo(BigDecimal val) {
        set(TBTHB5HIK.SEIHANRYO, val);
    }

    /**
     * 製版代を返します。
     * @return BigDecimal 製版代
     */
    @XmlElement(required = true)
    public BigDecimal getSeihanryo() {
        return (BigDecimal) get(TBTHB5HIK.SEIHANRYO);
    }

    /**
     * 登録年月日を設定します。
     * @param val String 登録年月日
     */
    public void setTouDate(String val) {
        set(TBTHB5HIK.TOUDATE, val);
    }

    /**
     * 登録年月日を返します。
     * @return String 登録年月日
     */
    public String getTouDate() {
        return (String) get(TBTHB5HIK.TOUDATE);
    }

    /**
     * 変更年月日を設定します。
     * @param val String 変更年月日
     */
    public void setHenDate(String val) {
        set(TBTHB5HIK.HENDATE, val);
    }

    /**
     * 変更年月日を返します。
     * @return String 変更年月日
     */
    public String getHenDate() {
        return (String) get(TBTHB5HIK.HENDATE);
    }

    /**
     * 取消年月日を設定します。
     * @param val String 取消年月日
     */
    public void setTorDate(String val) {
        set(TBTHB5HIK.TORDATE, val);
    }

    /**
     * 取消年月日を返します。
     * @return String 取消年月日
     */
    public String getTorDate() {
        return (String) get(TBTHB5HIK.TORDATE);
    }

//    /**
//     * 最新データフラグを設定します。
//     * @param val String 最新データフラグ
//     */
//    public void setSaisinFlg(String val) {
//        set("SAISINFLG", val);
//    }
//
//    /**
//     * 最新データフラグを返します。
//     * @return String 最新データフラグ
//     */
//    public String getSaisinFlg() {
//        return (String) get("SAISINFLG");
//    }
//
//    /**
//     * 更新区分名を設定します。
//     * @param val String 更新区分名
//     */
//    public void setKouKbnName(String val) {
//        set("KOUKBNNAME", val);
//    }
//
//    /**
//     * 更新区分名を返します。
//     * @return String 更新区分名
//     */
//    public String getKouKbnName() {
//        return (String) get("KOUKBNNAME");
//    }

//    /**
//     * ステータスを設定します。
//     * @param val String ステータス
//     */
//    public void setStatus(String val) {
//        set("STATUS", val);
//    }
//
//    /**
//     * ステータスを返します。
//     * @return String ステータス
//     */
//    public String getStatus() {
//        return (String) get("STATUS");
//    }

    /**
     * スペース名を設定します。
     * @param val String スペース名
     */
    public void setSpaceName(String val) {
        set(TBTHB5HIK.SPACENAME, val);
    }

    /**
     * スペース名を返します。
     * @return String スペース名
     */
    public String getSpaceName() {
        return (String) get(TBTHB5HIK.SPACENAME);
    }

    /**
     * ダミー1を設定します。
     * @param val String ダミー1
     */
    public void setDummy1(String val) {
        set("DUMMY1", val);
    }

    /**
     * ダミー1を返します。
     * @return String ダミー1
     */
    public String gettDummy1() {
        return (String) get("DUMMY1");
    }

    /**
     * ダミー2を設定します。
     * @param val String ダミー2
     */
    public void setDummy2(String val) {
        set("DUMMY2", val);
    }

    /**
     * ダミー2を返します。
     * @return String ダミー2
     */
    public String gettDummy2() {
        return (String) get("DUMMY2");
    }

}
