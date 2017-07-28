package jp.co.isid.kkh.customer.lion.model.master;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterDataInsertVO;

/**
 * <P>
 * �ėp�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 *
 * @author JSE K.Fukuda
 */
public class LionManager {

    /** �V���O���g���C���X�^���X */
    private static LionManager _manager = new LionManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private LionManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static LionManager getInstance() {
        return _manager;
    }


    /**
     * TV�ԑg�}�X�^(�f�[�^)�̍폜
     *
     * @param cond �폜����
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void deleteLionTvMastDataByCondition(LionCondition cond) throws KKHException {

        LionTvMastRegisterDAO dao = LionTvMastRegisterDAOFactory.createTvMastLionRegisterDAO();
        dao.deleteLionDataByCondition(cond);
    }

    /**
     * TV�ԑg�}�X�^(�f�[�^)�̓o�^
     *
     * @param list �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void registerLionTvMast(List<LionTvMastDataInsertVO> list) throws KKHException {

        for (LionTvMastDataInsertVO vo : list) {
            LionTvMastRegisterDAO dao = LionTvMastRegisterDAOFactory.createTvMastLionRegisterDAO();
            dao.registLionTvMastDataVO(vo);
        }
    }

    /**
     * ���W�I�ԑg�}�X�^(�f�[�^)�̍폜
     *
     * @param cond �폜����
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void deleteLionRdMastDataByCondition(LionCondition cond) throws KKHException {

        LionRdMastRegisterDAO dao = LionRdMastRegisterDAOFactory.createRdMastLionRegisterDAO();
        dao.deleteLionDataByCondition(cond);
    }

    /**
     * ���W�I�ԑg�}�X�^(�f�[�^)�̓o�^
     *
     * @param list �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void registerLionRdMast(List<LionRdMastDataInsertVO> list) throws KKHException {

        for (LionRdMastDataInsertVO vo : list) {
            LionRdMastRegisterDAO dao = LionRdMastRegisterDAOFactory.createRdMastLionRegisterDAO();
            dao.registLionRdMastDataVO(vo);
        }
    }

    /**
     * TV�ǃ}�X�^(�f�[�^)�̍폜
     *
     * @param cond �폜����
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void deleteLionTvKMastDataByCondition(LionCondition cond) throws KKHException {

        LionTvKMastRegisterDAO dao = LionTvKMastRegisterDAOFactory.createTvKMastLionRegisterDAO();
        dao.deleteLionDataByCondition(cond);
    }

    /**
     * TV�ǃ}�X�^(�f�[�^)�̓o�^
     *
     * @param list �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void registerLionTvKMast(List<LionTvKMastDataInsertVO> list) throws KKHException {

        for (LionTvKMastDataInsertVO vo : list) {
            LionTvKMastRegisterDAO dao = LionTvKMastRegisterDAOFactory.createTvKMastLionRegisterDAO();
            dao.registLionTvKMastDataVO(vo);
        }
    }

    /**
     * ���W�I�ǃ}�X�^(�f�[�^)�̍폜
     *
     * @param cond �폜����
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void deleteLionRdKMastDataByCondition(LionCondition cond) throws KKHException {

        LionRdKMastRegisterDAO dao = LionRdKMastRegisterDAOFactory.createRdKMastLionRegisterDAO();
        dao.deleteLionDataByCondition(cond);
    }

    /**
     * ���W�I�ǃ}�X�^(�f�[�^)�̓o�^
     *
     * @param list �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void registerLionRdKMast(List<LionRdKMastDataInsertVO> list) throws KKHException {

        for (LionRdKMastDataInsertVO vo : list) {
            LionRdKMastRegisterDAO dao = LionRdKMastRegisterDAOFactory.createRdKMastLionRegisterDAO();
            dao.registLionRdKMastDataVO(vo);
        }
    }

    /**
     * TV�ԑg�f�[�^���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public FindTvMastResult findTvMastByCondition(FindTvMastCondition cond) throws KKHException {
        //��������
        FindTvMastResult result = new FindTvMastResult();

        //******************************************************
        //TV�ԑg�f�[�^���擾
        //******************************************************
        FindTvMastDAO findTvMastDAO = FindTvMastDAOFactory.createFindTvMastDAO();

        List<FindTvMastVO> list = findTvMastDAO.findTvMastByCondition(cond);
        result.setFindTvMast(list);

        return result;
    }

    /**
     * ���W�I�ԑg�f�[�^���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public FindRdMastResult findRdMastByCondition(FindRdMastCondition cond) throws KKHException {
        //��������
        FindRdMastResult result = new FindRdMastResult();

        //******************************************************
        //���W�I�ԑg�f�[�^���擾
        //******************************************************
        FindRdMastDAO findRdMastDAO = FindRdMastDAOFactory.createFindRdMastDAO();

        List<FindRdMastVO> list = findRdMastDAO.findRdMastByCondition(cond);
        result.setFindRdMast(list);

        return result;
    }

    /**
     * TV�ǃf�[�^���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public FindTvKMastResult findTvKMastByCondition(FindTvKMastCondition cond) throws KKHException {
        //��������
        FindTvKMastResult result = new FindTvKMastResult();

        //******************************************************
        //TV�ǃf�[�^���擾
        //******************************************************
        FindTvKMastDAO findTvKMastDAO = FindTvKMastDAOFactory.createFindTvKMastDAO();

        List<FindTvKMastVO> list = findTvKMastDAO.findTvKMastByCondition(cond);
        result.setFindTvKMast(list);

        return result;
    }

    /**
     * ���W�I�ǃf�[�^���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public FindRdKMastResult findRdKMastByCondition(FindRdKMastCondition cond) throws KKHException {
        //��������
        FindRdKMastResult result = new FindRdKMastResult();

        //******************************************************
        //���W�I�ǃf�[�^���擾
        //******************************************************
        FindRdKMastDAO findRdKMastDAO = FindRdKMastDAOFactory.createFindRdKMastDAO();

        List<FindRdKMastVO> list = findRdKMastDAO.findRdKMastByCondition(cond);
        result.setFindRdKMast(list);

        return result;
    }

    /**
     * �G�������X�y�[�X�f�[�^���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public LionZashiRyoSpcMastResult lionZashiRyoSpcMastByCondition(LionZashiRyoSpcMastCondition cond) throws KKHException {
        //��������
        LionZashiRyoSpcMastResult result = new LionZashiRyoSpcMastResult();

        //******************************************************
        //�G�������X�y�[�X�f�[�^���擾
        //******************************************************
        LionZashiRyoSpcMastDAO lionZashiRyoSpcMastDAO = LionZashiRyoSpcMastDAOFactory.createLionZashiRyoSpcMastDAO();

        List<LionZashiRyoSpcMastVO> list = lionZashiRyoSpcMastDAO.lionZashiRyoSpcMastByCondition(cond);
        result.setLionZashiRyoSpcMast(list);

        return result;
    }

    /**
     * �G���X�y�[�X�����}�X�^(�f�[�^)�̓o�^
     *
     * @param list �}�X�^�f�[�^VO�iINSERT�p�j�̃��X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void insertLionZashiRyoSpcMast(List<MasterDataInsertVO> list) throws KKHException {

        for (MasterDataInsertVO vo : list) {
            UpdateLionZashiRyoSpcMastDAO dao = UpdateLionZashiRyoSpcMastDAOFactory.createUpdateLionZashiRyoSpcMastDAO();
            dao.insertLionZashiRyoSpcMastVO(vo);
        }
    }

    /**
     * �G�������X�y�[�X�f�[�^���폜���܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void deleteLionZashiRyoSpcMastByCondition(UpdateLionZashiRyoSpcMastCondition cond) throws KKHException {

        UpdateLionZashiRyoSpcMastDAO dao = UpdateLionZashiRyoSpcMastDAOFactory.createUpdateLionZashiRyoSpcMastDAO();

        dao.deleteLionZashiRyoSpcMastCondition(cond);
    }

}
