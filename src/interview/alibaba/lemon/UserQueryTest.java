package interview.alibaba.lemon;

import interview.alibaba.lemon.condition.Where;
import interview.alibaba.lemon.condition.WhereUnit;
import interview.alibaba.lemon.condition.rule.OperationEnum;
import interview.alibaba.lemon.entity.Student;
import interview.alibaba.lemon.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * 学生查询测试类
 * @author luolin
 * @date 2020/9/16
 */
public class UserQueryTest {
    /*public static void main(String[] args) {
        List<Object> list = new ArrayList();
        list.add(new Student());
        list.add(new User());
        list.forEach(obj->{
            Class<?> aClass = obj.getClass();
            System.out.println(aClass);
            Field[] declaredFields = aClass.getDeclaredFields();
            for(Field field : declaredFields){
                System.out.println(field.getName());
            }
        });
    }
*/

 private String[] names = {"张三","李四","王五","赵六","吴七"};


 private List<Object> list;


    /**
     * 初始化list  模拟表中数据 为user表
     * 默认
     *
     */
 private  void initUsers(){
     list = new ArrayList();
     int length = names.length;
     for(int i = 0; i< 100; i++){
         User user = new User();
         user.setId(i);
         user.setUsername(names[i%length]);
         user.setAge(i);
         user.setSex(i%2);
         list.add(user);
     }
 }

    /**
     * 模拟表中数据为student
     */
 private void initStudents(){
     list = new ArrayList<>();
     int length = names.length;
     for(int i = 0;i < 100; i++){
         Student student = new Student();
         student.setId(i);
         student.setName(names[i%length]);
         student.setClass_NO((i%6)+1);
         student.setStudent_NO("xxxx_"+i);
         list.add(student);
     }
 }

@Before
 public void initData(){
      initUsers();
 }

    /**
     * 查询姓名为张三的user
     *
     */
    @Test
 public void  queryByEq(){
        //查询姓名为张三的user
     Where where = new Where();
     List<WhereUnit> whereList = new ArrayList<>();
     WhereUnit unit = new WhereUnit();
     unit.setName("username");
     unit.setValue("张三");
     unit.setOperationEnum(OperationEnum.EQ);
     whereList.add(unit);
     where.setWhereList(whereList);
     List<Object> result = new QueryMain().query(list, where, null, null, null);
    System.out.println("resultCount:"+result.size());
     System.out.println(result);

 }



    /**
     * 查询姓名为张三的user 且 年龄大于50的
     *
     */
    @Test
    public void  queryByNameAndAge(){
        //查询姓名为张三的user
        Where where = new Where();
        List<WhereUnit> whereList = new ArrayList<>();
        WhereUnit unit = new WhereUnit();
        unit.setName("username");
        unit.setValue("张三");
        unit.setOperationEnum(OperationEnum.EQ);
        whereList.add(unit);

        WhereUnit ageUnit = new WhereUnit();
        ageUnit.setName("age");
        ageUnit.setValue(50);
        ageUnit.setOperationEnum(OperationEnum.GT);
        whereList.add(ageUnit);
        where.setWhereList(whereList);
        List<Object> result = new QueryMain().query(list, where, null, null, null);
        System.out.println("resultCount:"+result.size());
        System.out.println(result);

    }

    /**
     * 查询姓名不为张三的user
     */
    @Test
    public void  queryByNe(){
        //查询姓名为不为张三的user
        Where where = new Where();
        List<WhereUnit> whereList = new ArrayList<>();
        WhereUnit unit = new WhereUnit();
        unit.setName("username");
        unit.setValue("张三");
        unit.setOperationEnum(OperationEnum.NE);
        whereList.add(unit);
        where.setWhereList(whereList);
        List<Object> result = new QueryMain().query(list, where, null, null, null);
        System.out.println("resultCount:"+result.size());
        System.out.println(result);

    }








}
