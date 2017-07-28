package jp.co.isid.kkh.customer.uni.model.report;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.constants.KKHConstants.GyomKbn;
import jp.co.isid.kkh.util.constants.KKHConstants.SeiKbn;
import jp.co.isid.nj.model.ModelUtils;

public class ReportUniManager {

    /** ������̒��� (���e�P) */
    private static final int CONTENTS1_LENGTH = 32;
    /** ������̒��� (���e�Q) */
    private static final int CONTENTS2_LENGTH = 18;
    /** ������̒��� (���e�R) */
    private static final int CONTENTS3_LENGTH = 11;
    /** ������̒��� (���e�S) */
    private static final int CONTENTS4_LENGTH = 30;

    /** �V���O���g���C���X�^���X */
    private static ReportUniManager _manager = new ReportUniManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportUniManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportUniManager getInstance() {
        return _manager;
    }

    /**
     * ���[�i���j�`���[��_�L����ו\�j�f�[�^���������܂��B
     *
     * @return ReportUniResult ���я����
     * @throws KKHException
     *             �������ɃG���[�����������ꍇ
     */
    public ReportUniResult findReportUniByCondition(ReportUniCondition cond)
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
        if (cond.getYm() == null || cond.getYm().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        // ��������
        ReportUniResult result = new ReportUniResult();

        // ��������
        ReportUniCondition lCond = new ReportUniCondition();

        ReportUniDAO dao = ReportUniDAOFactory.createFindReportUniDAO();
        lCond = cond;

        // ****************************************************************
        // ���[�i���j�`���[��_�L����ו\�E�v���[�t���X�g�j�f�[�^�̌���
        // ****************************************************************
        List<ReportUniVO> list = dao.findReportUniByCondition(lCond);
        List<ReportUniVO> list_t = dao.findTougouReportUniByCondition(lCond);


        // ****************************************************************
        // ���[�i���j�`���[��_�L����ו\�j�f�[�^���擾
        // ****************************************************************
        result.setMeisai(getMeisai(list, list_t));

        // ****************************************************************
        // ���[�i���j�`���[��_�v���[�t���X�g�j�f�[�^���擾
        // ****************************************************************
        result.setProofs(getProofs(list, list_t));

        return result;
    }

