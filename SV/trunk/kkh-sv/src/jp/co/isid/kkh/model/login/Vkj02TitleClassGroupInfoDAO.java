package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.VWTITLECLASSGROUPINFO;
import jp.co.isid.kkh.integ.tbl.VWTITLECLASSMEMBER;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class Vkj02TitleClassGroupInfoDAO extends AbstractRdbDao {

    /** �E�ʓ����O���[�v��񌟍����� */
    private Vkj02TitleClassGroupInfoCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public Vkj02TitleClassGroupInfoDAO() {
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
        sql.append("  " + VWTITLECLASSMEMBER.GROUPCD + " ");
        sql.append(" FROM ");
        sql.append(" " + VWTITLECLASSGROUPINFO.TBNAME + ", " + VWTITLECLASSMEMBER.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + VWTITLECLASSGROUPINFO.GROUPCD + " = " + VWTITLECLASSMEMBER.GROUPCD);
        sql.append(" AND ");
        sql.append(" " + VWTITLECLASSGROUPINFO.STRTYMD + " <= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTITLECLASSGROUPINFO.STPYMD + " >= '" + _cond.getEigyoBi() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTITLECLASSMEMBER.ESQID + " = '" + _cond.getEsqId() + "' ");

        return sql.toString();
    }

    /**
     * �E�ʓ����O���[�v���̌������s���܂��B
     *
     * @return �E�ʓ����O���[�v���VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Vkj02TitleClassGroupInfoVO> getGroupInfo(Vkj02TitleClassGroupInfoCondition cond) throws KKHException {

        super.setModel(new Vkj02TitleClassGroupInfoVO());

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
     * @return List<Vkj02TitleClassGroupInfoVO> �ϊ���̌�������
     */
    @Override
    protected List<Vkj02TitleClassGroupInfoVO> createFindedModelInstances(List hashList) {

        List<Vkj02TitleClassGroupInfoVO> list = new ArrayList<Vkj02TitleClassGroupInfoVO>();
        if (getModel() instanceof Vkj02TitleClassGroupInfoVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                Vkj02TitleClassGroupInfoVO vo = new Vkj02TitleClassGroupInfoVO();
                vo.setGroupCd(StringUtil.trim((String) result.get(VWTITLECLASSMEMBER.GROUPCD.toUpperCase())));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
