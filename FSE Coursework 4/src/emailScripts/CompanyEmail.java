// https://docs.google.com/document/d/1migYYyWoCX3aydqz9rkFh2q5YYehMueO_p8LHfVqLb4/edit

package emailScripts;

public class CompanyEmail {
    private String fromAddress;
    private String toAddress;
    private String subjectLine;
    private String emailMessage;
    
    public CompanyEmail() {
        fromAddress = null;
        toAddress = null;
        subjectLine = null;
        emailMessage = null;
    }
    
    public CompanyEmail(String fAddress, String tAddress, String subLine, String eMessage) {
    	fromAddress = fAddress;
    	toAddress = tAddress;
    	subjectLine = subLine;
    	emailMessage = eMessage;
    }
    
    public String fromAddress() {
        return fromAddress;
    }
    
    public String toAddress() {
        return toAddress;
    }
    
    public String subjectLine() {
        return subjectLine;
    }
    
    public String emailMessage() {
    	// Bug fix: removed brackets at end
        return emailMessage;
    }
    
    //setFrom() and setTo() employ a simple verification method written by Joshua and partially editied by Julian.
    public void setFrom(String fromAddr) {
    			String [] splitUp = fromAddr.split("@");
    			
    			if (splitUp.length == 2) {
    				if(splitUp[0].split("\\.").length == 1) {
    					if(splitUp[1].split("\\.").length > 2 && splitUp[0].split("\\.").length < 4) {
    						fromAddress = fromAddr;
    					}
    				}
    			}	
    	}	
    	
    public void setTo(String toAddr) {
		String [] splitUp = toAddr.split("@");
		
		if (splitUp.length == 2) {
			if(splitUp[0].split("\\.").length == 1) {
				if(splitUp[1].split("\\.").length > 2 && splitUp[0].split("\\.").length < 4) {
					toAddress = toAddr;
				}
			}
		}	
}
    
    public void setSubject(String subLine) {
        subjectLine = subLine;
    }
    
    public void setMessage(String eMessage) {
        emailMessage = eMessage;
    }
    
    public boolean isValid() {
        boolean isComplete = true;
        if (fromAddress == null) isComplete = false;
        if (toAddress == null) isComplete = false;
        if (subjectLine == null) isComplete = false;
        if (emailMessage == null) isComplete = false;
        return isComplete;
    }
    
    public String toString() {
    	if (subjectLine.equals("")) {
    		return "[no subject]";
    	} else {
    		return subjectLine;
    	}
    }
}
