package jp.co.isid.kkh.customer.tkd.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * �g�p�ώ��{No�̌����擾DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/13 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindJissiNoCntByCondDAO extends AbstractRdbDao {

    /** �f�[�^�������� */
    private FindJissiNoCntCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindJissiNoCntByCondDAO() {
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
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[] { TBTHB2KMEI.KNGK1 };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForJissiNoCnt();
    }

    /**
     * �g�p�ώ��{No�̌����擾��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    private String getSelectSQLForJissiNoCnt() {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("     COUNT(*) AS " + TBTHB2KMEI.KNGK1);
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' ");
        sql.append(" AND ");
        sql.append(" ( ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " <> '" + _cond.getJyutNo() + "' ");
        sql.append(" OR ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " <> '" + _cond.getJyMeiNo() + "' ");
        sql.append(" OR ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " <> '" + _cond.getUrMeiNo() + "' ");
        sql.append(" ) ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.KNGK1 + " IN (" + _cond.getJissiNo() + ") ");

        return sql.toString();
    }

    /**
     * �g�p�ώ��{No�̌����̌������s���܂��B
     *
     * @return �g�p�ώ��{No�̌������܂�VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindJissiNoCntCondVO> findJissiNoCntByCondition(FindJissiNoCntCondition cond)
            throws KKHException {

        super.setModel(new FindJissiNoCntCondVO());

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
     * @return List<FindJissiNoCntCondVO> �ϊ���̌�������
     */
    @Override
    protected List<FindJissiNoCntCondVO> createFindedModelInstances(List hashList) {

        List<FindJissiNoCntCondVO> list = new ArrayList<FindJissiNoCntCondVO>();

        if (getModel() instanceof FindJissiNoCntCondVO) {

            for (int i = 0; i < hashList.size(); i++) {

                Map result = (Map) hashList.get(i);
                FindJissiNoCntCondVO vo = new FindJissiNoCntCondVO();

                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
