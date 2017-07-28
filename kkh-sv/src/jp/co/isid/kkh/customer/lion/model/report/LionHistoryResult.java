package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 * <P>
 * ���C�I����������
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 S.Fujimoto)<BR>
 * </P>
 * @author HLC S.Fujimoto
 */
public class LionHistoryResult extends AbstractServiceResult {

    /** ���C�I�������f�[�^�擾VO���X�g */
    private List<LionHistoryVO> _vo;

    /** List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ� */
    private String _dummy;

    /**
     * ���C�I�������f�[�^�擾VO���X�g���擾
     * @return ���C�I�������f�[�^�擾VO���X�g
     */
    public List<LionHistoryVO> getFindLionHistoryInfo() {
        return _vo;
    }

    /**
     * ���C�I�������f�[�^�擾VO���X�g��ݒ�
     * @param val List<LionHistoryVO> ���C�I�������f�[�^�擾VO
     */
    public void setFindLionHistoryInfo(List<LionHistoryVO> val) {
        _vo = val;
    }

    /**
     * �_�~�[�v���p�e�B���擾
     * @return String �_�~�[
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * �_�~�[�v���p�e�B��ݒ�
     * @param val String �_�~�[
     */
    public void setDummy(String val) {
        _dummy = val;
    }

 }
