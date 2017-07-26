package jp.co.isid.kkh.customer.lion.controller.detail;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotManager;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���C�I��TVSpot�f�[�^�擾�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/05 JSE H.Sasaki)<BR>
 * </P>
 *
 * @author
 */
public class FindLionTVSpotByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindLionTVSpotCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FindLionTVSpotManager manager = FindLionTVSpotManager.getInstance();
        FindLionTVSpotResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            CommonCodeMasterSearchCondition ��������
     */
    public void setFindLionTVSpotCondition(FindLionTVSpotCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return ReportTohResult ������������
     */
    public FindLionTVSpotResult getFindLionTVSpotResult() {
        return (FindLionTVSpotResult) super.getResult().get(RESULT_KEY);
    }
}
