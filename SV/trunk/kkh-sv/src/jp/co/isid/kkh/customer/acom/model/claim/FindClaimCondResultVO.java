package jp.co.isid.kkh.customer.acom.model.claim;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 請求データ 一覧情報VO (返却用)
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimCondResultVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindClaimCondResultVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindClaimCondResultVO();
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
     * 値引行区分を取得する
     * @return 値引行区分
     */
    public String getNebiKbn() {
        return (String) get("NEBIKBN");
    }

    /**
     * 値引行区分を設定する
     * @param val 値引行区分
     */
    public void setNebiKbn(String val) {
        set("NEBIKBN", val);
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
     * 商品区分名称を取得する
     * @return 商品区分名称
     */
    public String getSyohinKbnNm() {
        return (String) get("SHOHINKBNNM");
    }

    /**
     * 商品区分名称を設定する
     * @param val 商品区分名称
     */
    public void setSyohinKbnNm(String val) {
        set("SHOHINKBNNM", val);
    }

    /**
     * 細目区分を取得する
     * @return 細目区分
     */
    public String getSaimokuKbn() {
        return (String) get("SAIMOKUKBN");
    }

    /**
     * 細目区分を設定する
     * @param val 細目区分
     */
    public void setSaimokuKbn(String val) {
        set("SAIMOKUKBN", val);
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
     * 処理区分を取得する
     * @return 処理区分
     */
    public String getShoriKbn() {
        return (String) get("SHORIKBN");
    }

    /**
     * 処理区分を設定する
     * @param val 処理区分
     */
    public void setShoriKbn(String val) {
        set("SHORIKBN", val);
    }

    /**
     * 処理区分名を取得する
     * @return 処理区分名
     */
    public String getShoriKbnNm() {
        return (String) get("SHORIKBNNM");
    }

    /**
     * 処理区分名を設定する
     * @param val 処理区分名
     */
    public void setShoriKbnNm(String val) {
        set("SHORIKBNNM", val);
    }

    /**
     * 登録年月日を取得する
     * @return 登録年月日
     */
    public String getTouDate() {
        return (String) get("TOUDATE");
    }

    /**
     * 登録年月日を設定する
     * @param val 登録年月日
     */
    public void setTouDate(String val) {
        set("TOUDATE", val);
    }

    /**
     * 変更年月日を取得する
     * @return 変更年月日
     */
    public String getHenDate() {
        return (String) get("HENDATE");
    }

    /**
     * 変更年月日を設定する
     * @param val 変更年月日
     */
    public void setHenDate(String val) {
        set("HENDATE", val);
    }

    /**
     * 取消年月日を取得する
     * @return 取消年月日
     */
    public String getTorDate() {
        return (String) get("TORDATE");
    }

    /**
     * 取消年月日を設定する
     * @param val 取消年月日
     */
    public void setTorDate(String val) {
        set("TORDATE", val);
    }

    /**
     * 出力日時を取得する
     * @return 出力日時
     */
    public String getOutDate() {
        return (String) get("OUTDATE");
    }

    /**
     * 出力日時を設定する
     * @param val 出力日時
     */
    public void setOutDate(String val) {
        set("OUTDATE", val);
    }

    /**
     * 受注Noを取得する
     * @return 受注No
     */
    public String getJyutNo() {
        return (String) get("JYUTNO");
    }

    /**
     * 受注Noを設定する
     * @param val 受注No
     */
    public void setJyutNo(String val) {
        set("JYUTNO", val);
    }

    /**
     * 受注明細Noを取得する
     * @return 受注明細No
     */
    public String getJymeiNo() {
        return (String) get("JYMEINO");
    }

    /**
     * 受注明細Noを設定する
     * @param val 受注明細No
     */
    public void setJymeiNo(String val) {
        set("JYMEINO", val);
    }

    /**
     * 売上明細Noを取得する
     * @return 売上明細No
     */
    public String getUrmeiNo() {
        return (String) get("URMEINO");
    }

    /**
     * 売上明細Noを設定する
     * @param val 売上明細No
     */
    public void setUrmeiNo(String val) {
        set("URMEINO", val);
    }

    /**
     * 連番を取得する
     * @return 連番
     */
    public String getRenBan() {
        return (String) get("RENBAN");
    }

    /**
     * 連番を設定する
     * @param val 連番
     */
    public void setRenBan(String val) {
        set("RENBAN", val);
    }

    /**
     * 掲載日（発売日）を取得する
     * @return 掲載日（発売日）
     */
    public String getKeisaiDay() {
        return (String) get("KEISAIDAY");
    }

    /**
     * 掲載日（発売日）を設定する
     * @param val 掲載日（発売日）
     */
    public void setKeisaiDay(String val) {
        set("KEISAIDAY", val);
    }

    /**
     * 金額内訳（新聞／雑誌）を取得する
     * @return 金額内訳（新聞／雑誌）
     */
    public String getKingakUw() {
        return (String) get("KINGAKUW");
    }

    /**
     * 金額内訳（新聞／雑誌）を設定する
     * @param val 金額内訳（新聞／雑誌）
     */
    public void setKingakUw(String val) {
        set("KINGAKUW", val);
    }

    /**
     * 消費税内訳（新聞／雑誌）を取得する
     * @return 消費税内訳（新聞／雑誌）
     */
    public String getSyohizeiUw() {
        return (String) get("SYOHIZEIUW");
    }

    /**
     * 消費税内訳（新聞／雑誌）を設定する
     * @param val 消費税内訳（新聞／雑誌）
     */
    public void setSyohizeiUw(String val) {
        set("SYOHIZEIUW", val);
    }

    /**
     * 値引額内訳（新聞／雑誌）を取得する
     * @return 値引額内訳（新聞／雑誌）
     */
    public String getNebiGakUw() {
        return (String) get("NEBIGAKUW");
    }

    /**
     * 値引額内訳（新聞／雑誌）を設定する
     * @param val 値引額内訳（新聞／雑誌）
     */
    public void setNebiGakUw(String val) {
        set("NEBIGAKUW", val);
    }

    /**
     * 行単位消費税率を取得する
     * @return 行単位消費税率
     */
    public BigDecimal getSyohizeiRitu() {
        return (BigDecimal) get("SYOHIZEIRITU");
    }

    /**
     * 行単位消費税率を設定する
     * @param val 行単位消費税率
     */
    public void setSyohizeiRitu(BigDecimal val) {
        set("SYOHIZEIRITU", val);
    }

    /**
     * 業務区分を取得する
     * @return 業務区分
     */
    public String getGyomuKbn() {
        return (String) get("GYOMUKBN");
    }

    /**
     * 業務区分を設定する
     * @param val 業務区分
     */
    public void setGyomuKbn(String val) {
        set("GYOMUKBN", val);
    }

    /**
     * 値引率を取得する
     * @return 値引率
     */
    public BigDecimal getNebiRitu() {
        return (BigDecimal) get("NEBIRITU");
    }

    /**
     * 値引率を設定する
     * @param val 値引率
     */
    public void setNebiRitu(BigDecimal val) {
        set("NEBIRITU", val);
    }

    /**
     * 値引額を取得する
     * @return 値引額
     */
    public BigDecimal getNebiGak() {
        return (BigDecimal) get("NEBIGAK");
    }

    /**
     * 値引額を設定する
     * @param val 値引額
     */
    public void setNebiGak(BigDecimal val) {
        set("NEBIGAK", val);
    }
}
