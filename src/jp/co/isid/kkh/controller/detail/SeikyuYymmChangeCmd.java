package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.SeikyuYymmChangeResult;
import jp.co.isid.kkh.model.detail.SeikyuYymmChangeVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－請求年月変更
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/05 JSE K.Fukuda)<BR>
 * </P>
 *
 * @author
 */
public class SeikyuYymmChangeCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 請求年月変更処理用VO */
    private SeikyuYymmChangeVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 請求年月変更処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        // マスタデータの登録
        SeikyuYymmChangeResult result = manager.changeSeikyuYymm(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * 請求年月変更VOを設定します。
     *
     * @param vo SeikyuYymmChangeVO 請求年月変更VO
     */
    public void setSeikyuYymmChangeVO(SeikyuYymmChangeVO vo) {
        _vo = vo;
    }

    /**
     * 請求年月変更処理結果を返します。
     *
     * @return SeikyuYymmChangeResult 請求年月変更処理結果
     */
    public SeikyuYymmChangeResult getSeikyuYymmChangeResult() {
        return (SeikyuYymmChangeResult) super.getResult().get(RESULT_KEY);
    }

}
