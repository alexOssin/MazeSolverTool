
public class Coordinate {

    private int _row;
    private int _column;


    public Coordinate(int row,int column)
    {
        _row = row;
        _column = column;

    }
    public Coordinate(Coordinate coordinate)
    {
        _row = coordinate.getRow();
        _column = coordinate.getColumn();

    }

    public int getRow() {
        return _row;
    }

    public void setRow(int row) {
        this._row = _row;
    }

    public int getColumn() {
        return _column;
    }

    public void setColumn(int column) {
        this._column = column;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Coordinate)) {
            return false;
        }

        Coordinate that = (Coordinate) other;

        return this._row==that._row
                && this._column==(that._column);
    }

    @Override
    public String toString() {
        return _row+" "+_column;
    }
}
