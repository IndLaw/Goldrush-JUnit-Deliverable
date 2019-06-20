// similar to a graph class with Town.java as a node class
public class Map {

    public Town startTown, current;
    Town sutterCreek = new Town("Sutter Creek", 2, 0);
    Town coloma = new Town("Coloma", 3, 0);
    Town angelsCamp = new Town("Angels Camp", 4, 0);
    Town nevadaCity = new Town("Nevada City", 5, 0);
    Town virginiaCity = new Town("Virginia City", 3, 3);
    Town midas = new Town("Midas", 0, 5);
    Town elDoradoCn = new Town("El Dorado Cn", 0, 10);

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
