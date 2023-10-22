package lk.ijse.dep.service;

public interface Board {
    public static final int NUM_OF_ROWS = 5 ;
    public static final int NUM_OF_COLS = 6 ;

    public  BoardUI getBoardUI();

    public   int  findNextAvailableSpot(int col);

    public boolean isLegalMove(int col);

    public  boolean existLegalMoves();

    public  void updateMove(int col,Piece move);

    public void updateMove(int col , Piece move , int col2);

    public  Winner findWinner();
}
