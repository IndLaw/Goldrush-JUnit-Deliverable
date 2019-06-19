/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldrush;

import java.util.Random;

public class Game {
    public Map map;
    public int Propectors;
    Random rand;

    public Game(int seed, int prospectors) {
        map = null;
        Propectors = prospectors;
        rand = new Random(seed);
        
    }

    // initialize map
    public void start() {
        map = new Map();
        map.addNeighbors();
        map.setStart();
    }

    public void nextTown(Town town, int random) {

    }

    // change current location of prospector and increment visit_city counter
    // -> example_game.move(prospector1, prospector1.neighbors[pick_neighbor(prospector1) - 1])
    public void move(Prospector prospector, Town neighbor) {
        prospector.currentTown = neighbor;
        prospector.visitCity();

    }

    public boolean checkTownsVisited(Prospector prospector) {
        return prospector.visits > 4;
    }

    // takes prospector as argument and returns pseudorandom amount of gold
    public int findGold(Prospector prospector, int random, int amt) {
        return rand.nextInt(amt + 1);
    }

    // takes prospector as argument and returns pseudorandom amount of silver
    public int findSilver(Prospector prospector, int random, int amt) {
        return rand.nextInt(amt + 1);
    }

    // takes prospector as argument and returns a string formatted with silver amount
    public void displaySilver(Prospector prospector) {
        if (prospector.silver != 1) {
            System.out.println(prospector.gold + " ounces of silver.");
        } else {
            System.out.println(prospector.gold + " ounce of silver.");
        }

    }

    // takes prospector as argument and returns a string formatted with gold amount
    public void displayGold(Prospector prospector) {
        if (prospector.gold != 1) {
            System.out.println(prospector.gold + " ounces of gold.");
        } else {
            System.out.println(prospector.gold + " ounce of gold.");
        }

    }

    // add prospector's silver and gold and round up to 2 decimal places
    public void convertToMoney(Prospector prospector) {
        double num = (prospector.silver * 1.31) + (prospector.gold * 20.67);
        System.out.println("Heading home with " + String.format("%.2f", num));
    }

}
