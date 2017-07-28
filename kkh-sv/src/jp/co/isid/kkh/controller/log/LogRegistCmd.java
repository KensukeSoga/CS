package jp.co.isid.kkh.controller.log;

import jp.co.isid.kkh.model.log.LogManager;
import jp.co.isid.kkh.model.log.LogResult;
import jp.co.isid.kkh.model.log.LogVO;

import jp.co.isid.nj.controller.command.Command;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>�ėp���O�̓o�^�R�}���h</P>
 *
 * <P>
 * �ėp���O�@�o�^�R�}���h�N���X�B
 * </P>
 *
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬�i2011/11/14 IP H.Shimizu>
 * </P>
 *
 * @author  IP H.Shimizu
 * @since  14 November 2011
 */
public class LogRegistCmd extends Command  {

    private static final long serialVersionUID = 1L;

    /** �o�^���ʃL�[ */
    private static final String RESULT_KEY = "ESULT_KEY";

    /** �o�^���� */
    private LogVO _volist;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     * ��������̃R���X�g���N�^���`�����̂ŁA
     * �����Ȃ��̃R���X�g���N�^�������I�ɒ�`���Ȃ���΂Ȃ�Ȃ��Ȃ�܂����B
     */
    public LogRegistCmd() {
    }

    /**
     * ���s
     * @throws UserException
     */
    public void execute() throws KKHException {
        LogManager manager = LogManager.getInstance();
        manager.registLog(_volist);
    }

    /**
     * �o�^����ݒ肵�܂��B
     *
     * @param volist RegistLogVO �o�^���
     */
    public void setRegistLogVO(LogVO volist) {
        _volist = volist;
    }

    /**
     * ���O�o�^���ʂ�Ԃ��܂��B
     *
     * @return LogResult ������������
     */
    public LogResult getLogRegisterResult() {
        return (LogResult) super.getResult().get(RESULT_KEY);
    }

}
