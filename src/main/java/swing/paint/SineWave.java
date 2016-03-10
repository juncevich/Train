package swing.paint;

import swing.utils.SwingConsole;

import javax.swing.JFrame;
import javax.swing.JSlider;
import java.awt.BorderLayout;

/**
 * Класс настраивает программу
 * и создает регулятор.
 */
public final class SineWave extends JFrame {
    /**
     * Минимальное значение JSlider.
     */
    private static final int MIN = 1;
    /**
     * Максимальное значение JSlider.
     */
    private static final int MAX = 30;
    /**
     * Текущее значение JSlider.
     */
    private static final int VALUE = 5;
    /**
     * Ширина окна.
     */
    private static final int HEIGHT = 700;
    /**
     * Высота окна.
     */
    private static final int WIDTH = 400;
    /**
     * Волны.
     */
    private final SineDraw sines = new SineDraw();

    /**
     * Конструктор.
     */
    private SineWave() {
        add(sines);
        /**
         Слайдер.
         */
        final JSlider adjustCycles = new JSlider(MIN, MAX, VALUE);
        adjustCycles.addChangeListener(e -> sines.
                setCycles(((JSlider) e.getSource()).getValue()));
        add(BorderLayout.SOUTH, adjustCycles);
    }

    /**
     * Главный метод.
     *
     * @param args и аргументы.
     */
    public static void main(final String... args) {
        SwingConsole.run(new SineWave(), HEIGHT, WIDTH);
    }
}
