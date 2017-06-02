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
    private double longitude;
    private double latitude;
    
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
    
    public Review(int a, int b, String c, String d, String e, String f, int g, String h, String i, String j, String k, String l, double m, double Long, double Lat) {
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
        longitude = Long;
		latitude = Lat;
    }
	
	
	public String getAddress(){
		return address;
	}
	
	public void setCoordinates(double Long, double Lat){
		longitude = Long;
		latitude = Lat;
	}
	
	@Override
	public String toString() {
		return "Review [inspectionID=" + inspectionID + ", establishmentID=" + establishmentID + ", name=" + name
				+ ", type=" + type + ", address=" + address + ", status=" + status + ", minimumInspectionsPerYear="
				+ minimumInspectionsPerYear + ", infractionDetails=" + infractionDetails + ", inspectionDate="
				+ inspectionDate + ", severity=" + severity + ", action=" + action + ", courtOutcome=" + courtOutcome
				+ ", amountFined=" + amountFined + "]";
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
    **/
    
    
}