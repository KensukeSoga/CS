package jp.co.isid.kkh.model.history;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 履歴（Lion)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/1 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class HistoryJyutDownVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public HistoryJyutDownVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new HistoryJyutDownVO();
    }

    /**
     * 原票出力タイムスタンプを設定します。
     * @param val String GPSYUTIMSTMP
     */
    public void setGPSYUTIMSTMP(String val){
        set("GPSYUTIMSTMP",val);
    }

    /**
     * 原票出力タイムスタンプを返します。
     * @return String GPSYUTIMSTMP
     */
    public String getGPSYUTIMSTMP(){
        return(String) get("GPSYUTIMSTMP");
    }

    /**
     * 出力区分を設定します。
     * @param val String SYUKBN
     */
    public void setSYUKBN(String val){
        set("SYUKBN",val);
    }

    /**
     * 出力区分を返します。
     * @return String SYUKBN
     */
    public String getSYUKBN(){
        return(String) get("SYUKBN");
    }

    /**
     * 請求年月を設定します。
     * @param val String YYMM
     */
    public void setYYMM(String val){
        set("YYMM",val);
    }

    /**
     * 請求年月を返します。
     * @return String YYMM
     */
    public String getYYMM(){
        return(String) get("YYMM");
    }

    /**
     * 業務区分を設定します。
     * @param val String GYOMKBN
     */
    public void setGYOMKBN(String val){
        set("GYOMKBN",val);
    }

    /**
     * 業務区分を返します。
     * @return String GYOMKBN
     */
    public String getGYOMKBN(){
        return(String) get("GYOMKBN");
    }

    /**
     * 担当者コードを設定します。
     * @param val String TNTCD
     */
    public void setTNTCD(String val){
        set("TNTCD",val);
    }

    /**
     * 担当者コードを返します。
     * @return String TNTCD
     */
    public String getTNTCD(){
        return(String) get("TNTCD");
    }

    /**
     * 担当者名を設定します。
     * @param val String TNTCD
     */
    public void setTNTNM(String val){
        set("TNTNM",val);
    }

    /**
     * 担当者名を返します。
     * @return String TNTCD
     */
    public String getTNTNM(){
        return(String) get("TNTNM");
    }

}
