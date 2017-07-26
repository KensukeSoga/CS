package jp.co.isid.kkh.model.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * �ėp�}�X�^����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class CommonCodeMasterDAO extends AbstractRdbDao {

    /**�ėp�}�X�^�������� */
    private CommonCodeMasterCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode{COND,};
//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public CommonCodeMasterDAO() {
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
        //new String[] {};
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return TBRCMN_MEU29CC.TBNAME;
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
        String sql = "";

        sql = getSelectSQLForCond();

        return sql;
    }

    private String getSelectSQLForCond(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBRCMN_MEU29CC.MEU29_KYCDKND + " ");
        sql.append(" ," + TBRCMN_MEU29CC.MEU29_KYCD + " ");
        sql.append(" ," + TBRCMN_MEU29CC.MEU29_HKYMD + " ");
        sql.append(" ," + TBRCMN_MEU29CC.MEU29_HAISYMD + " ");
        sql.append(" ," + TBRCMN_MEU29CC.MEU29_NAIYKN + " ");
        sql.append(" ," + TBRCMN_MEU29CC.MEU29_NAIYJ + " ");
        sql.append(" ," + TBRCMN_MEU29CC.MEU29_YOBI1 + " ");
        sql.append(" ," + TBRCMN_MEU29CC.MEU29_HOSOK + " ");
        sql.append(" ," + TBRCMN_MEU29CC.MEU29_YOBI2 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBRCMN_MEU29CC.TBNAME + " ");
        //Where��
        sql.append(" WHERE ");
        sql.append(" " + TBRCMN_MEU29CC.MEU29_KYCDKND + " = '" + _cond.getKyCdKnd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU29CC.MEU29_HKYMD + " <= '" + _cond.getKijyunYmd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU29CC.MEU29_HAISYMD + " >= '" + _cond.getKijyunYmd() + "' ");
        sql.append(" ORDER BY ");
        sql.append(" " + TBRCMN_MEU29CC.MEU29_KYCD + " ");

        return sql.toString();
    }

    /**
     * �ėp�e�[�u���}�X�^�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<CommonCodeMasterVO> findCommonCodeMasterByCondition(CommonCodeMasterCondition cond) throws KKHException {

        super.setModel(new CommonCodeMasterVO());

        try {
            _cond = cond;
//        	_sqlMode = SqlMode.COND;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList List ��������
     * @return List<CommonCodeMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<CommonCodeMasterVO> createFindedModelInstances(List hashList) {
        List<CommonCodeMasterVO> list = new ArrayList<CommonCodeMasterVO>();
        if (getModel() instanceof CommonCodeMasterVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                CommonCodeMasterVO vo = new CommonCodeMasterVO();
                vo.setKYCDKND((String)result.get(TBRCMN_MEU29CC.MEU29_KYCDKND.toUpperCase()));
                vo.setKYCD((String)result.get(TBRCMN_MEU29CC.MEU29_KYCD.toUpperCase()));
                vo.setHKYMD((String)result.get(TBRCMN_MEU29CC.MEU29_HKYMD.toUpperCase()));
                vo.setHAISYMD((String)result.get(TBRCMN_MEU29CC.MEU29_HAISYMD.toUpperCase()));
                vo.setNAIYKN((String)result.get(TBRCMN_MEU29CC.MEU29_NAIYKN.toUpperCase()));
                vo.setNAIYJ((String)result.get(TBRCMN_MEU29CC.MEU29_NAIYJ.toUpperCase()));
                vo.setYOBI1((String)result.get(TBRCMN_MEU29CC.MEU29_YOBI1.toUpperCase()));
                vo.setHOSOK((String)result.get(TBRCMN_MEU29CC.MEU29_HOSOK.toUpperCase()));
                vo.setYOBI2((String)result.get(TBRCMN_MEU29CC.MEU29_YOBI2.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
