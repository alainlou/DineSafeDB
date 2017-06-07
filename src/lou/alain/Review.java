package lou.alain;
/**
 * The older representation of an inspection
 * @author panda
 *
 */
public class Review {
    /**
     * The unique inspection number of each inspection
     */
    private int inspectionID;
    /**
     * The establishment ID associated with each restaurant
     */
    private int establishmentID;
    /**
     * The name of the restaurant
     */
    private String name;
    /**
     * The type of the restaurant
     */
    private String type;
    /**
     * The address of the restaurant
     */
    private String address;
    /**
     * The inspection status right after the review
     */
    private String status;
    /**
     * The minimum number of inspections per year
     */
    private int minimumInspectionsPerYear;
    /**
     * The details of the infraction
     */
    private String infractionDetails;
    /**
     * The date of the inspection
     */
    private String inspectionDate;
    /**
     * The severity (from minor to significant)
     */
    private String severity;
    /**
     * The actions taken by the operators to remedy the issue (if during the inspection)
     */
    private String action;
    /**
     * The court decision the problem went to court
     */
    private String courtOutcome;
    /**
     * The amount fined as determined by the court
     */
    private double amountFined;
    /**
     * The longitude part of the coordinates of the restaurant
     */
    private double longitude;
    /**
     * The latitude part of the coordinates of the restaurant
     */
    private double latitude;
    
    /**
     * Changes the address of the Restaurant
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Constructor of a Review object without coordinates or amount fined
     * @param a sets this.inspectionID
     * @param b sets this.establishmentID
     * @param c sets this.name
     * @param d sets this.type
     * @param e sets this.address
     * @param f sets this.status
     * @param g sets this.minimumInspectionsPerYear
     * @param h sets this.infractionDetails
     * @param i sets this.inspecitonDate
     * @param j sets this.severity
     * @param k sets this.action
     * @param l sets this.courtOutcome
     */
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

    /**
     * Constructor of a Review object without coordinates
     * @param a sets this.inspectionID
     * @param b sets this.establishmentID
     * @param c sets this.name
     * @param d sets this.type
     * @param e sets this.address
     * @param f sets this.status
     * @param g sets this.minimumInspectionsPerYear
     * @param h sets this.infractionDetails
     * @param i sets this.inspecitonDate
     * @param j sets this.severity
     * @param k sets this.action
     * @param l sets this.courtOutcome
     * @param m sets this.amountFined
     */
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
    
    /**
     * Constructor of a Review object with all fields
     * @param a sets this.inspectionID
     * @param b sets this.establishmentID
     * @param c sets this.name
     * @param d sets this.type
     * @param e sets this.address
     * @param f sets this.status
     * @param g sets this.minimumInspectionsPerYear
     * @param h sets this.infractionDetails
     * @param i sets this.inspecitonDate
     * @param j sets this.severity
     * @param k sets this.action
     * @param l sets this.courtOutcome
     * @param m sets this.amountFined
     * @param Long sets this.longitude
     * @param Lat sets this.latitude
     */
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
	
	
	/**
	 * Constructor to create an empty inspection (added to later)
	 */
	public Review() {
	}
	/**
	 * Returns int the inspectionID
	 * @return the inspectionID
	 */
	public int getInspectionID() {
		return inspectionID;
	}
	/**
	 * Gets the establishmentID
	 * @return establishmentID
	 */
	public int getEstablishmentID() {
		return establishmentID;
	}
	/**
	 * Gets the restaurant name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the restaurant type
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Returns the status right after the review
	 * @return status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * Returns the minimumInspectionsPerYear of a restaurant
	 * @return minimumInspectionsPerYear
	 */
	public int getMinimumInspectionsPerYear() {
		return minimumInspectionsPerYear;
	}
	/**
	 * Gets the infractinoDetails
	 * @return infractionDetails
	 */
	public String getInfractionDetails() {
		return infractionDetails;
	}
	/**
	 * Gets the inspection date
	 * @return the inspectionDate
	 */
	public String getInspectionDate() {
		return inspectionDate;
	}
	/**
	 * Returns the severity of the problem
	 * @return severity
	 */
	public String getSeverity() {
		return severity;
	}
	/**
	 * Gets the action taken by the operator
	 * @return action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * Gets the court outcome
	 * @return courtOutcome
	 */
	public String getCourtOutcome() {
		return courtOutcome;
	}
	/**
	 * Gets the amount fined
	 * @return amountFined
	 */
	public double getAmountFined() {
		return amountFined;
	}
	/**
	 * Gets the longitude
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * Gets the latitude
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * Gets the address
	 * @return address
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * Sets the coordinates
	 * @param Long sets this.longitude
	 * @param Lat sets this.latitude
	 */
	public void setCoordinates(double Long, double Lat){
		longitude = Long;
		latitude = Lat;
	}
	
	/**
	 * Useful information from the Review converted into a string format
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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