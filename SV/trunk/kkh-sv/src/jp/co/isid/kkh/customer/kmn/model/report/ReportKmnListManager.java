package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.ArrayList;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 *
 * <P>
 * 帳票（公文_請求一覧）データ検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class ReportKmnListManager {

    /** シングルトンインスタンス */
    private static ReportKmnListManager _manager = new ReportKmnListManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportKmnListManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportKmnListManager getInstance() {
        return _manager;
    }

    /**
     * 帳票(公文_請求一覧)を検索します。
     *
     * @return ReportMacResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public ReportKmnListResult findByCondition(ReportKmnListCondition cond) throws KKHException {

        // パラメータの必須チェック
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getYm() == null || cond.getYm().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        //検索結果
        ReportKmnListResult result = new ReportKmnListResult();

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        ReportKmnListDAO reportKmnListDAO = ReportKmnListDAOFactory.createFindReportKmnListDAO();

        List<ReportKmnListVO> list = reportKmnListDAO.findReportKmnListByCondition(cond);

        if(cond.getOutput().equals("明細")){

            result.setRptList(list);

        }else if(cond.getOutput().equals("統合")){

            List<ReportKmnListVO> list2 = reportKmnListDAO.findReportKmnListByCondition2(cond);
            result.setRptList(getMeisai(list,list2));
        }

        return result;
    }

    /**
     * 明細データを取得する
     *
     * @param hashList   検索結果（明細と明細に紐づく受注）
     * @return List      明細データのみにした検索結果
     */
    private List<ReportKmnListVO> getMeisai(List<ReportKmnListVO> hashList, List<ReportKmnListVO> hashList2) {

        // リスト初期化
        List<ReportKmnListVO> list = new ArrayList<ReportKmnListVO>();
        List<ReportKmnListVO> reslist = new ArrayList<ReportKmnListVO>();
        ReportKmnListVO result = new ReportKmnListVO();
        ReportKmnListVO result_tmp = new ReportKmnListVO();

        // 検索結果から明細データだけvoにセットする
        for(int i = 0; i < hashList.size(); i++){

            // 初期化
            result = new ReportKmnListVO();
            // 検索結果から一行取得
            result = hashList.get(i);

            // 統合／未統合フラグ(true:未統合 false:統合)
            boolean miTflg = true;

            // 統合データかチェック
            for(int j = 0; j < hashList2.size(); j++){

                // 初期化
                result_tmp = new ReportKmnListVO();
                // 一行取得
                result_tmp = hashList2.get(j);

                if(result.getJyutNo().equals(result_tmp.getDTJyutNo())){

                    // 統合データのためフラグfalseを設定
                    miTflg = false;

                    // 統合データの場合
                    // 請求回収データを取得しているかチェック
                    if(result_tmp.getSkJyutNo().trim().length() > 0){

                        // 取得できている場合
                        result.setSeiZumi("済");

                    }else{

                        // 取得できていない場合
                        result.setSeiZumi("");
                        // ループから抜けて次のデータへ
                        break;
                    }
                }
            }
            // 未統合データの場合
            if(miTflg){

                // 請求回収データを取得しているかチェック
                if(!result.getSeiZumi().equals("0")){

                    // 取得できている場合
                    result.setSeiZumi("済");

                }else{

                    // 取得できていない場合
                    result.setSeiZumi("");
                }
            }

            // リストに格納
            list.add(result);
        }

        boolean flg1 = false;
        boolean flg2 = false;

        // リストの数分まわす
        for(int k = 0; k < list.size(); k++){

            ReportKmnListVO res = new ReportKmnListVO();
            // リストから一行取得
            res = list.get(k);

            // 最初のループだけ返却用リストに格納
            if(!flg1){
                reslist.add(res);
                flg1 = true;
            }

            // 返却用リストの数分まわす
            for(int l = 0; l < reslist.size(); l++){

                ReportKmnListVO res_l = new ReportKmnListVO();
                // リストから一行取得
                res_l = reslist.get(l);

                flg2 = false;

                // 返却用リストに受注No,受注明細No,売上明細Noが一致するデータの存在チェック
                if(res.getJyutNo().equals(res_l.getJyutNo()) &&
                        res.getJyMeiNo().equals(res_l.getJyMeiNo()) &&
                        res.getUrMeiNo().equals(res_l.getUrMeiNo())){

                    // 存在する場合は次のデータへ
                    flg2 = true;
                    break;
                }
            }

            // 返却用リストに存在しない場合は追加してから次のデータへ
            if(!flg2){

                // 返却用リストに格納
                reslist.add(res);
            }
        }

        return reslist;
    }

}
