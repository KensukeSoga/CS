package jp.co.isid.kkh.customer.ash.controller.detail;

import jp.co.isid.kkh.customer.ash.model.detail.DetailAshManager;
import jp.co.isid.kkh.customer.ash.model.detail.GetFDSeqCondition;
import jp.co.isid.kkh.customer.ash.model.detail.GetFDSeqResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �ėp�}�X�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class GetFDSeqCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private GetFDSeqCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        DetailAshManager manager = DetailAshManager.getInstance();
        GetFDSeqResult result = manager.getFDSeq(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition FindDetailDataByCond ��������
     */
    public void setGetFDSeqCondition(GetFDSeqCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return DetailDataResult ������������
     */
    public GetFDSeqResult getGetFDSeqResult() {
        return (GetFDSeqResult) super.getResult().get(RESULT_KEY);
    }

}
