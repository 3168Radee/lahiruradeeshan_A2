package lahiruradeeshan_A2;

public interface RideInterface {

    /**
     * Adds a visitor to the queue.
     * @param visitor The visitor to be added.
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Removes a visitor from the queue.
     */
    void removeVisitorFromQueue();

    /**
     * Prints the details of all visitors currently in the queue.
     */
    void printQueue();

    /**
     * Runs the ride for one cycle. Moves visitors from the queue to the ride history
     * based on the maximum number of riders allowed per cycle.
     */
    void runOneCycle();

    /**
     * Adds a visitor to the ride history.
     * @param visitor The visitor to be added.
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Checks if a specific visitor is in the ride history.
     * @param visitor The visitor to check.
     * @return True if the visitor is in the history, otherwise false.
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Returns the total number of visitors in the ride history.
     * @return The number of visitors in the history.
     */
    int numberOfVisitors();

    /**
     * Prints the details of all visitors who have taken the ride.
     */
    void printRideHistory();
}
