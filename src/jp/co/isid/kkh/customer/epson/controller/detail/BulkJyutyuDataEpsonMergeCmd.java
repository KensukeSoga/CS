package jp.co.isid.kkh.customer.epson.controller.detail;

import java.util.List;

import jp.co.isid.kkh.customer.epson.model.detail.BulkJyutyuDataEpsonMergeResult;
import jp.co.isid.kkh.customer.epson.model.detail.BulkJyutyuDataEpsonMergeVO;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeResult;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �ꊇ�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/24 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class BulkJyutyuDataEpsonMergeCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �ꊇ���������pVO */
    private BulkJyutyuDataEpsonMergeVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �ꊇ�������������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        // ���̓`�F�b�N
        checkInput();

        DetailManager manager = DetailManager.getInstance();
        List<JyutyuDataMergeVO> jyutyuDataMergeVOList = _vo.getJyutyuDataMergeVOList();
        // �󒍓����f�[�^���X�g�̌������A�J��Ԃ�
        for (JyutyuDataMergeVO vo : jyutyuDataMergeVOList) {
            // �󒍓���
            JyutyuDataMergeResult result = manager.mergeJyutyuData(vo);
        }

        getResult().set(RESULT_KEY, new BulkJyutyuDataEpsonMergeResult());
    }

    /**
     * �ꊇ����VO�̐ݒ�
     *
     * @param vo �ꊇ����VO
     */
    public void setBulkJyutyuDataEpsonMergeVO(BulkJyutyuDataEpsonMergeVO vo) {
        _vo = vo;
    }

    /**
     * ���s���ʂ�Ԃ��܂��B
     *
     * @return ���s����
     */
    public BulkJyutyuDataEpsonMergeResult getBulkJyutyuDataEpsonMergeResult() {
        return (BulkJyutyuDataEpsonMergeResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * �p�����[�^���̓`�F�b�N
     *
     * @throws KKHException �p�����[�^�w��G���[�̏ꍇ
     */
    private void checkInput() throws KKHException {

        if (_vo.getJyutyuDataMergeVOList() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
    }

}
