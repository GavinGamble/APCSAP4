import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoPlayerPong extends JFrame implements KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PADDLE_WIDTH = 20;
    private static final int PADDLE_HEIGHT = 100;
    private static final int PADDLE_SPEED = 8; // Adjusted speed
    private static final int BALL_SIZE = 20;
    private static final int BALL_SPEED = 5;

    private int playerOneY = HEIGHT / 2 - PADDLE_HEIGHT / 2;
    private int playerTwoY = HEIGHT / 2 - PADDLE_HEIGHT / 2;
    private int ballX = WIDTH / 2 - BALL_SIZE / 2;
    private int ballY = HEIGHT / 2 - BALL_SIZE / 2;
    private int ballXSpeed = BALL_SPEED;
    private int ballYSpeed = BALL_SPEED;

    public TwoPlayerPong() {
        setTitle("Two Player Pong");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        setVisible(true);

        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            update();
            repaint();
            try {
                Thread.sleep(10); // Adjust to control the game's speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        // Move the ball
        ballX += ballXSpeed;
        ballY += ballYSpeed;

        // Ball collision with top and bottom walls
        if (ballY <= 0 || ballY >= HEIGHT - BALL_SIZE) {
            ballYSpeed *= -1;
        }

        // Ball collision with paddles
        if (ballX <= PADDLE_WIDTH && ballY + BALL_SIZE >= playerOneY && ballY <= playerOneY + PADDLE_HEIGHT) {
            ballXSpeed *= -1;
        }
        if (ballX >= WIDTH - PADDLE_WIDTH - BALL_SIZE && ballY + BALL_SIZE >= playerTwoY && ballY <= playerTwoY + PADDLE_HEIGHT) {
            ballXSpeed *= -1;
        }

        // Ball collision with left and right walls
        if (ballX <= 0 || ballX >= WIDTH - BALL_SIZE) {
            // Reset the ball position
            ballX = WIDTH / 2 - BALL_SIZE / 2;
            ballY = HEIGHT / 2 - BALL_SIZE / 2;
            // Reset ball speed
            ballXSpeed = BALL_SPEED;
            ballYSpeed = BALL_SPEED;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        g.fillRect(PADDLE_WIDTH, playerOneY, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(WIDTH - PADDLE_WIDTH * 2, playerTwoY, PADDLE_WIDTH, PADDLE_HEIGHT);
        g.fillRect(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W && playerOneY > 0) {
            playerOneY -= PADDLE_SPEED;
        } else if (keyCode == KeyEvent.VK_S && playerOneY < HEIGHT - PADDLE_HEIGHT) {
            playerOneY += PADDLE_SPEED;
        } else if (keyCode == KeyEvent.VK_UP && playerTwoY > 0) {
            playerTwoY -= PADDLE_SPEED;
        } else if (keyCode == KeyEvent.VK_DOWN && playerTwoY < HEIGHT - PADDLE_HEIGHT) {
            playerTwoY += PADDLE_SPEED;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new TwoPlayerPong();
    }
}

