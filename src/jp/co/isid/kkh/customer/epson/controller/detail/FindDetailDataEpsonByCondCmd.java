package jp.co.isid.kkh.customer.epson.controller.detail;

import jp.co.isid.kkh.customer.epson.model.detail.DetailEpsonManager;
import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonCondition;
import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �ėp�}�X�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/5 IP.Shimizu)<BR>
 * </P>
 * @author
 */
public class FindDetailDataEpsonByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private DetailDataEpsonCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        DetailEpsonManager manager = DetailEpsonManager.getInstance();
        DetailDataEpsonResult result = manager.findDetailDataEpsonByCond(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition FindDetailDataByCond ��������
     */
    public void setDetailDataEpsonCondition(DetailDataEpsonCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return DetailDataResult ������������
     */
    public DetailDataEpsonResult getDetailDataEpsonResult() {
        return (DetailDataEpsonResult) super.getResult().get(RESULT_KEY);
    }

}
