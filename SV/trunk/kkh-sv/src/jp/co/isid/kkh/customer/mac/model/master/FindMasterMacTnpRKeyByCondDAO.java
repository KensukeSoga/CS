package jp.co.isid.kkh.customer.mac.model.master;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB17RMTNP;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRByCondCondition;

/**
 *
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u���L�[���ڎ擾DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 *
 * @author
 */
public class FindMasterMacTnpRKeyByCondDAO extends AbstractRdbDao {

    /** �f�[�^�������� */
    private FindMasterMacTnpRByCondCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindMasterMacTnpRKeyByCondDAO() {
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
        // new String[] {};
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return TBTHB17RMTNP.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
        };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {

        return getSelectSQLMacTnpRKey();
    }

    /**
     * �}�N�h�i���h�X�܃}�X�^�����e�[�u��������
     *
     * @param cond �X�V����
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    @SuppressWarnings("unchecked")
    public List<FindMasterMacTnpRKeyByCondVO> findthb17rmtnp(FindMasterMacTnpRByCondCondition cond) throws KKHException {

        super.setModel(new FindMasterMacTnpRKeyByCondVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �r�p�k����
     */
    public String getSelectSQLMacTnpRKey()
    {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " ");
        sql.append(",MAX(" + TBTHB17RMTNP.TORIKOMIFLG + ") HB17_TORIKOMIFLG");
        sql.append(" FROM ");
        sql.append(" " + TBTHB17RMTNP.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB17RMTNP.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB17RMTNP.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB17RMTNP.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB17RMTNP.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" GROUP BY ");
        sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " ");
        sql.append(" ORDER BY ");
        sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " DESC ");

        return sql.toString();
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
    protected List<FindMasterMacTnpRKeyByCondVO> createFindedModelInstances(List hashList) {
        List<FindMasterMacTnpRKeyByCondVO> list = new ArrayList<FindMasterMacTnpRKeyByCondVO>();
        if (getModel() instanceof FindMasterMacTnpRKeyByCondVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindMasterMacTnpRKeyByCondVO vo = new FindMasterMacTnpRKeyByCondVO();

                vo.setUpdRrkTimstmp((String)result.get(TBTHB17RMTNP.UPDRRKTIMSTMP.toUpperCase()));
                vo.setTorikomiFlg((String)result.get(TBTHB17RMTNP.TORIKOMIFLG.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
