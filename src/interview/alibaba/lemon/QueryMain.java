package interview.alibaba.lemon;

import interview.alibaba.lemon.condition.GroupBy;
import interview.alibaba.lemon.condition.Limit;
import interview.alibaba.lemon.condition.OrderBy;
import interview.alibaba.lemon.condition.Where;
import interview.alibaba.lemon.condition.WhereUnit;
import interview.alibaba.lemon.util.OperationUtil;
import interview.alibaba.lemon.util.ReflectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author luolin
 * @date 2020/9/17
 */
public class QueryMain {

    List<Object> query(List<Object> data, Where where, OrderBy orderBy, GroupBy groupBy, Limit limit) {
        List<Object> result = new ArrayList();
        if(isEmpty(data)){
            return result;
        }
        result = whereFilter(data, where);
        return result;
    }

    /**
     * where 条件的过滤
     * @param data
     * @param where
     */
    private List<Object> whereFilter(List<Object> data, Where where) {
        List<WhereUnit> whereList = where.getWhereList();
       if(isEmpty(whereList)){
           return data;
       }

        //获取object实体类的成员属性
        Map<String, Object> map = ReflectUtil.getFieldNameAndType(data.get(0));

        for(WhereUnit  unit : whereList){
            String name = unit.getName();
            if(map.get(name) != null){
              data =   OperationUtil.chooseOperation(unit.getOperationEnum(),unit.getValue(),data,name,map.get(name).toString());
            }
        }
        return data;
    }


    /**
     * 分组
     * @param data
     * @param groupBy
     * @return
     */
    private List<Object> groupBy(List<Object> data,GroupBy groupBy){
        if(null == data){
            return null;
        }

        List<Object> result = new ArrayList<>();
        if(null != groupBy && null != groupBy.getGroupList() && groupBy.getGroupList().size() > 0){
            Map<String, Object> map = ReflectUtil.getFieldNameAndType(data.get(0));
            List<String> groupList = groupBy.getGroupList();
            Map<String,String> validMap = new HashMap<>();
            //过滤出有效的分组字段
            for(String group : groupList){
                if(null != map.get(group)){
                    validMap.put(group,group);
                }
            }

            Map<String,List<Object>>  groupMap = new HashMap<>();
            //分组
            if(validMap.size() > 0){
                for(Object obj : data){
                    StringBuilder  sb = new StringBuilder();
                    Set<String> keys = validMap.keySet();
                    for(String key : keys ){
                        try {
                            Object filedValue = ReflectUtil.getFiledValue(obj, key);
                            sb.append(filedValue+"").append("_");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if(groupMap.get(sb.toString()) != null){
                        groupMap.get(sb.toString()).add(obj);
                    }else{
                        List<Object> list = new ArrayList<>();
                        list.add(obj);
                        groupMap.put(sb.toString(),list);
                    }

                }
                Collection<List<Object>> values = groupMap.values();
                for(List<Object> obj : values){
                    result.addAll(obj);
                }
                return  result;
            }else{
                return  data;
            }
        }else{
            return  data;
        }
//        return null;
    }


    /**
     * 分页
     * @param limit
     * @param data
     * @return
     */
    private List<Object> limit(Limit limit,List<Object> data){
        List<Object> result = new ArrayList<>();
        if(null == data){
           return  result;
        }
        if(null == limit ){
            return  data;
        }
        Integer start = limit.getStart();
        Integer end = limit.getEnd();
        if(null == end){
            if(null == start || start <= 0){
                return  data;
            }
            if(start > data.size()){
                return  result;
            }

            List<Object> list = data.subList(start, data.size());
            return list;
        }else{
            start = start == null || start < 0 ?0:start;
            end = end > data.size() ? data.size():end < 0?0:end;
            List<Object> list = data.subList(start, end);
            return  list;
        }
    }


    private boolean isEmpty(List<?> list){
        return null == list || list.size() == 0;
    }




}
