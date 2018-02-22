import java.io.IOException;

public class MazeSolverToolMain
{


    public static void main(String args[])
    {
        try
        {
            //read file
            MazeReader reader = new MazeReader(args[0]);
            reader.read();

            //get read objects
            Coordinate startPoint = new Coordinate(reader.getStartPoint());
            Coordinate endPoint = new Coordinate(reader.getEndPoint());
            Maze maze = new Maze(reader.getMazeMatrix());

            //solve read maze
            MazeSolverTool tool = new MazeSolverTool(maze,startPoint,endPoint);
            tool.solve();

            //print output
            tool.displayOutput();

        }
        catch (Exception e)
        {
            System.err.println("main error!"+e.getMessage());

        }
    }
}
