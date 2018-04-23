import java.util.Date;

public class Item {

    String name;
    Category itemCategory;
    Date expartationDate;
    Storage storageMethod;
    Boolean openClosed;

    public String getName() {
        return name;
    }

    public Category getItemCategory() {
        return itemCategory;
    }

    public Date getExpartationDate() {
        return expartationDate;
    }

    public Storage getStorageMethod() {
        return storageMethod;
    }

    public Boolean getOpenClosed() {
        return openClosed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemCategory(Category itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setExpartationDate(Date expartationDate) {
        this.expartationDate = expartationDate;
    }

    public void setStorageMethod(Storage storageMethod) {
        this.storageMethod = storageMethod;
    }

    public void setOpenClosed(Boolean openClosed) {
        this.openClosed = openClosed;
    }
}
