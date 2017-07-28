package jp.co.isid.kkh.model.master;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
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
public class MasterDAO extends AbstractRdbDao {

    /**�ėp�}�X�^�������� */
    private MasterCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{KIND,ITEM,};
    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public MasterDAO() {
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
        return TBTHBAMST.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHBAMST.TRKTIMSTMP
                ,TBTHBAMST.TRKPL
                ,TBTHBAMST.TRKTNT
                ,TBTHBAMST.UPDTIMSTMP
                ,TBTHBAMST.UPDAPL
                ,TBTHBAMST.UPDTNT
                ,TBTHBAMST.EGCD
                ,TBTHBAMST.TKSKGYCD
                ,TBTHBAMST.TKSBMNSEQNO
                ,TBTHBAMST.TKSTNTSEQNO
                ,TBTHBAMST.SYBT
                ,TBTHBAMST.FIELD1
                ,TBTHBAMST.FIELD2
                ,TBTHBAMST.FIELD3
                ,TBTHBAMST.FIELD4
                ,TBTHBAMST.FIELD5
                ,TBTHBAMST.FIELD6
                ,TBTHBAMST.FIELD7
                ,TBTHBAMST.FIELD8
                ,TBTHBAMST.FIELD9
                ,TBTHBAMST.FIELD10
                ,TBTHBAMST.FIELD11
                ,TBTHBAMST.FIELD12
                ,TBTHBAMST.FIELD13
                ,TBTHBAMST.FIELD14
                ,TBTHBAMST.FIELD15
                ,TBTHBAMST.FIELD16
                ,TBTHBAMST.FIELD17
                ,TBTHBAMST.FIELD18
                ,TBTHBAMST.FIELD19
                ,TBTHBAMST.FIELD20
                ,TBTHBAMST.INTVALUE1
                ,TBTHBAMST.INTVALUE2
                ,TBTHBAMST.INTVALUE3
                ,TBTHBAMST.INTVALUE4
                ,TBTHBAMST.INTVALUE5
                ,TBTHBAMST.INTVALUE6
                ,TBTHBAMST.INTVALUE7
                ,TBTHBAMST.INTVALUE8
                ,TBTHBAMST.INTVALUE9
                ,TBTHBAMST.INTVALUE10
        };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        if (_sqlMode.equals(SqlMode.KIND)){
            return getSelectSQLForKind();
        }else if (_sqlMode.equals(SqlMode.ITEM)){

            if(_cond.get_Itemfiltervalue() != null && !_cond.get_Itemfiltervalue().equals(""))
            {
                return getSelectSqlForMeleryItem();
            }
            else
            {
                return getSelectSQLForItem();
            }
        }

        return "";
    }

    private String getSelectSQLForKind(){
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBAMST.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHBAMST.TRKPL + " ");
        sql.append(" ," + TBTHBAMST.TRKTNT + " ");
        sql.append(" ," + TBTHBAMST.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHBAMST.UPDAPL + " ");
        sql.append(" ," + TBTHBAMST.UPDTNT + " ");
        sql.append(" ," + TBTHBAMST.EGCD + " ");
        sql.append(" ," + TBTHBAMST.TKSKGYCD + " ");
        sql.append(" ," + TBTHBAMST.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHBAMST.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHBAMST.SYBT + " ");
        sql.append(" ," + TBTHBAMST.FIELD1 + " ");
        sql.append(" ," + TBTHBAMST.FIELD2 + " ");
        sql.append(" ," + TBTHBAMST.FIELD3 + " ");
        sql.append(" ," + TBTHBAMST.FIELD4 + " ");
        sql.append(" ," + TBTHBAMST.FIELD5 + " ");
        sql.append(" ," + TBTHBAMST.FIELD6 + " ");
        sql.append(" ," + TBTHBAMST.FIELD7 + " ");
        sql.append(" ," + TBTHBAMST.FIELD8 + " ");
        sql.append(" ," + TBTHBAMST.FIELD9 + " ");
        sql.append(" ," + TBTHBAMST.FIELD10 + " ");
        sql.append(" ," + TBTHBAMST.FIELD11 + " ");
        sql.append(" ," + TBTHBAMST.FIELD12 + " ");
        sql.append(" ," + TBTHBAMST.FIELD13 + " ");
        sql.append(" ," + TBTHBAMST.FIELD14 + " ");
        sql.append(" ," + TBTHBAMST.FIELD15 + " ");
        sql.append(" ," + TBTHBAMST.FIELD16 + " ");
        sql.append(" ," + TBTHBAMST.FIELD17 + " ");
        sql.append(" ," + TBTHBAMST.FIELD18 + " ");
        sql.append(" ," + TBTHBAMST.FIELD19 + " ");
        sql.append(" ," + TBTHBAMST.FIELD20 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE1 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE2 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE3 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE4 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE5 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE6 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE7 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE8 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE9 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE10 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        //Where��
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '001' ");
        //�}�X�^�L�[
        if (_cond.getMasterKey() != null && !_cond.getMasterKey().equals("")){
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.FIELD3 + " = '" + _cond.getMasterKey() + "' ");
        }
