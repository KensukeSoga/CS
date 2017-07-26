package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB10WLRDB;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
//import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionSonotaDAO.SqlMode;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ���C�I�����[(���Ϗ�)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/5 fourm H.izawa)<BR>
 * �E����Œ[�������Ή�(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author fourm H.izawa
 */

public class NewReportLionDAO extends AbstractRdbDao {

    /** �ėp�}�X�^�������� */
    private NewReportLionCondition _cond;

    //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
    //�\�[�V�������f�B�A�ƃf�W�^�������ǉ�
    private enum SqlMode {SHINBUN,ZASHI,KOUTSU,JIGYOUHI,MOBILE,INTERNET,TIRASHI,SONOTA,
        SAMPLING,BSCS,TVSPOT,TVTIME,RADIOTIME,RADIOSPOT,SOCIALMEDIA,DIGITALMOVIE,ALLBAITAI };
    /* private enum SqlMode {SHINBUN,ZASHI,KOUTSU,JIGYOUHI,MOBILE,INTERNET,
                            TIRASHI,SONOTA,SAMPLING,BSCS,TVSPOT,TVTIME,RADIOTIME,RADIOSPOT,ALLBAITAI };*/
    //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod End
    private SqlMode _sqlMode = SqlMode.SHINBUN;

    private enum BaitaiCode {
    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
    	//�\�[�V�������f�B�A�ƃf�W�^�������ǉ�
    	SHINBUN("130"),ZASHI("140"),KOUTSU("150"),JIGYOUHI("250"),MOBILE("260"),INTERNET("116"),
    	TIRASHI("280"),SONOTA("190"),SAMPLING("290"),BSCS("300"),TVSPOT("110"),TVTIME("100"),
        RADIOTIME("120"),RADIOSPOT("125"),SOCIALMEDIA("117"),DIGITALMOVIE("118"),ALLBAITAI("900");
//        SHINBUN("130"),ZASHI("140"),KOUTSU("150"),JIGYOUHI("250"),MOBILE("260"),INTERNET("116"),
//        TIRASHI("280"),SONOTA("190"),SAMPLING("290"),BSCS("300"),TVSPOT("110"),TVTIME("100"),
//        RADIOTIME("120"),RADIOSPOT("125"),ALLBAITAI("900");
    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod End

        private final String _code;

        private BaitaiCode(String code) {
            _code = code;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }
    }

    /**
     * �C�����C���r���[
     */
    private static final String TBTB1 = "TB1";
    private static final String TBMST = "MST";

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public NewReportLionDAO() {
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

        //�\��
        if(_cond.getBaitaiCd().equals(BaitaiCode.ALLBAITAI.getCode()))
        {
            _sqlMode = SqlMode.ALLBAITAI;
            return getSelectSQLForAllBaitai();
        }
        //�V��
        if(_cond.getBaitaiCd().equals(BaitaiCode.SHINBUN.getCode()))
        {
            _sqlMode = SqlMode.SHINBUN;
            return  getSelectSQLForShinbun();
        }
        //�G��
        else if(_cond.getBaitaiCd().equals(BaitaiCode.ZASHI.getCode()))
        {
            _sqlMode = SqlMode.ZASHI;
            return  getSelectSQLForZashi();
        }
        //���
        else if(_cond.getBaitaiCd().equals(BaitaiCode.KOUTSU.getCode()))
        {
            _sqlMode = SqlMode.KOUTSU;
            return  getSelectSQLForKoutsu();
        }
        //���Ɣ�
        else if(_cond.getBaitaiCd().equals(BaitaiCode.JIGYOUHI.getCode()))
        {
            _sqlMode = SqlMode.JIGYOUHI;
            return  getSelectSQLForJigyouhi();
        }
        //���o�C��
        else if(_cond.getBaitaiCd().equals(BaitaiCode.MOBILE.getCode()))
        {
            _sqlMode = SqlMode.MOBILE;
            return  getSelectSQLForMobile();
        }
        //�C���^�[�l�b�g
        else if(_cond.getBaitaiCd().equals(BaitaiCode.INTERNET.getCode()))
        {
            _sqlMode = SqlMode.INTERNET;
            return  getSelectSQLForInterNet();
        }
        //�`���V
        else if(_cond.getBaitaiCd().equals(BaitaiCode.TIRASHI.getCode()))
        {
            _sqlMode = SqlMode.TIRASHI;
            return  getSelectSQLForTirashi();
        }
        //���̑�
        else if(_cond.getBaitaiCd().equals(BaitaiCode.SONOTA.getCode()))
        {
            _sqlMode = SqlMode.SONOTA;
            return  getSelectSQLForSonota();
        }
        //�T���v�����O
        else if(_cond.getBaitaiCd().equals(BaitaiCode.SAMPLING.getCode()))
        {
            _sqlMode = SqlMode.SAMPLING;
            return  getSelectSQLForSampling();
        }
        //BSCS
        else if(_cond.getBaitaiCd().equals(BaitaiCode.BSCS.getCode()))
        {
            _sqlMode = SqlMode.BSCS;
            return  getSelectSQLForBsCs();
        }
        //�e���r�X�|�b�g
        else if(_cond.getBaitaiCd().equals(BaitaiCode.TVSPOT.getCode()))
        {
            _sqlMode = SqlMode.TVSPOT;
            return  getSelectSQLForTvSpot();
        }
        //�e���r�^�C��
        else if(_cond.getBaitaiCd().equals(BaitaiCode.TVTIME.getCode()))
        {
            _sqlMode = SqlMode.TVTIME;
            return getSelectSQLForTvTime();
        }
        //���W�I�^�C��
        else if(_cond.getBaitaiCd().equals(BaitaiCode.RADIOTIME.getCode()))
        {
            _sqlMode = SqlMode.RADIOTIME;
            return  getSelectSQLForRadioTime();
        }
        //���W�I�X�|�b�g
        else if(_cond.getBaitaiCd().equals(BaitaiCode.RADIOSPOT.getCode()))
        {
            _sqlMode = SqlMode.RADIOSPOT;
            return  getSelectSQLForRadioSpot();
        }
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
        //�\�[�V�������f�B�A�ƃf�W�^�������ǉ�
        //�\�[�V�������f�B�A
        else if(_cond.getBaitaiCd().equals(BaitaiCode.SOCIALMEDIA.getCode()))
        {
            _sqlMode = SqlMode.SOCIALMEDIA;
            return  getSelectSQLForSocialMedia();
        }
        //�f�W�^������
        else if(_cond.getBaitaiCd().equals(BaitaiCode.DIGITALMOVIE.getCode()))
        {
            _sqlMode = SqlMode.DIGITALMOVIE;
            return  getSelectSQLForDigitalMovie();
        }
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End
        return null;
    }

    //*********************
    //�\������
    //*********************
    private String getSelectSQLForAllBaitai() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        sql.append(" " + TBTHB2KMEI.CODE6 + " " + NewReportLionVO.BAITAICD+ ",");                                                       //�}�̃R�[�h
        sql.append("  " + TBTHB2KMEI.CODE1 + " " + NewReportLionVO.BAITAIKOCD+ ",");                                                    //�}�̎q�R�[�h
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + "," );                                        //����ŗ�
        sql.append("  SUM(" + TBTHB2KMEI.SEIGAK + ") " + NewReportLionVO.SUMSEIGAK+ ",");                                               //�������z���v
        sql.append("  SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ "))) " + NewReportLionVO.SUMSZEIGAK);   //����Ŋz���v
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01),");
        sql.append(" " + TBTHB2KMEI.CODE1);
        sql.append(" ORDER BY");
        sql.append(" " + TBTHB2KMEI.CODE6);

        return sql.toString();
    }

    //*********************
    //�V������
    //*********************
    private String getSelectSQLForShinbun() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append("  " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ", ");//���i��
        sql.append("  mast1." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SHIMEI + " , "); //����
        sql.append("  " + TBTHB2KMEI.CODE2 + " " + NewReportLionVO.KYOKUCD + " , "); //�ǎ��R�[�h
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN + " " );
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.SYURUI + ", "); //�f��
        sql.append("  " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ", ");//���ς��藿��
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //����ŗ�
        sql.append("  DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ ")) " + NewReportLionVO.SZEIGAK+ ", ");//����Ŋz
        sql.append("  " + TBTHB2KMEI.NAME4 +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//�艿����
        //sql.append("  " + TBTHB1DOWN.FIELD11 +  " "+ NewReportLionVO.SPACE + ", ");//�X�y�[�X
        //sql.append("  " + TBTHB2KMEI.NAME7 +  " "+ NewReportLionVO.KIKAN + ", ");//�f�ڊ���
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN + " " );
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD11 + " ");
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.SPACE + ", ");//�X�y�[�X
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN + " " );
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12 + " ");
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10 + " ");
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6 + " ");
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3 + " ");
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.KIKAN + ", ");//�f�ڊ���
        sql.append("  mast2." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + " , "); //�����u�����h
        sql.append("  " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ " ");//�R�[�h�i�u�����h�j
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast1 ,  ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast2   ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('007') AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = mast1." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast1." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast1." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast1." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = mast2." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast2." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast2." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast2." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" mast1." + TBTHBAMST.SYBT + " = '105' AND ");
        sql.append(" mast2." + TBTHBAMST.SYBT + " = '201' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = mast1." + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = mast2." + TBTHBAMST.FIELD1 + "  ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB1DOWN.JYUTNO + ", ");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ", ");
        sql.append("  " + TBTHB1DOWN.URMEINO + " ");

        return sql.toString();
    }

    //*********************
    //�G������
    //*********************
    private String getSelectSQLForZashi() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append("  " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ", ");//���i��
        sql.append("  mast1." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.ZASHIMEI + " , "); //�G����
        sql.append("  " + TBTHB2KMEI.CODE2 + " " + NewReportLionVO.ZASHICD + ", ");//�G���R�[�h
        sql.append("  " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ", ");//���ς��藿��
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //����ŗ�
        sql.append("  DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ ")) " + NewReportLionVO.SZEIGAK+ ", ");//����Ŋz
        sql.append("  " + TBTHB2KMEI.NAME4 +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//�艿����
        sql.append("  " + TBTHB2KMEI.NAME2 +  " "+ NewReportLionVO.SPACE + ", ");//�X�y�[�X
        //sql.append("  " + TBTHB2KMEI.NAME7 +  " "+ NewReportLionVO.KIKAN + ", ");//�f�ڊ���
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN + " " );
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12 + " ");
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10 + " ");
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6 + " ");
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3 + " ");
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.KIKAN + ", ");//�f�ڊ���
        sql.append("  mast2." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + " , "); //�����u�����h
        sql.append("  " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ " ");//�R�[�h�i�u�����h�j
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast1 ,  ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast2   ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('008') AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
        sql.append(" mast1." + TBTHBAMST.SYBT + " = '106' AND ");
        sql.append(" mast2." + TBTHBAMST.SYBT + " = '201' AND ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = mast1." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast1." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast1." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast1." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = mast2." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast2." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast2." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast2." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = mast1." + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = mast2." + TBTHBAMST.FIELD1 + "  ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB1DOWN.JYUTNO + ", ");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ", ");
        sql.append("  " + TBTHB1DOWN.URMEINO + " ");

        return sql.toString();
    }

    //*********************
    //��ʌ���
    //*********************
    private String getSelectSQLForKoutsu() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");                                                  //���i��
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");                                              //���ϗ���
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + "," );                                    //����ŗ�
        sql.append(" DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ ")) " + NewReportLionVO.SZEIGAK+ ",");  //����Ŋz
        //sql.append("  " + TBTHB2KMEI.NAME4 +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//�艿����
        //sql.append("  " + TBTHB2KMEI.NAME7 +  " "+ NewReportLionVO.KIKAN + ", ");//�f�ڊ���
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                                                          //�f�ڊ���
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");                                               //�����u�����h
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE);                                                            //�R�[�h�i�u�����h�j
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '009' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        sql.append(" " + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" " + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    //*********************
    //���Ɣ��
    //*********************
    private String getSelectSQLForJigyouhi() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append("  " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ", ");//���i��
        sql.append("  MST2." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SYURUI + " , "); //���
        sql.append("  " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ", ");//���ς��藿��
        sql.append("  " + TBTHB2KMEI.NAME4 +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//�艿����
        //sql.append("  " + TBTHB2KMEI.NAME7 +  " "+ NewReportLionVO.KIKAN + ", ");//�f�ڊ���
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN + " " );
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12 + " ");
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10 + " ");
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6 + " ");
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3 + " ");
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.KIKAN + ", ");//�f�ڊ���
        sql.append("  MST1." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + " , "); //�����u�����h
        sql.append("  " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ", ");//�R�[�h�i�u�����h�j
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //����ŗ�
        sql.append("  " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK + " ");//����Ŋz
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " MST1,  ");
        sql.append("  " + TBTHBAMST.TBNAME + " MST2  ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('019') AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
        sql.append(" MST1." + TBTHBAMST.SYBT + " = '201' AND ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = MST1." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = MST1." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = MST1." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = MST1." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = MST1." + TBTHBAMST.FIELD1 + " AND  ");
        sql.append(" MST2." + TBTHBAMST.SYBT + " = '104' AND ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = MST2." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = MST2." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = MST2." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = MST2." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = MST2." + TBTHBAMST.FIELD1 + "  ");
        sql.append(" ORDER BY ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(NewReportLionVO.CODE + ",");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append("  " + TBTHB1DOWN.JYUTNO + ", ");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ", ");
        sql.append("  " + TBTHB1DOWN.URMEINO + " ");

        return sql.toString();
    }

    //*********************
    //���o�C������
    //*********************
    private String getSelectSQLForMobile() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");                                                  //���i��
        sql.append(" " + TBTHB1DOWN.HIMKNMKJ + " " + NewReportLionVO.HIMOKUMEI+ ",");                                               //��ږ�
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");                                              //���ϗ����A�艿����
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ",");                                     //����ŗ�
        sql.append(" DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ ")) " + NewReportLionVO.SZEIGAK+ ",");   //����Ŋz
        //sql.append("  " + TBTHB1DOWN.FIELD10 + " " + NewReportLionVO.KIKAN+ ", ");//����
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                                                          //����
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");                                               //�����u�����h
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE);                                                            //�R�[�h�i�u�����h�j
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '018' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        sql.append("  " + TBTHB1DOWN.JYUTNO + ",");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ",");
        sql.append("  " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    //*********************
    //�C���^�[�l�b�g����
    //*********************
    private String getSelectSQLForInterNet() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //���i��
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //���ϗ���
        //sql.append("  " + TBTHB1DOWN.FIELD3 +  " "+ NewReportLionVO.KIKAN + ", ");//����
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //����
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");           //�����u�����h
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ",");                   //�R�[�h�i�u�����h�j
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ","); //����ŗ�
        sql.append("  " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);                    //����Ŋz
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '017' AND");
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
        //�}�̋敪��ǉ�
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '17' AND");
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append("  " + TBTHB1DOWN.JYUTNO + ",");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ",");
        sql.append("  " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }
    //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
    //*********************
    //�\�[�V�������f�B�A����
    //*********************
    private String getSelectSQLForSocialMedia() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //���i��
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //���ϗ���
        //sql.append("  " + TBTHB1DOWN.FIELD3 +  " "+ NewReportLionVO.KIKAN + ", ");//����
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //����
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");           //�����u�����h
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ",");                   //�R�[�h�i�u�����h�j
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ","); //����ŗ�
        sql.append("  " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);                    //����Ŋz
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '017' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '1B' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append("  " + TBTHB1DOWN.JYUTNO + ",");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ",");
        sql.append("  " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }
  //*********************
    //�f�W�^�����挟��
    //*********************
    private String getSelectSQLForDigitalMovie() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //���i��
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //���ϗ���
        //sql.append("  " + TBTHB1DOWN.FIELD3 +  " "+ NewReportLionVO.KIKAN + ", ");//����
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //����
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");           //�����u�����h
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ",");                   //�R�[�h�i�u�����h�j
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ","); //����ŗ�
        sql.append("  " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);                    //����Ŋz
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '017' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '1C' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append("  " + TBTHB1DOWN.JYUTNO + ",");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ",");
        sql.append("  " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }
    //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End

    //*********************
    //�`���V����
    //*********************
    private String getSelectSQLForTirashi() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //���i��
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //���ϗ���
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + " ,");          //�����u�����h
        //sql.append("  " + TBTHB1DOWN.FIELD12 + " " + NewReportLionVO.KIKAN+ ", ");//����
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //����
        sql.append(" " + TBTHB2KMEI.CODE3 + " "+ NewReportLionVO.CODE+ ",");                    //�R�[�h�i�u�����h�j
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + "," );//����ŗ�
        sql.append(" " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);                     //����Ŋz
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '014' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" " + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    //*********************
    //���̑�����
    //*********************
    private String getSelectSQLForSonota() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //���i��
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //���ϗ���
        //sql.append("  " + TBTHB1DOWN.FIELD5 +  " "+ NewReportLionVO.KIKAN + ", ");//����
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //����
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");           //�����u�����h
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ",");                   //�R�[�h�i�u�����h�j
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) "+ NewReportLionVO.SHOHIZEI_RITU+ ",");   //����ŗ�
        sql.append(" " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);//����Ŋz
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '010' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" " + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    //*********************
    //�T���v�����O����
    //*********************
    private String getSelectSQLForSampling() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //���i��
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //���ϗ���
        //sql.append("  " + TBTHB1DOWN.FIELD12 +  " "+ NewReportLionVO.KIKAN + ", ");//����
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //����
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");           //�����u�����h
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ",");                   //�R�[�h�i�u�����h�j
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ","); //����ŗ�
        sql.append(" " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);                     //����Ŋz
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '015' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" " + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    //*********************
    //BSCS����
    //*********************
    private String getSelectSQLForBsCs() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" " + TBTHB9WLTVB.BANNAME + " " + NewReportLionVO.BANMEI + ",");                                                 //�ԑg��
        //sql.append("  " + TBTHB11WLTVK.KYOKUNAME + " " + NewReportLionVO.HOUSOUKYOKU + ",");                                      //������
        sql.append(" " + TBTHB1DOWN.FIELD2 + " " + NewReportLionVO.HOUSOUKYOKU + ",");                                              //������
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");                                              //���ϗ���
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," );                                                        //����ŗ�
        sql.append(" DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ ")) " + NewReportLionVO.SZEIGAK+ ",");   //����Ŋz
        sql.append(" " + TBTHB2KMEI.KNGK1 +  " "+ NewReportLionVO.TEIKARYOKIN + ",");                                               //��������
        sql.append(" " + TBTHB2KMEI.SONOTA7 +  " "+ NewReportLionVO.CMBYOUSU + ",");                                                //�b��
        sql.append(" " + TBTHB2KMEI.SONOTA5 +  " "+ NewReportLionVO.HONSU + ",");                                                   //�{��
        sql.append(" " + TBTHB1DOWN.FIELD8 +  " "+ NewReportLionVO.KIKAN + ",");                                                    //��������
        sql.append(" " + TBTHB2KMEI.CODE5 +  " "+ NewReportLionVO.BANCD + ",");                                                     //�ԑg�R�[�h
        sql.append(" " + TBTHB2KMEI.CODE2 +  " "+ NewReportLionVO.KYOKUCD);                                                         //�ǎ��R�[�h
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        sql.append(", " + TBTHB2KMEI.CODE3 + " " + NewReportLionVO.CODE);                                                           //�u�����h�R�[�h
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        //sql.append("  " + TBTHB11WLTVK.TBNAME + ", ");
        sql.append("  " + TBTHB9WLTVB.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('016') AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE5 + ") = " + TBTHB9WLTVB.BANCD);
        //sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = " + TBTHB11WLTVK.KYOKUCD + "  ");
        sql.append(" ORDER BY");
        sql.append("  " + TBTHB1DOWN.JYUTNO + ",");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ",");
        /* 2015/08/18 UnixAB���@�T�[�o���v���[�X�Ή� oki keisuke  UPD START*/
        sql.append("  " + TBTHB1DOWN.URMEINO + ",");
        sql.append("  " + TBTHB9WLTVB.HYOJIJYUN + ",");
        sql.append("  " + TBTHB2KMEI.RENBN + " ");
        // sql.append("  " + TBTHB1DOWN.URMEINO );
        /* 2015/08/18 UnixAB���@�T�[�o���v���[�X�Ή� oki keisuke UPD END*/

        return sql.toString();
    }

    //*********************
    //�e���r�^�C������
    //*********************
    private String getSelectSQLForTvTime(){

        // SQL.
        StringBuffer sql = new StringBuffer();

        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto MOD start */
        //���s�v�ȓ����������������邱�Ƃɂ��p�t�H�[�}���X���P
        sql.append("SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTB1 + "." + NewReportLionVO.KENNAME + ",");              //�ԑg��
        sql.append(" " + TBTB1 + "." + NewReportLionVO.HOUSOUKYOKU + ",");          //������
        sql.append(" " + TBTB1 + "." + NewReportLionVO.NETKYOKU + ",");             //�l�b�g��
        sql.append(" " + TBTB1 + "." + NewReportLionVO.MITUMORIRYO + ",");          //���ϗ���
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SHOHIZEI_RITU + ",");        //����ŗ�
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SZEIGAK + ",");              //����Ŋz
        sql.append(" " + TBTB1 + "." + NewReportLionVO.CMBYOUSU + ",");             //CM�b��
        sql.append(" " + TBTB1 + "." + NewReportLionVO.HONSU + ",");                //�{��
        sql.append(" " + TBTB1 + "." + NewReportLionVO.TEIKARYOKIN + ",");          //��������
        sql.append(" " + TBTB1 + "." + NewReportLionVO.KIKAN + ",");                //����
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SUMSEIGAK + ",");            //���{�d�g��
        sql.append(" " + TBTHB9WLTVB.HYOJIJYUN + " " + NewReportLionVO.AREA + ","); //�\����
        sql.append(" " + TBTB1 + "." + NewReportLionVO.CODE);                       //�u�����h�R�[�h
        sql.append(" FROM");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " KENNAME,");
        sql.append(" " + TBTHB1DOWN.FIELD1 + " HOUSOUKYOKU,");
        sql.append(" " + TBTHB1DOWN.FIELD3 + " NETKYOKU,");
        sql.append(" " + TBTHB1DOWN.FIELD5 + " CMBYOUSU,");
        sql.append(" " + TBTHB1DOWN.FIELD6 + " HONSU,");
        sql.append(" " + TBTHB1DOWN.FIELD8 + " KIKAN,");
        sql.append(" " + TBTHB2KMEI.EGCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.CODE5 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + " * 0.01 SHOHIZEI_RITU,");
        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") MITUMORIRYO,");
        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM(" + TBTHB2KMEI.NAME1 + "))) SZEIGAK,");
        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + " + " + TBTHB2KMEI.KNGK2 + " + " + TBTHB2KMEI.KNGK3 + ") TEIKARYOKIN,");
        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + ") SUMSEIGAK,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " CODE");
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ( '001','002' ) AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" " + TBTHB1DOWN.FIELD1 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD3 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD5 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD6 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD8 + ",");
        sql.append(" " + TBTHB2KMEI.EGCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + TBTHB2KMEI.CODE3 + ",");
        sql.append(" " + TBTHB2KMEI.CODE5 + "");
        sql.append(" ) " + TBTB1 + ",");
        sql.append(" " + TBTHB9WLTVB.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB9WLTVB.EGCD + " = " + TBTB1 + "." + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB9WLTVB.TKSKGYCD + " = " + TBTB1 + "." + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB9WLTVB.TKSBMNSEQNO + " = " + TBTB1 + "." + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB9WLTVB.TKSTNTSEQNO + " = " + TBTB1 + "." + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB9WLTVB.BANCD + " = TRIM(" + TBTB1 + "." + TBTHB2KMEI.CODE5 + ")");
        sql.append(" ORDER BY");
        sql.append(" CAST(" + TBTHB9WLTVB.HYOJIJYUN + " AS INT),");
        sql.append(" " + TBTHB9WLTVB.BANCD);

