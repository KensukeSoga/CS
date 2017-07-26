package jp.co.isid.kkh.model.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHBBSYS;
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
 * ・新規作成(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class CommonDAO extends AbstractRdbDao {

    /**汎用マスタ検索条件 */
    private CommonCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public CommonDAO() {
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
        return TBTHBBSYS.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHBBSYS.TRKTIMSTMP
                ,TBTHBBSYS.TRKPL
                ,TBTHBBSYS.TRKTNT
                ,TBTHBBSYS.UPDTIMSTMP
                ,TBTHBBSYS.UPDAPL
                ,TBTHBBSYS.UPDTNT
                ,TBTHBBSYS.EGCD
                ,TBTHBBSYS.TKSKGYCD
                ,TBTHBBSYS.TKSBMNSEQNO
                ,TBTHBBSYS.TKSTNTSEQNO
                ,TBTHBBSYS.SYBT
                ,TBTHBBSYS.FIELD1
                ,TBTHBBSYS.FIELD2
                ,TBTHBBSYS.FIELD3
                ,TBTHBBSYS.FIELD4
                ,TBTHBBSYS.FIELD5
                ,TBTHBBSYS.FIELD6
                ,TBTHBBSYS.FIELD7
                ,TBTHBBSYS.FIELD8
                ,TBTHBBSYS.FIELD9
                ,TBTHBBSYS.FIELD10
        };
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
            return getSelectSQLForCommon();
    }


    private String getSelectSQLForCommon(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBBSYS.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHBBSYS.TRKPL + " ");
        sql.append(" ," + TBTHBBSYS.TRKTNT + " ");
        sql.append(" ," + TBTHBBSYS.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHBBSYS.UPDAPL + " ");
        sql.append(" ," + TBTHBBSYS.UPDTNT + " ");
        sql.append(" ," + TBTHBBSYS.EGCD + " ");
        sql.append(" ," + TBTHBBSYS.TKSKGYCD + " ");
        sql.append(" ," + TBTHBBSYS.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHBBSYS.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHBBSYS.SYBT + " ");
        sql.append(" ," + TBTHBBSYS.FIELD1 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD2 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD3 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD4 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD5 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD6 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD7 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD8 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD9 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD10 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBBSYS.TBNAME + " ");

        //Where句
        sql.append(" WHERE ");
        sql.append(" " + TBTHBBSYS.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBBSYS.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBBSYS.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBBSYS.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBBSYS.SYBT + " = '" + _cond.getSybt() + "' ");

        //マスタキー
        if (_cond.getfield1() != null && !_cond.getfield1().equals("")){
            sql.append(" AND ");
            sql.append(" " + TBTHBBSYS.FIELD1 + " = '" + _cond.getfield1() + "' ");
        }

        return sql.toString();
    }

    /**
     * 汎用テーブルマスタの検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<CommonVO> findCommonByCondition(CommonCondition cond) throws KKHException {

        super.setModel(new CommonVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "KV-E0001");
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
    protected List<CommonVO> createFindedModelInstances(List hashList) {
        List<CommonVO> list = new ArrayList<CommonVO>();
        if (getModel() instanceof CommonVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                CommonVO vo = new CommonVO();
                vo.setTrkTimStmp((Date)result.get(TBTHBBSYS.TRKTIMSTMP.toUpperCase()));
                vo.setTrkPl((String)result.get(TBTHBBSYS.TRKPL.toUpperCase()));
                vo.setTrkTnt((String)result.get(TBTHBBSYS.TRKTNT.toUpperCase()));
                vo.setUpdTimStmp((Date)result.get(TBTHBBSYS.UPDTIMSTMP.toUpperCase()));
                vo.setUpdaPl((String)result.get(TBTHBBSYS.UPDAPL.toUpperCase()));
                vo.setUpdTnt((String)result.get(TBTHBBSYS.UPDTNT   .toUpperCase()));
                vo.setEgCd((String)result.get(TBTHBBSYS.EGCD.toUpperCase()));
                vo.setTksKgyCd((String)result.get(TBTHBBSYS.TKSKGYCD.toUpperCase()));
                vo.setTksBmnSeqNo((String)result.get(TBTHBBSYS.TKSBMNSEQNO.toUpperCase()));
                vo.setTksTntSeqNo((String)result.get(TBTHBBSYS.TKSTNTSEQNO.toUpperCase()));
                vo.setSybt((String)result.get(TBTHBBSYS.SYBT.toUpperCase()));
                vo.setField1((String)result.get(TBTHBBSYS.FIELD1.toUpperCase()));
                vo.setField2((String)result.get(TBTHBBSYS.FIELD2.toUpperCase()));
                vo.setField3((String)result.get(TBTHBBSYS.FIELD3.toUpperCase()));
                vo.setField4((String)result.get(TBTHBBSYS.FIELD4.toUpperCase()));
                vo.setField5((String)result.get(TBTHBBSYS.FIELD5.toUpperCase()));
                vo.setField6((String)result.get(TBTHBBSYS.FIELD6.toUpperCase()));
                vo.setField7((String)result.get(TBTHBBSYS.FIELD7.toUpperCase()));
                vo.setField8((String)result.get(TBTHBBSYS.FIELD8.toUpperCase()));
                vo.setField9((String)result.get(TBTHBBSYS.FIELD9.toUpperCase()));
                vo.setField10((String)result.get(TBTHBBSYS.FIELD10.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
