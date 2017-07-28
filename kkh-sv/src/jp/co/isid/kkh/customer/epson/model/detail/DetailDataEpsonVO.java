package jp.co.isid.kkh.customer.epson.model.detail;

import java.io.Serializable;
import java.util.List;

import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

public class DetailDataEpsonVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 明細区分 **/
    private String _kbn = null;

    /** ダウンロードテーブル */
    private Thb1DownVO _thb1Down = null;

    /** 広告費明細テーブルリスト */
    private List<Thb2KmeiVO> _thb2Kmei = null;

    /** ダミープロパティ */
    private String _dummy = null;

    /**
     * 明細区分を取得する
     * @return 明細区分
     */
    public String getKbn() {
        return _kbn;
    }

    /**
     * 明細区分を設定する
     */
    public void setKbn(String _kbn) {
        this._kbn = _kbn;
    }

    /**
     * ダウンロードテーブルを取得する
     * @return ダウンロードテーブル
     */
    public Thb1DownVO getThb1Down() {
        return _thb1Down;
    }

    /**
     * ダウンロードテーブルを設定する
     * @param thb1Down ダウンロードテーブル
     */
    public void setThb1Down(Thb1DownVO thb1Down) {
        this._thb1Down = thb1Down;
    }

    /**
     * 広告費明細テーブルリストを取得する
     * @return 広告費明細テーブルリスト
     */
    public List<Thb2KmeiVO> getThb2Kmei() {
        return _thb2Kmei;
    }

    /**
     * 広告費明細テーブルリストを設定する
     * @param thb2Kmei 広告費明細テーブルリスト
     */
    public void setThb2Kmei(List<Thb2KmeiVO> thb2Kmei) {
        this._thb2Kmei = thb2Kmei;
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

}
