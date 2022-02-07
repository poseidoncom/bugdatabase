package org.myapp.services;

import java.util.*;
import org.myapp.utils.DateTimeUtils;
import org.myapp.model.Developer;
import org.myapp.dao.DeveloperDAO;
import org.myapp.ApplicationException;

public class DeveloperService {

  private DeveloperDAO developerDAO = new DeveloperDAO();

  /**
   * Function list customers with their id-(primary key) values, so that id can be
   * used to loan a book.
   **/

  public void listDevelopers() {
    try {
      List<Developer> developers = developerDAO.getDevelopers();
      System.out.println("---------------------------------\n");
      for (Developer developer : developers) {
        System.out.println("developer no\t" + developer.getId() + "\nUsername and email\t" + developer.getUserName() + " "
            + developer.getEmail() + "\n");
        System.out.println("---------------------------------\n");
      }
    } catch (Exception e) {
      System.out.println("listing developers failed");
    }
  }

  public void addDeveloper(String userName, String email, String password) throws ApplicationException {
    if (userName == null || email == null || password == null) {
      throw new ApplicationException("All developer fields are required");
    }
    Developer developer = new Developer();
    developer.setUserName(userName);
    developer.setEmail(email);
    developer.setPassword(password);
    // We have to convert text presentation to number. SQLite uses here long
    // value for date, so that date comparison is possible but conversion is needed
    // first.
    developerDAO.addDeveloper(developer);
  }

}