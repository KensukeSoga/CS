package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �L����׏��iAsh�j�f�[�^����Manager
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/20 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshKoukokuHiManager {

    /** �V���O���g���C���X�^���X */
    private static ReportAshKoukokuHiManager _manager = new ReportAshKoukokuHiManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportAshKoukokuHiManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportAshKoukokuHiManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(Ash)���������܂��B
     *
     * @return ReportAshMediaResult �}�̎�ʈꗗ�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportAshKoukokuHiResult findByCondition(ReportAshMediaCondition cond) throws KKHException {

        //��������
        ReportAshKoukokuHiResult result = new ReportAshKoukokuHiResult();

        //******************************************************
        //�}�̎�ʃf�[�^���擾
        //******************************************************
        ReportAshKoukokuHiDAO reportAshKoukokuHiDAO = ReportAshKoukokuHiDAOFactory.createReportAshKoukokuHiDAO();
        List<ReportAshKoukokuHiVO> list = reportAshKoukokuHiDAO.findReportAshKoukokuHiByCondition(cond);
        result.setReportAsh(list);

        //******************************************************
        //�e���r�^�C���A���W�I�^�C���̖��׋��z�̎擾
        //******************************************************
        List<ReportAshTvAndRadioKingakVO> TvAndRadiolist = reportAshKoukokuHiDAO.findTvAndRadioKingakByCondition(cond);
        result.setReportAshTvAndRadio(TvAndRadiolist);
        return result;
    }

}
