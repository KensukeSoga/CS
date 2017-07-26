package jp.co.isid.kkh.util;



/**
 * <p>
 * ������Ɋւ��郆�[�e�B���e�B�N���X�B
 * </p>
 * <p>
 * <b>�C������</b><br />
 * �E�V�K�쐬(2006/09/22 WT H.Ikeda)<br />
 * </p>
 *
 * @author WT H.Ikeda
 */
public final class StringUtil {

    /**
     * ���[�e�B���e�B�N���X�̂��߃C���X�^���X�����֎~���܂��B
     */
    private StringUtil() {
    }

    /**
     * ������ s ���u�����N���ǂ����𔻒肵�܂��B
     * �u�����N�̒�`�͉��L�̒ʂ�ł��B
     * (1) s �� null �ł���B
     * (2) s �� trim ����������̒����� 0 �ł���B
     *
     * @param s ������
     * @return �u�����N�Ȃ�� true
     */
    public static boolean isBlank(String s) {
        if (s == null) {
            return true;
        } else {
            return s.trim().length() == 0;
        }
    }

    /**
     * ��������g�������܂��B
     * �Enull�̏ꍇ�͋󕶎���ԋp���܂�
     *
     * @param s ������
     * @return �g��������������
     */
    public static String trim(String s) {
        if (s == null) {
            return "";
        } else {
            return s.trim();
        }
    }

//    /**
//     * �T�j�^�C�W���O����
//     *
//     * @param str �ϊ����镶����
//     * @return �G�X�P�[�v�����`�ŕ������Ԃ��܂��B
//     * �i��j
//     * IN    A_'%DDD
//     * OUT   'A#_''#%DDD'
//     */
//    public static String sanitizing(String str) {
//
//        List<String> lst = KKHParameter.getInstance().getNGStringList();
//
//        String result = new String();
//        char c = "'".charAt(0);
//        char escape = "#".charAt(0);
//        char chrChk;
//        for(int j = 0 ; j < str.length(); j++){
//            String sani = "";
//            char chr = str.charAt(j);
//            for (int i = 0; i < lst.size(); i++) {
//                chrChk = lst.get(i).charAt(0);
//               if (chr == chrChk ) {
//                   if(chr == c) {
//                       sani = c + "";
//                       break;
//                   } else {
//                       sani = escape+ "";
//                       break;
//                   }
//               } else if (chr == escape){
//                   sani = escape + "";
//                   break;
//               }
//            }
//            result = result + sani + chr;
//        }
//        return  result;
//    }
//
//    /**
//     * �T�j�^�C�W���O����
//     *
//     * @param str �ϊ����镶����
//     * @return �G�X�P�[�v�����`�ŕ������Ԃ��܂��B
//     * �i��j
//     * IN    A_'%DDD
//     * OUT   '%A#_''#%DDD%' ESCAPE '#'
//     */
//    public static String sanitizingEx(String str) {
//        return  "'%" + StringUtil.sanitizing(str) + "%' ESCAPE '#'";
//    }


}
