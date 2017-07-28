package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTCM01KKH;
import jp.co.isid.kkh.integ.tbl.TBTCM02JUN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class Tcm01KkhDAO extends AbstractRdbDao {

    /** �͈̓t���O�FON */
    private static final String ZHANNIGF_ON = "1";

    /** �͈̓t���O�FOFF */
    private static final String ZHANNIGF_OFF = "0";

    /** �󔭒��o�^�t���O�FON */
    private static final String ZJYUHACHU_ON = "1";

    /** �X�e�[�^�X�F���� */
    private static final String ZSBCH0103_NORMAL = "O";

    /** ���J�͈͏�񌟍����� */
    private Tcm01KkhCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public Tcm01KkhDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
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
    public String getTableName() {
        return "";
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[] {};
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" /*+ ordered */ ");
        sql.append(" " + TBTCM02JUN.ZSBCH0317 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTCM01KKH.TBNAME + ", " + TBTCM02JUN.TBNAME);
        sql.append(" WHERE ");
        sql.append(" ((" + TBTCM01KKH.ZHANNIGF + " = '" + ZHANNIGF_ON + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZSBCH0105 + " = '" + _cond.getHigherOrganizationCode() + "' ) ");
        sql.append(" OR ");
        sql.append(" ( " + TBTCM01KKH.ZHANNIGF + " = '" + ZHANNIGF_OFF + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZSBCH0105 + " = '" + _cond.getOperationNo() + "' )) ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZTOUKYU + " IN ( " + _cond.getGroupCd() + " ) ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZSBCH0110 + " IN ( " + _cond.getTntCd() + " ) ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.DATEFROM + " <= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.DATETO + " >= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZJYUHACHU + " = '" + ZJYUHACHU_ON + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZDELFG + " IS NULL ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.ZSBCH0317 + " = '" + _cond.getCustomerCode() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.DATEFROM + " <= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.DATETO + " >= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.ZSBCH0211 + " <= '" + _cond.getTermBegin() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.ZSBCH0212 + " >= '" + _cond.getTermEnd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM02JUN.ZSBCH0103 + " = '" + ZSBCH0103_NORMAL + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTCM01KKH.ZSBCH0100 + " = " + TBTCM02JUN.ZSBCH0100);
        sql.append(" AND ROWNUM = 1");

        return sql.toString();
    }

    /**
     * ���J�͈͏��̌������s���܂��B
     *
     * @return ���J�͈͏��VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Tcm01KkhVO> getOpenRange(Tcm01KkhCondition cond) throws KKHException {

        super.setModel(new Tcm01KkhVO());

        try {
            _cond = cond;
//            _sqlMode = SqlMode.COND;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "HB-E0001");
        }

    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList List ��������
     * @return List<Tcm01KkhVO> �ϊ���̌�������
     */
    @Override
    protected List<Tcm01KkhVO> createFindedModelInstances(List hashList) {

        List<Tcm01KkhVO> list = new ArrayList<Tcm01KkhVO>();
        if (getModel() instanceof Tcm01KkhVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                Tcm01KkhVO vo = new Tcm01KkhVO();
                vo.setZsbch0317(StringUtil.trim((String) result.get(TBTCM02JUN.ZSBCH0317.toUpperCase())));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
