package jp.co.isid.kkh.customer.lion.model.report.proof;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionProofDaoInterface;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionVO;
import jp.co.isid.kkh.customer.lion.model.report.proof.LionProofConstants;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;
/**
 *
 * <P>
 * ���[�iLion)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionBSCSDAO extends AbstractRdbDao implements  ReportLionProofDaoInterface{

    /** �ėp�}�X�^�������� */
    private ReportLionCondition _cond;

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r�ǃ}�X�^ */
    public static final String C_HBAMST_SYBT_TV_KYOKU = LionProofConstants.MastBaitaiShubetsu.TV_KYOKU.getCode();
    //public static final String C_HBAMST_SYBT_TV_KYOKU = "401";

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r�ԑg�}�X�^ */
    public static final String C_HBAMST_SYBT_TV_BANGUMI =  LionProofConstants.MastBaitaiShubetsu.TV_BANGUMI.getCode();
    //public static final String C_HBAMST_SYBT_TV_BANGUMI = "601";

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportLionBSCSDAO() {
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
        // new String[] {};
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    @Override
    public String getTableName() {
        return TBTHB2KMEI.TBNAME;
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

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append("  " + TBTHB2KMEI.CODE4 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE5 + " " + ReportLionVO.PROGRAM_CD + ", ");
        sql.append("  " + TBTHB2KMEI.CODE2 + " " + ReportLionVO.KYOKU_CD + ", ");
//		sql.append("  mast4." + TBTHBAMST.FIELD2 + " " + ReportLionVO.KYOKU_MEI+ ", ");
        sql.append("  " + TBTHB11WLTVK.KYOKUNAME + " " + ReportLionVO.KYOKU_MEI+ ", ");
        sql.append("  " + TBTHB2KMEI.NEBIGAK + ", ");
        sql.append(" " + TBTHB9WLTVB.HYOJIJYUN+ " " + ReportLionVO.HYOJI+ ", ");
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //����ŗ�
        sql.append("  " + TBTHB2KMEI.SEIGAK + ", ");
        sql.append("  TRIM(" + TBTHB2KMEI.SONOTA5 + ") " + ReportLionVO.HONSU + ", ");
//		sql.append("  mast6." + TBTHBAMST.FIELD2 + " " + ReportLionVO.PROGRAM_NAME+ ", ");
        sql.append(" " + TBTHB9WLTVB.BANNAME + " " + ReportLionVO.PROGRAM_NAME+ ", ");
        sql.append("  " + TBTHB2KMEI.NAME1 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHB9WLTVB.TBNAME + ", ");
        sql.append("  " + TBTHB11WLTVK.TBNAME + " ");
//		sql.append("  " + TBTHBAMST.TBNAME + " mast4, ");
//		sql.append("  " + TBTHBAMST.TBNAME + " mast6 ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB11WLTVK.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB11WLTVK.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB11WLTVK.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB9WLTVB.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB9WLTVB.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB9WLTVB.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('016') AND ");
//		sql.append(" mast4." + TBTHBAMST.SYBT + " = '401' AND ");
//		sql.append(" mast6." + TBTHBAMST.SYBT + " = '601' AND ");
//		sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = mast4." + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = " + TBTHB11WLTVK.KYOKUCD + " AND ");
//		sql.append(" TRIM(" + TBTHB2KMEI.CODE5 + ") = mast6." + TBTHBAMST.FIELD1 + "  ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE5 + ") = " + TBTHB9WLTVB.BANCD + "  ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
        //sql.append("  mast6." + TBTHBAMST.INTVALUE5 + ", ");
//		sql.append("  " + TBTHB9WLTVB.HYOJIJYUN + ", ");
        sql.append("  " + TBTHB2KMEI.CODE5 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE2 + ", ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append("  " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append("  " + TBTHB2KMEI.URMEINO + " ");

        return sql.toString();
    }

    /**
     * ���[�f�[�^(���C�I��)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportLionVO> findReportLionByCondition(ReportLionCondition cond)
            throws KKHException {

        super.setModel(new ReportLionVO());

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
    protected List<ReportLionVO> createFindedModelInstances(List hashList) {
        List<ReportLionVO> list = new ArrayList<ReportLionVO>();
        if (getModel() instanceof ReportLionVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportLionVO vo = new ReportLionVO();
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));	//�J�[�hNO
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));				//�����N��
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));	//�㗝�X�R�[�h
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));	//�}�̋敪
                vo.setProgramCd((String) result.get(ReportLionVO.PROGRAM_CD.toUpperCase().trim()));	//�v���O�����R�[�h
                vo.setKyokuCd((String) result.get(ReportLionVO.KYOKU_CD.toUpperCase().trim()));	//�ǃR�[�h
                vo.setKyokuMei((String) result.get(ReportLionVO.KYOKU_MEI.toUpperCase().trim()));	//�ǖ�
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase().trim()));	//�l���z
//				vo.setHyoji((BigDecimal) result.get(ReportLionVO.HYOJI.toUpperCase().trim()));	//�\��
                vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));  //����ŗ�
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//�����z
                vo.setHonsu((String) result.get(ReportLionVO.HONSU.toUpperCase().trim()));	//�{��
                vo.setProgramName((String) result.get(ReportLionVO.PROGRAM_NAME.toUpperCase().trim()));	//�v���O������
                vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim()));	//�����
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
