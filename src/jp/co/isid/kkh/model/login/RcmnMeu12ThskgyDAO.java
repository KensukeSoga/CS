package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU12THSKGY;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU13THSKGYBMON;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class RcmnMeu12ThskgyDAO extends AbstractRdbDao {

    /** �I���N���ő�l */
    private static final String ENDYMD_MAX = "99999999";

    /** ������񌟍����� */
    private RcmnMeu12ThskgyCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public RcmnMeu12ThskgyDAO() {
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
        sql.append("  " + TBRCMN_MEU12THSKGY.THSKGYDISPKJ + " ");
        sql.append(" ," + TBRCMN_MEU13THSKGYBMON.SUBMEI + " ");
        sql.append(" FROM ");
        sql.append(" " + TBRCMN_MEU12THSKGY.TBNAME + ", " + TBRCMN_MEU13THSKGYBMON.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBRCMN_MEU13THSKGYBMON.THSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU13THSKGYBMON.SEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU13THSKGYBMON.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU12THSKGY.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU12THSKGY.THSKGYCD + " = " + TBRCMN_MEU13THSKGYBMON.THSKGYCD);

        return sql.toString();
    }

    /**
     * �������̌������s���܂��B
     *
     * @return �������VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<RcmnMeu12ThskgyVO> getCustomerInfo(RcmnMeu12ThskgyCondition cond) throws KKHException {

        super.setModel(new RcmnMeu12ThskgyVO());

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
     * @return List<RcmnMeu12ThskgyVO> �ϊ���̌�������
     */
    @Override
    protected List<RcmnMeu12ThskgyVO> createFindedModelInstances(List hashList) {

        List<RcmnMeu12ThskgyVO> list = new ArrayList<RcmnMeu12ThskgyVO>();
        if (getModel() instanceof RcmnMeu12ThskgyVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                RcmnMeu12ThskgyVO vo = new RcmnMeu12ThskgyVO();
                vo.setThskgyDispKj(StringUtil.trim((String) result.get(TBRCMN_MEU12THSKGY.THSKGYDISPKJ.toUpperCase())));
                vo.setSubMei(StringUtil.trim((String) result.get(TBRCMN_MEU13THSKGYBMON.SUBMEI.toUpperCase())));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
