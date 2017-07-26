package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHBCKHT;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class ThbcKhtDAO extends AbstractRdbDao {

    /** �J�����Ӑ�Ǘ���񌟍����� */
    private ThbcKhtCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ThbcKhtDAO() {
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
        sql.append("  " + TBTHBCKHT.DISFLG + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBCKHT.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBTHBCKHT.EGSCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBCKHT.TKSKGYCD + " = '" + _cond.getKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBCKHT.TKSBMNSEQNO + " = '" + _cond.getBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBCKHT.TKSTNTSEQNO + " = '" + _cond.getTntSeqNo() + "' ");

        return sql.toString();
    }

    /**
     * �J�����Ӑ�Ǘ����̌������s���܂��B
     *
     * @return �J�����Ӑ�Ǘ����VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ThbcKhtVO> getOpenCustomerInfo(ThbcKhtCondition cond) throws KKHException {

        super.setModel(new ThbcKhtVO());

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
     * @return List<ThbcKhtVO> �ϊ���̌�������
     */
    @Override
    protected List<ThbcKhtVO> createFindedModelInstances(List hashList) {

        List<ThbcKhtVO> list = new ArrayList<ThbcKhtVO>();
        if (getModel() instanceof ThbcKhtVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ThbcKhtVO vo = new ThbcKhtVO();
                vo.setDisFlg(StringUtil.trim((String) result.get(TBTHBCKHT.DISFLG.toUpperCase())));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
