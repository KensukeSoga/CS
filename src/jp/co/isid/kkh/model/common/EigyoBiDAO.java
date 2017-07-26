package jp.co.isid.kkh.model.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTKJ99KNR;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 汎用マスタ検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class EigyoBiDAO extends AbstractRdbDao {

//    /**汎用マスタ検索条件 */
//    private EigyoBiCondition _cond;

//    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode{COND,};
//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * デフォルトコンストラクタ。
     */
    public EigyoBiDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        //new String[] {};
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return TBTKJ99KNR.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
        };
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTKJ99KNR.EIGYOBI + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTKJ99KNR.TBNAME + " ");
        //Where句
        sql.append(" WHERE ");
        sql.append(" " + TBTKJ99KNR.SYSTEMID + " = 'HB' ");
        sql.append(" AND ");
        sql.append(" " + TBTKJ99KNR.SYSTEMNO + " = '02' ");

        return sql.toString();
    }


    /**
     * 汎用テーブルマスタの検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<EigyoBiVO> getEigyoBi(EigyoBiCondition cond) throws KKHException {

        super.setModel(new EigyoBiVO());

        try {
//            _cond = cond;
//            _sqlMode = SqlMode.COND;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<EigyoBiMasterVO> 変換後の検索結果
     */
    @Override
    protected List<EigyoBiVO> createFindedModelInstances(List hashList) {
        List<EigyoBiVO> list = new ArrayList<EigyoBiVO>();
        if (getModel() instanceof EigyoBiVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                EigyoBiVO vo = new EigyoBiVO();
                vo.setEigyoBi((String)result.get(TBTKJ99KNR.EIGYOBI.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
