package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 * <P>
 * �L�[�ǂ̔ԑg�R�[�h�̂�ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC ��(Jang)
 */
@XmlRootElement(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
public class FindKeyKyokuBangumiCdResult extends AbstractServiceResult {

    /** �ԑg�R�[�h���X�g */
    private List<FindKeyKyokuBangumiCdVO> _bangumiCdList;

    public List<FindKeyKyokuBangumiCdVO> getBangumiCdList() {
        return _bangumiCdList;
    }

    public void setBangumiCdList(List<FindKeyKyokuBangumiCdVO> val) {
        _bangumiCdList = val;
    }

}
