

class TicTacToe {
    private CellState[][] board;
    private boolean isFirstPlayerTurn;
    private boolean isPlayerVsComputer;
    private boolean isPlayerFirst;

    
    public TicTacToe(boolean playAgainstComputer, boolean playerGoesFirst) {
        board = new CellState[3][3];
        isFirstPlayerTurn = true;
        isPlayerVsComputer = playAgainstComputer;
        isPlayerFirst = playerGoesFirst;
        
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = CellState.EMPTY;
            }
        }
    }


    public boolean makeMove(int row, int col) {

        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != CellState.EMPTY) {
            return false;
        }

        
        board[row][col] = isFirstPlayerTurn ? CellState.X : CellState.O;
        isFirstPlayerTurn = !isFirstPlayerTurn;

        
        if (isPlayerVsComputer && 
            ((isPlayerFirst && !isFirstPlayerTurn) || (!isPlayerFirst && isFirstPlayerTurn))) {
            makeComputerMove();
        }

        return true;
    }

    
    private void makeComputerMove() {

        if (findWinningMove()) return;
        
        
        if (findBlockingMove()) return;
        
        makeRandomMove();
    }

    private boolean findWinningMove() {
        CellState computerSymbol = isPlayerFirst ? CellState.O : CellState.X;
        return findStrategicMove(computerSymbol);
    }

    private boolean findBlockingMove() {
        CellState playerSymbol = isPlayerFirst ? CellState.X : CellState.O;
        return findStrategicMove(playerSymbol);
    }

    private boolean findStrategicMove(CellState symbol) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == CellState.EMPTY) {
                    board[i][j] = symbol;
                    if (checkWin()) {
                        board[i][j] = isFirstPlayerTurn ? CellState.X : CellState.O;
                        isFirstPlayerTurn = !isFirstPlayerTurn;
                        return true;
                    }
                    board[i][j] = CellState.EMPTY;
                }
            }
        }
        return false;
    }

    private void makeRandomMove() {
        java.util.Random rand = new java.util.Random();
        int row, col;
        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (board[row][col] != CellState.EMPTY);

        board[row][col] = isFirstPlayerTurn ? CellState.X : CellState.O;
        isFirstPlayerTurn = !isFirstPlayerTurn;
    }


    public boolean checkWin() {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] != CellState.EMPTY && 
                board[i][0] == board[i][1] && 
                board[i][1] == board[i][2]) {
                return true;
            }
        }


        for (int j = 0; j < 3; j++) {
            if (board[0][j] != CellState.EMPTY && 
                board[0][j] == board[1][j] && 
                board[1][j] == board[2][j]) {
                return true;
            }
        }

        if (board[0][0] != CellState.EMPTY && 
            board[0][0] == board[1][1] && 
            board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != CellState.EMPTY && 
            board[0][2] == board[1][1] && 
            board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }


    public boolean isDraw() {
        if (checkWin()) return false;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == CellState.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    public CellState[][] getBoard() {
        return board;
    }


    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String symbol = switch (board[i][j]) {
                    case X -> "X";
                    case O -> "O";
                    case EMPTY -> " ";
                };
                System.out.print(symbol);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-+-+-");
        }
        System.out.println();
    }
    
    public boolean isFirstPlayerTurn(){
      return isFirstPlayerTurn;
    }
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.println("Play against computer? (y/n)");
        boolean vsComputer = scanner.nextLine().toLowerCase().startsWith("y");
        
        boolean playerFirst = true;
        if (vsComputer) {
            System.out.println("Do you want to go first? (y/n)");
            playerFirst = scanner.nextLine().toLowerCase().startsWith("y");
        }
        
        TicTacToe game = new TicTacToe(vsComputer, playerFirst);
        
        while (true) {
            game.printBoard();
            
            if (game.checkWin()) {
                System.out.println((game.isFirstPlayerTurn() ? "Player O" : "player X") + " wins!");
                break;
            }
            
            if (game.isDraw()) {
                System.out.println("It's a draw!");
                break;
            }
            
            System.out.println("Player " + (game.isFirstPlayerTurn() ? "X" : "O") + "'s turn");
            System.out.println("Enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.println("Enter column (0-2): ");
            int col = scanner.nextInt();
            
            if (!game.makeMove(row, col)) {
                System.out.println("Invalid move! Try again.");
            }
        }        
    }
}


enum CellState {
    X, O, EMPTY
}
