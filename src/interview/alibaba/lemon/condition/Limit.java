package interview.alibaba.lemon.condition;

/**
 * 分页信息
 * @author luolin
 * @date 2020/9/16
 */
public class Limit {

    //起始index 默认从o开始
    private Integer start = 0;

    private Integer end ;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
