package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeCancelResult;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeCancelVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�󒍓���
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/05 JSE K.Fukuda)<BR>
 * </P>
 *
 * @author
 */
public class JyutyuDataMergeCancelCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �󒍓��������pVO */
    private JyutyuDataMergeCancelVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �󒍓������������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        // �}�X�^�f�[�^�̓o�^
        JyutyuDataMergeCancelResult result = manager.mergeCancelJyutyuData(_vo);
        // ����I��
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * �󒍓���VO��ݒ肵�܂��B
     *
     * @param vo JyutyuDataMergeCancelVO �󒍓���VO
     */
    public void setJyutyuDataMergeCancelVO(JyutyuDataMergeCancelVO vo) {
        _vo = vo;
    }

    /**
     * �󒍓����������ʂ�Ԃ��܂��B
     *
     * @return JyutyuDataMergeCancelResult �󒍓�����������
     */
    public JyutyuDataMergeCancelResult getJyutyuDataMergeCancelResult() {
        return (JyutyuDataMergeCancelResult) super.getResult().get(RESULT_KEY);
    }

}
