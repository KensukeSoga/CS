package jp.co.isid.kkh.customer.ash.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;
import jp.co.isid.kkh.model.master.MasterVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

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
public class DetailDataAshDAO extends AbstractRdbDao {

    /**�󒍃f�[�^�������� */
    private DetailDataAshCondition _cond;
    /**�󒍃f�[�^�������� */
    private Thb2KmeiVO _vo;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{DTL, BCD, BCDMST, RENBN, };
    private SqlMode _sqlMode = SqlMode.DTL;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public DetailDataAshDAO() {
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
        if (_sqlMode.equals(SqlMode.DTL)){
            //=================================================================================================================================================================
            //SELECT��
            //=================================================================================================================================================================
            sql.append(" SELECT ");
            sql.append("     " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TIMSTMP + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.UPDAPL + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.UPDTNT + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HIMKCD + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RENBN + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATEFROM + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATETO + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SEIGAK + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HNNERT + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HNMAEGAK + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NEBIGAK + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.DATE6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KBN1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KBN2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KBN3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME7 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME8 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME9 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME10 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME11 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME12 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME13 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME14 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME15 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME16 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME17 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME18 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME19 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME20 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME21 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME22 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME23 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME24 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME25 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME26 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME27 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME28 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME29 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NAME30 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KNGK1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KNGK2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.KNGK3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RITU1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RITU2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA1 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA2 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA3 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA4 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA5 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA6 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA7 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA8 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA9 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SONOTA10 + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.BUNFLG + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.MEIHNFLG + " ");
            sql.append("    ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.NEBHNFLG + " ");
            sql.append("    ," + "KYOKUMST"        + "." + TBTHBAMST.FIELD1 + " AS KYOKUMST_FIELD1 ");
            sql.append("    ," + "KYOKUMST"        + "." + TBTHBAMST.FIELD2 + " AS KYOKUMST_FIELD2 ");
            sql.append("    ," + "KYOKUMST"        + "." + TBTHBAMST.FIELD3 + " AS KYOKUMST_FIELD3 ");
            sql.append("    ," + "KYOKUMST"        + "." + TBTHBAMST.FIELD4 + " AS KYOKUMST_FIELD4 ");
            sql.append("    ," + "SHOUHINMST"      + "." + TBTHBAMST.FIELD1 + " AS SHOUHINMST_FIELD1 ");
            sql.append("    ," + "SHOUHINMST"      + "." + TBTHBAMST.FIELD2 + " AS SHOUHINMST_FIELD2 ");
            //=================================================================================================================================================================
            //FROM��
            //=================================================================================================================================================================
            sql.append(" FROM ");
            sql.append("     " + TBTHB2KMEI.TBNAME + " ");
            sql.append("    ," + TBTHBAMST.TBNAME + " KYOKUMST ");
            sql.append("    ," + TBTHBAMST.TBNAME + " SHOUHINMST ");
            //=================================================================================================================================================================
            //WHERE��
            //=================================================================================================================================================================
            sql.append(" WHERE ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD             + " = '" + _cond.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD         + " = '" + _cond.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO      + " = '" + _cond.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO      + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM             + " = '" + _cond.getYm() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO           + " = '" + _cond.getJyutNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO          + " = '" + _cond.getJyMeiNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO          + " = '" + _cond.getUrMeiNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + "KYOKUMST"        + "." + TBTHBAMST.EGCD + "(+)"        + " = "  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD  + " ");
            sql.append(" AND ");
            sql.append("    " + "KYOKUMST"        + "." + TBTHBAMST.TKSKGYCD + "(+)"    + " = "  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD  + " ");
            sql.append(" AND ");
            sql.append("    " + "KYOKUMST"        + "." + TBTHBAMST.TKSBMNSEQNO + "(+)" + " = "  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO  + " ");
            sql.append(" AND ");
            sql.append("    " + "KYOKUMST"        + "." + TBTHBAMST.TKSTNTSEQNO + "(+)" + " = "  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO  + " ");
            sql.append(" AND ");
            sql.append("    " + "KYOKUMST"        + "." + TBTHBAMST.SYBT + "(+)"        + " = '" + _cond.getMstSybt()  + "' ");
            if (_cond.getTargetBaitaiCd().equals("140")){
                sql.append(" AND ");
                sql.append("    " + "KYOKUMST"        + "." + TBTHBAMST.FIELD1 + "(+)"      + " = TRIM("  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE6  + ") ");
            }else{
                sql.append(" AND ");
                sql.append("    " + "KYOKUMST"        + "." + TBTHBAMST.FIELD1 + "(+)"      + " = TRIM("  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE2  + ") ");
            }
            // ADD 2015/02/25 K.F START
            if (_cond.getMstSybt().equals("218")){
                sql.append(" AND ");
                sql.append("    " + "KYOKUMST"        + "." + TBTHBAMST.FIELD9 + "(+)"      + " = TRIM("  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE1  + ") ");
            }
        	// ADD 2015/02/25 K.F END
            sql.append(" AND ");
            sql.append("    " + "SHOUHINMST"      + "." + TBTHBAMST.EGCD + "(+)"        + " = "  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD  + " ");
            sql.append(" AND ");
            sql.append("    " + "SHOUHINMST"      + "." + TBTHBAMST.TKSKGYCD + "(+)"    + " = "  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD  + " ");
            sql.append(" AND ");
            sql.append("    " + "SHOUHINMST"      + "." + TBTHBAMST.TKSBMNSEQNO + "(+)" + " = "  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO  + " ");
            sql.append(" AND ");
            sql.append("    " + "SHOUHINMST"      + "." + TBTHBAMST.TKSTNTSEQNO + "(+)" + " = "  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO  + " ");
            sql.append(" AND ");
            sql.append("    " + "SHOUHINMST"      + "." + TBTHBAMST.SYBT + "(+)"        + " = '101' ");
            sql.append(" AND ");
            sql.append("    " + "SHOUHINMST"      + "." + TBTHBAMST.FIELD1 + "(+)"      + " = TRIM("  + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE3  + ") ");
            //=================================================================================================================================================================
            //Order��
            //=================================================================================================================================================================
            sql.append(" ORDER BY ");
            sql.append("     " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RENBN + " ");
        } else if (_sqlMode.equals(SqlMode.BCD)){
            //=================================================================================================================================================================
            //SELECT��
            //=================================================================================================================================================================
            sql.append(" SELECT ");
            sql.append("     " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.CODE1 + " ");
            //=================================================================================================================================================================
            //FROM��
            //=================================================================================================================================================================
            sql.append(" FROM ");
            sql.append("     " + TBTHB2KMEI.TBNAME + " ");
            //=================================================================================================================================================================
            //WHERE��
            //=================================================================================================================================================================
            sql.append(" WHERE ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD             + " = '" + _cond.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD         + " = '" + _cond.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO      + " = '" + _cond.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO      + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM             + " = '" + _cond.getYm() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO           + " = '" + _cond.getJyutNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO          + " = '" + _cond.getJyMeiNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO          + " = '" + _cond.getUrMeiNo() + "' ");
            //=================================================================================================================================================================
            //Order��
            //=================================================================================================================================================================
        } else if (_sqlMode.equals(SqlMode.BCDMST)){
            sql.append(" SELECT ");
            sql.append("     " + TBTHBAMST.TBNAME + "." + TBTHBAMST.FIELD2 + " ");
            sql.append("    ," + TBTHBAMST.TBNAME + "." + TBTHBAMST.FIELD3 + " ");
            sql.append("    ," + TBTHBAMST.TBNAME + "." + TBTHBAMST.FIELD4 + " ");
            sql.append("    ," + TBTHBAMST.TBNAME + "." + TBTHBAMST.FIELD5 + " ");
            sql.append("    ," + TBTHBAMST.TBNAME + "." + TBTHBAMST.FIELD6 + " ");
            sql.append(" FROM ");
            sql.append("     " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append("    " + TBTHBAMST.TBNAME + "." + TBTHBAMST.EGCD             + " = '" + _cond.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHBAMST.TBNAME + "." + TBTHBAMST.TKSKGYCD         + " = '" + _cond.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHBAMST.TBNAME + "." + TBTHBAMST.TKSBMNSEQNO      + " = '" + _cond.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHBAMST.TBNAME + "." + TBTHBAMST.TKSTNTSEQNO      + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHBAMST.TBNAME + "." + TBTHBAMST.SYBT             + " = '107' ");
        } else if (_sqlMode.equals(SqlMode.RENBN)) {
            sql.append(" SELECT ");
            sql.append("     MAX(" + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RENBN + ") AS " + TBTHB2KMEI.RENBN );
            sql.append(" FROM ");
            sql.append("     " + TBTHB2KMEI.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD             + " = '" + _vo.getHb2EgCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD         + " = '" + _vo.getHb2TksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO      + " = '" + _vo.getHb2TksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO      + " = '" + _vo.getHb2TksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM             + " = '" + _vo.getHb2Yymm() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO           + " = '" + _vo.getHb2JyutNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO          + " = '" + _vo.getHb2JyMeiNo() + "' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO          + " = '" + _vo.getHb2UrMeiNo() + "' ");
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
    public List<DetailDataAshVO> findDetailDataByCondition(DetailDataAshCondition cond) throws KKHException {

        super.setModel(new DetailDataAshVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.DTL;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * �g�p���}�̃f�[�^�̌������s���܂��B
     *
     * @return �L����׃f�[�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<String> findUseBaitaiCd(DetailDataAshCondition cond) throws KKHException {

        super.setModel(new DetailDataAshVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.BCD;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * �}�̃R�[�h�ϊ��}�X�^�̌������s���܂��B
     *
     * @return �L����׃f�[�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<MasterVO> findBaitaiCdCnvMst(DetailDataAshCondition cond) throws KKHException {

        super.setModel(new MasterVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.BCDMST;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * �L����׃f�[�^�̘A�ԍő�l�擾(�󒍓����p)
     *
     * @param vo �L����׃f�[�^VO
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    @SuppressWarnings("unchecked")
    public List<Thb2KmeiVO> selectThb2KmeiMaxRenbn(Thb2KmeiVO vo) throws KKHException {

        super.setModel(new Thb2KmeiVO());

        try {
            _vo = vo;
            _sqlMode = SqlMode.RENBN;
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
        if (_sqlMode.equals(SqlMode.BCD)){
            list = new ArrayList<String>();
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                list.add((String)result.get(TBTHB2KMEI.CODE1));
            }
        }else if (getModel() instanceof DetailDataAshVO) {
            list = new ArrayList<DetailDataAshVO>();
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                DetailDataAshVO vo = new DetailDataAshVO();

                vo.setHb2TimStmp((Date)result.get(TBTHB2KMEI.TIMSTMP.toUpperCase()));
                vo.setHb2UpdApl((String)result.get(TBTHB2KMEI.UPDAPL.toUpperCase()));
                vo.setHb2UpdTnt((String)result.get(TBTHB2KMEI.UPDTNT.toUpperCase()));
                vo.setHb2EgCd((String)result.get(TBTHB2KMEI.EGCD.toUpperCase()));
                vo.setHb2TksKgyCd((String)result.get(TBTHB2KMEI.TKSKGYCD.toUpperCase()));
                vo.setHb2TksBmnSeqNo((String)result.get(TBTHB2KMEI.TKSBMNSEQNO.toUpperCase()));
                vo.setHb2TksTntSeqNo((String)result.get(TBTHB2KMEI.TKSTNTSEQNO.toUpperCase()));
                vo.setHb2Yymm((String)result.get(TBTHB2KMEI.YYMM.toUpperCase()));
                vo.setHb2JyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                vo.setHb2JyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                vo.setHb2UrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
                vo.setHb2HimkCd((String)result.get(TBTHB2KMEI.HIMKCD.toUpperCase()));
                vo.setHb2Renbn((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
                vo.setHb2DateFrom((String)result.get(TBTHB2KMEI.DATEFROM.toUpperCase()));
                vo.setHb2DateTo((String)result.get(TBTHB2KMEI.DATETO.toUpperCase()));
                vo.setHb2SeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setHb2Hnnert((BigDecimal)result.get(TBTHB2KMEI.HNNERT.toUpperCase()));
                vo.setHb2HnmaeGak((BigDecimal)result.get(TBTHB2KMEI.HNMAEGAK.toUpperCase()));
                vo.setHb2NebiGak((BigDecimal)result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));
                vo.setHb2Date1((String)result.get(TBTHB2KMEI.DATE1.toUpperCase()));
                vo.setHb2Date2((String)result.get(TBTHB2KMEI.DATE2.toUpperCase()));
                vo.setHb2Date3((String)result.get(TBTHB2KMEI.DATE3.toUpperCase()));
                vo.setHb2Date4((String)result.get(TBTHB2KMEI.DATE4.toUpperCase()));
                vo.setHb2Date5((String)result.get(TBTHB2KMEI.DATE5.toUpperCase()));
                vo.setHb2Date6((String)result.get(TBTHB2KMEI.DATE6.toUpperCase()));
                vo.setHb2Kbn1((String)result.get(TBTHB2KMEI.KBN1.toUpperCase()));
                vo.setHb2Kbn2((String)result.get(TBTHB2KMEI.KBN2.toUpperCase()));
                vo.setHb2Kbn3((String)result.get(TBTHB2KMEI.KBN3.toUpperCase()));
                vo.setHb2Code1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                vo.setHb2Code2((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
                vo.setHb2Code3((String)result.get(TBTHB2KMEI.CODE3.toUpperCase()));
                vo.setHb2Code4((String)result.get(TBTHB2KMEI.CODE4.toUpperCase()));
                vo.setHb2Code5((String)result.get(TBTHB2KMEI.CODE5.toUpperCase()));
                vo.setHb2Code6((String)result.get(TBTHB2KMEI.CODE6.toUpperCase()));
                vo.setHb2Name1((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
                vo.setHb2Name2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                vo.setHb2Name3((String)result.get(TBTHB2KMEI.NAME3.toUpperCase()));
                vo.setHb2Name4((String)result.get(TBTHB2KMEI.NAME4.toUpperCase()));
                vo.setHb2Name5((String)result.get(TBTHB2KMEI.NAME5.toUpperCase()));
                vo.setHb2Name6((String)result.get(TBTHB2KMEI.NAME6.toUpperCase()));
                vo.setHb2Name7((String)result.get(TBTHB2KMEI.NAME7.toUpperCase()));
                vo.setHb2Name8((String)result.get(TBTHB2KMEI.NAME8.toUpperCase()));
                vo.setHb2Name9((String)result.get(TBTHB2KMEI.NAME9.toUpperCase()));
                vo.setHb2Name10((String)result.get(TBTHB2KMEI.NAME10.toUpperCase()));
                vo.setHb2Name11((String)result.get(TBTHB2KMEI.NAME11.toUpperCase()));
                vo.setHb2Name12((String)result.get(TBTHB2KMEI.NAME12.toUpperCase()));
                vo.setHb2Name13((String)result.get(TBTHB2KMEI.NAME13.toUpperCase()));
                vo.setHb2Name14((String)result.get(TBTHB2KMEI.NAME14.toUpperCase()));
                vo.setHb2Name15((String)result.get(TBTHB2KMEI.NAME15.toUpperCase()));
                vo.setHb2Name16((String)result.get(TBTHB2KMEI.NAME16.toUpperCase()));
                vo.setHb2Name17((String)result.get(TBTHB2KMEI.NAME17.toUpperCase()));
                vo.setHb2Name18((String)result.get(TBTHB2KMEI.NAME18.toUpperCase()));
                vo.setHb2Name19((String)result.get(TBTHB2KMEI.NAME19.toUpperCase()));
                vo.setHb2Name20((String)result.get(TBTHB2KMEI.NAME20.toUpperCase()));
                vo.setHb2Name21((String)result.get(TBTHB2KMEI.NAME21.toUpperCase()));
                vo.setHb2Name22((String)result.get(TBTHB2KMEI.NAME22.toUpperCase()));
                vo.setHb2Name23((String)result.get(TBTHB2KMEI.NAME23.toUpperCase()));
                vo.setHb2Name24((String)result.get(TBTHB2KMEI.NAME24.toUpperCase()));
                vo.setHb2Name25((String)result.get(TBTHB2KMEI.NAME25.toUpperCase()));
                vo.setHb2Name26((String)result.get(TBTHB2KMEI.NAME26.toUpperCase()));
                vo.setHb2Name27((String)result.get(TBTHB2KMEI.NAME27.toUpperCase()));
                vo.setHb2Name28((String)result.get(TBTHB2KMEI.NAME28.toUpperCase()));
                vo.setHb2Name29((String)result.get(TBTHB2KMEI.NAME29.toUpperCase()));
                vo.setHb2Name30((String)result.get(TBTHB2KMEI.NAME30.toUpperCase()));
                vo.setHb2Kngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
                vo.setHb2Kngk2((BigDecimal)result.get(TBTHB2KMEI.KNGK2.toUpperCase()));
                vo.setHb2Kngk3((BigDecimal)result.get(TBTHB2KMEI.KNGK3.toUpperCase()));
                vo.setHb2Ritu1((BigDecimal)result.get(TBTHB2KMEI.RITU1.toUpperCase()));
                vo.setHb2Ritu2((BigDecimal)result.get(TBTHB2KMEI.RITU2.toUpperCase()));
                vo.setHb2Sonota1((String)result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));
                vo.setHb2Sonota2((String)result.get(TBTHB2KMEI.SONOTA2.toUpperCase()));
                vo.setHb2Sonota3((String)result.get(TBTHB2KMEI.SONOTA3.toUpperCase()));
                vo.setHb2Sonota4((String)result.get(TBTHB2KMEI.SONOTA4.toUpperCase()));
                vo.setHb2Sonota5((String)result.get(TBTHB2KMEI.SONOTA5.toUpperCase()));
                vo.setHb2Sonota6((String)result.get(TBTHB2KMEI.SONOTA6.toUpperCase()));
                vo.setHb2Sonota7((String)result.get(TBTHB2KMEI.SONOTA7.toUpperCase()));
                vo.setHb2Sonota8((String)result.get(TBTHB2KMEI.SONOTA8.toUpperCase()));
                vo.setHb2Sonota9((String)result.get(TBTHB2KMEI.SONOTA9.toUpperCase()));
                vo.setHb2Sonota10((String)result.get(TBTHB2KMEI.SONOTA10.toUpperCase()));
                vo.setHb2BunFlg((String)result.get(TBTHB2KMEI.BUNFLG.toUpperCase()));
                vo.setHb2MeihnFlg((String)result.get(TBTHB2KMEI.MEIHNFLG.toUpperCase()));
                vo.setHb2NebhnFlg((String)result.get(TBTHB2KMEI.NEBHNFLG.toUpperCase()));

                vo.setKyokuField1((String)result.get("KYOKUMST_FIELD1"));
                vo.setKyokuField2((String)result.get("KYOKUMST_FIELD2"));
                vo.setKyokuField3((String)result.get("KYOKUMST_FIELD3"));
                vo.setKyokuField4((String)result.get("KYOKUMST_FIELD4"));

                vo.setShouhinField1((String)result.get("SHOUHINMST_FIELD1"));
                vo.setShouhinField2((String)result.get("SHOUHINMST_FIELD2"));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);

            }
        }else if (getModel() instanceof MasterVO) {
            if (_sqlMode.equals(SqlMode.BCDMST)){
                list = new ArrayList<MasterVO>();
                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    MasterVO vo = new MasterVO();

                    vo.setField2((String)result.get(TBTHBAMST.FIELD2));
                    vo.setField3((String)result.get(TBTHBAMST.FIELD3));
                    vo.setField4((String)result.get(TBTHBAMST.FIELD4));
                    vo.setField5((String)result.get(TBTHBAMST.FIELD5));
                    vo.setField6((String)result.get(TBTHBAMST.FIELD6));


                    // �������ʒ���̏�Ԃɂ���
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }else if (_sqlMode.equals(SqlMode.RENBN)){
            list = new ArrayList<DetailDataAshVO>();
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                DetailDataAshVO vo = new DetailDataAshVO();

                vo.setHb2Renbn((String)result.get(TBTHB2KMEI.RENBN ));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
