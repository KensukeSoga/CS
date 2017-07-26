package jp.co.isid.kkh.model.common;

import java.util.*;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 汎用マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class CommonCodeMasterManager {

    /** シングルトンインスタンス */
    private static CommonCodeMasterManager _manager = new CommonCodeMasterManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private CommonCodeMasterManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static CommonCodeMasterManager getInstance() {
        return _manager;
    }

    /**
     * 汎用マスタ(データ)を検索します。
     *
     * @return MasterResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public CommonCodeMasterResult findByCondition(CommonCodeMasterCondition cond) throws KKHException {

        //検索結果
        CommonCodeMasterResult result = new CommonCodeMasterResult();
        CommonCodeMasterDAO dao = CommonCodeMasterDAOFactory.createMasterDAO();

        //******************************************************
        //共通コードマスタ検索
        //******************************************************
        List<CommonCodeMasterVO> voList = dao.findCommonCodeMasterByCondition(cond);
        result.setCommonCodeMaster(voList);

        return result;
    }

}
