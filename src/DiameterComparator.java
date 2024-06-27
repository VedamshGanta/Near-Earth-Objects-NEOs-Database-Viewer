/**
 * Vedamsh Ganta
 * 115004229
 * Recitation 01
 */

/**
 * The DiameterComparator class is a comparator used to compare NearEarthObject instances based on their average diameter.
 */
public class DiameterComparator implements java.util.Comparator<NearEarthObject>{
    /**
     * Compares two NearEarthObject instances based on their average diameter.
     * @param left the first object to be compared.
     * @param right the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the average diameter of the left NearEarthObject
     * is less than, equal to, or greater than the average diameter of the right NearEarthObject, respectively.
     */
    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        return Double.compare(left.getAverageDiameter(), right.getAverageDiameter());
    }
}
