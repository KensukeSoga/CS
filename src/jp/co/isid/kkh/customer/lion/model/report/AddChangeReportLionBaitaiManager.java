package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���C�I�����[(�ǉ��ύX���X�g)����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionBaitaiManager {

    /** �V���O���g���C���X�^���X */
    private static AddChangeReportLionBaitaiManager _manager = new AddChangeReportLionBaitaiManager();

    /**
     * �������
     */
    /** �����^�C���X�^���v */
    private static final String RRKTIMSTMP = "RRKTIMSTMP";
    /** �ǉ��ύX���X�g */
    private static final String BAITAI = "BAITAI";

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private AddChangeReportLionBaitaiManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * @return �C���X�^���X
     */
    public static AddChangeReportLionBaitaiManager getInstance() {
        return _manager;
    }

    /**
     * ���C�I�����[�f�[�^(�ǉ��ύX���X�g)���������܂��B
     * @param ���C�I�����[(���쎺���X�g�E�ǉ��ύX���X�g)�f�[�^��������
     * @return ReportAshMediaResult �}�̎�ʈꗗ�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public AddChangeReportLionBaitaiResult findByCondition(AddChangeReportLionBaitaiCondition cond) throws KKHException {

        // �p�����[�^�̕K�{�`�F�b�N
        if (!CheckParameter(cond)) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        AddChangeReportLionBaitaiResult result = new AddChangeReportLionBaitaiResult();
        AddChangeReportLionBaitaiDAO dao = AddChangeReportLionBaitaiDAOFactory.createDAO();

        //�����^�C���X�^���v�̏ꍇ
        if (cond.getFindType().equals(RRKTIMSTMP)) {
            //�����J�n
            List<AddChangeReportLionBaitaiVO> list = dao.findAddChangeReportBaitai(cond);
            //�������ʊi�[
            result.setRrkTimStmpInfo(list);
        }
        //�ǉ��ύX���X�g�̏ꍇ
        else if (cond.getFindType().equals(BAITAI)) {
            //AD1�����J�n
            List<AddChangeReportLionBaitaiVO> list2 = dao.findAddChangeReportBaitai(cond);
            //�������ʊi�[
            result.setBaitaiAD1Info(list2);

            //�����擾(��������)
            List<AddChangeReportLionBaitaiVO> list3 = dao.findAddChangeReportBaitaiDiffInternal(cond);
            //�������ʊi�[
            result.setBaitaiDiffInfoInternal(list3);

            //�����擾
            List<AddChangeReportLionBaitaiVO> list4 = dao.findAddChangeReportBaitaiDiffExternal(cond);
            //�������ʊi�[
            result.setBaitaiDiffInfoExternal(list4);

            //AD2�����J�n
            cond.setRrkTimStmp(null);   //�����^�C���X�^���v������
            List<AddChangeReportLionBaitaiVO> list = dao.findAddChangeReportBaitai(cond);
            //�������ʊi�[
            result.setBaitaiAD2Info(list);
        }

        return result;
    }

    /**
     * �p�����[�^�K�{�`�F�b�N
     * @param cond ���C�I����������
     * @return True: OK�AFalse: NG
     */
    private boolean CheckParameter(AddChangeReportLionBaitaiCondition cond) {

        //ESQ-ID
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            return false;
        }
        //�c�Ə��R�[�h
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            return false;
        }
        //���Ӑ��ƃR�[�h
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            return false;
        }
        //���Ӑ敔��SEQNO
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            return false;
        }
        //���Ӑ�S��SEQNO
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            return false;
        }
        //�N��
        if (cond.getYymm() == null || cond.getYymm().equals("")) {
            return false;
        }
        //�������
        if (cond.getFindType() == null || cond.getFindType().equals("")) {
            return false;
        }
        //�����^�C���X�^���v�擾�ȊO�̏ꍇ�A�����^�C���X�^���v�K�{
        if (!cond.getFindType().equals(RRKTIMSTMP)) {
            if (cond.getRrkTimStmp() == null || cond.getRrkTimStmp().equals("")) {
                return false;
            }
        }

        return true;
    }

}
