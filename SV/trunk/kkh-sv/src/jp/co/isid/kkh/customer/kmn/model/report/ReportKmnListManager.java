package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.ArrayList;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 *
 * <P>
 * ���[�i����_�����ꗗ�j�f�[�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class ReportKmnListManager {

    /** �V���O���g���C���X�^���X */
    private static ReportKmnListManager _manager = new ReportKmnListManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportKmnListManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportKmnListManager getInstance() {
        return _manager;
    }

    /**
     * ���[(����_�����ꗗ)���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportKmnListResult findByCondition(ReportKmnListCondition cond) throws KKHException {

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
        //��������
        ReportKmnListResult result = new ReportKmnListResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        ReportKmnListDAO reportKmnListDAO = ReportKmnListDAOFactory.createFindReportKmnListDAO();

        List<ReportKmnListVO> list = reportKmnListDAO.findReportKmnListByCondition(cond);

        if(cond.getOutput().equals("����")){

            result.setRptList(list);

        }else if(cond.getOutput().equals("����")){

            List<ReportKmnListVO> list2 = reportKmnListDAO.findReportKmnListByCondition2(cond);
            result.setRptList(getMeisai(list,list2));
        }

        return result;
    }

    /**
     * ���׃f�[�^���擾����
     *
     * @param hashList   �������ʁi���ׂƖ��ׂɕR�Â��󒍁j
     * @return List      ���׃f�[�^�݂̂ɂ�����������
     */
    private List<ReportKmnListVO> getMeisai(List<ReportKmnListVO> hashList, List<ReportKmnListVO> hashList2) {

        // ���X�g������
        List<ReportKmnListVO> list = new ArrayList<ReportKmnListVO>();
        List<ReportKmnListVO> reslist = new ArrayList<ReportKmnListVO>();
        ReportKmnListVO result = new ReportKmnListVO();
        ReportKmnListVO result_tmp = new ReportKmnListVO();

        // �������ʂ��疾�׃f�[�^����vo�ɃZ�b�g����
        for(int i = 0; i < hashList.size(); i++){

            // ������
            result = new ReportKmnListVO();
            // �������ʂ����s�擾
            result = hashList.get(i);

            // �����^�������t���O(true:������ false:����)
            boolean miTflg = true;

            // �����f�[�^���`�F�b�N
            for(int j = 0; j < hashList2.size(); j++){

                // ������
                result_tmp = new ReportKmnListVO();
                // ��s�擾
                result_tmp = hashList2.get(j);

                if(result.getJyutNo().equals(result_tmp.getDTJyutNo())){

                    // �����f�[�^�̂��߃t���Ofalse��ݒ�
                    miTflg = false;

                    // �����f�[�^�̏ꍇ
                    // ��������f�[�^���擾���Ă��邩�`�F�b�N
                    if(result_tmp.getSkJyutNo().trim().length() > 0){

                        // �擾�ł��Ă���ꍇ
                        result.setSeiZumi("��");

                    }else{

                        // �擾�ł��Ă��Ȃ��ꍇ
                        result.setSeiZumi("");
                        // ���[�v���甲���Ď��̃f�[�^��
                        break;
                    }
                }
            }
            // �������f�[�^�̏ꍇ
            if(miTflg){

                // ��������f�[�^���擾���Ă��邩�`�F�b�N
                if(!result.getSeiZumi().equals("0")){

                    // �擾�ł��Ă���ꍇ
                    result.setSeiZumi("��");

                }else{

                    // �擾�ł��Ă��Ȃ��ꍇ
                    result.setSeiZumi("");
                }
            }

            // ���X�g�Ɋi�[
            list.add(result);
        }

        boolean flg1 = false;
        boolean flg2 = false;

        // ���X�g�̐����܂킷
        for(int k = 0; k < list.size(); k++){

            ReportKmnListVO res = new ReportKmnListVO();
            // ���X�g�����s�擾
            res = list.get(k);

            // �ŏ��̃��[�v�����ԋp�p���X�g�Ɋi�[
            if(!flg1){
                reslist.add(res);
                flg1 = true;
            }

            // �ԋp�p���X�g�̐����܂킷
            for(int l = 0; l < reslist.size(); l++){

                ReportKmnListVO res_l = new ReportKmnListVO();
                // ���X�g�����s�擾
                res_l = reslist.get(l);

                flg2 = false;

                // �ԋp�p���X�g�Ɏ�No,�󒍖���No,���㖾��No����v����f�[�^�̑��݃`�F�b�N
                if(res.getJyutNo().equals(res_l.getJyutNo()) &&
                        res.getJyMeiNo().equals(res_l.getJyMeiNo()) &&
                        res.getUrMeiNo().equals(res_l.getUrMeiNo())){

                    // ���݂���ꍇ�͎��̃f�[�^��
                    flg2 = true;
                    break;
                }
            }

            // �ԋp�p���X�g�ɑ��݂��Ȃ��ꍇ�͒ǉ����Ă��玟�̃f�[�^��
            if(!flg2){

                // �ԋp�p���X�g�Ɋi�[
                reslist.add(res);
            }
        }

        return reslist;
    }

}
