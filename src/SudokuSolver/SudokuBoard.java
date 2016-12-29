package SudokuSolver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by donamphuong on 18/03/2016.
 */
public class SudokuBoard extends JFrame {
    private final int SUDOKU_LENGTH = 9;

    private Square[][] board;
    //private boolean firstComputation = true;
    private LinkedList<Square> oneValue = new LinkedList<>();
    private LinkedList<Square> noValue = new LinkedList<>();

    //the order of squares added
    private LinkedList<Square> lastSquares = new LinkedList<>();

    public SudokuBoard() {
        board = new Square[SUDOKU_LENGTH][SUDOKU_LENGTH];

        for(int row = 0; row < SUDOKU_LENGTH; row++) {
            for(int col = 0; col < SUDOKU_LENGTH; col++) {
                board[row][col] = new Square(0, Square.findPosition(row, col), this);
                noValue.add(board[row][col]);
            }
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /*
    Set the square at row and column to the value specified by the parameter value
     */
    public void setSquare(int row, int col, int value) {
        Pair<Integer, Integer> pos = new Pair<Integer, Integer>(row, col);
        Square s = getSquare(pos);
        s.update(value);
    }

    public void removeFromNoValue(Square s) {
        noValue.remove(s);
    }

    public void display() {
        this.setBounds(200, 200, 500, 565);
        this.setLayout(null);

        int rowIncrease = 10, colIncrease = 10;
        for(int i = 0; i < SUDOKU_LENGTH; i ++) {
            for(int j = 0; j < SUDOKU_LENGTH; j++) {
                JSpinner box = board[i][j];
                box.setBounds(rowIncrease, colIncrease, 50, 50);
                this.add(box);

                if((j+1) % 3 == 0) {
                    rowIncrease += 10;
                }
                rowIncrease += 50;
            }

            if((i+1) % 3 == 0) {
                colIncrease += 10;
            }
            rowIncrease = 10;
            colIncrease += 50;
        }

        JButton solve = new JButton("SOLVE!");
        solve.setBounds(170, 490, 150, 40);
        this.add(solve);

        solve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solve();
            }
        });

        setVisible(true);
    }

    public Square getSquare(Pair<Integer, Integer> pos) {
        int column = pos.getC(), row = pos.getR();
        return (column >= 0 && column <= 8 && row >= 0 && row <= 8) ? board[row][column] : null;
    }

    public void addToOneValue(Square s) {
        oneValue.add(s);
    }

    public void solve() {
        while(!oneValue.isEmpty()) {
            Square s = oneValue.remove();
            int nextValue = s.getNextPossibleValue();
            s.update(nextValue);
        }

        while(!noValue.isEmpty()) {
            Square noValueSquare = noValue.remove();
            int possibleValue = noValueSquare.getPossibleValue();

            if(possibleValue == 0) {
                noValue.addFirst(noValueSquare);
                backTrack();
            } else {
                noValueSquare.update(noValueSquare.getPossibleValue());
                lastSquares.add(noValueSquare);
            }
        }

        display();
        JOptionPane.showMessageDialog(this, "CONGRATULATIONS, YOU FOUND THE ANSWER TO THIS SUDOKU PUZZLE", "Hello", JOptionPane.PLAIN_MESSAGE);
    }

    public void backTrack() {
        Square lastSquare = lastSquares.removeLast();
        int possibleValue = lastSquare.getPossibleValue();

        lastSquare.update(possibleValue);
        if(possibleValue == 0) {
            noValue.addFirst(lastSquare);
            backTrack();
        } else {
            lastSquares.add(lastSquare);
        }
    }

}
