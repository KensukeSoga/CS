package jp.co.isid.kkh.model.base;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.nj.exp.UserException;

/**
 *
 * <P>KKH�G���[�N���X</P>
 * <P>
 * KKH�T�[�o�������Ŕ��������Ɩ��I�ȗ�O��\���N���X�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/04 HLC sonobe)<BR>
 * </P>
 * @author HLC sonobe
 */
public class KKHException extends UserException {

    private static final long serialVersionUID = 1L;

    /** �G���[ID */
    private String _errorID;

    /** �m�[�g */
    private List<String> _noteList = new ArrayList<String>();

    /**
    * �V�K�C���X�^���X���\�z���܂��B<br>
    * message��UI�ɂ͖߂���܂���B<br>
    *
    * @param message message
    */
    public KKHException(String message) {
        super(message);
    }

    /**
    * �V�K�C���X�^���X���\�z���܂��B<br>
    * message��UI�ɂ͖߂���܂���B<br>
    * UI�ɂ́AerrorID�ɑ������郁�b�Z�[�W���\������܂��B<br>
    *
    * @param message message
    * @param errorID errorID
    */
    public KKHException(String message, String errorID) {
        super(message);
        _errorID = errorID;
    }

    /**
    * �V�K�C���X�^���X���\�z���܂��B
    *
    * @param cause �����̗�O
    */
    public KKHException(Throwable cause) {
        super(cause);
    }

    /**
    * �V�K�C���X�^���X���\�z���܂��B
    *
    * @param message �G���[���b�Z�[�W
    * @param cause �����̗�O
    */
    public KKHException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
    * errorID��߂��܂��B
    *
    * @return errorID
    */
    public String getErrorID() {
        return _errorID;
    }

    /**
    * errorID���Z�b�g���܂��B
    * @param errorID errorID
    */
    public void setErrorID(String errorID) {
        _errorID = errorID;
    }

    /**
    * noteList��߂��܂��B
    *
    * @return noteList
    */
    public List<String> getNoteList() {
        return _noteList;
    }

    /**
    * noteList���Z�b�g���܂��B
    * @param noteList noteList
    */
    public void setNoteList(List<String> noteList) {
        _noteList = noteList;
    }

    /**
    * �m�[�g��ǉ����܂��B
    * @param note note
    */
    public void addNote(String note) {
        _noteList.add(note);
    }

}