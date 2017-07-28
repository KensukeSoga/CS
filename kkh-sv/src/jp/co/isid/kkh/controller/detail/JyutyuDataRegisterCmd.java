package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.JyutyuDataRegisterResult;
import jp.co.isid.kkh.model.detail.JyutyuDataRegisterVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ד��́|�V�K�o�^
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/08 JSE K.Fukuda)<BR>
 * </P>
 *
 * @author
 */
public class JyutyuDataRegisterCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �V�K�o�^VO */
    private JyutyuDataRegisterVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �V�K�o�^���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        // �}�X�^�f�[�^�̓o�^
        JyutyuDataRegisterResult result = manager.registerJyutyuData(_vo);
        // ����I��
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * �����N���ύXVO��ݒ肵�܂��B
     *
     * @param vo JyutyuDataRegisterVO �����N���ύXVO
     */
    public void setJyutyuDataRegisterVO(JyutyuDataRegisterVO vo) {
        _vo = vo;
    }

    /**
     * �����N���ύX�������ʂ�Ԃ��܂��B
     *
     * @return JyutyuDataRegisterVOResult �����N���ύX��������
     */
    public JyutyuDataRegisterResult getJyutyuDataRegisterResult() {
        return (JyutyuDataRegisterResult) super.getResult().get(RESULT_KEY);
    }

}
