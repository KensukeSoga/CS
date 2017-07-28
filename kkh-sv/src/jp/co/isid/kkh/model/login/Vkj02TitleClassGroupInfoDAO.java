package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.VWTITLECLASSGROUPINFO;
import jp.co.isid.kkh.integ.tbl.VWTITLECLASSMEMBER;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class Vkj02TitleClassGroupInfoDAO extends AbstractRdbDao {

    /** 職位等級グループ情報検索条件 */
    private Vkj02TitleClassGroupInfoCondition _cond;

//    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * デフォルトコンストラクタ。
     */
    public Vkj02TitleClassGroupInfoDAO() {
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
        return "";
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[] {};
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + VWTITLECLASSMEMBER.GROUPCD + " ");
        sql.append(" FROM ");
        sql.append(" " + VWTITLECLASSGROUPINFO.TBNAME + ", " + VWTITLECLASSMEMBER.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + VWTITLECLASSGROUPINFO.GROUPCD + " = " + VWTITLECLASSMEMBER.GROUPCD);
        sql.append(" AND ");
        sql.append(" " + VWTITLECLASSGROUPINFO.STRTYMD + " <= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTITLECLASSGROUPINFO.STPYMD + " >= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTITLECLASSMEMBER.ESQID + " = '" + _cond.getEsqId() + "' ");

        return sql.toString();
    }

    /**
     * 職位等級グループ情報の検索を行います。
     *
     * @return 職位等級グループ情報VOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Vkj02TitleClassGroupInfoVO> getGroupInfo(Vkj02TitleClassGroupInfoCondition cond) throws KKHException {

        super.setModel(new Vkj02TitleClassGroupInfoVO());

        try {
            _cond = cond;
//            _sqlMode = SqlMode.COND;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "HB-E0001");
        }

    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<Vkj02TitleClassGroupInfoVO> 変換後の検索結果
     */
    @Override
    protected List<Vkj02TitleClassGroupInfoVO> createFindedModelInstances(List hashList) {

        List<Vkj02TitleClassGroupInfoVO> list = new ArrayList<Vkj02TitleClassGroupInfoVO>();
        if (getModel() instanceof Vkj02TitleClassGroupInfoVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                Vkj02TitleClassGroupInfoVO vo = new Vkj02TitleClassGroupInfoVO();
                vo.setGroupCd(StringUtil.trim((String) result.get(VWTITLECLASSMEMBER.GROUPCD.toUpperCase())));
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
