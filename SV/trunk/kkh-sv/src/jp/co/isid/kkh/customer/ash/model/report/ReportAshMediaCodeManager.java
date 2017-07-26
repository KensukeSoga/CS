package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���[�iAsh)�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/20 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaCodeManager {

    /** �V���O���g���C���X�^���X */
    private static ReportAshMediaCodeManager _manager = new ReportAshMediaCodeManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportAshMediaCodeManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportAshMediaCodeManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(Ash)���������܂��B
     *
     * @return ReportAshMediaResult �}�̎�ʈꗗ�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportAshMediaCodeResult findByCondition(ReportAshMediaCondition cond) throws KKHException {

        //��������
        ReportAshMediaCodeResult result = new ReportAshMediaCodeResult();

        //******************************************************
        //baitai�f�[�^���擾
        //******************************************************
        ReportAshMediaCodeDAO reportAshMediaDAO = ReportAshMediaCodeDAOFactory.createReportAshMediaCodeDAO();
        List<ReportAshMediaCodeVO> list = reportAshMediaDAO.findReportAshMediaCodeByCondition(cond);
        result.setReportAshCode(list);

        //******************************************************
        //Syohin�f�[�^���擾
        //******************************************************
        List<ReportAshMediaCodeVO> syohinlist = reportAshMediaDAO.findSyohinByCondition(cond);
        result.setSyohinCode(syohinlist);

        //*******************************************************
        //�}�X�^�f�[�^�擾
        //*******************************************************
        List<ReportAshOldKyokuVO> OldKyokulist = reportAshMediaDAO.findOldKyokuByCondition(cond);
        result.setReportAshOldKyoku(OldKyokulist);

        //*******************************************************
        //�ԑg�f�[�^�擾
        //*******************************************************
        List<ReportAshBangumiDataVO> Bangumilist = reportAshMediaDAO.findBangumiDataByCondition(cond);
        result.setReportAshBangumiData(Bangumilist);

        return result;
    }

}
