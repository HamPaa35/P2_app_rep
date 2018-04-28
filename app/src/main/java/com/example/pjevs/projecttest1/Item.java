package com.example.pjevs.projecttest1;
//Can we delete this???
public class Item {
    private String itemname;
            private String categoryName;
            private String expirationDate;

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Item(String itemname, String categoryName, String expirationDate) {
        this.itemname = itemname;

        this.categoryName = categoryName;
        this.expirationDate = expirationDate;
    }
}
