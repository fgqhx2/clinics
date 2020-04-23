package cn.ali.auth.pojo;

import java.io.Serializable;

public class Permission implements Serializable {

    private Integer id;
    private String name;//资源标识（或者叫权限字符串）
    private String describe;//资源类型（1：菜单，2：按钮，3：操作）
    private String url;//资源url
    private Integer parent_id;//父ID

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }
}
