package jp.co.isid.kkh.customer.acom.controller.input;

import jp.co.isid.kkh.customer.acom.model.input.HikManager;
import jp.co.isid.kkh.customer.acom.model.input.HikRegistVOList;
import jp.co.isid.kkh.customer.acom.model.input.HikSearchResult;
import jp.co.isid.nj.controller.command.Command;
import jp.co.isid.nj.controller.command.transaction.ManualTransaction;
import jp.co.isid.nj.exp.UserException;

/**
 * <P>�������(��r�p)�̌����R�}���h</P>
 *
 * <P>
 * �������XSD�S�ʁ@�����R�}���h�N���X�B
 * </P>
 *
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬�i2011/11/28 HLC J.Morobayashi>
 * </P>
 *
 * @author  HLC J.Morobayashia
 * @since  14 November 2011
 */
public class FindHikCheckDataByCondCmd extends Command implements ManualTransaction {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "ESULT_KEY";

    /** �������� */
    private HikRegistVOList _volist;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     * ��������̃R���X�g���N�^���`�����̂ŁA
     * �����Ȃ��̃R���X�g���N�^�������I�ɒ�`���Ȃ���΂Ȃ�Ȃ��Ȃ�܂����B
     */
    public FindHikCheckDataByCondCmd() {
    }

    /**
     * ���s
     * @throws UserException
     */
    public void execute() throws UserException {
        HikManager manager = HikManager.getInstance();
        HikSearchResult result = manager.findCheckDataByVoList(_volist);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ��������ݒ肵�܂��B
     * @param volist HikRegistVOList �������
     */
    public void setHikRegistVOList(HikRegistVOList volist) {
        _volist = volist;
    }

    /**
     * ������̔����f�[�^��Ԃ��܂��B
     * @return HikSearchResult ������������
     */
    public HikSearchResult getHikSearchResult() {
        return (HikSearchResult) super.getResult().get(RESULT_KEY);
    }

}
