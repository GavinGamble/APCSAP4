import java.util.Scanner;

public class MarioLevel {
    private static final int LEVEL_WIDTH = 20;
    private static final int LEVEL_HEIGHT = 10;
    private static char[][] levelMap = new char[LEVEL_HEIGHT][LEVEL_WIDTH];
    private static int marioPositionX = 1;
    private static int marioPositionY = LEVEL_HEIGHT - 2;

    public static void main(String[] args) {
        initializeLevel();
        printLevel();
        playLevel();
    }

    private static void initializeLevel() {
        // Initialize the level map with characters representing elements
        for (int i = 0; i < LEVEL_HEIGHT; i++) {
            for (int j = 0; j < LEVEL_WIDTH; j++) {
                if (i == LEVEL_HEIGHT - 1 || j == 0 || j == LEVEL_WIDTH - 1) {
                    levelMap[i][j] = '#'; // Walls
                } else if (i == LEVEL_HEIGHT - 2 && (j == 1 || j == LEVEL_WIDTH - 2)) {
                    levelMap[i][j] = 'M'; // Mario
                } else {
                    levelMap[i][j] = ' '; // Empty space
                }
            }
        }
    }

    private static void printLevel() {
        // Print the level map
        for (int i = 0; i < LEVEL_HEIGHT; i++) {
            for (int j = 0; j < LEVEL_WIDTH; j++) {
                System.out.print(levelMap[i][j]);
            }
            System.out.println();
        }
    }

    private static void playLevel() {
        Scanner scanner = new Scanner(System.in);
        boolean gameFinished = false;

        while (!gameFinished) {
            System.out.print("Enter your move (a: left, d: right, w: jump): ");
            char move = scanner.next().charAt(0);

            // Update Mario's position based on the move
            switch (move) {
                case 'a':
                    moveMario(-1, 0);
                    break;
                case 'd':
                    moveMario(1, 0);
                    break;
                case 'w':
                    moveMario(0, -1);
                    break;
                default:
                    System.out.println("Invalid move!");
            }

            // Check if Mario reached the end
            if (marioPositionX == LEVEL_WIDTH - 2 && marioPositionY == LEVEL_HEIGHT - 2) {
                gameFinished = true;
                System.out.println("Congratulations! You finished the level!");
            } else {
                printLevel();
            }
        }

        scanner.close();
    }

    private static void moveMario(int deltaX, int deltaY) {
        // Move Mario to the new position if it's valid
        int newPosX = marioPositionX + deltaX;
        int newPosY = marioPositionY + deltaY;

        if (newPosX >= 1 && newPosX < LEVEL_WIDTH - 1 && newPosY >= 0 && newPosY < LEVEL_HEIGHT) {
            char destination = levelMap[newPosY][newPosX];
            if (destination == ' ') {
                levelMap[marioPositionY][marioPositionX] = ' '; // Clear the current position
                marioPositionX = newPosX;
                marioPositionY = newPosY;
                levelMap[marioPositionY][marioPositionX] = 'M'; // Move Mario to the new position
            } else {
                System.out.println("Cannot move there! Obstacle in the way.");
            }
        } else {
            System.out.println("Cannot move there! Out of bounds.");
        }
    }
}
