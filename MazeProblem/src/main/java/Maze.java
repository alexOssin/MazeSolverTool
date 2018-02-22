
/*
represent a maze as 2D array
 */
public class Maze
{

    private int[][] _mazeMatrix;


public Maze(int [][] mazeMatrix)
{
    _mazeMatrix = mazeMatrix;

}

public int getValue(Coordinate coordinate)
{
    return _mazeMatrix[coordinate.getRow()][coordinate.getColumn()];
}

public void setValue(Coordinate coordinate, int value)
{
    _mazeMatrix[coordinate.getRow()][coordinate.getColumn()] = value;

}

public String toString()
{
    String matrix = "";
    for(int row = 0 ; row < _mazeMatrix.length; row++)
    {
        for(int col = 0 ; col< _mazeMatrix[0].length;col++)
        {
            matrix+=_mazeMatrix[row][col]+" ";
        }
        matrix+="\n";
    }
    return matrix+="\n";
}
public int[][] getMazeMatrix()
{
    return _mazeMatrix;

}






}
