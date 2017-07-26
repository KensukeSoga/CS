package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.constants.KKHConstants;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 * <P>
 * ���[(MAC)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/12 fourm h.izawa)<BR>
 * �E�A�T�q����őΉ�(2016/11/22 HLC K.Soga)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^�������� */
    private ReportAshMediaCondition _cond;

    private boolean _flg;

    /** �f�t�H���g�R���X�g���N�^ */
    public ReportAshMediaDAO() {
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

        if(_flg == true){
            return new String[]{
                "max("+TBTHB2KMEI.NAME3 + ") NAME33",
                "MIN("+TBTHB2KMEI.NAME2 + ") NAME2",
                "min("+TBTHB2KMEI.NAME2 + ") HIMKNMKJ",
                "sum(round("+ TBTHB2KMEI.SEIGAK + ")) SEIGAK",
                /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
                "sum(round("+ TBTHB2KMEI.NEBIGAK + ")) NEBIKIGAKU",
                /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
                /** 2013/01/17 JSE M.Naito DEL Start */
                //"min("+TBTHB2KMEI.NAME8 + ") KKNAMEKJ",
                /** 2013/01/17 JSE M.Naito DEL End */
                "min("+TBTHB2KMEI.NAME10 + ") KKNAMEKJ",
                "min("+TBTHB2KMEI.JYUTNO + ") JYUTNO2",
                "min("+TBTHB2KMEI.URMEINO + ") URMEINO2",
                "min("+TBTHB2KMEI.JYMEINO + ") JYMEINO2",
                "MAX("+TBTHB2KMEI.SONOTA2 + ") SONOTA2",
                "MIN("+TBTHB2KMEI.RENBN + ") RENBAN2",
                "max("+TBTHB2KMEI.HNNERT + ") HNNERT",
                "sum("+TBTHB2KMEI.HNMAEGAK + ") HNMAEGAK",
                "MAX("+TBTHB2KMEI.RITU1 + ") RITU1",
                TBTHB2KMEI.CODE1+" CODE1",
                "min("+TBTHB2KMEI.CODE3 + ") CODE3",
                "MIN("+TBTHB2KMEI.SONOTA10 +") SONOTA10",
                "MIN("+TBTHB2KMEI.NAME5 + ") NAME5",
                "min("+TBTHB2KMEI.SONOTA3 +") SONOTA3",
                "min("+TBTHB2KMEI.SONOTA5 + ") SONOTA5",
                "min("+TBTHB2KMEI.SONOTA6 + ") SONOTA6",
                "min("+TBTHB2KMEI.CODE2 + ") CODE2",
                "min("+TBTHB2KMEI.CODE6 +") CODE6",
                "min("+TBTHB2KMEI.NAME1 +") NAME1",
                "min("+TBTHB2KMEI.NAME6 + ") NAME6",
                "min("+TBTHB2KMEI.NAME9 + ") NAME9",
                /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
                "sum(round("+ TBTHB2KMEI.KNGK1 + ")) KNGK1",
                /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
                "min("+TBTHB2KMEI.SONOTA7 + ") SONOTA7",
                "min("+TBTHB2KMEI.SONOTA8 + ") SONOTA8"
            };
        }else{
            return new String[]{
                    "max("+TBTHB2KMEI.NAME3 + ") NAME33",
                    "MIN("+TBTHB2KMEI.NAME2 + ") NAME2",
                    "min("+TBTHB2KMEI.NAME2 + ") HIMKNMKJ",
                    "sum(round("+ TBTHB2KMEI.SEIGAK + ")) SEIGAK",
                    /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
                    "sum(round("+ TBTHB2KMEI.NEBIGAK + ")) NEBIKIGAKU",
                    /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
                    /** 2013/01/17 JSE M.Naito DEL Start */
                    //"min("+TBTHB2KMEI.NAME8 + ") KKNAMEKJ",
                    /** 2013/01/17 JSE M.Naito DEL End */
                    "min("+TBTHB2KMEI.NAME10 + ") KKNAMEKJ",
                    "min("+TBTHB2KMEI.JYUTNO + ") JYUTNO2",
                    "min("+TBTHB2KMEI.URMEINO + ") URMEINO2",
                    "min("+TBTHB2KMEI.JYMEINO + ") JYMEINO2",
                    "MAX("+TBTHB2KMEI.SONOTA2 + ") SONOTA2",
                    "MIN("+TBTHB2KMEI.RENBN + ") RENBAN2",
                    "max("+TBTHB2KMEI.HNNERT + ") HNNERT",
                    "sum("+TBTHB2KMEI.HNMAEGAK + ") HNMAEGAK",
                    TBTHB2KMEI.RITU1+" RITU1",
                    TBTHB2KMEI.CODE1+" CODE1",
                    "min("+TBTHB2KMEI.CODE3 + ") CODE3",
                    "MIN("+TBTHB2KMEI.SONOTA10 +") SONOTA10",
                    "MIN("+TBTHB2KMEI.NAME5 + ") NAME5",
                    "min("+TBTHB2KMEI.SONOTA3 +") SONOTA3",
                    "min("+TBTHB2KMEI.SONOTA5 + ") SONOTA5",
                    "min("+TBTHB2KMEI.SONOTA6 + ") SONOTA6",
                    "min("+TBTHB2KMEI.CODE2 + ") CODE2",
                    "min("+TBTHB2KMEI.CODE6 +") CODE6",
                    "min("+TBTHB2KMEI.NAME1 +") NAME1",
                    "min("+TBTHB2KMEI.NAME6 + ") NAME6",
                    "min("+TBTHB2KMEI.NAME9 + ") NAME9",
                    /** 2016/11/22 HLC �A�T�q����őΉ� K.Soga ADD Start */
                    "sum(round("+ TBTHB2KMEI.KNGK1 + ")) KNGK1",
                    /** 2016/11/22 HLC �A�T�q����őΉ� K.Soga ADD End */
                    "min("+TBTHB2KMEI.SONOTA7 + ") SONOTA7",
                    "min("+TBTHB2KMEI.SONOTA8 + ") SONOTA8"
            };
        }
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

        sql.append("(SELECT ");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i] + " ");
            }else{
                sql.append(" ," + getTableColumnNames()[i] + " ");
            }
        }

        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' AND");
        /** 2015/06/08 �A�T�q�Ή� HLC K.Fujisaki MOD Start */
        //sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('100','120','230','240')");
        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.ASH.getCode())){
            // �A�T�q�r�[���̏ꍇ�A�e���r�l�b�g�X�|�b�g��ΏۂƂ���
            sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('100','120','230','240','105') AND");
        }else{
            sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('100','120','230','240') AND");
        }
        /** 2015/06/08 �A�T�q�Ή� HLC K.Fujisaki MOD End */
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO);

        sql.append(" GROUP BY");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        /** 2013/11/26 ����őΉ� HLC H.Watabe ADD Start */
        if(_flg == false){
            sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        }
        /** 2013/11/26 ����őΉ� HLC H.Watabe ADD End */
        sql.append(" " + TBTHB2KMEI.CODE1 + ")");

        sql.append(" UNION (SELECT ");
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i] + " ");
            }else{
                sql.append(" ," + getTableColumnNames()[i] + " ");
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('117','118') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO);

        sql.append(" GROUP BY");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        /** 2013/11/26 ����őΉ� HLC H.Watabe ADD Start */
        if(_flg == false){
            sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        }
        /** 2013/11/26 ����őΉ� HLC H.Watabe ADD End */
        sql.append(" " + TBTHB2KMEI.CODE1 + ")");

        sql.append(" UNION (SELECT");
        //�S���ڂ��擾
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        /** 2013/01/17 JSE M.Naito DEL Start*/
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('110','130') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");

        sql.append(" UNION (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + "= '125' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");

        sql.append(" UNION (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('170') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");

        sql.append(" UNION (SELECT");
        /** 2013/02/22 PR�}�̒ǉ��Ή� JSE Okazaki ADD Start */
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('119') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");
        /** 2013/02/22 PR�}�̒ǉ��Ή� JSE Okazaki ADD End */

        sql.append(" UNION (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('150') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");

        sql.append(" UNION (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('115') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");

        sql.append(" UNION (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('116') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");

        sql.append(" UNION (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('190') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");

        /** 2015/03/02 �A�T�q�Ή� JSE K.Miyanoue ADD Start */
        sql.append(" UNION (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        if((_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo()).equals(KKHConstants.TksKgyCode.ASH.getCode())){
            /** 2015/06/08 �A�T�q�Ή� HLC K.Fujisaki MOD Start */
            //sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('193','194','199')");
            // UNION�Ώۂ̔}�̃R�[�h�ȊO�̔}�̃R�[�h�͑S�đΏۂƂ���
            sql.append(" " + TBTHB2KMEI.CODE1 + " NOT IN ('100','105','110','130','140','120','150','170','119','160','180','230','240','190','115','116','117','118','195') AND");
            /** 2015/06/08 �A�T�q�Ή� HLC K.Fujisaki MOD End */
        }else{
            sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('321','322','331','332','333','334','336','380','382','389') AND");
        }
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");
        /** 2015/03/02 �A�T�q�Ή� JSE K.Miyanoue ADD End */

        sql.append(" UNION (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('140') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");

        sql.append(" UNION (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('160','180') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' )");

        sql.append(" UNION (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME3 +" NAME33,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" NAME2,");
        sql.append(" " + TBTHB2KMEI.NAME2 +" HIMKNMKJ,");
        sql.append(" " + TBTHB2KMEI.SEIGAK +" SEIGAK,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.NEBIGAK +" NEBIKIGAKU,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga ADD End */
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 +" KKNAMEKJ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO +" JYUTNO2,");
        sql.append(" " + TBTHB2KMEI.URMEINO +" URMEINO2,");
        sql.append(" " + TBTHB2KMEI.JYMEINO +" JYMEINO2,");
        sql.append(" " + TBTHB2KMEI.SONOTA2 +" SONOTA2,");
        sql.append(" " + TBTHB2KMEI.RENBN +" RENBAN2,");
        sql.append(" " + TBTHB2KMEI.HNNERT +" HNNERT,");
        sql.append(" " + TBTHB2KMEI.HNMAEGAK +" HNMAEGAK,");
        sql.append(" " + TBTHB2KMEI.RITU1 +" RITU1,");
        sql.append(" " + TBTHB2KMEI.CODE1 +" CODE1,");
        sql.append(" " + TBTHB2KMEI.CODE3 +" CODE3,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 +" SONOTA10,");
        sql.append(" " + TBTHB2KMEI.NAME5 +" NAME5,");
        sql.append(" " + TBTHB2KMEI.SONOTA3 +" SONOTA3,");
        sql.append(" " + TBTHB2KMEI.SONOTA5 +" SONOTA5,");
        sql.append(" " + TBTHB2KMEI.SONOTA6 +" SONOTA6,");
        sql.append(" " + TBTHB2KMEI.CODE2 +" CODE2,");
        sql.append(" " + TBTHB2KMEI.CODE6 +" CODE6,");
        sql.append(" " + TBTHB2KMEI.NAME1 +" NAME1,");
        sql.append(" " + TBTHB2KMEI.NAME6 +" NAME6,");
        sql.append(" " + TBTHB2KMEI.NAME9 +" NAME9,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
        sql.append(" " + TBTHB2KMEI.KNGK1 +" KNGK1,");
        /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */
        sql.append(" " + TBTHB2KMEI.SONOTA7 +" SONOTA7,");
        sql.append(" " + TBTHB2KMEI.SONOTA8 +" SONOTA8");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('195') AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + "= ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + "= " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "= " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + "= " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + "<> ' ' ) ");

        sql.append("ORDER BY");
        sql.append(" SONOTA10,");
        sql.append(" CODE1,");
        sql.append(" JYUTNO2,");
        sql.append(" JYMEINO2,");
        sql.append(" URMEINO2,");
        sql.append(" RENBAN2");

        return sql.toString();
    }

    /**
     * ���[�f�[�^(MAC)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportAshMediaVO> findReportMacByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshMediaVO());
        try {
            _cond = cond;
            _flg = true;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ���[�f�[�^(MAC)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportAshMediaVO> findReportMacALLByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshMediaVO());
        try {
            _cond = cond;
            _flg = false;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }
}