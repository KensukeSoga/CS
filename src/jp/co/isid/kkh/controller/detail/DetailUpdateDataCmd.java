package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.DetailUpdateDataResult;
import jp.co.isid.kkh.model.detail.DetailUpdateDataVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－表示データ更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class DetailUpdateDataCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 広告費明細表示データ更新処理用VO */
    private DetailUpdateDataVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** executeで実行する処理モード() */
    public enum ExecMode{UPD_DISP,};
    public ExecMode _execSqlMode = ExecMode.UPD_DISP;

    /**
     * 広告費明細表示データ更新処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        if (_execSqlMode.equals(ExecMode.UPD_DISP)){
            // マスタデータの登録
            DetailUpdateDataResult result = manager.updateDisplayData(_vo);
            // 正常終了
            getResult().set(RESULT_KEY, result);
        }

//        throw new KKHException("");
    }

    /**
     * プランデータ登録VOを設定します。
     *
     * @param vo DetailUpdateDataVO プランデータ登録VO
     */
    public void setDetailUpdateDataVO(DetailUpdateDataVO vo) {
        _vo = vo;
    }

    /**
     * 登録後のプランデータを返します。
     *
     * @return UpdateDisplayDataResult 登録後のプランデータ
     */
    public DetailUpdateDataResult getUpdateDisplayDataResult() {
        return (DetailUpdateDataResult) super.getResult().get(RESULT_KEY);
    }

}
