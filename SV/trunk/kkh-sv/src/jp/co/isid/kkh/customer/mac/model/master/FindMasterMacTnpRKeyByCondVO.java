package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.kkh.integ.tbl.TBTHB17RMTNP;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u���L�[����VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 *
 * @author
 */
public class FindMasterMacTnpRKeyByCondVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindMasterMacTnpRKeyByCondVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindMasterMacTnpRKeyByCondVO();
    }

    /**
     * �X�V���{�L�[��ݒ肵�܂��B
     *
     * @param val String �X�V���{�L�[
     */
    public void setUpdRrkTimstmp(String val) {
        set(TBTHB17RMTNP.UPDRRKTIMSTMP, val);
    }

    /**
     * �X�V���{�L�[��Ԃ��܂��B
     *
     * @return String �X�V���{�L�[
     */
    public String getUpdRrkTimstmp() {
        return (String) get(TBTHB17RMTNP.UPDRRKTIMSTMP);
    }

    /**
     * ��荞�ݍX�V�t���O��ݒ肵�܂��B
     *
     * @param val String ��荞�ݍX�V�t���O
     */
    public void setTorikomiFlg(String val) {
        set(TBTHB17RMTNP.TORIKOMIFLG, val);
    }

    /**
     * ��荞�ݍX�V�t���O��Ԃ��܂��B
     *
     * @return String ��荞�ݍX�V�t���O
     */
    public String getTorikomiFlg() {
        return (String) get(TBTHB17RMTNP.TORIKOMIFLG);
    }

}
