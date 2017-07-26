package jp.co.isid.kkh.model.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTKJ99KNR;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * �Ɩ���v�ғ���DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/09 JSE H.Abe)<BR>
 * </P>
 *
 * @author
 */
public class AccountOperationStatusDAO extends AbstractRdbDao {

//    /** �������� */
//    private AccountOperationStatusCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public AccountOperationStatusDAO() {
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
        return TBTKJ99KNR.TBNAME;
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
        sql.append("  " + TBTKJ99KNR.KANRIFLG + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTKJ99KNR.TBNAME + " ");
        // Where��
        sql.append(" WHERE ");
        sql.append(" " + TBTKJ99KNR.SYSTEMID + " = 'HB' ");
        sql.append(" AND ");
        sql.append(" " + TBTKJ99KNR.SYSTEMNO + " = '02' ");

        return sql.toString();
    }

    /**
     * �Ɩ���v�ғ��󋵂̌������s���܂��B
     *
     * @return �Ɩ���v�ғ���VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<AccountOperationStatusVO> getAccountOperationStatus(AccountOperationStatusCondition cond)
            throws KKHException {

        super.setModel(new AccountOperationStatusVO());

        try {
//            _cond = cond;
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
     * @return List<AccountOperationStatusMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<AccountOperationStatusVO> createFindedModelInstances(List hashList) {
        List<AccountOperationStatusVO> list = new ArrayList<AccountOperationStatusVO>();
        if (getModel() instanceof AccountOperationStatusVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                AccountOperationStatusVO vo = new AccountOperationStatusVO();
                vo.setKanriFlg(StringUtil.trim((String) result.get(TBTKJ99KNR.KANRIFLG.toUpperCase())));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
