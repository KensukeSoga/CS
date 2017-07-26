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
 * ���[�iLion)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/07)<BR>
 * </P>
 *
 * @author
 */

public class DetailListLionZashiDAO extends AbstractRdbDao implements  DetailListLionDaoInterface{

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
    public DetailListLionZashiDAO() {
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
        sql.append(" " + TBTHB2KMEI.CODE6 + ", ");
        sql.append(" " + TBTHB2KMEI.YYMM + ", ");
        sql.append(" " + TBTHB2KMEI.CODE4 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE1 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE2 + " " + DetailListLionVO.ZASHI_CD + ", ");
        sql.append(" " + TBTHB2KMEI.NAME2 + " " + DetailListLionVO.SPACE + ", ");
        sql.append(" " + TBTHB2KMEI.NAME4 + ", ");
        sql.append(" " + TBTHB2KMEI.SEIGAK + ", ");
        sql.append(" " + TBTHB2KMEI.NAME8 + ", ");
        sql.append(" " + TBTHB2KMEI.NAME1 + ", ");
        sql.append(" " + TBTHB2KMEI.KNGK3 + ", ");
        sql.append("  mast2." + TBTHBAMST.FIELD2 + " " + DetailListLionVO.BRAND_MEI + ", ");
        sql.append("  mast1." + TBTHBAMST.FIELD2 + " " + DetailListLionVO.ZASHI_NAME + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " , ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " , ");
        sql.append(" " + TBTHBAMST.TBNAME + "  mast1, ");
        sql.append(" " + TBTHBAMST.TBNAME + "  mast2 ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" +_cond.getEgCd() +"'AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" +_cond.getTksKgyCd() +"' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" +_cond.getTksBmnSeqNo() +"' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" +_cond.getTksTntSeqNo() +"' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getymfrom() + "' AND '" + _cond.getymto() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('008') AND ");
        sql.append(" mast1." + TBTHBAMST.SYBT + " =  '106' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ")  = mast1." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" mast2." + TBTHBAMST.SYBT + " =  '201' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ")  = mast2." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast1." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast1." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast1." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast2." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast2." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast2." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.EGCD  + " =  " +  TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD  + " =  " +  TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO  + " =  " +  TBTHB1DOWN.TKSBMNSEQNO+ " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO  + " =  " +  TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM  + " =  " +  TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO  + " =  " +  TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " =  " +  TBTHB1DOWN.JYMEINO+ " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO  + " =  " +  TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " =  ' ' ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE2 + ", ");
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
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));
                vo.setBrandCd((String) result.get(TBTHB2KMEI.CODE3.toUpperCase().trim()));
                vo.setZashiCd((String) result.get(DetailListLionVO.ZASHI_CD.toUpperCase().trim()));
                vo.setSpace((String) result.get(DetailListLionVO.SPACE.toUpperCase().trim()));
                vo.setName4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase().trim()));
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setName8((String) result.get(TBTHB2KMEI.NAME8.toUpperCase().trim()));
                vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim()));
                vo.setKngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase()));
                vo.setZashiName((String) result.get(DetailListLionVO.ZASHI_NAME.toUpperCase().trim()));	//�G����
                vo.setBrandMei((String) result.get(DetailListLionVO.BRAND_MEI.toUpperCase().trim()));	//�u�����h��

//				vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));				//�l���z
//				vo.setSonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));			//�{��
//				vo.setSonota7((String) result.get(TBTHB2KMEI.SONOTA7.toUpperCase().trim()));			//�b��
//				vo.setShohizeiGak((BigDecimal) result.get(DetailListLionVO.SHOHIZEI_GAK.toUpperCase().trim()));			//�����
//
//				vo.setShinMei((String) result.get(DetailListLionVO.SHINBUN_MEI.toUpperCase().trim())); //�V����
//				vo.setBrandCd((String) result.get(DetailListLionVO.BRAND_CD.toUpperCase().trim())); //�u�����h�R�[�h
//				vo.setBrandMei((String) result.get(DetailListLionVO.BRAND_MEI.toUpperCase().trim())); //�u�����h��
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
