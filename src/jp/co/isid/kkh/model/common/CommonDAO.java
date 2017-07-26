package jp.co.isid.kkh.model.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHBBSYS;
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
 * �E�V�K�쐬(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class CommonDAO extends AbstractRdbDao {

    /**�ėp�}�X�^�������� */
    private CommonCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public CommonDAO() {
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
        return TBTHBBSYS.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHBBSYS.TRKTIMSTMP
                ,TBTHBBSYS.TRKPL
                ,TBTHBBSYS.TRKTNT
                ,TBTHBBSYS.UPDTIMSTMP
                ,TBTHBBSYS.UPDAPL
                ,TBTHBBSYS.UPDTNT
                ,TBTHBBSYS.EGCD
                ,TBTHBBSYS.TKSKGYCD
                ,TBTHBBSYS.TKSBMNSEQNO
                ,TBTHBBSYS.TKSTNTSEQNO
                ,TBTHBBSYS.SYBT
                ,TBTHBBSYS.FIELD1
                ,TBTHBBSYS.FIELD2
                ,TBTHBBSYS.FIELD3
                ,TBTHBBSYS.FIELD4
                ,TBTHBBSYS.FIELD5
                ,TBTHBBSYS.FIELD6
                ,TBTHBBSYS.FIELD7
                ,TBTHBBSYS.FIELD8
                ,TBTHBBSYS.FIELD9
                ,TBTHBBSYS.FIELD10
        };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
            return getSelectSQLForCommon();
    }


    private String getSelectSQLForCommon(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBBSYS.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHBBSYS.TRKPL + " ");
        sql.append(" ," + TBTHBBSYS.TRKTNT + " ");
        sql.append(" ," + TBTHBBSYS.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHBBSYS.UPDAPL + " ");
        sql.append(" ," + TBTHBBSYS.UPDTNT + " ");
        sql.append(" ," + TBTHBBSYS.EGCD + " ");
        sql.append(" ," + TBTHBBSYS.TKSKGYCD + " ");
        sql.append(" ," + TBTHBBSYS.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHBBSYS.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHBBSYS.SYBT + " ");
        sql.append(" ," + TBTHBBSYS.FIELD1 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD2 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD3 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD4 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD5 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD6 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD7 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD8 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD9 + " ");
        sql.append(" ," + TBTHBBSYS.FIELD10 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBBSYS.TBNAME + " ");

        //Where��
        sql.append(" WHERE ");
        sql.append(" " + TBTHBBSYS.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBBSYS.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBBSYS.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBBSYS.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBBSYS.SYBT + " = '" + _cond.getSybt() + "' ");

        //�}�X�^�L�[
        if (_cond.getfield1() != null && !_cond.getfield1().equals("")){
            sql.append(" AND ");
            sql.append(" " + TBTHBBSYS.FIELD1 + " = '" + _cond.getfield1() + "' ");
        }

        return sql.toString();
    }

    /**
     * �ėp�e�[�u���}�X�^�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<CommonVO> findCommonByCondition(CommonCondition cond) throws KKHException {

        super.setModel(new CommonVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "KV-E0001");
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
    protected List<CommonVO> createFindedModelInstances(List hashList) {
        List<CommonVO> list = new ArrayList<CommonVO>();
        if (getModel() instanceof CommonVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                CommonVO vo = new CommonVO();
                vo.setTrkTimStmp((Date)result.get(TBTHBBSYS.TRKTIMSTMP.toUpperCase()));
                vo.setTrkPl((String)result.get(TBTHBBSYS.TRKPL.toUpperCase()));
                vo.setTrkTnt((String)result.get(TBTHBBSYS.TRKTNT.toUpperCase()));
                vo.setUpdTimStmp((Date)result.get(TBTHBBSYS.UPDTIMSTMP.toUpperCase()));
                vo.setUpdaPl((String)result.get(TBTHBBSYS.UPDAPL.toUpperCase()));
                vo.setUpdTnt((String)result.get(TBTHBBSYS.UPDTNT   .toUpperCase()));
                vo.setEgCd((String)result.get(TBTHBBSYS.EGCD.toUpperCase()));
                vo.setTksKgyCd((String)result.get(TBTHBBSYS.TKSKGYCD.toUpperCase()));
                vo.setTksBmnSeqNo((String)result.get(TBTHBBSYS.TKSBMNSEQNO.toUpperCase()));
                vo.setTksTntSeqNo((String)result.get(TBTHBBSYS.TKSTNTSEQNO.toUpperCase()));
                vo.setSybt((String)result.get(TBTHBBSYS.SYBT.toUpperCase()));
                vo.setField1((String)result.get(TBTHBBSYS.FIELD1.toUpperCase()));
                vo.setField2((String)result.get(TBTHBBSYS.FIELD2.toUpperCase()));
                vo.setField3((String)result.get(TBTHBBSYS.FIELD3.toUpperCase()));
                vo.setField4((String)result.get(TBTHBBSYS.FIELD4.toUpperCase()));
                vo.setField5((String)result.get(TBTHBBSYS.FIELD5.toUpperCase()));
                vo.setField6((String)result.get(TBTHBBSYS.FIELD6.toUpperCase()));
                vo.setField7((String)result.get(TBTHBBSYS.FIELD7.toUpperCase()));
                vo.setField8((String)result.get(TBTHBBSYS.FIELD8.toUpperCase()));
                vo.setField9((String)result.get(TBTHBBSYS.FIELD9.toUpperCase()));
                vo.setField10((String)result.get(TBTHBBSYS.FIELD10.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