//        //Groupby��
        sql.append(" GROUP BY ");
        sql.append("  " + TBTHBAMST.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHBAMST.TRKPL + " ");
        sql.append(" ," + TBTHBAMST.TRKTNT + " ");
        sql.append(" ," + TBTHBAMST.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHBAMST.UPDAPL + " ");
        sql.append(" ," + TBTHBAMST.UPDTNT + " ");
        sql.append(" ," + TBTHBAMST.EGCD + " ");
        sql.append(" ," + TBTHBAMST.TKSKGYCD + " ");
        sql.append(" ," + TBTHBAMST.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHBAMST.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHBAMST.SYBT + " ");
        sql.append(" ," + TBTHBAMST.FIELD1 + " ");
        sql.append(" ," + TBTHBAMST.FIELD2 + " ");
        sql.append(" ," + TBTHBAMST.FIELD3 + " ");
        sql.append(" ," + TBTHBAMST.FIELD4 + " ");
        sql.append(" ," + TBTHBAMST.FIELD5 + " ");
        sql.append(" ," + TBTHBAMST.FIELD6 + " ");
        sql.append(" ," + TBTHBAMST.FIELD7 + " ");
        sql.append(" ," + TBTHBAMST.FIELD8 + " ");
        sql.append(" ," + TBTHBAMST.FIELD9 + " ");
        sql.append(" ," + TBTHBAMST.FIELD10 + " ");
        sql.append(" ," + TBTHBAMST.FIELD11 + " ");
        sql.append(" ," + TBTHBAMST.FIELD12 + " ");
        sql.append(" ," + TBTHBAMST.FIELD13 + " ");
        sql.append(" ," + TBTHBAMST.FIELD14 + " ");
        sql.append(" ," + TBTHBAMST.FIELD15 + " ");
        sql.append(" ," + TBTHBAMST.FIELD16 + " ");
        sql.append(" ," + TBTHBAMST.FIELD17 + " ");
        sql.append(" ," + TBTHBAMST.FIELD18 + " ");
        sql.append(" ," + TBTHBAMST.FIELD19 + " ");
        sql.append(" ," + TBTHBAMST.FIELD20 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE1 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE2 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE3 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE4 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE5 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE6 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE7 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE8 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE9 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE10 + " ");
        //Order��
        sql.append(" ORDER BY ");
        sql.append(" " + TBTHBAMST.FIELD3 + " ");

        return sql.toString();
    }

    private String getSelectSqlForMeleryItem()
    {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBAMST.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHBAMST.TRKPL + " ");
        sql.append(" ," + TBTHBAMST.TRKTNT + " ");
        sql.append(" ," + TBTHBAMST.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHBAMST.UPDAPL + " ");
        sql.append(" ," + TBTHBAMST.UPDTNT + " ");
        sql.append(" ," + TBTHBAMST.EGCD + " ");
        sql.append(" ," + TBTHBAMST.TKSKGYCD + " ");
        sql.append(" ," + TBTHBAMST.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHBAMST.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHBAMST.SYBT + " ");
        sql.append(" ," + TBTHBAMST.FIELD1 + " ");
        sql.append(" ," + TBTHBAMST.FIELD2 + " ");
        sql.append(" ," + TBTHBAMST.FIELD3 + " ");
        sql.append(" ," + TBTHBAMST.FIELD4 + " ");
        sql.append(" ," + TBTHBAMST.FIELD5 + " ");
        sql.append(" ," + TBTHBAMST.FIELD6 + " ");
        sql.append(" ," + TBTHBAMST.FIELD7 + " ");
        sql.append(" ," + TBTHBAMST.FIELD8 + " ");
        sql.append(" ," + TBTHBAMST.FIELD9 + " ");
        sql.append(" ," + TBTHBAMST.FIELD10 + " ");
        sql.append(" ," + TBTHBAMST.FIELD11 + " ");
        sql.append(" ," + TBTHBAMST.FIELD12 + " ");
        sql.append(" ," + TBTHBAMST.FIELD13 + " ");
        sql.append(" ," + TBTHBAMST.FIELD14 + " ");
        sql.append(" ," + TBTHBAMST.FIELD15 + " ");
        sql.append(" ," + TBTHBAMST.FIELD16 + " ");
        sql.append(" ," + TBTHBAMST.FIELD17 + " ");
        sql.append(" ," + TBTHBAMST.FIELD18 + " ");
        sql.append(" ," + TBTHBAMST.FIELD19 + " ");
        sql.append(" ," + TBTHBAMST.FIELD20 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE1 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE2 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE3 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE4 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE5 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE6 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE7 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE8 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE9 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE10 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");

        //Where��
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '002' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.FIELD1 + " = '" + _cond.get_Itemfiltervalue() + "' ");

        //Order��
        sql.append(" ORDER BY ");
        sql.append(" cast(" + TBTHBAMST.FIELD2 + " as NUMBER(5)) ");//��

        return sql.toString();
    }

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBAMST.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHBAMST.TRKPL + " ");
        sql.append(" ," + TBTHBAMST.TRKTNT + " ");
        sql.append(" ," + TBTHBAMST.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHBAMST.UPDAPL + " ");
        sql.append(" ," + TBTHBAMST.UPDTNT + " ");
        sql.append(" ," + TBTHBAMST.EGCD + " ");
        sql.append(" ," + TBTHBAMST.TKSKGYCD + " ");
        sql.append(" ," + TBTHBAMST.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHBAMST.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHBAMST.SYBT + " ");
        sql.append(" ," + TBTHBAMST.FIELD1 + " ");
        sql.append(" ," + TBTHBAMST.FIELD2 + " ");
        sql.append(" ," + TBTHBAMST.FIELD3 + " ");
        sql.append(" ," + TBTHBAMST.FIELD4 + " ");
        sql.append(" ," + TBTHBAMST.FIELD5 + " ");
        sql.append(" ," + TBTHBAMST.FIELD6 + " ");
        sql.append(" ," + TBTHBAMST.FIELD7 + " ");
        sql.append(" ," + TBTHBAMST.FIELD8 + " ");
        sql.append(" ," + TBTHBAMST.FIELD9 + " ");
        sql.append(" ," + TBTHBAMST.FIELD10 + " ");
        sql.append(" ," + TBTHBAMST.FIELD11 + " ");
        sql.append(" ," + TBTHBAMST.FIELD12 + " ");
        sql.append(" ," + TBTHBAMST.FIELD13 + " ");
        sql.append(" ," + TBTHBAMST.FIELD14 + " ");
        sql.append(" ," + TBTHBAMST.FIELD15 + " ");
        sql.append(" ," + TBTHBAMST.FIELD16 + " ");
        sql.append(" ," + TBTHBAMST.FIELD17 + " ");
        sql.append(" ," + TBTHBAMST.FIELD18 + " ");
        sql.append(" ," + TBTHBAMST.FIELD19 + " ");
        sql.append(" ," + TBTHBAMST.FIELD20 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE1 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE2 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE3 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE4 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE5 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE6 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE7 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE8 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE9 + " ");
        sql.append(" ," + TBTHBAMST.INTVALUE10 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");

        //Where��
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '002' ");
        //�}�X�^�L�[
        if (_cond.getMasterKey() != null && !_cond.getMasterKey().equals("")){
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.FIELD1 + " = '" + _cond.getMasterKey() + "' ");
        }

        //Order��
        sql.append(" ORDER BY ");
        sql.append(" cast(" + TBTHBAMST.FIELD2 + " as NUMBER(5)) ");//��

        return sql.toString();
    }

    /**
     * �ėp�e�[�u���}�X�^�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<MasterVO> findMasterKindByCondition(MasterCondition cond) throws KKHException {

        super.setModel(new MasterVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.KIND;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �ėp�e�[�u���}�X�^�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<MasterVO> findMasterItemByCondition(MasterCondition cond) throws KKHException {

        super.setModel(new MasterVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.ITEM;
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
    protected List<MasterVO> createFindedModelInstances(List hashList) {
        List<MasterVO> list = new ArrayList<MasterVO>();
        if (getModel() instanceof MasterVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                MasterVO vo = new MasterVO();
                vo.setTrkTimStmp((Date)result.get(TBTHBAMST.TRKTIMSTMP.toUpperCase()));
                vo.setTrkPl((String)result.get(TBTHBAMST.TRKPL.toUpperCase()));
                vo.setTrkTnt((String)result.get(TBTHBAMST.TRKTNT.toUpperCase()));
                vo.setUpdTimStmp((Date)result.get(TBTHBAMST.UPDTIMSTMP.toUpperCase()));
                vo.setUpdaPl((String)result.get(TBTHBAMST.UPDAPL.toUpperCase()));
                vo.setUpdTnt((String)result.get(TBTHBAMST.UPDTNT   .toUpperCase()));
                vo.setEgCd((String)result.get(TBTHBAMST.EGCD.toUpperCase()));
                vo.setTksKgyCd((String)result.get(TBTHBAMST.TKSKGYCD.toUpperCase()));
                vo.setTksBmnSeqNo((String)result.get(TBTHBAMST.TKSBMNSEQNO.toUpperCase()));
                vo.setTksTntSeqNo((String)result.get(TBTHBAMST.TKSTNTSEQNO.toUpperCase()));
                vo.setSybt((String)result.get(TBTHBAMST.SYBT.toUpperCase()));
                vo.setField1((String)result.get(TBTHBAMST.FIELD1.toUpperCase()));
                vo.setField2((String)result.get(TBTHBAMST.FIELD2.toUpperCase()));
                vo.setField3((String)result.get(TBTHBAMST.FIELD3.toUpperCase()));
                vo.setField4((String)result.get(TBTHBAMST.FIELD4.toUpperCase()));
                vo.setField5((String)result.get(TBTHBAMST.FIELD5.toUpperCase()));
                vo.setField6((String)result.get(TBTHBAMST.FIELD6.toUpperCase()));
                vo.setField7((String)result.get(TBTHBAMST.FIELD7.toUpperCase()));
                vo.setField8((String)result.get(TBTHBAMST.FIELD8.toUpperCase()));
                vo.setField9((String)result.get(TBTHBAMST.FIELD9.toUpperCase()));
                vo.setField10((String)result.get(TBTHBAMST.FIELD10.toUpperCase()));
                vo.setField11((String)result.get(TBTHBAMST.FIELD11.toUpperCase()));
                vo.setField12((String)result.get(TBTHBAMST.FIELD12.toUpperCase()));
                vo.setField13((String)result.get(TBTHBAMST.FIELD13.toUpperCase()));
                vo.setField14((String)result.get(TBTHBAMST.FIELD14.toUpperCase()));
                vo.setField15((String)result.get(TBTHBAMST.FIELD15.toUpperCase()));
                vo.setField16((String)result.get(TBTHBAMST.FIELD16.toUpperCase()));
                vo.setField17((String)result.get(TBTHBAMST.FIELD17.toUpperCase()));
                vo.setField18((String)result.get(TBTHBAMST.FIELD18.toUpperCase()));
                vo.setField19((String)result.get(TBTHBAMST.FIELD19.toUpperCase()));
                vo.setField20((String)result.get(TBTHBAMST.FIELD20.toUpperCase()));
                vo.setIntValue1((BigDecimal)result.get(TBTHBAMST.INTVALUE1.toUpperCase()));
                vo.setIntValue2((BigDecimal)result.get(TBTHBAMST.INTVALUE2.toUpperCase()));
                vo.setIntValue3((BigDecimal)result.get(TBTHBAMST.INTVALUE3.toUpperCase()));
                vo.setIntValue4((BigDecimal)result.get(TBTHBAMST.INTVALUE4.toUpperCase()));
                vo.setIntValue5((BigDecimal)result.get(TBTHBAMST.INTVALUE5.toUpperCase()));
                vo.setIntValue6((BigDecimal)result.get(TBTHBAMST.INTVALUE6.toUpperCase()));
                vo.setIntValue7((BigDecimal)result.get(TBTHBAMST.INTVALUE7.toUpperCase()));
                vo.setIntValue8((BigDecimal)result.get(TBTHBAMST.INTVALUE8.toUpperCase()));
                vo.setIntValue9((BigDecimal)result.get(TBTHBAMST.INTVALUE9.toUpperCase()));
                vo.setIntValue10((BigDecimal)result.get(TBTHBAMST.INTVALUE10.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
