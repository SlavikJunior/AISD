package sudoku;

public class Main {

    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 3, 1, 4, 5},
//                {7, 0, 2, 4, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 3, 0, 0, 0, 6},
//                {1, 0, 7, 0, 0, 8, 0, 0, 0},
//                {0, 0, 9, 0, 0, 2, 0, 1, 0},
//                {0, 0, 0, 0, 8, 9, 6, 3, 0},
//                {3, 0, 0, 0, 0, 0, 0, 0, 0},
//                {4, 0, 5, 0, 0, 0, 0, 0, 8}
//        };

        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 1, 4, 5},
                {7, 0, 2, 4, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 0, 0, 6},
                {1, 0, 7, 0, 0, 8, 0, 0, 0},
                {0, 0, 9, 0, 0, 2, 0, 1, 0},
                {0, 0, 0, 0, 8, 9, 6, 3, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 5, 0, 0, 0, 0, 0, 8}
        };

        SudokuSolver sudokuSolver = new SudokuSolver();
        System.out.println("Исходное судоку:");
        sudokuSolver.printGrid(grid);

        if (sudokuSolver.solveSudoku(grid)) {
            System.out.println("\nРешённое судоку:");
            sudokuSolver.printGrid(grid);
        } else {
            System.out.println("\nРешения не существует!");
        }
    }
}
