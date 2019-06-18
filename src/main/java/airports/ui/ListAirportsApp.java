package airports.ui;

import airports.base.AirportLoc;
import airports.base.CustomerLoc;
import airports.base.Location;
import airports.db.CloudantConn;
import com.cloudant.client.api.model.SearchResult;

import java.util.*;

/**
 * Reads input from the user and prints out the filtered list of airports.
 */
public class ListAirportsApp {


    /**
     * Calculates the distance between two location point
     * @param target airport location
     * @param src customer location
     * @return the distance between airport and customer
     */
    public static double calcDistance(Location target, Location src) {
        double dist = 0.0f;
        dist = Math.pow( target.getLat() - src.getLat(), 2) + Math.pow( target.getLon() - src.getLon(), 2);
        dist = Math.sqrt(dist);
        return dist;
    }


    /**
     * <p>Filter out those airports that are further then the custom radius</p>
     * <p>Additionally converts Field type to AirportLoc type</p>
     * @param itr an iterator that steps through each searchResult
     * @param customer the customer location
     * @return a list that contains airport locations with calculated distance
     */
    public static List<AirportLoc> filterResult(Iterator<SearchResult<AirportLoc>.SearchResultRow> itr,
                                                CustomerLoc customer) {
        List<AirportLoc> airportList = new ArrayList<AirportLoc>();
        while (itr.hasNext()) {
            SearchResult.SearchResultRow rowItem = itr.next();
            if (rowItem.getFields() instanceof AirportLoc) {
                AirportLoc item = (AirportLoc) rowItem.getFields();
                double dist = calcDistance(item, customer);
                if (dist <= customer.getRadius()) {
                    item.setDistance(dist);
                    airportList.add(item);
                }
            } else {
                System.out.println("Invalid response field type");
            }
        }
        return airportList;
    }


    /**
     * <p>This program pulls data about airports from a Cloudant database
     * and displays their location in a simple list, sorted by distance.</p>
     * <p>The user shall provide a lat/lon point and a radius during runtime.</p>
     * <p>The retrieved airports will be within the user provided radius.</p>
     *
     * @param args no arguments needed
     */
    public static void main(String [ ] args)
    {
        System.out.println("Welcome to World of Airports!");
        String choice = "y";
        CloudantConn con = new CloudantConn();
        Scanner scanner = new Scanner(System.in);

        while(choice.equalsIgnoreCase("y")) {
            CustomerLoc origo = new CustomerLoc();

            System.out.print("Give a latitude: ");
            origo.setLat(Float.parseFloat(scanner.nextLine()));
            System.out.print("Give a longitude: ");
            origo.setLon(Float.parseFloat(scanner.nextLine()));
            System.out.print("Give a radius: ");
            origo.setRadius(Float.parseFloat(scanner.nextLine()));

            System.out.printf("--- Executing Query ---\n");

            SearchResult<AirportLoc> searchResult = con.searchInDB(origo.getQueryString(), AirportLoc.class);
            List<AirportLoc> airportList = filterResult(searchResult.getRows().iterator(), origo);
            
            while(searchResult.getRows().size() == 25) {
                searchResult = con.pagination(origo.getQueryString(), AirportLoc.class, searchResult.getBookmark());
                airportList.addAll(filterResult(searchResult.getRows().iterator(), origo));
            }

            Collections.sort(airportList);

            System.out.printf("List of nearby airports: (count: %d)\n", airportList.size());
            System.out.println(airportList);

            System.out.print("Do you want to continue(y/n)?");
            choice = scanner.nextLine();
        }
        System.out.println("Goodbye!");

    }
}