    /**
     * �L����ו\�i�b��E�m��j�f�[�^���擾����
     *
     * @param hashList ��������
     * @return �ϊ���̌�������
     */
    private List<ReportUniResultVO> getMeisai(List<ReportUniVO> hashList, List<ReportUniVO> hashList_t) {

        List<ReportUniResultVO> list = new ArrayList<ReportUniResultVO>();

        for (int i = 0; i < hashList.size(); i++) {

            ReportUniVO result = new ReportUniVO();
            result = hashList.get(i);
            ReportUniResultVO vo = new ReportUniResultVO();

            // �������[No
            String gpyNo = "";
            String temp1 = result.getHb1GpyNo();
            String temp2 = result.getHb2Sonota2();

            // 2013/01/09 JSE M.Naito add
            // �󒍃f�[�^�̐������[No�̌`���ύX
            gpyNo = changeStr(temp1, temp2);

            String jyutNo1 = "";
            String jyutMNo1 = "";
            String uriMNo1 = "";
            // �����t���O�������Ă���ꍇ
            if(result.getHb1TouFlg().equals("1")){

                // ������́u��No�v���擾
                jyutNo1 = result.getHb1JyutNo();
                jyutMNo1 = result.getHb1JyMeiNo();
                uriMNo1 = result.getHb1UrMeiNo();

                // �������̐������[No���擾
                for(int j = 0; j < hashList_t.size(); j++){

                    // �󒍃f�[�^���擾
                    ReportUniVO result_t = new ReportUniVO();
                    result_t = hashList_t.get(j);

                    // �������́u�������No�A������󒍖���No�A�����攄�㖾��No�v�Ɠ�����́u��No�A�󒍖���No�A���㖾��No�v����v
                    if(result_t.getHb1TJyutNo().equals(jyutNo1) &&  result_t.getHb1TJymeiNo().equals(jyutMNo1) && result_t.getHb1TUrmeiNo().equals(uriMNo1)){

                        String tmp1 = "";
                        // �������̐������[No�̌`���ύX
                        tmp1 = changeStr(result_t.getHb1GpyNo(), "");

                        if(!gpyNo.equals("")){
//                            gpyNo += ",";
                            gpyNo += "\n";
                        }
                        gpyNo += tmp1;
                    }
                }
            }

//            if (!temp1.equals("") && temp1.length() == 10) {
//                // �������[No��10�����̏ꍇ�i����j �u999999-9999�v�`��
//                gpyNo += temp1.substring(0, 6);
//                gpyNo += "-";
//                gpyNo += temp1.substring(6, 10);
//
//            } else {
//                // �������[No��10�����ȊO�̏ꍇ�i�ُ�j �ϊ������ɃZ�b�g
//                gpyNo = temp1;
//            }
//
//            if (!temp2.equals("")) {
//                // �������[�s�ԍ������݂���ꍇ
//                gpyNo += "-";
//                gpyNo += temp2;
//            }
            vo.setGpyNo(gpyNo);

            // �����t���O
            vo.setTouFlg(result.getHb1TouFlg());

            // ��No(��No + "-" + �󒍖���No + "-" + ���㖾��No)
            String jyutNo = result.getHb1JyutNo();      // ��No
            String jyMeiNo = result.getHb1JyMeiNo();    // �󒍖���No
            String urMeiNo = result.getHb1UrMeiNo();    // ���㖾��No
            vo.setJutyuNo(jyutNo + "-" + jyMeiNo + "-" + urMeiNo);

            // ��ʃR�[�h
            String showNumStr = result.getShubetsuCd();
            vo.setShubetsuCd(showNumStr);

            // ��ʖ�
            vo.setShubetsuNm(result.getShubetsuNm());

            // ����
            vo.setKenmei(result.getHb2Name9());

            // ���
            vo.setHimoku(result.getHb2Name1());

            // ���z
            vo.setKngk(result.getHb2SeiGak());

            // �����
            vo.setTax(result.getHb2Kngk2());

            // ���z�i�󒍃_�E�����[�h�f�[�^�j
            vo.setKngkJ(result.getHb1SeiGak());

            // ����Łi�󒍃_�E�����[�h�f�[�^�j
            vo.setTaxJ(result.getHb1SzeiGak());

            // ���e�P
            String contents1 = getContents1(result, showNumStr);
            vo.setContents1(contents1);

            // ���e�Q
            String contents2 = getContents2(result, showNumStr);
            vo.setContents2(contents2);

            // ���e�R
            String contents3 = getContents3(result, showNumStr);
            vo.setContents3(contents3);

            // ���e�S
            String contents4 = getContents4(result, showNumStr);
            vo.setContents4(contents4);

            // ���e
            StringBuffer contents = new StringBuffer();
            contents.append(contentsAddSpace(contents1, CONTENTS1_LENGTH, false));
            contents.append(contentsAddSpace(contents2, CONTENTS2_LENGTH, false));
            contents.append(contentsAddSpace(contents3, CONTENTS3_LENGTH, true));

            // ����
            vo.setBusho(result.getHb2Name11());

            // �e���r�ԑg�A�e���r���ԁA����
            if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNumStr) ||
                ReportUniDAO.IDX_TV_TOKUBAN.equals(showNumStr) ||
                ReportUniDAO.IDX_SEISAKU.equals(showNumStr)) {

                if (!contents3.equals("") && !contents4.equals("")) {
                    contents.append("�~");
                } else {
                    contents.append("  ");
                }

            } else {
                contents.append("  ");
            }
            contents.append(contentsAddSpace(contents4, CONTENTS4_LENGTH, false));
            vo.setContents(contents.toString());

