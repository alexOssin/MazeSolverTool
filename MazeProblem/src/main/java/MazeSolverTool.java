import java.util.ArrayList;
import java.util.List;


/*
 solves the maze given its Start and End points and maze object
 */
public class MazeSolverTool
{
    private Maze _maze;
    private Coordinate _startPoint;
    private Coordinate _endPoint;
    private boolean isSolvable = false;
    private List<Coordinate> _path;

    public static int WALL = 1;
    public static int VISITED = 2;
    public static int PASSAGE = 0;

    public MazeSolverTool(Maze maze,Coordinate startPoint,Coordinate endPoint)
    {
        _maze = maze;
        _startPoint = startPoint;
        _endPoint = endPoint;
        _path = new ArrayList<Coordinate>();
    }

    public void solve() throws MazeReaderToolException
    {
        try
        {
            isSolvable = findPath(_startPoint);
            if(isSolvable != true)
            {
                _path.clear();
            }

        }
        catch (Exception e)
        {
            throw new  MazeReaderToolException("Unable to solve a maze."+e.getMessage());
        }


    }
    public List<Coordinate> getPath()
    {
        return _path;
    }


    public void displayOutput()
    {
        if(isSolvable)
            Output.displayOutput(_maze,_startPoint,_endPoint,_path);
        else
            System.out.println(" the maze not solvable . Nothing to display");

    }
    public boolean getIsSolvable()
    {
        return isSolvable;
    }

    /*
    recursive method
    returns TRUE if the maze is solvable , otherwise FALSE
    and update _path member in case there is a path from startPoint to endPoint.

    since we visit each coordinate only once , runtime equals to  (O(weigh * height))
    I thought about implementing  DFS algorithm but since in this case runtime is equal ,
    i've implemented current one just because it reminds me of my school days :)
     */
    private boolean findPath(final Coordinate startPoint) throws MazeReaderToolException
    {
        try
        {
            final Coordinate currLocation = new Coordinate(startPoint.getRow(),startPoint.getColumn());
            if(currLocation.equals(_endPoint))
            {
                _path.add(currLocation);
                return true;
            }

            if(_maze.getValue(currLocation) == PASSAGE)
            {
                _maze.setValue(currLocation,VISITED);

                Coordinate stepLeft = new Coordinate(currLocation.getRow(),currLocation.getColumn()-1);
                if (findPath(stepLeft))
                {
                    _path.add(currLocation);
                    return true;
                }

                Coordinate stepRight = new Coordinate(currLocation.getRow(),currLocation.getColumn()+1);
                if(findPath(stepRight))
                {
                    _path.add(currLocation);
                    return true;
                }

                Coordinate stepUp = new Coordinate(currLocation.getRow()-1,currLocation.getColumn());
                if(findPath(stepUp))
                {
                    _path.add(currLocation);
                    return true;
                }

                Coordinate stepDown = new Coordinate(currLocation.getRow()+1,currLocation.getColumn());
                if(findPath(stepDown))
                {
                    _path.add(currLocation);
                    return true;
                }
            }
            return false;

        }
        catch(Exception e)
        {
            throw new MazeReaderToolException("MazeSolverToolException: "+e.getMessage());
        }

    }

    public String mazeToString()
    {
        String pathStr = "";
        for(Coordinate coordinate:_path)
        {
            pathStr+=coordinate.toString()+" ";

        }
        return pathStr;

    }


}
