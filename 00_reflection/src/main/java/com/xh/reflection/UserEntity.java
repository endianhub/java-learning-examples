package com.xh.reflection;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/16
 */
public class UserEntity {

    private Integer id;
    private String name;

    public UserEntity() {
    }

    public UserEntity(String name) {
        this.name = name;
    }

    public UserEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void add() {
        System.out.println(">>>> add user <<<<");
    }

    public String addName(String name) {
        System.out.println(">>>> public addName user:" + name + " <<<<");
        return "我的名字是：" + name;
    }

    private String addName2(String name) {
        System.out.println(">>>> private addName2 user:" + name + " <<<<");
        return "我的名字是：" + name;
    }

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
}