            // �������ʒ���̏�Ԃɂ���
            ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
        }

        return list;
    }

    /**
     * ���e�P�ɕ\�����镶������擾����
     *
     * @param vo ���׃f�[�^
     * @param showNum ��ʕ\����
     *
     * @return String ���e�P
     */
    private String getContents1(ReportUniVO vo, String showNum) {

        String ret = "";

        // �e���r�ԑg�A�e���r����
        if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNum) || ReportUniDAO.IDX_TV_TOKUBAN.equals(showNum)) {

            String sonota5 = vo.getHb2Sonota5();
            String name3 = vo.getHb2Name3();

            // ���������Z�b�g
            // �������uYYYYMM�v�`���A�������u00000���00000�v�`�� �� �uM���ED���A���D���v�`���ɂ���
            if (!sonota5.equals("") && sonota5.length() == 6 &&
                !name3.equals("") && name3.length() == 31) {

                String temp = sonota5.substring(4, 6);
                if (temp.substring(0, 1).equals("0"))
                {
                    temp = temp.substring(1, 2);
                }

                ret = temp + "���E" + changeDate(name3);
            }

        // �e���r�X�|�b�g
        } else if (ReportUniDAO.IDX_TV_SPOT.equals(showNum)) {

            // �������Ԃ��Z�b�g
            // �������ԁuYYYYMMDDYYYYMMDD�v�`�� �� �uM/D-M/D�v�`���ɂ���
            ret = changeDate(vo.getHb2Name3());

        // �G���A�V���A���̑�
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum) ||
                   ReportUniDAO.IDX_SHINBUN.equals(showNum) ||
                   ReportUniDAO.IDX_SONOTA.equals(showNum)) {

            // �}�̖����Z�b�g
            ret = vo.getHb2Name2();

        // ����
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {

            // ������e���Z�b�g
            ret = vo.getHb2Name4();
        }

        return ret;
    }

    /**
     * ���e�Q�ɕ\�����镶������擾����
     *
     * @param vo ���׃f�[�^
     * @param showNum ��ʕ\����
     *
     * @return String ���e�Q
     */
    private String getContents2(ReportUniVO vo, String showNum) {

        String ret = "";

        // �e���r�X�|�b�g
        if (ReportUniDAO.IDX_TV_SPOT.equals(showNum)) {

            String name2 = vo.getHb2Name2();
            String sonota4 = vo.getHb2Sonota4();

            // �s�u �r�o�n�s �̏ꍇ
            // �����ǖ� + �ǐ����Z�b�g
            //�u"�����ǖ�" �� "�ǐ�" �ǁv�`���ɂ���   ��j���ޒ�����22��
            if (!name2.equals("")) {
                ret += name2 + "��";
            }

            if (!sonota4.equals("")) {
                DecimalFormat df = new DecimalFormat("#,##0");
                ret += df.format(Integer.valueOf(sonota4)) + "��";
            }

        // �G���A�V��
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum) || ReportUniDAO.IDX_SHINBUN.equals(showNum)) {

            // ���������Z�b�g(�G��)
            // �A�ړ����Z�b�g(�V��)
            // ���ԁuYYYYMMDD�v�`�� �� �uM��D���v�`���ɂ���
            ret = changeDate(vo.getHb2Name3());

        // ���̑�
        } else if (ReportUniDAO.IDX_SONOTA.equals(showNum)) {

            // ���Ԃ��Z�b�g
            // ���ԁuYYYYMMDDYYYYMMDD�v�`�� �� �uM/D-M/D�v�`���ɂ���
            ret = changeDate(vo.getHb2Name3());

        // ����
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {

            // �[�i�ڂ��Z�b�g
            String name3 = vo.getHb2Name3();
            if (!name3.equals("")) {
                ret = name3;
            }
        }

        return ret;
    }

    /**
     * ���e�R�ɕ\�����镶������擾����
     *
     * @param vo ���׃f�[�^
     * @param showNum ��ʕ\����
     *
     * @return String ���e�R
     */
    private String getContents3(ReportUniVO vo, String showNum) {

        String ret = "";

        // �e���r�ԑg�A�e���r���ԁA����
        if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNum) ||
            ReportUniDAO.IDX_TV_TOKUBAN.equals(showNum) ||
            ReportUniDAO.IDX_SEISAKU.equals(showNum)) {

            // �P�����Z�b�g
            BigDecimal kngk1 = vo.getHb2Kngk1();
            if (kngk1.compareTo(BigDecimal.ZERO) > 0) {

                // �u0�v�ȊO�̏ꍇ�͒P�����Z�b�g
                DecimalFormat df = new DecimalFormat("#,##0");
                ret = df.format((kngk1));
            }

        // �G��
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum)) {

            // �f�ڍ����Z�b�g
            ret = vo.getHb2Name6();
        }

        return ret;
    }

    /**
     * ���e�S�ɕ\�����镶������擾����
     *
     * @param vo ���׃f�[�^
     * @param showNum ��ʕ\����
     *
     * @return String ���e�S
     */
    private String getContents4(ReportUniVO vo, String showNum) {

        String ret = "";

        // �e���r�ԑg�A�e���r����
        if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNum) || ReportUniDAO.IDX_TV_TOKUBAN.equals(showNum)) {

            String sonota4 = vo.getHb2Sonota4();

            // �����񐔂��Z�b�g
            // �u"������" ��v�`���ɂ���
            if (!sonota4.equals("")) {
                DecimalFormat df = new DecimalFormat("#,##0");
                ret = df.format(Integer.valueOf(sonota4)) + "��";
            }

        // �G���A�V��
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum) ||
                   ReportUniDAO.IDX_SHINBUN.equals(showNum)) {

            // �X�y�[�X���Z�b�g
            String name7 = vo.getHb2Name7();
            if (!name7.trim().equals("")) {
                ret = name7;
            }

        // ����
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {

            String sonota4 = vo.getHb2Sonota4();

            // �񐔐��ʂ��Z�b�g
            // �u"�񐔐���" �{�v�`���ɂ���
            if (!sonota4.equals("")) {
                DecimalFormat df = new DecimalFormat("#,##0");
                ret = df.format(Integer.valueOf(sonota4)) + "�{";
            }
        }

        return ret;
    }

    /**
     * �v���[�t���X�g�f�[�^���擾����
     *
     * @param hashList ��������
     * @return �ϊ���̌�������
     */
    private List<ReportUniResultVO> getProofs(List<ReportUniVO> hashList, List<ReportUniVO> hashList_t) {

        List<ReportUniResultVO> list = new ArrayList<ReportUniResultVO>();

        for (int h = 0; h < hashList_t.size(); h++) {

            // ���X�g����ɂ܂Ƃ߂�
            hashList.add(hashList_t.get(h));
        }

         for (int i = 0; i < hashList.size(); i++) {

            ReportUniVO result = hashList.get(i);
            ReportUniResultVO vo = new ReportUniResultVO();

            String gyomKbn = result.getHb1GyomKbn();
            String gyomKbnNm = "";

            // �������[No
            vo.setGpyNo(result.getHb1GpyNo());

            // �������[�sNo
//            vo.setMGpyNo(result.getHb2Sonota2());

            // ��No(��No + "-" + �󒍖���No + "-" + ���㖾��No)
            String jyutNo = result.getHb1JyutNo();      // ��No
            String jyMeiNo = result.getHb1JyMeiNo();    // �󒍖���No
            String urMeiNo = result.getHb1UrMeiNo();    // ���㖾��No
            vo.setJutyuNo(jyutNo + "-" + jyMeiNo + "-" + urMeiNo);

            // �����t���O
            vo.setTouFlg(result.getHb1TouFlg());

            // �������No
            vo.setTJyutNo(result.getHb1TJyutNo());

            // ������󒍖���No
            vo.setTJymeiNo(result.getHb1TJymeiNo());

            // �����攄�㖾��No
            vo.setTUrmeiNo(result.getHb1TUrmeiNo());

            // �Ɩ��敪
            if (GyomKbn.TVTIME.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.TVTIME.getName();            // �e���r�^�C��

            } else if (GyomKbn.TVSPOT.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.TVSPOT.getName();            // �e���r�X�|�b�g

            } else if (GyomKbn.ZASHI.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.ZASHI.getName();             // �G��

            } else if (GyomKbn.SHINBUN.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.SHINBUN.getName();           // �V��

            } else if (GyomKbn.CREATIVE.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.CREATIVE.getName();          // �N���G�[�e�B�u

            } else if (GyomKbn.RADIO.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.RADIO.getName();             // ���W�I

            } else if (GyomKbn.EISEIM.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.EISEIM.getName();            // �q�����f�B�A

            } else if (GyomKbn.OOHM.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.OOHM.getName();              // OOH���f�B�A

            } else if (GyomKbn.INTERACTIVEM.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.INTERACTIVEM.getName();      // �C���^���N�e�B�u���f�B�A

            } else if (GyomKbn.SONOTAM.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.SONOTAM.getName();           // ���̑����f�B�A

            } else if (GyomKbn.MPLAN.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.MPLAN.getName();             // ���f�B�A�v�����j���O

            } else if (GyomKbn.MARKEPROMO.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.MARKEPROMO.getName();        // �}�[�P�e�B���O/�v�����[�V����

            } else if (GyomKbn.SPORTS.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.SPORTS.getName();            // �X�|�[�c

            } else if (GyomKbn.ENTERTAINMENT.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.ENTERTAINMENT.getName();     // �G���^�e�C�����g

            } else if (GyomKbn.SONOTAC.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.SONOTAC.getName();           // ���̑��R���e���c
            }
            vo.setGyomKbn(gyomKbn);
            vo.setGyomKbnNm(gyomKbnNm);

            // �����敪
            String seiKbn = result.getHb1SeiKbn();
            vo.setSeiKbn(result.getHb1SeiKbn());

            // ����
            vo.setKenmei(result.getHb1KKNameKJ());

            // ��ږ�
            vo.setHimoku(result.getHb1HimkNmKJ());

            String showNumStr = result.getShubetsuCd();

            // ���e�P
            vo.setContents1(getContentsProof1(result, showNumStr, seiKbn));

            // ���e�Q
            vo.setContents2(getContentsProof2(result, showNumStr, seiKbn));

            // ���e�R
            vo.setContents3(getContentsProof3(result, showNumStr, seiKbn));

            // ���e�S
            vo.setContents4(getContentsProof4(result, showNumStr, seiKbn));

            // ���z
            vo.setKngk(result.getHb1SeiGak());

            // ����Ŋz
            vo.setTax(result.getHb1SzeiGak());

            // ����
//            vo.setBusho(result.getHb2Name11());

            // �������ʒ���̏�Ԃɂ���
            ModelUtils.copyMemberSearchAfterInstace(vo);
            list.add(vo);
        }

        return list;
    }

    /**
     * ���e�P�ɕ\�����镶������擾����(�v���[�t���X�g)
     *
     * @param vo  ���׃f�[�^
     * @param showNum ��ʕ\����
     * @param seiKbn  �����敪
     *
     * @return String ���e�P
     */
    private String getContentsProof1(ReportUniVO vo, String showNum, String seiKbn) {

        String ret = "";

        // �e���r�ԑg�A�e���r����
        if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNum) || ReportUniDAO.IDX_TV_TOKUBAN.equals(showNum)) {
            // �^�C��
            if (SeiKbn.TIME.getCode().equals(seiKbn)) {

                String field8 = vo.getHb1Field8();
                String field7 = vo.getHb1Field7();

                // ���������Z�b�g
                // �������uYYYYMM�v�`���A�������u00000���00000�v�`�� �� �uM���ED���A���D���v�`���ɂ���
                if (!field8.equals("") && field8.substring(0, 6).length() == 6 &&
                    !field7.equals("") && field7.length() == 31) {

                    String temp = field8.substring(4, 6);
                    if (temp.substring(0, 1).equals("0"))
                    {
                        temp = temp.substring(1, 2);
                    }

                    ret = temp + "���E" + changeDate(field7);
                }
            }

        // �e���r�X�|�b�g
        } else if (ReportUniDAO.IDX_TV_SPOT.equals(showNum)) {
            // �X�|�b�g
            if (SeiKbn.SPOT.getCode().equals(seiKbn)) {
                // �������Ԃ��Z�b�g
                // �������ԁuYYYYMMDDYYYYMMDD�v�`�� �� �uM/D-M/D�v�`���ɂ���
                ret = changeDate(vo.getHb1Field4());
            }

        // �G��
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum)) {
            // �G��
            if (SeiKbn.MAGAZINE.getCode().equals(seiKbn)) {
                ret = vo.getHb1Field2();
            }

        // �V��
        } else if (ReportUniDAO.IDX_SHINBUN.equals(showNum)) {
            // �V��
            if (SeiKbn.NEWSPAPER.getCode().equals(seiKbn)) {
                ret = vo.getHb1Field2();
            }

        // ���̑�
        } else {

            // �����
            if (SeiKbn.WORKS.getCode().equals(seiKbn)) {
                ret = "";

            // ����(����Ɓj
            } else if (SeiKbn.KWORKS.getCode().equals(seiKbn)) {
                ret = vo.getHb1Field3();

            // ��L�ȊO
            } else {
                ret = vo.getHb1Field2();
            }
        }

        return ret;
    }

    /**
     * ���e�Q�ɕ\�����镶������擾����(�v���[�t���X�g)
     *
     * @param vo  ���׃f�[�^
     * @param showNum ��ʕ\����
     * @param seiKbn  �����敪
     *
     * @return String ���e�Q
     */
    private String getContentsProof2(ReportUniVO vo, String showNum, String seiKbn) {

        String ret = "";

        // �e���r�X�|�b�g
        if (ReportUniDAO.IDX_TV_SPOT.equals(showNum)) {

            // �X�|�b�g
            if (SeiKbn.SPOT.getCode().equals(seiKbn)) {

                String field2 = vo.getHb1Field2();
                String field3 = vo.getHb1Field3();

                // �s�u �r�o�n�s �̏ꍇ
                // �����ǖ� + �ǐ����Z�b�g
                //�u"�����ǖ�" �� "�ǐ�" �ǁv�`���ɂ���   ��j���ޒ�����22��
                if (!field2.equals("")) {
                    ret += field2 + "��";
                }

                if (!field3.equals("")) {
                    DecimalFormat df = new DecimalFormat("#,##0");
                    ret += df.format(Integer.valueOf(field3)) + "��";
                }
            }

        // �G��
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum)) {
            // �G��
            if (SeiKbn.MAGAZINE.getCode().equals(seiKbn)) {
                // ���������Z�b�g
                // ���ԁuYYYYMMDD�v�`�� �� �uM��D���v�`���ɂ���
                ret = changeDate(vo.getHb1Field3());
            }

        // �V��
        } else if (ReportUniDAO.IDX_SHINBUN.equals(showNum)) {
            // �V��
            if (SeiKbn.NEWSPAPER.getCode().equals(seiKbn)) {
                // �A�ړ����Z�b�g
                // ���ԁuYYYYMMDD�v�`�� �� �uM��D���v�`���ɂ���
                ret = changeDate(vo.getHb1Field3());
            }

        // ����
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {
            // �����
            if (SeiKbn.WORKS.getCode().equals(seiKbn)) {
                String field3 = vo.getHb1Field3();
                if (!field3.equals("")) {
                    ret = field3;
                }
            }

        // ���̑�
        } else if (ReportUniDAO.IDX_SONOTA.equals(showNum)) {

            // ���Ԃ��Z�b�g
            // ���ԁuYYYYMMDDYYYYMMDD�v�`�� �� �uM/D-M/D�v�`���ɂ���

            // �^�C��
            if (SeiKbn.TIME.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field8());

            // �X�|�b�g�A����(����Ɓj
            } else if (SeiKbn.SPOT.getCode().equals(seiKbn) ||
                       SeiKbn.KWORKS.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field4());

            // �G��
            } else if (SeiKbn.MAGAZINE.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field10());

            // �V��
            } else if (SeiKbn.NEWSPAPER.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field12());

            // ����ƁAIC�AOOH
            } else if (SeiKbn.WORKS.getCode().equals(seiKbn) ||
                       SeiKbn.IC.getCode().equals(seiKbn) ||
                       SeiKbn.OOH.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field5());

            // ���ۃ}�X
            } else if (SeiKbn.KMAS.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field3());
            }
        }

        return ret;
    }

    /**
     * ���e�R�ɕ\�����镶������擾����(�v���[�t���X�g)
     *
     * @param vo ���׃f�[�^
     * @param showNum ��ʕ\����
     * @param seiKbn  �����敪
     *
     * @return String ���e�R
     */
    private String getContentsProof3(ReportUniVO vo, String showNum, String seiKbn) {

        String ret = "";

        // �G��
        if (ReportUniDAO.IDX_ZASHI.equals(showNum)) {
            // �G��
            if (SeiKbn.MAGAZINE.getCode().equals(seiKbn)) {
                ret = vo.getHb1Field4();
            }

        // ����
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {
            // �����
            if (SeiKbn.WORKS.getCode().equals(seiKbn)) {

                BigDecimal seiTnka = vo.getHb1SeiTnka();

                if (seiTnka.compareTo(BigDecimal.ZERO) > 0) {

                    // �u0�v�ȊO�̏ꍇ�͒P�����Z�b�g
                    DecimalFormat df = new DecimalFormat("#,###");
                    ret = df.format(seiTnka);
                }
            }
        } else {
           ret = "";
        }

        return ret;
    }

    /**
     * ���e�S�ɕ\�����镶������擾����(�v���[�t���X�g)
     *
     * @param vo ���׃f�[�^
     * @param showNum ��ʕ\����
     * @param seiKbn  �����敪
     *
     * @return String ���e�S
     */
    private String getContentsProof4(ReportUniVO vo, String showNum, String seiKbn) {

        String ret = "";

        // �e���r�ԑg�A�e���r����
        if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNum) || ReportUniDAO.IDX_TV_TOKUBAN.equals(showNum)) {
            // �^�C��
            if (SeiKbn.TIME.getCode().equals(seiKbn)) {

                String field6 = vo.getHb1Field6().trim();

                // �����񐔂��Z�b�g
                // �u"������" ��v�`���ɂ���
                if (!field6.equals("")) {
                    int val = Integer.valueOf(field6);
                    if (val != 0) {
                        DecimalFormat df = new DecimalFormat("#,###");
                        ret = df.format(Integer.valueOf(field6)) + "��";
                    }
                }
            }

        // �G��
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum)) {
            // �G��
            if (SeiKbn.MAGAZINE.getCode().equals(seiKbn)) {

                String field9 = vo.getHb1Field9();
                String field8 = vo.getHb1Field8();

                // �X�y�[�X�ƌf�ڏ������Z�b�g
                if (!field9.equals("")) {
                    ret = field9 + field8;
                }
            }

        // �V��
        } else if (ReportUniDAO.IDX_SHINBUN.equals(showNum)) {
            // �V��
            if (SeiKbn.NEWSPAPER.getCode().equals(seiKbn)) {

                String field11 = vo.getHb1Field11();

                // �X�y�[�X���Z�b�g
                if (!field11.equals("")) {
                    ret = field11;
                }
            }

        // ����
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {
            // �����
            if (SeiKbn.WORKS.getCode().equals(seiKbn)) {

                String field6 = vo.getHb1Field6().trim();

                // �񐔐��ʂ��Z�b�g
                // �u"�񐔐���" �{�v�`���ɂ���
                if (!field6.equals("")) {
                    int val = Integer.valueOf(field6);
                    if (val != 0) {
                        DecimalFormat df = new DecimalFormat("#,###");
                        ret = df.format(Integer.valueOf(field6)) + "�{";
                    }
                }
            }
        }

        return ret;
    }

    /**
     * �����̕�����̒����ɂ����t�`���ɕϊ������l��Ԃ��B
     *
     * @param dateStr �ϊ��Ώە�����
     * @return String �ϊ���̒l
     */
    private String changeDate(String dateStr) {

        String ret = "";
        StringBuffer temp = new StringBuffer();

        // �uYYYYMMDD�v�`�� �� �uM��D���v�`���ɂ���
        if (!dateStr.trim().equals("") && dateStr.length() == 8) {

            temp.append(Integer.valueOf(dateStr.substring(4, 6)));
            temp.append("��");
            temp.append(Integer.valueOf(dateStr.substring(6, 8)));
            temp.append("��");

            ret = temp.toString();
        }

        // �uYYYYMMDDYYYYMMDD�v�`�� �� �uM/D-M/D�v�`���ɂ���
        else if (!dateStr.trim().equals("") && dateStr.length() == 16) {

            temp.append(Integer.valueOf(dateStr.substring(4, 6)));
            temp.append("/");
            temp.append(Integer.valueOf(dateStr.substring(6, 8)));
            temp.append("-");
            temp.append(Integer.valueOf(dateStr.substring(12, 14)));
            temp.append("/");
            temp.append(Integer.valueOf(dateStr.substring(14, 16)));

            ret = temp.toString();
        }

        else if(!dateStr.trim().equals("") && dateStr.length() == 31) {

            // �����̍������1���������ɔ�����s��
            for (int i = 0; i < dateStr.length(); i++) {

                // ���蕶���̔����o��
                String s = dateStr.substring(i, i + 1);
                if (s.equals("1")) {
                    temp.append(String.valueOf(i+1) + "���A");
                }
            }
            // ������̖����u�A�v���폜���Đݒ�
            ret = temp.toString().substring(0, temp.lastIndexOf("�A"));
        }

        return ret;
    }

    /**
     * ��������w�肵���o�C�g���ɂȂ�悤��Space���߂��s��
     *
     * @param str �ϊ��O������
     * @param length �w��o�C�g��
     * @param spc
     *         True�FSpace��ϊ��O������̑O�ɃZ�b�g
     *         False�FSpace��ϊ��O������̌�ɃZ�b�g
     * @return
     */
    private String contentsAddSpace(String str, int length, Boolean spc) {

        String ret = "";
        int len = 0;

        if (length <= str.length()) {
            // �ύX�O������̃o�C�g�����A�w��o�C�g���ȏ�̏ꍇ
            ret = str;

        } else {
            // �ʏ폈���i�w��o�C�g���ɂȂ�悤��Space���߁j
            len = length - str.getBytes().length;

            String space = "";
            // �w��o�C�g������Space�𐶐�
            for (int i =0; i< len; i++) {
                space += " ";
            }

            if (spc) {
                // Space�𕶎���̑O�ɃZ�b�g
                ret = space + str;

            } else {
                // Space�𕶎���̌�ɃZ�b�g
                ret = str + space;
            }
        }

        return ret;
    }

    // 2013/01/09 JSE M.Naito add
    /**
     * ��������`����ϊ������`�ŕԂ�
     * @param str �ϊ��O������
     * @return ret �ϊ��㕶����
     */
    private String changeStr(String str1, String str2) {

        String ret = "";

        if (!str1.equals("") && str1.length() == 10) {
            // �������[No��10�����̏ꍇ�i����j �u999999-9999�v�`��
            ret += str1.substring(0, 6);
            ret += "-";
            ret += str1.substring(6, 10);

        } else {
            // �������[No��10�����ȊO�̏ꍇ�i�ُ�j �ϊ������ɃZ�b�g
            ret = str1;
        }

        if (!str2.equals("")) {
            // �������[�s�ԍ������݂���ꍇ
            ret += "-";
            ret += str2;
        }

        return ret;
    }

}
