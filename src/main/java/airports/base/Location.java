package airports.base;

/**
 * A Location stands from latitude and longitude attributes.
 */
public class Location {
    protected float lat;
    protected float lon;

    /**
     * The default constructor generate Location with lat:0 and lon: 0
     */
    public Location() {
        this.lat = 0;
        this.lon = 0;
    }

    /**
     * Custom constructor with two different values
     * @param lat latitude of the location
     * @param lon longitude of the location
     */
    public Location(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Gets latitude of the location
     * @return value of latitude
     */
    public float getLat() {
        return lat;
    }

    /**
     * Sets latitude of the location
     * @param lat new latitude value
     */
    public void setLat(float lat) {
        this.lat = lat;
    }

    /**
     * Gets longitude of the location
     * @return value of longitude
     */
    public float getLon() {
        return lon;
    }

    /**
     * Sets longitude of the location
     * @param lon new longitude value
     */
    public void setLon(float lon) {
        this.lon = lon;
    }

    /**
     * @return custom printout
     */
    @Override
    public String toString() {
        return "{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
