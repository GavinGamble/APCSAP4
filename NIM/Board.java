import java.util.Random;

public class Board 
{
    private int pileSize;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private int moveCount;

    public Board(Player player1, Player player2) 
    {
        this.player1 = player1;
        this.player2 = player2;
        Random random = new Random();
        pileSize = random.nextInt(41) + 10; // Random pile size between 10 and 50
        currentPlayer = random.nextBoolean() ? player1 : player2; // Randomly choose starting player
    }

    public void takeTurn(int piecesTaken) 
    {
        pileSize -= piecesTaken;
        currentPlayer = (currentPlayer == player1) ? player2 : player1; // Switch player
        moveCount++;
    }

    public boolean isGameOver() 
    {
        return pileSize <= 1;
    }

    public String getWinner() 
    {
        return (currentPlayer == player1) ? player2.getName() : player1.getName();
    }

    public int getPileSize() 
    {
        return pileSize;
    }

    public int getMoveCount() 
    {
        return moveCount;
    }

    public Player getCurrentPlayer() 
    {
        return currentPlayer;
    }
}
