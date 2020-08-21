package businessObject;

public class Item {
    private String category;
    private String size;

    public Item setCategory(String category) {
        this.category = category;
        return this;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public String getSize() {
        return size;
    }
}
