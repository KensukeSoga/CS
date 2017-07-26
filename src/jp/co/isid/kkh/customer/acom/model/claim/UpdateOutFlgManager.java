package jp.co.isid.kkh.customer.acom.model.claim;

import jp.co.isid.kkh.model.base.KKHException;

public class UpdateOutFlgManager {

    /** シングルトンインスタンス */
    private static UpdateOutFlgManager _manager = new UpdateOutFlgManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private UpdateOutFlgManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static UpdateOutFlgManager getInstance() {
        return _manager;
    }

    /**
     * 送信フラグの更新を行います。
     *
     * @return UpdateOutFlgResult 送信フラグ更新結果
     * @throws KKHException
     *             処理中にエラーが発生した場合
     */
    public UpdateOutFlgResult updateThb2KmeiForOutFlg(UpdateOutFlgVO vo)
            throws KKHException {

        // パラメータの必須チェック
        if (vo.getEgCd() == null || vo.getEgCd().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (vo.getTksKgyCd() == null || vo.getTksKgyCd().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (vo.getTksBmnSeqNo() == null || vo.getTksBmnSeqNo().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (vo.getTksTntSeqNo() == null || vo.getTksTntSeqNo().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (vo.getJyutNo() == null) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (vo.getJyMeiNo() == null) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (vo.getUrMeiNo() == null) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (vo.getRenban() == null) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        // 更新結果保持用
        UpdateOutFlgResult result = new UpdateOutFlgResult();

        // ******************************************************
        // 送信フラグ更新
        // ******************************************************
        UpdateOutFlgDAO dao = UpdateOutFlgDAOFactory.createUpdateOutFlgDAO();

        int count = 0;
        for (int i = 0; i < vo.getJyutNo().length; i++) {
            count += dao.updateThb2KmeiForOutFlg(vo, i);
        }

        result.setCount(count);
        return result;
    }

}
