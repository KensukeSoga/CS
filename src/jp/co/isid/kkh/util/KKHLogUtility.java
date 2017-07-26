package jp.co.isid.kkh.util;

import org.apache.log4j.Logger;
import jp.co.isid.kkh.model.base.KKHException;

public class KKHLogUtility {

	/**
	 * インスタンス
	 */
	private static KKHLogUtility _Instance = null;

	/**
	 * Logger
	 */
	private Logger _logger;

	/**
	 * コンストラクタ
	 */
	private KKHLogUtility() {
		_logger = Logger.getLogger(KKHLogUtility.class.getName());
	}

	/**
	 * デフォルト出力
	 * @param message
	 */
	public static void outLog(String message) {
		info(message);
	}

	/**
	 * デフォルト出力
	 * @param message
	 */
	public static void outLog(KKHException e) {
		info(e);
	}

	/**
	 * DEBUG出力
	 * @param message
	 */
	public static void debug(String message) {
		if (_Instance == null) {
			_Instance = new KKHLogUtility();
		}
		_Instance._logger.info(message);
	}

	/**
	 * DEBUG出力
	 * @param e
	 */
	public static void debug(KKHException e) {
		debug(e.getMessage());
	}

	/**
	 * INFO出力
	 * @param message
	 */
	public static void info(String message) {
		if (_Instance == null) {
			_Instance = new KKHLogUtility();
		}
		_Instance._logger.info(message);
	}

	/**
	 * INFO出力
	 * @param e
	 */
	public static void info(KKHException e) {
		info(e.getMessage());
	}

	/**
	 * WARN出力
	 * @param message
	 */
	public static void warn(String message) {
		if (_Instance == null) {
			_Instance = new KKHLogUtility();
		}
		_Instance._logger.warn(message);
	}

	/**
	 * WARN出力
	 * @param e
	 */
	public static void warn(KKHException e) {
		warn(e.getMessage());
	}

	/**
	 * ERROR出力
	 * @param message
	 */
	public static void error(String message) {
		if (_Instance == null) {
			_Instance = new KKHLogUtility();
		}
		_Instance._logger.info(message);
	}

	/**
	 * ERROR出力
	 * @param e
	 */
	public static void error(KKHException e) {
		error(e.getMessage());
	}

	/**
	 * FATAL出力
	 * @param message
	 */
	public static void fatal(String message) {
		if (_Instance == null) {
			_Instance = new KKHLogUtility();
		}
		_Instance._logger.fatal(message);
	}

	/**
	 * FATAL出力
	 * @param e
	 */
	public static void fatal(KKHException e) {
		fatal(e.getMessage());
	}
}
