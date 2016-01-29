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

    private static final int WINDOW_WIDTH = 200;
    private static final int WINDOW_HEIGTH = 200;
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

        class ToeButton extends JPanel {
            private State state = State.BLANK;

            public ToeButton() {
                addMouseListener(new ML());
            }

            /**
             * Метод рисует вокруг панели
             * прямоугольую рамку,
             * а так же "крустик" или "нолик".
             * @param g графический объект.
             */
            public void paintComponent(final Graphics g) {
                super.paintComponent(g);
                int
                        x1 = 0, y1 = 0,
                        x2 = getSize().width - 1,
                        y2 = getSize().height - 1;
                g.drawRect(x1, y1, x2, y2);
                x1 = x2 / 4;
                y1 = y2 / 4;
                int wide = x2 / 2, high = y2 / 2;
                if (state == State.XX) {
                    g.drawLine(x1, y1, x1 + wide, y1 + high);
                    g.drawLine(x1, y1 + high, x1 + wide, y1);
                }

                if (state == State.OO) {
                    g.drawOval(x1, y1, x1 + wide / 2, y1 + high / 2);
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
            class ML extends MouseAdapter {
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

    private class BL implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent e) {
            JDialog d = new ToeDialog(
                    new Integer(rows.getText()),
                    new Integer(cols.getText()));
            d.setVisible(true);
        }
    }
    private TicTacToe() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("Rows", JLabel.CENTER));
        p.add(rows);
        p.add(new JLabel("Columns", JLabel.CENTER));
        p.add(cols);
        add(p, BorderLayout.NORTH);
        JButton b = new JButton("go");
        b.addActionListener(new BL());
        add(b, BorderLayout.SOUTH);
    }
    public static void main(final String[] args) {
        run(new TicTacToe(), WINDOW_WIDTH, WINDOW_HEIGTH);
    }
}
