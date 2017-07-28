package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.model.master.MasterDataVO;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * マスタデータ登録処理用VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/07 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class InsertLionZashiRyoSpcMastVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** ログイン担当者ESQID */
    private String _esqId = null;

    /** アプリID */
    private String _aplId = null;

    /** 営業所（取）コード */
    private String _egCd = null;

    /** 得意先企業コード */
    private String _tksKgyCd = null;

    /** 得意先部門SEQNO */
    private String _tksBmnSeqNo = null;

    /** 得意先担当SEQNO */
    private String _tksTntSeqNo = null;

    /** マスタキー */
    private String _masterKey = null;

    /** フィルターバリュー */
    private String _filterValue = null;

    /** 汎用マスタデータVOリスト */
    private List<MasterDataVO> _masterData = null;

    /** ダミープロパティ */
    private String _dummy = null;

    /** 更新日時最大値 */
    private Date _maxupdate = null;

    /** 種別 */
    private String _sybt = null;

    /** 雑誌コード */
    private String _zashiCd = null;

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
     * 営業所（取）コードを取得する
     * @return 営業所（取）コード
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * 営業所（取）コードを設定する
     * @param egCd 営業所（取）コード
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * 得意先企業コードを取得する
     * @return 得意先企業コード
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * 得意先企業コードを設定する
     * @param tksKgyCd 得意先企業コード
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * 得意先部門SEQNOを取得する
     * @return 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * 得意先部門SEQNOを設定する
     * @param tksBmnSeqNo 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * 得意先担当SEQNOを取得する
     * @return 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * 得意先担当SEQNOを設定する
     * @param tksTntSeqNo 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * マスタキーを取得する
     * @return マスタキー
     */
    public String getMasterKey() {
        return _masterKey;
    }

    /**
     * マスタキーを設定する
     * @param masterKey マスタキー
     */
    public void setMasterKey(String masterKey) {
        this._masterKey = masterKey;
    }

    /**
     * フィルターバリューを取得する
     * @return フィルターバリュー
     */
    public String getFilterValue() {
        return _filterValue;
    }

    /**
     * フィルターバリューを設定する
     * @param filterValue フィルターバリュー
     */
    public void setFilterValue(String filterValue) {
        this._filterValue = filterValue;
    }

    /**
     * 種別を取得する
     * @return 種別
     */
    public String get_sybt() {
        return _sybt;
    }

    /**
     * 種別を設定する
     * @param sybt 種別
     */
    public void set_sybt(String sybt) {
        _sybt = sybt;
    }

    /**
     * 雑誌コードを取得する
     * @return 雑誌コード
     */
    public String get_zashiCd() {
        return _zashiCd;
    }

    /**
     * 雑誌コードを設定する
     * @param zashiCd 雑誌コード
     */
    public void set_zashiCd(String zashiCd) {
        _zashiCd = zashiCd;
    }

    /**
     * 汎用マスタデータVOリストを取得する
     * @return 汎用マスタデータVOリスト
     */
    public List<MasterDataVO> getMasterData() {
        return _masterData;
    }

    /**
     * 汎用マスタデータVOリストを設定する
     * @param masterData 汎用マスタデータVOリスト
     */
    public void setMasterData(List<MasterDataVO> masterData) {
        this._masterData = masterData;
    }

    /**
     * ダミープロパティを取得する
     * @return ダミープロパティ
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * ダミープロパティを設定する
     * @param dummy ダミープロパティ
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

    /**
     * 更新日時最大値を取得する
     * @return Date 更新日時最大値
     */
    @XmlElement(required = true)
    public Date get_maxupdate() {
        return _maxupdate;
    }

    /**
     * 更新日時最大値を設定する
     * @param maxupdate Date 更新日時最大値
     */
    public void set_maxupdate(Date maxupdate) {
        _maxupdate = maxupdate;
    }

}
