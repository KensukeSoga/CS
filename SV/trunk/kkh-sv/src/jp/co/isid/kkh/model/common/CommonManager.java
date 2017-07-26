package jp.co.isid.kkh.model.common;

import java.util.*;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 汎用マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class CommonManager {

    /** シングルトンインスタンス */
    private static CommonManager _manager = new CommonManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private CommonManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static CommonManager getInstance() {
        return _manager;
    }

    /**
     * 汎用マスタ(種類・項目)を検索します。
     *
     * @return MasterResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public CommonResult findCommonByCondition(CommonCondition cond) throws KKHException {

        //パラメータの必須チェック
        if (cond.getEsqId()== null || cond.getEsqId().equals("")){
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getEgCd() == null || cond.getEgCd().equals("")){
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")){
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")){
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")){
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getSybt() == null || cond.getSybt().equals("")){
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        //検索結果
        CommonResult result = new CommonResult();
        //検索条件(マスタ種類設定・項目設定取得用)
        CommonCondition lCond = new CommonCondition();

        CommonDAO dao = CommonDAOFactory.createCommonDAO();

        //******************************************************
        //マスタ種類設定を取得
        //******************************************************
        lCond = cond;
        List<CommonVO> CommonList = dao.findCommonByCondition(lCond);
        result.setCommon(CommonList);

        return result;
    }

}
