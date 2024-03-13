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
 public Player(String inputName)
 {
  System.out.println("Enter Player Name: ");
  Scanner sc = new Scanner(System.in);
  String newName = sc.nextLine();

  name = newName;
  points = 0;
  System.out.println("Help and welcome to PhraseSolver " + name + "!");
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
  
} 