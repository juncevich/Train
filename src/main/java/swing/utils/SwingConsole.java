package swing.utils;


import javax.swing.*;

public class SwingConsole {
    public static void run(final JFrame f, final int width, final int heigth) {
        SwingUtilities.invokeLater(() -> {
            f.setTitle(f.getClass().getSimpleName());
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setSize(width, heigth);
            f.setVisible(true);
        });
    }
}
