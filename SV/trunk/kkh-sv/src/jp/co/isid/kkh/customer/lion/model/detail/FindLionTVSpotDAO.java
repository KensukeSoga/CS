package jp.co.isid.kkh.customer.lion.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotVO;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.tbl.VHB_V1GSM_LION;
import jp.co.isid.kkh.integ.tbl.VHB_V2MJW_LION;
import jp.co.isid.kkh.integ.tbl.VHB_V3MHP_LION;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 * <P>
 * ライオンTVSpotデータ取得DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/05 JSE Hitoshi Sasaki)<BR>
 * ・iClimax連携対応(2014/04/02 HLC fujimoto)<BR>
 * ・放送局コード変換対応(2014/05/12 HLC fujimoto)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FindLionTVSpotDAO extends AbstractRdbDao {

    /** ライオンTVSpotデータ検索条件 */
    private FindLionTVSpotCondition _cond;

    /* 放送局コード変換対応 HLC fujimoto ADD start */
    /** 放送局コード変換ビュー(内部) */
    private static final String VWNAME = "V_KYK_CD";
    /* 放送局コード変換対応 HLC fujimoto ADD end */

    /**
     * デフォルトコンストラクタ。
     */
    public FindLionTVSpotDAO() {
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
    @Override
    public String getTableName() {
        return null;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
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

    private String getSelectSQLForItem() {

        StringBuffer sql = new StringBuffer();

        /* 放送局コード変換対応 2014/05/12 HLC fujimoto ADD start */
        sql.append("WITH " + VWNAME + " AS ( ");
        sql.append("SELECT");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");
        sql.append(" " + TBTHBAMST.FIELD2 + " ");
        sql.append("FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append("WHERE");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '801' ");
        sql.append(") ");
        /* 放送局コード変換対応 2014/05/12 HLC fujimoto ADD end */
        sql.append("SELECT ");
        sql.append("    " + VHB_V1GSM_LION.JOB_NO + ", ");
        sql.append("    " + VHB_V1GSM_LION.CONTRA_NAME + ", ");
        sql.append("    " + VHB_V1GSM_LION.HK_SDT + ", ");
        sql.append("    " + VHB_V1GSM_LION.HK_EDT + ", ");
        sql.append("    " + VHB_V1GSM_LION.SHK_NO + ", ");
        /* 放送局コード変換対応 2014/05/12 HLC fujimoto MOD start */
//        /* iClimax連携対応 2014/04/03 HLC fujimoto MOD start*/
//        //sql.append("    " + VHB_V1GSM_LION.KYK_CD + ", ");
//        sql.append("    SUBSTR(" + VHB_V1GSM_LION.KYK_CD + ", 2, LENGTH(" + VHB_V1GSM_LION.KYK_CD + ") - 1) " + VHB_V1GSM_LION.KYK_CD + ",");
//        /* iClimax連携対応 2014/04/03 HLC fujimoto MOD end */
        sql.append("CASE WHEN SUBSTR(" + VHB_V1GSM_LION.KYK_CD + ", 2) = V." + TBTHBAMST.FIELD1 + " THEN V." + TBTHBAMST.FIELD2 + " ELSE SUBSTR(" + VHB_V1GSM_LION.KYK_CD + ", 2) END " + VHB_V1GSM_LION.KYK_CD + ",");
        /* 放送局コード変換対応 2014/05/12 HLC fujimoto MOD end */
        sql.append("    " + VHB_V1GSM_LION.KYKAN_NO + ", ");
        sql.append("    " + VHB_V3MHP_LION.K_HKGAK_HAT + ", ");
        sql.append("    " + VHB_V2MJW_LION.CM_SEC + ", ");
        sql.append("    " + VHB_V2MJW_LION.ONA_DT + ", ");
        sql.append("    " + VHB_V2MJW_LION.KYKAN_STM + ", ");
        sql.append("    " + VHB_V2MJW_LION.KYKAN_ETM + ", ");
        sql.append("    " + VHB_V2MJW_LION.AC_CD + ", ");
        sql.append("    " + VHB_V2MJW_LION.SZIKYTU_CD + ", ");
        sql.append("    " + VHB_V2MJW_LION.K_SZI_RYKG + ", ");
        sql.append("    " + VHB_V2MJW_LION.JWK_NO + " ");
        sql.append("FROM ");
        sql.append("    " + VHB_V1GSM_LION.TBNAME + ", ");
        sql.append("    " + VHB_V2MJW_LION.TBNAME + ", ");
        sql.append("    " + VHB_V3MHP_LION.TBNAME + " ");
        /* 放送局コード変換対応 2014/05/12 HLC fujimoto ADD start */
        sql.append(", " + VWNAME + " V ");
        /* 放送局コード変換対応 2014/05/12 HLC fujimoto ADD end */
        sql.append("WHERE ");
        sql.append("    " + VHB_V1GSM_LION.JOB_NO + " = '" + _cond.getJobNo() + "' AND ");
        sql.append("    " + VHB_V2MJW_LION.SHK_NO + " = " + VHB_V1GSM_LION.SHK_NO + " AND ");
        sql.append("    " + VHB_V2MJW_LION.KYK_CD + " = " + VHB_V1GSM_LION.KYK_CD + " AND ");
        sql.append("    " + VHB_V2MJW_LION.KYKAN_NO + " = " + VHB_V1GSM_LION.KYKAN_NO + " AND ");
        sql.append("    SUBSTR(" + VHB_V2MJW_LION.ONA_DT + ",0,6) = '" + _cond.getYM() + "' AND");
        sql.append("    " + VHB_V3MHP_LION.SHK_NO + " = " + VHB_V1GSM_LION.SHK_NO + " AND ");
        sql.append("    " + VHB_V3MHP_LION.KYK_CD + " = " + VHB_V1GSM_LION.KYK_CD + " AND ");
        sql.append("    " + VHB_V3MHP_LION.KYKAN_NO + " = " + VHB_V1GSM_LION.KYKAN_NO + " AND ");
        sql.append("    " + VHB_V3MHP_LION.MPRHB_PAT + " = " + VHB_V1GSM_LION.MPRHB_PAT + " AND ");
        sql.append("    " + VHB_V3MHP_LION.YM + " = '" + _cond.getYM() + "' ");
        sql.append("ORDER BY ");
        sql.append("    " + VHB_V1GSM_LION.SHK_NO + ", ");
        sql.append("    " + VHB_V1GSM_LION.KYK_CD + ", ");
        sql.append("    " + VHB_V1GSM_LION.KYKAN_NO + ", ");
        sql.append("    " + VHB_V2MJW_LION.JWK_NO + " ");

        return sql.toString();
    }

    /**
     * ライオンTVSpotデータの検索を行います。
     *
     * @return ライオンTVSpotデータ取得VOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindLionTVSpotVO> findFindLionTVSpotByCondition(FindLionTVSpotCondition cond) throws KKHException {

        super.setModel(new FindLionTVSpotVO());

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
     * @param hashList
     *            List 検索結果
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<FindLionTVSpotVO> createFindedModelInstances(List hashList) {
        List<FindLionTVSpotVO> list = new ArrayList<FindLionTVSpotVO>();
        if (getModel() instanceof FindLionTVSpotVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindLionTVSpotVO vo = new FindLionTVSpotVO();

                vo.setJOB_NO((String) result.get(VHB_V1GSM_LION.JOB_NO.toUpperCase()));
                vo.setCONTRA_NAM((String) result.get(VHB_V1GSM_LION.CONTRA_NAME.toUpperCase()));
                vo.setHK_SDT((String) result.get(VHB_V1GSM_LION.HK_SDT.toUpperCase()));
                vo.setHK_EDT((String) result.get(VHB_V1GSM_LION.HK_EDT.toUpperCase()));
                vo.setSHK_NO((String) result.get(VHB_V1GSM_LION.SHK_NO.toUpperCase()));
                vo.setKYK_CD((String) result.get(VHB_V1GSM_LION.KYK_CD.toUpperCase()));
                vo.setKYKAN_NO((String) result.get(VHB_V1GSM_LION.KYKAN_NO.toUpperCase()));
//				vo.setKYOKUCD((String) result.get(TBTHB11WLTVK.KYOKUCD.toUpperCase()));
//				vo.setKYOKUNAME((String) result.get(TBTHB11WLTVK.KYOKUNAME.toUpperCase()));
                vo.setK_HKGAK_HAT((BigDecimal) result.get(VHB_V3MHP_LION.K_HKGAK_HAT.toUpperCase()));
                vo.setCM_SEC((BigDecimal) result.get(VHB_V2MJW_LION.CM_SEC.toUpperCase()));
//				vo.setTIKU((String) result.get(TBTHB11WLTVK.TIKU.toUpperCase()));
                vo.setONA_DT((String) result.get(VHB_V2MJW_LION.ONA_DT.toUpperCase()));
                vo.setKYKAN_STM((String) result.get(VHB_V2MJW_LION.KYKAN_STM.toUpperCase()));
                vo.setKYKAN_ETM((String) result.get(VHB_V2MJW_LION.KYKAN_ETM.toUpperCase()));
//				vo.setSZIKYTU_KB((String) result.get(VHB_V2MJW_LION.SZIKYTU_KB.toUpperCase()));
                vo.setAC_CD((String) result.get(VHB_V2MJW_LION.AC_CD.toUpperCase()));
                vo.setSZIKYTU_CD((String) result.get(VHB_V2MJW_LION.SZIKYTU_CD.toUpperCase()));
                vo.setK_SZI_RYKG((String) result.get(VHB_V2MJW_LION.K_SZI_RYKG.toUpperCase()));
                vo.setJWK_NO((String) result.get(FindLionTVSpotVO.JWK_NO.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
