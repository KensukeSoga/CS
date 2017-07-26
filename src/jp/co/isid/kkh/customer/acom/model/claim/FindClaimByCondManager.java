package jp.co.isid.kkh.customer.acom.model.claim;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;
import jp.co.isid.kkh.model.master.MasterItemDAO;
import jp.co.isid.kkh.model.master.MasterItemDAOFactory;
import jp.co.isid.kkh.model.master.MasterVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.model.ModelUtils;

public class FindClaimByCondManager {

    /** �ėp�}�X�^�F��ʁF�V�� */
    static final String C_BAITAI_SHINBUN = "21";
    /** �ėp�}�X�^�F��ʁF�G�� */
    static final String C_BAITAI_ZASHI = "22";
    /** �ėp�}�X�^�F��ʁF�d�g */
    static final String C_BAITAI_DENPA = "11";
    /** �ėp�}�X�^�F��ʁF�L�� */
    static final String C_BAITAI_KOTSU = "31";

    /** ���_S */
    private static final String C_SYBT_S = "S";
    /** ���_T */
    private static final String C_SYBT_T = "T";
    /** �ԑg�� */
    private static final int C_BNGN_COUNT = 4;
    /** �z��v�f�� */
    private static final int C_ARRAY_COUNT = 31;

    /* 2015/01/05 �A�R������őΉ� HLC fujimoto ADD start */
    /** ���(����Œ[�������敪) */
    private static final String C_SYBT_TAXROUNDING = "201";

    /** �l�̌ܓ� */
    private static final String C_TAX_ROUND = "01";
    /** �؂�̂� */
    private static final String C_TAX_ROUNDDOWN = "02";
    /** �؂�グ */
    private static final String C_TAX_ROUNDUP = "03";

    private static final String C_TAX_FILTERVALUE = "01";
    /* 2015/01/05 �A�R������őΉ� HLC fujimoto ADD end */

    /** �V���O���g���C���X�^���X */
    private static FindClaimByCondManager _manager = new FindClaimByCondManager();

    /** �������� */
    private FindClaimCondition _lCond = new FindClaimCondition();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FindClaimByCondManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindClaimByCondManager getInstance() {
        return _manager;
    }

    /**
     * ����/�����ԍ� �ꗗ�����������܂��B
     *
     * @return FindClaimByCondResult �����f�[�^���
     * @throws KKHException
     *         �������ɃG���[�����������ꍇ
     */
    public FindClaimByCondResult findClaimByCondition(FindClaimCondition cond)
        throws KKHException {

        // �p�����[�^�̕K�{�`�F�b�N
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getYymm() == null || cond.getYymm().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        // ��������
        FindClaimByCondResult result = new FindClaimByCondResult();

        // �f�[�^�擾DAO�̃C���X�^���X����
        FindClaimByCondDAO dao = FindClaimByCondDAOFactory.createFindKenMeisaiByCondDAO();
        _lCond = cond;

        // ======================================================
        //  ����/�����ԍ� �ꗗ���
        // ======================================================
        // �f�[�^�擾
        List<FindClaimNoCondVO> claimNoList = dao.findClaimNoDataByCondition(_lCond);
        if (claimNoList.size() == 0) {
            return result;
        }
        // �f�[�^�ҏW
        List<FindClaimNoCondResultVO> claimNoResultList = this.editClaimNoDataList(claimNoList);


        // ======================================================
        //  �����f�[�^ �ꗗ���
        // ======================================================
        // �f�[�^�擾
        List<FindClaimCondVO> claimList = dao.findClaimDataByCondition(_lCond);
        if (claimNoList.size() == 0) {
            return result;
        }
        // �f�[�^�ҏW
        List<FindClaimCondResultVO> claimResultList =this.editClaimDataList(claimList, true, true);


        // ======================================================
        //  ����/���� ���وꗗ���
        // ======================================================
        // ���u�����f�[�^ �ꗗ���v�A�u ����/���� ���وꗗ���v����ɏo�͂���
        // �f�[�^�擾
        List<FindClaimDiffCondVO> claimDiffList = dao.findClaimDiffDataByCondition(_lCond);
        if (claimNoList.size() == 0) {
            return result;
        }
        // �f�[�^�ҏW�i�����f�[�^ �ꗗ���j
        List<FindClaimCondResultVO>  claimResultList2 =this.editClaimDataList(claimList, false, false);
        // �f�[�^�ҏW�i����/���� ���وꗗ���j
        List<FindClaimDiffCondResultVO> claimDiffResultList = this.editClaimDiffDataList(claimDiffList, claimResultList2, cond.getYymm());


        // �T�C�Y�O�̃��X�g�����݂���ꍇ�́A��̃��X�g��ԋp����
        if (claimNoResultList.size() == 0 ||
            claimResultList.size() == 0 ||
            claimDiffResultList.size() == 0) {

            result.setClaimNoDataList(new ArrayList<FindClaimNoCondResultVO>());
            result.setClaimDataList(new ArrayList<FindClaimCondResultVO>());
            result.setClaimDiffDataList(new ArrayList<FindClaimDiffCondResultVO>());

        } else {

            result.setClaimNoDataList(claimNoResultList);
            result.setClaimDataList(claimResultList);
            result.setClaimDiffDataList(claimDiffResultList);

        }

        return result;
    }

    /**
     * ����/�����ԍ� �ꗗ���̕ҏW���s��
     *
     * @param list ����/�����ԍ� �ꗗ�����܂�VO���X�g
     * @return     ����/�����ԍ� �ꗗ���i�ԋp�p�j���܂�VO���X�g
     */
    private List<FindClaimNoCondResultVO> editClaimNoDataList(List<FindClaimNoCondVO> list) {

        List<FindClaimNoCondResultVO> retList = new ArrayList<FindClaimNoCondResultVO>();
        FindClaimNoCondResultVO outVo = null;            // �ԋp�pVO�i�ԋp�p�̏���ێ�����j
        FindClaimNoCondVO result = null;                 // �ێ��pVO�iSQL�Ŏ擾��������ێ�����j
        FindClaimNoCondVO saveVo = null;                 // ��r�pVO�i�P�O�̏���ێ�����j
        StringBuffer renban = new StringBuffer();        // �A��
        String shoriKbn = "";                            // �����敪
        String shoriKbnComp = "";                        // �����敪��r�p
        String shoriKbnNm = "";                          // �����敪��
        String outSelect = "False";                      // �o�͑I��

        for (int i = 0; i < list.size(); i++) {

            result = (FindClaimNoCondVO) list.get(i);    // �ێ��pVO�iSQL�Ŏ擾��������ێ�����j

            if (saveVo != null) {

                // �˗��ԍ��i�����ԍ��j�A�������ԍ����ύX�����ꍇ
                if (!saveVo.getIraiNo().trim().equals(result.getIraiNo().trim()) ||
                    !saveVo.getSeiNo().trim().equals(result.getSeiNo().trim())) {

                    outVo = new FindClaimNoCondResultVO();            // VO�i�ԋp�p�j
                    outVo.setShoriKbn(shoriKbnNm);                    // �����敪
                    outVo.setOutSelect(outSelect);                    // �o�͑I��
                    outVo.setIraiNo(saveVo.getIraiNo().trim());       // �˗��ԍ��i�����ԍ��j
                    outVo.setSeiNo(saveVo.getSeiNo().trim());         // �������ԍ�
                    outVo.setSeiYymm(saveVo.getSeiYymm().trim());     // ���������s��
                    outVo.setKenmei(saveVo.getKenmei().trim());       // ����
                    outVo.setBaitaiCd(saveVo.getBaitaiCd().trim());   // �}�̃R�[�h
                    outVo.setOutDate(saveVo.getOutDate().trim());     // ���s����
                    outVo.setJyutNo(saveVo.getJyutNo().trim());       // ��No
                    outVo.setJymeiNo(saveVo.getJymeiNo().trim());     // �󒍖���No
                    outVo.setUrmeiNo(saveVo.getUrmeiNo().trim());     // ���㖾��No
                    outVo.setRenBan(renban.toString());               // �A��

                    ModelUtils.copyMemberSearchAfterInstace(outVo);
                    retList.add(outVo);

                    // �A�ԏ�����
                    renban = new StringBuffer();
                    renban.append("'" + result.getRenBan().trim() + "'");
                    // �����敪������
                    shoriKbn = result.getShoriKbn();
                    shoriKbnComp = result.getShoriKbn();
                }
            }

            if (i == 0) {
                shoriKbn = result.getShoriKbn();
            }

            // �A��
            if ("".equals(renban.toString())) {
                renban.append("'" + result.getRenBan().trim() + "'");
            } else {
                renban.append(",'" + result.getRenBan().trim() + "'");
            }

            // �����敪
            shoriKbnComp = result.getShoriKbn();
            if (shoriKbn.equals(shoriKbnComp)) {

                if ("".equals(shoriKbn.trim())) {
                    // �󕶎��̏ꍇ�u���o�́v
                    shoriKbnNm = "���o��";

                } else if ("1".equals(shoriKbn.trim())) {
                    // "1"�̏ꍇ�u�����M�v
                    shoriKbnNm = "�����M";

                } else {
                    // ��L�ȊO�̏ꍇ�u�o�͍ρv
                    shoriKbnNm = "���M��";
                }

            } else {
                // �u�ꕔ�o�͍ρv
                shoriKbnNm = "�ꕔ�o�͍�";
            }

            // �ЂƂO�̏���ێ�����
            saveVo = result;
        }

        // �ŏI���R�[�h���o��
        outVo = new FindClaimNoCondResultVO();            // VO�i�ԋp�p�j
        outVo.setShoriKbn(shoriKbnNm);                    // �����敪
        outVo.setOutSelect(outSelect);                    // �o�͑I��
        outVo.setIraiNo(saveVo.getIraiNo().trim());       // �˗��ԍ��i�����ԍ��j
        outVo.setSeiNo(saveVo.getSeiNo().trim());         // �������ԍ�
        outVo.setSeiYymm(saveVo.getSeiYymm().trim());     // ���������s��
        outVo.setKenmei(saveVo.getKenmei().trim());       // ����
        outVo.setBaitaiCd(saveVo.getBaitaiCd().trim());   // �}�̃R�[�h
        outVo.setOutDate(saveVo.getOutDate().trim());     // ���s����
        outVo.setJyutNo(saveVo.getJyutNo().trim());       // ��No
        outVo.setJymeiNo(saveVo.getJymeiNo().trim());     // �󒍖���No
        outVo.setUrmeiNo(saveVo.getUrmeiNo().trim());     // ���㖾��No
        outVo.setRenBan(renban.toString());               // �A��

        ModelUtils.copyMemberSearchAfterInstace(outVo);
        retList.add(outVo);

        return retList;
    }

