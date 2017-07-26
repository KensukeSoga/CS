package jp.co.isid.kkh.customer.tkd.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class FindMaxJissiNoByCondManager {

    /** �V���O���g���C���X�^���X */
    private static FindMaxJissiNoByCondManager _manager = new FindMaxJissiNoByCondManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FindMaxJissiNoByCondManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindMaxJissiNoByCondManager getInstance() {
        return _manager;
    }

    /**
     * (�f�[�^)���������܂��B
     *
     * @return FindByCondResult �}�X�^�����f�[�^
     * @throws KKHException
     *             �������ɃG���[�����������ꍇ
     */
    public FindMaxJissiNoByCondResult findMaxjissiNoByCondition(FindMaxJissiNoCondition cond)
            throws KKHException {

        // �p�����[�^�̕K�{�`�F�b�N
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getYm() == null || cond.getYm().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        // ��������
        FindMaxJissiNoByCondResult result = new FindMaxJissiNoByCondResult();

        // ��������
        FindMaxJissiNoCondition lCond = new FindMaxJissiNoCondition();

        // ******************************************************
        // ���{No�̍ő�l���擾
        // ******************************************************
        FindMaxJissiNoByCondDAO dao = FindMaxJissiNoByCondDAOFactory.createFindMaxJissiNoByCondDAO();

        // ******************************************************
        // �}�X�^��ސݒ���擾
        // ******************************************************
        lCond = cond;
        List<FindMaxJissiNoCondVO> list = dao.findMaxjissiNoByCondition(lCond);
        FindMaxJissiNoCondVO vo = list.get(0);

        result.setJissiNo(vo.getKngk1());

        return result;
    }

}
