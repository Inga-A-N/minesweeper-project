package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Grid {
    
    public Grid() {
    String[][]twoDGrid = new String[10][10];
    
    	int x, y;
	Random randomGenerator=new Random();
	
	for (int i = 0; i < twoDGrid.length; i++){
	    for (int j = 0; j < twoDGrid[0].length; j++) {
	    
		twoDGrid[i][j]= "*";
		
		}
	}
	
	int counter = 0;
		
	while(counter < 10) {
         
    	    	x = randomGenerator.nextInt(10);
        	y = randomGenerator.nextInt(10);
    		    		
    		if (twoDGrid[x][y] != "b") {
    		twoDGrid[x][y] = "b";
    		   counter++;
    		   System.out.printf("%s, %s\n", x, y);
    		}
    		
    	    }
    	    
    	    
	for (int i = 0; i<twoDGrid[0].length; i++) {
	    for (int j = 0; j<twoDGrid[0].length; j++) {
	        System.out.printf("[%s]", twoDGrid[i][j]);
	    }
	    System.out.println();
	} 
	
//	Displayed Grid
	
	System.out.println();
	System.out.println("Displayed Grid");
	String[][]twoDGridToDisplay = new String[10][10];
	    for (int i = 0; i < twoDGridToDisplay.length; i++){
		    for (int j = 0; j < twoDGridToDisplay[0].length; j++) {
		    
			twoDGridToDisplay[i][j]= "*";
			
			}
		}
	    for (int i = 0; i<twoDGridToDisplay[0].length; i++) {
		    for (int j = 0; j<twoDGridToDisplay[0].length; j++) {
		        System.out.printf("[%s]", twoDGridToDisplay[i][j]);
		    }
		    System.out.println();
		} 
	    
//	    User Input
	    
	Scanner userInput = new Scanner(System.in);
	boolean gameLost = false;
	int a, b;
	
	while(gameLost != true) {
		
	System.out.println("Please coordinate X");
	System.out.println();
	a = userInput.nextInt();
	
	System.out.println("Please coordinate Y");
	System.out.println();
	b = userInput.nextInt();
	
	if (twoDGrid[a][b] == "b") {
	    System.out.println("Game Lost!");
	    gameLost = true;
	}else {
	    int bombsAroundCounter = 0;
//	    for (int i = 0; i < 9; i++) {
//		
//	    }
	    if(a > 0 && b > 0 && twoDGrid[a-1][b-1]=="b") {
		bombsAroundCounter++;
	    }else if(a > 0 && twoDGrid[a-1][b]=="b"){
		bombsAroundCounter++;
	    }else if( a > 0 && b < 9 && twoDGrid[a-1][b+1]=="b"){
		bombsAroundCounter++;
	    }else if(b < 9 && twoDGrid[a][b+1]=="b"){
		bombsAroundCounter++;
	    }else if(a < 9 && b < 9 && twoDGrid[a+1][b+1]=="b"){
		bombsAroundCounter++;
	    }else if(a < 9 && twoDGrid[a+1][b]=="b"){
		bombsAroundCounter++;
	    }else if(a < 9 && b > 0 && twoDGrid[a+1][b-1]=="b"){
		bombsAroundCounter++;
	    }else if(b > 0 && twoDGrid[a][b-1]=="b"){
		bombsAroundCounter++;
	    }
	    
	    
	    twoDGridToDisplay[a][b] = String.valueOf(bombsAroundCounter);
	    GridUtils.printDisplayGrid(twoDGridToDisplay);
	}
	
	}
	
	
	userInput.close();
    }
    
    
    
    
}
