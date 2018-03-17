package com.wiatec.liveplay.entities;

/**
 * mapping the table of 'updater'
 */
public class UpgradeInfo {
    private int id;
    private String packageName;
    private String url;
    private String version;
    private int code;
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "UpgradeInfo{" +
                "id=" + id +
                ", packageName='" + packageName + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", code=" + code +
                ", info='" + info + '\'' +
                '}';
    }
}
