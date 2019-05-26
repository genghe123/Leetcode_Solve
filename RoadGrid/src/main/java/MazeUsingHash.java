import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class MazeUsingHash extends Maze {

    private ConcurrentHashMap<String, Boolean> set;

    public MazeUsingHash(String command) throws IOException {
        if (command == null) throw new IllegalArgumentException("Incorrect command format");
        BufferedReader reader = new BufferedReader(new StringReader(command));

        String[] init = checkAndSplit(reader.readLine(), 2, " ");
        row = tryUnsignParse(init[0]) * 2;
        col = tryUnsignParse(init[1]) * 2;
        set = new ConcurrentHashMap<>();
        init();

        for (String i : checkAndSplit(reader.readLine(), null, ";")) {
            connect(i);
        }
    }

    public MazeUsingHash(InputStream in) throws IOException {
        if (in == null) throw new IllegalArgumentException("Incorrect command format");
        StringBuilder buffer = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n, i = 0, j = 0; (n = in.read(b)) != -1; ) {
            String s = new String(b, 0, n);
            buffer.append(s);

            int lastIndex = buffer.lastIndexOf("\n");
            if (lastIndex != -1) {
                if (i++ == 0) {
                    String[] init = checkAndSplit(buffer.substring(0, lastIndex), 2, " ");
                    row = tryUnsignParse(init[0]) * 2;
                    col = tryUnsignParse(init[1]) * 2;
                    set = new ConcurrentHashMap<>();
                    init();

                    buffer.delete(0, lastIndex + 1);
                } else {
                    throw new IllegalArgumentException("Incorrect command format");
                }
            }
            lastIndex = buffer.lastIndexOf(";");
            if (lastIndex != -1 && j++ == 10000) {
                for (String a : checkAndSplit(buffer.substring(0, lastIndex), null, ";")) {
                    connect(a);
                }
                buffer.delete(0, lastIndex + 1);
                j = 0;
            }
        }
    }

    @Override
    public String render() {
        StringBuilder builder = new StringBuilder();
        for (Long i = 0L; i <= row; i++) {
            for (Long j = 0L; j <= col; j++) {
                if (set.containsKey(new Point(i, j).toString())) {
                    builder.append("[R]");
                } else {
                    builder.append("[W]");
                }
                builder.append(" ");
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }

    private void init() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        init(cachedThreadPool, 1, row, 1, col);
        try {
            cachedThreadPool.shutdown();
            while (!cachedThreadPool.isTerminated()) {
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void init(ExecutorService executor, long rowLow, long rowHigh, long colLow, long colHigh) {
        if (rowLow >= rowHigh || colLow >= colHigh) return;
        if (rowHigh - rowLow > 1000) {
            executor.execute(() -> {
                long rowMid = rowLow + (rowHigh - rowLow) / 2;
                init(executor, rowMid, rowHigh, colLow, colHigh);
                init(executor, rowLow, rowMid, colLow, colHigh);
            });
        }
        if (colHigh - colLow > 1000) {
            executor.execute(() -> {
                long colMid = colLow + (colHigh - colLow) / 2;
                init(executor, rowLow, rowHigh, colLow, colMid);
                init(executor, rowLow, rowHigh, colMid, colHigh);
            });
        }

        for (Long i = rowLow; i <= rowHigh; i += 2) {
            for (Long j = colLow; j <= colHigh; j += 2) {
                set.put(new Point(i, j).toString(), false);
            }
        }
    }

    private Long coordConvert(Long i) {
        return 2 * i + 1;
    }

    @Override
    void connect(String command) {
        String[] in = checkAndSplit(command, 2, " ");
        Point p1 = new Point(in[0]);
        Point p2 = new Point(in[1]);
        if (!set.containsKey(p1.toString()) || !set.containsKey(p2.toString())) {
            throw new IllegalArgumentException("Incorrect command format");
        }
        if (p1.neighbor(p2)) {
            set.put(p1.midPoint(p2).toString(), false);
        } else if (!p1.toString().equals(p2.toString())) {
            throw new IllegalArgumentException("Maze format error");
        }
    }

    private class Point {
        private Long x;
        private Long y;

        Point(String s) {
            String[] in = checkAndSplit(s, 2, ",");
            this.x = coordConvert(tryUnsignParse(in[0]));
            this.y = coordConvert(tryUnsignParse(in[1]));
        }

        Point(Long x, Long y) {
            this.x = x;
            this.y = y;
        }

        boolean neighbor(Point that) {
            if (that != null) {
                if (this.x.equals(that.x)) {
                    return Math.abs(this.y - that.y) == 2;
                }
                if (this.y.equals(that.y)) {
                    return Math.abs(this.x - that.x) == 2;
                }
            }
            return false;
        }

        Point midPoint(Point that) {
            Point point;
            if (this.x.equals(that.x)) {
                point = new Point(this.x, Math.min(this.y, that.y) + 1);
            } else {
                point = new Point(Math.min(this.x, that.x) + 1, this.y);
            }
            return point;
        }

        @Override
        public String toString() {
            return this.x.toString() + "+" + this.y.toString();
        }
    }
}
