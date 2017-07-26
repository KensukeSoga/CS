package jp.co.isid.kkh.customer.lion.model.master;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class LionZashiRyoSpcMastDAO extends AbstractRdbDao  {

    /** ラジオ局マスタ検索条件 */
    private LionZashiRyoSpcMastCondition _cond;

    //種別//////////////////////////////////////////////////////////////////////////////////////////////////
    /** 汎用マスタ：種別：雑誌 */
    public static final String C_HBAMST_SYBT_ZASHI =  LionConstants.MastBaitaiShubetsu.ZASHI.getCode();
    /** 汎用マスタ：種別：雑誌スペース */
    public static final String C_HBAMST_SYBT_ZASHI_SPACE =  LionConstants.MastBaitaiShubetsu.ZASHI_SPACE.getCode();
    /** 汎用マスタ：種別：料金 */
    public static final String C_HBAMST_SYBT_ZASHI_RYOKIN =  LionConstants.MastBaitaiShubetsu.ZASHI_RYOKIN.getCode();
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * デフォルトコンストラクタ。
     */
    public LionZashiRyoSpcMastDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
    @Override
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
    @Override
    public String getTableName() {
        return TBTHBAMST.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  ZSPACE." + TBTHBAMST.FIELD1 + " AS VAL1 ");
        sql.append(" , ' ' AS VAL2 , 0 AS VAL3 ");
        sql.append(" FROM ");
        sql.append("  " + TBTHBAMST.TBNAME + " ZSPACE ");
        sql.append(" WHERE ");
        sql.append(" ZSPACE." + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(" ZSPACE." + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(" ZSPACE." + TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append(" ZSPACE." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_SPACE + "' AND ");
        sql.append(" ZSPACE." + TBTHBAMST.FIELD1 + " ");
        sql.append(" NOT IN(SELECT ");
        sql.append(" RYOKIN." + TBTHBAMST.FIELD2 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHBAMST.TBNAME + " RYOKIN ");
        sql.append(" WHERE ");
        sql.append(" RYOKIN." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_RYOKIN + "' AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append(" RYOKIN." + TBTHBAMST.FIELD1 + " = '" + _cond.getCd() + "') ");
        sql.append(" UNION SELECT ");
        sql.append("  RYOKIN." + TBTHBAMST.FIELD2 + " AS VAL1 ");
        sql.append(" ,RYOKIN." + TBTHBAMST.FIELD3 + " AS VAL2 ");
        sql.append(" ,RYOKIN." + TBTHBAMST.INTVALUE1 + " AS VAL3 ");
        sql.append(" FROM ");
        sql.append("  " + TBTHBAMST.TBNAME + " RYOKIN, " + TBTHBAMST.TBNAME + " ZSPACE ");
        sql.append(" WHERE ");
        sql.append(" ZSPACE." + TBTHBAMST.FIELD1 + " = " + "RYOKIN." + TBTHBAMST.FIELD2 + " AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append(" ZSPACE." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_SPACE + "' AND ");
        sql.append(" RYOKIN." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_RYOKIN + "' AND ");
        sql.append(" RYOKIN." + TBTHBAMST.FIELD1 + " = '" + _cond.getCd() + "'  ");

        return sql.toString();
    }

    /**
     * ラジオ局マスタの検索を行います。
     *
     * @return テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<LionZashiRyoSpcMastVO> lionZashiRyoSpcMastByCondition(LionZashiRyoSpcMastCondition cond) throws KKHException {

        super.setModel(new LionZashiRyoSpcMastVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<LionZashiRyoSpcMastVO> createFindedModelInstances(List hashList) {
        List<LionZashiRyoSpcMastVO> list = new ArrayList<LionZashiRyoSpcMastVO>();
        if (getModel() instanceof LionZashiRyoSpcMastVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                LionZashiRyoSpcMastVO vo = new LionZashiRyoSpcMastVO();

                //マスタ１～3まで動的
                vo.setVal1((String)result.get(LionZashiRyoSpcMastVO.VAL1.toUpperCase()));
                vo.setVal2((String)result.get(LionZashiRyoSpcMastVO.VAL2.toUpperCase()));
                vo.setVal3((BigDecimal) result.get(LionZashiRyoSpcMastVO.VAL3));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
