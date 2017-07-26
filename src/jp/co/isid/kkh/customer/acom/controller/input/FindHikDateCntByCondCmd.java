package jp.co.isid.kkh.customer.acom.controller.input;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.input.HikManager;
import jp.co.isid.kkh.customer.acom.model.input.HikSearchDateCntVOList;
import jp.co.isid.kkh.customer.acom.model.input.HikSearchResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �����f�[�^�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/01 HLC J.Mrobayashi)<BR>
 * </P>
 * @author HLC J.Mrobayashi
 */
public class FindHikDateCntByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** ���t�f�[�^�����pVO */
    private HikSearchDateCntVOList _volist;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        HikManager manager = HikManager.getInstance();
        HikSearchResult result = manager.findDateCntByVoList(_volist);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ���t�f�[�^�����pVO��ݒ肵�܂��B
     * @param volist HikSearchDateCntVOList ���t�f�[�^�����pVO
     */
    public void setHikSearchDateCntVO(HikSearchDateCntVOList volist) {
        _volist = volist;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     * @return HikSearchResult ������������
     */
    public HikSearchResult getHikSearchResult() {
        return (HikSearchResult) super.getResult().get(RESULT_KEY);
    }

}
