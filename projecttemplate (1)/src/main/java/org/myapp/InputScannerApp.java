package org.myapp;

import org.myapp.utils.InputScanner;
import org.myapp.services.BugService;
import org.myapp.services.DeveloperService;
import org.myapp.services.ProjectService;
import org.myapp.services.TesterService;



public class InputScannerApp {

  private static BugService bugService = new BugService();
  private static DeveloperService developerService = new DeveloperService();
  private static ProjectService projectService = new ProjectService();
  private static TesterService testerService = new TesterService();

  private static InputScanner scanner = new InputScanner();

  static String info = "Type: (use enter after input)\n\n";

  public void startApp(String[] args) {

    System.out.println("Wellcome to BugTracker V1!\n");


    System.out.println(info + " addtester | adddeveloper | addproject | reportbug | bugs | updatebug | developers | testers | projects | vote");
    try {
      if (args.length == 0) {
        args = scanner.scanArguments(1);
        if (args[0].equals("addtester")) {
          addTester();
        } else if (args[0].equals("adddeveloper")) {
          addDeveloper();
        } else if (args[0].equals("addproject")) {
          addProject();
        } else if (args[0].equals("reportbug")) {
          addBug();
        } else if (args[0].equals("bugs")) {
          bugService.listBugs();
        } else if (args[0].equals("updatebug")) {
          updateBug();
        } else if (args[0].equals("developers")) {
          developerService.listDevelopers();
        } else if (args[0].equals("testers")) {
          testerService.listTesters();
        } else if (args[0].equals("projects")){
          projectService.listProjects();
        } else if (args[0].equals("vote")){
          voteBug();
        }
      
        


      } else {
        System.out.println("Nothing selected.");
      }
      System.out.println("Application ended successfully.");
    } catch (Exception e) {
      System.out.println("Error! " + e.getMessage());
    }
  }
  //metodit tähän

  private static void addTester() throws ApplicationException {
    System.out.println(info + "Username [enter]\nEmail [enter]\nPassword [enter]");
    String[] args = scanner.scanArguments(3);
    if (args.length == 3) {
      testerService.addTester(args[0], args[1], args[2]);
      System.out.println("Tester is saved");
    }
  }
  private static void addDeveloper() throws ApplicationException {
    System.out.println(info + "Username [enter]\nEmail [enter]\nPassword [enter]");
    String[] args = scanner.scanArguments(3);
    if (args.length == 3) {
      developerService.addDeveloper(args[0], args[1], args[2]);
      System.out.println("Developer is saved");
    }
  }

  private static void addProject() throws ApplicationException {
    System.out.println(info + "Project Name [enter]");
    String[] args = scanner.scanArguments(1);
    if (args.length == 1) {
      projectService.addProject(args[0]);
      System.out.println("Project is saved");
    }
  }

  

  private static void addBug() throws ApplicationException {
    System.out.println(info + "Project id [enter]\nReporter id [enter]\nDescription[enter]");
    String[] args = scanner.scanArguments(3);
    if (args.length == 3) {
      try {
        long projectId = Long.parseLong(args[0]);
        long reporterId = Long.parseLong(args[1]);
        bugService.addBug(projectId, reporterId, args[2]);
      } catch (NumberFormatException nfe) {
        System.out.println("Book number and customer number are positive integers");
      }
      
      System.out.println("Developer is saved");
    }
  }

  private static void updateBug() throws ApplicationException {
    System.out.println(info + "Bug id [enter]\nState [enter]\nCriticality [enter]\n Developer id [enter]");
    String[] args = scanner.scanArguments(4);
    if (args.length == 4) {
      try {
        long bugId = Long.parseLong(args[0]);
        long developerId = Long.parseLong(args[3]);
        bugService.updateBug(bugId, args[1], args[2], developerId);
      } catch (NumberFormatException nfe) {
        System.out.println("Project id and  are positive integers");
      }
      
      System.out.println("Developer is saved");
    }
  }

  private static void voteBug() throws ApplicationException {
    System.out.println(info + "Bug id [enter]");
    String[] args = scanner.scanArguments(1);
    if (args.length == 1) {
      try {
        long bugId = Long.parseLong(args[0]);
        bugService.voteBug(bugId);
      } catch (NumberFormatException nfe) {
        System.out.println("Project id and  are positive integers");
      }
      
      System.out.println("Developer is saved");
    }
  }

  

  
}