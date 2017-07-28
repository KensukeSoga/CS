package jp.co.isid.kkh.model.detail;


import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 受注番号統合DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/27 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class JyutNoTouUpdateDAO extends AbstractSimpleRdbDao  {

    private JyutNoTouUpdateVO _vo;

    /**
     * デフォルトコンストラクタ。
     */
    public JyutNoTouUpdateDAO() {
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
        return TBTHB1DOWN.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{};
    }

    /**
     * 受注内容統合登録を行います。
     *
     * @param vo VO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void JyutNoTouUpdate(JyutNoTouUpdateVO vo) throws KKHException {
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

        sql.append(" UPDATE ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" SET ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = '" + _vo.get_keyJyutno() + "', ");
        sql.append(" " + TBTHB1DOWN.TJYMEINO + " = '" + _vo.get_keyJyMeiNo() + "', ");
        sql.append(" " + TBTHB1DOWN.TURMEINO + " = '" + _vo.get_keyUriMeiNo() + "' ");
        sql.append(" WHERE");
//    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _vo.get_egCd() + "' ");
//    	sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _vo.get_tksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _vo.get_tksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _vo.get_tksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _vo.get_YYMM() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _vo.get_keyJyutno() + "' ");

        if(_vo.get_Gyomkbn().equals("") || _vo.get_Gyomkbn() == null)
        {
        }else
        {
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.GYOMKBN + " = '" + _vo.get_Gyomkbn() + "' ");
        }

        if(_vo.get_Tmspkbn().equals("") || _vo.get_Tmspkbn() == null)
        {
        }else
        {
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TMSPKBN + " = '" + _vo.get_Tmspkbn() + "' ");
        }

        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");

        return sql.toString();
    }

}
