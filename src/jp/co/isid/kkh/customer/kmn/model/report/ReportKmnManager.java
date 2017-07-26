package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;


public class ReportKmnManager {

    /** �V���O���g���C���X�^���X */
    private static ReportKmnManager _manager = new ReportKmnManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportKmnManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportKmnManager getInstance() {
        return _manager;
    }

    /**
     * ���[�i����_���[�o�́j�f�[�^���������܂��B
     *
     * @return ReportKmnResult ���я����
     * @throws KKHException
     *             �������ɃG���[�����������ꍇ
     */
    public ReportKmnResult findReportKmnByCondition(ReportKmnCondition cond)
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
        ReportKmnResult result = new ReportKmnResult();

        // ��������
        ReportKmnCondition lCond = new ReportKmnCondition();

        ReportKmnDAO dao = ReportKmnDAOFactory.createFindReportKmnDAO();
        lCond = cond;

        // ****************************************************************
        // ���[�i����_�`�[�j�f�[�^�̌���
        // ****************************************************************
        List<ReportKmnVO> list = dao.findReportKmnByCondition(lCond);

        // ****************************************************************
        // ���[�i����_�`�[�j�f�[�^�̌���
        // ****************************************************************
        List<ReportKmnVO> list2 = dao.findReportKmnByCondition2(lCond);

        // ****************************************************************
        // ���[�i����_�`�[�j�f�[�^���擾
        // ****************************************************************
        result.setMeisai(getMeisai(list,list2));

        return result;
    }


    /**
     * ���׃f�[�^���擾����
     *
     * @param hashList   �������ʁi���ׂƖ��ׂɕR�Â��󒍁j
     * @return List      ���׃f�[�^�݂̂ɂ�����������
     */
    private List<ReportKmnMeisaiVO> getMeisai(List<ReportKmnVO> hashList, List<ReportKmnVO> hashList2) {

        // ���X�g������
        List<ReportKmnMeisaiVO> list = new ArrayList<ReportKmnMeisaiVO>();
        ReportKmnMeisaiVO vo = new ReportKmnMeisaiVO();
        ReportKmnVO result = new ReportKmnVO();
        ReportKmnVO result_tmp = new ReportKmnVO();

        // �������ʂ��疾�׃f�[�^����vo�ɃZ�b�g����
        for(int i = 0; i < hashList.size(); i++){

            // ������
            vo = new ReportKmnMeisaiVO();
            result = new ReportKmnVO();
            // �������ʂ����s�擾
            result = hashList.get(i);

            // �����^�������t���O(true:������ false:����)
            boolean miTflg = true;

            // �����f�[�^���`�F�b�N
            for(int j = 0; j < hashList2.size(); j++){

                // ������
                result_tmp = new ReportKmnVO();
                // ��s�擾
                result_tmp = hashList2.get(j);

                if(result.getHb2JyutNo().equals(result_tmp.getHb1TJyutNo())){

                    // �����f�[�^�̂��߃t���Ofalse��ݒ�
                    miTflg = false;

                    // �����f�[�^�̏ꍇ
                    // ��������f�[�^���擾���Ă��邩�`�F�b�N
                    if(result_tmp.getHb14JyutNo().trim().length() > 0){

                        // �擾�ł��Ă���ꍇ
                        vo.setSeiZumi("��");

                    }else{

                        // �擾�ł��Ă��Ȃ��ꍇ
                        vo.setSeiZumi("");
                        // ���[�v���甲���Ď��̃f�[�^��
                        break;
                    }
                }
            }
            // �������f�[�^�̏ꍇ
            if(miTflg){

                // ��������f�[�^���擾���Ă��邩�`�F�b�N
                if(result.getHb14JyutNo().trim().length() > 0){

                    // �擾�ł��Ă���ꍇ
                    vo.setSeiZumi("��");

                }else{

                    // �擾�ł��Ă��Ȃ��ꍇ
                    vo.setSeiZumi("");
                }
            }

            vo.setJyutyuNo(result.getHb2JyutNo());                // ��No
            vo.setJyuMeiNo(result.getHb2JymeiNo());               // �󒍖���No
            vo.setUriMeiNo(result.getHb2UrmeiNo());               // ���㖾��No
            vo.setYyyymm(result.getHb2Yymm());                    // �N��
            vo.setBumonCd(result.getHb2Code1());                  // �R�[�h1
            vo.setOutputNo(result.getHb2Code2());                 // �R�[�h2
            vo.setHinmoku1(result.getHb2Name8());                 // ����8
            vo.setHinmoku2(result.getHb2Name3());                 // ����3
            vo.setHinmoku3(result.getHb2Name4());                 // ����4
            vo.setBumonNm(result.getHb2Name5());                  // ����5
            vo.setAtenaNm(result.getHb2Name16());                  // ����16
            vo.setSZeiGak(result.getHb2Kngk3());                  // ���v����Ŋz
            vo.setKingaku(result.getHb2Seigak());                 // �������z

            //--�����N���\�����@�C���Ή� 2013/07/18 HLC H.Watabe start
            vo.setSeikyuYM(result.getHb2Name6());                   //�����N��
            //--�����N���\�����@�C���Ή� 2013/07/18 HLC H.Watabe end

            // �ԋp�p���X�g�Ɋi�[
            list.add(vo);
        }

        return list;
    }

}
