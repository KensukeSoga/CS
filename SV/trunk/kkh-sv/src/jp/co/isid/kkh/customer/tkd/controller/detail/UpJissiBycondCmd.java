package jp.co.isid.kkh.customer.tkd.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.tkd.model.detail.UpJissiBycondManager;
import jp.co.isid.kkh.customer.tkd.model.detail.UpJissiBycondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.UpJissiBycondVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�\���f�[�^�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class UpJissiBycondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private UpJissiBycondVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        UpJissiBycondManager manager = UpJissiBycondManager.getInstance();

            // ���{NO��UP/DOWN�̓o�^
            manager.updateJissiData(_vo);
            // ����I��
            getResult().set(RESULT_KEY, new UpJissiBycondResult());

//        throw new KKHException("");
    }

    /**
     * �v�����f�[�^�o�^VO��ݒ肵�܂��B
     *
     * @param vo DetailUpdateDataVO �v�����f�[�^�o�^VO
     */
    public void setUpJissiBycondVO(UpJissiBycondVO vo) {
        _vo = vo;
    }

    /**
     * �o�^��̃v�����f�[�^��Ԃ��܂��B
     *
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public UpJissiBycondResult getUpJissiBycondResult() {
        return (UpJissiBycondResult) super.getResult().get(RESULT_KEY);
    }

}
