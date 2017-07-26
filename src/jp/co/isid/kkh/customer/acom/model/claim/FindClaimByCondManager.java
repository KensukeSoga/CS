package jp.co.isid.kkh.customer.acom.model.claim;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;
import jp.co.isid.kkh.model.master.MasterItemDAO;
import jp.co.isid.kkh.model.master.MasterItemDAOFactory;
import jp.co.isid.kkh.model.master.MasterVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.model.ModelUtils;

public class FindClaimByCondManager {

    /** 汎用マスタ：種別：新聞 */
    static final String C_BAITAI_SHINBUN = "21";
    /** 汎用マスタ：種別：雑誌 */
    static final String C_BAITAI_ZASHI = "22";
    /** 汎用マスタ：種別：電波 */
    static final String C_BAITAI_DENPA = "11";
    /** 汎用マスタ：種別：広告 */
    static final String C_BAITAI_KOTSU = "31";

    /** 種別_S */
    private static final String C_SYBT_S = "S";
    /** 種別_T */
    private static final String C_SYBT_T = "T";
    /** 番組数 */
    private static final int C_BNGN_COUNT = 4;
    /** 配列要素数 */
    private static final int C_ARRAY_COUNT = 31;

    /* 2015/01/05 アコム消費税対応 HLC fujimoto ADD start */
    /** 種別(消費税端数処理区分) */
    private static final String C_SYBT_TAXROUNDING = "201";

    /** 四捨五入 */
    private static final String C_TAX_ROUND = "01";
    /** 切り捨て */
    private static final String C_TAX_ROUNDDOWN = "02";
    /** 切り上げ */
    private static final String C_TAX_ROUNDUP = "03";

    private static final String C_TAX_FILTERVALUE = "01";
    /* 2015/01/05 アコム消費税対応 HLC fujimoto ADD end */

    /** シングルトンインスタンス */
    private static FindClaimByCondManager _manager = new FindClaimByCondManager();

    /** 検索条件 */
    private FindClaimCondition _lCond = new FindClaimCondition();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private FindClaimByCondManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindClaimByCondManager getInstance() {
        return _manager;
    }

    /**
     * 発注/請求番号 一覧情報を検索します。
     *
     * @return FindClaimByCondResult 請求データ情報
     * @throws KKHException
     *         処理中にエラーが発生した場合
     */
    public FindClaimByCondResult findClaimByCondition(FindClaimCondition cond)
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
        if (cond.getYymm() == null || cond.getYymm().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        // 検索結果
        FindClaimByCondResult result = new FindClaimByCondResult();

        // データ取得DAOのインスタンス生成
        FindClaimByCondDAO dao = FindClaimByCondDAOFactory.createFindKenMeisaiByCondDAO();
        _lCond = cond;

        // ======================================================
        //  発注/請求番号 一覧情報
        // ======================================================
        // データ取得
        List<FindClaimNoCondVO> claimNoList = dao.findClaimNoDataByCondition(_lCond);
        if (claimNoList.size() == 0) {
            return result;
        }
        // データ編集
        List<FindClaimNoCondResultVO> claimNoResultList = this.editClaimNoDataList(claimNoList);


        // ======================================================
        //  請求データ 一覧情報
        // ======================================================
        // データ取得
        List<FindClaimCondVO> claimList = dao.findClaimDataByCondition(_lCond);
        if (claimNoList.size() == 0) {
            return result;
        }
        // データ編集
        List<FindClaimCondResultVO> claimResultList =this.editClaimDataList(claimList, true, true);


        // ======================================================
        //  発注/請求 差異一覧情報
        // ======================================================
        // ※「請求データ 一覧情報」、「 発注/請求 差異一覧情報」を基に出力する
        // データ取得
        List<FindClaimDiffCondVO> claimDiffList = dao.findClaimDiffDataByCondition(_lCond);
        if (claimNoList.size() == 0) {
            return result;
        }
        // データ編集（請求データ 一覧情報）
        List<FindClaimCondResultVO>  claimResultList2 =this.editClaimDataList(claimList, false, false);
        // データ編集（発注/請求 差異一覧情報）
        List<FindClaimDiffCondResultVO> claimDiffResultList = this.editClaimDiffDataList(claimDiffList, claimResultList2, cond.getYymm());


        // サイズ０のリストが存在する場合は、空のリストを返却する
        if (claimNoResultList.size() == 0 ||
            claimResultList.size() == 0 ||
            claimDiffResultList.size() == 0) {

            result.setClaimNoDataList(new ArrayList<FindClaimNoCondResultVO>());
            result.setClaimDataList(new ArrayList<FindClaimCondResultVO>());
            result.setClaimDiffDataList(new ArrayList<FindClaimDiffCondResultVO>());

        } else {

            result.setClaimNoDataList(claimNoResultList);
            result.setClaimDataList(claimResultList);
            result.setClaimDiffDataList(claimDiffResultList);

        }

        return result;
    }

    /**
     * 発注/請求番号 一覧情報の編集を行う
     *
     * @param list 発注/請求番号 一覧情報を含むVOリスト
     * @return     発注/請求番号 一覧情報（返却用）を含むVOリスト
     */
    private List<FindClaimNoCondResultVO> editClaimNoDataList(List<FindClaimNoCondVO> list) {

        List<FindClaimNoCondResultVO> retList = new ArrayList<FindClaimNoCondResultVO>();
        FindClaimNoCondResultVO outVo = null;            // 返却用VO（返却用の情報を保持する）
        FindClaimNoCondVO result = null;                 // 保持用VO（SQLで取得した情報を保持する）
        FindClaimNoCondVO saveVo = null;                 // 比較用VO（１つ前の情報を保持する）
        StringBuffer renban = new StringBuffer();        // 連番
        String shoriKbn = "";                            // 処理区分
        String shoriKbnComp = "";                        // 処理区分比較用
        String shoriKbnNm = "";                          // 処理区分名
        String outSelect = "False";                      // 出力選択

        for (int i = 0; i < list.size(); i++) {

            result = (FindClaimNoCondVO) list.get(i);    // 保持用VO（SQLで取得した情報を保持する）

            if (saveVo != null) {

                // 依頼番号（発注番号）、請求書番号が変更した場合
                if (!saveVo.getIraiNo().trim().equals(result.getIraiNo().trim()) ||
                    !saveVo.getSeiNo().trim().equals(result.getSeiNo().trim())) {

                    outVo = new FindClaimNoCondResultVO();            // VO（返却用）
                    outVo.setShoriKbn(shoriKbnNm);                    // 処理区分
                    outVo.setOutSelect(outSelect);                    // 出力選択
                    outVo.setIraiNo(saveVo.getIraiNo().trim());       // 依頼番号（発注番号）
                    outVo.setSeiNo(saveVo.getSeiNo().trim());         // 請求書番号
                    outVo.setSeiYymm(saveVo.getSeiYymm().trim());     // 請求書発行日
                    outVo.setKenmei(saveVo.getKenmei().trim());       // 件名
                    outVo.setBaitaiCd(saveVo.getBaitaiCd().trim());   // 媒体コード
                    outVo.setOutDate(saveVo.getOutDate().trim());     // 実行日時
                    outVo.setJyutNo(saveVo.getJyutNo().trim());       // 受注No
                    outVo.setJymeiNo(saveVo.getJymeiNo().trim());     // 受注明細No
                    outVo.setUrmeiNo(saveVo.getUrmeiNo().trim());     // 売上明細No
                    outVo.setRenBan(renban.toString());               // 連番

                    ModelUtils.copyMemberSearchAfterInstace(outVo);
                    retList.add(outVo);

                    // 連番初期化
                    renban = new StringBuffer();
                    renban.append("'" + result.getRenBan().trim() + "'");
                    // 処理区分初期化
                    shoriKbn = result.getShoriKbn();
                    shoriKbnComp = result.getShoriKbn();
                }
            }

            if (i == 0) {
                shoriKbn = result.getShoriKbn();
            }

            // 連番
            if ("".equals(renban.toString())) {
                renban.append("'" + result.getRenBan().trim() + "'");
            } else {
                renban.append(",'" + result.getRenBan().trim() + "'");
            }

            // 処理区分
            shoriKbnComp = result.getShoriKbn();
            if (shoriKbn.equals(shoriKbnComp)) {

                if ("".equals(shoriKbn.trim())) {
                    // 空文字の場合「未出力」
                    shoriKbnNm = "未出力";

                } else if ("1".equals(shoriKbn.trim())) {
                    // "1"の場合「未送信」
                    shoriKbnNm = "未送信";

                } else {
                    // 上記以外の場合「出力済」
                    shoriKbnNm = "送信済";
                }

            } else {
                // 「一部出力済」
                shoriKbnNm = "一部出力済";
            }

            // ひとつ前の情報を保持する
            saveVo = result;
        }

        // 最終レコードを出力
        outVo = new FindClaimNoCondResultVO();            // VO（返却用）
        outVo.setShoriKbn(shoriKbnNm);                    // 処理区分
        outVo.setOutSelect(outSelect);                    // 出力選択
        outVo.setIraiNo(saveVo.getIraiNo().trim());       // 依頼番号（発注番号）
        outVo.setSeiNo(saveVo.getSeiNo().trim());         // 請求書番号
        outVo.setSeiYymm(saveVo.getSeiYymm().trim());     // 請求書発行日
        outVo.setKenmei(saveVo.getKenmei().trim());       // 件名
        outVo.setBaitaiCd(saveVo.getBaitaiCd().trim());   // 媒体コード
        outVo.setOutDate(saveVo.getOutDate().trim());     // 実行日時
        outVo.setJyutNo(saveVo.getJyutNo().trim());       // 受注No
        outVo.setJymeiNo(saveVo.getJymeiNo().trim());     // 受注明細No
        outVo.setUrmeiNo(saveVo.getUrmeiNo().trim());     // 売上明細No
        outVo.setRenBan(renban.toString());               // 連番

        ModelUtils.copyMemberSearchAfterInstace(outVo);
        retList.add(outVo);

        return retList;
    }

