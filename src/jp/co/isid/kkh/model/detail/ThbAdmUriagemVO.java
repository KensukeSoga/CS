package jp.co.isid.kkh.model.detail;

import jp.co.isid.kkh.integ.tbl.VWTHB_ADMURIAGEM;
import jp.co.isid.nj.model.AbstractModel;

public class ThbAdmUriagemVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ThbAdmUriagemVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ThbAdmUriagemVO();
    }

    /**
     * RESULTKEYを返します。
     * @return RESULTKEY
     */
    public String getResultKey() {
        return (String) get("RESULTKEY");
    }

    /**
     * RESULTKEYを設定します。
     * @param val RESULTKEY
     */
    public void setResultKey(String val) {
        set("RESULTKEY", val);
    }

    /**
     * 請求状態を取得する
     * @return 請求状態
     */
    public String getSeikJtai() {
        return (String) get(VWTHB_ADMURIAGEM.SEIKJTAI);
    }

    /**
     * 請求状態を設定する
     * @param val 請求状態
     */
    public void setSeikJtai(String val) {
        set(VWTHB_ADMURIAGEM.SEIKJTAI, val);
    }

    /**
     * 請求作業ステータスを取得する
     * @return 請求作業ステータス
     */
    public String getSeiSagSts() {
        return (String) get(VWTHB_ADMURIAGEM.SEISAGSTS);
    }

    /**
     * 請求作業ステータスを設定する
     * @param val 請求作業ステータス
     */
    public void setSeiSagSts(String val) {
        set(VWTHB_ADMURIAGEM.SEISAGSTS, val);
    }

    /**
     * 中止区分を取得する
     * @return 中止区分
     */
    public String getStpKbn() {
        return (String) get(VWTHB_ADMURIAGEM.STPKBN);
    }

    /**
     * 中止区分を設定する
     * @param val 中止区分
     */
    public void setStpKbn(String val) {
        set(VWTHB_ADMURIAGEM.STPKBN, val);
    }

}
