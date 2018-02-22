import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class MazeSolverTest
{
    int [][] matrix_1 = new int[][]//6x5 startP (1,1) endP (4,3)
            {       {1,1,1,1,1},
                    {1,0,0,0,1},
                    {1,1,1,0,1},
                    {1,1,1,0,1},
                    {1,1,1,0,1},
                    {1,1,1,1,1},
            };


    @Test
    public void solveMatrix_matrix_1_solvable() throws Exception
    {
        MazeSolverTool tool = new MazeSolverTool(
                new Maze(matrix_1),
                new Coordinate(1, 1),
                new Coordinate(4, 3));


        tool.solve();
        assertTrue("assert solvable maze",tool.getIsSolvable());

        assertEquals("assert found path",pathOfCoordinatesToString(tool.getPath()), "4 3 3 3 2 3 1 3 1 2 1 1 ");

    }

        int [][] matrix_2 =//10x13 startP(1,1) endP()(8,11)
                {       {1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,1,0,1,0,1,0,0,0,0,0,1},
                        {1,0,1,0,0,0,1,0,1,1,1,0,1},
                        {1,0,0,0,1,1,1,0,0,0,0,0,1},
                        {1,0,1,0,0,0,0,0,1,1,1,0,1},
                        {1,0,1,0,1,1,1,0,1,0,0,0,1},
                        {1,0,1,0,1,0,0,0,1,1,1,0,1},
                        {1,0,1,0,1,1,1,0,1,0,1,0,1},
                        {1,0,0,0,0,0,0,0,0,0,1,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1}
                };

    @Test
    public void solveMatrix_matrix_2_solvable()throws Exception
    {
        List<Integer> path = new ArrayList<Integer>();
        MazeSolverTool tool = new MazeSolverTool(
                new Maze(matrix_2),
                new Coordinate(1, 1),
                new Coordinate(8, 11));
        tool.solve();
        assertTrue("assert solvable maze",tool.getIsSolvable());
        assertEquals("assert found path",pathOfCoordinatesToString(tool.getPath()),"8 11 7 11 6 11 5 11 4 11 3 11 3 10 3 9 3 8 3 7 4 7 4 6 4 5 4 4 4 3 3 3 3 2 3 1 2 1 1 1 ");
    }


    private String pathOfCoordinatesToString(List<Coordinate> path)
    {
        String pathStr = "";
        for(Coordinate c:path)
        {
            pathStr+=c.toString()+" ";

        }
        return pathStr;
    }


    int [][] matrix_3 = new int[][]//6x5 startP (1,1) endP (4,3)
            {       {1,1,1,1,1},
                    {1,1,0,0,1},
                    {1,1,1,0,1},
                    {1,1,1,0,1},
                    {1,1,1,0,1},
                    {1,1,1,1,1},
            };

    @Test
    public void solveMatrix_matrix_3_notSolvable()throws Exception
    {
        MazeSolverTool tool = new MazeSolverTool(
                new Maze(matrix_3),
                new Coordinate(1, 1),
                new Coordinate(4, 3));


        tool.solve();
        assertFalse("assert not solvable maze",tool.getIsSolvable());

   }

    int [][] matrix_4 = new int[][]//3x5 startP (1,1) endP (1,1)
            {       {1,1,1,1,1},
                    {1,0,0,0,1},
                    {1,1,1,0,1},

            };

    @Test
    public void solveMatrix_matrix_4_solvable() throws Exception
    {
        MazeSolverTool tool = new MazeSolverTool(
                new Maze(matrix_4),
                new Coordinate(1, 1),
                new Coordinate(1, 1));


        tool.solve();
        assertTrue("assert solvable maze",tool.getIsSolvable());
        assertEquals("assert found path",pathOfCoordinatesToString(tool.getPath()),"1 1 ");


    }


}
