package airports.db;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.SearchResult;

/**
 * Establiches connection with Cloudant database.
 */
public class CloudantConn {
    private Database db;

    /**
     *  <p>Create a client connection with account "mikerhodes"</p>
     *  <p>Afterwards select databse "airportdb"</p>
     */
    public CloudantConn() {
        CloudantClient client = ClientBuilder.account("mikerhodes")
                                             .build();
        this.db = client.database("airportdb", false);
    }

    /**
     * Gets connection with databse
     * @return "airportdb" connection
     */
    public Database getDb() {
        return db;
    }

    /**
     * Execute a custome search on "airportdb"
     * @param queryString DB search will be executed with this query string
     * @param classOf the class of the searched data (in this case(AirportLoc)
     * @param <T> any type can be used here
     * @return a SearchResult, that contains the quieried items
     */
    public <T> SearchResult<T> searchInDB(String queryString, Class<T> classOf){
        SearchResult<T> result = db.search("view1/geo")
                .querySearchResult(queryString, classOf);
        return result;
    }

    public <T> SearchResult<T> pagination(String queryString, Class<T> classOf, String bmark){
        SearchResult<T> result = db.search("view1/geo")
                .bookmark(bmark)
                .querySearchResult(queryString, classOf);
        return result;
    }



}
