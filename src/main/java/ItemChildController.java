public class ItemChildController {
    private ItemModel model;
    private ItemChildView childView;
    private ItemBaseController baseController;

    public ItemChildController(ItemModel model, ItemBaseController baseController) {
        this.model = model;
        this.childView = new ItemChildView(this);
        this.baseController = baseController;
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

    public void fillInitialData() {
        childView.showItems(model.getItems());
    }

    public void updateOtherOpenWindows() {
        baseController.updateChildWindowsOnNewItemAdded();
    }

    public void updateWindow() {
        childView.updateTextItemsOnWindow(model.getAllTextItems());
    }

}
