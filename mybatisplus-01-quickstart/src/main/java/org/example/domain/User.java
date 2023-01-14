package org.example.domain;

import lombok.*;

//lombok快速开发实体类 使用注解添加setter getter toString方法 @Data包含@Setter @Getter @ToString 不包含构造方法
/*@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor*/
@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;

/*    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                '}';
    }*/
}
