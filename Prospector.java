//prospector class
public class Prospector {

    public int visits;
    public int ID;
    public Town currentTown;
    public int gold;
    public int silver;

    public Prospector(int id) {
        int ID = id;
        visits = 0;
        gold = 0;
        silver = 0;
        currentTown = null;

    }

    public void visitCity() {
        visits += 1;
    }

    public void getMoney(int Silver, int Gold) {
        silver += Silver;
        gold += Gold;
    }
}
