package interview.alibaba.lemon.condition;

import java.util.List;
/**
 *分组相关信息类
 * @author luolin
 * @date 2020/9/16
 */
public class GroupBy {

    //分组信息的字段集合
    private List<String> groupList;

    public List<String> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }
}
