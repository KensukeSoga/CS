package jp.co.isid.kkh.integ.util;

import java.util.Properties;

import jp.co.isid.nj.integ.sql.PoolConnect;
import jp.co.isid.kkh.base.KKHServerParameter;;

/**
 *
 * <P>�R�l�N�V�����擾�N���X</P>
 * <P>
 * KKH�R�l�N�V�����N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/01 HLC sonobe)<BR>
 * </P>
 * @author HLC sonobe
 */
public class KKHPoolConnect extends PoolConnect {

    /** �p�����[�^ */
    private static KKHServerParameter _param = KKHServerParameter.getInstance();

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public KKHPoolConnect() {
    }

    /**
     * �f�[�^�\�[�X���g�p���邩�ǂ�����Ԃ��܂��B
     *
     * @return true:�g�p���� false:�g�p���Ȃ�
     */
    public boolean isDataSourceUse() {
        return _param.isDataSourceUse();
    }

    /**
     * DriverProperties��Ԃ��܂��B
     *
     * @return Properties
     */
    public Properties getDriverProperties() {
        return _param.getDriverProperties();
    }

    /**
     * JDBCDriver����Ԃ��܂��B
     *
     * @return JDBCDriver��
     */
    public String getJDBCDriver() {
        return _param.getDBDriver();
    }

    /**
     * DataSource����Ԃ��܂��B
     *
     * @return DataSource��
     */
    public String getDataSourceName() {
        return _param.getDataSourceName();
    }

    /**
     * URL��Ԃ��܂��B
     *
     * @return URL
     */
    public String getURL() {
        return _param.getDBUrl();
    }

}
