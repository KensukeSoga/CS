package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���C�I���������\��\����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class InvoicePlanLionManager {

    /** �V���O���g���C���X�^���X */
    private static InvoicePlanLionManager _manager = new InvoicePlanLionManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private InvoicePlanLionManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * @return �C���X�^���X
     */
    public static InvoicePlanLionManager getInstance() {
        return _manager;
    }

    /**
     * ���C�I�������\��\���������܂��B
     *
     * @return ReportAshMediaResult �}�̎�ʈꗗ�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public InvoicePlanLionResult findByCondition(InvoicePlanLionCondition cond) throws KKHException {

        // �p�����[�^�̕K�{�`�F�b�N
        if (!CheckParameter(cond)) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        InvoicePlanLionResult result = new InvoicePlanLionResult();
        InvoicePlanLionDAO dao = InvoicePlanLionDAOFactory.createDAO();

        //�����J�n
        List<InvoicePlanLionVO> list = dao.findInvoicePlan(cond);
        //�������ʊi�[
        result.setInvoicePlanInfo(list);

        return result;
    }

    /**
     * �p�����[�^�K�{�`�F�b�N
     * @param cond ���C�I����������
     * @return True: OK�AFalse: NG
     */
    private boolean CheckParameter(InvoicePlanLionCondition cond) {

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
        //���ƕ�
        if (cond.getDivision() == null || cond.getDivision().equals("")) {
            return false;
        }

        return true;
    }

}
