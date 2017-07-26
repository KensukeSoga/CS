package jp.co.isid.kkh.customer.mac.model.master;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB17RMTNP;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRByCondCondition;

/**
 *
 * <P>
 * マクドナルド店舗マスタ履歴テーブルキー項目取得DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 *
 * @author
 */
public class FindMasterMacTnpRKeyByCondDAO extends AbstractRdbDao {

    /** データ検索条件 */
    private FindMasterMacTnpRByCondCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public FindMasterMacTnpRKeyByCondDAO() {
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
        return TBTHB17RMTNP.TBNAME;
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

        return getSelectSQLMacTnpRKey();
    }

    /**
     * マクドナルド店舗マスタ履歴テーブルを検索
     *
     * @param cond 更新条件
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    @SuppressWarnings("unchecked")
    public List<FindMasterMacTnpRKeyByCondVO> findthb17rmtnp(FindMasterMacTnpRByCondCondition cond) throws KKHException {

        super.setModel(new FindMasterMacTnpRKeyByCondVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ＳＱＬ生成
     */
    public String getSelectSQLMacTnpRKey()
    {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " ");
        sql.append(",MAX(" + TBTHB17RMTNP.TORIKOMIFLG + ") HB17_TORIKOMIFLG");
        sql.append(" FROM ");
        sql.append(" " + TBTHB17RMTNP.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB17RMTNP.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB17RMTNP.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB17RMTNP.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB17RMTNP.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" GROUP BY ");
        sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " ");
        sql.append(" ORDER BY ");
        sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " DESC ");

        return sql.toString();
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList
     *            List 検索結果
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<FindMasterMacTnpRKeyByCondVO> createFindedModelInstances(List hashList) {
        List<FindMasterMacTnpRKeyByCondVO> list = new ArrayList<FindMasterMacTnpRKeyByCondVO>();
        if (getModel() instanceof FindMasterMacTnpRKeyByCondVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindMasterMacTnpRKeyByCondVO vo = new FindMasterMacTnpRKeyByCondVO();

                vo.setUpdRrkTimstmp((String)result.get(TBTHB17RMTNP.UPDRRKTIMSTMP.toUpperCase()));
                vo.setTorikomiFlg((String)result.get(TBTHB17RMTNP.TORIKOMIFLG.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
