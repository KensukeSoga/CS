package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;


/**
 * <P>
 * �f�[�^�X�V(�w���`�[)manager
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/17 IP Shimizu)<BR>
 * </P>
 * @author
 */
public class UpdateReportMacPurManager {

    /** �V���O���g���C���X�^���X */
    private static UpdateReportMacPurManager _manager = new UpdateReportMacPurManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private UpdateReportMacPurManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static UpdateReportMacPurManager getInstance() {
        return _manager;
    }


    /**
     * �}�X�^(�f�[�^)�̓o�^
     *
     * @param list �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void updateReportMacSysDenNum(UpdateReportMacPurCondition vo) throws KKHException {


            UpdateReportMacPurDAO dao = UpdateReportMacPurDAOFactory.createMasterRegisterDAO();
            dao.updateReportMacSysDenNum(vo);
    }

    /**
     * �}�X�^(�f�[�^)�̓o�^
     *
     * @param list �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void updateReportMacPurchase(List<UpdateReportMacPurDataVO> list) throws KKHException {



        for (UpdateReportMacPurDataVO vo : list) {
            UpdateReportMacPurDAO dao = UpdateReportMacPurDAOFactory.createMasterRegisterDAO();
            dao.updateReportMacPurchase(vo);
        }
    }
}
