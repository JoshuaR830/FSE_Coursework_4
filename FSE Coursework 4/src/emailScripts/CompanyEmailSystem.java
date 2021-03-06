package emailScripts;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyEmailSystem {

	public static int GlobalProjectCounter;
	public static String[] ProjectPhases = new String[]{"Feasibility","Design","Implementation","Testing","Deployment","Completed"};
	
    public static ArrayList<CompanyProject> AllProjects;
    public static int currentProjShowing;
    
    public static void main(String[] args) {
        
        ///////
        //Startup
        //////
        GlobalProjectCounter = 0;
        AllProjects = new ArrayList<CompanyProject>();
        
        //////////////
        //example test data
        //////////////
        
        // Bug found
        // Problem created by the fact that the project titles are of invalid length
        CompanyProject cp1 = new CompanyProject("Proj1234567");
        CompanyProject cp2 = new CompanyProject("Proj2");
        CompanyProject cp3 = new CompanyProject("Proj3");
        
        for (int x = 0; x < 10; x++) {
        	CompanyEmail ce = new CompanyEmail("me" + x + "@me.com", "you" + x + "@you.com", "this is a test subject for email" + x, "this is a test message for email " + x);
        	
        	switch(x % 3) {
        	case 0:
        		try {
					cp1.addEmail(ce);
				} catch (Exception e) {
					System.out.println("Could not add");
				}
        		break;
        	case 1:
        		try {
					cp2.addEmail(ce);
				} catch (Exception e) {
					System.out.println("Could not add");
				}
        		break;
        	case 2:
        		try {
					cp3.addEmail(ce);
				} catch (Exception e) {
					System.out.println("Could not add");
				}
        		break;
        	}
        }
        
        AllProjects.add(cp1);
        AllProjects.add(cp2);
        AllProjects.add(cp3);
        
        //System.out.println(cp1);
        //System.out.println(AllProjects.toString());

        /// END OF TEST DATA ///
        
        System.out.println("What do you want to do?\n P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it");
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.next();
            try{
                if(currentProjShowing == 0) {
                    if (s.equals("P")) {
                        ListProjects();
                    } else if (s.equals("A")) {
                        AddProject(in);
                    } else if (s.equals("X")) {
                        System.out.println("Goodbye!");
                        break;
                    }
                    // Change made by Joshua Richardson - 03/05/18
                    // Stop the error by seeing if it is a digit
                    else if(s.matches("\\d*")) {
            			if (Integer.parseInt(s) > 0 ) {
            				// Change made by Inigo Taylor - 02/05/18
                        	// Changed Integer.parseInt(s)-1 to Integer.parseInt(s) so the currentProject stores the correct value
                            // In addition, so that when obtaining values still works when calling functions in CompanyProject I decremented 1 in all the other functions using it
            				currentProjShowing = Integer.parseInt(s);
            			}
                    } else {
                        System.out.println("Command not recognised");
                    } 

                } else {
                	// Change made by Joshua Richardson - 03/05/18
                	// Swapped if statements for a case switch
                	
                	switch(s){
	                	case "A":
	                		AddEmail(in);
	                		break;
	                	case "L":
	                		ListEmails(0);
	                		break;
	                	case "F":
	                		ListPhases();
	                		break;
	                	case "C":
	                		ListContacts();
	                		break;
	                	case "N":
	                		ChangeProjectPhase();
	                		break;
	                	case "X":
	                		currentProjShowing = 0;
	                		break;
	            		default:
	            			// Change made by Joshua Richardson - 03/05/18
	                        // Stop the error by seeing if it is a digit
	            			if(s.matches("\\d*")) {
		            			if (Integer.parseInt(s) > 0 ) {
		                            ListEmails(Integer.parseInt(s));
		            			}
	                        } else {
	                            System.out.println("Command not recognised");
	                        }
	            			break;
                	}
                }
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.toString() + "\n");
            }
            if(currentProjShowing == 0) {
                System.out.println("What do you want to do?\n P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it Software");
            } else {
                System.out.println("What do you want to do?\n L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project");
            }
        }
        in.close();
        
    }
    
    private static void ListProjects(){
        for (int x = 0; x < AllProjects.size(); x++) {
            CompanyProject cp = AllProjects.get(x);
            int emailCount = cp.getEmailsForPhase().size();
            System.out.println((x+1) + ") " + cp.toString() + " - " + emailCount + " emails"); // Tim Bartrum
        }
    }
    
    private static void AddProject(Scanner in) {
        System.out.println("What is the title of the project?");
        in.nextLine(); // to remove read-in bug
        String title = in.nextLine();
        AllProjects.add(new CompanyProject(title));
        System.out.println("[Project added]");
    }
    
    public static void ListEmails(int phaseToShow) {
    	CompanyProject cp = AllProjects.get(currentProjShowing-1);
        ArrayList<CompanyEmail> projectPhaseEmails = null;
        if (phaseToShow==0) {
            projectPhaseEmails = cp.getEmailsForPhase();
        // Changed this to show current phase if current phase is requested - it does exist
        } else if (phaseToShow <= cp.getPhaseByID()+1) {
        	// This catches an exception if an invalid PID is entered
        	// Added by Joshua Richardson 30/04/18
        	try {
        		// Changed this to show current phase if current phase is requested - it does exist
        		projectPhaseEmails = cp.getEmailsForPhase(phaseToShow-1);
        	} catch(Exception e) {
        		System.out.println("Invalid email");
        	}
        } else {
        	System.out.println(phaseToShow);
        	System.out.println(cp.getPhaseByID());
            System.out.println("Error: Unknown Phase");
        }
        if (projectPhaseEmails != null) {
            System.out.println(cp.toString());
            System.out.println("\n   From                Subject");
            System.out.println("--------------------------------");
            for (int x = 0; x < projectPhaseEmails.size(); x++) {
                CompanyEmail ce = projectPhaseEmails.get(projectPhaseEmails.size()-x-1);
                System.out.println((x+1) + ") " + ce.fromAddress() + " - " + ce.subjectLine());
                if (x==10) {
                    System.out.println("...");
                    break;
                }
            }
        }
    }
    
    private static void ListPhases() {
        CompanyProject cp = AllProjects.get(currentProjShowing-1);
        for (int x=0; x < cp.getPhaseByID(); x++ ) {
        	// This catches an exception if an invalid PID is entered
        	// Added by Joshua 30/04/18
        	try {
        		// Change made by Inigo Taylor - 02/05/18
        		// Changed the function cp.getPhaseByName to ProjectPhases[x] to get the previous phase names, rather than the current
        		System.out.println((x+1)+") "+ProjectPhases[x]+" - "+cp.getEmailsForPhase(x).size()+" Emails");
        	} catch(Exception e) {
        		System.out.println("Invalid email");
        	}            
        }
    }
    
    private static void ListContacts() {
        CompanyProject cp = AllProjects.get(currentProjShowing-1);
        ArrayList<String> projectContacts = cp.getProjectContacts();
        for (int x=0; x < projectContacts.size(); x++ ) {
            System.out.println((x+1)+") "+projectContacts.get(x));
        }
    }
    
    private static void AddEmail(Scanner in) {
        System.out.println("Which email address is it from?");
        in.nextLine(); //to remove read-in bug
        String fromAddress = in.nextLine();
        System.out.println("Which email address is it to?");
        String toAddress = in.nextLine();
        System.out.println("What is the Subject?");
        String subjectLine = in.nextLine();
        System.out.println("What is the Message?");
        String emailBody = in.nextLine();
        System.out.println(fromAddress + toAddress + subjectLine + emailBody);
        CompanyProject cp = AllProjects.get(currentProjShowing-1);
        CompanyEmail ce = new CompanyEmail(fromAddress,toAddress,subjectLine,emailBody);
        try {
			cp.addEmail(ce);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Could not add");
		}
        System.out.println("[Email added to " + cp.toString() + "]");
    }
    
    //Set to public for testing by Joshua Richardson - 02/05/18
    
    public static void ChangeProjectPhase() {
    	CompanyProject cp = AllProjects.get(currentProjShowing-1);
        if (cp.nextPhase()) {
            System.out.println("[Phase changed: " + cp.toString());
        } else {
            System.out.println("Project already in last phase.");
        }
    }

}