//        sql.append(" SELECT ");
//        sql.append("  " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.KENNAME + ", ");//�ԑg��
//        sql.append("  " + TBTHB1DOWN.FIELD1+ " " + NewReportLionVO.HOUSOUKYOKU + ", ");//������
//        sql.append("  " + TBTHB1DOWN.FIELD3+ " " + NewReportLionVO.NETKYOKU + ", ");//�l�b�g��
//        sql.append("  TB1." + NewReportLionVO.MITUMORIRYO + " " + NewReportLionVO.MITUMORIRYO + ", ");//���ς��藿��
//        sql.append(" (TB1." + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //����ŗ�
//        sql.append("  TB1." + NewReportLionVO.SZEIGAK + " " + NewReportLionVO.SZEIGAK + ", ");//����Ŋz
//        sql.append("  " + TBTHB1DOWN.FIELD5+  " "+ NewReportLionVO.CMBYOUSU + ", ");//�b��
//        sql.append("  " + TBTHB1DOWN.FIELD6+  " "+ NewReportLionVO.HONSU + ", ");//�{��
//        sql.append("  TB1." + NewReportLionVO.TEIKARYOKIN +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//��������
//        sql.append("  " + TBTHB1DOWN.FIELD8 +  " "+ NewReportLionVO.KIKAN + ", ");//��������
//        //okazaki
//        sql.append("  TB1." + NewReportLionVO.SUMSEIGAK + " " + NewReportLionVO.SUMSEIGAK + ", ");//���{�d�g��
//        sql.append("  " + TBTHB9WLTVB.HYOJIJYUN + " " + NewReportLionVO.AREA + " ");//�\����
//        //okazaki
//        sql.append(" FROM ");
//        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
//        sql.append(" (SELECT ");
//        sql.append(" " + TBTHB2KMEI.EGCD + ", ");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ", ");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ", ");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ", ");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
//        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
//        sql.append(" " + TBTHB2KMEI.CODE5 + ", ");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ", ");
//        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK+ ") " + NewReportLionVO.MITUMORIRYO + ", ");
//        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ "))) " + NewReportLionVO.SZEIGAK+ ", ");//����Ŋz
//        sql.append(" SUM(" + TBTHB2KMEI.KNGK1+ " + " + TBTHB2KMEI.KNGK2+ " + " + TBTHB2KMEI.KNGK3+ ") " + NewReportLionVO.TEIKARYOKIN + ", ");
//        //okazaki
//        sql.append(" SUM(" + TBTHB2KMEI.KNGK1+ ") " + NewReportLionVO.SUMSEIGAK+ " "); //���{�d�g��
//        //okazaki
//        sql.append(" FROM ");
//        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
//        sql.append("  " + TBTHB2KMEI.TBNAME + " ");
//        sql.append(" WHERE ");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND ");
//        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('001','002') AND ");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
//        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '   ");
//        sql.append(" GROUP BY ");
//        sql.append(" " + TBTHB2KMEI.JYUTNO  + ", ");
//        sql.append(" " + TBTHB2KMEI.JYMEINO  + ", ");
//        sql.append(" " + TBTHB2KMEI.URMEINO  + ", ");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ", ");
//        sql.append(" " + TBTHB2KMEI.CODE5  + " ) TB1 , ");
//        sql.append(" " + TBTHB9WLTVB.TBNAME  + " ");
//        sql.append(" WHERE ");
//        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND ");
//        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
//        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
//        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
//        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND ");
//        sql.append(" TB1." + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " AND ");
//        sql.append(" TB1." + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
//        sql.append(" TB1." + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
//        sql.append(" " + TBTHB9WLTVB.EGCD + " (+) = TB1." + TBTHB2KMEI.EGCD + " AND ");
//        sql.append(" " + TBTHB9WLTVB.TKSKGYCD + " (+) = TB1." + TBTHB2KMEI.TKSKGYCD + " AND ");
//        sql.append(" " + TBTHB9WLTVB.TKSBMNSEQNO + " (+) = TB1." + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
//        sql.append(" " + TBTHB9WLTVB.TKSTNTSEQNO + " (+) = TB1." + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
//        sql.append(" " + TBTHB9WLTVB.BANCD + " (+) = TRIM(TB1." + TBTHB2KMEI.CODE5 + ") ");
//        sql.append(" ORDER BY ");
//        sql.append(" CAST(" + TBTHB9WLTVB.HYOJIJYUN  + " AS INT) , ");
//        sql.append(" " + TBTHB9WLTVB.BANCD  + " ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto MOD end */

        return sql.toString();
    }

    //*********************
    //�e���r�X�|�b�g����
    //*********************
    private String getSelectSQLForTvSpot() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto MOD start */
        //���s�v�ȓ����������������邱�Ƃɂ��p�t�H�[�}���X���P
        sql.append("SELECT");
        sql.append(" " + TBTB1 + "." + NewReportLionVO.KENNAME + ",");                                              //���i��
        sql.append(" CONCAT(" + TBTB1 + "." + TBTHB1DOWN.FIELD1 + ", '��') " + NewReportLionVO.HOUSOUKYOKU + ",");  //������
        sql.append(" " + TBTB1 + "." + NewReportLionVO.MITUMORIRYO + ",");                                          //���ϗ���
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SHOHIZEI_RITU + ",");                                        //����ŗ�
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SZEIGAK + ",");                                              //�������z
        sql.append(" " + TBTB1 + "." + NewReportLionVO.TEIKARYOKIN + ",");                                          //�艿����
        sql.append(" " + TBTB1 + "." + NewReportLionVO.CMBYOUSU + ",");                                             //CM�b��
        sql.append(" " + TBTB1 + "." + NewReportLionVO.KIKAN + ",");                                                //����
        sql.append(" " + TBMST + "." + NewReportLionVO.SEIKYUBRAND + ",");                                          //�����u�����h
        sql.append(" " + TBMST + "." + NewReportLionVO.CODE);                                                       //�u�����h�R�[�h
        sql.append(" FROM");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" " + TBTHBAMST.FIELD1 + " " + NewReportLionVO.CODE + ",");
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND);
        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201'");
        sql.append(" ) " + TBMST + ",");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.KENNAME + ",");
        sql.append(" " + TBTHB1DOWN.FIELD1 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD4 + " " + NewReportLionVO.KIKAN + ",");
        sql.append(" " + TBTHB1DOWN.FIELD5 + " " + NewReportLionVO.CMBYOUSU + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") " + TBTHB2KMEI.CODE3 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + " * 0.01 " + NewReportLionVO.SHOHIZEI_RITU + ",");
        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") " + NewReportLionVO.MITUMORIRYO + ",");
        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM(" + TBTHB2KMEI.NAME1 + "))) " + NewReportLionVO.SZEIGAK + ",");
        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + ") " + NewReportLionVO.TEIKARYOKIN);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '005' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '02' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" " + TBTHB1DOWN.FIELD1 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD4 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD5 + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + TBTHB2KMEI.CODE3);
        sql.append(" ) " + TBTB1);
        sql.append(" WHERE");
        sql.append(" " + TBTB1 + "." + TBTHB2KMEI.CODE3 + " = " + TBMST + "." + NewReportLionVO.CODE);
        /* 2015/08/18 UnixAB���@�T�[�o���v���[�X�Ή� oki keisuke ADD START*/
        sql.append(" ORDER BY");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + NewReportLionVO.SHOHIZEI_RITU + ",");
        sql.append(" " + TBTHB2KMEI.CODE3 + " ");
        /* 2015/08/18 UnixAB���@�T�[�o���v���[�X�Ή� oki keisuke ADD END*/

        //sql.append(" SELECT ");
        //sql.append("/*+ ordered */");
        //sql.append("  " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.KENNAME + ", ");//���i��
        //sql.append("  CONCAT(" + TBTHB1DOWN.FIELD1+ ", '��') " + NewReportLionVO.HOUSOUKYOKU+ ", ");//������
        //sql.append("  TB1." + NewReportLionVO.MITUMORIRYO + " " + NewReportLionVO.MITUMORIRYO + ", ");//���ς��藿��
        //sql.append(" (TB1." + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //����ŗ�
        //sql.append("  TB1." + NewReportLionVO.SZEIGAK + " " + NewReportLionVO.SZEIGAK + ", ");//����Ŋz
        //sql.append("  TB1." + NewReportLionVO.TEIKARYOKIN +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//��������
        //sql.append("  " + TBTHB1DOWN.FIELD5 +  " "+ NewReportLionVO.CMBYOUSU + ", ");//�f�ޕb��
        //sql.append("  " + TBTHB1DOWN.FIELD4 +  " "+ NewReportLionVO.KIKAN + ", ");//��������
        //sql.append("  " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + " , "); //�����u�����h
        //sql.append("  " + TBTHBAMST.FIELD1 +  " "+ NewReportLionVO.CODE+ " ");//�R�[�h�i�u�����h�j
        //sql.append(" FROM ");
        //sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        //sql.append("  " + TBTHBAMST.TBNAME + ", ");
        //sql.append(" (SELECT ");
        //sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        //sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        //sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        //sql.append(" " + TBTHB2KMEI.CODE3 + ", ");
        //sql.append(" " + TBTHB2KMEI.RITU1 + ", ");
        //sql.append(" SUM(" + TBTHB2KMEI.SEIGAK+ ") " + NewReportLionVO.MITUMORIRYO + ", ");
        //sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ "))) " + NewReportLionVO.SZEIGAK+ ", ");//����Ŋz
        //sql.append(" SUM(" + TBTHB2KMEI.KNGK1+ ") " + NewReportLionVO.TEIKARYOKIN + " ");
        //sql.append(" FROM ");
        //sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        //sql.append("  " + TBTHB2KMEI.TBNAME + " ");
        //sql.append(" WHERE ");
        //sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        //sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        //sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        //sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        //sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND ");
        //sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('005') AND ");
        //sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('02') AND ");
        //sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        //sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        //sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        //sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        //sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        //sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        //sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        //sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        //sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '   ");
        //sql.append(" GROUP BY ");
        //sql.append(" " + TBTHB2KMEI.JYUTNO  + ", ");
        //sql.append(" " + TBTHB2KMEI.JYMEINO  + ", ");
        //sql.append(" " + TBTHB2KMEI.URMEINO  + ", ");
        //sql.append(" " + TBTHB2KMEI.RITU1 + ", ");
        //sql.append(" " + TBTHB2KMEI.CODE3  + " ) TB1 ");
        //sql.append(" WHERE ");
        //sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        //sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        //sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        //sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        //sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND ");
        //sql.append(" TB1." + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " AND ");
        //sql.append(" TB1." + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        //sql.append(" TB1." + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        //sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
        //sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHBAMST.EGCD + " AND ");
        //sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND ");
        //sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND ");
        //sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND ");
        //sql.append(" " + TBTHBAMST.SYBT + " = '201' AND ");
        //sql.append(" TRIM(TB1." + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1 + "   ");
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto MOD end */

        return sql.toString();
    }

    //*********************
    //���W�I�^�C������
    //*********************
    private String getSelectSQLForRadioTime() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        //���s�v�ȓ����������������邱�Ƃɂ��p�t�H�[�}���X���P
        sql.append("SELECT");
        sql.append(" " + TBTB1 + "." + NewReportLionVO.BANMEI + ",");                   //�ԑg��
        sql.append(" " + TBTB1 + "." + NewReportLionVO.HOUSOUKYOKU + ",");              //������
        sql.append(" " + TBTB1 + "." + NewReportLionVO.MITUMORIRYO + ",");              //���ϗ���
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SHOHIZEI_RITU + ",");            //����ŗ�
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SZEIGAK + ",");                  //����Ŋz
        sql.append(" " + TBTB1 + "." + NewReportLionVO.CMBYOUSU + ",");                 //CM�b��
        sql.append(" " + TBTB1 + "." + NewReportLionVO.HONSU + ",");                    //�{��
        sql.append(" " + TBTB1 + "." + NewReportLionVO.TEIKARYOKIN + ",");              //���{�����{������������
        sql.append(" " + TBTB1 + "." + NewReportLionVO.KIKAN + ",");                    //����
        sql.append(" " + TBTHB10WLRDB.HYOJIJYUN + " " + NewReportLionVO.AREA + ",");    //�\����
        sql.append(" " + TBTB1 + "." + NewReportLionVO.CODE);                           //�u�����h�R�[�h
        sql.append(" FROM");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " BANMEI,");
        sql.append(" " + TBTHB1DOWN.FIELD1 + " HOUSOUKYOKU,");
        sql.append(" " + TBTHB1DOWN.FIELD5 + " CMBYOUSU,");
        sql.append(" " + TBTHB1DOWN.FIELD6 + " HONSU,");
        sql.append(" " + TBTHB1DOWN.FIELD8 + " KIKAN,");
        sql.append(" " + TBTHB2KMEI.EGCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.CODE5 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + " * 0.01 SHOHIZEI_RITU,");
        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") MITUMORIRYO,");
        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM(" + TBTHB2KMEI.NAME1 + "))) SZEIGAK,");
        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + " + " + TBTHB2KMEI.KNGK3 + " ) TEIKARYOKIN,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " CODE");
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ( '003','004' ) AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " =" + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" " + TBTHB1DOWN.FIELD1 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD5 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD6 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD8 + ",");
        sql.append(" " + TBTHB2KMEI.EGCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + TBTHB2KMEI.CODE5 + ",");
        sql.append(" " + TBTHB2KMEI.CODE3);
        sql.append(" ) " + TBTB1 + ",");
        sql.append(" " + TBTHB10WLRDB.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB10WLRDB.EGCD + " = " + TBTB1 + "." + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB10WLRDB.TKSKGYCD + " = " + TBTB1 + "." + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB10WLRDB.TKSBMNSEQNO + " = " + TBTB1 + "." + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB10WLRDB.TKSTNTSEQNO + " = " + TBTB1 + "." + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB10WLRDB.BANCD + " = TRIM(" + TBTB1 + "." + TBTHB2KMEI.CODE5 + ")");
        sql.append(" ORDER BY");
        sql.append(" CAST(" + TBTHB10WLRDB.HYOJIJYUN + " AS INT),");
        sql.append(" " + TBTHB10WLRDB.BANCD);

