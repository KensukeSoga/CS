package jp.co.isid.kkh.customer.epson.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
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
 * 広告費明細検索(Epson)DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/5 IP.Shimizu)<BR>
 * </P>
 * @author
 */
public class DetailDataEpsonDAO extends AbstractRdbDao {

    /**受注データ検索条件 */
    private DetailDataEpsonCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode{DTL, BCD, BCDMST, };
//    private SqlMode _sqlMode = SqlMode.DTL;

    /**
     * デフォルトコンストラクタ。
     */
    public DetailDataEpsonDAO() {
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
        return "";
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
        StringBuffer sql = new StringBuffer();

        if (_cond.getKbn().equals("1")) {

            // =================================================================================================================================================================
            // SELECT句
            // =================================================================================================================================================================
            sql.append(" SELECT ");
            sql.append("     " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TIMSTMP + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.UPDAPL + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.UPDTNT + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HIMKCD + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RENBN + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATEFROM + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATETO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SEIGAK + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HNNERT + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HNMAEGAK + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NEBIGAK + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KBN1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KBN2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KBN3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME7 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME8 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME9 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME10 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME11 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME12 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME13 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME14 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME15 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME16 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME17 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME18 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME19 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME20 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME21 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME22 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME23 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME24 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME25 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME26 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME27 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME28 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME29 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME30 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KNGK1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KNGK2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KNGK3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RITU1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RITU2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA7 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA8 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA9 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA10 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.BUNFLG + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.MEIHNFLG + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NEBHNFLG + " ");
            // =================================================================================================================================================================
            // FROM句
            // =================================================================================================================================================================
            sql.append(" FROM ");
            sql.append("     " + TBTHB2KMEI.TBNAME + " ");
            // =================================================================================================================================================================
            // WHERE句
            // =================================================================================================================================================================
            sql.append(" WHERE ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME21 + " = '1' ");
            // =================================================================================================================================================================
            // Order句
            // =================================================================================================================================================================
            sql.append(" ORDER BY ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RENBN + " ");
        } else if (_cond.getKbn().equals("2")) {

            // 同一の請求書番号を全て取消した場合のみ自動で明細を表示しなくする対応
            //
            // 請求回収データの取消が走るタイミングを広告費側で制御できないため、
            // 受注番号＋受注明細番号＋売上明細番号による紐付けでは、
            // 紐付けを行った明細のみをピンポイントに取消した場合に、
            // 同じ請求書番号を持つデータが残っていても明細を取得できなくなる。
            // よって請求回収データとは請求番号で紐付けを行い
            // DISTINCTで一行にまとめるように対応する。

            // =================================================================================================================================================================
            // SELECT句
            // =================================================================================================================================================================
            sql.append(" SELECT DISTINCT");
            sql.append("     " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TIMSTMP + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.UPDAPL + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.UPDTNT + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HIMKCD + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RENBN + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATEFROM + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATETO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SEIGAK + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HNNERT + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HNMAEGAK + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NEBIGAK + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KBN1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KBN2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KBN3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME7 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME8 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME9 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME10 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME11 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME12 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME13 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME14 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME15 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME16 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME17 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME18 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME19 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME20 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME21 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME22 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME23 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME24 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME25 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME26 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME27 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME28 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME29 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME30 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KNGK1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KNGK2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KNGK3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RITU1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RITU2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA7 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA8 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA9 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA10 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.BUNFLG + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.MEIHNFLG + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NEBHNFLG + " ");
            // =================================================================================================================================================================
            // FROM句
            // =================================================================================================================================================================
            sql.append(" FROM ");
            sql.append("     " + TBTHB2KMEI.TBNAME + " ");
            sql.append("    ," + TBTHB14SKDOWN.TBNAME + " ");
            // =================================================================================================================================================================
            // WHERE句
            // =================================================================================================================================================================
            sql.append(" WHERE ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME21 + " = '2' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.EGCD + " = " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD + " ");
            sql.append(" AND ");
            sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSKGYCD + " = " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD + " ");
            sql.append(" AND ");
            sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO + " ");
            sql.append(" AND ");
            sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO + " ");
            sql.append(" AND ");
            sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEINO + " = " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA1 + " ");
            sql.append(" AND ");
            sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIYYMM + " = " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + " ");
            sql.append(" AND ");
