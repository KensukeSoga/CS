package jp.co.isid.kkh.customer.kmn.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
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
 * 帳票（公文_帳票出力）データ検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
public class ReportKmnDAO extends AbstractRdbDao {

    /** getSelectSQLで発行するSQLのモード() */
    private enum SelSqlMode {
        MEISAI1,MEISAI2,
    };

    private SelSqlMode _SelSqlMode = null;

    /** データ検索条件 */
    private ReportKmnCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportKmnDAO() {
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
     * 帳票（公文_帳票出力）データ取得のSQL文を返します。
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
            sql.append(" " + TBTHB2KMEI.JYUTNO);                                 // 受注No
            sql.append("," + TBTHB2KMEI.JYMEINO);                                // 受注明細No
            sql.append("," + TBTHB2KMEI.URMEINO);                                // 売上明細No
            sql.append("," + TBTHB2KMEI.YYMM);                                   // 年月
            sql.append("," + TBTHB2KMEI.SEIGAK);                                 // 請求金額
            sql.append("," + TBTHB2KMEI.CODE1);                                  // コード1
            sql.append("," + TBTHB2KMEI.CODE2);                                  // コード2
            sql.append("," + TBTHB2KMEI.NAME1);                                  // 名称1
            sql.append("," + TBTHB2KMEI.NAME2);                                  // 名称2
            sql.append("," + TBTHB2KMEI.NAME3);                                  // 名称3
            sql.append("," + TBTHB2KMEI.NAME4);                                  // 名称4
            sql.append("," + TBTHB2KMEI.NAME5);                                  // 名称5
            sql.append("," + TBTHB2KMEI.NAME6);                                  // 名称6
            sql.append("," + TBTHB2KMEI.NAME7);                                  // 名称7
            sql.append("," + TBTHB2KMEI.NAME8);                                  // 名称8
            sql.append("," + TBTHB2KMEI.NAME9);                                  // 名称9
            sql.append("," + TBTHB2KMEI.NAME11);                                 // 名称11
            sql.append("," + TBTHB2KMEI.NAME16);                                 // 名称16
            sql.append("," + TBTHB2KMEI.KNGK1);                                  // 金額1
            sql.append("," + TBTHB2KMEI.KNGK2);                                  // 金額2
            sql.append("," + TBTHB2KMEI.KNGK3);                                  // 金額3
            sql.append("," + TBTHB2KMEI.SONOTA2);                                // その他2
            sql.append("," + TBTHB2KMEI.SONOTA3);                                // その他3
            sql.append("," + TBTHB2KMEI.SONOTA4);                                // その他4
            sql.append("," + TBTHB2KMEI.SONOTA5);                                // その他5
            sql.append("," + TBTHB14SKDOWN.JYUTNO);                              // 受注No
            sql.append("," + TBTHB1DOWN.JYUTNO);                                 // 受注No
            sql.append("," + TBTHB1DOWN.TJYUTNO);                                // 統合先受注No
//            sql.append(", '0' AS OYAKOFLG");                                     // 親子フラグ(0:親 1:子)

            // ====================================================================================================
            // FROM句
            // ====================================================================================================
            sql.append(" FROM");
            sql.append(" ( ");
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
            sql.append(" ) ");
            sql.append(" LEFT OUTER JOIN");
            sql.append(" " + TBTHB14SKDOWN.TBNAME);
            sql.append(" ON");
            sql.append("     " + TBTHB1DOWN.EGCD + "        = " + TBTHB14SKDOWN.EGCD);
            sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + "    = " + TBTHB14SKDOWN.TKSKGYCD);
            sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB14SKDOWN.TKSBMNSEQNO);
            sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB14SKDOWN.TKSTNTSEQNO);
            sql.append(" AND " + TBTHB1DOWN.YYMM + "        = " + TBTHB14SKDOWN.SEIYYMM);
            sql.append(" AND " + TBTHB1DOWN.JYUTNO + "      = " + TBTHB14SKDOWN.JYUTNO);
            sql.append(" AND " + TBTHB1DOWN.JYMEINO + "     = " + TBTHB14SKDOWN.JYMEINO);
            sql.append(" AND " + TBTHB1DOWN.URMEINO + "     = " + TBTHB14SKDOWN.URMEINO);
          //2013/11/07 add 不具合対応　ステータス追加 start
            sql.append(" AND " + TBTHB14SKDOWN.SEISTATUS  + " = '2' " );
           //2013/11/07 add 不具合対応　ステータス追加 end

            // ====================================================================================================
            // WHERE句
            // ====================================================================================================
            sql.append(" WHERE");
            sql.append("     " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
            //sql.append(" AND " + TBTHB2KMEI.YYMM + "        = '" + _cond.getYm() + "'");
            // 統合先受注No
            sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " = ' '");

            // 出力No
            if(_cond.getOutputNo().trim().equals("")){

                // 請求年月
                sql.append(" AND " + TBTHB2KMEI.NAME6 + "  = '" + _cond.getYm() + "'");
                // 部門コード
                if(_cond.getBumon().trim().equals("")){
                }else{
                    sql.append(" AND " + TBTHB2KMEI.CODE1 + " = '" + _cond.getBumon() + "'");
                }

            }else{
                // 出力No
                sql.append(" AND " + TBTHB2KMEI.CODE2 + " = '" + _cond.getOutputNo() + "'");
            }

            // ====================================================================================================
            // ORDER BY句
            // ====================================================================================================
            sql.append("  ORDER BY ");
            sql.append(TBTHB2KMEI.JYUTNO + ", ");
            sql.append(TBTHB2KMEI.JYMEINO + ", ");
            sql.append(TBTHB2KMEI.URMEINO + ", ");
            sql.append(TBTHB2KMEI.RENBN);

        }else if(_SelSqlMode == SelSqlMode.MEISAI2){

            // ====================================================================================================
            // SELECT句
            // ====================================================================================================
            sql.append(" SELECT");
            sql.append(" " + TBTHB14SKDOWN.JYUTNO);                              // 受注No
            sql.append("," + TBTHB1DOWN.JYUTNO);                                 // 受注No
            sql.append("," + TBTHB1DOWN.TJYUTNO);                                // 統合先受注No
//            sql.append(", '1' AS OYAKOFLG");                                     // 親子フラグ(0:親 1:子)

            // ====================================================================================================
            // FROM句
            // ====================================================================================================
            sql.append(" FROM");
            sql.append(" " + TBTHB1DOWN.TBNAME);
            sql.append(" LEFT OUTER JOIN");
            sql.append(" " + TBTHB14SKDOWN.TBNAME);
            sql.append(" ON");
            sql.append("     " + TBTHB1DOWN.EGCD + "        = " + TBTHB14SKDOWN.EGCD);
            sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + "    = " + TBTHB14SKDOWN.TKSKGYCD);
            sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB14SKDOWN.TKSBMNSEQNO);
            sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB14SKDOWN.TKSTNTSEQNO);
            sql.append(" AND " + TBTHB1DOWN.YYMM + "        = " + TBTHB14SKDOWN.SEIYYMM);
            sql.append(" AND " + TBTHB1DOWN.JYUTNO + "      = " + TBTHB14SKDOWN.JYUTNO);
            sql.append(" AND " + TBTHB1DOWN.JYMEINO + "     = " + TBTHB14SKDOWN.JYMEINO);
            sql.append(" AND " + TBTHB1DOWN.URMEINO + "     = " + TBTHB14SKDOWN.URMEINO);
          //2013/11/07 add 不具合対応　ステータス追加 start
            sql.append(" AND " + TBTHB14SKDOWN.SEISTATUS  + " = '2' " );
           //2013/11/07 add 不具合対応　ステータス追加 end

            // ====================================================================================================
            // WHERE句
            // ====================================================================================================
            sql.append(" WHERE");
            sql.append("     " + TBTHB1DOWN.EGCD + "        = '" + _cond.getEgCd() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
            //sql.append(" AND " + TBTHB2KMEI.YYMM + "        = '" + _cond.getYm() + "'");
            // 統合先受注No
            sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " != ' '");

            // ====================================================================================================
            // ORDER BY句
            // ====================================================================================================
            sql.append("  ORDER BY ");
            sql.append(TBTHB1DOWN.JYUTNO );
        }

         return sql.toString();
    }

    /**
     * 帳票（公文_伝票）データの検索を行います。
     *
     * @return 帳票（公文_伝票）データを含むVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportKmnVO> findReportKmnByCondition(ReportKmnCondition cond)
            throws KKHException {

        super.setModel(new ReportKmnVO());

        try {
            _SelSqlMode = SelSqlMode.MEISAI1;
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * 帳票（公文_伝票）データの検索を行います。
     *
     * @return 帳票（公文_伝票）データを含むVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportKmnVO> findReportKmnByCondition2(ReportKmnCondition cond)
            throws KKHException {

        super.setModel(new ReportKmnVO());

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
    protected List<ReportKmnVO> createFindedModelInstances(List hashList) {
        return getMeisaiList(hashList);
    }

    /**
     * 広告費明細表（暫定・確定）データを取得する
     *
     * @param hashList 検索結果
     * @return 変換後の検索結果
     */
    private List<ReportKmnVO> getMeisaiList(List hashList) {

        List<ReportKmnVO> list = new ArrayList<ReportKmnVO>();

        if(_SelSqlMode == SelSqlMode.MEISAI1){

            if (getModel() instanceof ReportKmnVO) {

                for (int i = 0; i < hashList.size(); i++) {

                    Map result = (Map) hashList.get(i);
                    ReportKmnVO vo = new ReportKmnVO();

                    vo.setHb2JyutNo((String) result.get(TBTHB2KMEI.JYUTNO.toUpperCase().trim()));                // 受注No
                    vo.setHb2JymeiNo((String) result.get(TBTHB2KMEI.JYMEINO.toUpperCase().trim()));              // 受注明細No
                    vo.setHb2UrmeiNo((String) result.get(TBTHB2KMEI.URMEINO.toUpperCase().trim()));              // 売上明細No
                    vo.setHb2Yymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase().trim()));                    // 年月
                    //--請求年月表示方法修正対応 2013/07/18 HLC H.Watabe start
                    vo.setHb2Name6((String) result.get(TBTHB2KMEI.NAME6.toUpperCase().trim()));                 //請求年月
                    //--請求年月表示方法修正対応 2013/07/18 HLC H.Watabe end
                    vo.setHb2Code1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));                  // コード1
                    vo.setHb2Code2((String) result.get(TBTHB2KMEI.CODE2.toUpperCase().trim()));                  // コード2
                    vo.setHb2Name8((String) result.get(TBTHB2KMEI.NAME8.toUpperCase().trim()));                  // 名称8
                    vo.setHb2Name3((String) result.get(TBTHB2KMEI.NAME3.toUpperCase().trim()));                  // 名称3
                    vo.setHb2Name4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase().trim()));                  // 名称4
                    vo.setHb2Name5((String) result.get(TBTHB2KMEI.NAME5.toUpperCase().trim()));                  // 名称5
                    vo.setHb2Name16((String) result.get(TBTHB2KMEI.NAME16.toUpperCase().trim()));                  // 名称16
                    vo.setHb2Kngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase().trim()));              // 金額3
                    vo.setHb2Seigak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase().trim()));            // 請求金額
                    vo.setHb14JyutNo((String) result.get(TBTHB14SKDOWN.JYUTNO.toUpperCase().trim()));            // 受注No
//                    vo.setOyako((String) result.get("OYAKOFLG"));                                                // 親子フラグ
                    vo.setHb1JyutNo((String) result.get(TBTHB1DOWN.JYUTNO.toUpperCase().trim()));            // 受注No
                    vo.setHb1TJyutNo((String) result.get(TBTHB1DOWN.TJYUTNO.toUpperCase().trim()));            // 統合先受注No

                    // 検索結果直後の状態にする
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }else if(_SelSqlMode == SelSqlMode.MEISAI2){

            if (getModel() instanceof ReportKmnVO) {

                for (int i = 0; i < hashList.size(); i++) {

                    Map result = (Map) hashList.get(i);
                    ReportKmnVO vo = new ReportKmnVO();

                    vo.setHb14JyutNo((String) result.get(TBTHB14SKDOWN.JYUTNO.toUpperCase().trim()));            // 受注No
                    vo.setHb1JyutNo((String) result.get(TBTHB1DOWN.JYUTNO.toUpperCase().trim()));                // 受注No
                    vo.setHb1TJyutNo((String) result.get(TBTHB1DOWN.TJYUTNO.toUpperCase().trim()));              // 統合先受注No

                    // 検索結果直後の状態にする
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }

        return list;
    }

}
