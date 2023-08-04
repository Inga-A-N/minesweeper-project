package minesweeper;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner userInput = new Scanner(System.in);

    System.out.println("Please enter the desired height of the game field");
    int height = userInput.nextInt();

    System.out.println("Please enter the desired height of the game field");
    int width = userInput.nextInt();

    System.out.println(
      "Please enter the desired number of bombs on the game field"
    );
    int numberOfBombs = userInput.nextInt();

    if (numberOfBombs > height * width || numberOfBombs < 1) {
      System.out.println("Invalid number of bombs");
      System.out.println(
        "Please enter the desired number of bombs on the game field"
      );
      numberOfBombs = userInput.nextInt();
    }

    Grid initialGrid = new Grid(height, width, numberOfBombs);
  }
}
