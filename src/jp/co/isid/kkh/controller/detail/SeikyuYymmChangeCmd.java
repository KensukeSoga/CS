package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.SeikyuYymmChangeResult;
import jp.co.isid.kkh.model.detail.SeikyuYymmChangeVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L����ׁ|�����N���ύX
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/05 JSE K.Fukuda)<BR>
 * </P>
 *
 * @author
 */
public class SeikyuYymmChangeCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �����N���ύX�����pVO */
    private SeikyuYymmChangeVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �����N���ύX���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        // �}�X�^�f�[�^�̓o�^
        SeikyuYymmChangeResult result = manager.changeSeikyuYymm(_vo);
        // ����I��
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * �����N���ύXVO��ݒ肵�܂��B
     *
     * @param vo SeikyuYymmChangeVO �����N���ύXVO
     */
    public void setSeikyuYymmChangeVO(SeikyuYymmChangeVO vo) {
        _vo = vo;
    }

    /**
     * �����N���ύX�������ʂ�Ԃ��܂��B
     *
     * @return SeikyuYymmChangeResult �����N���ύX��������
     */
    public SeikyuYymmChangeResult getSeikyuYymmChangeResult() {
        return (SeikyuYymmChangeResult) super.getResult().get(RESULT_KEY);
    }

}
