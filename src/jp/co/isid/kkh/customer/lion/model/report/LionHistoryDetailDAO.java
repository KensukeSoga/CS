package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB92RRKKMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;

/**
 *
 * <P>
 * ライオン履歴ヘッダー作成DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */

public class LionHistoryDetailDAO extends AbstractRdbDao {

    /** ライオン履歴作成条件 */
    LionHistoryCondition _cond = null;

    /**
     * デフォルトコンストラクタ。
     */
    public LionHistoryDetailDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     * @return String[] プライマリキー
     */
    @Override
    public String[] getPrimryKeyNames() {
        return new String[] {
                TBTHB92RRKKMEI.RRKTIMSTMP
                ,TBTHB92RRKKMEI.EGCD
                ,TBTHB92RRKKMEI.TKSKGYCD
                ,TBTHB92RRKKMEI.TKSBMNSEQNO
                ,TBTHB92RRKKMEI.TKSTNTSEQNO
                ,TBTHB92RRKKMEI.YYMM
                ,TBTHB92RRKKMEI.JYUTNO
                ,TBTHB92RRKKMEI.JYMEINO
                ,TBTHB92RRKKMEI.URMEINO
                ,TBTHB92RRKKMEI.RENBN
        };
    }

    /**
     * 更新日付フィールドを返します。
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * テーブル名を返します。
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return TBTHB92RRKKMEI.TBNAME;
    }

    /**
     * テーブル列名を返します。
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        //return null;
        return new String[] {
                TBTHB92RRKKMEI.TIMSTMP
                ,TBTHB92RRKKMEI.UPDAPL
                ,TBTHB92RRKKMEI.UPDTNT
                ,TBTHB92RRKKMEI.RRKTIMSTMP
                ,TBTHB92RRKKMEI.EGCD
                ,TBTHB92RRKKMEI.TKSKGYCD
                ,TBTHB92RRKKMEI.TKSBMNSEQNO
                ,TBTHB92RRKKMEI.TKSTNTSEQNO
                ,TBTHB92RRKKMEI.YYMM
                ,TBTHB92RRKKMEI.JYUTNO
                ,TBTHB92RRKKMEI.JYMEINO
                ,TBTHB92RRKKMEI.URMEINO
                ,TBTHB92RRKKMEI.HIMKCD
                ,TBTHB92RRKKMEI.RENBN
                ,TBTHB92RRKKMEI.DATEFROM
                ,TBTHB92RRKKMEI.DATETO
                ,TBTHB92RRKKMEI.SEIGAK
                ,TBTHB92RRKKMEI.HNNERT
                ,TBTHB92RRKKMEI.HNMAEGAK
                ,TBTHB92RRKKMEI.NEBIGAK
                ,TBTHB92RRKKMEI.DATE1
                ,TBTHB92RRKKMEI.DATE2
                ,TBTHB92RRKKMEI.DATE3
                ,TBTHB92RRKKMEI.DATE4
                ,TBTHB92RRKKMEI.DATE5
                ,TBTHB92RRKKMEI.DATE6
                ,TBTHB92RRKKMEI.KBN1
                ,TBTHB92RRKKMEI.KBN2
                ,TBTHB92RRKKMEI.KBN3
                ,TBTHB92RRKKMEI.CODE1
                ,TBTHB92RRKKMEI.CODE2
                ,TBTHB92RRKKMEI.CODE3
                ,TBTHB92RRKKMEI.CODE4
                ,TBTHB92RRKKMEI.CODE5
                ,TBTHB92RRKKMEI.CODE6
                ,TBTHB92RRKKMEI.NAME1
                ,TBTHB92RRKKMEI.NAME2
                ,TBTHB92RRKKMEI.NAME3
                ,TBTHB92RRKKMEI.NAME4
                ,TBTHB92RRKKMEI.NAME5
                ,TBTHB92RRKKMEI.NAME6
                ,TBTHB92RRKKMEI.NAME7
                ,TBTHB92RRKKMEI.NAME8
                ,TBTHB92RRKKMEI.NAME9
                ,TBTHB92RRKKMEI.NAME10
                ,TBTHB92RRKKMEI.NAME11
                ,TBTHB92RRKKMEI.NAME12
                ,TBTHB92RRKKMEI.NAME13
                ,TBTHB92RRKKMEI.NAME14
                ,TBTHB92RRKKMEI.NAME15
                ,TBTHB92RRKKMEI.NAME16
                ,TBTHB92RRKKMEI.NAME17
                ,TBTHB92RRKKMEI.NAME18
                ,TBTHB92RRKKMEI.NAME19
                ,TBTHB92RRKKMEI.NAME20
                ,TBTHB92RRKKMEI.NAME21
                ,TBTHB92RRKKMEI.NAME22
                ,TBTHB92RRKKMEI.NAME23
                ,TBTHB92RRKKMEI.NAME24
                ,TBTHB92RRKKMEI.NAME25
                ,TBTHB92RRKKMEI.NAME26
                ,TBTHB92RRKKMEI.NAME27
                ,TBTHB92RRKKMEI.NAME28
                ,TBTHB92RRKKMEI.NAME29
                ,TBTHB92RRKKMEI.NAME30
                ,TBTHB92RRKKMEI.KNGK1
                ,TBTHB92RRKKMEI.KNGK2
                ,TBTHB92RRKKMEI.KNGK3
                ,TBTHB92RRKKMEI.RITU1
                ,TBTHB92RRKKMEI.RITU2
                ,TBTHB92RRKKMEI.SONOTA1
                ,TBTHB92RRKKMEI.SONOTA2
                ,TBTHB92RRKKMEI.SONOTA3
                ,TBTHB92RRKKMEI.SONOTA4
                ,TBTHB92RRKKMEI.SONOTA5
                ,TBTHB92RRKKMEI.SONOTA6
                ,TBTHB92RRKKMEI.SONOTA7
                ,TBTHB92RRKKMEI.SONOTA8
                ,TBTHB92RRKKMEI.SONOTA9
                ,TBTHB92RRKKMEI.SONOTA10
                ,TBTHB92RRKKMEI.BUNFLG
                ,TBTHB92RRKKMEI.MEIHNFLG
                ,TBTHB92RRKKMEI.NEBHNFLG
        };
    }

    /**
     * SQL文生成
     * @return String SQL文
     */
    public String getExecString() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("INSERT INTO");
        sql.append(" " + TBTHB92RRKKMEI.TBNAME);
        sql.append(" SELECT");
        sql.append(" " + TBTHB2KMEI.TIMSTMP + ",");         //タイムスタンプ
        sql.append(" " + TBTHB2KMEI.UPDAPL + ",");          //更新プログラム
        sql.append(" " + TBTHB2KMEI.UPDTNT + ",");          //更新担当者
        sql.append(" TO_DATE('" + _cond.getRrkTimStmp() + "','YYYY-MM-DD HH24:MI:SS'),");   //履歴タイムスタンプ
        sql.append(" " + TBTHB2KMEI.EGCD + ",");            //営業所コード
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");        //得意先企業コード
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");     //得意先部門SEQNO
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");     //得意先担当SEQNO
        sql.append(" " + TBTHB2KMEI.YYMM + ",");            //年月
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");          //受注No
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");         //受注明細No
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");         //売上明細No
        sql.append(" " + TBTHB2KMEI.HIMKCD + ",");          //費目コード
        sql.append(" " + TBTHB2KMEI.RENBN + ",");           //連番
        sql.append(" " + TBTHB2KMEI.DATEFROM + ",");        //年月日From
        sql.append(" " + TBTHB2KMEI.DATETO + ",");          //年月日To
        sql.append(" " + TBTHB2KMEI.SEIGAK + ",");          //請求金額
        sql.append(" " + TBTHB2KMEI.HNNERT + ",");          //変更値引率
        sql.append(" " + TBTHB2KMEI.HNMAEGAK + ",");        //値引率変更前金額
        sql.append(" " + TBTHB2KMEI.NEBIGAK + ",");         //値引額
        sql.append(" " + TBTHB2KMEI.DATE1 + ",");           //日付1
        sql.append(" " + TBTHB2KMEI.DATE2 + ",");           //日付2
        sql.append(" " + TBTHB2KMEI.DATE3 + ",");           //日付3
        sql.append(" " + TBTHB2KMEI.DATE4 + ",");           //日付4
        sql.append(" " + TBTHB2KMEI.DATE5 + ",");           //日付5
        sql.append(" " + TBTHB2KMEI.DATE6 + ",");           //日付6
        sql.append(" " + TBTHB2KMEI.KBN1 + ",");            //区分1
        sql.append(" " + TBTHB2KMEI.KBN2 + ",");            //区分2
        sql.append(" " + TBTHB2KMEI.KBN3 + ",");            //区分3
        sql.append(" " + TBTHB2KMEI.CODE1 + ",");           //コード1
        sql.append(" " + TBTHB2KMEI.CODE2 + ",");           //コード2
        sql.append(" " + TBTHB2KMEI.CODE3 + ",");           //コード3
        sql.append(" " + TBTHB2KMEI.CODE4 + ",");           //コード4
        sql.append(" " + TBTHB2KMEI.CODE5 + ",");           //コード5
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");           //コード6
        sql.append(" " + TBTHB2KMEI.NAME1 + ",");           //名称1(漢字)
        sql.append(" " + TBTHB2KMEI.NAME2 + ",");           //名称2(漢字))
        sql.append(" " + TBTHB2KMEI.NAME3 + ",");           //名称3(漢字)
        sql.append(" " + TBTHB2KMEI.NAME4 + ",");           //名称4(漢字)
        sql.append(" " + TBTHB2KMEI.NAME5 + ",");           //名称5(漢字)
        sql.append(" " + TBTHB2KMEI.NAME6 + ",");           //名称6(漢字)
        sql.append(" " + TBTHB2KMEI.NAME7 + ",");           //名称7(漢字)
        sql.append(" " + TBTHB2KMEI.NAME8 + ",");           //名称8(漢字))
        sql.append(" " + TBTHB2KMEI.NAME9 + ",");           //名称9(漢字)
        sql.append(" " + TBTHB2KMEI.NAME10 + ",");          //名称10(漢字)
        sql.append(" " + TBTHB2KMEI.NAME11 + ",");          //名称11(漢字)
        sql.append(" " + TBTHB2KMEI.NAME12 + ",");          //名称12(漢字)
        sql.append(" " + TBTHB2KMEI.NAME13 + ",");          //名称13(漢字)
        sql.append(" " + TBTHB2KMEI.NAME14 + ",");          //名称14(漢字)
        sql.append(" " + TBTHB2KMEI.NAME15 + ",");          //名称15(漢字)
        sql.append(" " + TBTHB2KMEI.NAME16 + ",");          //名称16(漢字)
        sql.append(" " + TBTHB2KMEI.NAME17 + ",");          //名称17(漢字)
        sql.append(" " + TBTHB2KMEI.NAME18 + ",");          //名称18(漢字)
        sql.append(" " + TBTHB2KMEI.NAME19 + ",");          //名称19(漢字)
        sql.append(" " + TBTHB2KMEI.NAME20 + ",");          //名称20(漢字)
        sql.append(" " + TBTHB2KMEI.NAME21 + ",");          //名称21(漢字)
        sql.append(" " + TBTHB2KMEI.NAME22 + ",");          //名称22(漢字)
        sql.append(" " + TBTHB2KMEI.NAME23 + ",");          //名称23(漢字)
        sql.append(" " + TBTHB2KMEI.NAME24 + ",");          //名称24(漢字)
        sql.append(" " + TBTHB2KMEI.NAME25 + ",");          //名称25(漢字)
        sql.append(" " + TBTHB2KMEI.NAME26 + ",");          //名称26(漢字)
        sql.append(" " + TBTHB2KMEI.NAME27 + ",");          //名称27(漢字)
        sql.append(" " + TBTHB2KMEI.NAME28 + ",");          //名称28(漢字)
        sql.append(" " + TBTHB2KMEI.NAME29 + ",");          //名称29(漢字)
        sql.append(" " + TBTHB2KMEI.NAME30 + ",");          //名称30(漢字)
        sql.append(" " + TBTHB2KMEI.KNGK1 + ",");           //金額1
        sql.append(" " + TBTHB2KMEI.KNGK2 + ",");           //金額2
        sql.append(" " + TBTHB2KMEI.KNGK3 + ",");           //金額3
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");           //比率1
        sql.append(" " + TBTHB2KMEI.RITU2 + ",");           //比率2
        sql.append(" " + TBTHB2KMEI.SONOTA1 + ",");         //その他1
        sql.append(" " + TBTHB2KMEI.SONOTA2 + ",");         //その他2
        sql.append(" " + TBTHB2KMEI.SONOTA3 + ",");         //その他3
        sql.append(" " + TBTHB2KMEI.SONOTA4 + ",");         //その他4
        sql.append(" " + TBTHB2KMEI.SONOTA5 + ",");         //その他5
        sql.append(" " + TBTHB2KMEI.SONOTA6 + ",");         //その他6
        sql.append(" " + TBTHB2KMEI.SONOTA7 + ",");         //その他7
        sql.append(" " + TBTHB2KMEI.SONOTA8 + ",");         //その他8
        sql.append(" " + TBTHB2KMEI.SONOTA9 + ",");         //その他9
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");        //その他10
        sql.append(" " + TBTHB2KMEI.BUNFLG + ",");          //分割フラグ
        sql.append(" " + TBTHB2KMEI.MEIHNFLG + ",");        //件名変更フラグ
        sql.append(" " + TBTHB2KMEI.NEBHNFLG + ",");              //値引率変更フラグ
        sql.append(" '" + _cond.getEsqId() + "'");          //履歴登録担当者(ESQ-ID)
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "'");

        return sql.toString();
    }

    /**
     * 広告費明細履歴を作成
     * @param cond 検索条件
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void insertHistoryDetailCreate(LionHistoryCondition cond)
            throws KKHException {
        try {
            _cond = cond;
            super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

}
