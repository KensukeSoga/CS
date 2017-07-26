package jp.co.isid.kkh.model.login;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �J�����Ӑ����ێ�����B
* </P>
* <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
*/
@XmlRootElement(namespace = "http://login.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://login.model.kkh.isid.co.jp/")
public class OpenCustomerInfoResult extends AbstractServiceResult {

    /** ��ʕ\���t���O */
    private String _disFlg = null;

    /**
     * ��ʕ\���t���O���擾����
     * @return ��ʕ\���t���O
     */
    public String getDisFlg() {
        return _disFlg;
    }

    /**
     * ��ʕ\���t���O��ݒ肷��
     * @param disFlg ��ʕ\���t���O
     */
    public void setDisFlg(String disFlg) {
        this._disFlg = disFlg;
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
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}
