package lou.alain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsefulReview implements Comparable<UsefulReview>{
	private int inspectionID;
	private String infractionDetails;
    private String inspectionDate;
    private String severity;
    private String action;
    private String courtOutcome;
    private double amountFined;
    
    public UsefulReview(int inspectionID, String infractionDetails, String inspectionDate, String severity,
			String action, String courtOutcome, double amountFined) {
		super();
		this.inspectionID = inspectionID;
		this.infractionDetails = infractionDetails;
		this.inspectionDate = inspectionDate;
		this.severity = severity;
		this.action = action;
		this.courtOutcome = courtOutcome;
		this.amountFined = amountFined;
	}

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
	
	public boolean equals(Object obj){
		if (obj instanceof UsefulReview){
			if(((Review)obj).getInspectionID() == this.inspectionID){
				return true;
			}
		}
		return false;
	}
	
	public String getInspectionDate(){
		return inspectionDate;
	}
	
	public int getInspectionID(){
		return inspectionID;
	}

}
