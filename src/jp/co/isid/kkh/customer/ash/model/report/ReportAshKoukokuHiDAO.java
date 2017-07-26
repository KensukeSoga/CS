package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;

//import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCodeDAO.SqlMode;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;

import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.constants.KKHConstants;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �L����׏��iAsh�j�f�[�^����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/12 fourm h.izawa)<BR>
 * </P>
 * @author fourm h.izawa
 */
public class ReportAshKoukokuHiDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^�������� */
    private ReportAshMediaCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{Data,Kingak,};
    private SqlMode _sqlMode = SqlMode.Data;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportAshKoukokuHiDAO() {
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
//      };

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
                    TBTHB2KMEI.NAME4 + " SEIKYUNO",
                    TBTHB2KMEI.CODE1 + " BAITAICD",
                    TBTHB2KMEI.SEIGAK + " SEIKYUKIN",
                    "MST2."+TBTHBAMST.FIELD2 + " KYOKUNM",
                    TBTHB2KMEI.CODE2 + " KYOKUCD",
                    "MST1."+ TBTHBAMST.FIELD2 + " HINSYUNM",
                    TBTHB2KMEI.CODE3 + " HINSYUCD",
                    TBTHB2KMEI.CODE4 + " DAIRITENCD",
                    TBTHB2KMEI.CODE5 + " BANGUMICD",
                    // 2013/01/17 JSE M.Naito
                    //TBTHB2KMEI.NAME8 + " KENMEI",
                    TBTHB2KMEI.NAME10 + " KENMEI",
                    TBTHB2KMEI.RENBN + " RENBN",
                    TBTHB2KMEI.JYUTNO + " JYUTNO",
                    TBTHB2KMEI.JYMEINO + " JYMEINO",
                    TBTHB2KMEI.URMEINO + " URMEINO",
                    TBTHB2KMEI.SONOTA8 + " KEYKYOKU",
                    TBTHB2KMEI.CODE6 + " CODE6",
                    "MST2." + TBTHBAMST.FIELD4 + " KYOKURYAKU",
                    TBTHB2KMEI.SONOTA10 + " SONOTA10"
        };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        if(_sqlMode.equals(SqlMode.Data)){
            //�L����׏��f�[�^����
            return getSelectSQLForItem();
        }else if(_sqlMode.equals(SqlMode.Kingak)){
            //�L����׏��^�C�����z����
            return getSelectSQLTvAndRaidoKingak();
        }
        return "";
    }

    /**
     * �L����׏��f�[�^����SQL���쐬
     * @return SQL��
     */
    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        //�e���r�^�C���E�e���r�X�|�b�g�E�e���r�l�b�g�X�|�b�g
        sql.append("SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '204' AND");
        // UPD 2015/06/08 K.F �A�T�q�Ή� Start
        //sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '100', '110' ) AND");
        if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
        	// �A�T�q�r�[���̏ꍇ�A�e���r�l�b�g�X�|�b�g��ΏۂƂ���
        	sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '100', '105', '110' ) AND");
        }
        else
        {
        	sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '100', '110' ) AND");
        }
        // UPD 2015/06/08 K.F �A�T�q�Ή� End
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //�V��
        sql.append(" UNION");
        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '202' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '130' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //�G��
        sql.append(" UNION");
        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '203' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '140' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE6 + ") AND");
        //sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") ");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //���W�I�^�C��
        sql.append(" UNION");
        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append("," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '205' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '120' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //���W�I�X�|�b�g
        sql.append(" UNION");
        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append("," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '205' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '125' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //���
        sql.append(" UNION");
        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append("," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '206' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '150' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //����
        sql.append(" UNION");
        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append("," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '216' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '170' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //PR
        sql.append(" UNION");

        //2013/02/22 jse okazaki PR�}�̒ǉ��Ή��@Start
        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append("," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '221' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '119' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //
        sql.append(" UNION");
        //2013/02/22 jse okazaki PR�}�̒ǉ��Ή��@End

        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '217' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '160', '180' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);


        sql.append(" UNION");
        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append("  " + getTableColumnNames()[i]);
            }else{
                sql.append(" ," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '218' AND");
    	// UPD 2015/03/03 K.F �A�T�q�Ή� START
        //sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '190', '115', '116', '117', '118', '195' ) AND");
    	if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
    		//�A�T�q�r�[���̏ꍇ
    		// UPD 2015/06/08 K.F �A�T�q�Ή� Start
    		//sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('190','115','116','117','118','195','193','194','199') ");
    		sql.append(" " + TBTHB2KMEI.CODE1 + " NOT IN ('100','105','110','130','140','120','150','170','119','160','180','230','240') ");
    		// UPD 2015/06/08 K.F �A�T�q�Ή� End
    	}else{
    		//�A�T�q�����̏ꍇ
    		sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('190','115','116','117','118','195','321','322','331','332','333','334','336','380','382','389') ");
    	}
        sql.append(" AND");
    	// UPD 2015/03/03 K.F �A�T�q�Ή� END
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
    	// ADD 2015/02/25 K.F START
        sql.append(" MST2."+ TBTHBAMST.FIELD9 + "(+) = RTRIM(" + TBTHB2KMEI.CODE1 + ") AND");
    	// ADD 2015/02/25 K.F END
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);


        sql.append(" UNION");
        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '219' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '230' AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);


        sql.append(" UNION");
        sql.append(" SELECT");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '220' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '240' AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        sql.append(" ORDER BY");
        sql.append(" SONOTA10,");
        sql.append(" BaitaiCD,");
        sql.append(" SeikyuNo,");
        sql.append(" JYUTNO,");
        sql.append(" JYMEINO,");
        sql.append(" URMEINO,");
        sql.append(" RENBN");

        return sql.toString();
    }

    /**
     * �L����׏��^�C�����z����SQL���쐬
     * @return SQL��
     */
    private String getSelectSQLTvAndRaidoKingak()
    {
        StringBuffer sql = new StringBuffer();
        sql.append(" (SELECT ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HinsyuCD, ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BaitaiCD, ");
        sql.append(" MAX(ROUND(" + TBTHB2KMEI.SEIGAK + ")) SEIGAK ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ", ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('100') ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO+ " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO+ " " );
        sql.append(" GROUP BY ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE1 + ") ");
        sql.append(" UNION ");
        sql.append(" (SELECT ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HinsyuCD, ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BaitaiCD, ");
        sql.append(" MAX(ROUND(" + TBTHB2KMEI.SEIGAK + ")) SEIGAK ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ", ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' ");
        sql.append(" AND ");

        // 2015/07/31 �A�T�q�r�[���L����׏��s��Ή� k.soga Mod Start
        // sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('120') ");
         sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('120', '105') ");
        // 2015/07/31 �A�T�q�r�[���L����׏��s��Ή� k.soga Mod End

        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO+ " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO+ " " );
        sql.append(" GROUP BY ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE1 + ") ");

        return sql.toString();

    }
    /**
     * �A�T�q���[(�L����׏��}�̎�ʃf�[�^)�̌������s���܂��B
     * @param cond �A�T�q���[(�L����׏�)��������
     * @return �A�T�q���[(�L����׏�)VO���X�g
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportAshKoukokuHiVO> findReportAshKoukokuHiByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshKoukokuHiVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.Data;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �A�T�q���[(�L����׏��A�e���r�^�C���E���W�I�^�C�����׋��z�f�[�^)�̌������s���܂��B
     * @param cond �A�T�q���[(�L����׏�)��������
     * @return �A�T�q���[(�L����׏�)�^�C�����׋��zVO���X�g
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportAshTvAndRadioKingakVO> findTvAndRadioKingakByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshTvAndRadioKingakVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.Kingak;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

//    /**
//     * Model�̐������s��<br>
//     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
//     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
//     *
//     * @param hashList List ��������
//     * @return List<CommonCodeMasterVO> �ϊ���̌�������
//     */
//    @Override
//    @SuppressWarnings("unchecked")
//    protected List<ReportMacVO> createFindedModelInstances(List hashList) {
//        List<ReportMacVO> list = new ArrayList<ReportMacVO>();
//        if (getModel() instanceof ReportMacVO) {
//            for (int i = 0; i < hashList.size(); i++) {
//                Map result = (Map) hashList.get(i);
//                ReportMacVO vo = new ReportMacVO();
//                vo.setSeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
//                vo.setDate1((String)result.get(TBTHB2KMEI.DATE1.toUpperCase()));
//                vo.setKbn1((String)result.get(TBTHB2KMEI.KBN1.toUpperCase()));
//                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
//                vo.setCode2((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
//                vo.setCode4((String)result.get(TBTHB2KMEI.CODE4.toUpperCase()));
//                vo.setName1((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
//                vo.setName2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
//                vo.setName3((String)result.get(TBTHB2KMEI.NAME3.toUpperCase()));
//                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
//                vo.setKngk2((BigDecimal)result.get(TBTHB2KMEI.KNGK2.toUpperCase()));
//                vo.setSonota1((String)result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));
//                vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
//                vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
//                vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
//                vo.setRenbn((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
//                vo.setSonota2((String)result.get(TBTHB2KMEI.SONOTA2.toUpperCase()));
//                // �������ʒ���̏�Ԃɂ���
//                ModelUtils.copyMemberSearchAfterInstace(vo);
//                list.add(vo);
//            }
//        }
//        return list;
//    }

}
