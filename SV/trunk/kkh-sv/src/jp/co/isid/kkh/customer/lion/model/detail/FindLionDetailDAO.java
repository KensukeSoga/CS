package jp.co.isid.kkh.customer.lion.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindLionDetailDAO extends AbstractRdbDao  {

    /**�e���r�ǃ}�X�^�������� */
    private FindLionDetailCondition _cond;

    //���//////////////////////////////////////////////////////////////////////////////////////////////
    /** �ėp�}�X�^�F�}�̎�ʁF�u�����h */
    public static final String C_HBAMST_SYBT_BRAND =  LionConstants.MastBaitaiShubetsu.BRAND.getCode();
    /** �ėp�}�X�^�F�}�̎�ʁF�V�� */
    public static final String C_HBAMST_SYBT_SHINBUN =  LionConstants.MastBaitaiShubetsu.SHINBUN.getCode();
    /** �ėp�}�X�^�F�}�̎�ʁF�G�� */
    public static final String C_HBAMST_SYBT_ZASHI =  LionConstants.MastBaitaiShubetsu.ZASHI.getCode();
    /** �ėp�}�X�^�F�}�̎�ʁF����� */
    public static final String C_HBAMST_SYBT_BAITAI_KBN =  LionConstants.MastBaitaiShubetsu.BAITAI_KBN.getCode();
    /** �ėp�}�X�^�F�}�̎�ʁF�� */
    public static final String C_HBAMST_SYBT_KEN =  LionConstants.MastBaitaiShubetsu.KEN.getCode();
    /** �ėp�}�X�^�F�}�̎�ʁF�C���^�[�l�b�g */
    public static final String C_HBAMST_SYBT_INTERNET  =  LionConstants.MastBaitaiShubetsu.INTERNET.getCode();
    /** �ėp�}�X�^�F�}�̎�ʁF���o�C�� */
    public static final String C_HBAMST_SYBT_MOBILE  =  LionConstants.MastBaitaiShubetsu.MOBILE.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���o�C�� */
    public static final String C_HBAMST_SYBT_SONOTA_CD =  LionConstants.MastBaitaiShubetsu.BAITAI_KBN.getCode();

    //�J�[�hNo///////////////////////////////////////////////////////////////////////////////////////////
    /** �ėp�}�X�^�F�J�[�hNO�F�V�� */
    public static final String C_HBAMST_CARD_SHINBUN =  LionConstants.CardNo.SHINBUN.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�G�� */
    public static final String C_HBAMST_CARD_ZASHI =  LionConstants.CardNo.ZASHI.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���W�I�^�C���i�l�b�g�j */
    public static final String C_HBAMST_CARD_RD_TIME =  LionConstants.CardNo.RD_TIME.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���W�I�^�C���i���[�J���j */
    public static final String C_HBAMST_CARD_RD_LOCAL =  LionConstants.CardNo.RD_LOCAL.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�X�|�b�g�i�e���r�A���W�I�j */
    public static final String C_HBAMST_CARD_SPOT =  LionConstants.CardNo.SPOT.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�e���r�^�C���i���[�J���j */
    public static final String C_HBAMST_CARD_TV_LOCAL =  LionConstants.CardNo.TV_LOCAL.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�e���r�i�l�b�g�j */
    public static final String C_HBAMST_CARD_TV_TIME =  LionConstants.CardNo.TV_TIME.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�FBS�ACS */
    public static final String C_HBAMST_CARD_BSCS=  LionConstants.CardNo.BSCS.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���� */
    public static final String C_HBAMST_CARD_SEISAKUHI =  LionConstants.CardNo.SEISAKUHI.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F��� */
    public static final String C_HBAMST_CARD_KOUTU =  LionConstants.CardNo.KOUTU.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�C���^�[�l�b�g */
    public static final String C_HBAMST_CARD_INTERNET =  LionConstants.CardNo.INTERNET.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���o�C�� */
    public static final String C_HBAMST_CARD_MOBILE =  LionConstants.CardNo.MOBILE.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���o�C�� */
    public static final String C_HBAMST_CARD_SONOTA =  LionConstants.CardNo.SONOTA.getCode();

    //�}�̋敪//////////////////////////////////////////////////////////////////////////////////////////////
    /** �ėp�}�X�^�F�}�̋敪�FTV���� */
    public static final String C_HBAMST_BAITAIKBN_TV_SPOT =  LionConstants.BaitaiKbn.TV_SPOT.getCode();
    /** �ėp�}�X�^�F�}�̋敪�F�炶���� */
    public static final String C_HBAMST_BAITAIKBN_RD_SPOT =  LionConstants.BaitaiKbn.RD_SPOT.getCode();

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindLionDetailDAO() {
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

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        //�}�X�^�pstringbuffer
        StringBuffer lstrSelect = new StringBuffer();
        StringBuffer lstrFrom = new StringBuffer();
        StringBuffer lstrWhere = new StringBuffer();

        //�}�X�^�f�[�^SQL�i����j
        //�V��
        if (_cond.getCode6().equals(C_HBAMST_CARD_SHINBUN))
        {
            //SELECT
            lstrSelect.append(" ," + "SINBUN." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //�V������
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //�u�����h����
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //�_�~�[�R
            //FROM
            lstrFrom.append(",("); //�}�X�^�e�[�u��(�V��)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_SHINBUN + "' ");
            lstrFrom.append(") SINBUN, ");
            lstrFrom.append("("); //�}�X�^�e�[�u��(�u�����h)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//�u�����h�R�[�h
            lstrWhere.append(" AND SINBUN." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND SINBUN." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND SINBUN." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND SINBUN." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//�V���R�[�h
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//�A��(�\�[�g���j
        }
        //�G��
        else if (_cond.getCode6().equals(C_HBAMST_CARD_ZASHI))
        {
            //SELECT
            lstrSelect.append(" ," + "ZASSI." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //�V������
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //�u�����h����
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //�_�~�[�R
            //FROM
            lstrFrom.append(",("); //�}�X�^�e�[�u��(�G��)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI + "' ");
            lstrFrom.append(") ZASSI, ");
            lstrFrom.append("("); //�}�X�^�e�[�u��(�u�����h)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//�u�����h�R�[�h
            lstrWhere.append(" AND ZASSI." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND ZASSI." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND ZASSI." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND ZASSI." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//�V���R�[�h
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//�A��(�\�[�g���j
        }
        //���W�I�^�C���i�l�b�g�j,���W�I�^�C���i���[�J���j
        else if (_cond.getCode6().equals(C_HBAMST_CARD_RD_LOCAL) || _cond.getCode6().equals(C_HBAMST_CARD_RD_TIME))
        {
            //SELECT
            lstrSelect.append(" ," + "RDKYK." + TBTHB12WLRDK.KYOKUNAME  + " AS VAL1 ");              //���W�I�ǖ���
            lstrSelect.append(" ," + "''"  + " AS VAL2 ");               //�_�~�[�Q
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //�_�~�[�R
            //FROM
            lstrFrom.append(", " + TBTHB12WLRDK.TBNAME + " RDKYK "); //�}�X�^�e�[�u��(���W�I��)
            //where
            lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.KYOKUCD + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//�u�����h�R�[�h
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//�A��(�\�[�g���j
        }
        //�X�|�b�g(�e���r)
        else if (_cond.getCode6().equals(C_HBAMST_CARD_SPOT))
        {
            if (_cond.getCode1().equals(C_HBAMST_BAITAIKBN_TV_SPOT)){
                //SELECT
                lstrSelect.append(" ," + "TVKYK." + TBTHB11WLTVK.KYOKUNAME  + " AS VAL1 ");          //TV�ԑg����
                lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //�u�����h����
                lstrSelect.append(" ," + "TVKYK." + TBTHB11WLTVK.TIKU  + " AS VAL3 ");               //�n��R�[�h
                //FROM
//                lstrFrom.append(", " + TBTHB11WLTVK.TBNAME + " TVKYK "); //�}�X�^�e�[�u��(���W�I��)
                lstrFrom.append(",(");//�}�X�^�e�[�u��(�e���r��)
                lstrFrom.append("SELECT * ");
                lstrFrom.append("FROM  " + TBTHB11WLTVK.TBNAME + " ");
                lstrFrom.append("order by " + TBTHB11WLTVK.THYOJIJYUN + " ");
                lstrFrom.append(") TVKYK ");
                lstrFrom.append(",("); //�}�X�^�e�[�u��(�u�����h)
                lstrFrom.append("SELECT * ");
                lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
                lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
                lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
                lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
                lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
                lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
                lstrFrom.append(") BRAND ");
                //where
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//�u�����h�R�[�h
                lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
                lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
                lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
                lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.KYOKUCD + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//�V���R�[�h
                lstrWhere.append(" order by "  + TBTHB11WLTVK.THYOJIJYUN );                 //�n�揇
            } else if (_cond.getCode1().equals(C_HBAMST_BAITAIKBN_RD_SPOT)){
                //SELECT
                lstrSelect.append(" ," + "RDKYK." + TBTHB12WLRDK.KYOKUNAME  + " AS VAL1 ");          //���W�I�ԑg����
                lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //�u�����h����
                lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //�_�~�[�R
                //FROM
                lstrFrom.append(", " + TBTHB12WLRDK.TBNAME + " RDKYK "); //�}�X�^�e�[�u��(���W�I��)
                lstrFrom.append(",("); //�}�X�^�e�[�u��(�u�����h)
                lstrFrom.append("SELECT * ");
                lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
                lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
                lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
                lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
                lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
                lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
                lstrFrom.append(") BRAND ");
                //where
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//�u�����h�R�[�h
                lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
                lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
                lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
                lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.KYOKUCD + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//�V���R�[�h
                //lstrWhere.append(" order by "  + TBTHB12WLRDK.HYOJIJYUN );                 //�n�揇
                lstrWhere.append(" order by "  + TBTHB2KMEI.RENBN );                 //�A��(�\�[�g���j
            }
        }
        //�s�u�^�C���l�b�g,�s�u�^�C�����[�J���a�r�E�b�r
        else if (_cond.getCode6().equals(C_HBAMST_CARD_TV_LOCAL) || _cond.getCode6().equals(C_HBAMST_CARD_TV_TIME) || _cond.getCode6().equals(C_HBAMST_CARD_BSCS))
        {
            //SELECT
            lstrSelect.append(" ," + "TVKYK." + TBTHB11WLTVK.KYOKUNAME  + " AS VAL1 ");              //���W�I�ǖ���
            lstrSelect.append(" ," + "''"  + " AS VAL2 ");               //�_�~�[�Q
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //�_�~�[�R
            //FROM
            lstrFrom.append(", " + TBTHB11WLTVK.TBNAME + " TVKYK "); //�}�X�^�e�[�u��(���W�I��)
            //where
            lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.KYOKUCD + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//�u�����h�R�[�h
            lstrWhere.append(" order by "  + TBTHB11WLTVK.THYOJIJYUN );                 //�n�揇
        }
        //����
        else if (_cond.getCode6().equals(C_HBAMST_CARD_SEISAKUHI))
        {
            //SELECT
            lstrSelect.append(" ," + "SEISAKU." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //������
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //�u�����h����
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //�_�~�[�R
            //FROM
            lstrFrom.append(",("); //�}�X�^�e�[�u��(�}�́A�u�����h)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BAITAI_KBN + "' AND ");
            //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
            //�f�W�^������(�}�̋敪43)�ǉ��̂��ߏC���A�}�̏���ł͏���
            lstrFrom.append(TBTHBAMST.FIELD1 + " NOT IN ('40' ,'41') ");//�����̂ݑΏ�
//            lstrFrom.append(TBTHBAMST.FIELD1 + " between '20' and '39' ");//�����̂ݑΏ�
            //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod End
            lstrFrom.append(") SEISAKU, ");
            lstrFrom.append("("); //�}�X�^�e�[�u��(�u�����h)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//�u�����h�R�[�h
            lstrWhere.append(" AND SEISAKU." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND SEISAKU." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND SEISAKU." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND SEISAKU." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE1 + ") ");//����R�[�h
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//�A��(�\�[�g���j
        }
        //���
        else if (_cond.getCode6().equals(C_HBAMST_CARD_KOUTU))
        {
            //SELECT
            lstrSelect.append(" ," + "KEN." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //��ʖ���
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //�u�����h����
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //�_�~�[�R
            //FROM
            lstrFrom.append(",("); //�}�X�^�e�[�u��(��)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_KEN + "' ");
            lstrFrom.append(") KEN, ");
            lstrFrom.append("("); //�}�X�^�e�[�u��(�u�����h)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//�u�����h�R�[�h
            lstrWhere.append(" AND KEN." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND KEN." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND KEN." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND KEN." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.SONOTA2 + ") ");//��ʃR�[�h
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//�A��(�\�[�g���j
        }
        //�C���^�[�l�b�g
        else if (_cond.getCode6().equals(C_HBAMST_CARD_INTERNET))
        {
            //SELECT
            lstrSelect.append(" ," + "INTERNET." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //�C���^�[�l�b�g�ǖ���
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //�u�����h����
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //�_�~�[�R
            //FROM
            lstrFrom.append(",("); //�}�X�^�e�[�u��(�C���^�[�l�b�g)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_INTERNET + "' ");
            lstrFrom.append(") INTERNET, ");
            lstrFrom.append("("); //�}�X�^�e�[�u��(�u�����h)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//�u�����h�R�[�h
            lstrWhere.append(" AND INTERNET." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND INTERNET." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND INTERNET." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND INTERNET." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//�C���^�[�l�b�g�ǃR�[�h
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//�A��(�\�[�g���j
        }
        //���o�C��
        else if (_cond.getCode6().equals(C_HBAMST_CARD_MOBILE))
        {
            //SELECT
            lstrSelect.append(" ," + "MOB." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //�C���^�[�l�b�g�ǖ���
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //���o�C������
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");
            //FROM
            lstrFrom.append(",("); //�}�X�^�e�[�u��(���o�C��)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_MOBILE + "' ");
            lstrFrom.append(") MOB, ");
            lstrFrom.append("("); //�}�X�^�e�[�u��(�u�����h)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//�u�����h�R�[�h
            lstrWhere.append(" AND MOB." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND MOB." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND MOB." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND MOB." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//���o�C���R�[�h
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//�A��(�\�[�g���j
        }
        //���̑�(��L��IF�ȊO���ׂāj
        else //if (_cond.getCode6().equals(C_HBAMST_CARD_SONOTA))
        {
            //SELECT
            lstrSelect.append(" ," + "SONOTA." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //�C���^�[�l�b�g�ǖ���
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //���̑��̖���
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");
            //FROM
            lstrFrom.append(",("); //�}�X�^�e�[�u��(���o�C��)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_SONOTA_CD + "' ");
            lstrFrom.append(") SONOTA, ");
            lstrFrom.append("("); //�}�X�^�e�[�u��(�u�����h)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//�u�����h�R�[�h
            lstrWhere.append(" AND SONOTA." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND SONOTA." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND SONOTA." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND SONOTA." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE1 + ") ");//���̑��R�[�h
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//�A��(�\�[�g���j
        }

        if ("".equals(lstrSelect.toString())){
            lstrSelect.append(" ," + "''"  + " AS VAL1 ");               //�_�~�[�P
            lstrSelect.append(" ," + "''"  + " AS VAL2 ");               //�_�~�[�Q
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //�_�~�[�R
        }

        //���׃f�[�^SQL
        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + " ");          //��No
        sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");      //�󒍖���No
        sql.append(" ," + TBTHB2KMEI.URMEINO + " ");      //���㖾��No
        sql.append(" ," + TBTHB2KMEI.YYMM + " ");         //�N��
        sql.append(" ," + TBTHB2KMEI.HIMKCD + " ");       //��ڃR�[�h
        sql.append(" ," + TBTHB2KMEI.HNNERT + " ");        //�l����
        sql.append(" ," + TBTHB2KMEI.NEBIGAK + " ");       //�l���z
        sql.append(" ," + TBTHB2KMEI.CODE1 + " ");         //�}�̋敪
        sql.append(" ," + TBTHB2KMEI.CODE2 + " ");         //�ǃR�[�h
        sql.append(" ," + TBTHB2KMEI.CODE3 + " ");         //�u�����h�R�[�h
        sql.append(" ," + TBTHB2KMEI.CODE4 + " ");         //�㗝�X�R�[�h
        sql.append(" ," + TBTHB2KMEI.CODE5 + " ");         //�ԑg�R�[�h
        sql.append(" ," + TBTHB2KMEI.CODE6 + " ");         //�J�[�h�m��
        sql.append(" ," + TBTHB2KMEI.NAME1 + " ");         //����Ŋz
        sql.append(" ," + TBTHB2KMEI.NAME2 + " ");         //�X�y�[�X�R�[�h
        sql.append(" ," + TBTHB2KMEI.NAME3 + " ");         //�������ԍ�
        sql.append(" ," + TBTHB2KMEI.NAME4 + " ");         //��`��
        sql.append(" ," + TBTHB2KMEI.NAME5 + " ");         //�f�ړ�������
        sql.append(" ," + TBTHB2KMEI.NAME6 + " ");         //�H����
        sql.append(" ," + TBTHB2KMEI.NAME7 + " ");         //����
        sql.append(" ," + TBTHB2KMEI.NAME8 + " ");         //���l
        sql.append(" ," + TBTHB2KMEI.NAME10 + " ");        //����
        sql.append(" ," + TBTHB2KMEI.KNGK1 + " ");         //�d�g��
        sql.append(" ," + TBTHB2KMEI.KNGK2 + " ");         //�l�b�g��
        sql.append(" ," + TBTHB2KMEI.KNGK3 + " ");         //�����
        sql.append(" ," + TBTHB2KMEI.SEIGAK + " ");        //�������z
        sql.append(" ," + TBTHB2KMEI.RITU1 + " ");         //����ŗ�
        sql.append(" ," + TBTHB2KMEI.SONOTA1 + " ");       //�x�~��
        sql.append(" ," + TBTHB2KMEI.SONOTA2 + " ");       //�{���b�c
        sql.append(" ," + TBTHB2KMEI.SONOTA3 + " ");       //�l�b�g�e�b
        sql.append(" ," + TBTHB2KMEI.SONOTA5 + " ");       //�{��
        sql.append(" ," + TBTHB2KMEI.SONOTA6 + " ");       //���b��
        sql.append(" ," + TBTHB2KMEI.SONOTA7 + " ");       //�b��
        sql.append(" ," + TBTHB2KMEI.SONOTA8 + " ");       //������
        sql.append(" ," + TBTHB2KMEI.SONOTA9 + " ");       //�e�c�p�\������
        sql.append(" " + lstrSelect + " ");             //�}�X�^�f�[�^(select)
        sql.append(" ," + TBTHB2KMEI.TIMSTMP + " ");//YYYY/MM/DD HH24:MI:SS//) TIMSTMP  //�^�C���X�^���v
        sql.append(" " + "FROM" + " ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " ");//�L����׃e�[�u��
        sql.append(" " + lstrFrom + " ");         //�}�X�^�f�[�^(from)
        sql.append(" " + "where" + " ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");          //�c�Ə�
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//���Ӑ�R�[�h
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//���Ӑ�BMN
        sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//���Ӑ�TNT
        sql.append(TBTHB2KMEI.YYMM  + " = '" + _cond.getYymm()  + "'  AND ");//�N��
        sql.append(TBTHB2KMEI.JYUTNO  + " = '" + _cond.getJyutno()  + "'  AND ");//�󒍂�O
        sql.append(TBTHB2KMEI.JYMEINO  + " = '" + _cond.getJymeino()  + "'  AND ");//�󒍖���
        sql.append(TBTHB2KMEI.URMEINO  + " = '" + _cond.getUrmeino()  + "'  ");//���㖾��
        sql.append(" " + lstrWhere   + " ");                                       //�}�X�^�f�[�^(�R�[�h)

        return sql.toString();
    }

    /**
     * TV�ǃ}�X�^�̌������s���܂��B
     *
     * @return �e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindLionDetailVO> findLionDetailByCondition(FindLionDetailCondition cond) throws KKHException {

        super.setModel(new FindLionDetailVO());

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
     * @param hashList List ��������
     * @return List<CommonCodeMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<FindLionDetailVO> createFindedModelInstances(List hashList) {
        List<FindLionDetailVO> list = new ArrayList<FindLionDetailVO>();
        if (getModel() instanceof FindLionDetailVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindLionDetailVO vo = new FindLionDetailVO();
                //MEI2
                vo.setJyutno((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                vo.setJymeino((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                vo.setUrmeino((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
                vo.setYymm((String)result.get(TBTHB2KMEI.YYMM.toUpperCase()));
                vo.setHimkcd((String)result.get(TBTHB2KMEI.HIMKCD.toUpperCase()));
                vo.setHnnert((BigDecimal)result.get(TBTHB2KMEI.HNNERT.toUpperCase()));
                vo.setNebigak((BigDecimal)result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));
                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                vo.setCode2((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
                vo.setCode3((String)result.get(TBTHB2KMEI.CODE3.toUpperCase()));
                vo.setCode4((String)result.get(TBTHB2KMEI.CODE4.toUpperCase()));
                vo.setCode5((String)result.get(TBTHB2KMEI.CODE5.toUpperCase()));
                vo.setCode6((String)result.get(TBTHB2KMEI.CODE6.toUpperCase()));
                vo.setName1((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
                vo.setName2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                vo.setName3((String)result.get(TBTHB2KMEI.NAME3.toUpperCase()));
                vo.setName4((String)result.get(TBTHB2KMEI.NAME4.toUpperCase()));
                vo.setName5((String)result.get(TBTHB2KMEI.NAME5.toUpperCase()));
                vo.setName6((String)result.get(TBTHB2KMEI.NAME6.toUpperCase()));
                vo.setName7((String)result.get(TBTHB2KMEI.NAME7.toUpperCase()));
                vo.setName8((String)result.get(TBTHB2KMEI.NAME8.toUpperCase()));
                vo.setName10((String)result.get(TBTHB2KMEI.NAME10.toUpperCase()));
                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
                vo.setKngk2((BigDecimal)result.get(TBTHB2KMEI.KNGK2.toUpperCase()));
                vo.setKngk3((BigDecimal)result.get(TBTHB2KMEI.KNGK3.toUpperCase()));
                vo.setSeigak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setRitu1((BigDecimal)result.get(TBTHB2KMEI.RITU1.toUpperCase()));
                vo.setSonota1((String)result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));
                vo.setSonota2((String)result.get(TBTHB2KMEI.SONOTA2.toUpperCase()));
                vo.setSonota3((String)result.get(TBTHB2KMEI.SONOTA3.toUpperCase()));
                vo.setSonota5((String)result.get(TBTHB2KMEI.SONOTA5.toUpperCase()));
                vo.setSonota6((String)result.get(TBTHB2KMEI.SONOTA6.toUpperCase()));
                vo.setSonota7((String)result.get(TBTHB2KMEI.SONOTA7.toUpperCase()));
                vo.setSonota8((String)result.get(TBTHB2KMEI.SONOTA8.toUpperCase()));
                vo.setSonota9((String)result.get(TBTHB2KMEI.SONOTA9.toUpperCase()));
                //�}�X�^�P�`�R�܂œ��I
                vo.setVal1((String)result.get(FindLionDetailVO.VAL1.toUpperCase()));
                vo.setVal2((String)result.get(FindLionDetailVO.VAL2.toUpperCase()));
                vo.setVal3((String)result.get(FindLionDetailVO.VAL3.toUpperCase()));
                //MEI2
                vo.setTimstmp((Date)result.get(TBTHB2KMEI.TIMSTMP.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
