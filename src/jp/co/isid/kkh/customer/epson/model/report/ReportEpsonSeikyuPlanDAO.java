package jp.co.isid.kkh.customer.epson.model.report;

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
 * 請求予定一覧（エプソン)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/9 IP JK)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSeikyuPlanDAO extends AbstractRdbDao {

    /** 検索条件 */
    private ReportEpsonSeikyuPlanCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportEpsonSeikyuPlanDAO() {
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
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    /**
     * 提出帳票情報取得のSQL文を返します。
     *
     * @return String SQL文
     */
    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        // ====================================================================================================
        // SELECT句
        // ====================================================================================================
        sql.append(" SELECT ");
        // 2015/04/06 エプソン件名拡張対応 Fujisaki Cng Start
        //sql.append(          TBTHB2KMEI.NAME8 	+ " ");          // 広告件名
        sql.append(          TBTHB2KMEI.NAME11 	+ " ");          // 広告件名(拡張対応)
        // 2015/04/06 エプソン件名拡張対応 Fujisaki Cng End
        sql.append("    ," + TBTHB2KMEI.NAME3 	+ " ");          // ご担当
        sql.append("    ," + TBTHB2KMEI.NAME10  + " ");          // 件名
        sql.append("    ," + TBTHB2KMEI.CODE4   + " ");          // 取引識別コード
        sql.append("    ," + TBTHB2KMEI.KNGK2   + " ");          // 事前
        sql.append("    ," + TBTHB2KMEI.SEIGAK   + " ");         // 事後
        sql.append("    ,CASE " + TBTHB2KMEI.CODE3);
        sql.append("         WHEN ' ' THEN 'zzz'");
        sql.append("         ELSE " + TBTHB2KMEI.CODE3);
        sql.append("     END AS SORT_KEY");
        sql.append("    ," + TBTHB2KMEI.JYUTNO);
        sql.append("    ," + TBTHB2KMEI.JYMEINO);
        sql.append("    ," + TBTHB2KMEI.URMEINO);

        // ====================================================================================================
        // FROM句
        // ====================================================================================================
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME);

        // ====================================================================================================
        // WHERE句
        // ====================================================================================================
        sql.append(" WHERE");
        // 検索条件 ---------------------------------------------------------------------------------------------
        sql.append("     " + TBTHB2KMEI.EGCD + "           = '" + _cond.getEgCd() + "'");          // 営業所コード
        sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "       = '" + _cond.getTksKgyCd() + "'");      // 得意先企業コード
        sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + "    = '" + _cond.getTksBmnSeqNo() + "'");   // 得意先部門SEQNO
        sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + "    = '" + _cond.getTksTntSeqNo() + "'");   // 得意先担当SEQNO
        sql.append(" AND " + TBTHB2KMEI.YYMM  + "          = '" + _cond.getYm() + "'");            // 年月
        sql.append(" AND " + TBTHB2KMEI.NAME21  + "        = '1'");                                // 明細種別

        // ====================================================================================================
        // ORDER BY句
        // ====================================================================================================
        sql.append(" ORDER BY");
        //sql.append("    " + TBTHB2KMEI.NAME3  + " ");         // ご担当
        //sql.append("   ," + TBTHB2KMEI.NAME8  + " ");         // 広告件名
        //sql.append("   ," + TBTHB2KMEI.NAME10);               // 件名
        sql.append("    SORT_KEY");
        sql.append("    ," + TBTHB2KMEI.JYUTNO);
        sql.append("    ," + TBTHB2KMEI.JYMEINO);
        sql.append("    ," + TBTHB2KMEI.URMEINO);

        return sql.toString();
    }


    /**
     * 請求予定一覧データ（エプソン)の検索を行います。
     *
     * @return 請求予定一覧（エプソン)VO リスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportEpsonSeikyuPlanVO> findReportEpsonSeikyuPlanByCondition(ReportEpsonSeikyuPlanCondition cond)
            throws KKHException {

        super.setModel(new ReportEpsonSeikyuPlanVO());

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
     * @param hashList
     *            List 検索結果
     * @return List<ReportEpsonSeikyuPlanVO> 変換後の検索結果
     */
    @Override
    protected List<ReportEpsonSeikyuPlanVO> createFindedModelInstances(List hashList) {

        List<ReportEpsonSeikyuPlanVO> list = new ArrayList<ReportEpsonSeikyuPlanVO>();

        if (getModel() instanceof ReportEpsonSeikyuPlanVO) {

            for (int i = 0; i < hashList.size(); i++) {

                Map result = (Map) hashList.get(i);
                ReportEpsonSeikyuPlanVO vo = new ReportEpsonSeikyuPlanVO();

                // 2015/04/06 エプソン件名拡張対応 Fujisaki Cng Start
                //vo.setNAME8((String) result.get(TBTHB2KMEI.NAME8.toUpperCase().trim()));         // 広告件名
                vo.setNAME11((String) result.get(TBTHB2KMEI.NAME11.toUpperCase().trim()));        // 広告件名(拡張対応)
                // 2015/04/06 エプソン件名拡張対応 Fujisaki Cng Start
                vo.setNAME3((String) result.get(TBTHB2KMEI.NAME3.toUpperCase().trim()));         // ご担当
                vo.setNAME10((String) result.get(TBTHB2KMEI.NAME10.toUpperCase().trim()));       // 件名
                vo.setCODE4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));         // 取引識別コード
                vo.setKNGK2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase().trim()));         // 事前
                vo.setSEIGAK((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase().trim()));       // 事後

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
