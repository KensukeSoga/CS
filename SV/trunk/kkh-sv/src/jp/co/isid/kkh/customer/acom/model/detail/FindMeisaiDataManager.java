package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;


/**
 * <P>
 * �L����ד���Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/08 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class FindMeisaiDataManager {

    /** �V���O���g���C���X�^���X */
    private static FindMeisaiDataManager _manager = new FindMeisaiDataManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FindMeisaiDataManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindMeisaiDataManager getInstance() {
        return _manager;
    }

    //**********************************************************************************************************************************************************************************
    //���׌���
    /**
     * �L����׃f�[�^���������܂��B
     *
     * @return DetailDataResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public FindMeisaiDataResult findMeisaiDataByCond(FindMeisaiDataCondition cond) throws KKHException {

    	//��������
    	FindMeisaiDataResult result = new FindMeisaiDataResult();

    	//******************************************************
    	//�L����׃f�[�^���擾
    	//******************************************************
    	FindMeisaiiBycondDAO thb2KmeiDAO = FindMeisaiiBycondDAOFactory.createMeisaiDAO();
    	Thb2KmeiVO thb2KmeiCond = new Thb2KmeiVO();
    	thb2KmeiCond.setHb2EgCd(cond.getEgCd());
    	thb2KmeiCond.setHb2TksKgyCd(cond.getTksKgyCd());
    	thb2KmeiCond.setHb2TksBmnSeqNo(cond.getTksBmnSeqNo());
    	thb2KmeiCond.setHb2TksTntSeqNo(cond.getTksTntSeqNo());
    	thb2KmeiCond.setHb2Yymm(cond.getYm());
    	thb2KmeiCond.setHb2JyutNo(cond.getJyutNo());
    	thb2KmeiCond.setHb2JyMeiNo(cond.getJyMeiNo());
    	thb2KmeiCond.setHb2UrMeiNo(cond.getUrMeiNo());

        List<Thb2KmeiVO> thb2KmeiList = thb2KmeiDAO.findThb2KmeiByCondCmn(thb2KmeiCond);
        result.setThb2KmeiList(thb2KmeiList);

        return result;
    }

}
