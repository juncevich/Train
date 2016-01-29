package swing.dialogs.tictactoe;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static swing.utils.SwingConsole.run;

/**
 * Содержит реализацию игры.
 */
public final class TicTacToe extends JFrame {
    /**
     * Текстовое поле, содержит
     * количество строк.
     */
    private final JTextField
            rows = new JTextField("3");
    /**
     * Текстовое поле, содержит
     * количество столюцов.
     */
    private final JTextField
            cols = new JTextField("3");

    /**
     * Перечисление содержит
     * состояния
     * BLANK - пустое,
     * XX - крестик,
     * OO - нолик.
     */
    private enum State { BLANK, XX, OO }

    /**
     * Ширина окна.
     */
    private static final int WINDOW_WIDTH = 200;
    /**
     * Высота окна.
     */
    private static final int WINDOW_HEIGHT = 200;
    /**
     * Всплывающее окно, с
     * ячейками.
     */
    static class ToeDialog extends JDialog {
        /**
         * Стартовое состояние.
         */
        private State turn = State.XX;
        /**
         * Длина стороны ячейки.
         * Ячейка квадратная.
         */
        private static final int CELL_SIDE = 50;
        /**
         * Конструктор добавляет на форму
         * заданное количество,
         * после чего изменяет их размер так,
         * чтобы на каждую сторону кнопки
         * приходилось по 50 пикселов.
         *
         * @param cellsWide количество элементов
         *                  в ширину.
         * @param cellHigh количество элементов
         *                 в высоту.
         */
        ToeDialog(final int cellsWide, final int cellHigh) {
            setTitle("The game itself");
            setLayout(new GridLayout(cellsWide, cellHigh));
            for (int i = 0; i < cellsWide * cellHigh; i++) {
                add(new ToeButton());
            }
            setSize(cellsWide * CELL_SIDE, cellHigh * CELL_SIDE);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        /**
         * С помощью механизма
         * внутренних классов ToeButton
         * снова обращается к родительскому
         * окну и изменяет результат
         * соответствующего хода. Если
         * на кнопке уже отображается
         * "крестик" или "нолик" происходит
         * замена текущего состояния.
         */
        class ToeButton extends JPanel {
            /**
             * Стартовое состояние.
             */
            private State state = State.BLANK;

            /**
             * Добавляет слушателя к кнопке,
             * который следит за нажатием
             * кнопки мыши.
             */
            public ToeButton() {
                addMouseListener(new MouseListener());
            }

            /**
             * Метод рисует вокруг панели
             * прямоугольую рамку,
             * а так же "крустик" или "нолик".
             * @param graphics графический объект.
             */
            public void paintComponent(final Graphics graphics) {
                super.paintComponent(graphics);
                int
                        x1 = 0, y1 = 0,
                        x2 = getSize().width - 1,
                        y2 = getSize().height - 1;
                graphics.drawRect(x1, y1, x2, y2);
                x1 = x2 / 4;
                y1 = y2 / 4;
                final int wide = x2 / 2, high = y2 / 2;
                if (state == State.XX) {
                    graphics.drawLine(x1, y1, x1 + wide, y1 + high);
                    graphics.drawLine(x1, y1 + high, x1 + wide, y1);
                }

                if (state == State.OO) {
                    graphics.drawOval(x1, y1, x1 + wide / 2, y1 + high / 2);
                }

            }

            /**
             * В этом классе обрабатываются
             * щелчки кнопок. Класс проверяет,
             * нарисовано ли что-нибудь на
             * табличной кнопке. Если в ней ничего
             * нет, то выдается запрос к
             * родительскому окну и на основе
             * полученной информации
             * устанавливается состояние
             * кнопки ToeButton.
             */
            class MouseListener extends MouseAdapter {
                @Override
                public void mousePressed(final MouseEvent e) {
                    if (state == State.BLANK) {
                        state = turn;
                        turn = (turn == State.XX ? State.OO : State.XX);
                    } else {
                        state = (state == State.XX ? State.OO : State.XX);
                        repaint();
                    }
                }
            }
        }
    }

    /**
     * Класс реализует интерфейс
     * <Code>ActionListener</Code>.
     * Получает значения строк и столбцов.
     * Отображает окно с ячейками
     * и заданными параметрами.
     */
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent e) {
            final JDialog d = new ToeDialog(
                    Integer.valueOf(rows.getText()),
                    Integer.valueOf(cols.getText()));
            d.setVisible(true);
        }
    }

    /**
     * Конструктор создает окно с
     * двумя текстовыми полями и
     * кнопку, для открытия диалога.
     */
    private TicTacToe() {
        final JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("Rows", JLabel.CENTER));
        p.add(rows);
        p.add(new JLabel("Columns", JLabel.CENTER));
        p.add(cols);
        add(p, BorderLayout.NORTH);
        final JButton b = new JButton("go");
        b.addActionListener(new ButtonListener());
        add(b, BorderLayout.SOUTH);
    }

    /**
     * Main method.
     * @param args main arguments.
     */
    public static void main(final String... args) {
        run(new TicTacToe(), WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
