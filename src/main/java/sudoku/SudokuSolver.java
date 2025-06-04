package sudoku;

public class SudokuSolver {
    private static final int GRID_SIZE = 9;
    private static final int EMPTY_CELL = 0;

    public boolean solveSudoku(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                // проверяю заполнена ли ячейка
                if (board[row][column] == EMPTY_CELL) {
                    // начинаю пробовать расставлять цифры с единицы
                    for (int number = 1; number <= GRID_SIZE; number++) {
                        // если цифра не подошла, пробую другую
                        if (isValidInserting(board, row, column, number)) {
                            board[row][column] = number;

                            // если цифра подошла, рекурсивно пробую расставить в остальные ячейки
                            if (solveSudoku(board))
                                return true;

                            // backtracking, если зашли в тупик
                            else
                                board[row][column] = EMPTY_CELL;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidInserting(int[][] board, int row, int column, int number) {
        // проверяю строку
        for (int tempColumn = 0; tempColumn < GRID_SIZE; tempColumn++) {
            if (board[row][tempColumn] == number) {
                return false;
            }
        }

        // проверяю столбец
        for (int tempRow = 0; tempRow < GRID_SIZE; tempRow++) {
            if (board[tempRow][column] == number) {
                return false;
            }
        }

        // проверяю квадрат 3x3
        // прикольный способ определить верхний угол квадрата
        // для ячейки (2, 7): 2 - 2 = 0 \\
        //                                ==> верно
        //                    7 - 1 = 6 //
        int tempRow = row - row % 3;
        int tempColumn = column - column % 3;

        for (int r = tempRow; r < tempRow + 3; r++) {
            for (int c = tempColumn; c < tempColumn + 3; c++) {
                if (board[r][c] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    public void printGrid(int[][] grid) {
        System.out.println("╔═══════╤═══════╤═══════╗");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("╟───────┼───────┼───────╢");
            }
            System.out.print("║ ");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("│ ");
                }
                System.out.print(grid[i][j] == 0 ? "· " : grid[i][j] + " ");
            }
            System.out.println("║");
        }
        System.out.println("╚═══════╧═══════╧═══════╝");
    }
}
