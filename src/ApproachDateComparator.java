/**
 * Vedamsh Ganta
 * 115004229
 * Recitation 01
 */

/**
 * This class implements the Comparator interface to compare NearEarthObjects by their closest approach date.
 */
public class ApproachDateComparator implements java.util.Comparator<NearEarthObject>{
    /**
     * Compares two NearEarthObjects by their closest approach date.
     * @param left the first NearEarthObject to be compared
     * @param right the second NearEarthObject to be compared
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the second
     */
    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        return left.getClosestApproachDate().compareTo(right.getClosestApproachDate());
    }
}
