package jp.co.isid.kkh.controller.common;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.CommonCondition;
import jp.co.isid.kkh.model.common.CommonManager;
import jp.co.isid.kkh.model.common.CommonResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �ėp�}�X�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class FindCommonByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private CommonCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        CommonManager manager = CommonManager.getInstance();
        CommonResult result = manager.findCommonByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindCommonCondition(CommonCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return MasterResult ������������
     */
    public CommonResult getCommonResult() {
        return (CommonResult) super.getResult().get(RESULT_KEY);
    }

}
