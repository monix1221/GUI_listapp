public class Item {
    private String text;

    public Item(String item) {
        this.text = item;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
