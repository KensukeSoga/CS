package jp.co.isid.kkh.customer.acom.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomCondition;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomVO;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;
import jp.co.isid.kkh.util.constants.KKHConstants;

/**
 *
 * <P>
 * ���[�i�A�R��)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * </P>
 *
 * @author
 */

public class ReportAcomDAO extends AbstractRdbDao {

    /** �ėp�}�X�^�������� */
    private ReportAcomCondition _cond;

    /** �ėp�}�X�^�F�}�̋敪�F�V�� */
    public static final String C_BAITAI_SHINBUN = "21";

    /** �ėp�}�X�^�F�}�̋敪�F�G�� */
    public static final String C_BAITAI_ZASHI = "22";

    /** �ėp�}�X�^�F�}�̋敪�F�d�g */
    public static final String C_BAITAI_DENPA = "11";

    /** �ėp�}�X�^�F�}�̋敪�F�L�� */
    public static final String C_BAITAI_KOTSU = "31";

    /** �ėp�}�X�^�F�}�̎�ʁF�V�� */
    public static final String C_HBAMST_F1_SHINBUN = "02";

    /** �ėp�}�X�^�F�}�̎�ʁF�G�� */
    public static final String C_HBAMST_F1_ZASHI = "03";

    /** �ėp�}�X�^�F�}�̎�ʁF�d�g */
    public static final String C_HBAMST_F1_DENPA = "mast7.gyomKbn";

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r */
    public static final String C_HBAMST_F1_TV = "04";

    /** �ėp�}�X�^�F�}�̎�ʁF���W�I */
    public static final String C_HBAMST_F1_RADIO = "05";

    /** �ėp�}�X�^�F�}�̎�ʁF�q�����f�B�A */
    public static final String C_HBAMST_F1_EISEI = "07";

    /** �ėp�}�X�^�F�}�̎�ʁF��� */
    public static final String C_HBAMST_F1_KOTSU = "06";

    /** �ėp�}�X�^�F�f�ڏꏊ */
    public static final String C_HBAMST_SYBT_KSAI = "906";

    /** �ėp�}�X�^�F�T�C�Y */
    public static final String C_HBAMST_SYBT_SIZE = "907";

    /** �ėp�}�X�^�F�L�G */
    public static final String C_HBAMST_SYBT_KZA = "908";

    /** �ėp�}�X�^�F���[ */
    public static final String C_HBAMST_SYBT_CHOYU = "909";

    /** �ėp�}�X�^�F���f�B�A */
    public static final String C_HBAMST_SYBT_MEDIA = "910";

    /** �ėp�}�X�^�F�F�� */
    public static final String C_HBAMST_SYBT_IRO = "911";

    /** �Ɩ��敪�}�X�^�F�R�[�h�F���W�I*/
    public static final String C_GYOM_CD_RADIO = KKHConstants.GyomKbn.RADIO.getCode();
    //public static final String C_GYOM_CD_RADIO = "11030";

    /** �Ɩ��敪�}�X�^�F�R�[�h�F�e���r�^�C�� */
    public static final String C_GYOM_CD_TVTIME = KKHConstants.GyomKbn.TVTIME.getCode();
    //public static final String C_GYOM_CD_TVTIME = "11040";

    /** �Ɩ��敪�}�X�^�F�R�[�h�F�e���r�X�|�b�g */
    public static final String C_GYOM_CD_TVSPOT = KKHConstants.GyomKbn.TVSPOT.getCode();
    //public static final String C_GYOM_CD_TVSPOT = "11045";

