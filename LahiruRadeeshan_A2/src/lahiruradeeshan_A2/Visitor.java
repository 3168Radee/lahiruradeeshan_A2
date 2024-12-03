package lahiruradeeshan_A2;

public class Visitor extends Person {
    private String visitorId;
    private String ageGroup;

    // Default constructor
    public Visitor() {
        super();
    }

    // Parameterized constructor
    public Visitor(String name, int age, String contactNumber, String visitorId, String ageGroup) {
        super(name, age, contactNumber);
        this.visitorId = visitorId;
        this.ageGroup = ageGroup;
    }

    // Getters and setters
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
}
