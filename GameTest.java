import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {



	@Test
	void stayOneVisitTest() {
		Game mockGame = new Game(0, 0);
		Prospector mockProspector = new Prospector(0);
		mockProspector.visits = 0;
		assertTrue(mockGame.stay(mockProspector, 1, 1));
		
	}
	
	@Test
	void stayManyVisitTest() {
		Game mockGame = new Game(0, 0);
		Prospector mockProspector = new Prospector(0);
		mockProspector.visits = 4;
		assertTrue(mockGame.stay(mockProspector, 2, 3));
		
	}

	@Test
	void stayNoLuckTest() {
		Game mockGame = new Game(0, 0);
		Prospector mockProspector = new Prospector(0);
		mockProspector.visits = 2;
		assertFalse(mockGame.stay(mockProspector, 0, 0));
		
	}
	
	@Test
	void runTest() {
		Game mockGame = new Game(0, 5);
		mockGame.start();
		assertEquals(mockGame.runs, 5);
		
	}
}
