package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU07SIKKRSPRD;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class RcmnMeu07SikkrsprdDAO extends AbstractRdbDao {

    /** 経理組織展開情報検索条件 */
    private RcmnMeu07SikkrsprdCondition _cond;

//    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * デフォルトコンストラクタ。
     */
    public RcmnMeu07SikkrsprdDAO() {
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
        sql.append(" /*+ ordered */ ");
        sql.append("  " + TBRCMN_MEU07SIKKRSPRD.SIKCDKYK + " ");
        sql.append(" FROM ");
        sql.append(" " + TBRCMN_MEU07SIKKRSPRD.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBRCMN_MEU07SIKKRSPRD.SIKCD + " = '" + _cond.getHigherOrganizationCode() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU07SIKKRSPRD.EGSYOCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" '" + _cond.getEigyoBi() + "' BETWEEN " +  TBRCMN_MEU07SIKKRSPRD.STARTYMD + " AND " + TBRCMN_MEU07SIKKRSPRD.ENDYMD);

        return sql.toString();
    }

    /**
     * 経理組織展開情報の検索を行います。
     *
     * @return 経理組織展開情報VOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<RcmnMeu07SikkrsprdVO> getAccountingOrganizationInfo(RcmnMeu07SikkrsprdCondition cond) throws KKHException {

        super.setModel(new RcmnMeu07SikkrsprdVO());

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
     * @return List<RcmnMeu07SikkrsprdVO> 変換後の検索結果
     */
    @Override
    protected List<RcmnMeu07SikkrsprdVO> createFindedModelInstances(List hashList) {

        List<RcmnMeu07SikkrsprdVO> list = new ArrayList<RcmnMeu07SikkrsprdVO>();
        if (getModel() instanceof RcmnMeu07SikkrsprdVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                RcmnMeu07SikkrsprdVO vo = new RcmnMeu07SikkrsprdVO();
                vo.setSikCdKyk(StringUtil.trim((String) result.get(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK.toUpperCase())));
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
