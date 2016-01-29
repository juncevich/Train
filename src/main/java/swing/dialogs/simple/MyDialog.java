package swing.dialogs.simple;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;

/**
 * Класс, содержит диалоговое окно.
 */
public class MyDialog extends JDialog {
    /**
     * Ширина окна.
     */
    private static final int WINDOW_WIDTH = 150;
    /**
     * Высота окна.
     */
    private static final int WINDOW_HEIGHT = 125;

    /**
     * Конструктор.
     * @param parent родительский оъект.
     */
    public MyDialog(final JFrame parent) {
        super(parent, "MyDialog", true);
        setLayout(new FlowLayout());
        add(new JLabel("Here is my dialog"));
        final JButton ok = new JButton("OK");
        ok.addActionListener(e -> dispose());
        add(ok);
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
    }
}
