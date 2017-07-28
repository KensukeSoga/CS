package jp.co.isid.kkh.controller.log;

import jp.co.isid.kkh.model.log.LogManager;
import jp.co.isid.kkh.model.log.LogResult;
import jp.co.isid.kkh.model.log.LogVO;

import jp.co.isid.nj.controller.command.Command;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>汎用ログの登録コマンド</P>
 *
 * <P>
 * 汎用ログ　登録コマンドクラス。
 * </P>
 *
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成（2011/11/14 IP H.Shimizu>
 * </P>
 *
 * @author  IP H.Shimizu
 * @since  14 November 2011
 */
public class LogRegistCmd extends Command  {

    private static final long serialVersionUID = 1L;

    /** 登録結果キー */
    private static final String RESULT_KEY = "ESULT_KEY";

    /** 登録条件 */
    private LogVO _volist;

    /**
     * デフォルトコンストラクタ。
     * 引数ありのコンストラクタを定義したので、
     * 引数なしのコンストラクタも明示的に定義しなければならなくなりました。
     */
    public LogRegistCmd() {
    }

    /**
     * 実行
     * @throws UserException
     */
    public void execute() throws KKHException {
        LogManager manager = LogManager.getInstance();
        manager.registLog(_volist);
    }

    /**
     * 登録情報を設定します。
     *
     * @param volist RegistLogVO 登録情報
     */
    public void setRegistLogVO(LogVO volist) {
        _volist = volist;
    }

    /**
     * ログ登録結果を返します。
     *
     * @return LogResult 条件検索結果
     */
    public LogResult getLogRegisterResult() {
        return (LogResult) super.getResult().get(RESULT_KEY);
    }

}
