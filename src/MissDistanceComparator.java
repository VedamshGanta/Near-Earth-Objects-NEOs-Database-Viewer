/**
 * Vedamsh Ganta
 * 115004229
 * Recitation 01
 */

/**
 * The MissDistanceComparator class implements the Comparator interface for NearEarthObject
 * and compares two NearEarthObject instances based on their miss distance.
 */
public class MissDistanceComparator implements java.util.Comparator<NearEarthObject>{
    /**
     * Compares two NearEarthObject instances based on their miss distance.
     * @param left the first object to be compared.
     * @param right the second object to be compared.
     * @return an integer value representing the result of the comparison
     */
    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        return (int)(left.getMissDistance() - right.getMissDistance());
    }
}
