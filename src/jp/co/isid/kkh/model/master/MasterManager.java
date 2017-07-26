package jp.co.isid.kkh.model.master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class MasterManager {

    /** シングルトンインスタンス */
    private static MasterManager _manager = new MasterManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private MasterManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static MasterManager getInstance() {
        return _manager;
    }

    /**
     * 汎用マスタ(データ)を検索します。
     *
     * @return MasterResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public MasterResult findByCondition(MasterCondition cond) throws KKHException {

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
        if (cond.getMasterKey() == null || cond.getMasterKey().equals("")){
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        //検索結果
        MasterResult result = new MasterResult();
        //検索条件(マスタ種類設定・項目設定取得用)
        MasterCondition lCond = new MasterCondition();
        //検索条件(マスタデータ取得用)
        MasterDataCondition lDataCond = new MasterDataCondition();

        MasterDAO dao = MasterDAOFactory.createMasterDAO();
        MasterDataDAO dataDao = MasterDataDAOFactory.createMasterDataDAO();

        //******************************************************
        //マスタ種類設定を取得
        //******************************************************
        lCond = cond;
        List<MasterVO> kindList = dao.findMasterKindByCondition(lCond);

        MasterVO masterKindVO = kindList.get(0);

        //マスタ項目設定・マスタデータ検索条件設定
        lCond = cond;
        lDataCond.setEsqId(cond.getEsqId());
        lDataCond.setEgCd(cond.getEgCd());
        lDataCond.setTksKgyCd(cond.getTksKgyCd());
        lDataCond.setTksBmnSeqNo(cond.getTksBmnSeqNo());
        lDataCond.setTksTntSeqNo(cond.getTksTntSeqNo());
        lDataCond.setMasterKey(cond.getMasterKey());
        //lDataCond.setFilterKey(cond.getFilterKey());
        lDataCond.setFilterValue(cond.getFilterValue());
        lDataCond.setFilterKey(masterKindVO.getField5());



        List<MasterDataVO> dataList = new ArrayList<MasterDataVO>();
        for (int i = 0; i < kindList.size(); i++){
            //******************************************************
            //マスタ項目設定を取得
            //******************************************************
            lCond.setMasterKey(kindList.get(i).getField3());
            List<MasterVO> itemList = new ArrayList<MasterVO>();
            itemList = dao.findMasterItemByCondition(lCond);

            //******************************************************
            //マスタデータを取得
            //******************************************************
            //検索条件設定
            lDataCond.setSybt(kindList.get(i).getField2());               //マスタ種類設定の種別を条件に設定
            String[] sortKeys = kindList.get(i).getField4().split(",");
            List<String> sortKeyList = new ArrayList<String>();
            for(int j = 0; j < sortKeys.length; j++){
                sortKeyList.add(sortKeys[j]);
            }
            lDataCond.setSortKey(sortKeyList);                            //マスタ種類設定のソートカラムを条件に設定
            List<String> selectColList = new ArrayList<String>();
            for(int j = 0; j < itemList.size(); j++){
                selectColList.add(itemList.get(j).getField4());
            }
            lDataCond.setSelectColumns(selectColList);                    //マスタ項目設定のカラム名を条件に設定
            dataList.addAll(dataDao.findMasterDataByCondition(lDataCond));
        }

        result.setMasterData(dataList);

        return result;
    }


    /**
     * 汎用マスタ(種類・項目)を検索します。
     *
     * @return MasterResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public MasterResult findMasterDefineByCondition(MasterCondition cond) throws KKHException {

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

        //検索結果
        MasterResult result = new MasterResult();
        //検索条件(マスタ種類設定・項目設定取得用)
        MasterCondition lCond = new MasterCondition();

        MasterDAO dao = MasterDAOFactory.createMasterDAO();

        //******************************************************
        //マスタ種類設定を取得
        //******************************************************
        lCond = cond;
        List<MasterVO> kindList = dao.findMasterKindByCondition(lCond);
        result.setMasterKind(kindList);

        //******************************************************
        //マスタ項目設定を取得
        //******************************************************
        lCond = cond;
        List<MasterVO> itemList = new ArrayList<MasterVO>();

        if(lCond.get_Itemfiltervalue() != null && !lCond.get_Itemfiltervalue().equals(""))
        {
            List<MasterVO> MerelyItemList = new ArrayList<MasterVO>();
            MerelyItemList = dao.findMasterItemByCondition(lCond);
            result.setMasterItem(MerelyItemList);
        }else
        {
            for (int i = 0; i < kindList.size(); i++){
                lCond.setMasterKey(kindList.get(i).getField3());            //マスタ種類設定のマスタキーを条件として設定
                List<MasterVO> tempItemList = new ArrayList<MasterVO>();
                tempItemList = dao.findMasterItemByCondition(lCond);
                itemList.addAll(tempItemList);
            }
            result.setMasterItem(itemList);
        }


        return result;
    }

    /**
     * 汎用マスタ（データ）の更新タイムスタンプ（最大値）の取得
     *
     * @param cond 検索条件
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public Date findMasterUpdTimStmpMaxByCondition(MasterDataCondition cond) throws KKHException {

        MasterDataDAO dataDao = MasterDataDAOFactory.createMasterDataDAO();
        List<MasterDataVO> dataVOList = dataDao.findMasterUpdTimStmpMaxByCondition(cond);
        MasterDataVO vo = dataVOList.get(0);
        return vo.getUpdTimStmp();
        //        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//
//        if(vo != null){
//	        try {
//				Date day = format.parse(vo.getUpdTimStmp().toString());
//				return day;
//	        } catch (ParseException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//			}
//        }


    }

    /**
     * 汎用マスタ(データ)の削除
     *
     * @param cond 削除条件
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void deleteMasterDataByCondition(MasterCondition cond) throws KKHException {

        MasterRegisterDAO dao = MasterRegisterDAOFactory.createMasterRegisterDAO();
        dao.deleteMasterDataByCondition(cond);
    }

    /**
     * 汎用マスタ(データ)の登録
     *
     * @param list マスタデータVO（INSERT用）のリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void registerMaster(List<MasterDataInsertVO> list) throws KKHException {

        for (MasterDataInsertVO vo : list) {
            MasterRegisterDAO dao = MasterRegisterDAOFactory.createMasterRegisterDAO();
            dao.registMasterDataVO(vo);
        }

    }


}
