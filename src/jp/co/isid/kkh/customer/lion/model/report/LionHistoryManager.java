package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���C�I���󒍗����쐬����Manager
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class LionHistoryManager {

    /** �V���O���g���C���X�^���X */
    private static LionHistoryManager _manager = new LionHistoryManager();

    /** ���C�I�������쐬���� */
//    LionHistoryCondition cond = new LionHistoryCondition();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private LionHistoryManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static LionHistoryManager getInstance() {
        return _manager;
    }

     /**
     * ���C�I���󒍗����f�[�^��o�^���܂��B
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public LionHistoryResult insertLionRrkInfo(LionHistoryCondition cond) throws KKHException {

        // �p�����[�^�̕K�{�`�F�b�N
        if (!CheckParameter(cond)) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        LionHistoryResult result = new LionHistoryResult();

        // �󒍃_�E�����[�h
        LionHistoryHeaderDAO headerDao = LionHistoryHeaderDAOFactory.createDAO();
        headerDao.insertHistoryHeaderCreate(cond);

        //�L�����
        LionHistoryDetailDAO detailDao = LionHistoryDetailDAOFactory.createDAO();
        detailDao.insertHistoryDetailCreate(cond);

        return result;
    }

    /**
     * �p�����[�^�`�F�b�N
     * @param cond ���C�I����������
     * @return ture: OK�Afalse: NG
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private boolean CheckParameter(LionHistoryCondition cond) throws KKHException {

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
        //�����^�C���X�^���v
        if (cond.getRrkTimStmp() == null || cond.getRrkTimStmp().equals("")) {
            return false;
        }
        //�����쐬���I��}��
        if (cond.getRrkGetBaitai() == null || cond.getRrkGetBaitai().equals("")) {
            return false;
        }

        return true;
    }

}
