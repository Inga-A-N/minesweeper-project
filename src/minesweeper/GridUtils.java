package minesweeper;

import java.util.Random;

public class GridUtils {
    
    public static int[] randomArray() {
	int[] randomCoordinatesArray = new int[10];
	
	Random randomGenerator=new Random();
    for (int i = 0; i < 10; i++) {
	randomCoordinatesArray[i] = randomGenerator.nextInt(10);
	
    }
    return randomCoordinatesArray;
    }
    
    public static void printDisplayGrid(String [][] grid) {
	    for (int i = 0; i<grid[0].length; i++) {
		    for (int j = 0; j<grid[0].length; j++) {
		        System.out.printf("[%s]", grid[i][j]);
		    }
		    System.out.println();
		} 
	    }
}
