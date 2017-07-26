package jp.co.isid.kkh.customer.ash.controller.detail;

import jp.co.isid.kkh.customer.ash.model.detail.FindKeyKyokuBangumiCdCondition;
import jp.co.isid.kkh.customer.ash.model.detail.FindKeyKyokuBangumiCdManager;
import jp.co.isid.kkh.customer.ash.model.detail.FindKeyKyokuBangumiCdResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �L�[�ǂ̔ԑg�R�[�h��Command
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC ��(Jang)
 */
public class FindKeyKyokuBangumiCdCmd extends Command {
    private static final long serialVersionUID = 1L;

    /** �������� */
    private FindKeyKyokuBangumiCdCondition _condition;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FindKeyKyokuBangumiCdManager manager = FindKeyKyokuBangumiCdManager.getInstance();
        FindKeyKyokuBangumiCdResult result = manager.findKeyKyokuBangumiCd(this._condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     * @param condition FindDetailDataByCond ��������
     */
    public void setFindKeyKyokuBangumiCdCondition(FindKeyKyokuBangumiCdCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     * @return DetailDataResult ������������
     */
    public FindKeyKyokuBangumiCdResult getFindKeyKyokuBangumiCdResultResult() {
        return (FindKeyKyokuBangumiCdResult) super.getResult().get(RESULT_KEY);
    }

}
