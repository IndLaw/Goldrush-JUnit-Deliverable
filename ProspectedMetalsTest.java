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

	// UNIT TESTS FOR METHOD display_silver(prospector)
	// Equivalence classes:
	// prospector.silver != 1 -> returns "[prospector.silver] ounces of silver."
	// prospector.silver = 1 -> returns "[prospector.silver] ounce of silver."

	// assure silver ounce is plural
	/*
	 * @Test void test_display_mulitple_silver() { Prospector mockProspector = new
	 * Prospector(0); mockProspector.silver = 7; Game mockGame = new Game(0, 0);
	 * assertEquals("\t7 ounces of silver.",
	 * mockGame.displaySilver(mockProspector)); }
	 * 
	 * // assure silver ounce is singular // EDGE CASE def
	 * test_display_single_silver mock_prospector = Prospector.new(nil)
	 * mock_prospector.silver = 1 mock_game = Game.new(0, nil) assert_equal
	 * "\t1 ounce of silver.", mock_game.display_silver(mock_prospector) end
	 * 
	 * 
	 * // UNIT TESTS FOR METHOD display_gold(prospector) // Equivalence classes: //
	 * prospector.gold != 1 -> returns "[prospector.gold] ounces of gold." //
	 * prospector.gold = 1 -> returns "[prospector.gold] ounce of gold."
	 * 
	 * // assure gold ounce is plural 
	 * def test_display_mulitple_gold 
	 * mock_prospector = Prospector.new(nil) mock_prospector.gold = 8 mock_game = Game.new(0, nil)
	 * assert_equal "\t8 ounces of gold.", mock_game.display_gold(mock_prospector)
	 * end
	 * 
	 * // assure gold ounce is singular // 
	 * EDGE CASE def test_display_single_gold
	 * mock_prospector = Prospector.new(nil) mock_prospector.gold = 1 mock_game =
	 * Game.new(0, nil) assert_equal "\t1 ounce of gold.",
	 * mock_game.display_gold(mock_prospector) end
	 * 
	 */
	
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
