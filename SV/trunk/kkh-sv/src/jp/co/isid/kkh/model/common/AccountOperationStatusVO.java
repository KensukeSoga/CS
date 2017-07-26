package jp.co.isid.kkh.model.common;

import jp.co.isid.kkh.integ.tbl.TBTKJ99KNR;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �Ɩ���v�ғ���VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/09 JSE H.Abe)<BR>
 * </P>
 * @author
 */
public class AccountOperationStatusVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public AccountOperationStatusVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new AccountOperationStatusVO();
    }

    /**
     * �Ǘ��t���O���擾����
     * @return �Ǘ��t���O
     */
    public String getKanriFlg() {
        return (String) get(TBTKJ99KNR.KANRIFLG);
    }

    /**
     * �Ǘ��t���O��ݒ肷��
     * @param val �Ǘ��t���O
     */
    public void setKanriFlg(String val) {
        set(TBTKJ99KNR.KANRIFLG, val);
    }

}
