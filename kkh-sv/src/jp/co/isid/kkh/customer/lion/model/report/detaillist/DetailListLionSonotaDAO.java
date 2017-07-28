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
 * ���C�I�����׈ꗗ���[(���̑�)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/07)<BR>
 * </P>
 *
 * @author
 */

public class DetailListLionSonotaDAO extends AbstractRdbDao implements  DetailListLionDaoInterface{

    /** �ėp�}�X�^�������� */
    private DetailListLionCondition _cond;

    private enum SqlMode{DATA,SYOHIZEI};
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
    public DetailListLionSonotaDAO() {
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
        }else if(_sqlMode.equals(SqlMode.SYOHIZEI))
        {
            return getSelectSQLForSyohizei();
        }

        return "";
    }

    /**
     * ���C�I�����׈ꗗ���[(���̑�)�f�[�^�擾SQL
     * @return String SQL��
     */
    private String getSelectSQLForItem() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append("  " + TBTHB2KMEI.CODE4 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE3 + " " + DetailListLionVO.BRAND_CD + ", ");
        sql.append(" " + TBTHBAMST.FIELD2 + " " + DetailListLionVO.BRAND_MEI + ", ");
        sql.append("  " + TBTHB2KMEI.SEIGAK + ", ");
        sql.append("  TRIM(" + TBTHB2KMEI.NAME10 + ") " + DetailListLionVO.KEN_MEI + ", ");
        sql.append("  " + TBTHB2KMEI.NAME1 +  " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getymfrom() + "' AND '" + _cond.getymto() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('010') AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append("  " + TBTHB2KMEI.CODE3 + ", ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append("  " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append("  " + TBTHB2KMEI.URMEINO + " ");

        return sql.toString();
    }

    /**
     * ���C�I�����׈ꗗ���[(���̑������)�f�[�^�擾SQL
     * @return String SQL��
     */
    private String getSelectSQLForSyohizei() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
//		sql.append(" sum(" + TBTHB2KMEI.SEIGAK + " * " +TBTHB2KMEI.RITU1 + " / 100) " + DetailListLionVO.SHOHIZEI_GAK  + " ");
//		sql.append(" sum(" + TBTHB2KMEI.NAME1 + ") " + DetailListLionVO.SHOHIZEI_GAK  + " ");
        sql.append(" sum(" + TBTHB2KMEI.SEIGAK + ") " + DetailListLionVO.SHOHIZEI_GAK  + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getymfrom() + "' AND '" + _cond.getymto() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('001','002','003','004','005','007','008','009','010','014','015','016','017','018','019') AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  ");
        sql.append(" GROUP BY ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + " ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB2KMEI.CODE6 + " ");

        return sql.toString();
    }

    /**
     * ���C�I�����׈ꗗ���[(���̑�)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
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

    /**
     * ���C�I�����׈ꗗ���[(���̑������)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<DetailListLionVO> findDetailListLionSyohiZeiByCondition(DetailListLionCondition cond)
            throws KKHException {

        super.setModel(new DetailListLionVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.SYOHIZEI;
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
     * @param hashList List ��������
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
                    vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));	//�}�̋敪
                    vo.setBrandCd((String) result.get(DetailListLionVO.BRAND_CD.toUpperCase().trim()));    //�u�����h�R�[�h
                    vo.setBrandMei((String) result.get(DetailListLionVO.BRAND_MEI.toUpperCase().trim())); //�u�����h��
                    vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//�����z
                    vo.setKenMei((String) result.get(DetailListLionVO.KEN_MEI.toUpperCase()));							//����
                    vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase()));	//����Ŋz

                    // �������ʒ���̏�Ԃɂ���
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }

            return list;
        }
        else if(_sqlMode.equals(SqlMode.SYOHIZEI)){
            if (getModel() instanceof DetailListLionVO) {
                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    DetailListLionVO vo = new DetailListLionVO();
                    vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));	//�J�[�hNO
                    vo.setShohizeiGak((BigDecimal) result.get(DetailListLionVO.SHOHIZEI_GAK.toUpperCase()));	//����Ŋz

                    // �������ʒ���̏�Ԃɂ���
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }

            return list;
        }

        return list;
    }

}
