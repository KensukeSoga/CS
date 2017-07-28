package jp.co.isid.kkh.base;

import java.util.Properties;

import jp.co.isid.nj.util.config.Parameter;
import jp.co.isid.nj.util.config.ParameterFactory;

/**
 *
 * <P>�L����׃V�X�e���̃p�����[�^�N���X</P>
 * <P>
 * �p�����[�^�̏���ێ�����N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/01 HLC sonobe)<BR>
 * </P>
 * @author HLC sonobe
 */
public class KKHServerParameter extends Parameter {

    /** serialVersionUID */
    private static final long serialVersionUID = 3286328306385741153L;
    /** �V�X�e���R�[�h */
    public static final String SYSTEM_CODE = "KKH";

    /**
     * �f�t�H���g�R���X�g���N�^�ł��B
     * �t���[�����[�N�ɂ��Ăяo����܂��B
     */
    public KKHServerParameter() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * @return �C���X�^���X
     */
    public static KKHServerParameter getInstance() {
        return (KKHServerParameter) ParameterFactory.getParameter(SYSTEM_CODE);
    }

    /**
     * �f�[�^�\�[�X�̎g�p�L����Ԃ��܂��B
     * @return true�̏ꍇ�A�f�[�^�\�[�X���g�p����
     */
    public boolean isDataSourceUse() {
        String val = (String)getValue("SQLSDataSourceUse");
        return (val != null && "true".equals(val)) ? true : false;
    }

    /**
     * �f�[�^�\�[�X����Ԃ��܂��B
     * @return �f�[�^�\�[�X��
     */
    public String getDataSourceName() {
        return (String)getValue("SQLSDataSourceName");
    }

    /**
     * JDBCDriver����Ԃ��܂��B
     * @return JDBCDriver��
     */
    public String getDBDriver() {
        return (String) getValue("DBDriver");
    }

    /**
     * �f�[�^�x�[�X URL ��Ԃ��܂��B
     * @return �f�[�^�x�[�X URL
     */
    public String getDBUrl() {
        return (String) getValue("DBUrl");
    }

    /**
     * DB�ڑ��v���p�e�B��Ԃ��܂��B
     * @return Properties DB �ڑ��v���p�e�B
     */
    public Properties getDriverProperties() {
        return toProperties((String) getValue("DBKey"), (String) getValue("DBParameter"));
    }

    /**
     * �Ɩ���v�f�[�^�\�[�X����Ԃ��܂��B
     * @return �f�[�^�\�[�X��
     */
    public String getDataSourceR3Name() {
        return (String)getValue("SQLSDataSourceR3Name");
    }

    /**
     * �Ɩ���vJDBCDriver����Ԃ��܂��B
     * @return �Ɩ���vJDBCDriver��
     */
    public String getECDBDriver() {
        return (String) getValue("ECDBDriver");
    }

    /**
     * �Ɩ���v�f�[�^�x�[�XURL��Ԃ��܂��B
     * @return �Ɩ���v�f�[�^�x�[�XURL
     */
    public String getECDBUrl() {
        return (String) getValue("ECDBUrl");
    }

    /**
     * �Ɩ���vDB�ڑ��v���p�e�B��Ԃ��܂��B
     * @return �Ɩ���vDB�ڑ��v���p�e�B
     */
    public Properties getECDriverProperties() {
        return toProperties((String) getValue("ECDBKey"), (String) getValue("ECDBParameter"));
    }

    /**
     * �J���}��؂�̃L�[�ƒl��Properties�I�u�W�F�N�g�ɕϊ����ĕԂ��܂�
     *
     * @param strKeys String �L�[�̃J���}��؂蕶����
     * @param strValues String �l�̃J���}��؂蕶����
     * @return Properties �ϊ����Properties�I�u�W�F�N�g
     */
    private Properties toProperties(String strKeys, String strValues) {
        Properties props = null;
        String[] keys = getCommaString2Array(strKeys);
        String[] values = getCommaString2Array(strValues);
        // �p�����[�^�̃Z�b�g
        if (haveKeys(keys)) {
            props = new Properties();
            for (int i = 0; i < keys.length; i++) {
                props.setProperty(keys[i], values[i]);
            }
        }
        return props;
    }

    /**
     * �L�[��ێ����Ă��邩�𔻒肵�܂��B
     *
     * @param keys String[] �L�[
     * @return true:�ێ����Ă��� false:�ێ����Ă��Ȃ�
     */
    private boolean haveKeys(String[] keys) {
        return (keys != null) && (keys.length != 0);
    }

    /**
     * CommandInvoker ����Ԃ��܂��B
     * @return CommandInvoker ��
     */
    public String getCommandInvokerName() {
        return "forServer";
    }

    /**
     * Log4j�̐ݒ�t�@�C���̃p�X��Ԃ��܂��B
     * @return Log4j�̐ݒ�t�@�C���̃p�X
     */
    public String getLog4jXMLPath() {
        return (String)getValue("Log4jXMLPath");
    }


}
