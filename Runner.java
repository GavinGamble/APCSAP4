/*
 * Activity 2.5.2
 *
 * The runner for the PhraseSolverGame
 */
public class Runner
{
  public static void main(String[] args) 
  {
    Player p1 = new Player("Test Name");
    System.out.println("P1 Name:" + p1.name);
    
    Player p2 = new Player(p1);
    System.out.println("P1 Name:" + p1.name);
  
    System.out.println("P2 Name:" + p2.name);
  }

} 
