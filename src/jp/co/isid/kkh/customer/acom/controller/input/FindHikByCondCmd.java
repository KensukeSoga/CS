package jp.co.isid.kkh.customer.acom.controller.input;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.input.HikManager;
import jp.co.isid.kkh.customer.acom.model.input.HikCommonCondition;
import jp.co.isid.kkh.customer.acom.model.input.HikSearchResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �����f�[�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/08 HLC J.Mrobayashi)<BR>
 * </P>
 * @author HLC J.Mrobayashi
 */
public class FindHikByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private HikCommonCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        HikManager manager = HikManager.getInstance();
        HikSearchResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     * @param condition HikCommonCondition ��������
     */
    public void setHikSearchCondition(HikCommonCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     * @return HikSearchResult ������������
     */
    public HikSearchResult getHikSearchResult() {
        return (HikSearchResult) super.getResult().get(RESULT_KEY);
    }

}
