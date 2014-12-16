package com.demo;

import java.util.HashMap;

public class StartGame {
	
	private static final int DEFAULT_NUMBER_OF_PLAYERS = 2;
	
	public static void main(String[] args) {

		HashMap<Integer, Integer> snakes = new HashMap<Integer, Integer>();
		snakes.put(24, 1);
		snakes.put(55, 13);
		snakes.put(71, 29);
		snakes.put(88, 67);
		snakes.put(99, 6);

		HashMap<Integer, Integer> ladders = new HashMap<Integer, Integer>();
		ladders.put(8, 31);
		ladders.put(42, 81);
		ladders.put(66, 87);

		// initialize the board with N(numbers of players, ladders set, snakes
		// set)
		SnakeAndLadder snakeAndLadder = new SnakeAndLadder(DEFAULT_NUMBER_OF_PLAYERS, ladders, snakes);
		snakeAndLadder.startGame();
	}

}
