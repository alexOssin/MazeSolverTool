Pre-interview task I was given for SDET role
(the original task described in about_the_task.txt)


       ================== Maze Solver Tool intro ========================


1. This Java utility can be run using command line :

    java -jar MazeSolverTool-1.0-SNAPSHOT.jar filePath/file.txt


2. There is MazeSolverToolTest class with JUnit tests for testing all given input files.

3. All input files are stored under src/test/testFiles directory.

4. General project structure :
    -MazeReader : reads the file and holds: maze matrix , its dimensions , start and end points.
    -MazeSolverTool : given a maze matrix , start and end points , searches for a "legal path" in maze matrix in between given points.
    -Output.displayOutput : static method that prints solved maze to stdIn
    -Maze class represents maze matrix

3. Assumptions :
    - each given maze is surrounded by '1' (main frame of the matrix contains only one's) (reason ==> simple implementation)
    - since there is no need to validate input files formats ==> no negative tests were implemented.


4. general points to improve :
    - more detailed Exceptions
    - logging should be added
    - given detailed requirements ,more tests should be added (negative , restriction , End-to-End , performance , etc')







