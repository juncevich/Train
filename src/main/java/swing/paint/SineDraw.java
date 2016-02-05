package swing.paint;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Класс содержит процесс рисования
 * и связанные с ним вычисления.
 */
class SineDraw extends JPanel {
    /**
     *
     */
    private static final int SCALEFACTOR = 200;
    /**
     * Количество отображаемых точек.
     */
    private int points;
    /**
     * Текущее значение синуса.
     */
    private double[] sines;

    /**
     * Конструктор класса.
     */
    public SineDraw() {
        setCycles(5);
    }

    /**
     * Рисует синусоиду на экране.
     * @param graphics Painted component.
     */
    public final void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        final int maxWidth = getWidth();
        final double hstep = (double) maxWidth / (double) points;
        final int maxHeigth = getHeight();
        /*
      Координаты точек по оси У.
     */
        int[] pts = new int[points];
        for (int i = 0; i < points; i++) {
            pts[i] = (int) (sines[i] * maxHeigth / 2 * .95 + maxHeigth / 2);


        }
        graphics.setColor(Color.RED);
        for (int i = 1; i < points; i++) {
            final int x1 = (int) ((i - 1) * hstep);
            final int x2 = (int) (i * hstep);
            final int y1 = pts[i - 1];
            final int y2 = pts[i];
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * Метод, который позволяет другому
     * объекту(в данном случае регулятору)
     * управлять отображаемой синусоидой.
     * Создает массив, соответствующий
     * количеству необходимых точек,
     * и зполняет массив sines числовыми
     * значениями.
     * @param newCycles количество волн на экране.
     */
    public final void setCycles(final int newCycles) {
        /*
      Количество волн на экране.
     */
        points = SCALEFACTOR * newCycles * 2;
        sines = new double[points];
        for (int i = 0; i < points; i++) {
            final double radians = (Math.PI / SCALEFACTOR) * i;
            sines[i] = Math.sin(radians);
        }
        repaint();
    }
}