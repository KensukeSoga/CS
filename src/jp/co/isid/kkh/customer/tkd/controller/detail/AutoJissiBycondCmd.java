package jp.co.isid.kkh.customer.tkd.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;

import jp.co.isid.kkh.customer.tkd.model.detail.AutoJissiBycondManager;
import jp.co.isid.kkh.customer.tkd.model.detail.AutoJissiBycondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.AutoJissiBycondVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|���{NO����UP/DOWN�i���{No�����t�^�j�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 *
 * @author Fourm H.izawa
 */
public class AutoJissiBycondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** ���{NO����UP/DOWN�i���{No�����t�^�jVO */
    private AutoJissiBycondVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * ���{NO����UP/DOWN�i���{No�����t�^�j���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        AutoJissiBycondManager manager = AutoJissiBycondManager.getInstance();

        // ���{NO��UP/DOWN�i���{No�����t�^�j�̓o�^
        manager.audateJissiData(_vo);
        // ����I��
        getResult().set(RESULT_KEY, new AutoJissiBycondResult());
    }

    /**
     * ���{NO����UP/DOWN�i���{No�����t�^�jVO��ݒ肵�܂��B
     *
     * @param vo AutoJissiBycondVO ���{NO����UP/DOWN�i���{No�����t�^�j
     */
    public void setAutoJissiBycondVO(AutoJissiBycondVO vo) {
        _vo = vo;
    }

    /**
     * ���{NO����UP/DOWN�i���{No�����t�^�j�̌��ʂ�Ԃ��܂��B
     *
     * @return AutoJissiBycondResult ���{NO����UP/DOWN�i���{No�����t�^�j�̌���
     */
    public AutoJissiBycondResult getAutoJissiBycondResult() {
        return (AutoJissiBycondResult) super.getResult().get(RESULT_KEY);
    }

}
