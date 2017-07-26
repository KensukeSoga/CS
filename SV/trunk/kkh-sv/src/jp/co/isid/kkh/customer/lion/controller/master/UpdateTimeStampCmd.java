package jp.co.isid.kkh.customer.lion.controller.master;

import jp.co.isid.kkh.customer.lion.model.master.UpdateTimeStampManager;
import jp.co.isid.kkh.customer.lion.model.master.UpdateTimeStampResult;
import jp.co.isid.kkh.customer.lion.model.master.UpdateTimeStampVO;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�\���f�[�^�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/9 Fourm A.naito)<BR>
 * </P>
 *
 * @author Fourm A.naito
 */
public class UpdateTimeStampCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private UpdateTimeStampVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        UpdateTimeStampManager manager = UpdateTimeStampManager.getInstance();

        // ���{NO��UP/DOWN�̓o�^
        manager.updateJissiData(_vo);
        // ����I��
        getResult().set(RESULT_KEY, new UpdateTimeStampResult());

//        throw new KKHException("");
    }

    /**
     * �v�����f�[�^�o�^VO��ݒ肵�܂��B
     *
     * @param vo DetailUpdateDataVO �v�����f�[�^�o�^VO
     */
    public void setUpdateTimeStampVO(UpdateTimeStampVO vo) {
        _vo = vo;
    }

    /**
     * �o�^��̃v�����f�[�^��Ԃ��܂��B
     *
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public UpdateTimeStampResult getUpdateTimeStampResult() {
        return (UpdateTimeStampResult) super.getResult().get(RESULT_KEY);
    }

}
