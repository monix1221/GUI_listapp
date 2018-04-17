public class ItemBaseController {
    private ItemModel itemModel;
    private ItemBaseView itemMainView;

    public ItemBaseController() {
        this.itemModel = ItemModel.getItemModelInstance(this);
        this.itemMainView = new ItemBaseView(this);
    }

    public void startMainWindow() {
        itemMainView.createMainWindow();
    }

    public void createChildWindow() {
        ItemChildController childController = new ItemChildController(itemModel);
        childController.startWindow();
        childController.fillData();
    }
}
