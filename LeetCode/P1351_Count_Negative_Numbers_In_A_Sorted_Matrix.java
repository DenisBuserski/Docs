class Solution {
    public int countNegatives(int[][] grid) {
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        int row = 0;
        int column = numberOfColumns - 1;
        int count = 0;

        while (row < numberOfRows && column >= 0) {
            if (grid[row][column] < 0) {
                count += (numberOfRows - row);
                column--;
            } else {
                row++;
            }
        }
        return count;
    }
}
