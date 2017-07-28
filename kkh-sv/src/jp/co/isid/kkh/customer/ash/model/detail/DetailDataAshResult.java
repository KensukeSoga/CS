package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �L����׃f�[�^�������ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/12/27 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
public class DetailDataAshResult extends AbstractServiceResult {

    /** �Ώ۔}�̃R�[�h */
    private String _targetBaitaiCd;

    /** �L����׃f�[�^VO���X�g */
    private List<DetailDataAshVO> _detailData;

    /**
     * �Ώ۔}�̃R�[�h���擾���܂��B
     * @return
     */
    public String getTargetBaitaiCd() {
        return _targetBaitaiCd;
    }

    /**
     * �Ώ۔}�̃R�[�h��ݒ肵�܂��B
     * @param targetBaitaiCd
     */
    public void setTargetBaitaiCd(String targetBaitaiCd) {
        this._targetBaitaiCd = targetBaitaiCd;
    }

    /**
     * �L����׃e�[�u��(THB2KMEI)VO���X�g���擾���܂��B
     * @return _thb2KmeiList
     */
    public List<DetailDataAshVO> getDetailData() {
        return _detailData;
    }

    /**
     * �L����׃e�[�u��(THB2KMEI)VO���X�g��ݒ肵�܂��B
     * @param thb2KmeiList
     */
    public void setDetailData(List<DetailDataAshVO> detailData) {
        _detailData = detailData;
    }

}
