package jp.co.isid.kkh.customer.lion.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindLionCodeItrDAO extends AbstractRdbDao {

	/** �ėp�}�X�^�������� */
	private FindLionCodeItrCondition _cond;

    //�J�[�hNo///////////////////////////////////////////////////////////////////////////////////////////
    /** �ėp�}�X�^�F�J�[�hNO�F�e���r�^�C�� */
    public static final String C_HBAMST_CARD_TV_TIME =  LionConstants.CardNo.TV_TIME.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F�e���r���[�J�� */
    public static final String C_HBAMST_CARD_TV_LOCAL =  LionConstants.CardNo.TV_LOCAL.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���W�I�^�C�� */
    public static final String C_HBAMST_CARD_RD_TIME =  LionConstants.CardNo.RD_TIME.getCode();
    /** �ėp�}�X�^�F�J�[�hNO�F���W�I���[�J�� */
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

	// ���//////////////////////////////////////////////////////////////////////////////////////////////////
	/** �ėp�}�X�^�F��ʁF�V�� */
	public static final String C_HBAMST_SYBT_SHINBUN = LionConstants.MastBaitaiShubetsu.SHINBUN.getCode();
	/** �ėp�}�X�^�F��ʁF�G�� */
	public static final String C_HBAMST_SYBT_ZASHI = LionConstants.MastBaitaiShubetsu.ZASHI.getCode();
	/** �ėp�}�X�^�F��ʁF�G���X�y�[�X */
	public static final String C_HBAMST_SYBT_ZASHI_SPACE = LionConstants.MastBaitaiShubetsu.ZASHI_SPACE.getCode();
	/** �ėp�}�X�^�F��ʁF�G������ */
	public static final String C_HBAMST_SYBT_ZASHI_RYOKIN = LionConstants.MastBaitaiShubetsu.ZASHI_RYOKIN.getCode();
	/** �ėp�}�X�^�F��ʁF���W�I�� */
	public static final String C_HBAMST_SYBT_RD = LionConstants.MastBaitaiShubetsu.RD_KYOKU.getCode();
	/** �ėp�}�X�^�F��ʁF�e���r�� */
	public static final String C_HBAMST_SYBT_TV = LionConstants.MastBaitaiShubetsu.TV_KYOKU.getCode();
	/** �ėp�}�X�^�F��ʁF�� */
	public static final String C_HBAMST_SYBT_KEN = LionConstants.MastBaitaiShubetsu.KEN.getCode();
	/** �ėp�}�X�^�F��ʁF�}�̋敪 */
	public static final String C_HBAMST_SYBT_BAITAI_KBN = LionConstants.MastBaitaiShubetsu.BAITAI_KBN.getCode();
	/** �ėp�}�X�^�F��ʁF�C���^�[�l�b�g */
	public static final String C_HBAMST_SYBT_INTERNET = LionConstants.MastBaitaiShubetsu.INTERNET.getCode();
	/** �ėp�}�X�^�F��ʁF���o�C�� */
	public static final String C_HBAMST_SYBT_MOBILE = LionConstants.MastBaitaiShubetsu.MOBILE.getCode();

    //Field1�R�[�h///////////////////////////////////////////////////////////////////////////////////////////
    /** ����1 */
    public static final String C_HBAMST_FIELD1_SEISAKU1 =  LionConstants.Field1Code.SEISAKU1.getCode();
    /** ����2 */
    public static final String C_HBAMST_FIELD1_SEISAKU2 =  LionConstants.Field1Code.SEISAKU2.getCode();

	// 2017/06/20 ���C�I���Ή� ITCOM K.SAKUMA Add Start
	/** �C���^�[�l�b�g */
	public static final String C_HBAMST_FIELD1_INTERNET = LionConstants.Field1Code.INTERNET.getCode();
	/** �\�[�V�������f�B�A */
	public static final String C_HBAMST_FIELD1_SOCIALMEDIA = LionConstants.Field1Code.SOCIALMEDIA.getCode();
	/** �f�W�^������ */
	public static final String C_HBAMST_FIELD1_DIGITALMOVIE = LionConstants.Field1Code.DIGITALMOVIE.getCode();
	// 2017/06/20 ���C�I���Ή� ITCOM K.SAKUMA Add End

	// �}�̃R�[�h/////////////////////////////////////////////////////////////////////////////////////////////
	/** TV�X�|�b�g */
	public static final String C_HBAMST_BTCD_TV = LionConstants.BaitaiKbn.TV_SPOT.getCode();
	/** RD�X�|�b�g */
	public static final String C_HBAMST_BTCD_RD = LionConstants.BaitaiKbn.RD_SPOT.getCode();

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindLionCodeItrDAO() {
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
        return null;
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

		// �V��
		if (_cond.getCdNo().equals(C_HBAMST_CARD_SHINBUN)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			// �V���}�X�^
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_SHINBUN + "' ");
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}

		// �G��
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_ZASHI)) {
			sql.append(" SELECT ");
			sql.append(" DISTINCT ");
			sql.append("  ZASSHI." + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ,ZASSHI." + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" ,ZSPACE." + TBTHBAMST.FIELD1 + " AS VAL3 ");
			sql.append(" ,ZSPACE." + TBTHBAMST.FIELD2 + " AS VAL4 ");
			sql.append(" ,RYOKIN." + TBTHBAMST.INTVALUE1 + " ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ZASSHI, " + TBTHBAMST.TBNAME + " ZSPACE, " + TBTHBAMST.TBNAME + " RYOKIN ");
			sql.append(" WHERE ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSKGYCD + " = ZSPACE." + TBTHBAMST.TKSKGYCD + " AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSBMNSEQNO + " = ZSPACE." + TBTHBAMST.TKSBMNSEQNO + " AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSTNTSEQNO + " = ZSPACE." + TBTHBAMST.TKSTNTSEQNO + " AND ");
			// �G���E�G���X�y�[�X�E�����}�X�^
			sql.append(" ZASSHI." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI + "' AND ");
			sql.append(" ZSPACE." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_SPACE + "' AND ");
			sql.append(" RYOKIN." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_RYOKIN + "' AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSKGYCD + " = RYOKIN." + TBTHBAMST.TKSKGYCD + " AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSBMNSEQNO + " = RYOKIN." + TBTHBAMST.TKSBMNSEQNO + " AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSTNTSEQNO + " = RYOKIN." + TBTHBAMST.TKSTNTSEQNO + " AND ");
			sql.append(" ZASSHI." + TBTHBAMST.FIELD1 + " = RYOKIN." + TBTHBAMST.FIELD1 + " AND ");
			sql.append(" ZSPACE." + TBTHBAMST.FIELD1 + " = RYOKIN." + TBTHBAMST.FIELD2 + " ");
			sql.append("  ORDER BY ");
			sql.append(" ZASSHI." + TBTHBAMST.FIELD1);
		}

		// ���W�I�^�C���E���W�I���[�J��
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_RD_TIME) || _cond.getCdNo().equals(C_HBAMST_CARD_RD_LOCAL)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHB12WLRDK.KYOKUCD + " AS VAL1 ");
			sql.append(" ," + TBTHB12WLRDK.KYOKUNAME + " AS VAL2 ");
			sql.append(" ," + TBTHB12WLRDK.KEIRETSU + " AS VAL3 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHB12WLRDK.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHB12WLRDK.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHB12WLRDK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHB12WLRDK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  ");
			sql.append("  ORDER BY ");
			sql.append(TBTHB12WLRDK.KYOKUCD);
		}

		// �X�|�b�g(�e���r�E���W�I)
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_SPOT)) {
			// �e���r�X�|�b�g
			if (_cond.getBtCd().equals(C_HBAMST_BTCD_TV)) {
				sql.append(" SELECT ");
				sql.append("  " + TBTHB11WLTVK.KYOKUCD + " AS VAL1 ");
				sql.append(" ," + TBTHB11WLTVK.KYOKUNAME + " AS VAL2 ");
				sql.append(" ," + TBTHB11WLTVK.KEIRETSU + " AS VAL3 ");
				sql.append(" FROM ");
				sql.append("  " + TBTHB11WLTVK.TBNAME + " ");
				sql.append(" WHERE ");
				sql.append(TBTHB11WLTVK.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
				sql.append(TBTHB11WLTVK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
				sql.append(TBTHB11WLTVK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
				sql.append("  ORDER BY ");
				sql.append(TBTHB11WLTVK.THYOJIJYUN);
			}
			// ���W�I�X�|�b�g
			else if (_cond.getBtCd().equals(C_HBAMST_BTCD_RD)) {
				sql.append(" SELECT ");
				sql.append("  " + TBTHB12WLRDK.KYOKUCD + " AS VAL1 ");
				sql.append(" ," + TBTHB12WLRDK.KYOKUNAME + " AS VAL2 ");
				sql.append(" ," + TBTHB12WLRDK.KEIRETSU + " AS VAL3 ");
				sql.append(" FROM ");
				sql.append("  " + TBTHB12WLRDK.TBNAME + " ");
				sql.append(" WHERE ");
				sql.append(TBTHB12WLRDK.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
				sql.append(TBTHB12WLRDK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
				sql.append(TBTHB12WLRDK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
				sql.append("  ORDER BY ");
				sql.append(TBTHB12WLRDK.KYOKUCD);
			}
		}

		// �e���r�^�C���E�e���r���[�J���EBSCS
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_TV_TIME) || _cond.getCdNo().equals(C_HBAMST_CARD_TV_LOCAL) || _cond.getCdNo().equals(C_HBAMST_CARD_BSCS)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHB11WLTVK.KYOKUCD + " AS VAL1 ");
			sql.append(" ," + TBTHB11WLTVK.KYOKUNAME + " AS VAL2 ");
			sql.append(" ," + TBTHB11WLTVK.KEIRETSU + " AS VAL3 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHB11WLTVK.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHB11WLTVK.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHB11WLTVK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHB11WLTVK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
			sql.append("  ORDER BY ");
			sql.append(TBTHB11WLTVK.THYOJIJYUN);
		}

		// ���
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_KOUTU)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			// ���}�X�^
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_KEN + "' ");
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}

		// ����
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_SEISAKUHI)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" ," + TBTHBAMST.INTVALUE1 + " ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			// �}�̋敪�}�X�^
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BAITAI_KBN + "'  AND ");
			// 2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
			// �}�̋敪40�A41�ȊO��\��
			sql.append(TBTHBAMST.FIELD1 + " BETWEEN '" + C_HBAMST_FIELD1_SEISAKU1 + "' AND '" + C_HBAMST_FIELD1_SEISAKU2 + "' AND ");
			sql.append(TBTHBAMST.FIELD1 + " NOT IN ('40' ,'41') ");
			// sql.append(TBTHBAMST.FIELD1 + " BETWEEN '" + C_HBAMST_FIELD1_SEISAKU1 + "' AND '" + C_HBAMST_FIELD1_SEISAKU2 + "' ");
			// 2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod End
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}
		// 2017/06/20 ���C�I���Ή� ITCOM K.SAKUMA Mod Start
		// �C���^�[�l�b�g(�}�̋敪������)
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_INTERNET)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			// �C���^�[�l�b�g�}�X�^
			// sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_INTERNET + "' ");
			// �}�̋敪�}�X�^
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BAITAI_KBN + "'  AND ");
			sql.append(TBTHBAMST.FIELD1 + " IN ('" + C_HBAMST_FIELD1_INTERNET + "','" + C_HBAMST_FIELD1_SOCIALMEDIA + "','" + C_HBAMST_FIELD1_DIGITALMOVIE + "') ");
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}
		// �C���^�[�l�b�g(�ǎ��R�[�h������)
		// else if( _cond.getCdNo().equals(C_HBAMST_CARD_INTERNET) ){
		// sql.append(" SELECT ");
		// sql.append(" " + TBTHBAMST.FIELD1 + " AS VAL1 ");
		// sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
		// sql.append(" FROM ");
		// sql.append(" " + TBTHBAMST.TBNAME + " ");
		// sql.append(" WHERE ");
		// sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
		// sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
		// sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
		// //�C���^�[�l�b�g�}�X�^
		// //sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_INTERNET + "' ");
		// sql.append(" ORDER BY ");
		// sql.append(TBTHBAMST.FIELD1);
		// }
		// 2017/06/20 ���C�I���Ή� ITCOM K.SAKUMA Mod End
		// ���o�C��
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_MOBILE)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			// ���o�C���}�X�^
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_MOBILE + "' ");
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}

		else {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" ," + TBTHBAMST.INTVALUE1 + " ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BAITAI_KBN + "'  AND ");
			sql.append(TBTHBAMST.FIELD1 + " IN ('13','50','51') ");
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
	public List<FindLionCodeItrVO> findLionCodeItrByCondition(FindLionCodeItrCondition cond) throws KKHException {

		super.setModel(new FindLionCodeItrVO());

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
	protected List<FindLionCodeItrVO> createFindedModelInstances(List hashList) {
		List<FindLionCodeItrVO> list = new ArrayList<FindLionCodeItrVO>();
		if (getModel() instanceof FindLionCodeItrVO) {
			for (int i = 0; i < hashList.size(); i++) {
				Map result = (Map) hashList.get(i);
				FindLionCodeItrVO vo = new FindLionCodeItrVO();
				// �}�X�^�P�`�S�܂œ��I
				vo.setVal1((String) result.get(FindLionCodeItrVO.VAL1.toUpperCase()));
				vo.setVal2((String) result.get(FindLionCodeItrVO.VAL2.toUpperCase()));
				vo.setVal3((String) result.get(FindLionCodeItrVO.VAL3.toUpperCase()));
				vo.setVal4((String) result.get(FindLionCodeItrVO.VAL4.toUpperCase()));
				vo.setIntvalue1((BigDecimal) result.get(TBTHBAMST.INTVALUE1.toUpperCase()));

				// �������ʒ���̏�Ԃɂ���
				ModelUtils.copyMemberSearchAfterInstace(vo);
				list.add(vo);
			}
		}

		return list;
	}

}
