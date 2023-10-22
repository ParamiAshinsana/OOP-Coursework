package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private final Piece[][] pieces;
    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        // All the pieces in the 2D array should be initialized to Piece.EMPTY inside the Constructor
        this.pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j <NUM_OF_ROWS ; j++) {
                this.pieces[i][j] = Piece.EMPTY;
            }
        }
        this.boardUI = boardUI;
    }

    @Override
    public BoardUI getBoardUI() {

        return this.boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if (this.pieces[col][i] == Piece.EMPTY) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if (this.pieces[col][i] == Piece.EMPTY) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existLegalMoves() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            if (isLegalMove(i)) {
                return true;
            }
        }
           return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        this.pieces[col][findNextAvailableSpot(col)] = move;
    }


    @Override
    public void updateMove(int col, Piece move , int row) {

        this.pieces[col][row] = move;
    }

    @Override
    public Winner findWinner() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            int count = 1;
            for (int j = 1; j < 5; j++) {
                if ((this.pieces[i][j] == this.pieces[i][(j-1)]) && (this.pieces[i][j] != Piece.EMPTY)) {
                    count++;
                    if (count == 4) {
                        return new Winner(this.pieces[i][j], i, j - 3, i, j);
                    }
                } else {
                    count = 1;
                }
            }
        }
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            int count = 1;
            for (int j = 1; j < NUM_OF_COLS; j++) {
                if ((this.pieces[j][i] == this.pieces[(j - 1)][i]) && (this.pieces[j][i] != Piece.EMPTY)) {
                    count++;
                    if (count == 4) {
                        return new Winner(this.pieces[j][i], j - 3, i, j, i);
                    }
                }else {
                    count = 1;
                }
            }
        }
        return new Winner(Piece.EMPTY);
    }

}
