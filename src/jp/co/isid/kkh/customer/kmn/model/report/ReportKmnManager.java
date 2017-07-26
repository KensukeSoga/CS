package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;


public class ReportKmnManager {

    /** シングルトンインスタンス */
    private static ReportKmnManager _manager = new ReportKmnManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportKmnManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportKmnManager getInstance() {
        return _manager;
    }

    /**
     * 帳票（公文_帳票出力）データを検索します。
     *
     * @return ReportKmnResult 並び順情報
     * @throws KKHException
     *             処理中にエラーが発生した場合
     */
    public ReportKmnResult findReportKmnByCondition(ReportKmnCondition cond)
            throws KKHException {

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

        // 検索結果
        ReportKmnResult result = new ReportKmnResult();

        // 検索条件
        ReportKmnCondition lCond = new ReportKmnCondition();

        ReportKmnDAO dao = ReportKmnDAOFactory.createFindReportKmnDAO();
        lCond = cond;

        // ****************************************************************
        // 帳票（公文_伝票）データの検索
        // ****************************************************************
        List<ReportKmnVO> list = dao.findReportKmnByCondition(lCond);

        // ****************************************************************
        // 帳票（公文_伝票）データの検索
        // ****************************************************************
        List<ReportKmnVO> list2 = dao.findReportKmnByCondition2(lCond);

        // ****************************************************************
        // 帳票（公文_伝票）データを取得
        // ****************************************************************
        result.setMeisai(getMeisai(list,list2));

        return result;
    }


    /**
     * 明細データを取得する
     *
     * @param hashList   検索結果（明細と明細に紐づく受注）
     * @return List      明細データのみにした検索結果
     */
    private List<ReportKmnMeisaiVO> getMeisai(List<ReportKmnVO> hashList, List<ReportKmnVO> hashList2) {

        // リスト初期化
        List<ReportKmnMeisaiVO> list = new ArrayList<ReportKmnMeisaiVO>();
        ReportKmnMeisaiVO vo = new ReportKmnMeisaiVO();
        ReportKmnVO result = new ReportKmnVO();
        ReportKmnVO result_tmp = new ReportKmnVO();

        // 検索結果から明細データだけvoにセットする
        for(int i = 0; i < hashList.size(); i++){

            // 初期化
            vo = new ReportKmnMeisaiVO();
            result = new ReportKmnVO();
            // 検索結果から一行取得
            result = hashList.get(i);

            // 統合／未統合フラグ(true:未統合 false:統合)
            boolean miTflg = true;

            // 統合データかチェック
            for(int j = 0; j < hashList2.size(); j++){

                // 初期化
                result_tmp = new ReportKmnVO();
                // 一行取得
                result_tmp = hashList2.get(j);

                if(result.getHb2JyutNo().equals(result_tmp.getHb1TJyutNo())){

                    // 統合データのためフラグfalseを設定
                    miTflg = false;

                    // 統合データの場合
                    // 請求回収データを取得しているかチェック
                    if(result_tmp.getHb14JyutNo().trim().length() > 0){

                        // 取得できている場合
                        vo.setSeiZumi("済");

                    }else{

                        // 取得できていない場合
                        vo.setSeiZumi("");
                        // ループから抜けて次のデータへ
                        break;
                    }
                }
            }
            // 未統合データの場合
            if(miTflg){

                // 請求回収データを取得しているかチェック
                if(result.getHb14JyutNo().trim().length() > 0){

                    // 取得できている場合
                    vo.setSeiZumi("済");

                }else{

                    // 取得できていない場合
                    vo.setSeiZumi("");
                }
            }

            vo.setJyutyuNo(result.getHb2JyutNo());                // 受注No
            vo.setJyuMeiNo(result.getHb2JymeiNo());               // 受注明細No
            vo.setUriMeiNo(result.getHb2UrmeiNo());               // 売上明細No
            vo.setYyyymm(result.getHb2Yymm());                    // 年月
            vo.setBumonCd(result.getHb2Code1());                  // コード1
            vo.setOutputNo(result.getHb2Code2());                 // コード2
            vo.setHinmoku1(result.getHb2Name8());                 // 名称8
            vo.setHinmoku2(result.getHb2Name3());                 // 名称3
            vo.setHinmoku3(result.getHb2Name4());                 // 名称4
            vo.setBumonNm(result.getHb2Name5());                  // 名称5
            vo.setAtenaNm(result.getHb2Name16());                  // 名称16
            vo.setSZeiGak(result.getHb2Kngk3());                  // 合計消費税額
            vo.setKingaku(result.getHb2Seigak());                 // 請求金額

            //--請求年月表示方法修正対応 2013/07/18 HLC H.Watabe start
            vo.setSeikyuYM(result.getHb2Name6());                   //請求年月
            //--請求年月表示方法修正対応 2013/07/18 HLC H.Watabe end

            // 返却用リストに格納
            list.add(vo);
        }

        return list;
    }

}
