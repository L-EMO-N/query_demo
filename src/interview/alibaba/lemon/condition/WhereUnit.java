package interview.alibaba.lemon.condition;

import interview.alibaba.lemon.condition.rule.JointEnum;
import interview.alibaba.lemon.condition.rule.OperationEnum;

/**
 * 条件单元
 * @author luolin
 * @date 2020/9/16
 */
public class WhereUnit {

    //属性名称
    private String name;

    //属性值
    private Object value;

    //连接符
    private JointEnum jointEnum;

    //操作符
    private OperationEnum operationEnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public JointEnum getJointEnum() {
        return jointEnum;
    }

    public void setJointEnum(JointEnum jointEnum) {
        this.jointEnum = jointEnum;
    }

    public OperationEnum getOperationEnum() {
        return operationEnum;
    }

    public void setOperationEnum(OperationEnum operationEnum) {
        this.operationEnum = operationEnum;
    }
}
