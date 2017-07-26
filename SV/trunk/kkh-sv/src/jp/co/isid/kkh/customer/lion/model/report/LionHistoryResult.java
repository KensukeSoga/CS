package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 * <P>
 * ライオン履歴結果
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 S.Fujimoto)<BR>
 * </P>
 * @author HLC S.Fujimoto
 */
public class LionHistoryResult extends AbstractServiceResult {

    /** ライオン履歴データ取得VOリスト */
    private List<LionHistoryVO> _vo;

    /** ListだけではWebサービスに公開されないのでダミープロパティを追加 */
    private String _dummy;

    /**
     * ライオン履歴データ取得VOリストを取得
     * @return ライオン履歴データ取得VOリスト
     */
    public List<LionHistoryVO> getFindLionHistoryInfo() {
        return _vo;
    }

    /**
     * ライオン履歴データ取得VOリストを設定
     * @param val List<LionHistoryVO> ライオン履歴データ取得VO
     */
    public void setFindLionHistoryInfo(List<LionHistoryVO> val) {
        _vo = val;
    }

    /**
     * ダミープロパティを取得
     * @return String ダミー
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * ダミープロパティを設定
     * @param val String ダミー
     */
    public void setDummy(String val) {
        _dummy = val;
    }

 }
