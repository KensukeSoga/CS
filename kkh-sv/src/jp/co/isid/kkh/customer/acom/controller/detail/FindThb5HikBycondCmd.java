package jp.co.isid.kkh.customer.acom.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.detail.FindThb5HikBycondManager;
import jp.co.isid.kkh.customer.acom.model.detail.FindThb5HikResult;
import jp.co.isid.kkh.customer.acom.model.detail.Thb5HikVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�\���f�[�^�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/10 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class FindThb5HikBycondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private Thb5HikVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        FindThb5HikBycondManager manager = FindThb5HikBycondManager.getInstance();

        //�����J�n
        FindThb5HikResult result = manager.findthb5Hikdata(_vo);
        // ����I��
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * �v�����f�[�^�o�^VO��ݒ肵�܂��B
     * @param vo DetailUpdateDataVO �v�����f�[�^�o�^VO
     */
    public void setFind8HikBycondVO(Thb5HikVO vo) {
        _vo = vo;
    }

    /**
     * �o�^��̃v�����f�[�^��Ԃ��܂��B
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public FindThb5HikResult getFindThb5HikResult() {
        return (FindThb5HikResult) super.getResult().get(RESULT_KEY);
    }

}
