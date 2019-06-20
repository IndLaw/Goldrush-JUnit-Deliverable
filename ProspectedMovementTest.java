import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// unit tests for prospector neighbor selection and movement
class ProspectedMovementTest {



	// UNIT TEST FOR METHOD add_neighbor(town)
	// Equivalence classes:
	// Neighboring Town can be accessed if != nil

	// Ensure neighbor is accessible
	@Test
	void test_neighbor() {
		Town mockVirginiaCity = new Town("Virginia City", 0, 0);
		Town mockColoma = new Town("Coloma", 0, 0);
		mockVirginiaCity.addNeighbor(mockColoma);
		assertTrue(mockVirginiaCity.neighbors.contains(mockColoma));
	}

	// UNIT TESTS FOR METHOD move(prospector, city)
	// If move() is called, Prospector.visits += 1
	// If move() is called, Prospector.cur_town = city

	// Test visited town incrementor
	@Test
	void test_move_incrementor() {
		Town mockVirginiaCity = new Town("Virginia City", 0, 0);
		Prospector mockProspector = new Prospector(0);
		Game mockGame = new Game(0, 0);
		mockGame.move(mockProspector, mockVirginiaCity);
		assertEquals(mockProspector.visits, 1);
	}

	// test that prospector moves to indicated town
	@Test
	void test_move_to_neighbor() {
		Town mockVirginiaCity = new Town("Virginia City", 0, 0);
		Prospector mockProspector = new Prospector(0);
		Game mockGame = new Game(0, 0);
		mockGame.move(mockProspector, mockVirginiaCity);
		assertEquals(mockProspector.currentTown, mockVirginiaCity);
	}


	// UNIT TESTS FOR METHOD check_towns_visited(prospector)
	// Equivalence classes:
	// towns_visited < 5 -> returns false
	// towns_visited = 5 -> returns true

	// ensure towns_visited returns false if visits < 5
	@Test
	void test_num_towns_visited_false() {
		Game mockGame = new Game(0, 0);
		Prospector mockProspector = new Prospector(0);
		assertFalse(mockGame.checkTownsVisited(mockProspector));
	  }

	// ensure towns_visited returns true if visits == 5
	// EDGE CASE
	@Test
	void test_num_towns_visited_true() {
		Game mockGame = new Game(0, 0);
		Town mockVirginiaCity = new Town("Virginia City", 0, 0);
		Prospector mockProspector = new Prospector(0);
	    for(int i = 0; i < 5; i++) {
	    	mockGame.move(mockProspector, mockVirginiaCity);
	    }
	    assertTrue(mockGame.checkTownsVisited(mockProspector));
	  }

}
