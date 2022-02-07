package org.myapp.services;

import java.util.*;
import org.myapp.ApplicationException;
import org.myapp.model.Bug;
import org.myapp.model.Project;
import org.myapp.model.Tester;
import org.myapp.model.Developer;


import org.myapp.dao.BugDAO;
import org.myapp.dao.ProjectDAO;
import org.myapp.dao.TesterDAO;
import org.myapp.dao.DeveloperDAO;

public class BugService {

  private BugDAO bugDAO = new BugDAO();
  private ProjectDAO projectDAO = new ProjectDAO();
  private TesterDAO testerDAO = new TesterDAO();
  private DeveloperDAO developerDAO = new DeveloperDAO();
  

  public void listBugs() {
    try {
      List<Bug> bugs = bugDAO.getBugs();
      System.out.println("---------------------------------\n");
      for (Bug bug : bugs) {
        System.out.println("Bug id\t" + bug.getId()+"\n");
        System.out.println("Project\t" + bug.getProject().getProjectName() + "\n");
        System.out.println("Description\t"+ bug.getDescription()+"\n");
        System.out.println("Assignee\t" + bug.getDeveloper().getEmail() + "\n");
        System.out.println("Votes\t"+ bug.getVotes()+"\n");
        System.out.println("State\t" + bug.getState() + "\n");
        System.out.println("Criticality\t" + bug.getCriticality() + "\n");
        System.out.println("Reporter\t" + bug.getTester().getUserName() + "\n");
        System.out.println("Report date\t \n");
        System.out.println("---------------------------------\n");
      }
    } catch (Exception e) {
      System.out.println("listing bugs failed");
    }
  }

  public void addBug(Long projectId, Long reporter, String description) throws ApplicationException {
    if (projectId == null || reporter == null) {
      throw new ApplicationException("Book name and author are required");
    }
    Project projectToAssign = projectDAO.getProjectById(projectId);
    if(projectToAssign != null){
      Tester testerWhoReported = testerDAO.getTesterById(reporter);
      if (reporter != null){
        Bug bug = new Bug();
        bug.setDate((new Date()).getTime());
        bug.setProject(projectToAssign);
        bug.setTester(testerWhoReported);
        bug.setDescription(description);
        bug.setDeveloper(null);
        bug.setCriticality(null);
        bug.setState(null);
        
        bugDAO.addBug(bug);
        System.out.println("Bug addedd.");
      }
    }
    
  }

  public void updateBug(Long bug, String state, String criticality, Long developer) throws ApplicationException{
    if (state == null || criticality == null || developer == null){
      throw new ApplicationException("State, ciriticality and developer id are required");
    }
    Developer developerToAssign = developerDAO.getDeveloperById(developer);
    if (developerToAssign != null){
      Bug updatedBug = bugDAO.getBugById(bug);
      updatedBug.setDeveloper(developerToAssign);
      updatedBug.setState(state);
      updatedBug.setCriticality(criticality);
      bugDAO.updateBug(updatedBug);
    }
  }

  public void voteBug(Long bug) throws ApplicationException{
    if (bug == null){
      throw new ApplicationException("State, ciriticality and developer id are required");
    }
      Bug updatedBug = bugDAO.getBugById(bug);
      updatedBug.setVotes(updatedBug.getVotes()+1);
      bugDAO.updateBug(updatedBug);
  }

  

}
