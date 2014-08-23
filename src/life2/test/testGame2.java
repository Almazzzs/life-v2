package life2.test;

import static org.junit.Assert.*;
import life2.Game2;
import life2.Game2Impl;

import org.junit.Assert;
import org.junit.Test;

public class testGame2 {
	int[][] stateNext = {{0,0,0,0,0},
			 			 {0,0,0,0,0},
			 			 {0,1,1,1,0},
			 			 {0,0,0,0,0},
			 			 {0,0,0,0,0}};
	
	int[][] state = {{0,0,0,0,0},
				   	 {0,0,1,0,0},
				   	 {0,0,1,0,0},
				   	 {0,0,1,0,0},
				   	 {0,0,0,0,0}};

	int[][] stateNeidhbours = {{0,1,1,1,0},
						       {0,2,1,2,0},
						       {0,3,2,3,0},
						       {0,2,1,2,0},
						       {0,1,1,1,0}};

	Game2 game =new Game2Impl();

	@Test
	public void testInit() {
		
		int[][] stateInit;
		
		game.init(state);
		
		stateInit = game.getState();
		
		Assert.assertArrayEquals(state, stateInit);
	}

	@Test
	public void testIterate() {
		
		int[][] stateNew;
		
		game.init(state);
		
		game.iterate();
		
		stateNew = game.getState();
		
		Assert.assertArrayEquals(stateNext, stateNew);
	}

	@Test
	public void testCalcAliveNeighbours() {
		
		int calc;
		
		game.init(state);
		
		calc = game.calcAliveNeighbours(2,2);
				
		Assert.assertEquals(2, calc);

		calc = game.calcAliveNeighbours(2,1);
		
		Assert.assertEquals(3, calc);

		calc = game.calcAliveNeighbours(0,0);
		
		Assert.assertEquals(0, calc);

	}
	
	@Test
	public void testAllNeighbours() {
		
		int calc;
		
		int[][] stateNew = new int[5][5];
		
		game.init(state);
		
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
			{
				calc = game.calcAliveNeighbours(i,j);
				stateNew[i][j] =calc;
				
			}
		
		Assert.assertArrayEquals(stateNeidhbours, stateNew);


	}

}