    /**
     * 請求データ 一覧情報の編集を行う
     *
     * @param list      請求データ 一覧情報を含むVOリスト
     * @param goukeiFlg 合計行出力可否フラグ  true：出力する／false：出力しない
     * @param nebiFlg   値引行出力可否フラグ  true：出力する／false：出力しない
     * @return          請求データ 一覧情報（返却用）を含むVOリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private List<FindClaimCondResultVO> editClaimDataList(List<FindClaimCondVO> list, boolean goukeiFlg, boolean nebiFlg) throws KKHException {

        List<FindClaimCondResultVO> retList = new ArrayList<FindClaimCondResultVO>();
        FindClaimCondVO result = null;                              // 保持用VO（SQLで取得した情報を保持する）
        FindClaimCondResultVO outVo = null;                         // 返却用VO（返却用の情報を保持する）
        FindClaimCondVO saveVo = null;                              // 比較用VO（１つ前の情報を保持する）

        int keisaiCnt = 0;                                          // 掲載日用カウンタ
        int bngmCnt = 0;                                            // 番組用カウンタ
        String jyutNo = "";                                         // 受注No
        String jymeiNo = "";                                        // 受注明細No
        String urmeiNo = "";                                        // 売上明細No
        String renban = "";                                         // 連番

        BigDecimal kngk = BigDecimal.ZERO;                          // 金額
        BigDecimal ritu = BigDecimal.ZERO;                          // 消費税率
        BigDecimal syohizei = BigDecimal.ZERO;                      // 消費税額
        BigDecimal kngkRow = BigDecimal.ZERO;                       // 行単位の金額
        BigDecimal syohizeiRow = BigDecimal.ZERO;                   // 行単位の消費税
        BigDecimal kngkSum = BigDecimal.ZERO;                       // 金額の合計
        BigDecimal syohizeiSum = BigDecimal.ZERO;                   // 消費税額の合計

        String[] cmList = new String[C_BNGN_COUNT];                 // CM秒数保持用リスト
        String[] nameList = new String[C_BNGN_COUNT];               // 内容名称保持用リスト
        String[] bngmList = new String[C_BNGN_COUNT];               // 番組名保持用リスト
        String[] keisaiDayList = new String[C_ARRAY_COUNT];         // 掲載日（発売日）保持用リスト
        String[] kingakUwList = new String[C_ARRAY_COUNT];          // 金額内訳（新聞／雑誌）保持用リスト
        String[] syohizeiUwList = new String[C_ARRAY_COUNT];        // 消費税内訳（新聞／雑誌）保持用リスト
        String[] nebiGakUwList = new String[C_ARRAY_COUNT];         // 値引額内訳（新聞／雑誌）保持用リスト
        String keitaiKbnCd = new String();                          // 形態区分コード
        String keitaiKbnNm = new String();                          // 形態区分名称
        String bikou1 = new String();                               // 備考１
        String bikou2 = new String();                               // 備考２
        List<String> kbnList = new ArrayList<String>();             // 区分リスト

        // 番組情報保持用配列の初期化
        for (int i = 0; i < C_BNGN_COUNT; i++) {
            cmList[i] = "";
            nameList[i] = "";
            bngmList[i] = "";
        }

        // 配列の初期化
        for (int i = 0; i < C_ARRAY_COUNT; i++) {
            keisaiDayList[i] = " ";
            kingakUwList[i] = "0";
            syohizeiUwList[i] = "0";
            nebiGakUwList[i] = "0";
        }

        /* 2015/01/05 アコム消費税対応 HLC fujimoto ADD start */
        //消費税端数処理区分取得
        String taxRounding = "";
        MasterItemDAO masterItemDao = MasterItemDAOFactory.createMasterItemDAO();
        MasterCondition masterCond = new MasterCondition();
        masterCond.setEgCd(_lCond.getEgCd());
        masterCond.setEsqId(_lCond.getEsqId());
        masterCond.setTksKgyCd(_lCond.getTksKgyCd());
        masterCond.setTksBmnSeqNo(_lCond.getTksBmnSeqNo());
        masterCond.setTksTntSeqNo(_lCond.getTksTntSeqNo());
        masterCond.setSybt(C_SYBT_TAXROUNDING);
        masterCond.setFilterValue(C_TAX_FILTERVALUE);

