package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �f�[�^�X�V(�w���`�[)DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/17 IP Shimizu)<BR>
 * </P>
 * @author IP Shimizu
 */
final class UpdateReportMacPurDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private UpdateReportMacPurDAOFactory() {
    }

    /**
     * �X�V�E�폜DAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static UpdateReportMacPurDAO createMasterRegisterDAO() {
        return (UpdateReportMacPurDAO) DaoFactory.createDao(UpdateReportMacPurDAO.class);
    }
}
