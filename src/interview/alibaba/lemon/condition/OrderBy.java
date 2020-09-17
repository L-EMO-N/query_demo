package interview.alibaba.lemon.condition;

import java.util.List;

/**
 *排序单元集类
 * @author luolin
 * @date 2020/9/16
 */
public class OrderBy {

    //排序单元集合
    private List<OrderByUnit>  orderList;

    public List<OrderByUnit> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderByUnit> orderList) {
        this.orderList = orderList;
    }
}
