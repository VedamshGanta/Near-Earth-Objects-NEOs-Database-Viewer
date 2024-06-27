/**
 * Vedamsh Ganta
 * 115004229
 * Recitation 01
 */

import big.data.DataSource;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * The NeoDatabase class represents a database of Near Earth Objects (NEOs) obtained from NASA's NEO API.
 * It provides methods for building a query URL, adding all NEOs from a given query URL to the database,
 * sorting the database based on a specified comparator, and printing the contents of the database as a table.
 * The class has a constant API_KEY representing the API key required to access the NEO API, and a constant API_ROOT
 * representing the root URL for the API.
 * The nearEarthObjects instance variable is an ArrayList of NearEarthObject objects representing the NEOs
 * currently in the database.
 */
public class NeoDatabase {
    public static final String API_KEY = "nsyBYvW3SkQQw3IU0iJEyuzDFM9jwYjGWfXWpvmO";
    public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";
    private ArrayList<NearEarthObject> nearEarthObjects;

    /**
     * Constructs an empty NeoDatabase object.
     * The nearEarthObjects instance variable is initialized as an empty ArrayList.
     */
    public NeoDatabase(){
        nearEarthObjects = new ArrayList<NearEarthObject>();
    }

    /**
     * Builds a query URL for a given page number in the NEO API.
     * @param pageNumber the page number for the query
     * @return the query URL as a String
     * @throws IllegalArgumentException if the page number is less than zero or greater than 715
     */
    public String buildQueryURL(int pageNumber) throws IllegalArgumentException{
        if(pageNumber < 0 || pageNumber > 715){
            throw new IllegalArgumentException();
        }
        return (API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY);
    }

    /**
     * Adds all NEOs from a given query URL to the nearEarthObjects instance variable.
     * @param queryURL the query URL as a String
     * @throws IllegalArgumentException if the DataSource object cannot be connected to the given query URL
     */
    public void addAll(String queryURL) throws IllegalArgumentException{
        if(queryURL == null){
            throw new IllegalArgumentException();
        }
        DataSource ds = DataSource.connectJSON(queryURL);
        ds.load();
        nearEarthObjects.addAll(ds.fetchList(NearEarthObject.class,
                "near_earth_objects/neo_reference_id",
                "near_earth_objects/name",
                "near_earth_objects/absolute_magnitude_h",
                "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min",
                "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max",
                "near_earth_objects/is_potentially_hazardous_asteroid",
                "near_earth_objects/close_approach_data/epoch_date_close_approach",
                "near_earth_objects/close_approach_data/miss_distance/kilometers",
                "near_earth_objects/close_approach_data/orbiting_body"));
    }

    /**
     * Sorts the nearEarthObjects instance variable based on a specified comparator.
     * @param comp the comparator used for sorting the NEOs in the database
     * @throws IllegalArgumentException if the comparator is null
     */
    public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException{
        if(comp == null){
            throw new IllegalArgumentException();
        }
        nearEarthObjects.sort(comp);
    }

    /**
     * Prints the nearEarthObjects in a formatted table
     */
    public void printTable(){
        System.out.println("  ID   |           Name            | Mag. | Diameter | Danger | Close Date | Miss Dist | Orbits");
        System.out.println("================================================================================================");
        for(NearEarthObject nearEarthObject: nearEarthObjects){
            System.out.println(nearEarthObject.toString());
        }
        System.out.println();
    }
}
