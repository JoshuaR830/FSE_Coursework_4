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
    
    public CompanyProject() {
        setupProject("New Project");
    }
    
    public CompanyProject(String pTitle) {
    	setupProject(pTitle);
    }
    
    // Changes made by Inigo Taylor, Tim Bartrum - 30/04/18
    // Changed the first ProjectPhase to be 0 rather than 1 as array indexing begins at 0
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
    public void setPTitle(String pTitle) {
    	if (pTitle.length() >= MIN_TITLE_LENGTH ) {
    		PTitle = pTitle;
    	}
    }
    
    public boolean isContact(String emailAddress) {
        return ProjectContacts.contains(emailAddress);
    }
    
    public void addContact(String emailAddress) {
        ProjectContacts.add(emailAddress);
    }
    
    public void addEmail(CompanyEmail newEmail) throws Exception {
        if (newEmail.isValid()) {
            ProjectEmails[ProjectPhase].add(newEmail);
            if (ProjectContacts.contains(newEmail.fromAddress())) {
                //do nothing
            } else {
                ProjectContacts.add(newEmail.fromAddress());
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
    	if(thePhase > PID || thePhase < 1) {
    		throw new Exception();
    	}
    	
    	return ProjectEmails[thePhase];
    	
        
    }
    
    // Added by Joshua Richardson - 30/04/18
    // This function will return the project email array
    public ArrayList[] getProjectEmails(){
    	return ProjectEmails;
    }
    
    public boolean nextPhase() {
        ProjectPhase++;
        if (ProjectPhase > CompanyEmailSystem.ProjectPhases.length) {
            return false;
        } else {
            return true;
        }
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
