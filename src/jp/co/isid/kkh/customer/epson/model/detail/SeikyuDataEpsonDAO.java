package jp.co.isid.kkh.customer.epson.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.epson.model.detail.Thb14skdownVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 請求回収データ検索(Epson)DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/04/23 JSE.Yuguchi)<BR>
 * </P>
 * @author
 */
public class SeikyuDataEpsonDAO extends AbstractRdbDao {

    /**請求回収データ検索条件 */
    private SeikyuDataCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public SeikyuDataEpsonDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
    	//new String[] {};
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return "";
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
        };
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
    	StringBuffer sql = new StringBuffer();

	        //=================================================================================================================================================================
	        //SELECT句
	        //=================================================================================================================================================================
	    	sql.append(" SELECT ");
	    	sql.append("     " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TIMSTMP + " ");
	    	sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.UPDAPL + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.UPDTNT + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIHUPDTIMSTMP + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.EGCD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSKGYCD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSBMNSEQNO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSTNTSEQNO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEINO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEISTATUS + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEISYBT + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEITSUKACD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIGAKGK + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TORIGAKGK + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.NEBIGAKGK + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SZEIGAKGK + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.MAEFURIGAK + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.MAEFURISZEIGAK + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.KAISTATUS + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.KESHIDATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.KAIGAK + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.KAIEGCD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIHAKDATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEISYUDATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEISAISYUDATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SAIHAKCNT + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEITORIDATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIYYMM + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.NYUKGYCD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIKGYCD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIBMNSEQNO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEITNTSEQNO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEINAMEUP + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEINAMEDOWN + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIBMNNAME + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.EGKYONAME + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.EGTNTCD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.EGTNTNAME + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEITNTCD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEITNTNAME + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SENSEINO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIBAINAME + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIHYODATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.KOUNAMEUP + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.KOUNAMEDOWN + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.FURISTATUS + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIMEINO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.ATUEGCD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.ATUTKSKGYCD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.ATUTKSBMNSEQNO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.ATUTKSTNTSEQNO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.JYUTNO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.JYMEINO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.URMEINO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.GPYNO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.JYTSUKACD + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIKANRATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.RATETYPE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIKANDATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TORIGAKJY + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TORIGAKEN + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.NEBIGAKJY + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.NEBIGAKEN + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SZEIGAKEN + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.FURIDATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.FURITORIDATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SZEIKBN + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.KEIYODATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.KEIDATE + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.FILETIMSTMP + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.KKHMEITIMSTMP + " ");
			//=================================================================================================================================================================
	        //FROM句
	        //=================================================================================================================================================================
			sql.append(" FROM ");
			sql.append("     " + TBTHB14SKDOWN.TBNAME + " ");
	        //=================================================================================================================================================================
	        //WHERE句
	        //=================================================================================================================================================================
	        sql.append(" WHERE ");
	        sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.EGCD             + " = '" + _cond.getEgCd() + "' ");
	        sql.append(" AND ");
	        sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSKGYCD         + " = '" + _cond.getTksKgyCd() + "' ");
	        sql.append(" AND ");
	        sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSBMNSEQNO      + " = '" + _cond.getBmncd() + "' ");
	        sql.append(" AND ");
	        sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.TKSTNTSEQNO      + " = '" + _cond.getTntcd() + "' ");
	        sql.append(" AND ");
	        sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIYYMM          + " = '" + _cond.getYymm() + "' ");
