package jp.co.isid.kkh.customer.acom.controller.claim;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.claim.UpdateOutFlgManager;
import jp.co.isid.kkh.customer.acom.model.claim.UpdateOutFlgResult;
import jp.co.isid.kkh.customer.acom.model.claim.UpdateOutFlgVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���M�t���O�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/20 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOutFlgCmd extends Command {

    /** */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private UpdateOutFlgVO _vo;

    /**
     * ���M�t���O�X�V���������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        UpdateOutFlgManager manager = UpdateOutFlgManager.getInstance();
        UpdateOutFlgResult result = manager.updateThb2KmeiForOutFlg(_vo);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ���M�t���O�X�V���VO��ݒ肵�܂��B
     *
     * @param vo
     *            UpdateOutFlgVO ��������
     */
    public void setUpdateOutFlgVO(UpdateOutFlgVO vo) {
        _vo = vo;
    }

    /**
     * ���M�t���O�X�V���ʂ�Ԃ��܂��B
     *
     * @return UpdateOutFlgResult ���M�t���O�X�V����
     */
    public UpdateOutFlgResult getUpdateOutFlgResult() {
        return (UpdateOutFlgResult) super.getResult().get(RESULT_KEY);
    }
}
