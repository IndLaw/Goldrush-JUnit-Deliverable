package goldrush;

// similar to a graph class with Town.java as a node class
public class Map {

    public Town startTown, current;
    Town sutterCreek = new Town("Sutter Creek", 0, 2);
    Town coloma = new Town("Coloma", 0, 3);
    Town angelsCamp = new Town("Angels Camp", 0, 4);
    Town nevadaCity = new Town("Nevada City", 0, 5);
    Town virginiaCity = new Town("Virginia City", 3, 3);
    Town midas = new Town("Midas", 5, 0);
    Town elDoradoCn = new Town("El Dorado Cn", 10, 0);

    public Map() {
        startTown = null;
        current = null;
    }

    // sets starting location
    public void setStart() {
        startTown = sutterCreek;
    }

    public void addNeighbors() {
        sutterCreek.addNeighbor(coloma);
        sutterCreek.addNeighbor(angelsCamp);
        coloma.addNeighbor(sutterCreek);
        angelsCamp.addNeighbor(sutterCreek);
        angelsCamp.addNeighbor(nevadaCity);
        angelsCamp.addNeighbor(virginiaCity);
        nevadaCity.addNeighbor(angelsCamp);
        virginiaCity.addNeighbor(coloma);
        virginiaCity.addNeighbor(angelsCamp);
        virginiaCity.addNeighbor(midas);
        virginiaCity.addNeighbor(elDoradoCn);
        midas.addNeighbor(virginiaCity);
        midas.addNeighbor(elDoradoCn);
        elDoradoCn.addNeighbor(virginiaCity);
        elDoradoCn.addNeighbor(midas);
    }
}
