import java.util.Scanner;

public class NimGame
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Game Of Nim!");

        // Get players' names
        System.out.print("Enter Player One Name: ");
        Player player1 = new Player(scanner.nextLine());
        System.out.print("Enter Player Two Name: ");
        Player player2 = new Player(scanner.nextLine());

        boolean playAgain = true;

        while (playAgain) 
        {
            Board gameLogic = new Board(player1, player2);

            System.out.println("\nStarting Size: " + gameLogic.getPileSize());

            // Game loop
            while (!gameLogic.isGameOver()) 
            {
                System.out.println("\nCurrent Size: " + gameLogic.getPileSize());
                System.out.println(gameLogic.getCurrentPlayer().getName() + "'s turn.");

                int maxMove = Math.min(gameLogic.getPileSize() / 2, gameLogic.getPileSize() - 1); // Maximum pieces player can take
                System.out.print("How many pieces are you taking? (1-" + maxMove + "): ");
                int piecesTaken = scanner.nextInt();

                if (piecesTaken < 1 || piecesTaken > maxMove) 
                {
                    System.out.println("No, You can  only take between 1 and " + maxMove + " pieces.");
                    continue;
                }

                gameLogic.takeTurn(piecesTaken);
            }

            // Announce winner
            System.out.println("\nGame over!");
            System.out.println("Winner: " + gameLogic.getWinner());
            System.out.println("Number of moves: " + gameLogic.getMoveCount());

            // Ask if players want to play again
            System.out.print("\nWould you like to go again? (Yes/No): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing Nim!");
        scanner.close();
    }
}
