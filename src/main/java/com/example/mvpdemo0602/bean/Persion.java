package com.example.mvpdemo0602.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/7/16.
 */

@Entity(nameInDb = "user_persion",generateConstructors = false,generateGettersSetters = true)
public class Persion {
    @Id(autoincrement = true)
    private Long p_id;
    private String name;
    private int age;
    private String num;
    @Keep
    public Persion(String name, int age, String num) {
        this.name = name;
        this.age = age;
        this.num = num;
    }

    @Keep
    public Persion() {
    }

    public Persion(Long p_id, String name, int age, String num) {
        this.p_id = p_id;
        this.name = name;
        this.age = age;
        this.num = num;
    }
    @Keep
    public Long getId() {
        return this.p_id;
    }
    @Keep
    public void setId(Long p_id) {
        this.p_id = p_id;
    }
    @Keep
    public String getName() {
        return this.name;
    }
    @Keep
    public void setName(String name) {
        this.name = name;
    }
    @Keep
    public int getAge() {
        return this.age;
    }
    @Keep
    public void setAge(int age) {
        this.age = age;
    }
    @Keep
    public String getNum() {
        return this.num;
    }
    @Keep
    public void setNum(String num) {
        this.num = num;
    }
    @Keep
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Keep
    @Override
    public boolean equals(Object obj) {
        if (this == obj ) return true;
        if (!(obj instanceof Persion))
            throw new ClassCastException("类型不一致");
        Persion p= (Persion) obj;
        return this.name.equals(p.getName());
    }

    @Override
    public String toString() {
        return "Persion{" +
                "id=" + p_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", num='" + num + '\'' +
                '}';
    }

    public Long getP_id() {
        return this.p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }
}