    /**
     * �����f�[�^ �ꗗ���̕ҏW���s��
     *
     * @param list      �����f�[�^ �ꗗ�����܂�VO���X�g
     * @param goukeiFlg ���v�s�o�͉ۃt���O  true�F�o�͂���^false�F�o�͂��Ȃ�
     * @param nebiFlg   �l���s�o�͉ۃt���O  true�F�o�͂���^false�F�o�͂��Ȃ�
     * @return          �����f�[�^ �ꗗ���i�ԋp�p�j���܂�VO���X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private List<FindClaimCondResultVO> editClaimDataList(List<FindClaimCondVO> list, boolean goukeiFlg, boolean nebiFlg) throws KKHException {

        List<FindClaimCondResultVO> retList = new ArrayList<FindClaimCondResultVO>();
        FindClaimCondVO result = null;                              // �ێ��pVO�iSQL�Ŏ擾��������ێ�����j
        FindClaimCondResultVO outVo = null;                         // �ԋp�pVO�i�ԋp�p�̏���ێ�����j
        FindClaimCondVO saveVo = null;                              // ��r�pVO�i�P�O�̏���ێ�����j

        int keisaiCnt = 0;                                          // �f�ړ��p�J�E���^
        int bngmCnt = 0;                                            // �ԑg�p�J�E���^
        String jyutNo = "";                                         // ��No
        String jymeiNo = "";                                        // �󒍖���No
        String urmeiNo = "";                                        // ���㖾��No
        String renban = "";                                         // �A��

        BigDecimal kngk = BigDecimal.ZERO;                          // ���z
        BigDecimal ritu = BigDecimal.ZERO;                          // ����ŗ�
        BigDecimal syohizei = BigDecimal.ZERO;                      // ����Ŋz
        BigDecimal kngkRow = BigDecimal.ZERO;                       // �s�P�ʂ̋��z
        BigDecimal syohizeiRow = BigDecimal.ZERO;                   // �s�P�ʂ̏����
        BigDecimal kngkSum = BigDecimal.ZERO;                       // ���z�̍��v
        BigDecimal syohizeiSum = BigDecimal.ZERO;                   // ����Ŋz�̍��v

        String[] cmList = new String[C_BNGN_COUNT];                 // CM�b���ێ��p���X�g
        String[] nameList = new String[C_BNGN_COUNT];               // ���e���̕ێ��p���X�g
        String[] bngmList = new String[C_BNGN_COUNT];               // �ԑg���ێ��p���X�g
        String[] keisaiDayList = new String[C_ARRAY_COUNT];         // �f�ړ��i�������j�ێ��p���X�g
        String[] kingakUwList = new String[C_ARRAY_COUNT];          // ���z����i�V���^�G���j�ێ��p���X�g
        String[] syohizeiUwList = new String[C_ARRAY_COUNT];        // ����œ���i�V���^�G���j�ێ��p���X�g
        String[] nebiGakUwList = new String[C_ARRAY_COUNT];         // �l���z����i�V���^�G���j�ێ��p���X�g
        String keitaiKbnCd = new String();                          // �`�ԋ敪�R�[�h
        String keitaiKbnNm = new String();                          // �`�ԋ敪����
        String bikou1 = new String();                               // ���l�P
        String bikou2 = new String();                               // ���l�Q
        List<String> kbnList = new ArrayList<String>();             // �敪���X�g

        // �ԑg���ێ��p�z��̏�����
        for (int i = 0; i < C_BNGN_COUNT; i++) {
            cmList[i] = "";
            nameList[i] = "";
            bngmList[i] = "";
        }

        // �z��̏�����
        for (int i = 0; i < C_ARRAY_COUNT; i++) {
            keisaiDayList[i] = " ";
            kingakUwList[i] = "0";
            syohizeiUwList[i] = "0";
            nebiGakUwList[i] = "0";
        }

        /* 2015/01/05 �A�R������őΉ� HLC fujimoto ADD start */
        //����Œ[�������敪�擾
        String taxRounding = "";
        MasterItemDAO masterItemDao = MasterItemDAOFactory.createMasterItemDAO();
        MasterCondition masterCond = new MasterCondition();
        masterCond.setEgCd(_lCond.getEgCd());
        masterCond.setEsqId(_lCond.getEsqId());
        masterCond.setTksKgyCd(_lCond.getTksKgyCd());
        masterCond.setTksBmnSeqNo(_lCond.getTksBmnSeqNo());
        masterCond.setTksTntSeqNo(_lCond.getTksTntSeqNo());
        masterCond.setSybt(C_SYBT_TAXROUNDING);
        masterCond.setFilterValue(C_TAX_FILTERVALUE);

