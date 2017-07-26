package jp.co.isid.kkh.customer.acom.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.detail.FindHatyuNumByCondVO;
import jp.co.isid.kkh.customer.acom.model.detail.FindHatyuNumBycondManager;
import jp.co.isid.kkh.customer.acom.model.detail.FindHatyuNumBycondResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�\���f�[�^�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/22 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class FindHatyuNumBycondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private FindHatyuNumByCondVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        FindHatyuNumBycondManager manager = FindHatyuNumBycondManager.getInstance();

        //�����J�n
        FindHatyuNumBycondResult result = manager.findThb2Kmeidata(_vo);
        // ����I��
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * �v�����f�[�^�o�^VO��ݒ肵�܂��B
     *
     * @param vo DetailUpdateDataVO �v�����f�[�^�o�^VO
     */
    public void setFindHatyuNumBycondVO(FindHatyuNumByCondVO vo) {
        _vo = vo;
    }

    /**
     * �o�^��̃v�����f�[�^��Ԃ��܂��B
     *
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public FindHatyuNumBycondResult getFindHatyuNumBycondResult() {
        return (FindHatyuNumBycondResult) super.getResult().get(RESULT_KEY);
    }

}
