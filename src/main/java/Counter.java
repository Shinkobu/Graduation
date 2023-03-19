import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Closeable {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private final int id;

    public Counter() {
        id = COUNTER.getAndIncrement();
    }
    public int getId(){
        return id;
    }

    @Override
    public void close() throws IOException {

    }
}
