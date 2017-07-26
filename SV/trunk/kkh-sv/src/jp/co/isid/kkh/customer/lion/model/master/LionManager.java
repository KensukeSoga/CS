package jp.co.isid.kkh.customer.lion.model.master;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterDataInsertVO;

/**
 * <P>
 * 汎用マスタ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 *
 * @author JSE K.Fukuda
 */
public class LionManager {

    /** シングルトンインスタンス */
    private static LionManager _manager = new LionManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private LionManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static LionManager getInstance() {
        return _manager;
    }


    /**
     * TV番組マスタ(データ)の削除
     *
     * @param cond 削除条件
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void deleteLionTvMastDataByCondition(LionCondition cond) throws KKHException {

        LionTvMastRegisterDAO dao = LionTvMastRegisterDAOFactory.createTvMastLionRegisterDAO();
        dao.deleteLionDataByCondition(cond);
    }

    /**
     * TV番組マスタ(データ)の登録
     *
     * @param list マスタデータVO（INSERT用）のリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void registerLionTvMast(List<LionTvMastDataInsertVO> list) throws KKHException {

        for (LionTvMastDataInsertVO vo : list) {
            LionTvMastRegisterDAO dao = LionTvMastRegisterDAOFactory.createTvMastLionRegisterDAO();
            dao.registLionTvMastDataVO(vo);
        }
    }

    /**
     * ラジオ番組マスタ(データ)の削除
     *
     * @param cond 削除条件
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void deleteLionRdMastDataByCondition(LionCondition cond) throws KKHException {

        LionRdMastRegisterDAO dao = LionRdMastRegisterDAOFactory.createRdMastLionRegisterDAO();
        dao.deleteLionDataByCondition(cond);
    }

    /**
     * ラジオ番組マスタ(データ)の登録
     *
     * @param list マスタデータVO（INSERT用）のリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void registerLionRdMast(List<LionRdMastDataInsertVO> list) throws KKHException {

        for (LionRdMastDataInsertVO vo : list) {
            LionRdMastRegisterDAO dao = LionRdMastRegisterDAOFactory.createRdMastLionRegisterDAO();
            dao.registLionRdMastDataVO(vo);
        }
    }

    /**
     * TV局マスタ(データ)の削除
     *
     * @param cond 削除条件
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void deleteLionTvKMastDataByCondition(LionCondition cond) throws KKHException {

        LionTvKMastRegisterDAO dao = LionTvKMastRegisterDAOFactory.createTvKMastLionRegisterDAO();
        dao.deleteLionDataByCondition(cond);
    }

    /**
     * TV局マスタ(データ)の登録
     *
     * @param list マスタデータVO（INSERT用）のリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void registerLionTvKMast(List<LionTvKMastDataInsertVO> list) throws KKHException {

        for (LionTvKMastDataInsertVO vo : list) {
            LionTvKMastRegisterDAO dao = LionTvKMastRegisterDAOFactory.createTvKMastLionRegisterDAO();
            dao.registLionTvKMastDataVO(vo);
        }
    }

    /**
     * ラジオ局マスタ(データ)の削除
     *
     * @param cond 削除条件
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void deleteLionRdKMastDataByCondition(LionCondition cond) throws KKHException {

        LionRdKMastRegisterDAO dao = LionRdKMastRegisterDAOFactory.createRdKMastLionRegisterDAO();
        dao.deleteLionDataByCondition(cond);
    }

    /**
     * ラジオ局マスタ(データ)の登録
     *
     * @param list マスタデータVO（INSERT用）のリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void registerLionRdKMast(List<LionRdKMastDataInsertVO> list) throws KKHException {

        for (LionRdKMastDataInsertVO vo : list) {
            LionRdKMastRegisterDAO dao = LionRdKMastRegisterDAOFactory.createRdKMastLionRegisterDAO();
            dao.registLionRdKMastDataVO(vo);
        }
    }

    /**
     * TV番組データを検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public FindTvMastResult findTvMastByCondition(FindTvMastCondition cond) throws KKHException {
        //検索結果
        FindTvMastResult result = new FindTvMastResult();

        //******************************************************
        //TV番組データを取得
        //******************************************************
        FindTvMastDAO findTvMastDAO = FindTvMastDAOFactory.createFindTvMastDAO();

        List<FindTvMastVO> list = findTvMastDAO.findTvMastByCondition(cond);
        result.setFindTvMast(list);

        return result;
    }

    /**
     * ラジオ番組データを検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public FindRdMastResult findRdMastByCondition(FindRdMastCondition cond) throws KKHException {
        //検索結果
        FindRdMastResult result = new FindRdMastResult();

        //******************************************************
        //ラジオ番組データを取得
        //******************************************************
        FindRdMastDAO findRdMastDAO = FindRdMastDAOFactory.createFindRdMastDAO();

        List<FindRdMastVO> list = findRdMastDAO.findRdMastByCondition(cond);
        result.setFindRdMast(list);

        return result;
    }

    /**
     * TV局データを検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public FindTvKMastResult findTvKMastByCondition(FindTvKMastCondition cond) throws KKHException {
        //検索結果
        FindTvKMastResult result = new FindTvKMastResult();

        //******************************************************
        //TV局データを取得
        //******************************************************
        FindTvKMastDAO findTvKMastDAO = FindTvKMastDAOFactory.createFindTvKMastDAO();

        List<FindTvKMastVO> list = findTvKMastDAO.findTvKMastByCondition(cond);
        result.setFindTvKMast(list);

        return result;
    }

    /**
     * ラジオ局データを検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public FindRdKMastResult findRdKMastByCondition(FindRdKMastCondition cond) throws KKHException {
        //検索結果
        FindRdKMastResult result = new FindRdKMastResult();

        //******************************************************
        //ラジオ局データを取得
        //******************************************************
        FindRdKMastDAO findRdKMastDAO = FindRdKMastDAOFactory.createFindRdKMastDAO();

        List<FindRdKMastVO> list = findRdKMastDAO.findRdKMastByCondition(cond);
        result.setFindRdKMast(list);

        return result;
    }

    /**
     * 雑誌料金スペースデータを検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public LionZashiRyoSpcMastResult lionZashiRyoSpcMastByCondition(LionZashiRyoSpcMastCondition cond) throws KKHException {
        //検索結果
        LionZashiRyoSpcMastResult result = new LionZashiRyoSpcMastResult();

        //******************************************************
        //雑誌料金スペースデータを取得
        //******************************************************
        LionZashiRyoSpcMastDAO lionZashiRyoSpcMastDAO = LionZashiRyoSpcMastDAOFactory.createLionZashiRyoSpcMastDAO();

        List<LionZashiRyoSpcMastVO> list = lionZashiRyoSpcMastDAO.lionZashiRyoSpcMastByCondition(cond);
        result.setLionZashiRyoSpcMast(list);

        return result;
    }

    /**
     * 雑誌スペース料金マスタ(データ)の登録
     *
     * @param list マスタデータVO（INSERT用）のリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void insertLionZashiRyoSpcMast(List<MasterDataInsertVO> list) throws KKHException {

        for (MasterDataInsertVO vo : list) {
            UpdateLionZashiRyoSpcMastDAO dao = UpdateLionZashiRyoSpcMastDAOFactory.createUpdateLionZashiRyoSpcMastDAO();
            dao.insertLionZashiRyoSpcMastVO(vo);
        }
    }

    /**
     * 雑誌料金スペースデータを削除します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void deleteLionZashiRyoSpcMastByCondition(UpdateLionZashiRyoSpcMastCondition cond) throws KKHException {

        UpdateLionZashiRyoSpcMastDAO dao = UpdateLionZashiRyoSpcMastDAOFactory.createUpdateLionZashiRyoSpcMastDAO();

        dao.deleteLionZashiRyoSpcMastCondition(cond);
    }

}
