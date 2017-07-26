package jp.co.isid.kkh.integ.util;

import java.util.Properties;

import jp.co.isid.kkh.base.KKHServerParameter;
import jp.co.isid.nj.integ.sql.PoolConnect;

/**
 *
 * <P>業務会計コネクション取得クラス</P>
 * <P>
 * 業務会計コネクションクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/23 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class ECPoolConnect extends PoolConnect {

    /** パラメータ */
    private static KKHServerParameter _param = KKHServerParameter.getInstance();

    /**
     * 新規インスタンスを構築します。
     */
    public ECPoolConnect() {
    }

    /**
     * データソースを使用するかどうかを返します。
     *
     * @return true:使用する false:使用しない
     */
    public boolean isDataSourceUse() {
        return _param.isDataSourceUse();
    }

    /**
     * DriverPropertiesを返します。
     *
     * @return Properties
     */
    public Properties getDriverProperties() {
        return _param.getECDriverProperties();
    }

    /**
     * JDBCDriver名を返します。
     *
     * @return JDBCDriver名
     */
    public String getJDBCDriver() {
        return _param.getECDBDriver();
    }

    /**
     * DataSource名を返します。
     *
     * @return DataSource名
     */
    public String getDataSourceName() {
        //return _param.getDataSourceName();
        return _param.getDataSourceR3Name();
    }

    /**
     * URLを返します。
     *
     * @return URL
     */
    public String getURL() {
        return _param.getECDBUrl();
    }

}
