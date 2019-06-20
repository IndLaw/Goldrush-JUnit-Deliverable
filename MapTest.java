import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapTest {

	//test that map object functions
	@Test
	void mapTypeTest() {
		Map m = new Map();
		assertTrue(m instanceof Map);
	}
	
	// test that current town equals null
	@Test
	void initNullCurrentTest() {
		Map m = new Map();
		assertEquals(m.current, null);
	}

	// test that start town equals null
	@Test
	void initNullStartTest() {
		Map m = new Map();
		assertEquals(m.startTown, null);
	}


	// UNIT TESTS FOR METHOD initialize
	// Equivalence classes: None
	// - No param passed in
	// - Do the same thing every time
	
	// check start and current town values after initialization
	// test that current town equals null
	// test that current town equals null
	@Test
	void initCurrentTest() {
		Map m = new Map();
		m.addNeighbors();
		assertEquals(m.current, null);
	}

	// test that start town equals null
	@Test
	void initStartTest() {
		Map m = new Map();
		m.addNeighbors();
		assertEquals(m.startTown, null);
	}
	

}
