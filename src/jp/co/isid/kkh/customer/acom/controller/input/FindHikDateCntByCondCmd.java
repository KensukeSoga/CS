package jp.co.isid.kkh.customer.acom.controller.input;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.input.HikManager;
import jp.co.isid.kkh.customer.acom.model.input.HikSearchDateCntVOList;
import jp.co.isid.kkh.customer.acom.model.input.HikSearchResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 発注データ検索コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/01 HLC J.Mrobayashi)<BR>
 * </P>
 * @author HLC J.Mrobayashi
 */
public class FindHikDateCntByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 日付データ検索用VO */
    private HikSearchDateCntVOList _volist;

    /**
     * 検索条件を使用し、検索処理を実行します。
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {
        HikManager manager = HikManager.getInstance();
        HikSearchResult result = manager.findDateCntByVoList(_volist);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 日付データ検索用VOを設定します。
     * @param volist HikSearchDateCntVOList 日付データ検索用VO
     */
    public void setHikSearchDateCntVO(HikSearchDateCntVOList volist) {
        _volist = volist;
    }

    /**
     * 条件検索結果を返します。
     * @return HikSearchResult 条件検索結果
     */
    public HikSearchResult getHikSearchResult() {
        return (HikSearchResult) super.getResult().get(RESULT_KEY);
    }

}