//        sql.append("SELECT");
//        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.BANMEI + ",");                                                     //�ԑg��
//        sql.append(" " + TBTHB1DOWN.FIELD1+ " " + NewReportLionVO.HOUSOUKYOKU + ",");                                                   //������
//        sql.append(" " + TBTB1 +"." + NewReportLionVO.MITUMORIRYO + " " + NewReportLionVO.MITUMORIRYO + ",");                          //���ϗ���
//        sql.append(" (" + TBTB1 + "." + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ",");                          //����ŗ�
//        sql.append(" " + TBTB1 + "." + NewReportLionVO.SZEIGAK + " " + NewReportLionVO.SZEIGAK + ",");                                 //����Ŋz
//        sql.append(" " + TBTHB1DOWN.FIELD5 + " "+ NewReportLionVO.CMBYOUSU + ",");                                                      //�b��
//        sql.append(" " + TBTHB1DOWN.FIELD6 + " "+ NewReportLionVO.HONSU + ",");                                                         //�{��
//        sql.append(" " + TBTB1 + "." + NewReportLionVO.TEIKARYOKIN +   " "+ NewReportLionVO.TEIKARYOKIN + ",");                        //���{�����{������������
//        sql.append(" " + TBTHB1DOWN.FIELD8 + " "+ NewReportLionVO.KIKAN + ",");                                                         //��������
//        sql.append(" " + TBTHB10WLRDB.HYOJIJYUN + " "+ NewReportLionVO.AREA);                                                           //�\����
//        sql.append(", " + TBTB1 + "." + NewReportLionVO.CODE);                                                                         //�u�����h�R�[�h
//        sql.append(" FROM");
//        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
//        sql.append(" (SELECT");
//        sql.append(" " + TBTHB2KMEI.EGCD + ",");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
//        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
//        sql.append(" " + TBTHB2KMEI.CODE5 + ",");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
//        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") " + NewReportLionVO.MITUMORIRYO + ",");
//        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ "))) " + NewReportLionVO.SZEIGAK+ ",");  //����Ŋz
//        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + " + " + TBTHB2KMEI.KNGK3 + " ) " + NewReportLionVO.TEIKARYOKIN);
//        sql.append(", " + TBTHB2KMEI.CODE3 + " " + NewReportLionVO.CODE);                                                               //�u�����h�R�[�h
//        sql.append(" FROM ");
//        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
//        sql.append(" " + TBTHB2KMEI.TBNAME);
//        sql.append(" WHERE");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
//        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('003','004') AND");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
//        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '");
//        sql.append(" GROUP BY");
//        sql.append(" " + TBTHB2KMEI.JYUTNO  + ",");
//        sql.append(" " + TBTHB2KMEI.JYMEINO  + ",");
//        sql.append(" " + TBTHB2KMEI.URMEINO  + ",");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
//        sql.append(" " + TBTHB2KMEI.CODE5);
//        sql.append(", " + TBTHB2KMEI.CODE3);
//        sql.append(" ) " + TBTB1 + ",");
//        sql.append(" " + TBTHB10WLRDB.TBNAME);
//        sql.append(" WHERE");
//        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
//        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
//        sql.append(" TB1." + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " AND");
//        sql.append(" TB1." + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
//        sql.append(" TB1." + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
//        sql.append(" " + TBTHB10WLRDB.EGCD + " (+) = TB1." + TBTHB2KMEI.EGCD + " AND");
//        sql.append(" " + TBTHB10WLRDB.TKSKGYCD + " (+) = TB1." + TBTHB2KMEI.TKSKGYCD + " AND");
//        sql.append(" " + TBTHB10WLRDB.TKSBMNSEQNO + " (+) = TB1." + TBTHB2KMEI.TKSBMNSEQNO + " AND");
//        sql.append(" " + TBTHB10WLRDB.TKSTNTSEQNO + " (+) = TB1." + TBTHB2KMEI.TKSTNTSEQNO + " AND");
//        sql.append(" " + TBTHB10WLRDB.BANCD + " (+) = TRIM(TB1." + TBTHB2KMEI.CODE5 + ")");
//        sql.append(" ORDER BY");
//        sql.append(" CAST(" + TBTHB10WLRDB.HYOJIJYUN  + " AS INT),");
//        sql.append(" " + TBTHB10WLRDB.BANCD);
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto MOD end */

        return sql.toString();
    }

    //*********************
    //���W�I�X�|�b�g����
    //*********************
    private String getSelectSQLForRadioSpot() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
        //���s�v�ȓ����������������邱�Ƃɂ��p�t�H�[�}���X���P
        sql.append("SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.KENNAME + ",");                                                        //���i��
        sql.append(" " + TBTHB1DOWN.FIELD2 + " " + NewReportLionVO.HOUSOUKYOKU + ",");                                                      //������
        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") " + NewReportLionVO.MITUMORIRYO + ",");                                                 //���ϗ���
        sql.append(" " + TBTHB2KMEI.RITU1 + " * 0.01 " + NewReportLionVO.SHOHIZEI_RITU + ",");                                              //����ŗ�
        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM(" + TBTHB2KMEI.NAME1 + "))) " + NewReportLionVO.SZEIGAK + ",");  //����Ŋz
        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + ") " + NewReportLionVO.TEIKARYOKIN + ", ");                                                 //��������
        sql.append(" " + TBTHB1DOWN.FIELD5 + " " + NewReportLionVO.CMBYOUSU + ",");                                                         //�f�ޕb��
        sql.append(" " + TBTHB1DOWN.FIELD6 + " " + NewReportLionVO.HONSU + ",");                                                            //�{��
        sql.append(" " + TBTHB1DOWN.FIELD4 + " " + NewReportLionVO.KIKAN + ",");                                                            //��������
        sql.append(" " + TBTHB2KMEI.CODE3 + " " + NewReportLionVO.CODE + ",");                                                              //�u�����h�R�[�h
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND);                                                             //�����u�����h
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '005' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '05' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD +" AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1 + " AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201'");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" " + TBTHB1DOWN.FIELD2 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD5 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD6 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD4 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + TBTHB2KMEI.CODE3 + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");
        sql.append(" " + TBTHBAMST.FIELD2);
        sql.append(" ORDER BY");
        sql.append(" " + NewReportLionVO.CODE + ",");
        sql.append(" " + NewReportLionVO.HOUSOUKYOKU);

