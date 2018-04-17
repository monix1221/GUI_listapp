import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ItemChildView extends JFrame {

    private static final String WINDOW_TITLE = "Child Window";
    private static final String ADD_BUTTON_TITLE = "ADD";
    private static final String WARNING_MESSAGE = "You can't add empty item!";

    private final ItemChildController controller;
    private JTextArea itemArea;

    public ItemChildView(ItemChildController controller) {
        this.controller = controller;
        this.itemArea = new JTextArea();

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse has been clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse has been pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse has been mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse has been mouseEntered");
                controller.updateAllChildWindows();

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void createWindow() {
        setTitle(WINDOW_TITLE);
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
        setVisible(true);
        setPreferredSize(new Dimension(400, 300));

        itemArea.setEditable(false); //prevents user from writing
        itemArea.getAccessibleContext();

        JScrollPane scrollPane = new JScrollPane(itemArea);
        this.getContentPane().add(scrollPane);

        pack(); //bez tego okno pokazuje sie malutkie

        JPanel panel = new JPanel();
        final JTextField itemTextField = new JTextField(20); // accepts upto 10 characters
        JButton addItemButton = new JButton(ADD_BUTTON_TITLE);
        panel.add(itemTextField);
        panel.add(addItemButton);

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addNewItem(itemTextField.getText());
                itemTextField.setText("");
                controller.updateAllChildWindows();
            }
        });

        this.getContentPane().add(BorderLayout.SOUTH, panel);
    }

    public void appendNewItem(String text) {
        itemArea.append(text + "\n");
    }

    public void createWarningPopUp() {
        JPopupMenu popupMenu = new JPopupMenu();
        JOptionPane.showMessageDialog(popupMenu, WARNING_MESSAGE);
    }

    public void showItems(List<Item> allItems) {
        for(Item item: allItems) {
            itemArea.append(item.getText() + "\n");
        }
    }

    public void updateItemsOnWindows(StringBuilder allItems) {
        itemArea.setText(allItems.toString());
    }
}
