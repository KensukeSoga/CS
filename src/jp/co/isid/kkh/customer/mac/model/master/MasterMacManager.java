package jp.co.isid.kkh.customer.mac.model.master;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;

/**
 * <P>
 * 汎用マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/27 IP Shimizu)<BR>
 * </P>
 * @author
 */
public class MasterMacManager {

    /** シングルトンインスタンス */
    private static MasterMacManager _manager = new MasterMacManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private MasterMacManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static MasterMacManager getInstance() {
        return _manager;
    }

//    /**
//     * 汎用マスタ（データ）の更新タイムスタンプ（最大値）の取得
//     *
//     * @param cond 検索条件
//     * @throws KKHException 処理中にエラーが発生した場合
//     */
//    public Date findMasterUpdTimStmpMaxByCondition(MasterDataCondition cond) throws KKHException {
//
//        MasterDataDAO dataDao = MasterDataDAOFactory.createMasterDataDAO();
//        List<MasterDataVO> dataVOList = dataDao.findMasterUpdTimStmpMaxByCondition(cond);
//        MasterDataVO vo = dataVOList.get(0);
//        return vo.getUpdTimStmp();
//        //        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
////
////        if(vo != null){
////	        try {
////				Date day = format.parse(vo.getUpdTimStmp().toString());
////				return day;
////	        } catch (ParseException e) {
////				// TODO 自動生成された catch ブロック
////				e.printStackTrace();
////			}
////        }
//
//
//    }
//
//    /**
//     * 汎用マスタ(データ)の削除
//     *
//     * @param cond 削除条件
//     * @throws KKHException 処理中にエラーが発生した場合
//     */
//    public void deleteMasterDataByCondition(MasterCondition cond) throws KKHException {
//
//        MasterRegisterDAO dao = MasterRegisterDAOFactory.createMasterRegisterDAO();
//        dao.deleteMasterDataByCondition(cond);
//    }

    /**
     * 汎用マスタ(データ)の登録
     *
     * @param list マスタデータVO（INSERT用）のリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void registerMaster(List<MasterMacDataInsertVO> list) throws KKHException {

        for (MasterMacDataInsertVO vo : list) {
            MasterMacRegisterDAO dao = MasterMacRegisterDAOFactory.createMasterRegisterDAO();
            dao.registMasterDataVO(vo);
        }
    }

    /**
     * 汎用マスタ(データ)の更新（日付の一括更新）
     *
     * @param cond 更新条件
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void updateMasterMacByConditon(MasterCondition cond) throws KKHException {
            MasterMacRegisterDAO dao = MasterMacRegisterDAOFactory.createMasterRegisterDAO();
            dao.updateMasterMacDataByCondition(cond);
    }

}
