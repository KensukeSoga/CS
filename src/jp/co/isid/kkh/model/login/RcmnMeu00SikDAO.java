package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU00SIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class RcmnMeu00SikDAO extends AbstractRdbDao {

    /** �g�D�}�X�^�������� */
    private RcmnMeu00SikCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public RcmnMeu00SikDAO() {
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
        sql.append(" " + TBRCMN_MEU00SIK.EGSYOCD + " ");
        sql.append(" ," + TBRCMN_MEU00SIK.JSIKCD + " ");
        sql.append(" ," + TBRCMN_MEU00SIK.KAISOCD + " ");
        sql.append(" FROM ");
        sql.append(" " + TBRCMN_MEU00SIK.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBRCMN_MEU00SIK.SIKCD + " = '" + _cond.getOperationNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU00SIK.STARTYMD + " <= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU00SIK.ENDYMD + " >= '" + _cond.getEigyoBi() + "' ");

        return sql.toString();
    }

    /**
     * �g�D�}�X�^�̌������s���܂��B
     *
     * @return �g�D�}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<RcmnMeu00SikVO> getBusinessOfficeInfo(RcmnMeu00SikCondition cond) throws KKHException {

        super.setModel(new RcmnMeu00SikVO());

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
     * @return List<RcmnMeu00SikVO> �ϊ���̌�������
     */
    @Override
    protected List<RcmnMeu00SikVO> createFindedModelInstances(List hashList) {

        List<RcmnMeu00SikVO> list = new ArrayList<RcmnMeu00SikVO>();
        if (getModel() instanceof RcmnMeu00SikVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                RcmnMeu00SikVO vo = new RcmnMeu00SikVO();
                vo.setEgsyoCd(StringUtil.trim((String) result.get(TBRCMN_MEU00SIK.EGSYOCD.toUpperCase())));
                vo.setJSikCd(StringUtil.trim((String) result.get(TBRCMN_MEU00SIK.JSIKCD.toUpperCase())));
                vo.setKaisoCd(StringUtil.trim((String) result.get(TBRCMN_MEU00SIK.KAISOCD.toUpperCase())));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
