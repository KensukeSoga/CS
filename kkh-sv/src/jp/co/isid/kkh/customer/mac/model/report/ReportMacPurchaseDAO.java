package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
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
 * �E�s��Ή�(2014/04/30 HLC S.Fujimoto)<BR>
 * </P>
 * @author JSE KT
 */
public class ReportMacPurchaseDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^�������� */
    private ReportMacPurchaseCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode{KIND,ITEM,};
//    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportMacPurchaseDAO() {
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

                TBTHB2KMEI.SEIGAK,	// �������z
                TBTHB2KMEI.DATE1,	// �N��
                TBTHB2KMEI.KBN1,	// �X�܋敪
                TBTHB2KMEI.CODE1,	// �X�܃R�[�h
                TBTHB2KMEI.CODE4,	// ����Ȗ�
                TBTHB2KMEI.NAME1,	// �����P
                TBTHB2KMEI.NAME2,	// �����Q
                TBTHB2KMEI.NAME3,	// �X�ܖ���
                TBTHB2KMEI.KNGK1,	// �P��
                TBTHB2KMEI.KNGK2,	// ����
                TBTHB2KMEI.SONOTA1,	// �`�[NO
                TBTHB2KMEI.JYUTNO,	// ��NO
                TBTHB2KMEI.JYMEINO,	// �󒍖���NO
                TBTHB2KMEI.URMEINO,	// ���㖾��NO
                TBTHB2KMEI.RENBN,	// �A��
                TBTHBAMST.FIELD10,	// �Ж�
                TBTHBAMST.FIELD13,	// ���׍s�t���O
                TBTHB2KMEI.SONOTA2	// �����R�[�h
        };
    }
    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        if (_cond.getreflg().equals("0"))
            {return getSelectSQLForPrint();}
        else
            {return getSelectSQLForRePrint();}
    }

    /**
     * �����
     * @return
     */
    private String getSelectSQLForPrint(){

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
        //����őΉ� 2013/10/21 add HLC H.Watabe start
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + " * 0.01) AS "+ TBTHB2KMEI.RITU1 + " ");
        //����őΉ� 2013/10/21 add HLC H.Watabe end
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ", ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        /* �s��Ή� 2014/04/30 fujimoto ADD start */
        sql.append(", " + TBTHB1DOWN.TBNAME);
        /* �s��Ή� 2014/04/30 fujimoto ADD end */
        sql.append(" WHERE ");
        sql.append("  " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSKGYCD + " = " +  TBTHBAMST.TKSKGYCD  + "  AND ");
        sql.append("  " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO  + "  AND ");
        sql.append("  " + TBTHB2KMEI.TKSTNTSEQNO  + " = " + TBTHBAMST.TKSTNTSEQNO  + "  AND ");
        /* �s��Ή� 2014/04/30 fujimoto ADD start */
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD);
        sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD);
        sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO);
        sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO);
        sql.append(" AND " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO); // ��NO
        sql.append(" AND " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO); // �󒍖���NO
        sql.append(" AND " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO); // ���㖾��NO
        sql.append(" AND " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM); // �N��
        sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" AND ");
        /* �s��Ή� 2014/04/30 fujimoto ADD end */
        sql.append("  RTRIM(" + TBTHBAMST.FIELD1 + ") = RTRIM(" + TBTHB2KMEI.CODE1 + ") AND ");
        sql.append("  " + TBTHBAMST.SYBT  + " = '301'  AND ");
        if (!_cond.getterritory().equals(""))
        {
            sql.append("  " + TBTHBAMST.FIELD8 + " in (" + _cond.getterritory() + ") AND ");
        }
        if (!_cond.getYm().equals(""))
        {
            sql.append("  " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "'  AND ");
        }
        sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA1 + ") IS NULL AND ");
        sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA2 + ") = '" + _cond.getsplitflg()  + "'  ");
        sql.append("  ORDER BY "); //GAC_FIELD1,HB2_CODE1,HB2_JYUTNO,HB2_JYMEINO,HB2_URMEINO "
        sql.append("  " + TBTHBAMST.FIELD8  + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + ", ");   // ��NO
        sql.append("  " + TBTHB2KMEI.JYMEINO + ", ");  // �󒍖���NO
        sql.append("  " + TBTHB2KMEI.URMEINO + " ");  // ���㖾��NO

        return sql.toString();
    }

    private String getSelectSQLForRePrint(){

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
        //����őΉ� 2013/10/21 add HLC H.Watabe start
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + " * 0.01) AS "+ TBTHB2KMEI.RITU1 + " ");
        //����őΉ� 2013/10/21 add HLC H.Watabe end
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ", ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        /* �s��Ή� 2014/04/30 fujimoto ADD start */
        sql.append(", " + TBTHB1DOWN.TBNAME);
        /* �s��Ή� 2014/04/30 fujimoto ADD end */
        sql.append(" WHERE ");
        sql.append("  " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSKGYCD + " = " +  TBTHBAMST.TKSKGYCD  + "  AND ");
        sql.append("  " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO  + "  AND ");
        sql.append("  " + TBTHB2KMEI.TKSTNTSEQNO  + " = " + TBTHBAMST.TKSTNTSEQNO  + "  AND ");
        /* �s��Ή� 2014/04/30 fujimoto ADD start */
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD);
        sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD);
        sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO);
        sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO);
        sql.append(" AND " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO); // ��NO
        sql.append(" AND " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO); // �󒍖���NO
        sql.append(" AND " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO); // ���㖾��NO
        sql.append(" AND " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM); // �N��
        sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" AND ");
        /* �s��Ή� 2014/04/30 fujimoto ADD end */
        sql.append("  RTRIM(" + TBTHBAMST.FIELD1 + ") = RTRIM(" + TBTHB2KMEI.CODE1 + ") AND ");
        sql.append("  " + TBTHBAMST.SYBT  + " = '301'  AND ");
        if (!_cond.getterritory().equals(""))
        {
            sql.append("  " + TBTHBAMST.FIELD8 + " in (" + _cond.getterritory() + ") AND ");
        }
        if (!_cond.getYm().equals(""))
        {
            sql.append("  " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "'  AND ");
        }
        if (!_cond.gettenpocd().equals("")){
            sql.append("  RTRIM(" + TBTHB2KMEI.CODE1 + ") = '" + _cond.gettenpocd()  + "' AND ");
        }
        //sql.append("  " + TBTHB2KMEI.SONOTA1 + " != " + "' ' AND ");
        //�`�[�ԍ��̂ǂ�����������Ȃ��ꍇ�͑S������
        if (_cond.getdenfr().equals("") && _cond.getdento().equals(""))
        {
            sql.append(" RTRIM(" + TBTHB2KMEI.SONOTA1 + ") IS NOT NULL AND ");
        }
        //TO�������AFROM������ꍇ
        else if (_cond.getdento().equals("")){
            sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA1 + ") >= '" + _cond.getdenfr()  + "' AND ");
        }
        //TO�������AFROM������ꍇ
        else if (_cond.getdenfr().equals("")){
            sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA1 + ") <= '" + _cond.getdento()  + "' AND ");
        }
        //TO�AFROM�ɗ����Ƃ��l������ꍇ
        else {
            sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA1 + ") BETWEEN '" + _cond.getdenfr()  + "' AND ");
            sql.append("'" + _cond.getdento()  + "' AND ");
        }
        sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA2 + ") = '" + _cond.getsplitflg()  + "'  ");
        sql.append("  ORDER BY ");
        sql.append("  " + TBTHBAMST.FIELD8  + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.SONOTA1 + " ");   // ��NO

        return sql.toString();
    }


    /**
     * ���[�f�[�^�iMAC)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportMacPurchaseVO> findReportMacPurchaseByCondition(ReportMacPurchaseCondition cond) throws KKHException {

        super.setModel(new ReportMacPurchaseVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }

    }

}
