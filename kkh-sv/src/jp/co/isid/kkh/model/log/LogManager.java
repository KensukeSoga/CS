package jp.co.isid.kkh.model.log;

import java.util.*;
import java.text.*;


import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.log.LogRegistDAO;
import jp.co.isid.kkh.model.log.LogRegistDAOFactory;
import jp.co.isid.kkh.model.log.LogVO;

/**
 * <P>
 * 汎用ログ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class LogManager {

    /** シングルトンインスタンス */
    private static LogManager _manager = new LogManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private LogManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static LogManager getInstance() {
        return _manager;
    }


    /**
     * 汎用ログを検索します。
     *
     * @return LogResult 汎用ログ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public LogResult findLogByCondition(LogCondition cond) throws KKHException {

    	//パラメータの必須チェック
    	if (cond.getEsqId()== null || cond.getEsqId().equals("")){
    		throw new KKHException("パラメータ指定エラー", "BD-E0001");
    	}
    	if (cond.getEgCd() == null || cond.getEgCd().equals("")){
    		throw new KKHException("パラメータ指定エラー", "BD-E0001");
    	}
    	if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")){
    		throw new KKHException("パラメータ指定エラー", "BD-E0001");
    	}
    	if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")){
    		throw new KKHException("パラメータ指定エラー", "BD-E0001");
    	}
    	if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")){
    		throw new KKHException("パラメータ指定エラー", "BD-E0001");
    	}
    	if (cond.getSybt() == null || cond.getSybt().equals("")){
    		throw new KKHException("パラメータ指定エラー", "BD-E0001");
    	}

    	//検索結果
    	LogResult result = new LogResult();
    	//検索条件(マスタ種類設定・項目設定取得用)
    	LogCondition lCond = new LogCondition();


    	LogDAO dao = LogDAOFactory.createLogDAO();

    	//******************************************************
    	//マスタ種類設定を取得
    	//******************************************************
    	lCond = cond;
        List<LogVO> LogList = dao.findLogByCondition(lCond);
        result.setLog(LogList);

        return result;
    }


    /**
     * 汎用ログデータの登録を行います。
     *
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void registLog(LogVO volist) throws KKHException {
    	//パラメータの必須チェック
    	if (volist.getTrkPl()== null || volist.getTrkPl().equals("")){
    		throw new KKHException("パラメータ指定エラー", "BD-E0001");
    	}
		if (volist.getTrkTnt()== null || volist.getTrkTnt().equals("")){
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (volist.getUpdPl()== null || volist.getUpdPl().equals("")){
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (volist.getUpdTnt()== null || volist.getUpdTnt().equals("")){
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (volist.getEgCd()== null || volist.getEgCd().equals("")){
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (volist.getTksKgyCd()== null || volist.getTksKgyCd().equals("")){
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (volist.getTksBmnSeqNo()== null || volist.getTksBmnSeqNo().equals("")){
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (volist.getTksTntSeqNo()== null || volist.getTksTntSeqNo().equals("")){
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
		if (volist.getSybt()== null || volist.getSybt().equals("")){
			throw new KKHException("パラメータ指定エラー", "BD-E0001");
		}
        // ログデータ登録
    	LogRegistDAO dao = LogRegistDAOFactory.createLogRegistDAO();
    	Date UpdDate = new Date();  //(1)Dateオブジェクトを生成


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    	volist.setUpdDate(sdf.format(UpdDate));
        dao.registLog(volist);

    }

}
