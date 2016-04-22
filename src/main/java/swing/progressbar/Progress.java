package swing.progressbar;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static swing.utils.SwingConsole.run;

public class Progress extends JFrame{
    private final ProgressMonitor pm = new ProgressMonitor(this, "Monitoring Progress", "Test", 0, 100);
    private final JSlider sb = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
    private Progress() {
        setLayout(new GridLayout(2, 1));
        JProgressBar pb = new JProgressBar();
        add(pb);
        pm.setProgress(0);
        pm.setMillisToPopup(1000);
        sb.setValue(0);
        sb.setPaintTicks(true);
        sb.setMajorTickSpacing(20);
        sb.setMinorTickSpacing(5);
        sb.setBorder(new TitledBorder("Slide me"));
        pb.setModel(sb.getModel());
        add(sb);
        sb.addChangeListener(e -> pm.setProgress(sb.getValue()));
    }

    public static void main(String[] args) {
        run(new Progress(), 300, 300);
    }
}
