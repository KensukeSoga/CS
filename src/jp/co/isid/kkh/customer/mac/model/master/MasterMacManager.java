package jp.co.isid.kkh.customer.mac.model.master;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;

/**
 * <P>
 * �ėp�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 IP Shimizu)<BR>
 * </P>
 * @author
 */
public class MasterMacManager {

    /** �V���O���g���C���X�^���X */
    private static MasterMacManager _manager = new MasterMacManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private MasterMacManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static MasterMacManager getInstance() {
        return _manager;
    }

//    /**
//     * �ėp�}�X�^�i�f�[�^�j�̍X�V�^�C���X�^���v�i�ő�l�j�̎擾
//     *
//     * @param cond ��������
//     * @throws KKHException �������ɃG���[�����������ꍇ
//     */
//    public Date findMasterUpdTimStmpMaxByCondition(MasterDataCondition cond) throws KKHException {
//
//        MasterDataDAO dataDao = MasterDataDAOFactory.createMasterDataDAO();
//        List<MasterDataVO> dataVOList = dataDao.findMasterUpdTimStmpMaxByCondition(cond);
//        MasterDataVO vo = dataVOList.get(0);
//        return vo.getUpdTimStmp();
//        //        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
////
////        if(vo != null){
////	        try {
////				Date day = format.parse(vo.getUpdTimStmp().toString());
////				return day;
////	        } catch (ParseException e) {
////				// TODO �����������ꂽ catch �u���b�N
////				e.printStackTrace();
////			}
////        }
//
//
//    }
//
//    /**
//     * �ėp�}�X�^(�f�[�^)�̍폜
//     *
//     * @param cond �폜����
//     * @throws KKHException �������ɃG���[�����������ꍇ
//     */
//    public void deleteMasterDataByCondition(MasterCondition cond) throws KKHException {
//
//        MasterRegisterDAO dao = MasterRegisterDAOFactory.createMasterRegisterDAO();
//        dao.deleteMasterDataByCondition(cond);
//    }

    /**
     * �ėp�}�X�^(�f�[�^)�̓o�^
     *
     * @param list �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void registerMaster(List<MasterMacDataInsertVO> list) throws KKHException {

        for (MasterMacDataInsertVO vo : list) {
            MasterMacRegisterDAO dao = MasterMacRegisterDAOFactory.createMasterRegisterDAO();
            dao.registMasterDataVO(vo);
        }
    }

    /**
     * �ėp�}�X�^(�f�[�^)�̍X�V�i���t�̈ꊇ�X�V�j
     *
     * @param cond �X�V����
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void updateMasterMacByConditon(MasterCondition cond) throws KKHException {
            MasterMacRegisterDAO dao = MasterMacRegisterDAOFactory.createMasterRegisterDAO();
            dao.updateMasterMacDataByCondition(cond);
    }

}
