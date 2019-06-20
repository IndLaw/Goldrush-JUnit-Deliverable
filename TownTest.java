import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

/**
 * @author inl11
 *
 */
class TownTest {

	// This test ensures town objects Town class properly initializes
	@Test
	public void initTown() {
		Town toledo = new Town("Toledo", 0, 0);
		assertTrue(toledo instanceof Town);

	}

	// checks town name
	@Test
	public void townName() {
		Town toledo = new Town("Toledo", 0, 0);
		assertEquals(toledo.name, "Toledo");

	}

	// -----------------------------------------------------------------------------------------
	// UNIT TESTS FOR METHOD add_neighbor
	// Equivalence classes:
	// argument = string -> returns true
	// argument = nil -> returns false
	// ----------------------------------------------------------------------------------------

	// If a string is provided as an argument to add_neighbor(), then true is
	// returned
	@Test
	public void testAddNeighbor() {
		Town toledo = new Town("Toledo", 0, 0);
		Town shack = new Town("Shack Shanty", 0, 0);
		boolean success = toledo.addNeighbor(shack);
		assertEquals(true, success);
	}

	// Test case of add null value
	@Test
	public void testAddNeighborNull() {
		Town toledo = new Town("Toledo", 0, 0);
		Town nullTown = new Town("", 0, 0);
		boolean success = toledo.addNeighbor(nullTown);
		assertEquals(false, success);
	}

	// Test amount of gold in town
	@Test
	public void testGoldAmount() {
		Town toledo = new Town("Toledo", 4, 3);
		assertEquals(toledo.gold, 4);
	}

	// Test amount of silver in town
	@Test
	public void testSilverAmount() {
		Town toledo = new Town("Toledo", 4, 3);
		assertEquals(toledo.silver, 3);
	}

}
