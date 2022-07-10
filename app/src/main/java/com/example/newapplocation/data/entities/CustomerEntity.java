package com.example.newapplocation.data.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

@Entity
public class CustomerEntity {

    @Id
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("license")
    private String license;
    @SerializedName("properties")
    @Convert(converter = PropertiesConverter.class, columnType = String.class)
    private CustomerProperties properties;
    @SerializedName("priority")
    private int priority;
    private boolean isSelected;

    @Generated(hash = 34525568)
    public CustomerEntity(Long id, String name, String license, CustomerProperties properties,
                          int priority, boolean isSelected) {
        this.id = id;
        this.name = name;
        this.license = license;
        this.properties = properties;
        this.priority = priority;
        this.isSelected = isSelected;
    }

    @Generated(hash = 457785240)
    public CustomerEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return this.license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public CustomerProperties getProperties() {
        return this.properties;
    }

    public void setProperties(CustomerProperties properties) {
        this.properties = properties;
    }

    public boolean getIsSelected() {
        return this.isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public static class PropertiesConverter implements PropertyConverter<CustomerProperties, String> {

        Gson mGson = new GsonBuilder().create();

        @Override
        public CustomerProperties convertToEntityProperty(String databaseValue) {
            return mGson.fromJson(databaseValue, CustomerProperties.class);
        }

        @Override
        public String convertToDatabaseValue(CustomerProperties entityProperty) {
            return mGson.toJson(entityProperty);
        }
    }

    public static class CustomerProperties {

        @SerializedName("url")
        private String url;
        @SerializedName("items")
        private CustomerPropertiesItem mItems;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public CustomerPropertiesItem getItems() {
            return mItems;
        }

        public void setItems(CustomerPropertiesItem items) {
            mItems = items;
        }
    }

    public static class CustomerPropertiesItem {
        @SerializedName("modules")
        private List<Long> mModules;
        @SerializedName("menus")
        private List<Long> mMenus;

        public List<Long> getModules() {
            return mModules;
        }

        public void setModules(List<Long> modules) {
            mModules = modules;
        }

        public List<Long> getMenus() {
            return mMenus;
        }

        public void setMenus(List<Long> menus) {
            mMenus = menus;
        }
    }

}
