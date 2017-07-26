package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ライオン履歴データ検索結果VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class LionHistoryVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** 履歴タイムスタンプ */
    public static final String RRKTIMSTMP = "RRKTIMSTMP";

    /**
     * 新規インスタンスを構築します。
     */
    public LionHistoryVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new LionHistoryVO();
    }

    /**
     * 履歴タイムスタンプを取得する
     * @return 履歴タイムスタンプ
     */
    public String getRrkTimStmp() {
        return (String) get(RRKTIMSTMP);
    }

    /**
     * 履歴タイムスタンプを設定する
     * @param val String 履歴タイムスタンプ
     */
    public void setRrkTimStmp(String val) {
        set(RRKTIMSTMP, val);
    }

}