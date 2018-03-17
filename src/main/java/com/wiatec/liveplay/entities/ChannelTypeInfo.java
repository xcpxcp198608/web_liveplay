package com.wiatec.liveplay.entities;

/**
 * mapping the table channel_type
 */
public class ChannelTypeInfo {

    //primary key
    private int id ;
    private String tag;
    //type name
    private String name;
    //type icon
    private String icon;
    //the flag about channel , 0 - normal channel ; 1 - favorite
    private short flag;
    //can see that the channel under this type(0 - false , 1 - true)
    private short type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public short getFlag() {
        return flag;
    }

    public void setFlag(short flag) {
        this.flag = flag;
    }

    public short getType() {
        return type;
    }

    public void setType(short isLock) {
        this.type = isLock;
    }

    @Override
    public String toString() {
        return "ChannelTypeInfo{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", flag=" + flag +
                ", type=" + type +
                '}';
    }
}
