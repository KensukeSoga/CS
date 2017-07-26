package jp.co.isid.kkh.customer.mac.controller.report;

import java.util.ArrayList;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb1DownDAO;
import jp.co.isid.kkh.model.detail.Thb1DownDAOFactory;
import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqDataVO;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqManager;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqResult;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqVO;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqCondition;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �������X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/18 IP Shimizu)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class UpdateReportMacReqCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �}�X�^�f�[�^�o�^�����pVO */
    private UpdateReportMacReqCondition _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �}�X�^�f�[�^�o�^���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        UpdateReportMacReqManager manager = UpdateReportMacReqManager.getInstance();

        // ���̓`�F�b�N
        checkInput();

        // �}�X�^�f�[�^�̕ҏW
        List<UpdateReportMacReqDataVO> updateVOList = new ArrayList<UpdateReportMacReqDataVO>();
        updateVOList = editDataUpdateVO(_vo);
        // �}�X�^�f�[�^�̓o�^
        manager.updateReportMacRequest(updateVOList);

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();
        //�󒍃^�C���X�^���v�̍X�V
        for(UpdateReportMacReqDataVO row : updateVOList){
            Thb1DownVO vo1down = new Thb1DownVO();
            vo1down.setHb1EgCd(row.getEgCd());
            vo1down.setHb1TksKgyCd(row.getTksKgyCd());
            vo1down.setHb1TksBmnSeqNo(row.getTksBmnSeqNo());
            vo1down.setHb1TksTntSeqNo(row.getTksTntSeqNo());
            vo1down.setHb1Yymm(row.getYymm());
            vo1down.setHb1JyutNo(row.getJyutNo());
            vo1down.setHb1JyMeiNo(row.getJyMeiNo());
            vo1down.setHb1UrMeiNo(row.getUrMeiNo());
            dao.updateSysdateTo1down(vo1down);
        }

        // ����I��
        getResult().set(RESULT_KEY, new UpdateReportMacReqResult());
    }

    /**
     * ���s���ʂ�Ԃ��܂��B
     *
     * @return ���s����
     */
    public UpdateReportMacReqResult getUpdateReportMacReqResult() {
        return (UpdateReportMacReqResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * �X�V������ݒ肵�܂��B
     *
     * @param vo UpdateReportMacPurVO �X�V����
     */
    public void setUpdateReportMacVO(UpdateReportMacReqCondition vo) {
        _vo = vo;
    }

    /**
     * �p�����[�^���̓`�F�b�N
     *
     * @throws KKHException �p�����[�^�w��G���[�̏ꍇ
     */
    private void checkInput() throws KKHException {

        //�p�����[�^�̕K�{�`�F�b�N
        if (StringUtil.isBlank(_vo.getEsqId())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getAplId())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getEgCd())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getTksKgyCd())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getTksBmnSeqNo())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getTksTntSeqNo())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (_vo.getReportData() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getHostDate())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
    }

    /**
     * �f�[�^�̕ҏW
     *
     *@return �f�[�^VO�iUPDATE�p�j�̃��X�g
     */
    private List<UpdateReportMacReqDataVO> editDataUpdateVO(UpdateReportMacReqCondition cond) {

        List<UpdateReportMacReqDataVO> updateVOList = new ArrayList<UpdateReportMacReqDataVO>();

        // �}�X�^���R�[�h�������[�v
        for (UpdateReportMacReqVO updateDataVO : cond.getReportData()) {
            UpdateReportMacReqDataVO updateVO = new UpdateReportMacReqDataVO();
            // ���ʍ���
            updateVO.setUpdApl(cond.getAplId());
            updateVO.setUpdTnt(cond.getEsqId());
            updateVO.setEgCd(cond.getEgCd());
            updateVO.setTksKgyCd(cond.getTksKgyCd());
            updateVO.setTksBmnSeqNo(cond.getTksBmnSeqNo());
            updateVO.setTksTntSeqNo(cond.getTksTntSeqNo());
            updateVO.setDate1(cond.getHostDate());
            updateVO.setYymm(updateDataVO.getYymm());
            updateVO.setJyutNo(updateDataVO.getJyutNo());
            updateVO.setJyMeiNo(updateDataVO.getJyMeiNo());
            updateVO.setUrMeiNo(updateDataVO.getUrMeiNo());
            updateVO.setRenbn(updateDataVO.getRenbn());
            updateVOList.add(updateVO);
        }

        return updateVOList;
    }

}
