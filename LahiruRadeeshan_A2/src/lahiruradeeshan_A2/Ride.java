package lahiruradeeshan_A2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Comparator;

public class Ride implements RideInterface {
    private String rideName;
    private String thrillLevel;
    private String attractionType;
    private Employee assignedEmployee;
    private Queue<Visitor> waitingLine; // Queue for visitors waiting for the ride
    private LinkedList<Visitor> rideHistory; // LinkedList for visitors who took the ride
    private int maxRiders; // Maximum number of visitors per ride cycle
    private int numOfCycles; // Number of ride cycles run

    // Constructor
    public Ride(String rideName, String thrillLevel, String attractionType, int maxRiders) {
        this.rideName = rideName;
        this.thrillLevel = thrillLevel;
        this.attractionType = attractionType;
        this.maxRiders = maxRiders;
        this.numOfCycles = 0;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Getters and setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getThrillLevel() {
        return thrillLevel;
    }

    public void setThrillLevel(String thrillLevel) {
        this.thrillLevel = thrillLevel;
    }

    public String getAttractionType() {
        return attractionType;
    }

    public void setAttractionType(String attractionType) {
        this.attractionType = attractionType;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    // Queue Management Methods (Part 3)
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingLine.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to the queue.");
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor removedVisitor = waitingLine.poll();
        if (removedVisitor != null) {
            System.out.println("Visitor " + removedVisitor.getName() + " removed from the queue.");
        } else {
            System.out.println("The queue is empty.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Visitors in queue for " + rideName + ":");
        for (Visitor visitor : waitingLine) {
            System.out.println(visitor.getName());
        }
    }

    // LinkedList Management Methods (Part 4A)
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean exists = rideHistory.contains(visitor);
        System.out.println("Visitor " + visitor.getName() + (exists ? " exists" : " does not exist") + " in ride history.");
        return exists;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Visitors who took the ride " + rideName + ":");
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getName());
        }
    }

    // Sorting Ride History (Part 4B)
    public void sortRideHistory(Comparator<Visitor> comparator) {
        rideHistory.sort(comparator);
        System.out.println("Ride history has been sorted.");
    }

    // Running a Ride Cycle (Part 5)
    @Override
    public void runOneCycle() {
        if (assignedEmployee == null) {
            System.out.println("No employee assigned to this ride. Cannot run.");
            return;
        }

        if (waitingLine.isEmpty()) {
            System.out.println("No visitors in the queue. Cannot run.");
            return;
        }

        int riders = Math.min(maxRiders, waitingLine.size());
        System.out.println("Running the ride for " + riders + " visitors.");

        for (int i = 0; i < riders; i++) {
            Visitor visitor = waitingLine.poll();
            addVisitorToHistory(visitor);
        }

        numOfCycles++;
        System.out.println("Cycle completed. Total cycles run: " + numOfCycles);
    }

    // Export Ride History to a File (Part 6)
    public void exportRideHistory(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getContactNumber() +
                             "," + visitor.getVisitorId() + "," + visitor.getAgeGroup());
                writer.newLine();
            }
            System.out.println("Ride history successfully exported to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while exporting ride history: " + e.getMessage());
        }
    }

    // Import Ride History from a File (Part 7)
    public void importRideHistory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 5) {
                    String name = details[0];
                    int age = Integer.parseInt(details[1]);
                    String contactNumber = details[2];
                    String visitorId = details[3];
                    String ageGroup = details[4];

                    // Create a new Visitor object and add it to the ride history
                    Visitor visitor = new Visitor(name, age, contactNumber, visitorId, ageGroup);
                    addVisitorToHistory(visitor);
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
            System.out.println("Ride history successfully imported from " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while importing ride history: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in the file: " + e.getMessage());
        }
    }
}

