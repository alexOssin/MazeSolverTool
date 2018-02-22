import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class MazeReaderTest
{

    int [][] matrix_1 = new int[][]//6x5 startP (1,1) endP (4,3)
            {       {1,1,1,1,1},
                    {1,0,0,0,1},
                    {1,0,1,0,1},
                    {1,0,1,0,1},
                    {1,0,1,0,1},
                    {1,1,1,1,1}
            };
    @Test
    public void mazeReaderTest_readSmallInputFile() throws Exception
    {
        MazeReader reader = new MazeReader("src/test/testFiles/small.txt");
        reader.read();

        //verify results
        assertEquals(" assert width",5,reader.getWidth());
        assertEquals(" assert height",6,reader.getHeight());

        assertEquals("assert start point column",
                1,reader.getStartPoint().getColumn());
        assertEquals("assert start point row",
                1,reader.getStartPoint().getRow());


        assertEquals("assert end point column",
                3,reader.getEndPoint().getColumn());
        assertEquals("assert end point row",
                4,reader.getEndPoint().getRow());

        assertEquals("assert matrix ",
                toString(reader.getMazeMatrix()),toString(matrix_1));


    }

    public String toString(int[][] mazeMatrix)
    {
        String matrix = "";
        for(int row = 0 ; row < mazeMatrix.length; row++)
        {
            for(int col = 0 ; col< mazeMatrix[0].length;col++)
            {
                matrix+=mazeMatrix[row][col]+" ";
            }
            matrix+="\n";
        }
        return matrix+="\n";
    }
}
