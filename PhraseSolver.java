/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
 private String name = new String(); 
 private double pointsBanked;
 private double pointsEarned;
 
 public String getName()
 {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Player Name:"); 
    String newName = sc.nextLine();
    while (newName.length() > 10)
    {
      System.out.println("Entry too long, Enter Player Name:");
      newName = sc.nextLine();
    }
    
    name = newName;
    return name;
 }
 
 public void setName(String x)
 {
   name = x;
 }
  
 public double getPointsEarned()
 {
   return pointsEarned;
 }
  
} 
