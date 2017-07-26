package jp.co.isid.kkh.customer.tkd.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.tkd.model.detail.FindThb2KmeiBycondManager;
import jp.co.isid.kkh.customer.tkd.model.detail.FindThb2KmeiBycondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.FindThb2KmeiBycondVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�\���f�[�^�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class FindThb2KmeiBycondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private FindThb2KmeiBycondVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        FindThb2KmeiBycondManager manager = FindThb2KmeiBycondManager.getInstance();
        FindThb2KmeiBycondResult result = new FindThb2KmeiBycondResult();

        //�Ɩ��敪���N���G�[�e�B�u�ȊO����������
        if(_vo.getCreativeFlg().equals("0")){
            result = manager.findThb2Kmeidata(_vo);
        }
        else{
            result = manager.findThb2KmeidataCreative(_vo);
        }

        //FindThb2KmeiBycondResult result = manager.findThb2Kmeidata(_vo);
        // ����I��
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * �v�����f�[�^�o�^VO��ݒ肵�܂��B
     *
     * @param vo DetailUpdateDataVO �v�����f�[�^�o�^VO
     */
    public void setFindThb2KmeiBycondVO(FindThb2KmeiBycondVO vo) {
        _vo = vo;
    }

    /**
     * �o�^��̃v�����f�[�^��Ԃ��܂��B
     *
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public FindThb2KmeiBycondResult getFindThb2KmeiBycondResult() {
        return (FindThb2KmeiBycondResult) super.getResult().get(RESULT_KEY);
    }

}
