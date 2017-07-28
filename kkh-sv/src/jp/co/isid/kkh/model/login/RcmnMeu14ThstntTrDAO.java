package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU07SIKKRSPRD;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU12THSKGY;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU13THSKGYBMON;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU14THSTNTTR;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU16SKUKJK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class RcmnMeu14ThstntTrDAO extends AbstractRdbDao {

    /** 得意先区分：得意先 */
    private static final String TKKBN_TK = "1";

    /** 終了年月最大値 */
    private static final String ENDYMD_MAX = "99999999";

    /** 取引先担当情報検索条件 */
    private RcmnMeu14ThstntTrCondition _cond;

//    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * デフォルトコンストラクタ。
     */
    public RcmnMeu14ThstntTrDAO() {
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
        sql.append(" /*+ ordered */ ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.THSKGYCD + " ");
        sql.append(" ," + TBRCMN_MEU14THSTNTTR.SEQNO + " ");
        sql.append(" ," + TBRCMN_MEU14THSTNTTR.TRTNTSEQNO + " ");
        sql.append(" ," + TBRCMN_MEU14THSTNTTR.SIKCD + " ");
        sql.append(" ," + TBRCMN_MEU16SKUKJK.SINCD + " ");
        sql.append(" ," + TBRCMN_MEU12THSKGY.THSKGYDISPKJ + " ");
        sql.append(" ," + TBRCMN_MEU13THSKGYBMON.SUBMEI + " ");
        sql.append(" ," + TBRCMN_MEU07SIKKRSPRD.SIKCDKYK + " ");
        sql.append(" ," + TBRCMN_MEU07SIKKRSPRD.SIKCDBU + " ");
        sql.append(" ," + TBRCMN_MEU07SIKKRSPRD.BUHYOJIKJ + " ");
        sql.append(" FROM ");
        sql.append("  " + TBRCMN_MEU14THSTNTTR.TBNAME + ", " + TBRCMN_MEU12THSKGY.TBNAME);
        sql.append(" ," + TBRCMN_MEU13THSKGYBMON.TBNAME + ", " + TBRCMN_MEU16SKUKJK.TBNAME);
        sql.append(" ," + TBRCMN_MEU07SIKKRSPRD.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.THSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.SEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.TKKBN + " = '" + TKKBN_TK + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.EGSYOCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU13THSKGYBMON.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU12THSKGY.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU16SKUKJK.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" '" + _cond.getEigyoBi() + "' BETWEEN " +  TBRCMN_MEU07SIKKRSPRD.STARTYMD + " AND " + TBRCMN_MEU07SIKKRSPRD.ENDYMD);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.THSKGYCD + " = " + TBRCMN_MEU12THSKGY.THSKGYCD);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.THSKGYCD + " = " + TBRCMN_MEU13THSKGYBMON.THSKGYCD);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.THSKGYCD + " = " + TBRCMN_MEU16SKUKJK.THSKGYCD);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.SEQNO + " = " + TBRCMN_MEU13THSKGYBMON.SEQNO);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.SEQNO + " = " + TBRCMN_MEU16SKUKJK.SEQNO);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.TRTNTSEQNO + " = " + TBRCMN_MEU16SKUKJK.TRTNTSEQNO);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.SIKCD + " = " + TBRCMN_MEU07SIKKRSPRD.SIKCD);
        sql.append(" ORDER BY ");
        sql.append("  " + TBRCMN_MEU14THSTNTTR.THSKGYCD + ", " + TBRCMN_MEU14THSTNTTR.SEQNO);
        sql.append(" ," + TBRCMN_MEU14THSTNTTR.TRTNTSEQNO);

        return sql.toString();
    }

    /**
     * 取引先担当情報の検索を行います。
     *
     * @return 取引先担当情報VOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<RcmnMeu14ThstntTrVO> getCustomerChargeInfo(RcmnMeu14ThstntTrCondition cond) throws KKHException {

        super.setModel(new RcmnMeu14ThstntTrVO());

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
     * @return List<RcmnMeu14ThstntTrVO> 変換後の検索結果
     */
    @Override
    protected List<RcmnMeu14ThstntTrVO> createFindedModelInstances(List hashList) {

        List<RcmnMeu14ThstntTrVO> list = new ArrayList<RcmnMeu14ThstntTrVO>();
        if (getModel() instanceof RcmnMeu14ThstntTrVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                RcmnMeu14ThstntTrVO vo = new RcmnMeu14ThstntTrVO();
                vo.setThskgyCd(StringUtil.trim((String) result.get(TBRCMN_MEU14THSTNTTR.THSKGYCD.toUpperCase())));
                vo.setSeqNo(StringUtil.trim((String) result.get(TBRCMN_MEU14THSTNTTR.SEQNO.toUpperCase())));
                vo.setTrtntSeqNo(StringUtil.trim((String) result.get(TBRCMN_MEU14THSTNTTR.TRTNTSEQNO.toUpperCase())));
                vo.setSikCd(StringUtil.trim((String) result.get(TBRCMN_MEU14THSTNTTR.SIKCD.toUpperCase())));
                vo.setSinCd((String) result.get(TBRCMN_MEU16SKUKJK.SINCD.toUpperCase())); // 各桁ごとに使用用途が異なるためTRIMしない
                vo.setThskgyDispKj(StringUtil.trim((String) result.get(TBRCMN_MEU12THSKGY.THSKGYDISPKJ.toUpperCase())));
                vo.setSubMei(StringUtil.trim((String) result.get(TBRCMN_MEU13THSKGYBMON.SUBMEI.toUpperCase())));
                vo.setSikcdKyk(StringUtil.trim((String) result.get(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK.toUpperCase())));
                vo.setSikCdBu(StringUtil.trim((String) result.get(TBRCMN_MEU07SIKKRSPRD.SIKCDBU.toUpperCase())));
                vo.setBuHyojiKj(StringUtil.trim((String) result.get(TBRCMN_MEU07SIKKRSPRD.BUHYOJIKJ.toUpperCase())));
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
