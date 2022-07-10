package com.example.newapplocation.domain.entities;

import android.view.Menu;

import java.util.List;

public class Module {
    private Long id;
    private String name;
    private String title;
    private String icon;
    private List<Menu> menus;

    public Module(Long id, String name, String title, String icon, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.icon = icon;
        this.menus = menus;
    }

    public Long getId() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
