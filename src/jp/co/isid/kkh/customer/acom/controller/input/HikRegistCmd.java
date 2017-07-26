package jp.co.isid.kkh.customer.acom.controller.input;

import jp.co.isid.kkh.customer.acom.model.input.HikManager;
import jp.co.isid.kkh.customer.acom.model.input.HikRegistResult;
import jp.co.isid.kkh.customer.acom.model.input.HikRegistVOList;
import jp.co.isid.nj.controller.command.Command;
import jp.co.isid.nj.exp.UserException;


/**
 * <P>発注情報全般の登録コマンド</P>
 *
 * <P>
 * 発注情報XSD全般　登録コマンドクラス。
 * </P>
 *
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成（2011/12/09 HLC J.Morobayashi>
 * </P>
 *
 * @author  HLC J.Morobayashia
 * @since  09 December 2011
 */
public class HikRegistCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 登録結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 発注データVOリスト */
    private HikRegistVOList _volist;

    /**
     * デフォルトコンストラクタ。
     * 引数ありのコンストラクタを定義したので、
     * 引数なしのコンストラクタも明示的に定義しなければならなくなりました。
     */
    public HikRegistCmd() {
    }

    /**
     * 実行
     * @throws UserException
     */
    public void execute() throws UserException {
        HikManager manager = HikManager.getInstance();
        manager.registHik(_volist);
        getResult().set(RESULT_KEY , new HikRegistResult());
    }

    /**
     * 発注データVOリストを設定します。
     * @param volist HikRegistVOList 発注データVOリスト
     */
    public void setHikRegistVO(HikRegistVOList volist) {
        _volist = volist;
    }

    /**
     * 登録後の発注データを返します。
     * @return HikRegistResult 条件検索結果
     */
    public HikRegistResult getHikRegistResult() {
        return (HikRegistResult) super.getResult().get(RESULT_KEY );
    }

}
