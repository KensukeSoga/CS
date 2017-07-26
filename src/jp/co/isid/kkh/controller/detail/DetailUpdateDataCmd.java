package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.DetailUpdateDataResult;
import jp.co.isid.kkh.model.detail.DetailUpdateDataVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�\���f�[�^�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class DetailUpdateDataCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private DetailUpdateDataVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** execute�Ŏ��s���鏈�����[�h() */
    public enum ExecMode{UPD_DISP,};
    public ExecMode _execSqlMode = ExecMode.UPD_DISP;

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        if (_execSqlMode.equals(ExecMode.UPD_DISP)){
            // �}�X�^�f�[�^�̓o�^
            DetailUpdateDataResult result = manager.updateDisplayData(_vo);
            // ����I��
            getResult().set(RESULT_KEY, result);
        }

//        throw new KKHException("");
    }

    /**
     * �v�����f�[�^�o�^VO��ݒ肵�܂��B
     *
     * @param vo DetailUpdateDataVO �v�����f�[�^�o�^VO
     */
    public void setDetailUpdateDataVO(DetailUpdateDataVO vo) {
        _vo = vo;
    }

    /**
     * �o�^��̃v�����f�[�^��Ԃ��܂��B
     *
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public DetailUpdateDataResult getUpdateDisplayDataResult() {
        return (DetailUpdateDataResult) super.getResult().get(RESULT_KEY);
    }

}
