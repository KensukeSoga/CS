package jp.co.isid.kkh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <P>
 * 日付に関するユーティリティクラス。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/01/07 ISID-IT K.Nukita)<BR>
 * </P>
 * @author ISID-IT K.Nukita
 */
public class DateUtil {

    /**
     * String→Date型変換処理
     *
     * @param strDate ８桁の日付文字列(YYYYMMDD)
     * @return Date 日付
     */
    public static Date toDate(String dateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            return format.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Date→String型変換処理
     *
     * @param date 日付
     * @return String ８桁の日付文字列(YYYYMMDD)
     */
    public static String toString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    /**
     * 日付に指定された日数を加算します
     *
     * @param dateString 日付
     * @param count 加算する日数
     * @return
     */
    public static String addDate(String dateString ,int count){

        Date date = toDate(dateString);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, count);

        return toString(cal.getTime());
    }

    /**
     * システム日付を指定のフォーマットで戻す<br>
     * 【凡例】<br>
     *   yyyy：西暦4桁<br>
     *   MM：月2桁<br>
     *   dd：日2桁<br>
     *   HH：時(24時間表記)<br>
     *   hh：時(12時間表記)<br>
     *   mm：分2桁<br>
     *   ss：秒2桁<br>
     *   SSS：ミリ秒3桁<br>
     *
     * @param dateString String 日付
     * @param targetFormat String 出力フォーマット (例．例１："yyyy/MM/dd"、例２："HH:mm"、例３："yyyy/MM/dd HH:mm:ss.SSS")
     * @return String 変換後文字列 (例１："2007/08/05"、例２："15:30"、例３："2008/03/22 15:24:10.876")
     */
    public static String getFormatStringDate(String dateString, String targetFormat) {
        Date date = toDate(dateString);
        return new SimpleDateFormat(targetFormat).format(date);
    }

    /**
     * 期間From(yyyyMMdd)～期間To(yyyyMMdd)までの年のリストを取得します
     *
     * @param termFrom String 期間From
     * @param termTo String 期間To
     * @return List<String> 年のリスト
     */
    public static List<String> getYearList(String termFrom, String termTo) {

        Date dateFrom = toDate(termFrom);
        Date dateTo = toDate(termTo);
        Calendar calFrom = Calendar.getInstance();
        Calendar calTo = Calendar.getInstance();

        calFrom.setTime(dateFrom);
        calTo.setTime(dateTo);

        List<String> yearList = new ArrayList<String>();

        while (calFrom.get(Calendar.YEAR) <= calTo.get(Calendar.YEAR)) {
            yearList.add(String.valueOf(calFrom.get(Calendar.YEAR)));
            calFrom.add(Calendar.YEAR, 1);
        }

        return yearList;
    }

    /**
     * 期首取得
     *
     * @param eigyoBi ホスト営業日
     * @return 期首
     */
    public static String getTermBegin(String eigyoBi) {

        int year = Integer.parseInt(eigyoBi.substring(0, 4));
        int month = Integer.parseInt(eigyoBi.substring(4, 6));

        if (month >= 1 && month <= 3) {
            year = year - 1;
        }
        return Integer.toString(year) + "04";
    }

    /**
     * 期末取得
     *
     * @param eigyoBi ホスト営業日
     * @return 期末
     */
    public static String getTermEnd(String eigyoBi) {

        int year = Integer.parseInt(eigyoBi.substring(0, 4));
        int month = Integer.parseInt(eigyoBi.substring(4, 6));

        if (month >= 4 && month <= 12) {
            year = year + 1;
        }
        return Integer.toString(year) + "03";
    }

}