//	        sql.append(" AND ");
//	        sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEISTATUS        + " = '2' ");
            sql.append(" AND ");
            sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEISTATUS        + " IN ('2','3') ");
	        //=================================================================================================================================================================
	        //Order句
	        //=================================================================================================================================================================
	        sql.append(" ORDER BY ");
	        sql.append("    " + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEINO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.SEIMEINO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.JYUTNO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.JYMEINO + " ");
			sql.append("    ," + TBTHB14SKDOWN.TBNAME + "." + TBTHB14SKDOWN.URMEINO + " ");

    	return sql.toString();
    }


    /**
     * 請求回収データの検索を行います。
     *
     * @return 請求回収データVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<Thb14skdownVO> findSeikyuDataByCondition(SeikyuDataCondition cond) throws KKHException {

    	super.setModel(new Thb14skdownVO());

        try {
        	_cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }

    }


    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<Thb14skdownVO> 変換後の検索結果
     */
    @Override
    @SuppressWarnings("unchecked")
    protected List createFindedModelInstances(List hashList) {
        List list = null;

        	list = new ArrayList<Thb14skdownVO>();
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                Thb14skdownVO vo = new Thb14skdownVO();

                vo.setHb14TimStmp((Date)result.get(TBTHB14SKDOWN.TIMSTMP.toUpperCase()));
                vo.setHb14UpdApl((String)result.get(TBTHB14SKDOWN.UPDAPL.toUpperCase()));
                vo.setHb14UpdTnt((String)result.get(TBTHB14SKDOWN.UPDTNT.toUpperCase()));
                vo.setHb14Seihupdtimstmp((String)result.get(TBTHB14SKDOWN.SEIHUPDTIMSTMP.toUpperCase()));
                vo.setHb14EgCd((String)result.get(TBTHB14SKDOWN.EGCD.toUpperCase()));
                vo.setHb14TksKgyCd((String)result.get(TBTHB14SKDOWN.TKSKGYCD.toUpperCase()));
                vo.setHb14TksBmnSeqNo((String)result.get(TBTHB14SKDOWN.TKSBMNSEQNO.toUpperCase()));
                vo.setHb14TksTntSeqNo((String)result.get(TBTHB14SKDOWN.TKSTNTSEQNO.toUpperCase()));
                vo.setHb14Seino((String)result.get(TBTHB14SKDOWN.SEINO.toUpperCase()));
                vo.setHb14Seistatus((String)result.get(TBTHB14SKDOWN.SEISTATUS.toUpperCase()));
                vo.setHb14Seisybt((String)result.get(TBTHB14SKDOWN.SEISYBT.toUpperCase()));
                vo.setHb14Seitsukacd((String)result.get(TBTHB14SKDOWN.SEITSUKACD.toUpperCase()));
                vo.setHb14Seigakgk((BigDecimal)result.get(TBTHB14SKDOWN.SEIGAKGK.toUpperCase()));
                vo.setHb14Torigakgk((BigDecimal)result.get(TBTHB14SKDOWN.TORIGAKGK.toUpperCase()));
                vo.setHb14Nebigakgk((BigDecimal)result.get(TBTHB14SKDOWN.NEBIGAKGK.toUpperCase()));
                vo.setHb14Szeigakgk((BigDecimal)result.get(TBTHB14SKDOWN.SZEIGAKGK.toUpperCase()));
                vo.setHb14Maefurigak((BigDecimal)result.get(TBTHB14SKDOWN.MAEFURIGAK.toUpperCase()));
                vo.setHb14Maefuriszeigak((BigDecimal)result.get(TBTHB14SKDOWN.MAEFURISZEIGAK.toUpperCase()));
                vo.setHb14Kaistatus((String)result.get(TBTHB14SKDOWN.KAISTATUS.toUpperCase()));
                vo.setHb14Keshidate((String)result.get(TBTHB14SKDOWN.KESHIDATE.toUpperCase()));
                vo.setHb14Kaigak((BigDecimal)result.get(TBTHB14SKDOWN.KAIGAK.toUpperCase()));
                vo.setHb14Kaiegcd((String)result.get(TBTHB14SKDOWN.KAIEGCD.toUpperCase()));
                vo.setHb14Seihakdate((String)result.get(TBTHB14SKDOWN.SEIHAKDATE.toUpperCase()));
                vo.setHb14Seisyudate((String)result.get(TBTHB14SKDOWN.SEISYUDATE.toUpperCase()));
                vo.setHb14Seisaisyudate((String)result.get(TBTHB14SKDOWN.SEISAISYUDATE.toUpperCase()));
                vo.setHb14Saihakcnt((BigDecimal)result.get(TBTHB14SKDOWN.SAIHAKCNT.toUpperCase()));
                vo.setHb14Seitoridate((String)result.get(TBTHB14SKDOWN.SEITORIDATE.toUpperCase()));
                vo.setHb14Seiyymm((String)result.get(TBTHB14SKDOWN.SEIYYMM.toUpperCase()));
                vo.setHb14Nyukgycd((String)result.get(TBTHB14SKDOWN.NYUKGYCD.toUpperCase()));
                vo.setHb14Seikgycd((String)result.get(TBTHB14SKDOWN.SEIKGYCD.toUpperCase()));
                vo.setHb14Seibmnseqno((String)result.get(TBTHB14SKDOWN.SEIBMNSEQNO.toUpperCase()));
                vo.setHb14Seitntseqno((String)result.get(TBTHB14SKDOWN.SEITNTSEQNO.toUpperCase()));
                vo.setHb14Seinameup((String)result.get(TBTHB14SKDOWN.SEINAMEUP.toUpperCase()));
                vo.setHb14Seinamedown((String)result.get(TBTHB14SKDOWN.SEINAMEDOWN.toUpperCase()));
                vo.setHb14Seibmnname((String)result.get(TBTHB14SKDOWN.SEIBMNNAME.toUpperCase()));
                vo.setHb14Egkyoname((String)result.get(TBTHB14SKDOWN.EGKYONAME.toUpperCase()));
                vo.setHb14Egtntcd((String)result.get(TBTHB14SKDOWN.EGTNTCD.toUpperCase()));
                vo.setHb14Egtntname((String)result.get(TBTHB14SKDOWN.EGTNTNAME.toUpperCase()));
                vo.setHb14Seitntcd((String)result.get(TBTHB14SKDOWN.SEITNTCD.toUpperCase()));
                vo.setHb14Seitntname((String)result.get(TBTHB14SKDOWN.SEITNTNAME.toUpperCase()));
                vo.setHb14Senseino((String)result.get(TBTHB14SKDOWN.SENSEINO.toUpperCase()));
                vo.setHb14Seibainame((String)result.get(TBTHB14SKDOWN.SEIBAINAME.toUpperCase()));
                vo.setHb14Seihyodate((String)result.get(TBTHB14SKDOWN.SEIHYODATE.toUpperCase()));
                vo.setHb14Kounameup((String)result.get(TBTHB14SKDOWN.KOUNAMEUP.toUpperCase()));
                vo.setHb14Kounamedown((String)result.get(TBTHB14SKDOWN.KOUNAMEDOWN.toUpperCase()));
                vo.setHb14Furistatus((String)result.get(TBTHB14SKDOWN.FURISTATUS.toUpperCase()));
                vo.setHb14Seimeino((String)result.get(TBTHB14SKDOWN.SEIMEINO.toUpperCase()));
                vo.setHb14Atuegcd((String)result.get(TBTHB14SKDOWN.ATUEGCD.toUpperCase()));
                vo.setHb14Atutkskgycd((String)result.get(TBTHB14SKDOWN.ATUTKSKGYCD.toUpperCase()));
                vo.setHb14Atutksbmnseqno((String)result.get(TBTHB14SKDOWN.ATUTKSBMNSEQNO.toUpperCase()));
                vo.setHb14Atutkstntseqno((String)result.get(TBTHB14SKDOWN.ATUTKSTNTSEQNO.toUpperCase()));
                vo.setHb14Jyutno((String)result.get(TBTHB14SKDOWN.JYUTNO.toUpperCase()));
                vo.setHb14Jymeino((String)result.get(TBTHB14SKDOWN.JYMEINO.toUpperCase()));
                vo.setHb14Urmeino((String)result.get(TBTHB14SKDOWN.URMEINO.toUpperCase()));
                vo.setHb14Gpyno((String)result.get(TBTHB14SKDOWN.GPYNO.toUpperCase()));
                vo.setHb14Jytsukacd((String)result.get(TBTHB14SKDOWN.JYTSUKACD.toUpperCase()));
                vo.setHb14Seikanrate((BigDecimal)result.get(TBTHB14SKDOWN.SEIKANRATE.toUpperCase()));
                vo.setHb14Ratetype((String)result.get(TBTHB14SKDOWN.RATETYPE.toUpperCase()));
                vo.setHb14Seikandate((String)result.get(TBTHB14SKDOWN.SEIKANDATE.toUpperCase()));
                vo.setHb14Torigakjy((BigDecimal)result.get(TBTHB14SKDOWN.TORIGAKJY.toUpperCase()));
                vo.setHb14Torigaken((BigDecimal)result.get(TBTHB14SKDOWN.TORIGAKEN.toUpperCase()));
                vo.setHb14Nebigakjy((BigDecimal)result.get(TBTHB14SKDOWN.NEBIGAKJY.toUpperCase()));
                vo.setHb14Nebigaken((BigDecimal)result.get(TBTHB14SKDOWN.NEBIGAKEN.toUpperCase()));
                vo.setHb14Szeigaken((BigDecimal)result.get(TBTHB14SKDOWN.SZEIGAKEN.toUpperCase()));
                vo.setHb14Furidate((String)result.get(TBTHB14SKDOWN.FURIDATE.toUpperCase()));
                vo.setHb14Furitoridate((String)result.get(TBTHB14SKDOWN.FURITORIDATE.toUpperCase()));
                vo.setHb14Szeikbn((String)result.get(TBTHB14SKDOWN.SZEIKBN.toUpperCase()));
                vo.setHb14Keiyodate((String)result.get(TBTHB14SKDOWN.KEIYODATE.toUpperCase()));
                vo.setHb14Keidate((String)result.get(TBTHB14SKDOWN.KEIDATE.toUpperCase()));
                vo.setHb14Filetimstmp((String)result.get(TBTHB14SKDOWN.FILETIMSTMP.toUpperCase()));
                vo.setHb14Kkhmeitimstmp((String)result.get(TBTHB14SKDOWN.KKHMEITIMSTMP.toUpperCase()));



                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        return list;
    }

}
