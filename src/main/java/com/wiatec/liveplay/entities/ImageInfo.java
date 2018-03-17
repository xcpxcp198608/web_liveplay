package com.wiatec.liveplay.entities;

/**
 * mapping image table column
 */
public class ImageInfo {

    private int id;
    private String name;
    private String url;
    private String link;

    public ImageInfo() {
    }

    public ImageInfo(String name, String url, String link) {
        this.name = name;
        this.url = url;
        this.link = link;
    }

    public ImageInfo(int id, String name, String url, String link) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
