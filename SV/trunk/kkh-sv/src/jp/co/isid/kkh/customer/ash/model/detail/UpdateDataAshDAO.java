package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 更新DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/29 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateDataAshDAO extends AbstractSimpleRdbDao {

    private Thb2KmeiVO _vo;

    /**
     * デフォルトコンストラクタ。
     */
    public UpdateDataAshDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    @Override
    public String[] getPrimryKeyNames() {
        return null;
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
     * 更新を行います。広告費明細データの更新(受注統合用)
     *
     * @param vo VO
     * @return int 更新件数
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public int updateThb2Kmei(Thb2KmeiVO vo)
            throws KKHException {
        // パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        super.setModel(vo);
        try {
            _vo = vo;
            return super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * EXEC-SQL生成
     */
    @Override
    public String getExecString() {
        StringBuffer sql = new StringBuffer();

        sql.append(" UPDATE ");
        sql.append("     " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" SET ");
    	sql.append("    " + TBTHB2KMEI.TIMSTMP + " = SYSDATE ");
        sql.append("   ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO           + " = '" + _vo.getHb2JyutNo() + "' ");
        sql.append("   ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO          + " = '" + _vo.getHb2JyMeiNo() + "' ");
        sql.append("   ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO          + " = '" + _vo.getHb2UrMeiNo() + "' ");
        sql.append("   ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SEIGAK           + " = '" + _vo.getHb2SeiGak() + "' ");
        sql.append("   ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HNMAEGAK         + " = '" + _vo.getHb2HnmaeGak() + "' ");
        sql.append(" WHERE ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD             + " = '" + _vo.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD         + " = '" + _vo.getHb2TksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO      + " = '" + _vo.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO      + " = '" + _vo.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM             + " = '" + _vo.getHb2Yymm() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO           + " = '" + _vo.getHb2JyutNo() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO          + " = '" + _vo.getHb2JyMeiNo() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO          + " = '" + _vo.getHb2UrMeiNo() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RENBN            + " = '" + _vo.getHb2Renbn() + "' ");

        return sql.toString();
    }
}
