package DAA5;
public class NQueens {
    public static void main(String[] args) {
        int n = 4; // Change this to the desired board size
        int[][] board = new int[n][n];
        placeQueens(board, 0);
        printBoard(board);
    }

    // Function to solve the N-Queens problem using backtracking
    public static boolean placeQueens(int[][] board, int col) {
        int N = board.length;

        // All queens are placed successfully
        if (col >= N) {
        	printBoard(board);
            System.out.println();
            return true;
        }

        for (int row = 0; row < N; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;

                // Recur to place the rest of the queens
                if (placeQueens(board, col + 1)) {
                    return true;
                }

                // If placing queen in board[row][col] doesn't lead to a solution, backtrack
                board[row][col] = 0;
            }
        }

        // If no row can be used to place the queen, return false
        return false;
    }

    // Check if it's safe to place a queen at board[row][col]
    public static boolean isSafe(int[][] board, int row, int col) {
        int N = board.length;

        // Check the row on the left
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Function to print the chessboard
    public static void printBoard(int[][] board) {
        int N = board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}