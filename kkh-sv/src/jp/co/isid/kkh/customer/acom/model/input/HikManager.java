package jp.co.isid.kkh.customer.acom.model.input;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.customer.acom.model.input.HikCommonCondition;
import jp.co.isid.kkh.customer.acom.model.input.HikVO;
import jp.co.isid.kkh.customer.acom.model.input.HikRegistVOList;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 発注データ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikManager {

    /** シングルトンインスタンス */
    private static HikManager _manager = new HikManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private HikManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static HikManager getInstance() {
        return _manager;
    }

    /**
     * 発注データを検索します。
     *
     * @return HikSearchResult 発注データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public HikSearchResult findByCondition(HikCommonCondition cond) throws KKHException {

        // 発注データ検索
    	HikDAO dao = HikDAOFactory.createHikDAO();

        List<HikVO> list = dao.findByCondition(cond);
        HikSearchResult result = new HikSearchResult();
        result.setHikVOList(list);
        return result;
    }

    /**
     * 日付関係のを検索します。
     *
     * @return HikSearchResult 発注データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public HikSearchResult findDateCntByVoList(HikSearchDateCntVOList volist) throws KKHException {

        HikSearchDateCntDAO    dao = HikSearchDateCntDAOFactory.createHikSearchDateCntDAO();
        HikCommonCondition cond = new HikCommonCondition();
        HikSearchResult result = new HikSearchResult();

        List<HikSearchDateCntVO> list = new ArrayList<HikSearchDateCntVO>();

        if(volist.getHikSearchDateCntVOList() != null){
            for (HikSearchDateCntVO vo : volist.getHikSearchDateCntVOList()) {

                //比較用データ取得のため、条件をconditionにセットする
                cond.setTkskgycd(vo.getTksKgyCd());
                cond.setTksbmnseqno(vo.getTksBmnSeqNo());
                cond.setTkstntseqno(vo.getTksTntSeqNo());
                cond.setSyubetsu(vo.getSybt());
                cond.setIrban(vo.getIrban());
                cond.setIrrowban(vo.getIrrowban());
                cond.setRecCd(vo.getRecCd());

                //リストに入れ直しを行う
                for (HikSearchDateCntVO tmp : dao.findByCondition(cond)) {
                   list.add(tmp);
                }
            }
        }

        result.setHikSearchDateCntVOList(list);
        return result;
    }


    /**
     * 比較情報用発注データを検索します。
     *
     * @return HikSearchResult 比較情報用発注データ
     * @throws  KKHException 処理中にエラーが発生した場合
     */
    public HikSearchResult findCheckDataByVoList(HikRegistVOList volist) throws KKHException {

        HikCheckDataDAO    cdao = HikDAOFactory.createHikCheckDataDAO();
        HikCommonCondition cond = new HikCommonCondition();
        HikSearchResult result = new HikSearchResult();

        List<HikVO> list = new ArrayList<HikVO>();

        if(volist.getHikRegistVOList() != null){
            for (HikVO vo : volist.getHikRegistVOList()) {

                //比較用データ取得のため、条件をconditionにセットする
                cond.setTkskgycd(vo.getTksKgyCd());
                cond.setTksbmnseqno(vo.getTksBmnSeqNo());
                cond.setTkstntseqno(vo.getTksTntSeqNo());
                cond.setSyubetsu(vo.getSybt());
                cond.setIrrowban(vo.getIrrowban());
                cond.setIrban(vo.getIrban());
                cond.setRecCd(vo.getRecCd());

                //リストに入れ直しを行う
                for (HikVO tmp : cdao.findByCondition(cond)) {
                   list.add(tmp);
                }
            }
        }

        result.setHikVOList(list);
        return result;
    }

    /**
     * 発注データの登録を行います。
     *
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void registHik(HikRegistVOList volist) throws KKHException {
        // 発注データ登録
        HikRegistDAO dao  = HikRegistDAOFactory.createHikRegistDAO();

        if(volist.getHikRegistVOList() != null){
            for (HikVO vo : volist.getHikRegistVOList()) {
                //発注データ登録処理
                dao.registHik(vo);
            }
        }
    }
}
