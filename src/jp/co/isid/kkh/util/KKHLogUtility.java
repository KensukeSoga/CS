package jp.co.isid.kkh.util;

import org.apache.log4j.Logger;
import jp.co.isid.kkh.model.base.KKHException;

public class KKHLogUtility {

	/**
	 * �C���X�^���X
	 */
	private static KKHLogUtility _Instance = null;

	/**
	 * Logger
	 */
	private Logger _logger;

	/**
	 * �R���X�g���N�^
	 */
	private KKHLogUtility() {
		_logger = Logger.getLogger(KKHLogUtility.class.getName());
	}

	/**
	 * �f�t�H���g�o��
	 * @param message
	 */
	public static void outLog(String message) {
		info(message);
	}

	/**
	 * �f�t�H���g�o��
	 * @param message
	 */
	public static void outLog(KKHException e) {
		info(e);
	}

	/**
	 * DEBUG�o��
	 * @param message
	 */
	public static void debug(String message) {
		if (_Instance == null) {
			_Instance = new KKHLogUtility();
		}
		_Instance._logger.info(message);
	}

	/**
	 * DEBUG�o��
	 * @param e
	 */
	public static void debug(KKHException e) {
		debug(e.getMessage());
	}

	/**
	 * INFO�o��
	 * @param message
	 */
	public static void info(String message) {
		if (_Instance == null) {
			_Instance = new KKHLogUtility();
		}
		_Instance._logger.info(message);
	}

	/**
	 * INFO�o��
	 * @param e
	 */
	public static void info(KKHException e) {
		info(e.getMessage());
	}

	/**
	 * WARN�o��
	 * @param message
	 */
	public static void warn(String message) {
		if (_Instance == null) {
			_Instance = new KKHLogUtility();
		}
		_Instance._logger.warn(message);
	}

	/**
	 * WARN�o��
	 * @param e
	 */
	public static void warn(KKHException e) {
		warn(e.getMessage());
	}

	/**
	 * ERROR�o��
	 * @param message
	 */
	public static void error(String message) {
		if (_Instance == null) {
			_Instance = new KKHLogUtility();
		}
		_Instance._logger.info(message);
	}

	/**
	 * ERROR�o��
	 * @param e
	 */
	public static void error(KKHException e) {
		error(e.getMessage());
	}

	/**
	 * FATAL�o��
	 * @param message
	 */
	public static void fatal(String message) {
		if (_Instance == null) {
			_Instance = new KKHLogUtility();
		}
		_Instance._logger.fatal(message);
	}

	/**
	 * FATAL�o��
	 * @param e
	 */
	public static void fatal(KKHException e) {
		fatal(e.getMessage());
	}
}
