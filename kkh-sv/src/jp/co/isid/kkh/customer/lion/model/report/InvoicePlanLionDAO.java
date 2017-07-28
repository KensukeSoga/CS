package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ���C�I���������\��\����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */

public class InvoicePlanLionDAO extends AbstractRdbDao {

    /** ���C�I�������\��\�������� */
    InvoicePlanLionCondition _cond = null;

    /** ���ƕ��F���R�} */
    private static final String DIV_ONAIR_CM_CODE = "23";
    private static final String DIV_ONAIR_CM_NAME = "���R�}";
    /** ���ƕ��F�v�����g�� */
    private static final String DIV_PRINT_COST_CODE = "21";
    private static final String DIV_PRINT_COST_NAME = "�v�����g��";

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public InvoicePlanLionDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     * @return String[] �v���C�}���L�[
     */
    @Override
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     * @return String �e�[�u����
     */
    @Override
    public String getTableName() {
        return null;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * SQL������
     */
    public String getSelectSQL() {
        return getSelectSQLInvoicePlan();
    }

    /**
     * �����\��\�擾SQL������
     * @return SQL��
     */
    private String getSelectSQLInvoicePlan() {

        //SQL
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " " + InvoicePlanLionVO.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " " + InvoicePlanLionVO.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + " " + InvoicePlanLionVO.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.CODE3 + " " + InvoicePlanLionVO.BRDCD + ",");
        sql.append(" M2." + TBTHBAMST.FIELD2 + " " + InvoicePlanLionVO.BRDNM + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") " + InvoicePlanLionVO.KENNM + ",");
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + InvoicePlanLionVO.SEIGAK + ",");
        sql.append(" " + TBTHB2KMEI.CODE1 + " " + InvoicePlanLionVO.BAITAIKBN + ",");
        sql.append(" M3." + TBTHBAMST.FIELD2 + " " + InvoicePlanLionVO.BAITAINM);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " M2,"); //AD�u�����h�}�X�^
        sql.append(" " + TBTHBAMST.TBNAME + " M3");  //�}�̋敪
        sql.append(" WHERE");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '012' AND");

//        //���C�I�������̏ꍇ
//        if (_cond.getDivision().equals(DIV_LION_AFFAIRS_NAME)) {
//            sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") LIKE '�y" + DIV_LION_AFFAIRS_NAME + "�z%' AND");
//        } else {
//            sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") NOT LIKE '�y" + DIV_LION_AFFAIRS_NAME + "�z%' AND");

            //���R�}�̏ꍇ
            if (_cond.getDivision().equals(DIV_ONAIR_CM_NAME)) {
                sql.append(" " + TBTHB2KMEI.CODE1 + " = '" + DIV_ONAIR_CM_CODE + "' AND");
            } else if (_cond.getDivision().equals(DIV_PRINT_COST_NAME)) {
                //�v�����g��̏ꍇ
                sql.append(" " + TBTHB2KMEI.CODE1 + " = '" + DIV_PRINT_COST_CODE + "' AND");
            } else {
                sql.append(" " + TBTHB2KMEI.CODE1 + " NOT IN ( '" + DIV_ONAIR_CM_CODE + "', '" + DIV_PRINT_COST_CODE + "' ) AND");
                sql.append(" M2." + TBTHBAMST.FIELD6 + " = '" + _cond.getDivision() + "' AND");
            }
//        }

        sql.append(" M2." + TBTHBAMST.SYBT + " = '201' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = M2." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = M2." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = M2." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 +") = M2." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" M3." + TBTHBAMST.SYBT + " = '104' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = M3." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = M3." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = M3." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = M3." + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        sql.append(" " + InvoicePlanLionVO.BRDCD + ",");
        sql.append(" " + InvoicePlanLionVO.BAITAIKBN + ",");
        sql.append(" " + InvoicePlanLionVO.JYUTNO + ",");
        sql.append(" " + InvoicePlanLionVO.JYMEINO + ",");
        sql.append(" " + InvoicePlanLionVO.URMEINO);

        return sql.toString();
    }

    /**
     * ���C�I�����쎺���X�g�f�[�^�̌������s���܂��B
     *
     * @return ���C�I�����쎺���X�g�f�[�^�擾VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<InvoicePlanLionVO> findInvoicePlan(InvoicePlanLionCondition cond) throws KKHException {
        super.setModel(new InvoicePlanLionVO());

        try {
            _cond = cond;
            return (List<InvoicePlanLionVO>)super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList List ��������
     * @return List<AddChangeReportVO> �ϊ���̌�������
     */
    @Override
    protected List<InvoicePlanLionVO> createFindedModelInstances(List hashList) {
        List<InvoicePlanLionVO> list = new ArrayList<InvoicePlanLionVO>();
        for (int i = 0; i < hashList.size(); i++) {
            Map result = (Map) hashList.get(i);
            InvoicePlanLionVO vo = new InvoicePlanLionVO();

            //��No
            vo.setJyutno((String) result.get(InvoicePlanLionVO.JYUTNO.toUpperCase()));
            //�󒍖���No
            vo.setJymeino((String) result.get(InvoicePlanLionVO.JYMEINO.toUpperCase()));
            //���㖾��No
            vo.setUrmeino((String) result.get(InvoicePlanLionVO.URMEINO.toUpperCase()));
            //�u�����h�R�[�h
            vo.setBrdCd((String) result.get(InvoicePlanLionVO.BRDCD.toUpperCase()));
            //�u�����h��
            vo.setBrdNm((String) result.get(InvoicePlanLionVO.BRDNM.toUpperCase()));
            //����
            vo.setKenNm((String) result.get(InvoicePlanLionVO.KENNM.toUpperCase()));
            //�������z
            vo.setSeigak((BigDecimal) result.get(InvoicePlanLionVO.SEIGAK.toUpperCase()));
            //�}�̋敪�R�[�h
            vo.setBaitaiKbn((String) result.get(InvoicePlanLionVO.BAITAIKBN.toUpperCase()));
            //�}�̋敪��
            vo.setBaitaiNm((String) result.get(InvoicePlanLionVO.BAITAINM.toUpperCase()));

            //�������ʒ���̏�Ԃɂ���
            ModelUtils.copyMemberSearchAfterInstace(vo);
            list.add(vo);
        }

        return list;
    }

}
