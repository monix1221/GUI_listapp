import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemModel {
    private static ItemModel instance;
    private final ItemBaseController controller;
    private List<Item> items;

    private ItemModel(ItemBaseController controller) {
        this.controller = controller;
        this.items = new ArrayList<Item>();
    }

    public static ItemModel getItemModelInstance(ItemBaseController controller) {
        if (instance == null) {
            instance = new ItemModel(controller);
        }
        return instance;
    }

    public List<Item> getAllItems() {
        return items;
    }

    public StringBuilder getReadyItems() {
        StringBuilder builder = new StringBuilder();
        for (Item item: items) {
            builder.append(item + "\n");
        }
        return builder;
    }

    public void addItem(String text) throws EmptyItemException {
        if (Objects.equals(text, "")) {
            throw new EmptyItemException();
        }
        items.add(new Item(text));
    }
}
