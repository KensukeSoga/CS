package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 発注データ登録DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/6 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class Thb5HikDAO extends AbstractSimpleRdbDao  {

//	private Thb5HikVO _vo;
    private HikVO _cond;
     /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{COMMON,};
    private SqlMode _sqlMode = SqlMode.COMMON;

    /**
     * デフォルトコンストラクタ。
     */
    public Thb5HikDAO() {
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
                TBTHB5HIK.TKSKGYCD,
                TBTHB5HIK.TKSBMNSEQNO,
                TBTHB5HIK.TKSTNTSEQNO,
                TBTHB5HIK.RECCD,
                TBTHB5HIK.IRBAN,
                TBTHB5HIK.IRROWBAN,
                TBTHB5HIK.RIRENO
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
        return TBTHB5HIK.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
            TBTHB5HIK.TRKTIMSTMP,
            TBTHB5HIK.TRKPL,
            TBTHB5HIK.TRKTNT,
            TBTHB5HIK.UPDTIMSTMP,
            TBTHB5HIK.UPDAPL,
            TBTHB5HIK.UPDTN,
            TBTHB5HIK.EGCD,
            TBTHB5HIK.TKSKGYCD,
            TBTHB5HIK.TKSBMNSEQNO,
            TBTHB5HIK.TKSTNTSEQNO,
            TBTHB5HIK.SYBT,
            TBTHB5HIK.RECCD,
            TBTHB5HIK.KOUKBN,
            TBTHB5HIK.RIRENO,
            TBTHB5HIK.IRYYMM,
            TBTHB5HIK.IRKBN,
            TBTHB5HIK.TOKUICD,
            TBTHB5HIK.EICODE,
            TBTHB5HIK.EINAME,
            TBTHB5HIK.TENCD,
            TBTHB5HIK.TENNAME,
            TBTHB5HIK.YOSAKBN,
            TBTHB5HIK.IRNAI,
            TBTHB5HIK.IRBAN,
            TBTHB5HIK.IRROWBAN,
            TBTHB5HIK.MEDIACD,
            TBTHB5HIK.MEDIANAME,
            TBTHB5HIK.SIZECD,
            TBTHB5HIK.SIZENAME,
            TBTHB5HIK.KEISAI1,
            TBTHB5HIK.KEISAI2,
            TBTHB5HIK.KEISAI3,
            TBTHB5HIK.KEISAI4,
            TBTHB5HIK.KEISAI5,
            TBTHB5HIK.KEITAICD,
            TBTHB5HIK.KEITAINAME,
            TBTHB5HIK.IRMONTH1,
            TBTHB5HIK.HOSORYO1,
            TBTHB5HIK.IRMONTH2,
            TBTHB5HIK.HOSORYO2,
            TBTHB5HIK.IRMONTH3,
            TBTHB5HIK.HOSORYO3,
            TBTHB5HIK.IRMONTH4,
            TBTHB5HIK.HOSORYO4,
            TBTHB5HIK.IRMONTH5,
            TBTHB5HIK.HOSORYO5,
            TBTHB5HIK.IRMONTH6,
            TBTHB5HIK.HOSORYO6,
            TBTHB5HIK.KOTUKEICD,
            TBTHB5HIK.KOTUKEINAME,
            TBTHB5HIK.KEISAI,
            TBTHB5HIK.KEISAIRYO,
            TBTHB5HIK.KEISAITANKA,
            TBTHB5HIK.KEISAICNT,
            TBTHB5HIK.SYOHIKBN,
            TBTHB5HIK.SYOHINAME,
            TBTHB5HIK.SAIKBN,
            TBTHB5HIK.TEKICD,
            TBTHB5HIK.URIYYMM,
            TBTHB5HIK.TANNAME,
            TBTHB5HIK.TANKINNAME,
            TBTHB5HIK.ANSYUBE,
            TBTHB5HIK.BIKOU1,
            TBTHB5HIK.BIKOU2,
            TBTHB5HIK.COLORCD,
            TBTHB5HIK.SPACECD,
            TBTHB5HIK.SPACENAME,
            TBTHB5HIK.SYBT1CD,
            TBTHB5HIK.SYBT2CD,
            TBTHB5HIK.DESIGNCNT,
            TBTHB5HIK.PLACECD,
            TBTHB5HIK.PRINTRYO,
            TBTHB5HIK.SASHIKAERYO,
            TBTHB5HIK.DESIGNRYO,
            TBTHB5HIK.HANSHITARYO,
            TBTHB5HIK.SEIHANRYO,
            TBTHB5HIK.TOUDATE,
            TBTHB5HIK.HENDATE,
            TBTHB5HIK.TORDATE
        };
    }

    /**
     * 実施NO自動UP/DOWNの登録を行います。
     *
     * @param vo VO 実施NoVO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void thb5Hikfind(Thb5HikVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        //super.setModel(vo);
//        _vo = vo;

        try {
          super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public  String getSelectSQL() {
        if (_sqlMode.equals(SqlMode.COMMON)){
            return getExecString();
        }
        return "";
    }

    /**
     * EXEC-SQL生成
     */
    @Override
    public String getExecString() {

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
        sql.append(" " + TBTHB5HIK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB5HIK.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB5HIK.TKSBMNSEQNO + " = '" +_cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB5HIK.TKSTNTSEQNO + " = '" +_cond.getTksTntSeqNo()+ "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB5HIK.IRBAN + " = '" +_cond.getIrban() + "' ");

        return sql.toString();
    }

    /**
     * 広告費明細テーブルの条件指定検索を行います。
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<HikVO> findThb5HikByCondCmn(HikVO Cond) throws KKHException {

        super.setModel(new HikVO());

        try {
            _cond = Cond;
//        	_selSqlMode = SelSqlMode.COND_CMN;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

}