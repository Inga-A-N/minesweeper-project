package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Grid {

  public Grid(int height, int width, int numberOfBombs) {
    String[][] twoDGrid = new String[height + 1][width + 1];

    int x, y;
    Random randomGenerator = new Random();

    for (int i = 0; i < twoDGrid.length; i++) {
      for (int j = 0; j < twoDGrid[0].length; j++) {
        twoDGrid[i][j] = "*";
      }
    }

    // Enumerating rows and columns
    GridUtils.enumeratingRowsAndColumns(twoDGrid);

    // Placing the bombs
    int counter = 0;

    while (counter < numberOfBombs) {
      x = randomGenerator.nextInt(1, height + 1);
      y = randomGenerator.nextInt(1, width + 1);

      if (twoDGrid[x][y] != "b") {
        twoDGrid[x][y] = "b";
        counter++;
        System.out.printf("%s, %s\n", x, y);
      }
    }

    for (int i = 0; i < twoDGrid.length; i++) {
      for (int j = 0; j < twoDGrid[i].length; j++) {
        System.out.printf("[%s]", twoDGrid[i][j]);
      }
      System.out.println();
    }

    //	Displayed Grid

    System.out.println();
    System.out.println("Displayed Grid");
    String[][] twoDGridToDisplay = new String[height + 1][width + 1];
    for (int i = 1; i < twoDGridToDisplay.length; i++) {
      for (int j = 1; j < twoDGridToDisplay[0].length; j++) {
        twoDGridToDisplay[i][j] = "*";
      }
    }
    //	    Enumerating rows and columns

    GridUtils.enumeratingRowsAndColumns(twoDGridToDisplay);

    //	    Filling the whole grid

    GridUtils.printDisplayGrid(twoDGridToDisplay);

    //	    User Input
    Scanner userInput = new Scanner(System.in);

    boolean gameLost = false;
    boolean gameWon = false;
    int a, b;

    while (gameLost != true && gameWon != true) {
      System.out.println("Please enter row number");
      System.out.println();
      a = userInput.nextInt();

      System.out.println("Please enter column number");
      System.out.println();
      b = userInput.nextInt();

      if ((a < 1 || a > height + 1) || (b < 1 || b > width + 1)) {
        System.out.println(
          "One or both coordinates are out of range, please enter integers in the range 1 to 10."
        );
        continue;
      }

      if (twoDGrid[a][b] == "b") {
        System.out.println("Game Lost!");
        GridUtils.printDisplayGrid(twoDGrid);
        gameLost = true;
      } else {
        int bombsAroundCounter = 0;

        if (a > 1 && b > 1 && twoDGrid[a - 1][b - 1] == "b") {
          bombsAroundCounter++;
        }
        if (a > 1 && twoDGrid[a - 1][b] == "b") {
          bombsAroundCounter++;
        }
        if (
          a > 1 &&
          b < twoDGridToDisplay[0].length - 1 &&
          twoDGrid[a - 1][b + 1] == "b"
        ) {
          bombsAroundCounter++;
        }
        if (b < twoDGridToDisplay[0].length - 1 && twoDGrid[a][b + 1] == "b") {
          bombsAroundCounter++;
        }
        if (
          a < twoDGridToDisplay.length - 1 &&
          b < twoDGridToDisplay[0].length - 1 &&
          twoDGrid[a + 1][b + 1] == "b"
        ) {
          bombsAroundCounter++;
        }
        if (a < twoDGridToDisplay.length - 1 && twoDGrid[a + 1][b] == "b") {
          bombsAroundCounter++;
        }
        if (
          a < twoDGridToDisplay.length - 1 &&
          b > 1 &&
          twoDGrid[a + 1][b - 1] == "b"
        ) {
          bombsAroundCounter++;
        }
        if (b > 1 && twoDGrid[a][b - 1] == "b") {
          bombsAroundCounter++;
        }

        twoDGridToDisplay[a][b] = String.valueOf(bombsAroundCounter);
        GridUtils.printDisplayGrid(twoDGridToDisplay);
      }

      int countingOpenSquares = 0;

      for (int i = 1; i < twoDGridToDisplay.length; i++) {
        for (int j = 1; j < twoDGridToDisplay[i].length; j++) {
          if (twoDGridToDisplay[i][j] != "*") {
            countingOpenSquares++;
          }
        }
      }

      System.out.println("Open squares " + countingOpenSquares);

      if (countingOpenSquares == width * height - numberOfBombs) {
        System.out.println("You WON!");
        gameWon = true;
      }
    }

    userInput.close();
  }
}
