package jp.co.isid.kkh.model.master;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class MasterCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** �}�X�^���(�C�ӁF�����Ώۂ̃}�X�^���w��) */
    private String _sybt;
    /** �}�X�^�L�[(�C�ӁF�}�X�^���ڐݒ�̌����ɂ̂ݎg�p) */
    private String _masterKey;
    /** �t�B���^�L�[ */
    private String  _filterKey;
    /** �t�B���^�[�o�����[ */
    private String _filterValue;
    /** �A�C�e���t�B���^�[�o�����[ */
    private String _Itemfiltervalue;

    /**
     * �}�X�^��ʂ��擾����
     * @return String �}�X�^���
     */
    public String getSybt() {
        return _sybt;
    }

    /**
     * �}�X�^��ʂ�ݒ肷��
     * @param sybt String �}�X�^���
     */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

    /**
     * �}�X�^�L�[���擾����
     * @return String �}�X�^�L�[
     */
    public String getMasterKey() {
        return _masterKey;
    }

    /**
     * �}�X�^�L�[��ݒ肷��
     * @param masterKey String �}�X�^�L�[
     */
    public void setMasterKey(String masterKey) {
        this._masterKey = masterKey;
    }

    /**
     * �t�B���^�L�[���擾����
     * @return String �t�B���^�L�[
     */
    public String getFilterKey() {
        return _filterKey;
    }

    /**
     * �t�B���^�L�[��ݒ肷��
     * @param filterKey String �t�B���^�L�[
     */
    public void setFilterKey(String filterKey) {
        this._filterKey = filterKey;
    }

    /**
     * �t�B���^�[�o�����[���擾����
     * @return String �t�B���^�[�o�����[
     */
    public String getFilterValue() {
        return _filterValue;
    }

    /**
     * �t�B���^�[�o�����[��ݒ肷��
     * @param filterValue String �t�B���^�[�o�����[
     */
    public void setFilterValue(String filterValue) {
        _filterValue = filterValue;
    }

    /**
     * �A�C�e���t�B���^�[�o�����[��ݒ肷��
     * @param val String �A�C�e���t�B���^�[�o�����[
     */
    public void set_Itemfiltervalue(String val) {
        _Itemfiltervalue = val;
    }

    /**
     * �A�C�e���t�B���^�[�o�����[���擾����
     * @return String �A�C�e���t�B���^�[�o�����[
     */
    public String get_Itemfiltervalue() {
        return _Itemfiltervalue;
    }

}
