package jp.co.isid.kkh.customer.lion.model.report.detaillist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.customer.lion.model.report.DetailListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionDaoInterface;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionVO;
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
 * ���C�I�����׈ꗗ���[(����)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/07)<BR>
 * </P>
 *
 * @author
 */

public class DetailListLionSeisakDAO extends AbstractRdbDao implements  DetailListLionDaoInterface{

    /** �ėp�}�X�^�������� */
    private DetailListLionCondition _cond;

    private enum SqlMode{DATA,BAITAI};
    private SqlMode _sqlMode = SqlMode.DATA;

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
    public DetailListLionSeisakDAO() {
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
        if(_sqlMode.equals(SqlMode.DATA))
        {
            return getSelectSQLForItem();
        }else if(_sqlMode.equals(SqlMode.BAITAI))
        {
            return getSelectSQLForBaitai();
        }

        return "";
    }

    private String getSelectSQLForItem() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append("  " + TBTHB2KMEI.CODE4 + ", ");
        sql.append("  mast1." + TBTHBAMST.FIELD1 + " " + DetailListLionVO.JANLE_CD + ", ");
        sql.append("  mast1." + TBTHBAMST.FIELD2 + " " + DetailListLionVO.JANLE_NAME + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE3 + " " + DetailListLionVO.BRAND_CD + ", ");
        sql.append("  mast2." + TBTHBAMST.FIELD2 + " " + DetailListLionVO.BRAND_MEI + ", ");
        sql.append("  " + TBTHB2KMEI.SEIGAK + ", ");
        sql.append("  " + TBTHB2KMEI.NAME1   + ", ");
        sql.append("  mast3." + TBTHBAMST.FIELD2 + " " + DetailListLionVO.BAITAI_NAME + ", ");
        sql.append("  " + TBTHB2KMEI.NAME10 + "  " + DetailListLionVO.KEN_MEI + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast1, ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast2, ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast3 ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getymfrom() + "' AND '" + _cond.getymto() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '" + _cond.getbaitaikbn() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('012') AND ");
        sql.append(" mast2." + TBTHBAMST.SYBT + " = '201' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = mast2." + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" mast1." + TBTHBAMST.SYBT + " = '103' AND ");
        sql.append(" mast2." + TBTHBAMST.FIELD4 + " =  mast1." + TBTHBAMST.FIELD1 +" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast2." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast2." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast2." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast1." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast1." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast1." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast3." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast3." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast3." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" mast3." + TBTHBAMST.SYBT + " = '104' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = mast3." + TBTHBAMST.FIELD1 + " ");
        sql.append(" ORDER BY ");
        sql.append(" " + TBTHB2KMEI.YYMM + ", ");
        sql.append(" " + DetailListLionVO.JANLE_CD + ", ");
        sql.append(" " + DetailListLionVO.BRAND_CD + ", ");
        sql.append(" " + TBTHB2KMEI.CODE1 + ", ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        // 2015/08/18 UnixAB���@�T�[�o���v���[�X�Ή� oki keisuke UPD START
        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.RENBN + " ");
        // sql.append(" " + TBTHB2KMEI.URMEINO + " ");
        // 2015/08/18 UnixAB���@�T�[�o���v���[�X�Ή� oki keisuke UPD END

        return sql.toString();
    }


    private String getSelectSQLForBaitai() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBAMST.FIELD1 + " " + DetailListLionVO.BAITAI_CD + ", ");
        sql.append("  " + TBTHBAMST.FIELD2 + " " + DetailListLionVO.BAITAI_NAME  + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append("  " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append("  " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append("  " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append("  " + TBTHBAMST.SYBT+ " = '104' ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHBAMST.FIELD1 + " ");

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
            _sqlMode = SqlMode.DATA;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }


    @SuppressWarnings("unchecked")
    public List<DetailListLionVO> findDetailListLionBaitaiCdName(DetailListLionCondition cond)
            throws KKHException {

        super.setModel(new DetailListLionVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.BAITAI;
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
        if(_sqlMode.equals(SqlMode.DATA))
        {
            if (getModel() instanceof DetailListLionVO) {
                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    DetailListLionVO vo = new DetailListLionVO();
                    vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));	//�J�[�hNO
                    vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));				//�����N��
                    vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));	//�㗝�X�R�[�h
                    vo.setJanleCd((String) result.get(DetailListLionVO.JANLE_CD.toUpperCase().trim()));	//�W�������R�[�h
                    vo.setJanleName((String) result.get(DetailListLionVO.JANLE_NAME.toUpperCase().trim()));	//�W��������
                    vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));	//�}�̋敪
                    vo.setBrandCd((String) result.get(DetailListLionVO.BRAND_CD.toUpperCase().trim()));    //�u�����h�R�[�h
                    vo.setBrandMei((String) result.get(DetailListLionVO.BRAND_MEI.toUpperCase().trim())); //�u�����h��
                    vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//�����z
                    vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim()));		//�����
                    vo.setBaitaiName((String) result.get(DetailListLionVO.BAITAI_NAME.toUpperCase().trim()));	//�}�̖�
                    vo.setKenMei((String) result.get(DetailListLionVO.KEN_MEI.toUpperCase().trim()));  //����
                    // �������ʒ���̏�Ԃɂ���
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }else if(_sqlMode.equals(SqlMode.BAITAI))
        {
            if (getModel() instanceof DetailListLionVO) {
                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    DetailListLionVO vo = new DetailListLionVO();
                    vo.setBaitaiCd((String) result.get(DetailListLionVO.BAITAI_CD.toUpperCase().trim()));	//�}�̃R�[�h
                    vo.setBaitaiName((String) result.get(DetailListLionVO.BAITAI_NAME.toUpperCase().trim()));	//�}�̖�

                    // �������ʒ���̏�Ԃɂ���
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }

        return list;
    }

}
