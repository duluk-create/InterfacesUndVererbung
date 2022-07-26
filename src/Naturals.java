
public class Naturals extends Sequence {
    private int next = 1;

    public boolean hasNext() {
        return true;
    }

    public Integer next() {
        if(next < 0)
            throw new IllegalStateException("Integer overflow");
        return next++;
    }
}
