package turtle;

public class Position {
    private int rowPosition;
    private int columnPosition;

    public Position(int rowPosition, int columnPosition) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
    }


    @Override
    public String toString() {
        return "Position{}";
    }

    @Override
    public boolean equals(Object o){
//        Position comparedPosition = (Position);
        return false;
    }
}