        try {
            List<MasterVO> masterVoList = masterItemDao.findMasterKindByCondition(masterCond);

            if (masterVoList.size() == 0) {
                return retList;
            }

        /* 2015/01/29 �A�R������őΉ� soga MOD end */
//            taxRounding = masterVoList.get(0).getField1();
            taxRounding = masterVoList.get(0).getField2();
        /* 2015/01/29 �A�R������őΉ� soga MOD end */

        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "KV-E0001");
        }
        /* 2015/01/05 �A�R������őΉ� HLC fujimoto MOD end */

        // �����f�[�^ �ꗗ��񕪏������J��Ԃ�
        for (int i = 0; i < list.size(); i++) {

            result = (FindClaimCondVO) list.get(i);

            // �l���s�t���O��false�ŁA
            if (nebiFlg == false) {
                // �l���s�敪���u0�v�ȊO�̏ꍇ�́A
                if (!result.getNebiKbn().trim().equals("0")) {
                    // �o�͂��Ȃ�
                    continue;
                }
            }
            // �擪���R�[�h�A�܂��͉��L���ڂ��L�[�u���C�N�����ꍇ
            //  1. �����N����
            //  2. �x����
            //  3. �}�̃R�[�h
            //  4. ���f�B�A�R�[�h
            //  5. �˗��ԍ��i�����ԍ��j
            //  6. �˗��s�ԍ��i�����s�ԍ��j
            //  7. ���������R�[�h
            //  8. ��Ж�
            //  9. �������ԍ�
            // 10. �������s�ԍ�
            // 11. ���i�敪
            // 12. �X��
            // 13. �����R�[�h
            // 14. �����
            // 15. �敪
            if (saveVo == null ||
                (saveVo.getSeiYymm().trim().equals(result.getSeiYymm().trim())     &&
                 saveVo.getPayDay().trim().equals(result.getPayDay().trim())       &&
                 saveVo.getBaitaiCd().trim().equals(result.getBaitaiCd().trim())   &&
                 saveVo.getMediaCd().trim().equals(result.getMediaCd().trim())     &&
                 saveVo.getIraiNo().trim().equals(result.getIraiNo().trim())       &&
                 saveVo.getIraiGyoNo().trim().equals(result.getIraiGyoNo().trim()) &&
                 saveVo.getSeibuCd().trim().equals(result.getSeibuCd().trim())     &&
                 saveVo.getKaiNm().trim().equals(result.getKaiNm().trim())         &&
                 saveVo.getSeiNo().trim().equals(result.getSeiNo().trim())         &&
                 saveVo.getSeiGyoNo().trim().equals(result.getSeiGyoNo().trim())   &&
                 saveVo.getSyohinKbn().trim().equals(result.getSyohinKbn().trim()) &&
                 saveVo.getTenBan().trim().equals(result.getTenBan().trim())       &&
                 saveVo.getToriCd().trim().equals(result.getToriCd().trim())       &&
                 saveVo.getAnbunSybt().trim().equals(result.getAnbunSybt().trim()) &&
                 saveVo.getKbn().trim().equals(result.getKbn().trim()))) {

            } else {

                // �������ԍ��A�����ԍ��������ꍇ
                if (saveVo.getSeiNo().trim().equals(result.getSeiNo().trim()) &&
                    saveVo.getIraiNo().trim().equals(result.getIraiNo().trim()) ) {

                    // ���׍s�o�� =====================================================================================
                    outVo = this.setMeisai(saveVo
                                          , kngkRow
                                          , syohizeiRow
                                          , jyutNo
                                          , jymeiNo
                                          , urmeiNo
                                          , renban
                                          , cmList
                                          , nameList
                                          , bngmList
                                          , keisaiDayList
                                          , kingakUwList
                                          , syohizeiUwList
                                          , nebiGakUwList
                                          , kbnList
                                          , keitaiKbnCd
                                          , keitaiKbnNm
                                          , bikou1
                                          , bikou2);

                    ModelUtils.copyMemberSearchAfterInstace(outVo);
                    retList.add(outVo);

                    // ���z���ڂ̏�����
                    kngk = BigDecimal.ZERO;
                    ritu = BigDecimal.ZERO;
                    syohizei = BigDecimal.ZERO;
                    kngkRow = BigDecimal.ZERO;
                    syohizeiRow = BigDecimal.ZERO;

                // �������ԍ��A�܂��͔����ԍ����قȂ�ꍇ
                } else {

                    // ���׍s�o�� =====================================================================================
                    outVo = this.setMeisai(saveVo
                                         , kngkRow
                                         , syohizeiRow
                                         , jyutNo
                                         , jymeiNo
                                         , urmeiNo
                                         , renban
                                         , cmList
                                         , nameList
                                         , bngmList
                                         , keisaiDayList
                                         , kingakUwList
                                         , syohizeiUwList
                                         , nebiGakUwList
                                         , kbnList
                                         , keitaiKbnCd
                                         , keitaiKbnNm
                                         , bikou1
                                         , bikou2);

                    ModelUtils.copyMemberSearchAfterInstace(outVo);
                    retList.add(outVo);

                    if (goukeiFlg) {
                        // ���v�s�o�� =====================================================================================
                        outVo = this.setGoukei(saveVo, kngkSum, syohizeiSum);
                        ModelUtils.copyMemberSearchAfterInstace(outVo);
                        retList.add(outVo);
                    }

                    // ���z���ڂ̏�����
                    kngk = BigDecimal.ZERO;
                    ritu = BigDecimal.ZERO;
                    syohizei = BigDecimal.ZERO;
                    kngkRow = BigDecimal.ZERO;
                    syohizeiRow = BigDecimal.ZERO;
                    kngkSum = BigDecimal.ZERO;
                    syohizeiSum = BigDecimal.ZERO;
                }

                // �ԑg���ێ��p�z��̏�����
                for (int j = 0; j < C_BNGN_COUNT; j++) {
                    cmList[j] = "";
                    nameList[j] = "";
                    bngmList[j] = "";
                }

                // �z��̏�����
                for (int j = 0; j < C_ARRAY_COUNT; j++) {
                    keisaiDayList[j] = " ";
                    kingakUwList[j] = "0";
                    syohizeiUwList[j] = "0";
                    nebiGakUwList[j] = "0";
                }

                // ��No�̏�����
                jyutNo = "";
                // �󒍖���No�̏�����
                jymeiNo = "";
                // ���㖾��No�̏�����
                urmeiNo = "";
                // �A�Ԃ̏�����
                renban = "";

                // �敪���X�g�̏�����
                kbnList = new ArrayList<String>();

                // �f�ړ��p�J�E���^�̏�����
                keisaiCnt = 0;

                // �ԑg�p�J�E���^�̏�����
                bngmCnt = 0;
            }

            // �P�O�̏���ێ�����
            saveVo = result;

            // ���z�v�Z ---------------------------------------------------------------------------
            kngk = BigDecimal.ZERO;
            kngk = kngk.add(result.getKingaku().add(result.getNebiGaku()));         // ���z
            ritu = result.getSyohiRitu();                                           // ����ŗ�
            syohizei = this.getSyohizei(kngk, ritu, taxRounding);                   // ����Ŋz

            kngkRow = kngkRow.add(kngk);                                            // �s�P�ʂ̋��z
            syohizeiRow = syohizeiRow.add(syohizei);                                // �s�P�ʂ̏���Ŋz

            kngkSum = kngkSum.add(kngk);                                            // ���z�̍��v
            syohizeiSum = this.getSyohizei(kngkSum, ritu, taxRounding);             // ����Ŋz�̍��v

            // ��ʁu21:�V���v�̏ꍇ�A���L���ڂɒl��ǉ����� ---------------------------------------
            if (C_BAITAI_SHINBUN.equals(result.getBaitaiCd().trim())) {

                String keisaiDay = result.getKeisaiDay().trim();

                if (!keisaiDay.equals("")) {
                    int count = Integer.valueOf(keisaiDay.substring(keisaiDay.length() - 2, keisaiDay.length())) - 1;

                    keisaiDayList[count] = "1";                                         // �f�ړ�
                    kingakUwList[count] += String.valueOf(kngk);                        // ���z����
                    syohizeiUwList[count] = String.valueOf(syohizei);                   // ����œ���

                    try {
                        Integer.parseInt(result.getJyutNo());
                        nebiGakUwList[count] = String.valueOf(result.getNebiGaku());    // �l���z����
                    } catch(NumberFormatException e) {
                        // �V�K�쐬�̎��i��NO�����l�ȊO�j�́A�l���z�𔄏㍂����t�Z����
                        nebiGakUwList[count] = String.valueOf( this.getNebiGak(keisaiDay, result.getMediaCd(), result.getNebiGaku(), kngk) );
                    }
                }
            }
            // ��ʁu22�F�G���v�A�u31�F��ʁv�̏ꍇ�A���L���ڂɒl��ǉ����� ------------------------
            else if (C_BAITAI_ZASHI.equals(result.getBaitaiCd().trim()) ||
                     C_BAITAI_KOTSU.equals(result.getBaitaiCd().trim())) {

                String keisaiDay = result.getKeisaiDay().trim();

                if (!keisaiDay.equals("")) {
                    keisaiDayList[keisaiCnt] = keisaiDay;                                   // �f�ړ�
                    kingakUwList[keisaiCnt] += String.valueOf(result.getKingaku());         // ���z����
                    syohizeiUwList[keisaiCnt] = String.valueOf(result.getShohiZei());       // ����œ���

                    try {
                        Integer.parseInt(result.getJyutNo());
                        nebiGakUwList[keisaiCnt] = String.valueOf(result.getNebiGaku());    // �l���z����
                    } catch(NumberFormatException e) {
                        // �V�K�쐬�̎��i��NO�����l�ȊO�j�́A�l���z�𔄏㍂����t�Z����
                        nebiGakUwList[keisaiCnt] = String.valueOf( this.getNebiGak(keisaiDay, result.getMediaCd(), result.getNebiGaku(), result.getKingaku()) );
                    }
                }
            }
            // ��ʁu11:�d�g�v�̏ꍇ�A���L���ڂɒl��ǉ����� ---------------------------------------
            else if (C_BAITAI_DENPA.equals(result.getBaitaiCd().trim())) {

                // ���ꐿ���ԍ��E�����ԍ��E�����s�ԍ���5���ȏ�̖��ׂ�����ꍇ�̓G���[
                if (bngmCnt >= 4) {
                    throw new KKHException("�d�g�f�[�^�̖��׌����G���[", "HB-W0144");
                }

                cmList[bngmCnt] = result.getName13().trim();                                // CM�b����n
                nameList[bngmCnt] = result.getName14().trim();                              // ���e��n
                bngmList[bngmCnt] = result.getName15().trim();                              // �ԑg��n

                if( bngmCnt == 0)
                {
                    // ��s�ڂ̔��l��ۑ�
                    keitaiKbnCd = result.getName11().trim();                                // �`�ԋ敪�R�[�h
                    keitaiKbnNm = result.getName12().trim();                                // �`�ԋ敪����
                    bikou1 = result.getName16().trim();                                     // ���l�P
                    bikou2 = result.getName17().trim();                                     // ���l�Q
                }
            }

            // ��No -----------------------------------------------------------------------------
            if ("".equals(jyutNo)) {
                jyutNo = result.getJyutNo();
            } else {
                jyutNo += "," + result.getJyutNo();
            }
            // �󒍖���No -------------------------------------------------------------------------
            if ("".equals(jymeiNo)) {
                jymeiNo = result.getJymeiNo();
            } else {
                jymeiNo += "," + result.getJymeiNo();
            }
            // ���㖾��No -------------------------------------------------------------------------
            if ("".equals(urmeiNo)) {
                urmeiNo = result.getUrmeiNo();
            } else {
                urmeiNo += "," + result.getUrmeiNo();
            }
            // �A�� -------------------------------------------------------------------------------
            if ("".equals(renban)) {
                renban = result.getRenBan();
            } else {
                renban += "," + result.getRenBan();
            }
            // �敪 -------------------------------------------------------------------------------
            kbnList.add(result.getShoriKbn().trim());

            // �f�ړ��p�J�E���^ �{ 1
            keisaiCnt += 1;

            // �ԑg�p�J�E���^ �{ 1
            bngmCnt += 1;
        }

        // �ێ��pVO��null�ȊO�̏ꍇ�A�ŏI�s���o�͂���
        if (saveVo != null) {

            // ���׍s�o�� =====================================================================================
            outVo = this.setMeisai(saveVo
                                , kngkRow
                                , syohizeiRow
                                , jyutNo
                                , jymeiNo
                                , urmeiNo
                                , renban
                                , cmList
                                , nameList
                                , bngmList
                                , keisaiDayList
                                , kingakUwList
                                , syohizeiUwList
                                , nebiGakUwList
                                , kbnList
                                , keitaiKbnCd
                                , keitaiKbnNm
                                , bikou1
                                , bikou2);


            ModelUtils.copyMemberSearchAfterInstace(outVo);
            retList.add(outVo);

            // ���v�s�o�� =====================================================================================
            if (goukeiFlg) {
                outVo = this.setGoukei(saveVo, kngkSum, syohizeiSum);
                ModelUtils.copyMemberSearchAfterInstace(outVo);
                retList.add(outVo);
            }
        }

        return retList;
    }

    /**
     * ����Ŋz���v�Z���ԋp����
     *
     * @param kngk ���z
     * @param ritu ����ŗ�
     * @param taxRounding ����Œ[�������敪
     * @return ����Ŋz
     * @throws KKHException
     */
    private BigDecimal getSyohizei(BigDecimal kngk, BigDecimal ritu, String taxRounding) throws KKHException {

        BigDecimal ret = BigDecimal.ZERO;

        // ����Ŋz = ���z * ����ŗ� / 100
        ret = kngk.multiply(ritu).divide(new BigDecimal(100));

        /* 2015/01/05 �A�R������őΉ� HLC fujimoto MOD start */
//        if (ret.compareTo(BigDecimal.ZERO) > 0) {
//            ret.add(new BigDecimal(0.5));
//
//        } else if (ret.compareTo(BigDecimal.ZERO) < 0) {
//            ret.add(new BigDecimal(-0.5));
//
//        } else {
//            ret = new BigDecimal(0);
//        }

        if (taxRounding.equals(C_TAX_ROUND)) {
            ret = ret.setScale(0, BigDecimal.ROUND_HALF_UP);
        } else if (taxRounding.equals(C_TAX_ROUNDDOWN)) {
            ret = ret.setScale(0, BigDecimal.ROUND_DOWN);
        } else if (taxRounding.equals(C_TAX_ROUNDUP)) {
            ret = ret.setScale(0, BigDecimal.ROUND_UP);
        } else {
            return BigDecimal.ZERO;
        }
        /* 2015/01/05 �A�R������őΉ� HLC fujimoto MOD end */

        return ret;
    }

    /**
     * �����̏�����ɁA�����f�[�^ �ꗗ���VO��ݒ肷��i���׍s�f�[�^�j
     *
     * @param vo             �����f�[�^ �ꗗ���VO
     * @param kngk           ���z
     * @param syohizei       �����
     * @param jyutNo         ��No
     * @param jymeiNo        �󒍖���No
     * @param urmeiNo        ���㖾��No
     * @param renban         �A��
     * @param cmList         CM�b�������X�g
     * @param nameList       ���e���̃��X�g
     * @param bngmList       �ԑg�����X�g
     * @param keisaiDayList  �f�ړ����X�g
     * @param kingakUwList   ���z���󃊃X�g
     * @param syohizeiUwList ����œ��󃊃X�g
     * @param nebiGakUwList  �l���z���󃊃X�g
     * @param kbnList        �敪���X�g
     * @return               �����f�[�^ �ꗗ���VO�i�ԋp�p�j
     */
    private FindClaimCondResultVO setMeisai(FindClaimCondVO vo,
                                            BigDecimal kngk,
                                            BigDecimal syohizei,
                                            String jyutNo,
                                            String jymeiNo,
                                            String urmeiNo,
                                            String renban,
                                            String[] cmList,
                                            String[] nameList,
                                            String[] bngmList,
                                            String[] keisaiDayList,
                                            String[] kingakUwList,
                                            String[] syohizeiUwList,
                                            String[] nebiGakUwList,
                                            List<String> kbnList,
                                            String keitaiKbnCd,
                                            String keitaiKbnNm,
                                            String bikou1,
                                            String bikou2) {

        FindClaimCondResultVO retVo = new FindClaimCondResultVO();

        // ���׍s�o�� ============================================================================================================================
        retVo.setSybt(C_SYBT_S);                                            // ��� (����)
        retVo.setIraiNo(vo.getIraiNo());                                    // �˗��ԍ��i�����ԍ��j
        retVo.setIraiGyoNo(vo.getIraiGyoNo());                              // �˗��s�ԍ��i�����s�ԍ��j
        retVo.setToriCd(vo.getToriCd().trim());                             // �����R�[�h
        retVo.setKaiNm(vo.getKaiNm().trim());                               // ��Ж�
        retVo.setSeibuCd(vo.getSeibuCd().trim());                           // ���������R�[�h
        retVo.setSeiYymm(vo.getSeiYymm().trim());                           // �����N����
        retVo.setSeiNo(vo.getSeiNo().trim());                               // �������ԍ�
        retVo.setNaiyoKbn("2");                                             // ���e�敪 (2:����)
        retVo.setSeiGyoNo(vo.getSeiGyoNo().trim());                         // �������s�ԍ�
        retVo.setNebiKbn(vo.getNebiKbn().trim());                           // �l���s�敪
        retVo.setPayDay(vo.getPayDay().trim());                             // �x����
        retVo.setSyohinKbn(vo.getSyohinKbn().trim());                       // ���i�敪
        retVo.setSyohinKbnNm(vo.getSyohinKbnNm().trim());                   // ���i�敪����
        retVo.setSaimokuKbn(vo.getSaimokuKbn().trim());                     // �זڋ敪
        retVo.setTekiyoCd(vo.getTekiyoCd().trim());                         // �E�v�R�[�h
        retVo.setBaitaiCd(vo.getBaitaiCd().trim());                         // �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:���)
        retVo.setMediaCd(vo.getMediaCd().trim());                           // ���f�B�A�R�[�h
        retVo.setMediaNm(vo.getMediaNm().trim());                           // ���f�B�A��
        retVo.setTenBan(vo.getTenBan().trim());                             // �X��
        retVo.setKingak(kngk);                                              // ���z
        retVo.setSyohizei(syohizei);                                        // ����Ŋz
        retVo.setKingakSum(kngk.add(syohizei));                             // ���v���z (���z + �����)
        retVo.setAnbunSybt(vo.getAnbunSybt().trim());                       // �����
        retVo.setKbn(vo.getKbn().trim());                                   // �敪
        retVo.setNebiRitu(vo.getNebiRitu());                                // �l����
        retVo.setTouDate(vo.getTouDate().trim());                           // �o�^�N����
        retVo.setHenDate(vo.getHenDate().trim());                           // �ύX�N����
        retVo.setTorDate(vo.getTorDate().trim());                           // ����N����
        retVo.setOutDate(vo.getOutDate().trim());                           // �o�͓���
//        retVo.setJyutNo(vo.getJyutNo().trim());                             // ��No
//        retVo.setJymeiNo(vo.getJymeiNo().trim());                           // �󒍖���No
//        retVo.setUrmeiNo(vo.getUrmeiNo().trim());                           // ���㖾��No
        retVo.setJyutNo(jyutNo);                                            // ��No
        retVo.setJymeiNo(jymeiNo);                                          // �󒍖���No
        retVo.setUrmeiNo(urmeiNo);                                          // ���㖾��No
        retVo.setRenBan(renban);                                            // �A��
        retVo.setKenmei(vo.getKenmei());                                    // ����
        retVo.setNebiGak(vo.getNebiGaku());                                 // �l���z
        retVo.setSyohizeiRitu(vo.getSyohiRitu());                           // ����ŗ�

        String iraiNo = vo.getIraiNo();
        if (iraiNo.equals("")) {
            iraiNo = "ZZZZZZZZ";
        }

        String iraiGyoNo = vo.getIraiGyoNo();
        if (iraiGyoNo.equals("")) {
            iraiGyoNo = "ZZZ";
        }

        String seiNo = vo.getSeiNo();
        if (seiNo.equals("")) {
            seiNo = "ZZZZZZZZ";
        }

        String seiGyoNo = vo.getSeiGyoNo();
        if (seiGyoNo.equals("")) {
            seiGyoNo = "ZZZ";
        }

        // �\�[�g���i�˗��ԍ� �{ �˗��s�ԍ� + �������ԍ� �{ �������s�ԍ� + ���(S))
        retVo.setSortNo(iraiNo + iraiGyoNo + seiNo + seiGyoNo + C_SYBT_S);

        // �f�ڒP��
        String keisaiTnk = "";
        try {
            int value = Integer.parseInt(vo.getKeisaiTnk().trim());
            keisaiTnk = String.format("%,d",value);
        } catch(NumberFormatException e) {
            keisaiTnk = "";
        }

        // �f�ړ��A���z����A����œ���A�l���z����
        String keisaiDay = "";
        String kingakUw = "";
        String syohizeiUw = "";
        String nebiGakUw = "";
        for (int i = 0; i < C_ARRAY_COUNT; i++) {

            if (keisaiDay.equals("")) {
                keisaiDay += keisaiDayList[i];
            } else {
                keisaiDay += "," +  keisaiDayList[i];
            }

            if (kingakUw.equals("")) {
                kingakUw += kingakUwList[i];
            } else {
                kingakUw += "," + kingakUwList[i];
            }

            if (syohizeiUw.equals("")) {
                syohizeiUw += syohizeiUwList[i];
            } else {
                syohizeiUw += "," + syohizeiUwList[i];
            }

            if (nebiGakUw.equals("")) {
                nebiGakUw += nebiGakUwList[i];
            } else {
                nebiGakUw += "," + nebiGakUwList[i];
            }
        }

        String[] shoriKbnNmAry = (String[]) kbnList.toArray(new String[0]);
        StringBuffer shoriKbn = new StringBuffer();
        for(String str : shoriKbnNmAry) {
            shoriKbn.append(str).append(",");
        }
        retVo.setShoriKbn(shoriKbn.substring(0, shoriKbn.length() - 1));    // �����敪
        retVo.setShoriKbnNm("");                                            // �����敪��

        // ��ʂ��u21:�V���v�̏ꍇ
        if (C_BAITAI_SHINBUN.equals(retVo.getBaitaiCd().trim())) {
            retVo.setKeisaiBasCd(vo.getName11().trim());                    // �f�ڏꏊ�R�[�h
            retVo.setKeisaiBasNm(vo.getSnbn_KeiBasNm().trim());             // �f�ڏꏊ����
            retVo.setSybt1Cd(vo.getName12().trim());                        // ���1�R�[�h
            retVo.setSybt1Nm(vo.getSnbn_Sybt1Nm().trim());                  // ���1����
            retVo.setSybt2Cd(vo.getName13().trim());                        // ���2�R�[�h
            retVo.setSybt2Nm(vo.getSnbn_Sybt2Nm().trim());                  // ���2����
            retVo.setSisaCd(vo.getName14().trim());                         // �F���R�[�h
            retVo.setSisaNm(vo.getSnbn_SisatNm().trim());                   // �F������
            retVo.setSizeCd(vo.getName15().trim());                         // �T�C�Y�R�[�h
            retVo.setSizeNm(vo.getSnbn_SizeNm().trim());                    // �T�C�Y����
            retVo.setKotukeiCd("");                                         // ��ʌf�ڃR�[�h
            retVo.setKotukeiNm("");                                         // ��ʌf�ږ���
            retVo.setKeitaiKbnCd("") ;                                      // �`�ԋ敪�R�[�h
            retVo.setKeitaiKbnNm("") ;                                      // �`�ԋ敪����
            retVo.setCm1("");                                               // CM�b����1
            retVo.setCm2("");                                               // CM�b����2
            retVo.setCm3("");                                               // CM�b����3
            retVo.setCm4("");                                               // CM�b����4
            retVo.setName1("");                                             // ���e����1
            retVo.setName2("");                                             // ���e����2
            retVo.setName3("");                                             // ���e����3
            retVo.setName4("");                                             // ���e����4
            retVo.setBngm1("");                                             // �ԑg��1
            retVo.setBngm2("");                                             // �ԑg��2
            retVo.setBngm3("");                                             // �ԑg��3
            retVo.setBngm4("");                                             // �ԑg��4
            retVo.setBiko1(vo.getName16().trim());                          // ���l1
            retVo.setBiko2(vo.getName17().trim());                          // ���l2
            retVo.setKikan("");                                             // ����
            retVo.setKeisaiSu("");                                          // �f�ډ�
            retVo.setKeisaiTnk(keisaiTnk);                                  // �f�ڒP��
            retVo.setKeisaiDay(keisaiDay);                                  // �f�ړ��i�������j
            retVo.setKingakUw(kingakUw);                                    // ���z����i�V���^�G���j
            retVo.setSyohizeiUw(syohizeiUw);                                // ����œ���i�V���^�G���j
            retVo.setNebiGakUw(nebiGakUw);                                  // �l���z����i�V���^�G���j

        // ��ʂ��u22:�G���v�̏ꍇ
        } else if (C_BAITAI_ZASHI.equals(retVo.getBaitaiCd().trim())) {
            retVo.setKeisaiBasCd("");                                       // �f�ڏꏊ�R�[�h
            retVo.setKeisaiBasNm("");                                       // �f�ڏꏊ����
            retVo.setSybt1Cd("");                                           // ���1�R�[�h
            retVo.setSybt1Nm("");                                           // ���1����
            retVo.setSybt2Cd("");                                           // ���2�R�[�h
            retVo.setSybt2Nm("");                                           // ���2����
            retVo.setSisaCd(vo.getName11().trim());                         // �F���R�[�h
            retVo.setSisaNm(vo.getZasi_SisatNm().trim());                   // �F������
            retVo.setSizeCd(vo.getName12().trim());                         // �T�C�Y�R�[�h
            retVo.setSizeNm(vo.getZasi_SizeNm().trim());                    // �T�C�Y����
            retVo.setKotukeiCd("");                                         // ��ʌf�ڃR�[�h
            retVo.setKotukeiNm("");                                         // ��ʌf�ږ���
            retVo.setKeitaiKbnCd("") ;                                      // �`�ԋ敪�R�[�h
            retVo.setKeitaiKbnNm("") ;                                      // �`�ԋ敪����
            retVo.setCm1("");                                               // CM�b����1
            retVo.setCm2("");                                               // CM�b����2
            retVo.setCm3("");                                               // CM�b����3
            retVo.setCm4("");                                               // CM�b����4
            retVo.setName1("");                                             // ���e����1
            retVo.setName2("");                                             // ���e����2
            retVo.setName3("");                                             // ���e����3
            retVo.setName4("");                                             // ���e����4
            retVo.setBngm1("");                                             // �ԑg��1
            retVo.setBngm2("");                                             // �ԑg��2
            retVo.setBngm3("");                                             // �ԑg��3
            retVo.setBngm4("");                                             // �ԑg��4
            retVo.setBiko1(vo.getName13().trim());                          // ���l1
            retVo.setBiko2(vo.getName14().trim());                          // ���l2
            retVo.setKikan("");                                             // ����
            retVo.setKeisaiSu("");                                          // �f�ډ�
            retVo.setKeisaiTnk(keisaiTnk);                                  // �f�ڒP��
            retVo.setKeisaiDay(keisaiDay);                                  // �f�ړ��i�������j
            retVo.setKingakUw(kingakUw);                                    // ���z����i�V���^�G���j
            retVo.setSyohizeiUw(syohizeiUw);                                // ����œ���i�V���^�G���j
            retVo.setNebiGakUw(nebiGakUw);                                  // �l���z����i�V���^�G���j

        // ��ʂ��u11:�d�g�v�̏ꍇ
        } else if (C_BAITAI_DENPA.equals(retVo.getBaitaiCd().trim())) {
            retVo.setKeisaiBasCd("");                                       // �f�ڏꏊ�R�[�h
            retVo.setKeisaiBasNm("");                                       // �f�ڏꏊ����
            retVo.setSybt1Cd("");                                           // ���1�R�[�h
            retVo.setSybt1Nm("");                                           // ���1����
            retVo.setSybt2Cd("");                                           // ���2�R�[�h
            retVo.setSybt2Nm("");                                           // ���2����
            retVo.setSisaCd("");                                            // �F���R�[�h
            retVo.setSisaNm("");                                            // �F������
            retVo.setSizeCd("");                                            // �T�C�Y�R�[�h
            retVo.setSizeNm("");                                            // �T�C�Y����
            retVo.setKotukeiCd("");                                         // ��ʌf�ڃR�[�h
            retVo.setKotukeiNm("");                                         // ��ʌf�ږ���
            retVo.setKeitaiKbnCd(keitaiKbnCd);                              // �`�ԋ敪�R�[�h
            retVo.setKeitaiKbnNm(keitaiKbnNm);                              // �`�ԋ敪����
            retVo.setCm1(cmList[0]);                                        // CM�b����1
            retVo.setName1(nameList[0]);                                    // ���e����1
            retVo.setBngm1(bngmList[0]);                                    // �ԑg��1
            retVo.setCm2(cmList[1]);                                        // CM�b����2
            retVo.setName2(nameList[1]);                                    // ���e����2
            retVo.setBngm2(bngmList[1]);                                    // �ԑg��2
            retVo.setCm3(cmList[2]);                                        // CM�b����3
            retVo.setName3(nameList[2]);                                    // ���e����3
            retVo.setBngm3(bngmList[2]);                                    // �ԑg��3
            retVo.setCm4(cmList[3]);                                        // CM�b����4
            retVo.setName4(nameList[3]);                                    // ���e����4
            retVo.setBngm4(bngmList[3]);                                    // �ԑg��4
            retVo.setBiko1(bikou1);                                         // ���l1
            retVo.setBiko2(bikou2);                                         // ���l2
            retVo.setKikan("");                                             // ����
            retVo.setKeisaiSu("");                                          // �f�ډ�
            retVo.setKeisaiTnk("");                                         // �f�ڒP��
            retVo.setKeisaiDay("");                                         // �f�ړ��i�������j
            retVo.setKingakUw("");                                          // ���z����i�V���^�G���j
            retVo.setSyohizeiUw("");                                        // ����œ���i�V���^�G���j
            retVo.setNebiGakUw("");                                         // �l���z����i�V���^�G���j

        // ��ʂ��u31:��ʁv�̏ꍇ
        } else if (C_BAITAI_KOTSU.equals(retVo.getBaitaiCd().trim())) {
            retVo.setKeisaiBasCd("");                                       // �f�ڏꏊ�R�[�h
            retVo.setKeisaiBasNm("");                                       // �f�ڏꏊ����
            retVo.setSybt1Cd("");                                           // ���1�R�[�h
            retVo.setSybt1Nm("");                                           // ���1����
            retVo.setSybt2Cd("");                                           // ���2�R�[�h
            retVo.setSybt2Nm("");                                           // ���2����
            retVo.setSisaCd("");                                            // �F���R�[�h
            retVo.setSisaNm("");                                            // �F������
            retVo.setSizeCd("");                                            // �T�C�Y�R�[�h
            retVo.setSizeNm("");                                            // �T�C�Y����
            retVo.setKotukeiCd(vo.getName11().trim());                      // ��ʌf�ڃR�[�h
            retVo.setKotukeiNm(vo.getSnbn_KeiBasNm().trim());               // ��ʌf�ږ���
            retVo.setKeitaiKbnCd("") ;                                      // �`�ԋ敪�R�[�h
            retVo.setKeitaiKbnNm("") ;                                      // �`�ԋ敪����
            retVo.setCm1("");                                               // CM�b����1
            retVo.setCm2("");                                               // CM�b����2
            retVo.setCm3("");                                               // CM�b����3
            retVo.setCm4("");                                               // CM�b����4
            retVo.setName1("");                                             // ���e����1
            retVo.setName2("");                                             // ���e����2
            retVo.setName3("");                                             // ���e����3
            retVo.setName4("");                                             // ���e����4
            retVo.setBngm1("");                                             // �ԑg��1
            retVo.setBngm2("");                                             // �ԑg��2
            retVo.setBngm3("");                                             // �ԑg��3
            retVo.setBngm4("");                                             // �ԑg��4
            retVo.setBiko1(vo.getName12().trim());                          // ���l1
            retVo.setBiko2(vo.getName13().trim());                          // ���l2
            retVo.setKikan(vo.getName14().trim());                          // ����
            retVo.setKeisaiSu(vo.getName15().trim());                       // �f�ډ�
            retVo.setKeisaiTnk(keisaiTnk);                                  // �f�ڒP��
            retVo.setKeisaiDay(keisaiDay);                                  // �f�ړ��i�������j
            retVo.setKingakUw(kingakUw);                                    // ���z����i�V���^�G���j
            retVo.setSyohizeiUw(syohizeiUw);                                // ����œ���i�V���^�G���j
            retVo.setNebiGakUw(nebiGakUw);                                  // �l���z����i�V���^�G���j
        }

        return retVo;
    }

    /**
     * �����̏�����ɁA�����f�[�^ �ꗗ���VO��ݒ肷��i���v�s�f�[�^�j
     *
     * @param vo       �����f�[�^ �ꗗ���VO
     * @param kngk     ���z
     * @param syohizei �����
     * @return         �����f�[�^ �ꗗ���VO�i�ԋp�p�j
     */
    private FindClaimCondResultVO setGoukei(FindClaimCondVO vo,
                                            BigDecimal kngk,
                                            BigDecimal syohizei) {

        FindClaimCondResultVO retVo = new FindClaimCondResultVO();

        // ���v�s�o�� ============================================================================================================================
        retVo = new FindClaimCondResultVO();                                   // �ԋp�pVO�i�ԋp�p�̏���ێ�����j
        retVo.setSybt(C_SYBT_T);                                               // ��� (�g�[�^��)
        retVo.setIraiNo(vo.getIraiNo());                                       // �˗��ԍ��i�����ԍ��j
        retVo.setIraiGyoNo("0");                                               // �˗��s�ԍ��i�����s�ԍ��j
        retVo.setToriCd(vo.getToriCd().trim());                                // �����R�[�h
        retVo.setKaiNm(vo.getKaiNm().trim());                                  // ��Ж�
        retVo.setSeibuCd(vo.getSeibuCd().trim());                              // ���������R�[�h
        retVo.setSeiYymm(vo.getSeiYymm().trim());                              // �����N����
        retVo.setSeiNo(vo.getSeiNo().trim());                                  // �������ԍ�
        retVo.setNebiKbn("");                                                  // �l���s�敪
        retVo.setNaiyoKbn("1");                                                // ���e�敪 (1:���v)
        retVo.setSeiGyoNo("0");                                                // �������s�ԍ�
        retVo.setPayDay(vo.getPayDay().trim());                                // �x����
        retVo.setSyohinKbn(vo.getSyohinKbn().trim());                          // ���i�敪
        retVo.setSyohinKbnNm(vo.getSyohinKbnNm().trim());                      // ���i�敪����
        retVo.setSaimokuKbn(vo.getSaimokuKbn().trim());                        // �זڋ敪
        retVo.setTekiyoCd(vo.getTekiyoCd().trim());                            // �E�v�R�[�h
        retVo.setBaitaiCd(vo.getBaitaiCd().trim());                            // �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:���)
        retVo.setMediaCd("");                                                  // ���f�B�A�R�[�h
        retVo.setMediaNm("");                                                  // ���f�B�A��
        retVo.setTenBan("");                                                   // �X��
        retVo.setKeitaiKbnCd("") ;                                             // �`�ԋ敪�R�[�h
        retVo.setKeitaiKbnNm("") ;                                             // �`�ԋ敪����
        retVo.setCm1("");                                                      // CM�b����1
        retVo.setCm2("");                                                      // CM�b����2
        retVo.setCm3("");                                                      // CM�b����3
        retVo.setCm4("");                                                      // CM�b����4
        retVo.setName1("");                                                    // ���e����1
        retVo.setName2("");                                                    // ���e����2
        retVo.setName3("");                                                    // ���e����3
        retVo.setName4("");                                                    // ���e����4
        retVo.setBngm1("");                                                    // �ԑg��1
        retVo.setBngm2("");                                                    // �ԑg��2
        retVo.setBngm3("");                                                    // �ԑg��3
        retVo.setBngm4("");                                                    // �ԑg��4
        retVo.setKeisaiBasCd("");                                              // �f�ڏꏊ�R�[�h
        retVo.setKeisaiBasNm("");                                              // �f�ڏꏊ����
        retVo.setSybt1Cd("");                                                  // ���1�R�[�h
        retVo.setSybt1Nm("");                                                  // ���1����
        retVo.setSybt2Cd("");                                                  // ���2�R�[�h
        retVo.setSybt2Nm("");                                                  // ���2����
        retVo.setSisaCd("");                                                   // �F���R�[�h
        retVo.setSisaNm("");                                                   // �F������
        retVo.setSizeCd("");                                                   // �T�C�Y�R�[�h
        retVo.setSizeNm("");                                                   // �T�C�Y����
        retVo.setKotukeiCd("");                                                // ��ʌf�ڃR�[�h
        retVo.setKotukeiNm("");                                                // ��ʌf�ږ���
        retVo.setKikan("");                                                    // ����
        retVo.setKeisaiSu("");                                                 // �f�ډ�
        retVo.setBiko1("");                                                    // ���l1
        retVo.setBiko2("");                                                    // ���l2
        retVo.setKingak(kngk);                                                 // ���z
        retVo.setSyohizei(syohizei);                                           // ����Ŋz
        retVo.setKingakSum(kngk.add(syohizei));                                // ���v���z (���z + �����)
        retVo.setAnbunSybt("");                                                // �����
        retVo.setKbn(vo.getKbn().trim());                                      // �敪
        retVo.setKenmei("");                                                   // ����
        retVo.setShoriKbn("");                                                 // �����敪
        retVo.setShoriKbnNm("");                                               // �����敪��
        retVo.setKeisaiTnk("");                                                // �f�ڒP��
        retVo.setTouDate("");                                                  // �o�^�N����
        retVo.setHenDate("");                                                  // �ύX�N����
        retVo.setTorDate("");                                                  // ����N����
        retVo.setOutDate(vo.getOutDate().trim());                              // �o�͓���
        retVo.setJyutNo(vo.getJyutNo().trim());                                // ��No
        retVo.setJymeiNo(vo.getJymeiNo().trim());                              // �󒍖���No
        retVo.setUrmeiNo(vo.getUrmeiNo().trim());                              // ���㖾��No
        retVo.setRenBan(vo.getRenBan().trim());                                // �A��

        String iraiNo = vo.getIraiNo();
        if (iraiNo.equals("")) {
            iraiNo = "ZZZZZZZZ";
        }

        String iraiGyoNo = vo.getIraiGyoNo();
        if (iraiGyoNo.equals("")) {
            iraiGyoNo = "ZZZ";
        }

        String seiNo = vo.getSeiNo();
        if (seiNo.equals("")) {
            seiNo = "ZZZZZZZZ";
        }

        String seiGyoNo = vo.getSeiGyoNo();
        if (seiGyoNo.equals("")) {
            seiGyoNo = "ZZZ";
        }

        // �\�[�g���i�˗��ԍ� �{ �˗��s�ԍ� + �������ԍ� �{ �������s�ԍ� + ���(T))
        retVo.setSortNo(iraiNo + iraiGyoNo + seiNo + seiGyoNo + C_SYBT_T);

        return retVo;
    }

    /**
     * ����/���� ���وꗗ���̕ҏW���s��
     *
     * @param list       ����/���� ���وꗗ�����܂�VO���X�g
     * @param resultList �����f�[�^ �ꗗ���i�ԋp�p�j���܂�VO���X�g
     * @param yymm       �N����
     * @return           ����/���� ���وꗗ���i�ԋp�p�j���܂�VO���X�g
     */
    private List<FindClaimDiffCondResultVO> editClaimDiffDataList(List<FindClaimDiffCondVO> list,
                                                                  List<FindClaimCondResultVO> resultList,
                                                                  String yymm) {

        List<FindClaimDiffCondResultVO> retList = new ArrayList<FindClaimDiffCondResultVO>();

        FindClaimDiffCondResultVO outVo = null;         // �ԋp�pVO�i�ԋp�p�̏���ێ�����j
        FindClaimDiffCondVO getVo = null;               // �ێ��pVO�iSQL�Ŏ擾��������ێ�����j

        // �����f�[�^ �ꗗ���̃T�C�Y���O�̏ꍇ�A��̃��X�g��ԋp����
        if (resultList.size() == 0) {
            return retList;
        }

        // �����f�[�^ �ꗗ��񃊃X�g����l���R�s�[
        for (FindClaimCondResultVO resultVo: resultList) {
            outVo = new FindClaimDiffCondResultVO();
            outVo.setSybt(resultVo.getSybt());                                 // ���
            outVo.setIraiNo(resultVo.getIraiNo());                             // �˗��ԍ��i�����ԍ��j
            outVo.setIraiGyoNo(resultVo.getIraiGyoNo());                       // �˗��s�ԍ��i�����s�ԍ��j
            outVo.setToriCd(resultVo.getToriCd());                             // �����R�[�h
            outVo.setSeibuCd(resultVo.getSeibuCd());                           // ���������R�[�h
            outVo.setSeiYymm(resultVo.getSeiYymm());                           // �����N����
            outVo.setSeiNo(resultVo.getSeiNo());                               // �������ԍ�
            outVo.setNaiyoKbn(resultVo.getNaiyoKbn());                         // ���e�敪
            outVo.setSeiGyoNo(resultVo.getSeiGyoNo());                         // �������s�ԍ�
            outVo.setPayDay(resultVo.getPayDay());                             // �x����
            outVo.setSyohinKbn(resultVo.getSyohinKbn());                       // ���i�敪
            outVo.setTekiyoCd(resultVo.getTekiyoCd());                         // �E�v�R�[�h
            outVo.setBaitaiCd(resultVo.getBaitaiCd());                         // �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:��� )
            outVo.setMediaCd(resultVo.getMediaCd());                           // ���f�B�A�R�[�h
            outVo.setMediaNm(resultVo.getMediaNm());                           // ���f�B�A��
            outVo.setTenBan(resultVo.getTenBan());                             // �X��
            outVo.setKeitaiKbnCd(resultVo.getKeitaiKbnCd());                   // �`�ԋ敪�R�[�h
            outVo.setKeitaiKbnNm(resultVo.getKeitaiKbnNm());                   // �`�ԋ敪����
            outVo.setCm1(resultVo.getCm1());                                   // CM�b����1
            outVo.setCm2(resultVo.getCm2());                                   // CM�b����2
            outVo.setCm3(resultVo.getCm3());                                   // CM�b����3
            outVo.setCm4(resultVo.getCm4());                                   // CM�b����4
            outVo.setName1(resultVo.getName1());                               // ���e����1
            outVo.setName2(resultVo.getName2());                               // ���e����2
            outVo.setName3(resultVo.getName3());                               // ���e����3
            outVo.setName4(resultVo.getName4());                               // ���e����4
            outVo.setBngm1(resultVo.getBngm1());                               // �ԑg��1
            outVo.setBngm2(resultVo.getBngm2());                               // �ԑg��2
            outVo.setBngm3(resultVo.getBngm3());                               // �ԑg��3
            outVo.setBngm4(resultVo.getBngm4());                               // �ԑg��4
            outVo.setKeisaiBasCd(resultVo.getKeisaiBasCd());                   // �f�ڏꏊ�R�[�h
            outVo.setKeisaiBasNm(resultVo.getKeisaiBasNm());                   // �f�ڏꏊ����
            outVo.setSybt1Cd(resultVo.getSybt1Cd());                           // ���1�R�[�h
            outVo.setSybt1Nm(resultVo.getSybt1Nm());                           // ���1����
            outVo.setSybt2Cd(resultVo.getSybt2Cd());                           // ���2�R�[�h
            outVo.setSybt2Nm(resultVo.getSybt2Nm());                           // ���2����
            outVo.setSisaCd(resultVo.getSisaCd());                             // �F���R�[�h
            outVo.setSisaNm(resultVo.getSisaNm());                             // �F������
            outVo.setSizeCd(resultVo.getSizeCd());                             // �T�C�Y�R�[�h
            outVo.setSizeNm(resultVo.getSizeNm());                             // �T�C�Y����
            outVo.setKotukeiCd(resultVo.getKotukeiCd());                       // ��ʌf�ڃR�[�h
            outVo.setKotukeiNm(resultVo.getKotukeiNm());                       // ��ʌf�ږ���
            outVo.setKeisaiSu(resultVo.getKeisaiSu());                         // �f�ډ�
            outVo.setBiko1(resultVo.getBiko1());                               // ���l1
            outVo.setBiko2(resultVo.getBiko2());                               // ���l2
            outVo.setKeisaiTnk(resultVo.getKeisaiTnk());                       // �f�ڒP��
            outVo.setKingak(resultVo.getKingak());                             // �s�P�ʋ��z
            outVo.setSyohizei(resultVo.getSyohizei());                         // �s�P�ʏ����
            outVo.setKingakSum(resultVo.getKingakSum());                       // �s�P�ʋ��z���v
            outVo.setAnbunSybt(resultVo.getAnbunSybt());                       // �����
            outVo.setKbn(resultVo.getKbn());                                   // �敪
            outVo.setKenmei(resultVo.getKenmei());                             // ����
            outVo.setKikan(resultVo.getKikan());                               // ����
            outVo.setSortNo(resultVo.getSortNo());                             // �\�[�g

            // �ԋp�p���X�g�ɒǉ�����
            ModelUtils.copyMemberSearchAfterInstace(outVo);
            retList.add(outVo);
        }

        // �R�s�[�������X�g�ɁA�擾��������ǉ�����
        for (int i = 0; i < list.size(); i++) {

            getVo = (FindClaimDiffCondVO) list.get(i);
            outVo = new FindClaimDiffCondResultVO();

            outVo.setSybt(getVo.getRecCd().trim());                            // ���R�[�h���
            outVo.setIraiNo(getVo.getIrBan());                                 // �˗��ԍ�
            outVo.setIraiGyoNo(getVo.getIrRowBan());                           // �˗��s�ԍ�
            outVo.setToriCd(getVo.getTokuiCd().trim());                        // �����R�[�h�i���Ӑ�R�[�h�j
            outVo.setNaiyoKbn("2");                                            // ���e�敪(���ׁF2 ���v�F1)
            outVo.setSyohinKbn(getVo.getSyohinKbn().trim());                   // ���i�敪
            outVo.setTekiyoCd(getVo.getTekiCd().trim());                       // �E�v�R�[�h
            outVo.setBaitaiCd(getVo.getSybt().trim());                         // �}�̃R�[�h�i��ʁj
            outVo.setMediaCd(getVo.getMediaCd().trim());                       // ���f�B�A�R�[�h
            outVo.setMediaNm(getVo.getMediaNm().trim());                       // ���f�B�A��
            outVo.setTenBan(getVo.getTenBan().trim());                         // �X��
            outVo.setBiko1(getVo.getBikou1().trim());                          // ���l1
            outVo.setBiko2(getVo.getBikou2().trim());                          // ���l2
            outVo.setAnbunSybt(getVo.getAnSybt().trim());                      // �����

            String iraiNo = getVo.getIrBan();
            if (iraiNo.equals("")) {
                iraiNo = "ZZZZZZZZ";
            }

            String iraiGyoNo = getVo.getIrRowBan();
            if (iraiGyoNo.equals("")) {
                iraiGyoNo = "ZZZ";
            }

            String seiNo = "        ";
            String seiGyoNo = "   ";

            // �\�[�g���i�˗��ԍ� �{ �˗��s�ԍ� + �������ԍ� �{ �������s�ԍ� + ���)
            outVo.setSortNo(iraiNo + iraiGyoNo + seiNo + seiGyoNo + getVo.getRecCd().trim());

            String keisaiTnk = "";
            try {
                int value = Integer.parseInt(getVo.getKeisaiTnk().trim());
                keisaiTnk = String.format("%,d",value);
            } catch(NumberFormatException e) {
                keisaiTnk = "";
            }

            // ��ʂ��u21:�V���v�̏ꍇ
            if (C_BAITAI_SHINBUN.equals(outVo.getBaitaiCd().trim())) {
                outVo.setKeitaiKbnCd("") ;                                     // �`�ԋ敪�R�[�h
                outVo.setKeitaiKbnNm("") ;                                     // �`�ԋ敪����
                outVo.setKeisaiTnk(keisaiTnk);                                 // �f�ڒP��
                outVo.setKeisaiBasCd(getVo.getPlaceCd().trim());               // �f�ڏꏊ�R�[�h
                outVo.setKeisaiBasNm(getVo.getKeiBasNm().trim());              // �f�ڏꏊ����
                outVo.setSybt1Cd(getVo.getSybt1Cd().trim());                   // ���1�R�[�h
                outVo.setSybt1Nm(getVo.getSybt1Nm().trim());                   // ���1����
                outVo.setSybt2Cd(getVo.getSybt2Cd().trim());                   // ���2�R�[�h
                outVo.setSybt2Nm(getVo.getSybt2Nm().trim());                   // ���2����
                outVo.setSisaCd(getVo.getColorCd().trim());                    // �F���R�[�h
                outVo.setSisaNm(getVo.getSisatNm().trim());                    // �F������
                outVo.setSizeCd(getVo.getSpCd().trim());                       // �X�y�[�X�R�[�h
                outVo.setSizeNm(getVo.getSpNm().trim());                       // �X�y�[�X����
                outVo.setKotukeiCd("");                                        // ��ʌf�ڃR�[�h
                outVo.setKotukeiNm("");                                        // ��ʌf�ږ���
                //outVo.setKingak(getVo.getHosoRyo1());                          // ���z
                outVo.setKingak(getVo.getKeisaiRyo());                          // ���z

            // ��ʂ��u22:�G���v�̏ꍇ
            } else if (C_BAITAI_ZASHI.equals(outVo.getBaitaiCd().trim())) {
                outVo.setKeitaiKbnCd("") ;                                     // �`�ԋ敪�R�[�h
                outVo.setKeitaiKbnNm("") ;                                     // �`�ԋ敪����
                outVo.setKeisaiTnk(keisaiTnk);                                 // �f�ڒP��
                outVo.setKeisaiBasCd("");                                      // �f�ڏꏊ�R�[�h
                outVo.setKeisaiBasNm("");                                      // �f�ڏꏊ����
                outVo.setSybt1Cd("");                                          // ���1�R�[�h
                outVo.setSybt1Nm("");                                          // ���1����
                outVo.setSybt2Cd("");                                          // ���2�R�[�h
                outVo.setSybt2Nm("");                                          // ���2����
                outVo.setSisaCd(getVo.getColorCd().trim());                    // �F���R�[�h
                outVo.setSisaNm(getVo.getSisatNm().trim());                    // �F������
                outVo.setSizeCd(getVo.getSizeCd().trim());                     // �T�C�Y�R�[�h
                outVo.setSizeNm(getVo.getSizeNm().trim());                     // �T�C�Y����
                outVo.setKotukeiCd("");                                        // ��ʌf�ڃR�[�h
                outVo.setKotukeiNm("");                                        // ��ʌf�ږ���
                //outVo.setKingak(getVo.getHosoRyo1());                          // ���z
                outVo.setKingak(getVo.getKeisaiRyo());                          // ���z

            // ��ʂ��u11:�d�g�v�̏ꍇ
            } else if (C_BAITAI_DENPA.equals(outVo.getBaitaiCd().trim())) {
                outVo.setKeitaiKbnCd(getVo.getKeitaiCd().trim()) ;             // �`�ԋ敪�R�[�h
                outVo.setKeitaiKbnNm(getVo.getKeitaiName().trim()) ;           // �`�ԋ敪����
                outVo.setKeisaiTnk("");                                        // �f�ڒP��
                outVo.setKeisaiBasCd("");                                      // �f�ڏꏊ�R�[�h
                outVo.setKeisaiBasNm("");                                      // �f�ڏꏊ����
                outVo.setSybt1Cd("");                                          // ���1�R�[�h
                outVo.setSybt1Nm("");                                          // ���1����
                outVo.setSybt2Cd("");                                          // ���2�R�[�h
                outVo.setSybt2Nm("");                                          // ���2����
                outVo.setSisaCd("");                                           // �F���R�[�h
                outVo.setSisaNm("");                                           // �F������
                outVo.setSizeCd("");                                           // �T�C�Y�R�[�h
                outVo.setSizeNm("");                                           // �T�C�Y����
                outVo.setKotukeiCd("");                                        // ��ʌf�ڃR�[�h
                outVo.setKotukeiNm("");                                        // ��ʌf�ږ���

                // �d�g�̎������������i�˗������܂������ė��Ă���ׁj
                if (yymm.equals(getVo.getIrMonth1())) {
                    // ���z1
                    outVo.setKingak(getVo.getHosoRyo1());

                } else if (yymm.equals(getVo.getIrMonth2())) {
                    // ���z2
                    outVo.setKingak(getVo.getHosoRyo2());

                } else if (yymm.equals(getVo.getIrMonth3())) {
                    // ���z3
                    outVo.setKingak(getVo.getHosoRyo3());

                } else if (yymm.equals(getVo.getIrMonth4())) {
                    // ���z4
                    outVo.setKingak(getVo.getHosoRyo4());

                } else if (yymm.equals(getVo.getIrMonth5())) {
                    // ���z5
                    outVo.setKingak(getVo.getHosoRyo5());

                } else if (yymm.equals(getVo.getIrMonth6())) {
                    // ���z6
                    outVo.setKingak(getVo.getHosoRyo6());
                }

            // ��ʂ��u31:��ʁv�̏ꍇ
            } else if (C_BAITAI_KOTSU.equals(outVo.getBaitaiCd().trim())) {
                outVo.setKeitaiKbnCd("") ;                                     // �`�ԋ敪�R�[�h
                outVo.setKeitaiKbnNm("") ;                                     // �`�ԋ敪����
                outVo.setKeisaiTnk(keisaiTnk);                                 // �f�ڒP��
                outVo.setKeisaiBasCd("");                                      // �f�ڏꏊ�R�[�h
                outVo.setKeisaiBasNm("");                                      // �f�ڏꏊ����
                outVo.setSybt1Cd("");                                          // ���1�R�[�h
                outVo.setSybt1Nm("");                                          // ���1����
                outVo.setSybt2Cd("");                                          // ���2�R�[�h
                outVo.setSybt2Nm("");                                          // ���2����
                outVo.setSisaCd("");                                           // �F���R�[�h
                outVo.setSisaNm("");                                           // �F������
                outVo.setSizeCd("");                                           // �T�C�Y�R�[�h
                outVo.setSizeNm("");                                           // �T�C�Y����
                outVo.setKotukeiCd(getVo.getKotuKeiCd().trim());               // ��ʌf�ڃR�[�h
                outVo.setKotukeiNm(getVo.getKotKeiNm().trim());                // ��ʌf�ږ���
                //outVo.setKingak(getVo.getHosoRyo1());                          // ���z
                outVo.setKingak(getVo.getKeisaiRyo());                          // ���z
            }

            ModelUtils.copyMemberSearchAfterInstace(outVo);
            retList.add(outVo);
        }

        return retList;
    }

    /**
     * �l���}�X�^���Q�Ƃ��A�l���z���v�Z�E�擾����
     *
     * @param  keisaiDay    �f�ړ�
     * @param  mediaCd      ���f�B�A�R�[�h
     * @param  nebiGak      �l���z
     * @param  kingak       ���z
     * @return              �l���z
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private BigDecimal getNebiGak(String keisaiDay, String mediaCd, BigDecimal nebiGak, BigDecimal kingak) throws KKHException {

        // �f�[�^�擾DAO�̃C���X�^���X����
        FindClaimByCondDAO dao = FindClaimByCondDAOFactory.createFindKenMeisaiByCondDAO();

        // �f�[�^�擾
        _lCond.setKeisaiDay(keisaiDay);
        List<FindNebikiCondVO> nebiList = dao.findNebikiDataByCondition(_lCond);

        if (nebiList.size() == 0) {
            return BigDecimal.ZERO;
        }

        String gyomuKbn = "11010";                  // �Ɩ��敪
        String himokuCd = "001";                    // ��ڃR�[�h
        String baitaiCdr = "";                      // �}�̃R�[�h
        boolean btHitFlg = false;                   // �t���O
        BigDecimal nebikiRitsu = BigDecimal.ZERO;   // �l����
        BigDecimal nebikiRitsu2 = BigDecimal.ZERO;  // �l����
        BigDecimal toriGak = BigDecimal.ZERO;       // �旿��
        BigDecimal retNebiGak = BigDecimal.ZERO;    // �l�����z

        for (int i = 0; i < nebiList.size(); i++) {

            FindNebikiCondVO result = (FindNebikiCondVO) nebiList.get(i);

            // �P�D[�Ɩ��敪]���������B[�}�̃R�[�hޓ��S��]���������B[��ں���]���������B
            if (result.getBtCd().length() == 6) {
                if (gyomuKbn.equals(result.getGMkbnCd()) &&
                    mediaCd.substring(0, 4).equals(result.getBtCd().substring(0, 4)) &&
                    himokuCd.equals(result.getHmCd())) {

                    // [�l�����}�X�^�̔}�̃R�[�h]��[�p�����[�^�}�̃R�[�h]���������B
                    if (mediaCd.equals(result.getBtCd())) {
                        btHitFlg = true;
                        nebikiRitsu2 = result.getNebikiR();
                    }

                    // [�l�����}�X�^�̔}�̃R�[�h���Q��]�� ""�B
                    if ("".equals(result.getBtCd().substring(4))) {
                        nebikiRitsu = result.getNebikiR();
                        break;
                    }
                }
            }

            // �Q.[�Ɩ��敪]���������B�}�̃R�[�h�̂S���ڂ��A�O�ɕϊ�����[�}�̃R�[�h��S��]���������B[��ڃR�[�h]���������B
            if (result.getBtCd().length() == 6) {
                if ("00".equals(mediaCd.substring(0, 2))) {

                    baitaiCdr = mediaCd.substring(0, 3) + "0";

                    if (gyomuKbn.equals(result.getGMkbnCd()) &&
                        baitaiCdr.equals(result.getBtCd().substring(0, 4)) &&
                        himokuCd.equals(result.getHmCd())) {

                        // [�l�����}�X�^�̔}�̃R�[�h]��[�p�����[�^�}�̃R�[�h]���������B
                        if (mediaCd.equals(result.getBtCd())) {
                            btHitFlg = true;
                            nebikiRitsu2 = result.getNebikiR();
                        }

                        // [�l�����}�X�^�̔}�̃R�[�h���Q��]�� ""�B
                        if ("".equals(result.getBtCd().substring(4))) {
                            nebikiRitsu = result.getNebikiR();
                            break;
                        }
                    }
                }
            }

            // �R�D[�Ɩ��敪]���������B[�}�̃R�[�h]���������B[��ڃR�[�h]���X�y�[�X�B
            if (result.getBtCd().length() == 6) {
                if (gyomuKbn.equals(result.getGMkbnCd()) &&
                    mediaCd.substring(0, 4).equals(result.getBtCd().substring(0, 4)) &&
                    "".equals(result.getHmCd())) {

                    // [�l�����}�X�^�̔}�̃R�[�h]��[�p�����[�^�}�̃R�[�h]���������B
                    if (mediaCd.equals(result.getBtCd())) {
                        btHitFlg = true;
                        nebikiRitsu2 = result.getNebikiR();
                    }

                    // [�l�����}�X�^�̔}�̃R�[�h���Q��]�� ""�B
                    if ("".equals(result.getBtCd().substring(4))) {
                        nebikiRitsu = result.getNebikiR();
                        break;
                    }
                }
            }

            // �S�D[�Ɩ��敪]���������B�}�̃R�[�h�̂S���ڂ��O�ɕϊ�����[�}�̃R�[�h��S��]���������B[��ڃR�[�h]���X�y�[�X�B
            if (result.getBtCd().length() == 6) {
                if ("00".equals(mediaCd.substring(0, 2))) {

                    baitaiCdr = mediaCd.substring(0, 3) + "0";

                    if (gyomuKbn.equals(result.getGMkbnCd()) &&
                        baitaiCdr.equals(result.getBtCd().substring(0, 4)) &&
                        "".equals(result.getHmCd())) {

                        // [�l�����}�X�^�̔}�̃R�[�h]��[�p�����[�^�}�̃R�[�h]���������B
                        if (mediaCd.equals(result.getBtCd())) {
                            btHitFlg = true;
                            nebikiRitsu2 = result.getNebikiR();
                        }

                        // [�l�����}�X�^�̔}�̃R�[�h���Q��]�� ""�B
                        if ("".equals(result.getBtCd().substring(4))) {
                            nebikiRitsu = result.getNebikiR();
                            break;
                        }
                    }
                }
            }

            // �T�D[�Ɩ��敪]���������B[�}�̃R�[�h]���X�y�[�X�B[��ڃR�[�h]���������B
            if (gyomuKbn.equals(result.getGMkbnCd()) &&
                "".equals(result.getBtCd()) &&
                "".equals(result.getHmCd())) {

                nebikiRitsu = result.getNebikiR();
                break;
            }

            // �U�D[�Ɩ��敪]���������B[�}�̃R�[�h]���X�y�[�X�B[��ڃR�[�h]���X�y�[�X�B
            if (gyomuKbn.equals(result.getGMkbnCd().trim()) &&
                "".equals(result.getBtCd().trim()) &&
                himokuCd.equals(result.getHmCd().trim())) {

                nebikiRitsu = result.getNebikiR();
                break;
            }

            // �V�D[�Ɩ��敪]���X�y�[�X�B[�}�̃R�[�h]���X�y�[�X�B[��ڃR�[�h]���X�y�[�X�B
            if ("".equals(result.getGMkbnCd().trim()) &&
                "".equals(result.getBtCd().trim()) &&
                "".equals(result.getHmCd().trim())) {

                nebikiRitsu = result.getNebikiR();
                break;
            }
        }

        if (btHitFlg) {
            nebikiRitsu = nebikiRitsu2;
        }

        // �v�Z
        BigDecimal val = new BigDecimal(100);               //
        BigDecimal val2 = new BigDecimal(100);              //
        BigDecimal val3 = kingak.multiply(val);             // �i���z * 100�j
        BigDecimal val4 = val2.subtract(nebikiRitsu);       // �i100 - �l�����j

        // �旿�����Z�o�i�i���z * 100�j/ �i100 - �l�����j�j
        toriGak =  val3.divide(val4, 0, BigDecimal.ROUND_HALF_UP);

        // �l�����z���Z�o�i�旿�� - ���z�j
        retNebiGak = toriGak.subtract(kingak);

        return retNebiGak;
    }
}

