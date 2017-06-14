package com.cmfz.entity;

import org.w3c.dom.stylesheets.LinkStyle;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 梵辰 on 2017/6/12.
 */
public class Menu implements Serializable {

    private String id;
    private String name;
    private String iconCls;
    private String href;
    private String lev;

    private List<Menu> children;

    public Menu() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", lev='" + lev + '\'' +
                ", children=" + children +
                '}';
    }
}
