package jp.co.isid.kkh.model.detail;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

public class JyutyuDataCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 営業所（取）コード */
    private String _egCd;
    /** 得意先企業コード */
    private String _tksKgyCd;
    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo;
    /** 得意先担当SEQNO */
    private String _tksTntSeqNo;
    /** 年月 */
    private String yymm;
    /** 終了年月 */
    private String yymmto;
    /** 国際区分 */
    private String kokKbn;
    /** タイム／スポット */
    private String tmspKbn;
    /** 業務区分 */
    private String gyomKbn;
    /** 受注No */
    private String jyutNo;
    /** 件名順／媒体順 */
    private String orderKbn;
    /** 変更・削除チェックフラグ */
    private boolean _updateCheckFlag = false;
    /** ログイン担当者ESQID */
    private String _esqId = null;
    /** アプリID */
    private String _aplId = null;
    /** 件名 */
    private String _kkNameKj;

    /**
     * @return egCd
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * @param egCd セットする egCd
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * @return tksKgyCd
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * @param tksKgyCd セットする tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * @return tksBmnSeqNo
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * @param tksBmnSeqNo セットする tksBmnSeqNo
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * @return tksTntSeqNo
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * @param tksTntSeqNo セットする tksTntSeqNo
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * 年月を返します。
     * @return yymm
     */
    public String getYymm() {
        return yymm;
    }

    /**
     * 年月を設定します。
     * @param yymm
     */
    public void setYymm(String yymm) {
        this.yymm = yymm;
    }

    /**
     * 終了年月を返します。
     * @return yymmto
     */
    public String getYymmTo() {
        return yymmto;
    }

    /**
     * 終了年月を設定します。
     * @param yymmto
     */
    public void setYymmTo(String yymmto) {
        this.yymmto = yymmto;
    }

    /**
     * 国際区分を返します。
     * @return kokKbn
     */
    public String getKokKbn() {
        return kokKbn;
    }

    /**
     * 国際区分を設定します。
     * @param kokKbn
     */
    public void setKokKbn(String kokKbn) {
        this.kokKbn = kokKbn;
    }

    /**
     * タイム／スポットを返します。
     * @return tmspKbn
     */
    public String getTmspKbn() {
        return tmspKbn;
    }

    /**
     * タイム／スポットを設定します。
     * @param tmspKbn
     */
    public void setTmspKbn(String tmspKbn) {
        this.tmspKbn = tmspKbn;
    }

    /**
     * 業務区分を返します。
     * @return gyomKbn
     */
    public String getGyomKbn() {
        return gyomKbn;
    }

    /**
     * 業務区分を設定します。
     * @param gyomKbn
     */
    public void setGyomKbn(String gyomKbn) {
        this.gyomKbn = gyomKbn;
    }

    /**
     * 受注Noを返します。
     * @return jyutNo
     */
    public String getJyutNo() {
        return jyutNo;
    }

    /**
     * 受注Noを設定します。
     * @param jyutNo
     */
    public void setJyutNo(String jyutNo) {
        this.jyutNo = jyutNo;
    }

    /**
     * 件名順／媒体順を返します。
     * @return orderKbn
     */
    public String getOrderKbn() {
        return orderKbn;
    }

    /**
     * 件名順／媒体順を設定します。
     * @param orderKbn
     */
    public void setOrderKbn(String orderKbn) {
        this.orderKbn = orderKbn;
    }

    /**
     * 変更・削除チェックフラグを取得する
     * @return 変更・削除チェックフラグ
     */
    public boolean getUpdateCheckFlag() {
        return _updateCheckFlag;
    }

    /**
     * 変更・削除チェックフラグを設定する
     * @param updateCheckFlag 変更・削除チェックフラグ
     */
    public void setUpdateCheckFlag(boolean updateCheckFlag) {
        this._updateCheckFlag = updateCheckFlag;
    }

    /**
     * ログイン担当者ESQIDを取得する
     * @return ログイン担当者ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ログイン担当者ESQIDを設定する
     * @param esqId ログイン担当者ESQID
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * アプリIDを取得する
     * @return アプリID
     */
    public String getAplId() {
        return _aplId;
    }

    /**
     * アプリIDを設定する
     * @param aplId アプリID
     */
    public void setAplId(String aplId) {
        this._aplId = aplId;
    }

    /**
     * 件名を返します。
     * @return 件名
     */
    public String getKkNameKj() {
        return _kkNameKj;
    }

    /**
     * 件名を設定します。
     * @param kkNameKj 件名
     */
    public void setKkNameKj(String kkNameKj) {
        this._kkNameKj = kkNameKj;
    }

    //サービス非公開▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
    //@XmlTransient
    /** 変更チェック項目リスト */
    private List<String> _compareColumnList;
    /** 変更通知機能の使用可否フラグ */
    private boolean _updPostFlag = true;

    /**
     * 変更チェック項目リストを返します。
     * @return _compareColumnList
     */
    @XmlTransient
    public List<String> getCompareColumnList(){
        return _compareColumnList;
    }

    /**
     * 変更チェック項目リストを設定します。
     * @param compareColumnList
     */
    public void setCompareColumnList(List<String> compareColumnList){
        _compareColumnList = compareColumnList;
    }

    /**
     * 変更通知機能の使用可否フラグを返します。
     * @return _updPostFlag
     */
    @XmlTransient
    public boolean getUpdPostFlag(){
        return _updPostFlag;
    }

    /**
     * 変更通知機能の使用可否フラグを設定します。
     * @param updPostFlag
     */
    public void setUpdPostFlag(boolean updPostFlag){
        _updPostFlag = updPostFlag;
    }

    //サービス非公開▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲

}
