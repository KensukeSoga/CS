package jp.co.isid.kkh.customer.lion.model.report.proof;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB10WLRDB;
import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionProofDaoInterface;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionVO;
import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;
/**
 *
 * <P>
 * ���C�I���v���[�t���X�g���[(���W�I�^�C��)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionRdTimeDAO extends AbstractRdbDao implements  ReportLionProofDaoInterface{

    /** �ėp�}�X�^�������� */
    private ReportLionCondition _cond;

    /** �ėp�}�X�^�F�}�̎�ʁF���W�I�ǃ}�X�^ */
    public static final String C_HBAMST_SYBT_RD_KYOKU = LionConstants.MastBaitaiShubetsu.RD_KYOKU.getCode();
    //public static final String C_HBAMST_SYBT_RD_KYOKU = "402";

    /** �ėp�}�X�^�F�}�̎�ʁF���W�I�ԑg�}�X�^ */
    public static final String C_HBAMST_SYBT_RD_BANGUMI = LionConstants.MastBaitaiShubetsu.RD_BANGUMI.getCode();
   // public static final String C_HBAMST_SYBT_RD_BANGUMI = "602";

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportLionRdTimeDAO() {
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


        // �e�}�̋��ʍ��ځ�.
        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.YYMM		+ " ");	//�����N��
        sql.append(" ," + TBTHB2KMEI.CODE1		+ " ");	//�}�̋敪
        sql.append(" ," + TBTHB2KMEI.CODE4 		+ " ");	//�㗝�X�R�[�h
        sql.append(" ," + TBTHB2KMEI.CODE6 		+ " ");	//�J�[�hNo
        sql.append(" ," + TBTHB2KMEI.SONOTA5 	+ " ");	//�{��
        sql.append(" ," + TBTHB2KMEI.KNGK2 		+ " ");	//�l�b�g��
        sql.append(" ," + TBTHB2KMEI.KNGK3 		+ " ");	//�����
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU" ); //����ŗ�
        sql.append(" ," + TBTHB2KMEI.SEIGAK 	+ " ");	//�����z
        sql.append(" ," + TBTHB2KMEI.NEBIGAK 	+ " ");	//�l���z
