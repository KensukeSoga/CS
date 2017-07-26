package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * ���[�iMAC)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportMacGetDenNumDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^�������� */
    private ReportMacGetDenNumCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode{KIND,ITEM,};
//    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportMacGetDenNumDAO() {
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
//		return new String[]{
//				TBTHB2KMEI.EGCD,
//				TBTHB2KMEI.TKSKGYCD,
//				TBTHB2KMEI.TKSBMNSEQNO,
//				TBTHB2KMEI.TKSTNTSEQNO,
//				TBTHB2KMEI.YYMM,
//				TBTHB2KMEI.JYUTNO,
//				TBTHB2KMEI.JYMEINO,
//				TBTHB2KMEI.URMEINO,
//				TBTHB2KMEI.RENBN
//		};
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
        return new String[]{

                TBTHBAMST.FIELD1,		// �`�[�ԍ�
                TBTHBAMST.FIELD2,		// �`�[�ԍ����
                TBTHBAMST.FIELD3,		// �����R�[�h
                TBTHBAMST.FIELD4,		// �d�b�ԍ�
                TBTHBAMST.FIELD5,		// �A����Z��
                TBTHBAMST.FIELD6,		// �`�[����
                TBTHBAMST.FIELD7,		// ���x������
                TBTHBAMST.INTVALUE2,	// �����
        };
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
        sql.append("  " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append("  " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append("  " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append("  " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");
        sql.append("  " + TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");
        sql.append("  " + TBTHBAMST.SYBT  + " = '201' ");

        return sql.toString();
    }

    /**
     * ���[�f�[�^�iMAC)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportMacGetDenNumVO> findReportMacGetDenNumByCondition(ReportMacGetDenNumCondition cond) throws KKHException {

        super.setModel(new ReportMacGetDenNumVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

}
