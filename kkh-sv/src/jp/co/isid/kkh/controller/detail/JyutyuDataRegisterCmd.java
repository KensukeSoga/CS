package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.JyutyuDataRegisterResult;
import jp.co.isid.kkh.model.detail.JyutyuDataRegisterVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細入力－新規登録
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/08 JSE K.Fukuda)<BR>
 * </P>
 *
 * @author
 */
public class JyutyuDataRegisterCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 新規登録VO */
    private JyutyuDataRegisterVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 新規登録処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        // マスタデータの登録
        JyutyuDataRegisterResult result = manager.registerJyutyuData(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * 請求年月変更VOを設定します。
     *
     * @param vo JyutyuDataRegisterVO 請求年月変更VO
     */
    public void setJyutyuDataRegisterVO(JyutyuDataRegisterVO vo) {
        _vo = vo;
    }

    /**
     * 請求年月変更処理結果を返します。
     *
     * @return JyutyuDataRegisterVOResult 請求年月変更処理結果
     */
    public JyutyuDataRegisterResult getJyutyuDataRegisterResult() {
        return (JyutyuDataRegisterResult) super.getResult().get(RESULT_KEY);
    }

}
