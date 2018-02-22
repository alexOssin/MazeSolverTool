import org.junit.Test;

import java.io.IOException;

public class MazeSolverToolMainTest
{
    private String smallInputFile = "src/test/testFiles/small.txt";
    private String largeInputFile = "src/test/testFiles/large_input.txt";
    private String mediumInputFile = "src/test/testFiles/medium_input.txt";
    private String inputFile = "src/test/testFiles/input.txt";
    private String sparseMedium = "src/test/testFiles/sparse_medium.txt";



    @Test
    public void sparseMediumFileTest() throws IOException
    {
        MazeSolverToolMain.main(new String[]{sparseMedium});
    }

    @Test
    public void inputFileTest() throws IOException
    {
        MazeSolverToolMain.main(new String[]{inputFile});
    }
    @Test
    public void mediumInputFileTest() throws IOException
    {
        MazeSolverToolMain.main(new String[]{mediumInputFile});
    }

    @Test
    public void largeInputFileTest() throws IOException
    {
        MazeSolverToolMain.main(new String[]{largeInputFile});
    }

    @Test
    public void smallInputFileTest() throws IOException
    {
        MazeSolverToolMain.main(new String[]{smallInputFile});
    }

}
