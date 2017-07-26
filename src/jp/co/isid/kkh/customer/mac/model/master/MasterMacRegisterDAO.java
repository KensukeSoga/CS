package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �}�X�^�f�[�^�o�^DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 IP Shimizu)<BR>
 * </P>
 * @author IP Shimizu
 */
public class MasterMacRegisterDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^(�f�[�^)��������*/
    private MasterMacDataInsertVO _VO;
    private MasterCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{DEL,UPD,INS,DateUPD};
    private SqlMode _sqlMode = SqlMode.INS;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public MasterMacRegisterDAO() {
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
        return TBTHBAMST.TRKTIMSTMP;
    }

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHBAMST.TRKTIMSTMP,TBTHBAMST.UPDTIMSTMP };
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
     * �ėp�}�X�^(�f�[�^)�̓o�^
     *
     * @param vo �}�X�^�f�[�^VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void registMasterDataVO(MasterMacDataInsertVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0004");
        }
        super.setModel(vo);
        try {
        	_VO = vo;
        	if (vo.getField14().equals("�V�K"))
        	{
	            if (!super.insert()) {
	                throw new KKHException("�o�^�G���[", "BD-E0004");
	            	}
        	}
        	else if (vo.getField14().equals("�ύX"))
        	{
        		_sqlMode = SqlMode.UPD;
        		super.exec();
        	}
        	else if (vo.getField14().equals("�폜"))
        	{
        		_sqlMode = SqlMode.DEL;
        		super.exec();
        	}
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }
    }

    /**
    * �ėp�}�X�^(�f�[�^)�̈ꊇ�X�V�i���t�j
    *
    * @param cond �폜����
    * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
    */
   public boolean updateMasterMacDataByCondition(MasterCondition cond) throws KKHException {
       //�p�����[�^�`�F�b�N
       if (cond == null) {
           throw new KKHException("�X�V�G���[", "BD-E0003");
       }

       try {
    	   _sqlMode = SqlMode.DateUPD;
           _cond = cond;
           super.exec();
       } catch (UserException e) {
           throw new KKHException(e.getMessage(), "BD-E0003");
       }

       return true;
   }

    /**
     * �폜�r�p�k����
     */
    @Override
    public String getExecString()
    {
        StringBuffer sql = new StringBuffer();

    	if (_sqlMode == SqlMode.DEL)
    	{
	        sql.append(" DELETE ");
	        sql.append(" FROM ");
	        sql.append(" " + TBTHBAMST.TBNAME + " ");
	        // Where��
	        sql.append(" WHERE ");
	        sql.append(" " + TBTHBAMST.EGCD + " = '" + _VO.getEgCd() + "' ");
	        sql.append(" AND ");
	        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _VO.getTksKgyCd() + "' ");
	        sql.append(" AND ");
	        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _VO.getTksBmnSeqNo() + "' ");
	        sql.append(" AND ");
	        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _VO.getTksTntSeqNo() + "' ");
	        sql.append(" AND ");
	        sql.append(" " + TBTHBAMST.SYBT + " = '" + _VO.getSybt() + "' ");
	        sql.append(" AND ");
	        sql.append(" " + TBTHBAMST.FIELD1 + " = '" + _VO.getField1() + "' ");

    	}
    	else if (_sqlMode == SqlMode.UPD)
    	{
            sql.append(" UPDATE ");
            sql.append(" " + TBTHBAMST.TBNAME + " ");
	        sql.append(" SET ");
	        sql.append(" " + TBTHBAMST.FIELD1 + " = '" + _VO.getField1() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD2 + " = '" + _VO.getField2() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD3 + " = '" + _VO.getField3() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD4 + " = '" + _VO.getField4() + "', ");
	        //sql.append(" " + TBTHBAMST.FIELD5 + " = '" + _VO.getField5() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD20 + " = '" + _VO.getField20() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD6 + " = '" + _VO.getField6() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD7 + " = '" + _VO.getField7() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD8 + " = '" + _VO.getField8() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD9 + " = '" + _VO.getField9() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD10 + " = '" + _VO.getField10() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD11 + " = '" + _VO.getField11() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD12 + " = '" + _VO.getField12() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD13 + " = '" + _VO.getField13() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD14 + " = '" + _VO.getField14() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD15 + " = '" + _VO.getField15() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD16 + " = '" + _VO.getField16() + "', ");
	        sql.append(" " + TBTHBAMST.FIELD17 + " = '" + _VO.getField17() + "' ");
            // Where��
            sql.append(" WHERE ");
            sql.append(" " + TBTHBAMST.EGCD + " = '" + _VO.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _VO.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _VO.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _VO.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.SYBT + " = '" + _VO.getSybt() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.FIELD1 + " = '" + _VO.getField1() + "' ");

    	}
    	else if (_sqlMode == SqlMode.DateUPD)
    	{
            sql.append(" UPDATE ");
            sql.append(" " + TBTHBAMST.TBNAME + " ");
	        sql.append(" SET ");
	        sql.append(" " + TBTHBAMST.TRKTIMSTMP + " = SYSDATE, ");
	        sql.append(" " + TBTHBAMST.UPDTIMSTMP + " = SYSDATE  ");
            // Where��
            sql.append(" WHERE ");
            sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.SYBT + " = '" + _cond.getSybt() + "' ");
    	}

        return sql.toString();
    }



}