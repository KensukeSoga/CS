package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 帳票（MAC)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/12 fourm h.izawa)<BR>
 * ・2014上期対応(ライセンシー一覧表示対応)(2014/04/25 HLC S.Fujimoto)<BR>
 * </P>
 * @author fourm h.izawa
 */
public class ReportMacLicenseeDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ検索条件 */
    private ReportMacCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode{KIND,ITEM,};
//    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportMacLicenseeDAO() {
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
//		return new String[]{
//				TBTHB2KMEI.EGCD,
//				TBTHB2KMEI.TKSKGYCD,
//				TBTHB2KMEI.TKSBMNSEQNO,
//				TBTHB2KMEI.TKSTNTSEQNO,
//				TBTHB2KMEI.YYMM,
//				TBTHB2KMEI.JYUTNO,
//				TBTHB2KMEI.JYMEINO,
//				TBTHB2KMEI.URMEINO,
//				TBTHB2KMEI.RENBN
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
                TBTHB2KMEI.SEIGAK,
                TBTHB2KMEI.CODE1,
                TBTHB2KMEI.NAME1,
                TBTHB2KMEI.NAME2,
                TBTHB2KMEI.NAME3,
                TBTHB2KMEI.KNGK1,
                TBTHB2KMEI.KNGK2,
                TBTHB2KMEI.SONOTA1,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.RENBN,
                TBTHBAMST.FIELD4,
                TBTHBAMST.FIELD12,
                TBTHBAMST.FIELD5,
                TBTHBAMST.FIELD6,
                TBTHBAMST.FIELD10,
                TBTHBAMST.FIELD11,
                TBTHBAMST.FIELD20,
                TBTHB2KMEI.SONOTA2
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
        //消費税対応 2013/10/21 add HLC H.Watabe start
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + " * 0.01) AS "+ TBTHB2KMEI.RITU1 + " ");
        //消費税対応 2013/10/21 add HLC H.Watabe end
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ", ");
        //sql.append(" KV_ADM.THB2KMEI, ");
        sql.append(" " + TBTHBAMST.TBNAME + ", ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.SONOTA1 + " != " + "' ' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' " );
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '301' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.FIELD9 + " = '2' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.FIELD1 + " = RTRIM(" + TBTHB2KMEI.CODE1+ ") ");
        //伝票番号のどちらも条件がない場合は全件検索
        if (_cond.getdenfr().equals("") && _cond.getdento().equals(""))
        {}
        //TOが無く、FROMがある場合
        else if (_cond.getdento().equals("")){
            sql.append(" AND " + TBTHB2KMEI.SONOTA1 + " >= '" + _cond.getdenfr()  + "' ");
        }
        //TOが無く、FROMがある場合
        else if (_cond.getdenfr().equals("")){
            sql.append(" AND " +  TBTHB2KMEI.SONOTA1 + " <= '" + _cond.getdento()  + "' ");
        }
        //TO、FROMに両方とも値がある場合
        else {
            sql.append(" AND " + TBTHB2KMEI.SONOTA1 + " BETWEEN '" + _cond.getdenfr()  + "' ");
            sql.append(" AND " + "'" + _cond.getdento()  + "' ");
        }
        sql.append(" ORDER BY ");
        sql.append(TBTHBAMST.FIELD12 + ",");
        sql.append(TBTHB2KMEI.CODE1);

        /* 2014/04/25 ライセンシー一覧表示対応 fujimoto ADD start */
        sql.append(", " + TBTHB2KMEI.SONOTA1);
        sql.append("," + TBTHB2KMEI.JYUTNO);
        sql.append(", " + TBTHB2KMEI.JYMEINO);
        sql.append("," + TBTHB2KMEI.URMEINO);
        /* 2014/04/25 ライセンシー一覧表示対応 fujimoto ADD end */

        return sql.toString();
    }


    /**
     * 帳票データ（MAC)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportMacLicenseeVO> findReportMacByCondition(ReportMacCondition cond) throws KKHException {

        super.setModel(new ReportMacLicenseeVO());

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
