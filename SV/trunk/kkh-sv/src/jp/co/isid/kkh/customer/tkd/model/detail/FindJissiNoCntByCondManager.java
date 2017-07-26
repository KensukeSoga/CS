package jp.co.isid.kkh.customer.tkd.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class FindJissiNoCntByCondManager {

	/** �V���O���g���C���X�^���X */
	private static FindJissiNoCntByCondManager _manager = new FindJissiNoCntByCondManager();

	/**
	 * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
	 */
	private FindJissiNoCntByCondManager() {
	}

	/**
	 * �C���X�^���X��Ԃ��܂��B
	 *
	 * @return �C���X�^���X
	 */
	public static FindJissiNoCntByCondManager getInstance() {
		return _manager;
	}

	/**
	 * �g�p�ώ��{No�̌������������܂��B
	 *
	 * @return FindJissiNoCntByCondResult �g�p�ώ��{No�̌���
	 * @throws KKHException
	 *             �������ɃG���[�����������ꍇ
	 */
	public FindJissiNoCntByCondResult findJissiNoCntByCondition(
			FindJissiNoCntCondition cond) throws KKHException {

		// �p�����[�^�̕K�{�`�F�b�N
		if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (cond.getYm() == null || cond.getYm().equals("")) {
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (cond.getJyutNo() == null || cond.getJyutNo().equals("")) {
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (cond.getJyMeiNo() == null || cond.getJyMeiNo().equals("")) {
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (cond.getUrMeiNo() == null || cond.getUrMeiNo().equals("")) {
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}

		// ��������
		FindJissiNoCntByCondResult result = new FindJissiNoCntByCondResult();

		// ��������
		FindJissiNoCntCondition lCond = new FindJissiNoCntCondition();

		// ******************************************************
		// �g�p�ώ��{No�̌������擾
		// ******************************************************
		FindJissiNoCntByCondDAO dao = FindJissiNoCntByCondDAOFactory.createFindJissiNoCntByCondDAO();

		// ******************************************************
		// �}�X�^��ސݒ���擾
		// ******************************************************
		lCond = cond;
		List<FindJissiNoCntCondVO> list = dao.findJissiNoCntByCondition(lCond);
		FindJissiNoCntCondVO vo = list.get(0);

		result.setJissiNoCnt(vo.getKngk1());

		return result;
	}

}
