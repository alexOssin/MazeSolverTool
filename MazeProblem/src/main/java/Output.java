import java.util.List;

public abstract class Output
{
    private static char START = 'S';
    private static char END = 'E';
    private static char PASSAGE = 'X';
    private static char WALL = '#';

    public static void displayOutput(Maze maze,
                       Coordinate startPoint,
                       Coordinate endPoint,
                       List<Coordinate> path)
    {
        char[][] mazeMatrixChar ;

        //convert from matrix of integers to matrix of characters
        mazeMatrixChar = toCharMatrix(maze.getMazeMatrix());

        //print path and start  end points on matrix
        printPathOnCharMatrix(mazeMatrixChar,startPoint,endPoint,path);

        System.out.println(toString(mazeMatrixChar));


    }

    //convert from matrix of integers to matrix of characters
    private static char[][] toCharMatrix(int [][] intMaze)
    {
        int height = intMaze.length;
        int width = intMaze[0].length;
        char[][] mazeMatrixChar = new char[height][width];

        for(int row = 0;row < height;row++)
        {
            for(int col = 0;col < width ; col++)
            {
                if(intMaze[row][col] == MazeSolverTool.WALL)
                    mazeMatrixChar[row][col] = WALL;
                else
                    mazeMatrixChar[row][col] = ' ';


            }

        }
        return mazeMatrixChar;
    }

    //prints path and start end points on matrix
    private static void printPathOnCharMatrix(char [][] charMatrix,
                                           Coordinate startPoint,
                                           Coordinate endPoint,
                                           List<Coordinate> path)
    {

        //rint path on matrix
        for(Coordinate coordinate:path)

            charMatrix[coordinate.getRow()][coordinate.getColumn()] = PASSAGE;

        //print start and end points on matrix
        charMatrix[startPoint.getRow()][startPoint.getColumn()] = START;
        charMatrix[endPoint.getRow()][endPoint.getColumn()] = END;
    }

    private static String toString(char [][] charMatrix)
    {
        String charMatrixStr = "";
        for(int row = 0;row < charMatrix.length;row++)
        {
            for(int col = 0;col < charMatrix[0].length ; col++)
            {
               charMatrixStr += charMatrix[row][col]+" ";
            }
            charMatrixStr +="\n";

        }
        return charMatrixStr;
    }

}
