package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.JyutNoTouUpdateManager;
import jp.co.isid.kkh.model.detail.JyutNoTouUpdateResult;
import jp.co.isid.kkh.model.detail.JyutNoTouUpdateVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�\���f�[�^�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class JyutNoTouUpdateCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private JyutNoTouUpdateVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        JyutNoTouUpdateManager manager = JyutNoTouUpdateManager.getInstance();

        // ���{NO��UP/DOWN�̓o�^
        manager.jyutNoTouUpDateData(_vo);
        // ����I��
        getResult().set(RESULT_KEY, new JyutNoTouUpdateResult());

//        throw new KKHException("");
    }

    /**
     * �v�����f�[�^�o�^VO��ݒ肵�܂��B
     *
     * @param vo DetailUpdateDataVO �v�����f�[�^�o�^VO
     */
    public void setJyutNoTouUpdateVO(JyutNoTouUpdateVO vo) {
        _vo = vo;
    }

    /**
     * �o�^��̃v�����f�[�^��Ԃ��܂��B
     *
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public JyutNoTouUpdateResult getJyutNoTouUpdateResult() {
        return (JyutNoTouUpdateResult) super.getResult().get(RESULT_KEY);
    }

}
