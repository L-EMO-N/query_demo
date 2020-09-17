package interview.alibaba.lemon.condition;

import interview.alibaba.lemon.condition.rule.SortEnum;

/**
 * 排序单元
 * @author luolin
 * @date 2020/9/16
 */
public class OrderByUnit {

    // 排序的字段名
    private String name;

    //排序的方式  asc 升序（默认） desc 降序
    private SortEnum sortEnum = SortEnum.ASC;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortEnum getSortEnum() {
        return sortEnum;
    }

    public void setSortEnum(SortEnum sortEnum) {
        this.sortEnum = sortEnum;
    }
}
