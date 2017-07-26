package jp.co.isid.kkh.customer.ash.controller.detail;

import jp.co.isid.kkh.customer.ash.model.detail.DetailAshManager;
import jp.co.isid.kkh.customer.ash.model.detail.DetailDataAshMergeResult;
import jp.co.isid.kkh.customer.ash.model.detail.DetailDataAshMergeVO;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�󒍓���(���ד���)
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class DetailDataAshMergeCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �󒍓���(���ד���)�����pVO */
    private DetailDataAshMergeVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �󒍓���(���ד���)���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        DetailAshManager manager = DetailAshManager.getInstance();

        // �󒍓���(���ד���)
        DetailDataAshMergeResult result = manager.mergeDataForAsh(_vo);

        // ����I��
        getResult().set(RESULT_KEY, result);
    }

    /**
     * �󒍓���(���ד���)VO��ݒ肵�܂��B
     *
     * @param vo DetailDataAshMergeVO �󒍓���(���ד���)VO
     */
    public void setDetailDataAshMergeVO(DetailDataAshMergeVO vo) {
        _vo = vo;
    }

    /**
     * �󒍓���(���ד���)�������ʂ�Ԃ��܂��B
     *
     * @return DetailDataAshMergeResult �󒍓���(���ד���)��������
     */
    public DetailDataAshMergeResult getDetailDataAshMergeResult() {
        return (DetailDataAshMergeResult) super.getResult().get(RESULT_KEY);
    }

}
