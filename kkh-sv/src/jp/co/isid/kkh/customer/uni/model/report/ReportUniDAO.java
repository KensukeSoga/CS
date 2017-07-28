package jp.co.isid.kkh.customer.uni.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.constants.KKHConstants.GyomKbn;
import jp.co.isid.kkh.util.constants.KKHConstants.Shubetsu;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 帳票（ユニチャーム_広告費明細表）データ検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class ReportUniDAO extends AbstractRdbDao {


    /** getSelectSQLで発行するSQLのモード() */
    private enum SelSqlMode {
        MEISAI1,MEISAI2,
    };

    private SelSqlMode _SelSqlMode = null;

    /** 種別表示順 (テレビ番組) */
    static final String IDX_TV_BANGUMI = "1";
    /** 種別表示順 (テレビ特番) */
    static final String IDX_TV_TOKUBAN = "2";
    /** 種別表示順 (テレビスポット) */
    static final String IDX_TV_SPOT = "3";
    /** 種別表示順 (雑誌) */
    static final String IDX_ZASHI = "4";
    /** 種別表示順 (新聞) */
    static final String IDX_SHINBUN = "5";
    /** 種別表示順 (その他) */
    static final String IDX_SONOTA = "6";
    /** 種別表示順 (制作) */
    static final String IDX_SEISAKU = "7";

    /** データ検索条件 */
    private ReportUniCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportUniDAO() {
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
        return null;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
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

        return getSelectSQLMeisai();
    }

    /**
     * 帳票（ユニチャーム_広告費明細表）データ取得のSQL文を返します。
     *
     * @return String SQL文
     */
    private String getSelectSQLMeisai() {
        StringBuffer sql = new StringBuffer();

        if(_SelSqlMode == SelSqlMode.MEISAI1){

            // ====================================================================================================
            // SELECT句
            // ====================================================================================================
            sql.append(" SELECT");
            sql.append(" CASE ");
            // 種別表示順
            sql.append(TBTHB2KMEI.CODE1);
            sql.append(" WHEN '" + Shubetsu.TV_BANGUMI.getCode() + "' THEN 1");  // テレビ番組
            sql.append(" WHEN '" + Shubetsu.TV_TOKUBAN.getCode() + "' THEN 2");  // テレビ特番
            sql.append(" WHEN '" + Shubetsu.TV_SPOT.getCode() + "'    THEN 3");  // テレビスポット
            sql.append(" WHEN '" + Shubetsu.ZASHI.getCode() + "'      THEN 4");  // 雑誌
            sql.append(" WHEN '" + Shubetsu.SHINBUN.getCode() + "'    THEN 5");  // 新聞
            sql.append(" WHEN '" + Shubetsu.SEISAKU.getCode() + "'    THEN 7");  // 制作
            sql.append(" ELSE 6");                                               // その他
            sql.append(" END AS SHOWNUM");                                       // 表示順
            // その他
            sql.append("," + TBTHB1DOWN.GPYNO);                                  // 請求原票No
            sql.append("," + TBTHB1DOWN.SEIGAK);                                 // 請求金額
            sql.append("," + TBTHB1DOWN.SZEIGAK);                                // 消費税額
            sql.append("," + TBTHB1DOWN.JYUTNO);                                 // 受注No
            sql.append("," + TBTHB1DOWN.JYMEINO);                                // 受注明細No
            sql.append("," + TBTHB1DOWN.URMEINO);                                // 売上明細No
            sql.append("," + TBTHB1DOWN.GYOMKBN);                                // 業務区分
            sql.append("," + TBTHB1DOWN.SEIKBN);                                 // 請求区分
            sql.append("," + TBTHB1DOWN.KKNAMEKJ);                               // 件名(漢字)
            sql.append("," + TBTHB1DOWN.HIMKNMKJ);                               // 費目名(漢字)
            sql.append("," + TBTHB1DOWN.SEITNKA);                                // 請求単価
            // 2013/01/09 JSE M.Naito add start
            sql.append("," + TBTHB1DOWN.TOUFLG);                                 // 統合フラグ
            sql.append("," + TBTHB1DOWN.TJYUTNO);                                // 統合先受注No
            // 2013/01/09 JSE M.Naito add end
            sql.append("," + TBTHB1DOWN.FIELD1);                                 // フィールド１
            sql.append("," + TBTHB1DOWN.FIELD2);                                 // フィールド２
            sql.append("," + TBTHB1DOWN.FIELD3);                                 // フィールド３
            sql.append("," + TBTHB1DOWN.FIELD4);                                 // フィールド４
            sql.append("," + TBTHB1DOWN.FIELD5);                                 // フィールド５
            sql.append("," + TBTHB1DOWN.FIELD6);                                 // フィールド６
            sql.append("," + TBTHB1DOWN.FIELD7);                                 // フィールド７
            sql.append("," + TBTHB1DOWN.FIELD8);                                 // フィールド８
            sql.append("," + TBTHB1DOWN.FIELD9);                                 // フィールド９
            sql.append("," + TBTHB1DOWN.FIELD10);                                // フィールド１０
            sql.append("," + TBTHB1DOWN.FIELD11);                                // フィールド１１
            sql.append("," + TBTHB1DOWN.FIELD12);                                // フィールド１２
            sql.append("," + TBTHB2KMEI.JYUTNO);                                 // 受注No
            sql.append("," + TBTHB2KMEI.JYMEINO);                                // 受注明細No
            sql.append("," + TBTHB2KMEI.URMEINO);                                // 売上明細No
            sql.append("," + TBTHB2KMEI.SEIGAK);                                 // 請求金額
            sql.append("," + TBTHB2KMEI.CODE1);                                  // コード1(種別コード)
            sql.append("," + TBTHB2KMEI.NAME1);                                  // 名称1(費目)
            sql.append("," + TBTHB2KMEI.NAME2);                                  // 名称2
            sql.append("," + TBTHB2KMEI.NAME3);                                  // 名称3
            sql.append("," + TBTHB2KMEI.NAME4);                                  // 名称4
            sql.append("," + TBTHB2KMEI.NAME6);                                  // 名称6
            sql.append("," + TBTHB2KMEI.NAME7);                                  // 名称7
            sql.append("," + TBTHB2KMEI.NAME9);                                  // 名称9
            sql.append("," + TBTHB2KMEI.NAME11);                                  // 名称11
            sql.append("," + TBTHB2KMEI.KNGK1);                                  // 金額1
            sql.append("," + TBTHB2KMEI.KNGK2);                                  // 金額2
            sql.append("," + TBTHB2KMEI.SONOTA2);                                // その他2
            sql.append("," + TBTHB2KMEI.SONOTA3);                                // その他3
            sql.append("," + TBTHB2KMEI.SONOTA4);                                // その他4
            sql.append("," + TBTHB2KMEI.SONOTA5);                                // その他5

            // ====================================================================================================
            // FROM句
            // ====================================================================================================
            sql.append(" FROM");
            sql.append(" " + TBTHB2KMEI.TBNAME);
            sql.append(" INNER JOIN");
            sql.append(" " + TBTHB1DOWN.TBNAME);
            sql.append(" ON");
            sql.append("     " + TBTHB2KMEI.EGCD + "        = " + TBTHB1DOWN.EGCD);
            sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = " + TBTHB1DOWN.TKSKGYCD);
            sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO);
            sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO);
            sql.append(" AND " + TBTHB2KMEI.YYMM + "        = " + TBTHB1DOWN.YYMM);
            sql.append(" AND " + TBTHB2KMEI.JYUTNO + "      = " + TBTHB1DOWN.JYUTNO);
            sql.append(" AND " + TBTHB2KMEI.JYMEINO + "     = " + TBTHB1DOWN.JYMEINO);
            sql.append(" AND " + TBTHB2KMEI.URMEINO + "     = " + TBTHB1DOWN.URMEINO);

            // ====================================================================================================
            // WHERE句
            // ====================================================================================================
            sql.append(" WHERE");
            sql.append("     " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
            sql.append(" AND " + TBTHB2KMEI.YYMM + "        = '" + _cond.getYm() + "'");
            if(_cond.getBusho().trim().equals("")){
            }else{
                sql.append(" AND " + TBTHB2KMEI.NAME11 + "      = '" + _cond.getBusho() + "'");
            }
            // 2013/01/09 JSE M.Naito add
            // 統合先受注No
            sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " = ' '");

            // ====================================================================================================
            // ORDER BY句
            // ====================================================================================================
            sql.append(" ORDER BY");
            sql.append("     SHOWNUM");                                          // 表示順
            sql.append(",CAST(RTRIM(" + TBTHB2KMEI.SONOTA3 + ") AS INT)");       // ソート番号
            sql.append("," + TBTHB1DOWN.GPYNO);                                  // 請求原票No
            sql.append("," + TBTHB2KMEI.SONOTA2);                                // 請求原票行番号（1桁）

        }

        else if (_SelSqlMode == SelSqlMode.MEISAI2) {

            sql.append(" SELECT");
//            sql.append(" CASE ");
            // 種別表示順
//            sql.append(TBTHB2KMEI.CODE1);
//            sql.append(" WHEN '" + Shubetsu.TV_BANGUMI.getCode() + "' THEN 1");  // テレビ番組
//            sql.append(" WHEN '" + Shubetsu.TV_TOKUBAN.getCode() + "' THEN 2");  // テレビ特番
//            sql.append(" WHEN '" + Shubetsu.TV_SPOT.getCode() + "'    THEN 3");  // テレビスポット
//            sql.append(" WHEN '" + Shubetsu.ZASHI.getCode() + "'      THEN 4");  // 雑誌
//            sql.append(" WHEN '" + Shubetsu.SHINBUN.getCode() + "'    THEN 5");  // 新聞
//            sql.append(" WHEN '" + Shubetsu.SEISAKU.getCode() + "'    THEN 7");  // 制作
//            sql.append(" ELSE 6");                                               // その他
//            sql.append(" END AS SHOWNUM");                                       // 表示順
            // その他
//            sql.append("," + TBTHB1DOWN.GPYNO);                                  // 請求原票No
            sql.append(" " + TBTHB1DOWN.GPYNO);                                  // 請求原票No
            sql.append("," + TBTHB1DOWN.SEIGAK);                                 // 請求金額
            sql.append("," + TBTHB1DOWN.SZEIGAK);                                // 消費税額
            sql.append("," + TBTHB1DOWN.JYUTNO);                                 // 受注No
            sql.append("," + TBTHB1DOWN.JYMEINO);                                // 受注明細No
            sql.append("," + TBTHB1DOWN.URMEINO);                                // 売上明細No
            sql.append("," + TBTHB1DOWN.GYOMKBN);                                // 業務区分
            sql.append("," + TBTHB1DOWN.SEIKBN);                                 // 請求区分
            sql.append("," + TBTHB1DOWN.KKNAMEKJ);                               // 件名(漢字)
            sql.append("," + TBTHB1DOWN.HIMKNMKJ);                               // 費目名(漢字)
            sql.append("," + TBTHB1DOWN.SEITNKA);                                // 請求単価
            // 2013/01/09 JSE M.Naito add start
            sql.append("," + TBTHB1DOWN.TOUFLG);                                 // 統合フラグ
            sql.append("," + TBTHB1DOWN.TJYUTNO);                                // 統合先受注No
            sql.append("," + TBTHB1DOWN.TJYMEINO);                                // 統合先受注明細No
            sql.append("," + TBTHB1DOWN.TURMEINO);                                // 統合先売上明細No
            // 2013/01/09 JSE M.Naito add end
            sql.append("," + TBTHB1DOWN.FIELD1);                                 // フィールド１
            sql.append("," + TBTHB1DOWN.FIELD2);                                 // フィールド２
            sql.append("," + TBTHB1DOWN.FIELD3);                                 // フィールド３
            sql.append("," + TBTHB1DOWN.FIELD4);                                 // フィールド４
            sql.append("," + TBTHB1DOWN.FIELD5);                                 // フィールド５
            sql.append("," + TBTHB1DOWN.FIELD6);                                 // フィールド６
            sql.append("," + TBTHB1DOWN.FIELD7);                                 // フィールド７
            sql.append("," + TBTHB1DOWN.FIELD8);                                 // フィールド８
            sql.append("," + TBTHB1DOWN.FIELD9);                                 // フィールド９
            sql.append("," + TBTHB1DOWN.FIELD10);                                // フィールド１０
            sql.append("," + TBTHB1DOWN.FIELD11);                                // フィールド１１
            sql.append("," + TBTHB1DOWN.FIELD12);                                // フィールド１２
//            sql.append("," + TBTHB2KMEI.JYUTNO);                                 // 受注No
//            sql.append("," + TBTHB2KMEI.JYMEINO);                                // 受注明細No
//            sql.append("," + TBTHB2KMEI.URMEINO);                                // 売上明細No
//            sql.append("," + TBTHB2KMEI.SEIGAK);                                 // 請求金額
//            sql.append("," + TBTHB2KMEI.CODE1);                                  // コード1(種別コード)
//            sql.append("," + TBTHB2KMEI.NAME1);                                  // 名称1(費目)
//            sql.append("," + TBTHB2KMEI.NAME2);                                  // 名称2
//            sql.append("," + TBTHB2KMEI.NAME3);                                  // 名称3
//            sql.append("," + TBTHB2KMEI.NAME4);                                  // 名称4
//            sql.append("," + TBTHB2KMEI.NAME6);                                  // 名称6
//            sql.append("," + TBTHB2KMEI.NAME7);                                  // 名称7
//            sql.append("," + TBTHB2KMEI.NAME9);                                  // 名称9
//            sql.append("," + TBTHB2KMEI.NAME11);                                  // 名称11
//            sql.append("," + TBTHB2KMEI.KNGK1);                                  // 金額1
//            sql.append("," + TBTHB2KMEI.KNGK2);                                  // 金額2
//            sql.append("," + TBTHB2KMEI.SONOTA2);                                // その他2
//            sql.append("," + TBTHB2KMEI.SONOTA3);                                // その他3
//            sql.append("," + TBTHB2KMEI.SONOTA4);                                // その他4
//            sql.append("," + TBTHB2KMEI.SONOTA5);                                // その他5

            // ====================================================================================================
            // FROM句
            // ====================================================================================================
            sql.append(" FROM");
            sql.append(" " + TBTHB1DOWN.TBNAME);
//            sql.append(" LEFT OUTER JOIN");
//            sql.append(" " + TBTHB2KMEI.TBNAME);
//            sql.append(" ON");
//            sql.append("     " + TBTHB2KMEI.EGCD + "        = " + TBTHB1DOWN.EGCD);
//            sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = " + TBTHB1DOWN.TKSKGYCD);
//            sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO);
//            sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO);
//            sql.append(" AND " + TBTHB2KMEI.YYMM + "        = " + TBTHB1DOWN.YYMM);
//            sql.append(" AND " + TBTHB2KMEI.JYUTNO + "      = " + TBTHB1DOWN.JYUTNO);
//            sql.append(" AND " + TBTHB2KMEI.JYMEINO + "     = " + TBTHB1DOWN.JYMEINO);
//            sql.append(" AND " + TBTHB2KMEI.URMEINO + "     = " + TBTHB1DOWN.URMEINO);

            // ====================================================================================================
            // WHERE句
            // ====================================================================================================
            sql.append(" WHERE");
            sql.append("     " + TBTHB1DOWN.EGCD + "        = '" + _cond.getEgCd() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
            sql.append(" AND " + TBTHB1DOWN.YYMM + "        = '" + _cond.getYm() + "'");
//            if(_cond.getBusho().trim().equals("")){
//            }else{
//                sql.append(" AND " + TBTHB2KMEI.NAME11 + "      = '" + _cond.getBusho() + "'");
//            }
            // 統合先受注No
            sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " != ' '");

            // ====================================================================================================
            // ORDER BY句
            // ====================================================================================================
            sql.append(" ORDER BY");
//            sql.append("     SHOWNUM");                                          // 表示順
//            sql.append(",CAST(RTRIM(" + TBTHB2KMEI.SONOTA3 + ") AS INT)");       // ソート番号
//            sql.append("," + TBTHB1DOWN.GPYNO);                                  // 請求原票No
            sql.append(" " + TBTHB1DOWN.GPYNO);                                  // 請求原票No
//            sql.append("," + TBTHB2KMEI.SONOTA2);                                // 請求原票行番号（1桁）

        }

        return sql.toString();
    }

    /**
     * 帳票（ユニチャーム_広告費明細表・プルーフリスト）データの検索を行います。
     *
     * @return 帳票（ユニチャーム_広告費明細表・プルーフリスト）データを含むVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportUniVO> findReportUniByCondition(ReportUniCondition cond)
            throws KKHException {

        super.setModel(new ReportUniVO());

        try {
            _SelSqlMode = SelSqlMode.MEISAI1;
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * 帳票（ユニチャーム_広告費明細表・プルーフリスト）データの検索を行います。
     * 統合元データのみ対象
     * @return 帳票（ユニチャーム_広告費明細表・プルーフリスト）データを含むVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportUniVO> findTougouReportUniByCondition(ReportUniCondition cond)
            throws KKHException {

        super.setModel(new ReportUniVO());

        try {
            _SelSqlMode = SelSqlMode.MEISAI2;
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
     * @param hashList
     *            List 検索結果
     * @return List<ReportUniVO> 変換後の検索結果
     */
    @Override
    protected List<ReportUniVO> createFindedModelInstances(List hashList) {
        return getMeisaiList(hashList);
    }

    /**
     * 広告費明細表（暫定・確定）データを取得する
     *
     * @param hashList 検索結果
     * @return 変換後の検索結果
     */
    private List<ReportUniVO> getMeisaiList(List hashList) {

        List<ReportUniVO> list = new ArrayList<ReportUniVO>();

        if (getModel() instanceof ReportUniVO) {

            for (int i = 0; i < hashList.size(); i++) {

                Map result = (Map) hashList.get(i);
                ReportUniVO vo = new ReportUniVO();

                // 種別コード
                BigDecimal showNum = (BigDecimal) result.get("SHOWNUM");
                //String showNumStr = String.valueOf(showNum);
                String showNumStr = "";

                // 種別コードが空の場合、業務区分から種別コードを設定する
                if(showNum == null){

                    // 業務区分を取得
                    String gyomKbn = (String)result.get(TBTHB1DOWN.GYOMKBN);

                    if (GyomKbn.TVTIME.getCode().equals(gyomKbn)) {
                        showNumStr = IDX_TV_BANGUMI;                           // テレビ番組

                    } else if (GyomKbn.TVSPOT.getCode().equals(gyomKbn)) {
                        showNumStr = IDX_TV_SPOT;                              // テレビスポット

                    } else if (GyomKbn.ZASHI.getCode().equals(gyomKbn)) {
                        showNumStr = IDX_ZASHI;                                // 雑誌

                    } else if (GyomKbn.SHINBUN.getCode().equals(gyomKbn)) {
                        showNumStr = IDX_SHINBUN;                              // 新聞

                    } else if (GyomKbn.CREATIVE.getCode().equals(gyomKbn)) {
                        showNumStr = IDX_SEISAKU;                              // 製作

                    } else {
                        showNumStr = IDX_SONOTA;                               // その他
                    }
                }
                else
                {
                    showNumStr = String.valueOf(showNum);
                }

                // 取得した種別コードをセット
                vo.setShubetsuCd(showNumStr);

                // 種別名
                String shubetsuNm = "";
                if (IDX_TV_BANGUMI.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.TV_BANGUMI.getName();    // テレビ番組

                } else if (IDX_TV_TOKUBAN.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.TV_TOKUBAN.getName();    // テレビ特番

                } else if (IDX_TV_SPOT.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.TV_SPOT.getName();       // テレビスポット

                } else if (IDX_ZASHI.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.ZASHI.getName();         // 雑誌

                } else if (IDX_SHINBUN.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.SHINBUN.getName();       // 新聞

                } else if (IDX_SONOTA.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.SONOTA.getName();        // その他

                } else if (IDX_SEISAKU.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.SEISAKU.getName();       // 製作
                }
                vo.setShubetsuNm(shubetsuNm);

                vo.setHb1GpyNo((String) result.get(TBTHB1DOWN.GPYNO.toUpperCase().trim()));            // 請求原票No
                vo.setHb1SeiGak((BigDecimal) result.get(TBTHB1DOWN.SEIGAK.toUpperCase().trim()));      // 請求金額
                vo.setHb1SzeiGak((BigDecimal) result.get(TBTHB1DOWN.SZEIGAK.toUpperCase().trim()));    // 消費税額
                vo.setHb1JyutNo((String) result.get(TBTHB1DOWN.JYUTNO.toUpperCase().trim()));          // 受注No
                vo.setHb1JyMeiNo((String) result.get(TBTHB1DOWN.JYMEINO.toUpperCase().trim()));        // 受注明細No
                vo.setHb1UrMeiNo((String) result.get(TBTHB1DOWN.URMEINO.toUpperCase().trim()));        // 売上明細No
                vo.setHb1GyomKbn((String) result.get(TBTHB1DOWN.GYOMKBN.toUpperCase().trim()));        // 業務区分
                vo.setHb1SeiKbn((String) result.get(TBTHB1DOWN.SEIKBN.toUpperCase().trim()));          // 請求区分
                vo.setHb1KKNameKJ((String) result.get(TBTHB1DOWN.KKNAMEKJ.toUpperCase().trim()));      // 件名(漢字)
                vo.setHb1HimkNmKJ((String) result.get(TBTHB1DOWN.HIMKNMKJ.toUpperCase().trim()));      // 費目名(漢字)
                vo.setHb1SeiTnka((BigDecimal) result.get(TBTHB1DOWN.SEITNKA.toUpperCase().trim()));    // 請求単価
                // 2013/01/09 JSE M.Naito add start
                vo.setHb1TouFlg((String) result.get(TBTHB1DOWN.TOUFLG.toUpperCase().trim()));          // 統合フラグ
                vo.setHb1TJyutNo((String) result.get(TBTHB1DOWN.TJYUTNO.toUpperCase().trim()));        // 統合先受注No
                vo.setHb1TJymeiNo((String) result.get(TBTHB1DOWN.TJYMEINO.toUpperCase().trim()));      // 統合先受注明細No
                vo.setHb1TUrmeiNo((String) result.get(TBTHB1DOWN.TURMEINO.toUpperCase().trim()));      // 統合先売上明細No
                // 2013/01/09 JSE M.Naito add end
                vo.setHb1Field1((String) result.get(TBTHB1DOWN.FIELD1.toUpperCase().trim()));          // フィールド１
                vo.setHb1Field2((String) result.get(TBTHB1DOWN.FIELD2.toUpperCase().trim()));          // フィールド２
                vo.setHb1Field3((String) result.get(TBTHB1DOWN.FIELD3.toUpperCase().trim()));          // フィールド３
                vo.setHb1Field4((String) result.get(TBTHB1DOWN.FIELD4.toUpperCase().trim()));          // フィールド４
                vo.setHb1Field5((String) result.get(TBTHB1DOWN.FIELD5.toUpperCase().trim()));          // フィールド５
                vo.setHb1Field6((String) result.get(TBTHB1DOWN.FIELD6.toUpperCase().trim()));          // フィールド６
                vo.setHb1Field7((String) result.get(TBTHB1DOWN.FIELD7.toUpperCase().trim()));          // フィールド７
                vo.setHb1Field8((String) result.get(TBTHB1DOWN.FIELD8.toUpperCase().trim()));          // フィールド８
                vo.setHb1Field9((String) result.get(TBTHB1DOWN.FIELD9.toUpperCase().trim()));          // フィールド９
                vo.setHb1Field10((String) result.get(TBTHB1DOWN.FIELD10.toUpperCase().trim()));        // フィールド１０
                vo.setHb1Field11((String) result.get(TBTHB1DOWN.FIELD11.toUpperCase().trim()));        // フィールド１１
                vo.setHb1Field12((String) result.get(TBTHB1DOWN.FIELD12.toUpperCase().trim()));        // フィールド１２

                vo.setHb2SeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase().trim()));      // 請求金額
                vo.setHb2Code1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));            // コード1
                vo.setHb2Name1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim()));            // 名称1
                vo.setHb2Name2((String) result.get(TBTHB2KMEI.NAME2.toUpperCase().trim()));            // 名称2
                vo.setHb2Name3((String) result.get(TBTHB2KMEI.NAME3.toUpperCase().trim()));            // 名称3
                vo.setHb2Name4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase().trim()));            // 名称4
                vo.setHb2Name6((String) result.get(TBTHB2KMEI.NAME6.toUpperCase().trim()));            // 名称6
                vo.setHb2Name7((String) result.get(TBTHB2KMEI.NAME7.toUpperCase().trim()));            // 名称7
                vo.setHb2Name9((String) result.get(TBTHB2KMEI.NAME9.toUpperCase().trim()));            // 名称9
                vo.setHb2Name11((String) result.get(TBTHB2KMEI.NAME11.toUpperCase().trim()));            // 名称9
                vo.setHb2Kngk1((BigDecimal) result.get(TBTHB2KMEI.KNGK1.toUpperCase().trim()));        // 金額1
                vo.setHb2Kngk2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase().trim()));        // 金額2
                vo.setHb2Sonota2((String) result.get(TBTHB2KMEI.SONOTA2.toUpperCase().trim()));        // その他2
                vo.setHb2Sonota3((String) result.get(TBTHB2KMEI.SONOTA3.toUpperCase().trim()));        // その他3
                vo.setHb2Sonota4((String) result.get(TBTHB2KMEI.SONOTA4.toUpperCase().trim()));        // その他4
                vo.setHb2Sonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));        // その他5

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
