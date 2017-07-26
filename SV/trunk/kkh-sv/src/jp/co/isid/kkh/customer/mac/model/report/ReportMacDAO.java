package jp.co.isid.kkh.customer.mac.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
 * 帳票（MAC)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE KT)<BR>
 * ・不具合対応(2014/04/30 HLC S.Fujimoto)<BR>
 * </P>
 * @author JSE KT
 */
public class ReportMacDAO extends AbstractRdbDao {

    /**汎用マスタ検索条件 */
    private ReportMacCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportMacDAO() {
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

        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.SEIGAK + " ");
        sql.append(" ," + TBTHB2KMEI.DATE1 + " ");
        sql.append(" ," + TBTHB2KMEI.KBN1 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE1 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE2 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE4 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME1 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME2 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME3 + " ");
        sql.append(" ," + TBTHB2KMEI.KNGK1 + " ");
        sql.append(" ," + TBTHB2KMEI.KNGK2 + " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA1 + " ");
        sql.append(" ," + TBTHB2KMEI.JYUTNO + " ");
        sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
        sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
        sql.append(" ," + TBTHB2KMEI.RENBN + " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA2 + " ");
        //消費税対応 2013/10/21 add HLC H.Watabe start
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + " * 0.01) AS "+ TBTHB2KMEI.RITU1 + " ");
        //消費税対応 2013/10/21 add HLC H.Watabe end
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + " ");
        /* 不具合対応 2014/04/30 fujimoto ADD start */
        sql.append(", " + TBTHB1DOWN.TBNAME);
        /* 不具合対応 2014/04/30 fujimoto ADD end */
        sql.append(" WHERE ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        /* 不具合対応 2014/04/30 fujimoto ADD start */
        sql.append(TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD);
        sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD);
        sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO);
        sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO);
        sql.append(" AND " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO);
        sql.append(" AND " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO);
        sql.append(" AND " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO);
        sql.append(" AND " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM);
        sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" AND ");
        /* 不具合対応 2014/04/30 fujimoto ADD end */
        sql.append(TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "'  AND ");
        sql.append(TBTHB2KMEI.SONOTA1 + " != ' ' AND ");
        sql.append(TBTHB2KMEI.KBN1 + "  != '2'  ");
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
        sql.append("  ORDER BY ");
        sql.append(TBTHB2KMEI.CODE2 + ", ");
        sql.append(TBTHB2KMEI.CODE1 + ", ");
        sql.append(TBTHB2KMEI.SONOTA1);

        return sql.toString();
    }

    /**
     * 帳票データ（MAC)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportMacVO> findReportMacByCondition(ReportMacCondition cond) throws KKHException {

        super.setModel(new ReportMacVO());

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
     * @param hashList List 検索結果
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<ReportMacVO> createFindedModelInstances(List hashList) {
        List<ReportMacVO> list = new ArrayList<ReportMacVO>();
        if (getModel() instanceof ReportMacVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportMacVO vo = new ReportMacVO();
                vo.setSeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setDate1((String)result.get(TBTHB2KMEI.DATE1.toUpperCase()));
                vo.setKbn1((String)result.get(TBTHB2KMEI.KBN1.toUpperCase()));
                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                vo.setCode2((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
                vo.setCode4((String)result.get(TBTHB2KMEI.CODE4.toUpperCase()));
                vo.setName1((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
                vo.setName2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                vo.setName3((String)result.get(TBTHB2KMEI.NAME3.toUpperCase()));
                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
                vo.setKngk2((BigDecimal)result.get(TBTHB2KMEI.KNGK2.toUpperCase()));
                vo.setSonota1((String)result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));
                vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
                vo.setRenbn((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
                vo.setSonota2((String)result.get(TBTHB2KMEI.SONOTA2.toUpperCase()));
                //消費税対応 2013/10/22 add HLC H.Watabe start
                vo.setRitu1((BigDecimal)result.get(TBTHB2KMEI.RITU1.toUpperCase()));
                //消費税対応 2013/10/22 add HLC H.Watabe end
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
