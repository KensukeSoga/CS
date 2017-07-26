package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.JyutNoTouInsManager;
import jp.co.isid.kkh.model.detail.JyutNoTouInsResult;
import jp.co.isid.kkh.model.detail.JyutNoTouInsVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|��No����
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/28 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class JyutNoTouInsCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private JyutNoTouInsVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        JyutNoTouInsManager manager = JyutNoTouInsManager.getInstance();

        // ���{NO��UP/DOWN�̓o�^
        manager.jyutNoTouInsDateData(_vo);
        // ����I��
        getResult().set(RESULT_KEY, new JyutNoTouInsResult());

//        throw new KKHException("");
    }

    /**
     * �v�����f�[�^�o�^VO��ݒ肵�܂��B
     *
     * @param vo DetailUpdateDataVO �v�����f�[�^�o�^VO
     */
    public void setJyutNoTouUpdateVO(JyutNoTouInsVO vo) {
        _vo = vo;
    }

    /**
     * �o�^��̃v�����f�[�^��Ԃ��܂��B
     *
     * @return JyutNoTouInsResult �o�^��̃v�����f�[�^
     */
    public JyutNoTouInsResult getJyutNoTouInsdateResult() {
        return (JyutNoTouInsResult) super.getResult().get(RESULT_KEY);
    }

}
