package jp.co.isid.kkh.model.master;

import java.io.Serializable;
import java.util.List;

public class MasterDataCondition extends MasterCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> selectColumns;
    private List<String> sortKey;

    /**
     * @return selectColumns
     */
    public List<String> getSelectColumns() {
        return selectColumns;
    }
    /**
     * @param selectColumns セットする selectColumns
     */
    public void setSelectColumns(List<String> selectColumns) {
        this.selectColumns = selectColumns;
    }
    /**
     * @return sortKey
     */
    public List<String> getSortKey() {
        return sortKey;
    }
    /**
     * @param sortKey セットする sortKey
     */
    public void setSortKey(List<String> sortKey) {
        this.sortKey = sortKey;
    }
}
