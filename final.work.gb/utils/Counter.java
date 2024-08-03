package utils;

public class Counter implements AutoCloseable {
    private int count;
    private boolean closed;

    public Counter() {
        this.count = 0;
        this.closed = false;
    }

    public void add() {
        if (closed) {
            throw new IllegalStateException("Counter is closed");
        }
        count++;
    }

    @Override
    public void close() {
        closed = true;
    }

    public int getCount() {
        return count;
    }
}