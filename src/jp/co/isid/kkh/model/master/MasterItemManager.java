package jp.co.isid.kkh.model.master;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �ėp�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/03 Fourm H.izawa)<BR>
 * </P>
 * @author
 */
public class MasterItemManager {

    /** �V���O���g���C���X�^���X */
    private static MasterItemManager _manager = new MasterItemManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private MasterItemManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static MasterItemManager getInstance() {
        return _manager;
    }




    /**
     * �ėp�}�X�^(��ށE����)���������܂��B
     *
     * @return MasterResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public MasterItemResult findMasterDefineByCondition(MasterCondition cond) throws KKHException {


        if (cond.getEgCd() == null || cond.getEgCd().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        //��������
        MasterItemResult result = new MasterItemResult();
        MasterItemDAO dao = MasterItemDAOFactory.createMasterItemDAO();
        List<MasterVO> list = dao.findMasterKindByCondition(cond);
        result.setMasterItem(list);



        return result;
    }




}
