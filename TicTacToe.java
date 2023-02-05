import java.util.Scanner;

public class TicTacToe {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nLet's play tic tac toe");

        char[][] board = {
                { '_', '_', '_' },

                { '_', '_', '_' },

                { '_', '_', '_' },
        };

        // Task 2: Call the function printBoard();
        printBoard(board);

        for (int i = 0; i < 9; i++) {

            if (i % 2 == 0) {
                System.out.println("Turn: " + " X ");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'X';
            } else {
                System.out.println("Turn: " + " O ");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'O';
            }
            printBoard(board);
            int count = checkWin(board);
            if (count == 3) {
                System.out.println("X wins!!!");
                break;
            } else if (count == -3) {
                System.out.println("O wins!!!");
                break;
            } else if (i == 8)
                System.out.println("It's a tie");

        }
    }

    public static void printBoard(char[][] board) {
        System.out.print("\n");
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n\n");
        }

    }

    public static int[] askUser(char[][] board) {
        System.out.print("pick a row and column number: ");
        int row = scan.nextInt();
        int column = scan.nextInt();
        while (board[row][column] != '_') {// (board[row][column] == 'X' || board[row][column] == 'O'){
            System.out.print("Spot taken , try again: ");
            row = scan.nextInt();
            column = scan.nextInt();

        }
        return new int[] { row, column };

    }

    public static int checkWin(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // check for row
                if (board[i][j] == 'X') {
                    count += 1;
                } else if (board[i][j] == 'O') {
                    count -= 1;
                }

            }
            if (count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }
        }
        // check for coloumn
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 'X') {
                    count += 1;
                } else if (board[j][i] == 'O') {
                    count -= 1;
                }

            }
            if (count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }

        }
        // left diagnol
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == 'X') {
                count++;
            } else if (board[i][i] == 'O') {
                count--;
            }
        }
        if (count == 3 || count == -3) {
            return count;
        } else {
            count = 0;
        }
        // Right diagnol
        for (int i = 0; i < 3; i++) {
            int rowIndex = 2 - i;
            if (board[rowIndex][i] == 'X') {
                count++;
            } else if (board[rowIndex][i] == 'O') {
                count--;
            }

        }

        return count;

    }

}
