package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBTHBCKHT;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �J�����Ӑ�Ǘ����VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class ThbcKhtVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ThbcKhtVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ThbcKhtVO();
    }

    /**
     * ��ʕ\���t���O���擾����
     * @return ��ʕ\���t���O
     */
    public String getDisFlg() {
        return (String) get(TBTHBCKHT.DISFLG);
    }

    /**
     * ��ʕ\���t���O��ݒ肷��
     * @param val ��ʕ\���t���O
     */
    public void setDisFlg(String val) {
        set(TBTHBCKHT.DISFLG, val);
    }

}
