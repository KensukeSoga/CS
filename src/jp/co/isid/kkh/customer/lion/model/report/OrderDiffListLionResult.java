package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* ���C�I���󒍍��وꗗ�������ʕێ��N���X
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
public class OrderDiffListLionResult extends AbstractServiceResult{

    /** ���C�I���󒍍��وꗗ��������VO���X�g */
    private List<OrderDiffListLionVO> _vo;
    /** ���C�I���V�K�󒍈ꗗ��������VO���X�g */
    private List<OrderDiffListLionVO> _vo2;
    /** ���C�I���󒍋��z���وꗗ��������VO���X�g */
    private List<OrderDiffListLionVO> _vo3;

    /**
     * ���C�I���󒍍��وꗗ�f�[�^���擾����
     * @return List<OrderDiffListLionVO> ���C�I���󒍍��وꗗ�f�[�^
     */
    public List<OrderDiffListLionVO> getOrderDiffListInfo() {
        return _vo;
    }

    /**
     * ���C�I���󒍍��وꗗ�f�[�^��ݒ肷��
     * @param val List<OrderDiffListLionVO> ���C�I���󒍍��وꗗ�f�[�^
     */
    public void setOrderDiffListInfo(List<OrderDiffListLionVO> val) {
        _vo = val;
    }

    /**
     * ���C�I���V�K�󒍈ꗗ�f�[�^���擾����
     * @return List<OrderDiffListLionVO> ���C�I���V�K�󒍈ꗗ�f�[�^
     */
    public List<OrderDiffListLionVO> getNewOrderListInfo() {
        return _vo2;
    }

    /**
     * ���C�I���V�K�󒍈ꗗ�f�[�^��ݒ肷��
     * @param val List<OrderDiffListLionVO> ���C�I���V�K�󒍈ꗗ�f�[�^
     */
    public void setNewOrderListInfo(List<OrderDiffListLionVO> val) {
        _vo2 = val;
    }

    /**
     * ���C�I���󒍋��z���وꗗ�f�[�^���擾����
     * @return List<OrderDiffListLionVO> ���C�I���󒍋��z���وꗗ�f�[�^
     */
    public List<OrderDiffListLionVO> getOrderAmountDiffListInfo() {
        return _vo3;
    }

    /**
     * ���C�I���󒍋��z���وꗗ��ݒ肷��
     * @param val List<OrderDiffListLionVO> ���C�I���󒍋��z���وꗗ�f�[�^
     */
    public void setOrderAmountDiffListInfo(List<OrderDiffListLionVO> val) {
        _vo3 = val;
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
