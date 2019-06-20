import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProspectedMetalsTest {

	// UNIT TEST FOR METHOD find_gold(prospector)
	// Equivalence class:
	// seed = x -> returns find_gold(x)
	@Test
	void findGoldTest() {
		Town mockVirginiaCity = new Town("Virginia City", 3, 3);
		Prospector mockProspector = new Prospector(0);
		mockProspector.currentTown = mockVirginiaCity;
		Game mockGame = new Game(204, 0);
		assertEquals(2, mockGame.findGold(mockProspector, mockVirginiaCity.gold));
	}

	// UNIT TEST FOR METHOD find_silver(prospector)
	// Equivalence class:
	// seed = x -> returns find_silver(x)
	@Test
	void findSilverTest() {
		Town mockVirginiaCity = new Town("Virginia City", 3, 3);
		Prospector mockProspector = new Prospector(0);
		mockProspector.currentTown = mockVirginiaCity;
		Game mockGame = new Game(6, 0);
		assertEquals(2, mockGame.findSilver(mockProspector, mockVirginiaCity.silver));
	}
	
	// UNIT TESTS FOR METHOD next_town
	// Equivalence classes:
	@Test
	void test_next_town() {
	    Game mockgame = new Game(0, 0);
	    Town toledo = new Town("Toledo", 4, 3);
	    Town t1 = new Town("Toledo", 0, 0);
	    Town t2 = new Town("Toledo", 0, 0);
	    Town t3 = new Town("Toledo", 0, 4);
	    toledo.addNeighbor(t1);
	    toledo.addNeighbor(t2);
	    toledo.addNeighbor(t3);
	    Town next_t = mockgame.nextTown(toledo);
	    assertEquals(next_t, t1);
	    }
	
	@Test
	void getMoneyTest() {
		Town mockVirginiaCity = new Town("Virginia City", 3, 3);
		Prospector mockProspector = new Prospector(0);
		mockProspector.currentTown = mockVirginiaCity;
		mockProspector.getMoney(3, 3);
		assertEquals(mockProspector.gold, 3);
		
	}


	
	  // UNIT TESTS FOR METHOD convert_to_money(prospector) // Equivalence classes:
	  // Digits up to hundredth decimal place = 123.45 -> returns
	  //"Heading home with $123.45." // No digits up to hundredth decimal place = 0
	  //-> returns "Heading home with $0.00."
	  
	  // test conversion from precious metals to USD 
	@Test
	void convertToMoneyTest(){
		  Prospector mockProspector = new Prospector(0);
		  mockProspector.silver = 11;
		mockProspector.gold = 32;
	    Game mockgame = new Game(0, 0);
	    String muns = mockgame.convertToMoney(mockProspector);
	    assertEquals("Heading home with $675.85.", muns);
	  }
	 

	// ensure that converted money always has two decimal places
	// EDGE CASE
	@Test
	void convertToMoneyZeroTest(){
		  Prospector mockProspector = new Prospector(0);
		  mockProspector.silver = 0;
		mockProspector.gold = 0;
	    Game mockgame = new Game(0, 0);
	    String muns = mockgame.convertToMoney(mockProspector);
	    assertEquals("Heading home with $0.00.", muns);
	  }

}
