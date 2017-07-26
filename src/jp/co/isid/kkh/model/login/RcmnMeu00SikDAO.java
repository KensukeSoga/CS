package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU00SIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class RcmnMeu00SikDAO extends AbstractRdbDao {

    /** 組織マスタ検索条件 */
    private RcmnMeu00SikCondition _cond;

//    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * デフォルトコンストラクタ。
     */
    public RcmnMeu00SikDAO() {
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
        sql.append(" " + TBRCMN_MEU00SIK.EGSYOCD + " ");
        sql.append(" ," + TBRCMN_MEU00SIK.JSIKCD + " ");
        sql.append(" ," + TBRCMN_MEU00SIK.KAISOCD + " ");
        sql.append(" FROM ");
        sql.append(" " + TBRCMN_MEU00SIK.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBRCMN_MEU00SIK.SIKCD + " = '" + _cond.getOperationNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU00SIK.STARTYMD + " <= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU00SIK.ENDYMD + " >= '" + _cond.getEigyoBi() + "' ");

        return sql.toString();
    }

    /**
     * 組織マスタの検索を行います。
     *
     * @return 組織マスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<RcmnMeu00SikVO> getBusinessOfficeInfo(RcmnMeu00SikCondition cond) throws KKHException {

        super.setModel(new RcmnMeu00SikVO());

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
     * @return List<RcmnMeu00SikVO> 変換後の検索結果
     */
    @Override
    protected List<RcmnMeu00SikVO> createFindedModelInstances(List hashList) {

        List<RcmnMeu00SikVO> list = new ArrayList<RcmnMeu00SikVO>();
        if (getModel() instanceof RcmnMeu00SikVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                RcmnMeu00SikVO vo = new RcmnMeu00SikVO();
                vo.setEgsyoCd(StringUtil.trim((String) result.get(TBRCMN_MEU00SIK.EGSYOCD.toUpperCase())));
                vo.setJSikCd(StringUtil.trim((String) result.get(TBRCMN_MEU00SIK.JSIKCD.toUpperCase())));
                vo.setKaisoCd(StringUtil.trim((String) result.get(TBRCMN_MEU00SIK.KAISOCD.toUpperCase())));
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
