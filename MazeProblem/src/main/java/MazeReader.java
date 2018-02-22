import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
represents a file as an object

Note: assuming that an input file is legal (as it written in the task) ,
no exceptions and other validations implemented
 */
public class MazeReader
{
    private int[][] _mazeMatrix;
    private Coordinate _startPoint;
    private Coordinate _engPoint;
    private int _width;
    private int _height;
    private File _filePath;


    public MazeReader(String fileStr) throws MazeReaderToolException
    {
        _filePath = new File(fileStr);
    }
    public void read() throws MazeReaderToolException
    {
        Scanner scanner;
        try
        {
            scanner = new Scanner(_filePath);

            //read matrix dimensions
            _width = scanner.nextInt();
            _height = scanner.nextInt();

            //read start point
            int column = scanner.nextInt();
            int row = scanner.nextInt();
            _startPoint = new Coordinate(row, column);

            //read end point
            column = scanner.nextInt();
            row = scanner.nextInt();
            _engPoint = new Coordinate(row, column);

            //read the matrix
            _mazeMatrix = new int[_height][_width];
            for (row = 0; row < _height; row++)
            {
                for (column = 0; column < _width; column++)
                    _mazeMatrix[row][column] = scanner.nextInt();
            }

            scanner.close();

        }
        catch(Exception e)
        {
            throw new MazeReaderToolException("MazeReader exception: "+e.getMessage());

        }



    }

    public int[][] getMazeMatrix() {
        return _mazeMatrix;
    }


    public Coordinate getStartPoint() {
        return _startPoint;
    }


    public Coordinate getEndPoint() {
        return _engPoint;
    }

    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }


}
