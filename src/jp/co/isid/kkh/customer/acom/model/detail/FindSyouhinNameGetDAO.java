package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �����f�[�^�o�^DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class FindSyouhinNameGetDAO extends AbstractSimpleRdbDao  {

//	private FindMeisaiDataCondition _vo;
    private FindSyohinNameGetCond _cond;
     /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{COMMON,};
    private SqlMode _sqlMode = SqlMode.COMMON;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindSyouhinNameGetDAO() {
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
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
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
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB2KMEI.NEBHNFLG
        };
    }

    /**
     * ���{NO����UP/DOWN�̓o�^���s���܂��B
     *
     * @param vo VO ���{NoVO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
//    public void findThb2Kmei(FindMeisaiDataCondition vo) throws KKHException {
//        //�p�����[�^�`�F�b�N
//        if (vo == null) {
//            throw new KKHException("�o�^�G���[", "BD-E0002");
//        }
//        //super.setModel(vo);
//        _vo = vo;
//
//        try {
//          super.exec();
//        } catch (UserException e) {
//            throw new KKHException(e.getMessage(), "BD-E0002");
//        }
//    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public  String getSelectSQL() {
        if (_sqlMode.equals(SqlMode.COMMON)){
            return getExecString();
        }
        return "";
    }

    /**
     * EXEC-SQL����
     */
    @Override
    public String getExecString() {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + TBTHBAMST.FIELD2+ " ");
        sql.append(" FROM " );
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.get_tksKgyCd() +"' ");
        sql.append( " AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.get_tksBmnSeqNo() +"' ");
        sql.append( " AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.get_tksTntSeqNo() +"' ");
        sql.append( " AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '106' " );
        sql.append( " AND ");
        sql.append(" " + TBTHBAMST.FIELD1+ " = '" + _cond.get_syohinKbn() +"' ");

        return sql.toString();
    }

    /**
     * �L����׃e�[�u���̏����w�茟�����s���܂��B
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<MasterVO> findsyouhinNameByCond(FindSyohinNameGetCond Cond) throws KKHException {

        super.setModel(new MasterVO());

        try {
            _cond = Cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

}