package jp.co.isid.kkh.controller.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.BulkDataRegisterResult;
import jp.co.isid.kkh.model.detail.BulkDataRegisterVO;
import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �ꊇ�o�^�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/24 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class BulkDataRegisterCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �ꊇ�o�^�����pVO */
    private BulkDataRegisterVO _vo;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �ꊇ�o�^���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        // ���̓`�F�b�N
        checkInput();

        /*
         * �r���`�F�b�N
         */
        // �_�E�����[�h�f�[�^�̌������A�J��Ԃ�
        for (Thb1DownVO currentDownVO : _vo.getThb1DownList()) {
            // �ŐV�̃_�E�����[�h�f�[�^�擾
            List<Thb1DownVO> newThb1DownVOList = manager.lockThb1Down(currentDownVO);
            // �_�E�����[�h�f�[�^�r���`�F�b�N
            ErrorInfo errorInfoThb1Down = checkExclusionThb1Down(newThb1DownVOList, currentDownVO.getHb1TimStmp());
            if (errorInfoThb1Down != null) {
                BulkDataRegisterResult result = new BulkDataRegisterResult();
                result.setErrorInfo(errorInfoThb1Down);
                getResult().set(RESULT_KEY, result);
                return;
            }
            // �L����׃f�[�^�擾�����ݒ�
            Thb2KmeiVO cond = new Thb2KmeiVO();
            setThb2KmeiCondition(cond, currentDownVO);
            // �L����׃f�[�^�擾
            List<Thb2KmeiVO> thb2KmeiVOList = manager.lockThb2Kmei(cond);
            // �L����׃f�[�^�r���`�F�b�N
            ErrorInfo errorInfoThb2Kmei = checkExclusionThb2Kmei(thb2KmeiVOList);
            if (errorInfoThb2Kmei != null) {
                BulkDataRegisterResult result = new BulkDataRegisterResult();
                result.setErrorInfo(errorInfoThb2Kmei);
                getResult().set(RESULT_KEY, result);
                return;
            }
        }

        /*
         * �ꊇ�o�^
         */
        // �_�E�����[�h�f�[�^�̌������A�J��Ԃ�
        for (Thb1DownVO currentDownVO : _vo.getThb1DownList()) {
            // �L����׃f�[�^�ҏW
            Thb2KmeiVO thb2KmeiVO = new Thb2KmeiVO();
            editThb2KmeiVO(_vo, currentDownVO, thb2KmeiVO);
            // �L����׃f�[�^�o�^
            manager.insertThb2Kmei(thb2KmeiVO);
            // �_�E�����[�h�f�[�^�ҏW
            editThb1DownVO(_vo, currentDownVO);
            // �_�E�����[�h�f�[�^�X�V
            manager.updateThb1DownForDisplayData(currentDownVO);

            //�����f�[�^�X�V
            manager.updateThb8RirekiForDisplayData(currentDownVO);
        }

        /*
         * �ꊇ�o�^�����q�Ή�
         */
        if(_vo.getTouIkkatsuThb1Down() != null)
        {
            for(Thb1DownVO UpRow : _vo.getTouIkkatsuThb1Down())
            {
                //���s
                manager.updateTourokuIkkatsuKoTaiou(UpRow);
            }
        }

        // ����I��
        getResult().set(RESULT_KEY, new BulkDataRegisterResult());
    }

    /**
     * �ꊇ�o�^VO�̐ݒ�
     *
     * @param vo �ꊇ�o�^VO
     */
    public void setBulkDataRegisterVO(BulkDataRegisterVO vo) {
        _vo = vo;
    }

    /**
     * ���s���ʂ�Ԃ��܂��B
     *
     * @return ���s����
     */
    public BulkDataRegisterResult getBulkDataRegisterResult() {
        return (BulkDataRegisterResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * �p�����[�^���̓`�F�b�N
     *
     * @throws KKHException �p�����[�^�w��G���[�̏ꍇ
     */
    private void checkInput() throws KKHException {

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
        if (_vo.getThb1DownList() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
    }

    /**
     * �L����׃f�[�^�擾�����̐ݒ�
     *
     * @param cond �L����׃f�[�^�擾����
     * @param downVO �_�E�����[�h�f�[�^VO
     */
    private void setThb2KmeiCondition(Thb2KmeiVO cond, Thb1DownVO downVO) {
        cond.setHb2EgCd(downVO.getHb1EgCd());
        cond.setHb2TksKgyCd(downVO.getHb1TksKgyCd()); // TODO �Â肪���ׂƃ_�E�����[�h�ňقȂ�
        cond.setHb2TksBmnSeqNo(downVO.getHb1TksBmnSeqNo());
        cond.setHb2TksTntSeqNo(downVO.getHb1TksTntSeqNo());
        cond.setHb2Yymm(downVO.getHb1Yymm());
        cond.setHb2JyutNo(downVO.getHb1JyutNo());
        cond.setHb2JyMeiNo(downVO.getHb1JyMeiNo());
        cond.setHb2UrMeiNo(downVO.getHb1UrMeiNo());
    }

    /**
     * �r���`�F�b�N�i�_�E�����[�h�f�[�^�j
     *
     * @param newThb1DownVOList �_�E�����[�h�f�[�^���X�g�i�ŐV�j
     * @param currentTimStmp �X�V�^�C���X�^���v�i���݁j
     * @return ����Fnull�A�`�F�b�N�G���[�F�G���[���
     */
    private ErrorInfo checkExclusionThb1Down(List<Thb1DownVO> newThb1DownVOList, Date currentTimStmp) {

        // �ŐV�̃_�E�����[�h�f�[�^���擾�ł��Ȃ������ꍇ
        if (newThb1DownVOList.size() == 0) {
            return createErrorInfo("�r���G���[", "BD-W0001");
        }

        // �X�V�^�C���X�^���v�i�ŐV�j���擾
        Thb1DownVO newThb1DownVO = newThb1DownVOList.get(0);
        Date newTimStmp = newThb1DownVO.getHb1TimStmp();

        // �X�V�^�C���X�^���v�i�ŐV�j���X�V�^�C���X�^���v�i���݁j���傫���ꍇ
        if (newTimStmp.compareTo(currentTimStmp) > 0) {
            return createErrorInfo("�r���G���[", "BD-W0001");
        }
        return null;
    }

    /**
     * �r���`�F�b�N�i�L����׃f�[�^�j
     *
     * @param thb2KmeiVOList �L����׃f�[�^���X�g
     * @return ����Fnull�A�`�F�b�N�G���[�F�G���[���
     */
    private ErrorInfo checkExclusionThb2Kmei(List<Thb2KmeiVO> thb2KmeiVOList) {

        // �L����׃f�[�^�����݂���ꍇ
        if (thb2KmeiVOList.size() > 0) {
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
     * �L����׃f�[�^�̕ҏW
     *
     * @param bulkDataRegisterVO �ꊇ�o�^�����pVO
     * @param thb1DownVO �_�E�����[�h�f�[�^VO
     * @param �L����׃f�[�^VO
     */
    private void editThb2KmeiVO(BulkDataRegisterVO bulkDataRegisterVO, Thb1DownVO thb1DownVO, Thb2KmeiVO thb2KmeiVO) {
        thb2KmeiVO.setHb2UpdApl(bulkDataRegisterVO.getAplId());
        thb2KmeiVO.setHb2UpdTnt(bulkDataRegisterVO.getEsqId());
        thb2KmeiVO.setHb2EgCd(bulkDataRegisterVO.getEgCd());
        thb2KmeiVO.setHb2TksKgyCd(bulkDataRegisterVO.getTksKgyCd());
        thb2KmeiVO.setHb2TksBmnSeqNo(bulkDataRegisterVO.getTksBmnSeqNo());
        thb2KmeiVO.setHb2TksTntSeqNo(bulkDataRegisterVO.getTksTntSeqNo());
        thb2KmeiVO.setHb2Yymm(thb1DownVO.getHb1Yymm());
        thb2KmeiVO.setHb2JyutNo(thb1DownVO.getHb1JyutNo());
        thb2KmeiVO.setHb2JyMeiNo(thb1DownVO.getHb1JyMeiNo());
        thb2KmeiVO.setHb2UrMeiNo(thb1DownVO.getHb1UrMeiNo());
        thb2KmeiVO.setHb2HimkCd(thb1DownVO.getHb1HimkCd());
        thb2KmeiVO.setHb2Renbn("001");
        thb2KmeiVO.setHb2DateFrom(" ");
        thb2KmeiVO.setHb2DateTo(" ");
        thb2KmeiVO.setHb2SeiGak(thb1DownVO.getHb1SeiGak());
        thb2KmeiVO.setHb2Hnnert(toBigDecimal("0"));
        thb2KmeiVO.setHb2HnmaeGak(toBigDecimal("0"));
        thb2KmeiVO.setHb2NebiGak(toBigDecimal("0"));

        if (StringUtil.isBlank(thb1DownVO.getHb1Field3())) {
            thb2KmeiVO.setHb2Date1(" ");
        } else {
            thb2KmeiVO.setHb2Date1(thb1DownVO.getHb1Field3());
        }

        thb2KmeiVO.setHb2Date2(" ");
        thb2KmeiVO.setHb2Date3(" ");
        thb2KmeiVO.setHb2Date4(" ");
        thb2KmeiVO.setHb2Date5(" ");
        thb2KmeiVO.setHb2Date6(" ");

        /*
         * �敪1�i���[�敪�j�̐ݒ�
         */
        // ���[�敪�������̏ꍇ
        if ("1".equals(thb1DownVO.getHb1Field4())) {
            thb2KmeiVO.setHb2Kbn1("M");
        // ���[�敪���[���̏ꍇ
        } else {
            thb2KmeiVO.setHb2Kbn1("E");
        }

        thb2KmeiVO.setHb2Kbn2("1");
        thb2KmeiVO.setHb2Kbn3(" ");

        /*
         * �R�[�h1�i�X�y�[�X�j�̐ݒ�
         */
        String space = thb1DownVO.getHb1Field11();
        // �X�y�[�X��"D"���܂܂�Ă���A����"X"���܂܂�Ă��Ȃ��ꍇ
        if (space.indexOf("D") >= 0 && space.indexOf("X") < 0) {
            // �X�y�[�X�̍Ōオ"D"�̏ꍇ
            if (space.indexOf("D") == space.length() - 1) {
                // �Ō��"D"���폜
                space = space.substring(0, space.length() - 1);
            // ��L�ȊO�̏ꍇ
            } else {
                // �ŏ���"D"��"*"�ɕϊ�
                space = space.replaceFirst("D", "*");
            }
        }

        if (StringUtil.isBlank(space)) {
            thb2KmeiVO.setHb2Code1(" ");
        } else {
            thb2KmeiVO.setHb2Code1(space);
        }

        if (StringUtil.isBlank(thb1DownVO.getHb1Field1())) {
            thb2KmeiVO.setHb2Code2(" ");
        } else {
            thb2KmeiVO.setHb2Code2(thb1DownVO.getHb1Field1());
        }

        thb2KmeiVO.setHb2Code3(" ");
        thb2KmeiVO.setHb2Code4(" ");
        thb2KmeiVO.setHb2Code5(" ");
        thb2KmeiVO.setHb2Code6(" ");
        thb2KmeiVO.setHb2Name1(" ");

        if (StringUtil.isBlank(thb1DownVO.getHb1Field2())) {
            thb2KmeiVO.setHb2Name2(" ");
        } else {
            thb2KmeiVO.setHb2Name2(thb1DownVO.getHb1Field2());
        }

        thb2KmeiVO.setHb2Name3(" ");
        thb2KmeiVO.setHb2Name4(" ");
        thb2KmeiVO.setHb2Name5(" ");
        thb2KmeiVO.setHb2Name6(" ");
        thb2KmeiVO.setHb2Name7(" ");

        if (StringUtil.isBlank(thb1DownVO.getHb1KKNameKJ())) {
            thb2KmeiVO.setHb2Name8(" ");
        } else {
            thb2KmeiVO.setHb2Name8(thb1DownVO.getHb1KKNameKJ());
        }

        thb2KmeiVO.setHb2Name9(" ");
        thb2KmeiVO.setHb2Name10(" ");
        //�X�y�[�X�Q
        thb2KmeiVO.setHb2Name11(thb1DownVO.getSpace2());
        thb2KmeiVO.setHb2Kngk1(thb1DownVO.getHb1SeiTnka());
        thb2KmeiVO.setHb2Kngk2(toBigDecimal("0"));
        thb2KmeiVO.setHb2Kngk3(toBigDecimal("0"));
        thb2KmeiVO.setHb2Ritu1(toBigDecimal("0"));
        thb2KmeiVO.setHb2Ritu2(toBigDecimal("0"));
        thb2KmeiVO.setHb2Sonota1(" ");
        thb2KmeiVO.setHb2Sonota2(" ");
        thb2KmeiVO.setHb2Sonota3(" ");
        thb2KmeiVO.setHb2Sonota4(" ");
        thb2KmeiVO.setHb2Sonota5(" ");
        thb2KmeiVO.setHb2Sonota6(" ");
        thb2KmeiVO.setHb2Sonota7(" ");
        thb2KmeiVO.setHb2Sonota8(" ");
        thb2KmeiVO.setHb2Sonota9(" ");
        thb2KmeiVO.setHb2Sonota10(" ");
        thb2KmeiVO.setHb2BunFlg(" ");
        thb2KmeiVO.setHb2MeihnFlg(" ");
        thb2KmeiVO.setHb2NebhnFlg(" ");
    }

    /**
     * �_�E�����[�h�f�[�^�̕ҏW
     *
     * @param bulkDataRegisterVO �ꊇ�o�^�����pVO
     * @param thb1DownVO �_�E�����[�h�f�[�^VO
     */
    private void editThb1DownVO(BulkDataRegisterVO bulkDataRegisterVO, Thb1DownVO thb1DownVO) {
        thb1DownVO.setHb1UpdApl(bulkDataRegisterVO.getAplId());
        thb1DownVO.setHb1UpdTnt(bulkDataRegisterVO.getEsqId());
        thb1DownVO.setHb1MSeiFlg("0");
    }

    /**
     * String����BigDecimal�ɕϊ�
     *
     * @param str �ϊ��O������
     * @return �ϊ��㐔�l
     */
    private BigDecimal toBigDecimal(String str) {

        // ���ݒ�̏ꍇ
        if (StringUtil.isBlank(str)) {
            return null;
        }

        return new BigDecimal(str);
    }

}
