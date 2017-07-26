package jp.co.isid.kkh.service.base;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * <P>�G���[���N���X</P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2010/12/06 ISID-IT K.Nukita)<BR>
 * </P>
 * @author ISID-IT K.Nukita
 */
@XmlRootElement(namespace = "http://base.service.kkh.isid.co.jp/")
@XmlType(namespace = "http://base.service.kkh.isid.co.jp/")
public class ErrorInfo {

    /** �G���[���ۂ� */
    private boolean _error;

    /** �G���[�R�[�h */
    private String _errorCode;

    /** ���l */
    private List<String> _note;

    /**
     * �R���X�g���N�^
     *
     */
    public ErrorInfo() {
    }

    /**
     * �G���[���ۂ����擾���܂��B
     * @return �G���[���ۂ�
     */
    public boolean isError() {
        return _error;
    }

    /**
     * �G���[���ۂ���ݒ肵�܂��B
     * @param error �G���[���ۂ�
     */
    public void setError(boolean error) {
        this._error = error;
    }

    /**
     * �G���[�R�[�h���擾���܂��B
     * @return �G���[�R�[�h
     */
    public String getErrorCode() {
        return _errorCode;
    }

    /**
     * �G���[�R�[�h��ݒ肵�܂��B
     * @param errorCode �G���[�R�[�h
     */
    public void setErrorCode(String errorCode) {
        this._errorCode = errorCode;
    }

    /**
     * ���l���擾���܂�
     * @return List<String>�I�u�W�F�N�g
     */
    public List<String> getNote() {
        if (_note == null) {
            _note = new ArrayList<String>();
        }
        return _note;
    }

    /**
     *���l��ݒ肵�܂��B
     * @param note ���l
     */
    public void setNote(List<String> note) {
        _note = note;
    }

}
