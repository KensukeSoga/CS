package jp.co.isid.kkh.integ.util;

import java.util.Properties;

import jp.co.isid.kkh.base.KKHServerParameter;
import jp.co.isid.nj.integ.sql.PoolConnect;

/**
 *
 * <P>�Ɩ���v�R�l�N�V�����擾�N���X</P>
 * <P>
 * �Ɩ���v�R�l�N�V�����N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/23 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class ECPoolConnect extends PoolConnect {

    /** �p�����[�^ */
    private static KKHServerParameter _param = KKHServerParameter.getInstance();

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ECPoolConnect() {
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
        return _param.getECDriverProperties();
    }

    /**
     * JDBCDriver����Ԃ��܂��B
     *
     * @return JDBCDriver��
     */
    public String getJDBCDriver() {
        return _param.getECDBDriver();
    }

    /**
     * DataSource����Ԃ��܂��B
     *
     * @return DataSource��
     */
    public String getDataSourceName() {
        //return _param.getDataSourceName();
        return _param.getDataSourceR3Name();
    }

    /**
     * URL��Ԃ��܂��B
     *
     * @return URL
     */
    public String getURL() {
        return _param.getECDBUrl();
    }

}
