package jp.co.isid.kkh.customer.acom.controller.input;

import jp.co.isid.kkh.customer.acom.model.input.HikManager;
import jp.co.isid.kkh.customer.acom.model.input.HikRegistVOList;
import jp.co.isid.kkh.customer.acom.model.input.HikSearchResult;
import jp.co.isid.nj.controller.command.Command;
import jp.co.isid.nj.controller.command.transaction.ManualTransaction;
import jp.co.isid.nj.exp.UserException;

/**
 * <P>発注情報(比較用)の検索コマンド</P>
 *
 * <P>
 * 発注情報XSD全般　検索コマンドクラス。
 * </P>
 *
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成（2011/11/28 HLC J.Morobayashi>
 * </P>
 *
 * @author  HLC J.Morobayashia
 * @since  14 November 2011
 */
public class FindHikCheckDataByCondCmd extends Command implements ManualTransaction {

    private static final long serialVersionUID = 1L;

    /** 検索結果キー */
    private static final String RESULT_KEY = "ESULT_KEY";

    /** 検索条件 */
    private HikRegistVOList _volist;

    /**
     * デフォルトコンストラクタ。
     * 引数ありのコンストラクタを定義したので、
     * 引数なしのコンストラクタも明示的に定義しなければならなくなりました。
     */
    public FindHikCheckDataByCondCmd() {
    }

    /**
     * 実行
     * @throws UserException
     */
    public void execute() throws UserException {
        HikManager manager = HikManager.getInstance();
        HikSearchResult result = manager.findCheckDataByVoList(_volist);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索情報を設定します。
     * @param volist HikRegistVOList 検索情報
     */
    public void setHikRegistVOList(HikRegistVOList volist) {
        _volist = volist;
    }

    /**
     * 検索後の発注データを返します。
     * @return HikSearchResult 条件検索結果
     */
    public HikSearchResult getHikSearchResult() {
        return (HikSearchResult) super.getResult().get(RESULT_KEY);
    }

}
