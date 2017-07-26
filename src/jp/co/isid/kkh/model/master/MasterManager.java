package jp.co.isid.kkh.model.master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �ėp�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class MasterManager {

    /** �V���O���g���C���X�^���X */
    private static MasterManager _manager = new MasterManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private MasterManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static MasterManager getInstance() {
        return _manager;
    }

    /**
     * �ėp�}�X�^(�f�[�^)���������܂��B
     *
     * @return MasterResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public MasterResult findByCondition(MasterCondition cond) throws KKHException {

        //�p�����[�^�̕K�{�`�F�b�N
        if (cond.getEsqId()== null || cond.getEsqId().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
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
        if (cond.getMasterKey() == null || cond.getMasterKey().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        //��������
        MasterResult result = new MasterResult();
        //��������(�}�X�^��ސݒ�E���ڐݒ�擾�p)
        MasterCondition lCond = new MasterCondition();
        //��������(�}�X�^�f�[�^�擾�p)
        MasterDataCondition lDataCond = new MasterDataCondition();

        MasterDAO dao = MasterDAOFactory.createMasterDAO();
        MasterDataDAO dataDao = MasterDataDAOFactory.createMasterDataDAO();

        //******************************************************
        //�}�X�^��ސݒ���擾
        //******************************************************
        lCond = cond;
        List<MasterVO> kindList = dao.findMasterKindByCondition(lCond);

        MasterVO masterKindVO = kindList.get(0);

        //�}�X�^���ڐݒ�E�}�X�^�f�[�^���������ݒ�
        lCond = cond;
        lDataCond.setEsqId(cond.getEsqId());
        lDataCond.setEgCd(cond.getEgCd());
        lDataCond.setTksKgyCd(cond.getTksKgyCd());
        lDataCond.setTksBmnSeqNo(cond.getTksBmnSeqNo());
        lDataCond.setTksTntSeqNo(cond.getTksTntSeqNo());
        lDataCond.setMasterKey(cond.getMasterKey());
        //lDataCond.setFilterKey(cond.getFilterKey());
        lDataCond.setFilterValue(cond.getFilterValue());
        lDataCond.setFilterKey(masterKindVO.getField5());



        List<MasterDataVO> dataList = new ArrayList<MasterDataVO>();
        for (int i = 0; i < kindList.size(); i++){
            //******************************************************
            //�}�X�^���ڐݒ���擾
            //******************************************************
            lCond.setMasterKey(kindList.get(i).getField3());
            List<MasterVO> itemList = new ArrayList<MasterVO>();
            itemList = dao.findMasterItemByCondition(lCond);

            //******************************************************
            //�}�X�^�f�[�^���擾
            //******************************************************
            //���������ݒ�
            lDataCond.setSybt(kindList.get(i).getField2());               //�}�X�^��ސݒ�̎�ʂ������ɐݒ�
            String[] sortKeys = kindList.get(i).getField4().split(",");
            List<String> sortKeyList = new ArrayList<String>();
            for(int j = 0; j < sortKeys.length; j++){
                sortKeyList.add(sortKeys[j]);
            }
            lDataCond.setSortKey(sortKeyList);                            //�}�X�^��ސݒ�̃\�[�g�J�����������ɐݒ�
            List<String> selectColList = new ArrayList<String>();
            for(int j = 0; j < itemList.size(); j++){
                selectColList.add(itemList.get(j).getField4());
            }
            lDataCond.setSelectColumns(selectColList);                    //�}�X�^���ڐݒ�̃J�������������ɐݒ�
            dataList.addAll(dataDao.findMasterDataByCondition(lDataCond));
        }

        result.setMasterData(dataList);

        return result;
    }


    /**
     * �ėp�}�X�^(��ށE����)���������܂��B
     *
     * @return MasterResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public MasterResult findMasterDefineByCondition(MasterCondition cond) throws KKHException {

        //�p�����[�^�̕K�{�`�F�b�N
        if (cond.getEsqId()== null || cond.getEsqId().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
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
        MasterResult result = new MasterResult();
        //��������(�}�X�^��ސݒ�E���ڐݒ�擾�p)
        MasterCondition lCond = new MasterCondition();

        MasterDAO dao = MasterDAOFactory.createMasterDAO();

        //******************************************************
        //�}�X�^��ސݒ���擾
        //******************************************************
        lCond = cond;
        List<MasterVO> kindList = dao.findMasterKindByCondition(lCond);
        result.setMasterKind(kindList);

        //******************************************************
        //�}�X�^���ڐݒ���擾
        //******************************************************
        lCond = cond;
        List<MasterVO> itemList = new ArrayList<MasterVO>();

        if(lCond.get_Itemfiltervalue() != null && !lCond.get_Itemfiltervalue().equals(""))
        {
            List<MasterVO> MerelyItemList = new ArrayList<MasterVO>();
            MerelyItemList = dao.findMasterItemByCondition(lCond);
            result.setMasterItem(MerelyItemList);
        }else
        {
            for (int i = 0; i < kindList.size(); i++){
                lCond.setMasterKey(kindList.get(i).getField3());            //�}�X�^��ސݒ�̃}�X�^�L�[�������Ƃ��Đݒ�
                List<MasterVO> tempItemList = new ArrayList<MasterVO>();
                tempItemList = dao.findMasterItemByCondition(lCond);
                itemList.addAll(tempItemList);
            }
            result.setMasterItem(itemList);
        }


        return result;
    }

    /**
     * �ėp�}�X�^�i�f�[�^�j�̍X�V�^�C���X�^���v�i�ő�l�j�̎擾
     *
     * @param cond ��������
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public Date findMasterUpdTimStmpMaxByCondition(MasterDataCondition cond) throws KKHException {

        MasterDataDAO dataDao = MasterDataDAOFactory.createMasterDataDAO();
        List<MasterDataVO> dataVOList = dataDao.findMasterUpdTimStmpMaxByCondition(cond);
        MasterDataVO vo = dataVOList.get(0);
        return vo.getUpdTimStmp();
        //        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//
//        if(vo != null){
//	        try {
//				Date day = format.parse(vo.getUpdTimStmp().toString());
//				return day;
//	        } catch (ParseException e) {
//				// TODO �����������ꂽ catch �u���b�N
//				e.printStackTrace();
//			}
//        }


    }

    /**
     * �ėp�}�X�^(�f�[�^)�̍폜
     *
     * @param cond �폜����
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void deleteMasterDataByCondition(MasterCondition cond) throws KKHException {

        MasterRegisterDAO dao = MasterRegisterDAOFactory.createMasterRegisterDAO();
        dao.deleteMasterDataByCondition(cond);
    }

    /**
     * �ėp�}�X�^(�f�[�^)�̓o�^
     *
     * @param list �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void registerMaster(List<MasterDataInsertVO> list) throws KKHException {

        for (MasterDataInsertVO vo : list) {
            MasterRegisterDAO dao = MasterRegisterDAOFactory.createMasterRegisterDAO();
            dao.registMasterDataVO(vo);
        }

    }


}
