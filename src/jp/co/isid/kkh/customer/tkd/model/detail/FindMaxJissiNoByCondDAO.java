package jp.co.isid.kkh.customer.tkd.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 実施No最大値取得DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/9 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindMaxJissiNoByCondDAO extends AbstractRdbDao {

    /** データ検索条件 */
    private FindMaxJissiNoCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public FindMaxJissiNoByCondDAO() {
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
        // new String[] {};
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[] { TBTHB2KMEI.KNGK1 };
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {

        return getSelectSQLForMaxjissiNo();
    }

    /**
     * 実施No最大値取得のSQL文を返します。
     *
     * @return String SQL文
     */
    private String getSelectSQLForMaxjissiNo() {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("     NVL(MAX(HB2_KNGK1),0) AS " + TBTHB2KMEI.KNGK1);
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' ");

        return sql.toString();
    }

    /**
     * 実施Noの最大値の検索を行います。
     *
     * @return 実施Noの最大値を含むVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindMaxJissiNoCondVO> findMaxjissiNoByCondition(FindMaxJissiNoCondition cond)
            throws KKHException {

        super.setModel(new FindMaxJissiNoCondVO());

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
     * @return List<FindMaxJissiNoCondVO> 変換後の検索結果
     */
    @Override
    protected List<FindMaxJissiNoCondVO> createFindedModelInstances(List hashList) {

        List<FindMaxJissiNoCondVO> list = new ArrayList<FindMaxJissiNoCondVO>();

        if (getModel() instanceof FindMaxJissiNoCondVO) {

            for (int i = 0; i < hashList.size(); i++) {

                Map result = (Map) hashList.get(i);
                FindMaxJissiNoCondVO vo = new FindMaxJissiNoCondVO();

                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}