package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrDAO;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrDAOFactory;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrResult;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrVO;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �ėp�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/21 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindLionCardNoItrManager {

    /** �V���O���g���C���X�^���X */
    private static FindLionCardNoItrManager _manager = new FindLionCardNoItrManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FindLionCardNoItrManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindLionCardNoItrManager getInstance() {
        return _manager;
    }

    /**
    * �J�[�hNO�ꗗ�f�[�^���������܂��B
    *
    * @return FindLionCardNoItrResult �ėp�}�X�^�����f�[�^
    * @throws KKHException �������ɃG���[�����������ꍇ
    */
   public FindLionCardNoItrResult findLionCardNoItrByCondition(FindLionCardNoItrCondition cond) throws KKHException {
   	//��������
	   FindLionCardNoItrResult result = new FindLionCardNoItrResult();

   	//******************************************************
   	//�J�[�hNO�ꗗ�f�[�^���擾
   	//******************************************************
	   FindLionCardNoItrDAO findLionCardNoItrDAO = FindLionCardNoItrDAOFactory.createFindLionCardNoItrDAO();

   	List<FindLionCardNoItrVO> list = findLionCardNoItrDAO.findLionCardNoItrByCondition(cond);
   	result.setFindLionCardNoItr(list);

       return result;

   }


}
