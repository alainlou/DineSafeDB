package lou.alain;

public class Review {
    private int inspectionID;
    private int establishmentID;
    private String name;
    private String type;
    private String address;
    private String status;
    private int minimumInspectionsPerYear;
    private String infractionDetails;
    private String inspectionDate;
    private String severity;
    private String action;
    private String courtOutcome;
    private double amountFined;
    
    public void setAddress(String address) {
        this.address = address;
    }
    public Review(int a, int b, String c, String d, String e, String f, int g, String h, String i, String j, String k, String l) {
        inspectionID = a;
        establishmentID = b;
        name = c;
        type = d;
        address = e;
        status = f;
        minimumInspectionsPerYear = g;
        infractionDetails = h;
        inspectionDate = i;
        severity = j;
        action = k;
        courtOutcome = l;
    }

    public Review(int a, int b, String c, String d, String e, String f, int g, String h, String i, String j, String k, String l, double m) {
        inspectionID = a;
        establishmentID = b;
        name = c;
        type = d;
        address = e;
        status = f;
        minimumInspectionsPerYear = g;
        infractionDetails = h;
        inspectionDate = i;
        severity = j;
        action = k;
        courtOutcome = l;
        amountFined = m;
    }

    /**public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinimumInspectionsPerYear() {
        return minimumInspectionsPerYear;
    }

    public void setMinimumInspectionsPerYear(int minimuminspectionsperyear) {
        this.minimumInspectionsPerYear = minimuminspectionsperyear;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", minimuminspectionsperyear=" + minimumInspectionsperYear +
                '}';
    }**/
}