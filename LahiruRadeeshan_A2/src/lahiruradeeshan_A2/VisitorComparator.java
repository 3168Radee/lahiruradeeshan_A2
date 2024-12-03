package lahiruradeeshan_A2;

import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {

    /**
     * Compares two Visitor objects based on their name and age.
     * 
     * @param v1 The first Visitor object.
     * @param v2 The second Visitor object.
     * @return A negative integer, zero, or a positive integer as the first argument
     *         is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Compare by name first
        int nameComparison = v1.getName().compareTo(v2.getName());

        // If names are the same, compare by age
        if (nameComparison != 0) {
            return nameComparison;
        }

        return Integer.compare(v1.getAge(), v2.getAge());
    }
}
