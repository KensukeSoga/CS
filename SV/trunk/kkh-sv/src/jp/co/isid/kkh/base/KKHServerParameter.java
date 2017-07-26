package jp.co.isid.kkh.base;

import java.util.Properties;

import jp.co.isid.nj.util.config.Parameter;
import jp.co.isid.nj.util.config.ParameterFactory;

/**
 *
 * <P>広告費明細システムのパラメータクラス</P>
 * <P>
 * パラメータの情報を保持するクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/01 HLC sonobe)<BR>
 * </P>
 * @author HLC sonobe
 */
public class KKHServerParameter extends Parameter {

    /** serialVersionUID */
    private static final long serialVersionUID = 3286328306385741153L;
    /** システムコード */
    public static final String SYSTEM_CODE = "KKH";

    /**
     * デフォルトコンストラクタです。
     * フレームワークにより呼び出されます。
     */
    public KKHServerParameter() {
    }

    /**
     * インスタンスを返します。
     * @return インスタンス
     */
    public static KKHServerParameter getInstance() {
        return (KKHServerParameter) ParameterFactory.getParameter(SYSTEM_CODE);
    }

    /**
     * データソースの使用有無を返します。
     * @return trueの場合、データソースを使用する
     */
    public boolean isDataSourceUse() {
        String val = (String)getValue("SQLSDataSourceUse");
        return (val != null && "true".equals(val)) ? true : false;
    }

    /**
     * データソース名を返します。
     * @return データソース名
     */
    public String getDataSourceName() {
        return (String)getValue("SQLSDataSourceName");
    }

    /**
     * JDBCDriver名を返します。
     * @return JDBCDriver名
     */
    public String getDBDriver() {
        return (String) getValue("DBDriver");
    }

    /**
     * データベース URL を返します。
     * @return データベース URL
     */
    public String getDBUrl() {
        return (String) getValue("DBUrl");
    }

    /**
     * DB接続プロパティを返します。
     * @return Properties DB 接続プロパティ
     */
    public Properties getDriverProperties() {
        return toProperties((String) getValue("DBKey"), (String) getValue("DBParameter"));
    }

    /**
     * 業務会計データソース名を返します。
     * @return データソース名
     */
    public String getDataSourceR3Name() {
        return (String)getValue("SQLSDataSourceR3Name");
    }

    /**
     * 業務会計JDBCDriver名を返します。
     * @return 業務会計JDBCDriver名
     */
    public String getECDBDriver() {
        return (String) getValue("ECDBDriver");
    }

    /**
     * 業務会計データベースURLを返します。
     * @return 業務会計データベースURL
     */
    public String getECDBUrl() {
        return (String) getValue("ECDBUrl");
    }

    /**
     * 業務会計DB接続プロパティを返します。
     * @return 業務会計DB接続プロパティ
     */
    public Properties getECDriverProperties() {
        return toProperties((String) getValue("ECDBKey"), (String) getValue("ECDBParameter"));
    }

    /**
     * カンマ区切りのキーと値をPropertiesオブジェクトに変換して返します
     *
     * @param strKeys String キーのカンマ区切り文字列
     * @param strValues String 値のカンマ区切り文字列
     * @return Properties 変換後のPropertiesオブジェクト
     */
    private Properties toProperties(String strKeys, String strValues) {
        Properties props = null;
        String[] keys = getCommaString2Array(strKeys);
        String[] values = getCommaString2Array(strValues);
        // パラメータのセット
        if (haveKeys(keys)) {
            props = new Properties();
            for (int i = 0; i < keys.length; i++) {
                props.setProperty(keys[i], values[i]);
            }
        }
        return props;
    }

    /**
     * キーを保持しているかを判定します。
     *
     * @param keys String[] キー
     * @return true:保持している false:保持していない
     */
    private boolean haveKeys(String[] keys) {
        return (keys != null) && (keys.length != 0);
    }

    /**
     * CommandInvoker 名を返します。
     * @return CommandInvoker 名
     */
    public String getCommandInvokerName() {
        return "forServer";
    }

    /**
     * Log4jの設定ファイルのパスを返します。
     * @return Log4jの設定ファイルのパス
     */
    public String getLog4jXMLPath() {
        return (String)getValue("Log4jXMLPath");
    }


}
