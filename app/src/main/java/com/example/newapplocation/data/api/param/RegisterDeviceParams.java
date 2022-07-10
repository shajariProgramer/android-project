package com.example.newapplocation.data.api.param;

import com.google.gson.annotations.SerializedName;

public class RegisterDeviceParams {

    @SerializedName("board")
    private String board;
    @SerializedName("bootloader")
    private String bootLoader;
    @SerializedName("brand")
    private String brand;
    @SerializedName("device")
    private String device;
    @SerializedName("display")
    private String display;
    @SerializedName("hardware")
    private String hardware;
    @SerializedName("host")
    private String host;
    @SerializedName("manufacturer")
    private String manufacturer;
    @SerializedName("model")
    private String model;
    @SerializedName("product")
    private String product;
    @SerializedName("serial")
    private String serial;
    @SerializedName("type")
    private String type;
    @SerializedName("license")
    private String license;
    @SerializedName("productUuid")
    private String productUuid;
    @SerializedName("sdk")
    private int sdk;
    @SerializedName("appVersion")
    private String appVersion;
    @SerializedName("devicePushNotificationId")
    private String devicePushNotificationId;

    public RegisterDeviceParams(String manufacturer, String model, String serial, int sdk, String appVersion,
                                String devicePushNotificationId) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.serial = serial;
        this.sdk = sdk;
        this.appVersion = appVersion;
        this.devicePushNotificationId = devicePushNotificationId;
    }

    public RegisterDeviceParams(String board, String bootLoader, String brand, String device,
                                String display, String hardware, String host, String manufacturer,
                                String model, String product, String serial, String type, int sdk,
                                String license, String productUuid, String appVersion) {
        this.board = board;
        this.bootLoader = bootLoader;
        this.brand = brand;
        this.device = device;
        this.display = display;
        this.hardware = hardware;
        this.host = host;
        this.sdk = sdk;
        this.manufacturer = manufacturer;
        this.model = model;
        this.product = product;
        this.serial = serial;
        this.type = type;
        this.license = license;
        this.productUuid = productUuid;
        this.appVersion = appVersion;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getBootLoader() {
        return bootLoader;
    }

    public void setBootLoader(String bootLoader) {
        this.bootLoader = bootLoader;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public int getSdk() {
        return sdk;
    }

    public void setSdk(int sdk) {
        this.sdk = sdk;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDevicePushNotificationId() {
        return devicePushNotificationId;
    }
}
