package jp.co.isid.kkh.customer.acom.model.claim;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * �����f�[�^����ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://claim.model.acom.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://claim.model.acom.customer.kkh.isid.co.jp/")
public class FindClaimByCondResult extends AbstractServiceResult {

    /** ����/�����ԍ� �ꗗ���VO���X�g */
    private List<FindClaimNoCondResultVO> _claimNoList;
    /** ����/���� ���وꗗ���VO���X�g */
    private List<FindClaimDiffCondResultVO> _claimDiffList;
    /** �����f�[�^ �ꗗ���VO���X�g */
    private List<FindClaimCondResultVO> _claimList;

    /**
     * ����/�����ԍ� �ꗗ���VO���X�g���擾���܂��B
     *
     * @return _list
     */
    public List<FindClaimNoCondResultVO> getClaimNoDataList() {
        return _claimNoList;
    }

    /**
     * ����/�����ԍ� �ꗗ���VO���X�g��ݒ肵�܂��B
     *
     * @param list
     */
    public void setClaimNoDataList(List<FindClaimNoCondResultVO> list) {
        _claimNoList = list;
    }

    /**
     * ����/���� ���وꗗ���VO���X�g���擾���܂��B
     *
     * @return _list
     */
    public List<FindClaimDiffCondResultVO> getClaimDiffDataList() {
        return _claimDiffList;
    }

    /**
     * ����/���� ���وꗗ���VO���X�g��ݒ肵�܂��B
     *
     * @param list
     */
    public void setClaimDiffDataList(List<FindClaimDiffCondResultVO> list) {
        _claimDiffList = list;
    }

    /**
     * �����f�[�^ �ꗗ���VO���X�g���擾���܂��B
     *
     * @return _list
     */
    public List<FindClaimCondResultVO> getClaimDataList() {
        return _claimList;
    }

    /**
     * �����f�[�^ �ꗗ���VO���X�g��ݒ肵�܂��B
     *
     * @param list
     */
    public void setClaimDataList(List<FindClaimCondResultVO> list) {
        _claimList = list;
    }

}
