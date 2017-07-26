package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.VWACCUSER;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class Vkj01AccuserDAO extends AbstractRdbDao {

    /** �l���VIEW�������� */
    private Vkj01AccuserCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public Vkj01AccuserDAO() {
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
        sql.append(" " + VWACCUSER.OGNZUNTCD + " ");
        sql.append(" FROM ");
        sql.append(" " + VWACCUSER.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + VWACCUSER.ESQID + " = '" + _cond.getEsqId() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWACCUSER.SIKOGNZUNTCD + " = '" + _cond.getOperationNo() + "' ");

        return sql.toString();
    }

    /**
     * �l���VIEW�̌������s���܂��B
     *
     * @return �l���VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Vkj01AccuserVO> getPersonalInfo(Vkj01AccuserCondition cond) throws KKHException {

        super.setModel(new Vkj01AccuserVO());

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
     * @return List<Vkj01AccuserVO> �ϊ���̌�������
     */
    @Override
    protected List<Vkj01AccuserVO> createFindedModelInstances(List hashList) {

        List<Vkj01AccuserVO> list = new ArrayList<Vkj01AccuserVO>();
        if (getModel() instanceof Vkj01AccuserVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                Vkj01AccuserVO vo = new Vkj01AccuserVO();
                vo.setOgnzuntCd(StringUtil.trim((String) result.get(VWACCUSER.OGNZUNTCD.toUpperCase())));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
