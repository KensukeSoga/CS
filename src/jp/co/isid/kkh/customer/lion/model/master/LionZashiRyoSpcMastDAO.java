package jp.co.isid.kkh.customer.lion.model.master;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class LionZashiRyoSpcMastDAO extends AbstractRdbDao  {

    /** ���W�I�ǃ}�X�^�������� */
    private LionZashiRyoSpcMastCondition _cond;

    //���//////////////////////////////////////////////////////////////////////////////////////////////////
    /** �ėp�}�X�^�F��ʁF�G�� */
    public static final String C_HBAMST_SYBT_ZASHI =  LionConstants.MastBaitaiShubetsu.ZASHI.getCode();
    /** �ėp�}�X�^�F��ʁF�G���X�y�[�X */
    public static final String C_HBAMST_SYBT_ZASHI_SPACE =  LionConstants.MastBaitaiShubetsu.ZASHI_SPACE.getCode();
    /** �ėp�}�X�^�F��ʁF���� */
    public static final String C_HBAMST_SYBT_ZASHI_RYOKIN =  LionConstants.MastBaitaiShubetsu.ZASHI_RYOKIN.getCode();
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public LionZashiRyoSpcMastDAO() {
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
        return TBTHBAMST.TBNAME;
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

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  ZSPACE." + TBTHBAMST.FIELD1 + " AS VAL1 ");
        sql.append(" , ' ' AS VAL2 , 0 AS VAL3 ");
        sql.append(" FROM ");
        sql.append("  " + TBTHBAMST.TBNAME + " ZSPACE ");
        sql.append(" WHERE ");
        sql.append(" ZSPACE." + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(" ZSPACE." + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(" ZSPACE." + TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append(" ZSPACE." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_SPACE + "' AND ");
        sql.append(" ZSPACE." + TBTHBAMST.FIELD1 + " ");
        sql.append(" NOT IN(SELECT ");
        sql.append(" RYOKIN." + TBTHBAMST.FIELD2 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHBAMST.TBNAME + " RYOKIN ");
        sql.append(" WHERE ");
        sql.append(" RYOKIN." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_RYOKIN + "' AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append(" RYOKIN." + TBTHBAMST.FIELD1 + " = '" + _cond.getCd() + "') ");
        sql.append(" UNION SELECT ");
        sql.append("  RYOKIN." + TBTHBAMST.FIELD2 + " AS VAL1 ");
        sql.append(" ,RYOKIN." + TBTHBAMST.FIELD3 + " AS VAL2 ");
        sql.append(" ,RYOKIN." + TBTHBAMST.INTVALUE1 + " AS VAL3 ");
        sql.append(" FROM ");
        sql.append("  " + TBTHBAMST.TBNAME + " RYOKIN, " + TBTHBAMST.TBNAME + " ZSPACE ");
        sql.append(" WHERE ");
        sql.append(" ZSPACE." + TBTHBAMST.FIELD1 + " = " + "RYOKIN." + TBTHBAMST.FIELD2 + " AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(" RYOKIN." + TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append(" ZSPACE." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_SPACE + "' AND ");
        sql.append(" RYOKIN." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_RYOKIN + "' AND ");
        sql.append(" RYOKIN." + TBTHBAMST.FIELD1 + " = '" + _cond.getCd() + "'  ");

        return sql.toString();
    }

    /**
     * ���W�I�ǃ}�X�^�̌������s���܂��B
     *
     * @return �e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<LionZashiRyoSpcMastVO> lionZashiRyoSpcMastByCondition(LionZashiRyoSpcMastCondition cond) throws KKHException {

        super.setModel(new LionZashiRyoSpcMastVO());

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
     * @param hashList List ��������
     * @return List<CommonCodeMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<LionZashiRyoSpcMastVO> createFindedModelInstances(List hashList) {
        List<LionZashiRyoSpcMastVO> list = new ArrayList<LionZashiRyoSpcMastVO>();
        if (getModel() instanceof LionZashiRyoSpcMastVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                LionZashiRyoSpcMastVO vo = new LionZashiRyoSpcMastVO();

                //�}�X�^�P�`3�܂œ��I
                vo.setVal1((String)result.get(LionZashiRyoSpcMastVO.VAL1.toUpperCase()));
                vo.setVal2((String)result.get(LionZashiRyoSpcMastVO.VAL2.toUpperCase()));
                vo.setVal3((BigDecimal) result.get(LionZashiRyoSpcMastVO.VAL3));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
