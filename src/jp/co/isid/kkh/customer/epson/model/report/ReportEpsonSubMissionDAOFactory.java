package jp.co.isid.kkh.customer.epson.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ��o���[�i�G�v�\��)����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/5 JSE YS)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSubMissionDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private ReportEpsonSubMissionDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static ReportEpsonSubMissionDAO createReportEpsonSubMissionDAO() {
        return (ReportEpsonSubMissionDAO) DaoFactory.createDao(ReportEpsonSubMissionDAO.class);
    }
}
