package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���C�I�����[(���쎺���X�g)����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionSeisakuManager {

    /** �V���O���g���C���X�^���X */
    private static AddChangeReportLionSeisakuManager _manager = new AddChangeReportLionSeisakuManager();

    /**
     * �������
     */
    /** �����^�C���X�^���v */
    private static final String RRKTIMSTMP = "RRKTIMSTMP";
    /** ���쎺���X�g(AD1) */
    private static final String SEISAKUAD1 = "SEISAKUAD1";
    /** ���쎺���X�g(AD2) */
    private static final String SEISAKUAD2 = "SEISAKUAD2";

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private AddChangeReportLionSeisakuManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * @return �C���X�^���X
     */
    public static AddChangeReportLionSeisakuManager getInstance() {
        return _manager;
    }

    /**
     * ���C�I�����[�f�[�^(���쎺���X�g)���������܂��B
     *
     * @return ReportAshMediaResult �}�̎�ʈꗗ�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public AddChangeReportLionSeisakuResult findByCondition(AddChangeReportLionSeisakuCondition cond) throws KKHException {

        // �p�����[�^�̕K�{�`�F�b�N
        if (!CheckParameter(cond)) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        AddChangeReportLionSeisakuResult result = new AddChangeReportLionSeisakuResult();
        AddChangeReportLionSeisakuDAO dao = AddChangeReportLionSeisakuDAOFactory.createDAO();

        //�����^�C���X�^���v�̏ꍇ
        if (cond.getFindType().equals(RRKTIMSTMP)) {
            //�����J�n
            List<AddChangeReportLionSeisakuVO> list = dao.findAddChangeReportSeisaku(cond);
            //�������ʊi�[
            result.setRrkTimStmpInfo(list);
        }
        //���쎺���X�g(AD1)�̏ꍇ
        else if (cond.getFindType().equals(SEISAKUAD1)) {
            //�����J�n
            List<AddChangeReportLionSeisakuVO> list = dao.findAddChangeReportSeisaku(cond);
            //�������ʊi�[
            result.setSeisakuAD1Info(list);
        }
        //���삵���X�g(AD2)�̏ꍇ
        else if (cond.getFindType().equals(SEISAKUAD2)) {
            //AD1�����J�n
            List<AddChangeReportLionSeisakuVO> list2 = dao.findAddChangeReportSeisaku(cond);
            //�������ʊi�[
            result.setSeisakuAD1Info(list2);

            //�����擾
            List<AddChangeReportLionSeisakuVO> list3 = dao.findAddChangeReportSeisakuDiff(cond);
            //�������ʊi�[
            result.setSeisakuDiffInfo(list3);

            //AD2�����J�n
            cond.setRrkTimStmp(null);   //�����^�C���X�^���v������
            List<AddChangeReportLionSeisakuVO> list = dao.findAddChangeReportSeisaku(cond);
            //�������ʊi�[
            result.setSeisakuAD2Info(list);
        }

        return result;
    }

    /**
     * �p�����[�^�K�{�`�F�b�N
     * @param cond ���C�I����������
     * @return True: OK�AFalse: NG
     */
    private boolean CheckParameter(AddChangeReportLionSeisakuCondition cond) {

        //ESQ-ID
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            return false;
        }
        //�c�Ə��R�[�h
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            return false;
        }
        //���Ӑ��ƃR�[�h
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            return false;
        }
        //���Ӑ敔��SEQNO
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            return false;
        }
        //���Ӑ�S��SEQNO
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            return false;
        }
        //�N��
        if (cond.getYymm() == null || cond.getYymm().equals("")) {
            return false;
        }
        //�������
        if (cond.getFindType() == null || cond.getFindType().equals("")) {
            return false;
        }

        //���쎺���X�g(AD2)�̏ꍇ�A�����^�C���X�^���v�K�{
        if (cond.getFindType().equals(SEISAKUAD2)) {
            if (cond.getRrkTimStmp() == null || cond.getRrkTimStmp().equals("")) {
                return false;
            }
        }

        return true;
    }

}
