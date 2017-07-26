package jp.co.isid.kkh.customer.epson.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonResult;
import jp.co.isid.kkh.customer.epson.model.detail.Thb14skdownVO;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonDAO;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonDAOFactory;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataCondition;


/**
 * <P>
 * ��������f�[�^���o��Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/04/25 JSE.Yuguchi)<BR>
 * </P>
 * @author
 */
public class SeikyuDataEpsonManager {

    /** �V���O���g���C���X�^���X */
    private static SeikyuDataEpsonManager _manager = new SeikyuDataEpsonManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private SeikyuDataEpsonManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static SeikyuDataEpsonManager getInstance() {
        return _manager;
    }



    //**********************************************************************************************************************************************************************************
    //��������f�[�^����
    /**
     * ��������f�[�^���������܂��B
     *
     * @return SeikyuDataEpsonResult ��������_�E�����[�h�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public SeikyuDataEpsonResult findSeikyuDataEpsonByCond(SeikyuDataCondition cond) throws KKHException {


    	SeikyuDataEpsonDAO dao = SeikyuDataEpsonDAOFactory.createSeikyuDataDAO();
    	//��������
    	SeikyuDataEpsonResult result = new SeikyuDataEpsonResult();


        List<Thb14skdownVO> SeikyuDataList = dao.findSeikyuDataByCondition(cond);

        result.setSeikyuData(SeikyuDataList);

        return result;
    }

}
