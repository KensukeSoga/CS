package jp.co.isid.kkh.customer.acom.model.claim;


import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 請求データ 一覧情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimCondVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindClaimCondVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindClaimCondVO();
    }

    /**
     * タイムスタンプを取得する
     * @return タイムスタンプ
     */
    public String getTimStmp() {
        return (String) get(TBTHB2KMEI.TIMSTMP);
    }

    /**
     * タイムスタンプを設定する
     * @param val タイムスタンプ
     */
    public void setTimStmp(String val) {
        set(TBTHB2KMEI.TIMSTMP, val);
    }

    /**
     * 依頼番号（発注番号）を取得する
     * @return 依頼番号（発注番号）
     */
    public String getIraiNo() {
        return (String) get(TBTHB2KMEI.CODE3);
    }

    /**
     * 依頼番号（発注番号）を設定する
     * @param val 依頼番号（発注番号）
     */
    public void setIraiNo(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * 依頼行番号（発注行番号）を取得する
     * @return 依頼行番号（発注行番号）
     */
    public String getIraiGyoNo() {
        return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
     * 依頼行番号（発注行番号）を設定する
     * @param val 依頼行番号（発注行番号）
     */
    public void setIraiGyoNo(String val) {
        set(TBTHB2KMEI.CODE4, val);
    }

    /**
     * 取引先コードを取得する
     * @return 取引先コード
     */
    public String getToriCd() {
        return (String) get(TBTHB2KMEI.SONOTA5);
    }

    /**
     * 取引先コードを設定する
     * @param val 取引先コード
     */
    public void setToriCd(String val) {
        set(TBTHB2KMEI.SONOTA5, val);
    }

    /**
     * 会社名を取得する
     * @return 会社名
     */
    public String getKaiNm() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * 会社名を設定する
     * @param val 会社名
     */
    public void setKaiNm(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * 請求部署コードを取得する
     * @return 請求部署コード
     */
    public String getSeibuCd() {
        return (String) get(TBTHB2KMEI.CODE5);
    }

    /**
     * 請求部署コードを設定する
     * @param val 請求部署コード
     */
    public void setSeibuCd(String val) {
        set(TBTHB2KMEI.CODE5, val);
    }

    /**
     * 請求年月日を取得する
     * @return 請求年月日
     */
    public String getSeiYymm() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * 請求年月日を設定する
     * @param val 請求年月日
     */
    public void setSeiYymm(String val) {
        set(TBTHB2KMEI.DATE1, val);
    }

    /**
     * 請求書番号を取得する
     * @return 請求書番号
     */
    public String getSeiNo() {
        return (String) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * 請求書番号を設定する
     * @param val 請求書番号
     */
    public void setSeiNo(String val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * 請求書行番号を取得する
     * @return 請求書行番号
     */
    public String getSeiGyoNo() {
        return (String) get(TBTHB2KMEI.SONOTA2);
    }

    /**
     * 請求書行番号を設定する
     * @param val 請求書行番号
     */
    public void setSeiGyoNo(String val) {
        set(TBTHB2KMEI.SONOTA2, val);
    }

    /**
     * 支払日を取得する
     * @return 支払日
     */
    public String getPayDay() {
        return (String) get(TBTHB2KMEI.DATE2);
    }

    /**
     * 支払日を設定する
     * @param val 支払日
     */
    public void setPayDay(String val) {
        set(TBTHB2KMEI.DATE2, val);
    }

    /**
     * 商品区分を取得する
     * @return 商品区分
     */
    public String getSyohinKbn() {
        return (String) get(TBTHB2KMEI.SONOTA3);
    }

    /**
     * 商品区分を設定する
     * @param val 商品区分
     */
    public void setSyohinKbn(String val) {
        set(TBTHB2KMEI.SONOTA3, val);
    }

    /**
     * 商品区分名称を取得する
     * @return 商品区分名称
     */
    public String getSyohinKbnNm() {
        return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
     * 商品区分名称を設定する
     * @param val 商品区分名称
     */
    public void setSyohinKbnNm(String val) {
        set(TBTHB2KMEI.NAME1, val);
    }

    /**
     * 摘要コードを取得する
     * @return 摘要コード
     */
    public String getTekiyoCd() {
        return (String) get(TBTHB2KMEI.CODE6);
    }

    /**
     * 摘要コードを設定する
     * @param val 摘要コード
     */
    public void setTekiyoCd(String val) {
        set(TBTHB2KMEI.CODE6, val);
    }

    /**
     * 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )を取得する
     * @return 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )
     */
    public String getBaitaiCd() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )を設定する
     * @param val 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )
     */
    public void setBaitaiCd(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * メディアコードを取得する
     * @return メディアコード
     */
    public String getMediaCd() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * メディアコードを設定する
     * @param val メディアコード
     */
    public void setMediaCd(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * 店番を取得する
     * @return 店番
     */
    public String getTenBan() {
        return (String) get(TBTHB2KMEI.SONOTA4);
    }

    /**
     * 店番を設定する
     * @param val 店番
     */
    public void setTenBan(String val) {
        set(TBTHB2KMEI.SONOTA4, val);
    }

    /**
     * 金額を取得する
     * @return 金額
     */
    public BigDecimal getKingaku() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * 金額を設定する
     * @param val 金額
     */
    public void setKingaku(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * 消費税を取得する
     * @return 消費税
     */
    public BigDecimal getShohiZei() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * 消費税を設定する
     * @param val 消費税
     */
    public void setShohiZei(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * 按分種別を取得する
     * @return 按分種別
     */
    public String getAnbunSybt() {
        return (String) get(TBTHB2KMEI.MEIHNFLG);
    }

    /**
     * 按分種別を設定する
     * @param val 按分種別
     */
    public void setAnbunSybt(String val) {
        set(TBTHB2KMEI.MEIHNFLG, val);
    }

    /**
     * 区分を取得する
     * @return 区分
     */
    public String getKbn() {
        return (String) get(TBTHB2KMEI.SONOTA6);
    }

    /**
     * 区分を設定する
     * @param val 区分
     */
    public void setKbn(String val) {
        set(TBTHB2KMEI.SONOTA6, val);
    }

    /**
     * 掲載日（新聞・雑誌）を取得する
     * @return 掲載日（新聞・雑誌）
     */
    public String getKeisaiDay() {
        return (String) get(TBTHB2KMEI.SONOTA9);
    }

    /**
     * 掲載日（新聞・雑誌）を設定する
     * @param val 掲載日（新聞・雑誌）
     */
    public void setKeisaiDay(String val) {
        set(TBTHB2KMEI.SONOTA9, val);
    }

    /**
     * 放送期間（スポット）を取得する
     * @return 放送期間（スポット）
     */
    public String getKikanSpot() {
        return (String) get(TBTHB1DOWN.FIELD4);
    }

    /**
     * 放送期間（スポット）を設定する
     * @param val 放送期間（スポット）
     */
    public void setKikanSpot(String val) {
        set(TBTHB1DOWN.FIELD4, val);
    }

    /**
     * 放送期間（タイム）を取得する
     * @return 放送期間（タイム）
     */
    public String getKikanTime() {
        return (String) get(TBTHB1DOWN.FIELD8);
    }

    /**
     * 放送期間（タイム）を設定する
     * @param val 放送期間（タイム）
     */
    public void setKikanTime(String val) {
        set(TBTHB1DOWN.FIELD8, val);
    }

    /**
     * スペース（雑誌）を取得する
     * @return スペース（雑誌）
     */
    public String getSpaceZasi() {
        return (String) get(TBTHB1DOWN.FIELD9);
    }

    /**
     * スペース（雑誌）を設定する
     * @param val スペース（雑誌）
     */
    public void setSpaceZasi(String val) {
        set(TBTHB1DOWN.FIELD9, val);
    }

    /**
     * スペース（新聞）を取得する
     * @return スペース（新聞）
     */
    public String getSpaceSnbn() {
        return (String) get(TBTHB1DOWN.FIELD11);
    }

    /**
     * スペース（新聞）を設定する
     * @param val スペース（新聞）
     */
    public void setSpaceSnbn(String val) {
        set(TBTHB1DOWN.FIELD11, val);
    }

    /**
     * 件名を取得する
     * @return 件名
     */
    public String getKenmei() {
        return (String) get(TBTHB1DOWN.KKNAMEKJ);
    }

    /**
     * 件名を設定する
     * @param val 件名
     */
    public void setKenmei(String val) {
        set(TBTHB1DOWN.KKNAMEKJ, val);
    }

    /**
     * 値引率を取得する
     * @return 値引率
     */
    public BigDecimal getNebiRitu() {
        return (BigDecimal) get(TBTHB2KMEI.HNNERT);
    }

    /**
     * 値引率を設定する
     * @param val 値引率
     */
    public void setNebiRitu(BigDecimal val) {
        set(TBTHB2KMEI.HNNERT, val);
    }

    /**
     * 値引額を取得する
     * @return 値引額
     */
    public BigDecimal getNebiGaku() {
        return (BigDecimal) get(TBTHB2KMEI.NEBIGAK);
    }

    /**
     * 値引額を設定する
     * @param val 値引額
     */
    public void setNebiGaku(BigDecimal val) {
        set(TBTHB2KMEI.NEBIGAK, val);
    }

    /**
     * 消費税率を取得する
     * @return 消費税率
     */
    public BigDecimal getSyohiRitu() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }

    /**
     * 消費税率を設定する
     * @param val 消費税率
     */
    public void setSyohiRitu(BigDecimal val) {
        set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * 受注NO.を取得する
     * @return 受注NO.
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * 受注NO.を設定する
     * @param val 受注NO.
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * タイム・スポット区分を取得する
     * @return タイム・スポット区分
     */
    public String getTmSpKbn() {
        return (String) get(TBTHB1DOWN.TMSPKBN);
    }

    /**
     * タイム・スポット区分を設定する
     * @param val タイム・スポット区分
     */
    public void setTmSpKbn(String val) {
        set(TBTHB1DOWN.TMSPKBN, val);
    }

    /**
     * 国際区分を取得する
     * @return 国際区分
     */
    public String getKokKbn() {
        return (String) get(TBTHB1DOWN.KOKKBN);
    }

    /**
     * 国際区分を設定する
     * @param val 国際区分
     */
    public void setKokKbn(String val) {
        set(TBTHB1DOWN.KOKKBN, val);
    }

    /**
     * 登録年月日を取得する
     * @return 登録年月日
     */
    public String getTouDate() {
        return (String) get(TBTHB2KMEI.DATE3);
    }

    /**
     * 登録年月日を設定する
     * @param val 登録年月日
     */
    public void setTouDate(String val) {
        set(TBTHB2KMEI.DATE3, val);
    }

    /**
     * 変更年月日を取得する
     * @return 変更年月日
     */
    public String getHenDate() {
        return (String) get(TBTHB2KMEI.DATE4);
    }

    /**
     * 変更年月日を設定する
     * @param val 変更年月日
     */
    public void setHenDate(String val) {
        set(TBTHB2KMEI.DATE4, val);
    }

    /**
     * 取消年月日を取得する
     * @return 取消年月日
     */
    public String getTorDate() {
        return (String) get(TBTHB2KMEI.DATE5);
    }

    /**
     * 取消年月日を設定する
     * @param val 取消年月日
     */
    public void setTorDate(String val) {
        set(TBTHB2KMEI.DATE5, val);
    }

    /**
     * 受注明細Noを取得する
     * @return 受注明細No
     */
    public String getJymeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 受注明細Noを設定する
     * @param val 受注明細No
     */
    public void setJymeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 売上明細Noを取得する
     * @return 売上明細No
     */
    public String getUrmeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 売上明細Noを設定する
     * @param val 売上明細No
     */
    public void setUrmeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 処理区分を取得する
     * @return 処理区分
     */
    public String getShoriKbn() {
        return (String) get(TBTHB2KMEI.KBN1);
    }

    /**
     * 処理区分を設定する
     * @param val 処理区分
     */
    public void setShoriKbn(String val) {
        set(TBTHB2KMEI.KBN1, val);
    }

    /**
     * 出力日時を取得する
     * @return 出力日時
     */
    public String getOutDate() {
        return (String) get(TBTHB2KMEI.NAME7);
    }

    /**
     * 出力日時を設定する
     * @param val 出力日時
     */
    public void setOutDate(String val) {
        set(TBTHB2KMEI.NAME7, val);
    }

    /**
     * 連番を取得する
     * @return 連番
     */
    public String getRenBan() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * 連番を設定する
     * @param val 連番
     */
    public void setRenBan(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * 掲載単価を取得する
     * @return 掲載単価
     */
    public String getKeisaiTnk() {
        return (String) get(TBTHB2KMEI.SONOTA7);
    }

    /**
     * 掲載単価を設定する
     * @param val 掲載単価
     */
    public void setKeisaiTnk(String val) {
        set(TBTHB2KMEI.SONOTA7, val);
    }

    /**
     * 名称11(漢字)を取得する
     * @return 名称11(漢字)
     */
    public String getName11() {
        return (String) get(TBTHB2KMEI.NAME11);
    }

    /**
     * 名称11(漢字)を設定する
     * @param val 名称11(漢字)
     */
    public void setName11(String val) {
        set(TBTHB2KMEI.NAME11, val);
    }

    /**
     * 名称12(漢字)を取得する
     * @return 名称12(漢字)
     */
    public String getName12() {
        return (String) get(TBTHB2KMEI.NAME12);
    }

    /**
     * 名称12(漢字)を設定する
     * @param val 名称12(漢字)
     */
    public void setName12(String val) {
        set(TBTHB2KMEI.NAME12, val);
    }

    /**
     * 名称13(漢字)を取得する
     * @return 名称13(漢字)
     */
    public String getName13() {
        return (String) get(TBTHB2KMEI.NAME13);
    }

    /**
     * 名称13(漢字)を設定する
     * @param val 名称13(漢字)
     */
    public void setName13(String val) {
        set(TBTHB2KMEI.NAME13, val);
    }

    /**
     * 名称14(漢字)を取得する
     * @return 名称14(漢字)
     */
    public String getName14() {
        return (String) get(TBTHB2KMEI.NAME14);
    }

    /**
     * 名称14(漢字)を設定する
     * @param val 名称14(漢字)
     */
    public void setName14(String val) {
        set(TBTHB2KMEI.NAME14, val);
    }

    /**
     * 名称15(漢字)を取得する
     * @return 名称15(漢字)
     */
    public String getName15() {
        return (String) get(TBTHB2KMEI.NAME15);
    }

    /**
     * 名称15(漢字)を設定する
     * @param val 名称15(漢字)
     */
    public void setName15(String val) {
        set(TBTHB2KMEI.NAME15, val);
    }

    /**
     * 名称16(漢字)を取得する
     * @return 名称16(漢字)
     */
    public String getName16() {
        return (String) get(TBTHB2KMEI.NAME16);
    }

    /**
     * 名称16(漢字)を設定する
     * @param val 名称16(漢字)
     */
    public void setName16(String val) {
        set(TBTHB2KMEI.NAME16, val);
    }

    /**
     * 名称17(漢字)を取得する
     * @return 名称17(漢字)
     */
    public String getName17() {
        return (String) get(TBTHB2KMEI.NAME17);
    }

    /**
     * 名称17(漢字)を設定する
     * @param val 名称17(漢字)
     */
    public void setName17(String val) {
        set(TBTHB2KMEI.NAME17, val);
    }

    /**
     * 値引行区分を取得する
     * @return 値引行区分
     */
    public String getNebiKbn() {
        return (String) get(TBTHB2KMEI.KBN2);
    }

    /**
     * 値引行区分を設定する
     * @param val 値引行区分
     */
    public void setNebiKbn(String val) {
        set(TBTHB2KMEI.KBN2, val);
    }

    /**
     * 細目区分を取得する
     * @return 細目区分
     */
    public String getSaimokuKbn() {
        return (String) get(TBTHB5HIK.SAIKBN);
    }

    /**
     * 細目区分を設定する
     * @param val 細目区分
     */
    public void setSaimokuKbn(String val) {
        set(TBTHB5HIK.SAIKBN, val);
    }

    /**
     * メディア名を取得する
     * @return メディア名
     */
    public String getMediaNm() {
        return (String) get(FindClaimByCondDAO.MEDIA_NM);
    }

    /**
     * メディア名を設定する
     * @param val メディア名
     */
    public void setMediaNm(String val) {
        set(FindClaimByCondDAO.MEDIA_NM, val);
    }

    /**
     * 新聞_掲載場所名称を取得する
     * @return 新聞_掲載場所名称
     */
    public String getSnbn_KeiBasNm() {
        return (String) get(FindClaimByCondDAO.SNBN_KEIBAS_NM);
    }

    /**
     * 新聞_掲載場所名称を設定する
     * @param val 新聞_掲載場所名称
     */
    public void setSnbn_KeiBasNm(String val) {
        set(FindClaimByCondDAO.SNBN_KEIBAS_NM, val);
    }

    /**
     * 新聞_種別1名称を取得する
     * @return 新聞_種別1名称
     */
    public String getSnbn_Sybt1Nm() {
        return (String) get(FindClaimByCondDAO.SNBN_SYBT1_NM);
    }

    /**
     * 新聞_種別1名称を設定する
     * @param val 新聞_種別1名称
     */
    public void setSnbn_Sybt1Nm(String val) {
        set(FindClaimByCondDAO.SNBN_SYBT1_NM, val);
    }

    /**
     * 新聞_種別2名称を取得する
     * @return 新聞_種別2名称
     */
    public String getSnbn_Sybt2Nm() {
        return (String) get(FindClaimByCondDAO.SNBN_SYBT2_NM);
    }

    /**
     * 新聞_種別2名称を設定する
     * @param val 新聞_種別2名称
     */
    public void setSnbn_Sybt2Nm(String val) {
        set(FindClaimByCondDAO.SNBN_SYBT2_NM, val);
    }

    /**
     * 新聞_色刷名称を取得する
     * @return 新聞_色刷名称
     */
    public String getSnbn_SisatNm() {
        return (String) get(FindClaimByCondDAO.SNBN_SISAT_NM);
    }

    /**
     * 新聞_色刷名称を設定する
     * @param val 新聞_色刷名称
     */
    public void setSnbn_SisatNm(String val) {
        set(FindClaimByCondDAO.SNBN_SISAT_NM, val);
    }

    /**
     * 新聞_サイズ名称を取得する
     * @return 新聞_サイズ名称
     */
    public String getSnbn_SizeNm() {
        return (String) get(FindClaimByCondDAO.SNBN_SIZE_NM);
    }

    /**
     * 新聞_サイズ名称を設定する
     * @param val 新聞_サイズ名称
     */
    public void setSnbn_SizeNm(String val) {
        set(FindClaimByCondDAO.SNBN_SIZE_NM, val);
    }

    /**
     * 雑誌_色刷名称を取得する
     * @return 雑誌_色刷名称
     */
    public String getZasi_SisatNm() {
        return (String) get(FindClaimByCondDAO.ZASI_SISAT_NM);
    }

    /**
     * 雑誌_色刷名称を設定する
     * @param val 雑誌_色刷名称
     */
    public void setZasi_SisatNm(String val) {
        set(FindClaimByCondDAO.ZASI_SISAT_NM, val);
    }

    /**
     * 雑誌_サイズ名称を取得する
     * @return 雑誌_サイズ名称
     */
    public String getZasi_SizeNm() {
        return (String) get(FindClaimByCondDAO.ZASI_SIZE_NM);
    }

    /**
     * 雑誌_サイズ名称を設定する
     * @param val 雑誌_サイズ名称
     */
    public void setZasi_SizeNm(String val) {
        set(FindClaimByCondDAO.ZASI_SIZE_NM, val);
    }

    /**
     * 電波_交通掲載名称を取得する
     * @return 電波_交通掲載名称
     */
    public String getDemp_kotKeiNm() {
        return (String) get(FindClaimByCondDAO.DEMP_KOTKEI_NM);
    }

    /**
     * 電波_交通掲載名称を設定する
     * @param val 電波_交通掲載名称
     */
    public void setDemp_kotKeiNm(String val) {
        set(FindClaimByCondDAO.DEMP_KOTKEI_NM, val);
    }

}
