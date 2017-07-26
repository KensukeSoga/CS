package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 * <P>
 * �����f�[�^�ꗗ����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�A�T�q����őΉ�(2016/11/22 HLC K.Soga)<BR>
 * </P>
 * @author
 */
public class FDAshDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^�������� */
    private ReportAshMediaCondition _cond;

    /** �f�t�H���g�R���X�g���N�^ */
    public FDAshDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     * @return String[] �v���C�}���L�[
     */
    @Override
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     * @return String �e�[�u����
     */
    @Override
    public String getTableName() {
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append("(SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " seikyuno,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " baitaicd,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga MOD Start */
        //sql.append(" (ROUND(" + TBTHB2KMEI.SEIGAK + ") + (TRUNC(ROUND(" + TBTHB2KMEI.SEIGAK + ") * (0.01 * " + TBTHB2KMEI.RITU1 + "))))" + " seikyukinzeiari,");
        //�������z(�ō�)(�������z + �����)
        sql.append(" ROUND(" + TBTHB2KMEI.SEIGAK + ") + ROUND(" + TBTHB2KMEI.KNGK1 + ")" + " seikyukinzeiari,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga MOD End */
        sql.append(" ROUND(" + TBTHB2KMEI.SEIGAK + ") seikyukinzeinashi,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " kyokucd,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " hinsyucd,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " dairitencd,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " bangumicd,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ, ");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " kenmei,");
        sql.append(" ' ' jyutjymei,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + " sortno,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " jyutno,");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " jymeino,");
        sql.append(" " + TBTHB2KMEI.URMEINO + " urmeino,");
        sql.append(" " + TBTHB2KMEI.RENBN + " renbn,");
        sql.append(" " + TBTHB2KMEI.SEIGAK + " seikyukin,");
        sql.append(" " + TBTHB2KMEI.RITU1 + " shohizeiritu");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " <> ' ' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " NOT IN ('130','140')");
        sql.append(" )");

        sql.append(" UNION ALL");
        sql.append(" (SELECT");
        sql.append(" MIN(" + TBTHB2KMEI.NAME4 + ") seikyuno,");
        sql.append(" MIN(" + TBTHB2KMEI.CODE1 + ") baitaicd,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga MOD Start */
        //sql.append(" SUM(ROUND(" + TBTHB2KMEI.SEIGAK + ") + (TRUNC(ROUND(" + TBTHB2KMEI.SEIGAK + ") * (0.01 * " + TBTHB2KMEI.RITU1 + "))))" + " seikyukinzeiari,");
        //�������z(�ō�)(�������z + �����)
        sql.append(" SUM(ROUND(" + TBTHB2KMEI.SEIGAK + ") + ROUND(" + TBTHB2KMEI.KNGK1 + "))" + " seikyukinzeiari,");
        /** 2016/11/24 �A�T�q����őΉ� HLC K.Soga MOD End */
        sql.append(" SUM(ROUND(" + TBTHB2KMEI.SEIGAK + ")) seikyukinzeinashi,");
        sql.append(" MIN(" + TBTHB2KMEI.CODE2 + ") kyokucd,");
        sql.append(" MIN(" + TBTHB2KMEI.CODE3 + ") hinsyucd,");
        sql.append(" MIN(" + TBTHB2KMEI.CODE4 + ") dairitencd,");
        sql.append(" MIN(" + TBTHB2KMEI.CODE5 + ") bangumicd,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ, ");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" MIN(" + TBTHB2KMEI.NAME10 + ") kenmei,");
        sql.append(" SUBSTR(" + TBTHB2KMEI.NAME3 + ",1,14) jyutjymei,");
        sql.append(" MIN(" + TBTHB2KMEI.SONOTA10 + ") sortno,");
        sql.append(" MIN(" + TBTHB2KMEI.JYUTNO + ") jyutno,");
        sql.append(" MIN(" + TBTHB2KMEI.JYMEINO + ") jymeino,");
        sql.append(" MIN(" + TBTHB2KMEI.URMEINO + ") urmeino,");
        sql.append(" MIN(" + TBTHB2KMEI.RENBN + ") renbn,");
        sql.append(" MIN(" + TBTHB2KMEI.SEIGAK + ") seikyukin,");
        sql.append(" MIN(" + TBTHB2KMEI.RITU1 + ") shohizeiritu");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " <> ' ' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('130','140')");

        sql.append("GROUP BY");
        sql.append(" SUBSTR(" + TBTHB2KMEI.NAME3 + ",1,14),");
        sql.append(" " + TBTHB2KMEI.CODE1 + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA9);
        sql.append(")");

        sql.append("ORDER BY");
        sql.append(" sortno,");
        sql.append(" baitaicd,");
        sql.append(" seikyuno,");
        sql.append(" jyutno,");
        sql.append(" jymeino,");
        sql.append(" urmeino,");
        sql.append(" renbn");
        return sql.toString();
    }

    /**
     * �����f�[�^�ꗗ�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FDAshVO> findFDAshByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new FDAshVO());
        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }
}