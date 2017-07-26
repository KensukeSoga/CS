package jp.co.isid.kkh.model.master;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 汎用マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/03 Fourm H.izawa)<BR>
 * </P>
 * @author
 */
public class MasterItemManager {

    /** シングルトンインスタンス */
    private static MasterItemManager _manager = new MasterItemManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private MasterItemManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static MasterItemManager getInstance() {
        return _manager;
    }




    /**
     * 汎用マスタ(種類・項目)を検索します。
     *
     * @return MasterResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public MasterItemResult findMasterDefineByCondition(MasterCondition cond) throws KKHException {


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

        //検索結果
        MasterItemResult result = new MasterItemResult();
        MasterItemDAO dao = MasterItemDAOFactory.createMasterItemDAO();
        List<MasterVO> list = dao.findMasterKindByCondition(cond);
        result.setMasterItem(list);



        return result;
    }




}
