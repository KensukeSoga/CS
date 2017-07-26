package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.model.base.KKHException;

/**
 *
 * <P>
 * �V�[�N�G���XNo�o�^Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class UpdateSeqNoManager {

    /** �V���O���g���C���X�^���X */
    private static UpdateSeqNoManager _manager = new UpdateSeqNoManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private UpdateSeqNoManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static UpdateSeqNoManager getInstance() {
        return _manager;
    }

    /**
     * �V�[�N�G���XNo�ő�l���擾���܂��B
     *
     * @return MaxSeqNoResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void updateDisplayData(UpdateSeqNoCondition cond) throws KKHException {

        // �p�����[�^�̕K�{�`�F�b�N
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

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        UpdateSeqNoDAO updateSeqNoDAO = UpdateSeqNoDAOFactory.createUpdateSeqNoDAO();

        updateSeqNoDAO.setConditionByCondition(cond);

        for (ReportKmnListVO reportKmnListVO : cond.getRepKmnList()) {
            updateSeqNoDAO.updateSeqNoByCondition(reportKmnListVO);
        }
    }

}
