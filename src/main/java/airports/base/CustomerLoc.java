package airports.base;

import java.util.Locale;

/**
 * Defined point by Customer
 */
public class CustomerLoc extends Location {
    private float radius;

    public CustomerLoc(float lat, float lon, float radius) {
        super(lat, lon);
        this.radius = radius;
    }

    public CustomerLoc() {
        super();
        this.radius = 5;
    }

    /**
     * Gets radius of the location
     * @return value of radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Sets radius of the location
     * @param radius new radius value
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "CustomerLoc{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", radius=" + radius +
                '}';
    }

    /**
     * Generates a query string, that can be used in Cloudant search
     * @return Cloudant query string
     */
    public String getQueryString() {
        String query = String.format(Locale.US,"lon:[ %.6f TO %.6f] AND lat:[%.6f TO %.6f]",
                              this.lat - this.radius, this.lat + this.radius,
                              this.lon - this.radius, this.lon + this.radius);
        return query;
    }
}
