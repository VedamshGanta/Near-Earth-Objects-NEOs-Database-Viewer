/**
 * Vedamsh Ganta
 * 115004229
 * Recitation 01
 */

/**
 *This class implements the Comparator interface to provide a comparison method for NearEarthObject objects
 * based on their reference ID.
 */
public class ReferenceIDComparator implements java.util.Comparator<NearEarthObject>{
    /**
     * Compares the reference IDs of two NearEarthObject objects and returns an integer value indicating their order.
     * @param left the first object to be compared.
     * @param right the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        return left.getReferenceID() - right.getReferenceID();
    }
}