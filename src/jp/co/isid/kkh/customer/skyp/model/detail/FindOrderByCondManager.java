package jp.co.isid.kkh.customer.skyp.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class FindOrderByCondManager {

    /** �V���O���g���C���X�^���X */
    private static FindOrderByCondManager _manager = new FindOrderByCondManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FindOrderByCondManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindOrderByCondManager getInstance() {
        return _manager;
    }

    /**
     * ���я������������܂��B
     *
     * @return FindOrderByCondResult ���я����
     * @throws KKHException
     *             �������ɃG���[�����������ꍇ
     */
    public FindOrderByCondResult findOrderByCondition(FindOrderCondition cond)
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
        FindOrderByCondResult result = new FindOrderByCondResult();

        // ��������
        FindOrderCondition lCond = new FindOrderCondition();

        // ******************************************************
        // ���я������擾
        // ******************************************************
        FindOrderByCondDAO dao = FindOrderByCondDAOFactory.createFindOrderByCondDAO();
        lCond = cond;
        List<FindOrderCondVO> list = dao.findOrderByCondition(lCond);
        result.setOrderList(list);

        return result;
    }

}
