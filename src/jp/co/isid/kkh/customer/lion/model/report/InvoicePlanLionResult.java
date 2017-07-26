package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ���C�I���������\��\�������ʕێ��N���X
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
* </P>
*
* @author HLC S.Fujimoto
*/
@XmlRootElement(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.lion.customer.kkh.isid.co.jp/")
public class InvoicePlanLionResult extends AbstractServiceResult{

    /** ���C�I�������\��\��������VO���X�g */
    private List<InvoicePlanLionVO> _vo;

    /**
     * ���C�I�������\��\�f�[�^���擾����
     * @return ���C�I�������\��\�f�[�^
     */
    public List<InvoicePlanLionVO> getInvoicePlanInfo() {
        return _vo;
    }

    /**
     * ���C�I�������\��\�f�[�^��ݒ肷��
     * @param val List<InvoicePlanLionVO> ���C�I�������\��\�f�[�^
     */
    public void setInvoicePlanInfo(List<InvoicePlanLionVO> val) {
        _vo = val;
    }

    /** List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ� */
    private String _dummy;

    /**
     * List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ����擾���܂��B
     * @return String �_�~�[�v���p�e�B
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * List�����ł�Web�T�[�r�X�Ɍ��J����Ȃ��̂Ń_�~�[�v���p�e�B��ǉ���ݒ肵�܂��B
     * @param dummy �_�~�[�v���p�e�B
     */
    public void setDummy(String val) {
        _dummy = val;
    }

}
