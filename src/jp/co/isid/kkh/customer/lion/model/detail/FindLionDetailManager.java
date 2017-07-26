package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �ėp�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class FindLionDetailManager {

    /** �V���O���g���C���X�^���X */
    private static FindLionDetailManager _manager = new FindLionDetailManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FindLionDetailManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindLionDetailManager getInstance() {
        return _manager;
    }


    /**
    * �ڍ׃f�[�^�i�}�X�^�t�j���������܂��B
    *
    * @return ReportMacResult �ڍ׃f�[�^�i�}�X�^�t�j�����f�[�^
    * @throws KKHException �������ɃG���[�����������ꍇ
    */
   public FindLionDetailResult findLionDetailByCondition(FindLionDetailCondition cond) throws KKHException {
       //��������
    FindLionDetailResult result = new FindLionDetailResult();

       //******************************************************
       //TV�ԑg�f�[�^���擾
       //******************************************************
    FindLionDetailDAO findDetailDAO = FindLionDetailDAOFactory.createFindLionDetailDAO();

       List<FindLionDetailVO> list = findDetailDAO.findLionDetailByCondition(cond);
       result.setFindLionDetail(list);

       return result;

   }

   /**
    * �ڍ׃f�[�^�̑��ݗL���i�J�[�hNO)���������܂��B
    *
    * @return ReportMacResult �ڍ׃f�[�^�i�}�X�^�t�j�����f�[�^
    * @throws KKHException �������ɃG���[�����������ꍇ
    */
   public FindLionCardNoGetResult findLionCardNoGetByCondition(FindLionCardNoGetCondition cond) throws KKHException {
       //��������
    FindLionCardNoGetResult result = new FindLionCardNoGetResult();

       //******************************************************
       //TV�ԑg�f�[�^���擾
       //******************************************************
    FindLionCardNoGetDAO findCardNoGetDAO = FindLionCardNoGetDAOFactory.createFindLionCardNoGetDAO();

       List<FindLionCardNoGetVO> list = findCardNoGetDAO.findLionCardNoGetByCondition(cond);
       result.setFindLionCardNoGet(list);

       return result;

   }


}
