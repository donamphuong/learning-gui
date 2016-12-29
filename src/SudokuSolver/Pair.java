package SudokuSolver;

/**
 * Created by donamphuong on 25/06/2016.
 */
public class Pair<R, C> {
    private R r;
    private C c;

    public Pair(R r, C c) {
        this.r = r;
        this.c = c;
    }

    public R getR() {
        return r;
    }

    public C getC() {
        return c;
    }

    public void set(R r, C c) {
        this.r = r;
        this.c = c;
    }
}
