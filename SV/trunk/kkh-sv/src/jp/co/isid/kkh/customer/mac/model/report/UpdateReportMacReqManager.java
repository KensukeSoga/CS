package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;


/**
 * <P>
 * �f�[�^�X�V(������)manager
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/18 IP Shimizu)<BR>
 * </P>
 * @author
 */
public class UpdateReportMacReqManager {

    /** �V���O���g���C���X�^���X */
    private static UpdateReportMacReqManager _manager = new UpdateReportMacReqManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private UpdateReportMacReqManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static UpdateReportMacReqManager getInstance() {
        return _manager;
    }

    /**
     * �}�X�^(�f�[�^)�̓o�^
     *
     * @param list �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void updateReportMacRequest(List<UpdateReportMacReqDataVO> list) throws KKHException {



        for (UpdateReportMacReqDataVO vo : list) {
            UpdateReportMacReqDAO dao = UpdateReportMacReqDAOFactory.createMasterRegisterDAO();
            dao.updateReportMacRequest(vo);
        }
    }
}
