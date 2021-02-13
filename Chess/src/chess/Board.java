package chess;

/**
 * Represents a chess board
 * 
 * @author Ian Wong
 *
 */
public class Board {

    public static final int BOARD_LENGTH = 8;
    private Square[][] squares;

    /**
     * 
     */
    public Board() {
        squares = new Square[BOARD_LENGTH][BOARD_LENGTH];
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_LENGTH; j++) {
                addSquare(new Square(this, i, j));
            }
        }
    }

    /**
     * 
     * @param square
     */
    public void addSquare(Square square) {
        int x = square.getX();
        int y = square.getY();
        squares[x][y] = square;
    }

    public Square[][] getBoard() {
        return squares;
    }

    /**
     * Set up the board in standard configuration
     * 
     * @param white
     *              white player
     * @param black
     *              black player
     */
    public void setUpBoard(Player white, Player black) {
        // white pieces
        for (int i = 0; i < BOARD_LENGTH; i++) {
            new Pawn(white, squares[1][i]);
        }

        new Rook(white, squares[0][0]);
        new Rook(white, squares[0][7]);
        new Knight(white, squares[0][1]);
        new Knight(white, squares[0][6]);
        new Bishop(white, squares[0][2]);
        new Bishop(white, squares[0][5]);
        new Queen(white, squares[0][3]);
        new King(white, squares[0][4]);

        for (int i = 0; i < BOARD_LENGTH; i++) {
            new Pawn(black, squares[6][i]);
        }

        new Rook(black, squares[7][0]);
        new Rook(black, squares[7][7]);
        new Knight(black, squares[7][1]);
        new Knight(black, squares[7][6]);
        new Bishop(black, squares[7][2]);
        new Bishop(black, squares[7][5]);
        new Queen(black, squares[7][3]);
        new King(black, squares[7][4]);
    }

}
