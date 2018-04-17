public class ItemChildController {

    private ItemModel model;
    private ItemChildView childView;

    public ItemChildController(ItemModel model) {
        this.model = model;
        this.childView = new ItemChildView(this);
    }

    public void startWindow() {
        childView.createWindow();
    }

    public void addNewItem(String text) {
        try {
            model.addItem(text);
        } catch (EmptyItemException e) {
            e.printStackTrace();
            childView.createWarningPopUp();
        }
    }

    public void fillData() {
        childView.showItems(model.getAllItems());
    }

    public void updateAllChildWindows() {
        childView.updateItemsOnWindows(model.getReadyItems());
    }

}
