package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTCM01KKH;
import jp.co.isid.kkh.integ.tbl.TBTCM02JUN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class Tcm01KkhDAO extends AbstractRdbDao {

    /** 範囲フラグ：ON */
    private static final String ZHANNIGF_ON = "1";

    /** 範囲フラグ：OFF */
    private static final String ZHANNIGF_OFF = "0";

    /** 受発注登録可フラグ：ON */
    private static final String ZJYUHACHU_ON = "1";

    /** ステータス：正常 */
    private static final String ZSBCH0103_NORMAL = "O";

    /** 公開範囲情報検索条件 */
    private Tcm01KkhCondition _cond;

//    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * デフォルトコンストラクタ。
     */
    public Tcm01KkhDAO() {
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
        sql.append(" " + TBTCM02JUN.ZSBCH0317 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTCM01KKH.TBNAME + ", " + TBTCM02JUN.TBNAME);
        sql.append(" WHERE ");
        sql.append(" ((" + TBTCM01KKH.ZHANNIGF + " = '" + ZHANNIGF_ON + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZSBCH0105 + " = '" + _cond.getHigherOrganizationCode() + "' ) ");
        sql.append(" OR ");
        sql.append(" ( " + TBTCM01KKH.ZHANNIGF + " = '" + ZHANNIGF_OFF + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZSBCH0105 + " = '" + _cond.getOperationNo() + "' )) ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZTOUKYU + " IN ( " + _cond.getGroupCd() + " ) ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZSBCH0110 + " IN ( " + _cond.getTntCd() + " ) ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.DATEFROM + " <= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.DATETO + " >= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZJYUHACHU + " = '" + ZJYUHACHU_ON + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZDELFG + " IS NULL ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.ZSBCH0317 + " = '" + _cond.getCustomerCode() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.DATEFROM + " <= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.DATETO + " >= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.ZSBCH0211 + " <= '" + _cond.getTermBegin() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.ZSBCH0212 + " >= '" + _cond.getTermEnd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.ZSBCH0103 + " = '" + ZSBCH0103_NORMAL + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZSBCH0100 + " = " + TBTCM02JUN.ZSBCH0100);
        sql.append(" AND ROWNUM = 1");

        return sql.toString();
    }

    /**
     * 公開範囲情報の検索を行います。
     *
     * @return 公開範囲情報VOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Tcm01KkhVO> getOpenRange(Tcm01KkhCondition cond) throws KKHException {

        super.setModel(new Tcm01KkhVO());

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
     * @return List<Tcm01KkhVO> 変換後の検索結果
     */
    @Override
    protected List<Tcm01KkhVO> createFindedModelInstances(List hashList) {

        List<Tcm01KkhVO> list = new ArrayList<Tcm01KkhVO>();
        if (getModel() instanceof Tcm01KkhVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                Tcm01KkhVO vo = new Tcm01KkhVO();
                vo.setZsbch0317(StringUtil.trim((String) result.get(TBTCM02JUN.ZSBCH0317.toUpperCase())));
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
