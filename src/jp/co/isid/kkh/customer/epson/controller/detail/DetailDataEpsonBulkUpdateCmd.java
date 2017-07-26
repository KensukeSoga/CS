package jp.co.isid.kkh.customer.epson.controller.detail;

import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonBulkUpdateResult;
import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonBulkUpdateVO;
import jp.co.isid.kkh.customer.epson.model.detail.DetailEpsonManager;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�\���f�[�^�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/13)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class DetailDataEpsonBulkUpdateCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �L����ו\���f�[�^�X�V�����pVO */
    private DetailDataEpsonBulkUpdateVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �L����ו\���f�[�^�X�V���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        DetailEpsonManager manager = DetailEpsonManager.getInstance();

        // �L����׃f�[�^�̓o�^
        DetailDataEpsonBulkUpdateResult result = manager.bulkUpdateDetailDataEpson(_vo);
        // ����I��
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * �L����׃f�[�^�X�V(�ꊇ)VO��ݒ肵�܂��B
     *
     * @param vo DetailDataBulkUpdateVO �L����׃f�[�^�X�V(�ꊇ)VO
     */
    public void setDetailDataEpsonBulkUpdateVO(DetailDataEpsonBulkUpdateVO vo) {
        _vo = vo;
    }

    /**
     * �o�^�㌋�ʂ�Ԃ��܂��B
     *
     * @return UpdateDisplayDataResult �o�^��̃v�����f�[�^
     */
    public DetailDataEpsonBulkUpdateResult getDetailDataEpsonBulkUpdateResult() {
        return (DetailDataEpsonBulkUpdateResult) super.getResult().get(RESULT_KEY);
    }

}
