package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindLionCardNoItrDAO extends AbstractRdbDao  {

    /** �ėp�}�X�^�������� */
    private FindLionCardNoItrCondition _cond;

    //���//////////////////////////////////////////////////////////////////////////////////////////////
    /** �ėp�}�X�^�F�}�̎�ʁF�}�̋敪(104) */
    public static final String C_HBAMST_SYBT_BAITAI_KBN =  LionConstants.MastBaitaiShubetsu.BAITAI_KBN.getCode();

    //�J�[�hNo///////////////////////////////////////////////////////////////////////////////////////////
    /** �ėp�}�X�^�F�J�[�hNO�F�e���r�^�C���i���[�J���j */
    public static final String C_HBAMST_CARD_TV_LOCAL =  LionConstants.CardNo.TV_LOCAL.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�e���r�i�l�b�g�j */
    public static final String C_HBAMST_CARD_TV_TIME =  LionConstants.CardNo.TV_TIME.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���W�I�^�C���i�l�b�g�j */
    public static final String C_HBAMST_CARD_RD_TIME =  LionConstants.CardNo.RD_TIME.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���W�I�^�C���i���[�J���j */
    public static final String C_HBAMST_CARD_RD_LOCAL =  LionConstants.CardNo.RD_LOCAL.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�X�|�b�g�i�e���r�A���W�I�j */
    public static final String C_HBAMST_CARD_SPOT =  LionConstants.CardNo.SPOT.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�V�� */
    public static final String C_HBAMST_CARD_SHINBUN =  LionConstants.CardNo.SHINBUN.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�G�� */
    public static final String C_HBAMST_CARD_ZASHI =  LionConstants.CardNo.ZASHI.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F��� */
    public static final String C_HBAMST_CARD_KOUTU =  LionConstants.CardNo.KOUTU.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���̑� */
    public static final String C_HBAMST_CARD_SONOTA =  LionConstants.CardNo.SONOTA.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���� */
    public static final String C_HBAMST_CARD_SEISAKUHI =  LionConstants.CardNo.SEISAKUHI.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�`���V */
    public static final String C_HBAMST_CARD_LEAFLET =  LionConstants.CardNo.LEAFLET.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�T���v�����O */
    public static final String C_HBAMST_CARD_SAMPLING =  LionConstants.CardNo.SAMPLING.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�FBS�ECS */
    public static final String C_HBAMST_CARD_BSCS =  LionConstants.CardNo.BSCS.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�C���^�[�l�b�g */
    public static final String C_HBAMST_CARD_INTERNET =  LionConstants.CardNo.INTERNET.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���o�C�� */
    public static final String C_HBAMST_CARD_MOBILE =  LionConstants.CardNo.MOBILE.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���Ɣ� */
    public static final String C_HBAMST_CARD_BUSINESSEXP =  LionConstants.CardNo.BUSINESSEXP.getCode();

    //Field1�R�[�h///////////////////////////////////////////////////////////////////////////////////////////
    /** �e���r�^�C�� */
    public static final String C_HBAMST_FIELD1_TV_LOCAL =  LionConstants.Field1Code.TV_TIME.getCode();
    /** ���W�I�^�C�� */
    public static final String C_HBAMST_FIELD1_RD_TIME =  LionConstants.Field1Code.RD_TIME.getCode();
    /** �X�|�b�g�i�e���r�j */
    public static final String C_HBAMST_FIELD1_TV_SPOT =  LionConstants.Field1Code.TV_SPOT.getCode();
    /** �X�|�b�g�i���W�I�j */
    public static final String C_HBAMST_FIELD1_RD_SPOT =  LionConstants.Field1Code.RD_SPOT.getCode();
    /** �V�� */
    public static final String C_HBAMST_FIELD1_SHINBUN =  LionConstants.Field1Code.SHINBUN.getCode();
    /** �G�� */
    public static final String C_HBAMST_FIELD1_ZASHI =  LionConstants.Field1Code.ZASHI.getCode();
    /** ��� */
    public static final String C_HBAMST_FIELD1_KOUTU =  LionConstants.Field1Code.KOTSU.getCode();
    /** ���̑� */
    public static final String C_HBAMST_FIELD1_SONOTA =  LionConstants.Field1Code.SONOTA.getCode();
    /** ����1 */
    public static final String C_HBAMST_FIELD1_SEISAKU1 =  LionConstants.Field1Code.SEISAKU1.getCode();
    /** ����2 */
    public static final String C_HBAMST_FIELD1_SEISAKU2 =  LionConstants.Field1Code.SEISAKU2.getCode();
    /** �`���V */
    public static final String C_HBAMST_FIELD1_CHIRASHI =  LionConstants.Field1Code.CHIRASHI.getCode();
    /** �T���v�����O */
    public static final String C_HBAMST_FIELD1_SAMPLING =  LionConstants.Field1Code.SAMPLING.getCode();
    /** BS�ECS */
    public static final String C_HBAMST_FIELD1_BSCS =  LionConstants.Field1Code.BS_CS.getCode();
    /** �C���^�[�l�b�g */
    public static final String C_HBAMST_FIELD1_INTERNET =  LionConstants.Field1Code.INTERNET.getCode();
    //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
    /** �\�[�V�������f�B�A */
    public static final String C_HBAMST_FIELD1_SOCIALMEDIA =  LionConstants.Field1Code.SOCIALMEDIA.getCode();
    /** �f�W�^������ */
    public static final String C_HBAMST_FIELD1_DIGITALMOVIE =  LionConstants.Field1Code.DIGITALMOVIE.getCode();
    //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End
    /** ���o�C�� */
    public static final String C_HBAMST_FIELD1_MOBILE =  LionConstants.Field1Code.MOBILE.getCode();
    /** ���Ɣ� */
    public static final String C_HBAMST_FIELD1_JIGYOHI =  LionConstants.Field1Code.JIGYOHI.getCode();

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindLionCardNoItrDAO() {
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
                TBTHBAMST.EGCD,
                TBTHBAMST.TKSKGYCD,
                TBTHBAMST.TKSBMNSEQNO,
                TBTHBAMST.TKSTNTSEQNO,
                TBTHBAMST.SYBT,
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
     * @return String �e�[�u����
     */
    @Override
    public String getTableName() {
        return TBTHBAMST.TBNAME;
    }


    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHBAMST.TRKTIMSTMP,
                TBTHBAMST.TRKPL,
                TBTHBAMST.TRKTNT,
                TBTHBAMST.UPDTIMSTMP,
                TBTHBAMST.UPDAPL,
                TBTHBAMST.UPDTNT,
                TBTHBAMST.EGCD,
                TBTHBAMST.TKSKGYCD,
                TBTHBAMST.TKSBMNSEQNO,
                TBTHBAMST.TKSTNTSEQNO,
                TBTHBAMST.SYBT,
                TBTHBAMST.FIELD1,
                TBTHBAMST.FIELD2
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

        //�e���r�^�C��(�l�b�g)�E�e���r�^�C��(���[�J��)
        if( _cond.getCode().equals(C_HBAMST_CARD_TV_TIME) || _cond.getCode().equals(C_HBAMST_CARD_TV_LOCAL)){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_TV_LOCAL  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //���W�I�^�C��(�l�b�g)�E���W�I�^�C��(���[�J��)
        else if( _cond.getCode().equals(C_HBAMST_CARD_RD_TIME) || _cond.getCode().equals(C_HBAMST_CARD_RD_LOCAL)){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_RD_TIME  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //�X�|�b�g
        else if( _cond.getCode().equals(C_HBAMST_CARD_SPOT) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " IN ('" + C_HBAMST_FIELD1_TV_SPOT  + "','" + C_HBAMST_FIELD1_RD_SPOT + "') ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //�V��
        else if( _cond.getCode().equals(C_HBAMST_CARD_SHINBUN) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_SHINBUN  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //�G��
        else if( _cond.getCode().equals(C_HBAMST_CARD_ZASHI) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_ZASHI  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //���
        else if( _cond.getCode().equals(C_HBAMST_CARD_KOUTU) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_KOUTU  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //���̑�
        else if( _cond.getCode().equals(C_HBAMST_CARD_SONOTA) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_SONOTA  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //����
        else if( _cond.getCode().equals(C_HBAMST_CARD_SEISAKUHI) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
            //�}�̋敪40�A41�ȊO��\��
            sql.append(TBTHBAMST.FIELD1 + " BETWEEN '" + C_HBAMST_FIELD1_SEISAKU1  + "' AND '" + C_HBAMST_FIELD1_SEISAKU2 + "' AND ");
            sql.append(TBTHBAMST.FIELD1 + " NOT IN ('40' ,'41') ");
            //sql.append(TBTHBAMST.FIELD1  + " BETWEEN '" + C_HBAMST_FIELD1_SEISAKU1  + "' AND '" + C_HBAMST_FIELD1_SEISAKU2  + "' ");
          //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod End
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //�`���V
        else if( _cond.getCode().equals(C_HBAMST_CARD_LEAFLET) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_CHIRASHI  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //�T���v�����O
        else if( _cond.getCode().equals(C_HBAMST_CARD_SAMPLING) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_SAMPLING  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //BS�ECS
        else if( _cond.getCode().equals(C_HBAMST_CARD_BSCS) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_BSCS  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //�C���^�[�l�b�g
        else if( _cond.getCode().equals(C_HBAMST_CARD_INTERNET) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
            sql.append(TBTHBAMST.FIELD1  + " IN ('" + C_HBAMST_FIELD1_INTERNET  + "','" + C_HBAMST_FIELD1_SOCIALMEDIA + "','" +C_HBAMST_FIELD1_DIGITALMOVIE + "') ");
            //sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_INTERNET  + "' ");
            //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod End
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //���o�C��
        else if( _cond.getCode().equals(C_HBAMST_CARD_MOBILE) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_MOBILE  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //���Ɣ�
        else if( _cond.getCode().equals(C_HBAMST_CARD_BUSINESSEXP) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_JIGYOHI  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        return sql.toString();
    }


    /**
     * �ėp�}�X�^�̌������s���܂��B
     *
     * @return �e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindLionCardNoItrVO> findLionCardNoItrByCondition(FindLionCardNoItrCondition cond) throws KKHException {

        super.setModel(new FindLionCardNoItrVO());

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
    protected List<FindLionCardNoItrVO> createFindedModelInstances(List hashList) {
        List<FindLionCardNoItrVO> list = new ArrayList<FindLionCardNoItrVO>();
        if (getModel() instanceof FindLionCardNoItrVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindLionCardNoItrVO vo = new FindLionCardNoItrVO();
                vo.setField1((String)result.get(TBTHBAMST.FIELD1.toUpperCase()));
                vo.setField2((String)result.get(TBTHBAMST.FIELD2.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
