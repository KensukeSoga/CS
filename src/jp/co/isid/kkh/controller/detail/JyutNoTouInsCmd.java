package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.JyutNoTouInsManager;
import jp.co.isid.kkh.model.detail.JyutNoTouInsResult;
import jp.co.isid.kkh.model.detail.JyutNoTouInsVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－受注No統合
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/28 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class JyutNoTouInsCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 広告費明細表示データ更新処理用VO */
    private JyutNoTouInsVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 広告費明細表示データ更新処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        JyutNoTouInsManager manager = JyutNoTouInsManager.getInstance();

        // 実施NOのUP/DOWNの登録
        manager.jyutNoTouInsDateData(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, new JyutNoTouInsResult());

//        throw new KKHException("");
    }

    /**
     * プランデータ登録VOを設定します。
     *
     * @param vo DetailUpdateDataVO プランデータ登録VO
     */
    public void setJyutNoTouUpdateVO(JyutNoTouInsVO vo) {
        _vo = vo;
    }

    /**
     * 登録後のプランデータを返します。
     *
     * @return JyutNoTouInsResult 登録後のプランデータ
     */
    public JyutNoTouInsResult getJyutNoTouInsdateResult() {
        return (JyutNoTouInsResult) super.getResult().get(RESULT_KEY);
    }

}
