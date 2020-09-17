package interview.alibaba.lemon.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射工具类
 * @author luolin
 * @date 2020/9/17
 */
public class ReflectUtil {


    /**
     * 获取类属性的名称
     * @param object
     * @return
     */
    public static Map<String, Object> getFieldNameAndType(Object object) {
        Map<String, Object> map = new HashMap<>();
        if (null == object) {
            return map;
        }
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            map.put(field.getName(), field.getGenericType());
        }
        return map;
    }


    /**
     * 获取object对象的 getFiedName的值
     * 这里只考虑 getXXX
     * boolean类型 isXXX的方法 不在考虑范围
     * @param object
     * @param FiledName
     * @return
     */
    public static Object getFiledValue(Object object,String FiledName) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        if(null == object || null == FiledName || "".equals(FiledName.trim())){
            return  null;
        }
        String getterMethod = "get"+FiledName.substring(0,1).toUpperCase()+FiledName.substring(1);
        Method method = object.getClass().getMethod(getterMethod, new Class[]{});
        Object value = method.invoke(object, new Object[]{});
        return value;
    }

}