    /** �Ɩ��敪�}�X�^�F�R�[�h�F�q�����f�B�A */
    public static final String C_GYOM_CD_EISEI = KKHConstants.GyomKbn.EISEIM.getCode();
    //public static final String C_GYOM_CD_EISEI = "11050";

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportAcomDAO() {
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
/*		return new String[] {
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.RENBN };*/
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        // new String[] {};
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
        return null;
        /*
        return new String[] {
                TBTHB2KMEI.TIMSTMP, TBTHB2KMEI.UPDAPL,
                TBTHB2KMEI.UPDTNT, TBTHB2KMEI.EGCD, TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO, TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM, TBTHB2KMEI.JYUTNO, TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO, TBTHB2KMEI.HIMKCD, TBTHB2KMEI.RENBN,
                TBTHB2KMEI.DATEFROM, TBTHB2KMEI.DATETO, TBTHB2KMEI.SEIGAK,
                TBTHB2KMEI.HNNERT, TBTHB2KMEI.HNMAEGAK, TBTHB2KMEI.NEBIGAK,
                TBTHB2KMEI.DATE1, TBTHB2KMEI.DATE2, TBTHB2KMEI.DATE3,
                TBTHB2KMEI.DATE4, TBTHB2KMEI.DATE5, TBTHB2KMEI.DATE6,
                TBTHB2KMEI.KBN1, TBTHB2KMEI.KBN2, TBTHB2KMEI.KBN3,
                TBTHB2KMEI.CODE1, TBTHB2KMEI.CODE2, TBTHB2KMEI.CODE3,
                TBTHB2KMEI.CODE4, TBTHB2KMEI.CODE5, TBTHB2KMEI.CODE6,
                TBTHB2KMEI.NAME1, TBTHB2KMEI.NAME2, TBTHB2KMEI.NAME3,
                TBTHB2KMEI.NAME4, TBTHB2KMEI.NAME5, TBTHB2KMEI.NAME6,
                TBTHB2KMEI.NAME7, TBTHB2KMEI.NAME8, TBTHB2KMEI.NAME9,
                TBTHB2KMEI.NAME10, TBTHB2KMEI.KNGK1, TBTHB2KMEI.KNGK2,
                TBTHB2KMEI.KNGK3, TBTHB2KMEI.RITU1, TBTHB2KMEI.RITU2,
                TBTHB2KMEI.SONOTA1, TBTHB2KMEI.SONOTA2, TBTHB2KMEI.SONOTA3,
                TBTHB2KMEI.SONOTA4, TBTHB2KMEI.SONOTA5, TBTHB2KMEI.SONOTA6,
                TBTHB2KMEI.SONOTA7, TBTHB2KMEI.SONOTA8, TBTHB2KMEI.SONOTA9,
                TBTHB2KMEI.SONOTA10, TBTHB2KMEI.BUNFLG, TBTHB2KMEI.MEIHNFLG,
                TBTHB2KMEI.NEBHNFLG
                };*/
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

    private String getSelectSQLForItem() {

        String baitai = "";	//�}��.
        String mstField1 = "";	//�ėp�}�X�^��FIELD1�̃L�[

        // SQL.
        StringBuffer sql = new StringBuffer();

        // �w�肵���}�̂��Z�b�g.
        baitai = _cond.getbaitai();

        //*********************************
        //�`�F�b�N�����}�̂ɂ���ĕ���
        //*********************************
        //�V��
        if (baitai.equals(C_BAITAI_SHINBUN)){
            mstField1 = C_HBAMST_F1_SHINBUN;
        }
        //�G��
        else if(baitai.equals(C_BAITAI_ZASHI)){
            mstField1 = C_HBAMST_F1_ZASHI;
        }
        //�d�g
        else if(baitai.equals(C_BAITAI_DENPA)){
            mstField1 = C_HBAMST_F1_DENPA;
        }
        //���
        else if(baitai.equals(C_BAITAI_KOTSU)){
            mstField1 = C_HBAMST_F1_KOTSU;
        }

        // �e�}�̋��ʍ��ځ�.
        sql.append(" SELECT ");
        sql.append("  " + TBTHB1DOWN.FIELD1 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD2 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD3 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD6 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD7 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD8 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD9 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD11 + " ");
        sql.append(" ," + TBTHB1DOWN.EGCD + " ");
        sql.append(" ," + TBTHB1DOWN.GYOMKBN + " ");
        sql.append(" ," + TBTHB1DOWN.KKNAMEKJ + " ");
        sql.append(" ," + TBTHB1DOWN.HIMKNMKJ + " ");
        sql.append(" ," + TBTHB1DOWN.TMSPKBN + " ");
        sql.append(" ," + TBTHB1DOWN.YYMM + " ");
        sql.append(" ," + TBTHB2KMEI.CODE1 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE2 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE3 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE4 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME3 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME4 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME5 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME6 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME11 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME12 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME13 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME14 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME15 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME16 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME17 + " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA1 + " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA7 + " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA9 + " ");
        sql.append(" ," + TBTHB2KMEI.SEIGAK + " ");
        sql.append(" ," + TBTHB2KMEI.NEBIGAK + " ");
        sql.append(" ," + TBTHB2KMEI.RENBN + " ");
        sql.append(" ," + TBTHB2KMEI.KBN2 + " ");
        sql.append(" ," + TBTHB2KMEI.JYUTNO + " ");
        sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
        sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
        //�}�́F�V��
        if(baitai.equals(C_BAITAI_SHINBUN)){
            sql.append(" ," + "mast1.HBA_FIELD3" + " AS BASHO" + " ");	//�ꏊ
            sql.append(" ," + "mast2.HBA_FIELD3" + " AS SAIZU" + " ");	//�T�C�Y
            sql.append(" ," + "mast3.HBA_FIELD3" + " AS KIZATSU" + " ");//�L�G
            sql.append(" ," + "mast4.HBA_FIELD3" + " AS CHOYU" + " ");	//���[
            sql.append(" ," + "mast5.HBA_FIELD3" + " AS MEDIA" + " ");	//���f�B�A
            sql.append(" ," + "mast6.HBA_FIELD3" + " AS IROZURI" + " ");//�F��
        }
        //�}�́F�G��
        else if(baitai.equals(C_BAITAI_ZASHI)){
            sql.append(" ," + "mast2.HBA_FIELD3" + " AS SAIZU" + " ");	//�T�C�Y
            sql.append(" ," + "mast5.HBA_FIELD3" + " AS MEDIA" + " ");	//���f�B�A
            sql.append(" ," + "mast6.HBA_FIELD3" + " AS IROZURI" + " ");//�F��
        }
        //�}�́F�d�g
        else if(baitai.equals(C_BAITAI_DENPA)){
            sql.append(" ," + "mast5.HBA_FIELD1" + " ");
            sql.append(" ," + "mast5.HBA_FIELD2" + " ");
            sql.append(" ," + "mast5.HBA_FIELD3" + " AS MEDIA" + " ");	 //���f�B�A
            sql.append(" ," + "mast5.HBA_FIELD4" + " AS MEDIARYA" + " ");//���f�B�A(��)
            sql.append(" ," + "mast7.gyomKbn" + " "); 					//�Ɩ��敪
            sql.append(" ," + "mast7.MEU29_KYCD" + " "); 				//
            sql.append(" ," + "mast7.MEU29_NAIYJ" + " ");				//����
        }
        //�}�́F���
        else if(baitai.equals(C_BAITAI_KOTSU)){
            sql.append(" ," + "mast1.HBA_FIELD3" + " AS BASHO" + " ");	//�ꏊ
            sql.append(" ," + "mast5.HBA_FIELD3" + " AS MEDIA" + " "); 	//���f�B�A
        }

        //*************************************************************************************************
        //SQL�쐬
        //*************************************************************************************************
        //sql.append(" ," + TBTHBAMST.FIELD3 + " " + "AS " + TBTHB1DOWN.FIELD2 + " ");	//���O��ύX
        sql.append(" FROM ");
            //*************************************************************************************************
            //THB1DOWN�e�[�u��
            //*************************************************************************************************
            sql.append(" /* THB1DOWN */");
            sql.append(" (SELECT ");
            sql.append("  " + TBTHB1DOWN.FIELD1);
            sql.append(" ," + TBTHB1DOWN.FIELD2);
            sql.append(" ," + TBTHB1DOWN.FIELD3);
            sql.append(" ," + TBTHB1DOWN.FIELD4);
            sql.append(" ," + TBTHB1DOWN.FIELD5);
            sql.append(" ," + TBTHB1DOWN.FIELD6);
            sql.append(" ," + TBTHB1DOWN.FIELD7);
            sql.append(" ," + TBTHB1DOWN.FIELD8);
            sql.append(" ," + TBTHB1DOWN.FIELD9);
            sql.append(" ," + TBTHB1DOWN.FIELD11);
            sql.append(" ," + TBTHB1DOWN.GYOMKBN);
            sql.append(" ," + TBTHB1DOWN.HIMKNMKJ);
            sql.append(" ," + TBTHB1DOWN.KKNAMEKJ);
            sql.append(" ," + TBTHB1DOWN.TMSPKBN);
            sql.append(" ," + TBTHB1DOWN.EGCD + " ");
            sql.append(" ," + TBTHB1DOWN.TKSKGYCD + " ");
            sql.append(" ," + TBTHB1DOWN.TKSBMNSEQNO + " ");
            sql.append(" ," + TBTHB1DOWN.TKSTNTSEQNO + " ");
            sql.append(" ," + TBTHB1DOWN.JYUTNO + " ");
            sql.append(" ," + TBTHB1DOWN.JYMEINO + " ");
            sql.append(" ," + TBTHB1DOWN.URMEINO + " ");
            sql.append(" ," + TBTHB1DOWN.YYMM + " ");
            sql.append(" ," + TBTHB1DOWN.TOUFLG + " ");
            sql.append(" FROM " );
            sql.append(TBTHB1DOWN.TBNAME + " thb1");
            sql.append(" WHERE ");
            sql.append("thb1." + TBTHB1DOWN.EGCD 		+ " = '" + _cond.getEgCd()  	  + "' AND ");
            sql.append("thb1." + TBTHB1DOWN.TKSKGYCD 	+ " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append("thb1." + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("thb1." + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("thb1." + TBTHB1DOWN.YYMM 		+ " = '" + _cond.getYm()		  + "' AND ");
            sql.append("thb1." + TBTHB1DOWN.TOUFLG 		+ " <> '" + "1" + "' ");	//����
            sql.append(") thb1 ");

            //*************************************************************************************************
            //THB2KMEI�e�[�u��
            //*************************************************************************************************
            sql.append(" /* THB2KMEI */");
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHB2KMEI.CODE1 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE2 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE3 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE4 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME3 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME4 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME5 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME6 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME11 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME12 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME13 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME14 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME15 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME16 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME17 + " ");
            sql.append(" ," + TBTHB2KMEI.SEIGAK + " ");
            sql.append(" ," + TBTHB2KMEI.NEBIGAK + " ");
            sql.append(" ," + TBTHB2KMEI.SONOTA1 + " ");
            sql.append(" ," + TBTHB2KMEI.SONOTA7 + " ");
            sql.append(" ," + TBTHB2KMEI.SONOTA9 + " ");
            sql.append(" ," + TBTHB2KMEI.EGCD + " ");
            sql.append(" ," + TBTHB2KMEI.TKSKGYCD + " ");
            sql.append(" ," + TBTHB2KMEI.TKSBMNSEQNO + " ");
            sql.append(" ," + TBTHB2KMEI.TKSTNTSEQNO + " ");
            sql.append(" ," + TBTHB2KMEI.JYUTNO + " ");
            sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.RENBN + " ");
            sql.append(" ," + TBTHB2KMEI.KBN2 + " ");
            sql.append(" ," + TBTHB2KMEI.YYMM + " ");
            sql.append(" FROM " );
            sql.append(TBTHB2KMEI.TBNAME + " thb2");
            sql.append(" WHERE ");
            sql.append("thb2." + TBTHB2KMEI.EGCD 		+ " = '" + _cond.getEgCd()  	  + "' AND ");
            sql.append("thb2." + TBTHB2KMEI.TKSKGYCD 	+ " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append("thb2." + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("thb2." + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("thb2." + TBTHB2KMEI.YYMM 		+ " = '" + _cond.getYm()		  + "' AND ");
            sql.append("thb2." + TBTHB2KMEI.CODE1 		+ " = '" + baitai 				  + "' ");	//����
            //sql.append("thb2." + TBTHB2KMEI.NAME6 			+ " <> '" +  " 	+ "' ");
            sql.append(") thb2 ON ( ");
            sql.append(TBTHB1DOWN.EGCD 		  + " = " + TBTHB2KMEI.EGCD 	   + " AND ");
            sql.append(TBTHB1DOWN.TKSKGYCD 	  + " = " + TBTHB2KMEI.TKSKGYCD    + " AND ");
            sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append(TBTHB1DOWN.YYMM 		  + " = " + TBTHB2KMEI.YYMM 	   + " AND ");
//			sql.append("TRIM(" + TBTHB1DOWN.JYUTNO  + ") = TRIM(" + TBTHB2KMEI.JYUTNO + ") AND ");
//			sql.append("TRIM(" + TBTHB1DOWN.JYMEINO + ") = TRIM(" + TBTHB2KMEI.JYMEINO + ") AND ");
//			sql.append("TRIM(" + TBTHB1DOWN.URMEINO + ") = TRIM(" + TBTHB2KMEI.URMEINO + ")" + ")");
            sql.append("TRIM(" + TBTHB1DOWN.JYUTNO  + ") = TRIM(" + TBTHB2KMEI.NAME3 + ") AND ");
            sql.append("TRIM(" + TBTHB1DOWN.JYMEINO + ") = TRIM(" + TBTHB2KMEI.NAME4 + ") AND ");
            sql.append("TRIM(" + TBTHB1DOWN.URMEINO + ") = TRIM(" + TBTHB2KMEI.NAME5 + ")" + ")");

        //*************************************************************************************************
        //�f�ڏꏊ
        //*************************************************************************************************
        sql.append(" /* �f�ڏꏊ */");
        //�}�́F�V���E���
        if (baitai.equals(C_BAITAI_SHINBUN) || baitai.equals(C_BAITAI_KOTSU)) {
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 		 + " = '" + _cond.getEgCd()  	   + "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_KSAI	   + "' AND ");
            sql.append(TBTHBAMST.FIELD1 	 + " = '" + mstField1  + "'");	//����
            sql.append(") mast1 ON (");
            sql.append("TRIM(mast1." + TBTHBAMST.FIELD2 + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME11 + ")" + ")");
        }
        //*************************************************************************************************
        //�T�C�Y
        //*************************************************************************************************
        sql.append(" /* �T�C�Y */");
        //�}�́F�V��
        if(baitai.equals(C_BAITAI_SHINBUN) || baitai.equals(C_BAITAI_ZASHI)){
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 		 + " = '" + _cond.getEgCd()  	   + "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_SIZE	   + "' AND ");
            sql.append(TBTHBAMST.FIELD1 	 + " = '" + mstField1  + "'");	//����
            sql.append(") mast2 ON (");
//			sql.append("TRIM(mast2." + TBTHBAMST.FIELD2 + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME15 + ")" + ")");
            //�}�́F�V��
            if(baitai.equals(C_BAITAI_SHINBUN)){
                sql.append("TRIM(mast2." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME15 + ")" + ")");
            }
            //�}�́F�G��
            else if(baitai.equals(C_BAITAI_ZASHI)){
                sql.append("TRIM(mast2." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME12 + ")" + ")");
            }
        }
        //*************************************************************************************************
        //�L�G
        //*************************************************************************************************
        sql.append(" /* �L�G */");
        //�}�́F�V��
        if(baitai.equals(C_BAITAI_SHINBUN)){
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 		 + " = '" + _cond.getEgCd()		   + "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_KZA 	   + "' AND ");
            sql.append(TBTHBAMST.FIELD1 	 + " = '" + mstField1 + "'");	//����
            sql.append(") mast3 ON (");
            sql.append("TRIM(mast3." + TBTHBAMST.FIELD2 + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME12 + ")" + ")");
        }
        //*************************************************************************************************
        //���[
        //*************************************************************************************************
        sql.append(" /* ���[ */");
        //�}�́F�V��
        if(baitai.equals(C_BAITAI_SHINBUN)){
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 		 + " = '" + _cond.getEgCd()  	   + "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_CHOYU	   + "' AND ");
            sql.append("TRIM(" + TBTHBAMST.FIELD1 + ") = '" + mstField1 + "'");	//����
            sql.append(") mast4 ON (");
            sql.append("TRIM(mast4." + TBTHBAMST.FIELD2 + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME13 + ")" + ")");
        }
        //*************************************************************************************************
        //�Ɩ��敪
        //*************************************************************************************************
        sql.append(" /* �Ɩ��敪 */");
        //�d�g
        if (baitai.equals(C_BAITAI_DENPA)){
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBRCMN_MEU29CC.MEU29_KYCD 	+ " , " );
            sql.append("  " + " CASE "+ TBRCMN_MEU29CC.MEU29_KYCD );
            sql.append(" 		 WHEN '" + C_GYOM_CD_TVTIME + "' THEN '" + C_HBAMST_F1_TV + "' ");	//�e���r�^�C�����e���r
            sql.append(" 		 WHEN '" + C_GYOM_CD_TVSPOT + "' THEN '" + C_HBAMST_F1_TV + "' ");	//TV�X�|�b�g���e���r
            sql.append(" 		 WHEN '" + C_GYOM_CD_RADIO  + "' THEN '" + C_HBAMST_F1_RADIO + "' ");	//���W�I�����W�I
            sql.append(" 		 WHEN '" + C_GYOM_CD_EISEI  + "' THEN '" + C_HBAMST_F1_EISEI + "' ");	//�q�����f�B�A���q��
            sql.append(" 		END " + " AS gyomKbn"		+ " , " );
            sql.append("  " + TBRCMN_MEU29CC.MEU29_NAIYJ );
            sql.append(" FROM " );
            sql.append(TBRCMN_MEU29CC.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBRCMN_MEU29CC.MEU29_KYCDKND	+ " = "  + "'87'" + " AND ");
            sql.append(TBRCMN_MEU29CC.MEU29_HKYMD	+ " <= " + "to_Char(sysdate,'yyyymmdd')" + " AND ");
            sql.append(TBRCMN_MEU29CC.MEU29_HAISYMD	+ " >= " + "to_Char(sysdate,'yyyymmdd')");
            sql.append(") mast7 ON (");
            sql.append("TRIM(thb1." + TBTHB1DOWN.GYOMKBN + ") = " + "TRIM(mast7." + TBRCMN_MEU29CC.MEU29_KYCD + ")" + ")");
        }
        //*************************************************************************************************
        //���f�B�A
        //*************************************************************************************************
        sql.append(" /* ���f�B�A */");
        sql.append(" LEFT OUTER JOIN ");
        sql.append(" (SELECT");
        sql.append("  " + TBTHBAMST.FIELD1 );
        sql.append(" ," + TBTHBAMST.FIELD2 );
        sql.append(" ," + TBTHBAMST.FIELD3 );
        sql.append(" ," + TBTHBAMST.FIELD4 );	//���f�B�A(��)
        sql.append(" FROM " );
        sql.append(TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append(TBTHBAMST.EGCD		 + " = '" + _cond.getEgCd()  		+ "' AND ");
        sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()  	+ "' AND ");
        sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() 	+ "' AND ");
        sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo()	+ "' AND ");
        sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_MEDIA + "'  ");
        sql.append(") mast5 ON (");
        //sql.append("mast5."+ TBTHBAMST.FIELD1 + " = " + mstField1	+ " AND ");	//����;
        sql.append(" TRIM(mast5." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.CODE2 + ")" + " AND ");
        //�d�g
        if (baitai.equals(C_BAITAI_DENPA)){
            sql.append("TRIM(" + "mast5."+ TBTHBAMST.FIELD1 + ") = " + mstField1 + " " + ")");	//����;
        }
        else{
            sql.append("TRIM(" + "mast5."+ TBTHBAMST.FIELD1 + ") = '" + mstField1 + "'" + ")");	//����
        }
