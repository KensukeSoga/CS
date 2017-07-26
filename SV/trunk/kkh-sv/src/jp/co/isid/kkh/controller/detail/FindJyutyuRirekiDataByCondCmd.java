package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.Thb8DownRCondition;
import jp.co.isid.kkh.model.detail.Thb8DownRResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �󒍃_�E�����[�h���������R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class FindJyutyuRirekiDataByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private Thb8DownRCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        DetailManager manager = DetailManager.getInstance();
        Thb8DownRResult result = manager.findJyutyuRirekiDataByCond(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition Thb8DownRCondition ��������
     */
    public void setThb8DownRCondition(Thb8DownRCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return Thb8DownRResult ������������
     */
    public Thb8DownRResult getThb8DownRResult() {
        return (Thb8DownRResult) super.getResult().get(RESULT_KEY);
    }

}
