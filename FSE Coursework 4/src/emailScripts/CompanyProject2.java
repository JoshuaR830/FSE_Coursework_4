// https://docs.google.com/document/d/1migYYyWoCX3aydqz9rkFh2q5YYehMueO_p8LHfVqLb4/edit

package emailScripts;

import java.util.ArrayList;

/**
 * Refactored Version of CompanyProject
 * @author Tim
 *
 */
public class CompanyProject2 {
	private static final int MAX_TITLE_LENGTH = 10;
	
    private int PID;
    private String PTitle;
    private ArrayList<String> ProjectContacts;
    private int ProjectPhase;
    private ArrayList[] ProjectEmails = new ArrayList[6];
    
    public CompanyProject2() {
        setupProject("New Project");
    }
    
    public CompanyProject2(String pTitle) {
    	setupProject(pTitle);
    }
    
    private void setupProject(String title) {
    	CompanyEmailSystem.GlobalProjectCounter++;
    	PID = CompanyEmailSystem.GlobalProjectCounter;
        this.setPTitle(title);
        ProjectContacts = new ArrayList<String>();
        ProjectPhase = 1;
        ProjectEmails[ProjectPhase] = new ArrayList<CompanyEmail>();
    }
    
    public int getPID() {
        return PID;
    }
    
    public String getPTitle() {
        return PTitle;
    }
    
	public void setPTitle(String pTitle) {
    	if (pTitle.length() > MAX_TITLE_LENGTH ) {
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
            if (!ProjectContacts.contains(newEmail.fromAddress())) {
            	ProjectContacts.add(newEmail.fromAddress());
            }
            
        } else {
        	throw new Exception("Invalid email");
        }
    }
    
    public ArrayList<CompanyEmail> getEmailsForPhase() {
        return ProjectEmails[ProjectPhase];
    }
    
    public ArrayList<CompanyEmail> getEmailsForPhase(int thePhase) {
        return ProjectEmails[thePhase];
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