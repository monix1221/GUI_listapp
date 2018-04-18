import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ItemChildView extends JFrame {

    private static final String WINDOW_TITLE = "Child Window";
    private static final String ADD_BUTTON_TITLE = "ADD";
    private static final String WARNING_MESSAGE = "You can't add empty item!";

    private final ItemChildController controller;
    private JTextArea textArea;

    public ItemChildView(ItemChildController controller) {
        this.controller = controller;
        this.textArea = new JTextArea();
    }

    public void createWindow() {
        setTitle(WINDOW_TITLE);
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
        setVisible(true);
        setPreferredSize(new Dimension(400, 300));

        textArea.setEditable(false); //prevents user from writing
        textArea.getAccessibleContext();

        JScrollPane scrollPane = new JScrollPane(textArea);
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
                controller.updateOtherOpenWindows();
            }
        });

        this.getContentPane().add(BorderLayout.SOUTH, panel);
    }

    public void createWarningPopUp() {
        JPopupMenu popupMenu = new JPopupMenu();
        JOptionPane.showMessageDialog(popupMenu, WARNING_MESSAGE);
    }

    public void showItems(List<Item> allItems) {
        for (Item item : allItems) {
            textArea.append(item.getText() + "\n");
        }
    }

    public void updateTextItemsOnWindow(StringBuilder allItems) {
        textArea.setText(allItems.toString());
    }
}
