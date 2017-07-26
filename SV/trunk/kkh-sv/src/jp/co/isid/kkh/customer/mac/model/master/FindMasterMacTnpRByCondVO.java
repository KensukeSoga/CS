package jp.co.isid.kkh.customer.mac.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHB17RMTNP;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * マクドナルド店舗マスタ履歴テーブルVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
@XmlRootElement(namespace = "http://master.model.mac.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.mac.customer.kkh.isid.co.jp/")
public class FindMasterMacTnpRByCondVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindMasterMacTnpRByCondVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindMasterMacTnpRByCondVO();
    }

    /**
     * 登録タイムスタンプを設定します。
     * @param val String 登録タイムスタンプ
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB17RMTNP.TRKTIMSTMP, val);
    }

    /**
     * 登録タイムスタンプを返します。
     * @return String 登録タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB17RMTNP.TRKTIMSTMP);
    }

    /**
     * 登録プログラムを設定します。
     * @param val String 登録プログラム
     */
    public void setTrkPl(String val) {
        set(TBTHB17RMTNP.TRKPL, val);
    }

    /**
     * 登録プログラムを返します。
     * @return String 登録プログラム
     */
    public String getTrkPl() {
        return (String) get(TBTHB17RMTNP.TRKPL);
    }

    /**
     * 登録担当者を設定します。
     * @param val String 登録担当者
     */
    public void setTrkTnt(String val) {
        set(TBTHB17RMTNP.TRKTNT, val);
    }

    /**
     * 登録担当者を返します。
     * @return String 登録担当者
     */
    public String getTrkTnt() {
        return (String) get(TBTHB17RMTNP.TRKTNT);
    }

    /**
     * 更新タイムスタンプを設定します。
     * @param val String 更新タイムスタンプ
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB17RMTNP.UPDTIMSTMP, val);
    }

    /**
     * 更新タイムスタンプを返します。
     * @return String 更新タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB17RMTNP.UPDTIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setUpdaPl(String val) {
        set(TBTHB17RMTNP.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getUpdaPl() {
        return (String) get(TBTHB17RMTNP.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setUpdTnt(String val) {
        set(TBTHB17RMTNP.UPDTNT   , val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getUpdTnt() {
        return (String) get(TBTHB17RMTNP.UPDTNT   );
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setEgCd(String val) {
        set(TBTHB17RMTNP.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getEgCd() {
        return (String) get(TBTHB17RMTNP.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHB17RMTNP.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB17RMTNP.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB17RMTNP.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB17RMTNP.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB17RMTNP.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB17RMTNP.TKSTNTSEQNO);
    }

    /**
     * 店舗コードを設定します。
     *
     * @param val String 店舗コード
     */
    public void setTenpoCd(String val) {
        set(TBTHB17RMTNP.TENPOCD, val);
    }

    /**
     * 店舗コードを返します。
     *
     * @return String 店舗コード
     */
    public String getTenpoCd() {
        return (String) get(TBTHB17RMTNP.TENPOCD);
    }

    /**
     * 店舗名を設定します。
     *
     * @param val String 店舗名
     */
    public void setTenpoNm(String val) {
        set(TBTHB17RMTNP.TENPONM, val);
    }

    /**
     * 店舗名を返します。
     *
     * @return String 店舗名
     */
    public String getTenpoNm() {
        return (String) get(TBTHB17RMTNP.TENPONM);
    }

    /**
     * テリトリーを設定します。
     *
     * @param val String テリトリー
     */
    public void setTerritory(String val) {
        set(TBTHB17RMTNP.TERRITORY, val);
    }

    /**
     * テリトリーを返します。
     *
     * @return String テリトリー
     */
    public String getTerritory() {
        return (String) get(TBTHB17RMTNP.TERRITORY);
    }

    /**
     * 店舗区分を設定します。
     *
     * @param val String 店舗区分
     */
    public void setTenpoKbn(String val) {
        set(TBTHB17RMTNP.TENPOKBN, val);
    }

    /**
     * 店舗区分を返します。
     *
     * @return String 店舗区分
     */
    public String getTenpoKbn() {
        return (String) get(TBTHB17RMTNP.TENPOKBN);
    }

    /**
     * 勘定科目を設定します。
     *
     * @param val String 勘定科目
     */
    public void setKamoku(String val) {
        set(TBTHB17RMTNP.KAMOKU, val);
    }

    /**
     * 勘定科目を返します。
     *
     * @return String 勘定科目
     */
    public String getKamoku() {
        return (String) get(TBTHB17RMTNP.KAMOKU);
    }

    /**
     * 郵便番号を設定します。
     *
     * @param val String 郵便番号
     */
    public void setYubinNo(String val) {
        set(TBTHB17RMTNP.YUBINNO, val);
    }

    /**
     * 郵便番号を返します。
     *
     * @return String 郵便番号
     */
    public String getYubinNo() {
        return (String) get(TBTHB17RMTNP.YUBINNO);
    }

    /**
     * 住所１を設定します。
     *
     * @param val String 住所１
     */
    public void setAddress1(String val) {
        set(TBTHB17RMTNP.ADDRESS1, val);
    }

    /**
     * 住所１を返します。
     *
     * @return String 住所１
     */
    public String getAddress1() {
        return (String) get(TBTHB17RMTNP.ADDRESS1);
    }

    /**
     * 住所２を設定します。
     *
     * @param val String 住所２
     */
    public void setAddress2(String val) {
        set(TBTHB17RMTNP.ADDRESS2, val);
    }

    /**
     * 住所２を返します。
     *
     * @return String 住所２
     */
    public String getAddress2() {
        return (String) get(TBTHB17RMTNP.ADDRESS2);
    }

    /**
     * 電話番号を設定します。
     *
     * @param val String 電話番号
     */
    public void setTelNo(String val) {
        set(TBTHB17RMTNP.TELNO, val);
    }

    /**
     * 電話番号を返します。
     *
     * @return String 電話番号
     */
    public String getTelNo() {
        return (String) get(TBTHB17RMTNP.TELNO);
    }

    /**
     * 明細行フラグを設定します。
     *
     * @param val String 明細行フラグ
     */
    public void setSplitFlg(String val) {
        set(TBTHB17RMTNP.SPLITFLG, val);
    }

    /**
     * 明細行フラグを返します。
     *
     * @return String 明細行フラグ
     */
    public String getSplitFlg() {
        return (String) get(TBTHB17RMTNP.SPLITFLG);
    }

    /**
     * ライセンシー社名を設定します。
     *
     * @param val String ライセンシー社名
     */
    public void setCompanyNm(String val) {
        set(TBTHB17RMTNP.COMPANYNM, val);
    }

    /**
     * ライセンシー社名を返します。
     *
     * @return String ライセンシー社名
     */
    public String getCompanyNm() {
        return (String) get(TBTHB17RMTNP.COMPANYNM);
    }

    /**
     * 代表者名を設定します。
     *
     * @param val String 代表者名
     */
    public void setName(String val) {
        set(TBTHB17RMTNP.NAME, val);
    }

    /**
     * 代表者名を返します。
     *
     * @return String 代表者名
     */
    public String getName() {
        return (String) get(TBTHB17RMTNP.NAME);
    }

    /**
     * 取引先コードを設定します。
     *
     * @param val String 取引先コード
     */
    public void setTorihikiCd(String val) {
        set(TBTHB17RMTNP.TORIHIKICD, val);
    }

    /**
     * 取引先コードを返します。
     *
     * @return String 取引先コード
     */
    public String getTorihikiCd() {
        return (String) get(TBTHB17RMTNP.TORIHIKICD);
    }

    /**
     * ステータスを設定します。
     *
     * @param val String ステータス
     */
    public void setInStatus(String val) {
        set(TBTHB17RMTNP.INSTATUS, val);
    }

    /**
     * ステータスを返します。
     *
     * @return String ステータス
     */
    public String getInStatus() {
        return (String) get(TBTHB17RMTNP.INSTATUS);
    }

    /**
     * 初期G.OPEN年月日を設定します。
     *
     * @param val String 初期G.OPEN年月日
     */
    public void setSGOpen(String val) {
        set(TBTHB17RMTNP.SGOPEN, val);
    }

    /**
     * 初期G.OPEN年月日を返します。
     *
     * @return String 初期G.OPEN年月日
     */
    public String getSGOpen() {
        return (String) get(TBTHB17RMTNP.SGOPEN);
    }

    /**
     * G.OPEN年月日を設定します。
     *
     * @param val String G.OPEN年月日
     */
    public void setGOpen(String val) {
        set(TBTHB17RMTNP.GOPEN, val);
    }

    /**
     * G.OPEN年月日を返します。
     *
     * @return String G.OPEN年月日
     */
    public String getGOpen() {
        return (String) get(TBTHB17RMTNP.GOPEN);
    }

    /**
     * G.CLOSE年月日を設定します。
     *
     * @param val String G.CLOSE年月日
     */
    public void setGClose(String val) {
        set(TBTHB17RMTNP.GCLOSE, val);
    }

    /**
     * G.CLOSE年月日を返します。
     *
     * @return String G.CLOSE年月日
     */
    public String getGClose() {
        return (String) get(TBTHB17RMTNP.GCLOSE);
    }

    /**
     * 更新実施キーを設定します。
     *
     * @param val String 更新実施キー
     */
    public void setUpdRrkTimstmp(String val) {
        set(TBTHB17RMTNP.UPDRRKTIMSTMP, val);
    }

    /**
     * 更新実施キーを返します。
     *
     * @return String 更新実施キー
     */
    public String getUpdRrkTimstmp() {
        return (String) get(TBTHB17RMTNP.UPDRRKTIMSTMP);
    }

    /**
     * 取り込み更新フラグを設定します。
     *
     * @param val String 取り込み更新フラグ
     */
    public void setTorikomiFlg(String val) {
        set(TBTHB17RMTNP.TORIKOMIFLG, val);
    }

    /**
     * 取り込み更新フラグを返します。
     *
     * @return String 取り込み更新フラグ
     */
    public String getTorikomiFlg() {
        return (String) get(TBTHB17RMTNP.TORIKOMIFLG);
    }

    /**
     * 履歴種別を設定します。
     *
     * @param val String 履歴種別
     */
    public void setRrkSybt(String val) {
        set(TBTHB17RMTNP.RRKSYBT, val);
    }

    /**
     * 履歴種別を返します。
     *
     * @return String 履歴種別
     */
    public String getRrkSybt() {
        return (String) get(TBTHB17RMTNP.RRKSYBT);
    }

}
