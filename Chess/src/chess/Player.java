/**
 * 
 */
package chess;

/**
 * Player class, has a color
 * 
 * unfinished
 * 
 * @author  Ian Wong
 * 
 * @version 2021.2.14
 *
 */
public class Player {

    private PlayerColor color;

    /**
     * 
     * @param playerColor
     */
    public Player(PlayerColor playerColor) {
        color = playerColor;
    }

    /**
     * 
     * @return
     */
    public PlayerColor getColor() {
        return color;
    }

    public boolean isWhite() {
        return getColor() == PlayerColor.WHITE;
    }

}
