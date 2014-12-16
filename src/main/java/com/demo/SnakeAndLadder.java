package com.demo;
import java.util.HashMap;
import java.util.Random;

/**
 * Snake and Ladder Game
 * 
 * @author ashish
 *
 */
public class SnakeAndLadder {
	
	private int players;
	private int position[];	
	private HashMap<Integer, Integer> ladders; // ladders starting and ending point
	private HashMap<Integer, Integer> snakes;
	
	public SnakeAndLadder(int noOfPlayers, HashMap<Integer, Integer> ladders2,
			HashMap<Integer, Integer> snakes2) {
		this.players = noOfPlayers;  
		this.position = new int[noOfPlayers];
		this.ladders = ladders2;
		this.snakes = snakes2; 
	}

	public void startGame() {
		// run the game until any player wins
		loop();			
	}

	public static int rollDie() {
		Random rand = new Random();
		return 1 + rand.nextInt(12);
	}

	public void loop() {
		int player = 0;
		while (!hasAnyPlayerWon()) {

			// roll dice for player i
			// move position of player i to new position j
			// if new position has any ladder or snake, move to new position
			// next players turn
			int roll = rollDie();
			System.out.println("Player " + (player + 1) + " rolled " + roll);

			moveToPosition(player, position[player] + roll);

			if (isNewPositionALadder(position[player])) {
				System.out.println("You hit a ladder! your new position is "
						+ ladders.get(position[player]));
				moveToPosition(player, ladders.get(position[player]));
			} else if (isNewPositionASnake(position[player])) {
				System.out
						.println("Oops, hit by a snake! your new position is "
								+ snakes.get(position[player]));
				moveToPosition(player, snakes.get(position[player]));
			}

			System.out.println("Player " + (player + 1) + " is now at "
					+ position[player]);

			player = (1 + player) % players;
		}
	}

	/**
	 * Move position of Player 'player' ahead by roll
	 * 
	 * @param player
	 * @param roll
	 * @return new position of player
	 */
	public void moveToPosition(int player, int roll) {
		position[player] = roll;
	}

	public boolean hasAnyPlayerWon() {
		int player = 0;
		while (player < players) {
			if (hasPlayerWon(position[player])) {
				System.out.println("WINNER: Player " + (player + 1));
				return true;
			}
			++player;
		}
		return false;
	}

	public boolean isNewPositionALadder(int position) {
		if (ladders.containsKey(position))
			return true;
		return false;
	}

	public boolean isNewPositionASnake(int position) {
		if (snakes.containsKey(position))
			return true;
		return false;
	}

	public boolean hasPlayerWon(int position) {
		if(position >= 100)
			return true;	
		return false;
	}


}
