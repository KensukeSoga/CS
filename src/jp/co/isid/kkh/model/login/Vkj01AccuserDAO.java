package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.VWACCUSER;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class Vkj01AccuserDAO extends AbstractRdbDao {

    /** 個人情報VIEW検索条件 */
    private Vkj01AccuserCondition _cond;

//    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * デフォルトコンストラクタ。
     */
    public Vkj01AccuserDAO() {
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
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return "";
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[] {};
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
        sql.append(" " + VWACCUSER.OGNZUNTCD + " ");
        sql.append(" FROM ");
        sql.append(" " + VWACCUSER.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + VWACCUSER.ESQID + " = '" + _cond.getEsqId() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWACCUSER.SIKOGNZUNTCD + " = '" + _cond.getOperationNo() + "' ");

        return sql.toString();
    }

    /**
     * 個人情報VIEWの検索を行います。
     *
     * @return 個人情報VOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Vkj01AccuserVO> getPersonalInfo(Vkj01AccuserCondition cond) throws KKHException {

        super.setModel(new Vkj01AccuserVO());

        try {
            _cond = cond;
//            _sqlMode = SqlMode.COND;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "HB-E0001");
        }

    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<Vkj01AccuserVO> 変換後の検索結果
     */
    @Override
    protected List<Vkj01AccuserVO> createFindedModelInstances(List hashList) {

        List<Vkj01AccuserVO> list = new ArrayList<Vkj01AccuserVO>();
        if (getModel() instanceof Vkj01AccuserVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                Vkj01AccuserVO vo = new Vkj01AccuserVO();
                vo.setOgnzuntCd(StringUtil.trim((String) result.get(VWACCUSER.OGNZUNTCD.toUpperCase())));
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
