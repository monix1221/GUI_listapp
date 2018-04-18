import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemBaseView extends JFrame {

    private static final String WELCOME_TEXT_MAIN_WINDOW = "Hello in my GUI application!";
    private static final String OPEN_WINDOW_LABEL = "Open window";

    private final ItemBaseController baseController;
    private JPanel mainApplicationPanel;
    private JLabel mainHelloLabel = new JLabel(WELCOME_TEXT_MAIN_WINDOW);
    private JButton mainButton = new JButton(OPEN_WINDOW_LABEL);

    public ItemBaseView(ItemBaseController baseController) {
        this.baseController = baseController;
        this.mainApplicationPanel = new JPanel();
    }

    public void createMainWindow() {
        mainApplicationPanel.setLayout(new BoxLayout(mainApplicationPanel, BoxLayout.Y_AXIS));
        this.getContentPane().add(mainApplicationPanel);
        setLocationRelativeTo(null); //zeby nie otwieralo okna w lewym gornym rogu tylko posrodku

        mainApplicationPanel.add(mainHelloLabel);
        mainHelloLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        mainApplicationPanel.add(mainButton);
        mainButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        mainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainHelloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainHelloLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        setVisible(true);

        mainApplicationPanel.setPreferredSize(new Dimension(300, 200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseController.createChildWindow();
            }
        });
    }
}
