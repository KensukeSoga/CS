package jp.co.isid.kkh.model.detail;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
//import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
//import jp.co.isid.kkh.model.detail.Thb2KmeiDAO.ExecSqlMode;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

public class Thb1DownDAO extends AbstractSimpleRdbDao {

    /** 受注削除フラグ：ON */
    private static final String JYUTDELFLG_ON = "1";

    /**
     * デフォルトコンストラクタ。
     */
    public Thb1DownDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
        //super.setUseTimeStamp(true);
    }

    private Thb1DownVO _cond;
    private List<Thb2KmeiVO> _cond2;

    /** getSelectSQLで発行するSQLのモード() */
    private enum SelSqlMode{LOAD, LOCK, LOCK_IKATSU, LOCK_CHD, LOCK_JDEL, MAX_JNO, JNO_UNQ};
    private SelSqlMode _selSqlMode = SelSqlMode.LOCK;

    /** getExecSQLで発行するSQLのモード() */
    private enum ExecSqlMode{INS, UPD, DEL, UPD_DSP, DEL_JDEL, UPD_YYMM, UPD_MEG, UPD_MCN, UPD_CHD, UPD_CHK, UPD_TRK ,TOrkKoshin,UP1Down};
    private ExecSqlMode _execSqlMode = ExecSqlMode.UPD_DSP;


    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
	@Override
	public String[] getPrimryKeyNames() {
		return new String[]{
				TBTHB1DOWN.EGCD,
				TBTHB1DOWN.TKSKGYCD,
				TBTHB1DOWN.TKSBMNSEQNO,
				TBTHB1DOWN.TKSTNTSEQNO,
				TBTHB1DOWN.YYMM,
				TBTHB1DOWN.JYUTNO,
				TBTHB1DOWN.JYMEINO,
				TBTHB1DOWN.URMEINO,
				TBTHB1DOWN.TOUFLG
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
				TBTHB1DOWN.TRKTIMSTMP,
				TBTHB1DOWN.TRKAPL,
				TBTHB1DOWN.TRKTNT,
				TBTHB1DOWN.TRKTNTNM,
				TBTHB1DOWN.KSNTIMSTMP,
				TBTHB1DOWN.KSNTNT,
				TBTHB1DOWN.KSNTNTNM,
				TBTHB1DOWN.TIMSTMP,
				TBTHB1DOWN.UPDAPL,
				TBTHB1DOWN.UPDTNT,
				TBTHB1DOWN.ATUEGCD,
				TBTHB1DOWN.EGCD,
				TBTHB1DOWN.TKSKGYCD,
				TBTHB1DOWN.TKSBMNSEQNO,
				TBTHB1DOWN.TKSTNTSEQNO,
				TBTHB1DOWN.JYUTNO,
				TBTHB1DOWN.JYMEINO,
				TBTHB1DOWN.URMEINO,
				TBTHB1DOWN.GPYNO,
				TBTHB1DOWN.GPYOPAG,
				TBTHB1DOWN.SEINO,
				TBTHB1DOWN.HIMKCD,
				TBTHB1DOWN.TOUFLG,
				TBTHB1DOWN.YYMM,
				TBTHB1DOWN.GYOMKBN,
				TBTHB1DOWN.MSKBN,
				TBTHB1DOWN.TMSPKBN,
				TBTHB1DOWN.KOKKBN,
				TBTHB1DOWN.SEIKBN,
				TBTHB1DOWN.SYONO,
				TBTHB1DOWN.KKNAMEKJ,
				TBTHB1DOWN.EGGAMENTYPE,
				TBTHB1DOWN.KKAKSHANKBN,
				TBTHB1DOWN.TORIGAK,
				TBTHB1DOWN.SEITNKA,
				TBTHB1DOWN.SEIGAK,
				TBTHB1DOWN.NEBIRITU,
				TBTHB1DOWN.NEBIGAK,
				TBTHB1DOWN.SZEIKBN,
				TBTHB1DOWN.SZEIRITU,
				TBTHB1DOWN.SZEIGAK,
				TBTHB1DOWN.HIMKNMKJ,
				TBTHB1DOWN.HIMKNMKN,
				TBTHB1DOWN.TJYUTNO,
				TBTHB1DOWN.TJYMEINO,
				TBTHB1DOWN.TURMEINO,
				TBTHB1DOWN.MSEIFLG,
				TBTHB1DOWN.YYMMOLD,
				TBTHB1DOWN.FIELD1,
				TBTHB1DOWN.FIELD2,
				TBTHB1DOWN.FIELD3,
				TBTHB1DOWN.FIELD4,
				TBTHB1DOWN.FIELD5,
				TBTHB1DOWN.FIELD6,
				TBTHB1DOWN.FIELD7,
				TBTHB1DOWN.FIELD8,
				TBTHB1DOWN.FIELD9,
				TBTHB1DOWN.FIELD10,
				TBTHB1DOWN.FIELD11,
				TBTHB1DOWN.FIELD12,
				TBTHB1DOWN.FILETIMSTMP,
				TBTHB1DOWN.MEITIMSTMP,
                TBTHB1DOWN.JYUTDELFLG
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
		return TBTHB1DOWN.TBNAME;
	}

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
	@Override
	public String getTimeStampKeyName() {
		return TBTHB1DOWN.TIMSTMP;
	}

    /**
     * システム日付で更新する列の定義です
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB1DOWN.TIMSTMP};
    }


    /**
     * 受注ダウンロードデータのPK検索を行います。
     * @param vo
     * @return
     * @throws KKHException
     */
    public Thb1DownVO loadThb1Down(Thb1DownVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("検索エラー", "BD-E0001");
        }
        super.setModel(vo);
        try {
        	_selSqlMode = SelSqlMode.LOAD;
            return (Thb1DownVO)super.load();
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
    public void insertThb1Down(Thb1DownVO vo) throws KKHException {
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
    public void updateThb1Down(Thb1DownVO vo) throws KKHException {
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
    public boolean deleteThb1Down(Thb1DownVO vo) throws KKHException {
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

        if (_selSqlMode.equals(SelSqlMode.LOCK)){
        	sql = getSelectSQLForLOCK();
        } else if (_selSqlMode.equals(SelSqlMode.LOCK_IKATSU)) {
        	sql = getSelectSQLForLOCK_IKATSU();
        } else if (_selSqlMode.equals(SelSqlMode.LOCK_CHD)) {
        	sql = getSelectSQLForLOCK_Child();
        } else if (_selSqlMode.equals(SelSqlMode.LOCK_JDEL)) {
        	sql = getSelectSQLForLOCK_JDEL();
        } else if (_selSqlMode.equals(SelSqlMode.MAX_JNO)){
        	sql = getSelectSQLForMaxJyutyuNo();
        } else if (_selSqlMode.equals(SelSqlMode.JNO_UNQ)){
        	sql = getSelectSQLForUniqueCheck();
        }else {
        	sql = getSelectSQLForALL();
        }

        return sql;
    }


    /**
     * デフォルトSQLを返します。
     * @return
     */
    private String getSelectSQLForALL(){

    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	//PK項目を取得
    	for (int i = 0; i < getTableColumnNames().length; i++){
    		if (i == 0){
    			sql.append("  " + getTableColumnNames()[i] + " ");
    		}else{
    			sql.append(" ," + getTableColumnNames()[i] + " ");
    		}
    	}
    	sql.append(" FROM ");
    	sql.append(" " + getTableName() + " ");

    	return sql.toString();
    }

    /**
     * 排他ロックSQLを返します。
     * @return
     */
    public String getSelectSQLForLOCK(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " ");
    	//PK項目を取得
    	for (int i = 0; i < getPrimryKeyNames().length; i++){
    		sql.append(" ," + getPrimryKeyNames()[i] + " ");
    	}
    	sql.append(" ," + TBTHB1DOWN.FILETIMSTMP + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");
    	sql.append(" ORDER BY ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " DESC ");


    	return sql.toString();
    }

    /**
     * 排他ロックSQL(一括)を返します。
     * @return
     */
    public String getSelectSQLForLOCK_IKATSU(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " ");
    	//PK項目を取得
    	for (int i = 0; i < getPrimryKeyNames().length; i++){
    		sql.append(" ," + getPrimryKeyNames()[i] + " ");
    	}
    	sql.append(" ," + TBTHB1DOWN.FILETIMSTMP + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");
    	sql.append(" ORDER BY ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " DESC ");

    	return sql.toString();
    }

    /**
     * 排他ロックSQLを返します。(明細登録－子明細)
     * @return
     */
    public String getSelectSQLForLOCK_Child(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " ");
    	//PK項目を取得
    	for (int i = 0; i < getPrimryKeyNames().length; i++){
    		sql.append(" ," + getPrimryKeyNames()[i] + " ");
    	}
    	sql.append(" ," + TBTHB1DOWN.FILETIMSTMP + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
    	sql.append(" ORDER BY ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " ASC ");
    	//sql.append(" " + TBTHB1DOWN.TIMSTMP + " DESC ");


    	return sql.toString();
    }

    /**
     * 排他ロックSQLを返します。(受注削除用)
     * @return
     */
    public String getSelectSQLForLOCK_JDEL(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " ");
    	//PK項目を取得
    	for (int i = 0; i < getPrimryKeyNames().length; i++){
    		sql.append(" ," + getPrimryKeyNames()[i] + " ");
    	}
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
    	sql.append(" AND ( ");
    	sql.append("         ( ");
    	sql.append("             " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
    	sql.append("             AND ");
    	sql.append("             " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
    	sql.append("             AND ");
    	sql.append("             " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
    	sql.append("         ) ");
    	sql.append("         OR ");
    	sql.append("         ( ");
    	sql.append("             " + TBTHB1DOWN.TJYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
    	sql.append("             AND ");
    	sql.append("             " + TBTHB1DOWN.TJYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
    	sql.append("             AND ");
    	sql.append("             " + TBTHB1DOWN.TURMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
    	sql.append("         ) ");
    	sql.append("     ) ");
    	sql.append(" ORDER BY ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " DESC ");


    	return sql.toString();
    }

    /**
     * 受注Noの最大値を取得するSQLを返します。
     * @return
     */
    public String getSelectSQLForMaxJyutyuNo(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" MAX(" + TBTHB1DOWN.JYUTNO + ") AS " + TBTHB1DOWN.JYUTNO + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.JYUTNO + " LIKE '" + _cond.getHb1JyutNo().substring(0, 6) + "%' ");

    	return sql.toString();
    }

    /**
     * 受注Noの重複チェックを行う為のSQLを返します。
     * @return
     */
    public String getSelectSQLForUniqueCheck(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB1DOWN.JYUTNO + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");

    	return sql.toString();
    }


    /**
     * 受注ダウンロードデータの検索を行います。
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> lockThb1Down(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LOCK;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * 受注ダウンロードデータの検索を行います。
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> lockIkatsuThb1Down(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LOCK_IKATSU;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * 受注ダウンロードデータの検索を行います。
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> lockThb1DownForChild(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LOCK_CHD;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }

    }

    /**
     * 受注ダウンロードデータの排他・検索を行います。(受注削除用)
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> lockThb1DownForJyutyuDataDel(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LOCK_JDEL;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }

    }

    /**
     * 受注Noの最大値を取得する。
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> getMaxJyutyuNo(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.MAX_JNO;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }

    }

    /**
     * 受注Noを取得する。(重複チェック用)
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> getJyutyuNoForUniqueCheck(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.JNO_UNQ;
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
			//明細登録
			Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" SET ");
	    	if (_cond2 != null && _cond2.size() > 0){
		    	sql.append(" " + TBTHB1DOWN.MSEIFLG + " = '" + vo.getHb1MSeiFlg() + "' ,");	//未請求フラグ
		    	sql.append(" " + TBTHB1DOWN.MEITIMSTMP + " = '" + vo.getHb1MeiTimStmp() + "' ,");	//明細作成タイムスタンプ
		    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " = SYSDATE ,");
		    	sql.append(" " + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ,");
		    	sql.append(" " + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ,");
	    	}
	    	//明細フラグが0(明細が無い)の場合
	    	if(vo.getHb1MeisaiFlg().equals("0"))
	    	{
	    		if(vo.getHb1KsnTntNm() == null )
	    		{
	    			//何もしません
	    		}else
	    		{
		    		//初期化する
			    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + "= '' ,");	//登録タイムスタンプ
			    	sql.append(" " + TBTHB1DOWN.TRKAPL + " = '' ,");		//登録プログラム
			    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '' ,");		//登録担当者
			    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '' ,");	//登録担当者
	    	    	//更新者を登録する
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//明細更新日
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//明細更新者
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//明細更新者名
	    		}
	    	}
	    	else//明細がある場合
	    	{
	    		//登録、更新ともに空ではない場合両方とも登録
	    		if(!vo.getHb1TrkTntNm().equals("") && !vo.getHb1KsnTntNm().equals(""))
	    		{
	    			//登録者を登録する
	    	    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ,");
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '" + vo.getHb1TrkTnt() + "' ,");	//登録担当者
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '" + vo.getHb1TrkTntNm() + "' ,");	//登録担当者名
	    	    	//更新者を登録する
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//明細更新日
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//更新者
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//更新者名

	    		}
	    		//登録者が空の場合更新者を登録
	    		if(vo.getHb1TrkTntNm().equals(""))
	    		{
	    	    	//更新者を登録する
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//明細更新日
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//更新者
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//更新者名
	    		}
	    		//更新者が空の場合
	    		if(vo.getHb1KsnTntNm().equals(""))
	    		{
	    			//登録者を登録する
	    	    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ,");
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '" + vo.getHb1TrkTnt() + "' ,");	//登録担当者
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '" + vo.getHb1TrkTntNm() + "' ,");	//登録担当者名
	    		}


//	    		//更新者が空の場合
//	    	    if(vo.getHb1KsnTntNm() == null)
//	    	    {
//	    	    	//登録者を登録する
//	    	    	sql.append("," + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ");
//	    	    	sql.append("," + TBTHB1DOWN.TRKTNT + " = '" + vo.getHb1TrkTnt() + "' ");	//登録担当者
//	    	    	sql.append("," + TBTHB1DOWN.TRKTNTNM + " = '" + vo.getHb1TrkTntNm() + "' ");	//登録担当者名
//
//	    	    }else
//	    	    {//更新者が空じゃない場合
//
//	    	    	//更新者を登録する
//	    	    	sql.append("," + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ");						//明細更新日
//	    	    	sql.append("," + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ");		//更新者
//	    	    	sql.append("," + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ");	//更新者名
//	    	    }
	    		//nullの場合、更新する
//	    	    sql.append("," + TBTHB1DOWN.TRKTIMSTMP + "= NVL(" + TBTHB1DOWN.TRKTIMSTMP + ", SYSDATE)");	//登録タイムスタンプ
//	    	    sql.append("," + TBTHB1DOWN.TRKAPL + " = NVL(TRIM(" + TBTHB1DOWN.TRKAPL + ") , '" + vo.getHb1UpdApl() + "') ");	//登録プログラム
//	    	    sql.append("," + TBTHB1DOWN.TRKTNT + " = NVL(TRIM(" + TBTHB1DOWN.TRKTNT + ") , '" +  vo.getHb1UpdTnt() + "') ");	//登録担当者
	    	}
	    	//コンマ削除
	    	String ToStSQL = sql.toString();
	    	ToStSQL = ToStSQL.substring(0, ToStSQL.length()-1);
	    	sql = new StringBuffer();
	    	sql.append(ToStSQL);

	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");
	 	} else if (_execSqlMode.equals(ExecSqlMode.DEL_JDEL)) {
	 		//受注削除
			//Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" DELETE ");
	    	sql.append(" FROM ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ( ");
	    	sql.append("         ( ");
	    	sql.append("             " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append("             AND ");
	    	sql.append("             " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append("             AND ");
	    	sql.append("             " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
	    	sql.append("         ) ");
	    	sql.append("         OR ");
	    	sql.append("         ( ");
	    	sql.append("             " + TBTHB1DOWN.TJYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append("             AND ");
	    	sql.append("             " + TBTHB1DOWN.TJYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append("             AND ");
	    	sql.append("             " + TBTHB1DOWN.TURMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
	    	sql.append("         ) ");
	    	sql.append("     ) ");
	 	} else if (_execSqlMode.equals(ExecSqlMode.UPD_YYMM)){
	 		//請求年月更新
			Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" SET ");
	    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
	    	sql.append("," + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ");
	    	sql.append("," + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ");
	    	sql.append("," + TBTHB1DOWN.YYMM + " = '" + vo.getHb1Yymm() + "' ");
	    	sql.append("," + TBTHB1DOWN.YYMMOLD + " = '" + vo.getHb1YymmOld() + "' ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TOUFLG + " = '" + _cond.getHb1TouFlg() + "' ");
	 	} else if (_execSqlMode.equals(ExecSqlMode.UPD_MEG)){
	 		//統合
			Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" SET ");
	    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
	    	sql.append("," + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ");
	    	sql.append("," + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ");
	    	sql.append("," + TBTHB1DOWN.TJYUTNO + " ='" + vo.getHb1TJyutNo() + "' ");
	    	sql.append("," + TBTHB1DOWN.TJYMEINO + " ='" + vo.getHb1TJyMeiNo() + "' ");
	    	sql.append("," + TBTHB1DOWN.TURMEINO + " ='" + vo.getHb1TUrMeiNo() + "' ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TOUFLG + " = '" + _cond.getHb1TouFlg() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");
	 	} else if (_execSqlMode.equals(ExecSqlMode.UPD_MCN)){
	 		//統合解除
			Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" SET ");
	    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
	    	sql.append("," + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ");
	    	sql.append("," + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ");
	    	sql.append("," + TBTHB1DOWN.TJYUTNO + " =' ' ");
	    	sql.append("," + TBTHB1DOWN.TJYMEINO + " =' ' ");
	    	sql.append("," + TBTHB1DOWN.TURMEINO + " =' ' ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = '" + _cond.getHb1TJyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = '" + _cond.getHb1TJyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = '" + _cond.getHb1TUrMeiNo() + "' ");
//	    	sql.append(" AND ");
//	    	sql.append(" " + TBTHB1DOWN.TOUFLG + " = ' ' ");
	 	} else if (_execSqlMode.equals(ExecSqlMode.UPD_CHD)){
			//明細登録－明細登録日時更新(統合元)
			Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" SET ");
	    	sql.append(" " + TBTHB1DOWN.MEITIMSTMP + " = '" + vo.getHb1MeiTimStmp() + "' ");
	    	sql.append("," + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
	    	sql.append("," + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ");
	    	sql.append("," + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
        } else if (_execSqlMode.equals(ExecSqlMode.UPD_CHK)){
            //更新・削除チェック
            Thb1DownVO vo = (Thb1DownVO)getModel();
            sql.append(" UPDATE ");
            sql.append(" " + TBTHB1DOWN.TBNAME + " ");
            sql.append(" SET ");
            sql.append(" " + TBTHB1DOWN.JYUTDELFLG + " = '" + JYUTDELFLG_ON + "' ");
            sql.append("," + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
            sql.append("," + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ");
            sql.append("," + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ");
            sql.append(" WHERE ");
            sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TOUFLG + " = '" + String.format("%-1s", _cond.getHb1TouFlg()) + "' ");
        }else if(_execSqlMode.equals(ExecSqlMode.TOrkKoshin)){
        	//統合されている奴の登録者更新者対応
        	Thb1DownVO vo = (Thb1DownVO)getModel();
        	sql.append(" UPDATE ");
            sql.append(" " + TBTHB1DOWN.TBNAME + " ");
            sql.append(" SET ");
	    	if(vo.getHb1MeisaiFlg().equals("0"))
	    	{
	    		if(vo.getHb1KsnTntNm() == null )
	    		{
	    			//何もしません
	    		}else
	    		{
		    		//初期化する
			    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + "= '' ,");	//登録タイムスタンプ
			    	sql.append(" " + TBTHB1DOWN.TRKAPL + " = '' ,");		//登録プログラム
			    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '' ,");		//登録担当者
			    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '' ,");	//登録担当者
	    	    	//更新者を登録する
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//明細更新日
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//明細更新者
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//明細更新者名
	    		}
	    	}
	    	else//明細がある場合
	    	{
	    		//登録、更新ともに空ではない場合両方とも登録
	    		if(vo.getHb1TrkTntNm() != null && vo.getHb1KsnTntNm() != null)
	    		{
	    			//登録者を登録する
	    	    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ,");
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '" + vo.getHb1TrkTnt() + "' ,");	//登録担当者
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '" + vo.getHb1TrkTntNm() + "' ,");	//登録担当者名
	    	    	//更新者を登録する
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//明細更新日
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//更新者
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//更新者名

	    		}
	    		//登録者が空の場合更新者を登録
	    		if(vo.getHb1TrkTntNm() == null)
	    		{
	    	    	//更新者を登録する
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//明細更新日
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//更新者
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//更新者名
	    		}
	    		//更新者が空の場合
	    		if(vo.getHb1KsnTntNm() == null)
	    		{
	    			//登録者を登録する
	    	    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ,");
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '" + vo.getHb1TrkTnt() + "' ,");	//登録担当者
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '" + vo.getHb1TrkTntNm() + "' ,");	//登録担当者名
	    		}

	    	}
            //カンマをとる処理ｗ
            String tost = sql.toString();
            tost = tost.substring(0,tost.length()-1);
            sql = new StringBuffer();
            sql.append(tost);

            sql.append(" WHERE ");
            sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TOUFLG + " = ' '");
        }
//        else if (_execSqlMode.equals(ExecSqlMode.UPD_TRK)){
//        	//登録者削除
//            sql.append(" UPDATE ");
//            sql.append(" " + TBTHB1DOWN.TBNAME + " ");
//            sql.append(" SET ");
//            //sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ");
//            sql.append(" " + TBTHB1DOWN.TRKTNT + " = ' ' ");
//            //sql.append("," + TBTHB1DOWN.TRKAPL + " = ' ' ");
//            // Where句
//            sql.append(" WHERE ");
//            sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
//            sql.append(" AND ");
//            sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
//            sql.append(" AND ");
//            sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
//            sql.append(" AND ");
//            sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
//            if (_cond.getHb1Yymm() != null && !_cond.getHb1Yymm().equals("")){
//	            sql.append(" AND ");
//	            sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
//            }
//            if (_cond.getHb1JyutNo() != null && !_cond.getHb1JyutNo().equals("")){
//	            sql.append(" AND ");
//	            sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
//            }
//            if (_cond.getHb1JyMeiNo() != null && !_cond.getHb1JyMeiNo().equals("")){
//	            sql.append(" AND ");
//	            sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
//            }
//            if (_cond.getHb1UrMeiNo() != null && !_cond.getHb1UrMeiNo().equals("")){
//	            sql.append(" AND ");
//	            sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
//            }
//	 	}
        else if(_execSqlMode.equals(ExecSqlMode.UP1Down)){
        	sql.append(" UPDATE ");
        	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        	sql.append(" SET ");
        	sql.append(" " + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
        	sql.append(" WHERE ");
        	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");
        }
        else {
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
    public void updateThb1DownForDisplayData(Thb1DownVO vo , List<Thb2KmeiVO> vo2) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("更新エラー", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_cond2 = vo2;
        	_execSqlMode = ExecSqlMode.UPD_DSP;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }
    /**
     * 受注ダウンロードデータのタイムスタンプを更新
     *
     * @param vo Condition用
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateSysdateTo1down(Thb1DownVO vo) throws KKHException{
    	if(vo == null){
    		throw new KKHException("更新エラー", "BD-E0003");
    	}
    	super.setModel(vo);
    	try
    	{
    		_cond = vo;
    		_execSqlMode = ExecSqlMode.UP1Down;
    		super.exec();
    	}catch(UserException e){
    		throw new KKHException(e.getMessage(),"BD-E0003");
    	}
    }


    /**
     * 受注ダウンロードデータの更新(表示データ更新用)
     *
     * @param vo 受注ダウンロードデータVO（INSERT用）
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateTourokuKousinTaiou(Thb1DownVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("更新エラー", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.TOrkKoshin;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }


    /**
     * 受注ダウンロードデータの更新(表示データ更新用)
     *
     * @param vo 受注ダウンロードデータVO（INSERT用）
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateThb1DownForDisplayDataChild(Thb1DownVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("更新エラー", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.UPD_CHD;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * 受注ダウンロードデータの削除(受注削除用)
     * @param vo 受注ダウンロードデータVO（DELETE用）
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void deleteThb1DownByCondition(Thb1DownVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("削除エラー", "BD-E0004");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.DEL_JDEL;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }
    }

    /**
     * 受注ダウンロードデータの更新(請求年月変更用)
     *
     * @param vo 受注ダウンロードデータVO(更新条件)
     * @param updVo 受注ダウンロードデータVO(更新データ)
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateThb1DownForCngSeikyuYymm(Thb1DownVO vo, Thb1DownVO updVo) throws KKHException {
        //パラメータチェック
        if (vo == null || updVo == null) {
            throw new KKHException("更新エラー", "BD-E0003");
        }
        super.setModel(updVo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.UPD_YYMM;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }


    /**
     * 受注ダウンロードデータの更新(受注統合用)
     *
     * @param vo 受注ダウンロードデータVO
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateThb1DownForJyutyuMerge(Thb1DownVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("更新エラー", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.UPD_MEG;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * 受注ダウンロードデータの更新(受注解除用)
     *
     * @param vo 受注ダウンロードデータVO
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateThb1DownForJyutyuMergeCancel(Thb1DownVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("更新エラー", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.UPD_MCN;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * 受注ダウンロードデータの更新(変更・削除チェック用)
     *
     * @param vo 受注ダウンロードデータVO
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateThb1DownForUpdateCheck(Thb1DownVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("更新エラー", "BD-E0003");
        }
        super.setModel(vo);
        try {
            _cond = vo;
            _execSqlMode = ExecSqlMode.UPD_CHK;
            super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * 広告費明細テーブルの条件指定更新
     *
     * @param cond 更新条件
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
        //パラメータチェック
//    public boolean updateThb1DownTrkByCondition(Thb1DownVO vo) throws KKHException {
//        if (vo == null) {
//            throw new KKHException("更新エラー", "BD-E0003");
//        }
//
//        try {
//            _cond = vo;
//            _execSqlMode = ExecSqlMode.UPD_TRK;
//            super.exec();
//        } catch (UserException e) {
//            throw new KKHException(e.getMessage(), "BD-E0003");
//        }
//
//        return true;
//    }

}