//        sql.append("SELECT");
//        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.KENNAME + ",");                                                    //���i��
//        sql.append(" " + TBTHB1DOWN.FIELD2 + " " + NewReportLionVO.HOUSOUKYOKU + ",");                                                  //������
//        sql.append(" TB1." + NewReportLionVO.MITUMORIRYO + " " + NewReportLionVO.MITUMORIRYO + ",");                                    //���ϗ���
//        sql.append(" (TB1." + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ",");                                     //����ŗ�
//        sql.append(" TB1." + NewReportLionVO.SZEIGAK + " " + NewReportLionVO.SZEIGAK + ",");                                            //����Ŋz
//        sql.append(" TB1." + NewReportLionVO.TEIKARYOKIN + " "+ NewReportLionVO.TEIKARYOKIN + ",");                                     //���{�����{������������
//        sql.append(" " + TBTHB1DOWN.FIELD5 +  " "+ NewReportLionVO.CMBYOUSU + ",");                                                     //�b��
//        sql.append(" " + TBTHB1DOWN.FIELD6 +  " "+ NewReportLionVO.HONSU + ",");                                                        //�{��
//        sql.append(" " + TBTHB1DOWN.FIELD4 +  " "+ NewReportLionVO.KIKAN + ",");                                                        //��������
//        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");                                                   //�����u�����h
//        sql.append(" " + TBTHBAMST.FIELD1 +  " "+ NewReportLionVO.CODE);                                                                //�R�[�h�i�u�����h�j
//        sql.append(" FROM");
//        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
//        sql.append(" " + TBTHBAMST.TBNAME + ",");
//        sql.append(" ( SELECT");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
//        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
//        sql.append(" " + TBTHB2KMEI.CODE3 + ",");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
//        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") " + NewReportLionVO.MITUMORIRYO + ",");
//        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM("+ TBTHB2KMEI.NAME1 + "))) " + NewReportLionVO.SZEIGAK+ ",");//����Ŋz
//        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + ") " + NewReportLionVO.TEIKARYOKIN);
//        sql.append(" FROM");
//        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
//        sql.append(" " + TBTHB2KMEI.TBNAME);
//        sql.append(" WHERE");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
//        sql.append(" " + TBTHB2KMEI.CODE6 + " = '005' AND");
//        sql.append(" " + TBTHB2KMEI.CODE1 + " = '05' AND");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
//        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '");
//        sql.append(" GROUP BY");
//        sql.append(" " + TBTHB2KMEI.JYUTNO  + ",");
//        sql.append(" " + TBTHB2KMEI.JYMEINO  + ",");
//        sql.append(" " + TBTHB2KMEI.URMEINO  + ",");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
//        sql.append(" " + TBTHB2KMEI.CODE3);
//        sql.append(" ) TB1");
//        sql.append(" WHERE");
//        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
//        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
//        sql.append(" TB1." + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " AND");
//        sql.append(" TB1." + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
//        sql.append(" TB1." + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
//        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHBAMST.EGCD + " AND");
//        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
//        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
//        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
//        sql.append(" " + TBTHBAMST.SYBT + " = '201'  AND");
//        sql.append(" TRIM(TB1." + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */

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
    public List<NewReportLionVO> findReportLionByCondition(NewReportLionCondition cond)
            throws KKHException {

        super.setModel(new NewReportLionVO());

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
    protected List<NewReportLionVO> createFindedModelInstances(List hashList) {
        List<NewReportLionVO> list = new ArrayList<NewReportLionVO>();
        if (getModel() instanceof NewReportLionVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                NewReportLionVO vo = new NewReportLionVO();

                //********************
                //�S�}��
                //********************
                if(_sqlMode.equals(SqlMode.ALLBAITAI))
                {
                    vo.setBaitaicd((String) result.get(NewReportLionVO.BAITAICD.toUpperCase().trim()));                     //�}�̃R�[�h
                    vo.setBaitaikocd((String) result.get(NewReportLionVO.BAITAIKOCD.toUpperCase().trim()));                 //�}�̎q�R�[�h
                    vo.setSumseigak((String) result.get(NewReportLionVO.SUMSEIGAK.toUpperCase().trim()).toString());        //�������z���v
                    vo.setSumszeigak((String) result.get(NewReportLionVO.SUMSZEIGAK.toUpperCase().trim()).toString());      //����ŋ��z���v
                }
                //********************
                //�V��
                //********************
                else if(_sqlMode.equals(SqlMode.SHINBUN))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setShimei((String) result.get(NewReportLionVO.SHIMEI.toUpperCase().trim()));                         //����
                    vo.setKyokuCd((String) result.get(NewReportLionVO.KYOKUCD.toUpperCase().trim()));                       //�ǎ��R�[�h
                    vo.setSyurui((String) result.get(NewReportLionVO.SYURUI.toUpperCase().trim()));                         //�f��
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //����ŋ��z
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()));               //�艿����
                    vo.setSpace((String) result.get(NewReportLionVO.SPACE.toUpperCase().trim()));                           //�X�y�[�X
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                }
                //********************
                //�G��
                //********************
                else if(_sqlMode.equals(SqlMode.ZASHI))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setZashimei((String) result.get(NewReportLionVO.ZASHIMEI.toUpperCase().trim()));                     //�G����
                    vo.setZashicd((String) result.get(NewReportLionVO.ZASHICD.toUpperCase().trim()));                       //�G���R�[�h
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //����ŋ��z
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()));               //�艿����
                    vo.setSpace((String) result.get(NewReportLionVO.SPACE.toUpperCase().trim()));                           //�X�y�[�X
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                }
                //********************
                //���
                //********************
                else if(_sqlMode.equals(SqlMode.KOUTSU))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //����ŋ��z
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()));               //�艿����
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                }
                //********************
                //���Ɣ�
                //********************
                else if(_sqlMode.equals(SqlMode.JIGYOUHI))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setSyurui((String) result.get(NewReportLionVO.SYURUI.toUpperCase().trim()));                         //���
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()));               //�艿����
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //�����
                }
                //********************
                //���o�C��
                //********************
                else if(_sqlMode.equals(SqlMode.MOBILE))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setHimokumei((String) result.get(NewReportLionVO.HIMOKUMEI.toUpperCase().trim()));                   //��ږ�
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //����ŋ��z
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                }
                //********************
                //�C���^�[�l�b�g
                //********************
                else if(_sqlMode.equals(SqlMode.INTERNET))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                    vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));                  //����ŗ�
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //�����
                }
                //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
              //********************
                //�\�[�V�������f�B�A
                //********************
                else if(_sqlMode.equals(SqlMode.SOCIALMEDIA))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                    vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));                  //����ŗ�
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //�����
                }
              //********************
                //�f�W�^������
                //********************
                else if(_sqlMode.equals(SqlMode.DIGITALMOVIE))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                    vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));                  //����ŗ�
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //�����
                }

                //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End

                //********************
                //�`���V
                //********************
                else if(_sqlMode.equals(SqlMode.TIRASHI))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //�����
                }
                //********************
                //���̑�
                //********************
                else if(_sqlMode.equals(SqlMode.SONOTA))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ς��藿��
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //�����
                }
                //********************
                //�T���v�����O
                //********************
                else if(_sqlMode.equals(SqlMode.SAMPLING))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //�����
                }
                //********************
                //BSCS
                //********************
                else if (_sqlMode.equals(SqlMode.BSCS))
                {
                    vo.setBanmei((String) result.get(NewReportLionVO.BANMEI.toUpperCase().trim()));                         //�ԑg��
                    vo.setHousoukyoku((String) result.get(NewReportLionVO.HOUSOUKYOKU.toUpperCase().trim()));               //������
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //����ŋ��z
                    vo.setCmbyousu((String) result.get(NewReportLionVO.CMBYOUSU.toUpperCase().trim()));                     //CM�b��
                    vo.setHonsu((String) result.get(NewReportLionVO.HONSU.toUpperCase().trim()));                           //�{��
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()).toString());    //��������
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setBanCd((String) result.get(NewReportLionVO.BANCD.toUpperCase().trim()));                           //�ԑg�R�[�h
                    vo.setKyokuCd((String) result.get(NewReportLionVO.KYOKUCD.toUpperCase().trim()));                       //�ǎ��R�[�h
                    /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim().toString()));                  //�u�����h�R�[�h
                    /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
                }
                //********************
                //�e���r�^�C��
                //********************
                else if(_sqlMode.equals(SqlMode.TVTIME))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //�ԑg��
                    vo.setHousoukyoku((String) result.get(NewReportLionVO.HOUSOUKYOKU.toUpperCase().trim()));               //������
                    vo.setNetKyoku((String) result.get(NewReportLionVO.NETKYOKU.toUpperCase().trim()));                     //�l�b�g��
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //����ŋ��z
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()).toString());    //�艿����
                    vo.setCmbyousu((String) result.get(NewReportLionVO.CMBYOUSU.toUpperCase().trim()));                     //CM�b��
                    vo.setHonsu((String) result.get(NewReportLionVO.HONSU.toUpperCase().trim()));                           //�{��
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    //okazaki
                    vo.setSumseigak((String) result.get(NewReportLionVO.SUMSEIGAK.toUpperCase().trim()).toString());        //���{�d�g��
                    vo.setArea((String) result.get(NewReportLionVO.AREA.toUpperCase().trim()).toString());                  //�\����
                    //okazaki
                    /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
                    vo.setCode((String)result.get(NewReportLionVO.CODE.toUpperCase().trim().toString()));                   //�u�����h�R�[�h
                    /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
                }
                //********************
                //�e���r�X�|�b�g
                //********************
                else if(_sqlMode.equals(SqlMode.TVSPOT))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setHousoukyoku((String) result.get(NewReportLionVO.HOUSOUKYOKU.toUpperCase().trim()));               //������
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //����ŋ��z
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()).toString());    //�艿����
                    vo.setCmbyousu((String) result.get(NewReportLionVO.CMBYOUSU.toUpperCase().trim()));                     //�f�ޕb��
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h
                }
                //********************
                //���W�I�^�C��
                //********************
                else if(_sqlMode.equals(SqlMode.RADIOTIME))
                {
                    vo.setBanmei((String) result.get(NewReportLionVO.BANMEI.toUpperCase().trim()));                         //�ԑg��
                    vo.setHousoukyoku((String) result.get(NewReportLionVO.HOUSOUKYOKU.toUpperCase().trim()));               //������
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //����ŋ��z
                    vo.setCmbyousu((String) result.get(NewReportLionVO.CMBYOUSU.toUpperCase().trim()));                     //CM�b��
                    vo.setHonsu((String) result.get(NewReportLionVO.HONSU.toUpperCase().trim()));                           //�{��
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()).toString());    //��������
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setArea((String) result.get(NewReportLionVO.AREA.toUpperCase().trim()).toString());                  //�\����
                    /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD start */
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim().toString()));                  //�u�����h�R�[�h
                    /* 2014/07/31 ����Œ[�������Ή� HLC fujimoto ADD end */
                }
                //********************
                //���W�I�X�|�b�g
                //********************
                else if(_sqlMode.equals(SqlMode.RADIOSPOT))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //���i��
                    vo.setHousoukyoku((String) result.get(NewReportLionVO.HOUSOUKYOKU.toUpperCase().trim()));               //������
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //���ϗ���
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //����ŗ�
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //����ŋ��z
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()).toString());    //��������
                    vo.setCmbyousu((String) result.get(NewReportLionVO.CMBYOUSU.toUpperCase().trim()));                     //CM�b��
                    vo.setHonsu((String) result.get(NewReportLionVO.HONSU.toUpperCase().trim()));                           //�{��
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //����
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //�����u�����h
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //�R�[�h

                }
//              vo.setBrandMei((String) result.get(ReportLionVO.BRAND_MEI.toUpperCase().trim())); //�u�����h��
//              vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));           //�����z

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
