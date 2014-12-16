package com.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class SnakeAndLadderTest {
	
	SnakeAndLadder s;
	
	@Before
	public void init(){
		
		HashMap<Integer, Integer> snakes = new HashMap<Integer, Integer>();
		snakes.put(24, 1);
		snakes.put(55, 13);
		snakes.put(71, 29);
		snakes.put(88, 67);
		snakes.put(99, 6);

		HashMap<Integer, Integer> ladders = new HashMap<Integer, Integer>();
		ladders.put(8, 31);
		ladders.put(15, 97);
		ladders.put(42, 81);
		ladders.put(66, 87);
		
		s = new SnakeAndLadder(2, ladders, snakes);
	}
	
	
	@Test
	public void testHasPlayerWonGivenPositionGreaterThan100() {
		assertTrue(s.hasPlayerWon(104));
	}
	
	@Test
	public void testHasPlayerWonGivenPositionLessThan100() {
		assertFalse(s.hasPlayerWon(98));
	}
	
	@Test
	public void testIsNewPositionALadderGivenALadderPosition(){
		assertTrue(s.isNewPositionALadder(8));
		assertTrue(s.isNewPositionALadder(15));
	}

	@Test
	public void testIsNewPositionALadderGivenANonLadderPosition(){
		assertFalse(s.isNewPositionALadder(6));
		assertFalse(s.isNewPositionALadder(51));
	}
	
	@Test
	public void testIsNewPositionASnakeGivenASnakePosition(){
		assertTrue(s.isNewPositionASnake(88));
		assertTrue(s.isNewPositionASnake(99));
	}

	@Test
	public void testIsNewPositionASnakeGivenANonLadderPosition(){
		assertFalse(s.isNewPositionASnake(6));
		assertFalse(s.isNewPositionASnake(51));
	}
}
