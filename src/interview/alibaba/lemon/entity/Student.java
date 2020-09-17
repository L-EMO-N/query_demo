package interview.alibaba.lemon.entity;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2020/9/16
 */
public class Student {
    private Integer id;

    private String name;

    private String student_NO;


    private Integer class_NO;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent_NO() {
        return student_NO;
    }

    public void setStudent_NO(String student_NO) {
        this.student_NO = student_NO;
    }

    public Integer getClass_NO() {
        return class_NO;
    }

    public void setClass_NO(Integer class_NO) {
        this.class_NO = class_NO;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student_NO='" + student_NO + '\'' +
                ", class_NO=" + class_NO +
                '}';
    }
}
