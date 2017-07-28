package jp.co.isid.kkh.customer.lion.controller.detail;

import jp.co.isid.kkh.customer.lion.model.detail.UpdateSubjectManager;
import jp.co.isid.kkh.customer.lion.model.detail.UpdateSubjectResult;
import jp.co.isid.kkh.customer.lion.model.detail.UpdateSubjectVO;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�����ύX�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/9 Fourm A.naito)<BR>
 * </P>
 *
 * @author Fourm A.naito
 */
public class UpdateSubjectCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private UpdateSubjectVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        UpdateSubjectManager manager = UpdateSubjectManager.getInstance();

        // �����ύX�f�[�^�̓o�^
        manager.updateJissiData(_vo);
        // ����I��
        getResult().set(RESULT_KEY, new UpdateSubjectResult());
    }

    /**
     * �v�����f�[�^�o�^VO��ݒ肵�܂��B
     *
     * @param vo DetailUpdateDataVO �v�����f�[�^�o�^VO
     */
    public void setUpdateSubjectVO(UpdateSubjectVO vo) {
        _vo = vo;
    }

    /**
     * �o�^��̃v�����f�[�^��Ԃ��܂��B
     *
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public UpdateSubjectResult getUpdateSubjectResult() {
        return (UpdateSubjectResult) super.getResult().get(RESULT_KEY);
    }

}
