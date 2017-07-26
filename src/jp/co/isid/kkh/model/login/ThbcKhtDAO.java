package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHBCKHT;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class ThbcKhtDAO extends AbstractRdbDao {

    /** 開放得意先管理情報検索条件 */
    private ThbcKhtCondition _cond;

//    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * デフォルトコンストラクタ。
     */
    public ThbcKhtDAO() {
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
        sql.append("  " + TBTHBCKHT.DISFLG + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBCKHT.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBTHBCKHT.EGSCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBCKHT.TKSKGYCD + " = '" + _cond.getKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBCKHT.TKSBMNSEQNO + " = '" + _cond.getBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBCKHT.TKSTNTSEQNO + " = '" + _cond.getTntSeqNo() + "' ");

        return sql.toString();
    }

    /**
     * 開放得意先管理情報の検索を行います。
     *
     * @return 開放得意先管理情報VOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ThbcKhtVO> getOpenCustomerInfo(ThbcKhtCondition cond) throws KKHException {

        super.setModel(new ThbcKhtVO());

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
     * @return List<ThbcKhtVO> 変換後の検索結果
     */
    @Override
    protected List<ThbcKhtVO> createFindedModelInstances(List hashList) {

        List<ThbcKhtVO> list = new ArrayList<ThbcKhtVO>();
        if (getModel() instanceof ThbcKhtVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ThbcKhtVO vo = new ThbcKhtVO();
                vo.setDisFlg(StringUtil.trim((String) result.get(TBTHBCKHT.DISFLG.toUpperCase())));
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
