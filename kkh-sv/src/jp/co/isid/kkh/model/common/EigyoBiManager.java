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
public class EigyoBiManager {

    /** シングルトンインスタンス */
    private static EigyoBiManager _manager = new EigyoBiManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private EigyoBiManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static EigyoBiManager getInstance() {
        return _manager;
    }

    /**
     * 汎用マスタ(データ)を検索します。
     *
     * @return MasterResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public EigyoBiResult getEigyoBi(EigyoBiCondition cond) throws KKHException {

        //検索結果
        EigyoBiResult result = new EigyoBiResult();
        EigyoBiDAO dao = EigyoBiDAOFactory.createEigyoBiDAO();

        //******************************************************
        //営業日取得
        //******************************************************
        List<EigyoBiVO> voList = dao.getEigyoBi(cond);
        if (voList.size() > 0){
            result.setEigyoBi(voList.get(0).getEigyoBi());
        }

        return result;
    }

}