/*		//�V�� �� �G��
        if (baitai.equals(C_BAITAI_SHINBUN) || baitai.equals(C_BAITAI_ZASHI) ){
            sql.append("mast5."+ THBAMST.FIELD1 + " = '" + mstField1	+ "' AND ");	//����
        }
        //�d�g
        else if (baitai.equals(C_BAITAI_DENPA)){
            sql.append("mast5."+ THBAMST.FIELD1 + " = " + mstField1	+ " AND ");	//����;
        }
        //�����
        else if (baitai.equals(C_BAITAI_KOTSU)){
            sql.append("mast5."+ THBAMST.FIELD1 + " = " + mstField1	+ " AND ");	//����;
        }
*/
        //*************************************************************************************************
        //�F��
        //*************************************************************************************************
        sql.append(" /* �F�� */");
        //�}�́F�V�� �� �G��
        if(baitai.equals(C_BAITAI_SHINBUN) || baitai.equals(C_BAITAI_ZASHI)){
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 		 + " = '" + _cond.getEgCd()		   + "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_IRO	   + "' AND ");
            sql.append("TRIM(" + TBTHBAMST.FIELD1 + ") = '" + mstField1 + "'");	//����
            sql.append(") mast6 ON (");
//			sql.append("TRIM(mast6." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME14 + ")" + ")");
            //�}�́F�V��
            if(baitai.equals(C_BAITAI_SHINBUN)){
                sql.append("TRIM(mast6." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME14 + ")" + ")");
            }
            //�}�́F�G��
            else if(baitai.equals(C_BAITAI_ZASHI)){
                sql.append("TRIM(mast6." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME11 + ")" + ")");
            }
        }
        //*************************************************************************************************
        //WHERE��
        //*************************************************************************************************
        sql.append(" WHERE ");
        sql.append(TBTHB1DOWN.EGCD 		  + " = '" + _cond.getEgCd()		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 	  + " = '" + _cond.getTksKgyCd()    + "' AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(TBTHB1DOWN.YYMM 		  + " = '" + _cond.getYm() 			+ "' AND ");
        sql.append(TBTHB1DOWN.TOUFLG 	  + " <> '" + "1" 					+ "' AND ");
        sql.append("TRIM(" + TBTHB2KMEI.CODE1 + ") = '" + baitai + "'");
        //*************************************************************************************************
        //ORDER BY��
        //*************************************************************************************************
        sql.append(" ORDER BY ");
        sql.append(TBTHB2KMEI.SONOTA1 + ", ");
        sql.append(TBTHB2KMEI.CODE3   + ", ");
        sql.append(TBTHB2KMEI.KBN2 	  + ", ");
        sql.append(TBTHB2KMEI.CODE2   + ", ");
        sql.append(TBTHB2KMEI.CODE4   + ", ");
        sql.append(TBTHB2KMEI.NAME6   + ", ");
        sql.append(TBTHB1DOWN.JYUTNO  + ", ");
        sql.append(TBTHB1DOWN.JYMEINO + ", ");
        sql.append(TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    /**
     * ���[�f�[�^(�A�R��)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportAcomVO> findReportAcomByCondition(ReportAcomCondition cond)
            throws KKHException {

        super.setModel(new ReportAcomVO());

        try {
            _cond = cond;
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
     * @param hashList
     *            List ��������
     * @return List<CommonCodeMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<ReportAcomVO> createFindedModelInstances(List hashList) {
        List<ReportAcomVO> list = new ArrayList<ReportAcomVO>();
        if (getModel() instanceof ReportAcomVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportAcomVO vo = new ReportAcomVO();
                vo.setName3((String) result.get(TBTHB2KMEI.NAME3.toUpperCase()));			//��No
                vo.setName4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase()));			//�󒍖���No
                vo.setName5((String) result.get(TBTHB2KMEI.NAME5.toUpperCase()));			//���㖾��No
                vo.setName6((String) result.get(TBTHB2KMEI.NAME6.toUpperCase()));			//�������[No
                vo.setName11((String) result.get(TBTHB2KMEI.NAME11.toUpperCase()));			//��
                vo.setName12((String) result.get(TBTHB2KMEI.NAME12.toUpperCase()));			//��
                vo.setName13((String) result.get(TBTHB2KMEI.NAME13.toUpperCase()));			//���l�P(�G��)
                vo.setName14((String) result.get(TBTHB2KMEI.NAME14.toUpperCase()));			//���l�Q(�G��)
                vo.setName15((String) result.get(TBTHB2KMEI.NAME15.toUpperCase()));			//
                vo.setName16((String) result.get(TBTHB2KMEI.NAME16.toUpperCase()));			//���l�P(�V��)
                vo.setName17((String) result.get(TBTHB2KMEI.NAME17.toUpperCase()));			//���l�Q(�V��)
                vo.setCode2((String) result.get(TBTHB2KMEI.CODE2.toUpperCase()));			//�P�s��
                vo.setCode3((String) result.get(TBTHB2KMEI.CODE3.toUpperCase()));			//�����ԍ�
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase()));			//�����s�ԍ�
                vo.setSonota1((String) result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));		//
                vo.setSonota7((String) result.get(TBTHB2KMEI.SONOTA7.toUpperCase()));		//�V���A�G���F�P���A���z
                vo.setSonota9((String) result.get(TBTHB2KMEI.SONOTA9.toUpperCase()));		//
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));		//���z
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));	//�l���z
                vo.setJyutNo((String) result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));			//��No
                vo.setJyMeiNo((String) result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));		//�󒍖���No
                vo.setUrMeiNo((String) result.get(TBTHB2KMEI.URMEINO.toUpperCase()));		//���㖾��No
                vo.setRenbn((String) result.get(TBTHB2KMEI.RENBN.toUpperCase()));
                vo.setKbn2((String) result.get(TBTHB2KMEI.KBN2.toUpperCase()));			//�l���敪(1:�l���s)
                vo.setYymm((String) result.get(TBTHB1DOWN.YYMM.toUpperCase()));			//�����Ǘ����i�V���F�X�y�[�X�j
                vo.setField1((String) result.get(TBTHB1DOWN.FIELD1.toUpperCase()));			//�����Ǘ����i�V���F�X�y�[�X�j
                vo.setField2((String) result.get(TBTHB1DOWN.FIELD2.toUpperCase()));			//�����ǖ�(�V���F�V���� )
                vo.setField3((String) result.get(TBTHB1DOWN.FIELD3.toUpperCase()));			//�l�b�g�ǐ�or�����ǐ��i�V���F�f�ړ��j
                vo.setField4((String) result.get(TBTHB1DOWN.FIELD4.toUpperCase()));			//�������ԁi�V���F���[�j
                vo.setField5((String) result.get(TBTHB1DOWN.FIELD5.toUpperCase()));			//�b��
                vo.setField6((String) result.get(TBTHB1DOWN.FIELD6.toUpperCase()));			//��or�{���i�f�ڔŁj
                vo.setField7((String) result.get(TBTHB1DOWN.FIELD7.toUpperCase()));			//
                vo.setField8((String) result.get(TBTHB1DOWN.FIELD8.toUpperCase()));			//�������ԁi�L�G�敪�j
                vo.setField9((String) result.get(TBTHB1DOWN.FIELD9.toUpperCase()));			//
                vo.setField11((String) result.get(TBTHB1DOWN.FIELD11.toUpperCase()));		//
                vo.setKkNameKj((String) result.get(TBTHB1DOWN.KKNAMEKJ.toUpperCase()));		//����
                vo.setHimknmkj((String) result.get(TBTHB1DOWN.HIMKNMKJ.toUpperCase()));		//��ږ�
                vo.setTmspkbn((String) result.get(TBTHB1DOWN.TMSPKBN.toUpperCase()));		//�^�C���X�|�b�g�敪
                vo.setGyomkbn((String) result.get(TBTHB1DOWN.GYOMKBN.toUpperCase()));		//�Ɩ��敪
                vo.setGyomKbnMei((String) result.get(TBRCMN_MEU29CC.MEU29_NAIYJ.toUpperCase()));		//�Ɩ��敪����
                vo.setBasho((String) result.get(ReportAcomVO.BASHO.toUpperCase()));				//�ꏊ
                vo.setSaizu((String) result.get(ReportAcomVO.SAIZU.toUpperCase()));				//�T�C�Y
                vo.setKizatsu((String) result.get(ReportAcomVO.KIZATSU.toUpperCase()));			//�L�G
                vo.setChoyu((String) result.get(ReportAcomVO.CHOYU.toUpperCase()));				//���[
                vo.setMedia((String) result.get(ReportAcomVO.MEDIA.toUpperCase()));				//���f�B�A
                vo.setMediaRya((String) result.get(ReportAcomVO.MEDIARYA.toUpperCase()));		//���f�B�A(��)
                vo.setIrozuri((String) result.get(ReportAcomVO.IROZURI.toUpperCase()));			//�F��

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }
}
