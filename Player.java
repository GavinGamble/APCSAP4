/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  private String name = ""; 
  private double points;
  /* your code here - attributes */

  /* your code here - constructor(s) */ 
  public player(String inputName)
  {
    System.out.println("Enter player name.");
    Scanner sc = new Scanner(System.in);
    String newName = sc.nextLine();
    name = newName;
    System.out.println("Hello and welcome to the game, " + name);
    name = newName;
    points = 0;
  }
public String getName()
 {
   return name;
 }
public void setName(String x)
 {
   name = x;
 }
 public double getPoints()
 {
   return points;
 }
  /* your code here - accessor(s) */ 

  /* your code here - mutator(s) */ 
}