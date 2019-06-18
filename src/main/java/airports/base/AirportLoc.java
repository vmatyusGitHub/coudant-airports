package airports.base;

/**
 * Location of an Airport
 */
public class AirportLoc extends Location implements Comparable {
    private String name;
    private double distance;

    AirportLoc(float lat, float lon, String name, float distance) {
        super(lat, lon);
        this.name = name;
        this.distance = distance;
    }

    /**
     * Gets name of the airport
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the airport
     * @param name new name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets distance of the airport from a given location
     * @return value of distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets distance of the airport from a given location
     * @param distance new distance value
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", distance=" + distance +
                "}\n";
    }

    /**
     * Compares distance values. This is used in a sort function.
     * @param compTo the other item that is compared to the current item (this)
     * @return the difference of the two distance value
     */
    public int compareTo(Object compTo) {
        return Double.compare(this.distance, ((AirportLoc) compTo).getDistance());
    }
}
