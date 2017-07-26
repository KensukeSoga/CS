package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionVO;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ���[�iLion)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionDAO extends AbstractRdbDao {

    /** �ėp�}�X�^�������� */
    private ReportLionCondition _cond;

    /** �ėp�}�X�^�F�}�̋敪�F�e���r�^�C�� */
    public static final String C_BAITAI_TV_TIME = "�e���r�^�C��";

    /** �ėp�}�X�^�F�}�̋敪�F���W�I�^�C�� */
    private static final String C_BAITAI_RD_TIME = "���W�I�^�C��";

    /** �ėp�}�X�^�F�}�̋敪�F�e���r�X�|�b�g */
    private static final String C_BAITAI_TV_SPOT = "�e���r�X�|�b�g";

    /** �ėp�}�X�^�F�}�̋敪�F���W�I�X�|�b�g */
    private static final String C_BAITAI_RD_SPOT = "���W�I�X�|�b�g";

    /** �ėp�}�X�^�F�}�̎�ʁF�u�����h�}�X�^ */
    public static final String C_HBAMST_SYBT_BRAND = "201";

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r�ǃ}�X�^ */
    public static final String C_HBAMST_SYBT_TV_KYOKU = "401";

    /** �ėp�}�X�^�F�}�̎�ʁF���W�I�ǃ}�X�^ */
    public static final String C_HBAMST_SYBT_RD_KYOKU = "402";

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r�ԑg�}�X�^ */
    public static final String C_HBAMST_SYBT_TV_BANGUMI = "601";

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r�ԑg�}�X�^ */
    public static final String C_HBAMST_SYBT_RD_BANGUMI = "602";

    /** �ėp�}�X�^�F�}�̋敪�F�d�g */
    public static final String C_BAITAI_DENPA = "11";

    /** �ėp�}�X�^�F�}�̎�ʁF�V�� */
    public static final String C_HBAMST_F1_SHINBUN = "02";

    /** �ėp�}�X�^�F�}�̎�ʁF�G�� */
    public static final String C_HBAMST_F1_ZASHI = "03";

    /** �ėp�}�X�^�F�}�̎�ʁF�d�g */
    public static final String C_HBAMST_F1_DENPA = "mast7.gyomKbn";

    /** �ėp�}�X�^�F�}�̎�ʁF�e���r */
    public static final String C_HBAMST_F1_TV = "04";

    /** �ėp�}�X�^�F�}�̎�ʁF���W�I */
    public static final String C_HBAMST_F1_RD = "05";

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
    public static final String C_GYOM_CD_RD = "11030";

    /** �Ɩ��敪�}�X�^�F�R�[�h�F�e���r�^�C�� */
    public static final String C_GYOM_CD_TVTIME = "11040";

    /** �Ɩ��敪�}�X�^�F�R�[�h�F�e���r�X�|�b�g */
    public static final String C_GYOM_CD_TVSPOT = "11045";

    /** �Ɩ��敪�}�X�^�F�R�[�h�F�q�����f�B�A */
    public static final String C_GYOM_CD_EISEI = "11050";

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportLionDAO() {
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

        String _baitai = "";	//�}��.

        // SQL.
        StringBuffer sql = new StringBuffer();

        // �w�肵���}�̂��Z�b�g.
        _baitai = _cond.getbaitai();

        //*********************************
        //�w�肵���}�̂ɂ���ĕ���
        //*********************************
        //�e���r�^�C��
        if (_baitai.equals(C_BAITAI_TV_TIME)){
        }

/*		//*********************************
        //�`�F�b�N�����}�̂ɂ���ĕ���
        //*********************************
        //�V��
        if (_baitai.equals(C_BAITAI_SHINBUN)){
            _mstField1 = C_HBAMST_F1_SHINBUN;
        }
        //�G��
        else if(_baitai.equals(C_BAITAI_ZASHI)){
            _mstField1 = C_HBAMST_F1_ZASHI;
        }
        //�d�g
        else if(_baitai.equals(C_BAITAI_DENPA)){
            _mstField1 = C_HBAMST_F1_DENPA;
        }
        //���
        else if(_baitai.equals(C_BAITAI_KOTSU)){
            _mstField1 = C_HBAMST_F1_KOTSU;
        }*/

        // �e�}�̋��ʍ��ځ�.
        sql.append(" SELECT ");
/*		sql.append("  " + TBTHB1DOWN.FIELD1 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD2 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD3 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD4 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD5 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD6 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD7 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD8 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD9 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD11 	+ " ");
        sql.append(" ," + TBTHB1DOWN.EGCD 		+ " ");
        sql.append(" ," + TBTHB1DOWN.GYOMKBN 	+ " ");
        sql.append(" ," + TBTHB1DOWN.KKNAMEKJ 	+ " ");
        sql.append(" ," + TBTHB1DOWN.HIMKNMKJ 	+ " ");
        sql.append(" ," + TBTHB1DOWN.TMSPKBN 	+ " ");
        sql.append(" ," + TBTHB1DOWN.YYMM	 	+ " ");*/
        sql.append("  " + TBTHB2KMEI.YYMM		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE1		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE2 		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE3 		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE4 		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE5 		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE6 		+ " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA5 	+ " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA7 	+ " ");
/*		sql.append(" , TRIM(" + TBTHB2KMEI.CODE1	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.CODE2 	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.CODE3 	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.CODE4 	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.CODE5 	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.CODE6 	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.SONOTA5 	+ ") ");*/
        sql.append(" ," + TBTHB2KMEI.KNGK2 		+ " ");
        sql.append(" ," + TBTHB2KMEI.KNGK3 		+ " ");
        sql.append(" ," + TBTHB2KMEI.SEIGAK 	+ " ");
        sql.append(" ," + TBTHB2KMEI.NEBIGAK 	+ " ");
        sql.append(" ," + TBTHB2KMEI.RITU1 		+ " ");	//����ŗ�
        sql.append(" ," + "TRUNC("
                        + "DECODE(TRIM(" + TBTHB2KMEI.SEIGAK + ") , NULL , 0 , " + TBTHB2KMEI.SEIGAK  + ")"
                        + " * "
                        + "DECODE(TRIM(" + TBTHB2KMEI.RITU1  + ") , NULL , 5 , " + TBTHB2KMEI.RITU1   + ")"
                        + "/ 100  )"
                        +  "AS SHOHIZEI_GAK " 	+ " ");	//����Ŋz
        sql.append(" ," + TBTHB2KMEI.NAME1 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME2 		+ " ");
//		sql.append(" ," + TBTHB2KMEI.NAME3 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME4 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME5 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME6 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME7 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME8 		+ " ");
/*		sql.append(" ," + TBTHB2KMEI.NAME11 	+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME12 	+ " ");
        sql.append(" ,to_single_byte(" + TBTHB2KMEI.NAME13 	+ ") AS " + TBTHB2KMEI.NAME13  + " ");	// ���p�ɕϊ�
        sql.append(" ," + TBTHB2KMEI.NAME14 	+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME15 	+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME16 	+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME17 	+ " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA1 	+ " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA7 	+ " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA9 	+ " ");
        sql.append(" ," + TBTHB2KMEI.RENBN 		+ " ");
        sql.append(" ," + TBTHB2KMEI.KBN2 		+ " ");
        sql.append(" ," + TBTHB2KMEI.JYUTNO 	+ " ");
        sql.append(" ," + TBTHB2KMEI.JYMEINO 	+ " ");
        sql.append(" ," + TBTHB2KMEI.URMEINO 	+ " ");*/
        //�}�́F�e���r�^�C���A���W�I�^�C���A�e���r�X�|�b�g
        if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_RD_TIME) || _baitai.equals(C_BAITAI_TV_SPOT) || _baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append(" ," + "mast3.HBA_FIELD1" 	+ " AS " + ReportLionVO.KYOKU_CD	+ " ");		//�ǃR�[�h
            sql.append(" ," + "mast3.HBA_FIELD2" 	+ " AS " + ReportLionVO.KYOKU_MEI	+ " ");		//�ǖ�
        }

        //�}�́F�e���r�^�C���A���W�I�^�C��
        if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_RD_TIME)){
            sql.append(" ," + "mast1.HBA_FIELD1" 	+ " AS "+ ReportLionVO.BANGUMI_CD	+ " ");		//�ԑg�R�[�h
            sql.append(" ," + "mast1.HBA_FIELD2" 	+ " AS "+ ReportLionVO.BANGUMI_MEI	+ " ");		//�ԑg��
        }

        //�}�́F�e���r�X�|�b�g�A���W�I�X�|�b�g
        if(_baitai.equals(C_BAITAI_TV_SPOT) || _baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append(" ," + "mast5.HBA_FIELD1" 	+ " AS " + ReportLionVO.BRAND_CD	+ " ");		//�u�����h�R�[�h
            sql.append(" ," + "mast5.HBA_FIELD2" 	+ " AS " + ReportLionVO.BRAND_MEI	+ " ");		//�u�����h��
            sql.append(" ," + "DECODE(TRIM(" + TBTHB2KMEI.SONOTA5 + ") , NULL , 0 , " + TBTHB2KMEI.SONOTA5 +  ")"
                            + " * "
                            + "DECODE(TRIM(" + TBTHB2KMEI.SONOTA7 + ") , NULL , 0 , " + TBTHB2KMEI.SONOTA7 +  ")"
                            + "  AS BYOSU_GOKEI " + " ");	//�� * CM1�{�b��
        }

        /*		//�}�́F�V��
        if(_baitai.equals(C_BAITAI_SHINBUN)){
            sql.append(" ," + "mast1.HBA_FIELD3" 	+ " AS BASHO"	+ " ");	//�ꏊ
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS SAIZU"	+ " ");	//�T�C�Y
            sql.append(" ," + "mast3.HBA_FIELD3" 	+ " AS KIZATSU"	+ " ");	//�L�G
            sql.append(" ," + "mast3.HBA_FIELD3" 	+ " AS CHOYU"	+ " ");	//���[
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS MEDIA"	+ " ");	//���f�B�A
            sql.append(" ," + "mast1.HBA_FIELD3" 	+ " AS IROZURI"	+ " ");	//�F��
        }
        //�}�́F�G��
        else if(_baitai.equals(C_BAITAI_ZASHI)){
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS SAIZU"	+ " ");	//�T�C�Y
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS MEDIA"	+ " ");	//���f�B�A
            sql.append(" ," + "mast1.HBA_FIELD3" 	+ " AS IROZURI"	+ " ");	//�F��
        }
        //�}�́F�d�g
        else if(_baitai.equals(C_BAITAI_DENPA)){
            sql.append(" ," + "mast5.HBA_FIELD1"	+ " ");
            sql.append(" ," + "mast5.HBA_FIELD2" 	+ " ");
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS MEDIA"	+ " ");		//���f�B�A
            sql.append(" ," + "mast5.HBA_FIELD4" 	+ " AS MEDIARYA"	+ " ");	//���f�B�A(��)
            sql.append(" ," + "mast7.gyomKbn"	+ " ");			//�Ɩ��敪
            sql.append(" ," + "mast7.MEU29_KYCD"	+ " ");		//�Ɩ��敪
            sql.append(" ," + "mast7.MEU29_NAIYJ"	+ " ");		//�Ɩ��敪����
        }
        //�}�́F���
        else if(_baitai.equals(C_BAITAI_KOTSU)){
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS MEDIA"	+ " ");	//���f�B�A
        }*/

        //*************************************************************************************************
        //FROM
        //*************************************************************************************************
        //sql.append(" ," + TBTHBAMST.FIELD3 + " " + "AS " + TBTHB1DOWN.FIELD2 + " ");	//���O��ύX
        sql.append(" FROM ");
        sql.append(TBTHB1DOWN.TBNAME + " thb1" + " , ");
        sql.append(TBTHB2KMEI.TBNAME + " thb2" + "   ");

        //*************************************************************************************************
        //�ԑg�}�X�^
        //*************************************************************************************************
        //�}�́F�e���r�^�C���A���W�I�^�C��
        if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_RD_TIME)){
            sql.append("  (SELECT");
            sql.append("  " + TBTHBAMST.FIELD1);
            sql.append(" ," + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" ," + TBTHBAMST.FIELD4 );
            sql.append(" ," + TBTHBAMST.FIELD5 );
            sql.append(" ," + TBTHBAMST.FIELD6 );
            sql.append(" ," + TBTHBAMST.INTVALUE6 );
            sql.append(" ," + TBTHBAMST.TKSKGYCD );
            sql.append(" ," + TBTHBAMST.TKSBMNSEQNO );
            sql.append(" ," + TBTHBAMST.TKSTNTSEQNO );
            sql.append(" ," + TBTHBAMST.SYBT);
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 			+ " = '" + _cond.getEgCd()  		+ "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd()  	+ "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
            //�}�́F�e���r�^�C��
            if(_baitai.equals(C_BAITAI_TV_TIME)){
                sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_TV_BANGUMI	+ "'     ");	//�e���r�ԑg�}�X�^
            }
            //�}�́F���W�I�^�C��
            else if(_baitai.equals(C_BAITAI_RD_TIME)){
                sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_RD_BANGUMI	+ "'     ");	//���W�I�ԑg�}�X�^
            }
            sql.append(") mast1"	+	" , ");
        }
        //*************************************************************************************************
        //�ǃ}�X�^
        //*************************************************************************************************
        //�}�́F�e���r�^�C���A���W�I�^�C���A�e���r�X�|�b�g�A���W�I�X�|�b�g
        if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_RD_TIME) || _baitai.equals(C_BAITAI_TV_SPOT) || _baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append("  ( SELECT");
            sql.append("  " + TBTHBAMST.FIELD1);
            sql.append(" ," + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" ," + TBTHBAMST.FIELD4 );
            sql.append(" ," + TBTHBAMST.FIELD5 );
            sql.append(" ," + TBTHBAMST.FIELD6 );
            sql.append(" ," + TBTHBAMST.TKSKGYCD );
            sql.append(" ," + TBTHBAMST.TKSBMNSEQNO );
            sql.append(" ," + TBTHBAMST.TKSTNTSEQNO );
            sql.append(" ," + TBTHBAMST.SYBT);
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 			+ " = '" + _cond.getEgCd()  		+ "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd()  	+ "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
            //�}�́F�e���r�^�C���A�e���r�X�|�b�g
            if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_TV_SPOT)){
                sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_TV_KYOKU	+ "'     ");	//�e���r�ǃ}�X�^
            }
            //�}�́F���W�I�^�C���A���W�I�X�|�b�g
            else if(_baitai.equals(C_BAITAI_RD_TIME) || _baitai.equals(C_BAITAI_RD_SPOT)){
                sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_RD_KYOKU	+ "'     ");	//���W�I�ǃ}�X�^
            }
        sql.append(") mast3 "	+	" , ");
        }

        //*************************************************************************************************
        //�u�����h�}�X�^
        //*************************************************************************************************
        //�}�́F�e���r�X�|�b�g
        if(_baitai.equals(C_BAITAI_TV_SPOT) || _baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append(" ( SELECT");
            sql.append("  " + TBTHBAMST.FIELD1);
            sql.append(" ," + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" ," + TBTHBAMST.FIELD4 );
            sql.append(" ," + TBTHBAMST.FIELD5 );
            sql.append(" ," + TBTHBAMST.FIELD6 );
            sql.append(" ," + TBTHBAMST.TKSKGYCD );
            sql.append(" ," + TBTHBAMST.TKSBMNSEQNO );
            sql.append(" ," + TBTHBAMST.TKSTNTSEQNO );
            sql.append(" ," + TBTHBAMST.SYBT);
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 			+ " = '" + _cond.getEgCd()  		+ "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd()  	+ "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
            sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_BRAND		+ "'     ");	//�u�����h�}�X�^