//		sql.append(" ," + "TRUNC("
//						+ "DECODE(TRIM(" + TBTHB2KMEI.SEIGAK + ") , NULL , 0 , " + TBTHB2KMEI.SEIGAK  + ")" + " * "
//						+ "DECODE(TRIM(" + TBTHB2KMEI.RITU1  + ") , NULL , 5 , " + TBTHB2KMEI.RITU1   + ")" + "/ 100 )" + " AS SHOHIZEI_GAK " + " ");	//����Ŋz
        sql.append(" ,TO_NUMBER(" + TBTHB2KMEI.NAME1 + ") AS SHOHIZEI_GAK "); // ����Ŋz
        sql.append(" ," + "mast3.HB12_KYOKUCD" 	+ " AS " + ReportLionVO.KYOKU_CD	+ " ");	//�ǃR�[�h
        sql.append(" ," + "mast3.HB12_KYOKUNAME" 	+ " AS " + ReportLionVO.KYOKU_MEI	+ " ");	//�ǖ�
        sql.append(" ," + "mast1.HB10_BANCD" 	+ " AS " + ReportLionVO.BANGUMI_CD	+ " ");	//�ԑg�R�[�h
        sql.append(" ," + "mast1.HB10_BANNAME" 	+ " AS " + ReportLionVO.BANGUMI_MEI	+ " ");	//�ԑg��

        //*************************************************************************************************
        //FROM
        //*************************************************************************************************
        sql.append(" FROM ");
        sql.append(TBTHB1DOWN.TBNAME +  " , ");
        sql.append(TBTHB2KMEI.TBNAME +" , ");
        sql.append(TBTHB10WLRDB.TBNAME + " mast1 ,");
        sql.append(TBTHB12WLRDK.TBNAME + " mast3");

        //*************************************************************************************************
        //WHERE��
        //*************************************************************************************************
        sql.append(" WHERE ");
        sql.append(TBTHB1DOWN.EGCD 			+ " = '" + _cond.getEgCd()				+ "' AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd()			+ "' AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo()		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo()		+ "' AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " = '" + _cond.getYm()				+ "' AND ");

        sql.append(TBTHB1DOWN.EGCD 			+ " =  " + TBTHB2KMEI.EGCD				+ "  AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " =  " + TBTHB2KMEI.TKSKGYCD			+ "  AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " =  " + TBTHB2KMEI.TKSBMNSEQNO		+ "  AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " =  " + TBTHB2KMEI.TKSTNTSEQNO		+ "  AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " =  " + TBTHB2KMEI.YYMM				+ "  AND ");
        sql.append(TBTHB1DOWN.JYUTNO 		+ " =  " + TBTHB2KMEI.JYUTNO			+ "  AND ");
        sql.append(TBTHB1DOWN.JYMEINO 		+ " =  " + TBTHB2KMEI.JYMEINO			+ "  AND ");
        sql.append(TBTHB1DOWN.URMEINO 		+ " =  " + TBTHB2KMEI.URMEINO			+ "  AND ");
        sql.append(TBTHB1DOWN.TJYUTNO 		+ " =  " + "' '"						+ "  AND ");

        sql.append(TBTHB10WLRDB.EGCD 		+ " =  " + TBTHB2KMEI.EGCD				+ "  AND ");
        sql.append(TBTHB10WLRDB.TKSKGYCD 	+ " =  " + TBTHB2KMEI.TKSKGYCD			+ "  AND ");
        sql.append(TBTHB10WLRDB.TKSBMNSEQNO	+ " =  " + TBTHB2KMEI.TKSBMNSEQNO		+ "  AND ");
        sql.append(TBTHB10WLRDB.TKSTNTSEQNO	+ " =  " + TBTHB2KMEI.TKSTNTSEQNO		+ "  AND ");
        sql.append(TBTHB10WLRDB.BANCD 		+ " =  " + "TRIM(" + TBTHB2KMEI.CODE5	+ ") AND ");

        sql.append(TBTHB12WLRDK.EGCD 		+ " =  " + TBTHB2KMEI.EGCD				+ "  AND ");
        sql.append(TBTHB12WLRDK.TKSKGYCD 	+ " =  " + TBTHB2KMEI.TKSKGYCD			+ "  AND ");
        sql.append(TBTHB12WLRDK.TKSBMNSEQNO	+ " =  " + TBTHB2KMEI.TKSBMNSEQNO		+ "  AND ");
        sql.append(TBTHB12WLRDK.TKSTNTSEQNO	+ " =  " + TBTHB2KMEI.TKSTNTSEQNO		+ "  AND ");
        sql.append(TBTHB12WLRDK.KYOKUCD		+ " =  " + "TRIM(" + TBTHB2KMEI.CODE2	+ ") AND ");

        sql.append("TRIM("+ TBTHB2KMEI.CODE6	+ ")" + " IN "+ " ('003' , '004' ) "	+ "  AND ");
        sql.append("TRIM("+ TBTHB2KMEI.CODE1	+ ")" + " = " + " '04' "				+ "      ");

        //*************************************************************************************************
        //OREDER BY
        //*************************************************************************************************
        sql.append(" ORDER BY ");
        sql.append(TBTHB2KMEI.CODE6 					+ ", ");
//		sql.append("mast1."	+ TBTHB10WLRDB.HYOJIJYUN 		+ ", ");
        sql.append("mast3."	+ TBTHB12WLRDK.HYOJIJYUN 		+ ", ");
        sql.append(" "	+ TBTHB2KMEI.CODE5 			+ ", ");
        sql.append(" "	+ TBTHB2KMEI.CODE2 			+ "  ");

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
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));							//�����N��
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));				//�}�̋敪
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));				//�㗝�X�R�[�h
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));				//�J�[�hNo
                vo.setSonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));			//�{��
                vo.setKngk2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase()));					//�l�b�g��
                vo.setKngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase()));					//�����
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//�����z
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));				//�l���z
                vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));  //����ŗ�
                vo.setShohizeiGak((BigDecimal) result.get(ReportLionVO.SHOHIZEI_GAK.toUpperCase()));	//����Ŋz
                vo.setByosuGokei((BigDecimal) result.get(ReportLionVO.BYOSU_GOKEI.toUpperCase()));		//CM�b�����v
                vo.setKyokuCd((String) result.get(ReportLionVO.KYOKU_CD.toUpperCase()));				//�ǃR�[�h
                vo.setKyokuMei((String) result.get(ReportLionVO.KYOKU_MEI.toUpperCase()));				//�ǖ���
                vo.setBangumiCd((String) result.get(ReportLionVO.BANGUMI_CD.toUpperCase()));			//�ԑg�R�[�h
                vo.setBangumiMei((String) result.get(ReportLionVO.BANGUMI_MEI.toUpperCase()));			//�ԑg����

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
