package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU07SIKKRSPRD;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class RcmnMeu07SikkrsprdDAO extends AbstractRdbDao {

    /** �o���g�D�W�J��񌟍����� */
    private RcmnMeu07SikkrsprdCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public RcmnMeu07SikkrsprdDAO() {
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
        sql.append("  " + TBRCMN_MEU07SIKKRSPRD.SIKCDKYK + " ");
        sql.append(" FROM ");
        sql.append(" " + TBRCMN_MEU07SIKKRSPRD.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBRCMN_MEU07SIKKRSPRD.SIKCD + " = '" + _cond.getHigherOrganizationCode() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU07SIKKRSPRD.EGSYOCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" '" + _cond.getEigyoBi() + "' BETWEEN " +  TBRCMN_MEU07SIKKRSPRD.STARTYMD + " AND " + TBRCMN_MEU07SIKKRSPRD.ENDYMD);

        return sql.toString();
    }

    /**
     * �o���g�D�W�J���̌������s���܂��B
     *
     * @return �o���g�D�W�J���VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<RcmnMeu07SikkrsprdVO> getAccountingOrganizationInfo(RcmnMeu07SikkrsprdCondition cond) throws KKHException {

        super.setModel(new RcmnMeu07SikkrsprdVO());

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
     * @return List<RcmnMeu07SikkrsprdVO> �ϊ���̌�������
     */
    @Override
    protected List<RcmnMeu07SikkrsprdVO> createFindedModelInstances(List hashList) {

        List<RcmnMeu07SikkrsprdVO> list = new ArrayList<RcmnMeu07SikkrsprdVO>();
        if (getModel() instanceof RcmnMeu07SikkrsprdVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                RcmnMeu07SikkrsprdVO vo = new RcmnMeu07SikkrsprdVO();
                vo.setSikCdKyk(StringUtil.trim((String) result.get(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK.toUpperCase())));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
