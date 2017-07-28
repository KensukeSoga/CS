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
 * 帳票（公文_請求一覧）データ検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class ReportKmnListDAO extends AbstractRdbDao {

    /**帳票（公文_請求一覧）検索条件 */
    private ReportKmnListCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{MEISAI1,MEISAI2,MEISAI3};
    private SqlMode _sqlMode = null;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportKmnListDAO() {
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

        if(_sqlMode == SqlMode.MEISAI1){

            sql.append(" SELECT ");
            sql.append("  " + TBTHB2KMEI.CODE2 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE3 + " ");
            sql.append(" ," + TBTHB2KMEI.JYUTNO + " ");
            sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.RENBN + " ");
            sql.append(" ," + TBTHB2KMEI.NAME11 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME12 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME13 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME14 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME1 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE1 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME5 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME2 + " ");
            sql.append(" ," + TBTHB2KMEI.KNGK1 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME15 + " ");
            sql.append(" ,(SELECT ");
            sql.append(" COUNT(" + TBTHB1DOWN.JYUTNO + ") FROM " + TBTHB14SKDOWN.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHB1DOWN.JYUTNO + " = " +  TBTHB14SKDOWN.JYUTNO  + " AND ");
            sql.append(TBTHB1DOWN.JYMEINO + " = " +  TBTHB14SKDOWN.JYMEINO  + " AND ");
            sql.append(TBTHB1DOWN.URMEINO + " = " +  TBTHB14SKDOWN.URMEINO  + " AND ");
            sql.append(TBTHB1DOWN.EGCD + " = " +  TBTHB14SKDOWN.EGCD  + " AND ");
            sql.append(TBTHB1DOWN.TKSKGYCD + " = " +  TBTHB14SKDOWN.TKSKGYCD  + " AND ");
            sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = " +  TBTHB14SKDOWN.TKSBMNSEQNO  + " AND ");
            sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = " +  TBTHB14SKDOWN.TKSTNTSEQNO  + " AND ");
            sql.append(TBTHB1DOWN.YYMM + " = " +  TBTHB14SKDOWN.SEIYYMM );
          //2013/11/07 add 不具合対応　ステータス追加 start
            sql.append(" AND " + TBTHB14SKDOWN.SEISTATUS  + " = '2' " );
           //2013/11/07 add 不具合対応　ステータス追加 end
            sql.append(" ) AS SKDOWN_CNT ");
            sql.append(" FROM ");
            sql.append("  " + TBTHB2KMEI.TBNAME + " ");
            sql.append(" ," + TBTHB1DOWN.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            //請求年月
            sql.append(TBTHB2KMEI.NAME6 + " = '" + _cond.getYm()  + "'  AND ");
            sql.append(TBTHB2KMEI.JYUTNO + " = " +  TBTHB1DOWN.JYUTNO  + " AND ");
            sql.append(TBTHB2KMEI.JYMEINO + " = " +  TBTHB1DOWN.JYMEINO  + " AND ");
            sql.append(TBTHB2KMEI.URMEINO + " = " +  TBTHB1DOWN.URMEINO  + " AND ");
            sql.append(TBTHB2KMEI.EGCD + " = " +  TBTHB1DOWN.EGCD  + " AND ");
            sql.append(TBTHB2KMEI.TKSKGYCD + " = " +  TBTHB1DOWN.TKSKGYCD  + " AND ");
            sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = " +  TBTHB1DOWN.TKSBMNSEQNO  + " AND ");
            sql.append(TBTHB2KMEI.TKSTNTSEQNO + " = " +  TBTHB1DOWN.TKSTNTSEQNO  + " AND ");
            sql.append(TBTHB2KMEI.YYMM + " = " +  TBTHB1DOWN.YYMM  + " AND ");
            sql.append(TBTHB1DOWN.TJYUTNO +  " = ' '   ");
            //部署コードが指定されていた場合
            if(!_cond.getBumonCd().equals("")){
                sql.append(" AND ");
                sql.append(TBTHB2KMEI.CODE1 + " = '" + _cond.getBumonCd()  + "' ");
            }
            sql.append("  ORDER BY ");
            sql.append(TBTHB2KMEI.JYUTNO + ", ");
            sql.append(TBTHB2KMEI.JYMEINO + ", ");
            sql.append(TBTHB2KMEI.URMEINO + ", ");
            sql.append(TBTHB2KMEI.RENBN);

        }else if(_sqlMode == SqlMode.MEISAI2){

            sql.append(" SELECT ");
            sql.append("  " + TBTHB2KMEI.CODE2 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE3 + " ");
            sql.append(" ," + TBTHB2KMEI.JYUTNO + " ");
            sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.RENBN + " ");
            sql.append(" ," + TBTHB2KMEI.NAME8 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME3 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME4 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME11 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME12 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME13 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME14 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME1 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE1 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME5 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME9 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME10 + " ");
            sql.append(" ," + TBTHB2KMEI.SEIGAK + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME2 + " ");
//            sql.append(" ," + TBTHB2KMEI.KNGK1 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME15 + " ");
            sql.append(" ,(SELECT ");
            sql.append(" COUNT(" + TBTHB1DOWN.JYUTNO + ") FROM " + TBTHB14SKDOWN.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHB1DOWN.JYUTNO + " = " +  TBTHB14SKDOWN.JYUTNO  + " AND ");
            sql.append(TBTHB1DOWN.JYMEINO + " = " +  TBTHB14SKDOWN.JYMEINO  + " AND ");
            sql.append(TBTHB1DOWN.URMEINO + " = " +  TBTHB14SKDOWN.URMEINO  + " AND ");
            sql.append(TBTHB1DOWN.EGCD + " = " +  TBTHB14SKDOWN.EGCD  + " AND ");
            sql.append(TBTHB1DOWN.TKSKGYCD + " = " +  TBTHB14SKDOWN.TKSKGYCD  + " AND ");
            sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = " +  TBTHB14SKDOWN.TKSBMNSEQNO  + " AND ");
            sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = " +  TBTHB14SKDOWN.TKSTNTSEQNO  + " AND ");
            sql.append(TBTHB1DOWN.YYMM + " = " +  TBTHB14SKDOWN.SEIYYMM );
          //2013/11/07 add 不具合対応　ステータス追加 start
            sql.append(" AND " + TBTHB14SKDOWN.SEISTATUS  + " = '2' " );
           //2013/11/07 add 不具合対応　ステータス追加 end
            sql.append(" ) AS SKDOWN_CNT ");
            sql.append(" FROM ");
            sql.append("  " + TBTHB2KMEI.TBNAME + " ");
            sql.append(" ," + TBTHB1DOWN.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            //請求年月
            sql.append(TBTHB2KMEI.NAME6 + " = '" + _cond.getYm()  + "'  AND ");
            sql.append(TBTHB2KMEI.JYUTNO + " = " +  TBTHB1DOWN.JYUTNO  + " AND ");
            sql.append(TBTHB2KMEI.JYMEINO + " = " +  TBTHB1DOWN.JYMEINO  + " AND ");
            sql.append(TBTHB2KMEI.URMEINO + " = " +  TBTHB1DOWN.URMEINO  + " AND ");
            sql.append(TBTHB2KMEI.EGCD + " = " +  TBTHB1DOWN.EGCD  + " AND ");
            sql.append(TBTHB2KMEI.TKSKGYCD + " = " +  TBTHB1DOWN.TKSKGYCD  + " AND ");
            sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = " +  TBTHB1DOWN.TKSBMNSEQNO  + " AND ");
            sql.append(TBTHB2KMEI.TKSTNTSEQNO + " = " +  TBTHB1DOWN.TKSTNTSEQNO  + " AND ");
            sql.append(TBTHB2KMEI.YYMM + " = " +  TBTHB1DOWN.YYMM  + " AND ");
            sql.append(TBTHB1DOWN.TJYUTNO +  " = ' '   ");
            //部署コードが指定されていた場合
            if(!_cond.getBumonCd().equals("")){
                sql.append(" AND ");
                sql.append(TBTHB2KMEI.CODE1 + " = '" + _cond.getBumonCd()  + "' ");
            }
            sql.append("  ORDER BY ");
            sql.append(TBTHB2KMEI.JYUTNO + ", ");
            sql.append(TBTHB2KMEI.JYMEINO + ", ");
            sql.append(TBTHB2KMEI.URMEINO + ", ");
            sql.append(TBTHB2KMEI.RENBN);

        }else if(_sqlMode == SqlMode.MEISAI3){

         // ====================================================================================================
            // SELECT句
            // ====================================================================================================
            sql.append(" SELECT");
            sql.append(" " + TBTHB14SKDOWN.JYUTNO);                              // 受注No
            sql.append("," + TBTHB1DOWN.JYUTNO);                                 // 受注No
            sql.append("," + TBTHB1DOWN.TJYUTNO);                                // 統合先受注No

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
     * 帳票（公文_請求一覧）の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportKmnListVO> findReportKmnListByCondition(ReportKmnListCondition cond) throws KKHException {

        super.setModel(new ReportKmnListVO());

        try {
            if(cond.getOutput().equals("明細")){
                _sqlMode = SqlMode.MEISAI1;
                _cond = cond;
                return super.find();
            }else{
                _sqlMode = SqlMode.MEISAI2;
                _cond = cond;
                return super.find();
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * 帳票（公文_請求一覧）の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportKmnListVO> findReportKmnListByCondition2(ReportKmnListCondition cond) throws KKHException {

        super.setModel(new ReportKmnListVO());

        try {
            _sqlMode = SqlMode.MEISAI3;
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
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<ReportKmnListVO> createFindedModelInstances(List hashList) {
        List<ReportKmnListVO> list = new ArrayList<ReportKmnListVO>();
        if (getModel() instanceof ReportKmnListVO) {

            if(_sqlMode == SqlMode.MEISAI1){

                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    ReportKmnListVO vo = new ReportKmnListVO();
                    vo.setShutNo((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
                    vo.setSeqNo((String)result.get(TBTHB2KMEI.CODE3.toUpperCase()));
                    vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                    vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                    vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
                    vo.setRenban((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
                    vo.setNaiyo((String)result.get(TBTHB2KMEI.NAME11.toUpperCase()) +
                            (String)result.get(TBTHB2KMEI.NAME12.toUpperCase()) +
                            (String)result.get(TBTHB2KMEI.NAME13.toUpperCase()) +
                            (String)result.get(TBTHB2KMEI.NAME14.toUpperCase()));
                    vo.setHimoku((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
                    vo.setBumonCd((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                    vo.setBumonNm((String)result.get(TBTHB2KMEI.NAME5.toUpperCase()));
                    vo.setKikan((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                    vo.setKingaku((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
                    vo.setBiko((String)result.get(TBTHB2KMEI.NAME15.toUpperCase()));

                    BigDecimal cnt = (BigDecimal)result.get("SKDOWN_CNT");

                    // 請求済みステータスの設定
                    if(cnt.compareTo(BigDecimal.ZERO) == 0){

                        // ブランクを設定する
                        vo.setSeiZumi("");

                    }else{

                        // 済を設定する
                        vo.setSeiZumi("済");
                    }

                    // 検索結果直後の状態にする
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }

            }else if(_sqlMode == SqlMode.MEISAI2){

                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    ReportKmnListVO vo = new ReportKmnListVO();
                    vo.setShutNo((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
                    vo.setSeqNo((String)result.get(TBTHB2KMEI.CODE3.toUpperCase()));
                    vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                    vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                    vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
                    vo.setRenban((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
                    vo.setNaiyo((String)result.get(TBTHB2KMEI.NAME8.toUpperCase()) +
                                (String)result.get(TBTHB2KMEI.NAME3.toUpperCase()) +
                                (String)result.get(TBTHB2KMEI.NAME4.toUpperCase()));
                    vo.setHimoku((String)result.get(TBTHB2KMEI.NAME9.toUpperCase()));
                    vo.setBumonCd((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                    vo.setBumonNm((String)result.get(TBTHB2KMEI.NAME5.toUpperCase()));
                    vo.setKikan((String)result.get(TBTHB2KMEI.NAME10.toUpperCase()));
                    vo.setKingaku((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                    vo.setBiko((String)result.get(TBTHB2KMEI.NAME15.toUpperCase()));

                    BigDecimal cnt = (BigDecimal)result.get("SKDOWN_CNT");
                    vo.setSeiZumi(cnt.toString());


                    // 請求済みステータスの設定
//                    if(cnt.compareTo(BigDecimal.ZERO) == 0){
//
//                        // ブランクを設定する
//                        vo.setSeiZumi("");
//
//                    }else{
//
//                        // 済を設定する
//                        vo.setSeiZumi("済");
//                    }

                    // 検索結果直後の状態にする
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }

            else if(_sqlMode == SqlMode.MEISAI3){

                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    ReportKmnListVO vo = new ReportKmnListVO();

                    vo.setSkJyutNo((String) result.get(TBTHB14SKDOWN.JYUTNO.toUpperCase().trim()));            // 受注No
                    vo.setDJyutNo((String) result.get(TBTHB1DOWN.JYUTNO.toUpperCase().trim()));                // 受注No
                    vo.setDTJyutNo((String) result.get(TBTHB1DOWN.TJYUTNO.toUpperCase().trim()));              // 統合先受注No

                    // 検索結果直後の状態にする
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }

        return list;
    }

}
