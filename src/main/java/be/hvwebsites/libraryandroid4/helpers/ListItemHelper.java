package be.hvwebsites.libraryandroid4.helpers;

public class ListItemHelper {
    private String itemtext;
//    private String itemEntityType;
    private String itemStyle;
    private IDNumber itemID;

    public ListItemHelper(String itemtext, String inStyle, IDNumber inID) {
        this.itemtext = itemtext;
//        this.itemEntityType = inItemEntityType;
        this.itemStyle = inStyle;
        this.itemID = inID;
    }

    public IDNumber getItemID() {
        return itemID;
    }

    public void setItemID(IDNumber itemID) {
        this.itemID = itemID;
    }

    public String getItemtext() {
        return itemtext;
    }

    public void setItemtext(String itemtext) {
        this.itemtext = itemtext;
    }

    public String getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(String itemStyle) {
        this.itemStyle = itemStyle;
    }

}