//			sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEISTATUS + " = '2' ");
            sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEISTATUS + " IN ('2','3') ");
            // =================================================================================================================================================================
            // Order句
            // =================================================================================================================================================================
            sql.append(" ORDER BY ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA1 + " ");
        }

        return sql.toString();
    }

    /**
     * 広告費明細データの検索を行います。
     *
     * @return 広告費明細データVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<DetailDataFindEpsonVO> findDetailDataByCondition(DetailDataEpsonCondition cond) throws KKHException {

        super.setModel(new DetailDataFindEpsonVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<DetailDataVO> 変換後の検索結果
     */
    @Override
    @SuppressWarnings("unchecked")
    //protected List<DetailDataVO> createFindedModelInstances(List hashList) {
    protected List createFindedModelInstances(List hashList) {

        List list = null;

        list = new ArrayList<DetailDataFindEpsonVO>();
        for (int i = 0; i < hashList.size(); i++) {
            Map result = (Map) hashList.get(i);
            DetailDataFindEpsonVO vo = new DetailDataFindEpsonVO();

            vo.setHb2TimStmp((Date)result.get(TBTHB2KMEI.TIMSTMP.toUpperCase()));
            vo.setHb2UpdApl((String)result.get(TBTHB2KMEI.UPDAPL.toUpperCase()));
            vo.setHb2UpdTnt((String)result.get(TBTHB2KMEI.UPDTNT.toUpperCase()));
            vo.setHb2EgCd((String)result.get(TBTHB2KMEI.EGCD.toUpperCase()));
            vo.setHb2TksKgyCd((String)result.get(TBTHB2KMEI.TKSKGYCD.toUpperCase()));
            vo.setHb2TksBmnSeqNo((String)result.get(TBTHB2KMEI.TKSBMNSEQNO.toUpperCase()));
            vo.setHb2TksTntSeqNo((String)result.get(TBTHB2KMEI.TKSTNTSEQNO.toUpperCase()));
            vo.setHb2Yymm((String)result.get(TBTHB2KMEI.YYMM.toUpperCase()));
            vo.setHb2JyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
            vo.setHb2JyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
            vo.setHb2UrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
            vo.setHb2HimkCd((String)result.get(TBTHB2KMEI.HIMKCD.toUpperCase()));
            vo.setHb2Renbn((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
            vo.setHb2DateFrom((String)result.get(TBTHB2KMEI.DATEFROM.toUpperCase()));
            vo.setHb2DateTo((String)result.get(TBTHB2KMEI.DATETO.toUpperCase()));
            vo.setHb2SeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
            vo.setHb2Hnnert((BigDecimal)result.get(TBTHB2KMEI.HNNERT.toUpperCase()));
            vo.setHb2HnmaeGak((BigDecimal)result.get(TBTHB2KMEI.HNMAEGAK.toUpperCase()));
            vo.setHb2NebiGak((BigDecimal)result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));
            vo.setHb2Date1((String)result.get(TBTHB2KMEI.DATE1.toUpperCase()));
            vo.setHb2Date2((String)result.get(TBTHB2KMEI.DATE2.toUpperCase()));
            vo.setHb2Date3((String)result.get(TBTHB2KMEI.DATE3.toUpperCase()));
            vo.setHb2Date4((String)result.get(TBTHB2KMEI.DATE4.toUpperCase()));
            vo.setHb2Date5((String)result.get(TBTHB2KMEI.DATE5.toUpperCase()));
            vo.setHb2Date6((String)result.get(TBTHB2KMEI.DATE6.toUpperCase()));
            vo.setHb2Kbn1((String)result.get(TBTHB2KMEI.KBN1.toUpperCase()));
            vo.setHb2Kbn2((String)result.get(TBTHB2KMEI.KBN2.toUpperCase()));
            vo.setHb2Kbn3((String)result.get(TBTHB2KMEI.KBN3.toUpperCase()));
            vo.setHb2Code1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
            vo.setHb2Code2((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
            vo.setHb2Code3((String)result.get(TBTHB2KMEI.CODE3.toUpperCase()));
            vo.setHb2Code4((String)result.get(TBTHB2KMEI.CODE4.toUpperCase()));
            vo.setHb2Code5((String)result.get(TBTHB2KMEI.CODE5.toUpperCase()));
            vo.setHb2Code6((String)result.get(TBTHB2KMEI.CODE6.toUpperCase()));
            vo.setHb2Name1((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
            vo.setHb2Name2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
            vo.setHb2Name3((String)result.get(TBTHB2KMEI.NAME3.toUpperCase()));
            vo.setHb2Name4((String)result.get(TBTHB2KMEI.NAME4.toUpperCase()));
            vo.setHb2Name5((String)result.get(TBTHB2KMEI.NAME5.toUpperCase()));
            vo.setHb2Name6((String)result.get(TBTHB2KMEI.NAME6.toUpperCase()));
            vo.setHb2Name7((String)result.get(TBTHB2KMEI.NAME7.toUpperCase()));
            vo.setHb2Name8((String)result.get(TBTHB2KMEI.NAME8.toUpperCase()));
            vo.setHb2Name9((String)result.get(TBTHB2KMEI.NAME9.toUpperCase()));
            vo.setHb2Name10((String)result.get(TBTHB2KMEI.NAME10.toUpperCase()));
            vo.setHb2Name11((String)result.get(TBTHB2KMEI.NAME11.toUpperCase()));
            vo.setHb2Name12((String)result.get(TBTHB2KMEI.NAME12.toUpperCase()));
            vo.setHb2Name13((String)result.get(TBTHB2KMEI.NAME13.toUpperCase()));
            vo.setHb2Name14((String)result.get(TBTHB2KMEI.NAME14.toUpperCase()));
            vo.setHb2Name15((String)result.get(TBTHB2KMEI.NAME15.toUpperCase()));
            vo.setHb2Name16((String)result.get(TBTHB2KMEI.NAME16.toUpperCase()));
            vo.setHb2Name17((String)result.get(TBTHB2KMEI.NAME17.toUpperCase()));
            vo.setHb2Name18((String)result.get(TBTHB2KMEI.NAME18.toUpperCase()));
            vo.setHb2Name19((String)result.get(TBTHB2KMEI.NAME19.toUpperCase()));
            vo.setHb2Name20((String)result.get(TBTHB2KMEI.NAME20.toUpperCase()));
            vo.setHb2Name21((String)result.get(TBTHB2KMEI.NAME21.toUpperCase()));
            vo.setHb2Name22((String)result.get(TBTHB2KMEI.NAME22.toUpperCase()));
            vo.setHb2Name23((String)result.get(TBTHB2KMEI.NAME23.toUpperCase()));
            vo.setHb2Name24((String)result.get(TBTHB2KMEI.NAME24.toUpperCase()));
            vo.setHb2Name25((String)result.get(TBTHB2KMEI.NAME25.toUpperCase()));
            vo.setHb2Name26((String)result.get(TBTHB2KMEI.NAME26.toUpperCase()));
            vo.setHb2Name27((String)result.get(TBTHB2KMEI.NAME27.toUpperCase()));
            vo.setHb2Name28((String)result.get(TBTHB2KMEI.NAME28.toUpperCase()));
            vo.setHb2Name29((String)result.get(TBTHB2KMEI.NAME29.toUpperCase()));
            vo.setHb2Name30((String)result.get(TBTHB2KMEI.NAME30.toUpperCase()));
            vo.setHb2Kngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
            vo.setHb2Kngk2((BigDecimal)result.get(TBTHB2KMEI.KNGK2.toUpperCase()));
            vo.setHb2Kngk3((BigDecimal)result.get(TBTHB2KMEI.KNGK3.toUpperCase()));
            vo.setHb2Ritu1((BigDecimal)result.get(TBTHB2KMEI.RITU1.toUpperCase()));
            vo.setHb2Ritu2((BigDecimal)result.get(TBTHB2KMEI.RITU2.toUpperCase()));
            vo.setHb2Sonota1((String)result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));
            vo.setHb2Sonota2((String)result.get(TBTHB2KMEI.SONOTA2.toUpperCase()));
            vo.setHb2Sonota3((String)result.get(TBTHB2KMEI.SONOTA3.toUpperCase()));
            vo.setHb2Sonota4((String)result.get(TBTHB2KMEI.SONOTA4.toUpperCase()));
            vo.setHb2Sonota5((String)result.get(TBTHB2KMEI.SONOTA5.toUpperCase()));
            vo.setHb2Sonota6((String)result.get(TBTHB2KMEI.SONOTA6.toUpperCase()));
            vo.setHb2Sonota7((String)result.get(TBTHB2KMEI.SONOTA7.toUpperCase()));
            vo.setHb2Sonota8((String)result.get(TBTHB2KMEI.SONOTA8.toUpperCase()));
            vo.setHb2Sonota9((String)result.get(TBTHB2KMEI.SONOTA9.toUpperCase()));
            vo.setHb2Sonota10((String)result.get(TBTHB2KMEI.SONOTA10.toUpperCase()));
            vo.setHb2BunFlg((String)result.get(TBTHB2KMEI.BUNFLG.toUpperCase()));
            vo.setHb2MeihnFlg((String)result.get(TBTHB2KMEI.MEIHNFLG.toUpperCase()));
            vo.setHb2NebhnFlg((String)result.get(TBTHB2KMEI.NEBHNFLG.toUpperCase()));

            // 検索結果直後の状態にする
            ModelUtils.copyMemberSearchAfterInstace(vo);
            list.add(vo);
        }

        return list;
    }

}
