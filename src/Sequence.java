import java.util.Iterator;

public abstract class Sequence implements Iterator<Integer>{
    private int next = 1;

    public final void remove() {
        throw new UnsupportedOperationException("sequence is immutable");
    }

    public boolean hasNext(Integer i) {
        if(i < Integer.MAX_VALUE)
            return true;
        throw new IllegalStateException("number is to big");
    }

    public Integer next() {
            return next++;
    }

    public void dump(int max) {
        for(int i = 0; i < max && hasNext(); i++) {
            System.out.print(next());
            if(hasNext())
                System.out.print(", ");
        }
        System.out.println(hasNext()? "..." : ";");
    }
}

