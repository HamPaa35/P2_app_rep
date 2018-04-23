public class Category {

    String name;
    int TypicalExperationOpen;
    int TypicalExperationClosed;
    Storage storageMethod;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypicalExperationOpen() {
        return TypicalExperationOpen;
    }

    public void setTypicalExperationOpen(int typicalExperationOpen) {
        TypicalExperationOpen = typicalExperationOpen;
    }

    public int getTypicalExperationClosed() {
        return TypicalExperationClosed;
    }

    public void setTypicalExperationClosed(int typicalExperationClosed) {
        TypicalExperationClosed = typicalExperationClosed;
    }

    public Storage getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(Storage storageMethod) {
        this.storageMethod = storageMethod;
    }

    void StorTest(){
        
    }
}
