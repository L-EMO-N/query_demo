package interview.alibaba.lemon.condition;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2020/9/16
 */
public class Where {

    private List<WhereUnit> whereList;

    public List<WhereUnit> getWhereList() {
        return whereList;
    }

    public void setWhereList(List<WhereUnit> whereList) {
        this.whereList = whereList;
    }
}
