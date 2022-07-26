import java.util.NoSuchElementException;

public class Range extends Sequence {

    private int next;
    private final int stopper;

    public Range(int from, int to) {
        next = from;
        stopper = to;
    }

    public boolean hasNext() {
        return next < stopper;
    }

    public Integer next() {
        if(hasNext())
            return next++;
        throw new NoSuchElementException("no more elments!");
    }


}
