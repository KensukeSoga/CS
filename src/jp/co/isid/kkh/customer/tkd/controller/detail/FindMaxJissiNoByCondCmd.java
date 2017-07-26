package jp.co.isid.kkh.customer.tkd.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;

import jp.co.isid.kkh.customer.tkd.model.detail.FindMaxJissiNoByCondManager;
import jp.co.isid.kkh.customer.tkd.model.detail.FindMaxJissiNoByCondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.FindMaxJissiNoCondition;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���{No�̍ő�l�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/09 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindMaxJissiNoByCondCmd extends Command {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** �������ʃL�[ */
	private static final String RESULT_KEY = "RESULT_KEY";

	/** �������� */
	private FindMaxJissiNoCondition _condition;

	/**
	 * �����������g�p���A ���{No�̍ő�l�������������s���܂��B
	 *
	 * @throws KKHException
	 *             �����Ɏ��s�����ꍇ
	 */
	public void execute() throws KKHException {
		FindMaxJissiNoByCondManager manager = FindMaxJissiNoByCondManager.getInstance();
		FindMaxJissiNoByCondResult result = manager.findMaxjissiNoByCondition(_condition);
		getResult().set(RESULT_KEY, result);
	}

	/**
	 *  ����������ݒ肵�܂��B
	 *
	 * @param condition
	 *            FindMaxJissiNoCondition ��������
	 */
	public void setFindMaxJissiNoCondition(FindMaxJissiNoCondition condition) {
		_condition = condition;
	}

	/**
	 * ���{No�̍ő�l�������ʂ�Ԃ��܂��B
	 *
	 * @return FindMaxJissiNoByCondResult ������������
	 */
	public FindMaxJissiNoByCondResult getFindByCondResult() {
		return (FindMaxJissiNoByCondResult) super.getResult().get(RESULT_KEY);
	}
}
