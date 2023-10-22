package lk.ijse.dep.service;

public class AiPlayer extends Player {
    public int count1;
    public AiPlayer(Board board) {
        super(board);
    }

    public void movePiece(int col) {
        col = selectedColumn();
        this.board.updateMove(col, Piece.GREEN);
        this.board.getBoardUI().update(col, false);
        Winner winner = this.board.findWinner();
        if (winner.getWinningPiece() != Piece.EMPTY) {
            this.board.getBoardUI().notifyWinner(winner);
        } else if (!this.board.existLegalMoves()) {
            this.board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }
    }

    private int selectedColumn() {
        int col = 0;
        do {
            col = (int) (Math.random() * 6);
        }while (!this.board.isLegalMove(col));
        count1 = 0;
        // there is legal move, return column
        return col;
    }

    public int minmaxMethod(int a , int b){
        count1++;
        System.out.println("minimax operation count id "+count1);
        Winner winner = this.board.findWinner();//checks if there is a winner or game over situation in the game
        if (winner.getWinningPiece() == Piece.GREEN) {//checking whether the winning pieces is green,
            return 1;//if the value
        }
        if (winner.getWinningPiece() == Piece.BLUE) {
            return -1;//user will win
        }
//        if ((!this.board.existLegalMoves()) || (b == 2)) {
//            return 0;//this will return the value when only the depth is equals to 2 and are legal moves on the board
//        }
        return 0;
    }


}