package jp.co.isid.kkh.controller.master;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;
import jp.co.isid.kkh.model.master.MasterDataCondition;
import jp.co.isid.kkh.model.master.MasterDataInsertVO;
import jp.co.isid.kkh.model.master.MasterDataVO;
import jp.co.isid.kkh.model.master.MasterManager;
import jp.co.isid.kkh.model.master.MasterRegisterResult;
import jp.co.isid.kkh.model.master.MasterRegisterVO;
import jp.co.isid.kkh.model.master.MasterResult;
import jp.co.isid.kkh.model.master.MasterVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;
import org.springframework.util.StringUtils;

/**
 * <P>
 * �����}�X�^�f�[�^�o�^�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/04/25 IP K.Kawamura)<BR>
 * </P>
 *
 * @author
 */
public class MasterTablesRegisterCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �}�X�^�f�[�^�o�^�����pVO */
    private MasterRegisterVO _vo1;
    private MasterRegisterVO _vo2;

    /** ���s���ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * �}�X�^�f�[�^�o�^���������s���܂��B
     *
     * @throws KKHException �o�^�Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        MasterManager manager = MasterManager.getInstance();

        // ���̓`�F�b�N
        checkInput(_vo1);
        checkInput(_vo2);

        // �}�X�^��`�擾������ݒ�
        MasterCondition masterCondition1 = new MasterCondition();
        MasterCondition masterCondition2 = new MasterCondition();
        setMasterCondition(masterCondition1, _vo1);
        setMasterCondition(masterCondition2, _vo2);

        // �}�X�^��`�̎擾
        MasterResult masterResult1 = manager.findMasterDefineByCondition(masterCondition1);
        MasterResult masterResult2 = manager.findMasterDefineByCondition(masterCondition2);
        List<MasterVO> masterKindList1 = masterResult1.getMasterKind();
        List<MasterVO> masterKindList2 = masterResult2.getMasterKind();

        // �}�X�^�f�[�^�擾�E�폜������ݒ�
        MasterDataCondition masterDataCondition1 = new MasterDataCondition();
        MasterDataCondition masterDataCondition2 = new MasterDataCondition();
        setMasterDataCondition(masterDataCondition1, _vo1, masterKindList1.get(0));
        setMasterDataCondition(masterDataCondition2, _vo2, masterKindList2.get(0));

        // �}�X�^�f�[�^�̍X�V�^�C���X�^���v�i�ő�l�j���擾
        Date newTimStmp = manager.findMasterUpdTimStmpMaxByCondition(masterDataCondition1);

        // ���݂̃^�C���X�^���v�̍ő�l���擾
        Date currentTimStmp = _vo1.get_maxupdate();

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

        // �}�X�^�f�[�^1�̍폜
        manager.deleteMasterDataByCondition(masterDataCondition1);

        if (_vo1.getMasterData() != null) {
            // �}�X�^�f�[�^1�̕ҏW
            List<MasterDataInsertVO> insertVOList1 = new ArrayList<MasterDataInsertVO>();
            insertVOList1 = editMasterDataInsertVO(_vo1, masterKindList1.get(0), masterResult1.getMasterItem());

            // �}�X�^�f�[�^1�̓o�^
            manager.registerMaster(insertVOList1);
        }

        // �}�X�^�f�[�^2�̍폜
        manager.deleteMasterDataByCondition(masterDataCondition2);

        if (_vo2.getMasterData() != null) {
            // �}�X�^�f�[�^2�̕ҏW
            List<MasterDataInsertVO> insertVOList2 = new ArrayList<MasterDataInsertVO>();
            insertVOList2 = editMasterDataInsertVO(_vo2, masterKindList2.get(0), masterResult2.getMasterItem());

            // �}�X�^�f�[�^2�̓o�^
            manager.registerMaster(insertVOList2);
        }

        // ����I��
        getResult().set(RESULT_KEY, new MasterRegisterResult());
    }

    /**
     * �}�X�^�f�[�^�o�^VO�̐ݒ�
     *
     * @param vo1 �}�X�^�f�[�^�o�^VO
     * @param vo2 �}�X�^�f�[�^�o�^VO
     */
    public void setMasterTablesRegisterVO(MasterRegisterVO vo1, MasterRegisterVO vo2) {
        _vo1 = vo1;
        _vo2 = vo2;
    }

    /**
     * ���s���ʂ�Ԃ��܂��B
     *
     * @return ���s����
     */
    public MasterRegisterResult getMasterRegisterResult() {
        return (MasterRegisterResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * �p�����[�^���̓`�F�b�N
     *
     * @param vo �}�X�^�f�[�^�o�^VO
     * @throws KKHException �p�����[�^�w��G���[�̏ꍇ
     */
    private void checkInput(MasterRegisterVO vo) throws KKHException {

        //�p�����[�^�̕K�{�`�F�b�N
        if (StringUtil.isBlank(vo.getEsqId())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getAplId())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getEgCd())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getTksKgyCd())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getTksBmnSeqNo())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getTksTntSeqNo())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getMasterKey())) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        try {
            if (vo.getMasterData() == null && vo.get_maxupdate() == DateFormat.getDateInstance().parse("1000/01/01 01:01:01")) {
                throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
            }
        } catch (ParseException e) {
            // TODO �����������ꂽ catch �u���b�N
            e.printStackTrace();
        }
    }

    /**
     * �}�X�^��`�擾�����̐ݒ�
     *
     * @param cond �}�X�^��`�擾����
     * @param masterRegisterVO �}�X�^�f�[�^�o�^�����pVO
     */
    private void setMasterCondition(MasterCondition cond, MasterRegisterVO masterRegisterVO) {

        cond.setEsqId(masterRegisterVO.getEsqId());
        cond.setEgCd(masterRegisterVO.getEgCd());
        cond.setTksKgyCd(masterRegisterVO.getTksKgyCd());
        cond.setTksBmnSeqNo(masterRegisterVO.getTksBmnSeqNo());
        cond.setTksTntSeqNo(masterRegisterVO.getTksTntSeqNo());
        cond.setMasterKey(masterRegisterVO.getMasterKey());
    }

    /**
     * �}�X�^�f�[�^�擾�E�폜�����̐ݒ�
     *
     * @param cond �}�X�^�f�[�^�擾�E�폜����
     * @param masterRegisterVO �}�X�^�f�[�^�o�^�����pVO
     * @param masterKindVO �}�X�^��ސݒ�VO
     */
    private void setMasterDataCondition(MasterCondition cond, MasterRegisterVO masterRegisterVO,MasterVO masterKindVO) {

        cond.setEgCd(masterRegisterVO.getEgCd());
        cond.setTksKgyCd(masterRegisterVO.getTksKgyCd());
        cond.setTksBmnSeqNo(masterRegisterVO.getTksBmnSeqNo());
        cond.setTksTntSeqNo(masterRegisterVO.getTksTntSeqNo());
        cond.setSybt(masterKindVO.getField2());
        if (StringUtil.isBlank(masterKindVO.getField5()) == false) {
            cond.setFilterKey(masterKindVO.getField5());
        }
        if (StringUtil.isBlank(masterRegisterVO.getFilterValue()) == false) {
            cond.setFilterValue(masterRegisterVO.getFilterValue());
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
     * �}�X�^�f�[�^�̕ҏW
     *
     * @param masterRegisterVO �}�X�^�f�[�^�o�^�����pVO
     * @param masterKindVO �}�X�^��ސݒ�VO
     * @param itemList �}�X�^����VO���X�g
     * @return �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     */
    private List<MasterDataInsertVO> editMasterDataInsertVO(MasterRegisterVO masterRegisterVO, MasterVO masterKindVO,
            List<MasterVO> masterItemList) {

        List<MasterDataInsertVO> insertVOList = new ArrayList<MasterDataInsertVO>();

        // ���ڒ�`�̃t�B�[���h��ݒ�
        List<String> itemList = new ArrayList<String>();
        for (MasterVO masterItem : masterItemList) {
            itemList.add(StringUtils.trimWhitespace(masterItem.getField4()));
        }

        // �}�X�^���R�[�h�������[�v
        for (MasterDataVO masterDataVO : masterRegisterVO.getMasterData()) {
            MasterDataInsertVO insertVO = new MasterDataInsertVO();
            // ���ʍ���
            insertVO.setTrkPl(masterRegisterVO.getAplId());
            insertVO.setTrkTnt(masterRegisterVO.getEsqId());
            insertVO.setUpdaPl(masterRegisterVO.getAplId());
            insertVO.setUpdTnt(masterRegisterVO.getEsqId());
            insertVO.setEgCd(masterRegisterVO.getEgCd());
            insertVO.setTksKgyCd(masterRegisterVO.getTksKgyCd());
            insertVO.setTksBmnSeqNo(masterRegisterVO.getTksBmnSeqNo());
            insertVO.setTksTntSeqNo(masterRegisterVO.getTksTntSeqNo());
            insertVO.setSybt(masterKindVO.getField2());

            // ���ڒ�`�̌������A�J��Ԃ�
            for (int i = 0; i < itemList.size(); i++) {
                String item = itemList.get(i);
                if ("FIELD1".equals(item)) {
                    insertVO.setField1(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD2".equals(item)) {
                    insertVO.setField2(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD3".equals(item)) {
                    insertVO.setField3(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD4".equals(item)) {
                    insertVO.setField4(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD5".equals(item)) {
                    insertVO.setField5(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD6".equals(item)) {
                    insertVO.setField6(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD7".equals(item)) {
                    insertVO.setField7(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD8".equals(item)) {
                    insertVO.setField8(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD9".equals(item)) {
                    insertVO.setField9(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD10".equals(item)) {
                    insertVO.setField10(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD11".equals(item)) {
                    insertVO.setField11(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD12".equals(item)) {
                    insertVO.setField12(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD13".equals(item)) {
                    insertVO.setField13(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD14".equals(item)) {
                    insertVO.setField14(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD15".equals(item)) {
                    insertVO.setField15(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD16".equals(item)) {
                    insertVO.setField16(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD17".equals(item)) {
                    insertVO.setField17(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD18".equals(item)) {
                    insertVO.setField18(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD19".equals(item)) {
                    insertVO.setField19(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD20".equals(item)) {
                    insertVO.setField20(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("INTVALUE1".equals(item)) {
                    insertVO.setIntValue1(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE2".equals(item)) {
                    insertVO.setIntValue2(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE3".equals(item)) {
                    insertVO.setIntValue3(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE4".equals(item)) {
                    insertVO.setIntValue4(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE5".equals(item)) {
                    insertVO.setIntValue5(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE6".equals(item)) {
                    insertVO.setIntValue6(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE7".equals(item)) {
                    insertVO.setIntValue7(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE8".equals(item)) {
                    insertVO.setIntValue8(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE9".equals(item)) {
                    insertVO.setIntValue9(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE10".equals(item)) {
                    insertVO.setIntValue10(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                }
            }

            insertVOList.add(insertVO);
        }

        return insertVOList;
    }

    /**
     * �Ώۗ�f�[�^�̎擾
     *
     * @param masterDataVO �}�X�^�f�[�^VO
     * @param columnIndex ��
     */
    private String getSubjectColumnData(MasterDataVO masterDataVO, int columnIndex) {

        String subjectColumnData = null;
        switch (columnIndex) {
        case 1:
            subjectColumnData = masterDataVO.getColumn1();
            break;
        case 2:
            subjectColumnData = masterDataVO.getColumn2();
            break;
        case 3:
            subjectColumnData = masterDataVO.getColumn3();
            break;
        case 4:
            subjectColumnData = masterDataVO.getColumn4();
            break;
        case 5:
            subjectColumnData = masterDataVO.getColumn5();
            break;
        case 6:
            subjectColumnData = masterDataVO.getColumn6();
            break;
        case 7:
            subjectColumnData = masterDataVO.getColumn7();
            break;
        case 8:
            subjectColumnData = masterDataVO.getColumn8();
            break;
        case 9:
            subjectColumnData = masterDataVO.getColumn9();
            break;
        case 10:
            subjectColumnData = masterDataVO.getColumn10();
            break;
        case 11:
            subjectColumnData = masterDataVO.getColumn11();
            break;
        case 12:
            subjectColumnData = masterDataVO.getColumn12();
            break;
        case 13:
            subjectColumnData = masterDataVO.getColumn13();
            break;
        case 14:
            subjectColumnData = masterDataVO.getColumn14();
            break;
        case 15:
            subjectColumnData = masterDataVO.getColumn15();
            break;
        case 16:
            subjectColumnData = masterDataVO.getColumn16();
            break;
        case 17:
            subjectColumnData = masterDataVO.getColumn17();
            break;
        case 18:
            subjectColumnData = masterDataVO.getColumn18();
            break;
        case 19:
            subjectColumnData = masterDataVO.getColumn19();
            break;
        case 20:
            subjectColumnData = masterDataVO.getColumn20();
            break;
        case 21:
            subjectColumnData = masterDataVO.getColumn21();
            break;
        case 22:
            subjectColumnData = masterDataVO.getColumn22();
            break;
        case 23:
            subjectColumnData = masterDataVO.getColumn23();
            break;
        case 24:
            subjectColumnData = masterDataVO.getColumn24();
            break;
        case 25:
            subjectColumnData = masterDataVO.getColumn25();
            break;
        case 26:
            subjectColumnData = masterDataVO.getColumn26();
            break;
        case 27:
            subjectColumnData = masterDataVO.getColumn27();
            break;
        case 28:
            subjectColumnData = masterDataVO.getColumn28();
            break;
        case 29:
            subjectColumnData = masterDataVO.getColumn29();
            break;
        case 30:
            subjectColumnData = masterDataVO.getColumn30();
            break;
        default:
            subjectColumnData = null;
        }

        return subjectColumnData;
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
