package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.JyutyuDataDeleteResult;
import jp.co.isid.kkh.model.detail.JyutyuDataDeleteVO;
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
public class JyutyuDataDeleteCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �󒍍폜�����pVO */
    private JyutyuDataDeleteVO _vo;

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

        // �󒍃_�E�����[�h�f�[�^����ѕR�Â��Ă���L����׃f�[�^�폜
        manager.deleteJyutyuData(_vo);
        // ����I��
        getResult().set(RESULT_KEY, new JyutyuDataDeleteResult());

//        throw new KKHException("");
    }

    /**
     * �v�����f�[�^�o�^VO��ݒ肵�܂��B
     *
     * @param vo DetailUpdateDataVO �v�����f�[�^�o�^VO
     */
    public void setJyutyuDataDeleteVO(JyutyuDataDeleteVO vo) {
        _vo = vo;
    }

    /**
     * �o�^��̃v�����f�[�^��Ԃ��܂��B
     *
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public JyutyuDataDeleteResult getJyutyuDataDeleteResult() {
        return (JyutyuDataDeleteResult) super.getResult().get(RESULT_KEY);
    }

}
