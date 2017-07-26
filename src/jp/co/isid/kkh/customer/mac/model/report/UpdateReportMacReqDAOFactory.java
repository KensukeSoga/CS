package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �f�[�^�X�V(������)DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/18)<BR>
 * </P>
 * @author IP Shimizu
 */
final class UpdateReportMacReqDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private UpdateReportMacReqDAOFactory() {
    }

    /**
     * �X�V�E�폜DAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static UpdateReportMacReqDAO createMasterRegisterDAO() {
        return (UpdateReportMacReqDAO) DaoFactory.createDao(UpdateReportMacReqDAO.class);
    }
}
