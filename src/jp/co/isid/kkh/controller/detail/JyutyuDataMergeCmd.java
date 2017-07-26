package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeResult;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeVO;
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
public class JyutyuDataMergeCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �󒍓��������pVO */
    private JyutyuDataMergeVO _vo;

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
        JyutyuDataMergeResult result = manager.mergeJyutyuData(_vo);
        // ����I��
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * �󒍓���VO��ݒ肵�܂��B
     *
     * @param vo JyutyuDataMergeVO �󒍓���VO
     */
    public void setJyutyuDataMergeVO(JyutyuDataMergeVO vo) {
        _vo = vo;
    }

    /**
     * �󒍓����������ʂ�Ԃ��܂��B
     *
     * @return JyutyuDataMergeResult �󒍓�����������
     */
    public JyutyuDataMergeResult getJyutyuDataMergeResult() {
        return (JyutyuDataMergeResult) super.getResult().get(RESULT_KEY);
    }

}
