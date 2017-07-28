package jp.co.isid.kkh.customer.epson.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ��o���[�i�G�v�\��)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/5 JSE YS)<BR>
 * �E�G�v�\���d������ύX�Ή�(2017/04/14 HLC K.Soga)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSubMissionDAO extends AbstractRdbDao {

    /** �������� */
    private ReportEpsonSubMissionCondition _cond;

    /** �f�t�H���g�R���X�g���N�^ */
    public ReportEpsonSubMissionDAO() {
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
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return null;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    /**
     * ��o���[���擾��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT DISTINCT");
        sql.append(" SIIRESAKI." + TBTHBAMST.FIELD3 + " KAISHCD,");                     // ���CD
        /** 2017/04/14 �G�v�\���d������ύX�Ή� HLC K.Soga MOD Start */
        //sql.append(" SIIRESAKI." + TBTHBAMST.FIELD4 + " KIHYOBMNCD,");                // �N�[����CD
        sql.append(" " + TBTHB2KMEI.SONOTA2 + " KIHYOBMNCD,");
        /** 2017/04/14 �G�v�\���d������ύX�Ή� HLC K.Soga MOD End */
        sql.append(" SIIRESAKI." + TBTHBAMST.FIELD1 + " SHIIRESKCD,");                  // �d����R�[�h
        sql.append(" SIIRESAKI." + TBTHBAMST.FIELD5 + " TUKACD,");                      // �ʉ�CD
        sql.append(" " + TBTHB2KMEI.DATE1 + " KEIJYOBI,");                              // �v���
        sql.append(" SIIRESAKI." + TBTHBAMST.INTVALUE2 + " RATE,");                     // ���Z���[�g
        sql.append(" " + TBTHB2KMEI.SONOTA1 + " SEINO,");                               // ����搿��No
        sql.append(" SIIRESAKI." + TBTHBAMST.INTVALUE1 + " ZEIKBN,");                   // ���O�ŋ敪
        sql.append(" " + TBTHB2KMEI.CODE4 + " TORISIKICD,");                            // ������ʃR�[�h
        /** 2017/04/14 �G�v�\���d������ύX�Ή� HLC K.Soga MOD Start **/
        //sql.append(" SIIRESAKI." + TBTHBAMST.FIELD6 + " GENKACENT,");                 // �����Z���^
        sql.append(" " + TBTHB2KMEI.SONOTA3 + " GENKACENT,");
        /** 2017/04/14 �G�v�\���d������ύX�Ή� HLC K.Soga MOD End **/
        sql.append(" " + TBTHB2KMEI.NAME5 + " SASHIZUNO,");                             // �w�}No
        sql.append(" " + TBTHB2KMEI.NAME6 + " SEGUSASHINO,");                           // �Z�O�����g�w�}�ԍ�
        sql.append(" " + TBTHB2KMEI.SEIGAK + " + " + TBTHB2KMEI.KNGK1 + " TORIGAK,");   // ������z
        sql.append(" " + TBTHB2KMEI.KNGK1 + " SYOHIGAK,");                              // ����Ŋz
        sql.append(" CASE " + TBTHB2KMEI.NAME7);                                        // �\�[�g�L�[
        sql.append(" WHEN ' ' THEN 0 ELSE TO_NUMBER(" + TBTHB2KMEI.NAME7 + ") END SORT_KEY");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB14SKDOWN.TBNAME + ",");
        sql.append(" (SELECT");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");       // �t�B�[���h1�F�����R�[�h
        sql.append(" " + TBTHBAMST.FIELD2 + ",");       // �t�B�[���h2�F�U����R�[�h
        sql.append(" " + TBTHBAMST.FIELD3 + ",");       // �t�B�[���h3�F���CD
        sql.append(" " + TBTHBAMST.FIELD4 + ",");       // �t�B�[���h4�F�N�[����CD
        sql.append(" " + TBTHBAMST.FIELD5 + ",");       // �t�B�[���h5�F�ʉ�CD
        sql.append(" " + TBTHBAMST.FIELD6 + ",");       // �t�B�[���h6�F�����Z���^
        sql.append(" " + TBTHBAMST.INTVALUE1 + ",");    // ���l1      �F�ŋ敪
        sql.append(" " + TBTHBAMST.INTVALUE2);          // ���l2      �F���Z���[�g
        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.SYBT  + " = '103'");
        sql.append(" ) SIIRESAKI");

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM  + " = '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.NAME21  + " = '2' AND");        // ���׎��
        sql.append(" " + TBTHB2KMEI.KBN1 + " <> '1' AND");          // �����ΏۊO�t���O���A1�ȊO�̃��R�[�h���Ώ�
        sql.append(" " + TBTHB14SKDOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB14SKDOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB14SKDOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB14SKDOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB14SKDOWN.SEINO + " = " + TBTHB2KMEI.SONOTA1 + " AND");
        sql.append(" " + TBTHB14SKDOWN.SEIYYMM + " = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB14SKDOWN.SEISTATUS + " IN ('2','3') ");

        sql.append(" ORDER BY");
        sql.append(" SORT_KEY"); // �\�[�g�L�[

        return sql.toString();
    }

    /**
     * ��o���[�f�[�^�i�G�v�\��)�̌������s���܂��B
     *
     * @return ��o���[�i�G�v�\��)VO ���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportEpsonSubMissionVO> findReportEpsonSubMissionByCondition(ReportEpsonSubMissionCondition cond)
            throws KKHException {

        super.setModel(new ReportEpsonSubMissionVO());

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
     * @return List<ReportEpsonSubMissionVO> �ϊ���̌�������
     */
    @Override
    protected List<ReportEpsonSubMissionVO> createFindedModelInstances(List hashList) {

        List<ReportEpsonSubMissionVO> list = new ArrayList<ReportEpsonSubMissionVO>();

        if (getModel() instanceof ReportEpsonSubMissionVO) {

            for (int i = 0; i < hashList.size(); i++) {

                Map result = (Map) hashList.get(i);
                ReportEpsonSubMissionVO vo = new ReportEpsonSubMissionVO();

                vo.setDenpyoNo("");                                          // �`�[�o�^NO
                vo.setMeisaiNo("");                                          // ����NO
                vo.setKaishCd((String) result.get("KAISHCD"));               // ���CD
                vo.setKihyoBmnCd((String) result.get("KIHYOBMNCD"));         // �N�[����CD
                vo.setShireskCd((String) result.get("SHIIRESKCD"));          // �d����R�[�h
                vo.setTukaCd((String) result.get("TUKACD"));                 // �ʉ�CD
                vo.setHatskCd("");                                           // �����敔��CD
                vo.setKeijyobi((String) result.get("KEIJYOBI"));             // �v���
                vo.setRate((BigDecimal) result.get("RATE"));                 // ���Z���[�g

                {
                    String s = (String)result.get("SEINO");

                    if ((s != null) && (s.length() == 12))
                    {
                        s = s.substring(0, 8) + "-" + s.substring(8, 12);
                    }

                    vo.setSeiNo(s);                                          // ����搿��No
                }

                vo.setZeiKbn((BigDecimal) result.get("ZEIKBN"));             // ���O�ŋ敪
                vo.setToriSikiCd((String) result.get("TORISIKICD"));         // ������ʃR�[�h
                vo.setGenkaCent((String) result.get("GENKACENT"));           // �����Z���^
                vo.setRiekiCent("");                                         // ���v�Z���^
                vo.setSashizuNo((String) result.get("SASHIZUNO"));           // �w�}No
                vo.setSeguSashiNo((String) result.get("SEGUSASHINO"));       // �Z�O�����g�w�}�ԍ�
                vo.setToriSaki("");                                          // �����i���֐�j
                vo.setToriNaiyo("");                                         // ��̓I������e
                vo.setToriGak((BigDecimal) result.get("TORIGAK"));           // ������z
                vo.setSyohiGak((BigDecimal) result.get("SYOHIGAK"));         // ����Ŋz
                vo.setKansanGak("");                                         // ���Z���z
                vo.setKansanSGak("");                                        // ���Z����Ŋz
                vo.setKeshikomiKey("");                                      // ����Key
                vo.setHinmokuCd("");                                         // �i�ڃR�[�h
                vo.setHinmokuMei("");                                        // �i�ږ���
                vo.setKataban("");                                           // �^��
                vo.setSuryo("");                                             // ����
                vo.setTani("");                                              // �P��
                vo.setToriTank("");                                          // ����P��
                vo.setKansanTank("");                                        // ���Z�P��
                vo.setPoNo("");                                              // P/ONo
                vo.setKeiyakuNo("");                                         // �_��No
                vo.setRingiNo("");                                           // �g�c��No
                vo.setGensenToriGak("");                                     // ����Ŏ�����z
                vo.setGensenZeiRitu("");                                     // ����ŗ�
                vo.setMaeTaisyoKbn("");                                      // �O���Ώۋ敪
                vo.setJyokenKakuKbn("");                                     // �����m��敪
                vo.setKikanFrom("");                                         // ���ԁiFrom�j
                vo.setKikanTo("");                                           // ���ԁiTo�j
                vo.setFurikaeJyoken("");                                     // �U�֏���

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }
}