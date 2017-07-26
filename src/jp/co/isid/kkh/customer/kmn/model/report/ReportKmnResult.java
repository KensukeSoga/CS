package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * ���[�i����_�`�[�j�f�[�^��ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
@XmlRootElement(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
public class ReportKmnResult extends AbstractServiceResult {

    /** ���[�i����_�`�[_���ׁj�f�[�^VO���X�g */
    private List<ReportKmnMeisaiVO> _meisai;

    /**
     * ���[�i����_�`�[_���ׁj�f�[�^VO���X�g���擾���܂��B
     *
     * @return _proofs
     */
    public List<ReportKmnMeisaiVO> getMeisai() {
        return _meisai;
    }

    /**
     * ���[�i����_�`�[_���ׁj�f�[�^VO���X�g��ݒ肵�܂��B
     *
     * @param proofs
     */
    public void setMeisai(List<ReportKmnMeisaiVO> meisai) {
        _meisai = meisai;
    }

}
