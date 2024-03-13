/*
 * Activity 2.5.2
 *
 * The runner for the PhraseSolverGame
 */
public class Runner
{
  public Runner()
  {

  }
  public static void main(String[] args) 
  {
    PhraseSolver p = new PhraseSolver(); 
    p.play();
    Player PlayerOne = new Player();
    System.out.println(PlayerOne.getName());
    System.out.println(PlayerOne.getPoints());
    Player PlayerTwo = new Player();
    System.out.println(PlayerTwo.getName());
    System.out.println(PlayerTwo.getPoints());
  }
 
} 
