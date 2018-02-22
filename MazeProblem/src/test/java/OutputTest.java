import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class OutputTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void initTest() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void reset() {
        System.setOut(System.out);
    }


    private static int[][] matrix_1 = new int[][]//6x5 startP (1,1) endP (4,3)
            {{1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 1},
                    {1, 1, 1, 0, 1},
                    {1, 1, 1, 0, 1},
                    {1, 1, 1, 0, 1},
                    {1, 1, 1, 1, 1},
            };
    private static String outputMatrix =
            "# # # # # \n" +
                    "# S X X # \n" +
                    "# # # X # \n" +
                    "# # # X # \n" +
                    "# # # E # \n" +
                    "# # # # # \n" +
                    "\n";

    @Test
    public void outputTest() {
        Coordinate sPoint = new Coordinate(1, 1);
        Coordinate ePoint = new Coordinate(4, 3);
        List<Coordinate> path = Arrays.asList(new Coordinate(1, 1),
                new Coordinate(1, 2),
                new Coordinate(1, 3),
                new Coordinate(2, 3),
                new Coordinate(3, 3),
                new Coordinate(4, 3));

        Maze maze = new Maze(matrix_1);

        Output.displayOutput(maze, sPoint, ePoint, path);
        assertEquals("assert output ", outputMatrix, outContent.toString());

    }
}