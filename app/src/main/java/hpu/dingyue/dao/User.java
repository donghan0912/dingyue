package hpu.dingyue.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by Administrator on 2016/9/29.
 */

@Entity(nameInDb = "user")// 配置表名（默认名称为：实体类名大写）
public class User {
    @Property(nameInDb = "name")// 生成表中的列表 别名（默认名称为：字段名大写）
    private String name;
    @Property(nameInDb = "age")
    private int age;
    @Property(nameInDb = "sex")
    private int sex;

    @Transient // 表示不在表中创建该列
    private Long id;

    @Generated(hash = 771165691)
    public User(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
