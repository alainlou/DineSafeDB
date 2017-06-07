package lou.alain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A representation of an inspection infraction with information only relevant in an inspection and not in a Restaurant 
 * @author panda
 *
 */
public class UsefulReview implements Comparable<UsefulReview>{
	/**
	 * The unique inspection number of each inspection
	 */
	private int inspectionID;
	/**
	 * The details of the infraction
	 */
	private String infractionDetails;
	/**
	 * The inspection status right after the review
     */
	private String status;
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
     * Constructor for an UsefulReview object
     * @param inspectionID sets this.inspectionID
     * @param infractionDetails sets this.infractionDeatils
     * @param status sets this.status
     * @param inspectionDate sets this.inspectionDate
     * @param severity sets this.severity
     * @param action sets this.action
     * @param courtOutcome sets this.courtOutcome
     * @param amountFined sets this.amountFined
     */
    public UsefulReview(int inspectionID, String infractionDetails, String status, String inspectionDate, String severity,
			String action, String courtOutcome, double amountFined) {
		super();
		this.status = status;
		this.inspectionID = inspectionID;
		this.infractionDetails = infractionDetails;
		this.inspectionDate = inspectionDate;
		this.severity = severity;
		this.action = action;
		this.courtOutcome = courtOutcome;
		this.amountFined = amountFined;
	}

	/**
	 * This is used to implement the comparable interface, returns an int that signifies greater than, equal to or less than. Sorts by date.
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(UsefulReview u) {
		try {
			Date one = new SimpleDateFormat("yyyy-MM-dd").parse(u.getInspectionDate());
			Date two =  new SimpleDateFormat("yyyy-MM-dd").parse(this.getInspectionDate());
			if(one.before(two)){
				return -1;
			}
			else if(two.before(one)){
				return 1;
			}
			else{
				return 0;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Returns where or not two issues where raise in the same inspection
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		if (obj instanceof UsefulReview){
			if(((Review)obj).getInspectionID() == this.inspectionID){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the inspection date
	 * @return inspectionDate
	 */
	public String getInspectionDate(){
		return inspectionDate;
	}
	
	/**
	 * Gets the inspectionID
	 * @return inspectionID
	 */
	public int getInspectionID(){
		return inspectionID;
	}

}