/*			//�}�́F�e���r�X�|�b�g
            if(_baitai.equals(C_BAITAI_TV_SPOT)){
                sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_BRAND	+ "'     ");	//�u�����h�}�X�^
            }
*/		sql.append(") mast5 "	+	" , ");
        }
        //*************************************************************************************************
        //WHERE��
        //*************************************************************************************************
        sql.append(" WHERE ");
        sql.append(TBTHB1DOWN.EGCD 			+ " = '" + _cond.getEgCd() 			+ "' AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd() 		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " = '" + _cond.getYm() 			+ "' AND ");

        sql.append(TBTHB1DOWN.EGCD 			+ " = " + TBTHB2KMEI.EGCD  			+ "  AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " = " + TBTHB2KMEI.TKSKGYCD 		+ "  AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " = " + TBTHB2KMEI.TKSBMNSEQNO 	+ "  AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " = " + TBTHB2KMEI.TKSTNTSEQNO 	+ "  AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " = " + TBTHB2KMEI.YYMM 			+ "  AND ");

        sql.append(TBTHB1DOWN.JYUTNO 		+ " = " + TBTHB2KMEI.JYUTNO  		+ "  AND ");
        sql.append(TBTHB1DOWN.JYMEINO 		+ " = " + TBTHB2KMEI.JYMEINO 		+ "  AND ");
        sql.append(TBTHB1DOWN.URMEINO 		+ " = " + TBTHB2KMEI.URMEINO 		+ "  AND ");
        sql.append(TBTHB1DOWN.TJYUTNO 		+ " = " + "' '" 					+ "  AND ");
        //�}�́F�e���r�^�C��
        if(_baitai.equals(C_BAITAI_TV_TIME)){
            sql.append(				  TBTHB2KMEI.CODE6 		 + " IN "+ " ('001' , '002' ) "  				+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE1 	+")" + " = " + " '01' "								+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE5 	+")" + " = " + "mast1." +TBTHBAMST.FIELD1 + "(+)"	+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE2 	+")" + " = " + "mast3." +TBTHBAMST.FIELD1 + "(+)"	+ "      ");
        }
        //�}�́F���W�I�^�C��
        else if(_baitai.equals(C_BAITAI_RD_TIME)){
            sql.append(				  TBTHB2KMEI.CODE6 		 + " IN "+ " ('003' , '004' ) "  				+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE1 	+")" + " = " + " '04' "								+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE5 	+")" + " = " + "mast1." +TBTHBAMST.FIELD1 + "(+)"	+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE2 	+")" + " = " + "mast3." +TBTHBAMST.FIELD1 + "(+)"	+ "      ");
        }
        //�}�́F�e���r�X�|�b�g
        else if(_baitai.equals(C_BAITAI_TV_SPOT)){
            sql.append(				  TBTHB2KMEI.CODE6 		 + " = " + " '005' "  							+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE1 	+")" + " = " + " '02' "								+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE2 	+")" + " = " + "mast3." +TBTHBAMST.FIELD1			+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE3 	+")" + " = " + "mast5." +TBTHBAMST.FIELD1			+ "      ");
        }
        //�}�́F���W�I�X�|�b�g
        else if(_baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append(				  TBTHB2KMEI.CODE6 		 + " = " + " '005' "  							+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE1 	+")" + " = " + " '05' "								+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE2 	+")" + " = " + "mast3." +TBTHBAMST.FIELD1			+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE3 	+")" + " = " + "mast5." +TBTHBAMST.FIELD1			+ "      ");
        }
        //*************************************************************************************************
        //OREDER BY
        //*************************************************************************************************
        sql.append(" ORDER BY ");
        //�}�́F�e���r�^�C���A���W�I�^�C��
        if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_RD_TIME)){
            sql.append(TBTHB2KMEI.CODE6 					+ ", ");
            sql.append("mast1."	+ TBTHBAMST.INTVALUE6 		+ ", ");
            sql.append("thb2."	+ TBTHB2KMEI.CODE5 			+ ", ");
            sql.append("thb2."	+ TBTHB2KMEI.CODE2 			+ "  ");
        }
        //�}�́F�e���r�X�|�b�g�A���W�I�X�|�b�g
        else if(_baitai.equals(C_BAITAI_TV_SPOT) || _baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append("thb2."	+ TBTHB2KMEI.CODE3 			+ ", ");	//�u�����h�R�[�h
            sql.append("mast3."	+ TBTHBAMST.FIELD1 			+ ", ");	//�ǃR�[�h
            sql.append("mast3."	+ TBTHBAMST.FIELD4 			+ ", ");
            sql.append("thb2."	+ TBTHB2KMEI.CODE2 			+ "  ");	//�ǃR�[�h
        }

        return sql.toString();
    }

    /**
     * ���[�f�[�^(���C�I��)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportLionVO> findReportLionByCondition(ReportLionCondition cond)
            throws KKHException {

        super.setModel(new ReportLionVO());

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
    protected List<ReportLionVO> createFindedModelInstances(List hashList) {
        List<ReportLionVO> list = new ArrayList<ReportLionVO>();
        if (getModel() instanceof ReportLionVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportLionVO vo = new ReportLionVO();
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));			//
                vo.setName3((String) result.get(TBTHB2KMEI.NAME3.toUpperCase()));			//��No
                vo.setName4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase()));			//�󒍖���No
                vo.setName5((String) result.get(TBTHB2KMEI.NAME5.toUpperCase()));			//
                vo.setName6((String) result.get(TBTHB2KMEI.NAME6.toUpperCase()));			//�������[No
                vo.setName7((String) result.get(TBTHB2KMEI.NAME7.toUpperCase()));			//
                vo.setName11((String) result.get(TBTHB2KMEI.NAME11.toUpperCase()));			//
                vo.setName12((String) result.get(TBTHB2KMEI.NAME12.toUpperCase()));			//
                vo.setName13((String) result.get(TBTHB2KMEI.NAME13.toUpperCase()));			//���l�P(�G��)
                vo.setName14((String) result.get(TBTHB2KMEI.NAME14.toUpperCase()));			//���l�Q(�G��)
                vo.setName15((String) result.get(TBTHB2KMEI.NAME15.toUpperCase()));			//
                vo.setName16((String) result.get(TBTHB2KMEI.NAME16.toUpperCase()));			//���l�P(�V��)
                vo.setName17((String) result.get(TBTHB2KMEI.NAME17.toUpperCase()));			//���l�Q(�V��)
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));			//
                vo.setCode2((String) result.get(TBTHB2KMEI.CODE2.toUpperCase().trim()));			//
                vo.setCode3((String) result.get(TBTHB2KMEI.CODE3.toUpperCase().trim()));			//
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));			//
                vo.setCode5((String) result.get(TBTHB2KMEI.CODE5.toUpperCase().trim()));			//
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));			//
                vo.setSonota1((String) result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));		//
                vo.setSonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));		//
                vo.setSonota7((String) result.get(TBTHB2KMEI.SONOTA7.toUpperCase()));		//
                vo.setSonota9((String) result.get(TBTHB2KMEI.SONOTA9.toUpperCase()));		//
                vo.setKngk2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase()));		//���z2
                vo.setKngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase()));		//���z2
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));		//�����z
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));	//�l���z
                vo.setJyutNo((String) result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));			//��No
                vo.setJyMeiNo((String) result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));		//�󒍖���No
                vo.setUrMeiNo((String) result.get(TBTHB2KMEI.URMEINO.toUpperCase()));		//���㖾��No
                vo.setRenbn((String) result.get(TBTHB2KMEI.RENBN.toUpperCase()));
                vo.setKbn2((String) result.get(TBTHB2KMEI.KBN2.toUpperCase()));				//�l���敪(1:�l���s)
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
                vo.setBasho((String) result.get(ReportLionVO.BASHO.toUpperCase()));				//�ꏊ
                vo.setSaizu((String) result.get(ReportLionVO.SAIZU.toUpperCase()));				//�T�C�Y
                vo.setKizatsu((String) result.get(ReportLionVO.KIZATSU.toUpperCase()));			//�L�G
                vo.setChoyu((String) result.get(ReportLionVO.CHOYU.toUpperCase()));				//���[
                vo.setMedia((String) result.get(ReportLionVO.MEDIA.toUpperCase()));				//���f�B�A
                vo.setMediaRya((String) result.get(ReportLionVO.MEDIARYA.toUpperCase()));		//���f�B�A(��)
                vo.setIrozuri((String) result.get(ReportLionVO.IROZURI.toUpperCase()));			//�F��

                vo.setShohizeiGak((BigDecimal) result.get(ReportLionVO.SHOHIZEI_GAK.toUpperCase()));	//����Ŋz

                vo.setByosuGokei((BigDecimal) result.get(ReportLionVO.BYOSU_GOKEI.toUpperCase()));		//CM�b�����v

                vo.setBrandCd((String) result.get(ReportLionVO.BRAND_CD.toUpperCase()));			//�u�����h�R�[�h
                vo.setBrandMei((String) result.get(ReportLionVO.BRAND_MEI.toUpperCase()));			//�u�����h����

                vo.setKyokuCd((String) result.get(ReportLionVO.KYOKU_CD.toUpperCase()));			//�ǃR�[�h
                vo.setKyokuMei((String) result.get(ReportLionVO.KYOKU_MEI.toUpperCase()));			//�ǖ���

                vo.setBangumiCd((String) result.get(ReportLionVO.BANGUMI_CD.toUpperCase()));		//�ԑg�R�[�h
                vo.setBangumiMei((String) result.get(ReportLionVO.BANGUMI_MEI.toUpperCase()));		//�ԑg����

                vo.setTvKyokuCd((String) result.get(ReportLionVO.TV_KYOKU_CD.toUpperCase()));		//�e���r�ǃR�[�h
                vo.setTvKyokuMei((String) result.get(ReportLionVO.TV_KYOKU_MEI.toUpperCase()));		//�e���r�ǖ���
                vo.setTvBangumiCd((String) result.get(ReportLionVO.TV_BANGUMI_CD.toUpperCase()));	//�e���r�ԑg�R�[�h
                vo.setTvBangumiMei((String) result.get(ReportLionVO.TV_BANGUMI_MEI.toUpperCase()));	//�e���r�ԑg����

                vo.setRdKyokuCd((String) result.get(ReportLionVO.RD_KYOKU_CD.toUpperCase()));		//���W�I�ǃR�[�h
                vo.setRdKyokuMei((String) result.get(ReportLionVO.RD_KYOKU_MEI.toUpperCase()));		//���W�I�ǖ���
                vo.setRdBangumiCd((String) result.get(ReportLionVO.RD_BANGUMI_CD.toUpperCase()));	//���W�I�ԑg�R�[�h
                vo.setRdBangumiMei((String) result.get(ReportLionVO.RD_BANGUMI_MEI.toUpperCase()));	//���W�I�ԑg����

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
