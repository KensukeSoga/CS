package jp.co.isid.kkh.customer.acom.model.claim;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 発注/請求 差異一覧情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimDiffCondVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 新規インスタンスを構築します。
     */
    public FindClaimDiffCondVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindClaimDiffCondVO();
    }

    /**
     * レコード種別を取得する
     * @return レコード種別
     */
    public String getRecCd() {
        return (String) get(TBTHB5HIK.RECCD);
    }

    /**
     * レコード種別を設定する
     * @param val レコード種別
     */
    public void setRecCd(String val) {
        set(TBTHB5HIK.RECCD, val);
    }

    /**
     * 依頼番号を取得する
     * @return 依頼番号
     */
    public String getIrBan() {
        return (String) get(TBTHB5HIK.IRBAN);
    }

    /**
     * 依頼番号を設定する
     * @param val 依頼番号
     */
    public void setIrBan(String val) {
        set(TBTHB5HIK.IRBAN, val);
    }

    /**
     * 依頼行番号を取得する
     * @return 依頼行番号
     */
    public String getIrRowBan() {
        return (String) get(TBTHB5HIK.IRROWBAN);
    }

    /**
     * 依頼行番号を設定する
     * @param val 依頼行番号
     */
    public void setIrRowBan(String val) {
        set(TBTHB5HIK.IRROWBAN, val);
    }

    /**
     * 得意先コード（取引先コード）を取得する
     * @return 得意先コード（取引先コード）
     */
    public String getTokuiCd() {
        return (String) get(TBTHB5HIK.TOKUICD);
    }

    /**
     * 得意先コード（取引先コード）を設定する
     * @param val 得意先コード（取引先コード）
     */
    public void setTokuiCd(String val) {
        set(TBTHB5HIK.TOKUICD, val);
    }

    /**
     * 商品区分を取得する
     * @return 商品区分
     */
    public String getSyohinKbn() {
        return (String) get(TBTHB5HIK.SYOHIKBN);
    }

    /**
     * 商品区分を設定する
     * @param val 商品区分
     */
    public void setSyohinKbn(String val) {
        set(TBTHB5HIK.SYOHIKBN, val);
    }

    /**
     * 商品区分名称を取得する
     * @return 商品区分名称
     */
    public String getSyohinKbnNm() {
        return (String) get(TBTHB5HIK.SYOHINAME);
    }

    /**
     * 商品区分名称を設定する
     * @param val 商品区分名称
     */
    public void setSyohinKbnNm(String val) {
        set(TBTHB5HIK.SYOHINAME, val);
    }

    /**
     * 摘要コードを取得する
     * @return 摘要コード
     */
    public String getTekiCd() {
        return (String) get(TBTHB5HIK.TEKICD);
    }

    /**
     * 摘要コードを設定する
     * @param val 摘要コード
     */
    public void setTekiCd(String val) {
        set(TBTHB5HIK.TEKICD, val);
    }

    /**
     * 種別（媒体コード）を取得する
     * @return 種別（媒体コード）
     */
    public String getSybt() {
        return (String) get(TBTHB5HIK.SYBT);
    }

    /**
     * 種別（媒体コード）を設定する
     * @param val 種別（媒体コード）
     */
    public void setSybt(String val) {
        set(TBTHB5HIK.SYBT, val);
    }

    /**
     * メディアコードを取得する
     * @return メディアコード
     */
    public String getMediaCd() {
        return (String) get(TBTHB5HIK.MEDIACD);
    }

    /**
     * メディアコードを設定する
     * @param val メディアコード
     */
    public void setMediaCd(String val) {
        set(TBTHB5HIK.MEDIACD, val);
    }

    /**
     * 店番を取得する
     * @return 店番
     */
    public String getTenBan() {
        return (String) get(TBTHB5HIK.TENCD);
    }

    /**
     * 店番を設定する
     * @param val 店番
     */
    public void setTenBan(String val) {
        set(TBTHB5HIK.TENCD, val);
    }

    /**
     * 掲載単価を取得する
     * @return 掲載単価
     */
    public String getKeisaiTnk() {
        return (String) get(TBTHB5HIK.KEISAITANKA);
    }

    /**
     * 掲載単価を設定する
     * @param val 掲載単価
     */
    public void setKeisaiTnk(String val) {
        set(TBTHB5HIK.KEISAITANKA, val);
    }

    /**
     * 掲載料を取得する
     * @return 掲載料
     */
    public BigDecimal getKeisaiRyo() {
        return (BigDecimal) get(TBTHB5HIK.KEISAIRYO);
    }

    /**
     * 掲載料を設定する
     * @param val 掲載料
     */
    public void setKeisaiRyo(BigDecimal val) {
        set(TBTHB5HIK.KEISAIRYO, val);
    }


    /**
     * 放送料1を取得する
     * @return 放送料1
     */
    public BigDecimal getHosoRyo1() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO1);
    }

    /**
     * 放送料1を設定する
     * @param val 放送料1
     */
    public void setHosoRyo1(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO1, val);
    }

    /**
     * 放送料2を取得する
     * @return 放送料2
     */
    public BigDecimal getHosoRyo2() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO2);
    }

    /**
     * 放送料2を設定する
     * @param val 放送料2
     */
    public void setHosoRyo2(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO2, val);
    }

    /**
     * 放送料3を取得する
     * @return 放送料3
     */
    public BigDecimal getHosoRyo3() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO3);
    }

    /**
     * 放送料3を設定する
     * @param val 放送料3
     */
    public void setHosoRyo3(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO3, val);
    }

    /**
     * 放送料4を取得する
     * @return 放送料4
     */
    public BigDecimal getHosoRyo4() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO4);
    }

    /**
     * 放送料4を設定する
     * @param val 放送料4
     */
    public void setHosoRyo4(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO4, val);
    }

    /**
     * 放送料5を取得する
     * @return 放送料5
     */
    public BigDecimal getHosoRyo5() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO5);
    }

    /**
     * 放送料5を設定する
     * @param val 放送料5
     */
    public void setHosoRyo5(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO5, val);
    }

    /**
     * 放送料6を取得する
     * @return 放送料6
     */
    public BigDecimal getHosoRyo6() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO6);
    }

    /**
     * 放送料6を設定する
     * @param val 放送料6
     */
    public void setHosoRyo6(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO6, val);
    }

    /**
     * 按分種別を取得する
     * @return 按分種別
     */
    public String getAnSybt() {
        return (String) get(TBTHB5HIK.ANSYUBE);
    }

    /**
     * 按分種別を設定する
     * @param val 按分種別
     */
    public void setAnSybt(String val) {
        set(TBTHB5HIK.ANSYUBE, val);
    }

    /**
     * 依頼月1を取得する
     * @return 依頼月1
     */
    public String getIrMonth1() {
        return (String) get(TBTHB5HIK.IRMONTH1);
    }

    /**
     * 依頼月1を設定する
     * @param val 依頼月1
     */
    public void setIrMonth1(String val) {
        set(TBTHB5HIK.IRMONTH1, val);
    }

    /**
     * 依頼月2を取得する
     * @return 依頼月2
     */
    public String getIrMonth2() {
        return (String) get(TBTHB5HIK.IRMONTH2);
    }

    /**
     * 依頼月2を設定する
     * @param val 依頼月2
     */
    public void setIrMonth2(String val) {
        set(TBTHB5HIK.IRMONTH2, val);
    }

    /**
     * 依頼月3を取得する
     * @return 依頼月3
     */
    public String getIrMonth3() {
        return (String) get(TBTHB5HIK.IRMONTH3);
    }

    /**
     * 依頼月3を設定する
     * @param val 依頼月3
     */
    public void setIrMonth3(String val) {
        set(TBTHB5HIK.IRMONTH3, val);
    }

    /**
     * 依頼月4を取得する
     * @return 依頼月4
     */
    public String getIrMonth4() {
        return (String) get(TBTHB5HIK.IRMONTH4);
    }

    /**
     * 依頼月4を設定する
     * @param val 依頼月4
     */
    public void setIrMonth4(String val) {
        set(TBTHB5HIK.IRMONTH4, val);
    }

    /**
     * 依頼月5を取得する
     * @return 依頼月5
     */
    public String getIrMonth5() {
        return (String) get(TBTHB5HIK.IRMONTH5);
    }

    /**
     * 依頼月5を設定する
     * @param val 依頼月5
     */
    public void setIrMonth5(String val) {
        set(TBTHB5HIK.IRMONTH5, val);
    }

    /**
     * 依頼月6を取得する
     * @return 依頼月6
     */
    public String getIrMonth6() {
        return (String) get(TBTHB5HIK.IRMONTH6);
    }

    /**
     * 依頼月6を設定する
     * @param val 依頼月6
     */
    public void setIrMonth6(String val) {
        set(TBTHB5HIK.IRMONTH6, val);
    }

    /**
     * 形態区分コードを取得する
     * @return 形態区分コード
     */
    public String getKeitaiCd() {
        return (String) get(TBTHB5HIK.KEITAICD);
    }

    /**
     * 形態区分コードを設定する
     * @param val 形態区分コード
     */
    public void setKeitaiCd(String val) {
        set(TBTHB5HIK.KEITAICD, val);
    }

    /**
     * 形態区分名を取得する
     * @return 形態区分名
     */
    public String getKeitaiName() {
        return (String) get(TBTHB5HIK.KEITAINAME);
    }

    /**
     * 形態区分名を設定する
     * @param val 形態区分名
     */
    public void setKeitaiName(String val) {
        set(TBTHB5HIK.KEITAINAME, val);
    }

    /**
     * 細目区分を取得する
     * @return 細目区分
     */
    public String getSaiKbn() {
        return (String) get(TBTHB5HIK.SAIKBN);
    }

    /**
     * 細目区分を設定する
     * @param val 細目区分
     */
    public void setSaiKbn(String val) {
        set(TBTHB5HIK.SAIKBN, val);
    }

    /**
     * 履歴管理番号を取得する
     * @return 履歴管理番号
     */
    public String getRireNo() {
        return (String) get(TBTHB5HIK.RIRENO);
    }

    /**
     * 履歴管理番号を設定する
     * @param val 履歴管理番号
     */
    public void setRireNo(String val) {
        set(TBTHB5HIK.RIRENO, val);
    }

    /**
     * 備考1を取得する
     * @return 備考1
     */
    public String getBikou1() {
        return (String) get(TBTHB5HIK.BIKOU1);
    }

    /**
     * 備考1を設定する
     * @param val 備考1
     */
    public void setBikou1(String val) {
        set(TBTHB5HIK.BIKOU1, val);
    }

    /**
     * 備考2を取得する
     * @return 備考2
     */
    public String getBikou2() {
        return (String) get(TBTHB5HIK.BIKOU2);
    }

    /**
     * 備考2を設定する
     * @param val 備考2
     */
    public void setBikou2(String val) {
        set(TBTHB5HIK.BIKOU2, val);
    }

    /**
     * 掲載場所コードを取得する
     * @return 掲載場所コード
     */
    public String getPlaceCd() {
        return (String) get(TBTHB5HIK.PLACECD);
    }

    /**
     * 掲載場所コードを設定する
     * @param val 掲載場所コード
     */
    public void setPlaceCd(String val) {
        set(TBTHB5HIK.PLACECD, val);
    }

    /**
     * 種別１コードを取得する
     * @return 種別１コード
     */
    public String getSybt1Cd() {
        return (String) get(TBTHB5HIK.SYBT1CD);
    }

    /**
     * 種別１コードを設定する
     * @param val 種別１コード
     */
    public void setSybt1Cd(String val) {
        set(TBTHB5HIK.SYBT1CD, val);
    }

    /**
     * 種別２コードを取得する
     * @return 種別２コード
     */
    public String getSybt2Cd() {
        return (String) get(TBTHB5HIK.SYBT2CD);
    }

    /**
     * 種別２コードを設定する
     * @param val 種別２コード
     */
    public void setSybt2Cd(String val) {
        set(TBTHB5HIK.SYBT2CD, val);
    }

    /**
     * 色刷コードを取得する
     * @return 色刷コード
     */
    public String getColorCd() {
        return (String) get(TBTHB5HIK.COLORCD);
    }

    /**
     * 色刷コードを設定する
     * @param val 色刷コード
     */
    public void setColorCd(String val) {
        set(TBTHB5HIK.COLORCD, val);
    }

    /**
     * サイズコードを取得する
     * @return サイズコード
     */
    public String getSizeCd() {
        return (String) get(TBTHB5HIK.SIZECD);
    }

    /**
     * サイズコードを設定する
     * @param val サイズコード
     */
    public void setSizeCd(String val) {
        set(TBTHB5HIK.SIZECD, val);
    }

    /**
     * スペースコードを取得する
     * @return スペースコード
     */
    public String getSpCd() {
        return (String) get(TBTHB5HIK.SPACECD);
    }

    /**
     * スペースコードを設定する
     * @param val スペースコード
     */
    public void setSpCd(String val) {
        set(TBTHB5HIK.SPACECD, val);
    }

    /**
     * 交通掲載コードを取得する
     * @return 交通掲載コード
     */
    public String getKotuKeiCd() {
        return (String) get(TBTHB5HIK.KOTUKEICD);
    }

    /**
     * 交通掲載コードを設定する
     * @param val 交通掲載コード
     */
    public void setKotuKeiCd(String val) {
        set(TBTHB5HIK.KOTUKEICD, val);
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
    public String getKeiBasNm() {
        return (String) get(FindClaimByCondDAO.SNBN_KEIBAS_NM);
    }

    /**
     * 新聞_掲載場所名称を設定する
     * @param val 新聞_掲載場所名称
     */
    public void setKeiBasNm(String val) {
        set(FindClaimByCondDAO.SNBN_KEIBAS_NM, val);
    }

    /**
     * 新聞_種別1名称を取得する
     * @return 新聞_種別1名称
     */
    public String getSybt1Nm() {
        return (String) get(FindClaimByCondDAO.SNBN_SYBT1_NM);
    }

    /**
     * 新聞_種別1名称を設定する
     * @param val 新聞_種別1名称
     */
    public void setSybt1Nm(String val) {
        set(FindClaimByCondDAO.SNBN_SYBT1_NM, val);
    }

    /**
     * 新聞_種別2名称を取得する
     * @return 新聞_種別2名称
     */
    public String getSybt2Nm() {
        return (String) get(FindClaimByCondDAO.SNBN_SYBT2_NM);
    }

    /**
     * 新聞_種別2名称を設定する
     * @param val 新聞_種別2名称
     */
    public void setSybt2Nm(String val) {
        set(FindClaimByCondDAO.SNBN_SYBT2_NM, val);
    }

    /**
     * 新聞_色刷名称を取得する
     * @return 新聞_色刷名称
     */
    public String getSisatNm() {
        return (String) get(FindClaimByCondDAO.SNBN_SISAT_NM);
    }

    /**
     * 新聞_色刷名称を設定する
     * @param val 新聞_色刷名称
     */
    public void setSisatNm(String val) {
        set(FindClaimByCondDAO.SNBN_SISAT_NM, val);
    }

    /**
     * 新聞_スペース名称を取得する
     * @return 新聞_スペース名称
     */
    public String getSpNm() {
        return (String) get(FindClaimByCondDAO.SNBN_SIZE_NM);
    }

    /**
     * 新聞_スペース名称を設定する
     * @param val 新聞_スペース名称
     */
    public void setSpNm(String val) {
        set(FindClaimByCondDAO.SNBN_SIZE_NM, val);
    }

    /**
     * 雑誌_サイズ名称を取得する
     * @return 雑誌_サイズ名称
     */
    public String getSizeNm() {
        return (String) get(FindClaimByCondDAO.ZASI_SIZE_NM);
    }

    /**
     * 雑誌_サイズ名称を設定する
     * @param val 雑誌_サイズ名称
     */
    public void setSizeNm(String val) {
        set(FindClaimByCondDAO.ZASI_SIZE_NM, val);
    }

    /**
     * 電波_交通掲載名称を取得する
     * @return 電波_交通掲載名称
     */
    public String getKotKeiNm() {
        return (String) get(FindClaimByCondDAO.DEMP_KOTKEI_NM);
    }

    /**
     * 電波_交通掲載名称を設定する
     * @param val 電波_交通掲載名称
     */
    public void setKotKeiNm(String val) {
        set(FindClaimByCondDAO.DEMP_KOTKEI_NM, val);
    }
}