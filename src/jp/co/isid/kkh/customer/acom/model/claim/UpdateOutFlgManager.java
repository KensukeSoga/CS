package jp.co.isid.kkh.customer.acom.model.claim;

import jp.co.isid.kkh.model.base.KKHException;

public class UpdateOutFlgManager {

    /** �V���O���g���C���X�^���X */
    private static UpdateOutFlgManager _manager = new UpdateOutFlgManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private UpdateOutFlgManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static UpdateOutFlgManager getInstance() {
        return _manager;
    }

    /**
     * ���M�t���O�̍X�V���s���܂��B
     *
     * @return UpdateOutFlgResult ���M�t���O�X�V����
     * @throws KKHException
     *             �������ɃG���[�����������ꍇ
     */
    public UpdateOutFlgResult updateThb2KmeiForOutFlg(UpdateOutFlgVO vo)
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
        if (vo.getJyutNo() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (vo.getJyMeiNo() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (vo.getUrMeiNo() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (vo.getRenban() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        // �X�V���ʕێ��p
        UpdateOutFlgResult result = new UpdateOutFlgResult();

        // ******************************************************
        // ���M�t���O�X�V
        // ******************************************************
        UpdateOutFlgDAO dao = UpdateOutFlgDAOFactory.createUpdateOutFlgDAO();

        int count = 0;
        for (int i = 0; i < vo.getJyutNo().length; i++) {
            count += dao.updateThb2KmeiForOutFlg(vo, i);
        }

        result.setCount(count);
        return result;
    }

}
