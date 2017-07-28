package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;

/**
 *
 * <P>
 * �L����׌���(�A�T�q)DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class GetFDSeqDAO extends AbstractRdbDao {

    /**�󒍃f�[�^�������� */
    private GetFDSeqCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{FDSEQ,};
    private SqlMode _sqlMode = SqlMode.FDSEQ;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public GetFDSeqDAO() {
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
        return "";
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

        StringBuffer sql = new StringBuffer();

        if (_sqlMode.equals(SqlMode.FDSEQ)){
            sql.append(" SELECT ");
            sql.append("     NVL(REPLACE(MAX(RTRIM(" + TBTHB2KMEI.SONOTA9 +")),0),0) AS " + TBTHB2KMEI.SONOTA9 + " ");        //FD����SEQ
            sql.append(" FROM ");
            sql.append("     " + TBTHB2KMEI.TBNAME + " ");   //�L����׃e�[�u��
            sql.append("    ," + TBTHB1DOWN.TBNAME + " ");   //�_�E�����[�h�e�[�u��
            sql.append(" WHERE ");
            sql.append("     " + TBTHB1DOWN.EGCD        + " = '" + _cond.getEgCd() + "'");    //�c�Ə��R�[�h
            sql.append(" and " + TBTHB1DOWN.TKSKGYCD    + " = '" + _cond.getTksKgyCd() + "' ");          //���Ӑ�R�[�h
            sql.append(" and " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");     //���Ӑ敔��SEQNO
            sql.append(" and " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");     //���Ӑ�S��SEQNO
            sql.append(" and " + TBTHB1DOWN.YYMM        + " = '" + _cond.getYymm() + "'");             //�N��
            sql.append(" and " + TBTHB1DOWN.TJYUTNO     + " = ' '");
            sql.append(" and " + TBTHB2KMEI.EGCD        + " = " + TBTHB1DOWN.EGCD + " ");       //�c�Ə�
            sql.append(" and " + TBTHB2KMEI.TKSKGYCD    + " = " + TBTHB1DOWN.TKSKGYCD + " ");   //���Ӑ�R�[�h
            sql.append(" and " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " ");//���Ӑ敔��SEQNO
            sql.append(" and " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " ");//���Ӑ�S��SEQNO
            sql.append(" and " + TBTHB2KMEI.YYMM        + " = " + TBTHB1DOWN.YYMM + " ");       //�N��
            sql.append(" and " + TBTHB2KMEI.JYUTNO      + " = " + TBTHB1DOWN.JYUTNO + " ");     //��No
            sql.append(" and " + TBTHB2KMEI.JYMEINO     + " = " + TBTHB1DOWN.JYMEINO + " ");    //�󒍖���No
            sql.append(" and " + TBTHB2KMEI.URMEINO     + " = " + TBTHB1DOWN.URMEINO + " ");    //���㖾��No
            sql.append(" and " + TBTHB2KMEI.JYUTNO      + " <> ' '");
            sql.append(" and " + TBTHB2KMEI.NAME3       + " like '" + _cond.getUrMeiNo() + "%' ");  //���㖾��No�i2008040001-001�j
        }

        return sql.toString();
    }

    /**
     * �L����׃f�[�^�̌������s���܂��B
     *
     * @return �L����׃f�[�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<String> getFDSeq(GetFDSeqCondition cond) throws KKHException {

        super.setModel(new GetFDSeqVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.FDSEQ;
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
     * @return List<DetailDataVO> �ϊ���̌�������
     */
    @Override
    @SuppressWarnings("unchecked")
    //protected List<DetailDataVO> createFindedModelInstances(List hashList) {
    protected List createFindedModelInstances(List hashList) {
        List list = null;
        if (_sqlMode == SqlMode.FDSEQ){
            list = new ArrayList<String>();
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                list.add((String)result.get(TBTHB2KMEI.SONOTA9));
            }
        }

        return list;
    }

}
