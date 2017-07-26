package jp.co.isid.kkh.customer.tkd.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;

import jp.co.isid.kkh.customer.tkd.model.detail.FindJissiNoCntByCondManager;
import jp.co.isid.kkh.customer.tkd.model.detail.FindJissiNoCntByCondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.FindJissiNoCntCondition;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �g�p�ώ��{No�̌��������R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/13 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindJissiNoCntByCondCmd extends Command {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** �������ʃL�[ */
	private static final String RESULT_KEY = "RESULT_KEY";

	/** �������� */
	private FindJissiNoCntCondition _condition;

	/**
	 * �����������g�p���A �g�p�ώ��{No�̌����������������s���܂��B
	 *
	 * @throws KKHException
	 *             �����Ɏ��s�����ꍇ
	 */
	public void execute() throws KKHException {
		FindJissiNoCntByCondManager manager = FindJissiNoCntByCondManager.getInstance();
		FindJissiNoCntByCondResult result = manager.findJissiNoCntByCondition(_condition);
		getResult().set(RESULT_KEY, result);
	}

	/**
	 *  ����������ݒ肵�܂��B
	 *
	 * @param condition
	 *            FindJissiNoCntCondition ��������
	 */
	public void setFindJissiNoCntCondition(FindJissiNoCntCondition condition) {
		_condition = condition;
	}

	/**
	 * �g�p�ώ��{No�̌����������ʂ�Ԃ��܂��B
	 *
	 * @return FindJissiNoCntByCondResult ������������
	 */
	public FindJissiNoCntByCondResult getFindByCondResult() {
		return (FindJissiNoCntByCondResult) super.getResult().get(RESULT_KEY);
	}
}
