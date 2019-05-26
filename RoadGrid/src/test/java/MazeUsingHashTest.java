import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.StringBufferInputStream;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MazeUsingHashTest {

    private Maze maze;

    @Test
    public void renderTest() throws IOException {
        maze = Maze.create("3 3\n0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1");
        String result = maze.render();
        Assert.assertEquals(
                "[W] [W] [W] [W] [W] [W] [W] \r\n" +
                        "[W] [R] [W] [R] [R] [R] [W] \r\n" +
                        "[W] [R] [W] [R] [W] [R] [W] \r\n" +
                        "[W] [R] [R] [R] [R] [R] [W] \r\n" +
                        "[W] [W] [W] [R] [W] [R] [W] \r\n" +
                        "[W] [R] [R] [R] [W] [R] [W] \r\n" +
                        "[W] [W] [W] [W] [W] [W] [W] \r\n", maze.render());
    }

    @Test(expected = NumberFormatException.class)
    public void inputCheckTest_InvalidNumberFormat1() throws IOException {
        maze = Maze.create("1.0 3\n0,1 0,2;0,0 1,0");
    }

    @Test(expected = NumberFormatException.class)
    public void inputCheckTest_InvalidNumberFormat2() throws IOException {
        maze = Maze.create("1 3\n0,1 0,Random");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputCheckTest_InvalidNumberRange() throws IOException {
        try {
            maze = Maze.create("1 3\n0,1 0,-1");
        } catch (IllegalArgumentException e) {
            assertEquals("Number out of range", e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputCheckTest_LackData() throws IOException {
        try {
            maze = Maze.create("1 3\n0,1");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect command format", e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputCheckTest_TwoGridNotAdjacent() throws IOException {
        try {
            maze = Maze.create("3 3\n1,1 2,2");
        } catch (IllegalArgumentException e) {
            assertEquals("Maze format error", e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputCheckTest_GridOutOfRange() throws IOException {
        try {
            maze = Maze.create("2 2\n100,50 100,51");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect command format", e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputCheckTest_OneLineInput() throws IOException {
        try {
            maze = Maze.create("0 0\n");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect command format", e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputCheckTest_NoInput() throws IOException {
        try {
            maze = Maze.create((String) null);
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect command format", e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Test
    public void criticalTest_OnlyOneGrid() throws IOException {
        maze = Maze.create("1 1\n0,0 0,0");
        Assert.assertEquals(2, maze.render().split("R").length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void criticalTest_NoGrid() throws IOException {
        try {
            maze = Maze.create("0 0\n0,0 0,0");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect command format", e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @Test
    public void pressureTest_1000000Grid() throws IOException {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream();
        out.connect(in);

        new Thread(() -> {
            try {
                StringBuilder builder = new StringBuilder();
                builder.append("1000 1000\n");
                for (int i = 0; i < 999; i += 1) {
                    for (int j = 0; j < 999; j += 1) {
                        builder.append(i).append(",").append(j).append(" ");
                        builder.append(i).append(",").append(j + 1);
                        builder.append(";");
                        out.write(builder.toString().getBytes());
                        builder.delete(0, builder.length());
                    }
                    out.flush();
                }
                builder.append("0,0 0,1");
                out.write(builder.toString().getBytes());
                out.flush();
                out.close();
            } catch (IOException e){

            }
        }).start();

        maze = Maze.create(in);
    }
}