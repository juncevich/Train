package swing.dialogs.filechooser;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static swing.utils.SwingConsole.run;

public class FileChooserTest extends JFrame {
    private final JTextField
            fileName = new JTextField();
    private final JTextField dir = new JTextField();

    private FileChooserTest() {
        JPanel p = new JPanel();
        JButton open = new JButton("Open");
        open.addActionListener(new OpenL());
        p.add(open);
        JButton save = new JButton("Save");
        save.addActionListener(new SaveL());
        p.add(save);
        add(p, BorderLayout.SOUTH);
        dir.setEditable(false);
        fileName.setEditable(false);
        p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(fileName);
        p.add(dir);
        add(p, BorderLayout.NORTH);
    }

    private class OpenL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser();
            int rVal = c.showOpenDialog(FileChooserTest.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                fileName.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                fileName.setText("You pressed cancel");
                dir.setText("");
            }
        }
    }
    private class SaveL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser();
            int rVal = c.showOpenDialog(FileChooserTest.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                fileName.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                fileName.setText("You pressed cancel");
                dir.setText("");
            }
        }
    }

    public static void main(String[] args) {
        run(new FileChooserTest(), 450, 250);
    }

}