        try {
            List<MasterVO> masterVoList = masterItemDao.findMasterKindByCondition(masterCond);

            if (masterVoList.size() == 0) {
                return retList;
            }

        /* 2015/01/29 アコム消費税対応 soga MOD end */
//            taxRounding = masterVoList.get(0).getField1();
            taxRounding = masterVoList.get(0).getField2();
        /* 2015/01/29 アコム消費税対応 soga MOD end */

        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "KV-E0001");
        }
        /* 2015/01/05 アコム消費税対応 HLC fujimoto MOD end */

        // 請求データ 一覧情報分処理を繰り返す
        for (int i = 0; i < list.size(); i++) {

            result = (FindClaimCondVO) list.get(i);

            // 値引行フラグがfalseで、
            if (nebiFlg == false) {
                // 値引行区分が「0」以外の場合は、
                if (!result.getNebiKbn().trim().equals("0")) {
                    // 出力しない
                    continue;
                }
            }
            // 先頭レコード、または下記項目がキーブレイクした場合
            //  1. 請求年月日
            //  2. 支払日
            //  3. 媒体コード
            //  4. メディアコード
            //  5. 依頼番号（発注番号）
            //  6. 依頼行番号（発注行番号）
            //  7. 請求部署コード
            //  8. 会社名
            //  9. 請求書番号
            // 10. 請求書行番号
            // 11. 商品区分
            // 12. 店番
            // 13. 取引先コード
            // 14. 按分種別
            // 15. 区分
            if (saveVo == null ||
                (saveVo.getSeiYymm().trim().equals(result.getSeiYymm().trim())     &&
                 saveVo.getPayDay().trim().equals(result.getPayDay().trim())       &&
                 saveVo.getBaitaiCd().trim().equals(result.getBaitaiCd().trim())   &&
                 saveVo.getMediaCd().trim().equals(result.getMediaCd().trim())     &&
                 saveVo.getIraiNo().trim().equals(result.getIraiNo().trim())       &&
                 saveVo.getIraiGyoNo().trim().equals(result.getIraiGyoNo().trim()) &&
                 saveVo.getSeibuCd().trim().equals(result.getSeibuCd().trim())     &&
                 saveVo.getKaiNm().trim().equals(result.getKaiNm().trim())         &&
                 saveVo.getSeiNo().trim().equals(result.getSeiNo().trim())         &&
                 saveVo.getSeiGyoNo().trim().equals(result.getSeiGyoNo().trim())   &&
                 saveVo.getSyohinKbn().trim().equals(result.getSyohinKbn().trim()) &&
                 saveVo.getTenBan().trim().equals(result.getTenBan().trim())       &&
                 saveVo.getToriCd().trim().equals(result.getToriCd().trim())       &&
                 saveVo.getAnbunSybt().trim().equals(result.getAnbunSybt().trim()) &&
                 saveVo.getKbn().trim().equals(result.getKbn().trim()))) {

            } else {

                // 請求書番号、発注番号が同じ場合
                if (saveVo.getSeiNo().trim().equals(result.getSeiNo().trim()) &&
                    saveVo.getIraiNo().trim().equals(result.getIraiNo().trim()) ) {

                    // 明細行出力 =====================================================================================
                    outVo = this.setMeisai(saveVo
                                          , kngkRow
                                          , syohizeiRow
                                          , jyutNo
                                          , jymeiNo
                                          , urmeiNo
                                          , renban
                                          , cmList
                                          , nameList
                                          , bngmList
                                          , keisaiDayList
                                          , kingakUwList
                                          , syohizeiUwList
                                          , nebiGakUwList
                                          , kbnList
                                          , keitaiKbnCd
                                          , keitaiKbnNm
                                          , bikou1
                                          , bikou2);

                    ModelUtils.copyMemberSearchAfterInstace(outVo);
                    retList.add(outVo);

                    // 金額項目の初期化
                    kngk = BigDecimal.ZERO;
                    ritu = BigDecimal.ZERO;
                    syohizei = BigDecimal.ZERO;
                    kngkRow = BigDecimal.ZERO;
                    syohizeiRow = BigDecimal.ZERO;

                // 請求書番号、または発注番号が異なる場合
                } else {

                    // 明細行出力 =====================================================================================
                    outVo = this.setMeisai(saveVo
                                         , kngkRow
                                         , syohizeiRow
                                         , jyutNo
                                         , jymeiNo
                                         , urmeiNo
                                         , renban
                                         , cmList
                                         , nameList
                                         , bngmList
                                         , keisaiDayList
                                         , kingakUwList
                                         , syohizeiUwList
                                         , nebiGakUwList
                                         , kbnList
                                         , keitaiKbnCd
                                         , keitaiKbnNm
                                         , bikou1
                                         , bikou2);

                    ModelUtils.copyMemberSearchAfterInstace(outVo);
                    retList.add(outVo);

                    if (goukeiFlg) {
                        // 合計行出力 =====================================================================================
                        outVo = this.setGoukei(saveVo, kngkSum, syohizeiSum);
                        ModelUtils.copyMemberSearchAfterInstace(outVo);
                        retList.add(outVo);
                    }

                    // 金額項目の初期化
                    kngk = BigDecimal.ZERO;
                    ritu = BigDecimal.ZERO;
                    syohizei = BigDecimal.ZERO;
                    kngkRow = BigDecimal.ZERO;
                    syohizeiRow = BigDecimal.ZERO;
                    kngkSum = BigDecimal.ZERO;
                    syohizeiSum = BigDecimal.ZERO;
                }

                // 番組情報保持用配列の初期化
                for (int j = 0; j < C_BNGN_COUNT; j++) {
                    cmList[j] = "";
                    nameList[j] = "";
                    bngmList[j] = "";
                }

                // 配列の初期化
                for (int j = 0; j < C_ARRAY_COUNT; j++) {
                    keisaiDayList[j] = " ";
                    kingakUwList[j] = "0";
                    syohizeiUwList[j] = "0";
                    nebiGakUwList[j] = "0";
                }

                // 受注Noの初期化
                jyutNo = "";
                // 受注明細Noの初期化
                jymeiNo = "";
                // 売上明細Noの初期化
                urmeiNo = "";
                // 連番の初期化
                renban = "";

                // 区分リストの初期化
                kbnList = new ArrayList<String>();

                // 掲載日用カウンタの初期化
                keisaiCnt = 0;

                // 番組用カウンタの初期化
                bngmCnt = 0;
            }

            // １つ前の情報を保持する
            saveVo = result;

            // 金額計算 ---------------------------------------------------------------------------
            kngk = BigDecimal.ZERO;
            kngk = kngk.add(result.getKingaku().add(result.getNebiGaku()));         // 金額
            ritu = result.getSyohiRitu();                                           // 消費税率
            syohizei = this.getSyohizei(kngk, ritu, taxRounding);                   // 消費税額

            kngkRow = kngkRow.add(kngk);                                            // 行単位の金額
            syohizeiRow = syohizeiRow.add(syohizei);                                // 行単位の消費税額

            kngkSum = kngkSum.add(kngk);                                            // 金額の合計
            syohizeiSum = this.getSyohizei(kngkSum, ritu, taxRounding);             // 消費税額の合計

            // 種別「21:新聞」の場合、下記項目に値を追加する ---------------------------------------
            if (C_BAITAI_SHINBUN.equals(result.getBaitaiCd().trim())) {

                String keisaiDay = result.getKeisaiDay().trim();

                if (!keisaiDay.equals("")) {
                    int count = Integer.valueOf(keisaiDay.substring(keisaiDay.length() - 2, keisaiDay.length())) - 1;

                    keisaiDayList[count] = "1";                                         // 掲載日
                    kingakUwList[count] += String.valueOf(kngk);                        // 金額内訳
                    syohizeiUwList[count] = String.valueOf(syohizei);                   // 消費税内訳

                    try {
                        Integer.parseInt(result.getJyutNo());
                        nebiGakUwList[count] = String.valueOf(result.getNebiGaku());    // 値引額内訳
                    } catch(NumberFormatException e) {
                        // 新規作成の時（受注NOが数値以外）は、値引額を売上高から逆算する
                        nebiGakUwList[count] = String.valueOf( this.getNebiGak(keisaiDay, result.getMediaCd(), result.getNebiGaku(), kngk) );
                    }
                }
            }
            // 種別「22：雑誌」、「31：交通」の場合、下記項目に値を追加する ------------------------
            else if (C_BAITAI_ZASHI.equals(result.getBaitaiCd().trim()) ||
                     C_BAITAI_KOTSU.equals(result.getBaitaiCd().trim())) {

                String keisaiDay = result.getKeisaiDay().trim();

                if (!keisaiDay.equals("")) {
                    keisaiDayList[keisaiCnt] = keisaiDay;                                   // 掲載日
                    kingakUwList[keisaiCnt] += String.valueOf(result.getKingaku());         // 金額内訳
                    syohizeiUwList[keisaiCnt] = String.valueOf(result.getShohiZei());       // 消費税内訳

                    try {
                        Integer.parseInt(result.getJyutNo());
                        nebiGakUwList[keisaiCnt] = String.valueOf(result.getNebiGaku());    // 値引額内訳
                    } catch(NumberFormatException e) {
                        // 新規作成の時（受注NOが数値以外）は、値引額を売上高から逆算する
                        nebiGakUwList[keisaiCnt] = String.valueOf( this.getNebiGak(keisaiDay, result.getMediaCd(), result.getNebiGaku(), result.getKingaku()) );
                    }
                }
            }
            // 種別「11:電波」の場合、下記項目に値を追加する ---------------------------------------
            else if (C_BAITAI_DENPA.equals(result.getBaitaiCd().trim())) {

                // 同一請求番号・発注番号・発注行番号で5件以上の明細がある場合はエラー
                if (bngmCnt >= 4) {
                    throw new KKHException("電波データの明細件数エラー", "HB-W0144");
                }

                cmList[bngmCnt] = result.getName13().trim();                                // CM秒数名n
                nameList[bngmCnt] = result.getName14().trim();                              // 内容名n
                bngmList[bngmCnt] = result.getName15().trim();                              // 番組名n

                if( bngmCnt == 0)
                {
                    // 一行目の備考を保存
                    keitaiKbnCd = result.getName11().trim();                                // 形態区分コード
                    keitaiKbnNm = result.getName12().trim();                                // 形態区分名称
                    bikou1 = result.getName16().trim();                                     // 備考１
                    bikou2 = result.getName17().trim();                                     // 備考２
                }
            }

            // 受注No -----------------------------------------------------------------------------
            if ("".equals(jyutNo)) {
                jyutNo = result.getJyutNo();
            } else {
                jyutNo += "," + result.getJyutNo();
            }
            // 受注明細No -------------------------------------------------------------------------
            if ("".equals(jymeiNo)) {
                jymeiNo = result.getJymeiNo();
            } else {
                jymeiNo += "," + result.getJymeiNo();
            }
            // 売上明細No -------------------------------------------------------------------------
            if ("".equals(urmeiNo)) {
                urmeiNo = result.getUrmeiNo();
            } else {
                urmeiNo += "," + result.getUrmeiNo();
            }
            // 連番 -------------------------------------------------------------------------------
            if ("".equals(renban)) {
                renban = result.getRenBan();
            } else {
                renban += "," + result.getRenBan();
            }
            // 区分 -------------------------------------------------------------------------------
            kbnList.add(result.getShoriKbn().trim());

            // 掲載日用カウンタ ＋ 1
            keisaiCnt += 1;

            // 番組用カウンタ ＋ 1
            bngmCnt += 1;
        }

        // 保持用VOがnull以外の場合、最終行を出力する
        if (saveVo != null) {

            // 明細行出力 =====================================================================================
            outVo = this.setMeisai(saveVo
                                , kngkRow
                                , syohizeiRow
                                , jyutNo
                                , jymeiNo
                                , urmeiNo
                                , renban
                                , cmList
                                , nameList
                                , bngmList
                                , keisaiDayList
                                , kingakUwList
                                , syohizeiUwList
                                , nebiGakUwList
                                , kbnList
                                , keitaiKbnCd
                                , keitaiKbnNm
                                , bikou1
                                , bikou2);


            ModelUtils.copyMemberSearchAfterInstace(outVo);
            retList.add(outVo);

            // 合計行出力 =====================================================================================
            if (goukeiFlg) {
                outVo = this.setGoukei(saveVo, kngkSum, syohizeiSum);
                ModelUtils.copyMemberSearchAfterInstace(outVo);
                retList.add(outVo);
            }
        }

        return retList;
    }

    /**
     * 消費税額を計算し返却する
     *
     * @param kngk 金額
     * @param ritu 消費税率
     * @param taxRounding 消費税端数処理区分
     * @return 消費税額
     * @throws KKHException
     */
    private BigDecimal getSyohizei(BigDecimal kngk, BigDecimal ritu, String taxRounding) throws KKHException {

        BigDecimal ret = BigDecimal.ZERO;

        // 消費税額 = 金額 * 消費税率 / 100
        ret = kngk.multiply(ritu).divide(new BigDecimal(100));

        /* 2015/01/05 アコム消費税対応 HLC fujimoto MOD start */
//        if (ret.compareTo(BigDecimal.ZERO) > 0) {
//            ret.add(new BigDecimal(0.5));
//
//        } else if (ret.compareTo(BigDecimal.ZERO) < 0) {
//            ret.add(new BigDecimal(-0.5));
//
//        } else {
//            ret = new BigDecimal(0);
//        }

        if (taxRounding.equals(C_TAX_ROUND)) {
            ret = ret.setScale(0, BigDecimal.ROUND_HALF_UP);
        } else if (taxRounding.equals(C_TAX_ROUNDDOWN)) {
            ret = ret.setScale(0, BigDecimal.ROUND_DOWN);
        } else if (taxRounding.equals(C_TAX_ROUNDUP)) {
            ret = ret.setScale(0, BigDecimal.ROUND_UP);
        } else {
            return BigDecimal.ZERO;
        }
        /* 2015/01/05 アコム消費税対応 HLC fujimoto MOD end */

        return ret;
    }

    /**
     * 引数の情報を基に、請求データ 一覧情報VOを設定する（明細行データ）
     *
     * @param vo             請求データ 一覧情報VO
     * @param kngk           金額
     * @param syohizei       消費税
     * @param jyutNo         受注No
     * @param jymeiNo        受注明細No
     * @param urmeiNo        売上明細No
     * @param renban         連番
     * @param cmList         CM秒数名リスト
     * @param nameList       内容名称リスト
     * @param bngmList       番組名リスト
     * @param keisaiDayList  掲載日リスト
     * @param kingakUwList   金額内訳リスト
     * @param syohizeiUwList 消費税内訳リスト
     * @param nebiGakUwList  値引額内訳リスト
     * @param kbnList        区分リスト
     * @return               請求データ 一覧情報VO（返却用）
     */
    private FindClaimCondResultVO setMeisai(FindClaimCondVO vo,
                                            BigDecimal kngk,
                                            BigDecimal syohizei,
                                            String jyutNo,
                                            String jymeiNo,
                                            String urmeiNo,
                                            String renban,
                                            String[] cmList,
                                            String[] nameList,
                                            String[] bngmList,
                                            String[] keisaiDayList,
                                            String[] kingakUwList,
                                            String[] syohizeiUwList,
                                            String[] nebiGakUwList,
                                            List<String> kbnList,
                                            String keitaiKbnCd,
                                            String keitaiKbnNm,
                                            String bikou1,
                                            String bikou2) {

        FindClaimCondResultVO retVo = new FindClaimCondResultVO();

        // 明細行出力 ============================================================================================================================
        retVo.setSybt(C_SYBT_S);                                            // 種別 (明細)
        retVo.setIraiNo(vo.getIraiNo());                                    // 依頼番号（発注番号）
        retVo.setIraiGyoNo(vo.getIraiGyoNo());                              // 依頼行番号（発注行番号）
        retVo.setToriCd(vo.getToriCd().trim());                             // 取引先コード
        retVo.setKaiNm(vo.getKaiNm().trim());                               // 会社名
        retVo.setSeibuCd(vo.getSeibuCd().trim());                           // 請求部署コード
        retVo.setSeiYymm(vo.getSeiYymm().trim());                           // 請求年月日
        retVo.setSeiNo(vo.getSeiNo().trim());                               // 請求書番号
        retVo.setNaiyoKbn("2");                                             // 内容区分 (2:明細)
        retVo.setSeiGyoNo(vo.getSeiGyoNo().trim());                         // 請求書行番号
        retVo.setNebiKbn(vo.getNebiKbn().trim());                           // 値引行区分
        retVo.setPayDay(vo.getPayDay().trim());                             // 支払日
        retVo.setSyohinKbn(vo.getSyohinKbn().trim());                       // 商品区分
        retVo.setSyohinKbnNm(vo.getSyohinKbnNm().trim());                   // 商品区分名称
        retVo.setSaimokuKbn(vo.getSaimokuKbn().trim());                     // 細目区分
        retVo.setTekiyoCd(vo.getTekiyoCd().trim());                         // 摘要コード
        retVo.setBaitaiCd(vo.getBaitaiCd().trim());                         // 媒体コード(21:新聞 22:雑誌 11:電波 31:交通)
        retVo.setMediaCd(vo.getMediaCd().trim());                           // メディアコード
        retVo.setMediaNm(vo.getMediaNm().trim());                           // メディア名
        retVo.setTenBan(vo.getTenBan().trim());                             // 店番
        retVo.setKingak(kngk);                                              // 金額
        retVo.setSyohizei(syohizei);                                        // 消費税額
        retVo.setKingakSum(kngk.add(syohizei));                             // 合計金額 (金額 + 消費税)
        retVo.setAnbunSybt(vo.getAnbunSybt().trim());                       // 按分種別
        retVo.setKbn(vo.getKbn().trim());                                   // 区分
        retVo.setNebiRitu(vo.getNebiRitu());                                // 値引率
        retVo.setTouDate(vo.getTouDate().trim());                           // 登録年月日
        retVo.setHenDate(vo.getHenDate().trim());                           // 変更年月日
        retVo.setTorDate(vo.getTorDate().trim());                           // 取消年月日
        retVo.setOutDate(vo.getOutDate().trim());                           // 出力日時
//        retVo.setJyutNo(vo.getJyutNo().trim());                             // 受注No
//        retVo.setJymeiNo(vo.getJymeiNo().trim());                           // 受注明細No
//        retVo.setUrmeiNo(vo.getUrmeiNo().trim());                           // 売上明細No
        retVo.setJyutNo(jyutNo);                                            // 受注No
        retVo.setJymeiNo(jymeiNo);                                          // 受注明細No
        retVo.setUrmeiNo(urmeiNo);                                          // 売上明細No
        retVo.setRenBan(renban);                                            // 連番
        retVo.setKenmei(vo.getKenmei());                                    // 件名
        retVo.setNebiGak(vo.getNebiGaku());                                 // 値引額
        retVo.setSyohizeiRitu(vo.getSyohiRitu());                           // 消費税率

        String iraiNo = vo.getIraiNo();
        if (iraiNo.equals("")) {
            iraiNo = "ZZZZZZZZ";
        }

        String iraiGyoNo = vo.getIraiGyoNo();
        if (iraiGyoNo.equals("")) {
            iraiGyoNo = "ZZZ";
        }

        String seiNo = vo.getSeiNo();
        if (seiNo.equals("")) {
            seiNo = "ZZZZZZZZ";
        }

        String seiGyoNo = vo.getSeiGyoNo();
        if (seiGyoNo.equals("")) {
            seiGyoNo = "ZZZ";
        }

        // ソート順（依頼番号 ＋ 依頼行番号 + 請求書番号 ＋ 請求書行番号 + 種別(S))
        retVo.setSortNo(iraiNo + iraiGyoNo + seiNo + seiGyoNo + C_SYBT_S);

        // 掲載単価
        String keisaiTnk = "";
        try {
            int value = Integer.parseInt(vo.getKeisaiTnk().trim());
            keisaiTnk = String.format("%,d",value);
        } catch(NumberFormatException e) {
            keisaiTnk = "";
        }

        // 掲載日、金額内訳、消費税内訳、値引額内訳
        String keisaiDay = "";
        String kingakUw = "";
        String syohizeiUw = "";
        String nebiGakUw = "";
        for (int i = 0; i < C_ARRAY_COUNT; i++) {

            if (keisaiDay.equals("")) {
                keisaiDay += keisaiDayList[i];
            } else {
                keisaiDay += "," +  keisaiDayList[i];
            }

            if (kingakUw.equals("")) {
                kingakUw += kingakUwList[i];
            } else {
                kingakUw += "," + kingakUwList[i];
            }

            if (syohizeiUw.equals("")) {
                syohizeiUw += syohizeiUwList[i];
            } else {
                syohizeiUw += "," + syohizeiUwList[i];
            }

            if (nebiGakUw.equals("")) {
                nebiGakUw += nebiGakUwList[i];
            } else {
                nebiGakUw += "," + nebiGakUwList[i];
            }
        }

        String[] shoriKbnNmAry = (String[]) kbnList.toArray(new String[0]);
        StringBuffer shoriKbn = new StringBuffer();
        for(String str : shoriKbnNmAry) {
            shoriKbn.append(str).append(",");
        }
        retVo.setShoriKbn(shoriKbn.substring(0, shoriKbn.length() - 1));    // 処理区分
        retVo.setShoriKbnNm("");                                            // 処理区分名

        // 種別が「21:新聞」の場合
        if (C_BAITAI_SHINBUN.equals(retVo.getBaitaiCd().trim())) {
            retVo.setKeisaiBasCd(vo.getName11().trim());                    // 掲載場所コード
            retVo.setKeisaiBasNm(vo.getSnbn_KeiBasNm().trim());             // 掲載場所名称
            retVo.setSybt1Cd(vo.getName12().trim());                        // 種別1コード
            retVo.setSybt1Nm(vo.getSnbn_Sybt1Nm().trim());                  // 種別1名称
            retVo.setSybt2Cd(vo.getName13().trim());                        // 種別2コード
            retVo.setSybt2Nm(vo.getSnbn_Sybt2Nm().trim());                  // 種別2名称
            retVo.setSisaCd(vo.getName14().trim());                         // 色刷コード
            retVo.setSisaNm(vo.getSnbn_SisatNm().trim());                   // 色刷名称
            retVo.setSizeCd(vo.getName15().trim());                         // サイズコード
            retVo.setSizeNm(vo.getSnbn_SizeNm().trim());                    // サイズ名称
            retVo.setKotukeiCd("");                                         // 交通掲載コード
            retVo.setKotukeiNm("");                                         // 交通掲載名称
            retVo.setKeitaiKbnCd("") ;                                      // 形態区分コード
            retVo.setKeitaiKbnNm("") ;                                      // 形態区分名称
            retVo.setCm1("");                                               // CM秒数名1
            retVo.setCm2("");                                               // CM秒数名2
            retVo.setCm3("");                                               // CM秒数名3
            retVo.setCm4("");                                               // CM秒数名4
            retVo.setName1("");                                             // 内容名称1
            retVo.setName2("");                                             // 内容名称2
            retVo.setName3("");                                             // 内容名称3
            retVo.setName4("");                                             // 内容名称4
            retVo.setBngm1("");                                             // 番組名1
            retVo.setBngm2("");                                             // 番組名2
            retVo.setBngm3("");                                             // 番組名3
            retVo.setBngm4("");                                             // 番組名4
            retVo.setBiko1(vo.getName16().trim());                          // 備考1
            retVo.setBiko2(vo.getName17().trim());                          // 備考2
            retVo.setKikan("");                                             // 期間
            retVo.setKeisaiSu("");                                          // 掲載回数
            retVo.setKeisaiTnk(keisaiTnk);                                  // 掲載単価
            retVo.setKeisaiDay(keisaiDay);                                  // 掲載日（発売日）
            retVo.setKingakUw(kingakUw);                                    // 金額内訳（新聞／雑誌）
            retVo.setSyohizeiUw(syohizeiUw);                                // 消費税内訳（新聞／雑誌）
            retVo.setNebiGakUw(nebiGakUw);                                  // 値引額内訳（新聞／雑誌）

        // 種別が「22:雑誌」の場合
        } else if (C_BAITAI_ZASHI.equals(retVo.getBaitaiCd().trim())) {
            retVo.setKeisaiBasCd("");                                       // 掲載場所コード
            retVo.setKeisaiBasNm("");                                       // 掲載場所名称
            retVo.setSybt1Cd("");                                           // 種別1コード
            retVo.setSybt1Nm("");                                           // 種別1名称
            retVo.setSybt2Cd("");                                           // 種別2コード
            retVo.setSybt2Nm("");                                           // 種別2名称
            retVo.setSisaCd(vo.getName11().trim());                         // 色刷コード
            retVo.setSisaNm(vo.getZasi_SisatNm().trim());                   // 色刷名称
            retVo.setSizeCd(vo.getName12().trim());                         // サイズコード
            retVo.setSizeNm(vo.getZasi_SizeNm().trim());                    // サイズ名称
            retVo.setKotukeiCd("");                                         // 交通掲載コード
            retVo.setKotukeiNm("");                                         // 交通掲載名称
            retVo.setKeitaiKbnCd("") ;                                      // 形態区分コード
            retVo.setKeitaiKbnNm("") ;                                      // 形態区分名称
            retVo.setCm1("");                                               // CM秒数名1
            retVo.setCm2("");                                               // CM秒数名2
            retVo.setCm3("");                                               // CM秒数名3
            retVo.setCm4("");                                               // CM秒数名4
            retVo.setName1("");                                             // 内容名称1
            retVo.setName2("");                                             // 内容名称2
            retVo.setName3("");                                             // 内容名称3
            retVo.setName4("");                                             // 内容名称4
            retVo.setBngm1("");                                             // 番組名1
            retVo.setBngm2("");                                             // 番組名2
            retVo.setBngm3("");                                             // 番組名3
            retVo.setBngm4("");                                             // 番組名4
            retVo.setBiko1(vo.getName13().trim());                          // 備考1
            retVo.setBiko2(vo.getName14().trim());                          // 備考2
            retVo.setKikan("");                                             // 期間
            retVo.setKeisaiSu("");                                          // 掲載回数
            retVo.setKeisaiTnk(keisaiTnk);                                  // 掲載単価
            retVo.setKeisaiDay(keisaiDay);                                  // 掲載日（発売日）
            retVo.setKingakUw(kingakUw);                                    // 金額内訳（新聞／雑誌）
            retVo.setSyohizeiUw(syohizeiUw);                                // 消費税内訳（新聞／雑誌）
            retVo.setNebiGakUw(nebiGakUw);                                  // 値引額内訳（新聞／雑誌）

        // 種別が「11:電波」の場合
        } else if (C_BAITAI_DENPA.equals(retVo.getBaitaiCd().trim())) {
            retVo.setKeisaiBasCd("");                                       // 掲載場所コード
            retVo.setKeisaiBasNm("");                                       // 掲載場所名称
            retVo.setSybt1Cd("");                                           // 種別1コード
            retVo.setSybt1Nm("");                                           // 種別1名称
            retVo.setSybt2Cd("");                                           // 種別2コード
            retVo.setSybt2Nm("");                                           // 種別2名称
            retVo.setSisaCd("");                                            // 色刷コード
            retVo.setSisaNm("");                                            // 色刷名称
            retVo.setSizeCd("");                                            // サイズコード
            retVo.setSizeNm("");                                            // サイズ名称
            retVo.setKotukeiCd("");                                         // 交通掲載コード
            retVo.setKotukeiNm("");                                         // 交通掲載名称
            retVo.setKeitaiKbnCd(keitaiKbnCd);                              // 形態区分コード
            retVo.setKeitaiKbnNm(keitaiKbnNm);                              // 形態区分名称
            retVo.setCm1(cmList[0]);                                        // CM秒数名1
            retVo.setName1(nameList[0]);                                    // 内容名称1
            retVo.setBngm1(bngmList[0]);                                    // 番組名1
            retVo.setCm2(cmList[1]);                                        // CM秒数名2
            retVo.setName2(nameList[1]);                                    // 内容名称2
            retVo.setBngm2(bngmList[1]);                                    // 番組名2
            retVo.setCm3(cmList[2]);                                        // CM秒数名3
            retVo.setName3(nameList[2]);                                    // 内容名称3
            retVo.setBngm3(bngmList[2]);                                    // 番組名3
            retVo.setCm4(cmList[3]);                                        // CM秒数名4
            retVo.setName4(nameList[3]);                                    // 内容名称4
            retVo.setBngm4(bngmList[3]);                                    // 番組名4
            retVo.setBiko1(bikou1);                                         // 備考1
            retVo.setBiko2(bikou2);                                         // 備考2
            retVo.setKikan("");                                             // 期間
            retVo.setKeisaiSu("");                                          // 掲載回数
            retVo.setKeisaiTnk("");                                         // 掲載単価
            retVo.setKeisaiDay("");                                         // 掲載日（発売日）
            retVo.setKingakUw("");                                          // 金額内訳（新聞／雑誌）
            retVo.setSyohizeiUw("");                                        // 消費税内訳（新聞／雑誌）
            retVo.setNebiGakUw("");                                         // 値引額内訳（新聞／雑誌）

        // 種別が「31:交通」の場合
        } else if (C_BAITAI_KOTSU.equals(retVo.getBaitaiCd().trim())) {
            retVo.setKeisaiBasCd("");                                       // 掲載場所コード
            retVo.setKeisaiBasNm("");                                       // 掲載場所名称
            retVo.setSybt1Cd("");                                           // 種別1コード
            retVo.setSybt1Nm("");                                           // 種別1名称
            retVo.setSybt2Cd("");                                           // 種別2コード
            retVo.setSybt2Nm("");                                           // 種別2名称
            retVo.setSisaCd("");                                            // 色刷コード
            retVo.setSisaNm("");                                            // 色刷名称
            retVo.setSizeCd("");                                            // サイズコード
            retVo.setSizeNm("");                                            // サイズ名称
            retVo.setKotukeiCd(vo.getName11().trim());                      // 交通掲載コード
            retVo.setKotukeiNm(vo.getSnbn_KeiBasNm().trim());               // 交通掲載名称
            retVo.setKeitaiKbnCd("") ;                                      // 形態区分コード
            retVo.setKeitaiKbnNm("") ;                                      // 形態区分名称
            retVo.setCm1("");                                               // CM秒数名1
            retVo.setCm2("");                                               // CM秒数名2
            retVo.setCm3("");                                               // CM秒数名3
            retVo.setCm4("");                                               // CM秒数名4
            retVo.setName1("");                                             // 内容名称1
            retVo.setName2("");                                             // 内容名称2
            retVo.setName3("");                                             // 内容名称3
            retVo.setName4("");                                             // 内容名称4
            retVo.setBngm1("");                                             // 番組名1
            retVo.setBngm2("");                                             // 番組名2
            retVo.setBngm3("");                                             // 番組名3
            retVo.setBngm4("");                                             // 番組名4
            retVo.setBiko1(vo.getName12().trim());                          // 備考1
            retVo.setBiko2(vo.getName13().trim());                          // 備考2
            retVo.setKikan(vo.getName14().trim());                          // 期間
            retVo.setKeisaiSu(vo.getName15().trim());                       // 掲載回数
            retVo.setKeisaiTnk(keisaiTnk);                                  // 掲載単価
            retVo.setKeisaiDay(keisaiDay);                                  // 掲載日（発売日）
            retVo.setKingakUw(kingakUw);                                    // 金額内訳（新聞／雑誌）
            retVo.setSyohizeiUw(syohizeiUw);                                // 消費税内訳（新聞／雑誌）
            retVo.setNebiGakUw(nebiGakUw);                                  // 値引額内訳（新聞／雑誌）
        }

        return retVo;
    }

    /**
     * 引数の情報を基に、請求データ 一覧情報VOを設定する（合計行データ）
     *
     * @param vo       請求データ 一覧情報VO
     * @param kngk     金額
     * @param syohizei 消費税
     * @return         請求データ 一覧情報VO（返却用）
     */
    private FindClaimCondResultVO setGoukei(FindClaimCondVO vo,
                                            BigDecimal kngk,
                                            BigDecimal syohizei) {

        FindClaimCondResultVO retVo = new FindClaimCondResultVO();

        // 合計行出力 ============================================================================================================================
        retVo = new FindClaimCondResultVO();                                   // 返却用VO（返却用の情報を保持する）
        retVo.setSybt(C_SYBT_T);                                               // 種別 (トータル)
        retVo.setIraiNo(vo.getIraiNo());                                       // 依頼番号（発注番号）
        retVo.setIraiGyoNo("0");                                               // 依頼行番号（発注行番号）
        retVo.setToriCd(vo.getToriCd().trim());                                // 取引先コード
        retVo.setKaiNm(vo.getKaiNm().trim());                                  // 会社名
        retVo.setSeibuCd(vo.getSeibuCd().trim());                              // 請求部署コード
        retVo.setSeiYymm(vo.getSeiYymm().trim());                              // 請求年月日
        retVo.setSeiNo(vo.getSeiNo().trim());                                  // 請求書番号
        retVo.setNebiKbn("");                                                  // 値引行区分
        retVo.setNaiyoKbn("1");                                                // 内容区分 (1:合計)
        retVo.setSeiGyoNo("0");                                                // 請求書行番号
        retVo.setPayDay(vo.getPayDay().trim());                                // 支払日
        retVo.setSyohinKbn(vo.getSyohinKbn().trim());                          // 商品区分
        retVo.setSyohinKbnNm(vo.getSyohinKbnNm().trim());                      // 商品区分名称
        retVo.setSaimokuKbn(vo.getSaimokuKbn().trim());                        // 細目区分
        retVo.setTekiyoCd(vo.getTekiyoCd().trim());                            // 摘要コード
        retVo.setBaitaiCd(vo.getBaitaiCd().trim());                            // 媒体コード(21:新聞 22:雑誌 11:電波 31:交通)
        retVo.setMediaCd("");                                                  // メディアコード
        retVo.setMediaNm("");                                                  // メディア名
        retVo.setTenBan("");                                                   // 店番
        retVo.setKeitaiKbnCd("") ;                                             // 形態区分コード
        retVo.setKeitaiKbnNm("") ;                                             // 形態区分名称
        retVo.setCm1("");                                                      // CM秒数名1
        retVo.setCm2("");                                                      // CM秒数名2
        retVo.setCm3("");                                                      // CM秒数名3
        retVo.setCm4("");                                                      // CM秒数名4
        retVo.setName1("");                                                    // 内容名称1
        retVo.setName2("");                                                    // 内容名称2
        retVo.setName3("");                                                    // 内容名称3
        retVo.setName4("");                                                    // 内容名称4
        retVo.setBngm1("");                                                    // 番組名1
        retVo.setBngm2("");                                                    // 番組名2
        retVo.setBngm3("");                                                    // 番組名3
        retVo.setBngm4("");                                                    // 番組名4
        retVo.setKeisaiBasCd("");                                              // 掲載場所コード
        retVo.setKeisaiBasNm("");                                              // 掲載場所名称
        retVo.setSybt1Cd("");                                                  // 種別1コード
        retVo.setSybt1Nm("");                                                  // 種別1名称
        retVo.setSybt2Cd("");                                                  // 種別2コード
        retVo.setSybt2Nm("");                                                  // 種別2名称
        retVo.setSisaCd("");                                                   // 色刷コード
        retVo.setSisaNm("");                                                   // 色刷名称
        retVo.setSizeCd("");                                                   // サイズコード
        retVo.setSizeNm("");                                                   // サイズ名称
        retVo.setKotukeiCd("");                                                // 交通掲載コード
        retVo.setKotukeiNm("");                                                // 交通掲載名称
        retVo.setKikan("");                                                    // 期間
        retVo.setKeisaiSu("");                                                 // 掲載回数
        retVo.setBiko1("");                                                    // 備考1
        retVo.setBiko2("");                                                    // 備考2
        retVo.setKingak(kngk);                                                 // 金額
        retVo.setSyohizei(syohizei);                                           // 消費税額
        retVo.setKingakSum(kngk.add(syohizei));                                // 合計金額 (金額 + 消費税)
        retVo.setAnbunSybt("");                                                // 按分種別
        retVo.setKbn(vo.getKbn().trim());                                      // 区分
        retVo.setKenmei("");                                                   // 件名
        retVo.setShoriKbn("");                                                 // 処理区分
        retVo.setShoriKbnNm("");                                               // 処理区分名
        retVo.setKeisaiTnk("");                                                // 掲載単価
        retVo.setTouDate("");                                                  // 登録年月日
        retVo.setHenDate("");                                                  // 変更年月日
        retVo.setTorDate("");                                                  // 取消年月日
        retVo.setOutDate(vo.getOutDate().trim());                              // 出力日時
        retVo.setJyutNo(vo.getJyutNo().trim());                                // 受注No
        retVo.setJymeiNo(vo.getJymeiNo().trim());                              // 受注明細No
        retVo.setUrmeiNo(vo.getUrmeiNo().trim());                              // 売上明細No
        retVo.setRenBan(vo.getRenBan().trim());                                // 連番

        String iraiNo = vo.getIraiNo();
        if (iraiNo.equals("")) {
            iraiNo = "ZZZZZZZZ";
        }

        String iraiGyoNo = vo.getIraiGyoNo();
        if (iraiGyoNo.equals("")) {
            iraiGyoNo = "ZZZ";
        }

        String seiNo = vo.getSeiNo();
        if (seiNo.equals("")) {
            seiNo = "ZZZZZZZZ";
        }

        String seiGyoNo = vo.getSeiGyoNo();
        if (seiGyoNo.equals("")) {
            seiGyoNo = "ZZZ";
        }

        // ソート順（依頼番号 ＋ 依頼行番号 + 請求書番号 ＋ 請求書行番号 + 種別(T))
        retVo.setSortNo(iraiNo + iraiGyoNo + seiNo + seiGyoNo + C_SYBT_T);

        return retVo;
    }

    /**
     * 発注/請求 差異一覧情報の編集を行う
     *
     * @param list       発注/請求 差異一覧情報を含むVOリスト
     * @param resultList 請求データ 一覧情報（返却用）を含むVOリスト
     * @param yymm       年月日
     * @return           発注/請求 差異一覧情報（返却用）を含むVOリスト
     */
    private List<FindClaimDiffCondResultVO> editClaimDiffDataList(List<FindClaimDiffCondVO> list,
                                                                  List<FindClaimCondResultVO> resultList,
                                                                  String yymm) {

        List<FindClaimDiffCondResultVO> retList = new ArrayList<FindClaimDiffCondResultVO>();

        FindClaimDiffCondResultVO outVo = null;         // 返却用VO（返却用の情報を保持する）
        FindClaimDiffCondVO getVo = null;               // 保持用VO（SQLで取得した情報を保持する）

        // 請求データ 一覧情報のサイズが０の場合、空のリストを返却する
        if (resultList.size() == 0) {
            return retList;
        }

        // 請求データ 一覧情報リストから値をコピー
        for (FindClaimCondResultVO resultVo: resultList) {
            outVo = new FindClaimDiffCondResultVO();
            outVo.setSybt(resultVo.getSybt());                                 // 種別
            outVo.setIraiNo(resultVo.getIraiNo());                             // 依頼番号（発注番号）
            outVo.setIraiGyoNo(resultVo.getIraiGyoNo());                       // 依頼行番号（発注行番号）
            outVo.setToriCd(resultVo.getToriCd());                             // 取引先コード
            outVo.setSeibuCd(resultVo.getSeibuCd());                           // 請求部署コード
            outVo.setSeiYymm(resultVo.getSeiYymm());                           // 請求年月日
            outVo.setSeiNo(resultVo.getSeiNo());                               // 請求書番号
            outVo.setNaiyoKbn(resultVo.getNaiyoKbn());                         // 内容区分
            outVo.setSeiGyoNo(resultVo.getSeiGyoNo());                         // 請求書行番号
            outVo.setPayDay(resultVo.getPayDay());                             // 支払日
            outVo.setSyohinKbn(resultVo.getSyohinKbn());                       // 商品区分
            outVo.setTekiyoCd(resultVo.getTekiyoCd());                         // 摘要コード
            outVo.setBaitaiCd(resultVo.getBaitaiCd());                         // 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )
            outVo.setMediaCd(resultVo.getMediaCd());                           // メディアコード
            outVo.setMediaNm(resultVo.getMediaNm());                           // メディア名
            outVo.setTenBan(resultVo.getTenBan());                             // 店番
            outVo.setKeitaiKbnCd(resultVo.getKeitaiKbnCd());                   // 形態区分コード
            outVo.setKeitaiKbnNm(resultVo.getKeitaiKbnNm());                   // 形態区分名称
            outVo.setCm1(resultVo.getCm1());                                   // CM秒数名1
            outVo.setCm2(resultVo.getCm2());                                   // CM秒数名2
            outVo.setCm3(resultVo.getCm3());                                   // CM秒数名3
            outVo.setCm4(resultVo.getCm4());                                   // CM秒数名4
            outVo.setName1(resultVo.getName1());                               // 内容名称1
            outVo.setName2(resultVo.getName2());                               // 内容名称2
            outVo.setName3(resultVo.getName3());                               // 内容名称3
            outVo.setName4(resultVo.getName4());                               // 内容名称4
            outVo.setBngm1(resultVo.getBngm1());                               // 番組名1
            outVo.setBngm2(resultVo.getBngm2());                               // 番組名2
            outVo.setBngm3(resultVo.getBngm3());                               // 番組名3
            outVo.setBngm4(resultVo.getBngm4());                               // 番組名4
            outVo.setKeisaiBasCd(resultVo.getKeisaiBasCd());                   // 掲載場所コード
            outVo.setKeisaiBasNm(resultVo.getKeisaiBasNm());                   // 掲載場所名称
            outVo.setSybt1Cd(resultVo.getSybt1Cd());                           // 種別1コード
            outVo.setSybt1Nm(resultVo.getSybt1Nm());                           // 種別1名称
            outVo.setSybt2Cd(resultVo.getSybt2Cd());                           // 種別2コード
            outVo.setSybt2Nm(resultVo.getSybt2Nm());                           // 種別2名称
            outVo.setSisaCd(resultVo.getSisaCd());                             // 色刷コード
            outVo.setSisaNm(resultVo.getSisaNm());                             // 色刷名称
            outVo.setSizeCd(resultVo.getSizeCd());                             // サイズコード
            outVo.setSizeNm(resultVo.getSizeNm());                             // サイズ名称
            outVo.setKotukeiCd(resultVo.getKotukeiCd());                       // 交通掲載コード
            outVo.setKotukeiNm(resultVo.getKotukeiNm());                       // 交通掲載名称
            outVo.setKeisaiSu(resultVo.getKeisaiSu());                         // 掲載回数
            outVo.setBiko1(resultVo.getBiko1());                               // 備考1
            outVo.setBiko2(resultVo.getBiko2());                               // 備考2
            outVo.setKeisaiTnk(resultVo.getKeisaiTnk());                       // 掲載単価
            outVo.setKingak(resultVo.getKingak());                             // 行単位金額
            outVo.setSyohizei(resultVo.getSyohizei());                         // 行単位消費税
            outVo.setKingakSum(resultVo.getKingakSum());                       // 行単位金額合計
            outVo.setAnbunSybt(resultVo.getAnbunSybt());                       // 按分種別
            outVo.setKbn(resultVo.getKbn());                                   // 区分
            outVo.setKenmei(resultVo.getKenmei());                             // 件名
            outVo.setKikan(resultVo.getKikan());                               // 期間
            outVo.setSortNo(resultVo.getSortNo());                             // ソート

            // 返却用リストに追加する
            ModelUtils.copyMemberSearchAfterInstace(outVo);
            retList.add(outVo);
        }

        // コピーしたリストに、取得した情報を追加する
        for (int i = 0; i < list.size(); i++) {

            getVo = (FindClaimDiffCondVO) list.get(i);
            outVo = new FindClaimDiffCondResultVO();

            outVo.setSybt(getVo.getRecCd().trim());                            // レコード種別
            outVo.setIraiNo(getVo.getIrBan());                                 // 依頼番号
            outVo.setIraiGyoNo(getVo.getIrRowBan());                           // 依頼行番号
            outVo.setToriCd(getVo.getTokuiCd().trim());                        // 取引先コード（得意先コード）
            outVo.setNaiyoKbn("2");                                            // 内容区分(明細：2 合計：1)
            outVo.setSyohinKbn(getVo.getSyohinKbn().trim());                   // 商品区分
            outVo.setTekiyoCd(getVo.getTekiCd().trim());                       // 摘要コード
            outVo.setBaitaiCd(getVo.getSybt().trim());                         // 媒体コード（種別）
            outVo.setMediaCd(getVo.getMediaCd().trim());                       // メディアコード
            outVo.setMediaNm(getVo.getMediaNm().trim());                       // メディア名
            outVo.setTenBan(getVo.getTenBan().trim());                         // 店番
            outVo.setBiko1(getVo.getBikou1().trim());                          // 備考1
            outVo.setBiko2(getVo.getBikou2().trim());                          // 備考2
            outVo.setAnbunSybt(getVo.getAnSybt().trim());                      // 按分種別

            String iraiNo = getVo.getIrBan();
            if (iraiNo.equals("")) {
                iraiNo = "ZZZZZZZZ";
            }

            String iraiGyoNo = getVo.getIrRowBan();
            if (iraiGyoNo.equals("")) {
                iraiGyoNo = "ZZZ";
            }

            String seiNo = "        ";
            String seiGyoNo = "   ";

            // ソート順（依頼番号 ＋ 依頼行番号 + 請求書番号 ＋ 請求書行番号 + 種別)
            outVo.setSortNo(iraiNo + iraiGyoNo + seiNo + seiGyoNo + getVo.getRecCd().trim());

            String keisaiTnk = "";
            try {
                int value = Integer.parseInt(getVo.getKeisaiTnk().trim());
                keisaiTnk = String.format("%,d",value);
            } catch(NumberFormatException e) {
                keisaiTnk = "";
            }

            // 種別が「21:新聞」の場合
            if (C_BAITAI_SHINBUN.equals(outVo.getBaitaiCd().trim())) {
                outVo.setKeitaiKbnCd("") ;                                     // 形態区分コード
                outVo.setKeitaiKbnNm("") ;                                     // 形態区分名称
                outVo.setKeisaiTnk(keisaiTnk);                                 // 掲載単価
                outVo.setKeisaiBasCd(getVo.getPlaceCd().trim());               // 掲載場所コード
                outVo.setKeisaiBasNm(getVo.getKeiBasNm().trim());              // 掲載場所名称
                outVo.setSybt1Cd(getVo.getSybt1Cd().trim());                   // 種別1コード
                outVo.setSybt1Nm(getVo.getSybt1Nm().trim());                   // 種別1名称
                outVo.setSybt2Cd(getVo.getSybt2Cd().trim());                   // 種別2コード
                outVo.setSybt2Nm(getVo.getSybt2Nm().trim());                   // 種別2名称
                outVo.setSisaCd(getVo.getColorCd().trim());                    // 色刷コード
                outVo.setSisaNm(getVo.getSisatNm().trim());                    // 色刷名称
                outVo.setSizeCd(getVo.getSpCd().trim());                       // スペースコード
                outVo.setSizeNm(getVo.getSpNm().trim());                       // スペース名称
                outVo.setKotukeiCd("");                                        // 交通掲載コード
                outVo.setKotukeiNm("");                                        // 交通掲載名称
                //outVo.setKingak(getVo.getHosoRyo1());                          // 金額
                outVo.setKingak(getVo.getKeisaiRyo());                          // 金額

            // 種別が「22:雑誌」の場合
            } else if (C_BAITAI_ZASHI.equals(outVo.getBaitaiCd().trim())) {
                outVo.setKeitaiKbnCd("") ;                                     // 形態区分コード
                outVo.setKeitaiKbnNm("") ;                                     // 形態区分名称
                outVo.setKeisaiTnk(keisaiTnk);                                 // 掲載単価
                outVo.setKeisaiBasCd("");                                      // 掲載場所コード
                outVo.setKeisaiBasNm("");                                      // 掲載場所名称
                outVo.setSybt1Cd("");                                          // 種別1コード
                outVo.setSybt1Nm("");                                          // 種別1名称
                outVo.setSybt2Cd("");                                          // 種別2コード
                outVo.setSybt2Nm("");                                          // 種別2名称
                outVo.setSisaCd(getVo.getColorCd().trim());                    // 色刷コード
                outVo.setSisaNm(getVo.getSisatNm().trim());                    // 色刷名称
                outVo.setSizeCd(getVo.getSizeCd().trim());                     // サイズコード
                outVo.setSizeNm(getVo.getSizeNm().trim());                     // サイズ名称
                outVo.setKotukeiCd("");                                        // 交通掲載コード
                outVo.setKotukeiNm("");                                        // 交通掲載名称
                //outVo.setKingak(getVo.getHosoRyo1());                          // 金額
                outVo.setKingak(getVo.getKeisaiRyo());                          // 金額

            // 種別が「11:電波」の場合
            } else if (C_BAITAI_DENPA.equals(outVo.getBaitaiCd().trim())) {
                outVo.setKeitaiKbnCd(getVo.getKeitaiCd().trim()) ;             // 形態区分コード
                outVo.setKeitaiKbnNm(getVo.getKeitaiName().trim()) ;           // 形態区分名称
                outVo.setKeisaiTnk("");                                        // 掲載単価
                outVo.setKeisaiBasCd("");                                      // 掲載場所コード
                outVo.setKeisaiBasNm("");                                      // 掲載場所名称
                outVo.setSybt1Cd("");                                          // 種別1コード
                outVo.setSybt1Nm("");                                          // 種別1名称
                outVo.setSybt2Cd("");                                          // 種別2コード
                outVo.setSybt2Nm("");                                          // 種別2名称
                outVo.setSisaCd("");                                           // 色刷コード
                outVo.setSisaNm("");                                           // 色刷名称
                outVo.setSizeCd("");                                           // サイズコード
                outVo.setSizeNm("");                                           // サイズ名称
                outVo.setKotukeiCd("");                                        // 交通掲載コード
                outVo.setKotukeiNm("");                                        // 交通掲載名称

                // 電波の時だけ分かれる（依頼月がまたがって来ている為）
                if (yymm.equals(getVo.getIrMonth1())) {
                    // 金額1
                    outVo.setKingak(getVo.getHosoRyo1());

                } else if (yymm.equals(getVo.getIrMonth2())) {
                    // 金額2
                    outVo.setKingak(getVo.getHosoRyo2());

                } else if (yymm.equals(getVo.getIrMonth3())) {
                    // 金額3
                    outVo.setKingak(getVo.getHosoRyo3());

                } else if (yymm.equals(getVo.getIrMonth4())) {
                    // 金額4
                    outVo.setKingak(getVo.getHosoRyo4());

                } else if (yymm.equals(getVo.getIrMonth5())) {
                    // 金額5
                    outVo.setKingak(getVo.getHosoRyo5());

                } else if (yymm.equals(getVo.getIrMonth6())) {
                    // 金額6
                    outVo.setKingak(getVo.getHosoRyo6());
                }

            // 種別が「31:交通」の場合
            } else if (C_BAITAI_KOTSU.equals(outVo.getBaitaiCd().trim())) {
                outVo.setKeitaiKbnCd("") ;                                     // 形態区分コード
                outVo.setKeitaiKbnNm("") ;                                     // 形態区分名称
                outVo.setKeisaiTnk(keisaiTnk);                                 // 掲載単価
                outVo.setKeisaiBasCd("");                                      // 掲載場所コード
                outVo.setKeisaiBasNm("");                                      // 掲載場所名称
                outVo.setSybt1Cd("");                                          // 種別1コード
                outVo.setSybt1Nm("");                                          // 種別1名称
                outVo.setSybt2Cd("");                                          // 種別2コード
                outVo.setSybt2Nm("");                                          // 種別2名称
                outVo.setSisaCd("");                                           // 色刷コード
                outVo.setSisaNm("");                                           // 色刷名称
                outVo.setSizeCd("");                                           // サイズコード
                outVo.setSizeNm("");                                           // サイズ名称
                outVo.setKotukeiCd(getVo.getKotuKeiCd().trim());               // 交通掲載コード
                outVo.setKotukeiNm(getVo.getKotKeiNm().trim());                // 交通掲載名称
                //outVo.setKingak(getVo.getHosoRyo1());                          // 金額
                outVo.setKingak(getVo.getKeisaiRyo());                          // 金額
            }

            ModelUtils.copyMemberSearchAfterInstace(outVo);
            retList.add(outVo);
        }

        return retList;
    }

    /**
     * 値引マスタを参照し、値引額を計算・取得する
     *
     * @param  keisaiDay    掲載日
     * @param  mediaCd      メディアコード
     * @param  nebiGak      値引額
     * @param  kingak       金額
     * @return              値引額
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private BigDecimal getNebiGak(String keisaiDay, String mediaCd, BigDecimal nebiGak, BigDecimal kingak) throws KKHException {

        // データ取得DAOのインスタンス生成
        FindClaimByCondDAO dao = FindClaimByCondDAOFactory.createFindKenMeisaiByCondDAO();

        // データ取得
        _lCond.setKeisaiDay(keisaiDay);
        List<FindNebikiCondVO> nebiList = dao.findNebikiDataByCondition(_lCond);

        if (nebiList.size() == 0) {
            return BigDecimal.ZERO;
        }

        String gyomuKbn = "11010";                  // 業務区分
        String himokuCd = "001";                    // 費目コード
        String baitaiCdr = "";                      // 媒体コード
        boolean btHitFlg = false;                   // フラグ
        BigDecimal nebikiRitsu = BigDecimal.ZERO;   // 値引率
        BigDecimal nebikiRitsu2 = BigDecimal.ZERO;  // 値引率
        BigDecimal toriGak = BigDecimal.ZERO;       // 取料金
        BigDecimal retNebiGak = BigDecimal.ZERO;    // 値引金額

        for (int i = 0; i < nebiList.size(); i++) {

            FindNebikiCondVO result = (FindNebikiCondVO) nebiList.get(i);

            // １．[業務区分]が等しい。[媒体コードﾞ頭４桁]が等しい。[費目ｺｰﾄﾞ]が等しい。
            if (result.getBtCd().length() == 6) {
                if (gyomuKbn.equals(result.getGMkbnCd()) &&
                    mediaCd.substring(0, 4).equals(result.getBtCd().substring(0, 4)) &&
                    himokuCd.equals(result.getHmCd())) {

                    // [値引率マスタの媒体コード]と[パラメータ媒体コード]が等しい。
                    if (mediaCd.equals(result.getBtCd())) {
                        btHitFlg = true;
                        nebikiRitsu2 = result.getNebikiR();
                    }

                    // [値引率マスタの媒体コード下２桁]が ""。
                    if ("".equals(result.getBtCd().substring(4))) {
                        nebikiRitsu = result.getNebikiR();
                        break;
                    }
                }
            }

            // ２.[業務区分]が等しい。媒体コードの４桁目を、０に変換した[媒体コード上４桁]が等しい。[費目コード]が等しい。
            if (result.getBtCd().length() == 6) {
                if ("00".equals(mediaCd.substring(0, 2))) {

                    baitaiCdr = mediaCd.substring(0, 3) + "0";

                    if (gyomuKbn.equals(result.getGMkbnCd()) &&
                        baitaiCdr.equals(result.getBtCd().substring(0, 4)) &&
                        himokuCd.equals(result.getHmCd())) {

                        // [値引率マスタの媒体コード]と[パラメータ媒体コード]が等しい。
                        if (mediaCd.equals(result.getBtCd())) {
                            btHitFlg = true;
                            nebikiRitsu2 = result.getNebikiR();
                        }

                        // [値引率マスタの媒体コード下２桁]が ""。
                        if ("".equals(result.getBtCd().substring(4))) {
                            nebikiRitsu = result.getNebikiR();
                            break;
                        }
                    }
                }
            }

            // ３．[業務区分]が等しい。[媒体コード]が等しい。[費目コード]がスペース。
            if (result.getBtCd().length() == 6) {
                if (gyomuKbn.equals(result.getGMkbnCd()) &&
                    mediaCd.substring(0, 4).equals(result.getBtCd().substring(0, 4)) &&
                    "".equals(result.getHmCd())) {

                    // [値引率マスタの媒体コード]と[パラメータ媒体コード]が等しい。
                    if (mediaCd.equals(result.getBtCd())) {
                        btHitFlg = true;
                        nebikiRitsu2 = result.getNebikiR();
                    }

                    // [値引率マスタの媒体コード下２桁]が ""。
                    if ("".equals(result.getBtCd().substring(4))) {
                        nebikiRitsu = result.getNebikiR();
                        break;
                    }
                }
            }

            // ４．[業務区分]が等しい。媒体コードの４桁目を０に変換した[媒体コード上４桁]が等しい。[費目コード]がスペース。
            if (result.getBtCd().length() == 6) {
                if ("00".equals(mediaCd.substring(0, 2))) {

                    baitaiCdr = mediaCd.substring(0, 3) + "0";

                    if (gyomuKbn.equals(result.getGMkbnCd()) &&
                        baitaiCdr.equals(result.getBtCd().substring(0, 4)) &&
                        "".equals(result.getHmCd())) {

                        // [値引率マスタの媒体コード]と[パラメータ媒体コード]が等しい。
                        if (mediaCd.equals(result.getBtCd())) {
                            btHitFlg = true;
                            nebikiRitsu2 = result.getNebikiR();
                        }

                        // [値引率マスタの媒体コード下２桁]が ""。
                        if ("".equals(result.getBtCd().substring(4))) {
                            nebikiRitsu = result.getNebikiR();
                            break;
                        }
                    }
                }
            }

            // ５．[業務区分]が等しい。[媒体コード]がスペース。[費目コード]が等しい。
            if (gyomuKbn.equals(result.getGMkbnCd()) &&
                "".equals(result.getBtCd()) &&
                "".equals(result.getHmCd())) {

                nebikiRitsu = result.getNebikiR();
                break;
            }

            // ６．[業務区分]が等しい。[媒体コード]がスペース。[費目コード]がスペース。
            if (gyomuKbn.equals(result.getGMkbnCd().trim()) &&
                "".equals(result.getBtCd().trim()) &&
                himokuCd.equals(result.getHmCd().trim())) {

                nebikiRitsu = result.getNebikiR();
                break;
            }

            // ７．[業務区分]がスペース。[媒体コード]がスペース。[費目コード]がスペース。
            if ("".equals(result.getGMkbnCd().trim()) &&
                "".equals(result.getBtCd().trim()) &&
                "".equals(result.getHmCd().trim())) {

                nebikiRitsu = result.getNebikiR();
                break;
            }
        }

        if (btHitFlg) {
            nebikiRitsu = nebikiRitsu2;
        }

        // 計算
        BigDecimal val = new BigDecimal(100);               //
        BigDecimal val2 = new BigDecimal(100);              //
        BigDecimal val3 = kingak.multiply(val);             // （金額 * 100）
        BigDecimal val4 = val2.subtract(nebikiRitsu);       // （100 - 値引率）

        // 取料金を算出（（金額 * 100）/ （100 - 値引率））
        toriGak =  val3.divide(val4, 0, BigDecimal.ROUND_HALF_UP);

        // 値引金額を算出（取料金 - 金額）
        retNebiGak = toriGak.subtract(kingak);

        return retNebiGak;
    }
}

