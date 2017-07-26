package jp.co.isid.kkh.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.base.ErrorInfo;

/**
 * <P>
 * Web�T�[�r�X�̏������ʂ�ێ����钊�ۃN���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2010/12/13 ISID-IT K.Nukita)<BR>
 * </P>
 * @author ISID-IT K.Nukita
 */
@XmlRootElement(namespace = "http://model.kkh.isid.co.jp/")
@XmlType(namespace = "http://model.kkh.isid.co.jp/")
public abstract class AbstractServiceResult {

    /** �G���[��� */
    private ErrorInfo _errorInfo = new ErrorInfo();

    /**
     * �G���[����Ԃ��܂��B
     * @return �G���[���
     */
    public ErrorInfo getErrorInfo() {
        return _errorInfo;
    }

    /**
     * �G���[����ݒ肵�܂��B
     * @param errorInfo �G���[���
     */
    public void setErrorInfo(ErrorInfo errorInfo) {
        _errorInfo = errorInfo;
    }

    /**
    * �G���[���ۂ����擾���܂��B
    * @return �G���[���ۂ�
    */
    public boolean isError() {

        if (_errorInfo == null) {
            return false;
        }
        return _errorInfo.isError();
    }

    /**
    * KKHException������ErrorInfo��ݒ肵�܂��B
    * @param e KKHException
    */
    public void toErrorInfo(KKHException e) {
        ErrorInfo info = new ErrorInfo();
        info.setError(true);
        info.setErrorCode(e.getErrorID());
        info.setNote(e.getNoteList());
        this.setErrorInfo(info);
    }
}
