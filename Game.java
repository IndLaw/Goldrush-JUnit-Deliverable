import java.util.Random;

public class Game {
	public Map map;
	public int numProspectors;
	Random rand;
	public Town currentTown;
	public int runs;

	public Game(int seed, int prospectors) {
		map = null;
		numProspectors = prospectors;
		rand = new Random(seed);

	}

	// initialize map
	public void start() {
		map = new Map();
		map.addNeighbors();
		map.setStart();
		run();
	}

	public int run() {
		runs = 0;
		for (int i = 0; i < numProspectors; i++) {
			Prospector prospector;
			map.current = map.startTown;
			runPros(prospector = new Prospector(i), i);
			runs++;
			System.out.println("");
		}
		return runs;
	}

	public Town nextTown(Town town) {
		int i = rand.nextInt(town.neighbors.size());
		return town.neighbors.get(i);

	}

	public void runPros(Prospector currentProspector, int i) {
		int j = i + 1;
		int days = 0;
		System.out.println("Prospector " + (j) + " starting in Sutter Creek.");
		while (!checkTownsVisited(currentProspector)) {
			days++;
			currentTown = map.current;
			int silver = findSilver(currentProspector, map.current.silver);
			int gold = findGold(currentProspector, map.current.gold);
			currentProspector.getMoney(silver, gold);
			dailyPrint(silver, gold);

			if (!stay(currentProspector, silver, gold)) {
				map.current = nextTown(map.current);
				move(currentProspector, map.current);
				
				if(currentProspector.visits != 5) {
				printMove(currentProspector, currentTown, map.current);
				// print prospector location unless done
				}
			}

		}
		System.out.println("After " + days + "days Prospector #" + j + "returned to San Francisco with:");
		System.out.println(currentProspector.gold + "ounces of gold.");
		System.out.println(currentProspector.silver + "ounces of silver.");
		convertToMoney(currentProspector);

	}

	// change current location of prospector and increment visit_city counter
	// -> example_game.move(prospector1,
	// prospector1.neighbors[pick_neighbor(prospector1) - 1])
	public void move(Prospector prospector, Town neighbor) {
		prospector.currentTown = neighbor;
		prospector.visitCity();

	}

	public boolean stay(Prospector prospector, int silver, int gold) {
		if (prospector.visits <= 3 && (gold > 0 || silver > 0)) {
			return true;
		} else if (prospector.visits > 3 && (gold > 1 || silver > 2)) {
			return true;
		} else {
			return false;
		}
	}

	public void dailyPrint(int silver, int gold) {
		if (silver == 0 && gold == 0) {
			System.out.println("\tFound no precious metals in " + currentTown.name + ".");
		} else {
			if (silver > 0) {
				if (silver == 1) {
					System.out.println("\tFound 1 ounce of silver in " + currentTown.name);
				} else {
					System.out.println("\tFound " + silver + " ounces of silver in " + currentTown.name);
				}
			}
			if (gold > 0) {
				if (gold == 1) {
					System.out.println("\tFound 1 ounce of gold in + " + currentTown.name + ".");
				} else {
					System.out.println("\tFound " + gold + " ounces of gold in " + currentTown.name);
				}
			}
		}
	}

	// print location change of prospector
	public void printMove(Prospector prospector, Town current, Town destination) {
		System.out.println("Heading from " + current.name + " to " + destination.name + ".");
	}

	// return true if prospector has visited 5 locations
	public boolean checkTownsVisited(Prospector prospector) {
		return prospector.visits > 4;
	}

	// takes prospector as argument and returns pseudorandom amount of gold
	public int findGold(Prospector prospector, int amt) {
		return rand.nextInt(amt + 1);
	}

	// takes prospector as argument and returns pseudorandom amount of silver
	public int findSilver(Prospector prospector, int amt) {
		return rand.nextInt(amt + 1);
	}



	// add prospector's silver and gold and round up to 2 decimal places
	public String convertToMoney(Prospector prospector) {
		double num = (prospector.silver * 1.31) + (prospector.gold * 20.67);
		String string = "Heading home with $" + String.format("%.2f", num) + ".";
		System.out.println(string);
		return string;
	}

}
