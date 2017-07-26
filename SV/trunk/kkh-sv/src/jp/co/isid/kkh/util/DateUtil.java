package jp.co.isid.kkh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <P>
 * ���t�Ɋւ��郆�[�e�B���e�B�N���X�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/01/07 ISID-IT K.Nukita)<BR>
 * </P>
 * @author ISID-IT K.Nukita
 */
public class DateUtil {

    /**
     * String��Date�^�ϊ�����
     *
     * @param strDate �W���̓��t������(YYYYMMDD)
     * @return Date ���t
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
     * Date��String�^�ϊ�����
     *
     * @param date ���t
     * @return String �W���̓��t������(YYYYMMDD)
     */
    public static String toString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    /**
     * ���t�Ɏw�肳�ꂽ���������Z���܂�
     *
     * @param dateString ���t
     * @param count ���Z�������
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
     * �V�X�e�����t���w��̃t�H�[�}�b�g�Ŗ߂�<br>
     * �y�}��z<br>
     *   yyyy�F����4��<br>
     *   MM�F��2��<br>
     *   dd�F��2��<br>
     *   HH�F��(24���ԕ\�L)<br>
     *   hh�F��(12���ԕ\�L)<br>
     *   mm�F��2��<br>
     *   ss�F�b2��<br>
     *   SSS�F�~���b3��<br>
     *
     * @param dateString String ���t
     * @param targetFormat String �o�̓t�H�[�}�b�g (��D��P�F"yyyy/MM/dd"�A��Q�F"HH:mm"�A��R�F"yyyy/MM/dd HH:mm:ss.SSS")
     * @return String �ϊ��㕶���� (��P�F"2007/08/05"�A��Q�F"15:30"�A��R�F"2008/03/22 15:24:10.876")
     */
    public static String getFormatStringDate(String dateString, String targetFormat) {
        Date date = toDate(dateString);
        return new SimpleDateFormat(targetFormat).format(date);
    }

    /**
     * ����From(yyyyMMdd)�`����To(yyyyMMdd)�܂ł̔N�̃��X�g���擾���܂�
     *
     * @param termFrom String ����From
     * @param termTo String ����To
     * @return List<String> �N�̃��X�g
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
     * ����擾
     *
     * @param eigyoBi �z�X�g�c�Ɠ�
     * @return ����
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
     * �����擾
     *
     * @param eigyoBi �z�X�g�c�Ɠ�
     * @return ����
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
