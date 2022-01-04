package be.hvwebsites.libraryandroid4.helpers;

public class CheckboxHelper {
    private String name;
    private boolean checked;
    private String style;
    private IDNumber itemID;

    public CheckboxHelper(String name, boolean checked, String inStyle, IDNumber inID) {
        this.name = name;
        this.checked = checked;
        this.style = inStyle;
        this.itemID = inID;
    }

    public IDNumber getItemID() {
        return itemID;
    }

    public void setItemID(IDNumber itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
