package lou.alain;

import java.util.ArrayList;

public class Restaurant {
	private int establishmentID;
	private String name;
    private String type;
    private String address;
    private String status;
    private int minimumInspectionsPerYear;
    private double longitude;
    private double latitude;
    private ArrayList<UsefulReview> reviews;
    
    public Restaurant(int establishmentID, String name, String type, String address, String status,
			int minimumInspectionsPerYear, double longitude, double latitude, ArrayList<UsefulReview> reviews) {
		super();
		this.establishmentID = establishmentID;
		this.name = name;
		this.type = type;
		this.address = address;
		this.status = status;
		this.minimumInspectionsPerYear = minimumInspectionsPerYear;
		this.longitude = longitude;
		this.latitude = latitude;
		this.reviews = reviews;
	}
}


