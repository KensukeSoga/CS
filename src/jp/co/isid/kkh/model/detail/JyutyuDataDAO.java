package jp.co.isid.kkh.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB8DOWNR;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.constants.KKHConstants;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.DummyNull;
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
public class JyutyuDataDAO extends AbstractRdbDao {

    /**�󒍃f�[�^�������� */
    private JyutyuDataCondition _cond;
//    /**�󒍃f�[�^���������Q */
//    private JyutyuDataVO _condVo;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode{COMMON, CHILD};
//    private SqlMode _sqlMode = SqlMode.COMMON;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public JyutyuDataDAO() {
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
        //=================================================================================================================================================================
        //SELECT��
        //=================================================================================================================================================================
        sql.append(" SELECT ");
        sql.append(" ROWNUM ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TRKTIMSTMP  + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TRKAPL      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TRKTNT      + " ");

        //2012/8/3 �e�[�u���ύX�ɂ��ǉ�
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TRKTNTNM    + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.KSNTIMSTMP  + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.KSNTNT      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.KSNTNTNM    + " ");
        //2012/8/3 �ǉ��I���

        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TIMSTMP     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.UPDAPL      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.UPDTNT      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.ATUEGCD     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.EGCD        + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSKGYCD    + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYMEINO     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.URMEINO     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GPYNO       + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GPYOPAG     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.SEINO       + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.HIMKCD      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TOUFLG      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMM        + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.MSKBN       + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TMSPKBN     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.KOKKBN      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.SEIKBN      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.SYONO       + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.KKNAMEKJ    + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.EGGAMENTYPE + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.KKAKSHANKBN + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TORIGAK + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.SEITNKA + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.SEIGAK + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.NEBIRITU + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.NEBIGAK + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.SZEIKBN + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.SZEIRITU + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.SZEIGAK + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.HIMKNMKJ    + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.HIMKNMKN    + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TJYUTNO     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TJYMEINO    + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TURMEINO    + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.MSEIFLG     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMMOLD     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD1      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD2      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD3      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD4      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD5      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD6      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD7      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD8      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD9      + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD10     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD11     + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD12     + " ");
        sql.append(" ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO      + " ");
        sql.append(" ,NVL(" + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SEIGAK + ", 0) AS " + TBTHB2KMEI.SEIGAK + " ");
        sql.append(" ,CASE WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='11010' THEN '001' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='11020' THEN '002' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='11040' THEN '003' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='11050' THEN '004' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='11045' THEN '005' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='11030' THEN '006' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='11070' THEN '007' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='12010' THEN '008' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='13010' THEN '009' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='11060' THEN '010' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='11080' THEN '011' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='11090' THEN '012' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='14010' THEN '013' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='14020' THEN '014' ");
        sql.append("       WHEN " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + "='14030' THEN '015' ");
        sql.append("       ELSE " + "'999' ");
        sql.append("  END AS GYOMBAN ");
        sql.append(" ,NVL(" + TBTHB2KMEI.TBNAME + ".DETAILCNT, 0) AS DETAILCNT ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FILETIMSTMP      + " ");
        sql.append(" ,CASE ");
//      sql.append("       WHEN " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.MEITIMSTMP + " IS NULL THEN NULL ");
        sql.append("       WHEN " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.MEITIMSTMP + " = ' ' THEN NULL ");
        if (_cond.getCompareColumnList() != null){
            for (String compareColumn : _cond.getCompareColumnList()) {
                sql.append("       WHEN " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.PREFIX + compareColumn + " <> " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.PREFIX + compareColumn + " THEN " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.MEITIMSTMP + " ");
            }
        }
        sql.append("       ELSE NULL ");
        sql.append("  END AS " + TBTHB8DOWNR.MEITIMSTMP + " ");
//        sql.append(" ,NVL(" + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.MEITIMSTMP + ", '') AS " + TBTHB8DOWNR.MEITIMSTMP + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTDELFLG       + " ");
//        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TOH.getCode())){
//        	//���Ӑ悪����̏ꍇ
//        	sql.append(" , THBAMST1." + TBTHBAMST.FIELD2 + " AS SPACE2 ");
//        }

        //2013/03/06 jse okazaki �����Ή��@Start
        // 2015/04/01 �������Ӑ�ύX�Ή� Fujisaki Cng Start
        // if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN.getCode())){
        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN.getCode())
        || (_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN_2015.getCode())){
            sql.append(" ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.JYUTNO      + " ");
        }
        // 2015/04/01 �������Ӑ�ύX�Ή� Fujisaki Cng End
        //2013/03/06 jse okazaki �����Ή��@End
        sql.append(" FROM ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" ,( ");
        //if(_cond.getTksKgyCd().equals("031054")){
        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.UNI.getCode())){
            //���Ӑ悪���j�`���[���̏ꍇ
            sql.append("     SELECT ");
            sql.append("      " + TBTHB2KMEI.EGCD + " ");
            sql.append("     ," + TBTHB2KMEI.TKSKGYCD + " ");
            sql.append("     ," + TBTHB2KMEI.TKSBMNSEQNO + " ");
            sql.append("     ," + TBTHB2KMEI.TKSTNTSEQNO + " ");
            sql.append("     ," + TBTHB2KMEI.YYMM + " ");
            sql.append("     ," + TBTHB2KMEI.JYUTNO + " ");
            sql.append("     ," + TBTHB2KMEI.JYMEINO + " ");
            sql.append("     ," + TBTHB2KMEI.URMEINO + " ");
            sql.append("     ,SUM(" + TBTHB2KMEI.SEIGAK  + ") AS " + TBTHB2KMEI.SEIGAK );
            sql.append("     ,COUNT(*) AS DETAILCNT ");
            sql.append("     FROM ");
            sql.append("     " + TBTHB2KMEI.TBNAME + " ");
            sql.append("     WHERE ");
            sql.append("         " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' " );
            sql.append("     AND " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' " );
            sql.append("     AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' " );
            sql.append("     AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' " );
//            sql.append("     AND " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' " );
            if(_cond.getYymmTo() != null && !(_cond.getYymmTo().equals(""))){
                sql.append("     AND " + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getYymm() + "' AND '" + _cond.getYymmTo() + "' ");
            }
            else
            {
                sql.append("     AND " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' " );
            }
            sql.append("     GROUP BY ");
            sql.append("      " + TBTHB2KMEI.EGCD + " ");
            sql.append("     ," + TBTHB2KMEI.TKSKGYCD + " ");
            sql.append("     ," + TBTHB2KMEI.TKSBMNSEQNO + " ");
            sql.append("     ," + TBTHB2KMEI.TKSTNTSEQNO + " ");
            sql.append("     ," + TBTHB2KMEI.YYMM + " ");
            sql.append("     ," + TBTHB2KMEI.JYUTNO + " ");
            sql.append("     ," + TBTHB2KMEI.JYMEINO + " ");
            sql.append("     ," + TBTHB2KMEI.URMEINO + " ");
        }else if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.EPS.getCode())){
            //���Ӑ悪�G�v�\���̏ꍇ
             sql.append("     SELECT ");
             sql.append("      " + TBTHB2KMEI.EGCD + " ");
             sql.append("     ," + TBTHB2KMEI.TKSKGYCD + " ");
             sql.append("     ," + TBTHB2KMEI.TKSBMNSEQNO + " ");
             sql.append("     ," + TBTHB2KMEI.TKSTNTSEQNO + " ");
             sql.append("     ," + TBTHB2KMEI.YYMM + " ");
             sql.append("     ," + TBTHB2KMEI.JYUTNO + " ");
             sql.append("     ," + TBTHB2KMEI.JYMEINO + " ");
             sql.append("     ," + TBTHB2KMEI.URMEINO + " ");
             sql.append("     ,0 AS " + TBTHB2KMEI.SEIGAK );
             sql.append("     ,COUNT(*) AS DETAILCNT ");
             sql.append("     FROM ");
             sql.append("     " + TBTHB2KMEI.TBNAME + " ");
             sql.append("     WHERE ");
             sql.append("         " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' " );
             sql.append("     AND " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' " );
             sql.append("     AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' " );
             sql.append("     AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' " );
//             sql.append("     AND " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' " );
             if(_cond.getYymmTo() != null && !(_cond.getYymmTo().equals(""))){
                 sql.append("     AND " + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getYymm() + "' AND '" + _cond.getYymmTo() + "' ");
             }
             else
             {
                 sql.append("     AND " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' " );
             }
             sql.append("     AND " + TBTHB2KMEI.NAME21 + " = '1'" + " ");
             sql.append("     GROUP BY ");
             sql.append("      " + TBTHB2KMEI.EGCD + " ");
             sql.append("     ," + TBTHB2KMEI.TKSKGYCD + " ");
             sql.append("     ," + TBTHB2KMEI.TKSBMNSEQNO + " ");
             sql.append("     ," + TBTHB2KMEI.TKSTNTSEQNO + " ");
             sql.append("     ," + TBTHB2KMEI.YYMM + " ");
             sql.append("     ," + TBTHB2KMEI.JYUTNO + " ");
             sql.append("     ," + TBTHB2KMEI.JYMEINO + " ");
             sql.append("     ," + TBTHB2KMEI.URMEINO + " ");
        }
        else{
            //���Ӑ悪��L�ȊO�̏ꍇ
            sql.append("     SELECT ");
            sql.append("      " + TBTHB2KMEI.EGCD + " ");
            sql.append("     ," + TBTHB2KMEI.TKSKGYCD + " ");
            sql.append("     ," + TBTHB2KMEI.TKSBMNSEQNO + " ");
            sql.append("     ," + TBTHB2KMEI.TKSTNTSEQNO + " ");
            sql.append("     ," + TBTHB2KMEI.YYMM + " ");
            sql.append("     ," + TBTHB2KMEI.JYUTNO + " ");
            sql.append("     ," + TBTHB2KMEI.JYMEINO + " ");
            sql.append("     ," + TBTHB2KMEI.URMEINO + " ");
            sql.append("     ,0 AS " + TBTHB2KMEI.SEIGAK );
            sql.append("     ,COUNT(*) AS DETAILCNT ");
            sql.append("     FROM ");
            sql.append("     " + TBTHB2KMEI.TBNAME + " ");
            sql.append("     WHERE ");
            sql.append("         " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' " );
            sql.append("     AND " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' " );
            sql.append("     AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' " );
            sql.append("     AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' " );
//            sql.append("     AND " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' " );
            if(_cond.getYymmTo() != null && !(_cond.getYymmTo().equals(""))){
                sql.append("     AND " + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getYymm() + "' AND '" + _cond.getYymmTo() + "' ");
            }
            else
            {
                sql.append("     AND " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' " );
            }
            sql.append("     GROUP BY ");
            sql.append("      " + TBTHB2KMEI.EGCD + " ");
            sql.append("     ," + TBTHB2KMEI.TKSKGYCD + " ");
            sql.append("     ," + TBTHB2KMEI.TKSBMNSEQNO + " ");
            sql.append("     ," + TBTHB2KMEI.TKSTNTSEQNO + " ");
            sql.append("     ," + TBTHB2KMEI.YYMM + " ");
            sql.append("     ," + TBTHB2KMEI.JYUTNO + " ");
            sql.append("     ," + TBTHB2KMEI.JYMEINO + " ");
            sql.append("     ," + TBTHB2KMEI.URMEINO + " ");
        }
        sql.append("  ) " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" ,( ");
        sql.append(" SELECT ");
        sql.append("     ROW_NUMBER() OVER (PARTITION BY ");
        sql.append("                              " + TBTHB8DOWNR.EGCD + " ");
        sql.append("                             ," + TBTHB8DOWNR.TKSKGYCD + " ");
        sql.append("                             ," + TBTHB8DOWNR.TKSBMNSEQNO + " ");
        sql.append("                             ," + TBTHB8DOWNR.TKSTNTSEQNO + " ");
        sql.append("                             ," + TBTHB8DOWNR.JYUTNO + " ");
        sql.append("                             ," + TBTHB8DOWNR.JYMEINO + " ");
        sql.append("                             ," + TBTHB8DOWNR.URMEINO + " ");
        sql.append("                             ," + TBTHB8DOWNR.YYMM + " ");
        sql.append("                         ORDER BY ");
        sql.append("                              " + TBTHB8DOWNR.FILETIMSTMP + " DESC ");
        sql.append("                         ) as num ");
        sql.append("     ," + TBTHB8DOWNR.TBNAME + ".* ");
        sql.append(" FROM ");
        sql.append("     " + TBTHB8DOWNR.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append("     " + TBTHB8DOWNR.EGCD        + " = '" + _cond.getEgCd() + "' " );
        sql.append(" AND " + TBTHB8DOWNR.TKSKGYCD    + " = '" + _cond.getTksKgyCd() + "' " );
        sql.append(" AND " + TBTHB8DOWNR.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' " );
        sql.append(" AND " + TBTHB8DOWNR.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' " );
//        sql.append(" AND " + TBTHB8DOWNR.YYMM        + " = '" + _cond.getYymm() + "' " );
        if(_cond.getYymmTo() != null && !(_cond.getYymmTo().equals(""))){
            sql.append("     AND " + TBTHB8DOWNR.YYMM + " BETWEEN '" + _cond.getYymm() + "' AND '" + _cond.getYymmTo() + "' ");
        }
        else
        {
            sql.append(" AND " + TBTHB8DOWNR.YYMM        + " = '" + _cond.getYymm() + "' " );
        }
        sql.append(" AND " + TBTHB8DOWNR.MEITIMSTMP + "  IS NOT NULL ");
        sql.append("  ) " + TBTHB8DOWNR.TBNAME + " ");
//        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TOH.getCode())){
//        	//���Ӑ悪����̏ꍇ
//        	sql.append(" ,( ");
//        	sql.append(" SELECT ");
//        	sql.append("      " + TBTHBAMST.FIELD1 +  " ");
//        	sql.append("     , " + TBTHBAMST.FIELD2 +  " ");
//        	sql.append(" FROM ");
//        	sql.append("     " + TBTHBAMST.TBNAME + " ");
//        	sql.append(" WHERE ");
//            sql.append("         " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' " );
//            sql.append("     AND " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' " );
//            sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' " );
//            sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' " );
//            sql.append("     AND " + TBTHBAMST.SYBT + " = '102'" + " " );
//            sql.append("  ) THBAMST1 ");
//
//        }
        //2013/03/06 jse okazaki �����Ή��@Start
        // 2015/04/01 �������Ӑ�ύX�Ή� Fujisaki Cng Start
        //if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN.getCode())){
        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN.getCode())
        || (_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN_2015.getCode())){
        // 2015/04/01 �������Ӑ�ύX�Ή� Fujisaki Cng End

            sql.append(" ,( ");
            sql.append("     SELECT ");
            sql.append("      " + TBTHB14SKDOWN.EGCD + " ");
            sql.append("     ," + TBTHB14SKDOWN.TKSKGYCD + " ");
            sql.append("     ," + TBTHB14SKDOWN.TKSBMNSEQNO + " ");
            sql.append("     ," + TBTHB14SKDOWN.TKSTNTSEQNO + " ");
            sql.append("     ," + TBTHB14SKDOWN.SEIYYMM + " ");
            sql.append("     ," + TBTHB14SKDOWN.JYUTNO + " ");
            sql.append("     ," + TBTHB14SKDOWN.JYMEINO + " ");
            sql.append("     ," + TBTHB14SKDOWN.URMEINO + " ");
            sql.append("     FROM ");
            sql.append("     " + TBTHB14SKDOWN.TBNAME + " ");
            sql.append("     WHERE ");
            sql.append("         " + TBTHB14SKDOWN.EGCD + " = '" + _cond.getEgCd() + "' " );
            sql.append("     AND " + TBTHB14SKDOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' " );
            sql.append("     AND " + TBTHB14SKDOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' " );
            sql.append("     AND " + TBTHB14SKDOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' " );
            if(_cond.getYymmTo() != null && !(_cond.getYymmTo().equals(""))){
                sql.append("     AND " + TBTHB14SKDOWN.SEIYYMM + " BETWEEN '" + _cond.getYymm() + "' AND '" + _cond.getYymmTo() + "' ");
            }
            else
            {
                sql.append(" AND " + TBTHB14SKDOWN.SEIYYMM        + " = '" + _cond.getYymm() + "' " );
            }
            //2013/11/07 add �s��Ή��@�X�e�[�^�X�ǉ� start
            sql.append(" AND " + TBTHB14SKDOWN.SEISTATUS  + " = '2' " );
           //2013/11/07 add �s��Ή��@�X�e�[�^�X�ǉ� end
            sql.append("  ) " + TBTHB14SKDOWN.TBNAME + " ");
        }
        //2013/03/06 jse okazaki �����Ή��@End
        //=================================================================================================================================================================
        //WHERE��
        //=================================================================================================================================================================
        sql.append(" WHERE ");
        sql.append("     " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' " );
        sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' " );
        sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' " );
        sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' " );
//        sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' " );
        if(_cond.getYymmTo() != null && !(_cond.getYymmTo().equals(""))){
            sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMM + " BETWEEN '" + _cond.getYymm() + "' AND '" + _cond.getYymmTo() + "' ");
        }
        else
        {
            sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' " );
        }
        sql.append(" AND " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.EGCD + " " );
        sql.append(" AND " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSKGYCD + " " );
        sql.append(" AND " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSBMNSEQNO + " " );
        sql.append(" AND " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSTNTSEQNO + " " );
        sql.append(" AND " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMM + " " );
        sql.append(" AND " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO + " " );
        sql.append(" AND " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYMEINO + " " );
        sql.append(" AND " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.URMEINO + " " );
        //�e�r���[�ɕ\������f�[�^(������or������)���擾��������Ǝq�r���[�ɕ\������f�[�^(������)�ŏ����𕪂���-------------------------------------
        sql.append(" AND ( " );
        //������or�������R�[�h���擾�������-------------------------------------------------------------------------------
        sql.append("         ( " );
        sql.append(" " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TJYUTNO + " = ' ' " );
        if(_cond.getKokKbn() != null && !(_cond.getKokKbn().equals(""))){
            sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.KOKKBN + " = '" + _cond.getKokKbn() + "' " );
        }
        if(_cond.getTmspKbn() != null && !(_cond.getTmspKbn().equals(""))){
            sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TMSPKBN + " = '" + _cond.getTmspKbn() + "' " );
        }
        if(_cond.getGyomKbn() != null && !(_cond.getGyomKbn().equals(""))){
            sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + " = '" + _cond.getGyomKbn() + "' " );
        }
        if(_cond.getJyutNo() != null && !(_cond.getJyutNo().equals(""))){
            sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO + " LIKE '" + _cond.getJyutNo() + "%' " );
        }
        //�����Ō���(2013/01/08�ǉ��Ή�)
        if(_cond.getKkNameKj() != null && !(_cond.getKkNameKj().equals(""))){
            sql.append(" AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.KKNAMEKJ + " LIKE '%" + _cond.getKkNameKj() + "%' " );
        }
        sql.append("         ) " );
        //-----------------------------------------------------------------------------------------------------------------
        sql.append("         OR " );
        //���������R�[�h���擾�������-------------------------------------------------------------------------------------
        sql.append("         ( " );
        sql.append("             EXISTS ( " );
        sql.append("                 SELECT " );
        sql.append("                     TOGO_SAKI." + TBTHB1DOWN.EGCD );
        sql.append("                 FROM " );
        sql.append("                     " + TBTHB1DOWN.TBNAME + " TOGO_SAKI " );
        sql.append("                 WHERE " );
        sql.append("                     " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.EGCD        + " = TOGO_SAKI." + TBTHB1DOWN.EGCD + " ");
        sql.append("                 AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSKGYCD    + "= TOGO_SAKI." + TBTHB1DOWN.TKSKGYCD + " ");
        sql.append("                 AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSBMNSEQNO + "= TOGO_SAKI." + TBTHB1DOWN.TKSBMNSEQNO + " ");
        sql.append("                 AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSTNTSEQNO + "= TOGO_SAKI." + TBTHB1DOWN.TKSTNTSEQNO + " ");
        sql.append("                 AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMM        + "= TOGO_SAKI." + TBTHB1DOWN.YYMM + " ");
        sql.append("                 AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TJYUTNO     + "= TOGO_SAKI." + TBTHB1DOWN.JYUTNO + " ");
        sql.append("                 AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TJYMEINO    + "= TOGO_SAKI." + TBTHB1DOWN.JYMEINO + " ");
        sql.append("                 AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TURMEINO    + "= TOGO_SAKI." + TBTHB1DOWN.URMEINO + " ");
        sql.append("                 AND TOGO_SAKI." + TBTHB1DOWN.TJYUTNO + " = ' ' " );
        if(_cond.getKokKbn() != null && !(_cond.getKokKbn().equals(""))){
            sql.append("                 AND TOGO_SAKI." + TBTHB1DOWN.KOKKBN + " = '" + _cond.getKokKbn() + "' " );
        }
        if(_cond.getTmspKbn() != null && !(_cond.getTmspKbn().equals(""))){
            sql.append("                 AND TOGO_SAKI." + TBTHB1DOWN.TMSPKBN + " = '" + _cond.getTmspKbn() + "' " );
        }
        if(_cond.getGyomKbn() != null && !(_cond.getGyomKbn().equals(""))){
            sql.append("                 AND TOGO_SAKI." + TBTHB1DOWN.GYOMKBN + " = '" + _cond.getGyomKbn() + "' " );
        }
        if(_cond.getJyutNo() != null && !(_cond.getJyutNo().equals(""))){
            sql.append("                 AND TOGO_SAKI." + TBTHB1DOWN.JYUTNO + " LIKE '" + _cond.getJyutNo() + "%' " );
        }
        //�����Ō���(2013/01/08�ǉ��Ή�)
        if(_cond.getKkNameKj() != null && !(_cond.getKkNameKj().equals(""))){
            sql.append("                 AND TOGO_SAKI." + TBTHB1DOWN.KKNAMEKJ + " LIKE '%" + _cond.getKkNameKj() + "%' " );
        }
        sql.append("             ) " );
        sql.append("         ) " );
        //-----------------------------------------------------------------------------------------------------------------
        sql.append("    ) " );
        sql.append(" AND " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.EGCD        + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.EGCD          + " ");
        sql.append(" AND " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.TKSKGYCD    + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSKGYCD      + " ");
        sql.append(" AND " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.TKSBMNSEQNO + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSBMNSEQNO   + " ");
        sql.append(" AND " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.TKSTNTSEQNO + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSTNTSEQNO   + " ");
        sql.append(" AND " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.JYUTNO      + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO        + " ");
        sql.append(" AND " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.JYMEINO     + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYMEINO       + " ");
        sql.append(" AND " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.URMEINO     + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.URMEINO       + " ");
        sql.append(" AND " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.YYMM        + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMM          + " ");
//      sql.append(" AND " + TBTHB8DOWNR.TBNAME + "." + TBTHB8DOWNR.TOUFLG      + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TOUFLG        + " ");
        sql.append(" AND " + TBTHB8DOWNR.TBNAME + ".NUM(+) = 1 ");                       // --�ŐV�̗����f�[�^�̂ݎ擾
//        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TOH.getCode())){
//        	//���Ӑ悪����̏ꍇ
//        	sql.append("                 AND TRIM(" + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD11    + ") = THBAMST1." + TBTHBAMST.FIELD1+ " (+) ");
//        }

        // 2015/06/11 ����A�h�Ή� Soga MOD Start
        // ����_���דo�^�󒍈ꗗ�@�\�g���Ή�
//        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TOH.getCode())){
        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TOH.getCode()) ||
                (_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TOHAD.getCode())){
        // 2015/06/11 ����A�h�Ή� Soga MOD End

        //���Ӑ悪����A����A�h�̏ꍇ
        //�����󒍔ԍ��̃f�[�^���������ɑ��݂���ꍇ�A���̌��Ő����ς݂ł���Ɠ����̃f�[�^�͕\�����Ȃ�
        //�������A���̌��������ς݂ł����Ă��A�����̃f�[�^�������f�[�^�̏ꍇ�͕\������B���ׂ��o�^�\�B�i�^�p��L�蓾�Ȃ����߁j
            sql.append(" AND ");
            sql.append(" NOT EXISTS (   ");
            sql.append("    SELECT      ");
            sql.append("            *   ");
            sql.append("    FROM        ");
            sql.append("        " + TBTHB1DOWN.TBNAME + " CHG_YYMM ");
            sql.append("    WHERE       ");
            sql.append("            " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.EGCD           + " = CHG_YYMM." + TBTHB1DOWN.EGCD           + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSKGYCD       + " = CHG_YYMM." + TBTHB1DOWN.TKSKGYCD       + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSBMNSEQNO    + " = CHG_YYMM." + TBTHB1DOWN.TKSBMNSEQNO    + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSTNTSEQNO    + " = CHG_YYMM." + TBTHB1DOWN.TKSTNTSEQNO    + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMM           + " <> CHG_YYMM."+ TBTHB1DOWN.YYMM           + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO         + " = CHG_YYMM." + TBTHB1DOWN.JYUTNO         + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYMEINO        + " = CHG_YYMM." + TBTHB1DOWN.JYMEINO        + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.URMEINO        + " = CHG_YYMM." + TBTHB1DOWN.URMEINO        + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TOUFLG         + " <> '1'                                       ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TJYUTNO        + " = ' '                                        ");
            sql.append("        AND " + " TRIM( " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TRKTNTNM + " ) IS NULL                              ");
            sql.append("        AND " + " CHG_YYMM." + TBTHB1DOWN.TJYUTNO + " = ' '                                                          ");
            sql.append("        AND " + " TRIM( " + " CHG_YYMM." + TBTHB1DOWN.TRKTNTNM + " ) IS NOT NULL                                     ");
            sql.append(" )              ");
            sql.append(" AND            ");
            sql.append(" NOT EXISTS (   ");
            sql.append("    SELECT      ");
            sql.append("        *       ");
            sql.append("    FROM        ");
            sql.append("        " + TBTHB1DOWN.TBNAME + " CHG_YYMM, ");
            sql.append("        " + TBTHB1DOWN.TBNAME + " CHG_YYMM_TOGO ");
            sql.append("    WHERE       ");
            sql.append("            " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.EGCD           + " = CHG_YYMM." + TBTHB1DOWN.EGCD           + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSKGYCD       + " = CHG_YYMM." + TBTHB1DOWN.TKSKGYCD       + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSBMNSEQNO    + " = CHG_YYMM." + TBTHB1DOWN.TKSBMNSEQNO    + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSTNTSEQNO    + " = CHG_YYMM." + TBTHB1DOWN.TKSTNTSEQNO    + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMM           + " <> CHG_YYMM."+ TBTHB1DOWN.YYMM           + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO         + " = CHG_YYMM." + TBTHB1DOWN.JYUTNO         + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYMEINO        + " = CHG_YYMM." + TBTHB1DOWN.JYMEINO        + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.URMEINO        + " = CHG_YYMM." + TBTHB1DOWN.URMEINO        + " ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TOUFLG         + " <> '1'                                       ");
            sql.append("        AND " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TJYUTNO        + " = ' '                                        ");
            sql.append("        AND " + " TRIM( " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TRKTNTNM + " ) IS NULL                              ");
            sql.append("        AND " + " CHG_YYMM." + TBTHB1DOWN.TJYUTNO        + " <> ' '                                                  ");
            sql.append("        AND " + " CHG_YYMM_TOGO." + TBTHB1DOWN.EGCD           + " = CHG_YYMM." + TBTHB1DOWN.EGCD                 + " ");
            sql.append("        AND " + " CHG_YYMM_TOGO." + TBTHB1DOWN.TKSKGYCD       + " = CHG_YYMM." + TBTHB1DOWN.TKSKGYCD             + " ");
            sql.append("        AND " + " CHG_YYMM_TOGO." + TBTHB1DOWN.TKSBMNSEQNO    + " = CHG_YYMM." + TBTHB1DOWN.TKSBMNSEQNO          + " ");
            sql.append("        AND " + " CHG_YYMM_TOGO." + TBTHB1DOWN.TKSTNTSEQNO    + " = CHG_YYMM." + TBTHB1DOWN.TKSTNTSEQNO          + " ");
            sql.append("        AND " + " CHG_YYMM_TOGO." + TBTHB1DOWN.YYMM           + " = CHG_YYMM." + TBTHB1DOWN.YYMM                 + " ");
            sql.append("        AND " + " CHG_YYMM_TOGO." + TBTHB1DOWN.JYUTNO         + " = CHG_YYMM." + TBTHB1DOWN.TJYUTNO              + " ");
            sql.append("        AND " + " CHG_YYMM_TOGO." + TBTHB1DOWN.JYMEINO        + " = CHG_YYMM." + TBTHB1DOWN.TJYMEINO             + " ");
            sql.append("        AND " + " CHG_YYMM_TOGO." + TBTHB1DOWN.URMEINO        + " = CHG_YYMM." + TBTHB1DOWN.TURMEINO             + " ");
            sql.append("        AND " + " TRIM( " + " CHG_YYMM_TOGO." + TBTHB1DOWN.TRKTNTNM + " ) IS NOT NULL                                ");
            sql.append(" )              ");
        }
        //2013/03/06 jse okazaki �����Ή��@Start
        // 2015/04/01 �������Ӑ�ύX�Ή� Fujisaki Cng Start
        //if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN.getCode())){
        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN.getCode())
        || (_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN_2015.getCode())){
        // 2015/04/01 �������Ӑ�ύX�Ή� Fujisaki Cng End
            sql.append(" AND " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.EGCD        + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.EGCD          + " ");
            sql.append(" AND " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSKGYCD    + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSKGYCD      + " ");
            sql.append(" AND " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSBMNSEQNO + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSBMNSEQNO   + " ");
            sql.append(" AND " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSTNTSEQNO + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.TKSTNTSEQNO   + " ");
            sql.append(" AND " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIYYMM     + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.YYMM          + " ");
            sql.append(" AND " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.JYUTNO      + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO        + " ");
            sql.append(" AND " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.JYMEINO     + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYMEINO       + " ");
            sql.append(" AND " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.URMEINO     + "(+) = " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.URMEINO       + " ");
        }
        //2013/03/06 jse okazaki �����Ή��@End

        //------------------------------------------------------------------------------------------------------------------------------------------------
        //=================================================================================================================================================================
        //Order��
        //=================================================================================================================================================================
        sql.append(" ORDER BY ");
        //if(_cond.getTksKgyCd().equals("385504")){
        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TKD.getCode())){
            //���Ӑ悪���c�̏ꍇ
            sql.append("  GYOMBAN " );
            sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO + " ");
            sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYMEINO + " ");
            sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.URMEINO + " ");
        //}else if (_cond.getTksKgyCd().equals("400702")){

        // 2015/06/11 ����A�h�Ή� Soga MOD Start
//        } else if ((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TOH.getCode())){
        } else if ((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TOH.getCode()) ||
                (_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TOHAD.getCode())){
        // 2015/06/11 ����A�h�Ή� Soga MOD End

            //���Ӑ悪����A����A�h�̏ꍇ
            if(_cond.getOrderKbn().equals("1")){
                //�}�̏��̏ꍇ
                sql.append("  " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD1 + " " );
                sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD3 + " ");
                sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + " " );
                sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO + " ");
                sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYMEINO + " ");
                sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.URMEINO + " ");
            }else{
                //�������̏ꍇ
                sql.append("  " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.KKNAMEKJ + " " );
                sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.FIELD1 + " ");
                sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + " " );
                sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO + " ");
                sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYMEINO + " ");
                sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.URMEINO + " ");
            }
        }else{
            //��L�ȊO�̓��Ӑ�
            sql.append("  " + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.GYOMKBN + " " );
            sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYUTNO + " ");
            sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.JYMEINO + " ");
            sql.append(" ," + TBTHB1DOWN.TBNAME + "." + TBTHB1DOWN.URMEINO + " ");
        }


        return sql.toString();
    }


    /**
     * �󒍃f�[�^�̌������s���܂��B
     *
     * @return �󒍃f�[�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<JyutyuDataVO> findJyutyuDataCOMMONByCondition(JyutyuDataCondition cond) throws KKHException {

        super.setModel(new JyutyuDataVO());

        try {
            _cond = cond;
//            _sqlMode = SqlMode.COMMON;
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
     * @return List<CommonCodeJyutyuDataVO> �ϊ���̌�������
     */
    @Override
    protected List<JyutyuDataVO> createFindedModelInstances(List hashList) {
        List<JyutyuDataVO> list = new ArrayList<JyutyuDataVO>();
        if (getModel() instanceof JyutyuDataVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                JyutyuDataVO vo = new JyutyuDataVO();
                vo.setRowNum(((BigDecimal)result.get("ROWNUM")).intValue());
                if (result.get(TBTHB1DOWN.TRKTIMSTMP.toUpperCase()) instanceof DummyNull) {
                    vo.setHb1TrkTimStmp(null);
                } else {
                    vo.setHb1TrkTimStmp((Date)result.get(TBTHB1DOWN.TRKTIMSTMP.toUpperCase()));
                }
                vo.setHb1TrkApl((String)result.get(TBTHB1DOWN.TRKAPL.toUpperCase()));
                vo.setHb1TrkTnt((String)result.get(TBTHB1DOWN.TRKTNT.toUpperCase()));
                vo.setHb1TrkTntNm((String)result.get(TBTHB1DOWN.TRKTNTNM.toUpperCase()));
                if(result.get(TBTHB1DOWN.KSNTIMSTMP.toUpperCase()) instanceof DummyNull)
                {
                    vo.setHb1KsnTimStmp(null);
                }else{
                    vo.setHb1KsnTimStmp((Date)result.get(TBTHB1DOWN.KSNTIMSTMP.toUpperCase()));
                }
                vo.setHb1KsnTnt((String)result.get(TBTHB1DOWN.KSNTNT.toUpperCase()));
                vo.setHb1KsnTntNm((String)result.get(TBTHB1DOWN.KSNTNTNM.toUpperCase()));
                vo.setHb1TimStmp((Date)result.get(TBTHB1DOWN.TIMSTMP.toUpperCase()));
                vo.setHb1UpdApl((String)result.get(TBTHB1DOWN.UPDAPL.toUpperCase()));
                vo.setHb1UpdTnt((String)result.get(TBTHB1DOWN.UPDTNT.toUpperCase()));
                vo.setHb1AtuEgCd((String)result.get(TBTHB1DOWN.ATUEGCD.toUpperCase()));
                vo.setHb1EgCd((String)result.get(TBTHB1DOWN.EGCD.toUpperCase()));
                vo.setHb1TksKgyCd((String)result.get(TBTHB1DOWN.TKSKGYCD.toUpperCase()));
                vo.setHb1TksBmnSeqNo((String)result.get(TBTHB1DOWN.TKSBMNSEQNO.toUpperCase()));
                vo.setHb1TksTntSeqNo((String)result.get(TBTHB1DOWN.TKSTNTSEQNO.toUpperCase()));
                vo.setHb1JyutNo((String)result.get(TBTHB1DOWN.JYUTNO.toUpperCase()));
                vo.setHb1JyMeiNo((String)result.get(TBTHB1DOWN.JYMEINO.toUpperCase()));
                vo.setHb1UrMeiNo((String)result.get(TBTHB1DOWN.URMEINO.toUpperCase()));
                vo.setHb1GpyNo((String)result.get(TBTHB1DOWN.GPYNO.toUpperCase()));
                vo.setHb1GpyoPag((String)result.get(TBTHB1DOWN.GPYOPAG.toUpperCase()));
                vo.setHb1SeiNo((String)result.get(TBTHB1DOWN.SEINO.toUpperCase()));
                vo.setHb1HimkCd((String)result.get(TBTHB1DOWN.HIMKCD.toUpperCase()));
                vo.setHb1TouFlg((String)result.get(TBTHB1DOWN.TOUFLG.toUpperCase()));
                vo.setHb1Yymm((String)result.get(TBTHB1DOWN.YYMM.toUpperCase()));
                vo.setHb1GyomKbn((String)result.get(TBTHB1DOWN.GYOMKBN.toUpperCase()));
                vo.setHb1MsKbn((String)result.get(TBTHB1DOWN.MSKBN.toUpperCase()));
                vo.setHb1TmspKbn((String)result.get(TBTHB1DOWN.TMSPKBN.toUpperCase()));
                vo.setHb1KokKbn((String)result.get(TBTHB1DOWN.KOKKBN.toUpperCase()));
                vo.setHb1SeiKbn((String)result.get(TBTHB1DOWN.SEIKBN.toUpperCase()));
                vo.setHb1SyoNo((String)result.get(TBTHB1DOWN.SYONO.toUpperCase()));
                vo.setHb1KKNameKJ((String)result.get(TBTHB1DOWN.KKNAMEKJ.toUpperCase()));
                vo.setHb1EgGamenType((String)result.get(TBTHB1DOWN.EGGAMENTYPE.toUpperCase()));
                vo.setHb1KkakShanKbn((String)result.get(TBTHB1DOWN.KKAKSHANKBN.toUpperCase()));
                vo.setHb1ToriGak((BigDecimal)result.get(TBTHB1DOWN.TORIGAK.toUpperCase()));
                vo.setHb1SeiTnka((BigDecimal)result.get(TBTHB1DOWN.SEITNKA.toUpperCase()));
                vo.setHb1SeiGak((BigDecimal)result.get(TBTHB1DOWN.SEIGAK.toUpperCase()));
                vo.setHb1NeviRitu((BigDecimal)result.get(TBTHB1DOWN.NEBIRITU.toUpperCase()));
                vo.setHb1NeviGak((BigDecimal)result.get(TBTHB1DOWN.NEBIGAK.toUpperCase()));
                vo.setHb1SzeiKbn((String)result.get(TBTHB1DOWN.SZEIKBN.toUpperCase()));
                vo.setHb1SzeiRitu((BigDecimal)result.get(TBTHB1DOWN.SZEIRITU.toUpperCase()));
                vo.setHb1SzeiGak((BigDecimal)result.get(TBTHB1DOWN.SZEIGAK.toUpperCase()));
                vo.setHb1HimkNmKJ((String)result.get(TBTHB1DOWN.HIMKNMKJ.toUpperCase()));
                vo.setHb1HimkNmKN((String)result.get(TBTHB1DOWN.HIMKNMKN.toUpperCase()));
                vo.setHb1TJyutNo((String)result.get(TBTHB1DOWN.TJYUTNO.toUpperCase()));
                vo.setHb1TJyMeiNo((String)result.get(TBTHB1DOWN.TJYMEINO.toUpperCase()));
                vo.setHb1TUrMeiNo((String)result.get(TBTHB1DOWN.TURMEINO.toUpperCase()));
                vo.setHb1MSeiFlg((String)result.get(TBTHB1DOWN.MSEIFLG.toUpperCase()));
                vo.setHb1YymmOld((String)result.get(TBTHB1DOWN.YYMMOLD.toUpperCase()));
                vo.setHb1Field1((String)result.get(TBTHB1DOWN.FIELD1.toUpperCase()));
                vo.setHb1Field2((String)result.get(TBTHB1DOWN.FIELD2.toUpperCase()));
                vo.setHb1Field3((String)result.get(TBTHB1DOWN.FIELD3.toUpperCase()));
                vo.setHb1Field4((String)result.get(TBTHB1DOWN.FIELD4.toUpperCase()));
                vo.setHb1Field5((String)result.get(TBTHB1DOWN.FIELD5.toUpperCase()));
                vo.setHb1Field6((String)result.get(TBTHB1DOWN.FIELD6.toUpperCase()));
                vo.setHb1Field7((String)result.get(TBTHB1DOWN.FIELD7.toUpperCase()));
                vo.setHb1Field8((String)result.get(TBTHB1DOWN.FIELD8.toUpperCase()));
                vo.setHb1Field9((String)result.get(TBTHB1DOWN.FIELD9.toUpperCase()));
                vo.setHb1Field10((String)result.get(TBTHB1DOWN.FIELD10.toUpperCase()));
                vo.setHb1Field11((String)result.get(TBTHB1DOWN.FIELD11.toUpperCase()));
                vo.setHb1Field12((String)result.get(TBTHB1DOWN.FIELD12.toUpperCase()));
                vo.setHb2JyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                vo.setHb2SeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setGyomBan((String)result.get("GYOMBAN"));
                vo.setDetailCnt((BigDecimal)result.get("DETAILCNT"));
                vo.setHb1FileTimStmp((String)result.get(TBTHB1DOWN.FILETIMSTMP.toUpperCase()));
                vo.setRMeiTimStmp((String)result.get(TBTHB8DOWNR.MEITIMSTMP));
                vo.setJyutDelFlg((String)result.get(TBTHB1DOWN.JYUTDELFLG.toUpperCase()));
//                if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.TOH.getCode())){
//                	vo.setSpace2((String)result.get("SPACE2"));
//                }
                // �������ʒ���̏�Ԃɂ���
                //2013/03/06 jse okazaki �����Ή��@Start
                // 2015/04/01 �������Ӑ�ύX�Ή� Fujisaki Cng Start
                //if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN.getCode())){
                if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN.getCode())
                || (_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.KMN_2015.getCode())){
                // 2015/04/01 �������Ӑ�ύX�Ή� Fujisaki Cng End
                	vo.setSeikyu((String)result.get(TBTHB14SKDOWN.JYUTNO.toUpperCase()));
                } else {
                    vo.setSeikyu("");
                }
                //2013/03/06 jse okazaki �����Ή��@End
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
