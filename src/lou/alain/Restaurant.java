package lou.alain;

import java.util.ArrayList;

/**
 * Representation of a restaurant
 * @author Alain
 *
 */
public class Restaurant {
	/**
	 * Unique establishment ID integer for every food serving place in Toronto
	 */
	private int establishmentID;
	/**
	 * The name of the restaurant
	 */
	private String name;
    /**
     * The type of restaurant (take-out, etc.)
     */
    private String type;
    /**
     * The address of the restaurant
     */
    private String address;
    /**
     * The current inspection status (based on the latest inspection)
     */
    private String status;
    /**
     * The number of inspection minimum per year (based on how well or poorly the Restaurant has done in the past)
     */
    private int minimumInspectionsPerYear;
    /**
     * The longitude part of the coordinates of the restaurant
     */
    private double longitude;
    /**
     * The latitude part of the coordinates of the restaurant
     */
    private double latitude;
    /**
     * An ArrayList of all the past inspections with relevant information
     */
    private ArrayList<UsefulReview> reviews;
    
    /**
     * Constructor that initializes a Restaurant object
     * @param establishmentID sets this.establishmentID
     * @param name sets this.name
     * @param type sets this.type
     * @param address sets this.address
     * @param status sets this.status
     * @param minimumInspectionsPerYear sets this.minimumInspectionsPerYear
     * @param longitude sets this.longitude
     * @param latitude sets this.latitude
     * @param reviews sets this.reviews
     */
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


