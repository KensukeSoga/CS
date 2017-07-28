package jp.co.isid.kkh.customer.skyp.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class UpdateOrderManager {

    /** �V���O���g���C���X�^���X */
    private static UpdateOrderManager _manager = new UpdateOrderManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private UpdateOrderManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static UpdateOrderManager getInstance() {
        return _manager;
    }

    /**
     * ���я��̍X�V���s���܂��B
     *
     * @return UpdateOrderResult ���я��X�V����
     * @throws KKHException
     *             �������ɃG���[�����������ꍇ
     */
    public UpdateOrderResult updateThb2KmeiForOrder(UpdateOrderVO vo)
            throws KKHException {

        // �p�����[�^�̕K�{�`�F�b�N
        if (vo.getEgCd() == null || vo.getEgCd().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (vo.getTksKgyCd() == null || vo.getTksKgyCd().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (vo.getTksBmnSeqNo() == null || vo.getTksBmnSeqNo().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (vo.getTksTntSeqNo() == null || vo.getTksTntSeqNo().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (vo.getYymm() == null || vo.getYymm().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (vo.getOrder() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (vo.getBaitaiNm() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (vo.getBaitaiKbn() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        // �X�V���ʕێ��p
        UpdateOrderResult result = new UpdateOrderResult();

        // ******************************************************
        // ���я����X�V
        // ******************************************************
        UpdateOrderDAO dao = UpdateOrderDAOFactory.createUpdateOrderDAO();

        int count = 0;
        for (int i = 0; i < vo.getOrder().length; i++) {
        	//���׃e�[�u�����X�V
            count += dao.updateThb2KmeiForOrder(vo, i);
        }

        //�X�V�������Z�b�g
        result.setCount(count);

        //�󒍃e�[�u�����X�V
        dao.updateThb1DownForOrder(vo);

        return result;
    }

}
