/**
 * Vedamsh Ganta
 * 115004229
 * Recitation 01
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The NearEarthObject class represents an object that orbits
 * close to Earth and contains various properties such as its
 * name, diameter, magnitude, and danger level. It also includes
 * the date of the closest approach, miss distance, and orbiting body.
 */
public class NearEarthObject {
    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private Date closestApproachDate;
    private double missDistance;
    private String orbitingBody;

    /**
     * Constructor for creating a NearEarthObject instance
     * @param referenceID the unique identifier of the object
     * @param name the name of the object
     * @param absoluteMagnitude the absolute magnitude of the object
     * @param minDiameter the minimum estimated diameter of the object
     * @param maxDiameter the maximum estimated diameter of the object
     * @param isDangerous the danger status of the object
     * @param closestDateTimestamp the timestamp of the closest approach date of the object
     * @param missDistance the miss distance of the object
     * @param orbitingBody the name of the body that the object is orbiting
     */
    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter, double maxDiameter, boolean isDangerous, long closestDateTimestamp, double missDistance, String orbitingBody){
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.averageDiameter = (minDiameter + maxDiameter) / 2;
        this.isDangerous = isDangerous;
        this.closestApproachDate = new Date(closestDateTimestamp);
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
    }

    /**
     * Returns the reference ID of the object
     * @return the reference ID
     */
    public int getReferenceID() {
        return referenceID;
    }

    /**
     * Sets the reference ID of the object
     * @param referenceID the new reference ID
     */
    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
    }

    /**
     * Returns the name of the object
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the object
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the absolute magnitude of the object
     * @return the absolute magnitude
     */
    public double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    /**
     * Sets the absolute magnitude of the object
     * @param absoluteMagnitude the new absolute magnitude
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    /**
     * Returns the average diameter of the object
     * @return the average diameter
     */
    public double getAverageDiameter() {
        return averageDiameter;
    }

    /**
     * Sets the average diameter of the object
     * @param averageDiameter the new average diameter
     */
    public void setAverageDiameter(double averageDiameter) {
        this.averageDiameter = averageDiameter;
    }

    /**
     * Returns the danger status of the object
     * @return the danger status
     */
    public boolean isDangerous() {
        return isDangerous;
    }

    /**
     * Sets the danger status of the object
     * @param dangerous the new danger status
     */
    public void setDangerous(boolean dangerous) {
        isDangerous = dangerous;
    }

    /**
     * returns the closest approach date
     * @return the closest approach date
     */
    public Date getClosestApproachDate() {
        return closestApproachDate;
    }

    /**
     * sets the closest approach date
     * @param closestApproachDate the new closest approach date
     */
    public void setClosestApproachDate(Date closestApproachDate) {
        this.closestApproachDate = closestApproachDate;
    }

    /**
     * returns the miss distance
     * @return the miss distance
     */
    public double getMissDistance() {
        return missDistance;
    }

    /**
     * sets the miss distance
     * @param missDistance the new miss distance
     */
    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    /**
     * returns the orbiting body
     * @return the orbiting body
     */
    public String getOrbitingBody() {
        return orbitingBody;
    }

    /**
     * sets the orbiting body
     * @param orbitingBody the new orbiting body
     */
    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    /**
     * returns the NEO as a formatted String
     * @return the NEO as a formatted String
     */
    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        return String.format("%-9d%-28s%-8.1f%-10.3f%-10s%-12s%-12.0f%s", referenceID,
                name.substring(0, Math.min(name.length(), 26)), absoluteMagnitude, averageDiameter, isDangerous,
                simpleDateFormat.format(closestApproachDate), missDistance, orbitingBody);
    }
}
