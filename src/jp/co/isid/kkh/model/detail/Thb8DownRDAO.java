package jp.co.isid.kkh.model.detail;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB8DOWNR;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

public class Thb8DownRDAO extends AbstractSimpleRdbDao {

    /**
     * デフォルトコンストラクタ。
     */
    public Thb8DownRDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
        //super.setUseTimeStamp(true);
    }

    private Thb8DownRCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
    private enum SelSqlMode{LOAD, LIST,};
    private SelSqlMode _selSqlMode = SelSqlMode.LOAD;

    /** getExecSQLで発行するSQLのモード() */
    private enum ExecSqlMode{INS, UPD, DEL, UPD_DSP, UPD_CHD,};
    private ExecSqlMode _execSqlMode = ExecSqlMode.INS;

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
	@Override
	public String[] getPrimryKeyNames() {
		return new String[]{
				TBTHB8DOWNR.EGCD,
				TBTHB8DOWNR.TKSKGYCD,
				TBTHB8DOWNR.TKSBMNSEQNO,
				TBTHB8DOWNR.TKSTNTSEQNO,
				TBTHB8DOWNR.YYMM,
				TBTHB8DOWNR.JYUTNO,
				TBTHB8DOWNR.JYMEINO,
				TBTHB8DOWNR.URMEINO,
				TBTHB8DOWNR.TOUFLG,
				TBTHB8DOWNR.FILETIMSTMP
		};
	}

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
	@Override
	public String[] getTableColumnNames() {
		String[] retStrs = new String[]{};
		retStrs = new String[]{
				TBTHB8DOWNR.TIMSTMP,
				TBTHB8DOWNR.UPDAPL,
				TBTHB8DOWNR.UPDTNT,
				TBTHB8DOWNR.ATUEGCD,
				TBTHB8DOWNR.EGCD,
				TBTHB8DOWNR.TKSKGYCD,
				TBTHB8DOWNR.TKSBMNSEQNO,
				TBTHB8DOWNR.TKSTNTSEQNO,
				TBTHB8DOWNR.JYUTNO,
				TBTHB8DOWNR.JYMEINO,
				TBTHB8DOWNR.URMEINO,
				TBTHB8DOWNR.GPYNO,
				TBTHB8DOWNR.GPYOPAG,
				TBTHB8DOWNR.SEINO,
				TBTHB8DOWNR.HIMKCD,
				TBTHB8DOWNR.TOUFLG,
				TBTHB8DOWNR.YYMM,
				TBTHB8DOWNR.GYOMKBN,
				TBTHB8DOWNR.MSKBN,
				TBTHB8DOWNR.TMSPKBN,
				TBTHB8DOWNR.KOKKBN,
				TBTHB8DOWNR.SEIKBN,
				TBTHB8DOWNR.SYONO,
				TBTHB8DOWNR.KKNAMEKJ,
				TBTHB8DOWNR.EGGAMENTYPE,
				TBTHB8DOWNR.KKAKSHANKBN,
				TBTHB8DOWNR.TORIGAK,
				TBTHB8DOWNR.SEITNKA,
				TBTHB8DOWNR.SEIGAK,
				TBTHB8DOWNR.NEBIRITU,
				TBTHB8DOWNR.NEBIGAK,
				TBTHB8DOWNR.SZEIKBN,
				TBTHB8DOWNR.SZEIRITU,
				TBTHB8DOWNR.SZEIGAK,
				TBTHB8DOWNR.HIMKNMKJ,
				TBTHB8DOWNR.HIMKNMKN,
				TBTHB8DOWNR.TJYUTNO,
				TBTHB8DOWNR.TJYMEINO,
				TBTHB8DOWNR.TURMEINO,
				TBTHB8DOWNR.MSEIFLG,
				TBTHB8DOWNR.YYMMOLD,
				TBTHB8DOWNR.FIELD1,
				TBTHB8DOWNR.FIELD2,
				TBTHB8DOWNR.FIELD3,
				TBTHB8DOWNR.FIELD4,
				TBTHB8DOWNR.FIELD5,
				TBTHB8DOWNR.FIELD6,
				TBTHB8DOWNR.FIELD7,
				TBTHB8DOWNR.FIELD8,
				TBTHB8DOWNR.FIELD9,
				TBTHB8DOWNR.FIELD10,
				TBTHB8DOWNR.FIELD11,
				TBTHB8DOWNR.FIELD12,
				TBTHB8DOWNR.FILETIMSTMP,
				TBTHB8DOWNR.MEITIMSTMP
		};

		return retStrs;
	}


    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
	@Override
	public String getTableName() {
		return TBTHB8DOWNR.TBNAME;
	}

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
	@Override
	public String getTimeStampKeyName() {
		return TBTHB8DOWNR.TIMSTMP;
	}

    /**
     * システム日付で更新する列の定義です
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB8DOWNR.TIMSTMP};
    }


    /**
     * 受注ダウンロードデータのPK検索を行います。
     * @param vo
     * @return
     * @throws KKHException
     */
    public Thb8DownRVO loadThb8DownR(Thb8DownRVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("検索エラー", "BD-E0001");
        }
        super.setModel(vo);
        try {
        	_selSqlMode = SelSqlMode.LOAD;
            return (Thb8DownRVO)super.load();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * 受注ダウンロードデータの登録
     *
     * @param vo 受注ダウンロードデータVO（INSERT用）
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void insertThb8DownR(Thb8DownRVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        super.setModel(vo);
        try {
        	_execSqlMode = ExecSqlMode.INS;
            if (!super.insert()) {
                throw new KKHException("登録エラー", "BD-E0002");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * 受注ダウンロードデータの更新(全項目対象)
     *
     * @param vo 受注ダウンロードデータVO（INSERT用）
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateThb8DownR(Thb8DownRVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("更新エラー", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_execSqlMode = ExecSqlMode.UPD;
            if (!super.update()) {
                throw new KKHException("更新エラー", "BD-E0003");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * 受注ダウンロードデータの削除を行います。
     *
     * @param vo 受注ダウンロードデータVO
     * @return boolean true：削除処理成功
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public boolean deleteThb8DownR(Thb8DownRVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("削除エラー", "BD-E0004");
        }

        super.setModel(vo);

        try {
        	_execSqlMode = ExecSqlMode.DEL;
            if (!super.remove()) {
                throw new KKHException("削除エラー", "BD-E0004");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }

        return true;
    }


    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
    	String sql = "";

    	if (_selSqlMode == SelSqlMode.LIST){
    		sql = getSelectSQLForList();
    	} else {
    		sql = super.getSelectSQL();
    	}

        return sql;
    }

    private String getSelectSQLForList(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	//全項目を取得
    	for (int i = 0; i < getTableColumnNames().length; i++){
    		if (i == 0){
    			sql.append("  " + getTableColumnNames()[i] + " ");
    		}else{
    			sql.append(" ," + getTableColumnNames()[i] + " ");
    		}
    	}
    	sql.append(" FROM ");
    	sql.append("  " + getTableName() + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB8DOWNR.EGCD + " = '" + _cond.getEgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
//    	sql.append(" AND ");
//    	sql.append(" " + TBTHB8DOWNR.YYMM + " = '" + _cond.getYymm() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.JYUTNO + " = '" + _cond.getJyutNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.JYMEINO + " = '" + _cond.getJyMeiNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.URMEINO + " = '" + _cond.getUrMeiNo() + "' ");
    	sql.append(" ORDER BY ");
    	sql.append("  " + TBTHB8DOWNR.FILETIMSTMP + " ");

    	return sql.toString();
    }

    /**
     * 受注ダウンロード履歴テーブルの条件検索を行います。
     *
     * @return 受注ダウンロード履歴データVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Thb8DownRVO> findJyutyuRirekiDataByCond(Thb8DownRCondition cond) throws KKHException{

    	super.setModel(new Thb8DownRVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LIST;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }


    /**
     * EXEC-SQL生成
     */
	@Override
	public String getExecString() {
		StringBuffer sql = new StringBuffer();

		if (_execSqlMode.equals(ExecSqlMode.UPD_DSP)){
			//明細登録--明細登録日時更新
			Thb8DownRVO vo = (Thb8DownRVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB8DOWNR.TBNAME + " ");
	    	sql.append(" SET ");
	    	sql.append(" " + TBTHB8DOWNR.MEITIMSTMP + " = '" + vo.getHb8MeiTimStmp() + "' ");
	    	sql.append("," + TBTHB8DOWNR.TIMSTMP + " = SYSDATE ");
	    	sql.append("," + TBTHB8DOWNR.UPDAPL + " ='" + vo.getHb8UpdApl() + "' ");
	    	sql.append("," + TBTHB8DOWNR.UPDTNT + " ='" + vo.getHb8UpdTnt() + "' ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB8DOWNR.EGCD + " = '" + _cond.getEgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
//	    	sql.append(" AND ");
//	    	sql.append(" " + TBTHB8DOWNR.YYMM + " = '" + _cond.getYymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.JYUTNO + " = '" + _cond.getJyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.JYMEINO + " = '" + _cond.getJyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.URMEINO + " = '" + _cond.getUrMeiNo() + "' ");
//	    	sql.append(" AND ");
//	    	sql.append(" " + TBTHB8DOWNR.TOUFLG + " = '" + _cond.getHb8TouFlg() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.FILETIMSTMP + " = '" + _cond.getFileTimStmp() + "' ");
	 	} else {
	 		super.getExecString();
	 	}

	 	return sql.toString();
	}

    /**
     * 受注ダウンロードデータの更新(表示データ更新用)
     *
     * @param vo 受注ダウンロードデータVO（INSERT用）
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateThb8DownRForDisplayData(Thb8DownRVO vo, Thb8DownRCondition cond) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("更新エラー", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = cond;
        	_execSqlMode = ExecSqlMode.UPD_DSP;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

}
