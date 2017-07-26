package jp.co.isid.kkh.customer.acom.model.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 発注データ検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikSearchDateCntDAO extends AbstractRdbDao {

    /**マスタ検索条件 */
    private HikCommonCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public HikSearchDateCntDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    @Override
    public String[] getPrimryKeyNames() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public String[] getTableColumnNames() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public String getTableName() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public String getTimeStampKeyName() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        StringBuilder sql = new StringBuilder();

        //SELECT句
        sql.append(" SELECT ");
        sql.append( TBTHB5HIK.IRBAN  + ",");
        sql.append( TBTHB5HIK.IRROWBAN);

        //FROM句
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME);

        //WHRE句
        sql.append(" WHERE ");
        sql.append(TBTHB5HIK.TKSKGYCD  + " = " + "'" + _cond.getTkskgycd() + "'");
        sql.append(" AND ");
        sql.append(TBTHB5HIK.TKSBMNSEQNO + " = " + "'" +  _cond.getTksbmnseqno() + "'");
        sql.append(" AND ");
        sql.append( TBTHB5HIK.TKSTNTSEQNO  + " = " + "'" +_cond.getTkstntseqno() + "'");
        sql.append(" AND ");
        sql.append(TBTHB5HIK.RECCD + " = " + "'" +_cond.getRecCd() + "'");
        sql.append(" AND ");
        sql.append( TBTHB5HIK.IRBAN  + " = " + "'" + _cond.getIrban() + "'");
        sql.append(" AND ");
        sql.append( TBTHB5HIK.SYBT  + " = " + "'" + _cond.getSyubetsu() + "'");
        sql.append(" AND ");
        sql.append( TBTHB5HIK.IRROWBAN + " = " + "'" + _cond.getIrrowban() + "'");

        return sql.toString();
    }

    /**
     * 発注テーブルの検索を行います。
     *
     * @return 発注テーブルVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<HikSearchDateCntVO> findByCondition(HikCommonCondition cond) throws KKHException {

        super.setModel(new HikSearchDateCntVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<HikVO> 変換後の検索結果
     */
    @Override
    protected List<HikSearchDateCntVO> createFindedModelInstances(List hashList) {
        List<HikSearchDateCntVO> list = new ArrayList<HikSearchDateCntVO>();
        if (getModel() instanceof HikSearchDateCntVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                HikSearchDateCntVO vo = new HikSearchDateCntVO();
                //VOListに入れ直す処理を行う
                vo.setIrban((String)result.get(TBTHB5HIK.IRBAN));         //発注番号
                vo.setIrrowban((String)result.get(TBTHB5HIK.IRROWBAN));   //発注行番号

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
