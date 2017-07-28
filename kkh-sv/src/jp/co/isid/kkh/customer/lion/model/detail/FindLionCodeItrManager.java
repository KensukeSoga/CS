package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �ėp�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/27 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindLionCodeItrManager {

    /** �V���O���g���C���X�^���X */
    private static FindLionCodeItrManager _manager = new FindLionCodeItrManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FindLionCodeItrManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindLionCodeItrManager getInstance() {
        return _manager;
    }

    /**
    * �R�[�h�ꗗ�f�[�^���������܂��B
    *
    * @return FindLionCardNoItrResult �ėp�}�X�^�����f�[�^
    * @throws KKHException �������ɃG���[�����������ꍇ
    */
   public FindLionCodeItrResult findLionCodeItrByCondition(FindLionCodeItrCondition cond) throws KKHException {
   	//��������
	   FindLionCodeItrResult result = new FindLionCodeItrResult();

   	//******************************************************
   	//�R�[�h�ꗗ�f�[�^���擾
   	//******************************************************
	   FindLionCodeItrDAO findLionCodeItrDAO = FindLionCodeItrDAOFactory.createFindLionCodeItrDAO();

   	List<FindLionCodeItrVO> list = findLionCodeItrDAO.findLionCodeItrByCondition(cond);
   	result.setFindLionCodeItr(list);

       return result;

   }


}
