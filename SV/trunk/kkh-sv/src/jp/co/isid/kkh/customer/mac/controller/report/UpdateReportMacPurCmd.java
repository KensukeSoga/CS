package jp.co.isid.kkh.customer.mac.controller.report;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb1DownDAO;
import jp.co.isid.kkh.model.detail.Thb1DownDAOFactory;
import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.master.MasterDataCondition;
import jp.co.isid.kkh.model.master.MasterManager;
import jp.co.isid.kkh.model.master.MasterRegisterResult;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurDataVO;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurManager;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurResult;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurVO;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurCondition;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �w���`�[�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/18 IP Shimizu)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class UpdateReportMacPurCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �}�X�^�f�[�^�o�^�����pVO */
    private UpdateReportMacPurCondition _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �}�X�^�f�[�^�o�^���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        MasterManager datemanager = MasterManager.getInstance();
        UpdateReportMacPurManager manager = UpdateReportMacPurManager.getInstance();

        // ���̓`�F�b�N
        checkInput();

        //�X�V�����ő�l�̎擾
        Date maxupdate = _vo.getMaxUpDate();

        // �}�X�^�f�[�^�擾��ݒ�
        MasterDataCondition masterDataCondition = new MasterDataCondition();
        setMasterDataCondition(masterDataCondition, _vo);


     // �}�X�^�f�[�^�̍X�V�^�C���X�^���v�i�ő�l�j���擾
        Date newTimStmp = datemanager.findMasterUpdTimStmpMaxByCondition(masterDataCondition);

        // ���݂̃^�C���X�^���v�̍ő�l���擾
        Date currentTimStmp = maxupdate;

        if(newTimStmp != null)
        {
            // �r���`�F�b�N
            ErrorInfo errorInfo = checkExclusion(newTimStmp, currentTimStmp);
            if (errorInfo != null) {
                MasterRegisterResult result = new MasterRegisterResult();
                result.setErrorInfo(errorInfo);
                getResult().set(RESULT_KEY, result);
                return;
            }
        }

        // �}�X�^�f�[�^�̕ҏW
        List<UpdateReportMacPurDataVO> updateVOList = new ArrayList<UpdateReportMacPurDataVO>();
        updateVOList = editDataUpdateVO(_vo);
        // �}�X�^�f�[�^�̓o�^
        manager.updateReportMacPurchase(updateVOList);
        manager.updateReportMacSysDenNum(_vo);

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();
        //�󒍃^�C���X�^���v�̍X�V
        for(UpdateReportMacPurDataVO row : updateVOList){
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
        getResult().set(RESULT_KEY, new UpdateReportMacPurResult());
    }

    /**
     * ���s���ʂ�Ԃ��܂��B
     *
     * @return ���s����
     */
    public UpdateReportMacPurResult getUpdateReportMacPurResult() {
        return (UpdateReportMacPurResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * �}�X�^�f�[�^�擾
     *
     * @param cond �}�X�^�f�[�^�擾
     */
    private void setMasterDataCondition(MasterDataCondition cond, UpdateReportMacPurCondition vo) {

        cond.setEgCd(vo.getEgCd());
        cond.setTksKgyCd(vo.getTksKgyCd());
        cond.setTksBmnSeqNo(vo.getTksBmnSeqNo());
        cond.setTksTntSeqNo(vo.getTksTntSeqNo());
        cond.setSybt("201");
    }

    /**
     * �X�V������ݒ肵�܂��B
     *
     * @param vo UpdateReportMacPurVO �X�V����
     */
    public void setUpdateReportMacVO(UpdateReportMacPurCondition vo) {
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
        if (StringUtil.isBlank(_vo.getDenNum())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getHostDate())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        try {
            if (_vo.getReportData() == null && _vo.getMaxUpDate() == DateFormat.getDateInstance().parse("1000/01/01 01:01:01")) {
                throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
            }
        } catch (ParseException e) {
            // TODO �����������ꂽ catch �u���b�N
            e.printStackTrace();
        }
    }

    /**
     * �r���`�F�b�N
     *
     * @param newTimStmp �X�V�^�C���X�^���v�i�ŐV�j
     * @param currentTimStmp �X�V�^�C���X�^���v�i���݁j
     * @return ����Fnull�A�`�F�b�N�G���[�F�G���[���
     */
    private ErrorInfo checkExclusion(Date newTimStmp, Date currentTimStmp) {

        // �Ώۂ̃^�C���X�^���v���ǂ�������݂��Ȃ��ꍇ
        if (newTimStmp == null && currentTimStmp == null) {
            return null;
        }
        // �Ώۂ̃^�C���X�^���v�̈�������݂��Ȃ��ꍇ
        if (newTimStmp == null || currentTimStmp == null) {
            return createErrorInfo("�r���G���[", "BD-W0001");
        }
        // �X�V�^�C���X�^���v�i�ŐV�j���X�V�^�C���X�^���v�i���݁j���傫���ꍇ
        if (newTimStmp.compareTo(currentTimStmp) > 0) {
            return createErrorInfo("�r���G���[", "BD-W0001");
        }
        return null;
    }

    /**
     * �G���[��񐶐�
     *
     * @param message ���b�Z�[�W
     * @param errorID �G���[�R�[�h
     * @return �G���[���
     */
    private ErrorInfo createErrorInfo(String message, String errorID) {

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setError(true);
        errorInfo.setErrorCode(errorID);
        List<String> list = new ArrayList<String>();
        list.add(message);
        errorInfo.setNote(list);
        return errorInfo;
    }


    /**
     * �f�[�^�̕ҏW
     *
     *@return �f�[�^VO�iUPDATE�p�j�̃��X�g
     */
    private List<UpdateReportMacPurDataVO> editDataUpdateVO(UpdateReportMacPurCondition cond) {

        List<UpdateReportMacPurDataVO> updateVOList = new ArrayList<UpdateReportMacPurDataVO>();

        // �}�X�^���R�[�h�������[�v
        for (UpdateReportMacPurVO updateDataVO : cond.getReportData()) {
            UpdateReportMacPurDataVO updateVO = new UpdateReportMacPurDataVO();
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
            updateVO.setSonota1(updateDataVO.getSonota1());
            updateVO.setKbn1(updateDataVO.getKbn1());
            updateVOList.add(updateVO);
        }

        return updateVOList;
    }

}
