package jp.co.isid.kkh.customer.acom.model.claim;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 発注/請求 差異一覧情報VO (返却用)
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimDiffCondResultVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 新規インスタンスを構築します。
     */
    public FindClaimDiffCondResultVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindClaimDiffCondResultVO();
    }

    /**
     * 種別を取得する
     * @return 種別
     */
    public String getSybt() {
        return (String) get("SYBT");
    }

    /**
     * 種別を設定する
     * @param val 種別
     */
    public void setSybt(String val) {
        set("SYBT", val);
    }

    /**
     * 依頼番号（発注番号）を取得する
     * @return 依頼番号（発注番号）
     */
    public String getIraiNo() {
        return (String) get("IRAINO");
    }

    /**
     * 依頼番号（発注番号）を設定する
     * @param val 依頼番号（発注番号）
     */
    public void setIraiNo(String val) {
        set("IRAINO", val);
    }

    /**
     * 依頼行番号（発注行番号）を取得する
     * @return 依頼行番号（発注行番号）
     */
    public String getIraiGyoNo() {
        return (String) get("IRAIGYONO");
    }

    /**
     * 依頼行番号（発注行番号）を設定する
     * @param val 依頼行番号（発注行番号）
     */
    public void setIraiGyoNo(String val) {
        set("IRAIGYONO", val);
    }

    /**
     * 取引先コードを取得する
     * @return 取引先コード
     */
    public String getToriCd() {
        return (String) get("TORICD");
    }

    /**
     * 取引先コードを設定する
     * @param val 取引先コード
     */
    public void setToriCd(String val) {
        set("TORICD", val);
    }

    /**
     * 会社名を取得する
     * @return 会社名
     */
    public String getKaiNm() {
        return (String) get("KAINM");
    }

    /**
     * 会社名を設定する
     * @param val 会社名
     */
    public void setKaiNm(String val) {
        set("KAINM", val);
    }

    /**
     * 請求部署コードを取得する
     * @return 請求部署コード
     */
    public String getSeibuCd() {
        return (String) get("SEIBUCD");
    }

    /**
     * 請求部署コードを設定する
     * @param val 請求部署コード
     */
    public void setSeibuCd(String val) {
        set("SEIBUCD", val);
    }

    /**
     * 請求年月日を取得する
     * @return 請求年月日
     */
    public String getSeiYymm() {
        return (String) get("SEIYYMM");
    }

    /**
     * 請求年月日を設定する
     * @param val 請求年月日
     */
    public void setSeiYymm(String val) {
        set("SEIYYMM", val);
    }

    /**
     * 請求書番号を取得する
     * @return 請求書番号
     */
    public String getSeiNo() {
        return (String) get("SEINO");
    }

    /**
     * 請求書番号を設定する
     * @param val 請求書番号
     */
    public void setSeiNo(String val) {
        set("SEINO", val);
    }

    /**
     * 内容区分を取得する
     * @return 内容区分
     */
    public String getNaiyoKbn() {
        return (String) get("NAIYOKBN");
    }

    /**
     * 内容区分を設定する
     * @param val 内容区分
     */
    public void setNaiyoKbn(String val) {
        set("NAIYOKBN", val);
    }

    /**
     * 請求書行番号を取得する
     * @return 請求書行番号
     */
    public String getSeiGyoNo() {
        return (String) get("SEIGYONO");
    }

    /**
     * 請求書行番号を設定する
     * @param val 請求書行番号
     */
    public void setSeiGyoNo(String val) {
        set("SEIGYONO", val);
    }

    /**
     * 支払日を取得する
     * @return 支払日
     */
    public String getPayDay() {
        return (String) get("PAYDAY");
    }

    /**
     * 支払日を設定する
     * @param val 支払日
     */
    public void setPayDay(String val) {
        set("PAYDAY", val);
    }

    /**
     * 商品区分を取得する
     * @return 商品区分
     */
    public String getSyohinKbn() {
        return (String) get("SHOHINKBN");
    }

    /**
     * 商品区分を設定する
     * @param val 商品区分
     */
    public void setSyohinKbn(String val) {
        set("SHOHINKBN", val);
    }

    /**
     * 摘要コードを取得する
     * @return 摘要コード
     */
    public String getTekiyoCd() {
        return (String) get("TEKIYOCD");
    }

    /**
     * 摘要コードを設定する
     * @param val 摘要コード
     */
    public void setTekiyoCd(String val) {
        set("TEKIYOCD", val);
    }

    /**
     * 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )を取得する
     * @return 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )
     */
    public String getBaitaiCd() {
        return (String) get("BAITAICD");
    }

    /**
     * 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )を設定する
     * @param val 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )
     */
    public void setBaitaiCd(String val) {
        set("BAITAICD", val);
    }

    /**
     * メディアコードを取得する
     * @return メディアコード
     */
    public String getMediaCd() {
        return (String) get("MEDIACD");
    }

    /**
     * メディアコードを設定する
     * @param val メディアコード
     */
    public void setMediaCd(String val) {
        set("MEDIACD", val);
    }

    /**
     * メディア名を取得する
     * @return メディア名
     */
    public String getMediaNm() {
        return (String) get("MEDIANM");
    }

    /**
     * メディア名を設定する
     * @param val メディア名
     */
    public void setMediaNm(String val) {
        set("MEDIANM", val);
    }

    /**
     * 店番を取得する
     * @return 店番
     */
    public String getTenBan() {
        return (String) get("TENBAN");
    }

    /**
     * 店番を設定する
     * @param val 店番
     */
    public void setTenBan(String val) {
        set("TENBAN", val);
    }

    /**
     * 形態区分コードを取得する
     * @return 形態区分コード
     */
    public String getKeitaiKbnCd() {
        return (String) get("KEITAIKBNCD");
    }

    /**
     * 形態区分コードを設定する
     * @param val 形態区分コード
     */
    public void setKeitaiKbnCd(String val) {
        set("KEITAIKBNCD", val);
    }

    /**
     * 形態区分名称を取得する
     * @return 形態区分名称
     */
    public String getKeitaiKbnNm() {
        return (String) get("KEITAIKBNNM");
    }

    /**
     * 形態区分名称を設定する
     * @param val 形態区分名称
     */
    public void setKeitaiKbnNm(String val) {
        set("KEITAIKBNNM", val);
    }

    /**
     * CM秒数名1を取得する
     * @return CM秒数名1
     */
    public String getCm1() {
        return (String) get("CM1");
    }

    /**
     * CM秒数名1を設定する
     * @param val CM秒数名1
     */
    public void setCm1(String val) {
        set("CM1", val);
    }

    /**
     * CM秒数名2を取得する
     * @return CM秒数名2
     */
    public String getCm2() {
        return (String) get("CM2");
    }

    /**
     * CM秒数名2を設定する
     * @param val CM秒数名2
     */
    public void setCm2(String val) {
        set("CM2", val);
    }

    /**
     * CM秒数名3を取得する
     * @return CM秒数名3
     */
    public String getCm3() {
        return (String) get("CM3");
    }

    /**
     * CM秒数名3を設定する
     * @param val CM秒数名3
     */
    public void setCm3(String val) {
        set("CM3", val);
    }

    /**
     * CM秒数名4を取得する
     * @return CM秒数名4
     */
    public String getCm4() {
        return (String) get("CM4");
    }

    /**
     * CM秒数名4を設定する
     * @param val CM秒数名4
     */
    public void setCm4(String val) {
        set("CM4", val);
    }

    /**
     * 内容名称1を取得する
     * @return 内容名称1
     */
    public String getName1() {
        return (String) get("NAME1");
    }

    /**
     * 内容名称1を設定する
     * @param val 内容名称1
     */
    public void setName1(String val) {
        set("NAME1", val);
    }

    /**
     * 内容名称2を取得する
     * @return 内容名称2
     */
    public String getName2() {
        return (String) get("NAME2");
    }

    /**
     * 内容名称2を設定する
     * @param val 内容名称2
     */
    public void setName2(String val) {
        set("NAME2", val);
    }

    /**
     * 内容名称3を取得する
     * @return 内容名称3
     */
    public String getName3() {
        return (String) get("NAME3");
    }

    /**
     * 内容名称3を設定する
     * @param val 内容名称3
     */
    public void setName3(String val) {
        set("NAME3", val);
    }

    /**
     * 内容名称4を取得する
     * @return 内容名称4
     */
    public String getName4() {
        return (String) get("NAME4");
    }

    /**
     * 内容名称4を設定する
     * @param val 内容名称4
     */
    public void setName4(String val) {
        set("NAME4", val);
    }

    /**
     * 番組名1を取得する
     * @return 番組名1
     */
    public String getBngm1() {
        return (String) get("BNGM1");
    }

    /**
     * 番組名1を設定する
     * @param val 番組名1
     */
    public void setBngm1(String val) {
        set("BNGM1", val);
    }

    /**
     * 番組名2を取得する
     * @return 番組名2
     */
    public String getBngm2() {
        return (String) get("BNGM2");
    }

    /**
     * 番組名2を設定する
     * @param val 番組名2
     */
    public void setBngm2(String val) {
        set("BNGM2", val);
    }

    /**
     * 番組名3を取得する
     * @return 番組名3
     */
    public String getBngm3() {
        return (String) get("BNGM3");
    }

    /**
     * 番組名3を設定する
     * @param val 番組名3
     */
    public void setBngm3(String val) {
        set("BNGM3", val);
    }

    /**
     * 番組名4を取得する
     * @return 番組名4
     */
    public String getBngm4() {
        return (String) get("BNGM4");
    }

    /**
     * 番組名4を設定する
     * @param val 番組名4
     */
    public void setBngm4(String val) {
        set("BNGM4", val);
    }

    /**
     * 掲載場所コードを取得する
     * @return 掲載場所コード
     */
    public String getKeisaiBasCd() {
        return (String) get("KEISAIBASCD");
    }

    /**
     * 掲載場所コードを設定する
     * @param val 掲載場所コード
     */
    public void setKeisaiBasCd(String val) {
        set("KEISAIBASCD", val);
    }

    /**
     * 掲載場所名称を取得する
     * @return 掲載場所名称
     */
    public String getKeisaiBasNm() {
        return (String) get("KEISAIBASNM");
    }

    /**
     * 掲載場所名称を設定する
     * @param val 掲載場所名称
     */
    public void setKeisaiBasNm(String val) {
        set("KEISAIBASNM", val);
    }

    /**
     * 種別1コードを取得する
     * @return 種別1コード
     */
    public String getSybt1Cd() {
        return (String) get("SYBT1CD");
    }

    /**
     * 種別1コードを設定する
     * @param val 種別1コード
     */
    public void setSybt1Cd(String val) {
        set("SYBT1CD", val);
    }

    /**
     * 種別1名称を取得する
     * @return 種別1名称
     */
    public String getSybt1Nm() {
        return (String) get("SYBT1NM");
    }

    /**
     * 種別1名称を設定する
     * @param val 種別1名称
     */
    public void setSybt1Nm(String val) {
        set("SYBT1NM", val);
    }

    /**
     * 種別2コードを取得する
     * @return 種別2コード
     */
    public String getSybt2Cd() {
        return (String) get("SYBT2CD");
    }

    /**
     * 種別2コードを設定する
     * @param val 種別2コード
     */
    public void setSybt2Cd(String val) {
        set("SYBT2CD", val);
    }

    /**
     * 種別2名称を取得する
     * @return 種別2名称
     */
    public String getSybt2Nm() {
        return (String) get("SYBT2NM");
    }

    /**
     * 種別2名称を設定する
     * @param val 種別2名称
     */
    public void setSybt2Nm(String val) {
        set("SYBT2NM", val);
    }

    /**
     * 色刷コードを取得する
     * @return 色刷コード
     */
    public String getSisaCd() {
        return (String) get("SISACD");
    }

    /**
     * 色刷コードを設定する
     * @param val 色刷コード
     */
    public void setSisaCd(String val) {
        set("SISACD", val);
    }

    /**
     * 色刷名称を取得する
     * @return 色刷名称
     */
    public String getSisaNm() {
        return (String) get("SISANM");
    }

    /**
     * 色刷名称を設定する
     * @param val 色刷名称
     */
    public void setSisaNm(String val) {
        set("SISANM", val);
    }

    /**
     * サイズコードを取得する
     * @return サイズコード
     */
    public String getSizeCd() {
        return (String) get("SIZECD");
    }

    /**
     * サイズコードを設定する
     * @param val サイズコード
     */
    public void setSizeCd(String val) {
        set("SIZECD", val);
    }

    /**
     * サイズ名称を取得する
     * @return サイズ名称
     */
    public String getSizeNm() {
        return (String) get("SIZENM");
    }

    /**
     * サイズ名称を設定する
     * @param val サイズ名称
     */
    public void setSizeNm(String val) {
        set("SIZENM", val);
    }

    /**
     * スペースコードを取得する
     * @return サイズコード
     */
    public String getSpCd() {
        return (String) get("SPACECD");
    }

    /**
     * スペースコードを設定する
     * @param val サイズコード
     */
    public void setSpCd(String val) {
        set("SPACECD", val);
    }

    /**
     * スペース名称を取得する
     * @return スペース名称
     */
    public String getSpNm() {
        return (String) get("SPACENM");
    }

    /**
     * スペース名称を設定する
     * @param val スペース名称
     */
    public void setSpNm(String val) {
        set("SPACENM", val);
    }

    /**
     * 交通掲載コードを取得する
     * @return 交通掲載コード
     */
    public String getKotukeiCd() {
        return (String) get("KOTUKEICD");
    }

    /**
     * 交通掲載コードを設定する
     * @param val 交通掲載コード
     */
    public void setKotukeiCd(String val) {
        set("KOTUKEICD", val);
    }

    /**
     * 交通掲載名称を取得する
     * @return 交通掲載名称
     */
    public String getKotukeiNm() {
        return (String) get("KOTUKEINM");
    }

    /**
     * 交通掲載名称を設定する
     * @param val 交通掲載名称
     */
    public void setKotukeiNm(String val) {
        set("KOTUKEINM", val);
    }

    /**
     * 期間を取得する
     * @return 期間
     */
    public String getKikan() {
        return (String) get("KIKAN");
    }

    /**
     * 期間を設定する
     * @param val 期間
     */
    public void setKikan(String val) {
        set("KIKAN", val);
    }

    /**
     * 掲載回数を取得する
     * @return 掲載回数
     */
    public String getKeisaiSu() {
        return (String) get("KEISAISU");
    }

    /**
     * 掲載回数を設定する
     * @param val 掲載回数
     */
    public void setKeisaiSu(String val) {
        set("KEISAISU", val);
    }

    /**
     * 備考1を取得する
     * @return 備考1
     */
    public String getBiko1() {
        return (String) get("BIKO1");
    }

    /**
     * 備考1を設定する
     * @param val 備考1
     */
    public void setBiko1(String val) {
        set("BIKO1", val);
    }

    /**
     * 備考2を取得する
     * @return 備考2
     */
    public String getBiko2() {
        return (String) get("BIKO2");
    }

    /**
     * 備考2を設定する
     * @param val 備考2
     */
    public void setBiko2(String val) {
        set("BIKO2", val);
    }

    /**
     * 掲載単価を取得する
     * @return 掲載単価
     */
    public String getKeisaiTnk() {
        return (String) get("KEISAITNK");
    }

    /**
     * 掲載単価を設定する
     * @param val 掲載単価
     */
    public void setKeisaiTnk(String val) {
        set("KEISAITNK", val);
    }

    /**
     * 行単位金額を取得する
     * @return 行単位金額
     */
    public BigDecimal getKingak() {
        return (BigDecimal) get("KINGAK");
    }

    /**
     * 行単位金額を設定する
     * @param val 行単位金額
     */
    public void setKingak(BigDecimal val) {
        set("KINGAK", val);
    }

    /**
     * 行単位消費税を取得する
     * @return 行単位消費税
     */
    public BigDecimal getSyohizei() {
        return (BigDecimal) get("SYOHIZEI");
    }

    /**
     * 行単位消費税を設定する
     * @param val 行単位消費税
     */
    public void setSyohizei(BigDecimal val) {
        set("SYOHIZEI", val);
    }

    /**
     * 行単位金額合計を取得する
     * @return 行単位金額合計
     */
    public BigDecimal getKingakSum() {
        return (BigDecimal) get("KINGAKSUM");
    }

    /**
     * 行単位金額合計を設定する
     * @param val 行単位金額合計
     */
    public void setKingakSum(BigDecimal val) {
        set("KINGAKSUM", val);
    }

    /**
     * 按分種別を取得する
     * @return 按分種別
     */
    public String getAnbunSybt() {
        return (String) get("ANBUNSYBT");
    }

    /**
     * 按分種別を設定する
     * @param val 按分種別
     */
    public void setAnbunSybt(String val) {
        set("ANBUNSYBT", val);
    }

    /**
     * 区分を取得する
     * @return 区分
     */
    public String getKbn() {
        return (String) get("KBN");
    }

    /**
     * 区分を設定する
     * @param val 区分
     */
    public void setKbn(String val) {
        set("KBN", val);
    }

    /**
     * 件名を取得する
     * @return 件名
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * 件名を設定する
     * @param val 件名
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * ソート番号を取得する
     * @return ソート番号
     */
    public String getSortNo() {
        return (String) get("SORTNO");
    }

    /**
     * ソート番号を設定する
     * @param val ソート番号
     */
    public void setSortNo(String val) {
        set("SORTNO", val);
    }
}