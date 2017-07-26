package jp.co.isid.kkh.customer.epson.controller.detail;

import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonManager;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataCondition;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ��������f�[�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/04/25 JSE.Yuguchi)<BR>
 * </P>
 * @author
 */
public class FindSeikyuDataEpsonByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private SeikyuDataCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        SeikyuDataEpsonManager manager = SeikyuDataEpsonManager.getInstance();
        SeikyuDataEpsonResult result = manager.findSeikyuDataEpsonByCond(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition FindSeikyuDataByCond ��������
     */
    public void setSeikyuDataCondition(SeikyuDataCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return SeikyuDataEpsonResult ������������
     */
    public SeikyuDataEpsonResult getSeikyuDataEpsonResult() {
        return (SeikyuDataEpsonResult) super.getResult().get(RESULT_KEY);
    }

}
