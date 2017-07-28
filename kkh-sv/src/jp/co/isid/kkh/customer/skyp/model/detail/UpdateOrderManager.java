package jp.co.isid.kkh.customer.skyp.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class UpdateOrderManager {

    /** シングルトンインスタンス */
    private static UpdateOrderManager _manager = new UpdateOrderManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private UpdateOrderManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static UpdateOrderManager getInstance() {
        return _manager;
    }

    /**
     * 並び順の更新を行います。
     *
     * @return UpdateOrderResult 並び順更新結果
     * @throws KKHException
     *             処理中にエラーが発生した場合
     */
    public UpdateOrderResult updateThb2KmeiForOrder(UpdateOrderVO vo)
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
        if (vo.getYymm() == null || vo.getYymm().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (vo.getOrder() == null) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (vo.getBaitaiNm() == null) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (vo.getBaitaiKbn() == null) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        // 更新結果保持用
        UpdateOrderResult result = new UpdateOrderResult();

        // ******************************************************
        // 並び順情報更新
        // ******************************************************
        UpdateOrderDAO dao = UpdateOrderDAOFactory.createUpdateOrderDAO();

        int count = 0;
        for (int i = 0; i < vo.getOrder().length; i++) {
        	//明細テーブルを更新
            count += dao.updateThb2KmeiForOrder(vo, i);
        }

        //更新件数をセット
        result.setCount(count);

        //受注テーブルを更新
        dao.updateThb1DownForOrder(vo);

        return result;
    }

}
