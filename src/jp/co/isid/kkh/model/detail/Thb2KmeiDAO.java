package jp.co.isid.kkh.model.detail;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.constants.KKHConstants;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

public class Thb2KmeiDAO extends AbstractSimpleRdbDao {

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public Thb2KmeiDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
        //super.setUseTimeStamp(true);
    }

    private Thb2KmeiVO _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SelSqlMode{LOAD, LOCK, COND_CMN, EPSON_LOCK, EPSON_SK_LOCK ,SCOND_CMN};
    private SelSqlMode _selSqlMode = SelSqlMode.LOCK;

    /** getExecSQL�Ŕ��s����SQL�̃��[�h() */
    private enum ExecSqlMode{INS, UPD, DEL, DEL_COND,};
    private ExecSqlMode _execSqlMode = ExecSqlMode.DEL_COND;

    /** getExecSQL�Ŏg�p��������pVO */
    private Thb2KmeiVO _condVO;

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
	@Override
	public String[] getPrimryKeyNames() {
		return new String[]{
				TBTHB2KMEI.EGCD,
				TBTHB2KMEI.TKSKGYCD,
				TBTHB2KMEI.TKSBMNSEQNO,
				TBTHB2KMEI.TKSTNTSEQNO,
				TBTHB2KMEI.YYMM,
				TBTHB2KMEI.JYUTNO,
				TBTHB2KMEI.JYMEINO,
				TBTHB2KMEI.URMEINO,
				TBTHB2KMEI.RENBN
		};
	}

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
	@Override
	public String[] getTableColumnNames() {
		return new String[]{
				TBTHB2KMEI.TIMSTMP,
				TBTHB2KMEI.UPDAPL,
				TBTHB2KMEI.UPDTNT,
				TBTHB2KMEI.EGCD,
				TBTHB2KMEI.TKSKGYCD,
				TBTHB2KMEI.TKSBMNSEQNO,
				TBTHB2KMEI.TKSTNTSEQNO,
				TBTHB2KMEI.YYMM,
				TBTHB2KMEI.JYUTNO,
				TBTHB2KMEI.JYMEINO,
				TBTHB2KMEI.URMEINO,
				TBTHB2KMEI.HIMKCD,
				TBTHB2KMEI.RENBN,
				TBTHB2KMEI.DATEFROM,
				TBTHB2KMEI.DATETO,
				TBTHB2KMEI.SEIGAK,
				TBTHB2KMEI.HNNERT,
				TBTHB2KMEI.HNMAEGAK,
				TBTHB2KMEI.NEBIGAK,
				TBTHB2KMEI.DATE1,
				TBTHB2KMEI.DATE2,
				TBTHB2KMEI.DATE3,
				TBTHB2KMEI.DATE4,
				TBTHB2KMEI.DATE5,
				TBTHB2KMEI.DATE6,
				TBTHB2KMEI.KBN1,
				TBTHB2KMEI.KBN2,
				TBTHB2KMEI.KBN3,
				TBTHB2KMEI.CODE1,
				TBTHB2KMEI.CODE2,
				TBTHB2KMEI.CODE3,
				TBTHB2KMEI.CODE4,
				TBTHB2KMEI.CODE5,
				TBTHB2KMEI.CODE6,
				TBTHB2KMEI.NAME1,
				TBTHB2KMEI.NAME2,
				TBTHB2KMEI.NAME3,
				TBTHB2KMEI.NAME4,
				TBTHB2KMEI.NAME5,
				TBTHB2KMEI.NAME6,
				TBTHB2KMEI.NAME7,
				TBTHB2KMEI.NAME8,
				TBTHB2KMEI.NAME9,
				TBTHB2KMEI.NAME10,
				TBTHB2KMEI.NAME11,
				TBTHB2KMEI.NAME12,
				TBTHB2KMEI.NAME13,
				TBTHB2KMEI.NAME14,
				TBTHB2KMEI.NAME15,
				TBTHB2KMEI.NAME16,
				TBTHB2KMEI.NAME17,
				TBTHB2KMEI.NAME18,
				TBTHB2KMEI.NAME19,
				TBTHB2KMEI.NAME20,
				TBTHB2KMEI.NAME21,
				TBTHB2KMEI.NAME22,
				TBTHB2KMEI.NAME23,
				TBTHB2KMEI.NAME24,
				TBTHB2KMEI.NAME25,
				TBTHB2KMEI.NAME26,
				TBTHB2KMEI.NAME27,
				TBTHB2KMEI.NAME28,
				TBTHB2KMEI.NAME29,
				TBTHB2KMEI.NAME30,
				TBTHB2KMEI.KNGK1,
				TBTHB2KMEI.KNGK2,
				TBTHB2KMEI.KNGK3,
				TBTHB2KMEI.RITU1,
				TBTHB2KMEI.RITU2,
				TBTHB2KMEI.SONOTA1,
				TBTHB2KMEI.SONOTA2,
				TBTHB2KMEI.SONOTA3,
				TBTHB2KMEI.SONOTA4,
				TBTHB2KMEI.SONOTA5,
				TBTHB2KMEI.SONOTA6,
				TBTHB2KMEI.SONOTA7,
				TBTHB2KMEI.SONOTA8,
				TBTHB2KMEI.SONOTA9,
				TBTHB2KMEI.SONOTA10,
				TBTHB2KMEI.BUNFLG,
				TBTHB2KMEI.MEIHNFLG,
				TBTHB2KMEI.NEBHNFLG
		};
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
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
	@Override
	public String getTimeStampKeyName() {
		return TBTHB2KMEI.TIMSTMP;
	}

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB2KMEI.TIMSTMP};
    }

    /**
     * �L����׃e�[�u����PK�������s���܂��B
     * @param vo
     * @return
     * @throws KKHException
     */
    public Thb2KmeiVO loadThb2Kmei(Thb2KmeiVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�����G���[", "BD-E0001");
        }
        super.setModel(vo);
        try {
        	_selSqlMode = SelSqlMode.LOAD;
            return (Thb2KmeiVO)super.load();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * �L����׃e�[�u���̓o�^
     *
     * @param vo �L����׃e�[�u��VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void insertThb2Kmei(Thb2KmeiVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        super.setModel(vo);
        try {
        	_execSqlMode = ExecSqlMode.INS;
            if (!super.insert()) {
                throw new KKHException("�o�^�G���[", "BD-E0002");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �L����׃e�[�u���̍X�V
     *
     * @param vo �L����׃e�[�u��VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateThb2Kmei(Thb2KmeiVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_execSqlMode = ExecSqlMode.UPD;
            if (!super.update()) {
                throw new KKHException("�X�V�G���[", "BD-E0003");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * �L����׃e�[�u���̍폜���s���܂��B
     *
     * @param vo �L����׃e�[�u��VO
     * @return boolean true�F�폜��������
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public boolean deleteThb2Kmei(Thb2KmeiVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�폜�G���[", "BD-E0004");
        }

        super.setModel(vo);

        try {
        	_execSqlMode = ExecSqlMode.DEL;
            if (!super.remove()) {
                throw new KKHException("�폜�G���[", "BD-E0004");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }

        return true;
    }



    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        if (_selSqlMode.equals(SelSqlMode.LOCK)){
            return getSelectSQLForLock();
        }else if (_selSqlMode.equals(SelSqlMode.EPSON_LOCK)){
            return getSelectSQLForEpsonLock();
        }else if (_selSqlMode.equals(SelSqlMode.EPSON_SK_LOCK)){
            return getSelectSQLForEpsonSKLock();
        }else if (_selSqlMode.equals(SelSqlMode.COND_CMN)){
        	return getSelectSQLForCondCmn();
        }else if(_selSqlMode.equals(SelSqlMode.SCOND_CMN)){
        	return getSpySelectSQLForCondCmn();
        }
        else {
        	return getSelectSQLForALL();
        }
    }

    /**
     * �f�t�H���gSQL��Ԃ��܂��B
     * @return
     */
    private String getSelectSQLForALL(){

    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	//PK���ڂ��擾
    	for (int i = 0; i < getTableColumnNames().length; i++){
    		if (i == 0){
    			sql.append("  " + getTableColumnNames()[i] + " ");
    		}else{
    			sql.append(" ," + getTableColumnNames()[i] + " ");
    		}
    	}
    	sql.append(" FROM ");
    	sql.append(" " + getTableName() + " ");

    	return sql.toString();
    }

    /**
     * �󒍃_�E�����[�h�f�[�^�P�ʂŔr�����b�N���s��SQL��Ԃ��܂��B
     * @return
     */
    public String getSelectSQLForLock(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB2KMEI.TIMSTMP + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getHb2TksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getHb2Yymm() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = '" + _cond.getHb2JyutNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = '" + _cond.getHb2JyMeiNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = '" + _cond.getHb2UrMeiNo() + "' ");
    	sql.append(" ORDER BY ");
    	sql.append(" " + TBTHB2KMEI.TIMSTMP + " DESC ");

    	return sql.toString();
    }

	/**
	 * �G�v�\���L����p�r�����b�NSQL
	 *
	 * @return
	 */
	public String getSelectSQLForEpsonLock() {
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT ");
		sql.append(" " + TBTHB2KMEI.TIMSTMP + " ");
		sql.append(" FROM ");
		sql.append(" " + TBTHB2KMEI.TBNAME + " ");
		sql.append(" WHERE ");
		sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getHb2EgCd() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getHb2TksKgyCd() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getHb2Yymm() + "' ");
		//�����������̃��R�[�h�̍ŐV���R�[�h���擾���邽��
//		sql.append(" AND ");
//		sql.append(" " + TBTHB2KMEI.JYUTNO + " = '" + _cond.getHb2JyutNo() + "' ");
//		sql.append(" AND ");
//		sql.append(" " + TBTHB2KMEI.JYMEINO + " = '" + _cond.getHb2JyMeiNo() + "' ");
//		sql.append(" AND ");
//		sql.append(" " + TBTHB2KMEI.URMEINO + " = '" + _cond.getHb2UrMeiNo() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.NAME21 + " = '1' ");
		sql.append(" ORDER BY ");
		sql.append(" " + TBTHB2KMEI.TIMSTMP + " DESC ");

		return sql.toString();
	}

	/**
	 * �G�v�\���������C�p�r�����b�NSQL
	 *
	 * @return
	 */
	public String getSelectSQLForEpsonSKLock() {
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT ");
		sql.append(" " + TBTHB2KMEI.TIMSTMP + " ");
		sql.append(" FROM ");
		sql.append(" " + TBTHB2KMEI.TBNAME + " ");
		sql.append(" WHERE ");
		sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getHb2EgCd() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getHb2TksKgyCd() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getHb2Yymm() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.JYUTNO + " = '" + _cond.getHb2JyutNo() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.JYMEINO + " = '" + _cond.getHb2JyMeiNo() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.URMEINO + " = '" + _cond.getHb2UrMeiNo() + "' ");
		sql.append(" AND ");
		sql.append(" " + TBTHB2KMEI.NAME21 + " = '2' ");
		sql.append(" ORDER BY ");
		sql.append(" " + TBTHB2KMEI.TIMSTMP + " DESC ");

		return sql.toString();
	}

    /**
     * �����w�茟��SQL��Ԃ��܂��B
     * @return
     */
    public String getSelectSQLForCondCmn(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	//�S���ڂ��擾
    	for (int i = 0; i < getTableColumnNames().length; i++){
    		if (i == 0){
    			sql.append("  " + getTableColumnNames()[i] + " ");
    		}else{
    			sql.append(" ," + getTableColumnNames()[i] + " ");
    		}
    	}
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getHb2TksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getHb2Yymm() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = '" + _cond.getHb2JyutNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = '" + _cond.getHb2JyMeiNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = '" + _cond.getHb2UrMeiNo() + "' ");
    	sql.append(" ORDER BY ");
        if((_cond.getHb2TksKgyCd() + _cond.getHb2TksBmnSeqNo() + _cond.getHb2TksTntSeqNo()).equals(KKHConstants.TksKgyCode.SKYP.getCode())){
        	//���Ӑ悪�X�J�p�[�̏ꍇ
        	sql.append(" " + TBTHB2KMEI.SONOTA1 + " ");
        	sql.append(", " + TBTHB2KMEI.NAME13 + " ");
        	sql.append(", " + TBTHB2KMEI.SONOTA2 + " ");
        	sql.append(", " + TBTHB2KMEI.RENBN + " ");
        }else
        {
        	sql.append(" " + TBTHB2KMEI.RENBN + " ");
        }

    	return sql.toString();
    }


    /**
     * �����w�茟��SQL��Ԃ��܂��B
     * @return
     */
    public String getSpySelectSQLForCondCmn(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB2KMEI.TIMSTMP+ " ");
    	sql.append(", " + TBTHB2KMEI.UPDAPL+ " ");
    	sql.append(", " + TBTHB2KMEI.UPDTNT+ " ");
    	sql.append(", " + TBTHB2KMEI.EGCD+ " ");
    	sql.append(", " + TBTHB2KMEI.TKSKGYCD+ " ");
    	sql.append(", " + TBTHB2KMEI.TKSBMNSEQNO+ " ");
    	sql.append(", " + TBTHB2KMEI.TKSTNTSEQNO+ " ");
    	sql.append(", " + TBTHB2KMEI.YYMM+ " ");
    	sql.append(", " + TBTHB2KMEI.JYUTNO+ " ");
    	sql.append(", " + TBTHB2KMEI.JYMEINO+ " ");
    	sql.append(", " + TBTHB2KMEI.URMEINO+ " ");
    	sql.append(", " + TBTHB2KMEI.HIMKCD+ " ");
    	sql.append(", " + TBTHB2KMEI.RENBN+ " ");
    	sql.append(", " + TBTHB2KMEI.DATEFROM+ " ");
    	sql.append(", " + TBTHB2KMEI.DATETO+ " ");
    	sql.append(", " + TBTHB2KMEI.SEIGAK+ " ");
    	sql.append(", " + TBTHB2KMEI.HNNERT+ " ");
    	sql.append(", " + TBTHB2KMEI.HNMAEGAK+ " ");
    	sql.append(", " + TBTHB2KMEI.NEBIGAK+ " ");
    	sql.append(", " + TBTHB2KMEI.DATE1+ " ");
    	sql.append(", " + TBTHB2KMEI.DATE2+ " ");
    	sql.append(", " + TBTHB2KMEI.DATE3+ " ");
    	sql.append(", " + TBTHB2KMEI.DATE4+ " ");
    	sql.append(", " + TBTHB2KMEI.DATE5+ " ");
    	sql.append(", " + TBTHB2KMEI.DATE6+ " ");
    	sql.append(", " + TBTHB2KMEI.KBN1+ " ");
    	sql.append(", " + TBTHB2KMEI.KBN2+ " ");
    	sql.append(", " + TBTHB2KMEI.KBN3+ " ");
    	sql.append(", " + TBTHB2KMEI.CODE1+ " ");
    	sql.append(", " + TBTHB2KMEI.CODE2+ " ");
    	sql.append(", " + TBTHB2KMEI.CODE3+ " ");
    	sql.append(", " + TBTHB2KMEI.CODE4+ " ");
    	sql.append(", " + TBTHB2KMEI.CODE5+ " ");
    	sql.append(", " + TBTHB2KMEI.CODE6+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME1+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME2+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME3+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME4+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME5+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME6+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME7+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME8+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME9+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME10+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME11+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME12+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME13+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME14+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME15+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME16+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME17+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME18+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME19+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME20+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME21+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME22+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME23+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME24+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME25+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME26+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME27+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME28+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME29+ " ");
    	sql.append(", " + TBTHB2KMEI.NAME30+ " ");
    	sql.append(", " + TBTHB2KMEI.KNGK1+ " ");
    	sql.append(", " + TBTHB2KMEI.KNGK2+ " ");
    	sql.append(", " + TBTHB2KMEI.KNGK3+ " ");
    	sql.append(", " + TBTHB2KMEI.RITU1+ " ");
    	sql.append(", " + TBTHB2KMEI.RITU2+ " ");
    	sql.append(", CASE " + TBTHB2KMEI.SONOTA1+ " WHEN ' ' THEN NULL ELSE " + TBTHB2KMEI.SONOTA1 + " END AS " + TBTHB2KMEI.SONOTA1);
    	sql.append(", CASE " + TBTHB2KMEI.SONOTA2+ " WHEN ' ' THEN NULL ELSE " + TBTHB2KMEI.SONOTA2 + " END AS " + TBTHB2KMEI.SONOTA2);
    	sql.append(", " + TBTHB2KMEI.SONOTA3+ " ");
    	sql.append(", " + TBTHB2KMEI.SONOTA4+ " ");
    	sql.append(", " + TBTHB2KMEI.SONOTA5+ " ");
    	sql.append(", " + TBTHB2KMEI.SONOTA6+ " ");
    	sql.append(", " + TBTHB2KMEI.SONOTA7+ " ");
    	sql.append(", " + TBTHB2KMEI.SONOTA8+ " ");
    	sql.append(", " + TBTHB2KMEI.SONOTA9+ " ");
    	sql.append(", " + TBTHB2KMEI.SONOTA10+ " ");
    	sql.append(", " + TBTHB2KMEI.BUNFLG+ " ");
    	sql.append(", " + TBTHB2KMEI.MEIHNFLG+ " ");
    	sql.append(", " + TBTHB2KMEI.NEBHNFLG+ " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getHb2TksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getHb2Yymm() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = '" + _cond.getHb2JyutNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = '" + _cond.getHb2JyMeiNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = '" + _cond.getHb2UrMeiNo() + "' ");
    	sql.append(" ORDER BY ");
    	sql.append(" " + TBTHB2KMEI.SONOTA1 + " ");
    	sql.append(", " + TBTHB2KMEI.NAME13 + " ");
    	sql.append(", " + TBTHB2KMEI.SONOTA2 + " ");
    	sql.append(", " + TBTHB2KMEI.RENBN + " ");


        return sql.toString();
    }



    /**
     * �L����׃e�[�u���̔r������p�������s���܂��B(�󒍃_�E�����[�h�f�[�^�P��)
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Thb2KmeiVO> lockThb2Kmei(Thb2KmeiVO cond) throws KKHException {

    	super.setModel(new Thb2KmeiVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LOCK;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }

    }

	/**
	 * �G�v�\���L����p�r�����b�N
	 *
	 * @return �󒍃_�E�����[�h�f�[�^VO
	 * @throws UserException
	 *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
	 */
	@SuppressWarnings("unchecked")
	public List<Thb2KmeiVO> epsonLockThb2Kmei(Thb2KmeiVO cond) throws KKHException {

		super.setModel(new Thb2KmeiVO());

		try {
			_cond = cond;
			_selSqlMode = SelSqlMode.EPSON_LOCK;
			return super.find();
		} catch (UserException e) {
			throw new KKHException(e.getMessage(), "BD-E0001");
		}

	}

	/**
	 * �G�v�\����������p�r�����b�N
	 *
	 * @return �󒍃_�E�����[�h�f�[�^VO
	 * @throws UserException
	 *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
	 */
	@SuppressWarnings("unchecked")
	public List<Thb2KmeiVO> epsonSKLockThb2Kmei(Thb2KmeiVO cond) throws KKHException {

		super.setModel(new Thb2KmeiVO());

		try {
			_cond = cond;
			_selSqlMode = SelSqlMode.EPSON_SK_LOCK;
			return super.find();
		} catch (UserException e) {
			throw new KKHException(e.getMessage(), "BD-E0001");
		}

	}

    /**
     * �L����׃e�[�u���̏����w�茟�����s���܂��B
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Thb2KmeiVO> findThb2KmeiByCondCmn(Thb2KmeiVO cond) throws KKHException {

    	super.setModel(new Thb2KmeiVO());

        try {
        	_cond = cond;
        	if((_cond.getHb2TksKgyCd() + _cond.getHb2TksBmnSeqNo() + _cond.getHb2TksTntSeqNo()).equals(KKHConstants.TksKgyCode.SKYP.getCode())){
            	//���Ӑ悪�X�J�p�[�̏ꍇ
        		_selSqlMode = SelSqlMode.SCOND_CMN;
        	}else
        	{
        		_selSqlMode = SelSqlMode.COND_CMN;
        	}
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * EXEC-SQL����
     */
    @Override
    public String getExecString() {
    	StringBuffer sql = new StringBuffer();

    	if (_execSqlMode.equals(ExecSqlMode.DEL_COND)){
            sql.append(" DELETE ");
            sql.append(" FROM ");
            sql.append(" " + TBTHB2KMEI.TBNAME + " ");
            // Where��
            sql.append(" WHERE ");
            sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _condVO.getHb2EgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _condVO.getHb2TksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _condVO.getHb2TksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _condVO.getHb2TksTntSeqNo() + "' ");
            if (_condVO.getHb2Yymm() != null && !_condVO.getHb2Yymm().equals("")){
	            sql.append(" AND ");
	            sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _condVO.getHb2Yymm() + "' ");
            }
            if (_condVO.getHb2JyutNo() != null && !_condVO.getHb2JyutNo().equals("")){
	            sql.append(" AND ");
	            sql.append(" " + TBTHB2KMEI.JYUTNO + " = '" + _condVO.getHb2JyutNo() + "' ");
            }
            if (_condVO.getHb2JyMeiNo() != null && !_condVO.getHb2JyMeiNo().equals("")){
	            sql.append(" AND ");
	            sql.append(" " + TBTHB2KMEI.JYMEINO + " = '" + _condVO.getHb2JyMeiNo() + "' ");
            }
            if (_condVO.getHb2UrMeiNo() != null && !_condVO.getHb2UrMeiNo().equals("")){
	            sql.append(" AND ");
	            sql.append(" " + TBTHB2KMEI.URMEINO + " = '" + _condVO.getHb2UrMeiNo() + "' ");
            }
    	}

    	return sql.toString();
    }

    /**
     * �L����׃e�[�u���̏����w��폜
     *
     * @param cond �폜����
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public boolean deleteThb2KmeiByCondition(Thb2KmeiVO condVO) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (condVO == null) {
            throw new KKHException("�폜�G���[", "BD-E0003");
        }

        try {
            _condVO = condVO;
            _execSqlMode = ExecSqlMode.DEL_COND;
            super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }

        return true;
    }
}
