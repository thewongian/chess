/**
 * 
 */
package chess;

/**
 * @author ian
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

}
