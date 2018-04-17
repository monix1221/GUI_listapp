public class Item {
    private String text;

    public Item (String item) {
        this.text = item;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
