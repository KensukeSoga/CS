package jp.co.isid.kkh.customer.tkd.model.detail;

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
 * ・新規作成(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class UpJissiBycondDAO extends AbstractSimpleRdbDao  {

    private UpJissiBycondVO _vo;

    /**
     * デフォルトコンストラクタ。
     */
    public UpJissiBycondDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    @Override
    public String[] getPrimryKeyNames() {
        // TODO 自動生成されたメソッド・スタブ
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
     * 実施NO自動UP/DOWNの登録を行います。
     *
     * @param vo VO 実施NoVO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void jissiUp(UpJissiBycondVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        //super.setModel(vo);
        _vo = vo;

        try {
          super.exec();
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

        sql.append("UPDATE");
        sql.append(" THB2KMEI");
        sql.append(" SET");
        sql.append(" HB2_KNGK1 =");
        sql.append(" HB2_KNGK1 ");
        sql.append(_vo.get_atnum());
        sql.append(" WHERE ");
        sql.append(" HB2_EGCD = ");
        sql.append("'" + _vo.get_egCd()+"'");
        sql.append(" AND ");
        sql.append(" HB2_TKSKGYCD = ");
        sql.append("'"+_vo.get_tksKgyCd()+"'");
        sql.append("AND");
        sql.append(" HB2_TKSBMNSEQNO = ");
        sql.append("'"+_vo.get_tksBmnSeqNo()+"'");
        sql.append(" AND ");
        sql.append(" HB2_TKSTNTSEQNO = ");
        sql.append("'" + _vo.get_TksTntSeqNo() + "'");
        sql.append(" AND ");
        sql.append(" HB2_YYMM = ");
        sql.append("'"+_vo.get_YYMM() +"'");
        sql.append("AND");
        sql.append(" HB2_KNGK1 >= 1");
//    	sql.append(" AND ");
//    	sql.append(" NOT HB2_KBN2 = 0 ");

        return sql.toString();
    }

}
