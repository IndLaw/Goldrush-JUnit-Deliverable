package goldrush;

// Represents each instance of a town

import java.util.ArrayList;

// Stores town neighbors, gold, and silver
public class Town {

    ArrayList<Town> neighbors = new ArrayList<>();
    public String name;
    public int silver, gold;

    public Town(String name, int gold, int silver) {
        String Name = name;
        int Gold = gold;
        int Silver = silver;

    }

    public boolean addNeighbor(Town name) {
        if (!name.name.isEmpty()) {
                neighbors.add(name);
            return true;
        } else {
            return false;
        }

    }

}
