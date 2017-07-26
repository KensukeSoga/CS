package jp.co.isid.kkh.customer.lion.model.report.proof;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
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
 * ���C�I���v���[�t���X�g���[(�f�W�^������)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2017/06/05 ITCOM A.Nakamura)<BR>
 * </P>
 *
 * @author
 */

 public class ReportLionDigitalMovieDAO extends AbstractRdbDao implements  ReportLionProofDaoInterface{

    /** �ėp�}�X�^�������� */
    private ReportLionCondition _cond;

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r�ǃ}�X�^ */
    public static final String C_HBAMST_SYBT_TV_KYOKU = LionProofConstants.MastBaitaiShubetsu.TV_KYOKU.getCode();

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r�ԑg�}�X�^ */
    public static final String C_HBAMST_SYBT_TV_BANGUMI =  LionProofConstants.MastBaitaiShubetsu.TV_BANGUMI.getCode();

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportLionDigitalMovieDAO() {
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
        sql.append("  " + TBTHB2KMEI.CODE3 + " " + ReportLionVO.BRAND_CD + ", ");
        sql.append("  mast2." + TBTHBAMST.FIELD2 + " " + ReportLionVO.BRAND_MEI + ", ");
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ,"); //����ŗ�
        sql.append("  " + TBTHB2KMEI.SEIGAK + ", ");
        sql.append("  " + TBTHB2KMEI.NAME10 + " " + ReportLionVO.KEN_MEI + ", ");
        sql.append("  " + TBTHB2KMEI.NAME1  + ", ");
        sql.append("  mast1." + TBTHBAMST.FIELD1 + " " + ReportLionVO.KYOKUSHI_CD + ", ");
        sql.append("  mast1." + TBTHBAMST.FIELD2 + " " + ReportLionVO.KYOKUSHI_NAME + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast1, ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast2 ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('017') AND ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '1C' AND");
        sql.append(" mast2." + TBTHBAMST.SYBT + " = '201' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = mast2." + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast2." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast2." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast2." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast1." + TBTHBAMST.TKSKGYCD + " (+) AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " =  mast1." + TBTHBAMST.TKSBMNSEQNO + " (+) AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " =  mast1." + TBTHBAMST.TKSTNTSEQNO + " (+) AND ");
        sql.append(" mast1." + TBTHBAMST.SYBT + "(+) =  '114' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") =  mast1." + TBTHBAMST.FIELD1 + " (+) ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB2KMEI.CODE3 + ", ");
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
                vo.setBrandCd((String) result.get(ReportLionVO.BRAND_CD.toUpperCase().trim()));    //�u�����h�R�[�h
                vo.setBrandMei((String) result.get(ReportLionVO.BRAND_MEI.toUpperCase().trim())); //�u�����h��
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//�����z
                vo.setKenMei((String) result.get(ReportLionVO.KEN_MEI.toUpperCase().trim())); //����
                vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));  //����ŗ�
                vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim())); //�����
                vo.setKyokushiCd((String) result.get(ReportLionVO.KYOKUSHI_CD.toUpperCase().trim())); //�ǎ��R�[�h
                vo.setKyokushiName((String) result.get(ReportLionVO.KYOKUSHI_NAME.toUpperCase().trim())); //�ǎ���

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

 }
