package interview.alibaba.lemon.util;

import interview.alibaba.lemon.condition.rule.OperationEnum;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2020/9/16
 */
public class OperationUtil {

    public static List<Object> chooseOperation(OperationEnum operationEnum,Object conditionValue,List<Object> list,String filedName,String type){

        List<Object> result = new ArrayList();
        switch (operationEnum){
            //=
            case EQ:
                list.forEach(obj ->{
                    try {
                        Object filedValue = ReflectUtil.getFiledValue(obj, filedName);
                        //两个都为null 则匹配上
                        if(null == conditionValue && null == filedValue){
                            result.add(obj);
                            return;
                        }
                        //两个都不为空 且 value值相等 则匹配上
                        if(null != conditionValue &&  null != filedValue){
                            String value1 = conditionValue.toString();
                            String  value2 = filedValue.toString();
                            if(value1.equals(value2)){
                                result.add(obj);
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
                break;
            // !=
            case NE:
                list.forEach(obj ->{
                    try {
                        Object filedValue = ReflectUtil.getFiledValue(obj, filedName);
                        if((null == conditionValue && null != filedName ) || (null != conditionValue && null == filedValue)){
                            result.add(obj);
                            return;
                        }
                        //两个都不为空 且 value值不相等 则匹配上
                        if(null != conditionValue &&  null != filedValue){
                            String value1 = conditionValue.toString();
                            String  value2 = filedValue.toString();
                            if(!value1.equals(value2)){
                                result.add(obj);
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
                break;
            //>=
            case GE:
                list.forEach(obj ->{
                    try {
                        Object filedValue = ReflectUtil.getFiledValue(obj, filedName);
                        //两个都为null   视为相等
                        if(conditionValue == null && filedValue == null){
                            result.add(obj);
                            return;
                        }

                        if(isNotAllNull(conditionValue,filedValue)){
                            return;
                        }
                        //值是string类型
                        if("class java.lang.String".equals(type)){
                            String val1 = conditionValue.toString();
                            String val2 = filedValue.toString();
                            if(val2.compareTo(val1) >= 0){
                                result.add(obj);
                                return;
                            }
                        }

                        //值是integer类型
                        if("class java.lang.Integer".equals(type)){
                            Integer val1 = (Integer)conditionValue;
                            Integer val2 =(Integer) filedValue;
                            if(val2 >= val1){
                                result.add(obj);
                                return;
                            }
                        }

                        //其他类型 double float  localdatatime  不一一列出


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                break;
            //>
            case GT:
                list.forEach(obj ->{
                    try {
                        Object filedValue = ReflectUtil.getFiledValue(obj, filedName);
                        //值是string类型
                        if("class java.lang.String".equals(type)){
                            String val1 = conditionValue.toString();
                            String val2 = filedValue.toString();
                            if(val2.compareTo(val1) > 0){
                                result.add(obj);
                                return;
                            }
                        }

                        //值是integer类型
                        if("class java.lang.Integer".equals(type)){
                            Integer val1 = (Integer)conditionValue;
                            Integer val2 =(Integer) filedValue;
                            if(val2 > val1){
                                result.add(obj);
                                return;
                            }
                        }

                        //其他类型 double float  localdatatime  不一一列出


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                break;
            //<=
            case LE:
                list.forEach(obj ->{
                    try {
                        Object filedValue = ReflectUtil.getFiledValue(obj, filedName);


                        if(isNotAllNull(conditionValue,filedValue)){
                            return;
                        }

                        //两个都为null   视为相等
                        if(conditionValue == null && filedValue == null){
                            result.add(obj);
                            return;
                        }

                        //值是string类型
                        if("class java.lang.String".equals(type)){
                            String val1 = conditionValue.toString();
                            String val2 = filedValue.toString();
                            if(val2.compareTo(val1) <= 0){
                                result.add(obj);
                                return;
                            }
                        }

                        //值是integer类型
                        if("class java.lang.Integer".equals(type)){
                            Integer val1 = (Integer)conditionValue;
                            Integer val2 =(Integer) filedValue;
                            if(val2 <= val1){
                                result.add(obj);
                                return;
                            }
                        }

                        //其他类型 double float  localdatatime  不一一列出


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });


                break;
            // <
            case LT:
                list.forEach(obj ->{
                    try {
                        Object filedValue = ReflectUtil.getFiledValue(obj, filedName);

                        //值是string类型
                        if("class java.lang.String".equals(type)){
                            String val1 = conditionValue.toString();
                            String val2 = filedValue.toString();
                            if(val2.compareTo(val1) < 0){
                                result.add(obj);
                                return;
                            }
                        }

                        //值是integer类型
                        if("class java.lang.Integer".equals(type)){
                            Integer val1 = (Integer)conditionValue;
                            Integer val2 =(Integer) filedValue;
                            if(val2 <  val1){
                                result.add(obj);
                                return;
                            }
                        }

                        //其他类型 double float  localdatatime  不一一列出


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });



                break;

            //like
            case LIKE:
                list.forEach(obj ->{
                    try {
                        Object filedValue = ReflectUtil.getFiledValue(obj, filedName);
                        //两个都为null 则匹配上
                        if(null == conditionValue && null == filedValue){
                            result.add(obj);
                            return;
                        }
                        //两个都不为空 且 value值相等 则匹配上
                        if(null != conditionValue &&  null != filedValue){
                            String value1 = conditionValue.toString();
                            String  value2 = filedValue.toString();
                            if(value2.contains(value1)){
                                result.add(obj);
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
                break;
             //not like
            case NOT_LIKE:
                list.forEach(obj ->{
                    try {
                        Object filedValue = ReflectUtil.getFiledValue(obj, filedName);
                        if((null == conditionValue && null != filedName ) || (null != conditionValue && null == filedValue)){
                            result.add(obj);
                            return;
                        }
                        //两个都不为空 且 value值不相等 则匹配上
                        if(null != conditionValue &&  null != filedValue){
                            String value1 = conditionValue.toString();
                            String  value2 = filedValue.toString();
                            if(!value2.contains(value1)){
                                result.add(obj);
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
                break;
            default:

        }
        return result;
    }

    private static boolean isNotAllNull(Object val1,Object val2){
        return (null == val1 && null != val2) || (null != val1 && null == val2);
    }

}
