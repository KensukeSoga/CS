package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotDAO;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotDAOFactory;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotResult;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotVO;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastDAO;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastDAOFactory;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastVO;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���C�I��TVSpot�f�[�^�擾�}�l�[�W���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/05 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FindLionTVSpotManager {

	/** �V���O���g���C���X�^���X */
	private static FindLionTVSpotManager _manager = new FindLionTVSpotManager();

	/**
	 * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
	 */
	private FindLionTVSpotManager() {
	}

	/**
	 * ���C�I��TVSpot�f�[�^�\�[�g�p�N���X
	 */
	private class TVSpotComparator implements Comparator<FindLionTVSpotVO>
	{
		public int compare(FindLionTVSpotVO arg0, FindLionTVSpotVO arg1)
		{
			int retval = 0;

			// �n��\����
			retval = compareTo(arg0.getTHYOJIJYUN(), arg1.getTHYOJIJYUN());

			if (retval != 0)
			{
				return retval;
			}

			// �\����
			retval = compareTo(arg0.getHYOJIJYUN(), arg1.getHYOJIJYUN());

			if (retval != 0)
			{
				return retval;
			}

			// Climax�X�|�b�g����NO
			retval = compareTo(arg0.getSHK_NO(), arg1.getSHK_NO());

			if (retval != 0)
			{
				return retval;
			}

			// �����ǃR�[�h
			retval = compareTo(arg0.getKYK_CD(), arg1.getKYK_CD());

			if (retval != 0)
			{
				return retval;
			}

			// �ǈ�NO
			retval = compareTo(arg0.getKYKAN_NO(), arg1.getKYKAN_NO());

			if (retval != 0)
			{
				return retval;
			}

			// ���ԘgNO
			retval = compareTo(arg0.getJWK_NO(), arg1.getJWK_NO());

			if (retval != 0)
			{
				return retval;
			}

			return 0;
		}

		public int compareTo( String val1, String val2 )
		{
			int retval = 0;

			if ((val1 == null) && (val2 == null))
			{
				// �����Ƃ�null�̏ꍇ�͓���Ɣ���
				return 0;
			}
			else if (val1 == null)
			{
				// �Е�����null�̏ꍇ��null�����Ȃ�Ɣ���
				return 1;
			}
			else if (val2 == null)
			{
				// �Е�����null�̏ꍇ��null�����Ȃ�Ɣ���
				return -1;
			}
			else if (val1.equals("") && val2.equals(""))
			{
				// �����Ƃ��󕶎��̏ꍇ�͓���Ɣ���
				return 0;
			}
			else if (val1.equals(""))
			{
				// �Е������󕶎��̏ꍇ�͋󕶎������Ȃ�Ɣ���
				return 1;
			}
			else if (val2.equals(""))
			{
				// �Е������󕶎��̏ꍇ�͋󕶎������Ȃ�Ɣ���
				return -1;
			}
			else
			{
				// ���̑��͕����R�[�h�Ŕ���
				retval = val1.compareTo(val2);
			}

			return retval;
		}
	}

	/**
	 * �C���X�^���X��Ԃ��܂��B
	 *
	 * @return �C���X�^���X
	 */
	public static FindLionTVSpotManager getInstance() {
		return _manager;
	}

	/**
	 * ���C�I��TVSpot�f�[�^���������܂��B
	 *
	 * @return FindLionTVSpotResult ���C�I��TVSpot�f�[�^�擾����
	 * @throws KKHException
	 *             �������ɃG���[�����������ꍇ
	 */
	public FindLionTVSpotResult findByCondition(FindLionTVSpotCondition cond) throws KKHException {

		// �������ׂ̈Ƀ}�X�^�Ƃ̌����𓖃��\�b�h���ōs��

		// TVSPOT�f�[�^�̎擾

		FindLionTVSpotResult result = new FindLionTVSpotResult();

		FindLionTVSpotDAO dao = FindLionTVSpotDAOFactory.createDAO();

		List<FindLionTVSpotVO> list = dao.findFindLionTVSpotByCondition(cond);


		// ���C�I���ǃ}�X�^�̎擾

		FindTvKMastCondition cond2 = new FindTvKMastCondition();

		cond2.setEsqId(cond.getEsqId());

		cond2.setEgCd(cond.getEgCd());

		cond2.setTksKgyCd(cond.getTksKgyCd());

		cond2.setTksBmnSeqNo(cond.getBmncd());

		cond2.setTksTntSeqNo(cond.getTntcd());

		cond2.setYm(cond.getYM());

		cond2.setKyokucd("");

		cond2.setKigou("");

		cond2.setKeiretsu("");

		cond2.setTiku("");

		FindTvKMastDAO dao2 = FindTvKMastDAOFactory.createFindTvKMastDAO();

		List<FindTvKMastVO> list2 = dao2.findTvKMastByCondition(cond2);


		// TVSPOT�f�[�^�Ƀ��C�I���ǃ}�X�^�̃f�[�^��t�^

		for (FindLionTVSpotVO ts : list)
		{
			for (FindTvKMastVO tkm : list2)
			{
				if (!ts.getKYK_CD().equals(tkm.getKigou()))
				{
					continue;
				}

//				// �n��R�[�h
//				ts.setTIKU(tkm.getTiku());
//
//				// �����ǃR�[�h
//				ts.setKYOKUCD(tkm.getKyokuCd());
//
//				// �����ǖ���
//				ts.setKYOKUNAME(tkm.getKyokuName());
//
//				// �n��\����
//				ts.setTHYOJIJYUN(tkm.getTHyojiJyun());
//
//				// �\����
//				ts.setHYOJIJYUN(tkm.getHyojijyun());

				// �n��R�[�h
				if (tkm.getTiku().equals(""))
				{
				    ts.setTIKU("00");
				}
				else
				{
				    ts.setTIKU(tkm.getTiku());
				}

                // �����ǃR�[�h
                ts.setKYOKUCD(tkm.getKyokuCd());

                // �����ǖ���
                ts.setKYOKUNAME(tkm.getKyokuName());

                // �n��\����
                if (tkm.getTHyojiJyun().equals(""))
                {
                    ts.setTHYOJIJYUN("000");
                }
                else
                {
                    ts.setTHYOJIJYUN(tkm.getTHyojiJyun());
                }

                // �\����
                if (tkm.getHyojijyun().equals(""))
                {
                    ts.setHYOJIJYUN("0");
                }
                else
                {
                    ts.setHYOJIJYUN(tkm.getHyojijyun());
                }

				break;
			}
		}


		// TVSPOT�f�[�^�̍ă\�[�g

		Collections.sort(list, new TVSpotComparator());


		// �擾���ʂ̐ݒ�
		result.setFindLionTVSpot(list);


		return result;
	}
}
