package jp.co.isid.kkh.model.history;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB3RRK;

import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 履歴（Lion)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/2/1 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class HistoryJyutDownDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ検索条件 */
    private HistoryJyutDownCondition _cond;

//    /* getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode{KIND,ITEM,};
//    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public HistoryJyutDownDAO() {
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
//		};
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
    @Override
    public String getTableName() {
        return TBTHB2KMEI.TBNAME;
    }


    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                "TRIM("+ TBTHB3RRK.GPSYUTIMSTMP +") AS GPSYUTIMSTMP",
                "TRIM("+ TBTHB3RRK.SYUKBN + ") AS SYUKBN",
                "TRIM("+ TBTHB3RRK.YYMM + ") AS YYMM",
                "TRIM("+ TBTHB3RRK.GYOMKBN + ") AS GYOMKBN",
                "TRIM("+ TBTHB3RRK.TNTCD + ") AS TNTCD",
                "TRIM("+ TBTHB3RRK.TNTNM + ") AS TNTNM"
        };
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
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append("  " + getTableColumnNames()[i] + " ");
            }else{
                sql.append(" ," + getTableColumnNames()[i] + " ");
            }
        }
        sql.append(" FROM ");
        sql.append(" " + TBTHB3RRK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB3RRK.YYMM + " LIKE '" + _cond.get_yymm() + "%' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB3RRK.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB3RRK.TKSBMNSEQNO + " = '" + _cond.get_tksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB3RRK.TKSTNTSEQNO+ " = '" + _cond.get_tksTntSeqNo() + "' ");
        sql.append(" ORDER BY ");
        sql.append(" " + TBTHB3RRK.GPSYUTIMSTMP + " DESC ");

        return sql.toString();
    }

    /**
     * 帳票データ（MAC)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<HistoryJyutDownVO> findReportMacByCondition(HistoryJyutDownCondition cond) throws KKHException {

        super.setModel(new HistoryJyutDownVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

//    /**
//     * Modelの生成を行う<br>
//     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
//     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
//     *
//     * @param hashList List 検索結果
//     * @return List<CommonCodeMasterVO> 変換後の検索結果
//     */
//    @Override
//    @SuppressWarnings("unchecked")
//    protected List<ReportMacVO> createFindedModelInstances(List hashList) {
//        List<ReportMacVO> list = new ArrayList<ReportMacVO>();
//        if (getModel() instanceof ReportMacVO) {
//            for (int i = 0; i < hashList.size(); i++) {
//                Map result = (Map) hashList.get(i);
//                ReportMacVO vo = new ReportMacVO();
//                vo.setSeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
//                vo.setDate1((String)result.get(TBTHB2KMEI.DATE1.toUpperCase()));
//                vo.setKbn1((String)result.get(TBTHB2KMEI.KBN1.toUpperCase()));
//                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
//                vo.setCode2((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
//                vo.setCode4((String)result.get(TBTHB2KMEI.CODE4.toUpperCase()));
//                vo.setName1((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
//                vo.setName2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
//                vo.setName3((String)result.get(TBTHB2KMEI.NAME3.toUpperCase()));
//                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
//                vo.setKngk2((BigDecimal)result.get(TBTHB2KMEI.KNGK2.toUpperCase()));
//                vo.setSonota1((String)result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));
//                vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
//                vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
//                vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
//                vo.setRenbn((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
//                vo.setSonota2((String)result.get(TBTHB2KMEI.SONOTA2.toUpperCase()));
//                // 検索結果直後の状態にする
//                ModelUtils.copyMemberSearchAfterInstace(vo);
//                list.add(vo);
//            }
//        }
//        return list;
//    }

}
