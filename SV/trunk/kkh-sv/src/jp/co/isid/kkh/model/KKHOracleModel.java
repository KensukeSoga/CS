package jp.co.isid.kkh.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.isid.nj.integ.sql.AbstractDBModel;
import jp.co.isid.nj.integ.sql.DBModelInterface;

/**
 * <P>
 * KKHSQLServer�p�̂c�a���f���N���X�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/01/11 ISID-IT K.Nukita)<BR>
 * </P>
 * @author ISID-IT K.Nukita
 */
public class KKHOracleModel extends AbstractDBModel implements Serializable {

    private static final long serialVersionUID = 1L;

    //�C���X�^���X�ێ�
    private static KKHOracleModel sqlServerModel = null;

    /**
     * �R���X�g���N�^
     */
    private KKHOracleModel(){
    }

    /**
     * �C���X�^���X�擾
     * @return DBModelInterface ���̃N���X���ێ����Ă���C���X�^���X
     */
    public static synchronized DBModelInterface getInstance(){
        if (sqlServerModel == null) sqlServerModel = new KKHOracleModel();
        return sqlServerModel;
    }

    /**
     * MS932�̕ϊ����K�v���ǂ���
     */
    public boolean needConvertMS932(){
        return false;
    }

    /**
     * �V�X�e�����t�p��SQL������("getdate()")��Ԃ��܂��B
     */
    public String getSystemDateString(){
        return "SYSDATE";
    }

    /**
     * ���t�^�p��SQL�������Ԃ��܂��B
     */
    public String getDateString(Date date){

//        return " '" + date.toString() + "'";
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         return "TO_DATE('" + sdf.format(date) + "','YYYY/MM/DD HH24:MI:SS')";
    }

    /**
     * Timestamp�^�p��SQL�������Ԃ��܂��B
     */
    public String getTimestampString(Timestamp ts){
        return "  '" + ts.toString() + "'";
    }

//    /**
//     * �r�p�k���ɍ��킹��������ɕϊ����܂��B
//     *
//     * @param obj �ϊ��Ώ�
//     * @return �r�p�k������
//     */
//	@Override
//    public String ConvertToDBString(Object obj) {
//		if (obj != null) {
//			if (obj.getClass().getName().equals("java.lang.String")) {
//				String str = (String)obj;
//				if (str.equals("")) {
//					// �e�N���X�i�t���[�����[�N�j�̃��\�b�h��
//					// �u''(�󕶎�)�v���u' '(�󔒂P��)�v�ɕϊ����Ă��܂��̂ŁA
//					// NULL(DummyNull)�ɒu�������Ă����B
//					// �iOracle �ł́A�󕶎���NULL �ƔF������Ă���j
//					obj = DummyNull.getInstance();
//				}
//			}
//        }
//        // ��͐e�N���X�ɂ��C��
//        return super.ConvertToDBString(obj);
//    }

}