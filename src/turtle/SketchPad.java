package turtle;

public class SketchPad {
    int[][] floor;

    public SketchPad(int floorRow, int floorColumn) {
        floor = new int[floorRow][floorColumn];

    }

    public int[][] getFloor() {
        return floor;
    }

    public void displayFloor() {
        for (int[] row : floor) {
            for (int column : row) {
                if (column == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}