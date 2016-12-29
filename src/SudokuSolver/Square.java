package SudokuSolver;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.HashSet;
import java.util.Set;

public class Square extends JSpinner{
    private final int MAX_VALUE = 9;
    private Pair<Integer, Integer> position;
    private SudokuBoard board;
    private Set<Integer> possibleValues;

    //squares represent position of squares that are in the same row, column or big square of this square
    private Set<Pair<Integer, Integer>> squares = new HashSet<>();

    public Square(int value, int position, SudokuBoard board) {
        setValue(value);
        this.position = new Pair<>(position/MAX_VALUE, position%MAX_VALUE);
        this.board = board;
        this.possibleValues = new HashSet<>();

        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Square source = (Square) e.getSource();
                source.update((int) source.getValue());
                //System.out.println(((Square) e.getSource()).getValue());

                //source.getBoard().removeFromNoValue(source);
            }
        });
        initialise();
    }

    private SudokuBoard getBoard() {
        return board;
    }

    private void initialise() {
        possibleValues.add(1);
        possibleValues.add(2);
        possibleValues.add(3);
        possibleValues.add(4);
        possibleValues.add(5);
        possibleValues.add(6);
        possibleValues.add(7);
        possibleValues.add(8);
        possibleValues.add(9);

        for(int i = 0; i < MAX_VALUE; i++) {
            Pair<Integer, Integer> sameRow = new Pair<>(position.getR(), i);
            Pair<Integer, Integer> sameColumn = new Pair<>(i, position.getC());
            if(i != position.getR()) {
                squares.add(sameColumn);
            }

            if(i!= position.getC()) {
                squares.add(sameRow);
            }
        }

        addSquare();
    }

    public void addSquare() {
        Pair<Integer, Integer> row = findStart(position.getR()), column = findStart(position.getC());

        for(int i = row.getR(); i <= row.getC(); i++) {
            for(int j = column.getR(); j <= column.getC(); j++) {
               if(i != 0 && j != 0) {
                   Pair<Integer, Integer> newPair = new Pair<>(position.getR() + i, position.getC() + j);
                   squares.add(newPair);
               }
            }
        }
    }

    public Pair<Integer, Integer> findStart(int num) {
        if(num%3 == 0) {
            return new Pair<>(1, 2);
        } else if (num%3 == 1) {
            return new Pair<>(-1, 1);
        } else {
            return new Pair<>(-2 , -1);
        }
    }

    /*
    Return the first possible value of a square - provided the possibleValues is not empty
     */
    public int getPossibleValue() {
        Set<Integer> knownValues = new HashSet<>();

        for(Pair<Integer, Integer> s : squares) {
            int value = (int) board.getSquare(s).getValue();

            if(!knownValues.contains(value) && value != 0) {
                knownValues.add(value);
            }
        }

        for(int i : possibleValues) {
            if(!knownValues.contains(i) && i > (int) getValue()) {
                return i;
            }
        }

        return 0;
    }

    public int getNextPossibleValue() {
        return possibleValues.iterator().next();
    }

    public static int findPosition(int row, int column) {
        return row * 9 + column;
    }

    public void update(int val) {
      setValue(val);

        board.removeFromNoValue(this);

        for(Pair<Integer, Integer> s : squares) {
           board.getSquare(s).oneValue();
        }
    }

    private void oneValue() {
        if(possibleValues.size() == 1) {
            board.addToOneValue(this);
        }
    }

    public void removeValue() {
        setValue(0);
    }

}
