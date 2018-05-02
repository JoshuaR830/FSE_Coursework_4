// https://docs.google.com/document/d/1migYYyWoCX3aydqz9rkFh2q5YYehMueO_p8LHfVqLb4/edit

package emailScripts;

import java.util.ArrayList;

public class CompanyProject {
	private static final int MIN_TITLE_LENGTH = 10;
	
    private int PID;
    private String PTitle;
    private ArrayList<String> ProjectContacts;
    private int ProjectPhase;
    private ArrayList[] ProjectEmails = new ArrayList[6];
    
    // Changes to constructors made by Tim Bartrum - 30/04/18
    public CompanyProject() {
        setupProject("New Project");
    }
    
    public CompanyProject(String pTitle) {
    	setupProject(pTitle);
    }
    
    // Changes made by Inigo Taylor, Tim Bartrum - 30/04/18
    // Changed the first ProjectPhase to be 0 rather than 1 as array indexing begins at 0 in Java
    private void setupProject(String title) {
    	CompanyEmailSystem.GlobalProjectCounter++;
    	PID = CompanyEmailSystem.GlobalProjectCounter;
        this.setPTitle(title);
        ProjectContacts = new ArrayList<String>();
        ProjectPhase = 0;
        ProjectEmails[ProjectPhase] = new ArrayList<CompanyEmail>();
    }
    
    public int getPID() {
        return PID;
    }
    
    public String getPTitle() {
        return PTitle;
    }
    
    // Changes made by Inigo Taylor - 29/04/18
    // Changed condition from > to >= when comparing pTitle.length() with MIN_TITLE_LENGTH
    
    
    // Bug fixed by Joshua Richardson - 02/05/18
    // Fixed a bug where if no title was entered the title would be null and break regex, this was the simplest option
    // We would have to check what the client would want it to do in this situation in real life - perhaps asking the user to enter a different title
    
    public void setPTitle(String pTitle) {
    	if (pTitle.length() >= MIN_TITLE_LENGTH ) {
    		PTitle = pTitle;
    	}else {
    		PTitle = "New Project";
    	}
    }
    
    public boolean isContact(String emailAddress) {
        return ProjectContacts.contains(emailAddress);
    }
    
    public void addContact(String emailAddress) {
        ProjectContacts.add(emailAddress);
    }
    
    // Changes made by Joshua Richardson, Inigo Taylor - 01/05/2018
    // Changed the address that is added to ProjectContacts from fromAddress to toAddress
    public void addEmail(CompanyEmail newEmail) throws Exception {
    	boolean validFrom = newEmail.checkValidEmail(newEmail.fromAddress());
    	boolean validTo = newEmail.checkValidEmail(newEmail.toAddress());
    	// Changes made by Inigo Taylor - 01/05/18
    	// Added an if statement to check whether the email is valid before adding it (and to give an error if it isn't)
        if (newEmail.isValid() && validFrom && validTo) {
            ProjectEmails[ProjectPhase].add(newEmail);
            
            // Changes made by Inigo Taylor - 01/05/18
            // Refactored code to be slightly more readable
            if (!ProjectContacts.contains(newEmail.toAddress())) {
                ProjectContacts.add(newEmail.toAddress());
            }
        } else {
        	throw new Exception("Invalid email");
        }
    }
    
    public ArrayList<CompanyEmail> getEmailsForPhase() {
        return ProjectEmails[ProjectPhase];
    }
    
    
    // Changes made by Joshua Richardson - 30/04/18
    // Added throws exception
    public ArrayList<CompanyEmail> getEmailsForPhase(int thePhase) throws Exception {
    	if(thePhase >= CompanyEmailSystem.ProjectPhases.length-1 || thePhase < 0) {
    		throw new Exception();
    	}
    	
    	return ProjectEmails[thePhase];
    	
        
    }
    
    // Added by Joshua Richardson - 30/04/18
    // This function will return the project email array
    public ArrayList[] getProjectEmails(){
    	return ProjectEmails;
    }
    
    // Changes made by Inigo Taylor 01/05/18
    // Moved ProjectPhase++ from outside the if to inside the if so the phase only changes when not at the final stage
    public boolean nextPhase() {
        if (ProjectPhase >= CompanyEmailSystem.ProjectPhases.length-1) {
            return false;
        } else {
            ProjectPhase++;
            return true;
        }
    }
    
    // Added by Joshua Richardson - 01/05/18
    // This function will allow you to set the current phase
    public void setProjectPhase(int phase) {
        ProjectPhase = phase;
    }
    
    public String getPhaseByName() {
        return CompanyEmailSystem.ProjectPhases[ProjectPhase];
    }
    
    
    
    public int getPhaseByID() {
        return ProjectPhase;
    }
    
    public ArrayList<String> getProjectContacts() {
        return ProjectContacts;
    }
    
    public String toString() {
        return PTitle + " [" + getPhaseByName() + "]";
    }
}
