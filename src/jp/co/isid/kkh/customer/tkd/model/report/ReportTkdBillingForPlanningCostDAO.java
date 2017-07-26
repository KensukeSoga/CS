package jp.co.isid.kkh.customer.tkd.model.report;

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
 * <P>
 * ���c�������ׁi����j�擾DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingForPlanningCostDAO extends AbstractRdbDao {

    /** �ėp�}�X�^�������� */
    private ReportTkdBillingForPlanningCostCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportTkdBillingForPlanningCostDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
    @Override
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    @Override
    public String getTableName() {
        return null;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem() {

        StringBuffer sql = new StringBuffer();

        sql.append("SELECT ");
        sql.append("    " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append("    " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append("    " + TBTHB2KMEI.URMEINO + ", ");
        sql.append("    " + TBTHB2KMEI.KNGK1 + ", ");
        sql.append("    rtrim(" + TBTHB2KMEI.CODE3 + ") SCD, ");
        sql.append("    rtrim(" + TBTHB2KMEI.NAME2 + ") SNM, ");
        sql.append("    rtrim(" + TBTHB2KMEI.NAME8 + ") TEKIYO, ");
        sql.append("    rtrim(" + TBTHB2KMEI.SONOTA1 + ") KBN, ");
        sql.append("    " + TBTHB2KMEI.SEIGAK + ", ");
        sql.append("    " + TBTHB1DOWN.SZEIRITU + " ");
        sql.append("FROM ");
        sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("    " + TBTHB1DOWN.TBNAME + " ");
        sql.append("WHERE ");
        sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "'  AND ");
        sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
        sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
        sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
        sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "'  AND ");
        sql.append("    " + TBTHB2KMEI.KBN1 + " = '1'  AND ");
        sql.append("    " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + "  AND ");
        sql.append("    " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + "  AND ");
        sql.append("    " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + "  AND ");
        sql.append("    " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + "  AND ");
        sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + "  AND ");
        sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + "  AND ");
        sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + "  AND ");
        sql.append("    " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + "  AND ");
        sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        sql.append("ORDER BY ");
        sql.append("    " + TBTHB2KMEI.KNGK1 + ", ");
        sql.append("    " + TBTHB2KMEI.NAME8 + ", ");
        sql.append("    " + TBTHB2KMEI.NAME2 + " ");

        return sql.toString();
    }

    /**
     * ���[�f�[�^�iTOH)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportTkdBillingForPlanningCostVO> findReportTkdBillingByCondition(ReportTkdBillingForPlanningCostCondition cond) throws KKHException {

        super.setModel(new ReportTkdBillingForPlanningCostVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList
     *            List ��������
     * @return List<CommonCodeMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<ReportTkdBillingForPlanningCostVO> createFindedModelInstances(List hashList) {
        List<ReportTkdBillingForPlanningCostVO> list = new ArrayList<ReportTkdBillingForPlanningCostVO>();
        if (getModel() instanceof ReportTkdBillingForPlanningCostVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportTkdBillingForPlanningCostVO vo = new ReportTkdBillingForPlanningCostVO();

                vo.setJYUTNO((String) result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                vo.setJYMEINO((String) result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                vo.setURMEINO((String) result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
                vo.setKNGK1((BigDecimal) result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
                vo.setSCD((String) result.get(ReportTkdBillingForPlanningCostVO.SCD.toUpperCase()));
                vo.setSNM((String) result.get(ReportTkdBillingForPlanningCostVO.SNM.toUpperCase()));
                vo.setTEKIYO((String) result.get(ReportTkdBillingForPlanningCostVO.TEKIYO.toUpperCase()));
                vo.setKBN((String) result.get(ReportTkdBillingForPlanningCostVO.KBN.toUpperCase()));
                vo.setSEIGAK((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setSZEIRITU((BigDecimal) result.get(TBTHB1DOWN.SZEIRITU.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
