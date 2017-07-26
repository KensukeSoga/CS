package jp.co.isid.kkh.customer.acom.controller.input;

import jp.co.isid.kkh.customer.acom.model.input.HikManager;
import jp.co.isid.kkh.customer.acom.model.input.HikRegistResult;
import jp.co.isid.kkh.customer.acom.model.input.HikRegistVOList;
import jp.co.isid.nj.controller.command.Command;
import jp.co.isid.nj.exp.UserException;


/**
 * <P>�������S�ʂ̓o�^�R�}���h</P>
 *
 * <P>
 * �������XSD�S�ʁ@�o�^�R�}���h�N���X�B
 * </P>
 *
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬�i2011/12/09 HLC J.Morobayashi>
 * </P>
 *
 * @author  HLC J.Morobayashia
 * @since  09 December 2011
 */
public class HikRegistCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �o�^���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �����f�[�^VO���X�g */
    private HikRegistVOList _volist;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     * ��������̃R���X�g���N�^���`�����̂ŁA
     * �����Ȃ��̃R���X�g���N�^�������I�ɒ�`���Ȃ���΂Ȃ�Ȃ��Ȃ�܂����B
     */
    public HikRegistCmd() {
    }

    /**
     * ���s
     * @throws UserException
     */
    public void execute() throws UserException {
        HikManager manager = HikManager.getInstance();
        manager.registHik(_volist);
        getResult().set(RESULT_KEY , new HikRegistResult());
    }

    /**
     * �����f�[�^VO���X�g��ݒ肵�܂��B
     * @param volist HikRegistVOList �����f�[�^VO���X�g
     */
    public void setHikRegistVO(HikRegistVOList volist) {
        _volist = volist;
    }

    /**
     * �o�^��̔����f�[�^��Ԃ��܂��B
     * @return HikRegistResult ������������
     */
    public HikRegistResult getHikRegistResult() {
        return (HikRegistResult) super.getResult().get(RESULT_KEY );
    }

}
