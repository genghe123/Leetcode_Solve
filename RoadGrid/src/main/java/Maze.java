import java.io.IOException;
import java.io.InputStream;

public abstract class Maze {

    long row, col;

    public abstract String render();

    public static Maze create(String command) throws IOException {
        return new MazeUsingHash(command);
    }

    public static Maze create(InputStream in) throws IOException{
        return new MazeUsingHash(in);
    }

    String[] checkAndSplit(String s, Integer length, String split) {
        if (s == null) {
            throw new IllegalArgumentException("Incorrect command format");
        }
        String[] result = s.split(split);
        if ((length != null && result.length != length)) {
            throw new IllegalArgumentException("Incorrect command format");
        }
        return result;
    }

    Long tryUnsignParse(String s) {
        Long result;
        try {
            result = (long) Integer.parseInt(s);
            if (result < 0) throw new IllegalArgumentException("Number out of range");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format");
        }
        return result;
    }

    abstract void connect(String command);
}
