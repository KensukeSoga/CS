package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailDataBulkUpdateResult;
import jp.co.isid.kkh.model.detail.DetailDataBulkUpdateVO;
import jp.co.isid.kkh.model.detail.DetailManager;
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
public class DetailDataBulkUpdateCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private DetailDataBulkUpdateVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        // �L����׃f�[�^�̓o�^
        DetailDataBulkUpdateResult result = manager.bulkUpdateDetailData(_vo);
        // ����I��
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * �L����׃f�[�^�X�V(�ꊇ)VO��ݒ肵�܂��B
     *
     * @param vo DetailDataBulkUpdateVO �L����׃f�[�^�X�V(�ꊇ)VO
     */
    public void setDetailDataBulkUpdateVO(DetailDataBulkUpdateVO vo) {
        _vo = vo;
    }

    /**
     * �o�^�㌋�ʂ�Ԃ��܂��B
     *
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public DetailDataBulkUpdateResult getDetailDataBulkUpdateResult() {
        return (DetailDataBulkUpdateResult) super.getResult().get(RESULT_KEY);
    }

}
