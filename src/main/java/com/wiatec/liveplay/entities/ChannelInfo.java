package com.wiatec.liveplay.entities;

/**
 * mapping the table of channel

 */
public class ChannelInfo {
    //primary key
    private int id;
    //channel id
    private int channelId;
    //sequence
    private int sequence;
    //query index
    private String tag;
    //channel name
    private String name;
    //stream url
    private String url;
    //channel icon
    private String icon;
    //channel type
    //the country of channel
    private String country;
    private int type;
    //the style of channel
    private int style;
    private boolean visible;
    private boolean locked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "ChannelInfo{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", sequence=" + sequence +
                ", tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", country='" + country + '\'' +
                ", type=" + type +
                ", style=" + style +
                ", visible=" + visible +
                ", locked=" + locked +
                '}';
    }
}
