package TicTacToeGame;

/**
 * Provides data fields and methods to create a Java data-type, representing a referree which establishes
 * key relationships between objects within the game, i.e. the players, and the board which is used. The referee
 * starts the game once these relationships are established .
 * @author Graydon Hall and Mohammad Moshirpour
 * @since 2021-09-21
 */
public class Referee {
    /**
     * Players in the game
     */
    Player xPlayer, oPlayer;

    /**
     * The board that players interact with to play the game
     */
    Board board;

    /**
     * Sets up the opponents for each player, displays the board, and then calls the first player (X player) to play.
     */
    public void runTheGame(){
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);
        board.display();
        xPlayer.play();
    };

    /**
     * Sets the game board object which will be used.
     * @param board
     */
    public void setBoard(Board board){
        this.board = board;
    };

    /**
     * Sets the player who will place Os on the board
     * @param oPlayer
     */
    public void setoPlayer(Player oPlayer){
        this.oPlayer = oPlayer;
    };

    /**
     * Sets the player who will place Xs on the board
     * @param oPlayer
     */
    public void setxPlayer(Player xPlayer){
        this.xPlayer = xPlayer;
    };
}
