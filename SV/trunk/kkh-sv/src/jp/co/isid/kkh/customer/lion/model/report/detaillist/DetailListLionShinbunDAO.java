package jp.co.isid.kkh.customer.lion.model.report.detaillist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionDaoInterface;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionVO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.LionDetailListConstants;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ���C�I�����׈ꗗ���[(�V��)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/07)<BR>
 * </P>
 *
 * @author
 */

public class DetailListLionShinbunDAO extends AbstractRdbDao implements DetailListLionDaoInterface{

    /** �ėp�}�X�^�������� */
    private DetailListLionCondition _cond;

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r�ǃ}�X�^ */
    public static final String C_HBAMST_SYBT_TV_KYOKU = LionDetailListConstants.MastBaitaiShubetsu.TV_KYOKU.getCode();
    //public static final String C_HBAMST_SYBT_TV_KYOKU = "401";

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r�ԑg�}�X�^ */
    public static final String C_HBAMST_SYBT_TV_BANGUMI =  LionDetailListConstants.MastBaitaiShubetsu.TV_BANGUMI.getCode();
    //public static final String C_HBAMST_SYBT_TV_BANGUMI = "601";

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public DetailListLionShinbunDAO() {
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
        sql.append("  " + TBTHB2KMEI.YYMM		+ ", ");	//�����N��
        sql.append("  TRIM(" + TBTHB2KMEI.CODE1		+ ") " + TBTHB2KMEI.CODE1 +" , ");	//�}�̋敪
        sql.append("  TRIM(" + TBTHB2KMEI.CODE2		+ ")" + TBTHB2KMEI.CODE2 +" , ");	//�V�����R�[�h
        sql.append("  TRIM(" + TBTHB2KMEI.CODE3	+ ")" + TBTHB2KMEI.CODE3 +" , ");	//�u�����h�R�[�h
        sql.append("  TRIM(" + TBTHB2KMEI.CODE4	+ ")" + TBTHB2KMEI.CODE4 +" , ");	//�㗝�X�R�[�h
        sql.append("  TRIM(" + TBTHB2KMEI.CODE6	+ ")" + TBTHB2KMEI.CODE6 +" , ");	//�J�[�hNo
        sql.append("  " + TBTHB2KMEI.NAME1		+ ", ");	//�����A
        sql.append("  " + TBTHB2KMEI.NAME4		+ ", ");	//���{��
        sql.append("  " + TBTHB2KMEI.NAME7		+ ", ");	//����
        sql.append("  " + TBTHB2KMEI.NAME8		+ ", ");	//���l
        sql.append("  " + TBTHB2KMEI.SEIGAK		+ ", ");	//�����z
        sql.append("  " + TBTHB2KMEI.NEBIGAK		+ ", ");	//�l���z
        sql.append("  " + TBTHB2KMEI.SONOTA5		+ ", ");	//�{��
        sql.append("  " + TBTHB2KMEI.SONOTA7		+ ", ");	//�b��
        sql.append("  " + TBTHB2KMEI.RITU1		+ ", ");	//����ŗ�
//		sql.append("  TRUNC(" + TBTHB2KMEI.SEIGAK + " * " + TBTHB2KMEI.RITU1 + " / 100 ) AS "+ DetailListLionVO.SHOHIZEI_GAK +  ", "  );	//�����
        sql.append("  TO_NUMBER(" + TBTHB2KMEI.NAME1 + ") AS " + DetailListLionVO.SHOHIZEI_GAK + ", "); // �����
        sql.append("  mast5." + TBTHBAMST.SYBT		+ ", ");	//���
        sql.append("  mast5." + TBTHBAMST.FIELD1		+ " AS " + DetailListLionVO.BRAND_CD + ", ");	//�u�����h�R�[�h
        sql.append("  mast5." + TBTHBAMST.FIELD2		+ " AS  " + DetailListLionVO.BRAND_MEI + ", ");	//�u�����h��
        sql.append("  mast5." + TBTHBAMST.FIELD3		+ " , ");
        sql.append("  mast5." + TBTHBAMST.FIELD4		+ " , ");
        sql.append("  mast5." + TBTHBAMST.FIELD5		+ " , ");
        sql.append("  mast5." + TBTHBAMST.FIELD6		+ " , ");
        sql.append("  mast11." + TBTHBAMST.SYBT		+ ", ");	//���
        sql.append("  mast11." + TBTHBAMST.FIELD1		+ " AS  " + DetailListLionVO.SHINBUN_CD + ", ");	//�V���R�[�h
        sql.append("  mast11." + TBTHBAMST.FIELD2		+ " AS  " + DetailListLionVO.SHINBUN_MEI + ", ");	//�V����
        sql.append("  mast11." + TBTHBAMST.FIELD3		+ ", ");
        sql.append("  mast11." + TBTHBAMST.FIELD4		+ ", ");
        sql.append("  mast11." + TBTHBAMST.FIELD5		+ ", ");
        sql.append("  mast11." + TBTHBAMST.FIELD6		+ " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " thb1, ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " thb2, ");
        sql.append(" (SELECT ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + ",");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHBAMST.SYBT + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");
        sql.append(" " + TBTHBAMST.FIELD2 + ",");
        sql.append(" " + TBTHBAMST.FIELD3 + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + ",");
        sql.append(" " + TBTHBAMST.FIELD6 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' ) mast5 ,");
        sql.append(" (SELECT ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + ",");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHBAMST.SYBT + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");
        sql.append(" " + TBTHBAMST.FIELD2 + ",");
        sql.append(" " + TBTHBAMST.FIELD3 + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + ",");
        sql.append(" " + TBTHBAMST.FIELD6 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '105' ) mast11 ");
        sql.append(" WHERE ");
        sql.append("  thb2." + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append("  thb2." + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getymfrom() + "' AND '" + _cond.getymto() + "' AND ");
        sql.append("  thb2." + TBTHB2KMEI.CODE1 + " = '07' AND ");
        sql.append("  thb2." + TBTHB2KMEI.EGCD + " = thb1." + TBTHB1DOWN.EGCD + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSKGYCD + " = thb1." + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSBMNSEQNO + " = thb1." + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSTNTSEQNO + " = thb1." + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.YYMM + " = thb1." + TBTHB1DOWN.YYMM + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.JYUTNO + " = thb1." + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.JYMEINO + " = thb1." + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.URMEINO + " = thb1." + TBTHB1DOWN.URMEINO + " AND ");
        sql.append("  thb1." + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
        sql.append("  thb2." + TBTHB2KMEI.CODE6 + " = '007' AND ");
        sql.append("  TRIM(thb2." + TBTHB2KMEI.CODE3 + ") = mast5." + TBTHBAMST.FIELD1 +" AND ");
        sql.append("  TRIM(thb2." + TBTHB2KMEI.CODE2 + ") = mast11." + TBTHBAMST.FIELD1 +"  ");
        sql.append(" ORDER BY ");
        sql.append(" thb2." + TBTHB2KMEI.YYMM + ", ");
        sql.append(" thb2." + TBTHB2KMEI.CODE3 + ", ");
        sql.append(" mast11." + TBTHBAMST.FIELD4  + ", ");
        sql.append(" mast11." + TBTHBAMST.FIELD5  + ", ");
        sql.append(" thb2." + TBTHB2KMEI.CODE2 + ", ");
        sql.append(" thb2." + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" thb2." + TBTHB2KMEI.JYMEINO + ", ");
        sql.append(" thb2." + TBTHB2KMEI.URMEINO + " ");

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
    public List<DetailListLionVO> findDetailListLionByCondition(DetailListLionCondition cond)
            throws KKHException {

        super.setModel(new DetailListLionVO());

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
    protected List<DetailListLionVO> createFindedModelInstances(List hashList) {
        List<DetailListLionVO> list = new ArrayList<DetailListLionVO>();
        if (getModel() instanceof DetailListLionVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                DetailListLionVO vo = new DetailListLionVO();
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));							//�����N��
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));				//�}�̋敪
                vo.setCode2((String) result.get(TBTHB2KMEI.CODE2.toUpperCase().trim()));
                vo.setCode3((String) result.get(TBTHB2KMEI.CODE3.toUpperCase().trim()));//�u�����h�R�[�h
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));				//�㗝�X�R�[�h
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));				//�J�[�hNo
                vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim()));
                vo.setName4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase().trim()));
                vo.setName7((String) result.get(TBTHB2KMEI.NAME7.toUpperCase().trim()));
                vo.setName8((String) result.get(TBTHB2KMEI.NAME8.toUpperCase().trim()));
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//�����z
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));				//�l���z
                vo.setSonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));			//�{��
                vo.setSonota7((String) result.get(TBTHB2KMEI.SONOTA7.toUpperCase().trim()));			//�b��
                vo.setShohizeiGak((BigDecimal) result.get(DetailListLionVO.SHOHIZEI_GAK.toUpperCase().trim()));			//�����
                vo.setShinCd((String) result.get(DetailListLionVO.SHINBUN_CD.toUpperCase().trim()));   //�V���R�[�h
                vo.setShinMei((String) result.get(DetailListLionVO.SHINBUN_MEI.toUpperCase().trim())); //�V����
                vo.setBrandCd((String) result.get(DetailListLionVO.BRAND_CD.toUpperCase().trim())); //�u�����h�R�[�h
                vo.setBrandMei((String) result.get(DetailListLionVO.BRAND_MEI.toUpperCase().trim())); //�u�����h��
//
//				vo.setKngk2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase()));					//�l�b�g��
//				vo.setKngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase()));					//�����
//
//
//				vo.setShohizeiGak((BigDecimal) result.get(DetailListLionVO.SHOHIZEI_GAK.toUpperCase()));	//����Ŋz
//				vo.setByosuGokei((BigDecimal) result.get(DetailListLionVO.BYOSU_GOKEI.toUpperCase()));		//CM�b�����v
//				vo.setKyokuCd((String) result.get(DetailListLionVO.KYOKU_CD.toUpperCase()));				//�ǃR�[�h
//				vo.setKyokuMei((String) result.get(DetailListLionVO.KYOKU_MEI.toUpperCase()));				//�ǖ���
//				vo.setBangumiCd((String) result.get(DetailListLionVO.BANGUMI_CD.toUpperCase()));			//�ԑg�R�[�h
//				vo.setBangumiMei((String) result.get(DetailListLionVO.BANGUMI_MEI.toUpperCase()));			//�ԑg����

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
