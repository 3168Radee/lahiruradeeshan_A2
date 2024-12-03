package lahiruradeeshan_A2;

import java.util.Comparator;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        
        // Demonstrating different parts
        System.out.println("=== Part 3: Queue Management ===");
        assignment.partThree();

        System.out.println("\n=== Part 4A: LinkedList for Ride History ===");
        assignment.partFourA();

        System.out.println("\n=== Part 4B: Sorting Ride History ===");
        assignment.partFourB();

        System.out.println("\n=== Part 5: Running Ride Cycles ===");
        assignment.partFive();

        System.out.println("\n=== Part 6: Export Ride History to File ===");
        assignment.partSix();

        System.out.println("\n=== Part 7: Import Ride History from File ===");
        assignment.partSeven();
    }

    /**
     * Part 3: Demonstrates queue management by adding visitors to a queue,
     * removing a visitor, and printing the queue.
     */
    public void partThree() {
        Ride rollerCoaster = new Ride("Roller Coaster", "Max", "Thrill Ride", 2);
        rollerCoaster.setAssignedEmployee(new Employee("John", 30, "123456", "E001", "Ride Operator"));

        // Creating visitors
        Visitor v1 = new Visitor("Nehemia", 25, "987654321", "V001", "Adult");
        Visitor v2 = new Visitor("Jason", 22, "876543219", "V002", "Adult");
        Visitor v3 = new Visitor("Jack", 28, "765432198", "V003", "Adult");
        Visitor v4 = new Visitor("Sharon", 21, "654321987", "V004", "Adult");
        Visitor v5 = new Visitor("Leo", 29, "123456789", "V005", "Adult");

        // Add visitors to queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // Print queue
        rollerCoaster.printQueue();

        // Remove one visitor from the queue
        rollerCoaster.removeVisitorFromQueue();

        // Print updated queue
        rollerCoaster.printQueue();
    }

    /**
     * Part 4A: Demonstrates using LinkedList for ride history by adding visitors,
     * checking if a visitor is in the history, printing the number of visitors, and
     * printing all visitors in the history.
     */
    public void partFourA() {
        Ride thunderstorm = new Ride("Thunderstorm", "Moderate", "Water Ride", 4);

        // Creating visitors
        Visitor v1 = new Visitor("Tom", 25, "123456789", "V006", "Adult");
        Visitor v2 = new Visitor("Sherly", 30, "987654321", "V007", "Adult");
        Visitor v3 = new Visitor("Ben", 22, "876543219", "V008", "Adult");
        Visitor v4 = new Visitor("David", 29, "765432198", "V009", "Adult");

        // Add visitors to ride history
        thunderstorm.addVisitorToHistory(v1);
        thunderstorm.addVisitorToHistory(v2);
        thunderstorm.addVisitorToHistory(v3);
        thunderstorm.addVisitorToHistory(v4);

        // Check if a visitor is in the history
        thunderstorm.checkVisitorFromHistory(v2);

        // Print the number of visitors in history
        System.out.println("Number of visitors in history: " + thunderstorm.numberOfVisitors());

        // Print all visitors in the history
        thunderstorm.printRideHistory();
    }

    /**
     * Part 4B: Demonstrates sorting ride history using a custom comparator and
     * printing the history before and after sorting.
     */
    public void partFourB() {
        Ride thunderstorm = new Ride("Thunderstorm", "Moderate", "Water Ride", 4);

        // Creating visitors
        Visitor v1 = new Visitor("Tom", 25, "123456789", "V006", "Adult");
        Visitor v2 = new Visitor("Sherly", 30, "987654321", "V007", "Adult");
        Visitor v3 = new Visitor("Ben", 22, "876543219", "V008", "Adult");
        Visitor v4 = new Visitor("David", 29, "765432198", "V009", "Adult");

        // Add visitors to ride history
        thunderstorm.addVisitorToHistory(v1);
        thunderstorm.addVisitorToHistory(v2);
        thunderstorm.addVisitorToHistory(v3);
        thunderstorm.addVisitorToHistory(v4);

        // Print unsorted history
        System.out.println("Unsorted Ride History:");
        thunderstorm.printRideHistory();

        // Sort the collection
        thunderstorm.sortRideHistory(new VisitorComparator());

        // Print sorted history
        System.out.println("Sorted Ride History:");
        thunderstorm.printRideHistory();
    }

    /**
     * Part 5: Demonstrates running a ride cycle by adding visitors to a queue,
     * running the cycle, and printing the updated queue and ride history.
     */
    public void partFive() {
        Ride rollerCoaster = new Ride("Roller Coaster", "Max", "Thrill Ride", 2);
        rollerCoaster.setAssignedEmployee(new Employee("John", 30, "123456", "E001", "Ride Operator"));

        // Add 10 visitors to the queue
        for (int i = 1; i <= 10; i++) {
            rollerCoaster.addVisitorToQueue(new Visitor("Visitor" + i, 20 + i, "Contact" + i, "V" + i, "Adult"));
        }

        // Print queue before running the cycle
        System.out.println("Queue before running the cycle:");
        rollerCoaster.printQueue();

        // Run one cycle
        rollerCoaster.runOneCycle();

        // Print queue and history after the cycle
        System.out.println("Queue after running the cycle:");
        rollerCoaster.printQueue();

        System.out.println("Ride History after running the cycle:");
        rollerCoaster.printRideHistory();
    }

    /**
     * Part 6: Demonstrates exporting ride history to a CSV file.
     */
    public void partSix() {
        Ride rollerCoaster = new Ride("Roller Coaster", "Max", "Thrill Ride", 2);

        // Add visitors to ride history
        rollerCoaster.addVisitorToHistory(new Visitor("Nehemia", 25, "987654321", "V001", "Adult"));
        rollerCoaster.addVisitorToHistory(new Visitor("Jason", 22, "876543219", "V002", "Adult"));
        rollerCoaster.addVisitorToHistory(new Visitor("Jack", 28, "765432198", "V003", "Adult"));
        rollerCoaster.addVisitorToHistory(new Visitor("Sharon", 21, "654321987", "V004", "Adult"));
        rollerCoaster.addVisitorToHistory(new Visitor("Leo", 29, "123456789", "V005", "Adult"));

        // Export ride history to a file
        rollerCoaster.exportRideHistory("ride_history.csv");
    }

    /**
     * Part 7: Demonstrates importing ride history from a CSV file and printing the
     * imported data.
     */
    public void partSeven() {
        Ride rollerCoaster = new Ride("Roller Coaster", "Max", "Thrill Ride", 2);

        // Import ride history from a file
        rollerCoaster.importRideHistory("ride_history.csv");

        // Print the number of visitors in the ride history
        System.out.println("Number of visitors imported: " + rollerCoaster.numberOfVisitors());

        // Print all visitors in the ride history
        rollerCoaster.printRideHistory();
    }
}
