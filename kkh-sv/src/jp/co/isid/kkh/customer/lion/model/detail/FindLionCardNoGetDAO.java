package jp.co.isid.kkh.customer.lion.model.detail;

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

public class FindLionCardNoGetDAO extends AbstractRdbDao  {
       /**�e���r�ǃ}�X�^�������� */
    private FindLionCardNoGetCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindLionCardNoGetDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
    @Override
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
    @Override
    public String getTableName() {
        return TBTHB2KMEI.TBNAME;
    }


    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
    }
    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }



    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        //���׃f�[�^SQL
        sql.append(" SELECT ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " ");         //�}�̋敪
        sql.append(" ," + TBTHB2KMEI.CODE6 + " ");         //�J�[�h�m��
        sql.append(" ," + TBTHB2KMEI.TIMSTMP + " ");//YYYY/MM/DD HH24:MI:SS//) TIMSTMP  //�^�C���X�^���v
        sql.append(" " + "FROM" + " ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " ");//�L����׃e�[�u��
        sql.append(" " + "where" + " ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");          //�c�Ə�
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");//���Ӑ�BMN
        sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");//���Ӑ�TNT
        sql.append(TBTHB2KMEI.YYMM  + " = '" + _cond.getYm()  + "'  AND ");//�N��
        sql.append(TBTHB2KMEI.JYUTNO  + " = '" + _cond.getJyutno()  + "'  AND ");//�󒍂�O
        sql.append(TBTHB2KMEI.JYMEINO  + " = '" + _cond.getJymeino()  + "'  AND ");//�󒍖���
        sql.append(TBTHB2KMEI.URMEINO  + " = '" + _cond.getUrmeino()  + "'  ");//���㖾��


        return sql.toString();
    }


    /**
     * �J�[�hNO�̌������s���܂��B
     *
     * @return �J�[�hNO�AVO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindLionCardNoGetVO> findLionCardNoGetByCondition(FindLionCardNoGetCondition cond) throws KKHException {

        super.setModel(new FindLionCardNoGetVO());

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
     * @return List<CommonCodeMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<FindLionCardNoGetVO> createFindedModelInstances(List hashList) {
        List<FindLionCardNoGetVO> list = new ArrayList<FindLionCardNoGetVO>();
        if (getModel() instanceof FindLionCardNoGetVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindLionCardNoGetVO vo = new FindLionCardNoGetVO();
                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                vo.setCode6((String)result.get(TBTHB2KMEI.CODE6.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
