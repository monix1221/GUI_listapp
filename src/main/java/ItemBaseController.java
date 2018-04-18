import java.util.ArrayList;
import java.util.List;

public class ItemBaseController {
    private ItemModel model;
    private ItemBaseView baseView;
    private List<ItemChildController> createdChildControllers;

    public ItemBaseController() {
        this.model = ItemModel.getItemModelInstance(this);
        this.baseView = new ItemBaseView(this);
        this.createdChildControllers = new ArrayList<>();
    }

    public void startMainWindow() {
        this.baseView.createMainWindow();
    }

    public void createChildWindow() {
        ItemChildController childController = new ItemChildController(model, this);
        this.createdChildControllers.add(childController);
        childController.startWindow();
        childController.fillInitialData();
    }

    public void updateChildWindowsOnNewItemAdded() {
        for (ItemChildController controller : createdChildControllers) {
            controller.updateWindow();
        }
    }

}
