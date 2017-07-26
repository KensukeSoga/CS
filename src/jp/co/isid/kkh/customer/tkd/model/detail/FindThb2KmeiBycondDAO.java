package jp.co.isid.kkh.customer.tkd.model.detail;


import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;
import jp.co.isid.kkh.util.constants.KKHConstants.GyomKbn;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 実施No更新用明細データ取得DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class FindThb2KmeiBycondDAO extends AbstractSimpleRdbDao  {

    private Thb2KmeiVO _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public FindThb2KmeiBycondDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{COMMON, CREATIVE};
    private SqlMode _sqlMode = SqlMode.COMMON;


    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
    @Override
    public String[] getPrimryKeyNames() {
        // TODO 自動生成されたメソッド・スタブ
        return new String[]{
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.RENBN
        };
    }

    /**
     * システム日付で更新する列の定義です
     */
    @Override
    protected String[] getSystemDateColumnNames() {
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
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB2KMEI.TIMSTMP,
                TBTHB2KMEI.UPDAPL,
                TBTHB2KMEI.UPDTNT,
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.HIMKCD,
                TBTHB2KMEI.RENBN,
                TBTHB2KMEI.DATEFROM,
                TBTHB2KMEI.DATETO,
                TBTHB2KMEI.SEIGAK,
                TBTHB2KMEI.HNNERT,
                TBTHB2KMEI.HNMAEGAK,
                TBTHB2KMEI.NEBIGAK,
                TBTHB2KMEI.DATE1,
                TBTHB2KMEI.DATE2,
                TBTHB2KMEI.DATE3,
                TBTHB2KMEI.DATE4,
                TBTHB2KMEI.DATE5,
                TBTHB2KMEI.DATE6,
                TBTHB2KMEI.KBN1,
                TBTHB2KMEI.KBN2,
                TBTHB2KMEI.KBN3,
                TBTHB2KMEI.CODE1,
                TBTHB2KMEI.CODE2,
                TBTHB2KMEI.CODE3,
                TBTHB2KMEI.CODE4,
                TBTHB2KMEI.CODE5,
                TBTHB2KMEI.CODE6,
                TBTHB2KMEI.NAME1,
                TBTHB2KMEI.NAME2,
                TBTHB2KMEI.NAME3,
                TBTHB2KMEI.NAME4,
                TBTHB2KMEI.NAME5,
                TBTHB2KMEI.NAME6,
                TBTHB2KMEI.NAME7,
                TBTHB2KMEI.NAME8,
                TBTHB2KMEI.NAME9,
                TBTHB2KMEI.NAME10,
                TBTHB2KMEI.NAME11,
                TBTHB2KMEI.NAME12,
                TBTHB2KMEI.NAME13,
                TBTHB2KMEI.NAME14,
                TBTHB2KMEI.NAME15,
                TBTHB2KMEI.NAME16,
                TBTHB2KMEI.NAME17,
                TBTHB2KMEI.NAME18,
                TBTHB2KMEI.NAME19,
                TBTHB2KMEI.NAME20,
                TBTHB2KMEI.NAME21,
                TBTHB2KMEI.NAME22,
                TBTHB2KMEI.NAME23,
                TBTHB2KMEI.NAME24,
                TBTHB2KMEI.NAME25,
                TBTHB2KMEI.NAME26,
                TBTHB2KMEI.NAME27,
                TBTHB2KMEI.NAME28,
                TBTHB2KMEI.NAME29,
                TBTHB2KMEI.NAME30,
                TBTHB2KMEI.KNGK1,
                TBTHB2KMEI.KNGK2,
                TBTHB2KMEI.KNGK3,
                TBTHB2KMEI.RITU1,
                TBTHB2KMEI.RITU2,
                TBTHB2KMEI.SONOTA1,
                TBTHB2KMEI.SONOTA2,
                TBTHB2KMEI.SONOTA3,
                TBTHB2KMEI.SONOTA4,
                TBTHB2KMEI.SONOTA5,
                TBTHB2KMEI.SONOTA6,
                TBTHB2KMEI.SONOTA7,
                TBTHB2KMEI.SONOTA8,
                TBTHB2KMEI.SONOTA9,
                TBTHB2KMEI.SONOTA10,
                TBTHB2KMEI.BUNFLG,
                TBTHB2KMEI.MEIHNFLG,
                TBTHB2KMEI.NEBHNFLG
        };
    }

    /**
     * 実施NO更新用の明細データの取得を行います。
     *
     * @param vo VO 実施NoVO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void findThb2Kmei(FindThb2KmeiBycondVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }

        try {
          super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }


    /**
     * クリエーティブ用のSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
    	if(_sqlMode.equals(SqlMode.COMMON)){
    		return getSelectSQLCommon();
        }else{
            return getSelectSQLCreative();
        }

    }

    /**
     * EXEC-SQL生成
     */
    public String getSelectSQLCommon() {
    //public String getExecString() {
        StringBuffer sql = new StringBuffer();

        //====================================================================================================
        // SELECT句
        //====================================================================================================
        sql.append(" SELECT ");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append("  " + getTableColumnNames()[i] + " ");
            }else{
                sql.append(" ," + getTableColumnNames()[i] + " ");
            }
        }
        //====================================================================================================
        // FROM句
        //====================================================================================================
        sql.append(" FROM ");
        sql.append(TBTHB2KMEI.TBNAME + ", ");

        // サブクエリ（媒体マスタ情報）
        sql.append("(SELECT ");
        sql.append(TBTHBAMST.INTVALUE1 + ",");
        sql.append(TBTHBAMST.FIELD2);
        sql.append(" FROM ");
        sql.append(TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append(TBTHBAMST.EGCD + "        = '" + _cond.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSKGYCD  + "   = '" + _cond.getHb2TksKgyCd() +"' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.SYBT + "        = '203' ");
        sql.append(") MST1, ");

        // サブクエリ（商品マスタ情報）
        sql.append("(SELECT ");
        sql.append(TBTHBAMST.INTVALUE1 + ",");
        sql.append(TBTHBAMST.FIELD1);
        sql.append(" FROM ");
        sql.append(TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append(TBTHBAMST.EGCD + "        = '" + _cond.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSKGYCD  + "   = '" + _cond.getHb2TksKgyCd() +"' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.SYBT + "        = '104' ");
        sql.append(") MST2, ");

        // サブクエリ（受注ダウンロードデータ）
        sql.append("(SELECT ");
        sql.append(TBTHB1DOWN.URMEINO + ",");
        sql.append(TBTHB1DOWN.JYMEINO + ",");
        sql.append(TBTHB1DOWN.JYUTNO + ",");
        sql.append(TBTHB1DOWN.GYOMKBN + ",");
        sql.append(" CASE ");
        sql.append(TBTHB1DOWN.GYOMKBN);
        sql.append(" WHEN '" + GyomKbn.SHINBUN.getCode() + "'       THEN 1 ");        // 新聞
        sql.append(" WHEN '" + GyomKbn.ZASHI.getCode() + "'         THEN 2 ");        // 雑誌
        sql.append(" WHEN '" + GyomKbn.TVTIME.getCode() + "'        THEN 3 ");        // テレビタイム
        sql.append(" WHEN '" + GyomKbn.EISEIM.getCode() + "'        THEN 4 ");        // 衛星メディア
        sql.append(" WHEN '" + GyomKbn.TVSPOT.getCode() + "'        THEN 5 ");        // テレビスポット
        sql.append(" WHEN '" + GyomKbn.RADIO.getCode() + "'         THEN 6 ");        // ラジオ
        sql.append(" WHEN '" + GyomKbn.OOHM.getCode() + "'          THEN 7 ");        // OOHメディア
        sql.append(" WHEN '" + GyomKbn.MARKEPROMO.getCode() + "'    THEN 8 ");        // マーケティング/プロモーション
        sql.append(" WHEN '" + GyomKbn.INTERACTIVEM.getCode() + "'  THEN 9 ");        // インタラクティブメディア
        sql.append(" WHEN '" + GyomKbn.SONOTAM.getCode()  + "'      THEN 10");        // その他メディア
        sql.append(" WHEN '" + GyomKbn.MPLAN.getCode() + "'         THEN 11");        // メディアプランニング
        sql.append(" WHEN '" + GyomKbn.SPORTS.getCode() + "'        THEN 12");        // スポーツ
        sql.append(" WHEN '" + GyomKbn.ENTERTAINMENT.getCode() + "' THEN 13");        // エンタテイメント
        sql.append(" WHEN '" + GyomKbn.SONOTAC.getCode() + "'       THEN 14");        // その他コンテンツ
        //sql.append(" WHEN '" + GyomKbn.CREATIVE.getCode() + "'      THEN 15");        // クリエーティブ
        sql.append(" END AS GYOMKBN");
        sql.append(" FROM ");
        sql.append(TBTHB1DOWN.TBNAME);
        sql.append(" WHERE ");
        sql.append(TBTHB1DOWN.EGCD + "        = '" + _cond.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD + "    = '" + _cond.getHb2TksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.YYMM + "        = '" + _cond.getHb2Yymm() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.GYOMKBN + "     <> '" + GyomKbn.CREATIVE.getCode() + "' ");	//クリエーティブ以外
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TJYUTNO + "     = ' ') ");

        //====================================================================================================
        // WHERE句
        //====================================================================================================
        sql.append(" WHERE ");
        sql.append(TBTHB2KMEI.EGCD + "        = '" + _cond.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getHb2TksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.YYMM + "        = '" + _cond.getHb2Yymm() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.KNGK1 + "      >=  0 ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.KBN2 + "       <> '2'");
        // 以下、結合条件
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.JYUTNO + "      = " + TBTHB2KMEI.JYUTNO);
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.JYMEINO + "     = " + TBTHB2KMEI.JYMEINO);
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.URMEINO + "     = " + TBTHB2KMEI.URMEINO);
        sql.append(" AND ");
        sql.append("MST1.").append(TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBTHB2KMEI.CODE2 + ")");
        sql.append(" AND ");
        sql.append("MST2.").append(TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBTHB2KMEI.CODE3 + ")");

        //====================================================================================================
        // ORDER BY句
        //====================================================================================================
        sql.append(" ORDER BY ");
        sql.append(" GYOMKBN, ");
        sql.append(TBTHB2KMEI.JYUTNO + ", ");
        sql.append(TBTHB2KMEI.JYMEINO +", ");
        sql.append(TBTHB2KMEI.URMEINO + ", ");
        sql.append("MST1.").append(TBTHBAMST.INTVALUE1 + ", ");
        sql.append("MST2.").append(TBTHBAMST.INTVALUE1 + ", ");
        sql.append(TBTHB2KMEI.RENBN);
//      sql.append(TBTHB2KMEI.RITU1);

        return sql.toString();
    }

    /**
     * 業務区分クリエーティブ用検索
     */
    public String getSelectSQLCreative() {
        StringBuffer sql = new StringBuffer();
        //====================================================================================================
        // SELECT句
        //====================================================================================================
        sql.append(" SELECT ");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append("  " + getTableColumnNames()[i] + " ");
            }else{
                sql.append(" ," + getTableColumnNames()[i] + " ");
            }
        }
        //====================================================================================================
        // FROM句
        //====================================================================================================
        sql.append(" FROM ");
        sql.append(TBTHB2KMEI.TBNAME + ", ");

        // サブクエリ（媒体マスタ情報）
        sql.append("(SELECT ");
        sql.append(TBTHBAMST.INTVALUE1 + ",");
        sql.append(TBTHBAMST.FIELD2);
        sql.append(" FROM ");
        sql.append(TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append(TBTHBAMST.EGCD + "        = '" + _cond.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSKGYCD  + "   = '" + _cond.getHb2TksKgyCd() +"' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.SYBT + "        = '203' ");
        sql.append(") MST1, ");

        // サブクエリ（商品マスタ情報）
        sql.append("(SELECT ");
        sql.append(TBTHBAMST.INTVALUE1 + ",");
        sql.append(TBTHBAMST.FIELD1);
        sql.append(" FROM ");
        sql.append(TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append(TBTHBAMST.EGCD + "        = '" + _cond.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSKGYCD  + "   = '" + _cond.getHb2TksKgyCd() +"' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHBAMST.SYBT + "        = '104' ");
        sql.append(") MST2, ");
        sql.append(TBTHB1DOWN.TBNAME);
        //====================================================================================================
        // WHERE句
        //====================================================================================================
        sql.append(" WHERE ");
        sql.append(TBTHB1DOWN.EGCD + "        = '" + _cond.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD + "    = '" + _cond.getHb2TksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.YYMM + "        = '" + _cond.getHb2Yymm() + "' ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.GYOMKBN + "     = '" + GyomKbn.CREATIVE.getCode() + "' ");	//クリエーティブ
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TJYUTNO + "     = ' ' ");
        // 以下、結合条件
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.EGCD + "        = " + TBTHB2KMEI.EGCD + " ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD + "    = " + TBTHB2KMEI.TKSKGYCD + " ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.YYMM + "        = " + TBTHB2KMEI.YYMM + " ");
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.JYUTNO + "      = " + TBTHB2KMEI.JYUTNO);
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.JYMEINO + "     = " + TBTHB2KMEI.JYMEINO);
        sql.append(" AND ");
        sql.append(TBTHB1DOWN.URMEINO + "     = " + TBTHB2KMEI.URMEINO);
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.KNGK1 + "      >=  0 ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.KBN2 + "       <> '2'");
        sql.append(" AND ");
        sql.append("MST1.").append(TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBTHB2KMEI.CODE2 + ")");
        sql.append(" AND ");
        sql.append("MST2.").append(TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBTHB2KMEI.CODE3 + ")");

        //====================================================================================================
        // ORDER BY句
        //====================================================================================================
        sql.append(" ORDER BY ");
        sql.append("MST2.").append(TBTHBAMST.INTVALUE1 + ", ");
        sql.append(TBTHB2KMEI.JYUTNO + ", ");
        sql.append(TBTHB2KMEI.JYMEINO +", ");
        sql.append(TBTHB2KMEI.URMEINO + ", ");
        sql.append("MST1.").append(TBTHBAMST.INTVALUE1 + ", ");
        sql.append(TBTHB2KMEI.RENBN);
//      sql.append(TBTHB2KMEI.RITU1);

        return sql.toString();
    }
    /**
     * 広告費明細テーブルの条件指定検索を行います。
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Thb2KmeiVO> findThb2KmeiByCondCmn(Thb2KmeiVO Cond) throws KKHException {
        super.setModel(new Thb2KmeiVO());

        try {
            _cond = Cond;
            _sqlMode = SqlMode.COMMON;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * 広告費明細テーブルの条件指定検索(クリエーティブ)を行います。
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Thb2KmeiVO> findThb2KmeiByCondCmnCreative(Thb2KmeiVO Cond) throws KKHException {
        super.setModel(new Thb2KmeiVO());

        try {
            _cond = Cond;
            _sqlMode = SqlMode.CREATIVE;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

}