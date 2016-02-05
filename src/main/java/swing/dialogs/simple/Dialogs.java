package swing.dialogs.simple;


import javax.swing.JButton;
import javax.swing.JFrame;

import static swing.utils.SwingConsole.run;

/**
 * Класс, который создает окно
 * с кнопкой, для вызова диалога.
 */
public class Dialogs extends JFrame {
    /**
     * Ширина окна.
     */
    private static final  int WINDOW_WIDTH = 125;
    /**
     * Высота окна.
     */
    private static final int WINDOW_HEIGHT = 75;
    /**
     * Окно диалога.
     */
    private final MyDialog dlg = new MyDialog(null);

    /**
     * Конструктор по умолчанию.
     */
    private Dialogs() {
        /*
      Кнопка вызова диалога.
     */
        JButton b1 = new JButton("Dialog box");
        b1.addActionListener(e -> dlg.setVisible(true));
        add(b1);

    }

    /**
     * Main method.
     * @param args main args.
     */
    public static void main(final String... args) {
        run(new Dialogs(), WINDOW_HEIGHT, WINDOW_WIDTH);
    }
}
