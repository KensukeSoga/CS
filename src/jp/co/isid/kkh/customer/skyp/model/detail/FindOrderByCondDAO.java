package jp.co.isid.kkh.customer.skyp.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
//import jp.co.isid.kkh.model.detail.Thb1DownDAO.SelSqlMode;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ���я����擾DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/21 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindOrderByCondDAO extends AbstractRdbDao {

    /** �}�̋敪 (BAITAI_KBN) */
    static final String BAITAI_KBN = "BAITAI_KBN";

    /** �}�̖��� (BAITAI_MEISYO) */
    static final String BAITAI_MEISYO = "BAITAI_MEISYO";

    /** ���s���� (HAKKO_KIKAN) */
    static final String HAKKO_KIKAN = "HAKKO_KIKAN";

    /** ���z���v (SUM_KINGAKU) */
    static final String KINGAKU = "SUM_KINGAKU";

    /** ����Ŋz���v (SUM_SYOHIZEIGAKU) */
    static final String SYOHIZEIGAKU = "SUM_SYOHIZEIGAKU";

    /** �������z���v (SUM_SEIKYU_KINGAKU) */
    static final String SEIKYU_KINGAKU = "SUM_SEIKYU_KINGAKU";

    /** ���я� (NARABI_JUN) */
    static final String NARABI_JUN = "NARABI_JUN";

    /** �f�[�^�������� */
    private FindOrderCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SelSqlMode{NORMAL,NAMESERCH};
    private SelSqlMode _selSqlMode = SelSqlMode.NORMAL;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindOrderByCondDAO() {
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
        // new String[] {};
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return TBTHB1DOWN.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[] {
                BAITAI_KBN,
                BAITAI_MEISYO,
                HAKKO_KIKAN,
                KINGAKU,
                SYOHIZEIGAKU,
                SEIKYU_KINGAKU,
                NARABI_JUN,
                };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {

        String sql = "";

        if(_selSqlMode.equals(SelSqlMode.NORMAL))
        {
            sql = getSelectSQLForOrder();
        }else if(_selSqlMode.equals(SelSqlMode.NAMESERCH))
        {
            sql = getNumberbyName();
        }

        return sql;
    }

    private String getNumberbyName()
    {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + TBTHB2KMEI.SONOTA1 + "  AS " + NARABI_JUN);
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append("     " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHB2KMEI.YYMM        + " = '" + _cond.getYm() + "'");
        sql.append(" AND " + TBTHB2KMEI.NAME13        + " = '" + _cond.getbaitaikbn() + "'");

        return sql.toString();
    }

    /**
     * ���я����擾��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    private String getSelectSQLForOrder() {

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + TBTHB2KMEI.NAME13  + "                                                     AS " + BAITAI_KBN);
        sql.append("," + TBTHB2KMEI.NAME7  + "                                                      AS " + BAITAI_MEISYO);
        sql.append(",SUM(" + TBTHB2KMEI.SEIGAK  + ")                                                AS " + KINGAKU);
        sql.append(",SUM(" + TBTHB2KMEI.KNGK1  + ")                                                 AS " + SYOHIZEIGAKU);
        sql.append(",SUM(" + TBTHB2KMEI.SEIGAK + " + " + TBTHB2KMEI.KNGK1  + ")                     AS " + SEIKYU_KINGAKU);
        sql.append(",DECODE(TRIM(" + TBTHB2KMEI.SONOTA1 + "), '', NULL, " + TBTHB2KMEI.SONOTA1 + ") AS " + NARABI_JUN);

        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME);
        sql.append(" INNER JOIN");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" ON");
        sql.append("     " + TBTHB2KMEI.EGCD + "        = " + TBTHB1DOWN.EGCD);
        sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = " + TBTHB1DOWN.TKSKGYCD);
        sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO);
        sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO);
        sql.append(" AND " + TBTHB2KMEI.YYMM + "        = " + TBTHB1DOWN.YYMM);
        sql.append(" AND " + TBTHB2KMEI.JYUTNO + "      = " + TBTHB1DOWN.JYUTNO);
        sql.append(" AND " + TBTHB2KMEI.JYMEINO + "     = " + TBTHB1DOWN.JYMEINO);
        sql.append(" AND " + TBTHB2KMEI.URMEINO + "     = " + TBTHB1DOWN.URMEINO);

        sql.append(" WHERE");
        sql.append("     " + TBTHB1DOWN.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHB1DOWN.YYMM        + " = '" + _cond.getYm() + "'");
        sql.append(" AND " + TBTHB1DOWN.TJYUTNO     + " = ' '");

        sql.append(" GROUP BY");
        sql.append(" " + TBTHB2KMEI.SONOTA1);
        sql.append("," + TBTHB2KMEI.NAME13);
        sql.append("," + TBTHB2KMEI.NAME7);

        sql.append(" ORDER BY");
        sql.append(" " + NARABI_JUN);
        sql.append("," + KINGAKU + " DESC");
        sql.append("," + BAITAI_KBN);
        sql.append("," + BAITAI_MEISYO);

        return sql.toString();
    }

    /**
     * ���я����̌������s���܂��B
     *
     * @return ���я������܂�VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindOrderCondVO> findOrderByCondition(
            FindOrderCondition cond) throws KKHException {

        super.setModel(new FindOrderCondVO());

        try {
            if(cond.getbaitaikbn() == null || cond.getbaitaikbn().equals(""))
            {
                _selSqlMode = SelSqlMode.NORMAL;
            }else
            {
                _selSqlMode = SelSqlMode.NAMESERCH;
            }
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
     * @return List<FindJissiNoCntCondVO> �ϊ���̌�������
     */
    @Override
    protected List<FindOrderCondVO> createFindedModelInstances(List hashList) {

        List<FindOrderCondVO> list = new ArrayList<FindOrderCondVO>();
        String yy = _cond.getYm().substring(4, 6);
        String narabiJun;

        if (yy.substring(0, 1).equals("0"))
        {
            yy = yy.substring(1, 2);
        }
        yy = yy + "����";

        if (getModel() instanceof FindOrderCondVO) {

            for (int i = 0; i < hashList.size(); i++) {

                Map result = (Map) hashList.get(i);
                FindOrderCondVO vo = new FindOrderCondVO();

                if(_selSqlMode.equals(SelSqlMode.NORMAL))
                {
                    vo.setBaitaiKbn((String) result.get(BAITAI_KBN.toUpperCase()));
                    vo.setBaitaiMeisyo((String) result.get(BAITAI_MEISYO.toUpperCase()));
                    vo.setHakkoKikan(yy);
                    vo.setKingaku((BigDecimal) result.get(KINGAKU.toUpperCase()));
                    vo.setSyohizeiGaku((BigDecimal) result.get(SYOHIZEIGAKU.toUpperCase()));
                    vo.setSeikyuKingaku((BigDecimal) result.get(SEIKYU_KINGAKU.toUpperCase()));

                    narabiJun = (String) result.get(NARABI_JUN.toUpperCase());

                    try{
                        vo.setNarabiJun(String.valueOf(Integer.parseInt(narabiJun)));
                    } catch(NumberFormatException ex){
                        vo.setNarabiJun("");
                    }
                }else
                {
                    vo.setNarabiJun((String)result.get(NARABI_JUN.toUpperCase()));
                }
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
