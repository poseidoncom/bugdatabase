package org.myapp.services;

import java.util.*;
import org.myapp.model.Tester;
import org.myapp.dao.TesterDAO;
import org.myapp.ApplicationException;

public class TesterService {

  private TesterDAO testerDAO = new TesterDAO();

  /**
   * Function list customers with their id-(primary key) values, so that id can be
   * used to loan a book.
   **/

  public void listTesters() {
    try {
      List<Tester> testers = testerDAO.getTesters();
      System.out.println("---------------------------------\n");
      for (Tester tester : testers) {
        System.out.println("Tester no\t" + tester.getId() + "\nUsername and email\t" + tester.getUserName() + " "
            + tester.getEmail() + "\n");
        System.out.println("---------------------------------\n");
      }
    } catch (Exception e) {
      System.out.println("listing testers failed");
    }
  }

  public void addTester(String userName, String email, String password) throws ApplicationException {
    if (userName == null || email == null || password == null) {
      throw new ApplicationException("All tester fields are required");
    }
    Tester tester = new Tester();
    tester.setUserName(userName);
    tester.setEmail(email);
    tester.setPassword(password);
    // We have to convert text presentation to number. SQLite uses here long
    // value for date, so that date comparison is possible but conversion is needed
    // first.
    testerDAO.addTester(tester);
  }

}
