package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU12THSKGY;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU13THSKGYBMON;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class RcmnMeu12ThskgyDAO extends AbstractRdbDao {

    /** 終了年月最大値 */
    private static final String ENDYMD_MAX = "99999999";

    /** 取引先情報検索条件 */
    private RcmnMeu12ThskgyCondition _cond;

//    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * デフォルトコンストラクタ。
     */
    public RcmnMeu12ThskgyDAO() {
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
        sql.append("  " + TBRCMN_MEU12THSKGY.THSKGYDISPKJ + " ");
        sql.append(" ," + TBRCMN_MEU13THSKGYBMON.SUBMEI + " ");
        sql.append(" FROM ");
        sql.append(" " + TBRCMN_MEU12THSKGY.TBNAME + ", " + TBRCMN_MEU13THSKGYBMON.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBRCMN_MEU13THSKGYBMON.THSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU13THSKGYBMON.SEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU13THSKGYBMON.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU12THSKGY.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU12THSKGY.THSKGYCD + " = " + TBRCMN_MEU13THSKGYBMON.THSKGYCD);

        return sql.toString();
    }

    /**
     * 取引先情報の検索を行います。
     *
     * @return 取引先情報VOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<RcmnMeu12ThskgyVO> getCustomerInfo(RcmnMeu12ThskgyCondition cond) throws KKHException {

        super.setModel(new RcmnMeu12ThskgyVO());

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
     * @return List<RcmnMeu12ThskgyVO> 変換後の検索結果
     */
    @Override
    protected List<RcmnMeu12ThskgyVO> createFindedModelInstances(List hashList) {

        List<RcmnMeu12ThskgyVO> list = new ArrayList<RcmnMeu12ThskgyVO>();
        if (getModel() instanceof RcmnMeu12ThskgyVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                RcmnMeu12ThskgyVO vo = new RcmnMeu12ThskgyVO();
                vo.setThskgyDispKj(StringUtil.trim((String) result.get(TBRCMN_MEU12THSKGY.THSKGYDISPKJ.toUpperCase())));
                vo.setSubMei(StringUtil.trim((String) result.get(TBRCMN_MEU13THSKGYBMON.SUBMEI.toUpperCase())));
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
